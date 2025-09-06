package com.bumptech.glide.util;

import android.text.TextUtils;
import android.util.Log;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public final class ContentLengthInputStream extends FilterInputStream {
    private static final String TAG = "ContentLengthStream";
    private static final int UNKNOWN = -1;
    private final long contentLength;
    private int readSoFar;

    private ContentLengthInputStream(InputStream inputStream0, long v) {
        super(inputStream0);
        this.contentLength = v;
    }

    @Override
    public int available() {
        long v1;
        synchronized(this) {
            v1 = Math.max(this.contentLength - ((long)this.readSoFar), this.in.available());
        }
        return (int)v1;
    }

    private int checkReadSoFarOrThrow(int v) {
        if(v >= 0) {
            this.readSoFar += v;
            return v;
        }
        if(this.contentLength - ((long)this.readSoFar) > 0L) {
            throw new IOException("Failed to read all expected data, expected: " + this.contentLength + ", but read: " + this.readSoFar);
        }
        return v;
    }

    public static InputStream obtain(InputStream inputStream0, long v) {
        return new ContentLengthInputStream(inputStream0, v);
    }

    public static InputStream obtain(InputStream inputStream0, String s) {
        return ContentLengthInputStream.obtain(inputStream0, ((long)ContentLengthInputStream.parseContentLength(s)));
    }

    private static int parseContentLength(String s) {
        if(!TextUtils.isEmpty(s)) {
            try {
                return Integer.parseInt(s);
            }
            catch(NumberFormatException numberFormatException0) {
                if(Log.isLoggable("ContentLengthStream", 3)) {
                    Log.d("ContentLengthStream", "failed to parse content length header: " + s, numberFormatException0);
                }
            }
        }
        return -1;
    }

    @Override
    public int read() {
        synchronized(this) {
            int v1 = super.read();
            this.checkReadSoFarOrThrow((v1 < 0 ? -1 : 1));
            return v1;
        }
    }

    @Override
    public int read(byte[] arr_b) {
        return this.read(arr_b, 0, arr_b.length);
    }

    @Override
    public int read(byte[] arr_b, int v, int v1) {
        synchronized(this) {
            return this.checkReadSoFarOrThrow(super.read(arr_b, v, v1));
        }
    }
}

