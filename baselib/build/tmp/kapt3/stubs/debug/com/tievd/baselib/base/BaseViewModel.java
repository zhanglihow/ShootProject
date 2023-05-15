package com.tievd.baselib.base;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u000f\u001a\u00020\u0010J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0004H\u0002J*\u0010\u0013\u001a\u00020\u00142\"\u0010\u0015\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0016j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004`\u0017J0\u0010\u0018\u001a\u00020\u00042&\u0010\u0019\u001a\"\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u001aj\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004`\u001bH\u0002J\u001d\u0010\u001c\u001a\u0002H\u001d\"\b\b\u0000\u0010\u001d*\u00020\u001e2\u0006\u0010\u001f\u001a\u0002H\u001d\u00a2\u0006\u0002\u0010 J\u001d\u0010\u001c\u001a\u0002H\u001d\"\b\b\u0000\u0010\u001d*\u00020!2\u0006\u0010\u001f\u001a\u0002H\u001d\u00a2\u0006\u0002\u0010\"J\u000e\u0010#\u001a\u00020\u00102\u0006\u0010$\u001a\u00020\u0007J\u0006\u0010%\u001a\u00020\u0010J(\u0010&\u001a\"\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u001aj\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004`\u001bH\u0016JP\u0010\'\u001a\"\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u001aj\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004`\u001b2&\u0010\u0019\u001a\"\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u001aj\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004`\u001bH\u0016Jp\u0010(\u001a\u00020\u0010*\u00020\u00012\'\u0010)\u001a#\b\u0001\u0012\u0004\u0012\u00020+\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100,\u0012\u0006\u0012\u0004\u0018\u00010-0*\u00a2\u0006\u0002\b.2#\b\u0002\u0010/\u001a\u001d\u0012\u0013\u0012\u001101\u00a2\u0006\f\b2\u0012\b\b3\u0012\u0004\b\b(4\u0012\u0004\u0012\u00020\u0010002\u000e\b\u0002\u00105\u001a\b\u0012\u0004\u0012\u00020\u001006\u00f8\u0001\u0000\u00a2\u0006\u0002\u00107R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000R \u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR \u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\u000e\u0010\u000b\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u00068"}, d2 = {"Lcom/tievd/baselib/base/BaseViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "AUTH_SECRET", "", "errorData", "Landroidx/lifecycle/MutableLiveData;", "Lcom/tievd/baselib/api/error/ErrorResult;", "getErrorData", "()Landroidx/lifecycle/MutableLiveData;", "setErrorData", "(Landroidx/lifecycle/MutableLiveData;)V", "isShowLoading", "", "setShowLoading", "dismissLoading", "", "encryption", "plainText", "getRequestBody", "Lokhttp3/RequestBody;", "hashMap", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "getSign", "params", "Ljava/util/LinkedHashMap;", "Lkotlin/collections/LinkedHashMap;", "preprocessData", "T", "Lcom/tievd/baselib/api/response/BaseCenterResult;", "baseBean", "(Lcom/tievd/baselib/api/response/BaseCenterResult;)Lcom/tievd/baselib/api/response/BaseCenterResult;", "Lcom/tievd/baselib/api/response/BaseResult;", "(Lcom/tievd/baselib/api/response/BaseResult;)Lcom/tievd/baselib/api/response/BaseResult;", "showError", "error", "showLoading", "signNoParams", "signParams", "launch", "block", "Lkotlin/Function2;", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "onError", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "e", "onComplete", "Lkotlin/Function0;", "(Landroidx/lifecycle/ViewModel;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)V", "baselib_debug"})
public class BaseViewModel extends androidx.lifecycle.ViewModel {
    private final java.lang.String AUTH_SECRET = "123456";
    @org.jetbrains.annotations.NotNull()
    private androidx.lifecycle.MutableLiveData<java.lang.Boolean> isShowLoading;
    @org.jetbrains.annotations.NotNull()
    private androidx.lifecycle.MutableLiveData<com.tievd.baselib.api.error.ErrorResult> errorData;
    
    public BaseViewModel() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.lang.Boolean> isShowLoading() {
        return null;
    }
    
    public final void setShowLoading(@org.jetbrains.annotations.NotNull()
    androidx.lifecycle.MutableLiveData<java.lang.Boolean> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<com.tievd.baselib.api.error.ErrorResult> getErrorData() {
        return null;
    }
    
    public final void setErrorData(@org.jetbrains.annotations.NotNull()
    androidx.lifecycle.MutableLiveData<com.tievd.baselib.api.error.ErrorResult> p0) {
    }
    
    public final void showLoading() {
    }
    
    public final void dismissLoading() {
    }
    
    public final void showError(@org.jetbrains.annotations.NotNull()
    com.tievd.baselib.api.error.ErrorResult error) {
    }
    
    /**
     * 无参
     */
    @org.jetbrains.annotations.NotNull()
    public java.util.LinkedHashMap<java.lang.String, java.lang.String> signNoParams() {
        return null;
    }
    
    /**
     * 有参
     */
    @org.jetbrains.annotations.NotNull()
    public java.util.LinkedHashMap<java.lang.String, java.lang.String> signParams(@org.jetbrains.annotations.NotNull()
    java.util.LinkedHashMap<java.lang.String, java.lang.String> params) {
        return null;
    }
    
    /**
     * 签名
     */
    private final java.lang.String getSign(java.util.LinkedHashMap<java.lang.String, java.lang.String> params) {
        return null;
    }
    
    /**
     * MD5加密
     *
     * @param plainText 明文
     * @return 32位密文
     */
    private final java.lang.String encryption(java.lang.String plainText) {
        return null;
    }
    
    /**
     * 请求接口，可定制是否显示loading和错误提示
     */
    public final void launch(@org.jetbrains.annotations.NotNull()
    androidx.lifecycle.ViewModel $this$launch, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function2<? super kotlinx.coroutines.CoroutineScope, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object> block, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.Throwable, kotlin.Unit> onError, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onComplete) {
    }
    
    /**
     * 预处理数据(错误)
     */
    @org.jetbrains.annotations.NotNull()
    public final <T extends com.tievd.baselib.api.response.BaseResult>T preprocessData(@org.jetbrains.annotations.NotNull()
    T baseBean) {
        return null;
    }
    
    /**
     * 获取中心token特用
     */
    @org.jetbrains.annotations.NotNull()
    public final <T extends com.tievd.baselib.api.response.BaseCenterResult>T preprocessData(@org.jetbrains.annotations.NotNull()
    T baseBean) {
        return null;
    }
    
    /**
     * 生成requestBody对象
     */
    @org.jetbrains.annotations.NotNull()
    public final okhttp3.RequestBody getRequestBody(@org.jetbrains.annotations.NotNull()
    java.util.HashMap<java.lang.String, java.lang.String> hashMap) {
        return null;
    }
}