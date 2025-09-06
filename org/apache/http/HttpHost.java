package org.apache.http;

@Deprecated
public final class HttpHost {
    public static final String DEFAULT_SCHEME_NAME = "http";
    protected final String hostname;
    protected final String lcHostname;
    protected final int port;
    protected final String schemeName;

    public HttpHost(String s) {
        throw new RuntimeException("Stub!");
    }

    public HttpHost(String s, int v) {
        throw new RuntimeException("Stub!");
    }

    public HttpHost(String s, int v, String s1) {
        throw new RuntimeException("Stub!");
    }

    public HttpHost(HttpHost httpHost0) {
        throw new RuntimeException("Stub!");
    }

    @Override
    public Object clone() {
        throw new RuntimeException("Stub!");
    }

    @Override
    public boolean equals(Object object0) {
        throw new RuntimeException("Stub!");
    }

    public String getHostName() {
        throw new RuntimeException("Stub!");
    }

    public int getPort() {
        throw new RuntimeException("Stub!");
    }

    public String getSchemeName() {
        throw new RuntimeException("Stub!");
    }

    @Override
    public int hashCode() {
        throw new RuntimeException("Stub!");
    }

    public String toHostString() {
        throw new RuntimeException("Stub!");
    }

    @Override
    public String toString() {
        throw new RuntimeException("Stub!");
    }

    public String toURI() {
        throw new RuntimeException("Stub!");
    }
}

