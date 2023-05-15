package com.tievd.baselib.utils;

import java.lang.System;

/**
 * @author zhangli
 * @email zhanglihow@gmail.com
 * @time
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0004"}, d2 = {"Lcom/tievd/baselib/utils/MMKVUtil;", "", "()V", "Companion", "baselib_debug"})
public final class MMKVUtil {
    @org.jetbrains.annotations.NotNull()
    public static final com.tievd.baselib.utils.MMKVUtil.Companion Companion = null;
    private static final kotlin.Lazy kv$delegate = null;
    
    public MMKVUtil() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J-\u0010\t\u001a\u0004\u0018\u0001H\n\"\b\b\u0000\u0010\n*\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\n0\u000f\u00a2\u0006\u0002\u0010\u0010J\u0015\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\r\u00a2\u0006\u0002\u0010\u0014J\u0010\u0010\u0015\u001a\u0004\u0018\u00010\r2\u0006\u0010\f\u001a\u00020\rJ\u0018\u0010\u0016\u001a\u00020\u00172\u0006\u0010\f\u001a\u00020\r2\b\u0010\u0018\u001a\u0004\u0018\u00010\u000bJ\u0016\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u0013\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u0012J\u0016\u0010\u001b\u001a\u00020\u00172\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\rR\u001d\u0010\u0003\u001a\u0004\u0018\u00010\u00048BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u001c"}, d2 = {"Lcom/tievd/baselib/utils/MMKVUtil$Companion;", "", "()V", "kv", "Lcom/tencent/mmkv/MMKV;", "getKv", "()Lcom/tencent/mmkv/MMKV;", "kv$delegate", "Lkotlin/Lazy;", "getBean", "T", "Landroid/os/Parcelable;", "dataName", "", "tClass", "Ljava/lang/Class;", "(Ljava/lang/String;Ljava/lang/Class;)Landroid/os/Parcelable;", "getBoolean", "", "name", "(Ljava/lang/String;)Ljava/lang/Boolean;", "getString", "saveBean", "", "data", "saveBoolean", "b", "saveString", "baselib_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        private final com.tencent.mmkv.MMKV getKv() {
            return null;
        }
        
        public final void saveString(@org.jetbrains.annotations.NotNull()
        java.lang.String dataName, @org.jetbrains.annotations.NotNull()
        java.lang.String data) {
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String getString(@org.jetbrains.annotations.NotNull()
        java.lang.String dataName) {
            return null;
        }
        
        public final void saveBoolean(@org.jetbrains.annotations.NotNull()
        java.lang.String name, boolean b) {
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.Boolean getBoolean(@org.jetbrains.annotations.NotNull()
        java.lang.String name) {
            return null;
        }
        
        public final void saveBean(@org.jetbrains.annotations.NotNull()
        java.lang.String dataName, @org.jetbrains.annotations.Nullable()
        android.os.Parcelable data) {
        }
        
        @org.jetbrains.annotations.Nullable()
        public final <T extends android.os.Parcelable>T getBean(@org.jetbrains.annotations.NotNull()
        java.lang.String dataName, @org.jetbrains.annotations.NotNull()
        java.lang.Class<T> tClass) {
            return null;
        }
    }
}