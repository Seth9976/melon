package org.apache.http.client.protocol;

import android.util.Log;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.annotation.Immutable;
import org.apache.http.auth.AuthProtocolState;
import org.apache.http.auth.AuthScheme;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.AuthStateHC4;
import org.apache.http.auth.Credentials;
import org.apache.http.client.AuthCache;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.conn.routing.RouteInfo;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.Args;

@Immutable
public class RequestAuthCache implements HttpRequestInterceptor {
    private static final String TAG = "HttpClient";

    private void doPreemptiveAuth(HttpHost httpHost0, AuthScheme authScheme0, AuthStateHC4 authStateHC40, CredentialsProvider credentialsProvider0) {
        String s = authScheme0.getSchemeName();
        if(Log.isLoggable("HttpClient", 3)) {
            Log.d("HttpClient", "Re-using cached \'" + s + "\' auth scheme for " + httpHost0);
        }
        Credentials credentials0 = credentialsProvider0.getCredentials(new AuthScope(httpHost0.getHostName(), httpHost0.getPort(), AuthScope.ANY_REALM, s));
        if(credentials0 != null) {
            if("BASIC".equalsIgnoreCase(authScheme0.getSchemeName())) {
                authStateHC40.setState(AuthProtocolState.CHALLENGED);
            }
            else {
                authStateHC40.setState(AuthProtocolState.SUCCESS);
            }
            authStateHC40.update(authScheme0, credentials0);
            return;
        }
        if(Log.isLoggable("HttpClient", 3)) {
            Log.d("HttpClient", "No credentials for preemptive authentication");
        }
    }

    @Override  // org.apache.http.HttpRequestInterceptor
    public void process(HttpRequest httpRequest0, HttpContext httpContext0) {
        Args.notNull(httpRequest0, "HTTP request");
        Args.notNull(httpContext0, "HTTP context");
        HttpClientContext httpClientContext0 = HttpClientContext.adapt(httpContext0);
        AuthCache authCache0 = httpClientContext0.getAuthCache();
        if(authCache0 != null) {
            CredentialsProvider credentialsProvider0 = httpClientContext0.getCredentialsProvider();
            if(credentialsProvider0 != null) {
                RouteInfo routeInfo0 = httpClientContext0.getHttpRoute();
                if(routeInfo0 != null) {
                    HttpHost httpHost0 = httpClientContext0.getTargetHost();
                    if(httpHost0 != null) {
                        if(httpHost0.getPort() < 0) {
                            httpHost0 = new HttpHost(httpHost0.getHostName(), routeInfo0.getTargetHost().getPort(), httpHost0.getSchemeName());
                        }
                        AuthStateHC4 authStateHC40 = httpClientContext0.getTargetAuthState();
                        if(authStateHC40 != null && authStateHC40.getState() == AuthProtocolState.UNCHALLENGED) {
                            AuthScheme authScheme0 = authCache0.get(httpHost0);
                            if(authScheme0 != null) {
                                this.doPreemptiveAuth(httpHost0, authScheme0, authStateHC40, credentialsProvider0);
                            }
                        }
                        HttpHost httpHost1 = routeInfo0.getProxyHost();
                        AuthStateHC4 authStateHC41 = httpClientContext0.getProxyAuthState();
                        if(httpHost1 != null && authStateHC41 != null && authStateHC41.getState() == AuthProtocolState.UNCHALLENGED) {
                            AuthScheme authScheme1 = authCache0.get(httpHost1);
                            if(authScheme1 != null) {
                                this.doPreemptiveAuth(httpHost1, authScheme1, authStateHC41, credentialsProvider0);
                            }
                        }
                    }
                    else if(Log.isLoggable("HttpClient", 3)) {
                        Log.d("HttpClient", "Target host not set in the context");
                    }
                }
                else if(Log.isLoggable("HttpClient", 3)) {
                    Log.d("HttpClient", "Route info not set in the context");
                }
            }
            else if(Log.isLoggable("HttpClient", 3)) {
                Log.d("HttpClient", "Credentials provider not set in the context");
            }
        }
        else if(Log.isLoggable("HttpClient", 3)) {
            Log.d("HttpClient", "Auth cache not set in the context");
        }
    }
}

