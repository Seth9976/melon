package com.bumptech.glide.integration.webp.decoder;

import A7.d;
import U4.x;
import android.annotation.TargetApi;
import android.graphics.Bitmap.Config;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.util.DisplayMetrics;
import android.util.Log;
import androidx.appcompat.app.o;
import com.bumptech.glide.integration.webp.WebpBitmapFactory;
import com.bumptech.glide.integration.webp.WebpHeaderParser.WebpImageType;
import com.bumptech.glide.integration.webp.WebpHeaderParser;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.ImageHeaderParser.ImageType;
import com.bumptech.glide.load.ImageHeaderParserUtils;
import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapResource;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy.SampleSizeRounding;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;
import com.bumptech.glide.load.resource.bitmap.Downsampler.DecodeCallbacks;
import com.bumptech.glide.load.resource.bitmap.Downsampler;
import com.bumptech.glide.load.resource.bitmap.TransformationUtils;
import com.bumptech.glide.util.LogTime;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.Util;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Queue;

public final class WebpDownsampler {
    private static final int DENSITY_PRECISION_MULTIPLIER = 1000000000;
    public static final Option DISABLE_DECODER = null;
    private static final DecodeCallbacks EMPTY_CALLBACKS = null;
    private static final int MARK_POSITION = 0xA00000;
    private static final Queue OPTIONS_QUEUE = null;
    private static final String TAG = "WebpDownsampler";
    public static final Option USE_SYSTEM_DECODER;
    private final BitmapPool bitmapPool;
    private final ArrayPool byteArrayPool;
    private final DisplayMetrics displayMetrics;
    private final List parsers;

    static {
        WebpDownsampler.DISABLE_DECODER = Option.memory("com.bumptech.glide.integration.webp.decoder.WebpDownsampler.DisableDecoder", Boolean.FALSE);
        WebpDownsampler.USE_SYSTEM_DECODER = Option.memory("com.bumptech.glide.integration.webp.decoder.WebpDownsampler.SystemDecoder", Boolean.TRUE);
        WebpDownsampler.EMPTY_CALLBACKS = new DecodeCallbacks() {
            @Override  // com.bumptech.glide.load.resource.bitmap.Downsampler$DecodeCallbacks
            public void onDecodeComplete(BitmapPool bitmapPool0, Bitmap bitmap0) {
            }

            @Override  // com.bumptech.glide.load.resource.bitmap.Downsampler$DecodeCallbacks
            public void onObtainBounds() {
            }
        };
        WebpDownsampler.OPTIONS_QUEUE = Util.createQueue(0);
    }

    public WebpDownsampler(List list0, DisplayMetrics displayMetrics0, BitmapPool bitmapPool0, ArrayPool arrayPool0) {
        this.parsers = list0;
        this.displayMetrics = (DisplayMetrics)Preconditions.checkNotNull(displayMetrics0);
        this.bitmapPool = (BitmapPool)Preconditions.checkNotNull(bitmapPool0);
        this.byteArrayPool = (ArrayPool)Preconditions.checkNotNull(arrayPool0);
    }

    private static int adjustTargetDensityForError(double f) {
        int v = WebpDownsampler.round(1000000000.0 * f);
        return WebpDownsampler.round(f / ((double)(((float)v) / 1000000000.0f)) * ((double)v));
    }

    private void calculateConfig(InputStream inputStream0, DecodeFormat decodeFormat0, boolean z, boolean z1, BitmapFactory.Options bitmapFactory$Options0, int v, int v1) {
        boolean z2;
        if(decodeFormat0 != DecodeFormat.PREFER_ARGB_8888) {
            try {
                z2 = ImageHeaderParserUtils.getType(this.parsers, inputStream0, this.byteArrayPool).hasAlpha();
            }
            catch(IOException iOException0) {
                if(Log.isLoggable("WebpDownsampler", 3)) {
                    Log.d("WebpDownsampler", "Cannot determine whether the image has alpha or not from header, format " + decodeFormat0, iOException0);
                }
                z2 = false;
            }
            Bitmap.Config bitmap$Config0 = z2 ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565;
            bitmapFactory$Options0.inPreferredConfig = bitmap$Config0;
            if(bitmap$Config0 == Bitmap.Config.RGB_565 || bitmap$Config0 == Bitmap.Config.ARGB_4444 || bitmap$Config0 == Bitmap.Config.ALPHA_8) {
                bitmapFactory$Options0.inDither = true;
            }
            return;
        }
        bitmapFactory$Options0.inPreferredConfig = Bitmap.Config.ARGB_8888;
    }

