package com.google.firebase.messaging;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public final class d extends FilterInputStream {
    public long a;
    public long b;

    public d(InputStream inputStream0) {
        super(inputStream0);
        this.b = -1L;
        this.a = 0x100001L;
    }

    @Override
    public final int available() {
        return (int)Math.min(this.in.available(), this.a);
    }

    @Override
    public final void mark(int v) {
        synchronized(this) {
            this.in.mark(v);
            this.b = this.a;
        }
    }

    @Override
    public final int read() {
        if(Long.compare(this.a, 0L) == 0) {
            return -1;
        }
        int v = this.in.read();
        if(v != -1) {
            --this.a;
        }
        return v;
    }

    @Override
    public final int read(byte[] arr_b, int v, int v1) {
        long v2 = this.a;
        if(Long.compare(v2, 0L) == 0) {
            return -1;
        }
        int v3 = this.in.read(arr_b, v, ((int)Math.min(v1, v2)));
        if(v3 != -1) {
            this.a -= (long)v3;
        }
        return v3;
    }

    @Override
    public final void reset() {
        synchronized(this) {
            if(this.in.markSupported()) {
                if(this.b == -1L) {
                    throw new IOException("Mark not set");
                }
                this.in.reset();
                this.a = this.b;
                return;
            }
        }
        throw new IOException("Mark not supported");
    }

    @Override
    public final long skip(long v) {
        long v1 = this.in.skip(Math.min(v, this.a));
        this.a -= v1;
        return v1;
    }
}

