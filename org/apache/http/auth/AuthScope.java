package org.apache.http.auth;

@Deprecated
public class AuthScope {
    public static final AuthScope ANY = null;
    public static final String ANY_HOST = null;
    public static final int ANY_PORT = -1;
    public static final String ANY_REALM;
    public static final String ANY_SCHEME;

    public AuthScope(String s, int v) {
        throw new RuntimeException("Stub!");
    }

    public AuthScope(String s, int v, String s1) {
        throw new RuntimeException("Stub!");
    }

    public AuthScope(String s, int v, String s1, String s2) {
        throw new RuntimeException("Stub!");
    }

    public AuthScope(AuthScope authScope0) {
        throw new RuntimeException("Stub!");
    }

    @Override
    public boolean equals(Object object0) {
        throw new RuntimeException("Stub!");
    }

    public String getHost() {
        throw new RuntimeException("Stub!");
    }

    public int getPort() {
        throw new RuntimeException("Stub!");
    }

    public String getRealm() {
        throw new RuntimeException("Stub!");
    }

    public String getScheme() {
        throw new RuntimeException("Stub!");
    }

    @Override
    public int hashCode() {
        throw new RuntimeException("Stub!");
    }

    public int match(AuthScope authScope0) {
        throw new RuntimeException("Stub!");
    }

    @Override
    public String toString() {
        throw new RuntimeException("Stub!");
    }
}

