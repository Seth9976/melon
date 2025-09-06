package org.apache.http.impl.conn;

import org.apache.http.HttpHost;
import org.apache.http.conn.ClientConnectionOperator;
import org.apache.http.conn.OperatedClientConnection;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.conn.routing.RouteTracker;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HttpContext;

@Deprecated
public abstract class AbstractPoolEntry {
    protected final ClientConnectionOperator connOperator;
    protected final OperatedClientConnection connection;
    protected volatile HttpRoute route;
    protected volatile Object state;
    protected volatile RouteTracker tracker;

    public AbstractPoolEntry(ClientConnectionOperator clientConnectionOperator0, HttpRoute httpRoute0) {
        throw new RuntimeException("Stub!");
    }

    public Object getState() {
        throw new RuntimeException("Stub!");
    }

    public void layerProtocol(HttpContext httpContext0, HttpParams httpParams0) {
        throw new RuntimeException("Stub!");
    }

    public void open(HttpRoute httpRoute0, HttpContext httpContext0, HttpParams httpParams0) {
        throw new RuntimeException("Stub!");
    }

    public void setState(Object object0) {
        throw new RuntimeException("Stub!");
    }

    public void shutdownEntry() {
        throw new RuntimeException("Stub!");
    }

    public void tunnelProxy(HttpHost httpHost0, boolean z, HttpParams httpParams0) {
        throw new RuntimeException("Stub!");
    }

    public void tunnelTarget(boolean z, HttpParams httpParams0) {
        throw new RuntimeException("Stub!");
    }
}

