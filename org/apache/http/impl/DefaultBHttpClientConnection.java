package org.apache.http.impl;

import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import org.apache.http.HttpClientConnection;
import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.config.MessageConstraints;
import org.apache.http.entity.ContentLengthStrategy;
import org.apache.http.impl.io.DefaultHttpRequestWriterFactory;
import org.apache.http.impl.io.DefaultHttpResponseParserFactory;
import org.apache.http.io.HttpMessageParser;
import org.apache.http.io.HttpMessageParserFactory;
import org.apache.http.io.HttpMessageWriter;
import org.apache.http.io.HttpMessageWriterFactory;
import org.apache.http.util.Args;

@NotThreadSafe
public class DefaultBHttpClientConnection extends BHttpConnectionBase implements HttpClientConnection {
    private final HttpMessageWriter requestWriter;
    private final HttpMessageParser responseParser;

    public DefaultBHttpClientConnection(int v) {
        this(v, v, null, null, null, null, null, null, null);
    }

    public DefaultBHttpClientConnection(int v, int v1, CharsetDecoder charsetDecoder0, CharsetEncoder charsetEncoder0, MessageConstraints messageConstraints0, ContentLengthStrategy contentLengthStrategy0, ContentLengthStrategy contentLengthStrategy1, HttpMessageWriterFactory httpMessageWriterFactory0, HttpMessageParserFactory httpMessageParserFactory0) {
        super(v, v1, charsetDecoder0, charsetEncoder0, messageConstraints0, contentLengthStrategy0, contentLengthStrategy1);
        if(httpMessageWriterFactory0 == null) {
            httpMessageWriterFactory0 = DefaultHttpRequestWriterFactory.INSTANCE;
        }
        this.requestWriter = httpMessageWriterFactory0.create(this.getSessionOutputBuffer());
        if(httpMessageParserFactory0 == null) {
            httpMessageParserFactory0 = DefaultHttpResponseParserFactory.INSTANCE;
        }
        this.responseParser = httpMessageParserFactory0.create(this.getSessionInputBuffer(), messageConstraints0);
    }

    public DefaultBHttpClientConnection(int v, CharsetDecoder charsetDecoder0, CharsetEncoder charsetEncoder0, MessageConstraints messageConstraints0) {
        this(v, v, charsetDecoder0, charsetEncoder0, messageConstraints0, null, null, null, null);
    }

    @Override  // org.apache.http.impl.BHttpConnectionBase
    public void bind(Socket socket0) {
        super.bind(socket0);
    }

    @Override  // org.apache.http.HttpClientConnection
    public void flush() {
        this.ensureOpen();
        this.doFlush();
    }

    @Override  // org.apache.http.HttpClientConnection
    public boolean isResponseAvailable(int v) {
        this.ensureOpen();
        try {
            return this.awaitInput(v);
        }
        catch(SocketTimeoutException unused_ex) {
            return false;
        }
    }

    public void onRequestSubmitted(HttpRequest httpRequest0) {
    }

    public void onResponseReceived(HttpResponse httpResponse0) {
    }

    @Override  // org.apache.http.HttpClientConnection
    public void receiveResponseEntity(HttpResponse httpResponse0) {
        Args.notNull(httpResponse0, "HTTP response");
        this.ensureOpen();
        httpResponse0.setEntity(this.prepareInput(httpResponse0));
    }

    @Override  // org.apache.http.HttpClientConnection
    public HttpResponse receiveResponseHeader() {
        this.ensureOpen();
        HttpResponse httpResponse0 = (HttpResponse)this.responseParser.parse();
        this.onResponseReceived(httpResponse0);
        if(httpResponse0.getStatusLine().getStatusCode() >= 200) {
            this.incrementResponseCount();
        }
        return httpResponse0;
    }

    @Override  // org.apache.http.HttpClientConnection
    public void sendRequestEntity(HttpEntityEnclosingRequest httpEntityEnclosingRequest0) {
        Args.notNull(httpEntityEnclosingRequest0, "HTTP request");
        this.ensureOpen();
        HttpEntity httpEntity0 = httpEntityEnclosingRequest0.getEntity();
        if(httpEntity0 == null) {
            return;
        }
        OutputStream outputStream0 = this.prepareOutput(httpEntityEnclosingRequest0);
        httpEntity0.writeTo(outputStream0);
        outputStream0.close();
    }

    @Override  // org.apache.http.HttpClientConnection
    public void sendRequestHeader(HttpRequest httpRequest0) {
        Args.notNull(httpRequest0, "HTTP request");
        this.ensureOpen();
        this.requestWriter.write(httpRequest0);
        this.onRequestSubmitted(httpRequest0);
        this.incrementRequestCount();
    }
}

