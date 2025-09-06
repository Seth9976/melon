package org.apache.http.impl.execchain;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import org.apache.http.ConnectionReuseStrategy;
import org.apache.http.HttpClientConnection;
import org.apache.http.HttpEntity;
import org.apache.http.HttpException;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.HttpResponse;
import org.apache.http.ProtocolException;
import org.apache.http.annotation.Immutable;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpExecutionAware;
import org.apache.http.client.methods.HttpRequestWrapper;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.client.protocol.RequestClientConnControl;
import org.apache.http.client.utils.URIUtilsHC4;
import org.apache.http.conn.ConnectionKeepAliveStrategy;
import org.apache.http.conn.ConnectionRequest;
import org.apache.http.conn.HttpClientConnectionManager;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.impl.conn.ConnectionShutdownException;
import org.apache.http.protocol.HttpProcessor;
import org.apache.http.protocol.HttpRequestExecutor;
import org.apache.http.protocol.ImmutableHttpProcessor;
import org.apache.http.protocol.RequestContentHC4;
import org.apache.http.protocol.RequestTargetHostHC4;
import org.apache.http.protocol.RequestUserAgentHC4;
import org.apache.http.util.Args;
import org.apache.http.util.VersionInfoHC4;

@Immutable
public class MinimalClientExec implements ClientExecChain {
    private final HttpClientConnectionManager connManager;
    private final HttpProcessor httpProcessor;
    private final ConnectionKeepAliveStrategy keepAliveStrategy;
    private final HttpRequestExecutor requestExecutor;
    private final ConnectionReuseStrategy reuseStrategy;

    public MinimalClientExec(HttpRequestExecutor httpRequestExecutor0, HttpClientConnectionManager httpClientConnectionManager0, ConnectionReuseStrategy connectionReuseStrategy0, ConnectionKeepAliveStrategy connectionKeepAliveStrategy0) {
        Args.notNull(httpRequestExecutor0, "HTTP request executor");
        Args.notNull(httpClientConnectionManager0, "Client connection manager");
        Args.notNull(connectionReuseStrategy0, "Connection reuse strategy");
        Args.notNull(connectionKeepAliveStrategy0, "Connection keep alive strategy");
        this.httpProcessor = new ImmutableHttpProcessor(new HttpRequestInterceptor[]{new RequestContentHC4(), new RequestTargetHostHC4(), new RequestClientConnControl(), new RequestUserAgentHC4(VersionInfoHC4.getUserAgent("Apache-HttpClient", "org.apache.http.client", this.getClass()))});
        this.requestExecutor = httpRequestExecutor0;
        this.connManager = httpClientConnectionManager0;
        this.reuseStrategy = connectionReuseStrategy0;
        this.keepAliveStrategy = connectionKeepAliveStrategy0;
    }

