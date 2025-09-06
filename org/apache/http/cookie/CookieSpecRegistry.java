package org.apache.http.cookie;

import java.util.List;
import java.util.Map;
import org.apache.http.params.HttpParams;

@Deprecated
public final class CookieSpecRegistry {
    public CookieSpecRegistry() {
        throw new RuntimeException("Stub!");
    }

    public CookieSpec getCookieSpec(String s) {
        synchronized(this) {
            throw new RuntimeException("Stub!");
        }
    }

    public CookieSpec getCookieSpec(String s, HttpParams httpParams0) {
        synchronized(this) {
            throw new RuntimeException("Stub!");
        }
    }

    public List getSpecNames() {
        synchronized(this) {
            throw new RuntimeException("Stub!");
        }
    }

    public void register(String s, CookieSpecFactory cookieSpecFactory0) {
        synchronized(this) {
            throw new RuntimeException("Stub!");
        }
    }

    public void setItems(Map map0) {
        synchronized(this) {
            throw new RuntimeException("Stub!");
        }
    }

    public void unregister(String s) {
        synchronized(this) {
            throw new RuntimeException("Stub!");
        }
    }
}

