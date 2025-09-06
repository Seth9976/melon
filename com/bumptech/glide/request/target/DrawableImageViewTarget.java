package com.bumptech.glide.request.target;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;

public class DrawableImageViewTarget extends ImageViewTarget {
    public DrawableImageViewTarget(ImageView imageView0) {
        super(imageView0);
    }

    @Deprecated
    public DrawableImageViewTarget(ImageView imageView0, boolean z) {
        super(imageView0, z);
    }

    public void setResource(Drawable drawable0) {
        ((ImageView)this.view).setImageDrawable(drawable0);
    }

    @Override  // com.bumptech.glide.request.target.ImageViewTarget
    public void setResource(Object object0) {
        this.setResource(((Drawable)object0));
    }
}

