package com.bumptech.glide.load.resource.gif;

import android.content.Context;
import android.graphics.Bitmap;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.resource.bitmap.BitmapResource;
import com.bumptech.glide.util.Preconditions;
import java.security.MessageDigest;

public class GifDrawableTransformation implements Transformation {
    private final Transformation wrapped;

    public GifDrawableTransformation(Transformation transformation0) {
        this.wrapped = (Transformation)Preconditions.checkNotNull(transformation0);
    }

    // 去混淆评级： 低(20)
    @Override  // com.bumptech.glide.load.Key
    public boolean equals(Object object0) {
        return object0 instanceof GifDrawableTransformation ? this.wrapped.equals(((GifDrawableTransformation)object0).wrapped) : false;
    }

    @Override  // com.bumptech.glide.load.Key
    public int hashCode() {
        return this.wrapped.hashCode();
    }

    @Override  // com.bumptech.glide.load.Transformation
    public Resource transform(Context context0, Resource resource0, int v, int v1) {
        GifDrawable gifDrawable0 = (GifDrawable)resource0.get();
        BitmapResource bitmapResource0 = new BitmapResource(gifDrawable0.getFirstFrame(), Glide.get(context0).getBitmapPool());
        Resource resource1 = this.wrapped.transform(context0, bitmapResource0, v, v1);
        if(!bitmapResource0.equals(resource1)) {
            bitmapResource0.recycle();
        }
        Bitmap bitmap0 = (Bitmap)resource1.get();
        gifDrawable0.setFrameTransformation(this.wrapped, bitmap0);
        return resource0;
    }

    @Override  // com.bumptech.glide.load.Key
    public void updateDiskCacheKey(MessageDigest messageDigest0) {
        this.wrapped.updateDiskCacheKey(messageDigest0);
    }
}

