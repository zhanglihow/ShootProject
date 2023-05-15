package com.tievd.baselib.api;

import java.lang.System;

/**
 * 接口异常，即接口返回的code != 0
 *
 * 原因：1，后台接口有问题；或者，2，请求参数有问题。
 * @param errorCode 接口返回的code(非0)
 * @param msg 错误提示信息
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007\u00a8\u0006\t"}, d2 = {"Lcom/tievd/baselib/api/ApiException;", "", "errorCode", "", "msg", "(Ljava/lang/String;Ljava/lang/String;)V", "getErrorCode", "()Ljava/lang/String;", "getMsg", "baselib_debug"})
public final class ApiException extends java.lang.Throwable {
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String errorCode = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String msg = null;
    
    public ApiException(@org.jetbrains.annotations.NotNull()
    java.lang.String errorCode, @org.jetbrains.annotations.NotNull()
    java.lang.String msg) {
        super(null);
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getErrorCode() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getMsg() {
        return null;
    }
}