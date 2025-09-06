package org.apache.http.conn.socket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import org.apache.http.HttpHost;
import org.apache.http.annotation.Immutable;
import org.apache.http.protocol.HttpContext;

@Immutable
public class PlainConnectionSocketFactory implements ConnectionSocketFactory {
    public static final PlainConnectionSocketFactory INSTANCE;

    static {
        PlainConnectionSocketFactory.INSTANCE = new PlainConnectionSocketFactory();
    }

    @Override  // org.apache.http.conn.socket.ConnectionSocketFactory
    public Socket connectSocket(int v, Socket socket0, HttpHost httpHost0, InetSocketAddress inetSocketAddress0, InetSocketAddress inetSocketAddress1, HttpContext httpContext0) {
        if(socket0 == null) {
            socket0 = this.createSocket(httpContext0);
        }
        if(inetSocketAddress1 != null) {
            socket0.bind(inetSocketAddress1);
        }
        try {
            socket0.connect(inetSocketAddress0, v);
            return socket0;
        }
        catch(IOException iOException0) {
            try {
                socket0.close();
            }
            catch(IOException unused_ex) {
            }
            throw iOException0;
        }
    }

    @Override  // org.apache.http.conn.socket.ConnectionSocketFactory
    public Socket createSocket(HttpContext httpContext0) {
        return new Socket();
    }

    public static PlainConnectionSocketFactory getSocketFactory() {
        return PlainConnectionSocketFactory.INSTANCE;
    }
}

