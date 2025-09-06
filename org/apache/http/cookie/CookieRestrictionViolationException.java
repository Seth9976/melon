package org.apache.http.cookie;

import org.apache.http.annotation.Immutable;

@Immutable
public class CookieRestrictionViolationException extends MalformedCookieException {
    private static final long serialVersionUID = 0x664BE3B3EF7DA655L;

    public CookieRestrictionViolationException() {
    }

    public CookieRestrictionViolationException(String s) {
        super(s);
    }
}