    public static void calculateScaling(ImageType imageHeaderParser$ImageType0, InputStream inputStream0, DecodeCallbacks downsampler$DecodeCallbacks0, BitmapPool bitmapPool0, DownsampleStrategy downsampleStrategy0, int v, int v1, int v2, int v3, int v4, BitmapFactory.Options bitmapFactory$Options0) {
        int v10;
        int v9;
        if(v1 > 0 && v2 > 0) {
            float f = v == 90 || v == 270 ? downsampleStrategy0.getScaleFactor(v2, v1, v3, v4) : downsampleStrategy0.getScaleFactor(v1, v2, v3, v4);
            if(Float.compare(f, 0.0f) <= 0) {
                goto label_58;
            }
            SampleSizeRounding downsampleStrategy$SampleSizeRounding0 = downsampleStrategy0.getSampleSizeRounding(v1, v2, v3, v4);
            if(downsampleStrategy$SampleSizeRounding0 == null) {
                throw new IllegalArgumentException("Cannot round with null rounding");
            }
            int v5 = v1 / WebpDownsampler.round(f * ((float)v1));
            int v6 = v2 / WebpDownsampler.round(f * ((float)v2));
            int v7 = downsampleStrategy$SampleSizeRounding0 == SampleSizeRounding.MEMORY ? Math.max(v5, v6) : Math.min(v5, v6);
            int v8 = Math.max(1, Integer.highestOneBit(v7));
            v8 = downsampleStrategy$SampleSizeRounding0 != SampleSizeRounding.MEMORY || ((float)v8) >= 1.0f / f ? Math.max(1, Integer.highestOneBit(v7)) : v8 << 1;
            bitmapFactory$Options0.inSampleSize = v8;
            if(imageHeaderParser$ImageType0 == ImageType.JPEG) {
                float f1 = (float)Math.min(v8, 8);
                v9 = (int)Math.ceil(((float)v1) / f1);
                v10 = (int)Math.ceil(((float)v2) / f1);
                if(v8 / 8 > 0) {
                    v9 /= v8 / 8;
                    v10 /= v8 / 8;
                }
            }
            else if(imageHeaderParser$ImageType0 == ImageType.PNG || imageHeaderParser$ImageType0 == ImageType.PNG_A) {
                v9 = (int)Math.floor(((float)v1) / ((float)v8));
                v10 = (int)Math.floor(((float)v2) / ((float)v8));
            }
            else if(imageHeaderParser$ImageType0 == ImageType.WEBP || imageHeaderParser$ImageType0 == ImageType.WEBP_A) {
                v9 = Math.round(((float)v1) / ((float)v8));
                v10 = Math.round(((float)v2) / ((float)v8));
            }
            else if(v1 % v8 != 0 || v2 % v8 != 0) {
                int[] arr_v = WebpDownsampler.getDimensions(inputStream0, bitmapFactory$Options0, downsampler$DecodeCallbacks0, bitmapPool0);
                v9 = arr_v[0];
                v10 = arr_v[1];
            }
            else {
                v9 = v1 / v8;
                v10 = v2 / v8;
            }
            double f2 = (double)downsampleStrategy0.getScaleFactor(v9, v10, v3, v4);
            bitmapFactory$Options0.inTargetDensity = WebpDownsampler.adjustTargetDensityForError(f2);
            bitmapFactory$Options0.inDensity = 1000000000;
            if(WebpDownsampler.isScaling(bitmapFactory$Options0)) {
                bitmapFactory$Options0.inScaled = true;
            }
            else {
                bitmapFactory$Options0.inTargetDensity = 0;
                bitmapFactory$Options0.inDensity = 0;
            }
            if(Log.isLoggable("WebpDownsampler", 2)) {
                StringBuilder stringBuilder0 = o.t(v1, v2, "Calculate scaling, source: [", "x", "], target: [");
                x.x(stringBuilder0, v3, "x", v4, "], power of two scaled: [");
                x.x(stringBuilder0, v9, "x", v10, "], exact scale factor: ");
                stringBuilder0.append(f);
                stringBuilder0.append(", power of 2 sample size: ");
                stringBuilder0.append(v8);
                stringBuilder0.append(", adjusted scale factor: ");
                stringBuilder0.append(f2);
                stringBuilder0.append(", target density: ");
                stringBuilder0.append(bitmapFactory$Options0.inTargetDensity);
                stringBuilder0.append(", density: ");
                stringBuilder0.append(bitmapFactory$Options0.inDensity);
                Log.v("WebpDownsampler", stringBuilder0.toString());
                return;
            label_58:
                StringBuilder stringBuilder1 = new StringBuilder("Cannot scale with factor: ");
                stringBuilder1.append(f);
                stringBuilder1.append(" from: ");
                stringBuilder1.append(downsampleStrategy0);
                stringBuilder1.append(", source: [");
                x.x(stringBuilder1, v1, "x", v2, "], target: [");
                stringBuilder1.append(v3);
                stringBuilder1.append("x");
                stringBuilder1.append(v4);
                stringBuilder1.append("]");
                throw new IllegalArgumentException(stringBuilder1.toString());
            }
        }
    }

