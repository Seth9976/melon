package org.apache.http.conn;

import java.io.InputStream;

@Deprecated
public class EofSensorInputStream extends InputStream implements ConnectionReleaseTrigger {
    protected InputStream wrappedStream;

    public EofSensorInputStream(InputStream inputStream0, EofSensorWatcher eofSensorWatcher0) {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.conn.ConnectionReleaseTrigger
    public void abortConnection() {
        throw new RuntimeException("Stub!");
    }

    @Override
    public int available() {
        throw new RuntimeException("Stub!");
    }

    public void checkAbort() {
        throw new RuntimeException("Stub!");
    }

    public void checkClose() {
        throw new RuntimeException("Stub!");
    }

    public void checkEOF(int v) {
        throw new RuntimeException("Stub!");
    }

    @Override
    public void close() {
        throw new RuntimeException("Stub!");
    }

    public boolean isReadAllowed() {
        throw new RuntimeException("Stub!");
    }

    @Override
    public int read() {
        throw new RuntimeException("Stub!");
    }

    @Override
    public int read(byte[] arr_b) {
        throw new RuntimeException("Stub!");
    }

    @Override
    public int read(byte[] arr_b, int v, int v1) {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.conn.ConnectionReleaseTrigger
    public void releaseConnection() {
        throw new RuntimeException("Stub!");
    }
}

