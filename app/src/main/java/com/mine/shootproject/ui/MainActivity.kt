package com.mine.shootproject.ui

import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.os.Vibrator
import android.view.View
import com.android.dx.stock.ProxyBuilder
import com.bumptech.glide.Glide
import com.mine.shootproject.BuildConfig
import com.mine.shootproject.databinding.ActivityMainBinding
import com.mine.shootproject.event.VoiceEvent
import com.mine.shootproject.utils.ColorBlobDetectionActivity
import com.mine.shootproject.utils.ColorBlobDetectionActivity2
import com.opensource.svgaplayer.SVGADrawable
import com.opensource.svgaplayer.SVGAParser
import com.opensource.svgaplayer.SVGAVideoEntity
import com.tievd.baselib.base.BaseActivity
import com.tievd.baselib.base.BaseViewModel
import org.greenrobot.eventbus.EventBus
import java.lang.reflect.InvocationHandler

class MainActivity : BaseActivity<BaseViewModel, ActivityMainBinding>() {

    companion object {
        fun start(context: Context) {
            val intent = Intent(context, MainActivity::class.java)
            context.startActivity(intent)
        }
    }

    private fun start(){
        val vibrator: Vibrator =
            getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
        vibrator.vibrate(100)
        EventBus.getDefault().post(VoiceEvent(2))
        WaiteActivity.start(this)
//        MyCameraActivity.start(this)

        finish()
    }

    override fun initView() {
        if (BuildConfig.FLAVOR == "red") {
            vb.redView.setOnClickListener {
                start()
            }
            SVGAParser(this).decodeFromAssets("ready_wear_red.svga", object : SVGAParser.ParseCompletion {
                override fun onComplete(videoItem: SVGAVideoEntity) {
                    vb.redView.setImageDrawable(SVGADrawable(videoItem))
                    vb.redView.startAnimation()
                }

                override fun onError() {
                }
            })

            startTethering(this)
        } else {
            vb.redView.setOnClickListener {
                start()
            }
            SVGAParser(this).decodeFromAssets("ready_wear_green.svga", object : SVGAParser.ParseCompletion {
                override fun onComplete(videoItem: SVGAVideoEntity) {
                    vb.redView.setImageDrawable(SVGADrawable(videoItem))
                    vb.redView.startAnimation()
                }

                override fun onError() {
                }
            })
        }
        SVGAParser(this).decodeFromAssets("home_out.svga", object : SVGAParser.ParseCompletion {
            override fun onComplete(videoItem: SVGAVideoEntity) {
                vb.outView.setImageDrawable(SVGADrawable(videoItem))
                vb.outView.startAnimation()
            }

            override fun onError() {
            }
        })

    }

    override fun initData() {
    }

    override fun initVM() {
    }

    override fun onDestroy() {
        vb.redView.stopAnimation()
        vb.redView.clear()
        super.onDestroy()
    }

    /**
     * 打开WiFi热点
     * @param context
     */
    private fun startTethering(context: Context) {
        //1、环境属性记录
        val property = System.getProperty("dexmaker.dexcache")

        //2、设置新的属性
        System.setProperty("dexmaker.dexcache", context.cacheDir.path)

        //3、反射操作打开热点
        val connectivityManager =
            context.getSystemService(CONNECTIVITY_SERVICE) as ConnectivityManager
        try {
            val classOnStartTetheringCallback =
                Class.forName("android.net.ConnectivityManager\$OnStartTetheringCallback")
            val startTethering = connectivityManager.javaClass.getDeclaredMethod(
                "startTethering",
                Int::class.javaPrimitiveType,
                Boolean::class.javaPrimitiveType, classOnStartTetheringCallback
            )
            val proxy: Any =
                ProxyBuilder.forClass(classOnStartTetheringCallback).handler { _, _, _ -> null }
                    .build()
            startTethering.invoke(connectivityManager, 0, false, proxy)
        } catch (e: Exception) {
            e.printStackTrace()
        }

        //4、恢复环境属性
        if (property != null) {
            System.setProperty("dexmaker.dexcache", property)
        }
    }

}