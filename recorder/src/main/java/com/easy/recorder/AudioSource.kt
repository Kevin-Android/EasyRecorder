package com.easy.recorder

/**
 *    @author : 王康
 *    @date   : 2023/4/10
 *    @desc   :
 */
abstract class  AudioSource {
    abstract var sampleRate: Int
    abstract var numChannels: Int
}