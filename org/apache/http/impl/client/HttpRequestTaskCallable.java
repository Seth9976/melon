package org.apache.http.impl.client;

import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.concurrent.FutureCallback;
import org.apache.http.protocol.HttpContext;

class HttpRequestTaskCallable implements Callable {
    private final FutureCallback callback;
    private final AtomicBoolean cancelled;
    private final HttpContext context;
    private long ended;
    private final HttpClient httpclient;
    private final FutureRequestExecutionMetrics metrics;
    private final HttpUriRequest request;
    private final ResponseHandler responseHandler;
    private final long scheduled;
    private long started;

    public HttpRequestTaskCallable(HttpClient httpClient0, HttpUriRequest httpUriRequest0, HttpContext httpContext0, ResponseHandler responseHandler0, FutureCallback futureCallback0, FutureRequestExecutionMetrics futureRequestExecutionMetrics0) {
        this.cancelled = new AtomicBoolean(false);
        this.scheduled = System.currentTimeMillis();
        this.started = -1L;
        this.ended = -1L;
        this.httpclient = httpClient0;
        this.responseHandler = responseHandler0;
        this.request = httpUriRequest0;
        this.context = httpContext0;
        this.callback = futureCallback0;
        this.metrics = futureRequestExecutionMetrics0;
    }

    @Override
    public Object call() {
        Object object0;
        if(!this.cancelled.get()) {
            try {
                this.metrics.getActiveConnections().incrementAndGet();
                this.started = System.currentTimeMillis();
                try {
                    this.metrics.getScheduledConnections().decrementAndGet();
                    object0 = this.httpclient.execute(this.request, this.responseHandler, this.context);
                    this.ended = System.currentTimeMillis();
                    this.metrics.getSuccessfulConnections().increment(this.started);
                    FutureCallback futureCallback0 = this.callback;
                    if(futureCallback0 != null) {
                        futureCallback0.completed(object0);
                    }
                    return object0;
                }
                catch(Exception exception0) {
                    this.metrics.getFailedConnections().increment(this.started);
                    this.ended = System.currentTimeMillis();
                    FutureCallback futureCallback1 = this.callback;
                    if(futureCallback1 != null) {
                        futureCallback1.failed(exception0);
                    }
                    throw exception0;
                }
            }
            finally {
                this.metrics.getRequests().increment(this.started);
                this.metrics.getTasks().increment(this.started);
                this.metrics.getActiveConnections().decrementAndGet();
            }
        }
        throw new IllegalStateException("call has been cancelled for request " + this.request.getURI());
    }

    public void cancel() {
        this.cancelled.set(true);
        FutureCallback futureCallback0 = this.callback;
        if(futureCallback0 != null) {
            futureCallback0.cancelled();
        }
    }

    public long getEnded() {
        return this.ended;
    }

    public long getScheduled() {
        return this.scheduled;
    }

    public long getStarted() {
        return this.started;
    }
}

