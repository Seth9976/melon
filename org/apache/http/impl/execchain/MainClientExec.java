package org.apache.http.impl.execchain;

import android.util.Log;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import org.apache.http.ConnectionReuseStrategy;
import org.apache.http.HttpClientConnection;
import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpException;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.HttpResponse;
import org.apache.http.annotation.Immutable;
import org.apache.http.auth.AuthProtocolState;
import org.apache.http.auth.AuthStateHC4;
import org.apache.http.client.AuthenticationStrategy;
import org.apache.http.client.NonRepeatableRequestException;
import org.apache.http.client.UserTokenHandler;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpExecutionAware;
import org.apache.http.client.methods.HttpRequestWrapper;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.client.protocol.RequestClientConnControl;
import org.apache.http.conn.ConnectionKeepAliveStrategy;
import org.apache.http.conn.ConnectionRequest;
import org.apache.http.conn.HttpClientConnectionManager;
import org.apache.http.conn.routing.BasicRouteDirector;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.conn.routing.HttpRouteDirector;
import org.apache.http.conn.routing.RouteTracker;
import org.apache.http.entity.BufferedHttpEntityHC4;
import org.apache.http.impl.auth.HttpAuthenticator;
import org.apache.http.impl.conn.ConnectionShutdownException;
import org.apache.http.message.BasicHttpRequest;
import org.apache.http.protocol.HttpProcessor;
import org.apache.http.protocol.HttpRequestExecutor;
import org.apache.http.protocol.ImmutableHttpProcessor;
import org.apache.http.protocol.RequestTargetHostHC4;
import org.apache.http.util.Args;
import org.apache.http.util.EntityUtilsHC4;

@Immutable
public class MainClientExec implements ClientExecChain {
    private static final String TAG = "HttpClient";
    private final HttpAuthenticator authenticator;
    private final HttpClientConnectionManager connManager;
    private final ConnectionKeepAliveStrategy keepAliveStrategy;
    private final AuthenticationStrategy proxyAuthStrategy;
    private final HttpProcessor proxyHttpProcessor;
    private final HttpRequestExecutor requestExecutor;
    private final ConnectionReuseStrategy reuseStrategy;
    private final HttpRouteDirector routeDirector;
    private final AuthenticationStrategy targetAuthStrategy;
    private final UserTokenHandler userTokenHandler;

    public MainClientExec(HttpRequestExecutor httpRequestExecutor0, HttpClientConnectionManager httpClientConnectionManager0, ConnectionReuseStrategy connectionReuseStrategy0, ConnectionKeepAliveStrategy connectionKeepAliveStrategy0, AuthenticationStrategy authenticationStrategy0, AuthenticationStrategy authenticationStrategy1, UserTokenHandler userTokenHandler0) {
        Args.notNull(httpRequestExecutor0, "HTTP request executor");
        Args.notNull(httpClientConnectionManager0, "Client connection manager");
        Args.notNull(connectionReuseStrategy0, "Connection reuse strategy");
        Args.notNull(connectionKeepAliveStrategy0, "Connection keep alive strategy");
        Args.notNull(authenticationStrategy0, "Target authentication strategy");
        Args.notNull(authenticationStrategy1, "Proxy authentication strategy");
        Args.notNull(userTokenHandler0, "User token handler");
        this.authenticator = new HttpAuthenticator();
        this.proxyHttpProcessor = new ImmutableHttpProcessor(new HttpRequestInterceptor[]{new RequestTargetHostHC4(), new RequestClientConnControl()});
        this.routeDirector = new BasicRouteDirector();
        this.requestExecutor = httpRequestExecutor0;
        this.connManager = httpClientConnectionManager0;
        this.reuseStrategy = connectionReuseStrategy0;
        this.keepAliveStrategy = connectionKeepAliveStrategy0;
        this.targetAuthStrategy = authenticationStrategy0;
        this.proxyAuthStrategy = authenticationStrategy1;
        this.userTokenHandler = userTokenHandler0;
    }

    private boolean createTunnelToProxy(HttpRoute httpRoute0, int v, HttpClientContext httpClientContext0) {
        throw new HttpException("Proxy chains are not supported.");
    }

