package org.apache.http.impl;

import java.net.Socket;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import org.apache.http.HttpConnection;
import org.apache.http.HttpConnectionFactory;
import org.apache.http.annotation.Immutable;
import org.apache.http.config.ConnectionConfig;
import org.apache.http.entity.ContentLengthStrategy;
import org.apache.http.io.HttpMessageParserFactory;
import org.apache.http.io.HttpMessageWriterFactory;

@Immutable
public class DefaultBHttpClientConnectionFactory implements HttpConnectionFactory {
    public static final DefaultBHttpClientConnectionFactory INSTANCE;
    private final ConnectionConfig cconfig;
    private final ContentLengthStrategy incomingContentStrategy;
    private final ContentLengthStrategy outgoingContentStrategy;
    private final HttpMessageWriterFactory requestWriterFactory;
    private final HttpMessageParserFactory responseParserFactory;

    static {
        DefaultBHttpClientConnectionFactory.INSTANCE = new DefaultBHttpClientConnectionFactory();
    }

    public DefaultBHttpClientConnectionFactory() {
        this(null, null, null, null, null);
    }

    public DefaultBHttpClientConnectionFactory(ConnectionConfig connectionConfig0) {
        this(connectionConfig0, null, null, null, null);
    }

    public DefaultBHttpClientConnectionFactory(ConnectionConfig connectionConfig0, ContentLengthStrategy contentLengthStrategy0, ContentLengthStrategy contentLengthStrategy1, HttpMessageWriterFactory httpMessageWriterFactory0, HttpMessageParserFactory httpMessageParserFactory0) {
        if(connectionConfig0 == null) {
            connectionConfig0 = ConnectionConfig.DEFAULT;
        }
        this.cconfig = connectionConfig0;
        this.incomingContentStrategy = contentLengthStrategy0;
        this.outgoingContentStrategy = contentLengthStrategy1;
        this.requestWriterFactory = httpMessageWriterFactory0;
        this.responseParserFactory = httpMessageParserFactory0;
    }

    public DefaultBHttpClientConnectionFactory(ConnectionConfig connectionConfig0, HttpMessageWriterFactory httpMessageWriterFactory0, HttpMessageParserFactory httpMessageParserFactory0) {
        this(connectionConfig0, null, null, httpMessageWriterFactory0, httpMessageParserFactory0);
    }

    @Override  // org.apache.http.HttpConnectionFactory
    public HttpConnection createConnection(Socket socket0) {
        return this.createConnection(socket0);
    }

    public DefaultBHttpClientConnection createConnection(Socket socket0) {
        CharsetDecoder charsetDecoder0 = ConnSupport.createDecoder(this.cconfig);
        CharsetEncoder charsetEncoder0 = ConnSupport.createEncoder(this.cconfig);
        DefaultBHttpClientConnection defaultBHttpClientConnection0 = new DefaultBHttpClientConnection(this.cconfig.getBufferSize(), this.cconfig.getFragmentSizeHint(), charsetDecoder0, charsetEncoder0, this.cconfig.getMessageConstraints(), this.incomingContentStrategy, this.outgoingContentStrategy, this.requestWriterFactory, this.responseParserFactory);
        defaultBHttpClientConnection0.bind(socket0);
        return defaultBHttpClientConnection0;
    }
}

