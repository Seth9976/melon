package org.apache.http.impl.io;

import org.apache.http.Header;
import org.apache.http.HttpMessage;
import org.apache.http.io.HttpMessageParser;
import org.apache.http.io.SessionInputBuffer;
import org.apache.http.message.LineParser;
import org.apache.http.params.HttpParams;

@Deprecated
public abstract class AbstractMessageParser implements HttpMessageParser {
    protected final LineParser lineParser;

    public AbstractMessageParser(SessionInputBuffer sessionInputBuffer0, LineParser lineParser0, HttpParams httpParams0) {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.io.HttpMessageParser
    public HttpMessage parse() {
        throw new RuntimeException("Stub!");
    }

    public abstract HttpMessage parseHead(SessionInputBuffer arg1);

    public static Header[] parseHeaders(SessionInputBuffer sessionInputBuffer0, int v, int v1, LineParser lineParser0) {
        throw new RuntimeException("Stub!");
    }
}

