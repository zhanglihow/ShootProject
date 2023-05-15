package com.tievd.baselib.utils

import java.math.BigDecimal


/**
 * 加、减、乘、除 高精度计算工具类
 *
setScale(2)  //表示保留2位小数，默认是四舍五入方式
setScale(2, BigDecimal.ROUND_DOWN)  //删除多余的小数位，例如：2.125 → 2.12
setScale(2, BigDecimal.ROUND_UP)  //进位处理，例如：2.125 → 2.13
setScale(2, BigDecimal.ROUND_HALF_UP)  //四舍五入，例如：2.125 → 2.13
 *
 * */
object UtilsBigDecimal {

    // 需要精确至小数点后几位
    private const val DECIMAL_POINT_NUMBER: Int = 2

    // 加法运算
    @JvmStatic
    fun add(d1: Double, d2: Double): Double =
        BigDecimal(d1).add(BigDecimal(d2)).setScale(DECIMAL_POINT_NUMBER, BigDecimal.ROUND_HALF_UP)
            .toDouble()

    // 减法运算
    @JvmStatic
    fun sub(d1: Double, d2: Double): Double = BigDecimal(d1).subtract(BigDecimal(d2))
        .setScale(DECIMAL_POINT_NUMBER, BigDecimal.ROUND_HALF_UP).toDouble()

    // 乘法运算
    @JvmStatic
    fun mul(d1: Double, d2: Double): Double = BigDecimal(d1).multiply(BigDecimal(d2))
        .setScale(DECIMAL_POINT_NUMBER, BigDecimal.ROUND_HALF_UP).toDouble()

    // 除法运算
    @JvmStatic
    fun div(d1: Double, d2: Double): Double = BigDecimal(d1).divide(BigDecimal(d2),
        4,BigDecimal.ROUND_HALF_UP).toDouble()

}