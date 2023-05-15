package com.tievd.baselib.base

import android.app.ProgressDialog
import android.content.Intent
import android.graphics.drawable.ColorDrawable
import android.os.Build
import android.os.Bundle
import android.view.*
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding
import com.tievd.baselib.R
import com.tievd.baselib.api.error.ErrorResult
import com.tievd.baselib.event.EventTokenOut
import com.tievd.baselib.utils.StatusBarUtils
import com.tievd.baselib.utils.StatusBarUtils.setStatusBarColor
import com.tievd.baselib.utils.StatusBarUtils.statusBarLightMode
import com.tievd.baselib.utils.ToastUtils
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode
import java.lang.reflect.ParameterizedType


abstract class BaseActivity<VM : BaseViewModel, VB : ViewBinding> : AppCompatActivity() {

    lateinit var mContext: FragmentActivity
    lateinit var vm: VM
    lateinit var vb: VB

    private var loadingDialog: ProgressDialog? = null

    var titleView: TextView? = null
    var backView: ImageView? = null
    var rightView: ImageView? = null
    var rightMenu:TextView?=null

    @Suppress("UNCHECKED_CAST")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStatusBarColor(this, R.color.white)
        statusBarLightMode(this)

        //避免软键盘弹出
        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN)
        //注意 type.actualTypeArguments[0]=BaseViewModel，type.actualTypeArguments[1]=ViewBinding
        val type = javaClass.genericSuperclass as ParameterizedType
        val clazz1 = type.actualTypeArguments[0] as Class<VM>
        vm = ViewModelProvider(this).get(clazz1)

        val clazz2 = type.actualTypeArguments[1] as Class<VB>
        val method = clazz2.getMethod("inflate", LayoutInflater::class.java)
        vb = method.invoke(null, layoutInflater) as VB

        setContentView(vb.root)

        mContext = this
        init()
        initView()
        initVM()
        initData()
        EventBus.getDefault().register(this)
    }

    open fun getClassName(): String? {
        val className = "BaseActivity"
        try {
            return javaClass.name
        } catch (e: Exception) {
        }
        return className
    }

    abstract fun initView()

    abstract fun initData()

    abstract fun initVM()

    private fun init() {
        //loading
        vm.isShowLoading.observe(this, Observer {
            if (it) showLoading() else dismissLoading()
        })
        //错误信息
        vm.errorData.observe(this, Observer {
            if (it.show) it.errMsg?.let { it1 -> ToastUtils.showToast(it1) }
            errorResult(it)
        })
    }

    fun showLoading(title: String = "请稍后...") {
        if (loadingDialog == null) {
            loadingDialog = ProgressDialog(this)
            loadingDialog?.setTitle(title)
        }
        loadingDialog?.show()
    }

    fun dismissLoading() {
        loadingDialog?.dismiss()
        loadingDialog = null
    }

    /**
     * 接口请求错误回调
     */
    open fun errorResult(errorResult: ErrorResult) {}


    /**
     * 说明：
     * 1. SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN：Activity全屏显示，但状态栏不会被隐藏覆盖。
     * 2. SYSTEM_UI_FLAG_LIGHT_STATUS_BAR：设置状态栏图标为黑色或者白色
     * 3. StatusBarUtil 工具类是修改状态栏的颜色为白色。
     */
    private fun initStatusBar() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            window.decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR)
            setStatusBarColor(this, R.color.white)
        }
    }

    fun setCustomActionBar(
        title: String, showBack: Boolean = true,
        function: (() -> Unit)? = null
    ) {
        val lp = ActionBar.LayoutParams(
            ActionBar.LayoutParams.MATCH_PARENT,
            ActionBar.LayoutParams.MATCH_PARENT,
            Gravity.CENTER
        )
        val mActionBarView = LayoutInflater.from(this).inflate(R.layout.layout_actionbar, null);

        backView = mActionBarView.findViewById<ImageView>(R.id.tv_back)
        if (showBack) {
            backView?.visibility = View.VISIBLE
        } else {
            backView?.visibility = View.INVISIBLE
        }
        backView?.setOnClickListener {
            finish()
        }
        if (function != null) {
            rightView = mActionBarView.findViewById(R.id.tv_back_gone)
            rightView?.visibility = View.VISIBLE
            rightView?.setOnClickListener {
                function()
            }
        }

        titleView = mActionBarView.findViewById(R.id.tv_title)
        titleView?.text = title
        supportActionBar?.setCustomView(mActionBarView, lp)
        supportActionBar?.displayOptions = ActionBar.DISPLAY_SHOW_CUSTOM
        supportActionBar?.setBackgroundDrawable(
            ColorDrawable(
                ContextCompat.getColor(
                    this,
                    R.color.white
                )
            )
        )
        supportActionBar?.setDisplayShowCustomEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(false)
        supportActionBar?.setDisplayShowTitleEnabled(false)
    }

    fun setCustomActionBar(color: Int,white:Boolean=false, function: (() -> Unit)?=null) {
        val lp = ActionBar.LayoutParams(
            ActionBar.LayoutParams.MATCH_PARENT,
            ActionBar.LayoutParams.MATCH_PARENT,
            Gravity.CENTER
        )
        val mActionBarView =
            LayoutInflater.from(this).inflate(R.layout.layout_actionbar_white, null)

        backView = mActionBarView.findViewById<ImageView>(R.id.tv_back)
        backView?.setOnClickListener {
            finish()
        }
        rightMenu = mActionBarView.findViewById<TextView>(R.id.tv_right)
        rightMenu?.setOnClickListener {
            function?.let { it1 -> it1() }
        }
        if(white){
            backView?.setImageResource(R.drawable.ic_baseline_arrow_back_24)
            rightMenu?.setTextColor(ContextCompat.getColor(this,R.color.white))
        }

        titleView = mActionBarView.findViewById(R.id.tv_title)
        titleView?.text = title
        supportActionBar?.setCustomView(mActionBarView, lp)
        supportActionBar?.displayOptions = ActionBar.DISPLAY_SHOW_CUSTOM
        supportActionBar?.setBackgroundDrawable(ColorDrawable(ContextCompat.getColor(this, color)))
        supportActionBar?.setDisplayShowCustomEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(false)
        supportActionBar?.setDisplayShowTitleEnabled(false)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> finish()
            else -> {
            }
        }
        return super.onOptionsItemSelected(item)
    }

    /**
     * 修改状态栏颜色，支持4.4以上版本
     * @param colorId
     */
    fun setStatusBarColor(colorId: Int) {
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window.statusBarColor = resources.getColor(colorId)
    }

    /**
     * 退出所有Activity
     */
    @Subscribe(threadMode = ThreadMode.MAIN)
    open fun getEventBus(event: EventTokenOut) {
        finish()
    }

    override fun onDestroy() {
        super.onDestroy()
        EventBus.getDefault().unregister(this)
    }

}