package org.apache.http.impl.io;

import java.io.OutputStream;
import org.apache.http.io.SessionOutputBuffer;

@Deprecated
public class ChunkedOutputStream extends OutputStream {
    public ChunkedOutputStream(SessionOutputBuffer sessionOutputBuffer0) {
        throw new RuntimeException("Stub!");
    }

    public ChunkedOutputStream(SessionOutputBuffer sessionOutputBuffer0, int v) {
        throw new RuntimeException("Stub!");
    }

    @Override
    public void close() {
        throw new RuntimeException("Stub!");
    }

    public void finish() {
        throw new RuntimeException("Stub!");
    }

    @Override
    public void flush() {
        throw new RuntimeException("Stub!");
    }

    public void flushCache() {
        throw new RuntimeException("Stub!");
    }

    public void flushCacheWithAppend(byte[] arr_b, int v, int v1) {
        throw new RuntimeException("Stub!");
    }

    @Override
    public void write(int v) {
        throw new RuntimeException("Stub!");
    }

    @Override
    public void write(byte[] arr_b) {
        throw new RuntimeException("Stub!");
    }

    @Override
    public void write(byte[] arr_b, int v, int v1) {
        throw new RuntimeException("Stub!");
    }

    public void writeClosingChunk() {
        throw new RuntimeException("Stub!");
    }
}

