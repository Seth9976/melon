package io.netty.handler.ssl;

import java.io.File;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.cert.X509Certificate;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSessionContext;
import javax.net.ssl.TrustManagerFactory;

@Deprecated
public final class JdkSslClientContext extends JdkSslContext {
    @Deprecated
    public JdkSslClientContext() {
        this(null, null);
    }

    @Deprecated
    public JdkSslClientContext(File file0) {
        this(file0, null);
    }

    @Deprecated
    public JdkSslClientContext(File file0, TrustManagerFactory trustManagerFactory0) {
        this(file0, trustManagerFactory0, null, IdentityCipherSuiteFilter.INSTANCE, JdkDefaultApplicationProtocolNegotiator.INSTANCE, 0L, 0L);
    }

    @Deprecated
    public JdkSslClientContext(File file0, TrustManagerFactory trustManagerFactory0, File file1, File file2, String s, KeyManagerFactory keyManagerFactory0, Iterable iterable0, CipherSuiteFilter cipherSuiteFilter0, ApplicationProtocolConfig applicationProtocolConfig0, long v, long v1) {
        this(file0, trustManagerFactory0, file1, file2, s, keyManagerFactory0, iterable0, cipherSuiteFilter0, JdkSslContext.toNegotiator(applicationProtocolConfig0, false), v, v1);
    }

    @Deprecated
    public JdkSslClientContext(File file0, TrustManagerFactory trustManagerFactory0, File file1, File file2, String s, KeyManagerFactory keyManagerFactory0, Iterable iterable0, CipherSuiteFilter cipherSuiteFilter0, JdkApplicationProtocolNegotiator jdkApplicationProtocolNegotiator0, long v, long v1) {
        super(JdkSslClientContext.newSSLContext(null, SslContext.toX509CertificatesInternal(file0), trustManagerFactory0, SslContext.toX509CertificatesInternal(file1), SslContext.toPrivateKeyInternal(file2, s), s, keyManagerFactory0, v, v1, "pkcs12"), true, iterable0, cipherSuiteFilter0, jdkApplicationProtocolNegotiator0, ClientAuth.NONE, null, false);
    }

    @Deprecated
    public JdkSslClientContext(File file0, TrustManagerFactory trustManagerFactory0, Iterable iterable0, CipherSuiteFilter cipherSuiteFilter0, ApplicationProtocolConfig applicationProtocolConfig0, long v, long v1) {
        this(file0, trustManagerFactory0, iterable0, cipherSuiteFilter0, JdkSslContext.toNegotiator(applicationProtocolConfig0, false), v, v1);
    }

    @Deprecated
    public JdkSslClientContext(File file0, TrustManagerFactory trustManagerFactory0, Iterable iterable0, CipherSuiteFilter cipherSuiteFilter0, JdkApplicationProtocolNegotiator jdkApplicationProtocolNegotiator0, long v, long v1) {
        this(null, file0, trustManagerFactory0, iterable0, cipherSuiteFilter0, jdkApplicationProtocolNegotiator0, v, v1);
    }

    @Deprecated
    public JdkSslClientContext(File file0, TrustManagerFactory trustManagerFactory0, Iterable iterable0, Iterable iterable1, long v, long v1) {
        JdkApplicationProtocolNegotiator jdkApplicationProtocolNegotiator0 = JdkSslContext.toNegotiator(SslContext.toApplicationProtocolConfig(iterable1), false);
        this(file0, trustManagerFactory0, iterable0, IdentityCipherSuiteFilter.INSTANCE, jdkApplicationProtocolNegotiator0, v, v1);
    }

    public JdkSslClientContext(Provider provider0, File file0, TrustManagerFactory trustManagerFactory0, Iterable iterable0, CipherSuiteFilter cipherSuiteFilter0, JdkApplicationProtocolNegotiator jdkApplicationProtocolNegotiator0, long v, long v1) {
        super(JdkSslClientContext.newSSLContext(provider0, SslContext.toX509CertificatesInternal(file0), trustManagerFactory0, null, null, null, null, v, v1, "pkcs12"), true, iterable0, cipherSuiteFilter0, jdkApplicationProtocolNegotiator0, ClientAuth.NONE, null, false);
    }

    public JdkSslClientContext(Provider provider0, X509Certificate[] arr_x509Certificate, TrustManagerFactory trustManagerFactory0, X509Certificate[] arr_x509Certificate1, PrivateKey privateKey0, String s, KeyManagerFactory keyManagerFactory0, Iterable iterable0, CipherSuiteFilter cipherSuiteFilter0, ApplicationProtocolConfig applicationProtocolConfig0, String[] arr_s, long v, long v1, String s1) {
        super(JdkSslClientContext.newSSLContext(provider0, arr_x509Certificate, trustManagerFactory0, arr_x509Certificate1, privateKey0, s, keyManagerFactory0, v, v1, s1), true, iterable0, cipherSuiteFilter0, JdkSslContext.toNegotiator(applicationProtocolConfig0, false), ClientAuth.NONE, arr_s, false);
    }

    @Deprecated
    public JdkSslClientContext(TrustManagerFactory trustManagerFactory0) {
        this(null, trustManagerFactory0);
    }

    private static SSLContext newSSLContext(Provider provider0, X509Certificate[] arr_x509Certificate, TrustManagerFactory trustManagerFactory0, X509Certificate[] arr_x509Certificate1, PrivateKey privateKey0, String s, KeyManagerFactory keyManagerFactory0, long v, long v1, String s1) {
        try {
            if(arr_x509Certificate != null) {
                trustManagerFactory0 = SslContext.buildTrustManagerFactory(arr_x509Certificate, trustManagerFactory0, s1);
            }
            KeyManagerFactory keyManagerFactory1 = arr_x509Certificate1 == null ? keyManagerFactory0 : SslContext.buildKeyManagerFactory(arr_x509Certificate1, null, privateKey0, s, keyManagerFactory0, s1);
            SSLContext sSLContext0 = provider0 == null ? SSLContext.getInstance("TLS") : SSLContext.getInstance("TLS", provider0);
            sSLContext0.init((keyManagerFactory1 == null ? null : keyManagerFactory1.getKeyManagers()), (trustManagerFactory0 == null ? null : trustManagerFactory0.getTrustManagers()), null);
            SSLSessionContext sSLSessionContext0 = sSLContext0.getClientSessionContext();
            if(Long.compare(v, 0L) > 0) {
                sSLSessionContext0.setSessionCacheSize(((int)Math.min(v, 0x7FFFFFFFL)));
            }
            if(v1 > 0L) {
                sSLSessionContext0.setSessionTimeout(((int)Math.min(v1, 0x7FFFFFFFL)));
            }
            return sSLContext0;
        }
        catch(Exception exception0) {
            throw exception0 instanceof SSLException ? ((SSLException)exception0) : new SSLException("failed to initialize the client-side SSL context", exception0);
        }
    }
}

