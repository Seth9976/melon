package com.bumptech.glide.util;

import android.annotation.TargetApi;
import android.graphics.Bitmap.Config;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import com.bumptech.glide.load.model.Model;
import com.bumptech.glide.request.BaseRequestOptions;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Queue;

public final class Util {
    private static final int HASH_ACCUMULATOR = 17;
    private static final int HASH_MULTIPLIER = 0x1F;
    private static final char[] HEX_CHAR_ARRAY;
    private static final char[] SHA_256_CHARS;
    private static volatile Handler mainThreadHandler;

    static {
        Util.HEX_CHAR_ARRAY = "0123456789abcdef".toCharArray();
        Util.SHA_256_CHARS = new char[0x40];
    }

    public static void assertBackgroundThread() {
        if(!Util.isOnBackgroundThread()) {
            throw new IllegalArgumentException("You must call this method on a background thread");
        }
    }

    public static void assertMainThread() {
        if(!Util.isOnMainThread()) {
            throw new IllegalArgumentException("You must call this method on the main thread");
        }
    }

    public static boolean bothBaseRequestOptionsNullEquivalentOrEquals(BaseRequestOptions baseRequestOptions0, BaseRequestOptions baseRequestOptions1) {
        return baseRequestOptions0 == null ? baseRequestOptions1 == null : baseRequestOptions0.isEquivalentTo(baseRequestOptions1);
    }

    public static boolean bothModelsNullEquivalentOrEquals(Object object0, Object object1) {
        if(object0 == null) {
            return object1 == null;
        }
        return object0 instanceof Model ? ((Model)object0).isEquivalentTo(object1) : object0.equals(object1);
    }

    public static boolean bothNullOrEqual(Object object0, Object object1) {
        return object0 == null ? object1 == null : object0.equals(object1);
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
        return Util.getBytesPerPixel(bitmap$Config0) * (v * v1);
    }

    @TargetApi(19)
    public static int getBitmapByteSize(Bitmap bitmap0) {
        if(!bitmap0.isRecycled()) {
            try {
                return bitmap0.getAllocationByteCount();
            }
            catch(NullPointerException unused_ex) {
                int v = bitmap0.getHeight();
                return bitmap0.getRowBytes() * v;
            }
        }
        throw new IllegalStateException("Cannot obtain size for recycled Bitmap: " + bitmap0 + "[" + bitmap0.getWidth() + "x" + bitmap0.getHeight() + "] " + bitmap0.getConfig());
    }

    public static int getBytesPerPixel(Bitmap.Config bitmap$Config0) [...] // 潜在的解密器

    @Deprecated
    public static int getSize(Bitmap bitmap0) {
        return Util.getBitmapByteSize(bitmap0);
    }

    public static List getSnapshot(Collection collection0) {
        List list0 = new ArrayList(collection0.size());
        for(Object object0: collection0) {
            if(object0 != null) {
                ((ArrayList)list0).add(object0);
            }
        }
        return list0;
    }

    private static Handler getUiThreadHandler() {
        if(Util.mainThreadHandler == null) {
            Class class0 = Util.class;
            synchronized(class0) {
                if(Util.mainThreadHandler == null) {
                    Util.mainThreadHandler = new Handler(Looper.getMainLooper());
                }
            }
        }
        return Util.mainThreadHandler;
    }

    public static int hashCode(float f) {
        return Util.hashCode(f, 17);
    }

    public static int hashCode(float f, int v) {
        return v * 0x1F + Float.floatToIntBits(f);
    }

    public static int hashCode(int v) {
        return v + 0x20F;
    }

    public static int hashCode(int v, int v1) [...] // Inlined contents

    public static int hashCode(Object object0, int v) {
        return object0 == null ? v * 0x1F : v * 0x1F + object0.hashCode();
    }

    public static int hashCode(boolean z) {
        return Util.hashCode(z, 17);
    }

    public static int hashCode(boolean z, int v) {
        return v * 0x1F + ((int)z);
    }

    public static boolean isOnBackgroundThread() {
        return !Util.isOnMainThread();
    }

    public static boolean isOnMainThread() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    public static boolean isValidDimension(int v) {
        return v > 0 || v == 0x80000000;
    }

    // 去混淆评级： 低(20)
    public static boolean isValidDimensions(int v, int v1) {
        return Util.isValidDimension(v) && Util.isValidDimension(v1);
    }

    public static void postOnUiThread(Runnable runnable0) {
        Util.getUiThreadHandler().post(runnable0);
    }

    public static void removeCallbacksOnUiThread(Runnable runnable0) {
        Util.getUiThreadHandler().removeCallbacks(runnable0);
    }

    public static String sha256BytesToHex(byte[] arr_b) {
        synchronized(Util.SHA_256_CHARS) {
        }
        return Util.bytesToHex(arr_b, Util.SHA_256_CHARS);
    }

    class com.bumptech.glide.util.Util.1 {
        static final int[] $SwitchMap$android$graphics$Bitmap$Config;

        static {
            int[] arr_v = new int[Bitmap.Config.values().length];
            com.bumptech.glide.util.Util.1.$SwitchMap$android$graphics$Bitmap$Config = arr_v;
            try {
                arr_v[Bitmap.Config.ALPHA_8.ordinal()] = 1;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                com.bumptech.glide.util.Util.1.$SwitchMap$android$graphics$Bitmap$Config[Bitmap.Config.RGB_565.ordinal()] = 2;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                com.bumptech.glide.util.Util.1.$SwitchMap$android$graphics$Bitmap$Config[Bitmap.Config.ARGB_4444.ordinal()] = 3;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                com.bumptech.glide.util.Util.1.$SwitchMap$android$graphics$Bitmap$Config[Bitmap.Config.RGBA_F16.ordinal()] = 4;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                com.bumptech.glide.util.Util.1.$SwitchMap$android$graphics$Bitmap$Config[Bitmap.Config.ARGB_8888.ordinal()] = 5;
            }
            catch(NoSuchFieldError unused_ex) {
            }
        }
    }

}

