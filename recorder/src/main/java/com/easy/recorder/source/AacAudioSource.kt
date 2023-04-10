package com.easy.recorder.source

import android.media.MediaRecorder
import com.easy.recorder.AudioSource

/**
 *    @author : 王康
 *    @date   : 2023/4/10
 *    @desc   :
 */
class AacAudioSource(
    override var sampleRate: String = "44100",
    override var numChannels: Int = 1,
    var samplingRate: Int = MediaRecorder.OutputFormat.DEFAULT
) : AudioSource()