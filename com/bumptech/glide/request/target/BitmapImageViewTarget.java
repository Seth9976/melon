package com.bumptech.glide.request.target;

import android.graphics.Bitmap;
import android.widget.ImageView;

public class BitmapImageViewTarget extends ImageViewTarget {
    public BitmapImageViewTarget(ImageView imageView0) {
        super(imageView0);
    }

    @Deprecated
    public BitmapImageViewTarget(ImageView imageView0, boolean z) {
        super(imageView0, z);
    }

    public void setResource(Bitmap bitmap0) {
        ((ImageView)this.view).setImageBitmap(bitmap0);
    }

    @Override  // com.bumptech.glide.request.target.ImageViewTarget
    public void setResource(Object object0) {
        this.setResource(((Bitmap)object0));
    }
}

