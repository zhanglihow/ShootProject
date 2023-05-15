package com.tievd.baselib.base;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u00042\u00020\u0005B\u0005\u00a2\u0006\u0002\u0010\u0006J\u0006\u0010-\u001a\u00020.J\u0010\u0010/\u001a\u00020.2\u0006\u0010/\u001a\u000200H\u0016J\n\u00101\u001a\u0004\u0018\u000102H\u0016J\u0010\u00103\u001a\u00020.2\u0006\u00104\u001a\u000205H\u0017J\b\u00106\u001a\u00020.H\u0002J\b\u00107\u001a\u00020.H&J\b\u00108\u001a\u00020.H\u0002J\b\u00109\u001a\u00020.H&J\b\u0010:\u001a\u00020.H&J\u0012\u0010;\u001a\u00020.2\b\u0010<\u001a\u0004\u0018\u00010=H\u0014J\b\u0010>\u001a\u00020.H\u0014J\u0010\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00020BH\u0016J*\u0010C\u001a\u00020.2\u0006\u0010D\u001a\u00020E2\b\b\u0002\u0010F\u001a\u00020@2\u0010\b\u0002\u0010G\u001a\n\u0012\u0004\u0012\u00020.\u0018\u00010HJ*\u0010C\u001a\u00020.2\u0006\u0010I\u001a\u0002022\b\b\u0002\u0010J\u001a\u00020@2\u0010\b\u0002\u0010G\u001a\n\u0012\u0004\u0012\u00020.\u0018\u00010HJ\u000e\u0010K\u001a\u00020.2\u0006\u0010L\u001a\u00020EJ\u0010\u0010M\u001a\u00020.2\b\b\u0002\u0010I\u001a\u000202R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u00020\u0010X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001b\u001a\u0004\u0018\u00010\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\n\"\u0004\b\u001d\u0010\fR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u0016X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0018\"\u0004\b \u0010\u001aR\u001c\u0010!\u001a\u00028\u0001X\u0086.\u00a2\u0006\u0010\n\u0002\u0010&\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001c\u0010\'\u001a\u00028\u0000X\u0086.\u00a2\u0006\u0010\n\u0002\u0010,\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+\u00a8\u0006N"}, d2 = {"Lcom/tievd/baselib/base/BaseActivity;", "VM", "Lcom/tievd/baselib/base/BaseViewModel;", "VB", "Landroidx/viewbinding/ViewBinding;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "backView", "Landroid/widget/ImageView;", "getBackView", "()Landroid/widget/ImageView;", "setBackView", "(Landroid/widget/ImageView;)V", "loadingDialog", "Landroid/app/ProgressDialog;", "mContext", "Landroidx/fragment/app/FragmentActivity;", "getMContext", "()Landroidx/fragment/app/FragmentActivity;", "setMContext", "(Landroidx/fragment/app/FragmentActivity;)V", "rightMenu", "Landroid/widget/TextView;", "getRightMenu", "()Landroid/widget/TextView;", "setRightMenu", "(Landroid/widget/TextView;)V", "rightView", "getRightView", "setRightView", "titleView", "getTitleView", "setTitleView", "vb", "getVb", "()Landroidx/viewbinding/ViewBinding;", "setVb", "(Landroidx/viewbinding/ViewBinding;)V", "Landroidx/viewbinding/ViewBinding;", "vm", "getVm", "()Lcom/tievd/baselib/base/BaseViewModel;", "setVm", "(Lcom/tievd/baselib/base/BaseViewModel;)V", "Lcom/tievd/baselib/base/BaseViewModel;", "dismissLoading", "", "errorResult", "Lcom/tievd/baselib/api/error/ErrorResult;", "getClassName", "", "getEventBus", "event", "Lcom/tievd/baselib/event/EventTokenOut;", "init", "initData", "initStatusBar", "initVM", "initView", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onOptionsItemSelected", "", "item", "Landroid/view/MenuItem;", "setCustomActionBar", "color", "", "white", "function", "Lkotlin/Function0;", "title", "showBack", "setStatusBarColor", "colorId", "showLoading", "baselib_debug"})
public abstract class BaseActivity<VM extends com.tievd.baselib.base.BaseViewModel, VB extends androidx.viewbinding.ViewBinding> extends androidx.appcompat.app.AppCompatActivity {
    public androidx.fragment.app.FragmentActivity mContext;
    public VM vm;
    public VB vb;
    private android.app.ProgressDialog loadingDialog;
    @org.jetbrains.annotations.Nullable()
    private android.widget.TextView titleView;
    @org.jetbrains.annotations.Nullable()
    private android.widget.ImageView backView;
    @org.jetbrains.annotations.Nullable()
    private android.widget.ImageView rightView;
    @org.jetbrains.annotations.Nullable()
    private android.widget.TextView rightMenu;
    private java.util.HashMap _$_findViewCache;
    
