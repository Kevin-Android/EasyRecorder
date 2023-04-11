package com.easy.recorder

import com.easy.recorder.source.AacAudioSource
import com.easy.recorder.source.WaveAudioSource
import com.easy.recorder.target.AacTarget
import com.easy.recorder.target.WavTarget

/**
 *    @author : 王康
 *    @date   : 2023/4/9
 *    @desc   :
 */
class AudioTargetFactory {
    companion object {
        fun getAudioTarget(
            builder: Builder,
            audioSource: AacAudioSource
        ): AacTarget {
            return AacTarget(builder, audioSource)
        }

        fun getAudioTarget(
            builder: Builder,
            audioSource: WaveAudioSource
        ): WavTarget {
            return WavTarget(builder, audioSource)
        }

    }
}