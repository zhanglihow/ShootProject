package com.tievd.baselib.utils

import android.annotation.SuppressLint
import java.text.ParseException
import java.text.ParsePosition
import java.text.SimpleDateFormat
import java.util.*


/**
 *
 * @author zhangli
 * @email zhanglihow@gmail.com
 * @time 2020/3/27 14:36
 */
class DateUtil {

    companion object {
        private const val FORMAT = "yyyy-MM-dd HH:mm:ss"
        private const val FORMAT2 = "yyyy-MM-dd"

        /**
         * 时间戳转时间
         */
        fun time2Str(time: Long, format: String = FORMAT):String{
            var date = "0"
            try {
                val sdf = SimpleDateFormat(format, Locale.CHINA)
                date = sdf.format(Date(time))
            } catch (e: Exception) {
                e.printStackTrace()
            }
            return date
        }

        /**
         * 将时间str转为Date
         */
        fun str2Date(str: String?, format: String? = null): Date? {
            var format1 = format
            if (str == null || str.isEmpty()) {
                return null
            }
            if (format == null || format.isEmpty()) {
                format1 = FORMAT
            }
            var date: Date? = null
            try {
                val sdf = SimpleDateFormat(format1, Locale.CHINA)
                date = sdf.parse(str)
            } catch (e: Exception) {
                e.printStackTrace()
            }
            return date
        }

        /**
         * Date转为时间str
         */
        fun date2Str(d: Date?, format: String? = null): String? {
            var format1 = format
            if (d == null) {
                return null
            }
            if (format == null || format.isEmpty()) {
                format1 = FORMAT
            }
            val sdf = SimpleDateFormat(format1, Locale.CHINA)
            return sdf.format(d)
        }


        /**
         * 获取当前时间
         */
        private fun getCurrentDate(format: String? = null): Date {
            var format1 = format
            if (format == null || format.isEmpty()) {
                format1 = FORMAT
            }
            val simpleDateFormat = SimpleDateFormat(format1, Locale.CHINA)
            return Date(System.currentTimeMillis())
        }

        /**
         * 获取当前时间格式
         */
        fun getCurrentDateStr(format: String? = null): String {
            var format1 = format
            if (format == null || format.isEmpty()) {
                format1 = FORMAT
            }
            val simpleDateFormat = SimpleDateFormat(format1, Locale.CHINA)
            return simpleDateFormat.format(getCurrentDate(format1))
        }

        /**
         * 转换时间格式
         *
         * time1:需要转转的格式 比如"2021-10-10 24：00：00"
         * format:需要转换的格式
         */
        @SuppressLint("SimpleDateFormat")
        fun getChangeTimeStr(time:String, format: String? = null): String?{
            var format1 = format
            if (format == null || format.isEmpty()) {
                format1 = FORMAT
            }
            val date=str2Date(time,format1)
            return date2Str(date,format1)
        }
        /**
         * 日期转换成秒数
         */
        fun getSecondsFromDate(expireDate: String?, format: String? = null): Long {
            if (expireDate == null || expireDate.trim { it <= ' ' } == "") return 0
            var format1 = format
            if (format == null || format.isEmpty()) {
                format1 = FORMAT
            }
            val sdf = SimpleDateFormat(format1)
            val date: Date?
            return try {
                date = sdf.parse(expireDate)
                (date.time / 1000)
            } catch (e: ParseException) {
                e.printStackTrace()
                0L
            }
        }

        fun getStringToDate(pattern: String, dateString: String): Long {
            val dateFormat = SimpleDateFormat(pattern)
            return try {
                val date = dateFormat.parse(dateString)
                date.time
            } catch (e: ParseException) {
                e.printStackTrace()
                0
            }
        }


        /**
         * 返回秒钟
         *
         * @param date Date 日期
         * @return 返回秒钟
         */
        fun getSecond(date: Date): Int {
            val calendar = Calendar.getInstance()
            calendar.time = date
            return calendar.get(Calendar.SECOND)
        }

        /**
         * 返回天
         *
         * @param date Date 日期
         */
        fun getDay(date: Date?): Int {
            val calendar = Calendar.getInstance()
            calendar.time = date
            return calendar.get(Calendar.DAY_OF_MONTH)
        }

        /**
         * 返回年
         *
         * @param date Date 日期
         */
        fun getYear(date: Date?): Int {
            val calendar = Calendar.getInstance()
            calendar.time = date
            return calendar.get(Calendar.YEAR)
        }

        /**
         * 返回月
         *
         * @param date Date 日期
         */
        fun getMonth(date: Date?): Int {
            val calendar = Calendar.getInstance()
            calendar.time = date
            return calendar.get(Calendar.MONTH)+1
        }

        /**
         * 返回小时
         *
         * @param date Date 日期
         * @return 返回小时
         */
        fun getHour(date: Date?): Int {
            val calendar = Calendar.getInstance()
            calendar.time = date
            return calendar.get(Calendar.HOUR_OF_DAY)
        }

        /**
         * 返回分钟
         *
         * @param date Date 日期
         * @return 返回小时
         */
        fun getMinute(date: Date?): Int {
            val calendar = Calendar.getInstance()
            calendar.time = date
            return calendar.get(Calendar.MINUTE)
        }

        /**
         * 获得当前日期
         */
        fun getCurDate(): Date? {
            val c = Calendar.getInstance()
            return c.time
        }


        /**
         * 获取指定日期所在月的第一天
         */
         fun getStartDate(date:Date):String {
            val calendar = Calendar.getInstance()
            calendar.time = date
            calendar[calendar[Calendar.YEAR], calendar[Calendar.MONTH]] = 1
            val startDate = calendar.time
            val sDateFormat = SimpleDateFormat(FORMAT2)
            return sDateFormat.format(startDate)
        }

        /**
         * 获取上月的第一天
         */
        fun getStartLastDate(date:Date):String {
            val calendar = Calendar.getInstance()
            calendar.time = date
            calendar[calendar[Calendar.YEAR], calendar[Calendar.MONTH]-1] = 1
            val startDate = calendar.time
            val sDateFormat = SimpleDateFormat(FORMAT2)
            return sDateFormat.format(startDate)
        }

        /**
         * 获取指定日期所在月的最后一天
         */
         fun getEndDate(date:Date):String {
            val calendar = Calendar.getInstance()
            calendar.time = date
            calendar[calendar[Calendar.YEAR], calendar[Calendar.MONTH]] = 1
            calendar.roll(Calendar.DATE, -1)
            val endDate = calendar.time
            val sDateFormat = SimpleDateFormat(FORMAT2)
            return sDateFormat.format(endDate)
        }

        /**
         * 获取上月的最后一天
         */
        fun getEndLastDate(date:Date):String {
            val calendar = Calendar.getInstance()
            calendar.time = date
            calendar[calendar[Calendar.YEAR], calendar[Calendar.MONTH]-1] = 1
            calendar.roll(Calendar.DATE, -1)
            val endDate = calendar.time
            val sDateFormat = SimpleDateFormat(FORMAT2)
            return sDateFormat.format(endDate)
        }


        /**
         * 获取三个月后的当前时间
         */
        fun getThreeMonthLaterDate(date:Date):String {
            val calendar = Calendar.getInstance()
            calendar.time = date
            calendar.add(Calendar.DAY_OF_YEAR, 90)
            val endDate = calendar.time
            val sDateFormat = SimpleDateFormat(FORMAT2)
            return sDateFormat.format(endDate)
        }

    }


}