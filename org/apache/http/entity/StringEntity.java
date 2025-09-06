package org.apache.http.entity;

import java.io.InputStream;
import java.io.OutputStream;

@Deprecated
public class StringEntity extends AbstractHttpEntity {
    protected final byte[] content;

    public StringEntity(String s) {
        this.content = null;
        throw new RuntimeException("Stub!");
    }

    public StringEntity(String s, String s1) {
        this.content = null;
        throw new RuntimeException("Stub!");
    }

    @Override
    public Object clone() {
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

