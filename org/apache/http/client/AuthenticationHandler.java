package org.apache.http.client;

import java.util.Map;
import org.apache.http.HttpResponse;
import org.apache.http.auth.AuthScheme;
import org.apache.http.protocol.HttpContext;

@Deprecated
public interface AuthenticationHandler {
    Map getChallenges(HttpResponse arg1, HttpContext arg2);

    boolean isAuthenticationRequested(HttpResponse arg1, HttpContext arg2);

    AuthScheme selectScheme(Map arg1, HttpResponse arg2, HttpContext arg3);
}

