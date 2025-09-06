package com.bumptech.glide.load.engine.bitmap_recycle;

import android.graphics.Bitmap.Config;
import android.graphics.Bitmap;

interface LruPoolStrategy {
    Bitmap get(int arg1, int arg2, Bitmap.Config arg3);

    int getSize(Bitmap arg1);

    String logBitmap(int arg1, int arg2, Bitmap.Config arg3);

    String logBitmap(Bitmap arg1);

    void put(Bitmap arg1);

    Bitmap removeLast();
}

