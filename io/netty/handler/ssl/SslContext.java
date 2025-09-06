package io.netty.handler.ssl;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.ByteBufInputStream;
import io.netty.util.AttributeMap;
import io.netty.util.DefaultAttributeMap;
import io.netty.util.internal.EmptyArrays;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyFactory;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.List;
import java.util.Map.Entry;
import java.util.concurrent.Executor;
import javax.crypto.Cipher;
import javax.crypto.EncryptedPrivateKeyInfo;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSessionContext;
import javax.net.ssl.TrustManagerFactory;

public abstract class SslContext {
    static final String ALIAS = "key";
    private static final String OID_PKCS5_PBES2 = "1.2.840.113549.1.5.13";
    private static final String PBES2 = "PBES2";
    static final CertificateFactory X509_CERT_FACTORY;
    private final AttributeMap attributes;
    private final boolean startTls;

    static {
        try {
            SslContext.X509_CERT_FACTORY = CertificateFactory.getInstance("X.509");
        }
        catch(CertificateException certificateException0) {
            throw new IllegalStateException("unable to instance X.509 CertificateFactory", certificateException0);
        }
    }

    public SslContext() {
        this(false);
    }

    public SslContext(boolean z) {
        this.attributes = new DefaultAttributeMap();
        this.startTls = z;
    }

    public abstract ApplicationProtocolNegotiator applicationProtocolNegotiator();

    public final AttributeMap attributes() {
        return this.attributes;
    }

    public static KeyManagerFactory buildKeyManagerFactory(KeyStore keyStore0, String s, char[] arr_c, KeyManagerFactory keyManagerFactory0) {
        if(keyManagerFactory0 == null) {
            if(s == null) {
                s = "SunX509";
            }
            keyManagerFactory0 = KeyManagerFactory.getInstance(s);
        }
        keyManagerFactory0.init(keyStore0, arr_c);
        return keyManagerFactory0;
    }

    public static KeyManagerFactory buildKeyManagerFactory(X509Certificate[] arr_x509Certificate, String s, PrivateKey privateKey0, String s1, KeyManagerFactory keyManagerFactory0, String s2) {
        if(s == null) {
            s = "SunX509";
        }
        char[] arr_c = SslContext.keyStorePassword(s1);
        return SslContext.buildKeyManagerFactory(SslContext.buildKeyStore(arr_x509Certificate, privateKey0, arr_c, s2), s, arr_c, keyManagerFactory0);
    }

    public static KeyStore buildKeyStore(X509Certificate[] arr_x509Certificate, PrivateKey privateKey0, char[] arr_c, String s) {
        if(s == null) {
            s = "pkcs12";
        }
        KeyStore keyStore0 = KeyStore.getInstance(s);
        keyStore0.load(null, null);
        keyStore0.setKeyEntry("key", privateKey0, arr_c, arr_x509Certificate);
        return keyStore0;
    }

    @Deprecated
    public static TrustManagerFactory buildTrustManagerFactory(File file0, TrustManagerFactory trustManagerFactory0) {
        return SslContext.buildTrustManagerFactory(file0, trustManagerFactory0, null);
    }

    public static TrustManagerFactory buildTrustManagerFactory(File file0, TrustManagerFactory trustManagerFactory0, String s) {
        return SslContext.buildTrustManagerFactory(SslContext.toX509Certificates(file0), trustManagerFactory0, s);
    }

    public static TrustManagerFactory buildTrustManagerFactory(X509Certificate[] arr_x509Certificate, TrustManagerFactory trustManagerFactory0, String s) {
        if(s == null) {
            s = "pkcs12";
        }
        KeyStore keyStore0 = KeyStore.getInstance(s);
        keyStore0.load(null, null);
        int v1 = 1;
        for(int v = 0; v < arr_x509Certificate.length; ++v) {
            keyStore0.setCertificateEntry(Integer.toString(v1), arr_x509Certificate[v]);
            ++v1;
        }
        if(trustManagerFactory0 == null) {
            trustManagerFactory0 = TrustManagerFactory.getInstance("PKIX");
        }
        trustManagerFactory0.init(keyStore0);
        return trustManagerFactory0;
    }

