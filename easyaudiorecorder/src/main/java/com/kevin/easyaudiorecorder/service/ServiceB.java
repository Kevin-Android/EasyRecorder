package com.kevin.easyaudiorecorder.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

/**
 * @author : 王康
 * @date : 2021/9/15
 * @desc :
 */
public class ServiceB extends Service {

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("ServiceB", "执行了 onCreate()");

    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
