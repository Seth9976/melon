package org.apache.http.client.methods;

import java.net.URI;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpRequest;
import org.apache.http.ProtocolVersion;
import org.apache.http.RequestLine;
import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.message.AbstractHttpMessage;
import org.apache.http.message.BasicRequestLine;
import org.apache.http.params.HttpParams;

@NotThreadSafe
public class HttpRequestWrapper extends AbstractHttpMessage implements HttpUriRequest {
    static class HttpEntityEnclosingRequestWrapper extends HttpRequestWrapper implements HttpEntityEnclosingRequest {
        private HttpEntity entity;

        public HttpEntityEnclosingRequestWrapper(HttpEntityEnclosingRequest httpEntityEnclosingRequest0) {
            super(httpEntityEnclosingRequest0, null);
            this.entity = httpEntityEnclosingRequest0.getEntity();
        }

        @Override  // org.apache.http.HttpEntityEnclosingRequest
        public boolean expectContinue() {
            Header header0 = this.getFirstHeader("Expect");
            return header0 != null && "100-continue".equalsIgnoreCase(header0.getValue());
        }

        @Override  // org.apache.http.HttpEntityEnclosingRequest
        public HttpEntity getEntity() {
            return this.entity;
        }

        @Override  // org.apache.http.HttpEntityEnclosingRequest
        public void setEntity(HttpEntity httpEntity0) {
            this.entity = httpEntity0;
        }
    }

    private final String method;
    private final HttpRequest original;
    private URI uri;
    private ProtocolVersion version;

    private HttpRequestWrapper(HttpRequest httpRequest0) {
        this.original = httpRequest0;
        this.version = httpRequest0.getRequestLine().getProtocolVersion();
        this.method = httpRequest0.getRequestLine().getMethod();
        this.uri = httpRequest0 instanceof HttpUriRequest ? ((HttpUriRequest)httpRequest0).getURI() : null;
        this.setHeaders(httpRequest0.getAllHeaders());
    }

    public HttpRequestWrapper(HttpRequest httpRequest0, org.apache.http.client.methods.HttpRequestWrapper.1 httpRequestWrapper$10) {
        this(httpRequest0);
    }

    @Override  // org.apache.http.client.methods.HttpUriRequest
    public void abort() {
        throw new UnsupportedOperationException();
    }

    @Override  // org.apache.http.client.methods.HttpUriRequest
    public String getMethod() {
        return this.method;
    }

    public HttpRequest getOriginal() {
        return this.original;
    }

    @Override  // org.apache.http.message.AbstractHttpMessage, org.apache.http.HttpMessage
    @Deprecated
    public HttpParams getParams() {
        if(this.params == null) {
            this.params = this.original.getParams().copy();
        }
        return this.params;
    }

    @Override  // org.apache.http.HttpMessage
    public ProtocolVersion getProtocolVersion() {
        ProtocolVersion protocolVersion0 = this.version;
        return protocolVersion0 == null ? this.original.getProtocolVersion() : protocolVersion0;
    }

    @Override  // org.apache.http.HttpRequest
    public RequestLine getRequestLine() {
        URI uRI0 = this.uri;
        String s = uRI0 == null ? this.original.getRequestLine().getUri() : uRI0.toASCIIString();
        if(s == null || s.length() == 0) {
            s = "/";
        }
        ProtocolVersion protocolVersion0 = this.getProtocolVersion();
        return new BasicRequestLine(this.method, s, protocolVersion0);
    }

    @Override  // org.apache.http.client.methods.HttpUriRequest
    public URI getURI() {
        return this.uri;
    }

    @Override  // org.apache.http.client.methods.HttpUriRequest
    public boolean isAborted() {
        return false;
    }

    public void setProtocolVersion(ProtocolVersion protocolVersion0) {
        this.version = protocolVersion0;
    }

    public void setURI(URI uRI0) {
        this.uri = uRI0;
    }

    @Override
    public String toString() {
        return this.getRequestLine() + " " + this.headergroup;
    }

    public static HttpRequestWrapper wrap(HttpRequest httpRequest0) {
        if(httpRequest0 == null) {
            return null;
        }
        return httpRequest0 instanceof HttpEntityEnclosingRequest ? new HttpEntityEnclosingRequestWrapper(((HttpEntityEnclosingRequest)httpRequest0)) : new HttpRequestWrapper(httpRequest0);
    }

    class org.apache.http.client.methods.HttpRequestWrapper.1 {
    }

}

