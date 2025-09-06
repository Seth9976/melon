package org.apache.http.impl.io;

import java.io.OutputStream;
import org.apache.http.io.HttpTransportMetrics;
import org.apache.http.io.SessionOutputBuffer;
import org.apache.http.params.HttpParams;
import org.apache.http.util.CharArrayBuffer;

@Deprecated
public abstract class AbstractSessionOutputBuffer implements SessionOutputBuffer {
    public AbstractSessionOutputBuffer() {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.io.SessionOutputBuffer
    public void flush() {
        throw new RuntimeException("Stub!");
    }

    public void flushBuffer() {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.io.SessionOutputBuffer
    public HttpTransportMetrics getMetrics() {
        throw new RuntimeException("Stub!");
    }

    public void init(OutputStream outputStream0, int v, HttpParams httpParams0) {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.io.SessionOutputBuffer
    public void write(int v) {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.io.SessionOutputBuffer
    public void write(byte[] arr_b) {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.io.SessionOutputBuffer
    public void write(byte[] arr_b, int v, int v1) {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.io.SessionOutputBuffer
    public void writeLine(String s) {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.io.SessionOutputBuffer
    public void writeLine(CharArrayBuffer charArrayBuffer0) {
        throw new RuntimeException("Stub!");
    }
}

