package org.apache.http.conn.routing;

import java.net.InetAddress;
import org.apache.http.HttpHost;

@Deprecated
public final class HttpRoute implements RouteInfo {
    public HttpRoute(HttpHost httpHost0) {
        throw new RuntimeException("Stub!");
    }

    public HttpRoute(HttpHost httpHost0, InetAddress inetAddress0, HttpHost httpHost1, boolean z) {
        throw new RuntimeException("Stub!");
    }

    public HttpRoute(HttpHost httpHost0, InetAddress inetAddress0, HttpHost httpHost1, boolean z, TunnelType routeInfo$TunnelType0, LayerType routeInfo$LayerType0) {
        throw new RuntimeException("Stub!");
    }

    public HttpRoute(HttpHost httpHost0, InetAddress inetAddress0, boolean z) {
        throw new RuntimeException("Stub!");
    }

    public HttpRoute(HttpHost httpHost0, InetAddress inetAddress0, HttpHost[] arr_httpHost, boolean z, TunnelType routeInfo$TunnelType0, LayerType routeInfo$LayerType0) {
        throw new RuntimeException("Stub!");
    }

    @Override
    public Object clone() {
        throw new RuntimeException("Stub!");
    }

    @Override
    public final boolean equals(Object object0) {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.conn.routing.RouteInfo
    public final int getHopCount() {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.conn.routing.RouteInfo
    public final HttpHost getHopTarget(int v) {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.conn.routing.RouteInfo
    public final LayerType getLayerType() {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.conn.routing.RouteInfo
    public final InetAddress getLocalAddress() {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.conn.routing.RouteInfo
    public final HttpHost getProxyHost() {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.conn.routing.RouteInfo
    public final HttpHost getTargetHost() {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.conn.routing.RouteInfo
    public final TunnelType getTunnelType() {
        throw new RuntimeException("Stub!");
    }

    @Override
    public final int hashCode() {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.conn.routing.RouteInfo
    public final boolean isLayered() {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.conn.routing.RouteInfo
    public final boolean isSecure() {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.conn.routing.RouteInfo
    public final boolean isTunnelled() {
        throw new RuntimeException("Stub!");
    }

    @Override
    public final String toString() {
        throw new RuntimeException("Stub!");
    }
}

