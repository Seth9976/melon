package org.apache.http.impl.client;

import android.util.Log;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Queue;
import org.apache.http.FormattedHeader;
import org.apache.http.Header;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.annotation.Immutable;
import org.apache.http.auth.AuthOption;
import org.apache.http.auth.AuthScheme;
import org.apache.http.auth.AuthSchemeProvider;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.Credentials;
import org.apache.http.auth.MalformedChallengeException;
import org.apache.http.client.AuthCache;
import org.apache.http.client.AuthenticationStrategy;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.config.Lookup;
import org.apache.http.protocol.HTTP;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.Args;
import org.apache.http.util.CharArrayBuffer;

@Immutable
abstract class AuthenticationStrategyImpl implements AuthenticationStrategy {
    private static final List DEFAULT_SCHEME_PRIORITY = null;
    private static final String TAG = "HttpClient";
    private final int challengeCode;
    private final String headerName;

    static {
        AuthenticationStrategyImpl.DEFAULT_SCHEME_PRIORITY = Collections.unmodifiableList(Arrays.asList(new String[]{"negotiate", "Kerberos", "NTLM", "Digest", "Basic"}));
    }

    public AuthenticationStrategyImpl(int v, String s) {
        this.challengeCode = v;
        this.headerName = s;
    }

    @Override  // org.apache.http.client.AuthenticationStrategy
    public void authFailed(HttpHost httpHost0, AuthScheme authScheme0, HttpContext httpContext0) {
        Args.notNull(httpHost0, "Host");
        Args.notNull(httpContext0, "HTTP context");
        AuthCache authCache0 = HttpClientContext.adapt(httpContext0).getAuthCache();
        if(authCache0 != null) {
            if(Log.isLoggable("HttpClient", 3)) {
                Log.d("HttpClient", "Clearing cached auth scheme for " + httpHost0);
            }
            authCache0.remove(httpHost0);
        }
    }

    @Override  // org.apache.http.client.AuthenticationStrategy
    public void authSucceeded(HttpHost httpHost0, AuthScheme authScheme0, HttpContext httpContext0) {
        Args.notNull(httpHost0, "Host");
        Args.notNull(authScheme0, "Auth scheme");
        Args.notNull(httpContext0, "HTTP context");
        HttpClientContext httpClientContext0 = HttpClientContext.adapt(httpContext0);
        if(this.isCachable(authScheme0)) {
            AuthCache authCache0 = httpClientContext0.getAuthCache();
            if(authCache0 == null) {
                authCache0 = new BasicAuthCache();
                httpClientContext0.setAuthCache(authCache0);
            }
            if(Log.isLoggable("HttpClient", 3)) {
                Log.d("HttpClient", "Caching \'" + authScheme0.getSchemeName() + "\' auth scheme for " + httpHost0);
            }
            authCache0.put(httpHost0, authScheme0);
        }
    }

    @Override  // org.apache.http.client.AuthenticationStrategy
    public Map getChallenges(HttpHost httpHost0, HttpResponse httpResponse0, HttpContext httpContext0) {
        int v1;
        CharArrayBuffer charArrayBuffer0;
        Args.notNull(httpResponse0, "HTTP response");
        Header[] arr_header = httpResponse0.getHeaders(this.headerName);
        Map map0 = new HashMap(arr_header.length);
        for(int v = 0; v < arr_header.length; ++v) {
            Header header0 = arr_header[v];
            if(header0 instanceof FormattedHeader) {
                charArrayBuffer0 = ((FormattedHeader)header0).getBuffer();
                v1 = ((FormattedHeader)header0).getValuePos();
            }
            else {
                String s = header0.getValue();
                if(s == null) {
                    throw new MalformedChallengeException("Header value is null");
                }
                charArrayBuffer0 = new CharArrayBuffer(s.length());
                charArrayBuffer0.append(s);
                v1 = 0;
            }
            while(v1 < charArrayBuffer0.length() && HTTP.isWhitespace(charArrayBuffer0.charAt(v1))) {
                ++v1;
            }
            int v2;
            for(v2 = v1; v2 < charArrayBuffer0.length() && !HTTP.isWhitespace(charArrayBuffer0.charAt(v2)); ++v2) {
            }
            ((HashMap)map0).put(charArrayBuffer0.substring(v1, v2).toLowerCase(Locale.ENGLISH), header0);
        }
        return map0;
    }

