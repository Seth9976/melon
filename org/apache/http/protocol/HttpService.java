package org.apache.http.protocol;

import org.apache.http.ConnectionReuseStrategy;
import org.apache.http.HttpException;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.HttpResponseFactory;
import org.apache.http.HttpServerConnection;
import org.apache.http.params.HttpParams;

@Deprecated
public class HttpService {
    public HttpService(HttpProcessor httpProcessor0, ConnectionReuseStrategy connectionReuseStrategy0, HttpResponseFactory httpResponseFactory0) {
        throw new RuntimeException("Stub!");
    }

    public void doService(HttpRequest httpRequest0, HttpResponse httpResponse0, HttpContext httpContext0) {
        throw new RuntimeException("Stub!");
    }

    public HttpParams getParams() {
        throw new RuntimeException("Stub!");
    }

    public void handleException(HttpException httpException0, HttpResponse httpResponse0) {
        throw new RuntimeException("Stub!");
    }

    public void handleRequest(HttpServerConnection httpServerConnection0, HttpContext httpContext0) {
        throw new RuntimeException("Stub!");
    }

    public void setConnReuseStrategy(ConnectionReuseStrategy connectionReuseStrategy0) {
        throw new RuntimeException("Stub!");
    }

    public void setExpectationVerifier(HttpExpectationVerifier httpExpectationVerifier0) {
        throw new RuntimeException("Stub!");
    }

    public void setHandlerResolver(HttpRequestHandlerResolver httpRequestHandlerResolver0) {
        throw new RuntimeException("Stub!");
    }

    public void setHttpProcessor(HttpProcessor httpProcessor0) {
        throw new RuntimeException("Stub!");
    }

    public void setParams(HttpParams httpParams0) {
        throw new RuntimeException("Stub!");
    }

    public void setResponseFactory(HttpResponseFactory httpResponseFactory0) {
        throw new RuntimeException("Stub!");
    }
}

