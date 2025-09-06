package com.bumptech.glide.load.engine.prefill;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Log;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.engine.cache.MemoryCache;
import com.bumptech.glide.load.resource.bitmap.BitmapResource;
import com.bumptech.glide.util.Util;
import java.security.MessageDigest;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;

final class BitmapPreFillRunner implements Runnable {
    static class Clock {
        public long now() {
            return SystemClock.currentThreadTimeMillis();
        }
    }

    static final class UniqueKey implements Key {
        @Override  // com.bumptech.glide.load.Key
        public void updateDiskCacheKey(MessageDigest messageDigest0) {
            throw new UnsupportedOperationException();
        }
    }

    static final int BACKOFF_RATIO = 4;
    private static final Clock DEFAULT_CLOCK = null;
    static final long INITIAL_BACKOFF_MS = 40L;
    static final long MAX_BACKOFF_MS = 0L;
    static final long MAX_DURATION_MS = 0x20L;
    static final String TAG = "PreFillRunner";
    private final BitmapPool bitmapPool;
    private final Clock clock;
    private long currentDelay;
    private final Handler handler;
    private boolean isCancelled;
    private final MemoryCache memoryCache;
    private final Set seenTypes;
    private final PreFillQueue toPrefill;

    static {
        BitmapPreFillRunner.DEFAULT_CLOCK = new Clock();
        BitmapPreFillRunner.MAX_BACKOFF_MS = TimeUnit.SECONDS.toMillis(1L);
    }

    public BitmapPreFillRunner(BitmapPool bitmapPool0, MemoryCache memoryCache0, PreFillQueue preFillQueue0) {
        Handler handler0 = new Handler(Looper.getMainLooper());
        this(bitmapPool0, memoryCache0, preFillQueue0, BitmapPreFillRunner.DEFAULT_CLOCK, handler0);
    }

    public BitmapPreFillRunner(BitmapPool bitmapPool0, MemoryCache memoryCache0, PreFillQueue preFillQueue0, Clock bitmapPreFillRunner$Clock0, Handler handler0) {
        this.seenTypes = new HashSet();
        this.currentDelay = 40L;
        this.bitmapPool = bitmapPool0;
        this.memoryCache = memoryCache0;
        this.toPrefill = preFillQueue0;
        this.clock = bitmapPreFillRunner$Clock0;
        this.handler = handler0;
    }

    public boolean allocate() {
        Bitmap bitmap0;
        long v = this.clock.now();
        while(!this.toPrefill.isEmpty() && !this.isGcDetected(v)) {
            PreFillType preFillType0 = this.toPrefill.remove();
            if(this.seenTypes.contains(preFillType0)) {
                bitmap0 = Bitmap.createBitmap(preFillType0.getWidth(), preFillType0.getHeight(), preFillType0.getConfig());
            }
            else {
                this.seenTypes.add(preFillType0);
                bitmap0 = this.bitmapPool.getDirty(preFillType0.getWidth(), preFillType0.getHeight(), preFillType0.getConfig());
            }
            int v1 = Util.getBitmapByteSize(bitmap0);
            if(this.getFreeMemoryCacheBytes() >= ((long)v1)) {
                UniqueKey bitmapPreFillRunner$UniqueKey0 = new UniqueKey();
                BitmapResource bitmapResource0 = BitmapResource.obtain(bitmap0, this.bitmapPool);
                this.memoryCache.put(bitmapPreFillRunner$UniqueKey0, bitmapResource0);
            }
            else {
                this.bitmapPool.put(bitmap0);
            }
            if(Log.isLoggable("PreFillRunner", 3)) {
                Log.d("PreFillRunner", "allocated [" + preFillType0.getWidth() + "x" + preFillType0.getHeight() + "] " + preFillType0.getConfig() + " size: " + v1);
            }
        }
        return !this.isCancelled && !this.toPrefill.isEmpty();
    }

    public void cancel() {
        this.isCancelled = true;
    }

    private long getFreeMemoryCacheBytes() {
        return this.memoryCache.getMaxSize() - this.memoryCache.getCurrentSize();
    }

    private long getNextDelay() {
        long v = this.currentDelay;
        this.currentDelay = Math.min(4L * v, BitmapPreFillRunner.MAX_BACKOFF_MS);
        return v;
    }

    private boolean isGcDetected(long v) {
        return this.clock.now() - v >= 0x20L;
    }

    @Override
    public void run() {
        if(this.allocate()) {
            long v = this.getNextDelay();
            this.handler.postDelayed(this, v);
        }
    }
}

