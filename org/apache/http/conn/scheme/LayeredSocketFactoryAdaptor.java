package org.apache.http.conn.scheme;

import java.net.Socket;

@Deprecated
class LayeredSocketFactoryAdaptor extends SocketFactoryAdaptor implements LayeredSocketFactory {
    private final LayeredSchemeSocketFactory factory;

    public LayeredSocketFactoryAdaptor(LayeredSchemeSocketFactory layeredSchemeSocketFactory0) {
        super(layeredSchemeSocketFactory0);
        this.factory = layeredSchemeSocketFactory0;
    }

    @Override  // org.apache.http.conn.scheme.LayeredSocketFactory
    public Socket createSocket(Socket socket0, String s, int v, boolean z) {
        return this.factory.createLayeredSocket(socket0, s, v, z);
    }
}

