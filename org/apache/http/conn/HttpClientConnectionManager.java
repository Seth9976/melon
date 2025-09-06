package org.apache.http.conn;

import java.util.concurrent.TimeUnit;
import org.apache.http.HttpClientConnection;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.protocol.HttpContext;

public interface HttpClientConnectionManager {
    void closeExpiredConnections();

    void closeIdleConnections(long arg1, TimeUnit arg2);

    void connect(HttpClientConnection arg1, HttpRoute arg2, int arg3, HttpContext arg4);

    void releaseConnection(HttpClientConnection arg1, Object arg2, long arg3, TimeUnit arg4);

    ConnectionRequest requestConnection(HttpRoute arg1, Object arg2);

    void routeComplete(HttpClientConnection arg1, HttpRoute arg2, HttpContext arg3);

    void shutdown();

    void upgrade(HttpClientConnection arg1, HttpRoute arg2, HttpContext arg3);
}

