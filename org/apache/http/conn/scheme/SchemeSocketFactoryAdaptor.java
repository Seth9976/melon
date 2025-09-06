package org.apache.http.conn.scheme;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import org.apache.http.params.HttpParams;

@Deprecated
class SchemeSocketFactoryAdaptor implements SchemeSocketFactory {
    private final SocketFactory factory;

    public SchemeSocketFactoryAdaptor(SocketFactory socketFactory0) {
        this.factory = socketFactory0;
    }

    @Override  // org.apache.http.conn.scheme.SchemeSocketFactory
    public Socket connectSocket(Socket socket0, InetSocketAddress inetSocketAddress0, InetSocketAddress inetSocketAddress1, HttpParams httpParams0) {
        String s = inetSocketAddress0.getHostName();
        int v = inetSocketAddress0.getPort();
        if(inetSocketAddress1 != null) {
            InetAddress inetAddress0 = inetSocketAddress1.getAddress();
            int v1 = inetSocketAddress1.getPort();
            return this.factory.connectSocket(socket0, s, v, inetAddress0, v1, httpParams0);
        }
        return this.factory.connectSocket(socket0, s, v, null, 0, httpParams0);
    }

    @Override  // org.apache.http.conn.scheme.SchemeSocketFactory
    public Socket createSocket(HttpParams httpParams0) {
        return this.factory.createSocket();
    }

    @Override
    public boolean equals(Object object0) {
        if(object0 == null) {
            return false;
        }
        if(this == object0) {
            return true;
        }
        return object0 instanceof SchemeSocketFactoryAdaptor ? this.factory.equals(((SchemeSocketFactoryAdaptor)object0).factory) : this.factory.equals(object0);
    }

    public SocketFactory getFactory() {
        return this.factory;
    }

    @Override
    public int hashCode() {
        return this.factory.hashCode();
    }

    @Override  // org.apache.http.conn.scheme.SchemeSocketFactory
    public boolean isSecure(Socket socket0) {
        return this.factory.isSecure(socket0);
    }
}

