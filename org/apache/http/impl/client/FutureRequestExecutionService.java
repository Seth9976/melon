package org.apache.http.impl.client;

import java.io.Closeable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;
import org.apache.http.annotation.ThreadSafe;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.concurrent.FutureCallback;
import org.apache.http.protocol.HttpContext;

@ThreadSafe
public class FutureRequestExecutionService implements Closeable {
    private final AtomicBoolean closed;
    private final ExecutorService executorService;
    private final HttpClient httpclient;
    private final FutureRequestExecutionMetrics metrics;

    public FutureRequestExecutionService(HttpClient httpClient0, ExecutorService executorService0) {
        this.metrics = new FutureRequestExecutionMetrics();
        this.closed = new AtomicBoolean(false);
        this.httpclient = httpClient0;
        this.executorService = executorService0;
    }

    @Override
    public void close() {
        this.closed.set(true);
        this.executorService.shutdownNow();
        HttpClient httpClient0 = this.httpclient;
        if(httpClient0 instanceof Closeable) {
            ((Closeable)httpClient0).close();
        }
    }

    public HttpRequestFutureTask execute(HttpUriRequest httpUriRequest0, HttpContext httpContext0, ResponseHandler responseHandler0) {
        return this.execute(httpUriRequest0, httpContext0, responseHandler0, null);
    }

    public HttpRequestFutureTask execute(HttpUriRequest httpUriRequest0, HttpContext httpContext0, ResponseHandler responseHandler0, FutureCallback futureCallback0) {
        if(this.closed.get()) {
            throw new IllegalStateException("Close has been called on this httpclient instance.");
        }
        this.metrics.getScheduledConnections().incrementAndGet();
        HttpRequestFutureTask httpRequestFutureTask0 = new HttpRequestFutureTask(httpUriRequest0, new HttpRequestTaskCallable(this.httpclient, httpUriRequest0, httpContext0, responseHandler0, futureCallback0, this.metrics));
        this.executorService.execute(httpRequestFutureTask0);
        return httpRequestFutureTask0;
    }

    public FutureRequestExecutionMetrics metrics() {
        return this.metrics;
    }
}

