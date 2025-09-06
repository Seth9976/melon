package org.apache.http.impl.cookie;

import java.util.Locale;
import org.apache.http.annotation.Immutable;
import org.apache.http.cookie.ClientCookie;
import org.apache.http.cookie.Cookie;
import org.apache.http.cookie.CookieAttributeHandler;
import org.apache.http.cookie.CookieOrigin;
import org.apache.http.cookie.CookieRestrictionViolationException;
import org.apache.http.cookie.MalformedCookieException;
import org.apache.http.cookie.SetCookie;
import org.apache.http.util.Args;

@Immutable
public class RFC2965DomainAttributeHandlerHC4 implements CookieAttributeHandler {
    // 去混淆评级： 低(30)
    public boolean domainMatch(String s, String s1) {
        return s.equals(s1) || s1.startsWith(".") && s.endsWith(s1);
    }

    @Override  // org.apache.http.cookie.CookieAttributeHandler
    public boolean match(Cookie cookie0, CookieOrigin cookieOrigin0) {
        Args.notNull(cookie0, "Cookie");
        Args.notNull(cookieOrigin0, "Cookie origin");
        String s = cookieOrigin0.getHost().toLowerCase(Locale.ENGLISH);
        String s1 = cookie0.getDomain();
        return this.domainMatch(s, s1) ? s.substring(0, s.length() - s1.length()).indexOf(46) == -1 : false;
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
        setCookie0.setDomain((s.startsWith(".") ? s.toLowerCase(Locale.ENGLISH) : "." + s.toLowerCase(Locale.ENGLISH)));
    }

    @Override  // org.apache.http.cookie.CookieAttributeHandler
    public void validate(Cookie cookie0, CookieOrigin cookieOrigin0) {
        Args.notNull(cookie0, "Cookie");
        Args.notNull(cookieOrigin0, "Cookie origin");
        String s = cookieOrigin0.getHost();
        Locale locale0 = Locale.ENGLISH;
        String s1 = s.toLowerCase(locale0);
        if(cookie0.getDomain() == null) {
            throw new CookieRestrictionViolationException("Invalid cookie state: domain not specified");
        }
        String s2 = cookie0.getDomain().toLowerCase(locale0);
        if(cookie0 instanceof ClientCookie && ((ClientCookie)cookie0).containsAttribute("domain")) {
            if(!s2.startsWith(".")) {
                throw new CookieRestrictionViolationException("Domain attribute \"" + cookie0.getDomain() + "\" violates RFC 2109: domain must start with a dot");
            }
            int v = s2.indexOf(46, 1);
            if((v < 0 || v == s2.length() - 1) && !s2.equals(".local")) {
                throw new CookieRestrictionViolationException("Domain attribute \"" + cookie0.getDomain() + "\" violates RFC 2965: the value contains no embedded dots and the value is not .local");
            }
            if(!this.domainMatch(s1, s2)) {
                throw new CookieRestrictionViolationException("Domain attribute \"" + cookie0.getDomain() + "\" violates RFC 2965: effective host name does not domain-match domain attribute.");
            }
            if(s1.substring(0, s1.length() - s2.length()).indexOf(46) != -1) {
                throw new CookieRestrictionViolationException("Domain attribute \"" + cookie0.getDomain() + "\" violates RFC 2965: effective host minus domain may not contain any dots");
            }
            return;
        }
        if(!cookie0.getDomain().equals(s1)) {
            throw new CookieRestrictionViolationException("Illegal domain attribute: \"" + cookie0.getDomain() + "\".Domain of origin: \"" + s1 + "\"");
        }
    }
}

