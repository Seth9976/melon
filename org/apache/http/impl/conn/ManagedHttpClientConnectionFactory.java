package org.apache.http.impl.conn;

import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CodingErrorAction;
import java.util.concurrent.atomic.AtomicLong;
import org.apache.http.HttpConnection;
import org.apache.http.annotation.Immutable;
import org.apache.http.config.ConnectionConfig;
import org.apache.http.config.MessageConstraints;
import org.apache.http.conn.HttpConnectionFactory;
import org.apache.http.conn.ManagedHttpClientConnection;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.impl.io.DefaultHttpRequestWriterFactory;
import org.apache.http.io.HttpMessageParserFactory;
import org.apache.http.io.HttpMessageWriterFactory;
import org.apache.http.io.SessionInputBuffer;

@Immutable
public class ManagedHttpClientConnectionFactory implements HttpConnectionFactory {
    private static final AtomicLong COUNTER;
    public static final ManagedHttpClientConnectionFactory INSTANCE;
    private final HttpMessageWriterFactory requestWriterFactory;
    private final HttpMessageParserFactory responseParserFactory;

    static {
        ManagedHttpClientConnectionFactory.COUNTER = new AtomicLong();
        ManagedHttpClientConnectionFactory.INSTANCE = new ManagedHttpClientConnectionFactory();
    }

    public ManagedHttpClientConnectionFactory() {
        this(null, null);
    }

    public ManagedHttpClientConnectionFactory(HttpMessageParserFactory httpMessageParserFactory0) {
        this(null, httpMessageParserFactory0);
    }

    public ManagedHttpClientConnectionFactory(HttpMessageWriterFactory httpMessageWriterFactory0, HttpMessageParserFactory httpMessageParserFactory0) {
        if(httpMessageWriterFactory0 == null) {
            httpMessageWriterFactory0 = DefaultHttpRequestWriterFactory.INSTANCE;
        }
        this.requestWriterFactory = httpMessageWriterFactory0;
        if(httpMessageParserFactory0 == null) {
            httpMessageParserFactory0 = (SessionInputBuffer sessionInputBuffer0, MessageConstraints messageConstraints0) -> new DefaultHttpResponseParser(sessionInputBuffer0, this.lineParser, this.responseFactory, messageConstraints0);
        }
        this.responseParserFactory = httpMessageParserFactory0;
    }

    @Override  // org.apache.http.conn.HttpConnectionFactory
    public HttpConnection create(Object object0, ConnectionConfig connectionConfig0) {
        return this.create(((HttpRoute)object0), connectionConfig0);
    }

    public ManagedHttpClientConnection create(HttpRoute httpRoute0, ConnectionConfig connectionConfig0) {
        ConnectionConfig connectionConfig1 = connectionConfig0 == null ? ConnectionConfig.DEFAULT : connectionConfig0;
        Charset charset0 = connectionConfig1.getCharset();
        CodingErrorAction codingErrorAction0 = connectionConfig1.getMalformedInputAction() == null ? CodingErrorAction.REPORT : connectionConfig1.getMalformedInputAction();
        CodingErrorAction codingErrorAction1 = connectionConfig1.getUnmappableInputAction() == null ? CodingErrorAction.REPORT : connectionConfig1.getUnmappableInputAction();
        if(charset0 != null) {
            CharsetDecoder charsetDecoder0 = charset0.newDecoder();
            charsetDecoder0.onMalformedInput(codingErrorAction0);
            charsetDecoder0.onUnmappableCharacter(codingErrorAction1);
            CharsetEncoder charsetEncoder0 = charset0.newEncoder();
            charsetEncoder0.onMalformedInput(codingErrorAction0);
            charsetEncoder0.onUnmappableCharacter(codingErrorAction1);
            return new LoggingManagedHttpClientConnection("http-outgoing-0", connectionConfig1.getBufferSize(), connectionConfig1.getFragmentSizeHint(), charsetDecoder0, charsetEncoder0, connectionConfig1.getMessageConstraints(), null, null, this.requestWriterFactory, this.responseParserFactory);
        }
        return new LoggingManagedHttpClientConnection("http-outgoing-1", connectionConfig1.getBufferSize(), connectionConfig1.getFragmentSizeHint(), null, null, connectionConfig1.getMessageConstraints(), null, null, this.requestWriterFactory, this.responseParserFactory);
    }
}

