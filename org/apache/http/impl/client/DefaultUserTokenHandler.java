package org.apache.http.impl.client;

import org.apache.http.client.UserTokenHandler;
import org.apache.http.protocol.HttpContext;

@Deprecated
public class DefaultUserTokenHandler implements UserTokenHandler {
    public DefaultUserTokenHandler() {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.client.UserTokenHandler
    public Object getUserToken(HttpContext httpContext0) {
        throw new RuntimeException("Stub!");
    }
}

