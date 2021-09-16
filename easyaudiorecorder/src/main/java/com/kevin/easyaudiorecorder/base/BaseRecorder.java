package com.kevin.easyaudiorecorder.base;

import android.app.Activity;
import android.content.ContentResolver;
import android.net.Uri;

import androidx.annotation.NonNull;
import androidx.lifecycle.LifecycleOwner;

import com.kevin.easyaudiorecorder.action.AndroidVersionAction;
import com.kevin.easyaudiorecorder.audio.EasyAudioRecorderConfig;

import java.io.File;

/**
 * @author : 王康
 * @date : 2021/9/14
 * @desc :
 */
@SuppressWarnings("unchecked")
public abstract class BaseRecorder<T extends BaseRecorder<?>>
        implements AndroidVersionAction {

    private final LifecycleOwner mLifecycleOwner;
    private ContentResolver mResolver;
    private File mPath;


    public BaseRecorder(LifecycleOwner lifecycleOwner) {
        if (lifecycleOwner == null) {
            throw new IllegalArgumentException("are you ok?");
        }
        mLifecycleOwner = lifecycleOwner;
    }


    /**
     * @param resolver 内容解析器
     * @param path     本地资源Uri
     */
    public T path(@NonNull ContentResolver resolver, File path) {
        mResolver = resolver;
        mPath = path;
        return (T) this;
    }


    public LifecycleOwner getLifecycleOwner() {
        return mLifecycleOwner;
    }

    public ContentResolver getContentResolver() {
        return mResolver;
    }

    /**
     * 获取录制文件的 地址
     *
     * @return 录制音频文件的 目录
     */
    public File getPath() {
        return mPath;
    }


}


