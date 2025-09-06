package org.apache.http.impl.cookie;

import H0.b;
import org.apache.http.annotation.Immutable;
import org.apache.http.cookie.Cookie;
import org.apache.http.cookie.CookieAttributeHandler;
import org.apache.http.cookie.CookieOrigin;
import org.apache.http.cookie.CookieRestrictionViolationException;
import org.apache.http.cookie.SetCookie;
import org.apache.http.util.Args;
import org.apache.http.util.TextUtils;

@Immutable
public class BasicPathHandlerHC4 implements CookieAttributeHandler {
    @Override  // org.apache.http.cookie.CookieAttributeHandler
    public boolean match(Cookie cookie0, CookieOrigin cookieOrigin0) {
        Args.notNull(cookie0, "Cookie");
        Args.notNull(cookieOrigin0, "Cookie origin");
        String s = cookieOrigin0.getPath();
        String s1 = cookie0.getPath();
        if(s1 == null) {
            s1 = "/";
        }
        if(s1.length() > 1 && s1.endsWith("/")) {
            s1 = b.d(1, 0, s1);
        }
        boolean z = s.startsWith(s1);
        return !z || s.length() == s1.length() || s1.endsWith("/") ? z : s.charAt(s1.length()) == 0x2F;
    }

    @Override  // org.apache.http.cookie.CookieAttributeHandler
    public void parse(SetCookie setCookie0, String s) {
        Args.notNull(setCookie0, "Cookie");
        if(TextUtils.isBlank(s)) {
            s = "/";
        }
        setCookie0.setPath(s);
    }

    @Override  // org.apache.http.cookie.CookieAttributeHandler
    public void validate(Cookie cookie0, CookieOrigin cookieOrigin0) {
        if(!this.match(cookie0, cookieOrigin0)) {
            throw new CookieRestrictionViolationException("Illegal path attribute \"" + cookie0.getPath() + "\". Path of origin: \"" + cookieOrigin0.getPath() + "\"");
        }
    }
}

