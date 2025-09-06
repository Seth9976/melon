package org.apache.http.entity;

import java.io.InputStream;
import java.io.OutputStream;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.util.Args;

@NotThreadSafe
public class HttpEntityWrapperHC4 implements HttpEntity {
    protected HttpEntity wrappedEntity;

    public HttpEntityWrapperHC4(HttpEntity httpEntity0) {
        this.wrappedEntity = (HttpEntity)Args.notNull(httpEntity0, "Wrapped entity");
    }

    @Override  // org.apache.http.HttpEntity
    @Deprecated
    public void consumeContent() {
        this.wrappedEntity.consumeContent();
    }

    @Override  // org.apache.http.HttpEntity
    public InputStream getContent() {
        return this.wrappedEntity.getContent();
    }

    @Override  // org.apache.http.HttpEntity
    public Header getContentEncoding() {
        return this.wrappedEntity.getContentEncoding();
    }

    @Override  // org.apache.http.HttpEntity
    public long getContentLength() {
        return this.wrappedEntity.getContentLength();
    }

    @Override  // org.apache.http.HttpEntity
    public Header getContentType() {
        return this.wrappedEntity.getContentType();
    }

    @Override  // org.apache.http.HttpEntity
    public boolean isChunked() {
        return this.wrappedEntity.isChunked();
    }

    @Override  // org.apache.http.HttpEntity
    public boolean isRepeatable() {
        return this.wrappedEntity.isRepeatable();
    }

    @Override  // org.apache.http.HttpEntity
    public boolean isStreaming() {
        return this.wrappedEntity.isStreaming();
    }

    @Override  // org.apache.http.HttpEntity
    public void writeTo(OutputStream outputStream0) {
        this.wrappedEntity.writeTo(outputStream0);
    }
}

