package com.bumptech.glide.request.target;

import android.graphics.drawable.Drawable;
import com.bumptech.glide.request.Request;
import com.bumptech.glide.util.Util;

public abstract class CustomTarget implements Target {
    private final int height;
    private Request request;
    private final int width;

    public CustomTarget() {
        this(0x80000000, 0x80000000);
    }

    public CustomTarget(int v, int v1) {
        if(!Util.isValidDimensions(v, v1)) {
            throw new IllegalArgumentException("Width and height must both be > 0 or Target#SIZE_ORIGINAL, but given width: " + v + " and height: " + v1);
        }
        this.width = v;
        this.height = v1;
    }

    @Override  // com.bumptech.glide.request.target.Target
    public final Request getRequest() {
        return this.request;
    }

    @Override  // com.bumptech.glide.request.target.Target
    public final void getSize(SizeReadyCallback sizeReadyCallback0) {
        sizeReadyCallback0.onSizeReady(this.width, this.height);
    }

    @Override  // com.bumptech.glide.manager.LifecycleListener
    public void onDestroy() {
    }

    @Override  // com.bumptech.glide.request.target.Target
    public void onLoadFailed(Drawable drawable0) {
    }

    @Override  // com.bumptech.glide.request.target.Target
    public void onLoadStarted(Drawable drawable0) {
    }

    @Override  // com.bumptech.glide.manager.LifecycleListener
    public void onStart() {
    }

    @Override  // com.bumptech.glide.manager.LifecycleListener
    public void onStop() {
    }

    @Override  // com.bumptech.glide.request.target.Target
    public final void removeCallback(SizeReadyCallback sizeReadyCallback0) {
    }

    @Override  // com.bumptech.glide.request.target.Target
    public final void setRequest(Request request0) {
        this.request = request0;
    }
}

