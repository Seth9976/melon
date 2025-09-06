package com.bumptech.glide.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Queue;

public final class ExceptionPassthroughInputStream extends InputStream {
    private static final Queue POOL;
    private IOException exception;
    private InputStream wrapped;

    static {
        ExceptionPassthroughInputStream.POOL = Util.createQueue(0);
    }

    @Override
    public int available() {
        return this.wrapped.available();
    }

    public static void clearQueue() {
        synchronized(ExceptionPassthroughInputStream.POOL) {
            while(true) {
                Queue queue1 = ExceptionPassthroughInputStream.POOL;
                if(queue1.isEmpty()) {
                    break;
                }
                queue1.remove();
            }
        }
    }

    @Override
    public void close() {
        this.wrapped.close();
    }

    public IOException getException() {
        return this.exception;
    }

    @Override
    public void mark(int v) {
        this.wrapped.mark(v);
    }

    @Override
    public boolean markSupported() {
        return this.wrapped.markSupported();
    }

    public static ExceptionPassthroughInputStream obtain(InputStream inputStream0) {
        ExceptionPassthroughInputStream exceptionPassthroughInputStream0;
        synchronized(ExceptionPassthroughInputStream.POOL) {
            exceptionPassthroughInputStream0 = (ExceptionPassthroughInputStream)ExceptionPassthroughInputStream.POOL.poll();
        }
        if(exceptionPassthroughInputStream0 == null) {
            exceptionPassthroughInputStream0 = new ExceptionPassthroughInputStream();
        }
        exceptionPassthroughInputStream0.setInputStream(inputStream0);
        return exceptionPassthroughInputStream0;
    }

    @Override
    public int read() {
        try {
            return this.wrapped.read();
        }
        catch(IOException iOException0) {
            this.exception = iOException0;
            throw iOException0;
        }
    }

    @Override
    public int read(byte[] arr_b) {
        try {
            return this.wrapped.read(arr_b);
        }
        catch(IOException iOException0) {
            this.exception = iOException0;
            throw iOException0;
        }
    }

    @Override
    public int read(byte[] arr_b, int v, int v1) {
        try {
            return this.wrapped.read(arr_b, v, v1);
        }
        catch(IOException iOException0) {
            this.exception = iOException0;
            throw iOException0;
        }
    }

    public void release() {
        this.exception = null;
        this.wrapped = null;
        synchronized(ExceptionPassthroughInputStream.POOL) {
            ExceptionPassthroughInputStream.POOL.offer(this);
        }
    }

    @Override
    public void reset() {
        synchronized(this) {
            this.wrapped.reset();
        }
    }

    public void setInputStream(InputStream inputStream0) {
        this.wrapped = inputStream0;
    }

    @Override
    public long skip(long v) {
        try {
            return this.wrapped.skip(v);
        }
        catch(IOException iOException0) {
            this.exception = iOException0;
            throw iOException0;
        }
    }
}

