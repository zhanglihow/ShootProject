package com.mine.shootproject.app

import android.util.Log
import androidx.appcompat.app.AppCompatDelegate
import com.shuyu.gsyvideoplayer.player.PlayerFactory
import com.tencent.bugly.crashreport.CrashReport
import com.tievd.baselib.base.BaseApplication
import com.tievd.baselib.utils.MMKVUtil
import org.opencv.android.OpenCVLoader
import tv.danmaku.ijk.media.exo2.Exo2PlayerManager


class MyApplication:BaseApplication() {

    override fun onCreate() {
        super.onCreate()

        CrashReport.initCrashReport(this, "faf5d5f87c", false)

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

        PlayerFactory.setPlayManager(Exo2PlayerManager::class.java)
    }
}