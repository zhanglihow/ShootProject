package com.mine.shootproject.ui

import android.content.Context
import android.content.Intent
import com.mine.shootproject.BuildConfig
import com.mine.shootproject.databinding.ActivityCameraBinding
import com.mine.shootproject.event.BeatEvent
import com.mine.shootproject.event.ServerStateEvent
import com.mine.shootproject.service.GreenService
import com.mine.shootproject.service.RedService
import com.tievd.baselib.base.BaseActivity
import com.tievd.baselib.base.BaseViewModel
import com.tievd.baselib.utils.ToastUtils
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

class CameraActivity : BaseActivity<BaseViewModel, ActivityCameraBinding>() {

    companion object{
        fun start(context: Context){
            val intent= Intent(context,CameraActivity::class.java)
            context.startActivity(intent)
        }
    }

    override fun initView() {
    }

    override fun initData() {
    }

    override fun initVM() {
    }

    override fun onDestroy() {
        super.onDestroy()
        if(BuildConfig.FLAVOR == "red"){
            stopService(Intent(this, RedService::class.java))
        }else{
            stopService(Intent(this, GreenService::class.java))
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    open fun beat(event: BeatEvent) {
        if(event.type==1){
            ToastUtils.showToast("发送心跳成功")
        }else{
            ToastUtils.showToast("收到心跳成功")
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    open fun state(event: ServerStateEvent) {
        vb.tvState.text=event.msg
    }
}