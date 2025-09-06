package org.apache.http.message;

import org.apache.http.HeaderElement;
import org.apache.http.NameValuePair;
import org.apache.http.util.CharArrayBuffer;

@Deprecated
public class BasicHeaderValueParser implements HeaderValueParser {
    public static final BasicHeaderValueParser DEFAULT;

    public BasicHeaderValueParser() {
        throw new RuntimeException("Stub!");
    }

    public HeaderElement createHeaderElement(String s, String s1, NameValuePair[] arr_nameValuePair) {
        throw new RuntimeException("Stub!");
    }

    public NameValuePair createNameValuePair(String s, String s1) {
        throw new RuntimeException("Stub!");
    }

    public static final HeaderElement[] parseElements(String s, HeaderValueParser headerValueParser0) {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.message.HeaderValueParser
    public HeaderElement[] parseElements(CharArrayBuffer charArrayBuffer0, ParserCursor parserCursor0) {
        throw new RuntimeException("Stub!");
    }

    public static final HeaderElement parseHeaderElement(String s, HeaderValueParser headerValueParser0) {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.message.HeaderValueParser
    public HeaderElement parseHeaderElement(CharArrayBuffer charArrayBuffer0, ParserCursor parserCursor0) {
        throw new RuntimeException("Stub!");
    }

    public static final NameValuePair parseNameValuePair(String s, HeaderValueParser headerValueParser0) {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.message.HeaderValueParser
    public NameValuePair parseNameValuePair(CharArrayBuffer charArrayBuffer0, ParserCursor parserCursor0) {
        throw new RuntimeException("Stub!");
    }

    public NameValuePair parseNameValuePair(CharArrayBuffer charArrayBuffer0, ParserCursor parserCursor0, char[] arr_c) {
        throw new RuntimeException("Stub!");
    }

    public static final NameValuePair[] parseParameters(String s, HeaderValueParser headerValueParser0) {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.message.HeaderValueParser
    public NameValuePair[] parseParameters(CharArrayBuffer charArrayBuffer0, ParserCursor parserCursor0) {
        throw new RuntimeException("Stub!");
    }
}

