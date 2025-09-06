package org.apache.http.impl.conn;

import org.apache.http.HttpResponseFactory;
import org.apache.http.annotation.Immutable;
import org.apache.http.config.MessageConstraints;
import org.apache.http.impl.DefaultHttpResponseFactoryHC4;
import org.apache.http.io.HttpMessageParser;
import org.apache.http.io.HttpMessageParserFactory;
import org.apache.http.io.SessionInputBuffer;
import org.apache.http.message.BasicLineParserHC4;
import org.apache.http.message.LineParser;

@Immutable
public class DefaultHttpResponseParserFactory implements HttpMessageParserFactory {
    public static final DefaultHttpResponseParserFactory INSTANCE;
    private final LineParser lineParser;
    private final HttpResponseFactory responseFactory;

    static {
        DefaultHttpResponseParserFactory.INSTANCE = new DefaultHttpResponseParserFactory();
    }

    public DefaultHttpResponseParserFactory() {
        this(null, null);
    }

    public DefaultHttpResponseParserFactory(HttpResponseFactory httpResponseFactory0) {
        this(null, httpResponseFactory0);
    }

    public DefaultHttpResponseParserFactory(LineParser lineParser0, HttpResponseFactory httpResponseFactory0) {
        if(lineParser0 == null) {
            lineParser0 = BasicLineParserHC4.INSTANCE;
        }
        this.lineParser = lineParser0;
        if(httpResponseFactory0 == null) {
            httpResponseFactory0 = DefaultHttpResponseFactoryHC4.INSTANCE;
        }
        this.responseFactory = httpResponseFactory0;
    }

    // 检测为 Lambda 实现
    @Override  // org.apache.http.io.HttpMessageParserFactory
    public HttpMessageParser create(SessionInputBuffer sessionInputBuffer0, MessageConstraints messageConstraints0) [...]
}

