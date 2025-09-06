package org.apache.http.impl.client;

import org.apache.http.HeaderElement;
import org.apache.http.HttpResponse;
import org.apache.http.annotation.Immutable;
import org.apache.http.conn.ConnectionKeepAliveStrategy;
import org.apache.http.message.BasicHeaderElementIterator;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.Args;

@Immutable
public class DefaultConnectionKeepAliveStrategyHC4 implements ConnectionKeepAliveStrategy {
    public static final DefaultConnectionKeepAliveStrategyHC4 INSTANCE;

    static {
        DefaultConnectionKeepAliveStrategyHC4.INSTANCE = new DefaultConnectionKeepAliveStrategyHC4();
    }

    @Override  // org.apache.http.conn.ConnectionKeepAliveStrategy
    public long getKeepAliveDuration(HttpResponse httpResponse0, HttpContext httpContext0) {
        Args.notNull(httpResponse0, "HTTP response");
        BasicHeaderElementIterator basicHeaderElementIterator0 = new BasicHeaderElementIterator(httpResponse0.headerIterator("Keep-Alive"));
        while(basicHeaderElementIterator0.hasNext()) {
            HeaderElement headerElement0 = basicHeaderElementIterator0.nextElement();
            String s = headerElement0.getName();
            String s1 = headerElement0.getValue();
            if(s1 != null && s.equalsIgnoreCase("timeout")) {
                try {
                    return Long.parseLong(s1) * 1000L;
                }
                catch(NumberFormatException unused_ex) {
                    continue;
                }
            }
            if(false) {
                break;
            }
        }
        return -1L;
    }
}