    public Resource decode(InputStream inputStream0, int v, int v1, Options options0) {
        return this.decode(inputStream0, v, v1, options0, WebpDownsampler.EMPTY_CALLBACKS);
    }

    public Resource decode(InputStream inputStream0, int v, int v1, Options options0, DecodeCallbacks downsampler$DecodeCallbacks0) {
        Preconditions.checkArgument(inputStream0.markSupported(), "You must provide an InputStream that supports mark()");
        Object object0 = this.byteArrayPool.get(0x10000, byte[].class);
        BitmapFactory.Options bitmapFactory$Options0 = WebpDownsampler.getDefaultOptions();
        bitmapFactory$Options0.inTempStorage = (byte[])object0;
        DecodeFormat decodeFormat0 = (DecodeFormat)options0.get(Downsampler.DECODE_FORMAT);
        DownsampleStrategy downsampleStrategy0 = (DownsampleStrategy)options0.get(Downsampler.DOWNSAMPLE_STRATEGY);
        boolean z = ((Boolean)options0.get(Downsampler.FIX_BITMAP_SIZE_TO_REQUESTED_DIMENSIONS)).booleanValue();
        boolean z1 = options0.get(Downsampler.ALLOW_HARDWARE_CONFIG) != null && ((Boolean)options0.get(Downsampler.ALLOW_HARDWARE_CONFIG)).booleanValue();
        try {
            return BitmapResource.obtain(this.decodeFromWrappedStreams(inputStream0, bitmapFactory$Options0, downsampleStrategy0, decodeFormat0, z1, v, v1, z, downsampler$DecodeCallbacks0), this.bitmapPool);
        }
        finally {
            WebpDownsampler.releaseOptions(bitmapFactory$Options0);
            this.byteArrayPool.put(((byte[])object0), byte[].class);
        }
    }

