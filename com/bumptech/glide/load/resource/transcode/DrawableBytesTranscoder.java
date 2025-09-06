package com.bumptech.glide.load.resource.transcode;

import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapResource;
import com.bumptech.glide.load.resource.gif.GifDrawable;

public final class DrawableBytesTranscoder implements ResourceTranscoder {
    private final ResourceTranscoder bitmapBytesTranscoder;
    private final BitmapPool bitmapPool;
    private final ResourceTranscoder gifDrawableBytesTranscoder;

    public DrawableBytesTranscoder(BitmapPool bitmapPool0, ResourceTranscoder resourceTranscoder0, ResourceTranscoder resourceTranscoder1) {
        this.bitmapPool = bitmapPool0;
        this.bitmapBytesTranscoder = resourceTranscoder0;
        this.gifDrawableBytesTranscoder = resourceTranscoder1;
    }

    private static Resource toGifDrawableResource(Resource resource0) [...] // Inlined contents

    @Override  // com.bumptech.glide.load.resource.transcode.ResourceTranscoder
    public Resource transcode(Resource resource0, Options options0) {
        Drawable drawable0 = (Drawable)resource0.get();
        if(drawable0 instanceof BitmapDrawable) {
            BitmapResource bitmapResource0 = BitmapResource.obtain(((BitmapDrawable)drawable0).getBitmap(), this.bitmapPool);
            return this.bitmapBytesTranscoder.transcode(bitmapResource0, options0);
        }
        return drawable0 instanceof GifDrawable ? this.gifDrawableBytesTranscoder.transcode(resource0, options0) : null;
    }
}

