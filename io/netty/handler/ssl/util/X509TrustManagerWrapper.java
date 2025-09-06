package io.netty.handler.ssl.util;

import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.SuppressJava6Requirement;
import java.net.Socket;
import java.security.cert.X509Certificate;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.X509ExtendedTrustManager;
import javax.net.ssl.X509TrustManager;

@SuppressJava6Requirement(reason = "Usage guarded by java version check")
final class X509TrustManagerWrapper extends X509ExtendedTrustManager {
    private final X509TrustManager delegate;

    public X509TrustManagerWrapper(X509TrustManager x509TrustManager0) {
        this.delegate = (X509TrustManager)ObjectUtil.checkNotNull(x509TrustManager0, "delegate");
    }

    @Override  // javax.net.ssl.X509TrustManager
    public void checkClientTrusted(X509Certificate[] arr_x509Certificate, String s) {
        this.delegate.checkClientTrusted(arr_x509Certificate, s);
    }

    @Override  // javax.net.ssl.X509ExtendedTrustManager
    public void checkClientTrusted(X509Certificate[] arr_x509Certificate, String s, Socket socket0) {
        this.delegate.checkClientTrusted(arr_x509Certificate, s);
    }

    @Override  // javax.net.ssl.X509ExtendedTrustManager
    public void checkClientTrusted(X509Certificate[] arr_x509Certificate, String s, SSLEngine sSLEngine0) {
        this.delegate.checkClientTrusted(arr_x509Certificate, s);
    }

    @Override  // javax.net.ssl.X509TrustManager
    public void checkServerTrusted(X509Certificate[] arr_x509Certificate, String s) {
        this.delegate.checkServerTrusted(arr_x509Certificate, s);
    }

    @Override  // javax.net.ssl.X509ExtendedTrustManager
    public void checkServerTrusted(X509Certificate[] arr_x509Certificate, String s, Socket socket0) {
        this.delegate.checkServerTrusted(arr_x509Certificate, s);
    }

    @Override  // javax.net.ssl.X509ExtendedTrustManager
    public void checkServerTrusted(X509Certificate[] arr_x509Certificate, String s, SSLEngine sSLEngine0) {
        this.delegate.checkServerTrusted(arr_x509Certificate, s);
    }

    @Override  // javax.net.ssl.X509TrustManager
    public X509Certificate[] getAcceptedIssuers() {
        return this.delegate.getAcceptedIssuers();
    }
}

