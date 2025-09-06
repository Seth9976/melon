package org.apache.http.impl.client;

import java.io.IOException;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.protocol.HttpContext;

@Deprecated
public class DefaultHttpRequestRetryHandler implements HttpRequestRetryHandler {
    public DefaultHttpRequestRetryHandler() {
        throw new RuntimeException("Stub!");
    }

    public DefaultHttpRequestRetryHandler(int v, boolean z) {
        throw new RuntimeException("Stub!");
    }

    public int getRetryCount() {
        throw new RuntimeException("Stub!");
    }

    public boolean isRequestSentRetryEnabled() {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.client.HttpRequestRetryHandler
    public boolean retryRequest(IOException iOException0, int v, HttpContext httpContext0) {
        throw new RuntimeException("Stub!");
    }
}

