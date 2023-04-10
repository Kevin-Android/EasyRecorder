package com.easy.recorder

import com.easy.recorder.source.AacAudioSource
import com.easy.recorder.source.WaveAudioSource
import com.easy.recorder.work.AacWorkSource
import com.easy.recorder.work.WaveWorkSource
import java.io.File

/**
 *    @author : 王康
 *    @date   : 2023/4/9
 *    @desc   :
 */
class AudioWorkFactory {
    companion object {
        fun getTargetWorkSource(
            externalFilesDir: File?,
            audioSource: AacAudioSource
        ): AacWorkSource {
            return AacWorkSource(externalFilesDir, audioSource)
        }

        fun getTargetWorkSource(
            externalFilesDir: File?,
            audioSource: WaveAudioSource
        ): WaveWorkSource {
            return WaveWorkSource(externalFilesDir, audioSource)
        }

    }
}