    private Bitmap decodeFromWrappedStreams(InputStream inputStream0, BitmapFactory.Options bitmapFactory$Options0, DownsampleStrategy downsampleStrategy0, DecodeFormat decodeFormat0, boolean z, int v, int v1, boolean z1, DecodeCallbacks downsampler$DecodeCallbacks0) {
        Bitmap bitmap1;
        long v2 = LogTime.getLogTime();
        int[] arr_v = WebpDownsampler.getDimensions(inputStream0, bitmapFactory$Options0, downsampler$DecodeCallbacks0, this.bitmapPool);
        int v3 = arr_v[0];
        int v4 = arr_v[1];
        String s = bitmapFactory$Options0.outMimeType;
        int v5 = ImageHeaderParserUtils.getOrientation(this.parsers, inputStream0, this.byteArrayPool);
        int v6 = v == 0x80000000 ? v3 : v;
        int v7 = v1 == 0x80000000 ? v4 : v1;
        WebpDownsampler.calculateScaling(ImageHeaderParserUtils.getType(this.parsers, inputStream0, this.byteArrayPool), inputStream0, downsampler$DecodeCallbacks0, this.bitmapPool, downsampleStrategy0, TransformationUtils.getExifOrientationDegrees(v5), v3, v4, v6, v7, bitmapFactory$Options0);
        int v8 = v6;
        int v9 = v7;
        this.calculateConfig(inputStream0, decodeFormat0, (v3 == -1 || v4 == -1 ? false : z), TransformationUtils.isExifOrientationRequired(v5), bitmapFactory$Options0, v8, v9);
        if(!z1) {
            float f = WebpDownsampler.isScaling(bitmapFactory$Options0) ? ((float)bitmapFactory$Options0.inTargetDensity) / ((float)bitmapFactory$Options0.inDensity) : 1.0f;
            int v10 = bitmapFactory$Options0.inSampleSize;
            int v11 = Math.round(((float)(((int)Math.ceil(((float)v3) / ((float)v10))))) * f);
            int v12 = Math.round(((float)(((int)Math.ceil(((float)v4) / ((float)v10))))) * f);
            if(Log.isLoggable("WebpDownsampler", 2)) {
                StringBuilder stringBuilder0 = o.t(v11, v12, "Calculated target [", "x", "] for source [");
                x.x(stringBuilder0, v3, "x", v4, "], sampleSize: ");
                stringBuilder0.append(v10);
                stringBuilder0.append(", targetDensity: ");
                stringBuilder0.append(bitmapFactory$Options0.inTargetDensity);
                stringBuilder0.append(", density: ");
                stringBuilder0.append(bitmapFactory$Options0.inDensity);
                stringBuilder0.append(", density multiplier: ");
                stringBuilder0.append(f);
                Log.v("WebpDownsampler", stringBuilder0.toString());
            }
            v8 = v11;
            v9 = v12;
        }
        if(v8 > 0 && v9 > 0) {
            WebpDownsampler.setInBitmap(bitmapFactory$Options0, this.bitmapPool, v8, v9);
        }
        Bitmap bitmap0 = WebpDownsampler.decodeStream(inputStream0, bitmapFactory$Options0, downsampler$DecodeCallbacks0, this.bitmapPool);
        downsampler$DecodeCallbacks0.onDecodeComplete(this.bitmapPool, bitmap0);
        if(Log.isLoggable("WebpDownsampler", 2)) {
            bitmap1 = bitmap0;
            WebpDownsampler.logDecode(v3, v4, s, bitmapFactory$Options0, bitmap1, v, v1, v2);
        }
        else {
            bitmap1 = bitmap0;
        }
        if(bitmap1 != null) {
            bitmap1.setDensity(this.displayMetrics.densityDpi);
            Bitmap bitmap2 = TransformationUtils.rotateImageExif(this.bitmapPool, bitmap1, v5);
            if(!bitmap1.equals(bitmap2)) {
                this.bitmapPool.put(bitmap1);
            }
            return bitmap2;
        }
        return null;
    }

    private static Bitmap decodeStream(InputStream inputStream0, BitmapFactory.Options bitmapFactory$Options0, DecodeCallbacks downsampler$DecodeCallbacks0, BitmapPool bitmapPool0) {
        Bitmap bitmap0;
        if(bitmapFactory$Options0.inJustDecodeBounds) {
            inputStream0.mark(0xA00000);
        }
        else {
            downsampler$DecodeCallbacks0.onObtainBounds();
        }
        int v = bitmapFactory$Options0.outWidth;
        int v1 = bitmapFactory$Options0.outHeight;
        String s = bitmapFactory$Options0.outMimeType;
        TransformationUtils.getBitmapDrawableLock().lock();
        try {
            bitmap0 = WebpBitmapFactory.decodeStream(inputStream0, null, bitmapFactory$Options0);
        }
        catch(IllegalArgumentException illegalArgumentException0) {
            IOException iOException0 = WebpDownsampler.newIoExceptionForInBitmapAssertion(illegalArgumentException0, v, v1, s, bitmapFactory$Options0);
            if(Log.isLoggable("WebpDownsampler", 3)) {
                Log.d("WebpDownsampler", "Failed to decode with inBitmap, trying again without Bitmap re-use", iOException0);
            }
            if(bitmapFactory$Options0.inBitmap != null) {
                try {
                    inputStream0.reset();
                    bitmapPool0.put(bitmapFactory$Options0.inBitmap);
                    bitmapFactory$Options0.inBitmap = null;
                    return WebpDownsampler.decodeStream(inputStream0, bitmapFactory$Options0, downsampler$DecodeCallbacks0, bitmapPool0);
                }
                catch(IOException unused_ex) {
                    throw iOException0;
                }
            }
            throw iOException0;
        }
        finally {
            TransformationUtils.getBitmapDrawableLock().unlock();
        }
        if(bitmapFactory$Options0.inJustDecodeBounds) {
            inputStream0.reset();
        }
        return bitmap0;
    }

