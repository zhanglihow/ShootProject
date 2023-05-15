package com.tievd.baselib.widget

import android.view.View
import com.tievd.baselib.widget.ViewClickDelay.SPACE_TIME
import com.tievd.baselib.widget.ViewClickDelay.hash
import com.tievd.baselib.widget.ViewClickDelay.lastClickTime

object ViewClickDelay {
    var hash: Int = 0
    var lastClickTime: Long = 0
    var SPACE_TIME: Long = 0
}

infix fun View.clicks(clickAction: () -> Unit) {
    this.setOnClickListener {
        if (this.hashCode() != hash) {
            hash = this.hashCode()
            lastClickTime = System.currentTimeMillis()
            clickAction()
        } else {
            val currentTime = System.currentTimeMillis()
            if (currentTime - lastClickTime > SPACE_TIME) {
                lastClickTime = System.currentTimeMillis()
                clickAction()
            }
        }
    }
}