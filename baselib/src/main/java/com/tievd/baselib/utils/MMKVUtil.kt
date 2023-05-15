package com.tievd.baselib.utils

import android.os.Parcelable
import com.tencent.mmkv.MMKV


/**
 *
 * @author zhangli
 * @email zhanglihow@gmail.com
 * @time
 */
class MMKVUtil {
    companion object {

        private val kv by lazy {
            MMKV.defaultMMKV()
        }

        fun saveString(dataName: String, data: String) {
            kv?.encode(dataName, data)
        }

        fun getString(dataName: String): String? {
            return kv?.decodeString(dataName, null)
        }

        fun saveBoolean(name: String, b: Boolean) {
            kv?.encode(name, b)
        }

        fun getBoolean(name: String): Boolean? {
            return kv?.decodeBool(name)
        }

        fun saveBean(dataName: String, data: Parcelable?) {
            kv?.encode(dataName, data)
        }

        fun <T : Parcelable> getBean(dataName: String,tClass: Class<T> ): T? {
            return kv?.decodeParcelable(dataName,tClass)
        }

    }
}