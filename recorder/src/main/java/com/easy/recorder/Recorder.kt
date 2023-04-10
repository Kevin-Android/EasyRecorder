package com.easy.recorder

import android.content.Context
import android.media.MediaRecorder
import java.io.File

class Recorder(
    private val builder: Builder
) {
    companion object {
        fun plugin(context: Context, rootPath: File): Builder {
            return Builder(context, rootPath)
        }
    }

    @JvmOverloads
    fun aac(
        sampleRate: String = "44100",
        numChannels: Int = 1,
        samplingRate: Int = MediaRecorder.OutputFormat.DEFAULT
    ): TargetManage {
        val aacAudioSource =
            AudioSourceFactory.provideAacAudioSource(sampleRate, numChannels, samplingRate)
        val audioTarget = AudioTargetFactory.getAudioTarget(builder.getRootPath(), aacAudioSource)
        return TargetManage(audioTarget)
    }

    fun wav(): TargetManage {
        val wavAudioSource = AudioSourceFactory.provideWavAudioSource()
        val audioTarget = AudioTargetFactory.getAudioTarget(builder.getRootPath(), wavAudioSource)
        return TargetManage(audioTarget)
    }


}