    @TargetApi(19)
    private static String getBitmapString(Bitmap bitmap0) {
        return bitmap0 == null ? null : "[" + bitmap0.getWidth() + "x" + bitmap0.getHeight() + "] " + bitmap0.getConfig() + (" (" + bitmap0.getAllocationByteCount() + ")");
    }

    private static BitmapFactory.Options getDefaultOptions() {
        BitmapFactory.Options bitmapFactory$Options0;
        synchronized(WebpDownsampler.class) {
            Queue queue0 = WebpDownsampler.OPTIONS_QUEUE;
            synchronized(queue0) {
                bitmapFactory$Options0 = (BitmapFactory.Options)queue0.poll();
            }
            if(bitmapFactory$Options0 == null) {
                bitmapFactory$Options0 = new BitmapFactory.Options();
                WebpDownsampler.resetOptions(bitmapFactory$Options0);
            }
            return bitmapFactory$Options0;
        }
    }

    private static int[] getDimensions(InputStream inputStream0, BitmapFactory.Options bitmapFactory$Options0, DecodeCallbacks downsampler$DecodeCallbacks0, BitmapPool bitmapPool0) {
        bitmapFactory$Options0.inJustDecodeBounds = true;
        WebpDownsampler.decodeStream(inputStream0, bitmapFactory$Options0, downsampler$DecodeCallbacks0, bitmapPool0);
        bitmapFactory$Options0.inJustDecodeBounds = false;
        return new int[]{bitmapFactory$Options0.outWidth, bitmapFactory$Options0.outHeight};
    }

    private static String getInBitmapString(BitmapFactory.Options bitmapFactory$Options0) {
        return WebpDownsampler.getBitmapString(bitmapFactory$Options0.inBitmap);
    }

    public boolean handles(InputStream inputStream0, Options options0) {
        if(((Boolean)options0.get(WebpDownsampler.DISABLE_DECODER)).booleanValue()) {
            return false;
        }
        if(((Boolean)options0.get(WebpDownsampler.USE_SYSTEM_DECODER)).booleanValue()) {
            if(WebpHeaderParser.sIsExtendedWebpSupported) {
                return false;
            }
            WebpImageType webpHeaderParser$WebpImageType0 = WebpHeaderParser.getType(inputStream0, this.byteArrayPool);
            return WebpHeaderParser.isStaticWebpType(webpHeaderParser$WebpImageType0) && webpHeaderParser$WebpImageType0 != WebpImageType.WEBP_SIMPLE;
        }
        return WebpHeaderParser.isStaticWebpType(WebpHeaderParser.getType(inputStream0, this.byteArrayPool));
    }

    public boolean handles(ByteBuffer byteBuffer0, Options options0) {
        if(((Boolean)options0.get(WebpDownsampler.DISABLE_DECODER)).booleanValue()) {
            return false;
        }
        if(((Boolean)options0.get(WebpDownsampler.USE_SYSTEM_DECODER)).booleanValue()) {
            if(WebpHeaderParser.sIsExtendedWebpSupported) {
                return false;
            }
            WebpImageType webpHeaderParser$WebpImageType0 = WebpHeaderParser.getType(byteBuffer0);
            return WebpHeaderParser.isStaticWebpType(webpHeaderParser$WebpImageType0) && webpHeaderParser$WebpImageType0 != WebpImageType.WEBP_SIMPLE;
        }
        return WebpHeaderParser.isStaticWebpType(WebpHeaderParser.getType(byteBuffer0));
    }

