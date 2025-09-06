package org.apache.http.impl;

import org.apache.http.ConnectionReuseStrategy;
import org.apache.http.Header;
import org.apache.http.HeaderIterator;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.ParseException;
import org.apache.http.ProtocolVersion;
import org.apache.http.TokenIterator;
import org.apache.http.annotation.Immutable;
import org.apache.http.message.BasicTokenIterator;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.Args;

@Immutable
public class DefaultConnectionReuseStrategyHC4 implements ConnectionReuseStrategy {
    public static final DefaultConnectionReuseStrategyHC4 INSTANCE;

    static {
        DefaultConnectionReuseStrategyHC4.INSTANCE = new DefaultConnectionReuseStrategyHC4();
    }

    private boolean canResponseHaveBody(HttpResponse httpResponse0) {
        int v = httpResponse0.getStatusLine().getStatusCode();
        return v >= 200 && (v != 204 && v != 205 && v != 304);
    }

    public TokenIterator createTokenIterator(HeaderIterator headerIterator0) {
        return new BasicTokenIterator(headerIterator0);
    }

    @Override  // org.apache.http.ConnectionReuseStrategy
    public boolean keepAlive(HttpResponse httpResponse0, HttpContext httpContext0) {
        boolean z;
        Args.notNull(httpResponse0, "HTTP response");
        Args.notNull(httpContext0, "HTTP context");
        ProtocolVersion protocolVersion0 = httpResponse0.getStatusLine().getProtocolVersion();
        Header header0 = httpResponse0.getFirstHeader("Transfer-Encoding");
        if(header0 != null) {
            if(!"chunked".equalsIgnoreCase(header0.getValue())) {
                return false;
            }
        }
        else if(this.canResponseHaveBody(httpResponse0)) {
            Header[] arr_header = httpResponse0.getHeaders("Content-Length");
            if(arr_header.length != 1) {
                return false;
            }
            Header header1 = arr_header[0];
            try {
                if(Integer.parseInt(header1.getValue()) < 0) {
                    return false;
                }
            }
            catch(NumberFormatException unused_ex) {
                return false;
            }
        }
        HeaderIterator headerIterator0 = httpResponse0.headerIterator("Connection");
        if(!headerIterator0.hasNext()) {
            headerIterator0 = httpResponse0.headerIterator("Proxy-Connection");
        }
        if(headerIterator0.hasNext()) {
            try {
                z = false;
                TokenIterator tokenIterator0 = this.createTokenIterator(headerIterator0);
                while(true) {
                label_19:
                    if(!tokenIterator0.hasNext()) {
                        return z ? true : !protocolVersion0.lessEquals(HttpVersion.HTTP_1_0);
                    }
                    String s = tokenIterator0.nextToken();
                    if("Close".equalsIgnoreCase(s)) {
                        return false;
                    }
                    if("Keep-Alive".equalsIgnoreCase(s)) {
                        break;
                    }
                }
            }
            catch(ParseException unused_ex) {
                return false;
            }
            z = true;
            goto label_19;
        }
        return !protocolVersion0.lessEquals(HttpVersion.HTTP_1_0);
    }
}

