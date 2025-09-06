package org.apache.http.client.config;

import U4.x;
import java.net.InetAddress;
import java.util.Collection;
import org.apache.http.HttpHost;

public class RequestConfig implements Cloneable {
    public static class Builder {
        private boolean authenticationEnabled;
        private boolean circularRedirectsAllowed;
        private int connectTimeout;
        private int connectionRequestTimeout;
        private String cookieSpec;
        private boolean expectContinueEnabled;
        private InetAddress localAddress;
        private int maxRedirects;
        private HttpHost proxy;
        private Collection proxyPreferredAuthSchemes;
        private boolean redirectsEnabled;
        private boolean relativeRedirectsAllowed;
        private int socketTimeout;
        private boolean staleConnectionCheckEnabled;
        private Collection targetPreferredAuthSchemes;

        public Builder() {
            this.staleConnectionCheckEnabled = true;
            this.redirectsEnabled = true;
            this.maxRedirects = 50;
            this.relativeRedirectsAllowed = true;
            this.authenticationEnabled = true;
            this.connectionRequestTimeout = -1;
            this.connectTimeout = -1;
            this.socketTimeout = -1;
        }

        public RequestConfig build() {
            return new RequestConfig(this.expectContinueEnabled, this.proxy, this.localAddress, this.staleConnectionCheckEnabled, this.cookieSpec, this.redirectsEnabled, this.relativeRedirectsAllowed, this.circularRedirectsAllowed, this.maxRedirects, this.authenticationEnabled, this.targetPreferredAuthSchemes, this.proxyPreferredAuthSchemes, this.connectionRequestTimeout, this.connectTimeout, this.socketTimeout);
        }

        public Builder setAuthenticationEnabled(boolean z) {
            this.authenticationEnabled = z;
            return this;
        }

        public Builder setCircularRedirectsAllowed(boolean z) {
            this.circularRedirectsAllowed = z;
            return this;
        }

        public Builder setConnectTimeout(int v) {
            this.connectTimeout = v;
            return this;
        }

        public Builder setConnectionRequestTimeout(int v) {
            this.connectionRequestTimeout = v;
            return this;
        }

        public Builder setCookieSpec(String s) {
            this.cookieSpec = s;
            return this;
        }

        public Builder setExpectContinueEnabled(boolean z) {
            this.expectContinueEnabled = z;
            return this;
        }

        public Builder setLocalAddress(InetAddress inetAddress0) {
            this.localAddress = inetAddress0;
            return this;
        }

        public Builder setMaxRedirects(int v) {
            this.maxRedirects = v;
            return this;
        }

        public Builder setProxy(HttpHost httpHost0) {
            this.proxy = httpHost0;
            return this;
        }

        public Builder setProxyPreferredAuthSchemes(Collection collection0) {
            this.proxyPreferredAuthSchemes = collection0;
            return this;
        }

        public Builder setRedirectsEnabled(boolean z) {
            this.redirectsEnabled = z;
            return this;
        }

        public Builder setRelativeRedirectsAllowed(boolean z) {
            this.relativeRedirectsAllowed = z;
            return this;
        }

        public Builder setSocketTimeout(int v) {
            this.socketTimeout = v;
            return this;
        }

        public Builder setStaleConnectionCheckEnabled(boolean z) {
            this.staleConnectionCheckEnabled = z;
            return this;
        }

        public Builder setTargetPreferredAuthSchemes(Collection collection0) {
            this.targetPreferredAuthSchemes = collection0;
            return this;
        }
    }

    public static final RequestConfig DEFAULT;
    private final boolean authenticationEnabled;
    private final boolean circularRedirectsAllowed;
    private final int connectTimeout;
    private final int connectionRequestTimeout;
    private final String cookieSpec;
    private final boolean expectContinueEnabled;
    private final InetAddress localAddress;
    private final int maxRedirects;
    private final HttpHost proxy;
    private final Collection proxyPreferredAuthSchemes;
    private final boolean redirectsEnabled;
    private final boolean relativeRedirectsAllowed;
    private final int socketTimeout;
    private final boolean staleConnectionCheckEnabled;
    private final Collection targetPreferredAuthSchemes;

    static {
        RequestConfig.DEFAULT = new Builder().build();
    }

    public RequestConfig(boolean z, HttpHost httpHost0, InetAddress inetAddress0, boolean z1, String s, boolean z2, boolean z3, boolean z4, int v, boolean z5, Collection collection0, Collection collection1, int v1, int v2, int v3) {
        this.expectContinueEnabled = z;
        this.proxy = httpHost0;
        this.localAddress = inetAddress0;
        this.staleConnectionCheckEnabled = z1;
        this.cookieSpec = s;
        this.redirectsEnabled = z2;
        this.relativeRedirectsAllowed = z3;
        this.circularRedirectsAllowed = z4;
        this.maxRedirects = v;
        this.authenticationEnabled = z5;
        this.targetPreferredAuthSchemes = collection0;
        this.proxyPreferredAuthSchemes = collection1;
        this.connectionRequestTimeout = v1;
        this.connectTimeout = v2;
        this.socketTimeout = v3;
    }

