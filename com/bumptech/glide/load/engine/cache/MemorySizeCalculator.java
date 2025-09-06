package com.bumptech.glide.load.engine.cache;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Context;
import android.text.format.Formatter;
import android.util.DisplayMetrics;
import android.util.Log;
import com.bumptech.glide.util.Preconditions;

public final class MemorySizeCalculator {
    public static final class Builder {
        static final int ARRAY_POOL_SIZE_BYTES = 0x400000;
        static final int BITMAP_POOL_TARGET_SCREENS = 0;
        static final float LOW_MEMORY_MAX_SIZE_MULTIPLIER = 0.33f;
        static final float MAX_SIZE_MULTIPLIER = 0.4f;
        static final int MEMORY_CACHE_TARGET_SCREENS = 2;
        ActivityManager activityManager;
        int arrayPoolSizeBytes;
        float bitmapPoolScreens;
        final Context context;
        float lowMemoryMaxSizeMultiplier;
        float maxSizeMultiplier;
        float memoryCacheScreens;
        ScreenDimensions screenDimensions;

        static {
            Builder.BITMAP_POOL_TARGET_SCREENS = 1;
        }

        public Builder(Context context0) {
            this.memoryCacheScreens = 2.0f;
            this.bitmapPoolScreens = (float)Builder.BITMAP_POOL_TARGET_SCREENS;
            this.maxSizeMultiplier = 0.4f;
            this.lowMemoryMaxSizeMultiplier = 0.33f;
            this.arrayPoolSizeBytes = 0x400000;
            this.context = context0;
            this.activityManager = (ActivityManager)context0.getSystemService("activity");
            this.screenDimensions = new DisplayMetricsScreenDimensions(context0.getResources().getDisplayMetrics());
            if(MemorySizeCalculator.isLowMemoryDevice(this.activityManager)) {
                this.bitmapPoolScreens = 0.0f;
            }
        }

        public MemorySizeCalculator build() {
            return new MemorySizeCalculator(this);
        }

        public Builder setActivityManager(ActivityManager activityManager0) {
            this.activityManager = activityManager0;
            return this;
        }

        public Builder setArrayPoolSize(int v) {
            this.arrayPoolSizeBytes = v;
            return this;
        }

        public Builder setBitmapPoolScreens(float f) {
            Preconditions.checkArgument(f >= 0.0f, "Bitmap pool screens must be greater than or equal to 0");
            this.bitmapPoolScreens = f;
            return this;
        }

        public Builder setLowMemoryMaxSizeMultiplier(float f) {
            Preconditions.checkArgument(f >= 0.0f && f <= 1.0f, "Low memory max size multiplier must be between 0 and 1");
            this.lowMemoryMaxSizeMultiplier = f;
            return this;
        }

        public Builder setMaxSizeMultiplier(float f) {
            Preconditions.checkArgument(f >= 0.0f && f <= 1.0f, "Size multiplier must be between 0 and 1");
            this.maxSizeMultiplier = f;
            return this;
        }

        public Builder setMemoryCacheScreens(float f) {
            Preconditions.checkArgument(f >= 0.0f, "Memory cache screens must be greater than or equal to 0");
            this.memoryCacheScreens = f;
            return this;
        }

        public Builder setScreenDimensions(ScreenDimensions memorySizeCalculator$ScreenDimensions0) {
            this.screenDimensions = memorySizeCalculator$ScreenDimensions0;
            return this;
        }
    }

    static final class DisplayMetricsScreenDimensions implements ScreenDimensions {
        private final DisplayMetrics displayMetrics;

        public DisplayMetricsScreenDimensions(DisplayMetrics displayMetrics0) {
            this.displayMetrics = displayMetrics0;
        }

        @Override  // com.bumptech.glide.load.engine.cache.MemorySizeCalculator$ScreenDimensions
        public int getHeightPixels() {
            return this.displayMetrics.heightPixels;
        }

