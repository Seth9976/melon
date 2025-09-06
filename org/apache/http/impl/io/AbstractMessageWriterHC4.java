package org.apache.http.impl.io;

import org.apache.http.Header;
import org.apache.http.HeaderIterator;
import org.apache.http.HttpMessage;
import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.io.HttpMessageWriter;
import org.apache.http.io.SessionOutputBuffer;
import org.apache.http.message.BasicLineFormatterHC4;
import org.apache.http.message.LineFormatter;
import org.apache.http.params.HttpParams;
import org.apache.http.util.Args;
import org.apache.http.util.CharArrayBuffer;

@NotThreadSafe
public abstract class AbstractMessageWriterHC4 implements HttpMessageWriter {
    protected final CharArrayBuffer lineBuf;
    protected final LineFormatter lineFormatter;
    protected final SessionOutputBuffer sessionBuffer;

    public AbstractMessageWriterHC4(SessionOutputBuffer sessionOutputBuffer0, LineFormatter lineFormatter0) {
        this.sessionBuffer = (SessionOutputBuffer)Args.notNull(sessionOutputBuffer0, "Session input buffer");
        if(lineFormatter0 == null) {
            lineFormatter0 = BasicLineFormatterHC4.INSTANCE;
        }
        this.lineFormatter = lineFormatter0;
        this.lineBuf = new CharArrayBuffer(0x80);
    }

    @Deprecated
    public AbstractMessageWriterHC4(SessionOutputBuffer sessionOutputBuffer0, LineFormatter lineFormatter0, HttpParams httpParams0) {
        Args.notNull(sessionOutputBuffer0, "Session input buffer");
        this.sessionBuffer = sessionOutputBuffer0;
        this.lineBuf = new CharArrayBuffer(0x80);
        if(lineFormatter0 == null) {
            lineFormatter0 = BasicLineFormatterHC4.INSTANCE;
        }
        this.lineFormatter = lineFormatter0;
    }

    @Override  // org.apache.http.io.HttpMessageWriter
    public void write(HttpMessage httpMessage0) {
        Args.notNull(httpMessage0, "HTTP message");
        this.writeHeadLine(httpMessage0);
        HeaderIterator headerIterator0 = httpMessage0.headerIterator();
        while(headerIterator0.hasNext()) {
            Header header0 = headerIterator0.nextHeader();
            CharArrayBuffer charArrayBuffer0 = this.lineFormatter.formatHeader(this.lineBuf, header0);
            this.sessionBuffer.writeLine(charArrayBuffer0);
        }
        this.lineBuf.clear();
        this.sessionBuffer.writeLine(this.lineBuf);
    }

    public abstract void writeHeadLine(HttpMessage arg1);
}

