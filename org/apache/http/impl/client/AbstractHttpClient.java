package org.apache.http.impl.client;

import org.apache.http.ConnectionReuseStrategy;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.HttpResponse;
import org.apache.http.HttpResponseInterceptor;
import org.apache.http.auth.AuthSchemeRegistry;
import org.apache.http.client.AuthenticationHandler;
import org.apache.http.client.CookieStore;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.HttpClient;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.RedirectHandler;
import org.apache.http.client.RequestDirector;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.UserTokenHandler;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.ConnectionKeepAliveStrategy;
import org.apache.http.conn.routing.HttpRoutePlanner;
import org.apache.http.cookie.CookieSpecRegistry;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.BasicHttpProcessor;
import org.apache.http.protocol.HttpContext;
import org.apache.http.protocol.HttpProcessor;
import org.apache.http.protocol.HttpRequestExecutor;

@Deprecated
public abstract class AbstractHttpClient implements HttpClient {
    public AbstractHttpClient(ClientConnectionManager clientConnectionManager0, HttpParams httpParams0) {
        throw new RuntimeException("Stub!");
    }

    public void addRequestInterceptor(HttpRequestInterceptor httpRequestInterceptor0) {
        synchronized(this) {
            throw new RuntimeException("Stub!");
        }
    }

    public void addRequestInterceptor(HttpRequestInterceptor httpRequestInterceptor0, int v) {
        synchronized(this) {
            throw new RuntimeException("Stub!");
        }
    }

    public void addResponseInterceptor(HttpResponseInterceptor httpResponseInterceptor0) {
        synchronized(this) {
            throw new RuntimeException("Stub!");
        }
    }

    public void addResponseInterceptor(HttpResponseInterceptor httpResponseInterceptor0, int v) {
        synchronized(this) {
            throw new RuntimeException("Stub!");
        }
    }

    public void clearRequestInterceptors() {
        synchronized(this) {
            throw new RuntimeException("Stub!");
        }
    }

    public void clearResponseInterceptors() {
        synchronized(this) {
            throw new RuntimeException("Stub!");
        }
    }

    public abstract AuthSchemeRegistry createAuthSchemeRegistry();

    public abstract ClientConnectionManager createClientConnectionManager();

    public RequestDirector createClientRequestDirector(HttpRequestExecutor httpRequestExecutor0, ClientConnectionManager clientConnectionManager0, ConnectionReuseStrategy connectionReuseStrategy0, ConnectionKeepAliveStrategy connectionKeepAliveStrategy0, HttpRoutePlanner httpRoutePlanner0, HttpProcessor httpProcessor0, HttpRequestRetryHandler httpRequestRetryHandler0, RedirectHandler redirectHandler0, AuthenticationHandler authenticationHandler0, AuthenticationHandler authenticationHandler1, UserTokenHandler userTokenHandler0, HttpParams httpParams0) {
        throw new RuntimeException("Stub!");
    }

    public abstract ConnectionKeepAliveStrategy createConnectionKeepAliveStrategy();

    public abstract ConnectionReuseStrategy createConnectionReuseStrategy();

    public abstract CookieSpecRegistry createCookieSpecRegistry();

    public abstract CookieStore createCookieStore();

    public abstract CredentialsProvider createCredentialsProvider();

    public abstract HttpContext createHttpContext();

    public abstract HttpParams createHttpParams();

    public abstract BasicHttpProcessor createHttpProcessor();

    public abstract HttpRequestRetryHandler createHttpRequestRetryHandler();

    public abstract HttpRoutePlanner createHttpRoutePlanner();

    public abstract AuthenticationHandler createProxyAuthenticationHandler();

    public abstract RedirectHandler createRedirectHandler();

    public abstract HttpRequestExecutor createRequestExecutor();

    public abstract AuthenticationHandler createTargetAuthenticationHandler();

    public abstract UserTokenHandler createUserTokenHandler();

