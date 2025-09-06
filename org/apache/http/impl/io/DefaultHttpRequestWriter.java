package org.apache.http.impl.io;

import org.apache.http.HttpMessage;
import org.apache.http.HttpRequest;
import org.apache.http.RequestLine;
import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.io.SessionOutputBuffer;
import org.apache.http.message.LineFormatter;

@NotThreadSafe
public class DefaultHttpRequestWriter extends AbstractMessageWriterHC4 {
    public DefaultHttpRequestWriter(SessionOutputBuffer sessionOutputBuffer0) {
        this(sessionOutputBuffer0, null);
    }

    public DefaultHttpRequestWriter(SessionOutputBuffer sessionOutputBuffer0, LineFormatter lineFormatter0) {
        super(sessionOutputBuffer0, lineFormatter0);
    }

    @Override  // org.apache.http.impl.io.AbstractMessageWriterHC4
    public void writeHeadLine(HttpMessage httpMessage0) {
        RequestLine requestLine0 = ((HttpRequest)httpMessage0).getRequestLine();
        this.lineFormatter.formatRequestLine(this.lineBuf, requestLine0);
        this.sessionBuffer.writeLine(this.lineBuf);
    }
}

