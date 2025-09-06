package org.apache.http.impl.conn;

import org.apache.http.HttpMessage;
import org.apache.http.HttpResponseFactory;
import org.apache.http.impl.io.AbstractMessageParser;
import org.apache.http.io.SessionInputBuffer;
import org.apache.http.message.LineParser;
import org.apache.http.params.HttpParams;

@Deprecated
public class DefaultResponseParser extends AbstractMessageParser {
    public DefaultResponseParser(SessionInputBuffer sessionInputBuffer0, LineParser lineParser0, HttpResponseFactory httpResponseFactory0, HttpParams httpParams0) {
        super(null, null, null);
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.impl.io.AbstractMessageParser
    public HttpMessage parseHead(SessionInputBuffer sessionInputBuffer0) {
        throw new RuntimeException("Stub!");
    }
}

