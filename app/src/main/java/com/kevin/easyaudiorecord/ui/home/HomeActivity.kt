package com.kevin.easyaudiorecord.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.kevin.easyaudiorecord.databinding.HomeActivityBinding

class HomeActivity : AppCompatActivity(), View.OnClickListener {


    private val binding by lazy {
        title = "首页"
        HomeActivityBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
//        RecorderService.startRecording(this, HomeActivity::class.java, R.mipmap.ic_launcher)
    }


    override fun onClick(v: View?) {
        TODO("Not yet implemented")
    }


}