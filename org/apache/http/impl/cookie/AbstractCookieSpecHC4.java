package org.apache.http.impl.cookie;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.cookie.CookieAttributeHandler;
import org.apache.http.cookie.CookieSpec;
import org.apache.http.util.Args;

@NotThreadSafe
public abstract class AbstractCookieSpecHC4 implements CookieSpec {
    private final Map attribHandlerMap;

    public AbstractCookieSpecHC4() {
        this.attribHandlerMap = new HashMap(10);
    }

    public CookieAttributeHandler findAttribHandler(String s) {
        return (CookieAttributeHandler)this.attribHandlerMap.get(s);
    }

    public CookieAttributeHandler getAttribHandler(String s) {
        CookieAttributeHandler cookieAttributeHandler0 = this.findAttribHandler(s);
        if(cookieAttributeHandler0 == null) {
            throw new IllegalStateException("Handler not registered for " + s + " attribute.");
        }
        return cookieAttributeHandler0;
    }

    public Collection getAttribHandlers() {
        return this.attribHandlerMap.values();
    }

    public void registerAttribHandler(String s, CookieAttributeHandler cookieAttributeHandler0) {
        Args.notNull(s, "Attribute name");
        Args.notNull(cookieAttributeHandler0, "Attribute handler");
        this.attribHandlerMap.put(s, cookieAttributeHandler0);
    }
}

