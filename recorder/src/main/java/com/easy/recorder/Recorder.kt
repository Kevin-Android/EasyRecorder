package com.easy.recorder

import android.content.Context
import android.media.MediaRecorder
import java.io.File
import java.util.Objects

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

    fun wav(): TargetManage {
        val wavAudioSource = AudioSourceFactory.provideWavAudioSource()
        val audioTarget = AudioTargetFactory.getAudioTarget(builder, wavAudioSource)
        return TargetManage(audioTarget)
    }

}