package com.tievd.baselib.api.response;

import java.lang.System;

/**
 * @author zhangli
 * @email zhanglihow@gmail.com
 * @time
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001\u0010B\u0015\u0012\u0006\u0010\u0003\u001a\u00028\u0000\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006R\u001c\u0010\u0003\u001a\u00028\u0000X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010\u000b\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0011"}, d2 = {"Lcom/tievd/baselib/api/response/CenterResult;", "T", "", "data", "header", "Lcom/tievd/baselib/api/response/CenterResult$HeaderBean;", "(Ljava/lang/Object;Lcom/tievd/baselib/api/response/CenterResult$HeaderBean;)V", "getData", "()Ljava/lang/Object;", "setData", "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "getHeader", "()Lcom/tievd/baselib/api/response/CenterResult$HeaderBean;", "setHeader", "(Lcom/tievd/baselib/api/response/CenterResult$HeaderBean;)V", "HeaderBean", "baselib_debug"})
public final class CenterResult<T extends java.lang.Object> {
    private T data;
    @org.jetbrains.annotations.NotNull()
    private com.tievd.baselib.api.response.CenterResult.HeaderBean header;
    
    public CenterResult(T data, @org.jetbrains.annotations.NotNull()
    com.tievd.baselib.api.response.CenterResult.HeaderBean header) {
        super();
    }
    
    public final T getData() {
        return null;
    }
    
    public final void setData(T p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.tievd.baselib.api.response.CenterResult.HeaderBean getHeader() {
        return null;
    }
    
    public final void setHeader(@org.jetbrains.annotations.NotNull()
    com.tievd.baselib.api.response.CenterResult.HeaderBean p0) {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0005R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007\u00a8\u0006\t"}, d2 = {"Lcom/tievd/baselib/api/response/CenterResult$HeaderBean;", "", "message", "", "code", "(Ljava/lang/String;Ljava/lang/String;)V", "getCode", "()Ljava/lang/String;", "getMessage", "baselib_debug"})
    public static final class HeaderBean {
        @org.jetbrains.annotations.NotNull()
        private final java.lang.String message = null;
        @org.jetbrains.annotations.NotNull()
        private final java.lang.String code = null;
        
        public HeaderBean(@org.jetbrains.annotations.NotNull()
        java.lang.String message, @org.jetbrains.annotations.NotNull()
        java.lang.String code) {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getMessage() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getCode() {
            return null;
        }
    }
}