package com.bumptech.glide.load.resource.gif;

import android.graphics.Bitmap.Config;
import android.graphics.Bitmap;
import com.bumptech.glide.gifdecoder.GifDecoder.BitmapProvider;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;

public final class GifBitmapProvider implements BitmapProvider {
    private final ArrayPool arrayPool;
    private final BitmapPool bitmapPool;

    public GifBitmapProvider(BitmapPool bitmapPool0) {
        this(bitmapPool0, null);
    }

    public GifBitmapProvider(BitmapPool bitmapPool0, ArrayPool arrayPool0) {
        this.bitmapPool = bitmapPool0;
        this.arrayPool = arrayPool0;
    }

    @Override  // com.bumptech.glide.gifdecoder.GifDecoder$BitmapProvider
    public Bitmap obtain(int v, int v1, Bitmap.Config bitmap$Config0) {
        return this.bitmapPool.getDirty(v, v1, bitmap$Config0);
    }

    @Override  // com.bumptech.glide.gifdecoder.GifDecoder$BitmapProvider
    public byte[] obtainByteArray(int v) {
        return this.arrayPool == null ? new byte[v] : ((byte[])this.arrayPool.get(v, byte[].class));
    }

    @Override  // com.bumptech.glide.gifdecoder.GifDecoder$BitmapProvider
    public int[] obtainIntArray(int v) {
        return this.arrayPool == null ? new int[v] : ((int[])this.arrayPool.get(v, int[].class));
    }

    @Override  // com.bumptech.glide.gifdecoder.GifDecoder$BitmapProvider
    public void release(Bitmap bitmap0) {
        this.bitmapPool.put(bitmap0);
    }

    @Override  // com.bumptech.glide.gifdecoder.GifDecoder$BitmapProvider
    public void release(byte[] arr_b) {
        ArrayPool arrayPool0 = this.arrayPool;
        if(arrayPool0 == null) {
            return;
        }
        arrayPool0.put(arr_b);
    }

    @Override  // com.bumptech.glide.gifdecoder.GifDecoder$BitmapProvider
    public void release(int[] arr_v) {
        ArrayPool arrayPool0 = this.arrayPool;
        if(arrayPool0 == null) {
            return;
        }
        arrayPool0.put(arr_v);
    }
}

