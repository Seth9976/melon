package org.apache.http.conn.routing;

import java.net.InetAddress;
import org.apache.http.HttpHost;

@Deprecated
public final class RouteTracker implements RouteInfo {
    public RouteTracker(HttpHost httpHost0, InetAddress inetAddress0) {
        throw new RuntimeException("Stub!");
    }

    public RouteTracker(HttpRoute httpRoute0) {
        throw new RuntimeException("Stub!");
    }

    @Override
    public Object clone() {
        throw new RuntimeException("Stub!");
    }

    public final void connectProxy(HttpHost httpHost0, boolean z) {
        throw new RuntimeException("Stub!");
    }

    public final void connectTarget(boolean z) {
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

    public final boolean isConnected() {
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

    public final void layerProtocol(boolean z) {
        throw new RuntimeException("Stub!");
    }

    public final HttpRoute toRoute() {
        throw new RuntimeException("Stub!");
    }

    @Override
    public final String toString() {
        throw new RuntimeException("Stub!");
    }

    public final void tunnelProxy(HttpHost httpHost0, boolean z) {
        throw new RuntimeException("Stub!");
    }

    public final void tunnelTarget(boolean z) {
        throw new RuntimeException("Stub!");
    }
}

