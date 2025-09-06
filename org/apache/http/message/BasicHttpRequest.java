package org.apache.http.message;

import org.apache.http.HttpRequest;
import org.apache.http.ProtocolVersion;
import org.apache.http.RequestLine;

@Deprecated
public class BasicHttpRequest extends AbstractHttpMessage implements HttpRequest {
    public BasicHttpRequest(String s, String s1) {
        throw new RuntimeException("Stub!");
    }

    public BasicHttpRequest(String s, String s1, ProtocolVersion protocolVersion0) {
        throw new RuntimeException("Stub!");
    }

    public BasicHttpRequest(RequestLine requestLine0) {
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
}

