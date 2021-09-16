package com.kevin.easyaudiorecorder.action;

import android.annotation.SuppressLint;
import android.os.Build;


/**
 * @author : 王康
 * @date : 2021/6/19
 * @desc :
 */
public interface AndroidVersionAction {

    /**
     * 是否是 Android 11 及以上版本
     *
     * @return boolean
     */
    default boolean isAndroid11() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.R;
    }

    /**
     * 是否是 Android 10 及以上版本
     *
     * @return boolean
     */
    default boolean isAndroid10() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q;
    }

    /**
     * 是否是 Android 9.0 及以上版本
     *
     * @return boolean
     */
    default boolean isAndroid9() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.P;
    }

    /**
     * 是否是 Android 8.0 及以上版本
     *
     * @return boolean
     */
    default boolean isAndroid8() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.O;
    }

    /**
     * 是否是 Android 7.0 及以上版本
     *
     * @return boolean
     */
    default boolean isAndroid7() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.N;
    }

    /**
     * 是否是 Android 6.0 及以上版本
     *
     * @return boolean
     */
    default boolean isAndroid6() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.M;
    }

    /**
     * 获取android 版本
     *
     * @return 安卓版本
     */
    default String getAndroidVersion() {
        if (isAndroid11()) {
            return "Android 11";
        } else if (isAndroid10()) {
            return "Android 10";
        } else if (isAndroid9()) {
            return "Android 9";
        } else if (isAndroid8()) {
            return "Android 8";
        } else if (isAndroid7()) {
            return "Android 7";
        } else if (isAndroid6()) {
            return "Android 6";
        } else {
            return "Android 5";
        }
    }
}
