package com.kevin.easyaudiorecorder.audio;

import androidx.lifecycle.LifecycleOwner;

import com.kevin.easyaudiorecorder.action.RecorderAction;
import com.kevin.easyaudiorecorder.base.BaseRecorder;
import com.kevin.easyaudiorecorder.io.FileContentResolver;

import java.io.File;


/**
 * @author : 王康
 * @date : 2021/9/14
 * @desc : 录音管理类
 */
public final class EasyAudioRecorder extends BaseRecorder<EasyAudioRecorder>
        implements RecorderAction {

    private EasyAudioRecorderConfig mEasyAudioRecorderConfig;

    public EasyAudioRecorder(LifecycleOwner lifecycleOwner) {
        super(lifecycleOwner);
    }


    /**
     * @param easyAudioRecorderConfig 录音配置
     */
    public EasyAudioRecorder config(EasyAudioRecorderConfig easyAudioRecorderConfig) {
        mEasyAudioRecorderConfig = easyAudioRecorderConfig;
        return this;
    }

    /**
     * 获取录音配置(这些设置只有在调用 prepareToRecord 时才完全有效)
     *
     * @return 录音配置
     */
    public EasyAudioRecorderConfig getEasyAudioRecorderConfig() {
        return mEasyAudioRecorderConfig;
    }


    @Override
    public boolean prepareToRecord() {
        if (getPath()==null){
            return false;
        }

        if (!getPath().exists()){
            if (getPath().mkdirs()){
                if (!getPath().isDirectory()){
                    return false;
                }
            }else {
                return false;
            }
        }else {
            if (!getPath().isDirectory()){
                return false;
            }
        }

        return false;
    }

    @Override
    public boolean record() {
        return false;
    }

    @Override
    public boolean recordAtTime(long atTime) {
        return false;
    }

    @Override
    public boolean recordForDuration(long forDuration) {
        return false;
    }

    @Override
    public boolean recordAtTimeAndForDuration(long atTime, long forDuration) {
        return false;
    }

    @Override
    public void pause() {

    }

    @Override
    public void stop() {

    }

    @Override
    public boolean deleteRecording() {
        return false;
    }

    @Override
    public boolean isRecording() {
        return false;
    }

    @Override
    public long getCurrentTime() {
        return 0;
    }
}