package com.kevin.easyrecorder

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import com.kevin.easyrecorder.databinding.ActivityHomeBinding
import com.kevin.easyrecorder.databinding.ActivityMainBinding

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binds()
    }

    private fun binds() {
        binding.goRecordingBut.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }

    }
}