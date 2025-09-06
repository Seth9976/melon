package org.apache.http.impl.pool;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import javax.net.SocketFactory;
import javax.net.ssl.SSLSocketFactory;
import org.apache.http.HttpClientConnection;
import org.apache.http.HttpConnectionFactory;
import org.apache.http.HttpHost;
import org.apache.http.annotation.Immutable;
import org.apache.http.config.ConnectionConfig;
import org.apache.http.config.SocketConfig;
import org.apache.http.impl.DefaultBHttpClientConnection;
import org.apache.http.impl.DefaultBHttpClientConnectionFactory;
import org.apache.http.params.HttpParamConfig;
import org.apache.http.params.HttpParams;
import org.apache.http.pool.ConnFactory;
import org.apache.http.util.Args;

@Immutable
public class BasicConnFactory implements ConnFactory {
    private final HttpConnectionFactory connFactory;
    private final int connectTimeout;
    private final SocketFactory plainfactory;
    private final SocketConfig sconfig;
    private final SSLSocketFactory sslfactory;

    public BasicConnFactory() {
        this(null, null, 0, SocketConfig.DEFAULT, ConnectionConfig.DEFAULT);
    }

    public BasicConnFactory(int v, SocketConfig socketConfig0, ConnectionConfig connectionConfig0) {
        this(null, null, v, socketConfig0, connectionConfig0);
    }

    public BasicConnFactory(SocketFactory socketFactory0, SSLSocketFactory sSLSocketFactory0, int v, SocketConfig socketConfig0, ConnectionConfig connectionConfig0) {
        this.plainfactory = socketFactory0;
        this.sslfactory = sSLSocketFactory0;
        this.connectTimeout = v;
        if(socketConfig0 == null) {
            socketConfig0 = SocketConfig.DEFAULT;
        }
        this.sconfig = socketConfig0;
        if(connectionConfig0 == null) {
            connectionConfig0 = ConnectionConfig.DEFAULT;
        }
        this.connFactory = new DefaultBHttpClientConnectionFactory(connectionConfig0);
    }

    @Deprecated
    public BasicConnFactory(SSLSocketFactory sSLSocketFactory0, HttpParams httpParams0) {
        Args.notNull(httpParams0, "HTTP params");
        this.plainfactory = null;
        this.sslfactory = sSLSocketFactory0;
        this.connectTimeout = httpParams0.getIntParameter("http.connection.timeout", 0);
        this.sconfig = HttpParamConfig.getSocketConfig(httpParams0);
        this.connFactory = new DefaultBHttpClientConnectionFactory(HttpParamConfig.getConnectionConfig(httpParams0));
    }

    public BasicConnFactory(SocketConfig socketConfig0, ConnectionConfig connectionConfig0) {
        this(null, null, 0, socketConfig0, connectionConfig0);
    }

    @Deprecated
    public BasicConnFactory(HttpParams httpParams0) {
        this(null, httpParams0);
    }

    @Override  // org.apache.http.pool.ConnFactory
    public Object create(Object object0) {
        return this.create(((HttpHost)object0));
    }

    @Deprecated
    public HttpClientConnection create(Socket socket0, HttpParams httpParams0) {
        HttpClientConnection httpClientConnection0 = new DefaultBHttpClientConnection(httpParams0.getIntParameter("http.socket.buffer-size", 0x2000));
        ((DefaultBHttpClientConnection)httpClientConnection0).bind(socket0);
        return httpClientConnection0;
    }

    public HttpClientConnection create(HttpHost httpHost0) {
        Socket socket0;
        String s = httpHost0.getSchemeName();
        if("http".equalsIgnoreCase(s)) {
            SocketFactory socketFactory0 = this.plainfactory;
            socket0 = socketFactory0 == null ? new Socket() : socketFactory0.createSocket();
        }
        else {
            socket0 = null;
        }
        if("https".equalsIgnoreCase(s)) {
            SocketFactory socketFactory1 = this.sslfactory;
            if(socketFactory1 == null) {
                socketFactory1 = SSLSocketFactory.getDefault();
            }
            socket0 = socketFactory1.createSocket();
        }
        if(socket0 == null) {
            throw new IOException(s + " scheme is not supported");
        }
        String s1 = httpHost0.getHostName();
        int v = httpHost0.getPort();
        if(v == -1) {
            if(httpHost0.getSchemeName().equalsIgnoreCase("http")) {
                v = 80;
            }
            else if(httpHost0.getSchemeName().equalsIgnoreCase("https")) {
                v = 443;
            }
        }
        socket0.setSoTimeout(this.sconfig.getSoTimeout());
        socket0.connect(new InetSocketAddress(s1, v), this.connectTimeout);
        socket0.setTcpNoDelay(this.sconfig.isTcpNoDelay());
        int v1 = this.sconfig.getSoLinger();
        if(v1 >= 0) {
            socket0.setSoLinger(v1 > 0, v1);
        }
        socket0.setKeepAlive(this.sconfig.isSoKeepAlive());
        return (HttpClientConnection)this.connFactory.createConnection(socket0);
    }
}

