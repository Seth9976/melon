package org.apache.http.message;

import org.apache.http.ProtocolVersion;
import org.apache.http.RequestLine;

@Deprecated
public class BasicRequestLine implements RequestLine {
    public BasicRequestLine(String s, String s1, ProtocolVersion protocolVersion0) {
        throw new RuntimeException("Stub!");
    }

    @Override
    public Object clone() {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.RequestLine
    public String getMethod() {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.RequestLine
    public ProtocolVersion getProtocolVersion() {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.RequestLine
    public String getUri() {
        throw new RuntimeException("Stub!");
    }

    @Override
    public String toString() {
        throw new RuntimeException("Stub!");
    }
}

