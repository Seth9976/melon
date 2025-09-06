package org.apache.http.impl.cookie;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import org.apache.http.client.utils.Punycode;
import org.apache.http.cookie.Cookie;
import org.apache.http.cookie.CookieAttributeHandler;
import org.apache.http.cookie.CookieOrigin;
import org.apache.http.cookie.SetCookie;

public class PublicSuffixFilterHC4 implements CookieAttributeHandler {
    private Set exceptions;
    private Set suffixes;
    private final CookieAttributeHandler wrapped;

    public PublicSuffixFilterHC4(CookieAttributeHandler cookieAttributeHandler0) {
        this.wrapped = cookieAttributeHandler0;
    }

    private boolean isForPublicSuffix(Cookie cookie0) {
        String s = cookie0.getDomain();
        if(s.startsWith(".")) {
            s = s.substring(1);
        }
        String s1 = Punycode.toUnicode(s);
        if((this.exceptions == null || !this.exceptions.contains(s1)) && this.suffixes != null) {
            while(true) {
                if(this.suffixes.contains(s1)) {
                    return true;
                }
                if(s1.startsWith("*.")) {
                    s1 = s1.substring(2);
                }
                int v = s1.indexOf(46);
                if(v == -1) {
                    break;
                }
                s1 = "*" + s1.substring(v);
                if(s1.length() <= 0) {
                    break;
                }
            }
        }
        return false;
    }

    // 去混淆评级： 低(20)
    @Override  // org.apache.http.cookie.CookieAttributeHandler
    public boolean match(Cookie cookie0, CookieOrigin cookieOrigin0) {
        return this.isForPublicSuffix(cookie0) ? false : this.wrapped.match(cookie0, cookieOrigin0);
    }

    @Override  // org.apache.http.cookie.CookieAttributeHandler
    public void parse(SetCookie setCookie0, String s) {
        this.wrapped.parse(setCookie0, s);
    }

    public void setExceptions(Collection collection0) {
        this.exceptions = new HashSet(collection0);
    }

    public void setPublicSuffixes(Collection collection0) {
        this.suffixes = new HashSet(collection0);
    }

    @Override  // org.apache.http.cookie.CookieAttributeHandler
    public void validate(Cookie cookie0, CookieOrigin cookieOrigin0) {
        this.wrapped.validate(cookie0, cookieOrigin0);
    }
}

