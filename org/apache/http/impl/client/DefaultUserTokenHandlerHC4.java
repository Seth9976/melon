package org.apache.http.impl.client;

import java.security.Principal;
import javax.net.ssl.SSLSession;
import org.apache.http.HttpConnection;
import org.apache.http.annotation.Immutable;
import org.apache.http.auth.AuthScheme;
import org.apache.http.auth.AuthStateHC4;
import org.apache.http.auth.Credentials;
import org.apache.http.client.UserTokenHandler;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.conn.ManagedHttpClientConnection;
import org.apache.http.protocol.HttpContext;

@Immutable
public class DefaultUserTokenHandlerHC4 implements UserTokenHandler {
    public static final DefaultUserTokenHandlerHC4 INSTANCE;

    static {
        DefaultUserTokenHandlerHC4.INSTANCE = new DefaultUserTokenHandlerHC4();
    }

    private static Principal getAuthPrincipal(AuthStateHC4 authStateHC40) {
        AuthScheme authScheme0 = authStateHC40.getAuthScheme();
        if(authScheme0 != null && authScheme0.isComplete() && authScheme0.isConnectionBased()) {
            Credentials credentials0 = authStateHC40.getCredentials();
            return credentials0 == null ? null : credentials0.getUserPrincipal();
        }
        return null;
    }

    @Override  // org.apache.http.client.UserTokenHandler
    public Object getUserToken(HttpContext httpContext0) {
        Principal principal0;
        HttpClientContext httpClientContext0 = HttpClientContext.adapt(httpContext0);
        AuthStateHC4 authStateHC40 = httpClientContext0.getTargetAuthState();
        if(authStateHC40 == null) {
            principal0 = null;
        }
        else {
            principal0 = DefaultUserTokenHandlerHC4.getAuthPrincipal(authStateHC40);
            if(principal0 == null) {
                principal0 = DefaultUserTokenHandlerHC4.getAuthPrincipal(httpClientContext0.getProxyAuthState());
            }
        }
        if(principal0 == null) {
            HttpConnection httpConnection0 = httpClientContext0.getConnection();
            if(httpConnection0.isOpen() && httpConnection0 instanceof ManagedHttpClientConnection) {
                SSLSession sSLSession0 = ((ManagedHttpClientConnection)httpConnection0).getSSLSession();
                return sSLSession0 == null ? null : sSLSession0.getLocalPrincipal();
            }
        }
        return principal0;
    }
}