    public BaseActivity() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.fragment.app.FragmentActivity getMContext() {
        return null;
    }
    
    public final void setMContext(@org.jetbrains.annotations.NotNull()
    androidx.fragment.app.FragmentActivity p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final VM getVm() {
        return null;
    }
    
    public final void setVm(@org.jetbrains.annotations.NotNull()
    VM p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final VB getVb() {
        return null;
    }
    
    public final void setVb(@org.jetbrains.annotations.NotNull()
    VB p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final android.widget.TextView getTitleView() {
        return null;
    }
    
    public final void setTitleView(@org.jetbrains.annotations.Nullable()
    android.widget.TextView p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final android.widget.ImageView getBackView() {
        return null;
    }
    
    public final void setBackView(@org.jetbrains.annotations.Nullable()
    android.widget.ImageView p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final android.widget.ImageView getRightView() {
        return null;
    }
    
    public final void setRightView(@org.jetbrains.annotations.Nullable()
    android.widget.ImageView p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final android.widget.TextView getRightMenu() {
        return null;
    }
    
    public final void setRightMenu(@org.jetbrains.annotations.Nullable()
    android.widget.TextView p0) {
    }
    
    @kotlin.Suppress(names = {"UNCHECKED_CAST"})
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public java.lang.String getClassName() {
        return null;
    }
    
    public abstract void initView();
    
    public abstract void initData();
    
    public abstract void initVM();
    
    private final void init() {
    }
    
    public final void showLoading(@org.jetbrains.annotations.NotNull()
    java.lang.String title) {
    }
    
    public final void dismissLoading() {
    }
    
    /**
     * 接口请求错误回调
     */
    public void errorResult(@org.jetbrains.annotations.NotNull()
    com.tievd.baselib.api.error.ErrorResult errorResult) {
    }
    
    /**
     * 说明：
     * 1. SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN：Activity全屏显示，但状态栏不会被隐藏覆盖。
     * 2. SYSTEM_UI_FLAG_LIGHT_STATUS_BAR：设置状态栏图标为黑色或者白色
     * 3. StatusBarUtil 工具类是修改状态栏的颜色为白色。
     */
    private final void initStatusBar() {
    }
    
    public final void setCustomActionBar(@org.jetbrains.annotations.NotNull()
    java.lang.String title, boolean showBack, @org.jetbrains.annotations.Nullable()
    kotlin.jvm.functions.Function0<kotlin.Unit> function) {
    }
    
    public final void setCustomActionBar(int color, boolean white, @org.jetbrains.annotations.Nullable()
    kotlin.jvm.functions.Function0<kotlin.Unit> function) {
    }
    
    @java.lang.Override()
    public boolean onOptionsItemSelected(@org.jetbrains.annotations.NotNull()
    android.view.MenuItem item) {
        return false;
    }
    
    /**
     * 修改状态栏颜色，支持4.4以上版本
     * @param colorId
     */
    public final void setStatusBarColor(int colorId) {
    }
    
    /**
     * 退出所有Activity
     */
    @org.greenrobot.eventbus.Subscribe(threadMode = org.greenrobot.eventbus.ThreadMode.MAIN)
    public void getEventBus(@org.jetbrains.annotations.NotNull()
    com.tievd.baselib.event.EventTokenOut event) {
    }
    
    @java.lang.Override()
    protected void onDestroy() {
    }
}