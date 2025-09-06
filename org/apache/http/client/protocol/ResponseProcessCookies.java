package org.apache.http.client.protocol;

import org.apache.http.HttpResponse;
import org.apache.http.HttpResponseInterceptor;
import org.apache.http.protocol.HttpContext;

@Deprecated
public class ResponseProcessCookies implements HttpResponseInterceptor {
    public ResponseProcessCookies() {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.HttpResponseInterceptor
    public void process(HttpResponse httpResponse0, HttpContext httpContext0) {
        throw new RuntimeException("Stub!");
    }
}