    public abstract List cipherSuites();

    public static SslProvider defaultClientProvider() {
        return SslContext.defaultProvider();
    }

    // 去混淆评级： 低(40)
    private static SslProvider defaultProvider() {
        return SslProvider.OPENSSL;
    }

    public static SslProvider defaultServerProvider() {
        return SslContext.defaultProvider();
    }

    @Deprecated
    public static PKCS8EncodedKeySpec generateKeySpec(char[] arr_c, byte[] arr_b) {
        if(arr_c == null) {
            return new PKCS8EncodedKeySpec(arr_b);
        }
        EncryptedPrivateKeyInfo encryptedPrivateKeyInfo0 = new EncryptedPrivateKeyInfo(arr_b);
        String s = SslContext.getPBEAlgorithm(encryptedPrivateKeyInfo0);
        SecretKey secretKey0 = SecretKeyFactory.getInstance(s).generateSecret(new PBEKeySpec(arr_c));
        Cipher cipher0 = Cipher.getInstance(s);
        cipher0.init(2, secretKey0, encryptedPrivateKeyInfo0.getAlgParameters());
        return encryptedPrivateKeyInfo0.getKeySpec(cipher0);
    }

    private static X509Certificate[] getCertificatesFromBuffers(ByteBuf[] arr_byteBuf) {
        CertificateFactory certificateFactory0 = CertificateFactory.getInstance("X.509");
        X509Certificate[] arr_x509Certificate = new X509Certificate[arr_byteBuf.length];
        try {
            for(int v1 = 0; v1 < arr_byteBuf.length; ++v1) {
                ByteBufInputStream byteBufInputStream0 = new ByteBufInputStream(arr_byteBuf[v1], false);
                try {
                    arr_x509Certificate[v1] = (X509Certificate)certificateFactory0.generateCertificate(byteBufInputStream0);
                }
                catch(Throwable throwable0) {
                    try {
                        byteBufInputStream0.close();
                    }
                    catch(IOException iOException0) {
                        throw new RuntimeException(iOException0);
                    }
                    throw throwable0;
                }
                try {
                    byteBufInputStream0.close();
                }
                catch(IOException iOException1) {
                    throw new RuntimeException(iOException1);
                }
            }
            return arr_x509Certificate;
        }
        finally {
            for(int v = 0; v < arr_byteBuf.length; ++v) {
                arr_byteBuf[v].release();
            }
        }
    }

    private static String getPBEAlgorithm(EncryptedPrivateKeyInfo encryptedPrivateKeyInfo0) {
        encryptedPrivateKeyInfo0.getAlgParameters();
        encryptedPrivateKeyInfo0.getAlgName();
        return encryptedPrivateKeyInfo0.getAlgName();
    }

    private static PrivateKey getPrivateKeyFromByteBuffer(ByteBuf byteBuf0, String s) {
        byte[] arr_b = new byte[byteBuf0.readableBytes()];
        byteBuf0.readBytes(arr_b).release();
        PKCS8EncodedKeySpec pKCS8EncodedKeySpec0 = SslContext.generateKeySpec((s == null ? null : s.toCharArray()), arr_b);
        try {
            return KeyFactory.getInstance("RSA").generatePrivate(pKCS8EncodedKeySpec0);
        }
        catch(InvalidKeySpecException unused_ex) {
            try {
                return KeyFactory.getInstance("DSA").generatePrivate(pKCS8EncodedKeySpec0);
            }
            catch(InvalidKeySpecException unused_ex) {
                try {
                    return KeyFactory.getInstance("EC").generatePrivate(pKCS8EncodedKeySpec0);
                }
                catch(InvalidKeySpecException invalidKeySpecException0) {
                    throw new InvalidKeySpecException("Neither RSA, DSA nor EC worked", invalidKeySpecException0);
                }
            }
        }
    }

