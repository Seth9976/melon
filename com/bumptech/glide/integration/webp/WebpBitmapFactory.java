package com.bumptech.glide.integration.webp;

import android.content.res.Resources;
import android.graphics.Bitmap.Config;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.util.Log;
import android.util.TypedValue;
import androidx.annotation.Keep;
import java.io.BufferedInputStream;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

@Keep
public class WebpBitmapFactory {
    private static final int IN_TEMP_BUFFER_SIZE = 0x2000;
    private static final int MAX_WEBP_HEADER_SIZE = 21;
    public static boolean sUseSystemDecoder = true;

    static {
        System.loadLibrary("glide-webp");
    }

    @Keep
    private static Bitmap createBitmap(int v, int v1, BitmapFactory.Options bitmapFactory$Options0) {
        if(bitmapFactory$Options0 != null && (bitmapFactory$Options0.inBitmap != null && bitmapFactory$Options0.inBitmap.isMutable())) {
            Bitmap bitmap0 = bitmapFactory$Options0.inBitmap;
            if(bitmap0.getWidth() == v && bitmap0.getHeight() == v1 && bitmap0.getConfig() == bitmapFactory$Options0.inPreferredConfig) {
                bitmap0.setHasAlpha(true);
                bitmap0.eraseColor(0);
                return bitmap0;
            }
        }
        Bitmap bitmap1 = Bitmap.createBitmap(v, v1, Bitmap.Config.ARGB_8888);
        bitmap1.setHasAlpha(true);
        bitmap1.eraseColor(0);
        return bitmap1;
    }

    public static Bitmap decodeByteArray(byte[] arr_b, int v, int v1) {
        return WebpBitmapFactory.decodeByteArray(arr_b, v, v1, null);
    }

    public static Bitmap decodeByteArray(byte[] arr_b, int v, int v1, BitmapFactory.Options bitmapFactory$Options0) {
        if((v | v1) < 0 || arr_b.length < v + v1) {
            throw new ArrayIndexOutOfBoundsException();
        }
        if(WebpBitmapFactory.webpSupportRequired(arr_b, v, v1)) {
            Bitmap bitmap0 = WebpBitmapFactory.nativeDecodeByteArray(arr_b, v, v1, bitmapFactory$Options0, WebpBitmapFactory.getScaleFromOptions(bitmapFactory$Options0), WebpBitmapFactory.getInTempStorageFromOptions(bitmapFactory$Options0));
            WebpBitmapFactory.setWebpBitmapOptions(bitmap0, bitmapFactory$Options0);
            return bitmap0;
        }
        return BitmapFactory.decodeByteArray(arr_b, v, v1, bitmapFactory$Options0);
    }

    public static Bitmap decodeFile(String s) {
        return WebpBitmapFactory.decodeFile(s, null);
    }

    public static Bitmap decodeFile(String s, BitmapFactory.Options bitmapFactory$Options0) {
        FileInputStream fileInputStream0;
        Bitmap bitmap0 = null;
        try {
            fileInputStream0 = null;
            fileInputStream0 = new FileInputStream(s);
            bitmap0 = WebpBitmapFactory.decodeStream(fileInputStream0, null, bitmapFactory$Options0);
            goto label_17;
        }
        catch(Exception exception0) {
            goto label_9;
        }
        catch(Throwable throwable0) {
        }
        goto label_14;
        try {
            try {
                bitmap0 = WebpBitmapFactory.decodeStream(fileInputStream0, null, bitmapFactory$Options0);
            }
            catch(Exception exception0) {
            label_9:
                Log.e("WebpBitmapFactory", "Unable to decode stream: " + exception0);
                if(fileInputStream0 == null) {
                    return null;
                }
            }
            goto label_17;
        }
        catch(Throwable throwable0) {
            bitmap0 = fileInputStream0;
        }
    label_14:
        if(bitmap0 != null) {
            try {
                ((InputStream)bitmap0).close();
            }
            catch(IOException unused_ex) {
            }
        }
        throw throwable0;
        try {
        label_17:
            fileInputStream0.close();
        }
        catch(IOException unused_ex) {
        }
        return bitmap0;
    }

    public static Bitmap decodeFileDescriptor(FileDescriptor fileDescriptor0) {
        return WebpBitmapFactory.decodeFileDescriptor(fileDescriptor0, null, null);
    }

