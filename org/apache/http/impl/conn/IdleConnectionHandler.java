package org.apache.http.impl.conn;

import java.util.concurrent.TimeUnit;
import org.apache.http.HttpConnection;

@Deprecated
public class IdleConnectionHandler {
    public IdleConnectionHandler() {
        throw new RuntimeException("Stub!");
    }

    public void add(HttpConnection httpConnection0, long v, TimeUnit timeUnit0) {
        throw new RuntimeException("Stub!");
    }

    public void closeExpiredConnections() {
        throw new RuntimeException("Stub!");
    }

    public void closeIdleConnections(long v) {
        throw new RuntimeException("Stub!");
    }

    public boolean remove(HttpConnection httpConnection0) {
        throw new RuntimeException("Stub!");
    }

    public void removeAll() {
        throw new RuntimeException("Stub!");
    }
}

