package com.kevin.easyaudiorecord.ui.home;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;

import com.kevin.easyaudiorecord.R;
import com.kevin.easyaudiorecorder.EasyRecorder;
import com.kevin.easyaudiorecorder.audio.EasyAudioRecorder;
import com.kevin.easyaudiorecorder.audio.EasyAudioRecorderConfig;
import com.kevin.easyaudiorecorder.io.FileContentResolver;
import com.kevin.easyaudiorecorder.service.RecorderService;

import java.io.File;
import java.net.URI;

public class RecorderActivity extends AppCompatActivity {


    /**
     * 创建 ServiceConnection 的匿名类
     */
    private final ServiceConnection connection = new ServiceConnection() {

        //重写onServiceConnected()方法和onServiceDisconnected()方法
        //在Activity与Service建立关联和解除关联的时候调用
        @Override
        public void onServiceDisconnected(ComponentName name) {
        }

        //在Activity与Service解除关联的时候调用
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            //实例化Service的内部类myBinder
            //通过向下转型得到了MyBinder的实例
            RecorderService.MyBinder binder = (RecorderService.MyBinder) service;
            //在Activity调用Service类的方法
            binder.service_connect_Activity();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recorder);
        File file = new File(getExternalFilesDir("records"), "520.wav");
        AVAudioRecorder a =     AVAudioRecorder.init();
        a.pa


    }

    public void onBindClick(View view) {
        EasyAudioRecorderConfig easyAudioRecorderConfig = new EasyAudioRecorderConfig();
        EasyAudioRecorder easyAudioRecorder = EasyRecorder.audio(this)
                .config(easyAudioRecorderConfig)
                .path(getContentResolver(), new File(""));
        boolean prepare = easyAudioRecorder.prepareToRecord();
        if (prepare){
            boolean record = easyAudioRecorder.record();
        }

    }
}