    public abstract boolean isClient();

    public final boolean isServer() {
        return !this.isClient();
    }

    public static char[] keyStorePassword(String s) {
        return s == null ? EmptyArrays.EMPTY_CHARS : s.toCharArray();
    }

    @Deprecated
    public static SslContext newClientContext() {
        return SslContext.newClientContext(null, null, null);
    }

    @Deprecated
    public static SslContext newClientContext(SslProvider sslProvider0) {
        return SslContext.newClientContext(sslProvider0, null, null);
    }

    @Deprecated
    public static SslContext newClientContext(SslProvider sslProvider0, File file0) {
        return SslContext.newClientContext(sslProvider0, file0, null);
    }

    @Deprecated
    public static SslContext newClientContext(SslProvider sslProvider0, File file0, TrustManagerFactory trustManagerFactory0) {
        return SslContext.newClientContext(sslProvider0, file0, trustManagerFactory0, null, IdentityCipherSuiteFilter.INSTANCE, null, 0L, 0L);
    }

    @Deprecated
    public static SslContext newClientContext(SslProvider sslProvider0, File file0, TrustManagerFactory trustManagerFactory0, File file1, File file2, String s, KeyManagerFactory keyManagerFactory0, Iterable iterable0, CipherSuiteFilter cipherSuiteFilter0, ApplicationProtocolConfig applicationProtocolConfig0, long v, long v1) {
        try {
            return SslContext.newClientContextInternal(sslProvider0, null, SslContext.toX509Certificates(file0), trustManagerFactory0, SslContext.toX509Certificates(file1), SslContext.toPrivateKey(file2, s), s, keyManagerFactory0, iterable0, cipherSuiteFilter0, applicationProtocolConfig0, null, v, v1, false, "pkcs12", new Map.Entry[0]);
        }
        catch(Exception exception0) {
            throw exception0 instanceof SSLException ? ((SSLException)exception0) : new SSLException("failed to initialize the client-side SSL context", exception0);
        }
    }

    @Deprecated
    public static SslContext newClientContext(SslProvider sslProvider0, File file0, TrustManagerFactory trustManagerFactory0, Iterable iterable0, CipherSuiteFilter cipherSuiteFilter0, ApplicationProtocolConfig applicationProtocolConfig0, long v, long v1) {
        return SslContext.newClientContext(sslProvider0, file0, trustManagerFactory0, null, null, null, null, iterable0, cipherSuiteFilter0, applicationProtocolConfig0, v, v1);
    }

    @Deprecated
    public static SslContext newClientContext(SslProvider sslProvider0, File file0, TrustManagerFactory trustManagerFactory0, Iterable iterable0, Iterable iterable1, long v, long v1) {
        ApplicationProtocolConfig applicationProtocolConfig0 = SslContext.toApplicationProtocolConfig(iterable1);
        return SslContext.newClientContext(sslProvider0, file0, trustManagerFactory0, null, null, null, null, iterable0, IdentityCipherSuiteFilter.INSTANCE, applicationProtocolConfig0, v, v1);
    }

    @Deprecated
    public static SslContext newClientContext(SslProvider sslProvider0, TrustManagerFactory trustManagerFactory0) {
        return SslContext.newClientContext(sslProvider0, null, trustManagerFactory0);
    }

    @Deprecated
    public static SslContext newClientContext(File file0) {
        return SslContext.newClientContext(null, file0);
    }

    @Deprecated
    public static SslContext newClientContext(File file0, TrustManagerFactory trustManagerFactory0) {
        return SslContext.newClientContext(null, file0, trustManagerFactory0);
    }

    @Deprecated
    public static SslContext newClientContext(File file0, TrustManagerFactory trustManagerFactory0, Iterable iterable0, CipherSuiteFilter cipherSuiteFilter0, ApplicationProtocolConfig applicationProtocolConfig0, long v, long v1) {
        return SslContext.newClientContext(null, file0, trustManagerFactory0, iterable0, cipherSuiteFilter0, applicationProtocolConfig0, v, v1);
    }

