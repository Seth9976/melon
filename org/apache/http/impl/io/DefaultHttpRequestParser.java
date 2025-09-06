package org.apache.http.impl.io;

import org.apache.http.ConnectionClosedException;
import org.apache.http.HttpMessage;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestFactory;
import org.apache.http.RequestLine;
import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.config.MessageConstraints;
import org.apache.http.impl.DefaultHttpRequestFactoryHC4;
import org.apache.http.io.SessionInputBuffer;
import org.apache.http.message.LineParser;
import org.apache.http.message.ParserCursor;
import org.apache.http.params.HttpParams;
import org.apache.http.util.Args;
import org.apache.http.util.CharArrayBuffer;

@NotThreadSafe
public class DefaultHttpRequestParser extends AbstractMessageParserHC4 {
    private final CharArrayBuffer lineBuf;
    private final HttpRequestFactory requestFactory;

    public DefaultHttpRequestParser(SessionInputBuffer sessionInputBuffer0) {
        this(sessionInputBuffer0, null, null, MessageConstraints.DEFAULT);
    }

    public DefaultHttpRequestParser(SessionInputBuffer sessionInputBuffer0, MessageConstraints messageConstraints0) {
        this(sessionInputBuffer0, null, null, messageConstraints0);
    }

    public DefaultHttpRequestParser(SessionInputBuffer sessionInputBuffer0, LineParser lineParser0, HttpRequestFactory httpRequestFactory0, MessageConstraints messageConstraints0) {
        super(sessionInputBuffer0, lineParser0, messageConstraints0);
        if(httpRequestFactory0 == null) {
            httpRequestFactory0 = DefaultHttpRequestFactoryHC4.INSTANCE;
        }
        this.requestFactory = httpRequestFactory0;
        this.lineBuf = new CharArrayBuffer(0x80);
    }

    @Deprecated
    public DefaultHttpRequestParser(SessionInputBuffer sessionInputBuffer0, LineParser lineParser0, HttpRequestFactory httpRequestFactory0, HttpParams httpParams0) {
        super(sessionInputBuffer0, lineParser0, httpParams0);
        this.requestFactory = (HttpRequestFactory)Args.notNull(httpRequestFactory0, "Request factory");
        this.lineBuf = new CharArrayBuffer(0x80);
    }

    @Override  // org.apache.http.impl.io.AbstractMessageParserHC4
    public HttpMessage parseHead(SessionInputBuffer sessionInputBuffer0) {
        return this.parseHead(sessionInputBuffer0);
    }

    public HttpRequest parseHead(SessionInputBuffer sessionInputBuffer0) {
        this.lineBuf.clear();
        if(sessionInputBuffer0.readLine(this.lineBuf) == -1) {
            throw new ConnectionClosedException("Client closed connection");
        }
        ParserCursor parserCursor0 = new ParserCursor(0, this.lineBuf.length());
        RequestLine requestLine0 = this.lineParser.parseRequestLine(this.lineBuf, parserCursor0);
        return this.requestFactory.newHttpRequest(requestLine0);
    }
}

