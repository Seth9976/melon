package org.apache.http.impl.client;

import java.util.Date;
import java.util.List;
import org.apache.http.client.CookieStore;
import org.apache.http.cookie.Cookie;

@Deprecated
public class BasicCookieStore implements CookieStore {
    public BasicCookieStore() {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.client.CookieStore
    public void addCookie(Cookie cookie0) {
        synchronized(this) {
            throw new RuntimeException("Stub!");
        }
    }

    public void addCookies(Cookie[] arr_cookie) {
        synchronized(this) {
            throw new RuntimeException("Stub!");
        }
    }

    @Override  // org.apache.http.client.CookieStore
    public void clear() {
        synchronized(this) {
            throw new RuntimeException("Stub!");
        }
    }

    @Override  // org.apache.http.client.CookieStore
    public boolean clearExpired(Date date0) {
        synchronized(this) {
            throw new RuntimeException("Stub!");
        }
    }

    @Override  // org.apache.http.client.CookieStore
    public List getCookies() {
        synchronized(this) {
            throw new RuntimeException("Stub!");
        }
    }

    @Override
    public String toString() {
        throw new RuntimeException("Stub!");
    }
}

