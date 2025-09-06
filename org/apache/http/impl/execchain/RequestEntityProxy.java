package org.apache.http.impl.execchain;

import java.io.InputStream;
import java.io.OutputStream;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpRequest;
import org.apache.http.annotation.NotThreadSafe;

@NotThreadSafe
class RequestEntityProxy implements HttpEntity {
    private boolean consumed;
    private final HttpEntity original;

    public RequestEntityProxy(HttpEntity httpEntity0) {
        this.consumed = false;
        this.original = httpEntity0;
    }

    @Override  // org.apache.http.HttpEntity
    @Deprecated
    public void consumeContent() {
        this.consumed = true;
        this.original.consumeContent();
    }

    public static void enhance(HttpEntityEnclosingRequest httpEntityEnclosingRequest0) {
        HttpEntity httpEntity0 = httpEntityEnclosingRequest0.getEntity();
        if(httpEntity0 != null && !httpEntity0.isRepeatable() && !RequestEntityProxy.isEnhanced(httpEntity0)) {
            httpEntityEnclosingRequest0.setEntity(new RequestEntityProxy(httpEntity0));
        }
    }

    @Override  // org.apache.http.HttpEntity
    public InputStream getContent() {
        return this.original.getContent();
    }

    @Override  // org.apache.http.HttpEntity
    public Header getContentEncoding() {
        return this.original.getContentEncoding();
    }

    @Override  // org.apache.http.HttpEntity
    public long getContentLength() {
        return this.original.getContentLength();
    }

    @Override  // org.apache.http.HttpEntity
    public Header getContentType() {
        return this.original.getContentType();
    }

    public HttpEntity getOriginal() {
        return this.original;
    }

    @Override  // org.apache.http.HttpEntity
    public boolean isChunked() {
        return this.original.isChunked();
    }

    public boolean isConsumed() {
        return this.consumed;
    }

    public static boolean isEnhanced(HttpEntity httpEntity0) {
        return httpEntity0 instanceof RequestEntityProxy;
    }

    public static boolean isRepeatable(HttpRequest httpRequest0) {
        if(httpRequest0 instanceof HttpEntityEnclosingRequest) {
            HttpEntity httpEntity0 = ((HttpEntityEnclosingRequest)httpRequest0).getEntity();
            return httpEntity0 != null && (!RequestEntityProxy.isEnhanced(httpEntity0) || ((RequestEntityProxy)httpEntity0).isConsumed()) ? httpEntity0.isRepeatable() : true;
        }
        return true;
    }

    @Override  // org.apache.http.HttpEntity
    public boolean isRepeatable() {
        return this.original.isRepeatable();
    }

    @Override  // org.apache.http.HttpEntity
    public boolean isStreaming() {
        return this.original.isStreaming();
    }

    @Override
    public String toString() {
        return "RequestEntityProxy{" + this.original + '}';
    }

    @Override  // org.apache.http.HttpEntity
    public void writeTo(OutputStream outputStream0) {
        this.consumed = true;
        this.original.writeTo(outputStream0);
    }
}

