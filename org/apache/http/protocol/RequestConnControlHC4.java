package org.apache.http.protocol;

import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.annotation.Immutable;
import org.apache.http.util.Args;

@Immutable
public class RequestConnControlHC4 implements HttpRequestInterceptor {
    @Override  // org.apache.http.HttpRequestInterceptor
    public void process(HttpRequest httpRequest0, HttpContext httpContext0) {
        Args.notNull(httpRequest0, "HTTP request");
        if(!httpRequest0.getRequestLine().getMethod().equalsIgnoreCase("CONNECT") && !httpRequest0.containsHeader("Connection")) {
            httpRequest0.addHeader("Connection", "Keep-Alive");
        }
    }
}

