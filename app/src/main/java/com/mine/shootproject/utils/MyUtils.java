package com.mine.shootproject.utils;

import static org.opencv.core.Core.inRange;
import static org.opencv.core.Core.merge;
import static org.opencv.core.Core.split;
import static org.opencv.imgcodecs.Imgcodecs.imread;
import static org.opencv.imgproc.Imgproc.COLOR_BGR2HSV;
import static org.opencv.imgproc.Imgproc.COLOR_RGB2HSV;
import static org.opencv.imgproc.Imgproc.MORPH_OPEN;
import static org.opencv.imgproc.Imgproc.MORPH_RECT;
import static org.opencv.imgproc.Imgproc.cvtColor;
import static org.opencv.imgproc.Imgproc.equalizeHist;
import static org.opencv.imgproc.Imgproc.getStructuringElement;
import static org.opencv.imgproc.Imgproc.morphologyEx;

import android.graphics.Bitmap;
import android.util.Log;

import com.tievd.baselib.utils.TyLog;

import org.opencv.android.Utils;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfPoint;
import org.opencv.core.MatOfPoint2f;
import org.opencv.core.Point;
import org.opencv.core.Scalar;
import org.opencv.core.Size;
import org.opencv.imgproc.Imgproc;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangli
 * @email zhanglihow@gmail.com
 * @time
 */
public class MyUtils {
    private static List<MatOfPoint> contours = new ArrayList<>();

    public static void greenBtn(Mat srcMat) {
        contours.clear();
        int tri = 0;
        int rect = 0;
        int circle = 0;
        int star = 0;
        int pentagon = 0;
        Mat hierarchy = new Mat();
        Mat binaryMat = new Mat();
        Mat resultMat = srcMat.clone();
        Mat hsvMat = new Mat();
        cvtColor(srcMat, hsvMat, COLOR_BGR2HSV);
        inRange(hsvMat, new Scalar(35, 43, 46), new Scalar(77, 255, 255), binaryMat);
        Bitmap resultBitmap = Bitmap.createBitmap(hsvMat.width(), hsvMat.height(), Bitmap.Config.ARGB_8888);
        Imgproc.findContours(binaryMat, contours, hierarchy, Imgproc.RETR_EXTERNAL, Imgproc.CHAIN_APPROX_SIMPLE);
        Imgproc.drawContours(resultMat, contours, -1, new Scalar(0, 0, 0), 10);
        double epsilon;

        if (contours.size() > 0) {
            MatOfPoint2f contours2f = new MatOfPoint2f(contours.get(0).toArray());
            epsilon = 0.04 * Imgproc.arcLength(contours2f, true);
            MatOfPoint2f approxCurve = new MatOfPoint2f();
            Imgproc.approxPolyDP(contours2f, approxCurve, epsilon, true);
            if (approxCurve.rows() == 3) {
                tri++;
            }
            if (approxCurve.rows() == 4) {
                rect++;
            }
            if (approxCurve.rows() == 5) {
                pentagon++;
            }
            if (approxCurve.rows() == 10) {
                star++;
            }
            if (approxCurve.rows() > 5 && approxCurve.rows() != 10) {
                circle++;
            }

            cvtColor(resultMat, resultMat, Imgproc.COLOR_RGB2BGR);
            Utils.matToBitmap(resultMat, resultBitmap);
//        iv_dst.setImageBitmap(resultBitmap);
            TyLog.INSTANCE.i("三角形:" + tri + "\t" + "矩形:" + rect + "\t" + "五边形:" + pentagon + "\t" + "星形:" + star + "\t" + "圆形:" + circle + "\t");
        }
        hierarchy.release();
        binaryMat.release();
        resultMat.release();
        hsvMat.release();

    }

//    color_dist = {'red': {'Lower': np.array([0, 60, 60]), 'Upper': np.array([6, 255, 255])},
//        'blue': {'Lower': np.array([100, 80, 46]), 'Upper': np.array([124, 255, 255])},
//        'green': {'Lower': np.array([35, 43, 35]), 'Upper': np.array([90, 255, 255])},
//    }

