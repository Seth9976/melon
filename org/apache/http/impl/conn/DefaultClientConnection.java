package org.apache.http.impl.conn;

import java.net.Socket;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.HttpResponseFactory;
import org.apache.http.conn.OperatedClientConnection;
import org.apache.http.impl.SocketHttpClientConnection;
import org.apache.http.io.HttpMessageParser;
import org.apache.http.io.SessionInputBuffer;
import org.apache.http.io.SessionOutputBuffer;
import org.apache.http.params.HttpParams;

@Deprecated
public class DefaultClientConnection extends SocketHttpClientConnection implements OperatedClientConnection {
    public DefaultClientConnection() {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.impl.SocketHttpClientConnection, org.apache.http.HttpConnection
    public void close() {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.impl.AbstractHttpClientConnection
    public HttpMessageParser createResponseParser(SessionInputBuffer sessionInputBuffer0, HttpResponseFactory httpResponseFactory0, HttpParams httpParams0) {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.impl.SocketHttpClientConnection
    public SessionInputBuffer createSessionInputBuffer(Socket socket0, int v, HttpParams httpParams0) {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.impl.SocketHttpClientConnection
    public SessionOutputBuffer createSessionOutputBuffer(Socket socket0, int v, HttpParams httpParams0) {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.impl.SocketHttpClientConnection, org.apache.http.conn.OperatedClientConnection
    public final Socket getSocket() {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.conn.OperatedClientConnection
    public final HttpHost getTargetHost() {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.conn.OperatedClientConnection
    public final boolean isSecure() {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.conn.OperatedClientConnection
    public void openCompleted(boolean z, HttpParams httpParams0) {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.conn.OperatedClientConnection
    public void opening(Socket socket0, HttpHost httpHost0) {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.impl.AbstractHttpClientConnection, org.apache.http.HttpClientConnection
    public HttpResponse receiveResponseHeader() {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.impl.AbstractHttpClientConnection, org.apache.http.HttpClientConnection
    public void sendRequestHeader(HttpRequest httpRequest0) {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.impl.SocketHttpClientConnection, org.apache.http.HttpConnection
    public void shutdown() {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.conn.OperatedClientConnection
    public void update(Socket socket0, HttpHost httpHost0, boolean z, HttpParams httpParams0) {
        throw new RuntimeException("Stub!");
    }
}

