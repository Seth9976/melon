package org.apache.http.impl.auth;

import org.apache.http.Header;
import org.apache.http.auth.AuthScheme;
import org.apache.http.util.CharArrayBuffer;

@Deprecated
public abstract class AuthSchemeBase implements AuthScheme {
    public AuthSchemeBase() {
        throw new RuntimeException("Stub!");
    }

    public boolean isProxy() {
        throw new RuntimeException("Stub!");
    }

    public abstract void parseChallenge(CharArrayBuffer arg1, int arg2, int arg3);

    @Override  // org.apache.http.auth.AuthScheme
    public void processChallenge(Header header0) {
        throw new RuntimeException("Stub!");
    }
}

