package org.apache.http.conn.params;

import java.util.Map;
import org.apache.http.conn.routing.HttpRoute;

@Deprecated
public final class ConnPerRouteBean implements ConnPerRoute {
    public static final int DEFAULT_MAX_CONNECTIONS_PER_ROUTE = 2;

    public ConnPerRouteBean() {
        throw new RuntimeException("Stub!");
    }

    public ConnPerRouteBean(int v) {
        throw new RuntimeException("Stub!");
    }

    public int getDefaultMax() {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.conn.params.ConnPerRoute
    public int getMaxForRoute(HttpRoute httpRoute0) {
        throw new RuntimeException("Stub!");
    }

    public void setDefaultMaxPerRoute(int v) {
        throw new RuntimeException("Stub!");
    }

    public void setMaxForRoute(HttpRoute httpRoute0, int v) {
        throw new RuntimeException("Stub!");
    }

    public void setMaxForRoutes(Map map0) {
        throw new RuntimeException("Stub!");
    }
}

