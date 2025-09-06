package org.apache.http.message;

import org.apache.http.HeaderElement;
import org.apache.http.NameValuePair;
import org.apache.http.util.CharArrayBuffer;

@Deprecated
public interface HeaderValueParser {
    HeaderElement[] parseElements(CharArrayBuffer arg1, ParserCursor arg2);

    HeaderElement parseHeaderElement(CharArrayBuffer arg1, ParserCursor arg2);

    NameValuePair parseNameValuePair(CharArrayBuffer arg1, ParserCursor arg2);

    NameValuePair[] parseParameters(CharArrayBuffer arg1, ParserCursor arg2);
}

