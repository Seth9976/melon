package org.apache.http.impl.client;

import android.util.Log;
import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.apache.http.HttpException;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.annotation.ThreadSafe;
import org.apache.http.auth.AuthStateHC4;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.CookieStore;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.Configurable;
import org.apache.http.client.methods.HttpExecutionAware;
import org.apache.http.client.methods.HttpRequestWrapper;
import org.apache.http.client.params.HttpClientParamConfig;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.config.Lookup;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.ClientConnectionRequest;
import org.apache.http.conn.HttpClientConnectionManager;
import org.apache.http.conn.ManagedClientConnection;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.conn.routing.HttpRoutePlanner;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.impl.execchain.ClientExecChain;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpParamsNames;
import org.apache.http.protocol.BasicHttpContextHC4;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.Args;

@ThreadSafe
class InternalHttpClient extends CloseableHttpClient {
    private static final String TAG = "HttpClient";
    private final Lookup authSchemeRegistry;
    private final List closeables;
    private final HttpClientConnectionManager connManager;
    private final Lookup cookieSpecRegistry;
    private final CookieStore cookieStore;
    private final CredentialsProvider credentialsProvider;
    private final RequestConfig defaultConfig;
    private final ClientExecChain execChain;
    private final HttpRoutePlanner routePlanner;

    public InternalHttpClient(ClientExecChain clientExecChain0, HttpClientConnectionManager httpClientConnectionManager0, HttpRoutePlanner httpRoutePlanner0, Lookup lookup0, Lookup lookup1, CookieStore cookieStore0, CredentialsProvider credentialsProvider0, RequestConfig requestConfig0, List list0) {
        Args.notNull(clientExecChain0, "HTTP client exec chain");
        Args.notNull(httpClientConnectionManager0, "HTTP connection manager");
        Args.notNull(httpRoutePlanner0, "HTTP route planner");
        this.execChain = clientExecChain0;
        this.connManager = httpClientConnectionManager0;
        this.routePlanner = httpRoutePlanner0;
        this.cookieSpecRegistry = lookup0;
        this.authSchemeRegistry = lookup1;
        this.cookieStore = cookieStore0;
        this.credentialsProvider = credentialsProvider0;
        this.defaultConfig = requestConfig0;
        this.closeables = list0;
    }

    @Override
    public void close() {
        this.connManager.shutdown();
        List list0 = this.closeables;
        if(list0 != null) {
            for(Object object0: list0) {
                Closeable closeable0 = (Closeable)object0;
                try {
                    closeable0.close();
                }
                catch(IOException iOException0) {
                    Log.e("HttpClient", iOException0.getMessage(), iOException0);
                }
            }
        }
    }

    private HttpRoute determineRoute(HttpHost httpHost0, HttpRequest httpRequest0, HttpContext httpContext0) {
        if(httpHost0 == null) {
            httpHost0 = (HttpHost)httpRequest0.getParams().getParameter("http.default-host");
        }
        return this.routePlanner.determineRoute(httpHost0, httpRequest0, httpContext0);
    }

    @Override  // org.apache.http.impl.client.CloseableHttpClient
    public CloseableHttpResponse doExecute(HttpHost httpHost0, HttpRequest httpRequest0, HttpContext httpContext0) {
        Args.notNull(httpRequest0, "HTTP request");
        RequestConfig requestConfig0 = null;
        HttpExecutionAware httpExecutionAware0 = httpRequest0 instanceof HttpExecutionAware ? ((HttpExecutionAware)httpRequest0) : null;
        try {
            HttpRequestWrapper httpRequestWrapper0 = HttpRequestWrapper.wrap(httpRequest0);
            if(httpContext0 == null) {
                httpContext0 = new BasicHttpContextHC4();
            }
            HttpClientContext httpClientContext0 = HttpClientContext.adapt(httpContext0);
            if(httpRequest0 instanceof Configurable) {
                requestConfig0 = ((Configurable)httpRequest0).getConfig();
            }
            if(requestConfig0 == null) {
                HttpParams httpParams0 = httpRequest0.getParams();
                if(!(httpParams0 instanceof HttpParamsNames)) {
                    requestConfig0 = HttpClientParamConfig.getRequestConfig(httpParams0);
                }
                else if(!((HttpParamsNames)httpParams0).getNames().isEmpty()) {
                    requestConfig0 = HttpClientParamConfig.getRequestConfig(httpParams0);
                }
            }
            if(requestConfig0 != null) {
                httpClientContext0.setRequestConfig(requestConfig0);
            }
            this.setupContext(httpClientContext0);
            HttpRoute httpRoute0 = this.determineRoute(httpHost0, httpRequestWrapper0, httpClientContext0);
            return this.execChain.execute(httpRoute0, httpRequestWrapper0, httpClientContext0, httpExecutionAware0);
        }
        catch(HttpException httpException0) {
        }
        throw new ClientProtocolException(httpException0);
    }

    @Override  // org.apache.http.client.HttpClient
    public ClientConnectionManager getConnectionManager() {
        return new ClientConnectionManager() {
            @Override  // org.apache.http.conn.ClientConnectionManager
            public void closeExpiredConnections() {
                InternalHttpClient.this.connManager.closeExpiredConnections();
            }

            @Override  // org.apache.http.conn.ClientConnectionManager
            public void closeIdleConnections(long v, TimeUnit timeUnit0) {
                InternalHttpClient.this.connManager.closeIdleConnections(v, timeUnit0);
            }

            @Override  // org.apache.http.conn.ClientConnectionManager
            public SchemeRegistry getSchemeRegistry() {
                throw new UnsupportedOperationException();
            }

            @Override  // org.apache.http.conn.ClientConnectionManager
            public void releaseConnection(ManagedClientConnection managedClientConnection0, long v, TimeUnit timeUnit0) {
                throw new UnsupportedOperationException();
            }

            @Override  // org.apache.http.conn.ClientConnectionManager
            public ClientConnectionRequest requestConnection(HttpRoute httpRoute0, Object object0) {
                throw new UnsupportedOperationException();
            }

            @Override  // org.apache.http.conn.ClientConnectionManager
            public void shutdown() {
                InternalHttpClient.this.connManager.shutdown();
            }
        };
    }

    @Override  // org.apache.http.client.HttpClient
    public HttpParams getParams() {
        throw new UnsupportedOperationException();
    }

    private void setupContext(HttpClientContext httpClientContext0) {
        if(httpClientContext0.getAttribute("http.auth.target-scope") == null) {
            httpClientContext0.setAttribute("http.auth.target-scope", new AuthStateHC4());
        }
        if(httpClientContext0.getAttribute("http.auth.proxy-scope") == null) {
            httpClientContext0.setAttribute("http.auth.proxy-scope", new AuthStateHC4());
        }
        if(httpClientContext0.getAttribute("http.authscheme-registry") == null) {
            httpClientContext0.setAttribute("http.authscheme-registry", this.authSchemeRegistry);
        }
        if(httpClientContext0.getAttribute("http.cookiespec-registry") == null) {
            httpClientContext0.setAttribute("http.cookiespec-registry", this.cookieSpecRegistry);
        }
        if(httpClientContext0.getAttribute("http.cookie-store") == null) {
            httpClientContext0.setAttribute("http.cookie-store", this.cookieStore);
        }
        if(httpClientContext0.getAttribute("http.auth.credentials-provider") == null) {
            httpClientContext0.setAttribute("http.auth.credentials-provider", this.credentialsProvider);
        }
        if(httpClientContext0.getAttribute("http.request-config") == null) {
            httpClientContext0.setAttribute("http.request-config", this.defaultConfig);
        }
    }
}

