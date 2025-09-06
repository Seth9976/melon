package org.apache.http.impl.client;

import org.apache.http.annotation.Immutable;
import org.apache.http.client.UserTokenHandler;
import org.apache.http.protocol.HttpContext;

@Immutable
public class NoopUserTokenHandler implements UserTokenHandler {
    public static final NoopUserTokenHandler INSTANCE;

    static {
        NoopUserTokenHandler.INSTANCE = new NoopUserTokenHandler();
    }

    // 检测为 Lambda 实现
    @Override  // org.apache.http.client.UserTokenHandler
    public Object getUserToken(HttpContext httpContext0) [...]
}

