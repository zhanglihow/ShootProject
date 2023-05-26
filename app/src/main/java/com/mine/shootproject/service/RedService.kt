package com.mine.shootproject.service

import android.app.Service
import android.content.Intent
import android.os.Handler
import android.os.IBinder
import android.os.Message
import android.util.Log
import com.mine.shootproject.event.*
import com.tievd.baselib.utils.TyLog
import kotlinx.coroutines.*
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode
import java.io.IOException
import java.io.PrintWriter
import java.net.InetAddress
import java.net.InetSocketAddress
import java.net.ServerSocket
import java.net.Socket


/**
 *
 * @author zhangli
 * @email zhanglihow@gmail.com
 * @time
 *
 * 服务端
 */
class RedService : Service() {
    companion object {
        //Socket 连接的端口号
        const val PORT = 1995
    }

    private var job: Job? = null
    private var beatJob: Job? = null
    private var serverSocket: ServerSocket? = null
    private var client: Socket? = null

    override fun onBind(p0: Intent?): IBinder? {
        return null
    }

    override fun onCreate() {
        super.onCreate()
        EventBus.getDefault().register(this)
        startListener()
    }

    override fun onDestroy() {
        super.onDestroy()
        serverSocket?.close()
        client?.close()
        job?.cancel()
        job = null
        beatJob?.cancel()
        beatJob = null
    }

    private fun startListener() {
        if (job != null) {
            return
        }
        job = GlobalScope.launch(context = Dispatchers.IO) {
            try {
                TyLog.i("开启 Socket")
                EventBus.getDefault().post(ServerStateEvent("开启 Socket"))

                if (serverSocket == null) {
                    serverSocket = ServerSocket()
                    serverSocket?.reuseAddress = true
                    serverSocket?.bind(InetSocketAddress(PORT))
                    serverSocket?.soTimeout = 60000
                    if (client == null || client?.isConnected == false) {
                        EventBus.getDefault().post(ServerStateEvent("等待连接...如果六十秒内未连接成功则放弃"))
                        try {
                            client = serverSocket?.accept()
                        } catch (e: Exception) {
                            e.printStackTrace()
                            releaseSocket()
                        }
                    }
                }
                /*连接成功的话  发送心跳包*/
                if (client?.isConnected == true) {
                    EventBus.getDefault().post(ServerStateEvent("连接成功"))
                    sendBeatData()
                } else {
                    releaseSocket()
                }

//                client?.tcpNoDelay = true
//                client?.sendBufferSize = 4096
//                // 设置输入流的接收缓冲区大小，默认是4KB，即4096字节
//                client?.receiveBufferSize = 4096
//                // 作用：每隔一段时间检查服务器是否处于活动状态，如果服务器端长时间没响应，自动关闭客户端socket
//                // 防止服务器端无效时，客户端长时间处于连接状态
//                client?.keepAlive = true

                val inputStream = client?.getInputStream()

                /**
                 * 实现数据循环接收
                 */
                while (client!!.isConnected) {
                    val bt = ByteArray(50)
//                    TyLog.i("bt:$bt")
                    inputStream?.read(bt)
                    val str = String(bt, Charsets.UTF_8) //编码方式  解决收到数据乱码
                    if (str.contains("绿方连接")) {
                        EventBus.getDefault().post(ConnectEvent())
                    } else {
                        EventBus.getDefault().post(GetMsgEvent(str))
                    }
                    TyLog.i("str:$str")
                }
            } catch (e: Exception) {
                e.printStackTrace()
                EventBus.getDefault().post(ServerStateEvent("异常: " + e.message))
                delay(5000)
                TyLog.e("5秒后重启")
                releaseSocket()
            }
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun state(event: PostMsgEvent) {
        sendMessage(event.msg)
    }


    /**
     * @steps write();
     * @effect socket服务端发送信息
     */
    private fun sendMessage(chat: String?) {
        val thread = Thread {
            try {
                val out = PrintWriter(client?.getOutputStream())
                out.print(chat)
                out.flush()
            } catch (e: Exception) {
                e.printStackTrace()
                releaseSocket()
                EventBus.getDefault().post(ServerStateEvent("发送心跳异常" + e.message))
            }
        }
        thread.start()
    }

    /*定时发送数据*/
    private fun sendBeatData() {
        beatJob = GlobalScope.launch(Dispatchers.IO) {
            while (client?.isConnected == true) {
                delay(5000)
                sendMessage("心跳")
                EventBus.getDefault().post(BeatEvent(1))
            }
        }
    }

    /*释放资源*/
    private fun releaseSocket() {
        job?.cancel()
        beatJob?.cancel()
        client?.close()
        serverSocket?.close()
        serverSocket = null
        job = null
        startListener()
    }

}