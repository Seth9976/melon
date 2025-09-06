package org.apache.http.protocol;

import org.apache.http.HttpClientConnection;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;

@Deprecated
public class HttpRequestExecutor {
    public HttpRequestExecutor() {
        throw new RuntimeException("Stub!");
    }

    public boolean canResponseHaveBody(HttpRequest httpRequest0, HttpResponse httpResponse0) {
        throw new RuntimeException("Stub!");
    }

    public HttpResponse doReceiveResponse(HttpRequest httpRequest0, HttpClientConnection httpClientConnection0, HttpContext httpContext0) {
        throw new RuntimeException("Stub!");
    }

    public HttpResponse doSendRequest(HttpRequest httpRequest0, HttpClientConnection httpClientConnection0, HttpContext httpContext0) {
        throw new RuntimeException("Stub!");
    }

    public HttpResponse execute(HttpRequest httpRequest0, HttpClientConnection httpClientConnection0, HttpContext httpContext0) {
        throw new RuntimeException("Stub!");
    }

    public void postProcess(HttpResponse httpResponse0, HttpProcessor httpProcessor0, HttpContext httpContext0) {
        throw new RuntimeException("Stub!");
    }

    public void preProcess(HttpRequest httpRequest0, HttpProcessor httpProcessor0, HttpContext httpContext0) {
        throw new RuntimeException("Stub!");
    }
}

