package org.apache.http.cookie;

import java.io.Serializable;
import java.util.Comparator;

@Deprecated
public class CookiePathComparator implements Serializable, Comparator {
    public CookiePathComparator() {
        throw new RuntimeException("Stub!");
    }

    @Override
    public int compare(Object object0, Object object1) {
        return this.compare(((Cookie)object0), ((Cookie)object1));
    }

    public int compare(Cookie cookie0, Cookie cookie1) {
        throw new RuntimeException("Stub!");
    }
}

