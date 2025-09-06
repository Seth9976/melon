package org.apache.http.impl.client;

import java.util.List;
import java.util.Map;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.auth.AuthScheme;
import org.apache.http.client.AuthenticationHandler;
import org.apache.http.protocol.HttpContext;

@Deprecated
public abstract class AbstractAuthenticationHandler implements AuthenticationHandler {
    public AbstractAuthenticationHandler() {
        throw new RuntimeException("Stub!");
    }

    public List getAuthPreferences() {
        throw new RuntimeException("Stub!");
    }

    public Map parseChallenges(Header[] arr_header) {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.client.AuthenticationHandler
    public AuthScheme selectScheme(Map map0, HttpResponse httpResponse0, HttpContext httpContext0) {
        throw new RuntimeException("Stub!");
    }
}

