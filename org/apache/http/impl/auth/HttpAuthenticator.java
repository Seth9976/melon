package org.apache.http.impl.auth;

import android.util.Log;
import java.util.Locale;
import java.util.Map;
import java.util.Queue;
import org.apache.http.Header;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.auth.AuthOption;
import org.apache.http.auth.AuthProtocolState;
import org.apache.http.auth.AuthScheme;
import org.apache.http.auth.AuthStateHC4;
import org.apache.http.auth.AuthenticationException;
import org.apache.http.auth.ContextAwareAuthScheme;
import org.apache.http.auth.Credentials;
import org.apache.http.auth.MalformedChallengeException;
import org.apache.http.client.AuthenticationStrategy;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.Asserts;

public class HttpAuthenticator {
    private static final String TAG = "HttpClient";

    // 去混淆评级： 低(20)
    private Header doAuth(AuthScheme authScheme0, Credentials credentials0, HttpRequest httpRequest0, HttpContext httpContext0) {
        return authScheme0 instanceof ContextAwareAuthScheme ? ((ContextAwareAuthScheme)authScheme0).authenticate(credentials0, httpRequest0, httpContext0) : authScheme0.authenticate(credentials0, httpRequest0);
    }

    private void ensureAuthScheme(AuthScheme authScheme0) {
        Asserts.notNull(authScheme0, "Auth scheme");
    }

    public void generateAuthResponse(HttpRequest httpRequest0, AuthStateHC4 authStateHC40, HttpContext httpContext0) {
        AuthScheme authScheme0 = authStateHC40.getAuthScheme();
        Credentials credentials0 = authStateHC40.getCredentials();
        int v = org.apache.http.impl.auth.HttpAuthenticator.1.$SwitchMap$org$apache$http$auth$AuthProtocolState[authStateHC40.getState().ordinal()];
        switch(v) {
            case 1: {
                Queue queue0 = authStateHC40.getAuthOptions();
                if(queue0 != null) {
                    while(!queue0.isEmpty()) {
                        AuthOption authOption0 = (AuthOption)queue0.remove();
                        AuthScheme authScheme1 = authOption0.getAuthScheme();
                        Credentials credentials1 = authOption0.getCredentials();
                        authStateHC40.update(authScheme1, credentials1);
                        if(Log.isLoggable("HttpClient", 3)) {
                            Log.d("HttpClient", "Generating response to an authentication challenge using " + authScheme1.getSchemeName() + " scheme");
                        }
                        try {
                            httpRequest0.addHeader(this.doAuth(authScheme1, credentials1, httpRequest0, httpContext0));
                            return;
                        }
                        catch(AuthenticationException authenticationException0) {
                            if(!Log.isLoggable("HttpClient", 5)) {
                                continue;
                            }
                            Log.w("HttpClient", authScheme1 + " authentication error: " + authenticationException0.getMessage());
                        }
                    }
                    return;
                }
                this.ensureAuthScheme(authScheme0);
                goto label_27;
            }
            case 3: {
                this.ensureAuthScheme(authScheme0);
                if(authScheme0.isConnectionBased()) {
                    return;
                }
            label_27:
                if(authScheme0 != null) {
                    try {
                        httpRequest0.addHeader(this.doAuth(authScheme0, credentials0, httpRequest0, httpContext0));
                        return;
                    }
                    catch(AuthenticationException authenticationException1) {
                        if(Log.isLoggable("HttpClient", 6)) {
                            Log.e("HttpClient", authScheme0 + " authentication error: " + authenticationException1.getMessage());
                        }
                    }
                }
                break;
            }
            default: {
                if(v != 4) {
                    goto label_27;
                }
            }
        }
    }

