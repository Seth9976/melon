package org.apache.http.entity.mime;

import java.io.InputStream;
import java.io.OutputStream;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.message.BasicHeader;

class MultipartFormEntity implements HttpEntity {
    private final long contentLength;
    private final Header contentType;
    private final AbstractMultipartForm multipart;

    public MultipartFormEntity(AbstractMultipartForm abstractMultipartForm0, String s, long v) {
        this.multipart = abstractMultipartForm0;
        this.contentType = new BasicHeader("Content-Type", s);
        this.contentLength = v;
    }

    @Override  // org.apache.http.HttpEntity
    public void consumeContent() {
        if(this.isStreaming()) {
            throw new UnsupportedOperationException("Streaming entity does not implement #consumeContent()");
        }
    }

    @Override  // org.apache.http.HttpEntity
    public InputStream getContent() {
        throw new UnsupportedOperationException("Multipart form entity does not implement #getContent()");
    }

    @Override  // org.apache.http.HttpEntity
    public Header getContentEncoding() {
        return null;
    }

    @Override  // org.apache.http.HttpEntity
    public long getContentLength() {
        return this.contentLength;
    }

    @Override  // org.apache.http.HttpEntity
    public Header getContentType() {
        return this.contentType;
    }

    public AbstractMultipartForm getMultipart() {
        return this.multipart;
    }

    @Override  // org.apache.http.HttpEntity
    public boolean isChunked() {
        return !this.isRepeatable();
    }

    @Override  // org.apache.http.HttpEntity
    public boolean isRepeatable() {
        return this.contentLength != -1L;
    }

    @Override  // org.apache.http.HttpEntity
    public boolean isStreaming() {
        return !this.isRepeatable();
    }

    @Override  // org.apache.http.HttpEntity
    public void writeTo(OutputStream outputStream0) {
        this.multipart.writeTo(outputStream0);
    }
}

