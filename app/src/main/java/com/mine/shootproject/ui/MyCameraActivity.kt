package com.mine.shootproject.ui

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Vibrator
import android.widget.TextView
import com.mine.shootproject.BuildConfig
import com.mine.shootproject.R
import com.mine.shootproject.event.BeatEvent
import com.mine.shootproject.event.ServerStateEvent
import com.mine.shootproject.event.VoiceEvent
import com.mine.shootproject.event.VoiceStopEvent
import com.mine.shootproject.service.GreenService
import com.mine.shootproject.service.RedService
import com.mine.shootproject.utils.ColorBlobDetector
import com.mine.shootproject.utils.MyUtils
import com.tievd.baselib.utils.ToastUtils
import com.tievd.baselib.utils.TyLog
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode
import org.opencv.android.*
import org.opencv.core.*
import org.opencv.imgproc.Imgproc


class MyCameraActivity : CameraActivity() {
    companion object {
        fun start(context: Context) {
            val intent = Intent(context, MyCameraActivity::class.java)
            context.startActivity(intent)
        }
    }

    private val tvState: TextView by lazy {
        findViewById(R.id.tv_state)
    }
    private val javaCameraView: JavaCamera2View by lazy {
        findViewById(R.id.javaCameraView)
    }

    private var mRgba: Mat? = null
    private var mBlobColorRgba: Scalar? = null
    private var mBlobColorHsv: Scalar? = null
    private var mDetector: ColorBlobDetector? = null
    private var mSpectrum: Mat? = null
    private var SPECTRUM_SIZE: Size? = null
    private var CONTOUR_COLOR: Scalar? = null

    private val backDialog by lazy {
        AlertDialog.Builder(this, android.R.style.Theme_DeviceDefault_Light_Dialog_Alert)
            .setTitle("提示")
            .setMessage("是否退出游戏？")
            .setNegativeButton("取消"){dialog, which ->
                dialog.dismiss()
            }
            .setPositiveButton("确定"){dialog, which ->
                dialog.dismiss()
                vibrator.cancel()
                EventBus.getDefault().post(VoiceStopEvent(7))
                startActivity(Intent(this,LauncherActivity::class.java))
                finish()
            }
            .create()
    }

    private val shootDialog by lazy {
        AlertDialog.Builder(this, android.R.style.Theme_DeviceDefault_Light_Dialog_Alert)
            .setTitle("提示")
            .setMessage("恭喜你击中对方，回到主页面")
            .setNegativeButton("取消"){dialog, which ->
                dialog.dismiss()
            }
            .setPositiveButton("确定"){dialog, which ->
                dialog.dismiss()
                vibrator.cancel()
                EventBus.getDefault().post(VoiceStopEvent(7))
                startActivity(Intent(this,LauncherActivity::class.java))
                finish()
            }
            .create()
    }

    private val shootNotDialog by lazy {
        AlertDialog.Builder(this, android.R.style.Theme_DeviceDefault_Light_Dialog_Alert)
            .setTitle("提示")
            .setMessage("很遗憾，没有击中，请继续游戏")
            .setNegativeButton("取消"){dialog, which ->
                dialog.dismiss()
            }
            .setPositiveButton("确定"){dialog, which ->
                dialog.dismiss()
            }
            .create()
    }

    private val vibrator by lazy {
        getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
    }
    private val patter = longArrayOf(200, 200, 200)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        EventBus.getDefault().post(VoiceEvent(7, true))

