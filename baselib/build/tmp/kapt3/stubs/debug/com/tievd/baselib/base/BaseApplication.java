package com.tievd.baselib.base;

import java.lang.System;

/**
 * @author zhangli
 * @email zhanglihow@gmail.com
 * @time
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0016\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0016\u00a8\u0006\t"}, d2 = {"Lcom/tievd/baselib/base/BaseApplication;", "Landroid/app/Application;", "()V", "initLog", "", "initMMKV", "initRefreshLayout", "onCreate", "Companion", "baselib_debug"})
public class BaseApplication extends android.app.Application {
    @org.jetbrains.annotations.NotNull()
    public static final com.tievd.baselib.base.BaseApplication.Companion Companion = null;
    public static com.tievd.baselib.base.BaseApplication instance;
    private static boolean isDebugMode = true;
    
    public BaseApplication() {
        super();
    }
    
    @java.lang.Override()
    public void onCreate() {
    }
    
    private final void initLog() {
    }
    
    private final void initRefreshLayout() {
    }
    
    private final void initMMKV() {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\u000b\"\u0004\b\f\u0010\r\u00a8\u0006\u000e"}, d2 = {"Lcom/tievd/baselib/base/BaseApplication$Companion;", "", "()V", "instance", "Lcom/tievd/baselib/base/BaseApplication;", "getInstance", "()Lcom/tievd/baselib/base/BaseApplication;", "setInstance", "(Lcom/tievd/baselib/base/BaseApplication;)V", "isDebugMode", "", "()Z", "setDebugMode", "(Z)V", "baselib_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.tievd.baselib.base.BaseApplication getInstance() {
            return null;
        }
        
        public final void setInstance(@org.jetbrains.annotations.NotNull()
        com.tievd.baselib.base.BaseApplication p0) {
        }
        
        public final boolean isDebugMode() {
            return false;
        }
        
        public final void setDebugMode(boolean p0) {
        }
    }
}