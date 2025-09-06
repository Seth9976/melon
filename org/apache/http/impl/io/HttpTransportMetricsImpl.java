package org.apache.http.impl.io;

import org.apache.http.io.HttpTransportMetrics;

@Deprecated
public class HttpTransportMetricsImpl implements HttpTransportMetrics {
    public HttpTransportMetricsImpl() {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.io.HttpTransportMetrics
    public long getBytesTransferred() {
        throw new RuntimeException("Stub!");
    }

    public void incrementBytesTransferred(long v) {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.io.HttpTransportMetrics
    public void reset() {
        throw new RuntimeException("Stub!");
    }

    public void setBytesTransferred(long v) {
        throw new RuntimeException("Stub!");
    }
}

