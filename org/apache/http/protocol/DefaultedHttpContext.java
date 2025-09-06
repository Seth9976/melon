package org.apache.http.protocol;

@Deprecated
public final class DefaultedHttpContext implements HttpContext {
    public DefaultedHttpContext(HttpContext httpContext0, HttpContext httpContext1) {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.protocol.HttpContext
    public Object getAttribute(String s) {
        throw new RuntimeException("Stub!");
    }

    public HttpContext getDefaults() {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.protocol.HttpContext
    public Object removeAttribute(String s) {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.protocol.HttpContext
    public void setAttribute(String s, Object object0) {
        throw new RuntimeException("Stub!");
    }
}

