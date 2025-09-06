package org.apache.http.impl.auth;

import java.util.Map;
import org.apache.http.util.CharArrayBuffer;

@Deprecated
public abstract class RFC2617Scheme extends AuthSchemeBase {
    public RFC2617Scheme() {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.auth.AuthScheme
    public String getParameter(String s) {
        throw new RuntimeException("Stub!");
    }

    public Map getParameters() {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.auth.AuthScheme
    public String getRealm() {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.impl.auth.AuthSchemeBase
    public void parseChallenge(CharArrayBuffer charArrayBuffer0, int v, int v1) {
        throw new RuntimeException("Stub!");
    }
}

