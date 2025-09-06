package com.iloen.melon.mcache;

import java.io.Closeable;

public class CachingJNI implements Closeable {
    public final long a;

    static {
        System.loadLibrary("mcache");
    }

    public CachingJNI(String s, long v) {
        this.a = this.initialize(s.getBytes(), v);
    }

    private native int AES_decrypt(long arg1, byte[] arg2, int arg3, byte[] arg4) {
    }

    public final byte[] c(byte[] arr_b) {
        byte[] arr_b1 = new byte[arr_b.length];
        return this.AES_decrypt(this.a, arr_b, arr_b.length, arr_b1) == 1 ? arr_b1 : null;
    }

    @Override
    public final void close() {
        this.release(this.a);
    }

    public final byte[] f(byte[] arr_b, int v) {
        byte[] arr_b1 = new byte[v];
        return this.AES_decrypt(this.a, arr_b, v, arr_b1) == 1 ? arr_b1 : null;
    }

    private native long initialize(byte[] arg1, long arg2) {
    }

    private native void release(long arg1) {
    }
}

