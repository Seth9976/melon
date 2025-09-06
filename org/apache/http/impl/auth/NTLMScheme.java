package org.apache.http.impl.auth;

import org.apache.http.Header;
import org.apache.http.HttpRequest;
import org.apache.http.auth.Credentials;
import org.apache.http.util.CharArrayBuffer;

@Deprecated
public class NTLMScheme extends AuthSchemeBase {
    public NTLMScheme(NTLMEngine nTLMEngine0) {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.auth.AuthScheme
    public Header authenticate(Credentials credentials0, HttpRequest httpRequest0) {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.auth.AuthScheme
    public String getParameter(String s) {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.auth.AuthScheme
    public String getRealm() {
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
    public void parseChallenge(CharArrayBuffer charArrayBuffer0, int v, int v1) {
        throw new RuntimeException("Stub!");
    }
}

