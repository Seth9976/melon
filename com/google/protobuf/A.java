package com.google.protobuf;

import java.io.FilterInputStream;
import java.io.InputStream;

public final class a extends FilterInputStream {
    public final int a;
    public int b;

    public a(int v, InputStream inputStream0, int v1) {
        this.a = v1;
        super(inputStream0);
        this.b = v;
    }

    @Override
    public final int available() {
        return Math.min(super.available(), this.b);
    }

    @Override
    public final int read() {
        if(this.a != 0) {
            if(this.b <= 0) {
                return -1;
            }
            int v = super.read();
            if(v >= 0) {
                --this.b;
            }
            return v;
        }
        if(this.b <= 0) {
            return -1;
        }
        int v1 = super.read();
        if(v1 >= 0) {
            --this.b;
        }
        return v1;
    }

    @Override
    public final int read(byte[] arr_b, int v, int v1) {
        if(this.a != 0) {
            int v2 = this.b;
            if(v2 <= 0) {
                return -1;
            }
            int v3 = super.read(arr_b, v, Math.min(v1, v2));
            if(v3 >= 0) {
                this.b -= v3;
            }
            return v3;
        }
        int v4 = this.b;
        if(v4 <= 0) {
            return -1;
        }
        int v5 = super.read(arr_b, v, Math.min(v1, v4));
        if(v5 >= 0) {
            this.b -= v5;
        }
        return v5;
    }

    @Override
    public final long skip(long v) {
        if(this.a != 0) {
            long v1 = super.skip(Math.min(v, this.b));
            if(v1 >= 0L) {
                this.b = (int)(((long)this.b) - v1);
            }
            return v1;
        }
        int v2 = (int)super.skip(Math.min(v, this.b));
        if(v2 >= 0) {
            this.b -= v2;
        }
        return (long)v2;
    }
}

