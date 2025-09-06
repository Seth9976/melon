package org.apache.http.impl.cookie;

import java.util.List;
import org.apache.http.Header;
import org.apache.http.cookie.CookieOrigin;

@Deprecated
public class BrowserCompatSpec extends CookieSpecBase {
    protected static final String[] DATE_PATTERNS;

    public BrowserCompatSpec() {
        throw new RuntimeException("Stub!");
    }

    public BrowserCompatSpec(String[] arr_s) {
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
    public List parse(Header header0, CookieOrigin cookieOrigin0) {
        throw new RuntimeException("Stub!");
    }
}

