package org.apache.http.client;

import java.util.Map;
import java.util.Queue;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.auth.AuthScheme;
import org.apache.http.protocol.HttpContext;

public interface AuthenticationStrategy {
    void authFailed(HttpHost arg1, AuthScheme arg2, HttpContext arg3);

    void authSucceeded(HttpHost arg1, AuthScheme arg2, HttpContext arg3);

    Map getChallenges(HttpHost arg1, HttpResponse arg2, HttpContext arg3);

    boolean isAuthenticationRequested(HttpHost arg1, HttpResponse arg2, HttpContext arg3);

    Queue select(Map arg1, HttpHost arg2, HttpResponse arg3, HttpContext arg4);
}

