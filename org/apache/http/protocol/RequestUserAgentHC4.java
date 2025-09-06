package org.apache.http.protocol;

import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.annotation.Immutable;
import org.apache.http.params.HttpParams;
import org.apache.http.util.Args;

@Immutable
public class RequestUserAgentHC4 implements HttpRequestInterceptor {
    private final String userAgent;

    public RequestUserAgentHC4() {
        this(null);
    }

    public RequestUserAgentHC4(String s) {
        this.userAgent = s;
    }

    @Override  // org.apache.http.HttpRequestInterceptor
    public void process(HttpRequest httpRequest0, HttpContext httpContext0) {
        Args.notNull(httpRequest0, "HTTP request");
        if(!httpRequest0.containsHeader("User-Agent")) {
            HttpParams httpParams0 = httpRequest0.getParams();
            String s = httpParams0 == null ? null : ((String)httpParams0.getParameter("http.useragent"));
            if(s == null) {
                s = this.userAgent;
            }
            if(s != null) {
                httpRequest0.addHeader("User-Agent", s);
            }
        }
    }
}

