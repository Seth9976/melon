package org.apache.http.conn.routing;

import java.net.InetAddress;
import org.apache.http.HttpHost;

@Deprecated
public interface RouteInfo {
    public static enum LayerType {
        LAYERED,
        PLAIN;

    }

    public static enum TunnelType {
        PLAIN,
        TUNNELLED;

    }

    int getHopCount();

    HttpHost getHopTarget(int arg1);

    LayerType getLayerType();

    InetAddress getLocalAddress();

    HttpHost getProxyHost();

    HttpHost getTargetHost();

    TunnelType getTunnelType();

    boolean isLayered();

    boolean isSecure();

    boolean isTunnelled();
}

