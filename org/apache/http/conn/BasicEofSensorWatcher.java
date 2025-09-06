package org.apache.http.conn;

import java.io.InputStream;

@Deprecated
public class BasicEofSensorWatcher implements EofSensorWatcher {
    protected boolean attemptReuse;
    protected ManagedClientConnection managedConn;

    public BasicEofSensorWatcher(ManagedClientConnection managedClientConnection0, boolean z) {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.conn.EofSensorWatcher
    public boolean eofDetected(InputStream inputStream0) {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.conn.EofSensorWatcher
    public boolean streamAbort(InputStream inputStream0) {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.conn.EofSensorWatcher
    public boolean streamClosed(InputStream inputStream0) {
        throw new RuntimeException("Stub!");
    }
}

