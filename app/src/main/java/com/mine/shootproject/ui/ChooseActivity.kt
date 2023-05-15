package com.mine.shootproject.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mine.shootproject.R
import com.mine.shootproject.databinding.ActivityChooseBinding
import com.tievd.baselib.base.BaseActivity
import com.tievd.baselib.base.BaseViewModel

class ChooseActivity : BaseActivity<BaseViewModel,ActivityChooseBinding>() {

    override fun initView() {
        vb.btnRed.setOnClickListener {
            MainActivity.start(this)
            finish()
        }
        vb.btnGreen.setOnClickListener {
            MainActivity.start(this)
            finish()
        }
    }

    override fun initData() {
    }

    override fun initVM() {
    }
}