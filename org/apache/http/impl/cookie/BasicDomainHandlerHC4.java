package org.apache.http.impl.cookie;

import org.apache.http.annotation.Immutable;
import org.apache.http.cookie.Cookie;
import org.apache.http.cookie.CookieAttributeHandler;
import org.apache.http.cookie.CookieOrigin;
import org.apache.http.cookie.CookieRestrictionViolationException;
import org.apache.http.cookie.MalformedCookieException;
import org.apache.http.cookie.SetCookie;
import org.apache.http.util.Args;

@Immutable
public class BasicDomainHandlerHC4 implements CookieAttributeHandler {
    @Override  // org.apache.http.cookie.CookieAttributeHandler
    public boolean match(Cookie cookie0, CookieOrigin cookieOrigin0) {
        Args.notNull(cookie0, "Cookie");
        Args.notNull(cookieOrigin0, "Cookie origin");
        String s = cookieOrigin0.getHost();
        String s1 = cookie0.getDomain();
        if(s1 == null) {
            return false;
        }
        if(s.equals(s1)) {
            return true;
        }
        if(!s1.startsWith(".")) {
            s1 = "." + s1;
        }
        return s.endsWith(s1) || s.equals(s1.substring(1));
    }

    @Override  // org.apache.http.cookie.CookieAttributeHandler
    public void parse(SetCookie setCookie0, String s) {
        Args.notNull(setCookie0, "Cookie");
        if(s == null) {
            throw new MalformedCookieException("Missing value for domain attribute");
        }
        if(s.trim().length() == 0) {
            throw new MalformedCookieException("Blank value for domain attribute");
        }
        setCookie0.setDomain(s);
    }

    @Override  // org.apache.http.cookie.CookieAttributeHandler
    public void validate(Cookie cookie0, CookieOrigin cookieOrigin0) {
        Args.notNull(cookie0, "Cookie");
        Args.notNull(cookieOrigin0, "Cookie origin");
        String s = cookieOrigin0.getHost();
        String s1 = cookie0.getDomain();
        if(s1 == null) {
            throw new CookieRestrictionViolationException("Cookie domain may not be null");
        }
        if(s.contains(".")) {
            if(s.endsWith(s1)) {
                return;
            }
            if(s1.startsWith(".")) {
                s1 = s1.substring(1, s1.length());
            }
            if(!s.equals(s1)) {
                throw new CookieRestrictionViolationException("Illegal domain attribute \"" + s1 + "\". Domain of origin: \"" + s + "\"");
            }
            return;
        }
        if(!s.equals(s1)) {
            throw new CookieRestrictionViolationException("Illegal domain attribute \"" + s1 + "\". Domain of origin: \"" + s + "\"");
        }
    }
}

