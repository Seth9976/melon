package io.netty.handler.ssl;

import java.io.File;
import java.security.PrivateKey;
import java.security.cert.X509Certificate;
import java.util.Map.Entry;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLSessionContext;
import javax.net.ssl.TrustManagerFactory;

public final class OpenSslClientContext extends OpenSslContext {
    private final OpenSslSessionContext sessionContext;

    @Deprecated
    public OpenSslClientContext() {
        this(null, null, null, null, null, null, null, IdentityCipherSuiteFilter.INSTANCE, null, 0L, 0L);
    }

    @Deprecated
    public OpenSslClientContext(File file0) {
        this(file0, null);
    }

    @Deprecated
    public OpenSslClientContext(File file0, TrustManagerFactory trustManagerFactory0) {
        this(file0, trustManagerFactory0, null, null, null, null, null, IdentityCipherSuiteFilter.INSTANCE, null, 0L, 0L);
    }

    @Deprecated
    public OpenSslClientContext(File file0, TrustManagerFactory trustManagerFactory0, File file1, File file2, String s, KeyManagerFactory keyManagerFactory0, Iterable iterable0, CipherSuiteFilter cipherSuiteFilter0, ApplicationProtocolConfig applicationProtocolConfig0, long v, long v1) {
        this(SslContext.toX509CertificatesInternal(file0), trustManagerFactory0, SslContext.toX509CertificatesInternal(file1), SslContext.toPrivateKeyInternal(file2, s), s, keyManagerFactory0, iterable0, cipherSuiteFilter0, applicationProtocolConfig0, null, v, v1, false, "pkcs12", new Map.Entry[0]);
    }

    @Deprecated
    public OpenSslClientContext(File file0, TrustManagerFactory trustManagerFactory0, Iterable iterable0, ApplicationProtocolConfig applicationProtocolConfig0, long v, long v1) {
        this(file0, trustManagerFactory0, null, null, null, null, iterable0, IdentityCipherSuiteFilter.INSTANCE, applicationProtocolConfig0, v, v1);
    }

    @Deprecated
    public OpenSslClientContext(File file0, TrustManagerFactory trustManagerFactory0, Iterable iterable0, CipherSuiteFilter cipherSuiteFilter0, ApplicationProtocolConfig applicationProtocolConfig0, long v, long v1) {
        this(file0, trustManagerFactory0, null, null, null, null, iterable0, cipherSuiteFilter0, applicationProtocolConfig0, v, v1);
    }

    @Deprecated
    public OpenSslClientContext(TrustManagerFactory trustManagerFactory0) {
        this(null, trustManagerFactory0);
    }

    public OpenSslClientContext(X509Certificate[] arr_x509Certificate, TrustManagerFactory trustManagerFactory0, X509Certificate[] arr_x509Certificate1, PrivateKey privateKey0, String s, KeyManagerFactory keyManagerFactory0, Iterable iterable0, CipherSuiteFilter cipherSuiteFilter0, ApplicationProtocolConfig applicationProtocolConfig0, String[] arr_s, long v, long v1, boolean z, String s1, Map.Entry[] arr_map$Entry) {
        super(iterable0, cipherSuiteFilter0, applicationProtocolConfig0, 0, arr_x509Certificate1, ClientAuth.NONE, arr_s, false, z, arr_map$Entry);
        try {
            OpenSslKeyMaterialProvider.validateKeyMaterialSupported(arr_x509Certificate1, privateKey0, s);
            this.sessionContext = ReferenceCountedOpenSslClientContext.newSessionContext(this, this.ctx, this.engineMap, arr_x509Certificate, trustManagerFactory0, arr_x509Certificate1, privateKey0, s, keyManagerFactory0, s1, v, v1);
        }
        catch(Throwable throwable0) {
            this.release();
            throw throwable0;
        }
    }

    @Override  // io.netty.handler.ssl.ReferenceCountedOpenSslContext
    public OpenSslSessionContext sessionContext() {
        return this.sessionContext;
    }

    @Override  // io.netty.handler.ssl.ReferenceCountedOpenSslContext
    public SSLSessionContext sessionContext() {
        return this.sessionContext();
    }
}

