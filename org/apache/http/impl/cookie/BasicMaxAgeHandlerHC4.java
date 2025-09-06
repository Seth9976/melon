package org.apache.http.impl.cookie;

import java.util.Date;
import org.apache.http.annotation.Immutable;
import org.apache.http.cookie.MalformedCookieException;
import org.apache.http.cookie.SetCookie;
import org.apache.http.util.Args;

@Immutable
public class BasicMaxAgeHandlerHC4 extends AbstractCookieAttributeHandlerHC4 {
    @Override  // org.apache.http.cookie.CookieAttributeHandler
    public void parse(SetCookie setCookie0, String s) {
        int v;
        Args.notNull(setCookie0, "Cookie");
        if(s == null) {
            throw new MalformedCookieException("Missing value for max-age attribute");
        }
        try {
            v = Integer.parseInt(s);
        }
        catch(NumberFormatException unused_ex) {
            throw new MalformedCookieException("Invalid max-age attribute: " + s);
        }
        if(v < 0) {
            throw new MalformedCookieException("Negative max-age attribute: " + s);
        }
        setCookie0.setExpiryDate(new Date(((long)v) * 1000L + System.currentTimeMillis()));
    }
}

