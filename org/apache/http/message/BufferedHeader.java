package org.apache.http.message;

import org.apache.http.FormattedHeader;
import org.apache.http.HeaderElement;
import org.apache.http.util.CharArrayBuffer;

@Deprecated
public class BufferedHeader implements FormattedHeader {
    public BufferedHeader(CharArrayBuffer charArrayBuffer0) {
        throw new RuntimeException("Stub!");
    }

    @Override
    public Object clone() {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.FormattedHeader
    public CharArrayBuffer getBuffer() {
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

    @Override  // org.apache.http.FormattedHeader
    public int getValuePos() {
        throw new RuntimeException("Stub!");
    }

    @Override
    public String toString() {
        throw new RuntimeException("Stub!");
    }
}