    public static void redBtn(Mat srcMat) {
        contours.clear();
        int tri = 0;
        int rect = 0;
        int circle = 0;
        int star = 0;
        int pentagon = 0;
        Mat hierarchy = new Mat();
        Mat binaryMat = new Mat();
        Mat resultMat = srcMat.clone();
        Mat hsvMat = new Mat();
        cvtColor(srcMat, hsvMat, COLOR_BGR2HSV);
        inRange(hsvMat, new Scalar(156, 43, 46), new Scalar(180, 255, 255), binaryMat);
//        Bitmap resultBitmap = Bitmap.createBitmap(hsvMat.width(), hsvMat.height(), Bitmap.Config.ARGB_8888);
        Imgproc.findContours(binaryMat, contours, hierarchy, Imgproc.RETR_EXTERNAL, Imgproc.CHAIN_APPROX_SIMPLE);
        Imgproc.drawContours(resultMat, contours, -1, new Scalar(0, 0, 0), 10);
        double epsilon;
        if (contours.size() > 0) {
            MatOfPoint2f contours2f = new MatOfPoint2f(contours.get(0).toArray());
            epsilon = Imgproc.arcLength(contours2f, true);
            MatOfPoint2f approxCurve = new MatOfPoint2f();
            Imgproc.approxPolyDP(contours2f, approxCurve, epsilon, true);
            if (approxCurve.rows() == 3) {
                tri++;
            }
            if (approxCurve.rows() == 4) {
                rect++;
            }
            if (approxCurve.rows() == 5) {
                pentagon++;
            }
            if (approxCurve.rows() == 10) {
                star++;
            }
            if (approxCurve.rows() > 5 && approxCurve.rows() != 10) {
                circle++;
            }
            cvtColor(resultMat, resultMat, Imgproc.COLOR_RGB2BGR);
            TyLog.INSTANCE.i("三角形:" + tri + "\t" + "矩形:" + rect + "\t" + "五边形:" + pentagon + "\t" + "星形:" + star + "\t" + "圆形:" + circle + "\t");
//            Core.inRange(hsvMat, new Scalar(100, 43, 46), new Scalar(124, 255, 255), hsvMat);
        }
        hierarchy.release();
        binaryMat.release();
        resultMat.release();
        hsvMat.release();
    }

    public static Mat myRed(Mat mat) {
        int iLowH = 0;
        int iHighH = 10;

        int iLowS = 200;
        int iHighS = 255;

        int iLowV = 200;
        int iHighV = 255;


        Mat imgHSV = new Mat();
        List<Mat> hsvSplit = new ArrayList<>();
        cvtColor(mat, imgHSV, COLOR_RGB2HSV); //Convert the captured frame from BGR to HSV

        //因为我们读取的是彩色图，直方图均衡化需要在HSV空间做
        split(imgHSV, hsvSplit);
        equalizeHist(hsvSplit.get(2), hsvSplit.get(2));
        merge(hsvSplit, imgHSV);
        Mat imgThresholded = new Mat();

//        inRange(imgHSV, new Scalar(iLowH, iLowS, iLowV), new Scalar(iHighH, iHighS, iHighV), imgThresholded); //Threshold the image


//        Mat m = new Mat();
//        Utils.bitmapToMat(bitmap_src, m);

//        Mat hsv=new Mat();
        //android上的是RGBA，所以先转成BGR
//        Imgproc.cvtColor(mat,hsv,Imgproc.COLOR_RGBA2BGR);
//        cvtColor(mat,hsv, COLOR_BGR2HSV);

//        Mat r=new Mat();

        inRange(imgHSV, new Scalar(iLowH, iLowS, iLowV), new Scalar(iHighH, iHighS, iHighV), imgThresholded); //Threshold the image

        //开操作 (去除一些噪点)
        Mat element = getStructuringElement(MORPH_RECT, new Size(5, 5));
//
////        inRange(hsv, new Scalar(iLowH, iLowS, iLowV), new Scalar(iHighH, iHighS, iHighV),r);
////        Mat element = getStructuringElement(MORPH_RECT, new Size(5, 5));
        morphologyEx(imgThresholded, imgThresholded, MORPH_OPEN, element);
//        element.release();
        mat.release();
        imgHSV.release();

        return imgThresholded;
    }


