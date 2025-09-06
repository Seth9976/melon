package org.apache.http.entity;

import java.io.InputStream;
import java.io.OutputStream;

@Deprecated
public class InputStreamEntity extends AbstractHttpEntity {
    public InputStreamEntity(InputStream inputStream0, long v) {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.entity.AbstractHttpEntity
    public void consumeContent() {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.HttpEntity
    public InputStream getContent() {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.HttpEntity
    public long getContentLength() {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.HttpEntity
    public boolean isRepeatable() {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.HttpEntity
    public boolean isStreaming() {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.HttpEntity
    public void writeTo(OutputStream outputStream0) {
        throw new RuntimeException("Stub!");
    }
}

