package org.apache.http.conn.params;

import java.net.InetAddress;
import org.apache.http.HttpHost;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.params.HttpParams;

@Deprecated
public class ConnRouteParams implements ConnRoutePNames {
    public static final HttpHost NO_HOST;
    public static final HttpRoute NO_ROUTE;

    public ConnRouteParams() {
        throw new RuntimeException("Stub!");
    }

    public static HttpHost getDefaultProxy(HttpParams httpParams0) {
        throw new RuntimeException("Stub!");
    }

    public static HttpRoute getForcedRoute(HttpParams httpParams0) {
        throw new RuntimeException("Stub!");
    }

    public static InetAddress getLocalAddress(HttpParams httpParams0) {
        throw new RuntimeException("Stub!");
    }

    public static void setDefaultProxy(HttpParams httpParams0, HttpHost httpHost0) {
        throw new RuntimeException("Stub!");
    }

    public static void setForcedRoute(HttpParams httpParams0, HttpRoute httpRoute0) {
        throw new RuntimeException("Stub!");
    }

    public static void setLocalAddress(HttpParams httpParams0, InetAddress inetAddress0) {
        throw new RuntimeException("Stub!");
    }
}

