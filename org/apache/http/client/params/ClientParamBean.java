package org.apache.http.client.params;

import java.util.Collection;
import org.apache.http.HttpHost;
import org.apache.http.conn.ClientConnectionManagerFactory;
import org.apache.http.params.HttpAbstractParamBean;
import org.apache.http.params.HttpParams;

@Deprecated
public class ClientParamBean extends HttpAbstractParamBean {
    public ClientParamBean(HttpParams httpParams0) {
        super(null);
        throw new RuntimeException("Stub!");
    }

    public void setAllowCircularRedirects(boolean z) {
        throw new RuntimeException("Stub!");
    }

    public void setConnectionManagerFactory(ClientConnectionManagerFactory clientConnectionManagerFactory0) {
        throw new RuntimeException("Stub!");
    }

    public void setConnectionManagerFactoryClassName(String s) {
        throw new RuntimeException("Stub!");
    }

    public void setCookiePolicy(String s) {
        throw new RuntimeException("Stub!");
    }

    public void setDefaultHeaders(Collection collection0) {
        throw new RuntimeException("Stub!");
    }

    public void setDefaultHost(HttpHost httpHost0) {
        throw new RuntimeException("Stub!");
    }

    public void setHandleAuthentication(boolean z) {
        throw new RuntimeException("Stub!");
    }

    public void setHandleRedirects(boolean z) {
        throw new RuntimeException("Stub!");
    }

    public void setMaxRedirects(int v) {
        throw new RuntimeException("Stub!");
    }

    public void setRejectRelativeRedirect(boolean z) {
        throw new RuntimeException("Stub!");
    }

    public void setVirtualHost(HttpHost httpHost0) {
        throw new RuntimeException("Stub!");
    }
}

