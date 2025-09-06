package com.bumptech.glide.request.target;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

public class BitmapThumbnailImageViewTarget extends ThumbnailImageViewTarget {
    public BitmapThumbnailImageViewTarget(ImageView imageView0) {
        super(imageView0);
    }

    @Deprecated
    public BitmapThumbnailImageViewTarget(ImageView imageView0, boolean z) {
        super(imageView0, z);
    }

    public Drawable getDrawable(Bitmap bitmap0) {
        return new BitmapDrawable(((ImageView)this.view).getResources(), bitmap0);
    }

    @Override  // com.bumptech.glide.request.target.ThumbnailImageViewTarget
    public Drawable getDrawable(Object object0) {
        return this.getDrawable(((Bitmap)object0));
    }
}

