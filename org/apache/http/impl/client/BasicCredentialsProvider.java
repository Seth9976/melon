package org.apache.http.impl.client;

import org.apache.http.auth.AuthScope;
import org.apache.http.auth.Credentials;
import org.apache.http.client.CredentialsProvider;

@Deprecated
public class BasicCredentialsProvider implements CredentialsProvider {
    public BasicCredentialsProvider() {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.client.CredentialsProvider
    public void clear() {
        synchronized(this) {
            throw new RuntimeException("Stub!");
        }
    }

    @Override  // org.apache.http.client.CredentialsProvider
    public Credentials getCredentials(AuthScope authScope0) {
        synchronized(this) {
            throw new RuntimeException("Stub!");
        }
    }

    @Override  // org.apache.http.client.CredentialsProvider
    public void setCredentials(AuthScope authScope0, Credentials credentials0) {
        synchronized(this) {
            throw new RuntimeException("Stub!");
        }
    }

    @Override
    public String toString() {
        throw new RuntimeException("Stub!");
    }
}

