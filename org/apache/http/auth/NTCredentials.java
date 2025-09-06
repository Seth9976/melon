package org.apache.http.auth;

import java.security.Principal;

@Deprecated
public class NTCredentials implements Credentials {
    public NTCredentials(String s) {
        throw new RuntimeException("Stub!");
    }

    public NTCredentials(String s, String s1, String s2, String s3) {
        throw new RuntimeException("Stub!");
    }

    @Override
    public boolean equals(Object object0) {
        throw new RuntimeException("Stub!");
    }

    public String getDomain() {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.auth.Credentials
    public String getPassword() {
        throw new RuntimeException("Stub!");
    }

    public String getUserName() {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.auth.Credentials
    public Principal getUserPrincipal() {
        throw new RuntimeException("Stub!");
    }

    public String getWorkstation() {
        throw new RuntimeException("Stub!");
    }

    @Override
    public int hashCode() {
        throw new RuntimeException("Stub!");
    }

    @Override
    public String toString() {
        throw new RuntimeException("Stub!");
    }
}

