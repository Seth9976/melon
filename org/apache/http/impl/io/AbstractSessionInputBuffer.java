package org.apache.http.impl.io;

import java.io.InputStream;
import org.apache.http.io.HttpTransportMetrics;
import org.apache.http.io.SessionInputBuffer;
import org.apache.http.params.HttpParams;
import org.apache.http.util.CharArrayBuffer;

@Deprecated
public abstract class AbstractSessionInputBuffer implements SessionInputBuffer {
    public AbstractSessionInputBuffer() {
        throw new RuntimeException("Stub!");
    }

    public int fillBuffer() {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.io.SessionInputBuffer
    public HttpTransportMetrics getMetrics() {
        throw new RuntimeException("Stub!");
    }

    public boolean hasBufferedData() {
        throw new RuntimeException("Stub!");
    }

    public void init(InputStream inputStream0, int v, HttpParams httpParams0) {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.io.SessionInputBuffer
    public int read() {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.io.SessionInputBuffer
    public int read(byte[] arr_b) {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.io.SessionInputBuffer
    public int read(byte[] arr_b, int v, int v1) {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.io.SessionInputBuffer
    public int readLine(CharArrayBuffer charArrayBuffer0) {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.io.SessionInputBuffer
    public String readLine() {
        throw new RuntimeException("Stub!");
    }
}