    @Override
    public Object clone() {
        return this.clone();
    }

    public RequestConfig clone() {
        return (RequestConfig)super.clone();
    }

    public static Builder copy(RequestConfig requestConfig0) {
        return new Builder().setExpectContinueEnabled(requestConfig0.isExpectContinueEnabled()).setProxy(requestConfig0.getProxy()).setLocalAddress(requestConfig0.getLocalAddress()).setStaleConnectionCheckEnabled(requestConfig0.isStaleConnectionCheckEnabled()).setCookieSpec(requestConfig0.getCookieSpec()).setRedirectsEnabled(requestConfig0.isRedirectsEnabled()).setRelativeRedirectsAllowed(requestConfig0.isRelativeRedirectsAllowed()).setCircularRedirectsAllowed(requestConfig0.isCircularRedirectsAllowed()).setMaxRedirects(requestConfig0.getMaxRedirects()).setAuthenticationEnabled(requestConfig0.isAuthenticationEnabled()).setTargetPreferredAuthSchemes(requestConfig0.getTargetPreferredAuthSchemes()).setProxyPreferredAuthSchemes(requestConfig0.getProxyPreferredAuthSchemes()).setConnectionRequestTimeout(requestConfig0.getConnectionRequestTimeout()).setConnectTimeout(requestConfig0.getConnectTimeout()).setSocketTimeout(requestConfig0.getSocketTimeout());
    }

    public static Builder custom() {
        return new Builder();
    }

    public int getConnectTimeout() {
        return this.connectTimeout;
    }

    public int getConnectionRequestTimeout() {
        return this.connectionRequestTimeout;
    }

    public String getCookieSpec() {
        return this.cookieSpec;
    }

    public InetAddress getLocalAddress() {
        return this.localAddress;
    }

    public int getMaxRedirects() {
        return this.maxRedirects;
    }

    public HttpHost getProxy() {
        return this.proxy;
    }

    public Collection getProxyPreferredAuthSchemes() {
        return this.proxyPreferredAuthSchemes;
    }

    public int getSocketTimeout() {
        return this.socketTimeout;
    }

    public Collection getTargetPreferredAuthSchemes() {
        return this.targetPreferredAuthSchemes;
    }

    public boolean isAuthenticationEnabled() {
        return this.authenticationEnabled;
    }

    public boolean isCircularRedirectsAllowed() {
        return this.circularRedirectsAllowed;
    }

    public boolean isExpectContinueEnabled() {
        return this.expectContinueEnabled;
    }

    public boolean isRedirectsEnabled() {
        return this.redirectsEnabled;
    }

    public boolean isRelativeRedirectsAllowed() {
        return this.relativeRedirectsAllowed;
    }

    public boolean isStaleConnectionCheckEnabled() {
        return this.staleConnectionCheckEnabled;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder0 = new StringBuilder(", expectContinueEnabled=");
        stringBuilder0.append(this.expectContinueEnabled);
        stringBuilder0.append(", proxy=");
        stringBuilder0.append(this.proxy);
        stringBuilder0.append(", localAddress=");
        stringBuilder0.append(this.localAddress);
        stringBuilder0.append(", staleConnectionCheckEnabled=");
        stringBuilder0.append(this.staleConnectionCheckEnabled);
        stringBuilder0.append(", cookieSpec=");
        stringBuilder0.append(this.cookieSpec);
        stringBuilder0.append(", redirectsEnabled=");
        stringBuilder0.append(this.redirectsEnabled);
        stringBuilder0.append(", relativeRedirectsAllowed=");
        stringBuilder0.append(this.relativeRedirectsAllowed);
        stringBuilder0.append(", maxRedirects=");
        stringBuilder0.append(this.maxRedirects);
        stringBuilder0.append(", circularRedirectsAllowed=");
        stringBuilder0.append(this.circularRedirectsAllowed);
        stringBuilder0.append(", authenticationEnabled=");
        stringBuilder0.append(this.authenticationEnabled);
        stringBuilder0.append(", targetPreferredAuthSchemes=");
        stringBuilder0.append(this.targetPreferredAuthSchemes);
        stringBuilder0.append(", proxyPreferredAuthSchemes=");
        stringBuilder0.append(this.proxyPreferredAuthSchemes);
        stringBuilder0.append(", connectionRequestTimeout=");
        stringBuilder0.append(this.connectionRequestTimeout);
        stringBuilder0.append(", connectTimeout=");
        stringBuilder0.append(this.connectTimeout);
        stringBuilder0.append(", socketTimeout=");
        return x.g(this.socketTimeout, "]", stringBuilder0);
    }
}

