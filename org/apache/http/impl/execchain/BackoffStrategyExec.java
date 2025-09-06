package org.apache.http.impl.execchain;

import java.io.IOException;
import java.lang.reflect.UndeclaredThrowableException;
import org.apache.http.HttpException;
import org.apache.http.annotation.Immutable;
import org.apache.http.client.BackoffManager;
import org.apache.http.client.ConnectionBackoffStrategy;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpExecutionAware;
import org.apache.http.client.methods.HttpRequestWrapper;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.util.Args;

@Immutable
public class BackoffStrategyExec implements ClientExecChain {
    private final BackoffManager backoffManager;
    private final ConnectionBackoffStrategy connectionBackoffStrategy;
    private final ClientExecChain requestExecutor;

    public BackoffStrategyExec(ClientExecChain clientExecChain0, ConnectionBackoffStrategy connectionBackoffStrategy0, BackoffManager backoffManager0) {
        Args.notNull(clientExecChain0, "HTTP client request executor");
        Args.notNull(connectionBackoffStrategy0, "Connection backoff strategy");
        Args.notNull(backoffManager0, "Backoff manager");
        this.requestExecutor = clientExecChain0;
        this.connectionBackoffStrategy = connectionBackoffStrategy0;
        this.backoffManager = backoffManager0;
    }

    @Override  // org.apache.http.impl.execchain.ClientExecChain
    public CloseableHttpResponse execute(HttpRoute httpRoute0, HttpRequestWrapper httpRequestWrapper0, HttpClientContext httpClientContext0, HttpExecutionAware httpExecutionAware0) {
        CloseableHttpResponse closeableHttpResponse0;
        Args.notNull(httpRoute0, "HTTP route");
        Args.notNull(httpRequestWrapper0, "HTTP request");
        Args.notNull(httpClientContext0, "HTTP context");
        try {
            closeableHttpResponse0 = this.requestExecutor.execute(httpRoute0, httpRequestWrapper0, httpClientContext0, httpExecutionAware0);
        }
        catch(Exception exception0) {
            if(this.connectionBackoffStrategy.shouldBackoff(exception0)) {
                this.backoffManager.backOff(httpRoute0);
            }
            if(exception0 instanceof RuntimeException) {
                throw (RuntimeException)exception0;
            }
            if(exception0 instanceof HttpException) {
                throw (HttpException)exception0;
            }
            if(exception0 instanceof IOException) {
                throw (IOException)exception0;
            }
            throw new UndeclaredThrowableException(exception0);
        }
        if(this.connectionBackoffStrategy.shouldBackoff(closeableHttpResponse0)) {
            this.backoffManager.backOff(httpRoute0);
            return closeableHttpResponse0;
        }
        this.backoffManager.probe(httpRoute0);
        return closeableHttpResponse0;
    }
}

