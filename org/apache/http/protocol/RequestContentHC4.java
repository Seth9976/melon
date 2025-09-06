package org.apache.http.protocol;

import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.HttpVersion;
import org.apache.http.ProtocolException;
import org.apache.http.ProtocolVersion;
import org.apache.http.annotation.Immutable;
import org.apache.http.util.Args;

@Immutable
public class RequestContentHC4 implements HttpRequestInterceptor {
    private final boolean overwrite;

    public RequestContentHC4() {
        this(false);
    }

    public RequestContentHC4(boolean z) {
        this.overwrite = z;
    }

    @Override  // org.apache.http.HttpRequestInterceptor
    public void process(HttpRequest httpRequest0, HttpContext httpContext0) {
        Args.notNull(httpRequest0, "HTTP request");
        if(httpRequest0 instanceof HttpEntityEnclosingRequest) {
            if(this.overwrite) {
                httpRequest0.removeHeaders("Transfer-Encoding");
                httpRequest0.removeHeaders("Content-Length");
            }
            else {
                if(httpRequest0.containsHeader("Transfer-Encoding")) {
                    throw new ProtocolException("Transfer-encoding header already present");
                }
                if(httpRequest0.containsHeader("Content-Length")) {
                    throw new ProtocolException("Content-Length header already present");
                }
            }
            ProtocolVersion protocolVersion0 = httpRequest0.getRequestLine().getProtocolVersion();
            HttpEntity httpEntity0 = ((HttpEntityEnclosingRequest)httpRequest0).getEntity();
            if(httpEntity0 == null) {
                httpRequest0.addHeader("Content-Length", "0");
                return;
            }
            if(httpEntity0.isChunked() || httpEntity0.getContentLength() < 0L) {
                if(protocolVersion0.lessEquals(HttpVersion.HTTP_1_0)) {
                    throw new ProtocolException("Chunked transfer encoding not allowed for " + protocolVersion0);
                }
                httpRequest0.addHeader("Transfer-Encoding", "chunked");
            }
            else {
                httpRequest0.addHeader("Content-Length", Long.toString(httpEntity0.getContentLength()));
            }
            if(httpEntity0.getContentType() != null && !httpRequest0.containsHeader("Content-Type")) {
                httpRequest0.addHeader(httpEntity0.getContentType());
            }
            if(httpEntity0.getContentEncoding() != null && !httpRequest0.containsHeader("Content-Encoding")) {
                httpRequest0.addHeader(httpEntity0.getContentEncoding());
            }
        }
    }
}

