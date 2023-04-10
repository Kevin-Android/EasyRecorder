package com.easy.recorder.target

import android.util.Log
import com.easy.recorder.source.AacAudioSource
import com.easy.recorder.AudioTarget
import java.io.File

/**
 *    @author : 王康
 *    @date   : 2023/4/10
 *    @desc   :
 */
class AacTarget(private val externalFilesDir: File, private val audioSource: AacAudioSource) :
    AudioTarget() {

    private val tag = "AacWorkSource"
    override fun load() {
        Log.d(tag, "load")
        Log.d(tag, externalFilesDir.absolutePath + "")
        Log.d(tag, audioSource.sampleRate + "")
    }

    override fun start() {
        TODO("Not yet implemented")
    }

    override fun pause() {
        TODO("Not yet implemented")
    }

    override fun stop() {
        TODO("Not yet implemented")
    }

    override fun close() {
        TODO("Not yet implemented")
    }
}