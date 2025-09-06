package org.apache.http.protocol;

import org.apache.http.HttpResponse;
import org.apache.http.HttpResponseInterceptor;

@Deprecated
public class ResponseContent implements HttpResponseInterceptor {
    public ResponseContent() {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.HttpResponseInterceptor
    public void process(HttpResponse httpResponse0, HttpContext httpContext0) {
        throw new RuntimeException("Stub!");
    }
}

