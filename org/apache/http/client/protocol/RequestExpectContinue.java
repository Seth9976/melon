package org.apache.http.client.protocol;

import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.HttpVersion;
import org.apache.http.ProtocolVersion;
import org.apache.http.annotation.Immutable;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.Args;

@Immutable
public class RequestExpectContinue implements HttpRequestInterceptor {
    @Override  // org.apache.http.HttpRequestInterceptor
    public void process(HttpRequest httpRequest0, HttpContext httpContext0) {
        Args.notNull(httpRequest0, "HTTP request");
        if(!httpRequest0.containsHeader("Expect") && httpRequest0 instanceof HttpEntityEnclosingRequest) {
            ProtocolVersion protocolVersion0 = httpRequest0.getRequestLine().getProtocolVersion();
            HttpEntity httpEntity0 = ((HttpEntityEnclosingRequest)httpRequest0).getEntity();
            if(httpEntity0 != null && httpEntity0.getContentLength() != 0L && !protocolVersion0.lessEquals(HttpVersion.HTTP_1_0) && HttpClientContext.adapt(httpContext0).getRequestConfig().isExpectContinueEnabled()) {
                httpRequest0.addHeader("Expect", "100-continue");
            }
        }
    }
}

