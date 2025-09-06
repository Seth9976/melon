package org.apache.http.entity;

import java.io.InputStream;
import java.io.OutputStream;
import org.apache.http.HttpEntity;

@Deprecated
public class BufferedHttpEntity extends HttpEntityWrapper {
    public BufferedHttpEntity(HttpEntity httpEntity0) {
        super(null);
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.entity.HttpEntityWrapper
    public InputStream getContent() {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.entity.HttpEntityWrapper
    public long getContentLength() {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.entity.HttpEntityWrapper
    public boolean isChunked() {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.entity.HttpEntityWrapper
    public boolean isRepeatable() {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.entity.HttpEntityWrapper
    public boolean isStreaming() {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.entity.HttpEntityWrapper
    public void writeTo(OutputStream outputStream0) {
        throw new RuntimeException("Stub!");
    }
}