    public static Bitmap decodeFileDescriptor(FileDescriptor fileDescriptor0, Rect rect0, BitmapFactory.Options bitmapFactory$Options0) {
        try(InputStream inputStream0 = WebpBitmapFactory.wrapToMarkSupportedStream(new FileInputStream(fileDescriptor0))) {
            if(WebpBitmapFactory.webpSupportRequired(WebpBitmapFactory.getImageHeader(inputStream0), 0, 21)) {
                Bitmap bitmap0 = WebpBitmapFactory.nativeDecodeStream(inputStream0, bitmapFactory$Options0, WebpBitmapFactory.getScaleFromOptions(bitmapFactory$Options0), WebpBitmapFactory.getInTempStorageFromOptions(bitmapFactory$Options0));
                WebpBitmapFactory.setWebpBitmapOptions(bitmap0, bitmapFactory$Options0);
                WebpBitmapFactory.setDefaultPadding(rect0);
                return bitmap0;
            }
            return BitmapFactory.decodeFileDescriptor(fileDescriptor0, rect0, bitmapFactory$Options0);
        }
    }

    public static Bitmap decodeResource(Resources resources0, int v) {
        return WebpBitmapFactory.decodeResource(resources0, v, null);
    }

    public static Bitmap decodeResource(Resources resources0, int v, BitmapFactory.Options bitmapFactory$Options0) {
        InputStream inputStream0;
        TypedValue typedValue0;
        Bitmap bitmap0 = null;
        try {
            typedValue0 = new TypedValue();
            inputStream0 = null;
            inputStream0 = resources0.openRawResource(v, typedValue0);
            bitmap0 = WebpBitmapFactory.decodeResourceStream(resources0, typedValue0, inputStream0, null, bitmapFactory$Options0);
            goto label_17;
        }
        catch(Exception unused_ex) {
            goto label_9;
        }
        catch(Throwable throwable0) {
        }
        goto label_14;
        try {
            bitmap0 = WebpBitmapFactory.decodeResourceStream(resources0, typedValue0, inputStream0, null, bitmapFactory$Options0);
            goto label_17;
        }
        catch(Exception unused_ex) {
        label_9:
            if(inputStream0 != null) {
                try {
                    inputStream0.close();
                }
                catch(IOException unused_ex) {
                }
            }
            goto label_19;
        }
        catch(Throwable throwable0) {
            bitmap0 = inputStream0;
        }
    label_14:
        if(bitmap0 != null) {
            try {
                ((InputStream)bitmap0).close();
            }
            catch(IOException unused_ex) {
            }
        }
        throw throwable0;
    label_17:
        if(inputStream0 != null) {
            try {
                inputStream0.close();
            }
            catch(IOException unused_ex) {
            }
        }
    label_19:
        if(bitmap0 == null && bitmapFactory$Options0 != null && bitmapFactory$Options0.inBitmap != null) {
            throw new IllegalArgumentException("Problem decoding into existing bitmap");
        }
        return bitmap0;
    }

    public static Bitmap decodeResourceStream(Resources resources0, TypedValue typedValue0, InputStream inputStream0, Rect rect0, BitmapFactory.Options bitmapFactory$Options0) {
        if(bitmapFactory$Options0 == null) {
            bitmapFactory$Options0 = new BitmapFactory.Options();
        }
        if(bitmapFactory$Options0.inDensity == 0 && typedValue0 != null) {
            int v = typedValue0.density;
            if(v == 0) {
                bitmapFactory$Options0.inDensity = 0xA0;
            }
            else if(v != 0xFFFF) {
                bitmapFactory$Options0.inDensity = v;
            }
        }
        if(bitmapFactory$Options0.inTargetDensity == 0 && resources0 != null) {
            bitmapFactory$Options0.inTargetDensity = resources0.getDisplayMetrics().densityDpi;
        }
        return WebpBitmapFactory.decodeStream(inputStream0, rect0, bitmapFactory$Options0);
    }

    public static Bitmap decodeStream(InputStream inputStream0) {
        return WebpBitmapFactory.decodeStream(inputStream0, null, null);
    }

    public static Bitmap decodeStream(InputStream inputStream0, Rect rect0, BitmapFactory.Options bitmapFactory$Options0) {
        if(inputStream0 == null) {
            return null;
        }
        InputStream inputStream1 = WebpBitmapFactory.wrapToMarkSupportedStream(inputStream0);
        if(WebpBitmapFactory.webpSupportRequired(WebpBitmapFactory.getImageHeader(inputStream1), 0, 21)) {
            Bitmap bitmap0 = WebpBitmapFactory.nativeDecodeStream(inputStream1, bitmapFactory$Options0, WebpBitmapFactory.getScaleFromOptions(bitmapFactory$Options0), WebpBitmapFactory.getInTempStorageFromOptions(bitmapFactory$Options0));
            WebpBitmapFactory.setWebpBitmapOptions(bitmap0, bitmapFactory$Options0);
            WebpBitmapFactory.setDefaultPadding(rect0);
            return bitmap0;
        }
        return BitmapFactory.decodeStream(inputStream1, rect0, bitmapFactory$Options0);
    }

