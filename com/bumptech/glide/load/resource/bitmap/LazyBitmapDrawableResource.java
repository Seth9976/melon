package com.bumptech.glide.load.resource.bitmap;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.Initializable;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.util.Preconditions;

public final class LazyBitmapDrawableResource implements Initializable, Resource {
    private final Resource bitmapResource;
    private final Resources resources;

    private LazyBitmapDrawableResource(Resources resources0, Resource resource0) {
        this.resources = (Resources)Preconditions.checkNotNull(resources0);
        this.bitmapResource = (Resource)Preconditions.checkNotNull(resource0);
    }

    public BitmapDrawable get() {
        Bitmap bitmap0 = (Bitmap)this.bitmapResource.get();
        return new BitmapDrawable(this.resources, bitmap0);
    }

    @Override  // com.bumptech.glide.load.engine.Resource
    public Object get() {
        return this.get();
    }

    @Override  // com.bumptech.glide.load.engine.Resource
    public Class getResourceClass() {
        return BitmapDrawable.class;
    }

    @Override  // com.bumptech.glide.load.engine.Resource
    public int getSize() {
        return this.bitmapResource.getSize();
    }

    @Override  // com.bumptech.glide.load.engine.Initializable
    public void initialize() {
        Resource resource0 = this.bitmapResource;
        if(resource0 instanceof Initializable) {
            ((Initializable)resource0).initialize();
        }
    }

    public static Resource obtain(Resources resources0, Resource resource0) {
        return resource0 == null ? null : new LazyBitmapDrawableResource(resources0, resource0);
    }

    @Deprecated
    public static LazyBitmapDrawableResource obtain(Context context0, Bitmap bitmap0) {
        return (LazyBitmapDrawableResource)LazyBitmapDrawableResource.obtain(context0.getResources(), BitmapResource.obtain(bitmap0, Glide.get(context0).getBitmapPool()));
    }

    @Deprecated
    public static LazyBitmapDrawableResource obtain(Resources resources0, BitmapPool bitmapPool0, Bitmap bitmap0) {
        return (LazyBitmapDrawableResource)LazyBitmapDrawableResource.obtain(resources0, BitmapResource.obtain(bitmap0, bitmapPool0));
    }

    @Override  // com.bumptech.glide.load.engine.Resource
    public void recycle() {
        this.bitmapResource.recycle();
    }
}

