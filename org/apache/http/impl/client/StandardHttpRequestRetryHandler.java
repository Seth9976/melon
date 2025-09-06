package org.apache.http.impl.client;

import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.http.HttpRequest;
import org.apache.http.annotation.Immutable;

@Immutable
public class StandardHttpRequestRetryHandler extends DefaultHttpRequestRetryHandlerHC4 {
    private final Map idempotentMethods;

    public StandardHttpRequestRetryHandler() {
        this(3, false);
    }

    public StandardHttpRequestRetryHandler(int v, boolean z) {
        super(v, z);
        ConcurrentHashMap concurrentHashMap0 = new ConcurrentHashMap();
        this.idempotentMethods = concurrentHashMap0;
        concurrentHashMap0.put("GET", Boolean.TRUE);
        concurrentHashMap0.put("HEAD", Boolean.TRUE);
        concurrentHashMap0.put("PUT", Boolean.TRUE);
        concurrentHashMap0.put("DELETE", Boolean.TRUE);
        concurrentHashMap0.put("OPTIONS", Boolean.TRUE);
        concurrentHashMap0.put("TRACE", Boolean.TRUE);
    }

    @Override  // org.apache.http.impl.client.DefaultHttpRequestRetryHandlerHC4
    public boolean handleAsIdempotent(HttpRequest httpRequest0) {
        String s = httpRequest0.getRequestLine().getMethod().toUpperCase(Locale.ENGLISH);
        Boolean boolean0 = (Boolean)this.idempotentMethods.get(s);
        return boolean0 != null && boolean0.booleanValue();
    }
}