    private boolean createTunnelToTarget(AuthStateHC4 authStateHC40, HttpClientConnection httpClientConnection0, HttpRoute httpRoute0, HttpRequest httpRequest0, HttpClientContext httpClientContext0) {
        RequestConfig requestConfig0 = httpClientContext0.getRequestConfig();
        int v = requestConfig0.getConnectTimeout();
        HttpHost httpHost0 = httpRoute0.getTargetHost();
        HttpHost httpHost1 = httpRoute0.getProxyHost();
        BasicHttpRequest basicHttpRequest0 = new BasicHttpRequest("CONNECT", httpHost0.toHostString(), httpRequest0.getProtocolVersion());
        this.requestExecutor.preProcess(basicHttpRequest0, this.proxyHttpProcessor, httpClientContext0);
        HttpResponse httpResponse0 = null;
        while(true) {
            int v1 = 0;
            if(httpResponse0 != null) {
                break;
            }
            if(!httpClientConnection0.isOpen()) {
                HttpClientConnectionManager httpClientConnectionManager0 = this.connManager;
                if(v > 0) {
                    v1 = v;
                }
                httpClientConnectionManager0.connect(httpClientConnection0, httpRoute0, v1, httpClientContext0);
            }
            basicHttpRequest0.removeHeaders("Proxy-Authorization");
            this.authenticator.generateAuthResponse(basicHttpRequest0, authStateHC40, httpClientContext0);
            HttpResponse httpResponse1 = this.requestExecutor.execute(basicHttpRequest0, httpClientConnection0, httpClientContext0);
            if(httpResponse1.getStatusLine().getStatusCode() < 200) {
                throw new HttpException("Unexpected response to CONNECT request: " + httpResponse1.getStatusLine());
            }
            if(requestConfig0.isAuthenticationEnabled() && this.authenticator.isAuthenticationRequested(httpHost1, httpResponse1, this.proxyAuthStrategy, authStateHC40, httpClientContext0) && this.authenticator.handleAuthChallenge(httpHost1, httpResponse1, this.proxyAuthStrategy, authStateHC40, httpClientContext0)) {
                if(this.reuseStrategy.keepAlive(httpResponse1, httpClientContext0)) {
                    if(Log.isLoggable("HttpClient", 3)) {
                        Log.d("HttpClient", "Connection kept alive");
                    }
                    EntityUtilsHC4.consume(httpResponse1.getEntity());
                }
                else {
                    httpClientConnection0.close();
                }
                httpResponse0 = null;
            }
            else {
                httpResponse0 = httpResponse1;
            }
        }
        if(httpResponse0.getStatusLine().getStatusCode() > 299) {
            HttpEntity httpEntity0 = httpResponse0.getEntity();
            if(httpEntity0 != null) {
                httpResponse0.setEntity(new BufferedHttpEntityHC4(httpEntity0));
            }
            httpClientConnection0.close();
            throw new TunnelRefusedException("CONNECT refused by proxy: " + httpResponse0.getStatusLine(), httpResponse0);
        }
        return false;
    }

    public void establishRoute(AuthStateHC4 authStateHC40, HttpClientConnection httpClientConnection0, HttpRoute httpRoute0, HttpRequest httpRequest0, HttpClientContext httpClientContext0) {
        int v = httpClientContext0.getRequestConfig().getConnectTimeout();
        RouteTracker routeTracker0 = new RouteTracker(httpRoute0);
        do {
            HttpRoute httpRoute1 = routeTracker0.toRoute();
            int v1 = this.routeDirector.nextStep(httpRoute0, httpRoute1);
            int v2 = 0;
            switch(v1) {
                case -1: {
                    throw new HttpException("Unable to establish route: planned = " + httpRoute0 + "; current = " + httpRoute1);
                }
                case 0: {
                    this.connManager.routeComplete(httpClientConnection0, httpRoute0, httpClientContext0);
                    break;
                }
                case 1: {
                    HttpClientConnectionManager httpClientConnectionManager0 = this.connManager;
                    if(v > 0) {
                        v2 = v;
                    }
                    httpClientConnectionManager0.connect(httpClientConnection0, httpRoute0, v2, httpClientContext0);
                    routeTracker0.connectTarget(httpRoute0.isSecure());
                    break;
                }
                case 2: {
                    this.connManager.connect(httpClientConnection0, httpRoute0, (v <= 0 ? 0 : v), httpClientContext0);
                    routeTracker0.connectProxy(httpRoute0.getProxyHost(), false);
                    break;
                }
                case 3: {
                    boolean z = this.createTunnelToTarget(authStateHC40, httpClientConnection0, httpRoute0, httpRequest0, httpClientContext0);
                    if(Log.isLoggable("HttpClient", 3)) {
                        Log.d("HttpClient", "Tunnel to target created.");
                    }
                    routeTracker0.tunnelTarget(z);
                    break;
                }
                case 4: {
                    int v3 = httpRoute1.getHopCount();
                    boolean z1 = this.createTunnelToProxy(httpRoute0, v3 - 1, httpClientContext0);
                    if(Log.isLoggable("HttpClient", 3)) {
                        Log.d("HttpClient", "Tunnel to proxy created.");
                    }
                    routeTracker0.tunnelProxy(httpRoute0.getHopTarget(v3 - 1), z1);
                    break;
                }
                case 5: {
                    this.connManager.upgrade(httpClientConnection0, httpRoute0, httpClientContext0);
                    routeTracker0.layerProtocol(httpRoute0.isSecure());
                    break;
                }
                default: {
                    throw new IllegalStateException("Unknown step indicator " + v1 + " from RouteDirector.");
                }
            }
        }
        while(v1 > 0);
    }

