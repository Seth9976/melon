package org.apache.http.impl.cookie;

import org.apache.http.cookie.Cookie;
import org.apache.http.cookie.CookieAttributeHandler;
import org.apache.http.cookie.CookieOrigin;

@Deprecated
public abstract class AbstractCookieAttributeHandler implements CookieAttributeHandler {
    public AbstractCookieAttributeHandler() {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.cookie.CookieAttributeHandler
    public boolean match(Cookie cookie0, CookieOrigin cookieOrigin0) {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.cookie.CookieAttributeHandler
    public void validate(Cookie cookie0, CookieOrigin cookieOrigin0) {
        throw new RuntimeException("Stub!");
    }
}

