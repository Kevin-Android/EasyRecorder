package com.easy.recorder.data

import java.io.File

/**
 *    @author : 王康
 *    @date   : 2023/4/10
 *    @desc   :
 */
data class AudioConfig @JvmOverloads constructor(
    val file: File,
    var numChannels: Int = 1
)