    @Override  // org.apache.http.impl.execchain.ClientExecChain
    public CloseableHttpResponse execute(HttpRoute httpRoute0, HttpRequestWrapper httpRequestWrapper0, HttpClientContext httpClientContext0, HttpExecutionAware httpExecutionAware0) {
        Object object1;
        HttpResponse httpResponse2;
        String s;
        HttpClientConnection httpClientConnection1;
        AuthStateHC4 authStateHC42;
        HttpResponse httpResponse0;
        HttpClientConnection httpClientConnection0;
        Args.notNull(httpRoute0, "HTTP route");
        Args.notNull(httpRequestWrapper0, "HTTP request");
        Args.notNull(httpClientContext0, "HTTP context");
        AuthStateHC4 authStateHC40 = httpClientContext0.getTargetAuthState();
        if(authStateHC40 == null) {
            authStateHC40 = new AuthStateHC4();
            httpClientContext0.setAttribute("http.auth.target-scope", authStateHC40);
        }
        AuthStateHC4 authStateHC41 = httpClientContext0.getProxyAuthState();
        if(authStateHC41 == null) {
            authStateHC41 = new AuthStateHC4();
            httpClientContext0.setAttribute("http.auth.proxy-scope", authStateHC41);
        }
        if(httpRequestWrapper0 instanceof HttpEntityEnclosingRequest) {
            RequestEntityProxy.enhance(((HttpEntityEnclosingRequest)httpRequestWrapper0));
        }
        Object object0 = httpClientContext0.getUserToken();
        ConnectionRequest connectionRequest0 = this.connManager.requestConnection(httpRoute0, object0);
        if(httpExecutionAware0 != null) {
            if(!httpExecutionAware0.isAborted()) {
                httpExecutionAware0.setCancellable(connectionRequest0);
                goto label_21;
            }
            connectionRequest0.cancel();
            throw new RequestAbortedException("Request aborted");
        }
    label_21:
        RequestConfig requestConfig0 = httpClientContext0.getRequestConfig();
        try {
            int v = requestConfig0.getConnectionRequestTimeout();
            httpClientConnection0 = connectionRequest0.get((v <= 0 ? 0L : ((long)v)), TimeUnit.MILLISECONDS);
        }
        catch(InterruptedException interruptedException0) {
            Thread.currentThread().interrupt();
            throw new RequestAbortedException("Request aborted", interruptedException0);
        }
        catch(ExecutionException executionException0) {
            Throwable throwable0 = executionException0.getCause();
            if(throwable0 != null) {
                executionException0 = throwable0;
            }
            throw new RequestAbortedException("Request execution failed", executionException0);
        }
        httpClientContext0.setAttribute("http.connection", httpClientConnection0);
        if(requestConfig0.isStaleConnectionCheckEnabled() && httpClientConnection0.isOpen()) {
            if(Log.isLoggable("HttpClient", 3)) {
                Log.d("HttpClient", "Stale connection check");
            }
            if(httpClientConnection0.isStale()) {
                if(Log.isLoggable("HttpClient", 3)) {
                    Log.d("HttpClient", "Stale connection detected");
                }
                httpClientConnection0.close();
            }
        }
        ConnectionHolder connectionHolder0 = new ConnectionHolder(this.connManager, httpClientConnection0);
        try {
            if(httpExecutionAware0 != null) {
                httpExecutionAware0.setCancellable(connectionHolder0);
            }
            int v1 = 1;
            while(true) {
                if(v1 > 1 && !RequestEntityProxy.isRepeatable(httpRequestWrapper0)) {
                    throw new NonRepeatableRequestException("Cannot retry request with a non-repeatable request entity.");
                }
                if(httpExecutionAware0 != null && httpExecutionAware0.isAborted()) {
                    throw new RequestAbortedException("Request aborted");
                }
                if(!httpClientConnection0.isOpen()) {
                    if(Log.isLoggable("HttpClient", 3)) {
                        Log.d("HttpClient", "Opening connection " + httpRoute0);
                    }
                    try {
                        this.establishRoute(authStateHC41, httpClientConnection0, httpRoute0, httpRequestWrapper0, httpClientContext0);
                    }
                    catch(TunnelRefusedException tunnelRefusedException0) {
                        if(Log.isLoggable("HttpClient", 3)) {
                            Log.d("HttpClient", tunnelRefusedException0.getMessage());
                        }
                        httpResponse0 = tunnelRefusedException0.getResponse();
                        goto label_99;
                    }
                }
                int v2 = requestConfig0.getSocketTimeout();
                if(v2 >= 0) {
                    httpClientConnection0.setSocketTimeout(v2);
                }
                if(httpExecutionAware0 != null && httpExecutionAware0.isAborted()) {
                    throw new RequestAbortedException("Request aborted");
                }
                if(Log.isLoggable("HttpClient", 3)) {
                    Log.d("HttpClient", "Executing request " + httpRequestWrapper0.getRequestLine());
                }
                if(!httpRequestWrapper0.containsHeader("Authorization")) {
                    if(Log.isLoggable("HttpClient", 3)) {
                        Log.d("HttpClient", "Target auth state: " + authStateHC40.getState());
                    }
                    this.authenticator.generateAuthResponse(httpRequestWrapper0, authStateHC40, httpClientContext0);
                }
                if(!httpRequestWrapper0.containsHeader("Proxy-Authorization") && !httpRoute0.isTunnelled()) {
                    if(Log.isLoggable("HttpClient", 3)) {
                        Log.d("HttpClient", "Proxy auth state: " + authStateHC41.getState());
                    }
                    this.authenticator.generateAuthResponse(httpRequestWrapper0, authStateHC41, httpClientContext0);
                }
                HttpResponse httpResponse1 = this.requestExecutor.execute(httpRequestWrapper0, httpClientConnection0, httpClientContext0);
                if(this.reuseStrategy.keepAlive(httpResponse1, httpClientContext0)) {
                    authStateHC42 = authStateHC41;
                    long v3 = this.keepAliveStrategy.getKeepAliveDuration(httpResponse1, httpClientContext0);
                    if(Log.isLoggable("HttpClient", 3)) {
                        if(v3 > 0L) {
                            httpClientConnection1 = httpClientConnection0;
                            s = "for " + v3 + " " + TimeUnit.MILLISECONDS;
                        }
                        else {
                            httpClientConnection1 = httpClientConnection0;
                            s = "indefinitely";
                        }
                        httpResponse2 = httpResponse1;
                        Log.d("HttpClient", "Connection can be kept alive " + s);
                    }
                    else {
                        httpClientConnection1 = httpClientConnection0;
                        httpResponse2 = httpResponse1;
                    }
                    connectionHolder0.setValidFor(v3, TimeUnit.MILLISECONDS);
                    connectionHolder0.markReusable();
                }
                else {
                    authStateHC42 = authStateHC41;
                    httpClientConnection1 = httpClientConnection0;
                    httpResponse2 = httpResponse1;
                    connectionHolder0.markNonReusable();
                }
                if(!this.needAuthentication(authStateHC40, authStateHC42, httpRoute0, httpResponse2, httpClientContext0)) {
                    httpResponse0 = httpResponse2;
                label_99:
                    if(object0 == null) {
                        object1 = this.userTokenHandler.getUserToken(httpClientContext0);
                        httpClientContext0.setAttribute("http.user-token", object1);
                    }
                    else {
                        object1 = object0;
                    }
                    if(object1 != null) {
                        connectionHolder0.setState(object1);
                    }
                    HttpEntity httpEntity0 = httpResponse0.getEntity();
                    if(httpEntity0 != null && httpEntity0.isStreaming()) {
                        return new HttpResponseProxy(httpResponse0, connectionHolder0);
                    }
                    connectionHolder0.releaseConnection();
                    return new HttpResponseProxy(httpResponse0, null);
                }
                HttpEntity httpEntity1 = httpResponse2.getEntity();
                if(connectionHolder0.isReusable()) {
                    EntityUtilsHC4.consume(httpEntity1);
                }
                else {
                    httpClientConnection1.close();
                    AuthProtocolState authProtocolState0 = AuthProtocolState.SUCCESS;
                    if(authStateHC42.getState() == authProtocolState0 && authStateHC42.getAuthScheme() != null && authStateHC42.getAuthScheme().isConnectionBased()) {
                        if(Log.isLoggable("HttpClient", 3)) {
                            Log.d("HttpClient", "Resetting proxy auth state");
                        }
                        authStateHC42.reset();
                    }
                    if(authStateHC40.getState() == authProtocolState0 && authStateHC40.getAuthScheme() != null && authStateHC40.getAuthScheme().isConnectionBased()) {
                        if(Log.isLoggable("HttpClient", 3)) {
                            Log.d("HttpClient", "Resetting target auth state");
                        }
                        authStateHC40.reset();
                    }
                }
                HttpRequest httpRequest0 = httpRequestWrapper0.getOriginal();
                if(!httpRequest0.containsHeader("Authorization")) {
                    httpRequestWrapper0.removeHeaders("Authorization");
                }
                if(!httpRequest0.containsHeader("Proxy-Authorization")) {
                    httpRequestWrapper0.removeHeaders("Proxy-Authorization");
                }
                ++v1;
                authStateHC41 = authStateHC42;
                httpClientConnection0 = httpClientConnection1;
            }
            goto label_148;
        }
        catch(ConnectionShutdownException connectionShutdownException0) {
        }
        catch(HttpException httpException0) {
            connectionHolder0.abortConnection();
            throw httpException0;
        }
        catch(IOException iOException0) {
            connectionHolder0.abortConnection();
            throw iOException0;
        }
        catch(RuntimeException runtimeException0) {
            goto label_148;
        }
        InterruptedIOException interruptedIOException0 = new InterruptedIOException("Connection has been shut down");
        interruptedIOException0.initCause(connectionShutdownException0);
        throw interruptedIOException0;
    label_148:
        connectionHolder0.abortConnection();
        throw runtimeException0;
    }

