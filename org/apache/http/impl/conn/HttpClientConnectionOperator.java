package org.apache.http.impl.conn;

import android.util.Log;
import java.io.IOException;
import java.net.ConnectException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.Arrays;
import org.apache.http.HttpHost;
import org.apache.http.annotation.Immutable;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.config.Lookup;
import org.apache.http.config.SocketConfig;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.conn.DnsResolver;
import org.apache.http.conn.HttpHostConnectException;
import org.apache.http.conn.ManagedHttpClientConnection;
import org.apache.http.conn.SchemePortResolver;
import org.apache.http.conn.UnsupportedSchemeException;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.LayeredConnectionSocketFactory;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.Args;

@Immutable
class HttpClientConnectionOperator {
    static final String SOCKET_FACTORY_REGISTRY = "http.socket-factory-registry";
    private static final String TAG = "HttpClient";
    private final DnsResolver dnsResolver;
    private final SchemePortResolver schemePortResolver;
    private final Lookup socketFactoryRegistry;

    public HttpClientConnectionOperator(Lookup lookup0, SchemePortResolver schemePortResolver0, DnsResolver dnsResolver0) {
        Args.notNull(lookup0, "Socket factory registry");
        this.socketFactoryRegistry = lookup0;
        if(schemePortResolver0 == null) {
            schemePortResolver0 = DefaultSchemePortResolver.INSTANCE;
        }
        this.schemePortResolver = schemePortResolver0;
        if(dnsResolver0 == null) {
            dnsResolver0 = (SystemDefaultDnsResolver this) -> InetAddress.getAllByName(s);
        }
        this.dnsResolver = dnsResolver0;
    }

    public void connect(ManagedHttpClientConnection managedHttpClientConnection0, HttpHost httpHost0, InetSocketAddress inetSocketAddress0, int v, SocketConfig socketConfig0, HttpContext httpContext0) {
        boolean z1;
        boolean z;
        ConnectionSocketFactory connectionSocketFactory0 = (ConnectionSocketFactory)this.getSocketFactoryRegistry(httpContext0).lookup(httpHost0.getSchemeName());
        if(connectionSocketFactory0 == null) {
            throw new UnsupportedSchemeException(httpHost0.getSchemeName() + " protocol is not supported");
        }
        String s = httpHost0.getHostName();
        InetAddress[] arr_inetAddress = this.dnsResolver.resolve(s);
        int v1 = this.schemePortResolver.resolve(httpHost0);
        for(int v2 = 0; v2 < arr_inetAddress.length; ++v2) {
            InetAddress inetAddress0 = arr_inetAddress[v2];
            if(v2 == arr_inetAddress.length - 1) {
                z = true;
                z1 = true;
            }
            else {
                z = true;
                z1 = false;
            }
            Socket socket0 = connectionSocketFactory0.createSocket(httpContext0);
            socket0.setSoTimeout(socketConfig0.getSoTimeout());
            socket0.setReuseAddress(socketConfig0.isSoReuseAddress());
            socket0.setTcpNoDelay(socketConfig0.isTcpNoDelay());
            socket0.setKeepAlive(socketConfig0.isSoKeepAlive());
            int v3 = socketConfig0.getSoLinger();
            if(v3 >= 0) {
                if(v3 <= 0) {
                    z = false;
                }
                socket0.setSoLinger(z, v3);
            }
            managedHttpClientConnection0.bind(socket0);
            InetSocketAddress inetSocketAddress1 = new InetSocketAddress(inetAddress0, v1);
            if(Log.isLoggable("HttpClient", 3)) {
                Log.d("HttpClient", "Connecting to " + inetSocketAddress1);
            }
            try {
                managedHttpClientConnection0.bind(connectionSocketFactory0.connectSocket(v, socket0, httpHost0, inetSocketAddress1, inetSocketAddress0, httpContext0));
                if(!Log.isLoggable("HttpClient", 3)) {
                    break;
                }
                Log.d("HttpClient", "Connection established " + managedHttpClientConnection0);
                return;
            }
            catch(SocketTimeoutException socketTimeoutException0) {
                if(z1) {
                    new ConnectTimeoutException(HttpClientConnectionOperator.getConnectTimeoutMessage(socketTimeoutException0, httpHost0, arr_inetAddress)).initCause(socketTimeoutException0);
                }
            }
            catch(ConnectException connectException0) {
                if(z1) {
                    if(!"Connection timed out".equals(connectException0.getMessage())) {
                        throw new HttpHostConnectException(httpHost0, connectException0);
                    }
                    ConnectTimeoutException connectTimeoutException0 = new ConnectTimeoutException(HttpClientConnectionOperator.getConnectTimeoutMessage(connectException0, httpHost0, arr_inetAddress));
                    connectTimeoutException0.initCause(connectException0);
                    throw connectTimeoutException0;
                }
            }
            if(Log.isLoggable("HttpClient", 3)) {
                Log.d("HttpClient", "Connect to " + inetSocketAddress1 + " timed out. Connection will be retried using another IP address");
            }
        }
    }

    private static String getConnectTimeoutMessage(IOException iOException0, HttpHost httpHost0, InetAddress[] arr_inetAddress) {
        return "Connect to " + (httpHost0 == null ? "remote host" : httpHost0.toHostString()) + (arr_inetAddress == null || arr_inetAddress.length <= 0 ? "" : " " + Arrays.asList(arr_inetAddress)) + (iOException0 == null || iOException0.getMessage() == null ? " timed out" : " failed: " + iOException0.getMessage());
    }

    private Lookup getSocketFactoryRegistry(HttpContext httpContext0) {
        Lookup lookup0 = (Lookup)httpContext0.getAttribute("http.socket-factory-registry");
        return lookup0 == null ? this.socketFactoryRegistry : lookup0;
    }

    public void upgrade(ManagedHttpClientConnection managedHttpClientConnection0, HttpHost httpHost0, HttpContext httpContext0) {
        ConnectionSocketFactory connectionSocketFactory0 = (ConnectionSocketFactory)this.getSocketFactoryRegistry(HttpClientContext.adapt(httpContext0)).lookup(httpHost0.getSchemeName());
        if(connectionSocketFactory0 == null) {
            throw new UnsupportedSchemeException(httpHost0.getSchemeName() + " protocol is not supported");
        }
        if(!(connectionSocketFactory0 instanceof LayeredConnectionSocketFactory)) {
            throw new UnsupportedSchemeException(httpHost0.getSchemeName() + " protocol does not support connection upgrade");
        }
        Socket socket0 = managedHttpClientConnection0.getSocket();
        int v = this.schemePortResolver.resolve(httpHost0);
        managedHttpClientConnection0.bind(((LayeredConnectionSocketFactory)connectionSocketFactory0).createLayeredSocket(socket0, httpHost0.getHostName(), v, httpContext0));
    }
}

