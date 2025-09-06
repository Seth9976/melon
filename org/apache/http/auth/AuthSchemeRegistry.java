package org.apache.http.auth;

import java.util.List;
import java.util.Map;
import org.apache.http.params.HttpParams;

@Deprecated
public final class AuthSchemeRegistry {
    public AuthSchemeRegistry() {
        throw new RuntimeException("Stub!");
    }

    public AuthScheme getAuthScheme(String s, HttpParams httpParams0) {
        synchronized(this) {
            throw new RuntimeException("Stub!");
        }
    }

    public List getSchemeNames() {
        synchronized(this) {
            throw new RuntimeException("Stub!");
        }
    }

    public void register(String s, AuthSchemeFactory authSchemeFactory0) {
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

