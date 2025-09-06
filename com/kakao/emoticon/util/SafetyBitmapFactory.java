package com.kakao.emoticon.util;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.graphics.BitmapFactory;

public class SafetyBitmapFactory {
    public static Bitmap decodeByteArray(byte[] arr_b, int v) {
        BitmapFactory.Options bitmapFactory$Options0 = new BitmapFactory.Options();
        int v1 = 1;
        while(true) {
            bitmapFactory$Options0.inSampleSize = v1;
            if(bitmapFactory$Options0.inSampleSize > 8) {
                break;
            }
            try {
                return BitmapFactory.decodeByteArray(arr_b, 0, v, bitmapFactory$Options0);
            }
            catch(OutOfMemoryError unused_ex) {
                stringBuilder0.toString();
                v1 = bitmapFactory$Options0.inSampleSize * 2;
            }
        }
        return null;
    }

    public static Bitmap decodeFile(String s) {
        BitmapFactory.Options bitmapFactory$Options0 = new BitmapFactory.Options();
        int v = 1;
        while(true) {
            bitmapFactory$Options0.inSampleSize = v;
            if(bitmapFactory$Options0.inSampleSize > 8) {
                break;
            }
            try {
                return BitmapFactory.decodeFile(s, bitmapFactory$Options0);
            }
            catch(OutOfMemoryError unused_ex) {
                stringBuilder0.toString();
                v = bitmapFactory$Options0.inSampleSize * 2;
            }
        }
        return null;
    }
}

