package org.apache.http.message;

import org.apache.http.Header;
import org.apache.http.HeaderIterator;
import org.apache.http.HttpMessage;
import org.apache.http.params.HttpParams;

@Deprecated
public abstract class AbstractHttpMessage implements HttpMessage {
    protected HeaderGroup headergroup;
    protected HttpParams params;

    public AbstractHttpMessage() {
        throw new RuntimeException("Stub!");
    }

    public AbstractHttpMessage(HttpParams httpParams0) {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.HttpMessage
    public void addHeader(String s, String s1) {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.HttpMessage
    public void addHeader(Header header0) {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.HttpMessage
    public boolean containsHeader(String s) {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.HttpMessage
    public Header[] getAllHeaders() {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.HttpMessage
    public Header getFirstHeader(String s) {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.HttpMessage
    public Header[] getHeaders(String s) {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.HttpMessage
    public Header getLastHeader(String s) {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.HttpMessage
    public HttpParams getParams() {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.HttpMessage
    public HeaderIterator headerIterator() {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.HttpMessage
    public HeaderIterator headerIterator(String s) {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.HttpMessage
    public void removeHeader(Header header0) {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.HttpMessage
    public void removeHeaders(String s) {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.HttpMessage
    public void setHeader(String s, String s1) {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.HttpMessage
    public void setHeader(Header header0) {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.HttpMessage
    public void setHeaders(Header[] arr_header) {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.HttpMessage
    public void setParams(HttpParams httpParams0) {
        throw new RuntimeException("Stub!");
    }
}