        @Override  // com.bumptech.glide.load.engine.cache.MemorySizeCalculator$ScreenDimensions
        public int getWidthPixels() {
            return this.displayMetrics.widthPixels;
        }
    }

    interface ScreenDimensions {
        int getHeightPixels();

        int getWidthPixels();
    }

    static final int BYTES_PER_ARGB_8888_PIXEL = 4;
    private static final int LOW_MEMORY_BYTE_ARRAY_POOL_DIVISOR = 2;
    private static final String TAG = "MemorySizeCalculator";
    private final int arrayPoolSize;
    private final int bitmapPoolSize;
    private final Context context;
    private final int memoryCacheSize;

    public MemorySizeCalculator(Builder memorySizeCalculator$Builder0) {
        this.context = memorySizeCalculator$Builder0.context;
        int v = MemorySizeCalculator.isLowMemoryDevice(memorySizeCalculator$Builder0.activityManager) ? memorySizeCalculator$Builder0.arrayPoolSizeBytes / 2 : memorySizeCalculator$Builder0.arrayPoolSizeBytes;
        this.arrayPoolSize = v;
        int v1 = MemorySizeCalculator.getMaxSize(memorySizeCalculator$Builder0.activityManager, memorySizeCalculator$Builder0.maxSizeMultiplier, memorySizeCalculator$Builder0.lowMemoryMaxSizeMultiplier);
        float f = (float)(memorySizeCalculator$Builder0.screenDimensions.getWidthPixels() * memorySizeCalculator$Builder0.screenDimensions.getHeightPixels() * 4);
        int v2 = Math.round(memorySizeCalculator$Builder0.bitmapPoolScreens * f);
        int v3 = Math.round(f * memorySizeCalculator$Builder0.memoryCacheScreens);
        int v4 = v1 - v;
        int v5 = v3 + v2;
        if(v5 <= v4) {
            this.memoryCacheSize = v3;
            this.bitmapPoolSize = v2;
        }
        else {
            float f1 = memorySizeCalculator$Builder0.memoryCacheScreens;
            float f2 = ((float)v4) / (memorySizeCalculator$Builder0.bitmapPoolScreens + f1);
            this.memoryCacheSize = Math.round(f1 * f2);
            this.bitmapPoolSize = Math.round(f2 * memorySizeCalculator$Builder0.bitmapPoolScreens);
        }
        if(Log.isLoggable("MemorySizeCalculator", 3)) {
            Log.d("MemorySizeCalculator", "Calculation complete, Calculated memory cache size: " + this.toMb(this.memoryCacheSize) + ", pool size: " + this.toMb(this.bitmapPoolSize) + ", byte array size: " + this.toMb(v) + ", memory class limited? " + (v5 > v1) + ", max size: " + this.toMb(v1) + ", memoryClass: " + memorySizeCalculator$Builder0.activityManager.getMemoryClass() + ", isLowMemoryDevice: " + MemorySizeCalculator.isLowMemoryDevice(memorySizeCalculator$Builder0.activityManager));
        }
    }

    public int getArrayPoolSizeInBytes() {
        return this.arrayPoolSize;
    }

    public int getBitmapPoolSize() {
        return this.bitmapPoolSize;
    }

    private static int getMaxSize(ActivityManager activityManager0, float f, float f1) {
        int v = activityManager0.getMemoryClass();
        if(MemorySizeCalculator.isLowMemoryDevice(activityManager0)) {
            f = f1;
        }
        return Math.round(((float)(v * 0x100000)) * f);
    }

    public int getMemoryCacheSize() {
        return this.memoryCacheSize;
    }

    @TargetApi(19)
    public static boolean isLowMemoryDevice(ActivityManager activityManager0) {
        return activityManager0.isLowRamDevice();
    }

    private String toMb(int v) {
        return Formatter.formatFileSize(this.context, ((long)v));
    }
}

