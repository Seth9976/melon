package org.apache.http.message;

import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.ProtocolVersion;
import org.apache.http.RequestLine;

@Deprecated
public class BasicHttpEntityEnclosingRequest extends BasicHttpRequest implements HttpEntityEnclosingRequest {
    public BasicHttpEntityEnclosingRequest(String s, String s1) {
        super(null);
        throw new RuntimeException("Stub!");
    }

    public BasicHttpEntityEnclosingRequest(String s, String s1, ProtocolVersion protocolVersion0) {
        super(null);
        throw new RuntimeException("Stub!");
    }

    public BasicHttpEntityEnclosingRequest(RequestLine requestLine0) {
        super(null);
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.HttpEntityEnclosingRequest
    public boolean expectContinue() {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.HttpEntityEnclosingRequest
    public HttpEntity getEntity() {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.HttpEntityEnclosingRequest
    public void setEntity(HttpEntity httpEntity0) {
        throw new RuntimeException("Stub!");
    }
}