    private static boolean isScaling(BitmapFactory.Options bitmapFactory$Options0) {
        return bitmapFactory$Options0.inTargetDensity > 0 && (bitmapFactory$Options0.inDensity > 0 && bitmapFactory$Options0.inTargetDensity != bitmapFactory$Options0.inDensity);
    }

    private static void logDecode(int v, int v1, String s, BitmapFactory.Options bitmapFactory$Options0, Bitmap bitmap0, int v2, int v3, long v4) {
        StringBuilder stringBuilder0 = new StringBuilder("Decoded ");
        d.t(stringBuilder0, WebpDownsampler.getBitmapString(bitmap0), " from [", v, "x");
        stringBuilder0.append(v1);
        stringBuilder0.append("] ");
        stringBuilder0.append(s);
        stringBuilder0.append(" with inBitmap ");
        d.t(stringBuilder0, WebpDownsampler.getInBitmapString(bitmapFactory$Options0), " for [", v2, "x");
        stringBuilder0.append(v3);
        stringBuilder0.append("], sample size: ");
        stringBuilder0.append(bitmapFactory$Options0.inSampleSize);
        stringBuilder0.append(", density: ");
        stringBuilder0.append(bitmapFactory$Options0.inDensity);
        stringBuilder0.append(", target density: ");
        stringBuilder0.append(bitmapFactory$Options0.inTargetDensity);
        stringBuilder0.append(", thread: ");
        stringBuilder0.append("jeb-dexdec-sb-st-1084");
        stringBuilder0.append(", duration: ");
        stringBuilder0.append(LogTime.getElapsedMillis(v4));
        Log.v("WebpDownsampler", stringBuilder0.toString());
    }

    private static IOException newIoExceptionForInBitmapAssertion(IllegalArgumentException illegalArgumentException0, int v, int v1, String s, BitmapFactory.Options bitmapFactory$Options0) {
        StringBuilder stringBuilder0 = o.t(v, v1, "Exception decoding bitmap, outWidth: ", ", outHeight: ", ", outMimeType: ");
        stringBuilder0.append(s);
        stringBuilder0.append(", inBitmap: ");
        stringBuilder0.append(WebpDownsampler.getInBitmapString(bitmapFactory$Options0));
        return new IOException(stringBuilder0.toString(), illegalArgumentException0);
    }

    private static void releaseOptions(BitmapFactory.Options bitmapFactory$Options0) {
        WebpDownsampler.resetOptions(bitmapFactory$Options0);
        synchronized(WebpDownsampler.OPTIONS_QUEUE) {
            WebpDownsampler.OPTIONS_QUEUE.offer(bitmapFactory$Options0);
        }
    }

    private static void resetOptions(BitmapFactory.Options bitmapFactory$Options0) {
        bitmapFactory$Options0.inTempStorage = null;
        bitmapFactory$Options0.inDither = false;
        bitmapFactory$Options0.inScaled = false;
        bitmapFactory$Options0.inSampleSize = 1;
        bitmapFactory$Options0.inPreferredConfig = null;
        bitmapFactory$Options0.inJustDecodeBounds = false;
        bitmapFactory$Options0.inDensity = 0;
        bitmapFactory$Options0.inTargetDensity = 0;
        bitmapFactory$Options0.outWidth = 0;
        bitmapFactory$Options0.outHeight = 0;
        bitmapFactory$Options0.outMimeType = null;
        bitmapFactory$Options0.inBitmap = null;
        bitmapFactory$Options0.inMutable = true;
    }

    private static int round(double f) {
        return (int)(((long)f) + 0x3FE0000000000000L);
    }

    @TargetApi(26)
    private static void setInBitmap(BitmapFactory.Options bitmapFactory$Options0, BitmapPool bitmapPool0, int v, int v1) {
        Bitmap.Config bitmap$Config0 = bitmapFactory$Options0.inPreferredConfig;
        if(bitmap$Config0 == Bitmap.Config.HARDWARE) {
            return;
        }
        bitmapFactory$Options0.inBitmap = bitmapPool0.getDirty(v, v1, bitmap$Config0);
    }

    private boolean shouldUsePool(ImageType imageHeaderParser$ImageType0) [...] // Inlined contents
}

