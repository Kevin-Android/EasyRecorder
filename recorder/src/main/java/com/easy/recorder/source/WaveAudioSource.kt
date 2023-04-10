package com.easy.recorder.source

import android.media.AudioRecord
import android.media.MediaRecorder
import com.easy.recorder.base.BaseAudioSource

/**
 *    @author : 王康
 *    @date   : 2023/4/10
 *    @desc   :
 */
class WaveAudioSource(
    override var sampleRate: String = "44100",
    override var numChannels: Int = 1,
) : BaseAudioSource() {


}