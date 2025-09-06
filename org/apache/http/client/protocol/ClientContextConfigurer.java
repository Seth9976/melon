package org.apache.http.client.protocol;

import java.util.List;
import org.apache.http.auth.AuthSchemeRegistry;
import org.apache.http.client.CookieStore;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.cookie.CookieSpecRegistry;
import org.apache.http.protocol.HttpContext;

@Deprecated
public class ClientContextConfigurer implements ClientContext {
    public ClientContextConfigurer(HttpContext httpContext0) {
        throw new RuntimeException("Stub!");
    }

    public void setAuthSchemePref(List list0) {
        throw new RuntimeException("Stub!");
    }

    public void setAuthSchemeRegistry(AuthSchemeRegistry authSchemeRegistry0) {
        throw new RuntimeException("Stub!");
    }

    public void setCookieSpecRegistry(CookieSpecRegistry cookieSpecRegistry0) {
        throw new RuntimeException("Stub!");
    }

    public void setCookieStore(CookieStore cookieStore0) {
        throw new RuntimeException("Stub!");
    }

    public void setCredentialsProvider(CredentialsProvider credentialsProvider0) {
        throw new RuntimeException("Stub!");
    }
}

