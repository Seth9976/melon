package org.apache.http.protocol;

import org.apache.http.HttpResponse;
import org.apache.http.HttpResponseInterceptor;

@Deprecated
public class ResponseDate implements HttpResponseInterceptor {
    public ResponseDate() {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.HttpResponseInterceptor
    public void process(HttpResponse httpResponse0, HttpContext httpContext0) {
        throw new RuntimeException("Stub!");
    }
}

