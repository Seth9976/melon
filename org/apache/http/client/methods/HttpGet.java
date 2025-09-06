package org.apache.http.client.methods;

import java.net.URI;

@Deprecated
public class HttpGet extends HttpRequestBase {
    public static final String METHOD_NAME = "GET";

    public HttpGet() {
        throw new RuntimeException("Stub!");
    }

    public HttpGet(String s) {
        throw new RuntimeException("Stub!");
    }

    public HttpGet(URI uRI0) {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.client.methods.HttpRequestBase
    public String getMethod() {
        throw new RuntimeException("Stub!");
    }
}

