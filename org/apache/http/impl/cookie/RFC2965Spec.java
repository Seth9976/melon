package org.apache.http.impl.cookie;

import java.util.List;
import org.apache.http.Header;
import org.apache.http.cookie.Cookie;
import org.apache.http.cookie.CookieOrigin;
import org.apache.http.util.CharArrayBuffer;

@Deprecated
public class RFC2965Spec extends RFC2109Spec {
    public RFC2965Spec() {
        throw new RuntimeException("Stub!");
    }

    public RFC2965Spec(String[] arr_s, boolean z) {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.impl.cookie.RFC2109Spec
    public void formatCookieAsVer(CharArrayBuffer charArrayBuffer0, Cookie cookie0, int v) {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.impl.cookie.RFC2109Spec
    public int getVersion() {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.impl.cookie.RFC2109Spec
    public Header getVersionHeader() {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.impl.cookie.CookieSpecBase
    public boolean match(Cookie cookie0, CookieOrigin cookieOrigin0) {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.impl.cookie.RFC2109Spec
    public List parse(Header header0, CookieOrigin cookieOrigin0) {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.impl.cookie.RFC2109Spec
    public void validate(Cookie cookie0, CookieOrigin cookieOrigin0) {
        throw new RuntimeException("Stub!");
    }
}

