package org.apache.http.impl.cookie;

import java.util.List;
import org.apache.http.Header;
import org.apache.http.cookie.Cookie;
import org.apache.http.cookie.CookieOrigin;
import org.apache.http.util.CharArrayBuffer;

@Deprecated
public class RFC2109Spec extends CookieSpecBase {
    public RFC2109Spec() {
        throw new RuntimeException("Stub!");
    }

    public RFC2109Spec(String[] arr_s, boolean z) {
        throw new RuntimeException("Stub!");
    }

    public void formatCookieAsVer(CharArrayBuffer charArrayBuffer0, Cookie cookie0, int v) {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.cookie.CookieSpec
    public List formatCookies(List list0) {
        throw new RuntimeException("Stub!");
    }

    public void formatParamAsVer(CharArrayBuffer charArrayBuffer0, String s, String s1, int v) {
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

    @Override  // org.apache.http.impl.cookie.CookieSpecBase
    public void validate(Cookie cookie0, CookieOrigin cookieOrigin0) {
        throw new RuntimeException("Stub!");
    }
}

