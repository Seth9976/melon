package com.bumptech.glide.request.target;

import android.graphics.drawable.Drawable;
import android.os.Handler.Callback;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.request.Request;
import com.bumptech.glide.request.transition.Transition;

public final class PreloadTarget extends CustomTarget {
    private static final Handler HANDLER = null;
    private static final int MESSAGE_CLEAR = 1;
    private final RequestManager requestManager;

    static {
        PreloadTarget.HANDLER = new Handler(Looper.getMainLooper(), new Handler.Callback() {
            @Override  // android.os.Handler$Callback
            public boolean handleMessage(Message message0) {
                if(message0.what == 1) {
                    ((PreloadTarget)message0.obj).clear();
                    return true;
                }
                return false;
            }
        });
    }

    private PreloadTarget(RequestManager requestManager0, int v, int v1) {
        super(v, v1);
        this.requestManager = requestManager0;
    }

    public void clear() {
        this.requestManager.clear(this);
    }

    public static PreloadTarget obtain(RequestManager requestManager0, int v, int v1) {
        return new PreloadTarget(requestManager0, v, v1);
    }

    @Override  // com.bumptech.glide.request.target.Target
    public void onLoadCleared(Drawable drawable0) {
    }

    @Override  // com.bumptech.glide.request.target.Target
    public void onResourceReady(Object object0, Transition transition0) {
        Request request0 = this.getRequest();
        if(request0 != null && request0.isComplete()) {
            PreloadTarget.HANDLER.obtainMessage(1, this).sendToTarget();
        }
    }
}

