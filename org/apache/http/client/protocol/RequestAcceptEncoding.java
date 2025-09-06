package org.apache.http.client.protocol;

import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.annotation.Immutable;
import org.apache.http.protocol.HttpContext;

@Immutable
public class RequestAcceptEncoding implements HttpRequestInterceptor {
    @Override  // org.apache.http.HttpRequestInterceptor
    public void process(HttpRequest httpRequest0, HttpContext httpContext0) {
        if(!httpRequest0.containsHeader("Accept-Encoding")) {
            httpRequest0.addHeader("Accept-Encoding", "gzip,deflate");
        }
    }
}

