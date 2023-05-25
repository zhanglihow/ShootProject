package com.mine.shootproject.weight

import android.content.Context
import android.util.AttributeSet
import android.view.View
import com.mine.shootproject.R
import com.shuyu.gsyvideoplayer.video.StandardGSYVideoPlayer


/**
 *
 * @author zhangli
 * @email zhanglihow@gmail.com
 * @time
 */
class MuVideoView(context: Context, attrs: AttributeSet) :
    StandardGSYVideoPlayer(context, attrs) {

    override fun getLayoutId(): Int {
        return R.layout.layout_my_video
    }
}