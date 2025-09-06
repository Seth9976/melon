package org.apache.http.client.methods;

import java.net.URI;

@Deprecated
public class HttpPut extends HttpEntityEnclosingRequestBase {
    public static final String METHOD_NAME = "PUT";

    public HttpPut() {
        throw new RuntimeException("Stub!");
    }

    public HttpPut(String s) {
        throw new RuntimeException("Stub!");
    }

    public HttpPut(URI uRI0) {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.client.methods.HttpRequestBase
    public String getMethod() {
        throw new RuntimeException("Stub!");
    }
}

