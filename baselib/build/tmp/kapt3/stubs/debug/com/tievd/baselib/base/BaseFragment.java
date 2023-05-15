package com.tievd.baselib.base;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u00042\u00020\u0005B\u0005\u00a2\u0006\u0002\u0010\u0006J\u0006\u0010(\u001a\u00020)J\u0010\u0010*\u001a\u00020)2\u0006\u0010*\u001a\u00020+H\u0016J\b\u0010,\u001a\u00020)H\u0002J\b\u0010-\u001a\u00020)H&J\b\u0010.\u001a\u00020)H&J\b\u0010/\u001a\u00020)H&J\b\u00100\u001a\u00020)H&J\u0006\u00101\u001a\u00020)J\b\u00102\u001a\u00020)H&J\u0012\u00103\u001a\u00020)2\b\u00104\u001a\u0004\u0018\u000105H\u0016J&\u00106\u001a\u0004\u0018\u00010\b2\u0006\u00107\u001a\u0002082\b\u00109\u001a\u0004\u0018\u00010:2\b\u00104\u001a\u0004\u0018\u000105H\u0016J\b\u0010;\u001a\u00020)H\u0016J\u001a\u0010<\u001a\u00020)2\u0006\u0010=\u001a\u00020\b2\b\u00104\u001a\u0004\u0018\u000105H\u0016J\u0010\u0010>\u001a\u00020)2\u0006\u0010\u0010\u001a\u00020\u000eH\u0016J\u0006\u0010?\u001a\u00020)R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u00020\u000eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0016\u001a\u00020\u0017X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001c\u001a\u00028\u0001X\u0086.\u00a2\u0006\u0010\n\u0002\u0010!\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001c\u0010\"\u001a\u00028\u0000X\u0086.\u00a2\u0006\u0010\n\u0002\u0010\'\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&\u00a8\u0006@"}, d2 = {"Lcom/tievd/baselib/base/BaseFragment;", "VM", "Lcom/tievd/baselib/base/BaseViewModel;", "VB", "Landroidx/viewbinding/ViewBinding;", "Landroidx/fragment/app/Fragment;", "()V", "contentView", "Landroid/view/View;", "getContentView", "()Landroid/view/View;", "setContentView", "(Landroid/view/View;)V", "isUIVisible", "", "isViewCreated", "isVisibleToUser", "()Z", "setVisibleToUser", "(Z)V", "loadingDialog", "Landroid/app/ProgressDialog;", "mContext", "Landroidx/fragment/app/FragmentActivity;", "getMContext", "()Landroidx/fragment/app/FragmentActivity;", "setMContext", "(Landroidx/fragment/app/FragmentActivity;)V", "vb", "getVb", "()Landroidx/viewbinding/ViewBinding;", "setVb", "(Landroidx/viewbinding/ViewBinding;)V", "Landroidx/viewbinding/ViewBinding;", "vm", "getVm", "()Lcom/tievd/baselib/base/BaseViewModel;", "setVm", "(Lcom/tievd/baselib/base/BaseViewModel;)V", "Lcom/tievd/baselib/base/BaseViewModel;", "dismissLoading", "", "errorResult", "Lcom/tievd/baselib/api/error/ErrorResult;", "init", "initClick", "initData", "initVM", "initView", "lazyLoad", "lazyLoadData", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroyView", "onViewCreated", "view", "setUserVisibleHint", "showLoading", "baselib_debug"})
public abstract class BaseFragment<VM extends com.tievd.baselib.base.BaseViewModel, VB extends androidx.viewbinding.ViewBinding> extends androidx.fragment.app.Fragment {
    public androidx.fragment.app.FragmentActivity mContext;
    @org.jetbrains.annotations.Nullable()
    private android.view.View contentView;
    public VM vm;
    public VB vb;
    private android.app.ProgressDialog loadingDialog;
    private boolean isViewCreated = false;
    private boolean isUIVisible = false;
    private boolean isVisibleToUser = false;
    private java.util.HashMap _$_findViewCache;
    
    public BaseFragment() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.fragment.app.FragmentActivity getMContext() {
        return null;
    }
    
    public final void setMContext(@org.jetbrains.annotations.NotNull()
    androidx.fragment.app.FragmentActivity p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final android.view.View getContentView() {
        return null;
    }
    
    public final void setContentView(@org.jetbrains.annotations.Nullable()
    android.view.View p0) {
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
    
    public final boolean isVisibleToUser() {
        return false;
    }
    
    public final void setVisibleToUser(boolean p0) {
    }
    
    @kotlin.Suppress(names = {"UNCHECKED_CAST"})
    @java.lang.Override()
    public void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    @java.lang.Override()
    public void onViewCreated(@org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void init() {
    }
    
    public abstract void initVM();
    
    public abstract void initView();
    
    public abstract void initClick();
    
    public abstract void initData();
    
    @java.lang.Override()
    public void setUserVisibleHint(boolean isVisibleToUser) {
    }
    
    public final void lazyLoad() {
    }
    
    public abstract void lazyLoadData();
    
    public final void showLoading() {
    }
    
    public final void dismissLoading() {
    }
    
    /**
     * 接口请求错误回调
     */
    public void errorResult(@org.jetbrains.annotations.NotNull()
    com.tievd.baselib.api.error.ErrorResult errorResult) {
    }
    
    @java.lang.Override()
    public void onDestroyView() {
    }
}