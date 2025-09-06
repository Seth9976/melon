package org.apache.http.conn.scheme;

import java.net.Socket;
import org.apache.http.params.HttpParams;

@Deprecated
class SchemeLayeredSocketFactoryAdaptor extends SchemeSocketFactoryAdaptor implements SchemeLayeredSocketFactory {
    private final LayeredSocketFactory factory;

    public SchemeLayeredSocketFactoryAdaptor(LayeredSocketFactory layeredSocketFactory0) {
        super(layeredSocketFactory0);
        this.factory = layeredSocketFactory0;
    }

    @Override  // org.apache.http.conn.scheme.SchemeLayeredSocketFactory
    public Socket createLayeredSocket(Socket socket0, String s, int v, HttpParams httpParams0) {
        return this.factory.createSocket(socket0, s, v, true);
    }
}

