package org.apache.http.conn.ssl;

import U4.x;
import android.annotation.TargetApi;
import android.net.SSLCertificateSocketFactory;
import android.util.Log;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import javax.net.SocketFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import jeb.synthetic.TWR;
import org.apache.http.HttpHost;
import org.apache.http.annotation.ThreadSafe;
import org.apache.http.conn.socket.LayeredConnectionSocketFactory;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.Args;
import org.apache.http.util.TextUtils;

@ThreadSafe
public class SSLConnectionSocketFactory implements LayeredConnectionSocketFactory {
    public static final X509HostnameVerifier ALLOW_ALL_HOSTNAME_VERIFIER = null;
    public static final X509HostnameVerifier BROWSER_COMPATIBLE_HOSTNAME_VERIFIER = null;
    public static final String SSL = "SSL";
    public static final String SSLV2 = "SSLv2";
    public static final X509HostnameVerifier STRICT_HOSTNAME_VERIFIER = null;
    private static final String TAG = "HttpClient";
    public static final String TLS = "TLS";
    private final X509HostnameVerifier hostnameVerifier;
    private final SSLSocketFactory socketfactory;
    private final String[] supportedCipherSuites;
    private final String[] supportedProtocols;

    static {
        SSLConnectionSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER = new AllowAllHostnameVerifierHC4();
        SSLConnectionSocketFactory.BROWSER_COMPATIBLE_HOSTNAME_VERIFIER = new BrowserCompatHostnameVerifierHC4();
        SSLConnectionSocketFactory.STRICT_HOSTNAME_VERIFIER = new StrictHostnameVerifierHC4();
    }

    public SSLConnectionSocketFactory(SSLContext sSLContext0) {
        this(sSLContext0, SSLConnectionSocketFactory.BROWSER_COMPATIBLE_HOSTNAME_VERIFIER);
    }

    public SSLConnectionSocketFactory(SSLContext sSLContext0, X509HostnameVerifier x509HostnameVerifier0) {
        this(((SSLContext)Args.notNull(sSLContext0, "SSL context")).getSocketFactory(), null, null, x509HostnameVerifier0);
    }

    public SSLConnectionSocketFactory(SSLContext sSLContext0, String[] arr_s, String[] arr_s1, X509HostnameVerifier x509HostnameVerifier0) {
        this(((SSLContext)Args.notNull(sSLContext0, "SSL context")).getSocketFactory(), arr_s, arr_s1, x509HostnameVerifier0);
    }

    public SSLConnectionSocketFactory(SSLSocketFactory sSLSocketFactory0, X509HostnameVerifier x509HostnameVerifier0) {
        this(sSLSocketFactory0, null, null, x509HostnameVerifier0);
    }

    public SSLConnectionSocketFactory(SSLSocketFactory sSLSocketFactory0, String[] arr_s, String[] arr_s1, X509HostnameVerifier x509HostnameVerifier0) {
        this.socketfactory = (SSLSocketFactory)Args.notNull(sSLSocketFactory0, "SSL socket factory");
        this.supportedProtocols = arr_s;
        this.supportedCipherSuites = arr_s1;
        if(x509HostnameVerifier0 == null) {
            x509HostnameVerifier0 = SSLConnectionSocketFactory.BROWSER_COMPATIBLE_HOSTNAME_VERIFIER;
        }
        this.hostnameVerifier = x509HostnameVerifier0;
    }

    @Override  // org.apache.http.conn.socket.ConnectionSocketFactory
    public Socket connectSocket(int v, Socket socket0, HttpHost httpHost0, InetSocketAddress inetSocketAddress0, InetSocketAddress inetSocketAddress1, HttpContext httpContext0) {
        Args.notNull(httpHost0, "HTTP host");
        Args.notNull(inetSocketAddress0, "Remote address");
        if(socket0 == null) {
            socket0 = this.createSocket(httpContext0);
        }
        if(inetSocketAddress1 != null) {
            socket0.bind(inetSocketAddress1);
        }
        try {
            socket0.connect(inetSocketAddress0, v);
        }
        catch(IOException iOException0) {
            try {
                socket0.close();
            }
            catch(IOException unused_ex) {
            }
            throw iOException0;
        }
        if(socket0 instanceof SSLSocket) {
            ((SSLSocket)socket0).startHandshake();
            this.verifyHostname(((SSLSocket)socket0), httpHost0.getHostName());
            return socket0;
        }
        return this.createLayeredSocket(socket0, httpHost0.getHostName(), inetSocketAddress0.getPort(), httpContext0);
    }

    @Override  // org.apache.http.conn.socket.LayeredConnectionSocketFactory
    @TargetApi(17)
    public Socket createLayeredSocket(Socket socket0, String s, int v, HttpContext httpContext0) {
        Socket socket1 = (SSLSocket)this.socketfactory.createSocket(socket0, s, v, true);
        String[] arr_s = this.supportedProtocols;
        if(arr_s != null) {
            ((SSLSocket)socket1).setEnabledProtocols(arr_s);
        }
        String[] arr_s1 = this.supportedCipherSuites;
        if(arr_s1 != null) {
            ((SSLSocket)socket1).setEnabledCipherSuites(arr_s1);
        }
        if(this.socketfactory instanceof SSLCertificateSocketFactory) {
            if(Log.isLoggable("HttpClient", 3)) {
                x.w("Enabling SNI for ", s, "HttpClient");
            }
            ((SSLCertificateSocketFactory)this.socketfactory).setHostname(socket1, s);
        }
        ((SSLSocket)socket1).startHandshake();
        this.verifyHostname(((SSLSocket)socket1), s);
        return socket1;
    }

    @Override  // org.apache.http.conn.socket.ConnectionSocketFactory
    public Socket createSocket(HttpContext httpContext0) {
        return SocketFactory.getDefault().createSocket();
    }

    public X509HostnameVerifier getHostnameVerifier() {
        return this.hostnameVerifier;
    }

    public static SSLConnectionSocketFactory getSocketFactory() {
        return new SSLConnectionSocketFactory(((SSLSocketFactory)SSLCertificateSocketFactory.getDefault(0)), SSLConnectionSocketFactory.BROWSER_COMPATIBLE_HOSTNAME_VERIFIER);
    }

    public static SSLConnectionSocketFactory getSystemSocketFactory() {
        return new SSLConnectionSocketFactory(((SSLSocketFactory)SSLCertificateSocketFactory.getDefault(0)), SSLConnectionSocketFactory.split(System.getProperty("https.protocols")), SSLConnectionSocketFactory.split(System.getProperty("https.cipherSuites")), SSLConnectionSocketFactory.BROWSER_COMPATIBLE_HOSTNAME_VERIFIER);
    }

    public void prepareSocket(SSLSocket sSLSocket0) {
    }

    // 去混淆评级： 低(20)
    private static String[] split(String s) {
        return TextUtils.isBlank(s) ? null : s.split(" *, *");
    }

    private void verifyHostname(SSLSocket sSLSocket0, String s) {
        try {
            this.hostnameVerifier.verify(s, sSLSocket0);
        }
        catch(IOException iOException0) {
            TWR.safeClose$NT(sSLSocket0, iOException0);
            throw iOException0;
        }
    }
}

