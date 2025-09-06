package org.apache.http.message;

import org.apache.http.ProtocolVersion;
import org.apache.http.StatusLine;

@Deprecated
public class BasicStatusLine implements StatusLine {
    public BasicStatusLine(ProtocolVersion protocolVersion0, int v, String s) {
        throw new RuntimeException("Stub!");
    }

    @Override
    public Object clone() {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.StatusLine
    public ProtocolVersion getProtocolVersion() {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.StatusLine
    public String getReasonPhrase() {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.StatusLine
    public int getStatusCode() {
        throw new RuntimeException("Stub!");
    }

    @Override
    public String toString() {
        throw new RuntimeException("Stub!");
    }
}

