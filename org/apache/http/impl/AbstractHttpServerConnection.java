package org.apache.http.impl;

import org.apache.http.HttpConnectionMetrics;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestFactory;
import org.apache.http.HttpResponse;
import org.apache.http.HttpServerConnection;
import org.apache.http.impl.entity.EntityDeserializer;
import org.apache.http.impl.entity.EntitySerializer;
import org.apache.http.io.HttpMessageParser;
import org.apache.http.io.HttpMessageWriter;
import org.apache.http.io.SessionInputBuffer;
import org.apache.http.io.SessionOutputBuffer;
import org.apache.http.params.HttpParams;

@Deprecated
public abstract class AbstractHttpServerConnection implements HttpServerConnection {
    public AbstractHttpServerConnection() {
        throw new RuntimeException("Stub!");
    }

    public abstract void assertOpen();

    public EntityDeserializer createEntityDeserializer() {
        throw new RuntimeException("Stub!");
    }

    public EntitySerializer createEntitySerializer() {
        throw new RuntimeException("Stub!");
    }

    public HttpRequestFactory createHttpRequestFactory() {
        throw new RuntimeException("Stub!");
    }

    public HttpMessageParser createRequestParser(SessionInputBuffer sessionInputBuffer0, HttpRequestFactory httpRequestFactory0, HttpParams httpParams0) {
        throw new RuntimeException("Stub!");
    }

    public HttpMessageWriter createResponseWriter(SessionOutputBuffer sessionOutputBuffer0, HttpParams httpParams0) {
        throw new RuntimeException("Stub!");
    }

    public void doFlush() {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.HttpServerConnection
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

    @Override  // org.apache.http.HttpConnection
    public boolean isStale() {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.HttpServerConnection
    public void receiveRequestEntity(HttpEntityEnclosingRequest httpEntityEnclosingRequest0) {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.HttpServerConnection
    public HttpRequest receiveRequestHeader() {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.HttpServerConnection
    public void sendResponseEntity(HttpResponse httpResponse0) {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.HttpServerConnection
    public void sendResponseHeader(HttpResponse httpResponse0) {
        throw new RuntimeException("Stub!");
    }
}

