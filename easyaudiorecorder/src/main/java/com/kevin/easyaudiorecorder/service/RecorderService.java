package com.kevin.easyaudiorecorder.service;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.graphics.Color;
import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.DrawableRes;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import com.kevin.easyaudiorecorder.action.AndroidVersionAction;
import com.kevin.easyaudiorecorder.action.AppAction;
import com.kevin.easyaudiorecorder.util.EasyUtil;

import java.io.Serializable;

/**
 * @author : 王康
 * @date : 2021/9/15
 * @desc :
 */
public class RecorderService extends Service
        implements AppAction, AndroidVersionAction {


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d("RecorderService", "执行了 onStartCommand()");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("RecorderService", "执行了 onCreate()");
        Intent intent = new Intent(this, ServiceB.class);
        startService(intent);
    }


    @RequiresApi(api = Build.VERSION_CODES.O)
    private NotificationChannel getNotificationChannel(String id, CharSequence name, String description, int importance) {
        //构建NotificationChannel实例
        NotificationChannel notificationChannel = new NotificationChannel(id, name, importance);
        //配置通知渠道的属性
        notificationChannel.setDescription(description);
        //设置通知出现时的闪光灯
        notificationChannel.enableLights(true);
        notificationChannel.setLightColor(Color.RED);
        //设置通知出现时的震动
        notificationChannel.enableVibration(true);
        notificationChannel.setVibrationPattern(new long[]{100, 200, 300, 400, 500, 400, 300, 200, 100});
        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        //在notificationManager中创建通知渠道
        notificationManager.createNotificationChannel(notificationChannel);
        return notificationChannel;
    }


    /**
     * 获取Notification.Builder
     *
     * @return Notification.Builder
     */
    private Notification.Builder getNotificationBuilder() {
        if (isAndroid8()) {
            //新建Builder对象
            NotificationChannel notificationChannel = getNotificationChannel("kevin", "录音", "您开启了录音", NotificationManager.IMPORTANCE_HIGH);
            return new Notification.Builder(this, "kevin");
        } else {
            return new Notification.Builder(this);
        }

    }


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.d("RecorderService", "执行了 onBind()");

        return null;
    }


    //新建一个子类继承自Binder类
    public static class MyBinder extends Binder {

        public void service_connect_Activity() {
            System.out.println("Service关联了Activity,并在Activity执行了Service的方法");

        }
    }


    public static void startRecording(Context context, ServiceConnection connection) {
        Log.d("RecorderService", "执行了 startRecording()");
        Intent intent = new Intent(context, RecorderService.class);
        context.bindService(intent, connection, BIND_AUTO_CREATE);
    }


}
