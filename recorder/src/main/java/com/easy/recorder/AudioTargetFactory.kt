package com.easy.recorder

import com.easy.recorder.source.AacAudioSource
import com.easy.recorder.source.WaveAudioSource
import com.easy.recorder.target.AacTarget
import com.easy.recorder.target.WavTarget
import java.io.File

/**
 *    @author : 王康
 *    @date   : 2023/4/9
 *    @desc   :
 */
class AudioTargetFactory {
    companion object {
        fun getAudioTarget(
            externalFilesDir: File,
            audioSource: AacAudioSource
        ): AacTarget {
            return AacTarget(externalFilesDir, audioSource)
        }

        fun getAudioTarget(
            externalFilesDir: File?,
            audioSource: WaveAudioSource
        ): WavTarget {
            return WavTarget(externalFilesDir, audioSource)
        }

    }
}