    public abstract Collection getPreferredAuthSchemes(RequestConfig arg1);

    @Override  // org.apache.http.client.AuthenticationStrategy
    public boolean isAuthenticationRequested(HttpHost httpHost0, HttpResponse httpResponse0, HttpContext httpContext0) {
        Args.notNull(httpResponse0, "HTTP response");
        return httpResponse0.getStatusLine().getStatusCode() == this.challengeCode;
    }

    public boolean isCachable(AuthScheme authScheme0) {
        if(authScheme0 != null && authScheme0.isComplete()) {
            String s = authScheme0.getSchemeName();
            return s.equalsIgnoreCase("Basic") || s.equalsIgnoreCase("Digest");
        }
        return false;
    }

    @Override  // org.apache.http.client.AuthenticationStrategy
    public Queue select(Map map0, HttpHost httpHost0, HttpResponse httpResponse0, HttpContext httpContext0) {
        Args.notNull(map0, "Map of auth challenges");
        Args.notNull(httpHost0, "Host");
        Args.notNull(httpResponse0, "HTTP response");
        Args.notNull(httpContext0, "HTTP context");
        HttpClientContext httpClientContext0 = HttpClientContext.adapt(httpContext0);
        Queue queue0 = new LinkedList();
        Lookup lookup0 = httpClientContext0.getAuthSchemeRegistry();
        if(lookup0 != null) {
            CredentialsProvider credentialsProvider0 = httpClientContext0.getCredentialsProvider();
            if(credentialsProvider0 != null) {
                Collection collection0 = this.getPreferredAuthSchemes(httpClientContext0.getRequestConfig());
                if(collection0 == null) {
                    collection0 = AuthenticationStrategyImpl.DEFAULT_SCHEME_PRIORITY;
                }
                if(Log.isLoggable("HttpClient", 3)) {
                    Log.d("HttpClient", "Authentication schemes in the order of preference: " + collection0);
                }
                for(Object object0: collection0) {
                    String s = (String)object0;
                    Header header0 = (Header)map0.get(s.toLowerCase(Locale.ENGLISH));
                    if(header0 != null) {
                        AuthSchemeProvider authSchemeProvider0 = (AuthSchemeProvider)lookup0.lookup(s);
                        if(authSchemeProvider0 == null) {
                            if(!Log.isLoggable("HttpClient", 5)) {
                                continue;
                            }
                            Log.w("HttpClient", "Authentication scheme " + s + " not supported");
                        }
                        else {
                            AuthScheme authScheme0 = authSchemeProvider0.create(httpContext0);
                            authScheme0.processChallenge(header0);
                            Credentials credentials0 = credentialsProvider0.getCredentials(new AuthScope(httpHost0.getHostName(), httpHost0.getPort(), authScheme0.getRealm(), authScheme0.getSchemeName()));
                            if(credentials0 == null) {
                                continue;
                            }
                            ((LinkedList)queue0).add(new AuthOption(authScheme0, credentials0));
                        }
                    }
                    else if(Log.isLoggable("HttpClient", 3)) {
                        Log.d("HttpClient", "Challenge for " + s + " authentication scheme not available");
                    }
                }
            }
            else if(Log.isLoggable("HttpClient", 3)) {
                Log.d("HttpClient", "Credentials provider not set in the context");
                return queue0;
            }
        }
        else if(Log.isLoggable("HttpClient", 3)) {
            Log.d("HttpClient", "Auth scheme registry not set in the context");
            return queue0;
        }
        return queue0;
    }
}

