package org.apache.http.message;

import org.apache.http.Header;
import org.apache.http.HeaderElement;

@Deprecated
public class BasicHeader implements Header {
    public BasicHeader(String s, String s1) {
        throw new RuntimeException("Stub!");
    }

    @Override
    public Object clone() {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.Header
    public HeaderElement[] getElements() {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.Header
    public String getName() {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.Header
    public String getValue() {
        throw new RuntimeException("Stub!");
    }

    @Override
    public String toString() {
        throw new RuntimeException("Stub!");
    }
}

