package com.mine.shootproject.utils;

/**
 * @author zhangli
 * @email zhanglihow@gmail.com
 * @time
 */

import java.util.List;

import org.opencv.android.BaseLoaderCallback;
import org.opencv.android.CameraActivity;
import org.opencv.android.CameraBridgeViewBase.CvCameraViewFrame;
import org.opencv.android.LoaderCallbackInterface;
import org.opencv.android.OpenCVLoader;
import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.MatOfPoint;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.core.Size;
import org.opencv.android.CameraBridgeViewBase;
import org.opencv.android.CameraBridgeViewBase.CvCameraViewListener2;
import org.opencv.imgproc.Imgproc;
import org.opencv.imgproc.Moments;

import android.app.Activity;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnTouchListener;
import android.view.SurfaceView;

import static org.opencv.imgproc.Imgproc.CONTOURS_MATCH_I1;
import static org.opencv.imgproc.Imgproc.boundingRect;

import androidx.appcompat.app.AppCompatActivity;

import com.mine.shootproject.R;
import com.mine.shootproject.ui.MainActivity;
import com.tievd.baselib.utils.TyLog;

public class MyMainActivity extends CameraActivity implements OnTouchListener, CvCameraViewListener2 {
    private static final String TAG = "colordetect";

    private boolean mIsColorSelected = false;
    private Mat mRgba;//两个mat对象
    private Scalar mBlobColorRgba;
    private Scalar mBlobColorHsv;
    private ColorBlobDetector2 mDetector;
    private Mat mSpectrum;
    private Size SPECTRUM_SIZE;
    private Scalar CONTOUR_COLOR;

    private CameraBridgeViewBase mOpenCvCameraView;//opencv中的抽象类，类似于Android中的SurfaceView该类实现了两个接口：
    // CvCameraViewListener     CvCameraViewListener2这两个接口提供了回调处理，，开始和停止摄像机，，处理每一帧的拍摄
    //要实现CameraBridgeViewBase有两个view,JavaCameraView  NativeCameraView：是C++类，相较而言可以得到较高的帧速率

    //为了画矩形框
    private Mat mMat;
    private int x;
    private int y;
    private int w;
    private int h;
    private Point mpoint;
    private BaseLoaderCallback baseLoaderCallback = new BaseLoaderCallback(this) {
        @Override
        public void onManagerConnected(int status) {
            switch (status) {
                case LoaderCallbackInterface.SUCCESS: {
                    Log.i(TAG, "OpenCV loaded successfully");
                    mOpenCvCameraView.enableView();
                    mOpenCvCameraView.setOnTouchListener(MyMainActivity.this);
                    mOpenCvCameraView.setCvCameraViewListener(MyMainActivity.this);
//                    // 禁用帧率显示
//                    mOpenCvCameraView.disableFpsMeter();
//                    mOpenCvCameraView.enableView();
                }
                break;
                default: {
                    super.onManagerConnected(status);
                }
                break;
            }
        }
    };

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        Log.i(TAG, "called onCreate");
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        setContentView(R.layout.color_blob_detection_surface_view);

