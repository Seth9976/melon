package org.apache.http.impl.io;

import java.io.IOException;
import java.io.OutputStream;
import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.io.SessionOutputBuffer;

@NotThreadSafe
public class ChunkedOutputStreamHC4 extends OutputStream {
    private final byte[] cache;
    private int cachePosition;
    private boolean closed;
    private final SessionOutputBuffer out;
    private boolean wroteLastChunk;

    public ChunkedOutputStreamHC4(int v, SessionOutputBuffer sessionOutputBuffer0) {
        this.cachePosition = 0;
        this.wroteLastChunk = false;
        this.closed = false;
        this.cache = new byte[v];
        this.out = sessionOutputBuffer0;
    }

    @Deprecated
    public ChunkedOutputStreamHC4(SessionOutputBuffer sessionOutputBuffer0) {
        this(0x800, sessionOutputBuffer0);
    }

    @Deprecated
    public ChunkedOutputStreamHC4(SessionOutputBuffer sessionOutputBuffer0, int v) {
        this(v, sessionOutputBuffer0);
    }

    @Override
    public void close() {
        if(!this.closed) {
            this.closed = true;
            this.finish();
            this.out.flush();
        }
    }

    public void finish() {
        if(!this.wroteLastChunk) {
            this.flushCache();
            this.writeClosingChunk();
            this.wroteLastChunk = true;
        }
    }

    @Override
    public void flush() {
        this.flushCache();
        this.out.flush();
    }

    public void flushCache() {
        int v = this.cachePosition;
        if(v > 0) {
            this.out.writeLine(Integer.toHexString(v));
            this.out.write(this.cache, 0, this.cachePosition);
            this.out.writeLine("");
            this.cachePosition = 0;
        }
    }

    public void flushCacheWithAppend(byte[] arr_b, int v, int v1) {
        this.out.writeLine(Integer.toHexString(this.cachePosition + v1));
        this.out.write(this.cache, 0, this.cachePosition);
        this.out.write(arr_b, v, v1);
        this.out.writeLine("");
        this.cachePosition = 0;
    }

    @Override
    public void write(int v) {
        if(this.closed) {
            throw new IOException("Attempted write to closed stream.");
        }
        int v1 = this.cachePosition;
        this.cache[v1] = (byte)v;
        this.cachePosition = v1 + 1;
        if(v1 + 1 == this.cache.length) {
            this.flushCache();
        }
    }

    @Override
    public void write(byte[] arr_b) {
        this.write(arr_b, 0, arr_b.length);
    }

    @Override
    public void write(byte[] arr_b, int v, int v1) {
        if(this.closed) {
            throw new IOException("Attempted write to closed stream.");
        }
        byte[] arr_b1 = this.cache;
        int v2 = this.cachePosition;
        if(v1 >= arr_b1.length - v2) {
            this.flushCacheWithAppend(arr_b, v, v1);
            return;
        }
        System.arraycopy(arr_b, v, arr_b1, v2, v1);
        this.cachePosition += v1;
    }

    public void writeClosingChunk() {
        this.out.writeLine("0");
        this.out.writeLine("");
    }
}

