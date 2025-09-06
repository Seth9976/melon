package com.bumptech.glide.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Queue;

@Deprecated
public class ExceptionCatchingInputStream extends InputStream {
    private static final Queue QUEUE;
    private IOException exception;
    private InputStream wrapped;

    static {
        ExceptionCatchingInputStream.QUEUE = Util.createQueue(0);
    }

    @Override
    public int available() {
        return this.wrapped.available();
    }

    public static void clearQueue() {
        while(true) {
            Queue queue0 = ExceptionCatchingInputStream.QUEUE;
            if(queue0.isEmpty()) {
                break;
            }
            queue0.remove();
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

    public static ExceptionCatchingInputStream obtain(InputStream inputStream0) {
        ExceptionCatchingInputStream exceptionCatchingInputStream0;
        synchronized(ExceptionCatchingInputStream.QUEUE) {
            exceptionCatchingInputStream0 = (ExceptionCatchingInputStream)ExceptionCatchingInputStream.QUEUE.poll();
        }
        if(exceptionCatchingInputStream0 == null) {
            exceptionCatchingInputStream0 = new ExceptionCatchingInputStream();
        }
        exceptionCatchingInputStream0.setInputStream(inputStream0);
        return exceptionCatchingInputStream0;
    }

    @Override
    public int read() {
        try {
            return this.wrapped.read();
        }
        catch(IOException iOException0) {
            this.exception = iOException0;
            return -1;
        }
    }

    @Override
    public int read(byte[] arr_b) {
        try {
            return this.wrapped.read(arr_b);
        }
        catch(IOException iOException0) {
            this.exception = iOException0;
            return -1;
        }
    }

    @Override
    public int read(byte[] arr_b, int v, int v1) {
        try {
            return this.wrapped.read(arr_b, v, v1);
        }
        catch(IOException iOException0) {
            this.exception = iOException0;
            return -1;
        }
    }

    public void release() {
        this.exception = null;
        this.wrapped = null;
        synchronized(ExceptionCatchingInputStream.QUEUE) {
            ExceptionCatchingInputStream.QUEUE.offer(this);
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
            return 0L;
        }
    }
}

