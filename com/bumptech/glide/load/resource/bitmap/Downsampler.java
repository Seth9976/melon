package com.bumptech.glide.load.resource.bitmap;

import A7.d;
import U4.x;
import android.annotation.TargetApi;
import android.graphics.Bitmap.Config;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.graphics.ColorSpace.Named;
import android.graphics.ColorSpace;
import android.os.Build.VERSION;
import android.os.ParcelFileDescriptor;
import android.util.DisplayMetrics;
import android.util.Log;
import androidx.appcompat.app.o;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.ImageHeaderParser.ImageType;
import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.PreferredColorSpace;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.util.LogTime;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.Util;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public final class Downsampler {
    public interface DecodeCallbacks {
        void onDecodeComplete(BitmapPool arg1, Bitmap arg2);

        void onObtainBounds();
    }

    public static final Option ALLOW_HARDWARE_CONFIG = null;
    public static final Option DECODE_FORMAT = null;
    @Deprecated
    public static final Option DOWNSAMPLE_STRATEGY = null;
    private static final DecodeCallbacks EMPTY_CALLBACKS = null;
    public static final Option FIX_BITMAP_SIZE_TO_REQUESTED_DIMENSIONS = null;
    private static final String ICO_MIME_TYPE = "image/x-ico";
    private static final Set NO_DOWNSAMPLE_PRE_N_MIME_TYPES = null;
    private static final Queue OPTIONS_QUEUE = null;
    public static final Option PREFERRED_COLOR_SPACE = null;
    static final String TAG = "Downsampler";
    private static final Set TYPES_THAT_USE_POOL_PRE_KITKAT = null;
    private static final String WBMP_MIME_TYPE = "image/vnd.wap.wbmp";
    private final BitmapPool bitmapPool;
    private final ArrayPool byteArrayPool;
    private final DisplayMetrics displayMetrics;
    private final HardwareConfigState hardwareConfigState;
    private final List parsers;

    static {
        Downsampler.DECODE_FORMAT = Option.memory("com.bumptech.glide.load.resource.bitmap.Downsampler.DecodeFormat", DecodeFormat.DEFAULT);
        Downsampler.PREFERRED_COLOR_SPACE = Option.memory("com.bumptech.glide.load.resource.bitmap.Downsampler.PreferredColorSpace");
        Downsampler.DOWNSAMPLE_STRATEGY = DownsampleStrategy.OPTION;
        Downsampler.FIX_BITMAP_SIZE_TO_REQUESTED_DIMENSIONS = Option.memory("com.bumptech.glide.load.resource.bitmap.Downsampler.FixBitmapSize", Boolean.FALSE);
        Downsampler.ALLOW_HARDWARE_CONFIG = Option.memory("com.bumptech.glide.load.resource.bitmap.Downsampler.AllowHardwareDecode", Boolean.FALSE);
        Downsampler.NO_DOWNSAMPLE_PRE_N_MIME_TYPES = Collections.unmodifiableSet(new HashSet(Arrays.asList(new String[]{"image/vnd.wap.wbmp", "image/x-ico"})));
        Downsampler.EMPTY_CALLBACKS = new DecodeCallbacks() {
            @Override  // com.bumptech.glide.load.resource.bitmap.Downsampler$DecodeCallbacks
            public void onDecodeComplete(BitmapPool bitmapPool0, Bitmap bitmap0) {
            }

            @Override  // com.bumptech.glide.load.resource.bitmap.Downsampler$DecodeCallbacks
            public void onObtainBounds() {
            }
        };
        Downsampler.TYPES_THAT_USE_POOL_PRE_KITKAT = Collections.unmodifiableSet(EnumSet.of(ImageType.JPEG, ImageType.PNG_A, ImageType.PNG));
        Downsampler.OPTIONS_QUEUE = Util.createQueue(0);
    }

    public Downsampler(List list0, DisplayMetrics displayMetrics0, BitmapPool bitmapPool0, ArrayPool arrayPool0) {
        this.hardwareConfigState = HardwareConfigState.getInstance();
        this.parsers = list0;
        this.displayMetrics = (DisplayMetrics)Preconditions.checkNotNull(displayMetrics0);
        this.bitmapPool = (BitmapPool)Preconditions.checkNotNull(bitmapPool0);
        this.byteArrayPool = (ArrayPool)Preconditions.checkNotNull(arrayPool0);
    }

    private static int adjustTargetDensityForError(double f) {
        int v = Downsampler.getDensityMultiplier(f);
        int v1 = Downsampler.round(((double)v) * f);
        return Downsampler.round(f / ((double)(((float)v1) / ((float)v))) * ((double)v1));
    }

    private void calculateConfig(ImageReader imageReader0, DecodeFormat decodeFormat0, boolean z, boolean z1, BitmapFactory.Options bitmapFactory$Options0, int v, int v1) {
        boolean z2;
        if(!this.hardwareConfigState.setHardwareConfigIfAllowed(v, v1, bitmapFactory$Options0, z, z1)) {
            if(decodeFormat0 == DecodeFormat.PREFER_ARGB_8888) {
                bitmapFactory$Options0.inPreferredConfig = Bitmap.Config.ARGB_8888;
                return;
            }
            try {
                z2 = imageReader0.getImageType().hasAlpha();
            }
            catch(IOException iOException0) {
                if(Log.isLoggable("Downsampler", 3)) {
                    Log.d("Downsampler", "Cannot determine whether the image has alpha or not from header, format " + decodeFormat0, iOException0);
                }
                z2 = false;
            }
            bitmapFactory$Options0.inPreferredConfig = z2 ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565;
            if((z2 ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565) == Bitmap.Config.RGB_565) {
                bitmapFactory$Options0.inDither = true;
            }
        }
    }

    private static void calculateScaling(ImageType imageHeaderParser$ImageType0, ImageReader imageReader0, DecodeCallbacks downsampler$DecodeCallbacks0, BitmapPool bitmapPool0, DownsampleStrategy downsampleStrategy0, int v, int v1, int v2, int v3, int v4, BitmapFactory.Options bitmapFactory$Options0) {
        int v12;
        int v11;
        int v6;
        int v5;
        if(v1 > 0 && v2 > 0) {
            if(Downsampler.isRotationRequired(v)) {
                v5 = v1;
                v6 = v2;
            }
            else {
                v6 = v1;
                v5 = v2;
            }
            float f = downsampleStrategy0.getScaleFactor(v6, v5, v3, v4);
            if(f <= 0.0f) {
                goto label_66;
            }
            SampleSizeRounding downsampleStrategy$SampleSizeRounding0 = downsampleStrategy0.getSampleSizeRounding(v6, v5, v3, v4);
            if(downsampleStrategy$SampleSizeRounding0 == null) {
                throw new IllegalArgumentException("Cannot round with null rounding");
            }
            int v7 = v6 / Downsampler.round(f * ((float)v6));
            int v8 = v5 / Downsampler.round(f * ((float)v5));
            int v9 = downsampleStrategy$SampleSizeRounding0 == SampleSizeRounding.MEMORY ? Math.max(v7, v8) : Math.min(v7, v8);
            int v10 = Math.max(1, Integer.highestOneBit(v9));
            v10 = downsampleStrategy$SampleSizeRounding0 != SampleSizeRounding.MEMORY || ((float)v10) >= 1.0f / f ? Math.max(1, Integer.highestOneBit(v9)) : v10 << 1;
            bitmapFactory$Options0.inSampleSize = v10;
            if(imageHeaderParser$ImageType0 == ImageType.JPEG) {
                float f1 = (float)Math.min(v10, 8);
                v11 = (int)Math.ceil(((float)v6) / f1);
                v12 = (int)Math.ceil(((float)v5) / f1);
                if(v10 / 8 > 0) {
                    v11 /= v10 / 8;
                    v12 /= v10 / 8;
                }
            }
            else if(imageHeaderParser$ImageType0 == ImageType.PNG || imageHeaderParser$ImageType0 == ImageType.PNG_A) {
                v11 = (int)Math.floor(((float)v6) / ((float)v10));
                v12 = (int)Math.floor(((float)v5) / ((float)v10));
            }
            else if(imageHeaderParser$ImageType0.isWebp()) {
                v11 = Math.round(((float)v6) / ((float)v10));
                v12 = Math.round(((float)v5) / ((float)v10));
            }
            else if(v6 % v10 == 0 && v5 % v10 == 0) {
                v11 = v6 / v10;
                v12 = v5 / v10;
            }
            else {
                int[] arr_v = Downsampler.getDimensions(imageReader0, bitmapFactory$Options0, downsampler$DecodeCallbacks0, bitmapPool0);
                v11 = arr_v[0];
                v12 = arr_v[1];
            }
            double f2 = (double)downsampleStrategy0.getScaleFactor(v11, v12, v3, v4);
            bitmapFactory$Options0.inTargetDensity = Downsampler.adjustTargetDensityForError(f2);
            bitmapFactory$Options0.inDensity = Downsampler.getDensityMultiplier(f2);
            if(Downsampler.isScaling(bitmapFactory$Options0)) {
                bitmapFactory$Options0.inScaled = true;
            }
            else {
                bitmapFactory$Options0.inTargetDensity = 0;
                bitmapFactory$Options0.inDensity = 0;
            }
            if(Log.isLoggable("Downsampler", 2)) {
                StringBuilder stringBuilder0 = o.t(v1, v2, "Calculate scaling, source: [", "x", "], degreesToRotate: ");
                x.x(stringBuilder0, v, ", target: [", v3, "x");
                x.x(stringBuilder0, v4, "], power of two scaled: [", v11, "x");
                stringBuilder0.append(v12);
                stringBuilder0.append("], exact scale factor: ");
                stringBuilder0.append(f);
                stringBuilder0.append(", power of 2 sample size: ");
                stringBuilder0.append(v10);
                stringBuilder0.append(", adjusted scale factor: ");
                stringBuilder0.append(f2);
                stringBuilder0.append(", target density: ");
                stringBuilder0.append(bitmapFactory$Options0.inTargetDensity);
                stringBuilder0.append(", density: ");
                stringBuilder0.append(bitmapFactory$Options0.inDensity);
                Log.v("Downsampler", stringBuilder0.toString());
                return;
            label_66:
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
        else if(Log.isLoggable("Downsampler", 3)) {
            Log.d("Downsampler", "Unable to determine dimensions for: " + imageHeaderParser$ImageType0 + " with target [" + v3 + "x" + v4 + "]");
        }
    }

    private Resource decode(ImageReader imageReader0, int v, int v1, Options options0, DecodeCallbacks downsampler$DecodeCallbacks0) {
        byte[] arr_b = (byte[])this.byteArrayPool.get(0x10000, byte[].class);
        BitmapFactory.Options bitmapFactory$Options0 = Downsampler.getDefaultOptions();
        bitmapFactory$Options0.inTempStorage = arr_b;
        DecodeFormat decodeFormat0 = (DecodeFormat)options0.get(Downsampler.DECODE_FORMAT);
        PreferredColorSpace preferredColorSpace0 = (PreferredColorSpace)options0.get(Downsampler.PREFERRED_COLOR_SPACE);
        DownsampleStrategy downsampleStrategy0 = (DownsampleStrategy)options0.get(DownsampleStrategy.OPTION);
        boolean z = ((Boolean)options0.get(Downsampler.FIX_BITMAP_SIZE_TO_REQUESTED_DIMENSIONS)).booleanValue();
        boolean z1 = options0.get(Downsampler.ALLOW_HARDWARE_CONFIG) != null && ((Boolean)options0.get(Downsampler.ALLOW_HARDWARE_CONFIG)).booleanValue();
        try {
            return BitmapResource.obtain(this.decodeFromWrappedStreams(imageReader0, bitmapFactory$Options0, downsampleStrategy0, decodeFormat0, preferredColorSpace0, z1, v, v1, z, downsampler$DecodeCallbacks0), this.bitmapPool);
        }
        finally {
            Downsampler.releaseOptions(bitmapFactory$Options0);
            this.byteArrayPool.put(arr_b);
        }
    }

    public Resource decode(ParcelFileDescriptor parcelFileDescriptor0, int v, int v1, Options options0) {
        return this.decode(new ParcelFileDescriptorImageReader(parcelFileDescriptor0, this.parsers, this.byteArrayPool), v, v1, options0, Downsampler.EMPTY_CALLBACKS);
    }

    public Resource decode(InputStream inputStream0, int v, int v1, Options options0) {
        return this.decode(inputStream0, v, v1, options0, Downsampler.EMPTY_CALLBACKS);
    }

    public Resource decode(InputStream inputStream0, int v, int v1, Options options0, DecodeCallbacks downsampler$DecodeCallbacks0) {
        return this.decode(new InputStreamImageReader(inputStream0, this.parsers, this.byteArrayPool), v, v1, options0, downsampler$DecodeCallbacks0);
    }

    public Resource decode(ByteBuffer byteBuffer0, int v, int v1, Options options0) {
        return this.decode(new ByteBufferReader(byteBuffer0, this.parsers, this.byteArrayPool), v, v1, options0, Downsampler.EMPTY_CALLBACKS);
    }

    public void decode(File file0, int v, int v1, Options options0) {
        this.decode(new FileReader(file0, this.parsers, this.byteArrayPool), v, v1, options0, Downsampler.EMPTY_CALLBACKS);
    }

    public void decode(byte[] arr_b, int v, int v1, Options options0) {
        this.decode(new ByteArrayReader(arr_b, this.parsers, this.byteArrayPool), v, v1, options0, Downsampler.EMPTY_CALLBACKS);
    }

    private Bitmap decodeFromWrappedStreams(ImageReader imageReader0, BitmapFactory.Options bitmapFactory$Options0, DownsampleStrategy downsampleStrategy0, DecodeFormat decodeFormat0, PreferredColorSpace preferredColorSpace0, boolean z, int v, int v1, boolean z1, DecodeCallbacks downsampler$DecodeCallbacks0) {
        int v8;
        long v2 = LogTime.getLogTime();
        int[] arr_v = Downsampler.getDimensions(imageReader0, bitmapFactory$Options0, downsampler$DecodeCallbacks0, this.bitmapPool);
        int v3 = arr_v[0];
        int v4 = arr_v[1];
        String s = bitmapFactory$Options0.outMimeType;
        int v5 = imageReader0.getImageOrientation();
        int v6 = TransformationUtils.getExifOrientationDegrees(v5);
        boolean z2 = TransformationUtils.isExifOrientationRequired(v5);
        int v7 = v;
        if(v7 != 0x80000000) {
            v8 = v1;
        }
        else if(Downsampler.isRotationRequired(v6)) {
            v8 = v1;
            v7 = v4;
        }
        else {
            v8 = v1;
            v7 = v3;
        }
        if(v8 == 0x80000000) {
            v8 = Downsampler.isRotationRequired(v6) ? v3 : v4;
        }
        Downsampler.calculateScaling(imageReader0.getImageType(), imageReader0, downsampler$DecodeCallbacks0, this.bitmapPool, downsampleStrategy0, v6, v3, v4, v7, v8, bitmapFactory$Options0);
        int v9 = v7;
        int v10 = v8;
        this.calculateConfig(imageReader0, decodeFormat0, (v3 == -1 || v4 == -1 ? false : z), z2, bitmapFactory$Options0, v9, v10);
        int v11 = Build.VERSION.SDK_INT;
        if(v3 < 0 || v4 < 0 || !z1) {
            float f = Downsampler.isScaling(bitmapFactory$Options0) ? ((float)bitmapFactory$Options0.inTargetDensity) / ((float)bitmapFactory$Options0.inDensity) : 1.0f;
            int v12 = bitmapFactory$Options0.inSampleSize;
            int v13 = Math.round(((float)(((int)Math.ceil(((float)v3) / ((float)v12))))) * f);
            int v14 = Math.round(((float)(((int)Math.ceil(((float)v4) / ((float)v12))))) * f);
            if(Log.isLoggable("Downsampler", 2)) {
                StringBuilder stringBuilder0 = o.t(v13, v14, "Calculated target [", "x", "] for source [");
                x.x(stringBuilder0, v3, "x", v4, "], sampleSize: ");
                stringBuilder0.append(v12);
                stringBuilder0.append(", targetDensity: ");
                stringBuilder0.append(bitmapFactory$Options0.inTargetDensity);
                stringBuilder0.append(", density: ");
                stringBuilder0.append(bitmapFactory$Options0.inDensity);
                stringBuilder0.append(", density multiplier: ");
                stringBuilder0.append(f);
                Log.v("Downsampler", stringBuilder0.toString());
            }
            v9 = v13;
            v10 = v14;
        }
        if(v9 > 0 && v10 > 0) {
            Downsampler.setInBitmap(bitmapFactory$Options0, this.bitmapPool, v9, v10);
        }
        if(preferredColorSpace0 != null) {
            bitmapFactory$Options0.inPreferredColorSpace = v11 >= 28 ? ColorSpace.get((preferredColorSpace0 != PreferredColorSpace.DISPLAY_P3 || (bitmapFactory$Options0.outColorSpace == null || !bitmapFactory$Options0.outColorSpace.isWideGamut()) ? ColorSpace.Named.SRGB : ColorSpace.Named.DISPLAY_P3)) : ColorSpace.get(ColorSpace.Named.SRGB);
        }
        Bitmap bitmap0 = Downsampler.decodeStream(imageReader0, bitmapFactory$Options0, downsampler$DecodeCallbacks0, this.bitmapPool);
        downsampler$DecodeCallbacks0.onDecodeComplete(this.bitmapPool, bitmap0);
        if(Log.isLoggable("Downsampler", 2)) {
            Downsampler.logDecode(v3, v4, s, bitmapFactory$Options0, bitmap0, v, v1, v2);
        }
        if(bitmap0 != null) {
            bitmap0.setDensity(this.displayMetrics.densityDpi);
            Bitmap bitmap1 = TransformationUtils.rotateImageExif(this.bitmapPool, bitmap0, v5);
            if(!bitmap0.equals(bitmap1)) {
                this.bitmapPool.put(bitmap0);
            }
            return bitmap1;
        }
        return null;
    }

    private static Bitmap decodeStream(ImageReader imageReader0, BitmapFactory.Options bitmapFactory$Options0, DecodeCallbacks downsampler$DecodeCallbacks0, BitmapPool bitmapPool0) {
        if(!bitmapFactory$Options0.inJustDecodeBounds) {
            downsampler$DecodeCallbacks0.onObtainBounds();
            imageReader0.stopGrowingBuffers();
        }
        int v = bitmapFactory$Options0.outWidth;
        int v1 = bitmapFactory$Options0.outHeight;
        String s = bitmapFactory$Options0.outMimeType;
        TransformationUtils.getBitmapDrawableLock().lock();
        try {
            return imageReader0.decodeBitmap(bitmapFactory$Options0);
        }
        catch(IllegalArgumentException illegalArgumentException0) {
            IOException iOException0 = Downsampler.newIoExceptionForInBitmapAssertion(illegalArgumentException0, v, v1, s, bitmapFactory$Options0);
            if(Log.isLoggable("Downsampler", 3)) {
                Log.d("Downsampler", "Failed to decode with inBitmap, trying again without Bitmap re-use", iOException0);
            }
            Bitmap bitmap1 = bitmapFactory$Options0.inBitmap;
            if(bitmap1 != null) {
                try {
                    bitmapPool0.put(bitmap1);
                    bitmapFactory$Options0.inBitmap = null;
                    return Downsampler.decodeStream(imageReader0, bitmapFactory$Options0, downsampler$DecodeCallbacks0, bitmapPool0);
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
    }

    @TargetApi(19)
    private static String getBitmapString(Bitmap bitmap0) {
        return bitmap0 == null ? null : "[" + bitmap0.getWidth() + "x" + bitmap0.getHeight() + "] " + bitmap0.getConfig() + (" (" + bitmap0.getAllocationByteCount() + ")");
    }

    private static BitmapFactory.Options getDefaultOptions() {
        BitmapFactory.Options bitmapFactory$Options0;
        synchronized(Downsampler.class) {
            Queue queue0 = Downsampler.OPTIONS_QUEUE;
            synchronized(queue0) {
                bitmapFactory$Options0 = (BitmapFactory.Options)queue0.poll();
            }
            if(bitmapFactory$Options0 == null) {
                bitmapFactory$Options0 = new BitmapFactory.Options();
                Downsampler.resetOptions(bitmapFactory$Options0);
            }
            return bitmapFactory$Options0;
        }
    }

    private static int getDensityMultiplier(double f) {
        if(f > 1.0) {
            f = 1.0 / f;
        }
        return (int)Math.round(f * 2147483647.0);
    }

    private static int[] getDimensions(ImageReader imageReader0, BitmapFactory.Options bitmapFactory$Options0, DecodeCallbacks downsampler$DecodeCallbacks0, BitmapPool bitmapPool0) {
        bitmapFactory$Options0.inJustDecodeBounds = true;
        Downsampler.decodeStream(imageReader0, bitmapFactory$Options0, downsampler$DecodeCallbacks0, bitmapPool0);
        bitmapFactory$Options0.inJustDecodeBounds = false;
        return new int[]{bitmapFactory$Options0.outWidth, bitmapFactory$Options0.outHeight};
    }

    private static String getInBitmapString(BitmapFactory.Options bitmapFactory$Options0) {
        return Downsampler.getBitmapString(bitmapFactory$Options0.inBitmap);
    }

    // 去混淆评级： 低(20)
    public boolean handles(ParcelFileDescriptor parcelFileDescriptor0) {
        return true;
    }

    public boolean handles(InputStream inputStream0) [...] // Inlined contents

    public boolean handles(ByteBuffer byteBuffer0) [...] // Inlined contents

    private static boolean isRotationRequired(int v) {
        return v == 90 || v == 270;
    }

    private static boolean isScaling(BitmapFactory.Options bitmapFactory$Options0) {
        return bitmapFactory$Options0.inTargetDensity > 0 && (bitmapFactory$Options0.inDensity > 0 && bitmapFactory$Options0.inTargetDensity != bitmapFactory$Options0.inDensity);
    }

    private static void logDecode(int v, int v1, String s, BitmapFactory.Options bitmapFactory$Options0, Bitmap bitmap0, int v2, int v3, long v4) {
        StringBuilder stringBuilder0 = new StringBuilder("Decoded ");
        d.t(stringBuilder0, Downsampler.getBitmapString(bitmap0), " from [", v, "x");
        stringBuilder0.append(v1);
        stringBuilder0.append("] ");
        stringBuilder0.append(s);
        stringBuilder0.append(" with inBitmap ");
        d.t(stringBuilder0, Downsampler.getInBitmapString(bitmapFactory$Options0), " for [", v2, "x");
        stringBuilder0.append(v3);
        stringBuilder0.append("], sample size: ");
        stringBuilder0.append(bitmapFactory$Options0.inSampleSize);
        stringBuilder0.append(", density: ");
        stringBuilder0.append(bitmapFactory$Options0.inDensity);
        stringBuilder0.append(", target density: ");
        stringBuilder0.append(bitmapFactory$Options0.inTargetDensity);
        stringBuilder0.append(", thread: ");
        stringBuilder0.append("jeb-dexdec-sb-st-991");
        stringBuilder0.append(", duration: ");
        stringBuilder0.append(LogTime.getElapsedMillis(v4));
        Log.v("Downsampler", stringBuilder0.toString());
    }

    private static IOException newIoExceptionForInBitmapAssertion(IllegalArgumentException illegalArgumentException0, int v, int v1, String s, BitmapFactory.Options bitmapFactory$Options0) {
        StringBuilder stringBuilder0 = o.t(v, v1, "Exception decoding bitmap, outWidth: ", ", outHeight: ", ", outMimeType: ");
        stringBuilder0.append(s);
        stringBuilder0.append(", inBitmap: ");
        stringBuilder0.append(Downsampler.getInBitmapString(bitmapFactory$Options0));
        return new IOException(stringBuilder0.toString(), illegalArgumentException0);
    }

    private static void releaseOptions(BitmapFactory.Options bitmapFactory$Options0) {
        Downsampler.resetOptions(bitmapFactory$Options0);
        synchronized(Downsampler.OPTIONS_QUEUE) {
            Downsampler.OPTIONS_QUEUE.offer(bitmapFactory$Options0);
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
        bitmapFactory$Options0.inPreferredColorSpace = null;
        bitmapFactory$Options0.outColorSpace = null;
        bitmapFactory$Options0.outConfig = null;
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
        Bitmap.Config bitmap$Config1 = bitmapFactory$Options0.outConfig;
        if(bitmap$Config1 != null) {
            bitmap$Config0 = bitmap$Config1;
        }
        bitmapFactory$Options0.inBitmap = bitmapPool0.getDirty(v, v1, bitmap$Config0);
    }

    private boolean shouldUsePool(ImageType imageHeaderParser$ImageType0) [...] // Inlined contents
}

