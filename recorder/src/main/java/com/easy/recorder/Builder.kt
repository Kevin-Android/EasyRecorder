package com.easy.recorder

import android.content.Context
import android.media.MediaRecorder
import java.io.File

/**
 *    @author : 王康
 *    @date   : 2023/4/10
 *    @desc   :
 */
class Builder(private val context: Context, private val rootPath: File) {

    fun getRootPath(): File {
        return rootPath
    }

    fun build(): Recorder {
        return Recorder(this)
    }

}