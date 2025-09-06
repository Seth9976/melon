package com.bumptech.glide.request.target;

import android.graphics.drawable.Drawable;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;

public abstract class ThumbnailImageViewTarget extends ImageViewTarget {
    public ThumbnailImageViewTarget(ImageView imageView0) {
        super(imageView0);
    }

    @Deprecated
    public ThumbnailImageViewTarget(ImageView imageView0, boolean z) {
        super(imageView0, z);
    }

    public abstract Drawable getDrawable(Object arg1);

    @Override  // com.bumptech.glide.request.target.ImageViewTarget
    public void setResource(Object object0) {
        ViewGroup.LayoutParams viewGroup$LayoutParams0 = ((ImageView)this.view).getLayoutParams();
        Drawable drawable0 = this.getDrawable(object0);
        if(viewGroup$LayoutParams0 != null && viewGroup$LayoutParams0.width > 0 && viewGroup$LayoutParams0.height > 0) {
            drawable0 = new FixedSizeDrawable(drawable0, viewGroup$LayoutParams0.width, viewGroup$LayoutParams0.height);
        }
        ((ImageView)this.view).setImageDrawable(drawable0);
    }
}

