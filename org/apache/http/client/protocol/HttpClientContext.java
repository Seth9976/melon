package org.apache.http.client.protocol;

import java.util.List;
import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.auth.AuthSchemeProvider;
import org.apache.http.auth.AuthStateHC4;
import org.apache.http.client.AuthCache;
import org.apache.http.client.CookieStore;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.config.Lookup;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.conn.routing.RouteInfo;
import org.apache.http.cookie.CookieOrigin;
import org.apache.http.cookie.CookieSpec;
import org.apache.http.cookie.CookieSpecProvider;
import org.apache.http.protocol.BasicHttpContextHC4;
import org.apache.http.protocol.HttpContext;
import org.apache.http.protocol.HttpCoreContext;

@NotThreadSafe
public class HttpClientContext extends HttpCoreContext {
    public static final String AUTHSCHEME_REGISTRY = "http.authscheme-registry";
    public static final String AUTH_CACHE = "http.auth.auth-cache";
    public static final String COOKIESPEC_REGISTRY = "http.cookiespec-registry";
    public static final String COOKIE_ORIGIN = "http.cookie-origin";
    public static final String COOKIE_SPEC = "http.cookie-spec";
    public static final String COOKIE_STORE = "http.cookie-store";
    public static final String CREDS_PROVIDER = "http.auth.credentials-provider";
    public static final String HTTP_ROUTE = "http.route";
    public static final String PROXY_AUTH_STATE = "http.auth.proxy-scope";
    public static final String REDIRECT_LOCATIONS = "http.protocol.redirect-locations";
    public static final String REQUEST_CONFIG = "http.request-config";
    public static final String TARGET_AUTH_STATE = "http.auth.target-scope";
    public static final String USER_TOKEN = "http.user-token";

    public HttpClientContext() {
    }

    public HttpClientContext(HttpContext httpContext0) {
        super(httpContext0);
    }

    // 去混淆评级： 低(20)
    public static HttpClientContext adapt(HttpContext httpContext0) {
        return httpContext0 instanceof HttpClientContext ? ((HttpClientContext)httpContext0) : new HttpClientContext(httpContext0);
    }

    public static HttpClientContext create() {
        return new HttpClientContext(new BasicHttpContextHC4());
    }

    public AuthCache getAuthCache() {
        return (AuthCache)this.getAttribute("http.auth.auth-cache", AuthCache.class);
    }

    public Lookup getAuthSchemeRegistry() {
        return this.getLookup("http.authscheme-registry", AuthSchemeProvider.class);
    }

    public CookieOrigin getCookieOrigin() {
        return (CookieOrigin)this.getAttribute("http.cookie-origin", CookieOrigin.class);
    }

    public CookieSpec getCookieSpec() {
        return (CookieSpec)this.getAttribute("http.cookie-spec", CookieSpec.class);
    }

    public Lookup getCookieSpecRegistry() {
        return this.getLookup("http.cookiespec-registry", CookieSpecProvider.class);
    }

    public CookieStore getCookieStore() {
        return (CookieStore)this.getAttribute("http.cookie-store", CookieStore.class);
    }

    public CredentialsProvider getCredentialsProvider() {
        return (CredentialsProvider)this.getAttribute("http.auth.credentials-provider", CredentialsProvider.class);
    }

    public RouteInfo getHttpRoute() {
        return (RouteInfo)this.getAttribute("http.route", HttpRoute.class);
    }

    private Lookup getLookup(String s, Class class0) {
        return (Lookup)this.getAttribute(s, Lookup.class);
    }

    public AuthStateHC4 getProxyAuthState() {
        return (AuthStateHC4)this.getAttribute("http.auth.proxy-scope", AuthStateHC4.class);
    }

    public List getRedirectLocations() {
        return (List)this.getAttribute("http.protocol.redirect-locations", List.class);
    }

    public RequestConfig getRequestConfig() {
        RequestConfig requestConfig0 = (RequestConfig)this.getAttribute("http.request-config", RequestConfig.class);
        return requestConfig0 == null ? RequestConfig.DEFAULT : requestConfig0;
    }

    public AuthStateHC4 getTargetAuthState() {
        return (AuthStateHC4)this.getAttribute("http.auth.target-scope", AuthStateHC4.class);
    }

    public Object getUserToken() {
        return this.getAttribute("http.user-token");
    }

    public Object getUserToken(Class class0) {
        return this.getAttribute("http.user-token", class0);
    }

    public void setAuthCache(AuthCache authCache0) {
        this.setAttribute("http.auth.auth-cache", authCache0);
    }

    public void setAuthSchemeRegistry(Lookup lookup0) {
        this.setAttribute("http.authscheme-registry", lookup0);
    }

    public void setCookieSpecRegistry(Lookup lookup0) {
        this.setAttribute("http.cookiespec-registry", lookup0);
    }

    public void setCookieStore(CookieStore cookieStore0) {
        this.setAttribute("http.cookie-store", cookieStore0);
    }

    public void setCredentialsProvider(CredentialsProvider credentialsProvider0) {
        this.setAttribute("http.auth.credentials-provider", credentialsProvider0);
    }

    public void setRequestConfig(RequestConfig requestConfig0) {
        this.setAttribute("http.request-config", requestConfig0);
    }

    public void setUserToken(Object object0) {
        this.setAttribute("http.user-token", object0);
    }
}

