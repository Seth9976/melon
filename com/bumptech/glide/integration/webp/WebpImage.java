package com.bumptech.glide.integration.webp;

import androidx.annotation.Keep;
import com.bumptech.glide.util.Preconditions;
import java.nio.ByteBuffer;

@Keep
public class WebpImage {
    private int mBackgroundColor;
    private int mDurationMs;
    private int mFrameCount;
    private int[] mFrameDurations;
    private int mHeigth;
    private int mLoopCount;
    @Keep
    private long mNativePtr;
    private int mWidth;

    static {
        System.loadLibrary("glide-webp");
    }

    @Keep
    public WebpImage(long v, int v1, int v2, int v3, int v4, int[] arr_v, int v5, int v6) {
        if(v == 0L) {
            throw new RuntimeException("internal error: native WebpImage is 0");
        }
        this.mWidth = v1;
        this.mHeigth = v2;
        this.mFrameCount = v3;
        this.mDurationMs = v4;
        this.mFrameDurations = arr_v;
        this.mLoopCount = v5;
        this.fixFrameDurations(arr_v);
        this.mBackgroundColor = v6;
        this.mNativePtr = v;
    }

    public static WebpImage create(byte[] arr_b) {
        Preconditions.checkNotNull(arr_b);
        ByteBuffer byteBuffer0 = ByteBuffer.allocateDirect(arr_b.length);
        byteBuffer0.put(arr_b);
        byteBuffer0.rewind();
        return WebpImage.nativeCreateFromDirectByteBuffer(byteBuffer0);
    }

    public void dispose() {
        this.nativeDispose();
    }

    @Override
    public void finalize() {
        this.nativeFinalize();
    }

    private void fixFrameDurations(int[] arr_v) {
        for(int v = 0; v < arr_v.length; ++v) {
            if(arr_v[v] < 11) {
                arr_v[v] = 100;
            }
        }
    }

    public int getBackgroundColor() {
        return this.mBackgroundColor;
    }

    public int getDuration() {
        return this.mDurationMs;
    }

    public WebpFrame getFrame(int v) {
        return this.nativeGetFrame(v);
    }

    public int getFrameCount() {
        return this.mFrameCount;
    }

    public int[] getFrameDurations() {
        return this.mFrameDurations;
    }

    public WebpFrameInfo getFrameInfo(int v) {
        WebpFrame webpFrame0 = this.getFrame(v);
        try {
            return new WebpFrameInfo(v, webpFrame0);
        }
        finally {
            webpFrame0.dispose();
        }
    }

    public int getHeight() {
        return this.mHeigth;
    }

    public int getLoopCount() {
        return this.mLoopCount;
    }

    public int getSizeInBytes() {
        return this.nativeGetSizeInBytes();
    }

    public int getWidth() {
        return this.mWidth;
    }

    private static native WebpImage nativeCreateFromDirectByteBuffer(ByteBuffer arg0) {
    }

    private native void nativeDispose() {
    }

    private native void nativeFinalize() {
    }

    private native WebpFrame nativeGetFrame(int arg1) {
    }

    private native int nativeGetSizeInBytes() {
    }
}