    private boolean needAuthentication(AuthStateHC4 authStateHC40, AuthStateHC4 authStateHC41, HttpRoute httpRoute0, HttpResponse httpResponse0, HttpClientContext httpClientContext0) {
        if(httpClientContext0.getRequestConfig().isAuthenticationEnabled()) {
            HttpHost httpHost0 = httpClientContext0.getTargetHost();
            if(httpHost0 == null) {
                httpHost0 = httpRoute0.getTargetHost();
            }
            HttpHost httpHost1 = httpHost0.getPort() >= 0 ? httpHost0 : new HttpHost(httpHost0.getHostName(), httpRoute0.getTargetHost().getPort(), httpHost0.getSchemeName());
            boolean z = this.authenticator.isAuthenticationRequested(httpHost1, httpResponse0, this.targetAuthStrategy, authStateHC40, httpClientContext0);
            HttpHost httpHost2 = httpRoute0.getProxyHost();
            if(httpHost2 == null) {
                httpHost2 = httpRoute0.getTargetHost();
            }
            boolean z1 = this.authenticator.isAuthenticationRequested(httpHost2, httpResponse0, this.proxyAuthStrategy, authStateHC41, httpClientContext0);
            if(z) {
                return this.authenticator.handleAuthChallenge(httpHost1, httpResponse0, this.targetAuthStrategy, authStateHC40, httpClientContext0);
            }
            return z1 ? this.authenticator.handleAuthChallenge(httpHost2, httpResponse0, this.proxyAuthStrategy, authStateHC41, httpClientContext0) : false;
        }
        return false;
    }
}

