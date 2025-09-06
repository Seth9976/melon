package com.bumptech.glide.request.target;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

public class ImageViewTargetFactory {
    public ViewTarget buildTarget(ImageView imageView0, Class class0) {
        if(Bitmap.class.equals(class0)) {
            return new BitmapImageViewTarget(imageView0);
        }
        if(!Drawable.class.isAssignableFrom(class0)) {
            throw new IllegalArgumentException("Unhandled class: " + class0 + ", try .as*(Class).transcode(ResourceTranscoder)");
        }
        return new DrawableImageViewTarget(imageView0);
    }
}

