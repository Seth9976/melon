package org.apache.http.impl.client;

import java.util.Collection;
import java.util.Map;
import java.util.Queue;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.annotation.Immutable;
import org.apache.http.auth.AuthScheme;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.protocol.HttpContext;

@Immutable
public class ProxyAuthenticationStrategy extends AuthenticationStrategyImpl {
    public static final ProxyAuthenticationStrategy INSTANCE;

    static {
        ProxyAuthenticationStrategy.INSTANCE = new ProxyAuthenticationStrategy();
    }

    public ProxyAuthenticationStrategy() {
        super(407, "Proxy-Authenticate");
    }

    @Override  // org.apache.http.impl.client.AuthenticationStrategyImpl
    public void authFailed(HttpHost httpHost0, AuthScheme authScheme0, HttpContext httpContext0) {
        super.authFailed(httpHost0, authScheme0, httpContext0);
    }

    @Override  // org.apache.http.impl.client.AuthenticationStrategyImpl
    public void authSucceeded(HttpHost httpHost0, AuthScheme authScheme0, HttpContext httpContext0) {
        super.authSucceeded(httpHost0, authScheme0, httpContext0);
    }

    @Override  // org.apache.http.impl.client.AuthenticationStrategyImpl
    public Map getChallenges(HttpHost httpHost0, HttpResponse httpResponse0, HttpContext httpContext0) {
        return super.getChallenges(httpHost0, httpResponse0, httpContext0);
    }

    @Override  // org.apache.http.impl.client.AuthenticationStrategyImpl
    public Collection getPreferredAuthSchemes(RequestConfig requestConfig0) {
        return requestConfig0.getProxyPreferredAuthSchemes();
    }

    @Override  // org.apache.http.impl.client.AuthenticationStrategyImpl
    public boolean isAuthenticationRequested(HttpHost httpHost0, HttpResponse httpResponse0, HttpContext httpContext0) {
        return super.isAuthenticationRequested(httpHost0, httpResponse0, httpContext0);
    }

    @Override  // org.apache.http.impl.client.AuthenticationStrategyImpl
    public Queue select(Map map0, HttpHost httpHost0, HttpResponse httpResponse0, HttpContext httpContext0) {
        return super.select(map0, httpHost0, httpResponse0, httpContext0);
    }
}

