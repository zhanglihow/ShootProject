package com.mine.shootproject.utils

import android.content.Context
import android.net.wifi.WifiManager
import android.util.Log
import com.tievd.baselib.utils.TyLog


/**
 *
 * @author zhangli
 * @email zhanglihow@gmail.com
 * @time
 */
class ConnectUtil {
    companion object {
        /**
         * 本机IP
         */
         fun getLocalIp(context: Context): String? {
            val wifiManager =
                context.applicationContext.getSystemService(Context.WIFI_SERVICE) as WifiManager
            val wifiInfo = wifiManager.connectionInfo
            val ipAddress = wifiInfo.ipAddress
            TyLog.i("getLocalIp ip:$ipAddress")
            if (ipAddress == 0) {
                return null
            }
            return ((ipAddress and 0xff).toString() + "." + (ipAddress shr 8 and 0xff) + "."
                    + (ipAddress shr 16 and 0xff) + "." + (ipAddress shr 24 and 0xff))
        }
    }
}