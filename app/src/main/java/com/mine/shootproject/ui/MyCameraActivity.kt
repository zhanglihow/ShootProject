package com.mine.shootproject.ui

import android.animation.ObjectAnimator
import android.animation.PropertyValuesHolder
import android.animation.ValueAnimator
import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Vibrator
import android.view.View
import android.view.WindowManager
import android.view.animation.LinearInterpolator
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.mine.shootproject.BuildConfig
import com.mine.shootproject.R
import com.mine.shootproject.event.*
import com.mine.shootproject.utils.ColorBlobDetector
import com.mine.shootproject.utils.MyUtils
import com.mine.shootproject.weight.MuVideoView
import com.shuyu.gsyvideoplayer.listener.VideoAllCallBack
import com.tievd.baselib.utils.ToastUtils
import com.tievd.baselib.utils.TyLog
import kotlinx.coroutines.*
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode
import org.opencv.android.*
import org.opencv.core.*
import org.opencv.imgproc.Imgproc


class MyCameraActivity : CameraActivity() {
    companion object {
        const val AREA_MAX = 200000
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

    private val shootView: ImageView by lazy {
        findViewById(R.id.shoot_view)
    }

    private val inVideoView: MuVideoView by lazy {
        findViewById(R.id.video_in_view)
    }
    private val backView: ImageView by lazy {
        findViewById(R.id.back_view)
    }


    private var mRgba: Mat? = null
    private var mBlobColorRgba: Scalar? = null
    private var mBlobColorHsv: Scalar? = null
    private var mDetector: ColorBlobDetector? = null
    private var mSpectrum: Mat? = null
    private var SPECTRUM_SIZE: Size? = null
    private var CONTOUR_COLOR: Scalar? = null

    private var setMatJbo: Job? = null

    private var shootMat: Mat? = null

    private val backDialog by lazy {
        AlertDialog.Builder(this, android.R.style.Theme_DeviceDefault_Light_Dialog_Alert)
            .setTitle("提示")
            .setMessage("是否退出游戏？")
            .setNegativeButton("取消") { dialog, which ->
                dialog.dismiss()
            }
            .setPositiveButton("确定") { dialog, which ->
                dialog.dismiss()
                vibrator.cancel()
                EventBus.getDefault().post(VoiceStopEvent(8))
                EventBus.getDefault().post(PostMsgEvent("out"))
                startActivity(Intent(this, LauncherActivity::class.java))
                finish()
            }
            .create()
    }

    private val outDialog by lazy {
        AlertDialog.Builder(this, android.R.style.Theme_DeviceDefault_Light_Dialog_Alert)
            .setTitle("提示")
            .setMessage("对方退出游戏，回到主页面")
            .setNegativeButton("取消") { dialog, which ->
                dialog.dismiss()
            }
            .setPositiveButton("确定") { dialog, which ->
                dialog.dismiss()
                vibrator.cancel()
                startActivity(Intent(this, LauncherActivity::class.java))
                finish()
            }
            .create()
    }


    private val shootDialog by lazy {
        AlertDialog.Builder(this, android.R.style.Theme_DeviceDefault_Light_Dialog_Alert)
            .setTitle("提示")
            .setMessage("恭喜你击中对方，回到主页面")
            .setNegativeButton("取消") { dialog, which ->
                dialog.dismiss()
            }
            .setPositiveButton("确定") { dialog, which ->
                dialog.dismiss()
                vibrator.cancel()
                EventBus.getDefault().post(VoiceStopEvent(8))
                startActivity(Intent(this, LauncherActivity::class.java))
                finish()
            }
            .create()
    }

    private val shootedDialog by lazy {
        AlertDialog.Builder(this, android.R.style.Theme_DeviceDefault_Light_Dialog_Alert)
            .setTitle("提示")
            .setMessage("很遗憾，你被击中了,是否回到主页面")
            .setNegativeButton("取消") { dialog, which ->
                dialog.dismiss()
            }
            .setPositiveButton("确定") { dialog, which ->
                dialog.dismiss()
                vibrator.cancel()
                startActivity(Intent(this, LauncherActivity::class.java))
                finish()
            }
            .create()
    }

    private val vibrator by lazy {
        getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)
        EventBus.getDefault().post(VoiceEvent(8, true))

        setContentView(R.layout.activity_camera)


        if (BuildConfig.FLAVOR == "red") {
            Glide.with(this).load(R.drawable.icon_red_wait).into(shootView)
        } else {
            Glide.with(this).load(R.drawable.icon_green_wait).into(shootView)
        }
        shootView.setOnClickListener {
            startShoot()
            TyLog.i("shootMat  shootMat.value:${shootMat}")
            if (shootMat != null) {
                ToastUtils.showToast("恭喜你，击中对方，赢得游戏")
                shootIn()
            } else {
                ToastUtils.showToast("失去目标，请重新射击")
                noShoot()
            }
        }
        EventBus.getDefault().register(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        setMatJbo?.cancel()
        inVideoView.release()
        javaCameraView.disableView()
    }

    override fun onBackPressed() {
        backDialog.show()
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun beat(event: BeatEvent) {
//        if (event.type == 1) {
//            ToastUtils.showToast("发送心跳成功")
//        } else {
//            ToastUtils.showToast("收到心跳成功")
//        }
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
                MyUtils.myGreen(rgbMat)
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
                val area = rect.size.area()
                rect.points(points)
//                TyLog.i("area：$area")
                if (area > AREA_MAX) {
                    waitShoot()
//                    ToastUtils.showToast("发现目标，准备射击！")
                    if (setMatJbo == null) {
//                        TyLog.i("shootMat ==null")
                        setMatJbo = GlobalScope.launch(Dispatchers.Main) {
                            shootMat = tmp
//                            TyLog.i("shootMat delay(2000)1111111")
                            delay(2000)
                            shootMat = null
                            cancel()
                            setMatJbo = null
//                            TyLog.i("shootMat delay(2000)2222222")
                        }
                    }
                }
            }
            hierarchy.release()
//            TyLog.i("contour size:${contour.size},$contour")
            return rgbMat
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
        //todo test
//        if (BuildConfig.FLAVOR == "red") {
        if (OpenCVLoader.initDebug()) {
            TyLog.i("initDebug true")
            baseLoaderCallback.onManagerConnected(LoaderCallbackInterface.SUCCESS)
        } else {
            TyLog.i("initDebug false")
            OpenCVLoader.initAsync(OpenCVLoader.OPENCV_VERSION, this, baseLoaderCallback)
        }
//        }

    }

    /**
     * 瞄准对方
     */
    private fun waitShoot() {
        vibrator.vibrate(50)
        EventBus.getDefault().post(VoiceEvent(4, false))
    }

    /**
     * 点击射击
     */
    private fun startShoot() {
        vibrator.cancel()
        vibrator.vibrate(50)
        EventBus.getDefault().post(VoiceStopEvent(8))
        EventBus.getDefault().post(VoiceEvent(5, false))
    }

    /**
     * 未击中
     */
    private fun noShoot() {
        vibrator.vibrate(100)
        EventBus.getDefault().post(VoiceEvent(7, false))
//        javaCameraView.disableView()
    }

    /**
     * 击中
     */
    private fun shootIn() {
        EventBus.getDefault().post(PostMsgEvent("shoot"))
        javaCameraView.disableView()
        vibrator.vibrate(500)
        EventBus.getDefault().post(VoiceEvent(6, false))
        initVideoView("shoot")
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun clintConnect(event: GetMsgEvent) {
        if (event.msg.contains("shoot")) {
            EventBus.getDefault().unregister(this)
            javaCameraView.disableView()
            vibrator.vibrate(500)
            EventBus.getDefault().post(VoiceStopEvent(8))
            EventBus.getDefault().post(VoiceEvent(6, false))
            if (!inVideoView.isInPlayingState) {
                initVideoView("out")
            }
        } else if (event.msg.contains("out")) {
            EventBus.getDefault().unregister(this)
            javaCameraView.disableView()
            vibrator.vibrate(500)
            EventBus.getDefault().post(VoiceStopEvent(8))
            outDialog.show()
        }
    }

    private fun initVideoView(type: String) {
        GlobalScope.launch(Dispatchers.Main) {
            inVideoView.visibility = View.VISIBLE
            backView.visibility = View.VISIBLE

            val holder1: PropertyValuesHolder = PropertyValuesHolder.ofFloat("scaleX", 2f, 0.5f)
            val holder2: PropertyValuesHolder = PropertyValuesHolder.ofFloat("scaleY", 2f, 0.5f)
            val holder3: PropertyValuesHolder = PropertyValuesHolder.ofFloat("alpha", 1f, 0.5f)

            val objectAnimator: ObjectAnimator =
                ObjectAnimator.ofPropertyValuesHolder(backView, holder1, holder2, holder3)
            objectAnimator.duration = 3000
            objectAnimator.repeatCount = -1
            objectAnimator.interpolator = LinearInterpolator()
            objectAnimator.start()

            val url = if (type == "out") {
                "android.resource://" + packageName + "/" + R.raw.shoot_ok_video
            } else {
                "android.resource://" + packageName + "/" + R.raw.shoot_not_video
            }
            inVideoView.seekOnStart = 0
            inVideoView.isShowFullAnimation = true
            inVideoView.setUp(url, false, "")
            inVideoView.setVideoAllCallBack(object : VideoAllCallBack {
                override fun onStartPrepared(url: String?, vararg objects: Any?) {
                }

                override fun onPrepared(url: String?, vararg objects: Any?) {
                }

                override fun onClickStartIcon(url: String?, vararg objects: Any?) {
                }

                override fun onClickStartError(url: String?, vararg objects: Any?) {
                }

                override fun onClickStop(url: String?, vararg objects: Any?) {
                }

                override fun onClickStopFullscreen(url: String?, vararg objects: Any?) {
                }

                override fun onClickResume(url: String?, vararg objects: Any?) {
                }

                override fun onClickResumeFullscreen(url: String?, vararg objects: Any?) {
                }

                override fun onClickSeekbar(url: String?, vararg objects: Any?) {
                }

                override fun onClickSeekbarFullscreen(url: String?, vararg objects: Any?) {
                }

                override fun onAutoComplete(url: String?, vararg objects: Any?) {
                    inVideoView.visibility = View.GONE
                    if (type == "out") {
                        shootedDialog.show()
                    } else {
                        shootDialog.show()
                    }
                }

                override fun onComplete(url: String?, vararg objects: Any?) {
                    inVideoView.visibility = View.GONE
                    if (type == "out") {
                        shootedDialog.show()
                    } else {
                        shootDialog.show()
                    }
                }

                override fun onEnterFullscreen(url: String?, vararg objects: Any?) {
                }

                override fun onQuitFullscreen(url: String?, vararg objects: Any?) {
                }

                override fun onQuitSmallWidget(url: String?, vararg objects: Any?) {
                }

                override fun onEnterSmallWidget(url: String?, vararg objects: Any?) {
                }

                override fun onTouchScreenSeekVolume(url: String?, vararg objects: Any?) {
                }

                override fun onTouchScreenSeekPosition(url: String?, vararg objects: Any?) {
                }

                override fun onTouchScreenSeekLight(url: String?, vararg objects: Any?) {
                }

                override fun onPlayError(url: String?, vararg objects: Any?) {
                }

                override fun onClickStartThumb(url: String?, vararg objects: Any?) {
                }

                override fun onClickBlank(url: String?, vararg objects: Any?) {
                }

                override fun onClickBlankFullscreen(url: String?, vararg objects: Any?) {
                }
            })
            delay(3000)
            backView.visibility = View.GONE
            inVideoView.startPlayLogic()
        }
    }

}