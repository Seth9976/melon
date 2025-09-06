package org.apache.http.impl.conn;

import java.net.InetAddress;
import org.apache.http.HttpException;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.ProtocolException;
import org.apache.http.annotation.Immutable;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.conn.SchemePortResolver;
import org.apache.http.conn.UnsupportedSchemeException;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.conn.routing.HttpRoutePlanner;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.Args;

@Immutable
public class DefaultRoutePlanner implements HttpRoutePlanner {
    private final SchemePortResolver schemePortResolver;

    public DefaultRoutePlanner(SchemePortResolver schemePortResolver0) {
        if(schemePortResolver0 == null) {
            schemePortResolver0 = DefaultSchemePortResolver.INSTANCE;
        }
        this.schemePortResolver = schemePortResolver0;
    }

    public HttpHost determineProxy(HttpHost httpHost0, HttpRequest httpRequest0, HttpContext httpContext0) {
        return null;
    }

    @Override  // org.apache.http.conn.routing.HttpRoutePlanner
    public HttpRoute determineRoute(HttpHost httpHost0, HttpRequest httpRequest0, HttpContext httpContext0) {
        Args.notNull(httpRequest0, "Request");
        if(httpHost0 == null) {
            throw new ProtocolException("Target host is not specified");
        }
        RequestConfig requestConfig0 = HttpClientContext.adapt(httpContext0).getRequestConfig();
        InetAddress inetAddress0 = requestConfig0.getLocalAddress();
        HttpHost httpHost1 = requestConfig0.getProxy() == null ? this.determineProxy(httpHost0, httpRequest0, httpContext0) : requestConfig0.getProxy();
        if(httpHost0.getPort() <= 0) {
            try {
                httpHost0 = new HttpHost(httpHost0.getHostName(), this.schemePortResolver.resolve(httpHost0), httpHost0.getSchemeName());
            }
            catch(UnsupportedSchemeException unsupportedSchemeException0) {
                throw new HttpException(unsupportedSchemeException0.getMessage());
            }
        }
        boolean z = httpHost0.getSchemeName().equalsIgnoreCase("https");
        return httpHost1 == null ? new HttpRoute(httpHost0, inetAddress0, z) : new HttpRoute(httpHost0, inetAddress0, httpHost1, z);
    }
}

