package com.easy.recorder.source

import android.media.MediaRecorder
import com.easy.recorder.AudioSource

/**
 *    @author : 王康
 *    @date   : 2023/4/10
 *    @desc   :
 */
class AacAudioSource(
    var audioSamplingRate: Int = 44100,
    var audioChannels: Int = 1,
    var audioOutputFormat: Int = MediaRecorder.OutputFormat.DEFAULT,
    var audioEncoder: Int = MediaRecorder.AudioEncoder.DEFAULT,
    var audioEncodingBitRate: Int = 128000,
)