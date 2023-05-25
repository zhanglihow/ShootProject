package com.mine.shootproject.service

import android.app.Service
import android.content.Context
import android.content.Intent
import android.media.MediaPlayer
import android.net.Uri
import android.os.IBinder
import com.mine.shootproject.R
import com.mine.shootproject.event.VoiceEvent
import com.mine.shootproject.event.VoiceStopEvent
import com.mine.shootproject.utils.MediaPlayerUtil
import com.mine.shootproject.utils.SoundPoolHelper
import kotlinx.coroutines.Job
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode
import java.io.IOException


/**
 *
 * @author zhangli
 * @email zhanglihow@gmail.com
 * @time
 */
class VoiceService : Service() {

    val startJob1: Job? = null
    val startJob2: Job? = null
    val shootJob: Job? = null
    private var soundPoolHelper: SoundPoolHelper? = null

    override fun onBind(p0: Intent?): IBinder? {
        return null
    }

    override fun onCreate() {
        super.onCreate()
        EventBus.getDefault().register(this)
        init()
    }

    override fun onDestroy() {
        super.onDestroy()
        soundPoolHelper?.release()
    }

    private fun init() {
        //初始化，指定是最大4个Stream流，使用默认的Stream：TYPE_MUSIC
        soundPoolHelper = SoundPoolHelper(10, SoundPoolHelper.TYPE_MUSIC)
            .setRingtoneType(SoundPoolHelper.RING_TYPE_MUSIC) //加载默认音频，因为上面指定了，所以其默认是：RING_TYPE_MUSIC
            .load(this, "start_1", R.raw.start1)
            .load(this, "start_2", R.raw.start2)
            .load(this, "all_start", R.raw.all_start)
            .load(this, "wait_shoot", R.raw.wait_shoot)
            .load(this, "shoot_click", R.raw.shoot_click)
            .load(this, "shoot_ok", R.raw.shoot_ok)
            .load(this, "shoot_not", R.raw.shoot_not)
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun voice(event: VoiceEvent) {
        when (event.type) {
            1 -> {
                soundPoolHelper?.play("start_1", event.isLoop)
            }
            2 -> {
                soundPoolHelper?.play("start_2", event.isLoop)
            }
            3 -> {
                soundPoolHelper?.stop("start_2")
                soundPoolHelper?.play("all_start", event.isLoop)
            }
            4 -> {
                soundPoolHelper?.play("wait_shoot", event.isLoop)
            }
            5 -> {
                soundPoolHelper?.play("shoot_click", event.isLoop)
            }
            6 -> {
                soundPoolHelper?.play("shoot_ok", event.isLoop)
            }
            7 -> {
                soundPoolHelper?.play("shoot_not", event.isLoop)
            }
            8-> {
                playLong()
            }
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun voiceStop(event: VoiceStopEvent) {
        when (event.type) {
            1 -> {
                soundPoolHelper?.stop("start_1")
            }
            2 -> {
                soundPoolHelper?.stop("start_2")
            }
            3 -> {
                soundPoolHelper?.stop("all_start")
            }
            4 -> {
                soundPoolHelper?.stop("wait_shoot")
            }
            5 -> {
                soundPoolHelper?.stop("shoot_click")
            }
            6 -> {
                soundPoolHelper?.stop("shoot_ok")
            }
            7 -> {
                soundPoolHelper?.stop("shoot_not")
            }
            8-> {
                stopLong()
            }
        }
    }

    private fun playLong() {
        MediaPlayerUtil.initMedia(this,R.raw.long_voice)
        MediaPlayerUtil.playMedia()
    }

    private fun stopLong(){
        MediaPlayerUtil.release()
    }


}