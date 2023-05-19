package com.mine.shootproject.ui

import android.content.Context
import android.content.Intent
import android.os.Vibrator
import android.view.View
import com.bumptech.glide.Glide
import com.mine.shootproject.BuildConfig
import com.mine.shootproject.databinding.ActivityWaiteBinding
import com.mine.shootproject.event.*
import com.mine.shootproject.service.GreenService
import com.mine.shootproject.service.RedService
import com.opensource.svgaplayer.SVGADrawable
import com.opensource.svgaplayer.SVGAParser
import com.opensource.svgaplayer.SVGAVideoEntity
import com.tievd.baselib.base.BaseActivity
import com.tievd.baselib.base.BaseViewModel
import com.tievd.baselib.utils.ToastUtils
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

/**
 * 这个页面进行socket连接
 * 连接完成，两边自动跳相机页面
 *
 * 红方是服务端
 *
 * 绿方是客户端
 *
 */
class WaiteActivity : BaseActivity<BaseViewModel, ActivityWaiteBinding>() {

    companion object {
        fun start(context: Context) {
            val intent = Intent(context, WaiteActivity::class.java)
            context.startActivity(intent)
        }
    }

    override fun initView() {
        setCustomActionBar("等待双方准备完成", false)

        if (BuildConfig.FLAVOR == "red") {
            SVGAParser(this).decodeFromAssets("waite_red.svga", object : SVGAParser.ParseCompletion {
                override fun onComplete(videoItem: SVGAVideoEntity) {
                    vb.redView.setImageDrawable(SVGADrawable(videoItem))
                    vb.redView.startAnimation()
                }
                override fun onError() {
                }
            })
        } else {
            SVGAParser(this).decodeFromAssets("waite_green.svga", object : SVGAParser.ParseCompletion {
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
                vb.redView.setImageDrawable(SVGADrawable(videoItem))
                vb.redView.startAnimation()
            }
            override fun onError() {
            }
        })
    }

    override fun initData() {
        if (BuildConfig.FLAVOR == "red") {
            startService(Intent(this, RedService::class.java))
        } else {
            startService(Intent(this, GreenService::class.java))
        }

        //test
        GlobalScope.launch {
            delay(2000)
            start()
        }
    }

    override fun initVM() {
    }

    override fun onDestroy() {
        vb.redView.stopAnimation()
        vb.redView.clear()
        super.onDestroy()
    }

    private fun start(){
        val vibrator: Vibrator =
            getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
        vibrator.vibrate(100)
        EventBus.getDefault().post(VoiceEvent(3))
        MyCameraActivity.start(this)
        finish()
    }


    @Subscribe(threadMode = ThreadMode.MAIN)
     fun clintConnect(event: ConnectEvent) {
        if (BuildConfig.FLAVOR == "red") {
            ToastUtils.showToast("绿方已准备好，开始游戏")
        } else {
            ToastUtils.showToast("红方已准备好，开始游戏")
        }
        start()
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
     fun state(event: ServerStateEvent) {
        vb.tvState.text = event.msg
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
     fun clintConnect(event: GetMsgEvent) {
        if (event.msg == "绿方连接") {
            ToastUtils.showToast("绿方已准备好，开始游戏")
            start()
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
     fun beat(event: BeatEvent) {
        if (BuildConfig.FLAVOR == "red") {
            ToastUtils.showToast("发送心跳成功")
        } else {
            ToastUtils.showToast("收到心跳成功")
        }
    }

}