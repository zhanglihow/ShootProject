package com.tievd.baselib.utils;

import java.lang.System;

/**
 * @author zhangli
 * @email zhanglihow@gmail.com
 * @time 2020/3/27 14:36
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0004"}, d2 = {"Lcom/tievd/baselib/utils/DateUtil;", "", "()V", "Companion", "baselib_debug"})
public final class DateUtil {
    @org.jetbrains.annotations.NotNull()
    public static final com.tievd.baselib.utils.DateUtil.Companion Companion = null;
    private static final java.lang.String FORMAT = "yyyy-MM-dd HH:mm:ss";
    private static final java.lang.String FORMAT2 = "yyyy-MM-dd";
    
    public DateUtil() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\f\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0004J\u001e\u0010\n\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000b\u001a\u00020\u00042\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0004H\u0007J\b\u0010\f\u001a\u0004\u0018\u00010\bJ\u0014\u0010\r\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0004H\u0002J\u0012\u0010\u000e\u001a\u00020\u00042\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\bJ\u000e\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\bJ\u000e\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\bJ\u0010\u0010\u0014\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\bJ\u0010\u0010\u0015\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\bJ\u0010\u0010\u0016\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\bJ\u000e\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\bJ\u001c\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0004J\u000e\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\bJ\u000e\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\bJ\u0016\u0010\u001d\u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u0004J\u000e\u0010 \u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\bJ\u0010\u0010!\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\bJ\u001e\u0010\"\u001a\u0004\u0018\u00010\b2\b\u0010#\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0004J\u0018\u0010$\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00192\b\b\u0002\u0010\t\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006%"}, d2 = {"Lcom/tievd/baselib/utils/DateUtil$Companion;", "", "()V", "FORMAT", "", "FORMAT2", "date2Str", "d", "Ljava/util/Date;", "format", "getChangeTimeStr", "time", "getCurDate", "getCurrentDate", "getCurrentDateStr", "getDay", "", "date", "getEndDate", "getEndLastDate", "getHour", "getMinute", "getMonth", "getSecond", "getSecondsFromDate", "", "expireDate", "getStartDate", "getStartLastDate", "getStringToDate", "pattern", "dateString", "getThreeMonthLaterDate", "getYear", "str2Date", "str", "time2Str", "baselib_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        /**
         * 时间戳转时间
         */
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String time2Str(long time, @org.jetbrains.annotations.NotNull()
        java.lang.String format) {
            return null;
        }
        
        /**
         * 将时间str转为Date
         */
        @org.jetbrains.annotations.Nullable()
        public final java.util.Date str2Date(@org.jetbrains.annotations.Nullable()
        java.lang.String str, @org.jetbrains.annotations.Nullable()
        java.lang.String format) {
            return null;
        }
        
        /**
         * Date转为时间str
         */
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String date2Str(@org.jetbrains.annotations.Nullable()
        java.util.Date d, @org.jetbrains.annotations.Nullable()
        java.lang.String format) {
            return null;
        }
        
        /**
         * 获取当前时间
         */
        private final java.util.Date getCurrentDate(java.lang.String format) {
            return null;
        }
        
        /**
         * 获取当前时间格式
         */
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getCurrentDateStr(@org.jetbrains.annotations.Nullable()
        java.lang.String format) {
            return null;
        }
        
        /**
         * 转换时间格式
         *
         * time1:需要转转的格式 比如"2021-10-10 24：00：00"
         * format:需要转换的格式
         */
        @org.jetbrains.annotations.Nullable()
        @android.annotation.SuppressLint(value = {"SimpleDateFormat"})
        public final java.lang.String getChangeTimeStr(@org.jetbrains.annotations.NotNull()
        java.lang.String time, @org.jetbrains.annotations.Nullable()
        java.lang.String format) {
            return null;
        }
        
        /**
         * 日期转换成秒数
         */
        public final long getSecondsFromDate(@org.jetbrains.annotations.Nullable()
        java.lang.String expireDate, @org.jetbrains.annotations.Nullable()
        java.lang.String format) {
            return 0L;
        }
        
        public final long getStringToDate(@org.jetbrains.annotations.NotNull()
        java.lang.String pattern, @org.jetbrains.annotations.NotNull()
        java.lang.String dateString) {
            return 0L;
        }
        
        /**
         * 返回秒钟
         *
         * @param date Date 日期
         * @return 返回秒钟
         */
        public final int getSecond(@org.jetbrains.annotations.NotNull()
        java.util.Date date) {
            return 0;
        }
        
        /**
         * 返回天
         *
         * @param date Date 日期
         */
        public final int getDay(@org.jetbrains.annotations.Nullable()
        java.util.Date date) {
            return 0;
        }
        
        /**
         * 返回年
         *
         * @param date Date 日期
         */
        public final int getYear(@org.jetbrains.annotations.Nullable()
        java.util.Date date) {
            return 0;
        }
        
        /**
         * 返回月
         *
         * @param date Date 日期
         */
        public final int getMonth(@org.jetbrains.annotations.Nullable()
        java.util.Date date) {
            return 0;
        }
        
        /**
         * 返回小时
         *
         * @param date Date 日期
         * @return 返回小时
         */
        public final int getHour(@org.jetbrains.annotations.Nullable()
        java.util.Date date) {
            return 0;
        }
        
        /**
         * 返回分钟
         *
         * @param date Date 日期
         * @return 返回小时
         */
        public final int getMinute(@org.jetbrains.annotations.Nullable()
        java.util.Date date) {
            return 0;
        }
        
        /**
         * 获得当前日期
         */
        @org.jetbrains.annotations.Nullable()
        public final java.util.Date getCurDate() {
            return null;
        }
        
        /**
         * 获取指定日期所在月的第一天
         */
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getStartDate(@org.jetbrains.annotations.NotNull()
        java.util.Date date) {
            return null;
        }
        
        /**
         * 获取上月的第一天
         */
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getStartLastDate(@org.jetbrains.annotations.NotNull()
        java.util.Date date) {
            return null;
        }
        
        /**
         * 获取指定日期所在月的最后一天
         */
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getEndDate(@org.jetbrains.annotations.NotNull()
        java.util.Date date) {
            return null;
        }
        
        /**
         * 获取上月的最后一天
         */
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getEndLastDate(@org.jetbrains.annotations.NotNull()
        java.util.Date date) {
            return null;
        }
        
        /**
         * 获取三个月后的当前时间
         */
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getThreeMonthLaterDate(@org.jetbrains.annotations.NotNull()
        java.util.Date date) {
            return null;
        }
    }
}