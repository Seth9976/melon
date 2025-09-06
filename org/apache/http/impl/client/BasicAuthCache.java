package org.apache.http.impl.client;

import java.util.HashMap;
import org.apache.http.HttpHost;
import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.auth.AuthScheme;
import org.apache.http.client.AuthCache;
import org.apache.http.conn.SchemePortResolver;
import org.apache.http.conn.UnsupportedSchemeException;
import org.apache.http.impl.conn.DefaultSchemePortResolver;
import org.apache.http.util.Args;

@NotThreadSafe
public class BasicAuthCache implements AuthCache {
    private final HashMap map;
    private final SchemePortResolver schemePortResolver;

    public BasicAuthCache() {
        this(null);
    }

    public BasicAuthCache(SchemePortResolver schemePortResolver0) {
        this.map = new HashMap();
        if(schemePortResolver0 == null) {
            schemePortResolver0 = DefaultSchemePortResolver.INSTANCE;
        }
        this.schemePortResolver = schemePortResolver0;
    }

    @Override  // org.apache.http.client.AuthCache
    public void clear() {
        this.map.clear();
    }

    @Override  // org.apache.http.client.AuthCache
    public AuthScheme get(HttpHost httpHost0) {
        Args.notNull(httpHost0, "HTTP host");
        HttpHost httpHost1 = this.getKey(httpHost0);
        return (AuthScheme)this.map.get(httpHost1);
    }

    public HttpHost getKey(HttpHost httpHost0) {
        int v;
        if(httpHost0.getPort() <= 0) {
            try {
                v = this.schemePortResolver.resolve(httpHost0);
            }
            catch(UnsupportedSchemeException unused_ex) {
                return httpHost0;
            }
            return new HttpHost(httpHost0.getHostName(), v, httpHost0.getSchemeName());
        }
        return httpHost0;
    }

    @Override  // org.apache.http.client.AuthCache
    public void put(HttpHost httpHost0, AuthScheme authScheme0) {
        Args.notNull(httpHost0, "HTTP host");
        HttpHost httpHost1 = this.getKey(httpHost0);
        this.map.put(httpHost1, authScheme0);
    }

    @Override  // org.apache.http.client.AuthCache
    public void remove(HttpHost httpHost0) {
        Args.notNull(httpHost0, "HTTP host");
        HttpHost httpHost1 = this.getKey(httpHost0);
        this.map.remove(httpHost1);
    }

    @Override
    public String toString() {
        return this.map.toString();
    }
}

