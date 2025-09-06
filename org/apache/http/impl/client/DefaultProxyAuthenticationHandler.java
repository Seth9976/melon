package org.apache.http.impl.client;

import java.util.Map;
import org.apache.http.HttpResponse;
import org.apache.http.protocol.HttpContext;

@Deprecated
public class DefaultProxyAuthenticationHandler extends AbstractAuthenticationHandler {
    public DefaultProxyAuthenticationHandler() {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.client.AuthenticationHandler
    public Map getChallenges(HttpResponse httpResponse0, HttpContext httpContext0) {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.client.AuthenticationHandler
    public boolean isAuthenticationRequested(HttpResponse httpResponse0, HttpContext httpContext0) {
        throw new RuntimeException("Stub!");
    }
}

