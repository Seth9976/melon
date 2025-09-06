package org.apache.http.impl.client;

import java.net.URI;
import org.apache.http.HttpRequest;
import org.apache.http.ProtocolVersion;
import org.apache.http.RequestLine;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.message.AbstractHttpMessage;

@Deprecated
public class RequestWrapper extends AbstractHttpMessage implements HttpUriRequest {
    public RequestWrapper(HttpRequest httpRequest0) {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.client.methods.HttpUriRequest
    public void abort() {
        throw new RuntimeException("Stub!");
    }

    public int getExecCount() {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.client.methods.HttpUriRequest
    public String getMethod() {
        throw new RuntimeException("Stub!");
    }

    public HttpRequest getOriginal() {
        throw new RuntimeException("Stub!");
    }

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

    public void incrementExecCount() {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.client.methods.HttpUriRequest
    public boolean isAborted() {
        throw new RuntimeException("Stub!");
    }

    public boolean isRepeatable() {
        throw new RuntimeException("Stub!");
    }

    public void resetHeaders() {
        throw new RuntimeException("Stub!");
    }

    public void setMethod(String s) {
        throw new RuntimeException("Stub!");
    }

    public void setProtocolVersion(ProtocolVersion protocolVersion0) {
        throw new RuntimeException("Stub!");
    }

    public void setURI(URI uRI0) {
        throw new RuntimeException("Stub!");
    }
}

