package org.apache.http.impl.cookie;

import org.apache.http.annotation.Immutable;
import org.apache.http.cookie.Cookie;
import org.apache.http.cookie.CookieAttributeHandler;
import org.apache.http.cookie.CookieOrigin;

@Immutable
public abstract class AbstractCookieAttributeHandlerHC4 implements CookieAttributeHandler {
    @Override  // org.apache.http.cookie.CookieAttributeHandler
    public boolean match(Cookie cookie0, CookieOrigin cookieOrigin0) {
        return true;
    }

    @Override  // org.apache.http.cookie.CookieAttributeHandler
    public void validate(Cookie cookie0, CookieOrigin cookieOrigin0) {
    }
}

