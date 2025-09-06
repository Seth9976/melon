package com.bumptech.glide.request.target;

import android.graphics.drawable.Drawable;
import com.bumptech.glide.request.Request;

@Deprecated
public abstract class BaseTarget implements Target {
    private Request request;

    @Override  // com.bumptech.glide.request.target.Target
    public Request getRequest() {
        return this.request;
    }

    @Override  // com.bumptech.glide.manager.LifecycleListener
    public void onDestroy() {
    }

    @Override  // com.bumptech.glide.request.target.Target
    public void onLoadCleared(Drawable drawable0) {
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
    public void setRequest(Request request0) {
        this.request = request0;
    }
}

