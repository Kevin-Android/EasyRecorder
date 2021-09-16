package com.kevin.easyaudiorecorder.base;

/**
 * @author : 王康
 * @date : 2021/9/15
 * @desc :
 */
public final class RecorderHelper {
    private static volatile RecorderHelper helper;

    public static RecorderHelper getInstance() {
        if (helper == null) {
            // 当前没有初始化配置
            throw new IllegalStateException("You haven't initialized the configuration yet");
        }
        return helper;
    }
}
