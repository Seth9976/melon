package org.apache.http.impl.auth;

import org.apache.http.Header;
import org.apache.http.HttpRequest;
import org.apache.http.auth.Credentials;

@Deprecated
public class BasicScheme extends RFC2617Scheme {
    public BasicScheme() {
        throw new RuntimeException("Stub!");
    }

    public static Header authenticate(Credentials credentials0, String s, boolean z) {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.auth.AuthScheme
    public Header authenticate(Credentials credentials0, HttpRequest httpRequest0) {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.auth.AuthScheme
    public String getSchemeName() {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.auth.AuthScheme
    public boolean isComplete() {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.auth.AuthScheme
    public boolean isConnectionBased() {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.impl.auth.AuthSchemeBase
    public void processChallenge(Header header0) {
        throw new RuntimeException("Stub!");
    }
}

