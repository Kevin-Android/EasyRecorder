package com.kevin.easyrecorder

import android.media.AudioRecord
import android.media.MediaRecorder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.easy.recorder.AudioFormatFactory
import com.easy.recorder.Recorder

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recorder = Recorder.plugin(this).setRootPath("abc").build()
        val aac = recorder.aac()


    }
}