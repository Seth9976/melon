package org.apache.http.conn.params;

import org.apache.http.params.HttpParams;

@Deprecated
public final class ConnManagerParams implements ConnManagerPNames {
    public static final int DEFAULT_MAX_TOTAL_CONNECTIONS = 20;

    public ConnManagerParams() {
        throw new RuntimeException("Stub!");
    }

    public static ConnPerRoute getMaxConnectionsPerRoute(HttpParams httpParams0) {
        throw new RuntimeException("Stub!");
    }

    public static int getMaxTotalConnections(HttpParams httpParams0) {
        throw new RuntimeException("Stub!");
    }

    public static long getTimeout(HttpParams httpParams0) {
        throw new RuntimeException("Stub!");
    }

    public static void setMaxConnectionsPerRoute(HttpParams httpParams0, ConnPerRoute connPerRoute0) {
        throw new RuntimeException("Stub!");
    }

    public static void setMaxTotalConnections(HttpParams httpParams0, int v) {
        throw new RuntimeException("Stub!");
    }

    public static void setTimeout(HttpParams httpParams0, long v) {
        throw new RuntimeException("Stub!");
    }
}

