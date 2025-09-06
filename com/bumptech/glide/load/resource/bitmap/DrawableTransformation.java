package com.bumptech.glide.load.resource.bitmap;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import java.security.MessageDigest;

public class DrawableTransformation implements Transformation {
    private final boolean isRequired;
    private final Transformation wrapped;

    public DrawableTransformation(Transformation transformation0, boolean z) {
        this.wrapped = transformation0;
        this.isRequired = z;
    }

    public Transformation asBitmapDrawable() [...] // Inlined contents

    // 去混淆评级： 低(20)
    @Override  // com.bumptech.glide.load.Key
    public boolean equals(Object object0) {
        return object0 instanceof DrawableTransformation ? this.wrapped.equals(((DrawableTransformation)object0).wrapped) : false;
    }

    @Override  // com.bumptech.glide.load.Key
    public int hashCode() {
        return this.wrapped.hashCode();
    }

    private Resource newDrawableResource(Context context0, Resource resource0) {
        return LazyBitmapDrawableResource.obtain(context0.getResources(), resource0);
    }

    @Override  // com.bumptech.glide.load.Transformation
    public Resource transform(Context context0, Resource resource0, int v, int v1) {
        BitmapPool bitmapPool0 = Glide.get(context0).getBitmapPool();
        Drawable drawable0 = (Drawable)resource0.get();
        Resource resource1 = DrawableToBitmapConverter.convert(bitmapPool0, drawable0, v, v1);
        if(resource1 == null) {
            if(this.isRequired) {
                throw new IllegalArgumentException("Unable to convert " + drawable0 + " to a Bitmap");
            }
            return resource0;
        }
        Resource resource2 = this.wrapped.transform(context0, resource1, v, v1);
        if(resource2.equals(resource1)) {
            resource2.recycle();
            return resource0;
        }
        return this.newDrawableResource(context0, resource2);
    }

    @Override  // com.bumptech.glide.load.Key
    public void updateDiskCacheKey(MessageDigest messageDigest0) {
        this.wrapped.updateDiskCacheKey(messageDigest0);
    }
}

