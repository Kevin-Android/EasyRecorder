package com.kevin.easyaudiorecorder.util;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.provider.OpenableColumns;

import androidx.annotation.NonNull;

import java.io.File;

/**
 * @author : 王康
 * @date : 2021/9/14
 * @desc :
 */
public class EasyUtil {


    /**
     * 类名
     */
    public static final String CLASS = "class";
    /**
     * icon
     */
    public static final String ICON = "icon";

    /**
     * 通过ContentResolver获取文件大小
     *
     * @param resolver 内容解析器
     * @param uri      本地文件uri
     * @return 文件大小
     */
    public static long getFileUriSize(@NonNull ContentResolver resolver, Uri uri) {
        Cursor cursor = resolver.query(uri, null, null, null, null);
        if (cursor == null) {
            return 0;
        }
        int sizeIndex = cursor.getColumnIndex(OpenableColumns.SIZE);
        cursor.moveToFirst();
        long fileUriSize = cursor.getLong(sizeIndex);
        cursor.close();
        return fileUriSize;
    }

    public static boolean exists(File file) {
        if (file == null) {
            return false;
        }
        return file.exists();
    }

}
