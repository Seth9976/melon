package org.apache.http.impl.cookie;

import org.apache.http.annotation.Immutable;
import org.apache.http.cookie.MalformedCookieException;
import org.apache.http.cookie.SetCookie;
import org.apache.http.util.Args;

@Immutable
public class BrowserCompatVersionAttributeHandler extends AbstractCookieAttributeHandlerHC4 {
    @Override  // org.apache.http.cookie.CookieAttributeHandler
    public void parse(SetCookie setCookie0, String s) {
        int v;
        Args.notNull(setCookie0, "Cookie");
        if(s == null) {
            throw new MalformedCookieException("Missing value for version attribute");
        }
        try {
            v = 0;
            v = Integer.parseInt(s);
        }
        catch(NumberFormatException unused_ex) {
        }
        setCookie0.setVersion(v);
    }
}

