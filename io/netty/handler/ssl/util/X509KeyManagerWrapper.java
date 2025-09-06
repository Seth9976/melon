package io.netty.handler.ssl.util;

import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.SuppressJava6Requirement;
import java.net.Socket;
import java.security.Principal;
import java.security.PrivateKey;
import java.security.cert.X509Certificate;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.X509ExtendedKeyManager;
import javax.net.ssl.X509KeyManager;

@SuppressJava6Requirement(reason = "Usage guarded by java version check")
final class X509KeyManagerWrapper extends X509ExtendedKeyManager {
    private final X509KeyManager delegate;

    public X509KeyManagerWrapper(X509KeyManager x509KeyManager0) {
        this.delegate = (X509KeyManager)ObjectUtil.checkNotNull(x509KeyManager0, "delegate");
    }

    @Override  // javax.net.ssl.X509KeyManager
    public String chooseClientAlias(String[] arr_s, Principal[] arr_principal, Socket socket0) {
        return this.delegate.chooseClientAlias(arr_s, arr_principal, socket0);
    }

    @Override  // javax.net.ssl.X509ExtendedKeyManager
    public String chooseEngineClientAlias(String[] arr_s, Principal[] arr_principal, SSLEngine sSLEngine0) {
        return this.delegate.chooseClientAlias(arr_s, arr_principal, null);
    }

    @Override  // javax.net.ssl.X509ExtendedKeyManager
    public String chooseEngineServerAlias(String s, Principal[] arr_principal, SSLEngine sSLEngine0) {
        return this.delegate.chooseServerAlias(s, arr_principal, null);
    }

    @Override  // javax.net.ssl.X509KeyManager
    public String chooseServerAlias(String s, Principal[] arr_principal, Socket socket0) {
        return this.delegate.chooseServerAlias(s, arr_principal, socket0);
    }

    @Override  // javax.net.ssl.X509KeyManager
    public X509Certificate[] getCertificateChain(String s) {
        return this.delegate.getCertificateChain(s);
    }

    @Override  // javax.net.ssl.X509KeyManager
    public String[] getClientAliases(String s, Principal[] arr_principal) {
        return this.delegate.getClientAliases(s, arr_principal);
    }

    @Override  // javax.net.ssl.X509KeyManager
    public PrivateKey getPrivateKey(String s) {
        return this.delegate.getPrivateKey(s);
    }

    @Override  // javax.net.ssl.X509KeyManager
    public String[] getServerAliases(String s, Principal[] arr_principal) {
        return this.delegate.getServerAliases(s, arr_principal);
    }
}

