package com.easy.recorder

import android.content.Context
import android.media.MediaRecorder
import android.os.Environment
import java.io.File

/**
 *    @author : 王康
 *    @date   : 2023/4/10
 *    @desc   :
 */
class Builder(private val context: Context) {

    var rootPath = context.getExternalFilesDir("recording")

    fun getContext(): Context {
        return context
    }

    fun setRootPath(filePath: File): Builder {
        rootPath = filePath
        return this
    }


    fun build(): Recorder {
        return Recorder(this)
    }

}