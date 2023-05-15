package com.tievd.baselib.utils;

import java.lang.System;

/**
 * 加、减、乘、除 高精度计算工具类
 *
 * setScale(2)  //表示保留2位小数，默认是四舍五入方式
 * setScale(2, BigDecimal.ROUND_DOWN)  //删除多余的小数位，例如：2.125 → 2.12
 * setScale(2, BigDecimal.ROUND_UP)  //进位处理，例如：2.125 → 2.13
 * setScale(2, BigDecimal.ROUND_HALF_UP)  //四舍五入，例如：2.125 → 2.13
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0007J\u0018\u0010\t\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0007J\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0007J\u0018\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\f"}, d2 = {"Lcom/tievd/baselib/utils/UtilsBigDecimal;", "", "()V", "DECIMAL_POINT_NUMBER", "", "add", "", "d1", "d2", "div", "mul", "sub", "baselib_debug"})
public final class UtilsBigDecimal {
    @org.jetbrains.annotations.NotNull()
    public static final com.tievd.baselib.utils.UtilsBigDecimal INSTANCE = null;
    private static final int DECIMAL_POINT_NUMBER = 2;
    
    private UtilsBigDecimal() {
        super();
    }
    
    @kotlin.jvm.JvmStatic()
    public static final double add(double d1, double d2) {
        return 0.0;
    }
    
    @kotlin.jvm.JvmStatic()
    public static final double sub(double d1, double d2) {
        return 0.0;
    }
    
    @kotlin.jvm.JvmStatic()
    public static final double mul(double d1, double d2) {
        return 0.0;
    }
    
    @kotlin.jvm.JvmStatic()
    public static final double div(double d1, double d2) {
        return 0.0;
    }
}