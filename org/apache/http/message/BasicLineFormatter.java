package org.apache.http.message;

import org.apache.http.Header;
import org.apache.http.ProtocolVersion;
import org.apache.http.RequestLine;
import org.apache.http.StatusLine;
import org.apache.http.util.CharArrayBuffer;

@Deprecated
public class BasicLineFormatter implements LineFormatter {
    public static final BasicLineFormatter DEFAULT;

    public BasicLineFormatter() {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.message.LineFormatter
    public CharArrayBuffer appendProtocolVersion(CharArrayBuffer charArrayBuffer0, ProtocolVersion protocolVersion0) {
        throw new RuntimeException("Stub!");
    }

    public void doFormatHeader(CharArrayBuffer charArrayBuffer0, Header header0) {
        throw new RuntimeException("Stub!");
    }

    public void doFormatRequestLine(CharArrayBuffer charArrayBuffer0, RequestLine requestLine0) {
        throw new RuntimeException("Stub!");
    }

    public void doFormatStatusLine(CharArrayBuffer charArrayBuffer0, StatusLine statusLine0) {
        throw new RuntimeException("Stub!");
    }

    public int estimateProtocolVersionLen(ProtocolVersion protocolVersion0) {
        throw new RuntimeException("Stub!");
    }

    public static final String formatHeader(Header header0, LineFormatter lineFormatter0) {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.message.LineFormatter
    public CharArrayBuffer formatHeader(CharArrayBuffer charArrayBuffer0, Header header0) {
        throw new RuntimeException("Stub!");
    }

    public static final String formatProtocolVersion(ProtocolVersion protocolVersion0, LineFormatter lineFormatter0) {
        throw new RuntimeException("Stub!");
    }

    public static final String formatRequestLine(RequestLine requestLine0, LineFormatter lineFormatter0) {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.message.LineFormatter
    public CharArrayBuffer formatRequestLine(CharArrayBuffer charArrayBuffer0, RequestLine requestLine0) {
        throw new RuntimeException("Stub!");
    }

    public static final String formatStatusLine(StatusLine statusLine0, LineFormatter lineFormatter0) {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.message.LineFormatter
    public CharArrayBuffer formatStatusLine(CharArrayBuffer charArrayBuffer0, StatusLine statusLine0) {
        throw new RuntimeException("Stub!");
    }

    public CharArrayBuffer initBuffer(CharArrayBuffer charArrayBuffer0) {
        throw new RuntimeException("Stub!");
    }
}

