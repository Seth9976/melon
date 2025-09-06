package com.bumptech.glide.util;

import java.io.FilterInputStream;
import java.io.InputStream;

public class MarkEnforcingInputStream extends FilterInputStream {
    private static final int END_OF_STREAM = -1;
    private static final int UNSET = 0x80000000;
    private int availableBytes;

    public MarkEnforcingInputStream(InputStream inputStream0) {
        super(inputStream0);
        this.availableBytes = 0x80000000;
    }

    @Override
    public int available() {
        return this.availableBytes == 0x80000000 ? super.available() : Math.min(this.availableBytes, super.available());
    }

    private long getBytesToRead(long v) {
        int v1 = this.availableBytes;
        if(v1 == 0) {
            return -1L;
        }
        return v1 == 0x80000000 || v <= ((long)v1) ? v : ((long)v1);
    }

    @Override
    public void mark(int v) {
        synchronized(this) {
            super.mark(v);
            this.availableBytes = v;
        }
    }

    @Override
    public int read() {
        if(this.getBytesToRead(1L) == -1L) {
            return -1;
        }
        int v = super.read();
        this.updateAvailableBytesAfterRead(1L);
        return v;
    }

    @Override
    public int read(byte[] arr_b, int v, int v1) {
        int v2 = (int)this.getBytesToRead(((long)v1));
        if(v2 == -1) {
            return -1;
        }
        int v3 = super.read(arr_b, v, v2);
        this.updateAvailableBytesAfterRead(((long)v3));
        return v3;
    }

    @Override
    public void reset() {
        synchronized(this) {
            super.reset();
            this.availableBytes = 0x80000000;
        }
    }

    @Override
    public long skip(long v) {
        long v1 = this.getBytesToRead(v);
        if(v1 == -1L) {
            return 0L;
        }
        long v2 = super.skip(v1);
        this.updateAvailableBytesAfterRead(v2);
        return v2;
    }

    private void updateAvailableBytesAfterRead(long v) {
        int v1 = this.availableBytes;
        if(v1 != 0x80000000 && v != -1L) {
            this.availableBytes = (int)(((long)v1) - v);
        }
    }
}

