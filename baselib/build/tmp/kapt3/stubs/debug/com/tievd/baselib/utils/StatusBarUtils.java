package com.tievd.baselib.utils;

import java.lang.System;

/**
 * @author zhangli
 * @email zhanglihow@gmail.com
 * @time
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\u0004J\u0016\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u0004J\u0016\u0010\u000b\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000eJ\u0016\u0010\u000f\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000eJ\u0016\u0010\u0010\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u000eJ\u000e\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\nJ\u0010\u0010\u0013\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\nH\u0007\u00a8\u0006\u0014"}, d2 = {"Lcom/tievd/baselib/utils/StatusBarUtils;", "", "()V", "FlymeSetStatusBarLightMode", "", "window", "Landroid/view/Window;", "dark", "MIUISetStatusBarLightMode", "activity", "Landroid/app/Activity;", "StatusBarDarkMode", "", "type", "", "StatusBarLightMode", "setStatusBarColor", "colorId", "statusBarLightMode", "transparencyBar", "baselib_debug"})
public final class StatusBarUtils {
    @org.jetbrains.annotations.NotNull()
    public static final com.tievd.baselib.utils.StatusBarUtils INSTANCE = null;
    
    private StatusBarUtils() {
        super();
    }
    
    /**
     * 修改状态栏为全透明
     *
     * @param activity
     */
    @android.annotation.TargetApi(value = 19)
    public final void transparencyBar(@org.jetbrains.annotations.NotNull()
    android.app.Activity activity) {
    }
    
    /**
     * 修改状态栏颜色，支持4.4以上版本
     *
     * @param activity
     * @param colorId
     */
    public final void setStatusBarColor(@org.jetbrains.annotations.NotNull()
    android.app.Activity activity, int colorId) {
    }
    
    /**
     * 状态栏亮色模式，设置状态栏黑色文字、图标，
     * 适配4.4以上版本MIUIV、Flyme和6.0以上版本其他Android
     *
     * @param activity
     * @return 1:MIUUI 2:Flyme 3:android6.0
     */
    public final int statusBarLightMode(@org.jetbrains.annotations.NotNull()
    android.app.Activity activity) {
        return 0;
    }
    
    /**
     * 已知系统类型时，设置状态栏黑色文字、图标。
     * 适配4.4以上版本MIUIV、Flyme和6.0以上版本其他Android
     *
     * @param activity
     * @param type     1:MIUUI 2:Flyme 3:android6.0
     */
    public final void StatusBarLightMode(@org.jetbrains.annotations.NotNull()
    android.app.Activity activity, int type) {
    }
    
    /**
     * 状态栏暗色模式，清除MIUI、flyme或6.0以上版本状态栏黑色文字、图标
     */
    public final void StatusBarDarkMode(@org.jetbrains.annotations.NotNull()
    android.app.Activity activity, int type) {
    }
    
    /**
     * 设置状态栏图标为深色和魅族特定的文字风格
     * 可以用来判断是否为Flyme用户
     *
     * @param window 需要设置的窗口
     * @param dark   是否把状态栏文字及图标颜色设置为深色
     * @return boolean 成功执行返回true
     */
    public final boolean FlymeSetStatusBarLightMode(@org.jetbrains.annotations.Nullable()
    android.view.Window window, boolean dark) {
        return false;
    }
    
    /**
     * 需要MIUIV6以上
     *
     * @param activity
     * @param dark     是否把状态栏文字及图标颜色设置为深色
     * @return boolean 成功执行返回true
     */
    public final boolean MIUISetStatusBarLightMode(@org.jetbrains.annotations.NotNull()
    android.app.Activity activity, boolean dark) {
        return false;
    }
}