package com.bumptech.glide.load.engine.bitmap_recycle;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.graphics.Bitmap.Config;
import android.graphics.Bitmap;
import android.util.Log;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import va.e;

public class LruBitmapPool implements BitmapPool {
    interface BitmapTracker {
        void add(Bitmap arg1);

        void remove(Bitmap arg1);
    }

    static final class NullBitmapTracker implements BitmapTracker {
        @Override  // com.bumptech.glide.load.engine.bitmap_recycle.LruBitmapPool$BitmapTracker
        public void add(Bitmap bitmap0) {
        }

        @Override  // com.bumptech.glide.load.engine.bitmap_recycle.LruBitmapPool$BitmapTracker
        public void remove(Bitmap bitmap0) {
        }
    }

    static class ThrowingBitmapTracker implements BitmapTracker {
        private final Set bitmaps;

        private ThrowingBitmapTracker() {
            this.bitmaps = Collections.synchronizedSet(new HashSet());
        }

        @Override  // com.bumptech.glide.load.engine.bitmap_recycle.LruBitmapPool$BitmapTracker
        public void add(Bitmap bitmap0) {
            if(this.bitmaps.contains(bitmap0)) {
                throw new IllegalStateException("Can\'t add already added bitmap: " + bitmap0 + " [" + bitmap0.getWidth() + "x" + bitmap0.getHeight() + "]");
            }
            this.bitmaps.add(bitmap0);
        }

        @Override  // com.bumptech.glide.load.engine.bitmap_recycle.LruBitmapPool$BitmapTracker
        public void remove(Bitmap bitmap0) {
            if(!this.bitmaps.contains(bitmap0)) {
                throw new IllegalStateException("Cannot remove bitmap not in tracker");
            }
            this.bitmaps.remove(bitmap0);
        }
    }

    private static final Bitmap.Config DEFAULT_CONFIG = null;
    private static final String TAG = "LruBitmapPool";
    private final Set allowedConfigs;
    private long currentSize;
    private int evictions;
    private int hits;
    private final long initialMaxSize;
    private long maxSize;
    private int misses;
    private int puts;
    private final LruPoolStrategy strategy;
    private final BitmapTracker tracker;

    static {
        LruBitmapPool.DEFAULT_CONFIG = Bitmap.Config.ARGB_8888;
    }

    public LruBitmapPool(long v) {
        this(v, LruBitmapPool.getDefaultStrategy(), LruBitmapPool.getDefaultAllowedConfigs());
    }

    public LruBitmapPool(long v, LruPoolStrategy lruPoolStrategy0, Set set0) {
        this.initialMaxSize = v;
        this.maxSize = v;
        this.strategy = lruPoolStrategy0;
        this.allowedConfigs = set0;
        this.tracker = new NullBitmapTracker();
    }

    public LruBitmapPool(long v, Set set0) {
        this(v, LruBitmapPool.getDefaultStrategy(), set0);
    }

    @TargetApi(26)
    private static void assertNotHardwareConfig(Bitmap.Config bitmap$Config0) {
        if(bitmap$Config0 == Bitmap.Config.HARDWARE) {
            throw new IllegalArgumentException("Cannot create a mutable Bitmap with config: " + bitmap$Config0 + ". Consider setting Downsampler#ALLOW_HARDWARE_CONFIG to false in your RequestOptions and/or in GlideBuilder.setDefaultRequestOptions");
        }
    }

    @Override  // com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
    public void clearMemory() {
        if(Log.isLoggable("LruBitmapPool", 3)) {
            Log.d("LruBitmapPool", "clearMemory");
        }
        this.trimToSize(0L);
    }

    private static Bitmap createBitmap(int v, int v1, Bitmap.Config bitmap$Config0) {
        if(bitmap$Config0 == null) {
            bitmap$Config0 = LruBitmapPool.DEFAULT_CONFIG;
        }
        return Bitmap.createBitmap(v, v1, bitmap$Config0);
    }

    private void dump() {
        if(Log.isLoggable("LruBitmapPool", 2)) {
            this.dumpUnchecked();
        }
    }

    private void dumpUnchecked() {
        Log.v("LruBitmapPool", "Hits=" + this.hits + ", misses=" + this.misses + ", puts=" + this.puts + ", evictions=" + this.evictions + ", currentSize=" + this.currentSize + ", maxSize=" + this.maxSize + "\nStrategy=" + this.strategy);
    }

    private void evict() {
        this.trimToSize(this.maxSize);
    }

    public long evictionCount() {
        return (long)this.evictions;
    }

    @Override  // com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
    public Bitmap get(int v, int v1, Bitmap.Config bitmap$Config0) {
        Bitmap bitmap0 = this.getDirtyOrNull(v, v1, bitmap$Config0);
        if(bitmap0 != null) {
            bitmap0.eraseColor(0);
            return bitmap0;
        }
        return LruBitmapPool.createBitmap(v, v1, bitmap$Config0);
    }

    public long getCurrentSize() {
        return this.currentSize;
    }

    @TargetApi(26)
    private static Set getDefaultAllowedConfigs() {
        HashSet hashSet0 = new HashSet(Arrays.asList(Bitmap.Config.values()));
        hashSet0.add(null);
        hashSet0.remove(Bitmap.Config.HARDWARE);
        return Collections.unmodifiableSet(hashSet0);
    }

