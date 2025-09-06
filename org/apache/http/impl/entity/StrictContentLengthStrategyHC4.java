package org.apache.http.impl.entity;

import org.apache.http.Header;
import org.apache.http.HttpMessage;
import org.apache.http.HttpVersion;
import org.apache.http.ProtocolException;
import org.apache.http.annotation.Immutable;
import org.apache.http.entity.ContentLengthStrategy;
import org.apache.http.util.Args;

@Immutable
public class StrictContentLengthStrategyHC4 implements ContentLengthStrategy {
    public static final StrictContentLengthStrategyHC4 INSTANCE;
    private final int implicitLen;

    static {
        StrictContentLengthStrategyHC4.INSTANCE = new StrictContentLengthStrategyHC4();
    }

    public StrictContentLengthStrategyHC4() {
        this(-1);
    }

    public StrictContentLengthStrategyHC4(int v) {
        this.implicitLen = v;
    }

    @Override  // org.apache.http.entity.ContentLengthStrategy
    public long determineLength(HttpMessage httpMessage0) {
        Args.notNull(httpMessage0, "HTTP message");
        Header header0 = httpMessage0.getFirstHeader("Transfer-Encoding");
        if(header0 != null) {
            String s = header0.getValue();
            if("chunked".equalsIgnoreCase(s)) {
                if(httpMessage0.getProtocolVersion().lessEquals(HttpVersion.HTTP_1_0)) {
                    throw new ProtocolException("Chunked transfer encoding not allowed for " + httpMessage0.getProtocolVersion());
                }
                return -2L;
            }
            if(!"identity".equalsIgnoreCase(s)) {
                throw new ProtocolException("Unsupported transfer encoding: " + s);
            }
            return -1L;
        }
        Header header1 = httpMessage0.getFirstHeader("Content-Length");
        if(header1 != null) {
            String s1 = header1.getValue();
            try {
                long v = Long.parseLong(s1);
                if(v < 0L) {
                    throw new ProtocolException("Negative content length: " + s1);
                }
                return v;
            }
            catch(NumberFormatException unused_ex) {
                throw new ProtocolException("Invalid content length: " + s1);
            }
        }
        return (long)this.implicitLen;
    }
}

