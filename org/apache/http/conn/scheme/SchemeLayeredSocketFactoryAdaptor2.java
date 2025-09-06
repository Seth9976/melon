package org.apache.http.conn.scheme;

import java.net.InetSocketAddress;
import java.net.Socket;
import org.apache.http.params.HttpParams;

@Deprecated
class SchemeLayeredSocketFactoryAdaptor2 implements SchemeLayeredSocketFactory {
    private final LayeredSchemeSocketFactory factory;

    public SchemeLayeredSocketFactoryAdaptor2(LayeredSchemeSocketFactory layeredSchemeSocketFactory0) {
        this.factory = layeredSchemeSocketFactory0;
    }

    @Override  // org.apache.http.conn.scheme.SchemeSocketFactory
    public Socket connectSocket(Socket socket0, InetSocketAddress inetSocketAddress0, InetSocketAddress inetSocketAddress1, HttpParams httpParams0) {
        return this.factory.connectSocket(socket0, inetSocketAddress0, inetSocketAddress1, httpParams0);
    }

    @Override  // org.apache.http.conn.scheme.SchemeLayeredSocketFactory
    public Socket createLayeredSocket(Socket socket0, String s, int v, HttpParams httpParams0) {
        return this.factory.createLayeredSocket(socket0, s, v, true);
    }

    @Override  // org.apache.http.conn.scheme.SchemeSocketFactory
    public Socket createSocket(HttpParams httpParams0) {
        return this.factory.createSocket(httpParams0);
    }

    @Override  // org.apache.http.conn.scheme.SchemeSocketFactory
    public boolean isSecure(Socket socket0) {
        return this.factory.isSecure(socket0);
    }
}

