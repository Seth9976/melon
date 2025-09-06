package com.bumptech.glide.load.data;

import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import java.io.OutputStream;

public final class BufferedOutputStream extends OutputStream {
    private ArrayPool arrayPool;
    private byte[] buffer;
    private int index;
    private final OutputStream out;

    public BufferedOutputStream(OutputStream outputStream0, ArrayPool arrayPool0) {
        this(outputStream0, arrayPool0, 0x10000);
    }

    public BufferedOutputStream(OutputStream outputStream0, ArrayPool arrayPool0, int v) {
        this.out = outputStream0;
        this.arrayPool = arrayPool0;
        this.buffer = (byte[])arrayPool0.get(v, byte[].class);
    }

    @Override
    public void close() {
        try {
            this.flush();
        }
        finally {
            this.out.close();
        }
        this.release();
    }

    @Override
    public void flush() {
        this.flushBuffer();
        this.out.flush();
    }

    private void flushBuffer() {
        int v = this.index;
        if(v > 0) {
            this.out.write(this.buffer, 0, v);
            this.index = 0;
        }
    }

    private void maybeFlushBuffer() {
        if(this.index == this.buffer.length) {
            this.flushBuffer();
        }
    }

    private void release() {
        byte[] arr_b = this.buffer;
        if(arr_b != null) {
            this.arrayPool.put(arr_b);
            this.buffer = null;
        }
    }

    @Override
    public void write(int v) {
        int v1 = this.index;
        this.index = v1 + 1;
        this.buffer[v1] = (byte)v;
        this.maybeFlushBuffer();
    }

    @Override
    public void write(byte[] arr_b) {
        this.write(arr_b, 0, arr_b.length);
    }

    @Override
    public void write(byte[] arr_b, int v, int v1) {
        int v2 = 0;
        do {
            int v3 = v1 - v2;
            int v4 = v + v2;
            int v5 = this.index;
            if(v5 == 0 && v3 >= this.buffer.length) {
                this.out.write(arr_b, v4, v3);
                return;
            }
            int v6 = Math.min(v3, this.buffer.length - v5);
            System.arraycopy(arr_b, v4, this.buffer, this.index, v6);
            this.index += v6;
            v2 += v6;
            this.maybeFlushBuffer();
        }
        while(v2 < v1);
    }
}

