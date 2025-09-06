package com.bumptech.glide.request.target;

import android.graphics.drawable.Drawable;
import com.bumptech.glide.manager.LifecycleListener;
import com.bumptech.glide.request.Request;
import com.bumptech.glide.request.transition.Transition;

public interface Target extends LifecycleListener {
    public static final int SIZE_ORIGINAL = 0x80000000;

    Request getRequest();

    void getSize(SizeReadyCallback arg1);

    void onLoadCleared(Drawable arg1);

    void onLoadFailed(Drawable arg1);

    void onLoadStarted(Drawable arg1);

    void onResourceReady(Object arg1, Transition arg2);

    void removeCallback(SizeReadyCallback arg1);

    void setRequest(Request arg1);
}