    @Deprecated
    public static SslContext newClientContext(File file0, TrustManagerFactory trustManagerFactory0, Iterable iterable0, Iterable iterable1, long v, long v1) {
        return SslContext.newClientContext(null, file0, trustManagerFactory0, iterable0, iterable1, v, v1);
    }

    @Deprecated
    public static SslContext newClientContext(TrustManagerFactory trustManagerFactory0) {
        return SslContext.newClientContext(null, null, trustManagerFactory0);
    }

    public static SslContext newClientContextInternal(SslProvider sslProvider0, Provider provider0, X509Certificate[] arr_x509Certificate, TrustManagerFactory trustManagerFactory0, X509Certificate[] arr_x509Certificate1, PrivateKey privateKey0, String s, KeyManagerFactory keyManagerFactory0, Iterable iterable0, CipherSuiteFilter cipherSuiteFilter0, ApplicationProtocolConfig applicationProtocolConfig0, String[] arr_s, long v, long v1, boolean z, String s1, Map.Entry[] arr_map$Entry) {
        SslProvider sslProvider1 = sslProvider0 == null ? SslContext.defaultClientProvider() : sslProvider0;
        switch(io.netty.handler.ssl.SslContext.1.$SwitchMap$io$netty$handler$ssl$SslProvider[sslProvider1.ordinal()]) {
            case 1: {
                if(z) {
                    throw new IllegalArgumentException("OCSP is not supported with this SslProvider: " + sslProvider1);
                }
                return new JdkSslClientContext(provider0, arr_x509Certificate, trustManagerFactory0, arr_x509Certificate1, privateKey0, s, keyManagerFactory0, iterable0, cipherSuiteFilter0, applicationProtocolConfig0, arr_s, v, v1, s1);
            }
            case 2: {
                SslContext.verifyNullSslContextProvider(sslProvider1, provider0);
                OpenSsl.ensureAvailability();
                return new OpenSslClientContext(arr_x509Certificate, trustManagerFactory0, arr_x509Certificate1, privateKey0, s, keyManagerFactory0, iterable0, cipherSuiteFilter0, applicationProtocolConfig0, arr_s, v, v1, z, s1, arr_map$Entry);
            }
            case 3: {
                SslContext.verifyNullSslContextProvider(sslProvider1, provider0);
                OpenSsl.ensureAvailability();
                return new ReferenceCountedOpenSslClientContext(arr_x509Certificate, trustManagerFactory0, arr_x509Certificate1, privateKey0, s, keyManagerFactory0, iterable0, cipherSuiteFilter0, applicationProtocolConfig0, arr_s, v, v1, z, s1, arr_map$Entry);
            }
            default: {
                throw new Error(sslProvider1.toString());
            }
        }
    }

    public abstract SSLEngine newEngine(ByteBufAllocator arg1);

    public abstract SSLEngine newEngine(ByteBufAllocator arg1, String arg2, int arg3);

    public final SslHandler newHandler(ByteBufAllocator byteBufAllocator0) {
        return this.newHandler(byteBufAllocator0, this.startTls);
    }

    public final SslHandler newHandler(ByteBufAllocator byteBufAllocator0, String s, int v) {
        return this.newHandler(byteBufAllocator0, s, v, this.startTls);
    }

    public SslHandler newHandler(ByteBufAllocator byteBufAllocator0, String s, int v, Executor executor0) {
        return this.newHandler(byteBufAllocator0, s, v, this.startTls, executor0);
    }

    public SslHandler newHandler(ByteBufAllocator byteBufAllocator0, String s, int v, boolean z) {
        return new SslHandler(this.newEngine(byteBufAllocator0, s, v), z);
    }

