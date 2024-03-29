package com.easy.recorder

import android.media.MediaRecorder
import com.easy.recorder.source.AacAudioSource
import com.easy.recorder.source.WaveAudioSource

/**
 *    @author : 王康
 *    @date   : 2023/4/10
 *    @desc   :
 */
class AudioSourceFactory {

    companion object {

        fun provideAacAudioSource(
            sampleRate: Int,
            numChannels: Int,
            samplingRate: Int
        ): AacAudioSource {
            return AacAudioSource(sampleRate, numChannels, samplingRate)
        }

        fun provideWavAudioSource(
            sampleRate: Int = 44100,
            numChannels: Int = 1,
            samplingRate: Int = MediaRecorder.OutputFormat.DEFAULT
        ): WaveAudioSource {
            return WaveAudioSource()
        }
    }


}