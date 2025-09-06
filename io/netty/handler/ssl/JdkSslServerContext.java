package io.netty.handler.ssl;

import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.SuppressJava6Requirement;
import java.io.File;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.cert.X509Certificate;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSessionContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509ExtendedTrustManager;

@Deprecated
public final class JdkSslServerContext extends JdkSslContext {
    @Deprecated
    public JdkSslServerContext(File file0, File file1) {
        this(null, file0, file1, null, null, IdentityCipherSuiteFilter.INSTANCE, JdkDefaultApplicationProtocolNegotiator.INSTANCE, 0L, 0L, null);
    }

    @Deprecated
    public JdkSslServerContext(File file0, File file1, String s) {
        this(file0, file1, s, null, IdentityCipherSuiteFilter.INSTANCE, JdkDefaultApplicationProtocolNegotiator.INSTANCE, 0L, 0L);
    }

    @Deprecated
    public JdkSslServerContext(File file0, File file1, String s, Iterable iterable0, CipherSuiteFilter cipherSuiteFilter0, ApplicationProtocolConfig applicationProtocolConfig0, long v, long v1) {
        this(null, file0, file1, s, iterable0, cipherSuiteFilter0, JdkSslContext.toNegotiator(applicationProtocolConfig0, true), v, v1, "pkcs12");
    }

    @Deprecated
    public JdkSslServerContext(File file0, File file1, String s, Iterable iterable0, CipherSuiteFilter cipherSuiteFilter0, JdkApplicationProtocolNegotiator jdkApplicationProtocolNegotiator0, long v, long v1) {
        this(null, file0, file1, s, iterable0, cipherSuiteFilter0, jdkApplicationProtocolNegotiator0, v, v1, "pkcs12");
    }

    @Deprecated
    public JdkSslServerContext(File file0, File file1, String s, Iterable iterable0, Iterable iterable1, long v, long v1) {
        JdkApplicationProtocolNegotiator jdkApplicationProtocolNegotiator0 = JdkSslContext.toNegotiator(SslContext.toApplicationProtocolConfig(iterable1), true);
        this(null, file0, file1, s, iterable0, IdentityCipherSuiteFilter.INSTANCE, jdkApplicationProtocolNegotiator0, v, v1, "pkcs12");
    }

    @Deprecated
    public JdkSslServerContext(File file0, TrustManagerFactory trustManagerFactory0, File file1, File file2, String s, KeyManagerFactory keyManagerFactory0, Iterable iterable0, CipherSuiteFilter cipherSuiteFilter0, ApplicationProtocolConfig applicationProtocolConfig0, long v, long v1) {
        super(JdkSslServerContext.newSSLContext(null, SslContext.toX509CertificatesInternal(file0), trustManagerFactory0, SslContext.toX509CertificatesInternal(file1), SslContext.toPrivateKeyInternal(file2, s), s, keyManagerFactory0, v, v1, null), false, iterable0, cipherSuiteFilter0, applicationProtocolConfig0, ClientAuth.NONE, null, false);
    }

    @Deprecated
    public JdkSslServerContext(File file0, TrustManagerFactory trustManagerFactory0, File file1, File file2, String s, KeyManagerFactory keyManagerFactory0, Iterable iterable0, CipherSuiteFilter cipherSuiteFilter0, JdkApplicationProtocolNegotiator jdkApplicationProtocolNegotiator0, long v, long v1) {
        super(JdkSslServerContext.newSSLContext(null, SslContext.toX509CertificatesInternal(file0), trustManagerFactory0, SslContext.toX509CertificatesInternal(file1), SslContext.toPrivateKeyInternal(file2, s), s, keyManagerFactory0, v, v1, "pkcs12"), false, iterable0, cipherSuiteFilter0, jdkApplicationProtocolNegotiator0, ClientAuth.NONE, null, false);
    }