    public SslHandler newHandler(ByteBufAllocator byteBufAllocator0, String s, int v, boolean z, Executor executor0) {
        return new SslHandler(this.newEngine(byteBufAllocator0, s, v), z, executor0);
    }

    public SslHandler newHandler(ByteBufAllocator byteBufAllocator0, Executor executor0) {
        return this.newHandler(byteBufAllocator0, this.startTls, executor0);
    }

    public SslHandler newHandler(ByteBufAllocator byteBufAllocator0, boolean z) {
        return new SslHandler(this.newEngine(byteBufAllocator0), z);
    }

    public SslHandler newHandler(ByteBufAllocator byteBufAllocator0, boolean z, Executor executor0) {
        return new SslHandler(this.newEngine(byteBufAllocator0), z, executor0);
    }

    @Deprecated
    public static SslContext newServerContext(SslProvider sslProvider0, File file0, File file1) {
        return SslContext.newServerContext(sslProvider0, file0, file1, null);
    }

    @Deprecated
    public static SslContext newServerContext(SslProvider sslProvider0, File file0, File file1, String s) {
        return SslContext.newServerContext(sslProvider0, file0, file1, s, null, IdentityCipherSuiteFilter.INSTANCE, null, 0L, 0L);
    }

    // 去混淆评级： 低(20)
    @Deprecated
    public static SslContext newServerContext(SslProvider sslProvider0, File file0, File file1, String s, Iterable iterable0, CipherSuiteFilter cipherSuiteFilter0, ApplicationProtocolConfig applicationProtocolConfig0, long v, long v1) {
        return SslContext.newServerContext(sslProvider0, null, null, file0, file1, s, null, iterable0, cipherSuiteFilter0, applicationProtocolConfig0, v, v1, "pkcs12");
    }

    @Deprecated
    public static SslContext newServerContext(SslProvider sslProvider0, File file0, File file1, String s, Iterable iterable0, Iterable iterable1, long v, long v1) {
        ApplicationProtocolConfig applicationProtocolConfig0 = SslContext.toApplicationProtocolConfig(iterable1);
        return SslContext.newServerContext(sslProvider0, file0, file1, s, iterable0, IdentityCipherSuiteFilter.INSTANCE, applicationProtocolConfig0, v, v1);
    }

    @Deprecated
    public static SslContext newServerContext(SslProvider sslProvider0, File file0, File file1, String s, TrustManagerFactory trustManagerFactory0, Iterable iterable0, Iterable iterable1, long v, long v1) {
        ApplicationProtocolConfig applicationProtocolConfig0 = SslContext.toApplicationProtocolConfig(iterable1);
        return SslContext.newServerContext(sslProvider0, null, trustManagerFactory0, file0, file1, s, null, iterable0, IdentityCipherSuiteFilter.INSTANCE, applicationProtocolConfig0, v, v1);
    }

    // 去混淆评级： 低(20)
    @Deprecated
    public static SslContext newServerContext(SslProvider sslProvider0, File file0, TrustManagerFactory trustManagerFactory0, File file1, File file2, String s, KeyManagerFactory keyManagerFactory0, Iterable iterable0, CipherSuiteFilter cipherSuiteFilter0, ApplicationProtocolConfig applicationProtocolConfig0, long v, long v1) {
        return SslContext.newServerContext(sslProvider0, file0, trustManagerFactory0, file1, file2, s, keyManagerFactory0, iterable0, cipherSuiteFilter0, applicationProtocolConfig0, v, v1, "pkcs12");
    }

    public static SslContext newServerContext(SslProvider sslProvider0, File file0, TrustManagerFactory trustManagerFactory0, File file1, File file2, String s, KeyManagerFactory keyManagerFactory0, Iterable iterable0, CipherSuiteFilter cipherSuiteFilter0, ApplicationProtocolConfig applicationProtocolConfig0, long v, long v1, String s1) {
        try {
            return SslContext.newServerContextInternal(sslProvider0, null, SslContext.toX509Certificates(file0), trustManagerFactory0, SslContext.toX509Certificates(file1), SslContext.toPrivateKey(file2, s), s, keyManagerFactory0, iterable0, cipherSuiteFilter0, applicationProtocolConfig0, v, v1, ClientAuth.NONE, null, false, false, s1, new Map.Entry[0]);
        }
        catch(Exception exception0) {
            throw exception0 instanceof SSLException ? ((SSLException)exception0) : new SSLException("failed to initialize the server-side SSL context", exception0);
        }
    }

