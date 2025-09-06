package org.apache.http.impl.conn;

import android.util.Log;
import org.apache.http.HttpMessage;
import org.apache.http.HttpResponse;
import org.apache.http.HttpResponseFactory;
import org.apache.http.NoHttpResponseException;
import org.apache.http.ProtocolException;
import org.apache.http.StatusLine;
import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.config.MessageConstraints;
import org.apache.http.impl.DefaultHttpResponseFactoryHC4;
import org.apache.http.impl.io.AbstractMessageParserHC4;
import org.apache.http.io.SessionInputBuffer;
import org.apache.http.message.LineParser;
import org.apache.http.message.ParserCursor;
import org.apache.http.params.HttpParams;
import org.apache.http.util.Args;
import org.apache.http.util.CharArrayBuffer;

@NotThreadSafe
public class DefaultHttpResponseParser extends AbstractMessageParserHC4 {
    private static final String TAG = "HttpClient";
    private final CharArrayBuffer lineBuf;
    private final HttpResponseFactory responseFactory;

    public DefaultHttpResponseParser(SessionInputBuffer sessionInputBuffer0) {
        this(sessionInputBuffer0, null, null, MessageConstraints.DEFAULT);
    }

    public DefaultHttpResponseParser(SessionInputBuffer sessionInputBuffer0, MessageConstraints messageConstraints0) {
        this(sessionInputBuffer0, null, null, messageConstraints0);
    }

    public DefaultHttpResponseParser(SessionInputBuffer sessionInputBuffer0, LineParser lineParser0, HttpResponseFactory httpResponseFactory0, MessageConstraints messageConstraints0) {
        super(sessionInputBuffer0, lineParser0, messageConstraints0);
        if(httpResponseFactory0 == null) {
            httpResponseFactory0 = DefaultHttpResponseFactoryHC4.INSTANCE;
        }
        this.responseFactory = httpResponseFactory0;
        this.lineBuf = new CharArrayBuffer(0x80);
    }

    @Deprecated
    public DefaultHttpResponseParser(SessionInputBuffer sessionInputBuffer0, LineParser lineParser0, HttpResponseFactory httpResponseFactory0, HttpParams httpParams0) {
        super(sessionInputBuffer0, lineParser0, httpParams0);
        Args.notNull(httpResponseFactory0, "Response factory");
        this.responseFactory = httpResponseFactory0;
        this.lineBuf = new CharArrayBuffer(0x80);
    }

    @Override  // org.apache.http.impl.io.AbstractMessageParserHC4
    public HttpMessage parseHead(SessionInputBuffer sessionInputBuffer0) {
        return this.parseHead(sessionInputBuffer0);
    }

    public HttpResponse parseHead(SessionInputBuffer sessionInputBuffer0) {
        for(int v = 0; true; ++v) {
            this.lineBuf.clear();
            int v1 = sessionInputBuffer0.readLine(this.lineBuf);
            if(v1 == -1 && v == 0) {
                throw new NoHttpResponseException("The target server failed to respond");
            }
            ParserCursor parserCursor0 = new ParserCursor(0, this.lineBuf.length());
            if(this.lineParser.hasProtocolVersion(this.lineBuf, parserCursor0)) {
                StatusLine statusLine0 = this.lineParser.parseStatusLine(this.lineBuf, parserCursor0);
                return this.responseFactory.newHttpResponse(statusLine0, null);
            }
            if(v1 == -1) {
                break;
            }
            if(Log.isLoggable("HttpClient", 3)) {
                Log.d("HttpClient", "Garbage in response: " + this.lineBuf.toString());
            }
        }
        throw new ProtocolException("The server failed to respond with a valid HTTP response");
    }

    public boolean reject(CharArrayBuffer charArrayBuffer0, int v) [...] // Inlined contents
}