    private static byte[] getImageHeader(InputStream inputStream0) {
        if(!inputStream0.markSupported()) {
            inputStream0 = new BufferedInputStream(inputStream0, 21);
        }
        inputStream0.mark(21);
        byte[] arr_b = new byte[21];
        try {
            inputStream0.read(arr_b, 0, 21);
            inputStream0.reset();
            return arr_b;
        }
        catch(IOException unused_ex) {
            return null;
        }
    }

    private static byte[] getInTempStorageFromOptions(BitmapFactory.Options bitmapFactory$Options0) {
        if(bitmapFactory$Options0 != null) {
            return bitmapFactory$Options0.inTempStorage == null ? new byte[0x2000] : bitmapFactory$Options0.inTempStorage;
        }
        return new byte[0x2000];
    }

    private static float getScaleFromOptions(BitmapFactory.Options bitmapFactory$Options0) {
        float f = 1.0f;
        if(bitmapFactory$Options0 != null) {
            int v = bitmapFactory$Options0.inSampleSize;
            if(v > 1) {
                f = 1.0f / ((float)v);
            }
            if(bitmapFactory$Options0.inScaled) {
                return bitmapFactory$Options0.inDensity == 0 || bitmapFactory$Options0.inTargetDensity == 0 || bitmapFactory$Options0.inDensity == bitmapFactory$Options0.inScreenDensity ? f : ((float)bitmapFactory$Options0.inTargetDensity) / ((float)bitmapFactory$Options0.inDensity) * f;
            }
        }
        return f;
    }

    private static native Bitmap nativeDecodeByteArray(byte[] arg0, int arg1, int arg2, BitmapFactory.Options arg3, float arg4, byte[] arg5) {
    }

    private static native Bitmap nativeDecodeStream(InputStream arg0, BitmapFactory.Options arg1, float arg2, byte[] arg3) {
    }

    private static void setDefaultPadding(Rect rect0) {
        if(rect0 != null) {
            rect0.top = -1;
            rect0.left = -1;
            rect0.bottom = -1;
            rect0.right = -1;
        }
    }

    private static void setDensityFromOptions(Bitmap bitmap0, BitmapFactory.Options bitmapFactory$Options0) {
        if(bitmap0 != null && bitmapFactory$Options0 != null) {
            int v = bitmapFactory$Options0.inDensity;
            if(v != 0) {
                bitmap0.setDensity(v);
                int v1 = bitmapFactory$Options0.inTargetDensity;
                if(v1 != 0 && v != v1 && v != bitmapFactory$Options0.inScreenDensity && bitmapFactory$Options0.inScaled) {
                    bitmap0.setDensity(v1);
                }
            }
            else if(bitmapFactory$Options0.inBitmap != null) {
                bitmap0.setDensity(0xA0);
            }
        }
    }

    @Keep
    private static boolean setOutDimensions(BitmapFactory.Options bitmapFactory$Options0, int v, int v1) {
        if(bitmapFactory$Options0 != null) {
            bitmapFactory$Options0.outWidth = v;
            bitmapFactory$Options0.outHeight = v1;
            return bitmapFactory$Options0.inJustDecodeBounds;
        }
        return false;
    }

    private static void setWebpBitmapOptions(Bitmap bitmap0, BitmapFactory.Options bitmapFactory$Options0) {
        WebpBitmapFactory.setDensityFromOptions(bitmap0, bitmapFactory$Options0);
        if(bitmapFactory$Options0 != null) {
            bitmapFactory$Options0.outMimeType = "image/webp";
        }
    }

    public static boolean webpSupportRequired(byte[] arr_b, int v, int v1) {
        try {
            WebpImageType webpHeaderParser$WebpImageType0 = WebpHeaderParser.getType(arr_b, v, v1);
            return WebpBitmapFactory.sUseSystemDecoder ? false : WebpHeaderParser.isStaticWebpType(webpHeaderParser$WebpImageType0);
        }
        catch(IOException unused_ex) {
            return false;
        }
    }

    private static InputStream wrapToMarkSupportedStream(InputStream inputStream0) {
        return !inputStream0.markSupported() ? new BufferedInputStream(inputStream0, 0x2000) : inputStream0;
    }
}

