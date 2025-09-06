package org.apache.http.impl.conn;

import java.util.concurrent.TimeUnit;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.ClientConnectionOperator;
import org.apache.http.conn.ClientConnectionRequest;
import org.apache.http.conn.ManagedClientConnection;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.params.HttpParams;

@Deprecated
public class SingleClientConnManager implements ClientConnectionManager {
    public class ConnAdapter extends AbstractPooledConnAdapter {
        public ConnAdapter(PoolEntry singleClientConnManager$PoolEntry0, HttpRoute httpRoute0) {
            super(null, null);
            throw new RuntimeException("Stub!");
        }
    }

    public class PoolEntry extends AbstractPoolEntry {
        public PoolEntry() {
            super(null, null);
            throw new RuntimeException("Stub!");
        }

        public void close() {
            throw new RuntimeException("Stub!");
        }

        public void shutdown() {
            throw new RuntimeException("Stub!");
        }
    }

    public static final String MISUSE_MESSAGE = "Invalid use of SingleClientConnManager: connection still allocated.\nMake sure to release the connection before allocating another one.";
    protected boolean alwaysShutDown;
    protected ClientConnectionOperator connOperator;
    protected long connectionExpiresTime;
    protected volatile boolean isShutDown;
    protected long lastReleaseTime;
    protected ConnAdapter managedConn;
    protected SchemeRegistry schemeRegistry;
    protected PoolEntry uniquePoolEntry;

    public SingleClientConnManager(HttpParams httpParams0, SchemeRegistry schemeRegistry0) {
        throw new RuntimeException("Stub!");
    }

    public final void assertStillUp() {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.conn.ClientConnectionManager
    public void closeExpiredConnections() {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.conn.ClientConnectionManager
    public void closeIdleConnections(long v, TimeUnit timeUnit0) {
        throw new RuntimeException("Stub!");
    }

    public ClientConnectionOperator createConnectionOperator(SchemeRegistry schemeRegistry0) {
        throw new RuntimeException("Stub!");
    }

    @Override
    public void finalize() {
        throw new RuntimeException("Stub!");
    }

    public ManagedClientConnection getConnection(HttpRoute httpRoute0, Object object0) {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.conn.ClientConnectionManager
    public SchemeRegistry getSchemeRegistry() {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.conn.ClientConnectionManager
    public void releaseConnection(ManagedClientConnection managedClientConnection0, long v, TimeUnit timeUnit0) {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.conn.ClientConnectionManager
    public final ClientConnectionRequest requestConnection(HttpRoute httpRoute0, Object object0) {
        throw new RuntimeException("Stub!");
    }

    public void revokeConnection() {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.conn.ClientConnectionManager
    public void shutdown() {
        throw new RuntimeException("Stub!");
    }
}

