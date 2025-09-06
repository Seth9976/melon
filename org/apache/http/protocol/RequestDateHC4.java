package org.apache.http.protocol;

import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.annotation.ThreadSafe;
import org.apache.http.util.Args;

@ThreadSafe
public class RequestDateHC4 implements HttpRequestInterceptor {
    private static final HttpDateGenerator DATE_GENERATOR;

    static {
        RequestDateHC4.DATE_GENERATOR = new HttpDateGenerator();
    }

    @Override  // org.apache.http.HttpRequestInterceptor
    public void process(HttpRequest httpRequest0, HttpContext httpContext0) {
        Args.notNull(httpRequest0, "HTTP request");
        if(httpRequest0 instanceof HttpEntityEnclosingRequest && !httpRequest0.containsHeader("Date")) {
            httpRequest0.setHeader("Date", RequestDateHC4.DATE_GENERATOR.getCurrentDate());
        }
    }
}

