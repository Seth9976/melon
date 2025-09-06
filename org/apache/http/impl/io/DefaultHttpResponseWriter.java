package org.apache.http.impl.io;

import org.apache.http.HttpMessage;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.io.SessionOutputBuffer;
import org.apache.http.message.LineFormatter;

@NotThreadSafe
public class DefaultHttpResponseWriter extends AbstractMessageWriterHC4 {
    public DefaultHttpResponseWriter(SessionOutputBuffer sessionOutputBuffer0) {
        super(sessionOutputBuffer0, null);
    }

    public DefaultHttpResponseWriter(SessionOutputBuffer sessionOutputBuffer0, LineFormatter lineFormatter0) {
        super(sessionOutputBuffer0, lineFormatter0);
    }

    @Override  // org.apache.http.impl.io.AbstractMessageWriterHC4
    public void writeHeadLine(HttpMessage httpMessage0) {
        StatusLine statusLine0 = ((HttpResponse)httpMessage0).getStatusLine();
        this.lineFormatter.formatStatusLine(this.lineBuf, statusLine0);
        this.sessionBuffer.writeLine(this.lineBuf);
    }
}

