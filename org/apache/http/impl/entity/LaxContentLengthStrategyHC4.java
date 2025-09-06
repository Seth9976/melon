package org.apache.http.impl.entity;

import org.apache.http.Header;
import org.apache.http.HeaderElement;
import org.apache.http.HttpMessage;
import org.apache.http.ParseException;
import org.apache.http.ProtocolException;
import org.apache.http.annotation.Immutable;
import org.apache.http.entity.ContentLengthStrategy;
import org.apache.http.util.Args;

@Immutable
public class LaxContentLengthStrategyHC4 implements ContentLengthStrategy {
    public static final LaxContentLengthStrategyHC4 INSTANCE;
    private final int implicitLen;

    static {
        LaxContentLengthStrategyHC4.INSTANCE = new LaxContentLengthStrategyHC4();
    }

    public LaxContentLengthStrategyHC4() {
        this(-1);
    }

    public LaxContentLengthStrategyHC4(int v) {
        this.implicitLen = v;
    }

    @Override  // org.apache.http.entity.ContentLengthStrategy
    public long determineLength(HttpMessage httpMessage0) {
        HeaderElement[] arr_headerElement;
        Args.notNull(httpMessage0, "HTTP message");
        Header header0 = httpMessage0.getFirstHeader("Transfer-Encoding");
        if(header0 != null) {
            try {
                arr_headerElement = header0.getElements();
            }
            catch(ParseException parseException0) {
                throw new ProtocolException("Invalid Transfer-Encoding header value: " + header0, parseException0);
            }
            if("identity".equalsIgnoreCase(header0.getValue())) {
                return -1L;
            }
            return arr_headerElement.length <= 0 || !"chunked".equalsIgnoreCase(arr_headerElement[arr_headerElement.length - 1].getName()) ? -1L : -2L;
        }
        if(httpMessage0.getFirstHeader("Content-Length") != null) {
            Header[] arr_header = httpMessage0.getHeaders("Content-Length");
            int v = arr_header.length - 1;
            while(v >= 0) {
                Header header1 = arr_header[v];
                try {
                    long v1 = Long.parseLong(header1.getValue());
                    return v1 < 0L ? -1L : v1;
                }
                catch(NumberFormatException unused_ex) {
                    --v;
                }
            }
            return -1L;
        }
        return (long)this.implicitLen;
    }
}

