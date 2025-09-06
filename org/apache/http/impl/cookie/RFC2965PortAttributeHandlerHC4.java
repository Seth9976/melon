package org.apache.http.impl.cookie;

import java.util.StringTokenizer;
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
public class RFC2965PortAttributeHandlerHC4 implements CookieAttributeHandler {
    @Override  // org.apache.http.cookie.CookieAttributeHandler
    public boolean match(Cookie cookie0, CookieOrigin cookieOrigin0) {
        Args.notNull(cookie0, "Cookie");
        Args.notNull(cookieOrigin0, "Cookie origin");
        int v = cookieOrigin0.getPort();
        if(cookie0 instanceof ClientCookie && ((ClientCookie)cookie0).containsAttribute("port")) {
            return cookie0.getPorts() == null ? false : RFC2965PortAttributeHandlerHC4.portMatch(v, cookie0.getPorts());
        }
        return true;
    }

    @Override  // org.apache.http.cookie.CookieAttributeHandler
    public void parse(SetCookie setCookie0, String s) {
        Args.notNull(setCookie0, "Cookie");
        if(setCookie0 instanceof SetCookie2 && s != null && s.trim().length() > 0) {
            ((SetCookie2)setCookie0).setPorts(RFC2965PortAttributeHandlerHC4.parsePortAttribute(s));
        }
    }

    private static int[] parsePortAttribute(String s) {
        StringTokenizer stringTokenizer0 = new StringTokenizer(s, ",");
        int[] arr_v = new int[stringTokenizer0.countTokens()];
        try {
            for(int v = 0; stringTokenizer0.hasMoreTokens(); ++v) {
                int v1 = Integer.parseInt(stringTokenizer0.nextToken().trim());
                arr_v[v] = v1;
                if(v1 < 0) {
                    throw new MalformedCookieException("Invalid Port attribute.");
                }
            }
            return arr_v;
        }
        catch(NumberFormatException numberFormatException0) {
            throw new MalformedCookieException("Invalid Port attribute: " + numberFormatException0.getMessage());
        }
    }

    private static boolean portMatch(int v, int[] arr_v) {
        for(int v1 = 0; v1 < arr_v.length; ++v1) {
            if(v == arr_v[v1]) {
                return true;
            }
        }
        return false;
    }

    @Override  // org.apache.http.cookie.CookieAttributeHandler
    public void validate(Cookie cookie0, CookieOrigin cookieOrigin0) {
        Args.notNull(cookie0, "Cookie");
        Args.notNull(cookieOrigin0, "Cookie origin");
        int v = cookieOrigin0.getPort();
        if(cookie0 instanceof ClientCookie && ((ClientCookie)cookie0).containsAttribute("port") && !RFC2965PortAttributeHandlerHC4.portMatch(v, cookie0.getPorts())) {
            throw new CookieRestrictionViolationException("Port attribute violates RFC 2965: Request port not found in cookie\'s port list.");
        }
    }
}