    public HttpParams determineParams(HttpRequest httpRequest0) {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.client.HttpClient
    public Object execute(HttpHost httpHost0, HttpRequest httpRequest0, ResponseHandler responseHandler0) {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.client.HttpClient
    public Object execute(HttpHost httpHost0, HttpRequest httpRequest0, ResponseHandler responseHandler0, HttpContext httpContext0) {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.client.HttpClient
    public Object execute(HttpUriRequest httpUriRequest0, ResponseHandler responseHandler0) {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.client.HttpClient
    public Object execute(HttpUriRequest httpUriRequest0, ResponseHandler responseHandler0, HttpContext httpContext0) {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.client.HttpClient
    public final HttpResponse execute(HttpHost httpHost0, HttpRequest httpRequest0) {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.client.HttpClient
    public final HttpResponse execute(HttpHost httpHost0, HttpRequest httpRequest0, HttpContext httpContext0) {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.client.HttpClient
    public final HttpResponse execute(HttpUriRequest httpUriRequest0) {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.client.HttpClient
    public final HttpResponse execute(HttpUriRequest httpUriRequest0, HttpContext httpContext0) {
        throw new RuntimeException("Stub!");
    }

    public final AuthSchemeRegistry getAuthSchemes() {
        synchronized(this) {
            throw new RuntimeException("Stub!");
        }
    }

    public final ConnectionKeepAliveStrategy getConnectionKeepAliveStrategy() {
        synchronized(this) {
            throw new RuntimeException("Stub!");
        }
    }

    @Override  // org.apache.http.client.HttpClient
    public final ClientConnectionManager getConnectionManager() {
        synchronized(this) {
            throw new RuntimeException("Stub!");
        }
    }

    public final ConnectionReuseStrategy getConnectionReuseStrategy() {
        synchronized(this) {
            throw new RuntimeException("Stub!");
        }
    }

    public final CookieSpecRegistry getCookieSpecs() {
        synchronized(this) {
            throw new RuntimeException("Stub!");
        }
    }

    public final CookieStore getCookieStore() {
        synchronized(this) {
            throw new RuntimeException("Stub!");
        }
    }

    public final CredentialsProvider getCredentialsProvider() {
        synchronized(this) {
            throw new RuntimeException("Stub!");
        }
    }

    public final BasicHttpProcessor getHttpProcessor() {
        synchronized(this) {
            throw new RuntimeException("Stub!");
        }
    }

    public final HttpRequestRetryHandler getHttpRequestRetryHandler() {
        synchronized(this) {
            throw new RuntimeException("Stub!");
        }
    }

    @Override  // org.apache.http.client.HttpClient
    public final HttpParams getParams() {
        synchronized(this) {
            throw new RuntimeException("Stub!");
        }
    }

    public final AuthenticationHandler getProxyAuthenticationHandler() {
        synchronized(this) {
            throw new RuntimeException("Stub!");
        }
    }

    public final RedirectHandler getRedirectHandler() {
        synchronized(this) {
            throw new RuntimeException("Stub!");
        }
    }

    public final HttpRequestExecutor getRequestExecutor() {
        synchronized(this) {
            throw new RuntimeException("Stub!");
        }
    }

    public HttpRequestInterceptor getRequestInterceptor(int v) {
        synchronized(this) {
            throw new RuntimeException("Stub!");
        }
    }

    public int getRequestInterceptorCount() {
        synchronized(this) {
            throw new RuntimeException("Stub!");
        }
    }

    public HttpResponseInterceptor getResponseInterceptor(int v) {
        synchronized(this) {
            throw new RuntimeException("Stub!");
        }
    }

    public int getResponseInterceptorCount() {
        synchronized(this) {
            throw new RuntimeException("Stub!");
        }
    }

    public final HttpRoutePlanner getRoutePlanner() {
        synchronized(this) {
            throw new RuntimeException("Stub!");
        }
    }

    public final AuthenticationHandler getTargetAuthenticationHandler() {
        synchronized(this) {
            throw new RuntimeException("Stub!");
        }
    }

    public final UserTokenHandler getUserTokenHandler() {
        synchronized(this) {
            throw new RuntimeException("Stub!");
        }
    }

    public void removeRequestInterceptorByClass(Class class0) {
        throw new RuntimeException("Stub!");
    }

    public void removeResponseInterceptorByClass(Class class0) {
        throw new RuntimeException("Stub!");
    }

    public void setAuthSchemes(AuthSchemeRegistry authSchemeRegistry0) {
        synchronized(this) {
            throw new RuntimeException("Stub!");
        }
    }

    public void setCookieSpecs(CookieSpecRegistry cookieSpecRegistry0) {
        synchronized(this) {
            throw new RuntimeException("Stub!");
        }
    }

    public void setCookieStore(CookieStore cookieStore0) {
        synchronized(this) {
            throw new RuntimeException("Stub!");
        }
    }

    public void setCredentialsProvider(CredentialsProvider credentialsProvider0) {
        synchronized(this) {
            throw new RuntimeException("Stub!");
        }
    }

    public void setHttpRequestRetryHandler(HttpRequestRetryHandler httpRequestRetryHandler0) {
        synchronized(this) {
            throw new RuntimeException("Stub!");
        }
    }

    public void setKeepAliveStrategy(ConnectionKeepAliveStrategy connectionKeepAliveStrategy0) {
        synchronized(this) {
            throw new RuntimeException("Stub!");
        }
    }

    public void setParams(HttpParams httpParams0) {
        synchronized(this) {
            throw new RuntimeException("Stub!");
        }
    }

    public void setProxyAuthenticationHandler(AuthenticationHandler authenticationHandler0) {
        synchronized(this) {
            throw new RuntimeException("Stub!");
        }
    }

    public void setRedirectHandler(RedirectHandler redirectHandler0) {
        synchronized(this) {
            throw new RuntimeException("Stub!");
        }
    }

    public void setReuseStrategy(ConnectionReuseStrategy connectionReuseStrategy0) {
        synchronized(this) {
            throw new RuntimeException("Stub!");
        }
    }

    public void setRoutePlanner(HttpRoutePlanner httpRoutePlanner0) {
        synchronized(this) {
            throw new RuntimeException("Stub!");
        }
    }

    public void setTargetAuthenticationHandler(AuthenticationHandler authenticationHandler0) {
        synchronized(this) {
            throw new RuntimeException("Stub!");
        }
    }

    public void setUserTokenHandler(UserTokenHandler userTokenHandler0) {
        synchronized(this) {
            throw new RuntimeException("Stub!");
        }
    }
}

