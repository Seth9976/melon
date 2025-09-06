package com.bumptech.glide.integration.webp;

import android.graphics.Bitmap;
import androidx.annotation.Keep;

@Keep
public class WebpFrame {
    static final int FRAME_DURATION_MS_FOR_MIN = 100;
    static final int MIN_FRAME_DURATION_MS = 11;
    boolean blendPreviousFrame;
    int delay;
    boolean disposeBackgroundColor;
    int ih;
    int iw;
    int ix;
    int iy;
    @Keep
    private long mNativePtr;

    public WebpFrame(long v, int v1, int v2, int v3, int v4, int v5, boolean z, boolean z1) {
        this.mNativePtr = v;
        this.ix = v1;
        this.iy = v2;
        this.iw = v3;
        this.ih = v4;
        this.delay = v5;
        this.blendPreviousFrame = z;
        this.disposeBackgroundColor = z1;
        this.fixFrameDuration();
    }

    public void dispose() {
        this.nativeDispose();
    }

    @Override
    public void finalize() {
        this.nativeFinalize();
    }

    private void fixFrameDuration() {
        if(this.delay < 11) {
            this.delay = 100;
        }
    }

    public int getDurationMs() {
        return this.delay;
    }

    public int getHeight() {
        return this.ih;
    }

    public int getWidth() {
        return this.iw;
    }

    public int getXOffest() {
        return this.ix;
    }

    public int getYOffest() {
        return this.iy;
    }

    public boolean isBlendWithPreviousFrame() {
        return this.blendPreviousFrame;
    }

    private native void nativeDispose() {
    }

    private native void nativeFinalize() {
    }

    private native void nativeRenderFrame(int arg1, int arg2, Bitmap arg3) {
    }

    public void renderFrame(int v, int v1, Bitmap bitmap0) {
        this.nativeRenderFrame(v, v1, bitmap0);
    }

    public boolean shouldDisposeToBackgroundColor() {
        return this.disposeBackgroundColor;
    }
}

