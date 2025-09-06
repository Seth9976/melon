package org.apache.http.protocol;

import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;

@Deprecated
public class RequestConnControl implements HttpRequestInterceptor {
    public RequestConnControl() {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.HttpRequestInterceptor
    public void process(HttpRequest httpRequest0, HttpContext httpContext0) {
        throw new RuntimeException("Stub!");
    }
}

