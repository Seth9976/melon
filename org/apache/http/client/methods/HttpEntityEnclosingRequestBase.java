package org.apache.http.client.methods;

import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;

@Deprecated
public abstract class HttpEntityEnclosingRequestBase extends HttpRequestBase implements HttpEntityEnclosingRequest {
    public HttpEntityEnclosingRequestBase() {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.client.methods.HttpRequestBase
    public Object clone() {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.HttpEntityEnclosingRequest
    public boolean expectContinue() {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.HttpEntityEnclosingRequest
    public HttpEntity getEntity() {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.HttpEntityEnclosingRequest
    public void setEntity(HttpEntity httpEntity0) {
        throw new RuntimeException("Stub!");
    }
}

