package com.easy.recorder

import android.content.Context
import com.easy.recorder.work.AacWorkSource

/**
 * @author  康康
 * @date    2023/4/9
 * @desc    录音
 */
class Recorder(
    private val builder: Builder
) {


    companion object {
        fun plugin(context: Context): Builder {
            return Builder(context)
        }
    }

    fun aac(): AacWorkSource {
        val aacAudioSource = AudioFormatFactory.provideAacAudioSource()
        val targetWorkSource =
            AudioWorkFactory.getTargetWorkSource(builder.getRootPath(), aacAudioSource)
        return AudioWorkFactory.getTargetWorkSource(builder.getRootPath(), aacAudioSource)
    }

}