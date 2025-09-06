package org.apache.http.impl.client;

import java.util.concurrent.TimeUnit;
import org.apache.http.HttpException;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.annotation.ThreadSafe;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.Configurable;
import org.apache.http.client.methods.HttpExecutionAware;
import org.apache.http.client.methods.HttpRequestWrapper;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.ClientConnectionRequest;
import org.apache.http.conn.HttpClientConnectionManager;
import org.apache.http.conn.ManagedClientConnection;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.impl.DefaultConnectionReuseStrategyHC4;
import org.apache.http.impl.execchain.MinimalClientExec;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.BasicHttpContextHC4;
import org.apache.http.protocol.HttpContext;
import org.apache.http.protocol.HttpRequestExecutor;
import org.apache.http.util.Args;

@ThreadSafe
class MinimalHttpClient extends CloseableHttpClient {
    private final HttpClientConnectionManager connManager;
    private final HttpParams params;
    private final MinimalClientExec requestExecutor;

    public MinimalHttpClient(HttpClientConnectionManager httpClientConnectionManager0) {
        this.connManager = (HttpClientConnectionManager)Args.notNull(httpClientConnectionManager0, "HTTP connection manager");
        this.requestExecutor = new MinimalClientExec(new HttpRequestExecutor(), httpClientConnectionManager0, DefaultConnectionReuseStrategyHC4.INSTANCE, DefaultConnectionKeepAliveStrategyHC4.INSTANCE);
        this.params = new BasicHttpParams();
    }

    @Override
    public void close() {
        this.connManager.shutdown();
    }

    @Override  // org.apache.http.impl.client.CloseableHttpClient
    public CloseableHttpResponse doExecute(HttpHost httpHost0, HttpRequest httpRequest0, HttpContext httpContext0) {
        Args.notNull(httpHost0, "Target host");
        Args.notNull(httpRequest0, "HTTP request");
        RequestConfig requestConfig0 = null;
        HttpExecutionAware httpExecutionAware0 = httpRequest0 instanceof HttpExecutionAware ? ((HttpExecutionAware)httpRequest0) : null;
        try {
            HttpRequestWrapper httpRequestWrapper0 = HttpRequestWrapper.wrap(httpRequest0);
            if(httpContext0 == null) {
                httpContext0 = new BasicHttpContextHC4();
            }
            HttpClientContext httpClientContext0 = HttpClientContext.adapt(httpContext0);
            HttpRoute httpRoute0 = new HttpRoute(httpHost0);
            if(httpRequest0 instanceof Configurable) {
                requestConfig0 = ((Configurable)httpRequest0).getConfig();
            }
            if(requestConfig0 != null) {
                httpClientContext0.setRequestConfig(requestConfig0);
            }
            return this.requestExecutor.execute(httpRoute0, httpRequestWrapper0, httpClientContext0, httpExecutionAware0);
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
                MinimalHttpClient.this.connManager.closeExpiredConnections();
            }

            @Override  // org.apache.http.conn.ClientConnectionManager
            public void closeIdleConnections(long v, TimeUnit timeUnit0) {
                MinimalHttpClient.this.connManager.closeIdleConnections(v, timeUnit0);
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
                MinimalHttpClient.this.connManager.shutdown();
            }
        };
    }

    @Override  // org.apache.http.client.HttpClient
    public HttpParams getParams() {
        return this.params;
    }
}

