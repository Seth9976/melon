package com.bumptech.glide.load.resource.gif;

import com.bumptech.glide.gifdecoder.GifDecoder;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapResource;

public final class GifFrameResourceDecoder implements ResourceDecoder {
    private final BitmapPool bitmapPool;

    public GifFrameResourceDecoder(BitmapPool bitmapPool0) {
        this.bitmapPool = bitmapPool0;
    }

    public Resource decode(GifDecoder gifDecoder0, int v, int v1, Options options0) {
        return BitmapResource.obtain(gifDecoder0.getNextFrame(), this.bitmapPool);
    }

    @Override  // com.bumptech.glide.load.ResourceDecoder
    public Resource decode(Object object0, int v, int v1, Options options0) {
        return this.decode(((GifDecoder)object0), v, v1, options0);
    }

    public boolean handles(GifDecoder gifDecoder0, Options options0) {
        return true;
    }

    @Override  // com.bumptech.glide.load.ResourceDecoder
    public boolean handles(Object object0, Options options0) {
        return this.handles(((GifDecoder)object0), options0);
    }
}

