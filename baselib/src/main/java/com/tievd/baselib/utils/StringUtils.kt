package com.tievd.baselib.utils

import java.util.regex.Matcher
import java.util.regex.Pattern


/**
 *
 * @author zhangli
 * @email zhanglihow@gmail.com
 * @time
 */
class StringUtils {

    companion object{
        /**
         * 去除输入中不正确的数字
         */
        fun getEtDisCountString(str:String):Float{
            if(str.isEmpty()){
                return 0F
            }
            if(str=="."){
                return 0F
            }
            if(str.startsWith(".")){
                return str.substring(1,str.length).toFloat()
            }
            if(str.endsWith(".")){
                return str.substring(0,str.length-1).toFloat()
            }
            return str.toFloat()
        }

        /**
         * 去除空格和回车
         */
        fun replaceBlank(str: String): String {
            var dest = ""
            val p: Pattern = Pattern.compile("\\s*|\t|\r|\n")
            val m: Matcher = p.matcher(str)
            dest = m.replaceAll("")
            return dest
        }
    }
}