    public static Mat myGreen(Mat mat) {
        int iLowH = 35;
        int iHighH = 77;

        int iLowS = 150;
        int iHighS = 255;

        int iLowV = 150;
        int iHighV = 255;


        Mat imgHSV = new Mat();
        List<Mat> hsvSplit = new ArrayList<>();
        cvtColor(mat, imgHSV, COLOR_RGB2HSV); //Convert the captured frame from BGR to HSV

        //因为我们读取的是彩色图，直方图均衡化需要在HSV空间做
        split(imgHSV, hsvSplit);
        equalizeHist(hsvSplit.get(2), hsvSplit.get(2));
        merge(hsvSplit, imgHSV);
        Mat imgThresholded = new Mat();

//        inRange(imgHSV, new Scalar(iLowH, iLowS, iLowV), new Scalar(iHighH, iHighS, iHighV), imgThresholded); //Threshold the image


//        Mat m = new Mat();
//        Utils.bitmapToMat(bitmap_src, m);

//        Mat hsv=new Mat();
        //android上的是RGBA，所以先转成BGR
//        Imgproc.cvtColor(mat,hsv,Imgproc.COLOR_RGBA2BGR);
//        cvtColor(mat,hsv, COLOR_BGR2HSV);

//        Mat r=new Mat();

        inRange(imgHSV, new Scalar(iLowH, iLowS, iLowV), new Scalar(iHighH, iHighS, iHighV), imgThresholded); //Threshold the image

        //开操作 (去除一些噪点)
        Mat element = getStructuringElement(MORPH_RECT, new Size(5, 5));
//
////        inRange(hsv, new Scalar(iLowH, iLowS, iLowV), new Scalar(iHighH, iHighS, iHighV),r);
////        Mat element = getStructuringElement(MORPH_RECT, new Size(5, 5));
        morphologyEx(imgThresholded, imgThresholded, MORPH_OPEN, element);
//        element.release();
        mat.release();
        imgHSV.release();

        return imgThresholded;
    }


    public static Mat myBlue(Mat mat) {
        Mat imgHSV = new Mat();
        cvtColor(mat, imgHSV, COLOR_BGR2HSV);
        Mat des = new Mat();
        Imgproc.blur(imgHSV, des, new Size(5, 5));
        Mat mat1 = new Mat();
        Imgproc.medianBlur(des, mat1, 5);
        Mat mat2 = new Mat();
        Imgproc.GaussianBlur(mat1, mat2, new Size(5, 5), 0);
        Mat mat3 = new Mat();
        Imgproc.bilateralFilter(mat2, mat3, 9, 75, 75);


        Scalar low_blue = new Scalar(55, 0, 0);
        Scalar high_blue = new Scalar(118, 255, 255);
        Mat mat4 = new Mat();
        inRange(mat3, low_blue, high_blue, mat4);
        Core.bitwise_and(mat, mat, mat4);
        return mat4;
    }


//    fun findRect(mSource:Mat): Mat {
//        val tmp = mSource.clone()
//        val contours = mutableListOf<MatOfPoint>()
//        val hierarchy = Mat()
//        val mBinary=Mat()
//        Imgproc.findContours(
//                mBinary,
//                contours,
//                hierarchy,
//                Imgproc.RETR_TREE,
//                Imgproc.CHAIN_APPROX_SIMPLE
//        )
//
//        for (i in 0 until contours.size) {
////            title = "最小外接矩形"
//            val source = MatOfPoint2f()
//            source.fromList(contours[i].toList())
//            val rect = Imgproc.minAreaRect(source)
//            val points = arrayOfNulls<Point>(4)
//            val center = rect.center
//            rect.points(points)
//            TyLog.i("RotateRect: ${points.toList()}, Center：$center")
//            for (j in 0..3) {
//                Imgproc.line(
//                        tmp,
//                        points[j % 4],
//                        points[(j + 1) % 4],
//                        Scalar(255.0, 255.0, 0.0),
//                        4,
//                        Imgproc.LINE_8
//                )
//            }
//        }
//        hierarchy.release()
//        return tmp
//    }
}
