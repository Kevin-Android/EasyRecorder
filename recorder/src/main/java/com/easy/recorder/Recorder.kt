package com.easy.recorder

import android.content.Context
import android.media.MediaRecorder

class Recorder(
    private val builder: Builder
) {
    companion object {
        fun plugin(context: Context): Builder {
            return Builder(context)
        }
    }

    @JvmOverloads
    fun aac(
        sampleRate: Int = 44100,
        numChannels: Int = 1,
        samplingRate: Int = MediaRecorder.OutputFormat.DEFAULT
    ): TargetManage {
        val aacAudioSource =
            AudioSourceFactory.provideAacAudioSource(sampleRate, numChannels, samplingRate)
        val audioTarget = AudioTargetFactory.getAudioTarget(builder, aacAudioSource)
        return TargetManage(audioTarget)
    }

}