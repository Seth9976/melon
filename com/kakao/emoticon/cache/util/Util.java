package com.kakao.emoticon.cache.util;

import android.annotation.TargetApi;
import android.graphics.Bitmap.Config;
import android.graphics.Bitmap;
import android.os.Looper;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Queue;

public final class Util {
    private static final char[] HEX_CHAR_ARRAY;
    private static final char[] SHA_1_CHARS;
    private static final char[] SHA_256_CHARS;

    static {
        Util.HEX_CHAR_ARRAY = "0123456789abcdef".toCharArray();
        Util.SHA_256_CHARS = new char[0x40];
        Util.SHA_1_CHARS = new char[40];
    }

    public static void assertBackgroundThread() {
        if(!Util.isOnBackgroundThread()) {
            throw new IllegalArgumentException("YOu must call this method on a background thread");
        }
    }

    public static void assertMainThread() {
        if(!Util.isOnMainThread()) {
            throw new IllegalArgumentException("You must call this method on the main thread");
        }
    }

    private static String bytesToHex(byte[] arr_b, char[] arr_c) {
        for(int v = 0; v < arr_b.length; ++v) {
            int v1 = arr_b[v];
            arr_c[v * 2] = Util.HEX_CHAR_ARRAY[(v1 & 0xFF) >>> 4];
            arr_c[v * 2 + 1] = Util.HEX_CHAR_ARRAY[v1 & 15];
        }
        return new String(arr_c);
    }

    public static Queue createQueue(int v) {
        return new ArrayDeque(v);
    }

    public static int getBitmapByteSize(int v, int v1, Bitmap.Config bitmap$Config0) {
        return v * v1 * Util.getBytesPerPixel(bitmap$Config0);
    }

    @TargetApi(19)
    public static int getBitmapByteSize(Bitmap bitmap0) {
        try {
            return bitmap0.getAllocationByteCount();
        }
        catch(NullPointerException unused_ex) {
            int v = bitmap0.getHeight();
            return bitmap0.getRowBytes() * v;
        }
    }

    private static int getBytesPerPixel(Bitmap.Config bitmap$Config0) {
        if(bitmap$Config0 == null) {
            bitmap$Config0 = Bitmap.Config.ARGB_8888;
        }
        switch(com.kakao.emoticon.cache.util.Util.1.$SwitchMap$android$graphics$Bitmap$Config[bitmap$Config0.ordinal()]) {
            case 1: 
            case 2: 
            case 3: {
                return 1;
            }
            default: {
                return 4;
            }
        }
    }

    @Deprecated
    public static int getSize(Bitmap bitmap0) {
        return Util.getBitmapByteSize(bitmap0);
    }

    public static List getSnapshot(Collection collection0) {
        List list0 = new ArrayList(collection0.size());
        for(Object object0: collection0) {
            ((ArrayList)list0).add(object0);
        }
        return list0;
    }

    public static boolean isOnBackgroundThread() {
        return !Util.isOnMainThread();
    }

    public static boolean isOnMainThread() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    public static String sha1BytesToHex(byte[] arr_b) {
        synchronized(Util.SHA_1_CHARS) {
        }
        return Util.bytesToHex(arr_b, Util.SHA_1_CHARS);
    }

    public static String sha256BytesToHex(byte[] arr_b) {
        synchronized(Util.SHA_256_CHARS) {
        }
        return Util.bytesToHex(arr_b, Util.SHA_256_CHARS);
    }

    class com.kakao.emoticon.cache.util.Util.1 {
        static final int[] $SwitchMap$android$graphics$Bitmap$Config;

        static {
            int[] arr_v = new int[Bitmap.Config.values().length];
            com.kakao.emoticon.cache.util.Util.1.$SwitchMap$android$graphics$Bitmap$Config = arr_v;
            try {
                arr_v[Bitmap.Config.ALPHA_8.ordinal()] = 1;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                com.kakao.emoticon.cache.util.Util.1.$SwitchMap$android$graphics$Bitmap$Config[Bitmap.Config.RGB_565.ordinal()] = 2;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                com.kakao.emoticon.cache.util.Util.1.$SwitchMap$android$graphics$Bitmap$Config[Bitmap.Config.ARGB_4444.ordinal()] = 3;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                com.kakao.emoticon.cache.util.Util.1.$SwitchMap$android$graphics$Bitmap$Config[Bitmap.Config.ARGB_8888.ordinal()] = 4;
            }
            catch(NoSuchFieldError unused_ex) {
            }
        }
    }

}

