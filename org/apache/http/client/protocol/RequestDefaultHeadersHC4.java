package org.apache.http.client.protocol;

import java.util.Collection;
import org.apache.http.Header;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.annotation.Immutable;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.Args;

@Immutable
public class RequestDefaultHeadersHC4 implements HttpRequestInterceptor {
    private final Collection defaultHeaders;

    public RequestDefaultHeadersHC4() {
        this(null);
    }

    public RequestDefaultHeadersHC4(Collection collection0) {
        this.defaultHeaders = collection0;
    }

    @Override  // org.apache.http.HttpRequestInterceptor
    public void process(HttpRequest httpRequest0, HttpContext httpContext0) {
        Args.notNull(httpRequest0, "HTTP request");
        if(!httpRequest0.getRequestLine().getMethod().equalsIgnoreCase("CONNECT")) {
            Collection collection0 = (Collection)httpRequest0.getParams().getParameter("http.default-headers");
            if(collection0 == null) {
                collection0 = this.defaultHeaders;
            }
            if(collection0 != null) {
                for(Object object0: collection0) {
                    httpRequest0.addHeader(((Header)object0));
                }
            }
        }
    }
}

