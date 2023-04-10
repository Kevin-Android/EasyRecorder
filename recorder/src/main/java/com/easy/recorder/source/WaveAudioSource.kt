package com.easy.recorder.source

import com.easy.recorder.AudioSource

/**
 *    @author : 王康
 *    @date   : 2023/4/10
 *    @desc   :
 */
class WaveAudioSource(
    override var sampleRate: String = "44100",
    override var numChannels: Int = 1,
) : AudioSource() {


}