package org.apache.http.impl.io;

import org.apache.http.HttpRequestFactory;
import org.apache.http.annotation.Immutable;
import org.apache.http.config.MessageConstraints;
import org.apache.http.impl.DefaultHttpRequestFactoryHC4;
import org.apache.http.io.HttpMessageParser;
import org.apache.http.io.HttpMessageParserFactory;
import org.apache.http.io.SessionInputBuffer;
import org.apache.http.message.BasicLineParserHC4;
import org.apache.http.message.LineParser;

@Immutable
public class DefaultHttpRequestParserFactory implements HttpMessageParserFactory {
    public static final DefaultHttpRequestParserFactory INSTANCE;
    private final LineParser lineParser;
    private final HttpRequestFactory requestFactory;

    static {
        DefaultHttpRequestParserFactory.INSTANCE = new DefaultHttpRequestParserFactory();
    }

    public DefaultHttpRequestParserFactory() {
        this(null, null);
    }

    public DefaultHttpRequestParserFactory(LineParser lineParser0, HttpRequestFactory httpRequestFactory0) {
        if(lineParser0 == null) {
            lineParser0 = BasicLineParserHC4.INSTANCE;
        }
        this.lineParser = lineParser0;
        if(httpRequestFactory0 == null) {
            httpRequestFactory0 = DefaultHttpRequestFactoryHC4.INSTANCE;
        }
        this.requestFactory = httpRequestFactory0;
    }

    @Override  // org.apache.http.io.HttpMessageParserFactory
    public HttpMessageParser create(SessionInputBuffer sessionInputBuffer0, MessageConstraints messageConstraints0) {
        return new DefaultHttpRequestParser(sessionInputBuffer0, this.lineParser, this.requestFactory, messageConstraints0);
    }
}

