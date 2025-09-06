package com.bumptech.glide.load.resource.bitmap;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.util.Preconditions;
import java.security.MessageDigest;

@Deprecated
public class BitmapDrawableTransformation implements Transformation {
    private final Transformation wrapped;

    public BitmapDrawableTransformation(Transformation transformation0) {
        this.wrapped = (Transformation)Preconditions.checkNotNull(new DrawableTransformation(transformation0, false));
    }

    private static Resource convertToBitmapDrawableResource(Resource resource0) {
        if(!(resource0.get() instanceof BitmapDrawable)) {
            throw new IllegalArgumentException("Wrapped transformation unexpectedly returned a non BitmapDrawable resource: " + resource0.get());
        }
        return resource0;
    }

    private static Resource convertToDrawableResource(Resource resource0) [...] // Inlined contents

    // 去混淆评级： 低(20)
    @Override  // com.bumptech.glide.load.Key
    public boolean equals(Object object0) {
        return object0 instanceof BitmapDrawableTransformation ? this.wrapped.equals(((BitmapDrawableTransformation)object0).wrapped) : false;
    }

    @Override  // com.bumptech.glide.load.Key
    public int hashCode() {
        return this.wrapped.hashCode();
    }

    @Override  // com.bumptech.glide.load.Transformation
    public Resource transform(Context context0, Resource resource0, int v, int v1) {
        return BitmapDrawableTransformation.convertToBitmapDrawableResource(this.wrapped.transform(context0, resource0, v, v1));
    }

    @Override  // com.bumptech.glide.load.Key
    public void updateDiskCacheKey(MessageDigest messageDigest0) {
        this.wrapped.updateDiskCacheKey(messageDigest0);
    }
}

