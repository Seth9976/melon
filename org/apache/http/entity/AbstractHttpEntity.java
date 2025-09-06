package org.apache.http.entity;

import org.apache.http.Header;
import org.apache.http.HttpEntity;

@Deprecated
public abstract class AbstractHttpEntity implements HttpEntity {
    protected boolean chunked;
    protected Header contentEncoding;
    protected Header contentType;

    public AbstractHttpEntity() {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.HttpEntity
    public void consumeContent() {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.HttpEntity
    public Header getContentEncoding() {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.HttpEntity
    public Header getContentType() {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.HttpEntity
    public boolean isChunked() {
        throw new RuntimeException("Stub!");
    }

    public void setChunked(boolean z) {
        throw new RuntimeException("Stub!");
    }

    public void setContentEncoding(String s) {
        throw new RuntimeException("Stub!");
    }

    public void setContentEncoding(Header header0) {
        throw new RuntimeException("Stub!");
    }

    public void setContentType(String s) {
        throw new RuntimeException("Stub!");
    }

    public void setContentType(Header header0) {
        throw new RuntimeException("Stub!");
    }
}

