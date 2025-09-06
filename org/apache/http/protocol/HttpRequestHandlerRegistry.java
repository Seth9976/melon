package org.apache.http.protocol;

import java.util.Map;

@Deprecated
public class HttpRequestHandlerRegistry implements HttpRequestHandlerResolver {
    public HttpRequestHandlerRegistry() {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.protocol.HttpRequestHandlerResolver
    public HttpRequestHandler lookup(String s) {
        throw new RuntimeException("Stub!");
    }

    @Deprecated
    public boolean matchUriRequestPattern(String s, String s1) {
        throw new RuntimeException("Stub!");
    }

    public void register(String s, HttpRequestHandler httpRequestHandler0) {
        throw new RuntimeException("Stub!");
    }

    public void setHandlers(Map map0) {
        throw new RuntimeException("Stub!");
    }

    public void unregister(String s) {
        throw new RuntimeException("Stub!");
    }
}

