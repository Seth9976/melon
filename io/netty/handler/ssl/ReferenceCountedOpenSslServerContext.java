package io.netty.handler.ssl;

import io.netty.buffer.ByteBufAllocator;
import io.netty.internal.tcnative.CertificateCallback;
import io.netty.internal.tcnative.SSLContext;
import io.netty.internal.tcnative.SniHostNameMatcher;
import io.netty.util.CharsetUtil;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.SuppressJava6Requirement;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.security.PrivateKey;
import java.security.cert.X509Certificate;
import java.util.Map.Entry;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSessionContext;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509ExtendedTrustManager;
import javax.net.ssl.X509TrustManager;

public final class ReferenceCountedOpenSslServerContext extends ReferenceCountedOpenSslContext {
    @SuppressJava6Requirement(reason = "Usage guarded by java version check")
    static final class ExtendedTrustManagerVerifyCallback extends AbstractCertificateVerifier {
        private final X509ExtendedTrustManager manager;

        public ExtendedTrustManagerVerifyCallback(OpenSslEngineMap openSslEngineMap0, X509ExtendedTrustManager x509ExtendedTrustManager0) {
            super(openSslEngineMap0);
            this.manager = x509ExtendedTrustManager0;
        }

        @Override  // io.netty.handler.ssl.ReferenceCountedOpenSslContext$AbstractCertificateVerifier
        public void verify(ReferenceCountedOpenSslEngine referenceCountedOpenSslEngine0, X509Certificate[] arr_x509Certificate, String s) {
            this.manager.checkClientTrusted(arr_x509Certificate, s, referenceCountedOpenSslEngine0);
        }
    }

    static final class OpenSslServerCertificateCallback implements CertificateCallback {
        private final OpenSslEngineMap engineMap;
        private final OpenSslKeyMaterialManager keyManagerHolder;

        public OpenSslServerCertificateCallback(OpenSslEngineMap openSslEngineMap0, OpenSslKeyMaterialManager openSslKeyMaterialManager0) {
            this.engineMap = openSslEngineMap0;
            this.keyManagerHolder = openSslKeyMaterialManager0;
        }

        public void handle(long v, byte[] arr_b, byte[][] arr2_b) {
            ReferenceCountedOpenSslEngine referenceCountedOpenSslEngine0 = this.engineMap.get(v);
            if(referenceCountedOpenSslEngine0 == null) {
                return;
            }
            try {
                this.keyManagerHolder.setKeyMaterialServerSide(referenceCountedOpenSslEngine0);
                return;
            }
            catch(Throwable throwable0) {
                referenceCountedOpenSslEngine0.initHandshakeException(throwable0);
                if(throwable0 instanceof Exception) {
                    throw (Exception)throwable0;
                }
                throw new SSLException(throwable0);
            }
        }
    }

    static final class OpenSslSniHostnameMatcher implements SniHostNameMatcher {
        private final OpenSslEngineMap engineMap;

        public OpenSslSniHostnameMatcher(OpenSslEngineMap openSslEngineMap0) {
            this.engineMap = openSslEngineMap0;
        }

        public boolean match(long v, String s) {
            ReferenceCountedOpenSslEngine referenceCountedOpenSslEngine0 = this.engineMap.get(v);
            if(referenceCountedOpenSslEngine0 != null) {
                return referenceCountedOpenSslEngine0.checkSniHostnameMatch(s.getBytes(CharsetUtil.UTF_8));
            }
            ReferenceCountedOpenSslServerContext.logger.warn("No ReferenceCountedOpenSslEngine found for SSL pointer: {}", v);
            return false;
        }
    }

    static final class TrustManagerVerifyCallback extends AbstractCertificateVerifier {
        private final X509TrustManager manager;

        public TrustManagerVerifyCallback(OpenSslEngineMap openSslEngineMap0, X509TrustManager x509TrustManager0) {
            super(openSslEngineMap0);
            this.manager = x509TrustManager0;
        }

        @Override  // io.netty.handler.ssl.ReferenceCountedOpenSslContext$AbstractCertificateVerifier
        public void verify(ReferenceCountedOpenSslEngine referenceCountedOpenSslEngine0, X509Certificate[] arr_x509Certificate, String s) {
            this.manager.checkClientTrusted(arr_x509Certificate, s);
        }
    }

    private static final byte[] ID;
    private static final InternalLogger logger;
    private final OpenSslServerSessionContext sessionContext;

    static {
        ReferenceCountedOpenSslServerContext.logger = InternalLoggerFactory.getInstance(ReferenceCountedOpenSslServerContext.class);
        ReferenceCountedOpenSslServerContext.ID = new byte[]{110, 101, 0x74, 0x74, 0x79};
    }

    public ReferenceCountedOpenSslServerContext(X509Certificate[] arr_x509Certificate, TrustManagerFactory trustManagerFactory0, X509Certificate[] arr_x509Certificate1, PrivateKey privateKey0, String s, KeyManagerFactory keyManagerFactory0, Iterable iterable0, CipherSuiteFilter cipherSuiteFilter0, ApplicationProtocolConfig applicationProtocolConfig0, long v, long v1, ClientAuth clientAuth0, String[] arr_s, boolean z, boolean z1, String s1, Map.Entry[] arr_map$Entry) {
        this(arr_x509Certificate, trustManagerFactory0, arr_x509Certificate1, privateKey0, s, keyManagerFactory0, iterable0, cipherSuiteFilter0, ReferenceCountedOpenSslContext.toNegotiator(applicationProtocolConfig0), v, v1, clientAuth0, arr_s, z, z1, s1, arr_map$Entry);
    }

