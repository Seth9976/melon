package org.apache.http.impl;

import org.apache.http.HttpClientConnection;
import org.apache.http.HttpConnectionMetrics;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.HttpResponseFactory;
import org.apache.http.impl.entity.EntityDeserializer;
import org.apache.http.impl.entity.EntitySerializer;
import org.apache.http.io.HttpMessageParser;
import org.apache.http.io.HttpMessageWriter;
import org.apache.http.io.SessionInputBuffer;
import org.apache.http.io.SessionOutputBuffer;
import org.apache.http.params.HttpParams;

@Deprecated
public abstract class AbstractHttpClientConnection implements HttpClientConnection {
    public AbstractHttpClientConnection() {
        throw new RuntimeException("Stub!");
    }

    public abstract void assertOpen();

    public EntityDeserializer createEntityDeserializer() {
        throw new RuntimeException("Stub!");
    }

    public EntitySerializer createEntitySerializer() {
        throw new RuntimeException("Stub!");
    }

    public HttpResponseFactory createHttpResponseFactory() {
        throw new RuntimeException("Stub!");
    }

    public HttpMessageWriter createRequestWriter(SessionOutputBuffer sessionOutputBuffer0, HttpParams httpParams0) {
        throw new RuntimeException("Stub!");
    }

    public HttpMessageParser createResponseParser(SessionInputBuffer sessionInputBuffer0, HttpResponseFactory httpResponseFactory0, HttpParams httpParams0) {
        throw new RuntimeException("Stub!");
    }

    public void doFlush() {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.HttpClientConnection
    public void flush() {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.HttpConnection
    public HttpConnectionMetrics getMetrics() {
        throw new RuntimeException("Stub!");
    }

    public void init(SessionInputBuffer sessionInputBuffer0, SessionOutputBuffer sessionOutputBuffer0, HttpParams httpParams0) {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.HttpClientConnection
    public boolean isResponseAvailable(int v) {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.HttpConnection
    public boolean isStale() {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.HttpClientConnection
    public void receiveResponseEntity(HttpResponse httpResponse0) {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.HttpClientConnection
    public HttpResponse receiveResponseHeader() {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.HttpClientConnection
    public void sendRequestEntity(HttpEntityEnclosingRequest httpEntityEnclosingRequest0) {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.HttpClientConnection
    public void sendRequestHeader(HttpRequest httpRequest0) {
        throw new RuntimeException("Stub!");
    }
}

