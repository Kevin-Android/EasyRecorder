package com.easy.recorder

import android.content.Context
import android.media.MediaRecorder
import java.io.File

/**
 *    @author : 王康
 *    @date   : 2023/4/10
 *    @desc   :
 */
class Builder(private val context: Context) {

    private var rootPath = context.getExternalFilesDir("recording")

    fun setRootPath(path: String): Builder {
        rootPath = context.getExternalFilesDir(path)
        return this
    }

    fun getRootPath(): File? {
        return rootPath
    }

    fun build(): Recorder {
        return Recorder(this)
    }

}