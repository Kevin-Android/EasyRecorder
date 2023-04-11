package com.easy.recorder

import com.easy.recorder.source.AacAudioSource
import java.io.File

/**
 *    @author : 王康
 *    @date   : 2023/4/11
 *    @desc   :
 */
class AudioFileUtil {

    companion object {

        fun createAacFile(rootPath: File): File {
            val fileName =
                "3gp_${System.currentTimeMillis()}.3gp"
            val file = File(rootPath, fileName)
            if (!file.createNewFile()) {
                throw IllegalStateException("Failed to create file, path: ${file.absolutePath}")
            }
            return File(rootPath, fileName)
        }


    }

}