package com.kevin.easyaudiorecorder;

import androidx.lifecycle.LifecycleOwner;

import com.kevin.easyaudiorecorder.audio.EasyAudioRecorder;

/**
 * @author : 王康
 * @date : 2021/9/15
 * @desc :
 */
public class EasyRecorder {

    public static EasyAudioRecorder audio(LifecycleOwner lifecycleOwner) {
        return new EasyAudioRecorder(lifecycleOwner);
    }

}