    @Override  // org.apache.http.impl.execchain.ClientExecChain
    public CloseableHttpResponse execute(HttpRoute httpRoute0, HttpRequestWrapper httpRequestWrapper0, HttpClientContext httpClientContext0, HttpExecutionAware httpExecutionAware0) {
        HttpHost httpHost0;
        HttpClientConnection httpClientConnection0;
        TimeUnit timeUnit0;
        Args.notNull(httpRoute0, "HTTP route");
        Args.notNull(httpRequestWrapper0, "HTTP request");
        Args.notNull(httpClientContext0, "HTTP context");
        MinimalClientExec.rewriteRequestURI(httpRequestWrapper0, httpRoute0);
        ConnectionRequest connectionRequest0 = this.connManager.requestConnection(httpRoute0, null);
        if(httpExecutionAware0 != null) {
            if(!httpExecutionAware0.isAborted()) {
                httpExecutionAware0.setCancellable(connectionRequest0);
                goto label_11;
            }
            connectionRequest0.cancel();
            throw new RequestAbortedException("Request aborted");
        }
    label_11:
        RequestConfig requestConfig0 = httpClientContext0.getRequestConfig();
        try {
            int v = requestConfig0.getConnectionRequestTimeout();
            timeUnit0 = TimeUnit.MILLISECONDS;
            httpClientConnection0 = connectionRequest0.get((v <= 0 ? 0L : ((long)v)), timeUnit0);
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
        ConnectionHolder connectionHolder0 = new ConnectionHolder(this.connManager, httpClientConnection0);
        try {
            if(httpExecutionAware0 != null) {
                if(!httpExecutionAware0.isAborted()) {
                    httpExecutionAware0.setCancellable(connectionHolder0);
                    goto label_31;
                }
                connectionHolder0.close();
                throw new RequestAbortedException("Request aborted");
            }
        label_31:
            if(!httpClientConnection0.isOpen()) {
                int v1 = requestConfig0.getConnectTimeout();
                HttpClientConnectionManager httpClientConnectionManager0 = this.connManager;
                if(v1 <= 0) {
                    v1 = 0;
                }
                httpClientConnectionManager0.connect(httpClientConnection0, httpRoute0, v1, httpClientContext0);
                this.connManager.routeComplete(httpClientConnection0, httpRoute0, httpClientContext0);
            }
            int v2 = requestConfig0.getSocketTimeout();
            if(v2 >= 0) {
                httpClientConnection0.setSocketTimeout(v2);
            }
            HttpRequest httpRequest0 = httpRequestWrapper0.getOriginal();
            if(httpRequest0 instanceof HttpUriRequest) {
                URI uRI0 = ((HttpUriRequest)httpRequest0).getURI();
                httpHost0 = uRI0.isAbsolute() ? new HttpHost(uRI0.getHost(), uRI0.getPort(), uRI0.getScheme()) : null;
            }
            else {
                httpHost0 = null;
            }
            if(httpHost0 == null) {
                httpHost0 = httpRoute0.getTargetHost();
            }
            httpClientContext0.setAttribute("http.target_host", httpHost0);
            httpClientContext0.setAttribute("http.request", httpRequestWrapper0);
            httpClientContext0.setAttribute("http.connection", httpClientConnection0);
            httpClientContext0.setAttribute("http.route", httpRoute0);
            this.httpProcessor.process(httpRequestWrapper0, httpClientContext0);
            HttpResponse httpResponse0 = this.requestExecutor.execute(httpRequestWrapper0, httpClientConnection0, httpClientContext0);
            this.httpProcessor.process(httpResponse0, httpClientContext0);
            if(this.reuseStrategy.keepAlive(httpResponse0, httpClientContext0)) {
                connectionHolder0.setValidFor(this.keepAliveStrategy.getKeepAliveDuration(httpResponse0, httpClientContext0), timeUnit0);
                connectionHolder0.markReusable();
            }
            else {
                connectionHolder0.markNonReusable();
            }
            HttpEntity httpEntity0 = httpResponse0.getEntity();
            if(httpEntity0 != null && httpEntity0.isStreaming()) {
                return new HttpResponseProxy(httpResponse0, connectionHolder0);
            }
            connectionHolder0.releaseConnection();
            return new HttpResponseProxy(httpResponse0, null);
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
            connectionHolder0.abortConnection();
            throw runtimeException0;
        }
        InterruptedIOException interruptedIOException0 = new InterruptedIOException("Connection has been shut down");
        interruptedIOException0.initCause(connectionShutdownException0);
        throw interruptedIOException0;
    }

    public static void rewriteRequestURI(HttpRequestWrapper httpRequestWrapper0, HttpRoute httpRoute0) {
        try {
            URI uRI0 = httpRequestWrapper0.getURI();
            if(uRI0 != null) {
                httpRequestWrapper0.setURI((uRI0.isAbsolute() ? URIUtilsHC4.rewriteURI(uRI0, null, true) : URIUtilsHC4.rewriteURI(uRI0)));
            }
            return;
        }
        catch(URISyntaxException uRISyntaxException0) {
        }
        throw new ProtocolException("Invalid URI: " + httpRequestWrapper0.getRequestLine().getUri(), uRISyntaxException0);
    }
}

