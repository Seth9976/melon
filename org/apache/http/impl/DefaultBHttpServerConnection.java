package org.apache.http.impl;

import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.HttpServerConnection;
import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.config.MessageConstraints;
import org.apache.http.entity.ContentLengthStrategy;
import org.apache.http.impl.entity.DisallowIdentityContentLengthStrategy;
import org.apache.http.impl.io.DefaultHttpRequestParserFactory;
import org.apache.http.impl.io.DefaultHttpResponseWriterFactory;
import org.apache.http.io.HttpMessageParser;
import org.apache.http.io.HttpMessageParserFactory;
import org.apache.http.io.HttpMessageWriter;
import org.apache.http.io.HttpMessageWriterFactory;
import org.apache.http.util.Args;

@NotThreadSafe
public class DefaultBHttpServerConnection extends BHttpConnectionBase implements HttpServerConnection {
    private final HttpMessageParser requestParser;
    private final HttpMessageWriter responseWriter;

    public DefaultBHttpServerConnection(int v) {
        this(v, v, null, null, null, null, null, null, null);
    }

    public DefaultBHttpServerConnection(int v, int v1, CharsetDecoder charsetDecoder0, CharsetEncoder charsetEncoder0, MessageConstraints messageConstraints0, ContentLengthStrategy contentLengthStrategy0, ContentLengthStrategy contentLengthStrategy1, HttpMessageParserFactory httpMessageParserFactory0, HttpMessageWriterFactory httpMessageWriterFactory0) {
        if(contentLengthStrategy0 == null) {
            contentLengthStrategy0 = DisallowIdentityContentLengthStrategy.INSTANCE;
        }
        super(v, v1, charsetDecoder0, charsetEncoder0, messageConstraints0, contentLengthStrategy0, contentLengthStrategy1);
        HttpMessageParserFactory httpMessageParserFactory1 = httpMessageParserFactory0 == null ? DefaultHttpRequestParserFactory.INSTANCE : httpMessageParserFactory0;
        this.requestParser = httpMessageParserFactory1.create(this.getSessionInputBuffer(), messageConstraints0);
        HttpMessageWriterFactory httpMessageWriterFactory1 = httpMessageWriterFactory0 == null ? DefaultHttpResponseWriterFactory.INSTANCE : httpMessageWriterFactory0;
        this.responseWriter = httpMessageWriterFactory1.create(this.getSessionOutputBuffer());
    }

    public DefaultBHttpServerConnection(int v, CharsetDecoder charsetDecoder0, CharsetEncoder charsetEncoder0, MessageConstraints messageConstraints0) {
        this(v, v, charsetDecoder0, charsetEncoder0, messageConstraints0, null, null, null, null);
    }

    @Override  // org.apache.http.impl.BHttpConnectionBase
    public void bind(Socket socket0) {
        super.bind(socket0);
    }

    @Override  // org.apache.http.HttpServerConnection
    public void flush() {
        this.ensureOpen();
        this.doFlush();
    }

    public void onRequestReceived(HttpRequest httpRequest0) {
    }

    public void onResponseSubmitted(HttpResponse httpResponse0) {
    }

    @Override  // org.apache.http.HttpServerConnection
    public void receiveRequestEntity(HttpEntityEnclosingRequest httpEntityEnclosingRequest0) {
        Args.notNull(httpEntityEnclosingRequest0, "HTTP request");
        this.ensureOpen();
        httpEntityEnclosingRequest0.setEntity(this.prepareInput(httpEntityEnclosingRequest0));
    }

    @Override  // org.apache.http.HttpServerConnection
    public HttpRequest receiveRequestHeader() {
        this.ensureOpen();
        HttpRequest httpRequest0 = (HttpRequest)this.requestParser.parse();
        this.incrementRequestCount();
        return httpRequest0;
    }

    @Override  // org.apache.http.HttpServerConnection
    public void sendResponseEntity(HttpResponse httpResponse0) {
        Args.notNull(httpResponse0, "HTTP response");
        this.ensureOpen();
        HttpEntity httpEntity0 = httpResponse0.getEntity();
        if(httpEntity0 == null) {
            return;
        }
        OutputStream outputStream0 = this.prepareOutput(httpResponse0);
        httpEntity0.writeTo(outputStream0);
        outputStream0.close();
    }

    @Override  // org.apache.http.HttpServerConnection
    public void sendResponseHeader(HttpResponse httpResponse0) {
        Args.notNull(httpResponse0, "HTTP response");
        this.ensureOpen();
        this.responseWriter.write(httpResponse0);
        if(httpResponse0.getStatusLine().getStatusCode() >= 200) {
            this.incrementResponseCount();
        }
    }
}

