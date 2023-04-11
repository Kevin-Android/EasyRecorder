package com.easy.recorder.target

import android.media.MediaRecorder
import android.os.Build
import android.util.Log
import com.easy.recorder.AudioFileUtil
import com.easy.recorder.AudioTarget
import com.easy.recorder.Builder
import com.easy.recorder.listener.OnRecorderListener
import com.easy.recorder.source.AacAudioSource
import java.io.IOException
import java.util.Objects

/**
 *    @author : 王康
 *    @date   : 2023/4/10
 *    @desc   :
 */
class AacTarget(private val builder: Builder, private val audioSource: AacAudioSource) :
    AudioTarget() {

    private lateinit var mMediaRecorder: MediaRecorder
    private lateinit var mOnRecorderListener: OnRecorderListener

    override fun load() {
        mMediaRecorder = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            MediaRecorder(builder.getContext())
        } else {
            MediaRecorder()
        }
        mMediaRecorder.apply {
            //  设置用于录音的音频源
            setAudioSource(MediaRecorder.AudioSource.DEFAULT)
            //  设置录制期间生成的输出文件的格式
            setOutputFormat(audioSource.audioOutputFormat)
            //  设置用于录音的音频编码器
            setAudioEncoder(audioSource.audioEncoder)
            //  设置用于录制的音频通道数
            setAudioChannels(audioSource.audioChannels)
            //  设置录音的音频编码比特率
//            setAudioEncodingBitRate(audioSource.audioEncodingBitRate)
            //  设置录音的音频采样率
            setAudioSamplingRate(audioSource.audioSamplingRate)
            val rootPath = builder.rootPath ?: throw IllegalStateException("are you okay ?")
            val aacFile = AudioFileUtil.createAacFile(rootPath)
            Log.d("AacTarget", "是否存在：${aacFile.exists()}")
            Log.d("AacTarget", "相对路径：${aacFile.isFile}")
            Log.d("AacTarget", "绝对路径：${aacFile.absolutePath}")
            Log.d("AacTarget", "hashCode：${hashCode()}")
            Log.d("AacTarget", "hashCode：${hashCode()}")
            setOutputFile(aacFile.absolutePath)


        }
    }


    override fun listener(onRecorderListener: OnRecorderListener) {
        mOnRecorderListener = onRecorderListener
    }

    private fun sendEvent(i: Int) {
        mOnRecorderListener.onRecorderStatus(i)
    }


    override fun prepare() {
        try {
            Log.d("AacTarget", "start：${mMediaRecorder.hashCode()}")
            Log.d("AacTarget", "start：${mMediaRecorder.hashCode()}")
            mMediaRecorder.prepare()
            Log.d("AacTarget", "prepare")
            sendEvent(1)
        } catch (e: IOException) {
            Log.d("AacTarget", "prepare IOException:${e.message}")
        } catch (e: IllegalStateException) {
            Log.d("AacTarget", "prepare IllegalStateException:${e.message}")
        }
    }

    override fun start() {
        //  准备记录器以开始捕获和编码数据
        //  现在开始录制

        try {
            mMediaRecorder.start()
            sendEvent(2)
            Log.d("AacTarget", "start")
        } catch (e: IOException) {
            Log.d("AacTarget", "start IOException:${e.message}")
        } catch (e: IllegalStateException) {
            Log.d("AacTarget", "start IllegalStateException:${e.message}")
        }

    }

    override fun pause() {
        try {
            mMediaRecorder.pause()
            sendEvent(3)
        } catch (e: RuntimeException) {
            Log.d("AacTarget", "pause RuntimeException:${e.message}")
        } catch (e: IllegalStateException) {
            Log.d("AacTarget", "pause IllegalStateException:${e.message}")
        }
    }

    override fun resume() {
        try {
            mMediaRecorder.resume()
            sendEvent(2)
        } catch (e: RuntimeException) {
            Log.d("AacTarget", "resume RuntimeException:${e.message}")
        } catch (e: IllegalStateException) {
            Log.d("AacTarget", "resume IllegalStateException:${e.message}")
        }

    }

    override fun stop() {
        try {
            mMediaRecorder.stop()
            sendEvent(4)
        } catch (e: RuntimeException) {
            Log.d("AacTarget", "pause RuntimeException:${e.message}")
        } catch (e: IllegalStateException) {
            Log.d("AacTarget", "pause IllegalStateException:${e.message}")
        }
    }

    override fun close() {
        mMediaRecorder.reset()
    }
}