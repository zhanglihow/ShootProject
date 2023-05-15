package com.tievd.baselib.api;

import java.lang.System;

/**
 * 接口请求工厂
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u000b\u001a\u00020\fH\u0002J\'\u0010\r\u001a\u0002H\u000e\"\u0004\b\u0000\u0010\u000e2\u0006\u0010\u000f\u001a\u00020\u00042\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u000e0\u0011\u00a2\u0006\u0002\u0010\u0012J\b\u0010\u0013\u001a\u00020\fH\u0002J\b\u0010\u0014\u001a\u00020\u0015H\u0002J\b\u0010\u0016\u001a\u00020\u0006H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\u0017"}, d2 = {"Lcom/tievd/baselib/api/ApiFactory;", "", "()V", "TOKEN", "", "mClient", "Lokhttp3/OkHttpClient;", "getMClient", "()Lokhttp3/OkHttpClient;", "mClient$delegate", "Lkotlin/Lazy;", "addHeaderInterceptor", "Lokhttp3/Interceptor;", "createService", "T", "baseUrl", "clazz", "Ljava/lang/Class;", "(Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;", "getHeaderInterceptor", "getLoggingInterceptor", "Lokhttp3/logging/HttpLoggingInterceptor;", "newClient", "baselib_debug"})
public final class ApiFactory {
    @org.jetbrains.annotations.NotNull()
    public static final com.tievd.baselib.api.ApiFactory INSTANCE = null;
    private static final kotlin.Lazy mClient$delegate = null;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String TOKEN = "X-Access-Token";
    
    private ApiFactory() {
        super();
    }
    
    private final okhttp3.OkHttpClient getMClient() {
        return null;
    }
    
    /**
     * 创建API Service接口实例
     */
    public final <T extends java.lang.Object>T createService(@org.jetbrains.annotations.NotNull()
    java.lang.String baseUrl, @org.jetbrains.annotations.NotNull()
    java.lang.Class<T> clazz) {
        return null;
    }
    
    /**
     * OkHttpClient客户端
     */
    private final okhttp3.OkHttpClient newClient() {
        return null;
    }
    
    /**
     * 日志拦截器
     */
    private final okhttp3.logging.HttpLoggingInterceptor getLoggingInterceptor() {
        return null;
    }
    
    /**
     * 获取头拦截器
     */
    private final okhttp3.Interceptor getHeaderInterceptor() {
        return null;
    }
    
    /**
     * 添加头拦截器
     */
    private final okhttp3.Interceptor addHeaderInterceptor() {
        return null;
    }
}