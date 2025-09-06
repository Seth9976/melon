package org.apache.http.impl.conn.tsccm;

import java.util.concurrent.TimeUnit;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.ClientConnectionOperator;
import org.apache.http.conn.ClientConnectionRequest;
import org.apache.http.conn.ManagedClientConnection;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.params.HttpParams;

@Deprecated
public class ThreadSafeClientConnManager implements ClientConnectionManager {
    protected ClientConnectionOperator connOperator;
    protected final AbstractConnPool connectionPool;
    protected SchemeRegistry schemeRegistry;

    public ThreadSafeClientConnManager(HttpParams httpParams0, SchemeRegistry schemeRegistry0) {
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

    public AbstractConnPool createConnectionPool(HttpParams httpParams0) {
        throw new RuntimeException("Stub!");
    }

    @Override
    public void finalize() {
        throw new RuntimeException("Stub!");
    }

    public int getConnectionsInPool() {
        throw new RuntimeException("Stub!");
    }

    public int getConnectionsInPool(HttpRoute httpRoute0) {
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
    public ClientConnectionRequest requestConnection(HttpRoute httpRoute0, Object object0) {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.conn.ClientConnectionManager
    public void shutdown() {
        throw new RuntimeException("Stub!");
    }
}

