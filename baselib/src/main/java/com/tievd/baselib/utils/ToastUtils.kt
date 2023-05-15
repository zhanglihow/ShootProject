package com.tievd.baselib.utils

import android.widget.Toast
import com.tievd.baselib.base.BaseApplication

object ToastUtils {

    fun showToast(msg: String){
        Toast.makeText(BaseApplication.instance,msg,Toast.LENGTH_SHORT).show()
    }
}