package org.apache.http.impl.conn;

import org.apache.http.HttpHost;
import org.apache.http.annotation.Immutable;
import org.apache.http.conn.SchemePortResolver;
import org.apache.http.conn.UnsupportedSchemeException;
import org.apache.http.util.Args;

@Immutable
public class DefaultSchemePortResolver implements SchemePortResolver {
    public static final DefaultSchemePortResolver INSTANCE;

    static {
        DefaultSchemePortResolver.INSTANCE = new DefaultSchemePortResolver();
    }

    @Override  // org.apache.http.conn.SchemePortResolver
    public int resolve(HttpHost httpHost0) {
        Args.notNull(httpHost0, "HTTP host");
        int v = httpHost0.getPort();
        if(v > 0) {
            return v;
        }
        String s = httpHost0.getSchemeName();
        if(s.equalsIgnoreCase("http")) {
            return 80;
        }
        if(!s.equalsIgnoreCase("https")) {
            throw new UnsupportedSchemeException(s + " protocol is not supported");
        }
        return 443;
    }
}

