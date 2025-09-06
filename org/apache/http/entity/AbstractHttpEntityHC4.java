package org.apache.http.entity;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.message.BasicHeader;

@NotThreadSafe
public abstract class AbstractHttpEntityHC4 implements HttpEntity {
    protected static final int OUTPUT_BUFFER_SIZE = 0x1000;
    protected boolean chunked;
    protected Header contentEncoding;
    protected Header contentType;

    @Override  // org.apache.http.HttpEntity
    @Deprecated
    public void consumeContent() {
    }

    @Override  // org.apache.http.HttpEntity
    public Header getContentEncoding() {
        return this.contentEncoding;
    }

    @Override  // org.apache.http.HttpEntity
    public Header getContentType() {
        return this.contentType;
    }

    @Override  // org.apache.http.HttpEntity
    public boolean isChunked() {
        return this.chunked;
    }

    public void setChunked(boolean z) {
        this.chunked = z;
    }

    public void setContentEncoding(String s) {
        this.setContentEncoding((s == null ? null : new BasicHeader("Content-Encoding", s)));
    }

    public void setContentEncoding(Header header0) {
        this.contentEncoding = header0;
    }

    public void setContentType(String s) {
        this.setContentType((s == null ? null : new BasicHeader("Content-Type", s)));
    }

    public void setContentType(Header header0) {
        this.contentType = header0;
    }
}

