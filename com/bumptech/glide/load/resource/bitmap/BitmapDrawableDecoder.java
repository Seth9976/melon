package com.bumptech.glide.load.resource.bitmap;

import android.content.Context;
import android.content.res.Resources;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.util.Preconditions;

public class BitmapDrawableDecoder implements ResourceDecoder {
    private final ResourceDecoder decoder;
    private final Resources resources;

    public BitmapDrawableDecoder(Context context0, ResourceDecoder resourceDecoder0) {
        this(context0.getResources(), resourceDecoder0);
    }

    public BitmapDrawableDecoder(Resources resources0, ResourceDecoder resourceDecoder0) {
        this.resources = (Resources)Preconditions.checkNotNull(resources0);
        this.decoder = (ResourceDecoder)Preconditions.checkNotNull(resourceDecoder0);
    }

    @Deprecated
    public BitmapDrawableDecoder(Resources resources0, BitmapPool bitmapPool0, ResourceDecoder resourceDecoder0) {
        this(resources0, resourceDecoder0);
    }

    @Override  // com.bumptech.glide.load.ResourceDecoder
    public Resource decode(Object object0, int v, int v1, Options options0) {
        Resource resource0 = this.decoder.decode(object0, v, v1, options0);
        return LazyBitmapDrawableResource.obtain(this.resources, resource0);
    }

    @Override  // com.bumptech.glide.load.ResourceDecoder
    public boolean handles(Object object0, Options options0) {
        return this.decoder.handles(object0, options0);
    }
}

