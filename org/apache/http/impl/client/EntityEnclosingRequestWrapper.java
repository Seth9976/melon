package org.apache.http.impl.client;

import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;

@Deprecated
public class EntityEnclosingRequestWrapper extends RequestWrapper implements HttpEntityEnclosingRequest {
    public EntityEnclosingRequestWrapper(HttpEntityEnclosingRequest httpEntityEnclosingRequest0) {
        super(null);
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

    @Override  // org.apache.http.impl.client.RequestWrapper
    public boolean isRepeatable() {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.HttpEntityEnclosingRequest
    public void setEntity(HttpEntity httpEntity0) {
        throw new RuntimeException("Stub!");
    }
}

