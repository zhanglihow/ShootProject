package com.tievd.baselib.api.error;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0011\u0018\u00002\u00020\u0001B1\b\u0007\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\tR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\b\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000b\"\u0004\b\u0013\u0010\rR\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017\u00a8\u0006\u0018"}, d2 = {"Lcom/tievd/baselib/api/error/ErrorResult;", "", "code", "", "errMsg", "", "show", "", "index", "(ILjava/lang/String;ZI)V", "getCode", "()I", "setCode", "(I)V", "getErrMsg", "()Ljava/lang/String;", "setErrMsg", "(Ljava/lang/String;)V", "getIndex", "setIndex", "getShow", "()Z", "setShow", "(Z)V", "baselib_debug"})
public final class ErrorResult {
    private int code;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String errMsg;
    private boolean show;
    private int index;
    
    @kotlin.jvm.JvmOverloads()
    public ErrorResult() {
        super();
    }
    
    @kotlin.jvm.JvmOverloads()
    public ErrorResult(int code) {
        super();
    }
    
    @kotlin.jvm.JvmOverloads()
    public ErrorResult(int code, @org.jetbrains.annotations.Nullable()
    java.lang.String errMsg) {
        super();
    }
    
    @kotlin.jvm.JvmOverloads()
    public ErrorResult(int code, @org.jetbrains.annotations.Nullable()
    java.lang.String errMsg, boolean show) {
        super();
    }
    
    @kotlin.jvm.JvmOverloads()
    public ErrorResult(int code, @org.jetbrains.annotations.Nullable()
    java.lang.String errMsg, boolean show, int index) {
        super();
    }
    
    public final int getCode() {
        return 0;
    }
    
    public final void setCode(int p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getErrMsg() {
        return null;
    }
    
    public final void setErrMsg(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    public final boolean getShow() {
        return false;
    }
    
    public final void setShow(boolean p0) {
    }
    
    public final int getIndex() {
        return 0;
    }
    
    public final void setIndex(int p0) {
    }
}