package org.apache.http.impl.cookie;

import java.util.List;
import org.apache.http.Header;
import org.apache.http.cookie.CookieOrigin;

@Deprecated
public class NetscapeDraftSpec extends CookieSpecBase {
    protected static final String EXPIRES_PATTERN = "EEE, dd-MMM-yyyy HH:mm:ss z";

    public NetscapeDraftSpec() {
        throw new RuntimeException("Stub!");
    }

    public NetscapeDraftSpec(String[] arr_s) {
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

