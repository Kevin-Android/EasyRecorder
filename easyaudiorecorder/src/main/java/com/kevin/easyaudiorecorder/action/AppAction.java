package com.kevin.easyaudiorecorder.action;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;

import com.kevin.easyaudiorecorder.util.EasyUtil;

import java.io.File;


/**
 * @author : 王康
 * @date : 2021/9/15
 * @desc :
 */
public interface AppAction {


    /**
     * 判断文件是否存在
     *
     * @param file 文件
     * @return 文件是否存在
     */
    default boolean exists(File file) {
        return EasyUtil.exists(file);
    }

    /**
     * 获取图标 Bitmap
     *
     * @param context 上下文
     * @return app icon
     */
    default Bitmap getAppBitmap(Context context) {
        PackageManager packageManager = null;
        ApplicationInfo applicationInfo;
        try {
            packageManager = context.getApplicationContext()
                    .getPackageManager();
            applicationInfo = packageManager.getApplicationInfo(
                    context.getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e) {
            applicationInfo = null;
        }
        if (applicationInfo == null) {
            return null;
        }
        //xxx根据自己的情况获取drawable
        Drawable drawable = packageManager.getApplicationIcon(applicationInfo);
        BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
        return bitmapDrawable.getBitmap();
    }

    /**
     * 获取图标 Drawable
     *
     * @param context 上下文
     * @return app icon
     */
    default Drawable getAppDrawable(Context context) {
        PackageManager packageManager = null;
        ApplicationInfo applicationInfo;
        try {
            packageManager = context.getApplicationContext()
                    .getPackageManager();
            applicationInfo = packageManager.getApplicationInfo(
                    context.getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e) {
            applicationInfo = null;
        }
        if (applicationInfo == null) {
            return null;
        }
        //xxx根据自己的情况获取drawable
        return packageManager.getApplicationIcon(applicationInfo);
    }





}
