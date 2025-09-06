package com.bumptech.glide.load.engine.bitmap_recycle;

import android.graphics.Bitmap.Config;
import android.graphics.Bitmap;

public interface BitmapPool {
    void clearMemory();

    Bitmap get(int arg1, int arg2, Bitmap.Config arg3);

    Bitmap getDirty(int arg1, int arg2, Bitmap.Config arg3);

    long getMaxSize();

    void put(Bitmap arg1);

    void setSizeMultiplier(float arg1);

    void trimMemory(int arg1);
}

