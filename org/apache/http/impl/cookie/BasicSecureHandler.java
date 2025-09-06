package org.apache.http.impl.cookie;

import org.apache.http.cookie.Cookie;
import org.apache.http.cookie.CookieOrigin;
import org.apache.http.cookie.SetCookie;

@Deprecated
public class BasicSecureHandler extends AbstractCookieAttributeHandler {
    public BasicSecureHandler() {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.impl.cookie.AbstractCookieAttributeHandler
    public boolean match(Cookie cookie0, CookieOrigin cookieOrigin0) {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.cookie.CookieAttributeHandler
    public void parse(SetCookie setCookie0, String s) {
        throw new RuntimeException("Stub!");
    }
}

