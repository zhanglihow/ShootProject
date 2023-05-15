package com.tievd.baselib.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tievd.baselib.api.ApiException
import com.tievd.baselib.api.error.ErrorResult
import com.tievd.baselib.api.response.BaseCenterResult
import com.tievd.baselib.api.response.BaseResult
import com.tievd.baselib.utils.RSAUtils
import com.tievd.baselib.utils.TyLog
import kotlinx.coroutines.*
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody
import java.net.URLEncoder
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException


open class BaseViewModel : ViewModel() {

    private val AUTH_SECRET = "123456"//前后台协议密钥

    var isShowLoading = MutableLiveData<Boolean>()//是否显示loading
    var errorData = MutableLiveData<ErrorResult>()//错误信息


    fun showLoading() {
        isShowLoading.value = true
    }

    fun dismissLoading() {
        isShowLoading.value = false
    }

    fun showError(error: ErrorResult) {
        errorData.value = error
    }

    /**
     * 无参
     */
    open fun signNoParams(): LinkedHashMap<String, String?> {
        val params = LinkedHashMap<String, String?>()
        params["sign"] = getSign(params)
        return params
    }

    /**
     * 有参
     */
    open fun signParams(params: LinkedHashMap<String, String?>): LinkedHashMap<String, String?> {
        params["sign"] = getSign(params)
        return params
    }


    /**
     * 签名
     */
    private fun getSign(params: LinkedHashMap<String, String?>): String {
        val sb = StringBuilder()
        params.forEach {
            val key = it.key
            var value = ""
            if (!it.value.isNullOrEmpty()) {
                value = URLEncoder.encode(it.value as String?).replace("\\+", "%20")
            }
            sb.append("$key=$value&")
        }
        val s = sb.toString().substring(0, sb.toString().length - 1).toLowerCase() + AUTH_SECRET
        return encryption(s)
    }


    /**
     * MD5加密
     *
     * @param plainText 明文
     * @return 32位密文
     */
    private fun encryption(plainText: String): String {
        var re_md5 = ""
        try {
            val md: MessageDigest = MessageDigest.getInstance("MD5")
            md.update(plainText.toByteArray())
            val b: ByteArray = md.digest()
            var i: Int
            val buf = StringBuffer("")
            for (offset in b.indices) {
                i = b[offset].toInt()
                if (i < 0) i += 256
                if (i < 16) buf.append("0")
                buf.append(Integer.toHexString(i))
            }
            re_md5 = buf.toString()
        } catch (e: NoSuchAlgorithmException) {
            e.printStackTrace()
        }
        return re_md5
    }

    /**
     * 请求接口，可定制是否显示loading和错误提示
     */
//    fun <T> launch(
//        block: suspend CoroutineScope.() -> BaseResult<T>,//请求接口方法，T表示data实体泛型，调用时可将data对应的bean传入即可
//        liveData: MutableLiveData<T>,
//        isShowLoading: Boolean = false,
//        isShowError: Boolean = true
//    ) {
//        if (isShowLoading) showLoading()
//        viewModelScope.launch {
//            try {
//                val result = withContext(Dispatchers.IO) { block() }
//                if (result.code == 200) {//请求成功
//                    liveData.value = result.data
//                } else {
//                    TyLog.e("请求错误>>" + result.msg)
//                    showError(ErrorResult(result.code, result.msg, isShowError))
//                }
//            } catch (e: Throwable) {//接口请求失败
//                TyLog.e("请求异常>>" + e.message)
//                val errorResult = ErrorUtil.getError(e)
//                errorResult.show = isShowError
//                showError(errorResult)
//            } finally {//请求结束
//                dismissLoading()
//            }
//        }
//    }

    fun ViewModel.launch(
        block: suspend CoroutineScope.() -> Unit,
        onError: (e: Throwable) -> Unit = {},
        onComplete: () -> Unit = {}
    ) {
        viewModelScope.launch(
            CoroutineExceptionHandler { _, throwable ->
                run {
                    onError(throwable)
                    throwable.message?.let { TyLog.e(it) }
                }
            }
        ) {
            try {
                block.invoke(this)
            } finally {
                onComplete()
            }
        }
    }

    /**
     * 预处理数据(错误)
     */
    fun <T : BaseResult> preprocessData(baseBean: T): T =
        when {
            baseBean.code == 200 -> {// 成功
                // 返回数据
                baseBean
            }
            baseBean.msg != null && baseBean.msg.isNotEmpty() -> {
                throw ApiException(baseBean.code.toString(), "总线返回错误：${baseBean.code},${baseBean.msg}")
            }
//            baseBean.message == "login expired" -> {// 失败
//                // 抛出接口异常
//                throw ApiException(baseBean.code.toString(), "登陆状态失效，请重新登录")
//            }
            else -> {
                throw ApiException(baseBean.code.toString(), baseBean.message)
            }
        }

    /**
     * 获取中心token特用
     */
    fun <T : BaseCenterResult> preprocessData(baseBean: T): T =
        when {
            baseBean.code == 0 -> {// 成功
                // 返回数据
                baseBean
            }
            baseBean.msg == "login expired" -> {// 失败
                // 抛出接口异常
                throw ApiException(baseBean.code.toString(), "登陆状态失效，请重新登录")
            }
            else -> {
                throw ApiException(baseBean.code.toString(), baseBean.msg)
            }
        }

    /**
     * 生成requestBody对象
     */
    fun getRequestBody(hashMap: HashMap<String, String>): RequestBody {
        val data = StringBuffer()
        if (hashMap.size > 0) {
            val iter: Iterator<*> = hashMap.entries.iterator()
            while (iter.hasNext()) {
                val entry =
                    iter.next() as Map.Entry<*, *>
                val key = entry.key
                val value = RSAUtils.getSha1Sign(entry.value as String)
                data.append(key).append("=").append(value).append("&")
            }
        }
        val jso = data.substring(0, data.length - 1)
        return RequestBody.create(
            "application/x-www-form-urlencoded; charset=utf-8".toMediaTypeOrNull(),
            jso
        )
    }
}
