package com.bumptech.glide.gifdecoder;

import android.graphics.Bitmap.Config;
import android.graphics.Bitmap;
import java.io.InputStream;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.nio.ByteBuffer;

public interface GifDecoder {
    public interface BitmapProvider {
        Bitmap obtain(int arg1, int arg2, Bitmap.Config arg3);

        byte[] obtainByteArray(int arg1);

        int[] obtainIntArray(int arg1);

        void release(Bitmap arg1);

        void release(byte[] arg1);

        void release(int[] arg1);
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface GifDecodeStatus {
    }

    public static final int STATUS_FORMAT_ERROR = 1;
    public static final int STATUS_OK = 0;
    public static final int STATUS_OPEN_ERROR = 2;
    public static final int STATUS_PARTIAL_DECODE = 3;
    public static final int TOTAL_ITERATION_COUNT_FOREVER;

    void advance();

    void clear();

    int getByteSize();

    int getCurrentFrameIndex();

    ByteBuffer getData();

    int getDelay(int arg1);

    int getFrameCount();

    int getHeight();

    @Deprecated
    int getLoopCount();

    int getNetscapeLoopCount();

    int getNextDelay();

    Bitmap getNextFrame();

    int getStatus();

    int getTotalIterationCount();

    int getWidth();

    int read(InputStream arg1, int arg2);

    int read(byte[] arg1);

    void resetFrameIndex();

    void setData(GifHeader arg1, ByteBuffer arg2);

    void setData(GifHeader arg1, ByteBuffer arg2, int arg3);

    void setData(GifHeader arg1, byte[] arg2);

    void setDefaultBitmapConfig(Bitmap.Config arg1);
}

