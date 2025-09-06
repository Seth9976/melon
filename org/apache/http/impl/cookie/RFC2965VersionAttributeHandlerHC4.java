package org.apache.http.impl.cookie;

import org.apache.http.annotation.Immutable;
import org.apache.http.cookie.ClientCookie;
import org.apache.http.cookie.Cookie;
import org.apache.http.cookie.CookieAttributeHandler;
import org.apache.http.cookie.CookieOrigin;
import org.apache.http.cookie.CookieRestrictionViolationException;
import org.apache.http.cookie.MalformedCookieException;
import org.apache.http.cookie.SetCookie2;
import org.apache.http.cookie.SetCookie;
import org.apache.http.util.Args;

@Immutable
public class RFC2965VersionAttributeHandlerHC4 implements CookieAttributeHandler {
    @Override  // org.apache.http.cookie.CookieAttributeHandler
    public boolean match(Cookie cookie0, CookieOrigin cookieOrigin0) {
        return true;
    }

    @Override  // org.apache.http.cookie.CookieAttributeHandler
    public void parse(SetCookie setCookie0, String s) {
        int v;
        Args.notNull(setCookie0, "Cookie");
        if(s == null) {
            throw new MalformedCookieException("Missing value for version attribute");
        }
        try {
            v = -1;
            v = Integer.parseInt(s);
        }
        catch(NumberFormatException unused_ex) {
        }
        if(v < 0) {
            throw new MalformedCookieException("Invalid cookie version.");
        }
        setCookie0.setVersion(v);
    }

    @Override  // org.apache.http.cookie.CookieAttributeHandler
    public void validate(Cookie cookie0, CookieOrigin cookieOrigin0) {
        Args.notNull(cookie0, "Cookie");
        if(cookie0 instanceof SetCookie2 && cookie0 instanceof ClientCookie && !((ClientCookie)cookie0).containsAttribute("version")) {
            throw new CookieRestrictionViolationException("Violates RFC 2965. Version attribute is required.");
        }
    }
}

