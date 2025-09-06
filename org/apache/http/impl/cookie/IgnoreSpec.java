package org.apache.http.impl.cookie;

import java.util.Collections;
import java.util.List;
import org.apache.http.Header;
import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.cookie.CookieOrigin;

@NotThreadSafe
public class IgnoreSpec extends CookieSpecBaseHC4 {
    @Override  // org.apache.http.cookie.CookieSpec
    public List formatCookies(List list0) {
        return Collections.EMPTY_LIST;
    }

    @Override  // org.apache.http.cookie.CookieSpec
    public int getVersion() {
        return 0;
    }

    @Override  // org.apache.http.cookie.CookieSpec
    public Header getVersionHeader() {
        return null;
    }

    @Override  // org.apache.http.cookie.CookieSpec
    public List parse(Header header0, CookieOrigin cookieOrigin0) {
        return Collections.EMPTY_LIST;
    }
}

