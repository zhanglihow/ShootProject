package com.tievd.baselib.api.response


/**
 *
 * @author zhangli
 * @email zhanglihow@gmail.com
 * @time
 */
class CenterResult<T>(var data:T,var header:HeaderBean) {
    class HeaderBean(val message:String,val code:String)
}