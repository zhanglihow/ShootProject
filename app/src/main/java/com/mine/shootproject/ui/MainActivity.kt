package com.mine.shootproject.ui

import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.view.View
import com.android.dx.stock.ProxyBuilder
import com.mine.shootproject.BuildConfig
import com.mine.shootproject.databinding.ActivityMainBinding
import com.tievd.baselib.base.BaseActivity
import com.tievd.baselib.base.BaseViewModel
import java.lang.reflect.InvocationHandler

class MainActivity : BaseActivity<BaseViewModel,ActivityMainBinding>() {

    companion object{
        fun start(context: Context){
            val intent=Intent(context,MainActivity::class.java)
            context.startActivity(intent)
        }
    }

    override fun initView() {
        if(BuildConfig.FLAVOR == "red"){
            vb.redView.visibility= View.VISIBLE
            vb.greenView.stopAnimation()
            vb.greenView.clear()
            vb.redView.setOnClickListener {
                WaiteActivity.start(this)
                finish()
            }
            startTethering(this)
        }else{
            vb.greenView.visibility= View.VISIBLE
            vb.redView.stopAnimation()
            vb.redView.clear()
            vb.greenView.setOnClickListener {
                WaiteActivity.start(this)
                finish()
            }
        }
    }

    override fun initData() {
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
            val proxy: Any = ProxyBuilder.forClass(classOnStartTetheringCallback).handler { _, _, _ -> null }
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