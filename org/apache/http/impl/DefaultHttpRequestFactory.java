package org.apache.http.impl;

import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestFactory;
import org.apache.http.RequestLine;

@Deprecated
public class DefaultHttpRequestFactory implements HttpRequestFactory {
    public DefaultHttpRequestFactory() {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.HttpRequestFactory
    public HttpRequest newHttpRequest(String s, String s1) {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.HttpRequestFactory
    public HttpRequest newHttpRequest(RequestLine requestLine0) {
        throw new RuntimeException("Stub!");
    }
}

