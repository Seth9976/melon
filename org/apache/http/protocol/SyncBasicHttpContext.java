package org.apache.http.protocol;

@Deprecated
public class SyncBasicHttpContext extends BasicHttpContext {
    public SyncBasicHttpContext(HttpContext httpContext0) {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.protocol.BasicHttpContext
    public Object getAttribute(String s) {
        synchronized(this) {
            throw new RuntimeException("Stub!");
        }
    }

    @Override  // org.apache.http.protocol.BasicHttpContext
    public Object removeAttribute(String s) {
        synchronized(this) {
            throw new RuntimeException("Stub!");
        }
    }

    @Override  // org.apache.http.protocol.BasicHttpContext
    public void setAttribute(String s, Object object0) {
        synchronized(this) {
            throw new RuntimeException("Stub!");
        }
    }
}

