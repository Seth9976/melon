package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap.Config;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path.Direction;
import android.graphics.Path;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.os.Build;
import android.util.Log;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.util.Preconditions;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public final class TransformationUtils {
    interface DrawRoundedCornerFn {
        void drawRoundedCorners(Canvas arg1, Paint arg2, RectF arg3);
    }

    static final class NoLock implements Lock {
        @Override
        public void lock() {
        }

        @Override
        public void lockInterruptibly() {
        }

        @Override
        public Condition newCondition() {
            throw new UnsupportedOperationException("Should not be called");
        }

        @Override
        public boolean tryLock() {
            return true;
        }

        @Override
        public boolean tryLock(long v, TimeUnit timeUnit0) {
            return true;
        }

        @Override
        public void unlock() {
        }
    }

    private static final Lock BITMAP_DRAWABLE_LOCK = null;
    private static final Paint CIRCLE_CROP_BITMAP_PAINT = null;
    private static final int CIRCLE_CROP_PAINT_FLAGS = 7;
    private static final Paint CIRCLE_CROP_SHAPE_PAINT = null;
    private static final Paint DEFAULT_PAINT = null;
    private static final Set MODELS_REQUIRING_BITMAP_LOCK = null;
    public static final int PAINT_FLAGS = 6;
    private static final String TAG = "TransformationUtils";

    static {
        TransformationUtils.DEFAULT_PAINT = new Paint(6);
        TransformationUtils.CIRCLE_CROP_SHAPE_PAINT = new Paint(7);
        HashSet hashSet0 = new HashSet(Arrays.asList(new String[]{"XT1085", "XT1092", "XT1093", "XT1094", "XT1095", "XT1096", "XT1097", "XT1098", "XT1031", "XT1028", "XT937C", "XT1032", "XT1008", "XT1033", "XT1035", "XT1034", "XT939G", "XT1039", "XT1040", "XT1042", "XT1045", "XT1063", "XT1064", "XT1068", "XT1069", "XT1072", "XT1077", "XT1078", "XT1079"}));
        TransformationUtils.MODELS_REQUIRING_BITMAP_LOCK = hashSet0;
        ReentrantLock reentrantLock0 = hashSet0.contains(Build.MODEL) ? new ReentrantLock() : new NoLock();
        TransformationUtils.BITMAP_DRAWABLE_LOCK = reentrantLock0;
        Paint paint0 = new Paint(7);
        TransformationUtils.CIRCLE_CROP_BITMAP_PAINT = paint0;
        paint0.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    }

    private static void applyMatrix(Bitmap bitmap0, Bitmap bitmap1, Matrix matrix0) {
        Lock lock0 = TransformationUtils.BITMAP_DRAWABLE_LOCK;
        lock0.lock();
        try {
            Canvas canvas0 = new Canvas(bitmap1);
            canvas0.drawBitmap(bitmap0, matrix0, TransformationUtils.DEFAULT_PAINT);
            TransformationUtils.clear(canvas0);
        }
        catch(Throwable throwable0) {
            TransformationUtils.BITMAP_DRAWABLE_LOCK.unlock();
            throw throwable0;
        }
        lock0.unlock();
    }

    public static Bitmap centerCrop(BitmapPool bitmapPool0, Bitmap bitmap0, int v, int v1) {
        float f2;
        float f1;
        if(bitmap0.getWidth() == v && bitmap0.getHeight() == v1) {
            return bitmap0;
        }
        Matrix matrix0 = new Matrix();
        float f = 0.0f;
        if(bitmap0.getWidth() * v1 > bitmap0.getHeight() * v) {
            f1 = ((float)v1) / ((float)bitmap0.getHeight());
            f = (((float)v) - ((float)bitmap0.getWidth()) * f1) * 0.5f;
            f2 = 0.0f;
        }
        else {
            f1 = ((float)v) / ((float)bitmap0.getWidth());
            f2 = (((float)v1) - ((float)bitmap0.getHeight()) * f1) * 0.5f;
        }
        matrix0.setScale(f1, f1);
        matrix0.postTranslate(((float)(((int)(f + 0.5f)))), ((float)(((int)(f2 + 0.5f)))));
        Bitmap bitmap1 = bitmapPool0.get(v, v1, TransformationUtils.getNonNullConfig(bitmap0));
        TransformationUtils.setAlpha(bitmap0, bitmap1);
        TransformationUtils.applyMatrix(bitmap0, bitmap1, matrix0);
        return bitmap1;
    }

    public static Bitmap centerInside(BitmapPool bitmapPool0, Bitmap bitmap0, int v, int v1) {
        if(bitmap0.getWidth() <= v && bitmap0.getHeight() <= v1) {
            if(Log.isLoggable("TransformationUtils", 2)) {
                Log.v("TransformationUtils", "requested target size larger or equal to input, returning input");
            }
            return bitmap0;
        }
        if(Log.isLoggable("TransformationUtils", 2)) {
            Log.v("TransformationUtils", "requested target size too big for input, fit centering instead");
        }
        return TransformationUtils.fitCenter(bitmapPool0, bitmap0, v, v1);
    }

    public static Bitmap circleCrop(BitmapPool bitmapPool0, Bitmap bitmap0, int v, int v1) {
        int v2 = Math.min(v, v1);
        float f = ((float)v2) / 2.0f;
        int v3 = bitmap0.getWidth();
        int v4 = bitmap0.getHeight();
        float f1 = Math.max(((float)v2) / ((float)v3), ((float)v2) / ((float)v4));
        float f2 = ((float)v3) * f1;
        float f3 = f1 * ((float)v4);
        float f4 = (((float)v2) - f2) / 2.0f;
        float f5 = (((float)v2) - f3) / 2.0f;
        RectF rectF0 = new RectF(f4, f5, f2 + f4, f3 + f5);
        Bitmap bitmap1 = TransformationUtils.getAlphaSafeBitmap(bitmapPool0, bitmap0);
        Bitmap bitmap2 = bitmapPool0.get(v2, v2, TransformationUtils.getAlphaSafeConfig(bitmap0));
        bitmap2.setHasAlpha(true);
        Lock lock0 = TransformationUtils.BITMAP_DRAWABLE_LOCK;
        lock0.lock();
        try {
            Canvas canvas0 = new Canvas(bitmap2);
            canvas0.drawCircle(f, f, f, TransformationUtils.CIRCLE_CROP_SHAPE_PAINT);
            canvas0.drawBitmap(bitmap1, null, rectF0, TransformationUtils.CIRCLE_CROP_BITMAP_PAINT);
            TransformationUtils.clear(canvas0);
        }
        catch(Throwable throwable0) {
            TransformationUtils.BITMAP_DRAWABLE_LOCK.unlock();
            throw throwable0;
        }
        lock0.unlock();
        if(!bitmap1.equals(bitmap0)) {
            bitmapPool0.put(bitmap1);
        }
        return bitmap2;
    }

    private static void clear(Canvas canvas0) {
        canvas0.setBitmap(null);
    }

    public static Bitmap fitCenter(BitmapPool bitmapPool0, Bitmap bitmap0, int v, int v1) {
        if(bitmap0.getWidth() == v && bitmap0.getHeight() == v1) {
            if(!Log.isLoggable("TransformationUtils", 2)) {
                return bitmap0;
            }
            Log.v("TransformationUtils", "requested target size matches input, returning input");
            return bitmap0;
        }
        float f = Math.min(((float)v) / ((float)bitmap0.getWidth()), ((float)v1) / ((float)bitmap0.getHeight()));
        int v2 = Math.round(((float)bitmap0.getWidth()) * f);
        int v3 = Math.round(((float)bitmap0.getHeight()) * f);
        if(bitmap0.getWidth() == v2 && bitmap0.getHeight() == v3) {
            if(Log.isLoggable("TransformationUtils", 2)) {
                Log.v("TransformationUtils", "adjusted target size matches input, returning input");
            }
            return bitmap0;
        }
        Bitmap bitmap1 = bitmapPool0.get(((int)(((float)bitmap0.getWidth()) * f)), ((int)(((float)bitmap0.getHeight()) * f)), TransformationUtils.getNonNullConfig(bitmap0));
        TransformationUtils.setAlpha(bitmap0, bitmap1);
        if(Log.isLoggable("TransformationUtils", 2)) {
            Log.v("TransformationUtils", "request: " + v + "x" + v1);
            Log.v("TransformationUtils", "toFit:   " + bitmap0.getWidth() + "x" + bitmap0.getHeight());
            Log.v("TransformationUtils", "toReuse: " + bitmap1.getWidth() + "x" + bitmap1.getHeight());
            Log.v("TransformationUtils", "minPct:   " + f);
        }
        Matrix matrix0 = new Matrix();
        matrix0.setScale(f, f);
        TransformationUtils.applyMatrix(bitmap0, bitmap1, matrix0);
        return bitmap1;
    }

    private static Bitmap getAlphaSafeBitmap(BitmapPool bitmapPool0, Bitmap bitmap0) {
        Bitmap.Config bitmap$Config0 = TransformationUtils.getAlphaSafeConfig(bitmap0);
        if(bitmap$Config0.equals(bitmap0.getConfig())) {
            return bitmap0;
        }
        Bitmap bitmap1 = bitmapPool0.get(bitmap0.getWidth(), bitmap0.getHeight(), bitmap$Config0);
        new Canvas(bitmap1).drawBitmap(bitmap0, 0.0f, 0.0f, null);
        return bitmap1;
    }

    private static Bitmap.Config getAlphaSafeConfig(Bitmap bitmap0) {
        Bitmap.Config bitmap$Config0 = Bitmap.Config.RGBA_F16;
        return bitmap$Config0.equals(bitmap0.getConfig()) ? bitmap$Config0 : Bitmap.Config.ARGB_8888;
    }

    public static Lock getBitmapDrawableLock() {
        return TransformationUtils.BITMAP_DRAWABLE_LOCK;
    }

    public static int getExifOrientationDegrees(int v) {
        switch(v) {
            case 3: 
            case 4: {
                return 180;
            }
            case 5: 
            case 6: {
                return 90;
            }
            case 7: 
            case 8: {
                return 270;
            }
            default: {
                return 0;
            }
        }
    }

    private static Bitmap.Config getNonNullConfig(Bitmap bitmap0) {
        return bitmap0.getConfig() == null ? Bitmap.Config.ARGB_8888 : bitmap0.getConfig();
    }

    public static void initializeMatrixForRotation(int v, Matrix matrix0) {
        switch(v) {
            case 2: {
                matrix0.setScale(-1.0f, 1.0f);
                return;
            }
            case 3: {
                matrix0.setRotate(180.0f);
                return;
            }
            case 4: {
                matrix0.setRotate(180.0f);
                matrix0.postScale(-1.0f, 1.0f);
                return;
            }
            case 5: {
                matrix0.setRotate(90.0f);
                matrix0.postScale(-1.0f, 1.0f);
                return;
            }
            case 6: {
                matrix0.setRotate(90.0f);
                return;
            }
            case 7: {
                matrix0.setRotate(-90.0f);
                matrix0.postScale(-1.0f, 1.0f);
                return;
            }
            case 8: {
                matrix0.setRotate(-90.0f);
            }
        }
    }

    public static boolean isExifOrientationRequired(int v) {
        switch(v) {
            case 2: 
            case 3: 
            case 4: 
            case 5: 
            case 6: 
            case 7: 
            case 8: {
                return true;
            }
            default: {
                return false;
            }
        }
    }

    public static Bitmap rotateImage(Bitmap bitmap0, int v) {
        if(v != 0) {
            try {
                Matrix matrix0 = new Matrix();
                matrix0.setRotate(((float)v));
                return Bitmap.createBitmap(bitmap0, 0, 0, bitmap0.getWidth(), bitmap0.getHeight(), matrix0, true);
            }
            catch(Exception exception0) {
                if(Log.isLoggable("TransformationUtils", 6)) {
                    Log.e("TransformationUtils", "Exception when trying to orient image", exception0);
                }
            }
        }
        return bitmap0;
    }

    public static Bitmap rotateImageExif(BitmapPool bitmapPool0, Bitmap bitmap0, int v) {
        if(!TransformationUtils.isExifOrientationRequired(v)) {
            return bitmap0;
        }
        Matrix matrix0 = new Matrix();
        TransformationUtils.initializeMatrixForRotation(v, matrix0);
        RectF rectF0 = new RectF(0.0f, 0.0f, ((float)bitmap0.getWidth()), ((float)bitmap0.getHeight()));
        matrix0.mapRect(rectF0);
        Bitmap bitmap1 = bitmapPool0.get(Math.round(rectF0.width()), Math.round(rectF0.height()), TransformationUtils.getNonNullConfig(bitmap0));
        matrix0.postTranslate(-rectF0.left, -rectF0.top);
        bitmap1.setHasAlpha(bitmap0.hasAlpha());
        TransformationUtils.applyMatrix(bitmap0, bitmap1, matrix0);
        return bitmap1;
    }

    public static Bitmap roundedCorners(BitmapPool bitmapPool0, Bitmap bitmap0, float f, float f1, float f2, float f3) {
        return TransformationUtils.roundedCorners(bitmapPool0, bitmap0, new DrawRoundedCornerFn() {
            @Override  // com.bumptech.glide.load.resource.bitmap.TransformationUtils$DrawRoundedCornerFn
            public void drawRoundedCorners(Canvas canvas0, Paint paint0, RectF rectF0) {
                Path path0 = new Path();
                path0.addRoundRect(rectF0, new float[]{f, f, f1, f1, f2, f2, f3, f3}, Path.Direction.CW);
                canvas0.drawPath(path0, paint0);
            }
        });
    }

    public static Bitmap roundedCorners(BitmapPool bitmapPool0, Bitmap bitmap0, int v) {
        Preconditions.checkArgument(v > 0, "roundingRadius must be greater than 0.");
        return TransformationUtils.roundedCorners(bitmapPool0, bitmap0, new DrawRoundedCornerFn() {
            @Override  // com.bumptech.glide.load.resource.bitmap.TransformationUtils$DrawRoundedCornerFn
            public void drawRoundedCorners(Canvas canvas0, Paint paint0, RectF rectF0) {
                canvas0.drawRoundRect(rectF0, ((float)v), ((float)v), paint0);
            }
        });
    }

    @Deprecated
    public static Bitmap roundedCorners(BitmapPool bitmapPool0, Bitmap bitmap0, int v, int v1, int v2) {
        return TransformationUtils.roundedCorners(bitmapPool0, bitmap0, v2);
    }

    private static Bitmap roundedCorners(BitmapPool bitmapPool0, Bitmap bitmap0, DrawRoundedCornerFn transformationUtils$DrawRoundedCornerFn0) {
        Bitmap.Config bitmap$Config0 = TransformationUtils.getAlphaSafeConfig(bitmap0);
        Bitmap bitmap1 = TransformationUtils.getAlphaSafeBitmap(bitmapPool0, bitmap0);
        Bitmap bitmap2 = bitmapPool0.get(bitmap1.getWidth(), bitmap1.getHeight(), bitmap$Config0);
        bitmap2.setHasAlpha(true);
        BitmapShader bitmapShader0 = new BitmapShader(bitmap1, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        Paint paint0 = new Paint();
        paint0.setAntiAlias(true);
        paint0.setShader(bitmapShader0);
        RectF rectF0 = new RectF(0.0f, 0.0f, ((float)bitmap2.getWidth()), ((float)bitmap2.getHeight()));
        Lock lock0 = TransformationUtils.BITMAP_DRAWABLE_LOCK;
        lock0.lock();
        try {
            Canvas canvas0 = new Canvas(bitmap2);
            canvas0.drawColor(0, PorterDuff.Mode.CLEAR);
            transformationUtils$DrawRoundedCornerFn0.drawRoundedCorners(canvas0, paint0, rectF0);
            TransformationUtils.clear(canvas0);
        }
        catch(Throwable throwable0) {
            TransformationUtils.BITMAP_DRAWABLE_LOCK.unlock();
            throw throwable0;
        }
        lock0.unlock();
        if(!bitmap1.equals(bitmap0)) {
            bitmapPool0.put(bitmap1);
        }
        return bitmap2;
    }

    public static void setAlpha(Bitmap bitmap0, Bitmap bitmap1) {
        bitmap1.setHasAlpha(bitmap0.hasAlpha());
    }
}

