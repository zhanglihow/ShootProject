package com.mine.shootproject.ui

import android.Manifest
import android.content.Context
import android.content.Intent
import android.os.Vibrator
import com.hjq.permissions.OnPermissionCallback
import com.hjq.permissions.Permission
import com.hjq.permissions.XXPermissions
import com.mine.shootproject.databinding.ActivityLauncherBinding
import com.mine.shootproject.event.VoiceEvent
import com.mine.shootproject.service.VoiceService
import com.opensource.svgaplayer.SVGADrawable
import com.opensource.svgaplayer.SVGAParser
import com.opensource.svgaplayer.SVGAVideoEntity
import com.tievd.baselib.base.BaseActivity
import com.tievd.baselib.base.BaseViewModel
import com.tievd.baselib.utils.ToastUtils
import org.greenrobot.eventbus.EventBus


class LauncherActivity : BaseActivity<BaseViewModel, ActivityLauncherBinding>() {


    private var permission = false

    override fun initView() {

        vb.ivCenter.setOnClickListener {
            if (!permission) {
                ToastUtils.showToast("请先允许权限")
                getPermission()
                return@setOnClickListener
            }
            val vibrator: Vibrator =
                getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
            vibrator.vibrate(100)
            EventBus.getDefault().post(VoiceEvent(1))
            MainActivity.start(this)
            finish()
        }

         SVGAParser(this).decodeFromAssets("home_out.svga", object : SVGAParser.ParseCompletion {
             override fun onComplete(videoItem: SVGAVideoEntity) {
                 vb.svgaView.setImageDrawable(SVGADrawable(videoItem))
                 vb.svgaView.startAnimation()
                 val vibrator: Vibrator =
                     getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
                 vibrator.vibrate(500)
             }

             override fun onError() {
             }
         })

    }

    override fun initData() {

        getPermission()

        startService(Intent(this,VoiceService::class.java))
    }

    override fun initVM() {
    }

    override fun onDestroy() {
        vb.svgaView.stopAnimation()
        vb.svgaView.clear()
        super.onDestroy()
    }

    private fun getPermission() {
        XXPermissions.with(this)
            .permission(
                Permission.CAMERA,
                Manifest.permission.WRITE_SETTINGS
            )
            .request(object : OnPermissionCallback {
                override fun onGranted(permissions: MutableList<String>, all: Boolean) {
                    if (!all) {
                        ToastUtils.showToast("请授予权限")
                        return
                    }
                    permission = true
                }

                override fun onDenied(permissions: MutableList<String>, never: Boolean) {
                    if (never) {
                        ToastUtils.showToast("被永久拒绝授权，请手动授予权限")
                        XXPermissions.startPermissionActivity(this@LauncherActivity, permissions)
                    } else {
                        ToastUtils.showToast("获取权限失败")
                    }
                }
            })
    }

}