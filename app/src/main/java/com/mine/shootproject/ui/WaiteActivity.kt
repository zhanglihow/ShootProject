package com.mine.shootproject.ui

import android.content.Context
import android.content.Intent
import android.view.View
import com.mine.shootproject.BuildConfig
import com.mine.shootproject.databinding.ActivityWaiteBinding
import com.mine.shootproject.event.BeatEvent
import com.mine.shootproject.event.ConnectEvent
import com.mine.shootproject.event.GetMsgEvent
import com.mine.shootproject.event.ServerStateEvent
import com.mine.shootproject.service.GreenService
import com.mine.shootproject.service.RedService
import com.tievd.baselib.base.BaseActivity
import com.tievd.baselib.base.BaseViewModel
import com.tievd.baselib.utils.ToastUtils
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
class WaiteActivity : BaseActivity<BaseViewModel,ActivityWaiteBinding>() {

    companion object{
        fun start(context: Context){
            val intent= Intent(context,WaiteActivity::class.java)
            context.startActivity(intent)
        }
    }

    override fun initView() {
        setCustomActionBar("等待双方准备完成",false)

        if(BuildConfig.FLAVOR == "red"){
            vb.redView.visibility= View.VISIBLE
            vb.greenView.stopAnimation()
            vb.greenView.clear()
            vb.redView.setOnClickListener {

            }
        }else{
            vb.greenView.visibility= View.VISIBLE
            vb.redView.stopAnimation()
            vb.redView.clear()
            vb.greenView.setOnClickListener {

            }
        }
    }

    override fun initData() {
        if(BuildConfig.FLAVOR == "red"){
            startService(Intent(this, RedService::class.java))
        }else{
            startService(Intent(this, GreenService::class.java))
        }
    }

    override fun initVM() {
    }

    override fun onDestroy() {
        if(BuildConfig.FLAVOR == "red"){
            vb.redView.stopAnimation()
            vb.redView.clear()
        }else{
            vb.greenView.stopAnimation()
            vb.greenView.clear()
        }
        super.onDestroy()
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    open fun clintConnect(event: ConnectEvent) {
        if(BuildConfig.FLAVOR == "red"){
            ToastUtils.showToast("绿方已准备好，开始游戏")
        }else{
            ToastUtils.showToast("红方已准备好，开始游戏")
        }
        CameraActivity.start(this)
        finish()
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    open fun state(event: ServerStateEvent) {
        vb.tvState.text=event.msg
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    open fun clintConnect(event: GetMsgEvent) {
        if(event.msg=="蓝方连接"){
            ToastUtils.showToast("绿方已准备好，开始游戏")
            CameraActivity.start(this)
            finish()
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    open fun beat(event: BeatEvent) {
        if(BuildConfig.FLAVOR == "red"){
            ToastUtils.showToast("发送心跳成功")
        }else{
            ToastUtils.showToast("收到心跳成功")
        }
    }

}