    @Deprecated
    public static SslContext newServerContext(File file0, File file1) {
        return SslContext.newServerContext(file0, file1, null);
    }

    @Deprecated
    public static SslContext newServerContext(File file0, File file1, String s) {
        return SslContext.newServerContext(null, file0, file1, s);
    }

    @Deprecated
    public static SslContext newServerContext(File file0, File file1, String s, Iterable iterable0, CipherSuiteFilter cipherSuiteFilter0, ApplicationProtocolConfig applicationProtocolConfig0, long v, long v1) {
        return SslContext.newServerContext(null, file0, file1, s, iterable0, cipherSuiteFilter0, applicationProtocolConfig0, v, v1);
    }

    @Deprecated
    public static SslContext newServerContext(File file0, File file1, String s, Iterable iterable0, Iterable iterable1, long v, long v1) {
        return SslContext.newServerContext(null, file0, file1, s, iterable0, iterable1, v, v1);
    }

    public static SslContext newServerContextInternal(SslProvider sslProvider0, Provider provider0, X509Certificate[] arr_x509Certificate, TrustManagerFactory trustManagerFactory0, X509Certificate[] arr_x509Certificate1, PrivateKey privateKey0, String s, KeyManagerFactory keyManagerFactory0, Iterable iterable0, CipherSuiteFilter cipherSuiteFilter0, ApplicationProtocolConfig applicationProtocolConfig0, long v, long v1, ClientAuth clientAuth0, String[] arr_s, boolean z, boolean z1, String s1, Map.Entry[] arr_map$Entry) {
        SslProvider sslProvider1 = sslProvider0 == null ? SslContext.defaultServerProvider() : sslProvider0;
        switch(io.netty.handler.ssl.SslContext.1.$SwitchMap$io$netty$handler$ssl$SslProvider[sslProvider1.ordinal()]) {
            case 1: {
                if(z1) {
                    throw new IllegalArgumentException("OCSP is not supported with this SslProvider: " + sslProvider1);
                }
                return new JdkSslServerContext(provider0, arr_x509Certificate, trustManagerFactory0, arr_x509Certificate1, privateKey0, s, keyManagerFactory0, iterable0, cipherSuiteFilter0, applicationProtocolConfig0, v, v1, clientAuth0, arr_s, z, s1);
            }
            case 2: {
                SslContext.verifyNullSslContextProvider(sslProvider1, provider0);
                return new OpenSslServerContext(arr_x509Certificate, trustManagerFactory0, arr_x509Certificate1, privateKey0, s, keyManagerFactory0, iterable0, cipherSuiteFilter0, applicationProtocolConfig0, v, v1, clientAuth0, arr_s, z, z1, s1, arr_map$Entry);
            }
            case 3: {
                SslContext.verifyNullSslContextProvider(sslProvider1, provider0);
                return new ReferenceCountedOpenSslServerContext(arr_x509Certificate, trustManagerFactory0, arr_x509Certificate1, privateKey0, s, keyManagerFactory0, iterable0, cipherSuiteFilter0, applicationProtocolConfig0, v, v1, clientAuth0, arr_s, z, z1, s1, arr_map$Entry);
            }
            default: {
                throw new Error(sslProvider1.toString());
            }
        }
    }

    @Deprecated
    public final List nextProtocols() {
        return this.applicationProtocolNegotiator().protocols();
    }

    public long sessionCacheSize() {
        return (long)this.sessionContext().getSessionCacheSize();
    }

