package org.apache.http.impl.io;

import org.apache.http.HttpMessage;
import org.apache.http.io.SessionOutputBuffer;
import org.apache.http.message.LineFormatter;
import org.apache.http.params.HttpParams;

@Deprecated
public class HttpRequestWriter extends AbstractMessageWriter {
    public HttpRequestWriter(SessionOutputBuffer sessionOutputBuffer0, LineFormatter lineFormatter0, HttpParams httpParams0) {
        super(null, null, null);
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.impl.io.AbstractMessageWriter
    public void writeHeadLine(HttpMessage httpMessage0) {
        throw new RuntimeException("Stub!");
    }
}

