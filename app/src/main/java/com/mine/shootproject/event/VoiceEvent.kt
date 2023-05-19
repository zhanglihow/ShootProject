package com.mine.shootproject.event


/**
 *
 * @author zhangli
 * @email zhanglihow@gmail.com
 * @time
 *
 * type= 1:start_1,2:start_2,3:all_start,4:shoot,5:shoot_not,6:shoot_ok,7:环境音
 */
class VoiceEvent(val type:Int,val isLoop:Boolean=false) {
}