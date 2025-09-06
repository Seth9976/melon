package org.apache.http.impl.io;

import org.apache.http.annotation.Immutable;
import org.apache.http.io.HttpMessageWriter;
import org.apache.http.io.HttpMessageWriterFactory;
import org.apache.http.io.SessionOutputBuffer;
import org.apache.http.message.BasicLineFormatterHC4;
import org.apache.http.message.LineFormatter;

@Immutable
public class DefaultHttpRequestWriterFactory implements HttpMessageWriterFactory {
    public static final DefaultHttpRequestWriterFactory INSTANCE;
    private final LineFormatter lineFormatter;

    static {
        DefaultHttpRequestWriterFactory.INSTANCE = new DefaultHttpRequestWriterFactory();
    }

    public DefaultHttpRequestWriterFactory() {
        this(null);
    }

    public DefaultHttpRequestWriterFactory(LineFormatter lineFormatter0) {
        if(lineFormatter0 == null) {
            lineFormatter0 = BasicLineFormatterHC4.INSTANCE;
        }
        this.lineFormatter = lineFormatter0;
    }

    @Override  // org.apache.http.io.HttpMessageWriterFactory
    public HttpMessageWriter create(SessionOutputBuffer sessionOutputBuffer0) {
        return new DefaultHttpRequestWriter(sessionOutputBuffer0, this.lineFormatter);
    }
}

