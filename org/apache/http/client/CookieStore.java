package org.apache.http.client;

import java.util.Date;
import java.util.List;
import org.apache.http.cookie.Cookie;

@Deprecated
public interface CookieStore {
    void addCookie(Cookie arg1);

    void clear();

    boolean clearExpired(Date arg1);

    List getCookies();
}

