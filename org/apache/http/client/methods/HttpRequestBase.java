package org.apache.http.client.methods;

import java.net.URI;
import org.apache.http.ProtocolVersion;
import org.apache.http.RequestLine;
import org.apache.http.conn.ClientConnectionRequest;
import org.apache.http.conn.ConnectionReleaseTrigger;
import org.apache.http.message.AbstractHttpMessage;

@Deprecated
public abstract class HttpRequestBase extends AbstractHttpMessage implements AbortableHttpRequest, HttpUriRequest {
    public HttpRequestBase() {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.client.methods.HttpUriRequest, org.apache.http.client.methods.AbortableHttpRequest
    public void abort() {
        throw new RuntimeException("Stub!");
    }

    @Override
    public Object clone() {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.client.methods.HttpUriRequest
    public abstract String getMethod();

    @Override  // org.apache.http.HttpMessage
    public ProtocolVersion getProtocolVersion() {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.HttpRequest
    public RequestLine getRequestLine() {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.client.methods.HttpUriRequest
    public URI getURI() {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.client.methods.HttpUriRequest
    public boolean isAborted() {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.client.methods.AbortableHttpRequest
    public void setConnectionRequest(ClientConnectionRequest clientConnectionRequest0) {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.client.methods.AbortableHttpRequest
    public void setReleaseTrigger(ConnectionReleaseTrigger connectionReleaseTrigger0) {
        throw new RuntimeException("Stub!");
    }

    public void setURI(URI uRI0) {
        throw new RuntimeException("Stub!");
    }
}

