package io.netty.handler.ssl;

import java.io.File;
import java.security.PrivateKey;
import java.security.cert.X509Certificate;
import java.util.Map.Entry;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLSessionContext;
import javax.net.ssl.TrustManagerFactory;

public final class OpenSslServerContext extends OpenSslContext {
    private final OpenSslServerSessionContext sessionContext;

    @Deprecated
    public OpenSslServerContext(File file0, File file1) {
        this(file0, file1, null);
    }

    @Deprecated
    public OpenSslServerContext(File file0, File file1, String s) {
        this(file0, file1, s, null, IdentityCipherSuiteFilter.INSTANCE, ApplicationProtocolConfig.DISABLED, 0L, 0L);
    }

    @Deprecated
    public OpenSslServerContext(File file0, File file1, String s, Iterable iterable0, ApplicationProtocolConfig applicationProtocolConfig0, long v, long v1) {
        this(file0, file1, s, iterable0, IdentityCipherSuiteFilter.INSTANCE, applicationProtocolConfig0, v, v1);
    }

    @Deprecated
    public OpenSslServerContext(File file0, File file1, String s, Iterable iterable0, CipherSuiteFilter cipherSuiteFilter0, ApplicationProtocolConfig applicationProtocolConfig0, long v, long v1) {
        this(null, null, file0, file1, s, null, iterable0, cipherSuiteFilter0, applicationProtocolConfig0, v, v1);
    }

    @Deprecated
    public OpenSslServerContext(File file0, File file1, String s, Iterable iterable0, Iterable iterable1, long v, long v1) {
        this(file0, file1, s, iterable0, SslContext.toApplicationProtocolConfig(iterable1), v, v1);
    }

    @Deprecated
    public OpenSslServerContext(File file0, File file1, String s, TrustManagerFactory trustManagerFactory0, Iterable iterable0, ApplicationProtocolConfig applicationProtocolConfig0, long v, long v1) {
        this(file0, file1, s, trustManagerFactory0, iterable0, ReferenceCountedOpenSslContext.toNegotiator(applicationProtocolConfig0), v, v1);
    }

    @Deprecated
    public OpenSslServerContext(File file0, File file1, String s, TrustManagerFactory trustManagerFactory0, Iterable iterable0, CipherSuiteFilter cipherSuiteFilter0, ApplicationProtocolConfig applicationProtocolConfig0, long v, long v1) {
        this(null, trustManagerFactory0, file0, file1, s, null, iterable0, cipherSuiteFilter0, ReferenceCountedOpenSslContext.toNegotiator(applicationProtocolConfig0), v, v1);
    }

    @Deprecated
    public OpenSslServerContext(File file0, File file1, String s, TrustManagerFactory trustManagerFactory0, Iterable iterable0, CipherSuiteFilter cipherSuiteFilter0, OpenSslApplicationProtocolNegotiator openSslApplicationProtocolNegotiator0, long v, long v1) {
        this(null, trustManagerFactory0, file0, file1, s, null, iterable0, cipherSuiteFilter0, openSslApplicationProtocolNegotiator0, v, v1);
    }

    @Deprecated
    public OpenSslServerContext(File file0, File file1, String s, TrustManagerFactory trustManagerFactory0, Iterable iterable0, OpenSslApplicationProtocolNegotiator openSslApplicationProtocolNegotiator0, long v, long v1) {
        this(null, trustManagerFactory0, file0, file1, s, null, iterable0, null, openSslApplicationProtocolNegotiator0, v, v1);
    }

    @Deprecated
    public OpenSslServerContext(File file0, TrustManagerFactory trustManagerFactory0, File file1, File file2, String s, KeyManagerFactory keyManagerFactory0, Iterable iterable0, CipherSuiteFilter cipherSuiteFilter0, ApplicationProtocolConfig applicationProtocolConfig0, long v, long v1) {
        this(file0, trustManagerFactory0, file1, file2, s, keyManagerFactory0, iterable0, cipherSuiteFilter0, ReferenceCountedOpenSslContext.toNegotiator(applicationProtocolConfig0), v, v1);
    }

    // 去混淆评级： 低(20)
    @Deprecated
    public OpenSslServerContext(File file0, TrustManagerFactory trustManagerFactory0, File file1, File file2, String s, KeyManagerFactory keyManagerFactory0, Iterable iterable0, CipherSuiteFilter cipherSuiteFilter0, OpenSslApplicationProtocolNegotiator openSslApplicationProtocolNegotiator0, long v, long v1) {
        this(SslContext.toX509CertificatesInternal(file0), trustManagerFactory0, SslContext.toX509CertificatesInternal(file1), SslContext.toPrivateKeyInternal(file2, s), s, keyManagerFactory0, iterable0, cipherSuiteFilter0, openSslApplicationProtocolNegotiator0, v, v1, ClientAuth.NONE, null, false, false, "pkcs12", new Map.Entry[0]);
    }

    public OpenSslServerContext(X509Certificate[] arr_x509Certificate, TrustManagerFactory trustManagerFactory0, X509Certificate[] arr_x509Certificate1, PrivateKey privateKey0, String s, KeyManagerFactory keyManagerFactory0, Iterable iterable0, CipherSuiteFilter cipherSuiteFilter0, ApplicationProtocolConfig applicationProtocolConfig0, long v, long v1, ClientAuth clientAuth0, String[] arr_s, boolean z, boolean z1, String s1, Map.Entry[] arr_map$Entry) {
        this(arr_x509Certificate, trustManagerFactory0, arr_x509Certificate1, privateKey0, s, keyManagerFactory0, iterable0, cipherSuiteFilter0, ReferenceCountedOpenSslContext.toNegotiator(applicationProtocolConfig0), v, v1, clientAuth0, arr_s, z, z1, s1, arr_map$Entry);
    }

    private OpenSslServerContext(X509Certificate[] arr_x509Certificate, TrustManagerFactory trustManagerFactory0, X509Certificate[] arr_x509Certificate1, PrivateKey privateKey0, String s, KeyManagerFactory keyManagerFactory0, Iterable iterable0, CipherSuiteFilter cipherSuiteFilter0, OpenSslApplicationProtocolNegotiator openSslApplicationProtocolNegotiator0, long v, long v1, ClientAuth clientAuth0, String[] arr_s, boolean z, boolean z1, String s1, Map.Entry[] arr_map$Entry) {
        super(iterable0, cipherSuiteFilter0, openSslApplicationProtocolNegotiator0, 1, arr_x509Certificate1, clientAuth0, arr_s, z, z1, arr_map$Entry);
        try {
            OpenSslKeyMaterialProvider.validateKeyMaterialSupported(arr_x509Certificate1, privateKey0, s);
            this.sessionContext = ReferenceCountedOpenSslServerContext.newSessionContext(this, this.ctx, this.engineMap, arr_x509Certificate, trustManagerFactory0, arr_x509Certificate1, privateKey0, s, keyManagerFactory0, s1, v, v1);
        }
        catch(Throwable throwable0) {
            this.release();
            throw throwable0;
        }
    }

    public OpenSslServerSessionContext sessionContext() {
        return this.sessionContext;
    }

    @Override  // io.netty.handler.ssl.ReferenceCountedOpenSslContext
    public OpenSslSessionContext sessionContext() {
        return this.sessionContext();
    }

    @Override  // io.netty.handler.ssl.ReferenceCountedOpenSslContext
    public SSLSessionContext sessionContext() {
        return this.sessionContext();
    }
}

