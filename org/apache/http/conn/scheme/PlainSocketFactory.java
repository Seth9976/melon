package org.apache.http.conn.scheme;

import java.net.InetAddress;
import java.net.Socket;
import org.apache.http.params.HttpParams;

@Deprecated
public final class PlainSocketFactory implements SocketFactory {
    public PlainSocketFactory() {
        throw new RuntimeException("Stub!");
    }

    public PlainSocketFactory(HostNameResolver hostNameResolver0) {
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

    public static PlainSocketFactory getSocketFactory() {
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

