package org.apache.http.auth;

import org.apache.http.annotation.Immutable;
import org.apache.http.util.Args;

@Immutable
public final class AuthOption {
    private final AuthScheme authScheme;
    private final Credentials creds;

    public AuthOption(AuthScheme authScheme0, Credentials credentials0) {
        Args.notNull(authScheme0, "Auth scheme");
        Args.notNull(credentials0, "User credentials");
        this.authScheme = authScheme0;
        this.creds = credentials0;
    }

    public AuthScheme getAuthScheme() {
        return this.authScheme;
    }

    public Credentials getCredentials() {
        return this.creds;
    }

    @Override
    public String toString() {
        return this.authScheme.toString();
    }
}

