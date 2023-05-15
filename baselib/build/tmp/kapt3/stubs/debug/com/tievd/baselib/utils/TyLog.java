package com.tievd.baselib.utils;

import java.lang.System;

/**
 * @author zhangli
 * @email zhanglihow@gmail.com
 * @time
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0004J-\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00042\u0018\b\u0002\u0010\u0010\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u0011\"\u0004\u0018\u00010\u0001\u00a2\u0006\u0002\u0010\u0012J+\u0010\u0013\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00042\u0016\u0010\u0010\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u0011\"\u0004\u0018\u00010\u0001\u00a2\u0006\u0002\u0010\u0012J\u000e\u0010\u0014\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0004J\u0010\u0010\u0015\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\u0016\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\u0017\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n\u00a8\u0006\u0018"}, d2 = {"Lcom/tievd/baselib/utils/TyLog;", "", "()V", "TAG_NET", "", "opLog", "", "getOpLog", "()Z", "setOpLog", "(Z)V", "d", "", "msg", "e", "message", "args", "", "(Ljava/lang/String;[Ljava/lang/Object;)V", "i", "json", "showHttpApiLog", "showHttpHeaderLog", "showHttpLog", "baselib_debug"})
public final class TyLog {
    @org.jetbrains.annotations.NotNull()
    public static final com.tievd.baselib.utils.TyLog INSTANCE = null;
    private static boolean opLog;
    private static final java.lang.String TAG_NET = "NET";
    
    private TyLog() {
        super();
    }
    
    public final boolean getOpLog() {
        return false;
    }
    
    public final void setOpLog(boolean p0) {
    }
    
    public final void d(@org.jetbrains.annotations.NotNull()
    java.lang.String msg) {
    }
    
    public final void i(@org.jetbrains.annotations.NotNull()
    java.lang.String message, @org.jetbrains.annotations.NotNull()
    java.lang.Object... args) {
    }
    
    public final void e(@org.jetbrains.annotations.NotNull()
    java.lang.String message, @org.jetbrains.annotations.NotNull()
    java.lang.Object... args) {
    }
    
    public final void json(@org.jetbrains.annotations.NotNull()
    java.lang.String message) {
    }
    
    public final void showHttpHeaderLog(@org.jetbrains.annotations.Nullable()
    java.lang.String message) {
    }
    
    public final void showHttpApiLog(@org.jetbrains.annotations.Nullable()
    java.lang.String message) {
    }
    
    public final void showHttpLog(@org.jetbrains.annotations.Nullable()
    java.lang.String message) {
    }
}