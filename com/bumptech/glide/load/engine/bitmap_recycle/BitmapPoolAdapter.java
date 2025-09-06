package com.bumptech.glide.load.engine.bitmap_recycle;

import android.graphics.Bitmap.Config;
import android.graphics.Bitmap;

public class BitmapPoolAdapter implements BitmapPool {
    @Override  // com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
    public void clearMemory() {
    }

    @Override  // com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
    public Bitmap get(int v, int v1, Bitmap.Config bitmap$Config0) {
        return Bitmap.createBitmap(v, v1, bitmap$Config0);
    }

    @Override  // com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
    public Bitmap getDirty(int v, int v1, Bitmap.Config bitmap$Config0) {
        return this.get(v, v1, bitmap$Config0);
    }

    @Override  // com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
    public long getMaxSize() {
        return 0L;
    }

    @Override  // com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
    public void put(Bitmap bitmap0) {
        bitmap0.recycle();
    }

    @Override  // com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
    public void setSizeMultiplier(float f) {
    }

    @Override  // com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
    public void trimMemory(int v) {
    }
}

