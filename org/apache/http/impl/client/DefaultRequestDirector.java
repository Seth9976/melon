package org.apache.http.impl.client;

import org.apache.http.ConnectionReuseStrategy;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.client.AuthenticationHandler;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.RedirectHandler;
import org.apache.http.client.RequestDirector;
import org.apache.http.client.UserTokenHandler;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.ConnectionKeepAliveStrategy;
import org.apache.http.conn.ManagedClientConnection;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.conn.routing.HttpRoutePlanner;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HttpContext;
import org.apache.http.protocol.HttpProcessor;
import org.apache.http.protocol.HttpRequestExecutor;

@Deprecated
public class DefaultRequestDirector implements RequestDirector {
    protected final ClientConnectionManager connManager;
    protected final HttpProcessor httpProcessor;
    protected final ConnectionKeepAliveStrategy keepAliveStrategy;
    protected ManagedClientConnection managedConn;
    protected final HttpParams params;
    protected final RedirectHandler redirectHandler;
    protected final HttpRequestExecutor requestExec;
    protected final HttpRequestRetryHandler retryHandler;
    protected final ConnectionReuseStrategy reuseStrategy;
    protected final HttpRoutePlanner routePlanner;

    public DefaultRequestDirector(HttpRequestExecutor httpRequestExecutor0, ClientConnectionManager clientConnectionManager0, ConnectionReuseStrategy connectionReuseStrategy0, ConnectionKeepAliveStrategy connectionKeepAliveStrategy0, HttpRoutePlanner httpRoutePlanner0, HttpProcessor httpProcessor0, HttpRequestRetryHandler httpRequestRetryHandler0, RedirectHandler redirectHandler0, AuthenticationHandler authenticationHandler0, AuthenticationHandler authenticationHandler1, UserTokenHandler userTokenHandler0, HttpParams httpParams0) {
        throw new RuntimeException("Stub!");
    }

    public HttpRequest createConnectRequest(HttpRoute httpRoute0, HttpContext httpContext0) {
        throw new RuntimeException("Stub!");
    }

    public boolean createTunnelToProxy(HttpRoute httpRoute0, int v, HttpContext httpContext0) {
        throw new RuntimeException("Stub!");
    }

    public boolean createTunnelToTarget(HttpRoute httpRoute0, HttpContext httpContext0) {
        throw new RuntimeException("Stub!");
    }

    public HttpRoute determineRoute(HttpHost httpHost0, HttpRequest httpRequest0, HttpContext httpContext0) {
        throw new RuntimeException("Stub!");
    }

    public void establishRoute(HttpRoute httpRoute0, HttpContext httpContext0) {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.client.RequestDirector
    public HttpResponse execute(HttpHost httpHost0, HttpRequest httpRequest0, HttpContext httpContext0) {
        throw new RuntimeException("Stub!");
    }

    public RoutedRequest handleResponse(RoutedRequest routedRequest0, HttpResponse httpResponse0, HttpContext httpContext0) {
        throw new RuntimeException("Stub!");
    }

    public void releaseConnection() {
        throw new RuntimeException("Stub!");
    }

    public void rewriteRequestURI(RequestWrapper requestWrapper0, HttpRoute httpRoute0) {
        throw new RuntimeException("Stub!");
    }
}

