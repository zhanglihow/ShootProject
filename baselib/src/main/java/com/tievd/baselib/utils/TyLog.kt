package com.tievd.baselib.utils

import android.util.Log
import com.orhanobut.logger.Logger
import com.tievd.baselib.base.BaseApplication.Companion.isDebugMode


/**
 *
 * @author zhangli
 * @email zhanglihow@gmail.com
 * @time
 */
object TyLog {
    var opLog = !isDebugMode

    private const val TAG_NET = "NET"

    fun d(msg: String) {
        if (!opLog) return
        Logger.d(msg)
    }

    fun i(message: String, vararg args: Any?) {
        if (!opLog) return
        Logger.i(message, *args)
    }

    fun e(message: String, vararg args: Any?= emptyArray()) {
        if (!opLog) return
        Logger.e(message, *args)
    }

    fun json(message: String) {
        if (!opLog) return
        Logger.json(message)
    }

    fun showHttpHeaderLog(message: String?) {
        if (!opLog) message?.let { Log.d(TAG_NET, it) }
    }

    fun showHttpApiLog(message: String?) {
        if (!opLog) message?.let { Log.w(TAG_NET, it) }
    }

    fun showHttpLog(message: String?) {
        if (!opLog) message?.let { Log.i(TAG_NET, it) }
    }
}