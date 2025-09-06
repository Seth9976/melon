package org.apache.http.message;

import org.apache.http.Header;
import org.apache.http.ProtocolVersion;
import org.apache.http.RequestLine;
import org.apache.http.StatusLine;
import org.apache.http.util.CharArrayBuffer;

@Deprecated
public class BasicLineParser implements LineParser {
    public static final BasicLineParser DEFAULT;
    protected final ProtocolVersion protocol;

    public BasicLineParser() {
        throw new RuntimeException("Stub!");
    }

    public BasicLineParser(ProtocolVersion protocolVersion0) {
        throw new RuntimeException("Stub!");
    }

    public ProtocolVersion createProtocolVersion(int v, int v1) {
        throw new RuntimeException("Stub!");
    }

    public RequestLine createRequestLine(String s, String s1, ProtocolVersion protocolVersion0) {
        throw new RuntimeException("Stub!");
    }

    public StatusLine createStatusLine(ProtocolVersion protocolVersion0, int v, String s) {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.message.LineParser
    public boolean hasProtocolVersion(CharArrayBuffer charArrayBuffer0, ParserCursor parserCursor0) {
        throw new RuntimeException("Stub!");
    }

    public static final Header parseHeader(String s, LineParser lineParser0) {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.message.LineParser
    public Header parseHeader(CharArrayBuffer charArrayBuffer0) {
        throw new RuntimeException("Stub!");
    }

    public static final ProtocolVersion parseProtocolVersion(String s, LineParser lineParser0) {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.message.LineParser
    public ProtocolVersion parseProtocolVersion(CharArrayBuffer charArrayBuffer0, ParserCursor parserCursor0) {
        throw new RuntimeException("Stub!");
    }

    public static final RequestLine parseRequestLine(String s, LineParser lineParser0) {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.message.LineParser
    public RequestLine parseRequestLine(CharArrayBuffer charArrayBuffer0, ParserCursor parserCursor0) {
        throw new RuntimeException("Stub!");
    }

    public static final StatusLine parseStatusLine(String s, LineParser lineParser0) {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.message.LineParser
    public StatusLine parseStatusLine(CharArrayBuffer charArrayBuffer0, ParserCursor parserCursor0) {
        throw new RuntimeException("Stub!");
    }

    public void skipWhitespace(CharArrayBuffer charArrayBuffer0, ParserCursor parserCursor0) {
        throw new RuntimeException("Stub!");
    }
}

