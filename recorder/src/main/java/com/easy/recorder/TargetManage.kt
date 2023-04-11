package com.easy.recorder

/**
 *    @author : 王康
 *    @date   : 2023/4/9
 *    @desc   :
 */
class TargetManage(private val audioTarget: AudioTarget) {

    init {
        audioTarget.load()
    }

    fun start() {
    }

    fun pause() {
    }

    fun stop() {
    }

    fun close() {
    }


}