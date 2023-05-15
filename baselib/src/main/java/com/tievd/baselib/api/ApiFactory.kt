package com.tievd.baselib.api

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.tievd.baselib.BuildConfig
import com.tievd.baselib.api.gson.MGson
import com.tievd.baselib.utils.JsonUtil
import com.tievd.baselib.utils.MMKVUtil
import com.tievd.baselib.utils.ToastUtils
import com.tievd.baselib.utils.TyLog
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


/**
 * 接口请求工厂
 */
object ApiFactory {
    // OkHttpClient客户端
    private val mClient: OkHttpClient by lazy { newClient() }

    const val TOKEN = "X-Access-Token"

    /**
     * 创建API Service接口实例
     */
    fun <T> createService(baseUrl: String, clazz: Class<T>): T =
        Retrofit.Builder().baseUrl(baseUrl).client(mClient)
            .addConverterFactory(GsonConverterFactory.create(MGson.getInstance()))
            .addCallAdapterFactory(CoroutineCallAdapterFactory.invoke())
            .build()
            .create(clazz)

    /**
     * OkHttpClient客户端
     */
    private fun newClient(): OkHttpClient = OkHttpClient.Builder().apply {
        connectTimeout(30, TimeUnit.SECONDS)// 连接时间：30s超时
        readTimeout(30, TimeUnit.SECONDS)// 读取时间：30s超时
        writeTimeout(30, TimeUnit.SECONDS)// 写入时间：30s超时
        addNetworkInterceptor(getLoggingInterceptor())
//        addInterceptor(getHeaderInterceptor())
        addInterceptor(addHeaderInterceptor())
    }.build()

    /**
     * 日志拦截器
     */
    private fun getLoggingInterceptor(): HttpLoggingInterceptor {
        val logInterceptor = HttpLoggingInterceptor(object : HttpLoggingInterceptor.Logger {
            private val mMessage = java.lang.StringBuilder()
            override fun log(message: String) {
                // 请求或者响应开始
                var message = message
                if (message.startsWith("--> POST") || message.startsWith("--> GET")) {
//                    if(BuildConfig.FLAVOR=="appRelease") {
//                        GlobalScope.launch(Dispatchers.Main) {
//                            ToastUtils.showToast("url:$message")
//                        }
//                    }
                    mMessage.setLength(0)
                }
                // 以{}或者[]形式的说明是响应结果的json数据，需要进行格式化
                if (message.startsWith("{") && message.endsWith("}")
                    || message.startsWith("[") && message.endsWith("]")
                ) {
                    message = JsonUtil.formatJson(JsonUtil.decodeUnicode(message))
                }
                mMessage.append(
                    """
                            $message
                            
                            """.trimIndent()
                )
                // 请求或者响应结束，打印整条日志
                if (message.startsWith("<-- END HTTP")) {
                    TyLog.i(mMessage.toString())
                }
            }
        })
        logInterceptor.apply {
            if(BuildConfig.DEBUG){
                logInterceptor.level = HttpLoggingInterceptor.Level.BODY
            }else{
                logInterceptor.level = HttpLoggingInterceptor.Level.HEADERS
            }
        }
        return logInterceptor
    }

    /**
     * 获取头拦截器
     */
    private fun getHeaderInterceptor(): Interceptor {
        return object : Interceptor {
            override fun intercept(chain: Interceptor.Chain): Response {
                val response = chain.proceed(chain.request())
                val head=response.headers[TOKEN]
                TyLog.i("head:$head")
                if(head!=null && head.toString().isNotEmpty()){
                    MMKVUtil.saveString(TOKEN, head.toString())
                }
                return response
            }
        }
    }

    /**
     * 添加头拦截器
     */
    private fun addHeaderInterceptor(): Interceptor {
        return object : Interceptor {
            override fun intercept(chain: Interceptor.Chain): Response {
                val token =MMKVUtil.getString(TOKEN)
//                TyLog.i("token:$token")
                val original = chain.request()
                val requestBuilder = original.newBuilder().header(TOKEN, token.toString())
                val request = requestBuilder.build()
                return chain.proceed(request)
            }
        }
    }


}

