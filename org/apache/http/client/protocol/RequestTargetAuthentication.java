package org.apache.http.client.protocol;

import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.protocol.HttpContext;

@Deprecated
public class RequestTargetAuthentication implements HttpRequestInterceptor {
    public RequestTargetAuthentication() {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.HttpRequestInterceptor
    public void process(HttpRequest httpRequest0, HttpContext httpContext0) {
        throw new RuntimeException("Stub!");
    }
}

