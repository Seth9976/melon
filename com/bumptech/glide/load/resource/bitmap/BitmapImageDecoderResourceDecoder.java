package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.ImageDecoder.Source;
import android.graphics.ImageDecoder;
import android.util.Log;
import androidx.window.layout.util.a;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPoolAdapter;
import com.bumptech.glide.load.resource.DefaultOnHeaderDecodedListener;

public final class BitmapImageDecoderResourceDecoder implements ResourceDecoder {
    private static final String TAG = "BitmapImageDecoder";
    private final BitmapPool bitmapPool;

    public BitmapImageDecoderResourceDecoder() {
        this.bitmapPool = new BitmapPoolAdapter();
    }

    public Resource decode(ImageDecoder.Source imageDecoder$Source0, int v, int v1, Options options0) {
        Bitmap bitmap0 = ImageDecoder.decodeBitmap(imageDecoder$Source0, new DefaultOnHeaderDecodedListener(v, v1, options0));
        if(Log.isLoggable("BitmapImageDecoder", 2)) {
            Log.v("BitmapImageDecoder", "Decoded [" + bitmap0.getWidth() + "x" + bitmap0.getHeight() + "] for [" + v + "x" + v1 + "]");
        }
        return new BitmapResource(bitmap0, this.bitmapPool);
    }

    @Override  // com.bumptech.glide.load.ResourceDecoder
    public Resource decode(Object object0, int v, int v1, Options options0) {
        return this.decode(a.g(object0), v, v1, options0);
    }

    public boolean handles(ImageDecoder.Source imageDecoder$Source0, Options options0) {
        return true;
    }

    @Override  // com.bumptech.glide.load.ResourceDecoder
    public boolean handles(Object object0, Options options0) {
        return this.handles(((ImageDecoder.Source)object0), options0);
    }
}