        mOpenCvCameraView = (CameraBridgeViewBase) findViewById(R.id.color_blob_detection_activity_surface_view);
        mOpenCvCameraView.setVisibility(SurfaceView.VISIBLE);
        mOpenCvCameraView.setCvCameraViewListener(this);
    }

    @Override
    public void onPause() {
        super.onPause();
        if (mOpenCvCameraView != null)
            mOpenCvCameraView.disableView();
    }

    @Override
    public void onResume() {
        super.onResume();
//        if (OpenCVLoader.initDebug()) {
//            baseLoaderCallback.onManagerConnected(LoaderCallbackInterface.SUCCESS);
//        } else {
//            OpenCVLoader.initAsync(OpenCVLoader.OPENCV_VERSION, this, baseLoaderCallback);
//        }
        if (!OpenCVLoader.initDebug()) {
            Log.d(TAG, "Internal OpenCV library not found. Using OpenCV Manager for initialization");
            OpenCVLoader.initAsync(OpenCVLoader.OPENCV_VERSION_3_0_0, this, baseLoaderCallback);
        } else {
            Log.d(TAG, "OpenCV library found inside package. Using it!");
            baseLoaderCallback.onManagerConnected(LoaderCallbackInterface.SUCCESS);
        }
    }



    public void onDestroy() {
        super.onDestroy();
        if (mOpenCvCameraView != null)
            mOpenCvCameraView.disableView();
    }

    public void onCameraViewStarted(int width, int height) {
        mRgba = new Mat(height, width, CvType.CV_8UC4);
        mDetector = new ColorBlobDetector2();
        mSpectrum = new Mat();
        mBlobColorRgba = new Scalar(255);
        mBlobColorHsv = new Scalar(255);//从rgbt通道转化为hsv
        SPECTRUM_SIZE = new Size(200, 64);
        CONTOUR_COLOR = new Scalar(255, 0, 0, 255);//红色 一开始的默认轮廓颜色
    }

    public void onCameraViewStopped() {
        mRgba.release();
    }

    public boolean onTouch(View v, MotionEvent event) {
        int cols = mRgba.cols();//宽
        int rows = mRgba.rows();//高

        int xOffset = (mOpenCvCameraView.getWidth() - cols) / 2;
        int yOffset = (mOpenCvCameraView.getHeight() - rows) / 2;

        int x = (int) event.getX() - xOffset;
        int y = (int) event.getY() - yOffset;//这段计算是什么意思，mRgba，mOpenCvCameraView这两个对象有什么不同？

        Log.i(TAG, "Touch image coordinates: (" + x + ", " + y + ")");

        if ((x < 0) || (y < 0) || (x > cols) || (y > rows)) return false;

        Rect touchedRect = new Rect();//触摸到的矩形框

        touchedRect.x = (x > 4) ? x - 4 : 0;
        touchedRect.y = (y > 4) ? y - 4 : 0;

        touchedRect.width = (x + 4 < cols) ? x + 4 - touchedRect.x : cols - touchedRect.x;
        touchedRect.height = (y + 4 < rows) ? y + 4 - touchedRect.y : rows - touchedRect.y;

        Mat touchedRegionRgba = mRgba.submat(touchedRect);//分割提取触摸的矩形块图形对象，然后进行hsv通道转换，下步会进行提取

        Mat touchedRegionHsv = new Mat();
        Imgproc.cvtColor(touchedRegionRgba, touchedRegionHsv, Imgproc.COLOR_RGB2HSV_FULL);//转换函数？

        // Calculate average color of touched region，计算所选矩形块中所有像素点的平均hsv
        mBlobColorHsv = Core.sumElems(touchedRegionHsv);//核心块总hsv，以列表格式存储
        int pointCount = touchedRect.width * touchedRect.height;//总像素数
        for (int i = 0; i < mBlobColorHsv.val.length; i++)//每个通道都坐下平均
            mBlobColorHsv.val[i] /= pointCount;

        mBlobColorRgba = converScalarHsv2Rgba(mBlobColorHsv);

        Log.i(TAG, "Touched rgba color: (" + mBlobColorRgba.val[0] + ", " + mBlobColorRgba.val[1] +
                ", " + mBlobColorRgba.val[2] + ", " + mBlobColorRgba.val[3] + ")");

        mDetector.setHsvColor(mBlobColorHsv);

        Imgproc.resize(mDetector.getSpectrum(), mSpectrum, SPECTRUM_SIZE, 0, 0, Imgproc.INTER_LINEAR_EXACT);

        mIsColorSelected = true;

        touchedRegionRgba.release();
        touchedRegionHsv.release();

        return false; // don't need subsequent touch events
    }

    public Mat onCameraFrame(CvCameraViewFrame inputFrame) {
        mRgba = inputFrame.rgba();

        if (mIsColorSelected) {
            mDetector.process(mRgba);
            List<MatOfPoint> contours = mDetector.getContours();
            Log.e(TAG, "Contours count: " + contours.size());
            //画出矩形 contours的相关属性https://blog.csdn.net/zziahgf/article/details/76013881
            //每个单独的contour是包括物体边界点的(x,y)坐标的Numpy 数组.
            // Rect r= Imgproc.boundingRect(contours.get(0));//正确形势
            //Imgproc.rectangle(mRgba,r,new Scalar(0,0,255), 2);
            //到了opencv3.x，图形绘制模块就移植在Imgproc里了
            if (contours.size() > 0) {//contours.size()是轮廓总数量的意思
                //找最大轮廓坐标
                double maxVal = 0;
                int maxValIdx = 0;
                for (int contourIdx = 0; contourIdx < contours.size(); contourIdx++) {
                    double contourArea = Imgproc.contourArea(contours.get(contourIdx));
                    if (maxVal < contourArea) {
                        maxVal = contourArea;
                        maxValIdx = contourIdx;
                    }
                }

                Moments m = Imgproc.moments(contours.get(maxValIdx));//在这里在识别出来的轮廓中心画圆
                int cx = (int) (m.m10 / m.m00);
                int cy = (int) (m.m01 / m.m00);//轮廓的中心
                mpoint = new Point(cx, cy);
                //Imgproc.circle(mRgba, mpoint, 5, new Scalar(0, 0, 255), -1, Imgproc.LINE_AA);
                Imgproc.rectangle(mRgba, new Point(cx - 5, cy - 5), new Point(cx + 5, cy + 5), new Scalar(0, 0, 255));
                ;

                //Imgproc.drawContours(mRgba, contours, -1,new Scalar(0,0,255));//画出轮廓，正确，RGB
            }
            Mat colorLabel = mRgba.submat(4, 68, 4, 68);
            colorLabel.setTo(mBlobColorRgba);

            Mat spectrumLabel = mRgba.submat(4, 4 + mSpectrum.rows(), 70, 70 + mSpectrum.cols());
            mSpectrum.copyTo(spectrumLabel);
        }

        return mRgba;
    }

    private Scalar converScalarHsv2Rgba(Scalar hsvColor) {//scalar是将图像设置成单一灰度和颜色
        Mat pointMatRgba = new Mat();
        Mat pointMatHsv = new Mat(1, 1, CvType.CV_8UC3, hsvColor);
        Imgproc.cvtColor(pointMatHsv, pointMatRgba, Imgproc.COLOR_HSV2RGB_FULL, 4);
        //如何在这里只返回单一的颜色或范围，是不是就可以做颜色识别了，但验证
        //return new Scalar(0, 0, 255);//没有效果，依然是点一个颜色实现一个效果把下面一行注释掉依然能实现原有功能
        return new Scalar(pointMatRgba.get(0, 0));
    }
}
