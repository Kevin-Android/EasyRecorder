package com.easy.recorder

import android.media.MediaRecorder

/**
 *    @author : 王康
 *    @date   : 2023/4/9
 *    @desc   :
 */
class AudioFileFormat {

    enum class Type {
        WAVE, AAC;
    }

    enum class AacAudioEncoder(aac: Int) {
        AAC(MediaRecorder.AudioEncoder.AAC),
        AAC_ELD(MediaRecorder.AudioEncoder.AAC_ELD),
        HE_AAC(MediaRecorder.AudioEncoder.HE_AAC)
    }



    fun create(type: Type) {
    }



}