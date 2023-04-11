package com.kevin.easyrecorder

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.provider.Settings
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.easy.recorder.*
import com.easy.recorder.listener.OnRecorderListener
import com.kevin.easyrecorder.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val tag = "MainActivity"
    private lateinit var binding: ActivityMainBinding
    private var status = 1
    //
    private lateinit var targetManage: TargetManage
    private val mRequestCode: Int = Manifest.permission.RECORD_AUDIO.hashCode()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binds()

    }


    /**
     * 绑定空间事件
     */
    private fun binds() {
        binding.applyBut.setOnClickListener {
            val checkSelfPermission = checkSelfPermission(Manifest.permission.RECORD_AUDIO)
            if (PackageManager.PERMISSION_GRANTED == checkSelfPermission) {
                Log.d(tag, "已经有权限了")
                initRecorder()
            } else {
                val arrayOf = arrayOf(Manifest.permission.RECORD_AUDIO)
                requestPermissions(arrayOf, mRequestCode)
            }
        }

        binding.start.setOnClickListener {
            when (status) {
                PREPARE -> {
                    targetManage.prepare()
                    targetManage.start()
                }
                RECORDING -> targetManage.pause()
                PAUSE -> targetManage.resume()
            }
        }

        binding.stop.setOnClickListener {
            targetManage.stop()
        }


    }

    private fun initRecorder() {
        Toast.makeText(this, "已经获取录音权限了", Toast.LENGTH_SHORT).show()
        val recorder = Recorder.plugin(this).build().aac()
        targetManage.listener(object : OnRecorderListener {
            override fun onRecorderStatus(status: Int) {
                this@MainActivity.status = status
                when (status) {
                    PREPARE -> {
                        binding.start.text = "开始录音"
                        binding.stop.visibility = View.GONE
                    }
                    RECORDING -> {
                        binding.start.text = "暂停录音"
                        binding.stop.visibility = View.VISIBLE
                    }
                    PAUSE -> {
                        binding.start.text = "继续录音"
                        binding.stop.visibility = View.VISIBLE
                    }
                    STOP -> {
                        binding.start.text = "开始录音"
                        binding.stop.visibility = View.GONE
                    }

                }
            }
        })
        binding.start.visibility = View.VISIBLE

    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        Log.d(tag, "$requestCode $mRequestCode")
        if (mRequestCode == requestCode) {
            val i = grantResults[0]
            if (i == PackageManager.PERMISSION_GRANTED) {
                initRecorder()
            } else {
                if (!shouldShowRequestPermissionRationale(permissions[0])) {
                    Toast.makeText(this, "无法获取录音权限讲不能录音", Toast.LENGTH_SHORT).show()
                    startApplicationSet()
                } else {
                    Toast.makeText(this, "拒绝了权限授权", Toast.LENGTH_SHORT).show()
                }
            }


        }

    }

    private fun startApplicationSet() {
        val intent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS)
        val uri: Uri = Uri.fromParts("package", packageName, null)
        intent.data = uri
        startActivity(intent)
    }

}