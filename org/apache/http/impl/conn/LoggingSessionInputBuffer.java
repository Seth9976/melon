package org.apache.http.impl.conn;

import org.apache.http.io.HttpTransportMetrics;
import org.apache.http.io.SessionInputBuffer;
import org.apache.http.util.CharArrayBuffer;

@Deprecated
public class LoggingSessionInputBuffer implements SessionInputBuffer {
    public LoggingSessionInputBuffer(SessionInputBuffer sessionInputBuffer0, Wire wire0) {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.io.SessionInputBuffer
    public HttpTransportMetrics getMetrics() {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.io.SessionInputBuffer
    public boolean isDataAvailable(int v) {
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

