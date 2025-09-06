package org.apache.http.impl.execchain;

import java.util.Locale;
import org.apache.http.Header;
import org.apache.http.HeaderIterator;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.ProtocolVersion;
import org.apache.http.StatusLine;
import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.params.HttpParams;

@NotThreadSafe
class HttpResponseProxy implements CloseableHttpResponse {
    private final ConnectionHolder connHolder;
    private final HttpResponse original;

    public HttpResponseProxy(HttpResponse httpResponse0, ConnectionHolder connectionHolder0) {
        this.original = httpResponse0;
        this.connHolder = connectionHolder0;
        ResponseEntityProxy.enchance(httpResponse0, connectionHolder0);
    }

    @Override  // org.apache.http.HttpMessage
    public void addHeader(String s, String s1) {
        this.original.addHeader(s, s1);
    }

    @Override  // org.apache.http.HttpMessage
    public void addHeader(Header header0) {
        this.original.addHeader(header0);
    }

    @Override
    public void close() {
        ConnectionHolder connectionHolder0 = this.connHolder;
        if(connectionHolder0 != null) {
            connectionHolder0.abortConnection();
        }
    }

    @Override  // org.apache.http.HttpMessage
    public boolean containsHeader(String s) {
        return this.original.containsHeader(s);
    }

    @Override  // org.apache.http.HttpMessage
    public Header[] getAllHeaders() {
        return this.original.getAllHeaders();
    }

    @Override  // org.apache.http.HttpResponse
    public HttpEntity getEntity() {
        return this.original.getEntity();
    }

    @Override  // org.apache.http.HttpMessage
    public Header getFirstHeader(String s) {
        return this.original.getFirstHeader(s);
    }

    @Override  // org.apache.http.HttpMessage
    public Header[] getHeaders(String s) {
        return this.original.getHeaders(s);
    }

    @Override  // org.apache.http.HttpMessage
    public Header getLastHeader(String s) {
        return this.original.getLastHeader(s);
    }

    @Override  // org.apache.http.HttpResponse
    public Locale getLocale() {
        return this.original.getLocale();
    }

    @Override  // org.apache.http.HttpMessage
    @Deprecated
    public HttpParams getParams() {
        return this.original.getParams();
    }

    @Override  // org.apache.http.HttpMessage
    public ProtocolVersion getProtocolVersion() {
        return this.original.getProtocolVersion();
    }

    @Override  // org.apache.http.HttpResponse
    public StatusLine getStatusLine() {
        return this.original.getStatusLine();
    }

    @Override  // org.apache.http.HttpMessage
    public HeaderIterator headerIterator() {
        return this.original.headerIterator();
    }

    @Override  // org.apache.http.HttpMessage
    public HeaderIterator headerIterator(String s) {
        return this.original.headerIterator(s);
    }

    @Override  // org.apache.http.HttpMessage
    public void removeHeader(Header header0) {
        this.original.removeHeader(header0);
    }

    @Override  // org.apache.http.HttpMessage
    public void removeHeaders(String s) {
        this.original.removeHeaders(s);
    }

    @Override  // org.apache.http.HttpResponse
    public void setEntity(HttpEntity httpEntity0) {
        this.original.setEntity(httpEntity0);
    }

    @Override  // org.apache.http.HttpMessage
    public void setHeader(String s, String s1) {
        this.original.setHeader(s, s1);
    }

    @Override  // org.apache.http.HttpMessage
    public void setHeader(Header header0) {
        this.original.setHeader(header0);
    }

    @Override  // org.apache.http.HttpMessage
    public void setHeaders(Header[] arr_header) {
        this.original.setHeaders(arr_header);
    }

    @Override  // org.apache.http.HttpResponse
    public void setLocale(Locale locale0) {
        this.original.setLocale(locale0);
    }

    @Override  // org.apache.http.HttpMessage
    @Deprecated
    public void setParams(HttpParams httpParams0) {
        this.original.setParams(httpParams0);
    }

    @Override  // org.apache.http.HttpResponse
    public void setReasonPhrase(String s) {
        this.original.setReasonPhrase(s);
    }

    @Override  // org.apache.http.HttpResponse
    public void setStatusCode(int v) {
        this.original.setStatusCode(v);
    }

    @Override  // org.apache.http.HttpResponse
    public void setStatusLine(ProtocolVersion protocolVersion0, int v) {
        this.original.setStatusLine(protocolVersion0, v);
    }

    @Override  // org.apache.http.HttpResponse
    public void setStatusLine(ProtocolVersion protocolVersion0, int v, String s) {
        this.original.setStatusLine(protocolVersion0, v, s);
    }

    @Override  // org.apache.http.HttpResponse
    public void setStatusLine(StatusLine statusLine0) {
        this.original.setStatusLine(statusLine0);
    }

    @Override
    public String toString() {
        return "HttpResponseProxy{" + this.original + '}';
    }
}

