package org.apache.http.cookie;

import java.util.List;
import org.apache.http.Header;

@Deprecated
public interface CookieSpec {
    List formatCookies(List arg1);

    int getVersion();

    Header getVersionHeader();

    boolean match(Cookie arg1, CookieOrigin arg2);

    List parse(Header arg1, CookieOrigin arg2);

    void validate(Cookie arg1, CookieOrigin arg2);
}