    private static LruPoolStrategy getDefaultStrategy() {
        return new SizeConfigStrategy();
    }

    @Override  // com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
    public Bitmap getDirty(int v, int v1, Bitmap.Config bitmap$Config0) {
        Bitmap bitmap0 = this.getDirtyOrNull(v, v1, bitmap$Config0);
        return bitmap0 == null ? LruBitmapPool.createBitmap(v, v1, bitmap$Config0) : bitmap0;
    }

    private Bitmap getDirtyOrNull(int v, int v1, Bitmap.Config bitmap$Config0) {
        synchronized(this) {
            LruBitmapPool.assertNotHardwareConfig(bitmap$Config0);
            Bitmap bitmap0 = this.strategy.get(v, v1, (bitmap$Config0 == null ? LruBitmapPool.DEFAULT_CONFIG : bitmap$Config0));
            if(bitmap0 == null) {
                if(Log.isLoggable("LruBitmapPool", 3)) {
                    Log.d("LruBitmapPool", "Missing bitmap=" + this.strategy.logBitmap(v, v1, bitmap$Config0));
                }
                ++this.misses;
            }
            else {
                ++this.hits;
                this.currentSize -= (long)this.strategy.getSize(bitmap0);
                this.tracker.remove(bitmap0);
                LruBitmapPool.normalize(bitmap0);
            }
            if(Log.isLoggable("LruBitmapPool", 2)) {
                Log.v("LruBitmapPool", "Get bitmap=" + this.strategy.logBitmap(v, v1, bitmap$Config0));
            }
            this.dump();
            return bitmap0;
        }
    }

    @Override  // com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
    public long getMaxSize() {
        return this.maxSize;
    }

    public long hitCount() {
        return (long)this.hits;
    }

    @TargetApi(19)
    private static void maybeSetPreMultiplied(Bitmap bitmap0) {
        bitmap0.setPremultiplied(true);
    }

    public long missCount() {
        return (long)this.misses;
    }

    private static void normalize(Bitmap bitmap0) {
        bitmap0.setHasAlpha(true);
        LruBitmapPool.maybeSetPreMultiplied(bitmap0);
    }

    @Override  // com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
    public void put(Bitmap bitmap0) {
        synchronized(this) {
            if(bitmap0 != null) {
                if(bitmap0.isRecycled()) {
                    throw new IllegalStateException("Cannot pool recycled bitmap");
                }
                if(bitmap0.isMutable() && ((long)this.strategy.getSize(bitmap0)) <= this.maxSize) {
                    Bitmap.Config bitmap$Config0 = bitmap0.getConfig();
                    if(this.allowedConfigs.contains(bitmap$Config0)) {
                        int v1 = this.strategy.getSize(bitmap0);
                        this.strategy.put(bitmap0);
                        this.tracker.add(bitmap0);
                        ++this.puts;
                        this.currentSize += (long)v1;
                        if(Log.isLoggable("LruBitmapPool", 2)) {
                            Log.v("LruBitmapPool", "Put bitmap in pool=" + this.strategy.logBitmap(bitmap0));
                        }
                        this.dump();
                        this.evict();
                        return;
                    }
                }
                if(Log.isLoggable("LruBitmapPool", 2)) {
                    Bitmap.Config bitmap$Config1 = bitmap0.getConfig();
                    Log.v("LruBitmapPool", "Reject bitmap from pool, bitmap: " + this.strategy.logBitmap(bitmap0) + ", is mutable: " + bitmap0.isMutable() + ", is allowed config: " + this.allowedConfigs.contains(bitmap$Config1));
                }
                bitmap0.recycle();
                return;
            }
        }
        throw new NullPointerException("Bitmap must not be null");
    }

    @Override  // com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
    public void setSizeMultiplier(float f) {
        synchronized(this) {
            this.maxSize = (long)Math.round(((float)this.initialMaxSize) * f);
            this.evict();
        }
    }

    @Override  // com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
    @SuppressLint({"InlinedApi"})
    public void trimMemory(int v) {
        if(Log.isLoggable("LruBitmapPool", 3)) {
            e.f(v, "trimMemory, level=", "LruBitmapPool");
        }
        if(v < 40 && v < 20) {
            if(v != 15) {
                return;
            }
            this.trimToSize(this.getMaxSize() / 2L);
            return;
        }
        this.clearMemory();
    }

    private void trimToSize(long v) {
        synchronized(this) {
            while(this.currentSize > v) {
                Bitmap bitmap0 = this.strategy.removeLast();
                if(bitmap0 == null) {
                    if(Log.isLoggable("LruBitmapPool", 5)) {
                        Log.w("LruBitmapPool", "Size mismatch, resetting");
                        this.dumpUnchecked();
                    }
                    this.currentSize = 0L;
                    return;
                }
                this.tracker.remove(bitmap0);
                this.currentSize -= (long)this.strategy.getSize(bitmap0);
                ++this.evictions;
                if(Log.isLoggable("LruBitmapPool", 3)) {
                    Log.d("LruBitmapPool", "Evicting bitmap=" + this.strategy.logBitmap(bitmap0));
                }
                this.dump();
                bitmap0.recycle();
            }
        }
    }
}

