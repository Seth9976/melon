package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import com.bumptech.glide.load.engine.Initializable;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.Util;

public class BitmapResource implements Initializable, Resource {
    private final Bitmap bitmap;
    private final BitmapPool bitmapPool;

    public BitmapResource(Bitmap bitmap0, BitmapPool bitmapPool0) {
        this.bitmap = (Bitmap)Preconditions.checkNotNull(bitmap0, "Bitmap must not be null");
        this.bitmapPool = (BitmapPool)Preconditions.checkNotNull(bitmapPool0, "BitmapPool must not be null");
    }

    public Bitmap get() {
        return this.bitmap;
    }

    @Override  // com.bumptech.glide.load.engine.Resource
    public Object get() {
        return this.get();
    }

    @Override  // com.bumptech.glide.load.engine.Resource
    public Class getResourceClass() {
        return Bitmap.class;
    }

    @Override  // com.bumptech.glide.load.engine.Resource
    public int getSize() {
        return Util.getBitmapByteSize(this.bitmap);
    }

    @Override  // com.bumptech.glide.load.engine.Initializable
    public void initialize() {
        this.bitmap.prepareToDraw();
    }

    public static BitmapResource obtain(Bitmap bitmap0, BitmapPool bitmapPool0) {
        return bitmap0 == null ? null : new BitmapResource(bitmap0, bitmapPool0);
    }

    @Override  // com.bumptech.glide.load.engine.Resource
    public void recycle() {
        this.bitmapPool.put(this.bitmap);
    }
}

