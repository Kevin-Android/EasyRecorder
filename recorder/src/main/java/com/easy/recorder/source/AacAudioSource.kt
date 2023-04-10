package com.easy.recorder.source

import android.media.MediaRecorder
import com.easy.recorder.base.BaseAudioSource

/**
 *    @author : 王康
 *    @date   : 2023/4/10
 *    @desc   :
 */
class AacAudioSource @JvmOverloads constructor(
    override var sampleRate: String = "44100",
    override var numChannels: Int = 1,
    var samplingRate: Int = MediaRecorder.OutputFormat.DEFAULT
) : BaseAudioSource()