package com.mine.shootproject.service

import android.R.attr.data
import android.app.Service
import android.content.Context
import android.content.Intent
import android.net.wifi.WifiManager
import android.os.IBinder
import android.system.Os.socket
import com.mine.shootproject.event.*
import com.tievd.baselib.utils.TyLog
import kotlinx.coroutines.*
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode
import java.io.*
import java.net.InetSocketAddress
import java.net.Socket


/**
 *
 * @author zhangli
 * @email zhanglihow@gmail.com
 * @time
 *
 * 客户端
 */
class GreenService : Service() {

    private var job: Job? = null
    private var client: Socket? = null

    private var isFirstConnect = true

    override fun onBind(p0: Intent?): IBinder? {
        return null
    }

    override fun onCreate() {
        super.onCreate()
        EventBus.getDefault().register(this)
        val ip = getHotspotIpAddress(this)
        send(ip, "绿方连接")
    }

    override fun onDestroy() {
        super.onDestroy()
        client?.close()
        job?.cancel()
        job = null
    }

    fun send(ipAddress: String, msg: String) {
        if (job != null) {
            return
        }
        job = GlobalScope.launch {
            withContext(context = Dispatchers.IO) {
                EventBus.getDefault().post(ServerStateEvent("开启 Socket"))

                client = Socket()
                client?.soTimeout = 60000
                client?.bind(null)

                EventBus.getDefault().post(ServerStateEvent("如果六十秒内未连接成功则放弃"))

                try {
                    client?.connect(InetSocketAddress(ipAddress, RedService.PORT), 30000)
                } catch (e: Exception) {
                    e.printStackTrace()
                    job = null
                    client = null
                    delay(5000)
                    send(ipAddress, msg)
                }

                EventBus.getDefault().post(ServerStateEvent("连接成功"))

                if (isFirstConnect) {
                    isFirstConnect = false
                    sendMessage(msg)
                }

                try {
//                    client?.tcpNoDelay = true
//                    client?.sendBufferSize = 4096
//                    // 设置输入流的接收缓冲区大小，默认是4KB，即4096字节
//                    client?.receiveBufferSize = 4096
//                    // 作用：每隔一段时间检查服务器是否处于活动状态，如果服务器端长时间没响应，自动关闭客户端socket
//                    // 防止服务器端无效时，客户端长时间处于连接状态
//                    client?.keepAlive = true
                    /**得到输入流 */
                    val inputStream = client?.getInputStream()
                    /**
                     * 实现数据循环接收
                     */
                    while (client?.isConnected == true) {
                        val bt = ByteArray(50)
                        inputStream?.read(bt)
                        val str = String(bt, Charsets.UTF_8) //编码方式  解决收到数据乱码
                        if (str.contains("心跳")) {
                            EventBus.getDefault().post(BeatEvent(2))
                        } else {
                            EventBus.getDefault().post(GetMsgEvent(str))
                        }
                        TyLog.i("str:$str")
                    }
                } catch (e: Exception) {
                    e.printStackTrace()
                    EventBus.getDefault().post(ServerStateEvent("出现异常"))
                    delay(5000)
                    releaseSocket()
                }
            }
        }
    }

    private fun getHotspotIpAddress(context: Context): String {
        val wifiManager =
            context.applicationContext.getSystemService(Context.WIFI_SERVICE) as? WifiManager
        val wifiInfo = wifiManager?.connectionInfo
        if (wifiInfo != null) {
            val dhcpInfo = wifiManager.dhcpInfo
            if (dhcpInfo != null) {
                val address = dhcpInfo.gateway
                return ((address and 0xFF).toString() + "." + (address shr 8 and 0xFF)
                        + "." + (address shr 16 and 0xFF)
                        + "." + (address shr 24 and 0xFF))
            }
        }
        return ""
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun state(event: PostMsgEvent) {
        sendMessage(event.msg)
    }

    /**
     * @steps write();
     * @effect 发送消息
     */
    private fun sendMessage(str: String?) {
        val thread = Thread {
            try {
                val out = PrintWriter(client?.getOutputStream())
                out.print(str)
                out.flush()
                if (str == "绿方连接") {
                    EventBus.getDefault().post(ConnectEvent())
                }
            } catch (e: Exception) {
                e.printStackTrace()
                EventBus.getDefault().post(ServerStateEvent("发送消息失败" + e.message))
                Thread.sleep(5000)
                releaseSocket()
            }
        }
        thread.start()
    }

    /*释放资源*/
    private fun releaseSocket() {
        job?.cancel()
        job = null
        client?.close()
        client = null
        val ip = getHotspotIpAddress(this)
        send(ip, "绿方连接")
    }

}