package com.bumptech.glide.request.transition;

import android.graphics.Bitmap;

public class BitmapTransitionFactory extends BitmapContainerTransitionFactory {
    public BitmapTransitionFactory(TransitionFactory transitionFactory0) {
        super(transitionFactory0);
    }

    public Bitmap getBitmap(Bitmap bitmap0) {
        return bitmap0;
    }

    @Override  // com.bumptech.glide.request.transition.BitmapContainerTransitionFactory
    public Bitmap getBitmap(Object object0) {
        return this.getBitmap(((Bitmap)object0));
    }
}

