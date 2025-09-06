package org.apache.http.impl;

import java.net.InetAddress;
import java.net.Socket;
import org.apache.http.HttpInetConnection;
import org.apache.http.io.SessionInputBuffer;
import org.apache.http.io.SessionOutputBuffer;
import org.apache.http.params.HttpParams;

@Deprecated
public class SocketHttpServerConnection extends AbstractHttpServerConnection implements HttpInetConnection {
    public SocketHttpServerConnection() {
        throw new RuntimeException("Stub!");
    }

    public void assertNotOpen() {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.impl.AbstractHttpServerConnection
    public void assertOpen() {
        throw new RuntimeException("Stub!");
    }

    public void bind(Socket socket0, HttpParams httpParams0) {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.HttpConnection
    public void close() {
        throw new RuntimeException("Stub!");
    }

    public SessionInputBuffer createHttpDataReceiver(Socket socket0, int v, HttpParams httpParams0) {
        throw new RuntimeException("Stub!");
    }

    public SessionOutputBuffer createHttpDataTransmitter(Socket socket0, int v, HttpParams httpParams0) {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.HttpInetConnection
    public InetAddress getLocalAddress() {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.HttpInetConnection
    public int getLocalPort() {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.HttpInetConnection
    public InetAddress getRemoteAddress() {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.HttpInetConnection
    public int getRemotePort() {
        throw new RuntimeException("Stub!");
    }

    public Socket getSocket() {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.HttpConnection
    public int getSocketTimeout() {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.HttpConnection
    public boolean isOpen() {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.HttpConnection
    public void setSocketTimeout(int v) {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.HttpConnection
    public void shutdown() {
        throw new RuntimeException("Stub!");
    }
}

