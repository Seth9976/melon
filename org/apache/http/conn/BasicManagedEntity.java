package org.apache.http.conn;

import java.io.InputStream;
import java.io.OutputStream;
import org.apache.http.HttpEntity;
import org.apache.http.entity.HttpEntityWrapper;

@Deprecated
public class BasicManagedEntity extends HttpEntityWrapper implements ConnectionReleaseTrigger, EofSensorWatcher {
    protected final boolean attemptReuse;
    protected ManagedClientConnection managedConn;

    public BasicManagedEntity(HttpEntity httpEntity0, ManagedClientConnection managedClientConnection0, boolean z) {
        super(null);
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.conn.ConnectionReleaseTrigger
    public void abortConnection() {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.entity.HttpEntityWrapper
    public void consumeContent() {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.conn.EofSensorWatcher
    public boolean eofDetected(InputStream inputStream0) {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.entity.HttpEntityWrapper
    public InputStream getContent() {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.entity.HttpEntityWrapper
    public boolean isRepeatable() {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.conn.ConnectionReleaseTrigger
    public void releaseConnection() {
        throw new RuntimeException("Stub!");
    }

    public void releaseManagedConnection() {
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

    @Override  // org.apache.http.entity.HttpEntityWrapper
    public void writeTo(OutputStream outputStream0) {
        throw new RuntimeException("Stub!");
    }
}

