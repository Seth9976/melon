package org.apache.http.impl.io;

import org.apache.http.annotation.Immutable;
import org.apache.http.io.HttpMessageWriter;
import org.apache.http.io.HttpMessageWriterFactory;
import org.apache.http.io.SessionOutputBuffer;
import org.apache.http.message.BasicLineFormatterHC4;
import org.apache.http.message.LineFormatter;

@Immutable
public class DefaultHttpResponseWriterFactory implements HttpMessageWriterFactory {
    public static final DefaultHttpResponseWriterFactory INSTANCE;
    private final LineFormatter lineFormatter;

    static {
        DefaultHttpResponseWriterFactory.INSTANCE = new DefaultHttpResponseWriterFactory();
    }

    public DefaultHttpResponseWriterFactory() {
        this(null);
    }

    public DefaultHttpResponseWriterFactory(LineFormatter lineFormatter0) {
        if(lineFormatter0 == null) {
            lineFormatter0 = BasicLineFormatterHC4.INSTANCE;
        }
        this.lineFormatter = lineFormatter0;
    }

    @Override  // org.apache.http.io.HttpMessageWriterFactory
    public HttpMessageWriter create(SessionOutputBuffer sessionOutputBuffer0) {
        return new DefaultHttpResponseWriter(sessionOutputBuffer0, this.lineFormatter);
    }
}

