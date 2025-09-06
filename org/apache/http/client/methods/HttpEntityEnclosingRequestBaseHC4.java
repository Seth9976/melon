package org.apache.http.client.methods;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.client.utils.CloneUtilsHC4;

@NotThreadSafe
public abstract class HttpEntityEnclosingRequestBaseHC4 extends HttpRequestBaseHC4 implements HttpEntityEnclosingRequest {
    private HttpEntity entity;

    @Override  // org.apache.http.client.methods.AbstractExecutionAwareRequest
    public Object clone() {
        HttpEntityEnclosingRequestBaseHC4 httpEntityEnclosingRequestBaseHC40 = (HttpEntityEnclosingRequestBaseHC4)super.clone();
        HttpEntity httpEntity0 = this.entity;
        if(httpEntity0 != null) {
            httpEntityEnclosingRequestBaseHC40.entity = (HttpEntity)CloneUtilsHC4.cloneObject(httpEntity0);
        }
        return httpEntityEnclosingRequestBaseHC40;
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

    @Override  // org.apache.http.HttpEntityEnclosingRequest
    public void setEntity(HttpEntity httpEntity0) {
        this.entity = httpEntity0;
    }
}