    public abstract SSLSessionContext sessionContext();

    public long sessionTimeout() {
        return (long)this.sessionContext().getSessionTimeout();
    }

    public static ApplicationProtocolConfig toApplicationProtocolConfig(Iterable iterable0) {
        return iterable0 == null ? ApplicationProtocolConfig.DISABLED : new ApplicationProtocolConfig(Protocol.NPN_AND_ALPN, SelectorFailureBehavior.CHOOSE_MY_LAST_PROTOCOL, SelectedListenerFailureBehavior.ACCEPT, iterable0);
    }

    public static PrivateKey toPrivateKey(File file0, String s) {
        return SslContext.toPrivateKey(file0, s, true);
    }

    public static PrivateKey toPrivateKey(File file0, String s, boolean z) {
        if(file0 == null) {
            return null;
        }
        if(z && BouncyCastlePemReader.isAvailable()) {
            PrivateKey privateKey0 = BouncyCastlePemReader.getPrivateKey(file0, s);
            return privateKey0 == null ? SslContext.getPrivateKeyFromByteBuffer(PemReader.readPrivateKey(file0), s) : privateKey0;
        }
        return SslContext.getPrivateKeyFromByteBuffer(PemReader.readPrivateKey(file0), s);
    }

    public static PrivateKey toPrivateKey(InputStream inputStream0, String s) {
        if(inputStream0 == null) {
            return null;
        }
        if(BouncyCastlePemReader.isAvailable()) {
            if(!inputStream0.markSupported()) {
                inputStream0 = new BufferedInputStream(inputStream0);
            }
            inputStream0.mark(0x100000);
            PrivateKey privateKey0 = BouncyCastlePemReader.getPrivateKey(inputStream0, s);
            if(privateKey0 != null) {
                return privateKey0;
            }
            inputStream0.reset();
        }
        return SslContext.getPrivateKeyFromByteBuffer(PemReader.readPrivateKey(inputStream0), s);
    }

    public static PrivateKey toPrivateKeyInternal(File file0, String s) {
        try {
            return SslContext.toPrivateKey(file0, s);
        }
        catch(Exception exception0) {
            throw new SSLException(exception0);
        }
    }

    public static X509Certificate[] toX509Certificates(File file0) {
        return file0 == null ? null : SslContext.getCertificatesFromBuffers(PemReader.readCertificates(file0));
    }

    public static X509Certificate[] toX509Certificates(InputStream inputStream0) {
        return inputStream0 == null ? null : SslContext.getCertificatesFromBuffers(PemReader.readCertificates(inputStream0));
    }

    public static X509Certificate[] toX509CertificatesInternal(File file0) {
        try {
            return SslContext.toX509Certificates(file0);
        }
        catch(CertificateException certificateException0) {
            throw new SSLException(certificateException0);
        }
    }

    private static void verifyNullSslContextProvider(SslProvider sslProvider0, Provider provider0) {
        if(provider0 != null) {
            throw new IllegalArgumentException("Java Security Provider unsupported for SslProvider: " + sslProvider0);
        }
    }

    class io.netty.handler.ssl.SslContext.1 {
        static final int[] $SwitchMap$io$netty$handler$ssl$SslProvider;

        static {
            int[] arr_v = new int[SslProvider.values().length];
            io.netty.handler.ssl.SslContext.1.$SwitchMap$io$netty$handler$ssl$SslProvider = arr_v;
            try {
                arr_v[SslProvider.JDK.ordinal()] = 1;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                io.netty.handler.ssl.SslContext.1.$SwitchMap$io$netty$handler$ssl$SslProvider[SslProvider.OPENSSL.ordinal()] = 2;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                io.netty.handler.ssl.SslContext.1.$SwitchMap$io$netty$handler$ssl$SslProvider[SslProvider.OPENSSL_REFCNT.ordinal()] = 3;
            }
            catch(NoSuchFieldError unused_ex) {
            }
        }
    }

}

