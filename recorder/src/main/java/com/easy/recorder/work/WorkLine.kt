package com.easy.recorder.work

/**
 *    @author : 王康
 *    @date   : 2023/4/10
 *    @desc   :
 */
abstract class WorkLine {
    abstract fun open()
    abstract fun start()
    abstract fun pause()
    abstract fun stop()
    abstract fun close()
}