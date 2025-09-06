package com.iloen.melon.net;

import java.net.InetAddress;
import java.net.Socket;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

public class TLSSocketFactory extends SSLSocketFactory {
    private SSLSocketFactory mSSLSocketFactory;

    public TLSSocketFactory() {
        SSLContext sSLContext0 = SSLContext.getInstance("TLS");
        sSLContext0.init(null, null, null);
        this.mSSLSocketFactory = sSLContext0.getSocketFactory();
    }

    @Override  // javax.net.SocketFactory
    public Socket createSocket(String s, int v) {
        return this.enableTLSOnSocket(this.mSSLSocketFactory.createSocket(s, v));
    }

    @Override  // javax.net.SocketFactory
    public Socket createSocket(String s, int v, InetAddress inetAddress0, int v1) {
        return this.enableTLSOnSocket(this.mSSLSocketFactory.createSocket(s, v, inetAddress0, v1));
    }

    @Override  // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress0, int v) {
        return this.enableTLSOnSocket(this.mSSLSocketFactory.createSocket(inetAddress0, v));
    }

    @Override  // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress0, int v, InetAddress inetAddress1, int v1) {
        return this.enableTLSOnSocket(this.mSSLSocketFactory.createSocket(inetAddress0, v, inetAddress1, v1));
    }

    @Override  // javax.net.ssl.SSLSocketFactory
    public Socket createSocket(Socket socket0, String s, int v, boolean z) {
        return this.enableTLSOnSocket(this.mSSLSocketFactory.createSocket(socket0, s, v, z));
    }

    private Socket enableTLSOnSocket(Socket socket0) {
        if(socket0 != null && socket0 instanceof SSLSocket) {
            ((SSLSocket)socket0).setEnabledProtocols(new String[]{"TLSv1.1", "TLSv1.2"});
        }
        return socket0;
    }

    @Override  // javax.net.ssl.SSLSocketFactory
    public String[] getDefaultCipherSuites() {
        return this.mSSLSocketFactory.getDefaultCipherSuites();
    }

    @Override  // javax.net.ssl.SSLSocketFactory
    public String[] getSupportedCipherSuites() {
        return this.mSSLSocketFactory.getSupportedCipherSuites();
    }
}

