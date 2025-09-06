package org.apache.http.message;

import org.apache.http.Header;
import org.apache.http.ProtocolVersion;
import org.apache.http.RequestLine;
import org.apache.http.StatusLine;
import org.apache.http.util.CharArrayBuffer;

@Deprecated
public interface LineParser {
    boolean hasProtocolVersion(CharArrayBuffer arg1, ParserCursor arg2);

    Header parseHeader(CharArrayBuffer arg1);

    ProtocolVersion parseProtocolVersion(CharArrayBuffer arg1, ParserCursor arg2);

    RequestLine parseRequestLine(CharArrayBuffer arg1, ParserCursor arg2);

    StatusLine parseStatusLine(CharArrayBuffer arg1, ParserCursor arg2);
}

