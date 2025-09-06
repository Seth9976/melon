package org.apache.http.conn;

import java.util.concurrent.TimeUnit;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.conn.scheme.SchemeRegistry;

@Deprecated
public interface ClientConnectionManager {
    void closeExpiredConnections();

    void closeIdleConnections(long arg1, TimeUnit arg2);

    SchemeRegistry getSchemeRegistry();

    void releaseConnection(ManagedClientConnection arg1, long arg2, TimeUnit arg3);

    ClientConnectionRequest requestConnection(HttpRoute arg1, Object arg2);

    void shutdown();
}

