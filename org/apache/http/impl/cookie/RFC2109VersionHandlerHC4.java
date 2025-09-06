package org.apache.http.impl.cookie;

import org.apache.http.annotation.Immutable;
import org.apache.http.cookie.Cookie;
import org.apache.http.cookie.CookieOrigin;
import org.apache.http.cookie.CookieRestrictionViolationException;
import org.apache.http.cookie.MalformedCookieException;
import org.apache.http.cookie.SetCookie;
import org.apache.http.util.Args;

@Immutable
public class RFC2109VersionHandlerHC4 extends AbstractCookieAttributeHandlerHC4 {
    @Override  // org.apache.http.cookie.CookieAttributeHandler
    public void parse(SetCookie setCookie0, String s) {
        Args.notNull(setCookie0, "Cookie");
        if(s == null) {
            throw new MalformedCookieException("Missing value for version attribute");
        }
        if(s.trim().length() != 0) {
            try {
                setCookie0.setVersion(Integer.parseInt(s));
                return;
            }
            catch(NumberFormatException numberFormatException0) {
                throw new MalformedCookieException("Invalid version: " + numberFormatException0.getMessage());
            }
        }
        throw new MalformedCookieException("Blank value for version attribute");
    }

    @Override  // org.apache.http.impl.cookie.AbstractCookieAttributeHandlerHC4
    public void validate(Cookie cookie0, CookieOrigin cookieOrigin0) {
        Args.notNull(cookie0, "Cookie");
        if(cookie0.getVersion() < 0) {
            throw new CookieRestrictionViolationException("Cookie version may not be negative");
        }
    }
}

