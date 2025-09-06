package org.apache.http.impl.conn.tsccm;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import org.apache.http.conn.OperatedClientConnection;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.impl.conn.IdleConnectionHandler;

@Deprecated
public abstract class AbstractConnPool implements RefQueueHandler {
    protected IdleConnectionHandler idleConnHandler;
    protected volatile boolean isShutDown;
    protected Set issuedConnections;
    protected int numConnections;
    protected final Lock poolLock;
    protected ReferenceQueue refQueue;

    public AbstractConnPool() {
        throw new RuntimeException("Stub!");
    }

    public void closeConnection(OperatedClientConnection operatedClientConnection0) {
        throw new RuntimeException("Stub!");
    }

    public void closeExpiredConnections() {
        throw new RuntimeException("Stub!");
    }

    public void closeIdleConnections(long v, TimeUnit timeUnit0) {
        throw new RuntimeException("Stub!");
    }

    public abstract void deleteClosedConnections();

    public void enableConnectionGC() {
        throw new RuntimeException("Stub!");
    }

    public abstract void freeEntry(BasicPoolEntry arg1, boolean arg2, long arg3, TimeUnit arg4);

    public final BasicPoolEntry getEntry(HttpRoute httpRoute0, Object object0, long v, TimeUnit timeUnit0) {
        throw new RuntimeException("Stub!");
    }

    public abstract void handleLostEntry(HttpRoute arg1);

    @Override  // org.apache.http.impl.conn.tsccm.RefQueueHandler
    public void handleReference(Reference reference0) {
        throw new RuntimeException("Stub!");
    }

    public abstract PoolEntryRequest requestPoolEntry(HttpRoute arg1, Object arg2);

    public void shutdown() {
        throw new RuntimeException("Stub!");
    }
}

