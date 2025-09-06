package com.bumptech.glide.load.resource.bitmap;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.drawable.ResourceDrawableDecoder;

public class ResourceBitmapDecoder implements ResourceDecoder {
    private final BitmapPool bitmapPool;
    private final ResourceDrawableDecoder drawableDecoder;

    public ResourceBitmapDecoder(ResourceDrawableDecoder resourceDrawableDecoder0, BitmapPool bitmapPool0) {
        this.drawableDecoder = resourceDrawableDecoder0;
        this.bitmapPool = bitmapPool0;
    }

    public Resource decode(Uri uri0, int v, int v1, Options options0) {
        Resource resource0 = this.drawableDecoder.decode(uri0, v, v1, options0);
        if(resource0 == null) {
            return null;
        }
        Drawable drawable0 = (Drawable)resource0.get();
        return DrawableToBitmapConverter.convert(this.bitmapPool, drawable0, v, v1);
    }

    @Override  // com.bumptech.glide.load.ResourceDecoder
    public Resource decode(Object object0, int v, int v1, Options options0) {
        return this.decode(((Uri)object0), v, v1, options0);
    }

    public boolean handles(Uri uri0, Options options0) {
        return "android.resource".equals(uri0.getScheme());
    }

    @Override  // com.bumptech.glide.load.ResourceDecoder
    public boolean handles(Object object0, Options options0) {
        return this.handles(((Uri)object0), options0);
    }
}

