package org.apache.http.conn.scheme;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpParams;

@Deprecated
class SocketFactoryAdaptor implements SocketFactory {
    private final SchemeSocketFactory factory;

    public SocketFactoryAdaptor(SchemeSocketFactory schemeSocketFactory0) {
        this.factory = schemeSocketFactory0;
    }

    @Override  // org.apache.http.conn.scheme.SocketFactory
    public Socket connectSocket(Socket socket0, String s, int v, InetAddress inetAddress0, int v1, HttpParams httpParams0) {
        InetSocketAddress inetSocketAddress0;
        if(inetAddress0 != null || v1 > 0) {
            if(v1 <= 0) {
                v1 = 0;
            }
            inetSocketAddress0 = new InetSocketAddress(inetAddress0, v1);
        }
        else {
            inetSocketAddress0 = null;
        }
        InetSocketAddress inetSocketAddress1 = new InetSocketAddress(InetAddress.getByName(s), v);
        return this.factory.connectSocket(socket0, inetSocketAddress1, inetSocketAddress0, httpParams0);
    }

    @Override  // org.apache.http.conn.scheme.SocketFactory
    public Socket createSocket() {
        BasicHttpParams basicHttpParams0 = new BasicHttpParams();
        return this.factory.createSocket(basicHttpParams0);
    }

    @Override
    public boolean equals(Object object0) {
        if(object0 == null) {
            return false;
        }
        if(this == object0) {
            return true;
        }
        return object0 instanceof SocketFactoryAdaptor ? this.factory.equals(((SocketFactoryAdaptor)object0).factory) : this.factory.equals(object0);
    }

    public SchemeSocketFactory getFactory() {
        return this.factory;
    }

    @Override
    public int hashCode() {
        return this.factory.hashCode();
    }

    @Override  // org.apache.http.conn.scheme.SocketFactory
    public boolean isSecure(Socket socket0) {
        return this.factory.isSecure(socket0);
    }
}