        setContentView(R.layout.activity_camera)
    }

    override fun onDestroy() {
        super.onDestroy()
        javaCameraView.disableView()
    }

    override fun onBackPressed() {
//        super.onBackPressed()
        backDialog.show()
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
     fun beat(event: BeatEvent) {
        if (event.type == 1) {
            ToastUtils.showToast("发送心跳成功")
        } else {
            ToastUtils.showToast("收到心跳成功")
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
     fun state(event: ServerStateEvent) {
        tvState.text = event.msg
    }


    private val cvCameraViewListener2 = object : CameraBridgeViewBase.CvCameraViewListener2 {
        override fun onCameraViewStarted(width: Int, height: Int) {
            TyLog.i("onCameraViewStarted width=$width, height=$height")

            mRgba = Mat(height, width, CvType.CV_8UC4)
            mDetector = ColorBlobDetector()
            mSpectrum = Mat()
            mBlobColorRgba = Scalar(255.0)
            mBlobColorHsv = Scalar(255.0)
            SPECTRUM_SIZE = Size(200.0, 64.0)
            CONTOUR_COLOR = Scalar(255.0, 0.0, 0.0, 255.0)
        }

        override fun onCameraViewStopped() {
            TyLog.i("onCameraViewStopped")
            mRgba?.release()
        }

        override fun onCameraFrame(inputFrame: CameraBridgeViewBase.CvCameraViewFrame?): Mat? {
            val rgbMat = inputFrame?.rgba()
            val mat = if (BuildConfig.FLAVOR == "red") {
                MyUtils.myRed(rgbMat)
            } else {
                MyUtils.myRed(rgbMat)
            }

            val mask1: Mat = mat.clone()
            val contour: List<MatOfPoint> = java.util.ArrayList()
            val hierarchy = Mat()
            Imgproc.findContours(
                mask1,
                contour,
                hierarchy,
                Imgproc.RETR_EXTERNAL,
                Imgproc.CHAIN_APPROX_SIMPLE
            )

            val tmp = mat.clone()
            for (element in contour) {
//            title = "最小外接矩形"
                val source = MatOfPoint2f()
                source.fromList(element.toList())
                val rect = Imgproc.minAreaRect(source)
                val points = arrayOfNulls<Point>(4)
                val center = rect.center
                rect.points(points)
                TyLog.i("RotateRect: ${points.toList()}, Center：$center")
                for (j in 0..3) {
                    Imgproc.line(
                        tmp,
                        points[j % 4],
                        points[(j + 1) % 4],
                        Scalar(255.0, 255.0, 0.0),
                        4,
                        Imgproc.LINE_8
                    )
                }
            }
            hierarchy.release()
            TyLog.i("contour size:${contour.size},$contour")
            return tmp
        }
    }

    private val baseLoaderCallback = object : BaseLoaderCallback(this) {
        override fun onManagerConnected(status: Int) {
            TyLog.i("onManagerConnected status=$status, javaCameraView=$javaCameraView");
            when (status) {
                LoaderCallbackInterface.SUCCESS -> {
                    javaCameraView.setCvCameraViewListener(cvCameraViewListener2)
                    // 禁用帧率显示
                    javaCameraView.disableFpsMeter()
                    javaCameraView.enableView()
                }
                else -> {
                    super.onManagerConnected(status)
                }
            }
        }
    }

    override fun getCameraViewList(): MutableList<CameraBridgeViewBase> {
        TyLog.i("getCameraViewList")
        val list: MutableList<CameraBridgeViewBase> = ArrayList()
        list.add(javaCameraView)
        return list
    }


    override fun onPause() {
        super.onPause()
        javaCameraView.disableView()
    }

    override fun onResume() {
        super.onResume()
        if (OpenCVLoader.initDebug()) {
            TyLog.i("initDebug true")
            baseLoaderCallback.onManagerConnected(LoaderCallbackInterface.SUCCESS)
        } else {
            TyLog.i("initDebug false")
            OpenCVLoader.initAsync(OpenCVLoader.OPENCV_VERSION, this, baseLoaderCallback)
        }
    }

    /**
     * 瞄准对方
     */
    private fun waitShoot() {
        vibrator.vibrate(patter, 0)
        EventBus.getDefault().post(VoiceEvent(4, true))

    }

    /**
     * 点击射击
     */
    private fun startShoot() {
        vibrator.cancel()
        vibrator.vibrate(50)
//        EventBus.getDefault().post(VoiceStopEvent())
        EventBus.getDefault().post(VoiceEvent(5, false))

    }

    /**
     * 未击中
     */
    private fun noShoot() {
        vibrator.vibrate(100)
        EventBus.getDefault().post(VoiceEvent(6, false))
        EventBus.getDefault().post(VoiceEvent(7, true))

        shootNotDialog.show()
    }

    /**
     * 击中
     */
    private fun shootIn() {
        javaCameraView.disableView()
        vibrator.vibrate(300)
        EventBus.getDefault().post(VoiceEvent(5, false))
        shootDialog.show()
    }

}