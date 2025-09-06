package org.apache.http.impl.cookie;

import java.util.Collection;
import org.apache.http.cookie.CookieAttributeHandler;
import org.apache.http.cookie.CookieSpec;

@Deprecated
public abstract class AbstractCookieSpec implements CookieSpec {
    public AbstractCookieSpec() {
        throw new RuntimeException("Stub!");
    }

    public CookieAttributeHandler findAttribHandler(String s) {
        throw new RuntimeException("Stub!");
    }

    public CookieAttributeHandler getAttribHandler(String s) {
        throw new RuntimeException("Stub!");
    }

    public Collection getAttribHandlers() {
        throw new RuntimeException("Stub!");
    }

    public void registerAttribHandler(String s, CookieAttributeHandler cookieAttributeHandler0) {
        throw new RuntimeException("Stub!");
    }
}

