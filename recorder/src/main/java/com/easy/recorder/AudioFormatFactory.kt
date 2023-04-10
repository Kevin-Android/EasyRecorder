package com.easy.recorder

import com.easy.recorder.source.AacAudioSource
import com.easy.recorder.source.WaveAudioSource
import java.io.File

/**
 *    @author : 王康
 *    @date   : 2023/4/10
 *    @desc   :
 */
class AudioFormatFactory {

    companion object {

        fun provideAacAudioSource(): AacAudioSource {
            return AacAudioSource()
        }

        fun provideWaveAudioSource(): WaveAudioSource {
            return WaveAudioSource("")
        }
    }


}