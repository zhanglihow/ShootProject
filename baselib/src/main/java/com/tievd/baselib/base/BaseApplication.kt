package com.tievd.baselib.base

import android.app.Application
import android.content.Context
import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.Logger
import com.orhanobut.logger.PrettyFormatStrategy
import com.scwang.smartrefresh.layout.SmartRefreshLayout
import com.scwang.smartrefresh.layout.api.RefreshLayout
import com.scwang.smartrefresh.layout.constant.SpinnerStyle
import com.scwang.smartrefresh.layout.footer.ClassicsFooter
import com.scwang.smartrefresh.layout.header.ClassicsHeader
import com.tencent.mmkv.MMKV
import com.tievd.baselib.BuildConfig
import com.tievd.baselib.utils.TyLog


/**
 *
 * @author zhangli
 * @email zhanglihow@gmail.com
 * @time
 */
open class BaseApplication: Application() {

    companion object{
        lateinit var instance: BaseApplication
        //是否debug
        var isDebugMode = true
    }

    override fun onCreate() {
        super.onCreate()
        instance=this
        initLog()
        initMMKV()
        initRefreshLayout()
    }

    private fun initLog() {
        val formatStrategy = PrettyFormatStrategy.newBuilder()
            .showThreadInfo(false) // 展示线程信息
            .methodCount(1) // 展示调用的方法个数，默认是 2
            .methodOffset(1) // 跳过堆栈中的方法个数， 默认是 0
            .tag("qingyang") //  TAG
            .build()
        Logger.addLogAdapter(AndroidLogAdapter(formatStrategy))

        TyLog.opLog = isDebugMode
    }

    private fun initRefreshLayout() {
        //设置全局默认配置（优先级最低，会被其他设置覆盖）
        SmartRefreshLayout.setDefaultRefreshInitializer { _: Context?, layout: RefreshLayout ->
            //开始设置全局的基本参数
            layout.setFooterHeight(40f)
            layout.setDisableContentWhenLoading(false)
            layout.setDisableContentWhenRefresh(true) //是否在刷新的时候禁止列表的操作
            layout.setDisableContentWhenLoading(true) //是否在加载的时候禁止列表的操作
            layout.setEnableOverScrollBounce(false)
        }
        SmartRefreshLayout.setDefaultRefreshHeaderCreator { context: Context?, layout: RefreshLayout? ->
            ClassicsHeader(context)
                .setSpinnerStyle(SpinnerStyle.Translate)
                .setTextSizeTitle(13f)
                .setDrawableArrowSize(15f)
                .setDrawableProgressSize(15f)
                .setDrawableMarginRight(10f)
                .setFinishDuration(0)
        }
        SmartRefreshLayout.setDefaultRefreshFooterCreator { context: Context?, layout: RefreshLayout? ->
            ClassicsFooter(context)
                .setSpinnerStyle(SpinnerStyle.Translate)
                .setTextSizeTitle(13f)
                .setDrawableArrowSize(15f)
                .setDrawableProgressSize(15f)
                .setDrawableMarginRight(10f)
                .setFinishDuration(0)
        }
    }

    private fun initMMKV(){
        MMKV.initialize(this)
    }


}