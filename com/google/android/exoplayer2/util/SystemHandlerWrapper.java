package com.google.android.exoplayer2.util;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

final class SystemHandlerWrapper implements HandlerWrapper {
    private final Handler handler;

    public SystemHandlerWrapper(Handler handler0) {
        this.handler = handler0;
    }

    @Override  // com.google.android.exoplayer2.util.HandlerWrapper
    public Looper getLooper() {
        return this.handler.getLooper();
    }

    @Override  // com.google.android.exoplayer2.util.HandlerWrapper
    public Message obtainMessage(int v) {
        return this.handler.obtainMessage(v);
    }

    @Override  // com.google.android.exoplayer2.util.HandlerWrapper
    public Message obtainMessage(int v, int v1, int v2) {
        return this.handler.obtainMessage(v, v1, v2);
    }

    @Override  // com.google.android.exoplayer2.util.HandlerWrapper
    public Message obtainMessage(int v, int v1, int v2, Object object0) {
        return this.handler.obtainMessage(v, v1, v2, object0);
    }

    @Override  // com.google.android.exoplayer2.util.HandlerWrapper
    public Message obtainMessage(int v, Object object0) {
        return this.handler.obtainMessage(v, object0);
    }

    @Override  // com.google.android.exoplayer2.util.HandlerWrapper
    public boolean post(Runnable runnable0) {
        return this.handler.post(runnable0);
    }

    @Override  // com.google.android.exoplayer2.util.HandlerWrapper
    public boolean postDelayed(Runnable runnable0, long v) {
        return this.handler.postDelayed(runnable0, v);
    }

    @Override  // com.google.android.exoplayer2.util.HandlerWrapper
    public void removeCallbacksAndMessages(Object object0) {
        this.handler.removeCallbacksAndMessages(object0);
    }

    @Override  // com.google.android.exoplayer2.util.HandlerWrapper
    public void removeMessages(int v) {
        this.handler.removeMessages(v);
    }

    @Override  // com.google.android.exoplayer2.util.HandlerWrapper
    public boolean sendEmptyMessage(int v) {
        return this.handler.sendEmptyMessage(v);
    }

    @Override  // com.google.android.exoplayer2.util.HandlerWrapper
    public boolean sendEmptyMessageAtTime(int v, long v1) {
        return this.handler.sendEmptyMessageAtTime(v, v1);
    }
}

