package com.mine.shootproject.app

import android.util.Log
import androidx.appcompat.app.AppCompatDelegate
import com.tievd.baselib.base.BaseApplication
import com.tievd.baselib.utils.MMKVUtil
import org.opencv.android.OpenCVLoader


class MyApplication:BaseApplication() {

    override fun onCreate() {
        super.onCreate()

        val mode=MMKVUtil.getBoolean("mode")

        if (mode == true) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        }else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        }
        if (!OpenCVLoader.initDebug())
            Log.e("OpenCV", "Unable to load OpenCV!")
        else
            Log.i("OpenCV", "OpenCV loaded Successfully!")
    }
}