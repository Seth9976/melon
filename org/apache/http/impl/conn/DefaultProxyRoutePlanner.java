package org.apache.http.impl.conn;

import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.annotation.Immutable;
import org.apache.http.conn.SchemePortResolver;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.Args;

@Immutable
public class DefaultProxyRoutePlanner extends DefaultRoutePlanner {
    private final HttpHost proxy;

    public DefaultProxyRoutePlanner(HttpHost httpHost0) {
        this(httpHost0, null);
    }

    public DefaultProxyRoutePlanner(HttpHost httpHost0, SchemePortResolver schemePortResolver0) {
        super(schemePortResolver0);
        this.proxy = (HttpHost)Args.notNull(httpHost0, "Proxy host");
    }

    @Override  // org.apache.http.impl.conn.DefaultRoutePlanner
    public HttpHost determineProxy(HttpHost httpHost0, HttpRequest httpRequest0, HttpContext httpContext0) {
        return this.proxy;
    }
}

