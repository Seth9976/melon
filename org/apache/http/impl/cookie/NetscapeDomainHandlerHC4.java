package org.apache.http.impl.cookie;

import java.util.Locale;
import java.util.StringTokenizer;
import org.apache.http.annotation.Immutable;
import org.apache.http.cookie.Cookie;
import org.apache.http.cookie.CookieOrigin;
import org.apache.http.cookie.CookieRestrictionViolationException;
import org.apache.http.util.Args;

@Immutable
public class NetscapeDomainHandlerHC4 extends BasicDomainHandlerHC4 {
    // 去混淆评级： 低(35)
    private static boolean isSpecialDomain(String s) {
        String s1 = s.toUpperCase(Locale.ENGLISH);
        return s1.endsWith(".COM") || s1.endsWith(".EDU") || s1.endsWith(".NET") || s1.endsWith(".GOV") || s1.endsWith(".MIL") || s1.endsWith(".ORG") || s1.endsWith(".INT");
    }

    @Override  // org.apache.http.impl.cookie.BasicDomainHandlerHC4
    public boolean match(Cookie cookie0, CookieOrigin cookieOrigin0) {
        Args.notNull(cookie0, "Cookie");
        Args.notNull(cookieOrigin0, "Cookie origin");
        String s = cookieOrigin0.getHost();
        String s1 = cookie0.getDomain();
        return s1 == null ? false : s.endsWith(s1);
    }

    @Override  // org.apache.http.impl.cookie.BasicDomainHandlerHC4
    public void validate(Cookie cookie0, CookieOrigin cookieOrigin0) {
        super.validate(cookie0, cookieOrigin0);
        String s = cookieOrigin0.getHost();
        String s1 = cookie0.getDomain();
        if(s.contains(".")) {
            int v = new StringTokenizer(s1, ".").countTokens();
            if(NetscapeDomainHandlerHC4.isSpecialDomain(s1)) {
                if(v < 2) {
                    throw new CookieRestrictionViolationException("Domain attribute \"" + s1 + "\" violates the Netscape cookie specification for special domains");
                }
            }
            else if(v < 3) {
                throw new CookieRestrictionViolationException("Domain attribute \"" + s1 + "\" violates the Netscape cookie specification");
            }
        }
    }
}

