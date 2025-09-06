package org.apache.http.impl.io;

import org.apache.http.HttpMessage;
import org.apache.http.HttpResponseFactory;
import org.apache.http.io.SessionInputBuffer;
import org.apache.http.message.LineParser;
import org.apache.http.params.HttpParams;

@Deprecated
public class HttpResponseParser extends AbstractMessageParser {
    public HttpResponseParser(SessionInputBuffer sessionInputBuffer0, LineParser lineParser0, HttpResponseFactory httpResponseFactory0, HttpParams httpParams0) {
        super(null, null, null);
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.impl.io.AbstractMessageParser
    public HttpMessage parseHead(SessionInputBuffer sessionInputBuffer0) {
        throw new RuntimeException("Stub!");
    }
}

