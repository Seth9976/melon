package com.bumptech.glide.request.target;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;

public class DrawableThumbnailImageViewTarget extends ThumbnailImageViewTarget {
    public DrawableThumbnailImageViewTarget(ImageView imageView0) {
        super(imageView0);
    }

    @Deprecated
    public DrawableThumbnailImageViewTarget(ImageView imageView0, boolean z) {
        super(imageView0, z);
    }

    public Drawable getDrawable(Drawable drawable0) {
        return drawable0;
    }

    @Override  // com.bumptech.glide.request.target.ThumbnailImageViewTarget
    public Drawable getDrawable(Object object0) {
        return this.getDrawable(((Drawable)object0));
    }
}

