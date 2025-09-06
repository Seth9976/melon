package org.apache.http.client.params;

import java.net.InetAddress;
import org.apache.http.HttpHost;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.params.HttpParams;

@Deprecated
public final class HttpClientParamConfig {
    public static RequestConfig getRequestConfig(HttpParams httpParams0) {
        return RequestConfig.custom().setSocketTimeout(httpParams0.getIntParameter("http.socket.timeout", 0)).setStaleConnectionCheckEnabled(httpParams0.getBooleanParameter("http.connection.stalecheck", true)).setConnectTimeout(httpParams0.getIntParameter("http.connection.timeout", 0)).setExpectContinueEnabled(httpParams0.getBooleanParameter("http.protocol.expect-continue", false)).setProxy(((HttpHost)httpParams0.getParameter("http.route.default-proxy"))).setLocalAddress(((InetAddress)httpParams0.getParameter("http.route.local-address"))).setAuthenticationEnabled(httpParams0.getBooleanParameter("http.protocol.handle-authentication", true)).setCircularRedirectsAllowed(httpParams0.getBooleanParameter("http.protocol.allow-circular-redirects", false)).setCookieSpec(((String)httpParams0.getParameter("http.protocol.cookie-policy"))).setMaxRedirects(httpParams0.getIntParameter("http.protocol.max-redirects", 50)).setRedirectsEnabled(httpParams0.getBooleanParameter("http.protocol.handle-redirects", true)).setRelativeRedirectsAllowed(!httpParams0.getBooleanParameter("http.protocol.reject-relative-redirect", false)).build();
    }
}

