package org.apache.http.cookie;

@Deprecated
public interface CookieAttributeHandler {
    boolean match(Cookie arg1, CookieOrigin arg2);

    void parse(SetCookie arg1, String arg2);

    void validate(Cookie arg1, CookieOrigin arg2);
}

