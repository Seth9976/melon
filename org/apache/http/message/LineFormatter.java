package org.apache.http.message;

import org.apache.http.Header;
import org.apache.http.ProtocolVersion;
import org.apache.http.RequestLine;
import org.apache.http.StatusLine;
import org.apache.http.util.CharArrayBuffer;

@Deprecated
public interface LineFormatter {
    CharArrayBuffer appendProtocolVersion(CharArrayBuffer arg1, ProtocolVersion arg2);

    CharArrayBuffer formatHeader(CharArrayBuffer arg1, Header arg2);

    CharArrayBuffer formatRequestLine(CharArrayBuffer arg1, RequestLine arg2);

    CharArrayBuffer formatStatusLine(CharArrayBuffer arg1, StatusLine arg2);
}

