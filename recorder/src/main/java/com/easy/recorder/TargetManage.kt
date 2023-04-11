package com.easy.recorder

import com.easy.recorder.listener.OnRecorderListener

/**
 *    @author : 王康
 *    @date   : 2023/4/9
 *    @desc   :
 */
class TargetManage(private val audioTarget: AudioTarget) {

    init {
        audioTarget.load()
    }

    fun prepare() {
        audioTarget.prepare()
    }


    fun start() {
        audioTarget.start()
    }

    fun listener(onRecorderListener: OnRecorderListener) {
        audioTarget.listener(onRecorderListener)
    }


    fun pause() {
        audioTarget.pause()
    }

    fun resume() {
        audioTarget.resume()
    }

    fun stop() {
        audioTarget.stop()
    }

    fun close() {
        audioTarget.
    }


}