    public ReferenceCountedOpenSslServerContext(X509Certificate[] arr_x509Certificate, TrustManagerFactory trustManagerFactory0, X509Certificate[] arr_x509Certificate1, PrivateKey privateKey0, String s, KeyManagerFactory keyManagerFactory0, Iterable iterable0, CipherSuiteFilter cipherSuiteFilter0, OpenSslApplicationProtocolNegotiator openSslApplicationProtocolNegotiator0, long v, long v1, ClientAuth clientAuth0, String[] arr_s, boolean z, boolean z1, String s1, Map.Entry[] arr_map$Entry) {
        super(iterable0, cipherSuiteFilter0, openSslApplicationProtocolNegotiator0, 1, arr_x509Certificate1, clientAuth0, arr_s, z, z1, true, arr_map$Entry);
        try {
            OpenSslServerSessionContext openSslServerSessionContext0 = ReferenceCountedOpenSslServerContext.newSessionContext(this, this.ctx, this.engineMap, arr_x509Certificate, trustManagerFactory0, arr_x509Certificate1, privateKey0, s, keyManagerFactory0, s1, v, v1);
            this.sessionContext = openSslServerSessionContext0;
            if(ReferenceCountedOpenSslContext.SERVER_ENABLE_SESSION_TICKET) {
                openSslServerSessionContext0.setTicketKeys(new OpenSslSessionTicketKey[0]);
            }
        }
        catch(Throwable throwable0) {
            this.release();
            throw throwable0;
        }
    }

    public static OpenSslServerSessionContext newSessionContext(ReferenceCountedOpenSslContext referenceCountedOpenSslContext0, long v, OpenSslEngineMap openSslEngineMap0, X509Certificate[] arr_x509Certificate, TrustManagerFactory trustManagerFactory0, X509Certificate[] arr_x509Certificate1, PrivateKey privateKey0, String s, KeyManagerFactory keyManagerFactory0, String s1, long v1, long v2) {
        long v4;
        long v3;
        X509Certificate[] arr_x509Certificate2;
        X509TrustManager x509TrustManager0;
        TrustManagerFactory trustManagerFactory1;
        try {
            SSLContext.setVerify(v, 0, 10);
            if(keyManagerFactory0 != null) {
                throw new IllegalArgumentException("KeyManagerFactory not supported");
            }
            ObjectUtil.checkNotNull(arr_x509Certificate1, "keyCertChain");
            ReferenceCountedOpenSslContext.setKeyMaterial(v, arr_x509Certificate1, privateKey0, s);
        }
        catch(Exception exception0) {
            throw new SSLException("failed to set certificate and key", exception0);
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
            x509TrustManager0 = ReferenceCountedOpenSslContext.chooseTrustManager(trustManagerFactory1.getTrustManagers());
            ReferenceCountedOpenSslServerContext.setVerifyCallback(v, openSslEngineMap0, x509TrustManager0);
            arr_x509Certificate2 = x509TrustManager0.getAcceptedIssuers();
            v3 = 0L;
            if(arr_x509Certificate2 != null && arr_x509Certificate2.length > 0) {
                goto label_18;
            }
            goto label_35;
        }
        catch(SSLException sSLException0) {
            throw sSLException0;
        }
        catch(Exception exception1) {
            throw new SSLException("unable to setup trustmanager", exception1);
        }
        try {
        label_18:
            v4 = ReferenceCountedOpenSslContext.toBIO(ByteBufAllocator.DEFAULT, arr_x509Certificate2);
        }
        catch(Throwable throwable1) {
            goto label_26;
        }
        try {
            if(!SSLContext.setCACertificateBio(v, v4)) {
                throw new SSLException("unable to setup accepted issuers for trustmanager " + x509TrustManager0);
            }
            goto label_28;
        }
        catch(Throwable throwable1) {
            v3 = v4;
        }
        try {
            try {
            label_26:
                ReferenceCountedOpenSslContext.freeBio(v3);
                throw throwable1;
            label_28:
                ReferenceCountedOpenSslContext.freeBio(v4);
                goto label_35;
            }
            catch(SSLException sSLException0) {
            }
            catch(Exception exception1) {
                throw new SSLException("unable to setup trustmanager", exception1);
            }
            throw sSLException0;
        label_35:
            OpenSslServerSessionContext openSslServerSessionContext0 = new OpenSslServerSessionContext(referenceCountedOpenSslContext0, null);
            openSslServerSessionContext0.setSessionIdContext(ReferenceCountedOpenSslServerContext.ID);
            openSslServerSessionContext0.setSessionCacheEnabled(ReferenceCountedOpenSslContext.SERVER_ENABLE_SESSION_CACHE);
            if(Long.compare(v1, 0L) > 0) {
                openSslServerSessionContext0.setSessionCacheSize(((int)Math.min(v1, 0x7FFFFFFFL)));
            }
            if(v2 > 0L) {
                openSslServerSessionContext0.setSessionTimeout(((int)Math.min(v2, 0x7FFFFFFFL)));
            }
            return openSslServerSessionContext0;
        }
        catch(Throwable throwable0) {
        }
        throw throwable0;
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

    @SuppressJava6Requirement(reason = "Guarded by java version check")
    private static void setVerifyCallback(long v, OpenSslEngineMap openSslEngineMap0, X509TrustManager x509TrustManager0) {
        if(ReferenceCountedOpenSslContext.useExtendedTrustManager(x509TrustManager0)) {
            SSLContext.setCertVerifyCallback(v, new ExtendedTrustManagerVerifyCallback(openSslEngineMap0, ((X509ExtendedTrustManager)x509TrustManager0)));
            return;
        }
        SSLContext.setCertVerifyCallback(v, new TrustManagerVerifyCallback(openSslEngineMap0, x509TrustManager0));
    }
}

