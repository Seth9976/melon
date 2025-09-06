package org.apache.http.impl.cookie;

import org.apache.http.cookie.Cookie;
import org.apache.http.cookie.CookieOrigin;

@Deprecated
public class NetscapeDomainHandler extends BasicDomainHandler {
    public NetscapeDomainHandler() {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.impl.cookie.BasicDomainHandler
    public boolean match(Cookie cookie0, CookieOrigin cookieOrigin0) {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.impl.cookie.BasicDomainHandler
    public void validate(Cookie cookie0, CookieOrigin cookieOrigin0) {
        throw new RuntimeException("Stub!");
    }
}

