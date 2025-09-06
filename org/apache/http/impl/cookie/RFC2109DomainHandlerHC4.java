package org.apache.http.impl.cookie;

import java.util.Locale;
import org.apache.http.annotation.Immutable;
import org.apache.http.cookie.Cookie;
import org.apache.http.cookie.CookieAttributeHandler;
import org.apache.http.cookie.CookieOrigin;
import org.apache.http.cookie.CookieRestrictionViolationException;
import org.apache.http.cookie.MalformedCookieException;
import org.apache.http.cookie.SetCookie;
import org.apache.http.util.Args;

@Immutable
public class RFC2109DomainHandlerHC4 implements CookieAttributeHandler {
    @Override  // org.apache.http.cookie.CookieAttributeHandler
    public boolean match(Cookie cookie0, CookieOrigin cookieOrigin0) {
        Args.notNull(cookie0, "Cookie");
        Args.notNull(cookieOrigin0, "Cookie origin");
        String s = cookieOrigin0.getHost();
        String s1 = cookie0.getDomain();
        return s1 == null ? false : s.equals(s1) || s1.startsWith(".") && s.endsWith(s1);
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
        if(!s1.equals(s)) {
            if(s1.indexOf(46) == -1) {
                throw new CookieRestrictionViolationException("Domain attribute \"" + s1 + "\" does not match the host \"" + s + "\"");
            }
            if(!s1.startsWith(".")) {
                throw new CookieRestrictionViolationException("Domain attribute \"" + s1 + "\" violates RFC 2109: domain must start with a dot");
            }
            int v = s1.indexOf(46, 1);
            if(v < 0 || v == s1.length() - 1) {
                throw new CookieRestrictionViolationException("Domain attribute \"" + s1 + "\" violates RFC 2109: domain must contain an embedded dot");
            }
            String s2 = s.toLowerCase(Locale.ENGLISH);
            if(!s2.endsWith(s1)) {
                throw new CookieRestrictionViolationException("Illegal domain attribute \"" + s1 + "\". Domain of origin: \"" + s2 + "\"");
            }
            if(s2.substring(0, s2.length() - s1.length()).indexOf(46) != -1) {
                throw new CookieRestrictionViolationException("Domain attribute \"" + s1 + "\" violates RFC 2109: host minus domain may not contain any dots");
            }
        }
    }
}

