package org.apache.http.auth;

import java.util.Queue;
import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.util.Args;

@NotThreadSafe
public class AuthStateHC4 {
    private Queue authOptions;
    private AuthScheme authScheme;
    private AuthScope authScope;
    private Credentials credentials;
    private AuthProtocolState state;

    public AuthStateHC4() {
        this.state = AuthProtocolState.UNCHALLENGED;
    }

    public Queue getAuthOptions() {
        return this.authOptions;
    }

    public AuthScheme getAuthScheme() {
        return this.authScheme;
    }

    @Deprecated
    public AuthScope getAuthScope() {
        return this.authScope;
    }

    public Credentials getCredentials() {
        return this.credentials;
    }

    public AuthProtocolState getState() {
        return this.state;
    }

    public boolean hasAuthOptions() {
        return this.authOptions != null && !this.authOptions.isEmpty();
    }

    @Deprecated
    public void invalidate() {
        this.reset();
    }

    @Deprecated
    public boolean isValid() {
        return this.authScheme != null;
    }

    public void reset() {
        this.state = AuthProtocolState.UNCHALLENGED;
        this.authOptions = null;
        this.authScheme = null;
        this.authScope = null;
        this.credentials = null;
    }

    @Deprecated
    public void setAuthScheme(AuthScheme authScheme0) {
        if(authScheme0 == null) {
            this.reset();
            return;
        }
        this.authScheme = authScheme0;
    }

    @Deprecated
    public void setAuthScope(AuthScope authScope0) {
        this.authScope = authScope0;
    }

    @Deprecated
    public void setCredentials(Credentials credentials0) {
        this.credentials = credentials0;
    }

    public void setState(AuthProtocolState authProtocolState0) {
        if(authProtocolState0 == null) {
            authProtocolState0 = AuthProtocolState.UNCHALLENGED;
        }
        this.state = authProtocolState0;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("state:");
        stringBuilder0.append(this.state);
        stringBuilder0.append(";");
        if(this.authScheme != null) {
            stringBuilder0.append("auth scheme:");
            stringBuilder0.append(this.authScheme.getSchemeName());
            stringBuilder0.append(";");
        }
        if(this.credentials != null) {
            stringBuilder0.append("credentials present");
        }
        return stringBuilder0.toString();
    }

    public void update(Queue queue0) {
        Args.notEmpty(queue0, "Queue of auth options");
        this.authOptions = queue0;
        this.authScheme = null;
        this.credentials = null;
    }

    public void update(AuthScheme authScheme0, Credentials credentials0) {
        Args.notNull(authScheme0, "Auth scheme");
        Args.notNull(credentials0, "Credentials");
        this.authScheme = authScheme0;
        this.credentials = credentials0;
        this.authOptions = null;
    }
}

