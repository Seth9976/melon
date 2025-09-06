package com.bumptech.glide.load.resource.transcode;

import android.content.Context;
import android.content.res.Resources;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.LazyBitmapDrawableResource;
import com.bumptech.glide.util.Preconditions;

public class BitmapDrawableTranscoder implements ResourceTranscoder {
    private final Resources resources;

    public BitmapDrawableTranscoder(Context context0) {
        this(context0.getResources());
    }

    public BitmapDrawableTranscoder(Resources resources0) {
        this.resources = (Resources)Preconditions.checkNotNull(resources0);
    }

    @Deprecated
    public BitmapDrawableTranscoder(Resources resources0, BitmapPool bitmapPool0) {
        this(resources0);
    }

    @Override  // com.bumptech.glide.load.resource.transcode.ResourceTranscoder
    public Resource transcode(Resource resource0, Options options0) {
        return LazyBitmapDrawableResource.obtain(this.resources, resource0);
    }
}

