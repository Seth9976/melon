package org.apache.http.conn;

import java.net.InetAddress;
import java.net.Socket;
import org.apache.http.conn.scheme.SocketFactory;
import org.apache.http.params.HttpParams;

@Deprecated
public final class MultihomePlainSocketFactory implements SocketFactory {
    public MultihomePlainSocketFactory() {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.conn.scheme.SocketFactory
    public Socket connectSocket(Socket socket0, String s, int v, InetAddress inetAddress0, int v1, HttpParams httpParams0) {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.conn.scheme.SocketFactory
    public Socket createSocket() {
        throw new RuntimeException("Stub!");
    }

    @Override
    public boolean equals(Object object0) {
        throw new RuntimeException("Stub!");
    }

    public static MultihomePlainSocketFactory getSocketFactory() {
        throw new RuntimeException("Stub!");
    }

    @Override
    public int hashCode() {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.conn.scheme.SocketFactory
    public final boolean isSecure(Socket socket0) {
        throw new RuntimeException("Stub!");
    }
}

