package org.apache.http.client.methods;

import java.net.URI;

@Deprecated
public class HttpPost extends HttpEntityEnclosingRequestBase {
    public static final String METHOD_NAME = "POST";

    public HttpPost() {
        throw new RuntimeException("Stub!");
    }

    public HttpPost(String s) {
        throw new RuntimeException("Stub!");
    }

    public HttpPost(URI uRI0) {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.client.methods.HttpRequestBase
    public String getMethod() {
        throw new RuntimeException("Stub!");
    }
}