    public JdkSslServerContext(Provider provider0, File file0, File file1, String s, Iterable iterable0, CipherSuiteFilter cipherSuiteFilter0, JdkApplicationProtocolNegotiator jdkApplicationProtocolNegotiator0, long v, long v1, String s1) {
        super(JdkSslServerContext.newSSLContext(provider0, null, null, SslContext.toX509CertificatesInternal(file0), SslContext.toPrivateKeyInternal(file1, s), s, null, v, v1, s1), false, iterable0, cipherSuiteFilter0, jdkApplicationProtocolNegotiator0, ClientAuth.NONE, null, false);
    }

    public JdkSslServerContext(Provider provider0, X509Certificate[] arr_x509Certificate, TrustManagerFactory trustManagerFactory0, X509Certificate[] arr_x509Certificate1, PrivateKey privateKey0, String s, KeyManagerFactory keyManagerFactory0, Iterable iterable0, CipherSuiteFilter cipherSuiteFilter0, ApplicationProtocolConfig applicationProtocolConfig0, long v, long v1, ClientAuth clientAuth0, String[] arr_s, boolean z, String s1) {
        super(JdkSslServerContext.newSSLContext(provider0, arr_x509Certificate, trustManagerFactory0, arr_x509Certificate1, privateKey0, s, keyManagerFactory0, v, v1, s1), false, iterable0, cipherSuiteFilter0, JdkSslContext.toNegotiator(applicationProtocolConfig0, true), clientAuth0, arr_s, z);
    }

    private static SSLContext newSSLContext(Provider provider0, X509Certificate[] arr_x509Certificate, TrustManagerFactory trustManagerFactory0, X509Certificate[] arr_x509Certificate1, PrivateKey privateKey0, String s, KeyManagerFactory keyManagerFactory0, long v, long v1, String s1) {
        TrustManagerFactory trustManagerFactory1;
        if(privateKey0 == null && keyManagerFactory0 == null) {
            throw new NullPointerException("key, keyManagerFactory");
        }
        try {
            if(arr_x509Certificate != null) {
                trustManagerFactory1 = SslContext.buildTrustManagerFactory(arr_x509Certificate, trustManagerFactory0, s1);
            }
            else if(trustManagerFactory0 == null) {
                trustManagerFactory1 = TrustManagerFactory.getInstance("PKIX");
                trustManagerFactory1.init(null);
            }
            else {
                trustManagerFactory1 = trustManagerFactory0;
            }
            KeyManagerFactory keyManagerFactory1 = privateKey0 == null ? keyManagerFactory0 : SslContext.buildKeyManagerFactory(arr_x509Certificate1, null, privateKey0, s, keyManagerFactory0, null);
            SSLContext sSLContext0 = provider0 == null ? SSLContext.getInstance("TLS") : SSLContext.getInstance("TLS", provider0);
            sSLContext0.init(keyManagerFactory1.getKeyManagers(), JdkSslServerContext.wrapTrustManagerIfNeeded(trustManagerFactory1.getTrustManagers()), null);
            SSLSessionContext sSLSessionContext0 = sSLContext0.getServerSessionContext();
            if(Long.compare(v, 0L) > 0) {
                sSLSessionContext0.setSessionCacheSize(((int)Math.min(v, 0x7FFFFFFFL)));
            }
            if(v1 > 0L) {
                sSLSessionContext0.setSessionTimeout(((int)Math.min(v1, 0x7FFFFFFFL)));
            }
            return sSLContext0;
        }
        catch(Exception exception0) {
            throw exception0 instanceof SSLException ? ((SSLException)exception0) : new SSLException("failed to initialize the server-side SSL context", exception0);
        }
    }

    @SuppressJava6Requirement(reason = "Guarded by java version check")
    private static TrustManager[] wrapTrustManagerIfNeeded(TrustManager[] arr_trustManager) {
        if(PlatformDependent.javaVersion() >= 7) {
            for(int v = 0; v < arr_trustManager.length; ++v) {
                TrustManager trustManager0 = arr_trustManager[v];
                if(trustManager0 instanceof X509ExtendedTrustManager) {
                    arr_trustManager[v] = new EnhancingX509ExtendedTrustManager(((X509ExtendedTrustManager)trustManager0));
                }
            }
        }
        return arr_trustManager;
    }
}

