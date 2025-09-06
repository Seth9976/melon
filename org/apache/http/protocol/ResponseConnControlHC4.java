package org.apache.http.protocol;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.HttpResponseInterceptor;
import org.apache.http.HttpVersion;
import org.apache.http.ProtocolVersion;
import org.apache.http.annotation.Immutable;
import org.apache.http.util.Args;

@Immutable
public class ResponseConnControlHC4 implements HttpResponseInterceptor {
    @Override  // org.apache.http.HttpResponseInterceptor
    public void process(HttpResponse httpResponse0, HttpContext httpContext0) {
        Args.notNull(httpResponse0, "HTTP response");
        HttpCoreContext httpCoreContext0 = HttpCoreContext.adapt(httpContext0);
        switch(httpResponse0.getStatusLine().getStatusCode()) {
            case 400: 
            case 408: 
            case 411: 
            case 413: 
            case 414: 
            case 501: 
            case 503: {
                httpResponse0.setHeader("Connection", "Close");
                return;
            }
            default: {
                Header header0 = httpResponse0.getFirstHeader("Connection");
                if(header0 == null || !"Close".equalsIgnoreCase(header0.getValue())) {
                    HttpEntity httpEntity0 = httpResponse0.getEntity();
                    if(httpEntity0 != null) {
                        ProtocolVersion protocolVersion0 = httpResponse0.getStatusLine().getProtocolVersion();
                        if(httpEntity0.getContentLength() < 0L && (!httpEntity0.isChunked() || protocolVersion0.lessEquals(HttpVersion.HTTP_1_0))) {
                            httpResponse0.setHeader("Connection", "Close");
                            return;
                        }
                    }
                    HttpRequest httpRequest0 = httpCoreContext0.getRequest();
                    if(httpRequest0 != null) {
                        Header header1 = httpRequest0.getFirstHeader("Connection");
                        if(header1 != null) {
                            httpResponse0.setHeader("Connection", header1.getValue());
                            return;
                        }
                        if(httpRequest0.getProtocolVersion().lessEquals(HttpVersion.HTTP_1_0)) {
                            httpResponse0.setHeader("Connection", "Close");
                        }
                    }
                }
            }
        }
    }
}