    public boolean handleAuthChallenge(HttpHost httpHost0, HttpResponse httpResponse0, AuthenticationStrategy authenticationStrategy0, AuthStateHC4 authStateHC40, HttpContext httpContext0) {
        try {
            if(Log.isLoggable("HttpClient", 3)) {
                Log.d("HttpClient", httpHost0.toHostString() + " requested authentication");
            }
            Map map0 = authenticationStrategy0.getChallenges(httpHost0, httpResponse0, httpContext0);
            if(map0.isEmpty()) {
                if(Log.isLoggable("HttpClient", 3)) {
                    Log.d("HttpClient", "Response contains no authentication challenges");
                }
                return false;
            }
            AuthScheme authScheme0 = authStateHC40.getAuthScheme();
            int v = org.apache.http.impl.auth.HttpAuthenticator.1.$SwitchMap$org$apache$http$auth$AuthProtocolState[authStateHC40.getState().ordinal()];
            if(v == 1) {
            label_13:
                if(authScheme0 == null) {
                    if(Log.isLoggable("HttpClient", 3)) {
                        Log.d("HttpClient", "Auth scheme is null");
                    }
                    authenticationStrategy0.authFailed(httpHost0, null, httpContext0);
                    authStateHC40.reset();
                    authStateHC40.setState(AuthProtocolState.FAILURE);
                    return false;
                }
            label_22:
                if(authScheme0 != null) {
                    Header header0 = (Header)map0.get(authScheme0.getSchemeName().toLowerCase(Locale.ENGLISH));
                    if(header0 != null) {
                        if(Log.isLoggable("HttpClient", 3)) {
                            Log.d("HttpClient", "Authorization challenge processed");
                        }
                        authScheme0.processChallenge(header0);
                        if(authScheme0.isComplete()) {
                            if(Log.isLoggable("HttpClient", 3)) {
                                Log.d("HttpClient", "Authentication failed");
                            }
                            authenticationStrategy0.authFailed(httpHost0, authStateHC40.getAuthScheme(), httpContext0);
                            authStateHC40.reset();
                            authStateHC40.setState(AuthProtocolState.FAILURE);
                            return false;
                        }
                        authStateHC40.setState(AuthProtocolState.HANDSHAKE);
                        return true;
                    }
                    authStateHC40.reset();
                }
            }
            else {
                switch(v) {
                    case 2: {
                        goto label_13;
                    }
                    case 3: {
                        authStateHC40.reset();
                        break;
                    }
                    case 4: {
                        return false;
                    }
                    case 5: {
                        goto label_22;
                    }
                }
            }
            Queue queue0 = authenticationStrategy0.select(map0, httpHost0, httpResponse0, httpContext0);
            if(queue0 != null && !queue0.isEmpty()) {
                if(Log.isLoggable("HttpClient", 3)) {
                    Log.d("HttpClient", "Selected authentication options: " + queue0);
                }
                authStateHC40.setState(AuthProtocolState.CHALLENGED);
                authStateHC40.update(queue0);
                return true;
            }
            return false;
        }
        catch(MalformedChallengeException malformedChallengeException0) {
        }
        if(Log.isLoggable("HttpClient", 5)) {
            Log.w("HttpClient", "Malformed challenge: " + malformedChallengeException0.getMessage());
        }
        authStateHC40.reset();
        return false;
    }

    public boolean isAuthenticationRequested(HttpHost httpHost0, HttpResponse httpResponse0, AuthenticationStrategy authenticationStrategy0, AuthStateHC4 authStateHC40, HttpContext httpContext0) {
        if(authenticationStrategy0.isAuthenticationRequested(httpHost0, httpResponse0, httpContext0)) {
            if(Log.isLoggable("HttpClient", 3)) {
                Log.d("HttpClient", "Authentication required");
            }
            if(authStateHC40.getState() == AuthProtocolState.SUCCESS) {
                authenticationStrategy0.authFailed(httpHost0, authStateHC40.getAuthScheme(), httpContext0);
            }
            return true;
        }
        switch(org.apache.http.impl.auth.HttpAuthenticator.1.$SwitchMap$org$apache$http$auth$AuthProtocolState[authStateHC40.getState().ordinal()]) {
            case 1: 
            case 2: {
                if(Log.isLoggable("HttpClient", 3)) {
                    Log.d("HttpClient", "Authentication succeeded");
                }
                authStateHC40.setState(AuthProtocolState.SUCCESS);
                authenticationStrategy0.authSucceeded(httpHost0, authStateHC40.getAuthScheme(), httpContext0);
                break;
            }
            case 3: {
                break;
            }
            default: {
                authStateHC40.setState(AuthProtocolState.UNCHALLENGED);
                return false;
            }
        }
        return false;
    }
}

