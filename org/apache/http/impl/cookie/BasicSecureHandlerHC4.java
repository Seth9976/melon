package org.apache.http.impl.cookie;

import org.apache.http.annotation.Immutable;
import org.apache.http.cookie.Cookie;
import org.apache.http.cookie.CookieOrigin;
import org.apache.http.cookie.SetCookie;
import org.apache.http.util.Args;

@Immutable
public class BasicSecureHandlerHC4 extends AbstractCookieAttributeHandlerHC4 {
    @Override  // org.apache.http.impl.cookie.AbstractCookieAttributeHandlerHC4
    public boolean match(Cookie cookie0, CookieOrigin cookieOrigin0) {
        Args.notNull(cookie0, "Cookie");
        Args.notNull(cookieOrigin0, "Cookie origin");
        return !cookie0.isSecure() || cookieOrigin0.isSecure();
    }

    @Override  // org.apache.http.cookie.CookieAttributeHandler
    public void parse(SetCookie setCookie0, String s) {
        Args.notNull(setCookie0, "Cookie");
        setCookie0.setSecure(true);
    }
}

