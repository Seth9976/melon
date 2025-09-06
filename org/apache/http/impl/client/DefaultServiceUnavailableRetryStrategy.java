package org.apache.http.impl.client;

import org.apache.http.HttpResponse;
import org.apache.http.annotation.Immutable;
import org.apache.http.client.ServiceUnavailableRetryStrategy;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.Args;

@Immutable
public class DefaultServiceUnavailableRetryStrategy implements ServiceUnavailableRetryStrategy {
    private final int maxRetries;
    private final long retryInterval;

    public DefaultServiceUnavailableRetryStrategy() {
        this(1, 1000);
    }

    public DefaultServiceUnavailableRetryStrategy(int v, int v1) {
        Args.positive(v, "Max retries");
        Args.positive(v1, "Retry interval");
        this.maxRetries = v;
        this.retryInterval = (long)v1;
    }

    @Override  // org.apache.http.client.ServiceUnavailableRetryStrategy
    public long getRetryInterval() {
        return this.retryInterval;
    }

    @Override  // org.apache.http.client.ServiceUnavailableRetryStrategy
    public boolean retryRequest(HttpResponse httpResponse0, int v, HttpContext httpContext0) {
        return v <= this.maxRetries && httpResponse0.getStatusLine().getStatusCode() == 503;
    }
}

