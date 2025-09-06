package com.bumptech.glide.load.resource.bitmap;

import android.content.Context;
import android.graphics.Bitmap;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.util.Util;

public abstract class BitmapTransformation implements Transformation {
    public abstract Bitmap transform(BitmapPool arg1, Bitmap arg2, int arg3, int arg4);

    @Override  // com.bumptech.glide.load.Transformation
    public final Resource transform(Context context0, Resource resource0, int v, int v1) {
        if(!Util.isValidDimensions(v, v1)) {
            throw new IllegalArgumentException("Cannot apply transformation on width: " + v + " or height: " + v1 + " less than or equal to zero and not Target.SIZE_ORIGINAL");
        }
        BitmapPool bitmapPool0 = Glide.get(context0).getBitmapPool();
        Bitmap bitmap0 = (Bitmap)resource0.get();
        if(v == 0x80000000) {
            v = bitmap0.getWidth();
        }
        if(v1 == 0x80000000) {
            v1 = bitmap0.getHeight();
        }
        Bitmap bitmap1 = this.transform(bitmapPool0, bitmap0, v, v1);
        return bitmap0.equals(bitmap1) ? resource0 : BitmapResource.obtain(bitmap1, bitmapPool0);
    }
}

