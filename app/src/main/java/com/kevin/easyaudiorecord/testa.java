package com.kevin.easyaudiorecord;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;

import java.io.File;

/**
 * @author : 王康
 * @date : 2021/9/14
 * @desc :
 */
public class testa {
    public static void main(String[] args) {
        Uri uri = Uri.fromFile(new File(""));
        String string = uri.toString();
        System.out.println("string");
    }

    public static boolean checkURIResource(Context context, Uri uri) {
        Cursor cursor = context.getContentResolver().query(uri, null, null, null, null);
        boolean doesExist= (cursor != null && cursor.moveToFirst());
        if (cursor != null) {
            cursor.close();
        }
        return doesExist;

    }

}
