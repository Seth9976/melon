package org.apache.http.impl.conn;

import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.ProxySelector;
import java.util.List;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.conn.routing.HttpRoutePlanner;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.protocol.HttpContext;

@Deprecated
public class ProxySelectorRoutePlanner implements HttpRoutePlanner {
    protected ProxySelector proxySelector;
    protected SchemeRegistry schemeRegistry;

    public ProxySelectorRoutePlanner(SchemeRegistry schemeRegistry0, ProxySelector proxySelector0) {
        throw new RuntimeException("Stub!");
    }

    public Proxy chooseProxy(List list0, HttpHost httpHost0, HttpRequest httpRequest0, HttpContext httpContext0) {
        throw new RuntimeException("Stub!");
    }

    public HttpHost determineProxy(HttpHost httpHost0, HttpRequest httpRequest0, HttpContext httpContext0) {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.conn.routing.HttpRoutePlanner
    public HttpRoute determineRoute(HttpHost httpHost0, HttpRequest httpRequest0, HttpContext httpContext0) {
        throw new RuntimeException("Stub!");
    }

    public String getHost(InetSocketAddress inetSocketAddress0) {
        throw new RuntimeException("Stub!");
    }

    public ProxySelector getProxySelector() {
        throw new RuntimeException("Stub!");
    }

    public void setProxySelector(ProxySelector proxySelector0) {
        throw new RuntimeException("Stub!");
    }
}

