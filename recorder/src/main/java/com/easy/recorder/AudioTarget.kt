package com.easy.recorder

import com.easy.recorder.listener.OnRecorderListener

open class AudioTarget {

    open fun load() {

    }

    open fun prepare(){

    }

    open fun start() {

    }

    open fun pause() {

    }

    open fun resume() {

    }

    open fun stop() {

    }

    open fun close() {

    }

    open fun listener(onRecorderListener: OnRecorderListener) {
    }

}