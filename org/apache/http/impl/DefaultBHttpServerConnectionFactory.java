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
public class DefaultBHttpServerConnectionFactory implements HttpConnectionFactory {
    public static final DefaultBHttpServerConnectionFactory INSTANCE;
    private final ConnectionConfig cconfig;
    private final ContentLengthStrategy incomingContentStrategy;
    private final ContentLengthStrategy outgoingContentStrategy;
    private final HttpMessageParserFactory requestParserFactory;
    private final HttpMessageWriterFactory responseWriterFactory;

    static {
        DefaultBHttpServerConnectionFactory.INSTANCE = new DefaultBHttpServerConnectionFactory();
    }

    public DefaultBHttpServerConnectionFactory() {
        this(null, null, null, null, null);
    }

    public DefaultBHttpServerConnectionFactory(ConnectionConfig connectionConfig0) {
        this(connectionConfig0, null, null, null, null);
    }

    public DefaultBHttpServerConnectionFactory(ConnectionConfig connectionConfig0, ContentLengthStrategy contentLengthStrategy0, ContentLengthStrategy contentLengthStrategy1, HttpMessageParserFactory httpMessageParserFactory0, HttpMessageWriterFactory httpMessageWriterFactory0) {
        if(connectionConfig0 == null) {
            connectionConfig0 = ConnectionConfig.DEFAULT;
        }
        this.cconfig = connectionConfig0;
        this.incomingContentStrategy = contentLengthStrategy0;
        this.outgoingContentStrategy = contentLengthStrategy1;
        this.requestParserFactory = httpMessageParserFactory0;
        this.responseWriterFactory = httpMessageWriterFactory0;
    }

    public DefaultBHttpServerConnectionFactory(ConnectionConfig connectionConfig0, HttpMessageParserFactory httpMessageParserFactory0, HttpMessageWriterFactory httpMessageWriterFactory0) {
        this(connectionConfig0, null, null, httpMessageParserFactory0, httpMessageWriterFactory0);
    }

    @Override  // org.apache.http.HttpConnectionFactory
    public HttpConnection createConnection(Socket socket0) {
        return this.createConnection(socket0);
    }

    public DefaultBHttpServerConnection createConnection(Socket socket0) {
        CharsetDecoder charsetDecoder0 = ConnSupport.createDecoder(this.cconfig);
        CharsetEncoder charsetEncoder0 = ConnSupport.createEncoder(this.cconfig);
        DefaultBHttpServerConnection defaultBHttpServerConnection0 = new DefaultBHttpServerConnection(this.cconfig.getBufferSize(), this.cconfig.getFragmentSizeHint(), charsetDecoder0, charsetEncoder0, this.cconfig.getMessageConstraints(), this.incomingContentStrategy, this.outgoingContentStrategy, this.requestParserFactory, this.responseWriterFactory);
        defaultBHttpServerConnection0.bind(socket0);
        return defaultBHttpServerConnection0;
    }
}

