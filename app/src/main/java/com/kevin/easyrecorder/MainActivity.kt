package com.kevin.easyrecorder

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.easy.recorder.Recorder
import java.io.File

class MainActivity : AppCompatActivity() {
    private val file: File?
        get() {
            return getExternalFilesDir("recording")
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val externalFilesDir = file
        if (externalFilesDir != null) {
            if (externalFilesDir.exists()){
                val aac = Recorder.plugin(this, externalFilesDir).build().aac()
            }

        }


    }
}