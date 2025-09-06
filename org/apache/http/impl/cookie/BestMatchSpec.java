package org.apache.http.impl.cookie;

import java.util.List;
import org.apache.http.Header;
import org.apache.http.cookie.Cookie;
import org.apache.http.cookie.CookieOrigin;
import org.apache.http.cookie.CookieSpec;

@Deprecated
public class BestMatchSpec implements CookieSpec {
    public BestMatchSpec() {
        throw new RuntimeException("Stub!");
    }

    public BestMatchSpec(String[] arr_s, boolean z) {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.cookie.CookieSpec
    public List formatCookies(List list0) {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.cookie.CookieSpec
    public int getVersion() {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.cookie.CookieSpec
    public Header getVersionHeader() {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.cookie.CookieSpec
    public boolean match(Cookie cookie0, CookieOrigin cookieOrigin0) {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.cookie.CookieSpec
    public List parse(Header header0, CookieOrigin cookieOrigin0) {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.cookie.CookieSpec
    public void validate(Cookie cookie0, CookieOrigin cookieOrigin0) {
        throw new RuntimeException("Stub!");
    }
}

