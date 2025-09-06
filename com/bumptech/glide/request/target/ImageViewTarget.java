package com.bumptech.glide.request.target;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.bumptech.glide.request.transition.Transition.ViewAdapter;
import com.bumptech.glide.request.transition.Transition;

public abstract class ImageViewTarget extends ViewTarget implements ViewAdapter {
    private Animatable animatable;

    public ImageViewTarget(ImageView imageView0) {
        super(imageView0);
    }

    @Deprecated
    public ImageViewTarget(ImageView imageView0, boolean z) {
        super(imageView0, z);
    }

    @Override  // com.bumptech.glide.request.transition.Transition$ViewAdapter
    public Drawable getCurrentDrawable() {
        return ((ImageView)this.view).getDrawable();
    }

    private void maybeUpdateAnimatable(Object object0) {
        if(object0 instanceof Animatable) {
            this.animatable = (Animatable)object0;
            ((Animatable)object0).start();
            return;
        }
        this.animatable = null;
    }

    @Override  // com.bumptech.glide.request.target.ViewTarget
    public void onLoadCleared(Drawable drawable0) {
        super.onLoadCleared(drawable0);
        Animatable animatable0 = this.animatable;
        if(animatable0 != null) {
            animatable0.stop();
        }
        this.setResourceInternal(null);
        this.setDrawable(drawable0);
    }

    @Override  // com.bumptech.glide.request.target.BaseTarget
    public void onLoadFailed(Drawable drawable0) {
        super.onLoadFailed(drawable0);
        this.setResourceInternal(null);
        this.setDrawable(drawable0);
    }

    @Override  // com.bumptech.glide.request.target.ViewTarget
    public void onLoadStarted(Drawable drawable0) {
        super.onLoadStarted(drawable0);
        this.setResourceInternal(null);
        this.setDrawable(drawable0);
    }

    @Override  // com.bumptech.glide.request.target.Target
    public void onResourceReady(Object object0, Transition transition0) {
        if(transition0 != null && transition0.transition(object0, this)) {
            this.maybeUpdateAnimatable(object0);
            return;
        }
        this.setResourceInternal(object0);
    }

    @Override  // com.bumptech.glide.request.target.BaseTarget
    public void onStart() {
        Animatable animatable0 = this.animatable;
        if(animatable0 != null) {
            animatable0.start();
        }
    }

    @Override  // com.bumptech.glide.request.target.BaseTarget
    public void onStop() {
        Animatable animatable0 = this.animatable;
        if(animatable0 != null) {
            animatable0.stop();
        }
    }

    @Override  // com.bumptech.glide.request.transition.Transition$ViewAdapter
    public void setDrawable(Drawable drawable0) {
        ((ImageView)this.view).setImageDrawable(drawable0);
    }

    public abstract void setResource(Object arg1);

    private void setResourceInternal(Object object0) {
        this.setResource(object0);
        this.maybeUpdateAnimatable(object0);
    }
}

