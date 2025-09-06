package org.apache.http.impl.client;

import java.io.InputStream;
import java.io.OutputStream;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.entity.HttpEntityWrapperHC4;

@Deprecated
@NotThreadSafe
public class EntityEnclosingRequestWrapperHC4 extends RequestWrapper implements HttpEntityEnclosingRequest {
    class EntityWrapper extends HttpEntityWrapperHC4 {
        public EntityWrapper(HttpEntity httpEntity0) {
            super(httpEntity0);
        }

        @Override  // org.apache.http.entity.HttpEntityWrapperHC4
        public void consumeContent() {
            EntityEnclosingRequestWrapperHC4.this.consumed = true;
            super.consumeContent();
        }

        @Override  // org.apache.http.entity.HttpEntityWrapperHC4
        public InputStream getContent() {
            EntityEnclosingRequestWrapperHC4.this.consumed = true;
            return super.getContent();
        }

        @Override  // org.apache.http.entity.HttpEntityWrapperHC4
        public void writeTo(OutputStream outputStream0) {
            EntityEnclosingRequestWrapperHC4.this.consumed = true;
            super.writeTo(outputStream0);
        }
    }

    private boolean consumed;
    private HttpEntity entity;

    public EntityEnclosingRequestWrapperHC4(HttpEntityEnclosingRequest httpEntityEnclosingRequest0) {
        super(httpEntityEnclosingRequest0);
        this.setEntity(httpEntityEnclosingRequest0.getEntity());
    }

    @Override  // org.apache.http.HttpEntityEnclosingRequest
    public boolean expectContinue() {
        Header header0 = this.getFirstHeader("Expect");
        return header0 != null && "100-continue".equalsIgnoreCase(header0.getValue());
    }

    @Override  // org.apache.http.HttpEntityEnclosingRequest
    public HttpEntity getEntity() {
        return this.entity;
    }

    // 去混淆评级： 低(20)
    @Override  // org.apache.http.impl.client.RequestWrapper
    public boolean isRepeatable() {
        return this.entity == null || this.entity.isRepeatable() || !this.consumed;
    }

    @Override  // org.apache.http.HttpEntityEnclosingRequest
    public void setEntity(HttpEntity httpEntity0) {
        this.entity = httpEntity0 == null ? null : new EntityWrapper(this, httpEntity0);
        this.consumed = false;
    }
}

