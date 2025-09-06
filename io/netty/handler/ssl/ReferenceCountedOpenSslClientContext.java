package io.netty.handler.ssl;

import io.netty.internal.tcnative.CertificateCallback;
import io.netty.internal.tcnative.SSL;
import io.netty.internal.tcnative.SSLContext;
import io.netty.util.internal.EmptyArrays;
import io.netty.util.internal.SuppressJava6Requirement;
import java.security.PrivateKey;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Map.Entry;
import java.util.Set;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSessionContext;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509ExtendedTrustManager;
import javax.net.ssl.X509TrustManager;
import javax.security.auth.x500.X500Principal;

public final class ReferenceCountedOpenSslClientContext extends ReferenceCountedOpenSslContext {
    @SuppressJava6Requirement(reason = "Usage guarded by java version check")
    static final class ExtendedTrustManagerVerifyCallback extends AbstractCertificateVerifier {
        private final X509ExtendedTrustManager manager;

        public ExtendedTrustManagerVerifyCallback(OpenSslEngineMap openSslEngineMap0, X509ExtendedTrustManager x509ExtendedTrustManager0) {
            super(openSslEngineMap0);
            this.manager = x509ExtendedTrustManager0;
        }

        @Override  // io.netty.handler.ssl.ReferenceCountedOpenSslContext$AbstractCertificateVerifier
        public void verify(ReferenceCountedOpenSslEngine referenceCountedOpenSslEngine0, X509Certificate[] arr_x509Certificate, String s) {
            this.manager.checkServerTrusted(arr_x509Certificate, s, referenceCountedOpenSslEngine0);
        }
    }

    static final class OpenSslClientCertificateCallback implements CertificateCallback {
        private final OpenSslEngineMap engineMap;
        private final OpenSslKeyMaterialManager keyManagerHolder;

        public OpenSslClientCertificateCallback(OpenSslEngineMap openSslEngineMap0, OpenSslKeyMaterialManager openSslKeyMaterialManager0) {
            this.engineMap = openSslEngineMap0;
            this.keyManagerHolder = openSslKeyMaterialManager0;
        }

        private static String clientKeyType(byte b) {
            switch(b) {
                case 1: {
                    return "RSA";
                }
                case 3: {
                    return "DH_RSA";
                }
                case 0x40: {
                    return "EC";
                }
                case 65: {
                    return "EC_RSA";
                }
                case 66: {
                    return "EC_EC";
                }
                default: {
                    return null;
                }
            }
        }

        public void handle(long v, byte[] arr_b, byte[][] arr2_b) {
            X500Principal[] arr_x500Principal;
            ReferenceCountedOpenSslEngine referenceCountedOpenSslEngine0 = this.engineMap.get(v);
            if(referenceCountedOpenSslEngine0 == null) {
                return;
            }
            try {
                String[] arr_s = (String[])OpenSslClientCertificateCallback.supportedClientKeyTypes(arr_b).toArray(EmptyArrays.EMPTY_STRINGS);
                if(arr2_b == null) {
                    arr_x500Principal = null;
                }
                else {
                    arr_x500Principal = new X500Principal[arr2_b.length];
                    for(int v1 = 0; v1 < arr2_b.length; ++v1) {
                        arr_x500Principal[v1] = new X500Principal(arr2_b[v1]);
                    }
                }
                this.keyManagerHolder.setKeyMaterialClientSide(referenceCountedOpenSslEngine0, arr_s, arr_x500Principal);
                return;
            }
            catch(Throwable throwable0) {
            }
            referenceCountedOpenSslEngine0.initHandshakeException(throwable0);
            if(throwable0 instanceof Exception) {
                throw (Exception)throwable0;
            }
            throw new SSLException(throwable0);
        }

        private static Set supportedClientKeyTypes(byte[] arr_b) {
            if(arr_b == null) {
                return ReferenceCountedOpenSslClientContext.SUPPORTED_KEY_TYPES;
            }
            Set set0 = new HashSet(arr_b.length);
            for(int v = 0; v < arr_b.length; ++v) {
                String s = OpenSslClientCertificateCallback.clientKeyType(arr_b[v]);
                if(s != null) {
                    ((HashSet)set0).add(s);
                }
            }
            return set0;
        }
    }

    static final class OpenSslClientSessionContext extends OpenSslSessionContext {
        public OpenSslClientSessionContext(ReferenceCountedOpenSslContext referenceCountedOpenSslContext0, OpenSslKeyMaterialProvider openSslKeyMaterialProvider0) {
            super(referenceCountedOpenSslContext0, openSslKeyMaterialProvider0, SSL.SSL_SESS_CACHE_CLIENT, new OpenSslClientSessionCache(referenceCountedOpenSslContext0.engineMap));
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
            this.manager.checkServerTrusted(arr_x509Certificate, s);
        }
    }

    private static final Set SUPPORTED_KEY_TYPES;
    private final OpenSslSessionContext sessionContext;

    static {
        ReferenceCountedOpenSslClientContext.SUPPORTED_KEY_TYPES = Collections.unmodifiableSet(new LinkedHashSet(Arrays.asList(new String[]{"RSA", "DH_RSA", "EC", "EC_RSA", "EC_EC"})));
    }

    public ReferenceCountedOpenSslClientContext(X509Certificate[] arr_x509Certificate, TrustManagerFactory trustManagerFactory0, X509Certificate[] arr_x509Certificate1, PrivateKey privateKey0, String s, KeyManagerFactory keyManagerFactory0, Iterable iterable0, CipherSuiteFilter cipherSuiteFilter0, ApplicationProtocolConfig applicationProtocolConfig0, String[] arr_s, long v, long v1, boolean z, String s1, Map.Entry[] arr_map$Entry) {
        super(iterable0, cipherSuiteFilter0, ReferenceCountedOpenSslContext.toNegotiator(applicationProtocolConfig0), 0, arr_x509Certificate1, ClientAuth.NONE, arr_s, false, z, true, arr_map$Entry);
        try {
            this.sessionContext = ReferenceCountedOpenSslClientContext.newSessionContext(this, this.ctx, this.engineMap, arr_x509Certificate, trustManagerFactory0, arr_x509Certificate1, privateKey0, s, keyManagerFactory0, s1, v, v1);
        }
        catch(Throwable throwable0) {
            this.release();
            throw throwable0;
        }
    }

    public static OpenSslSessionContext newSessionContext(ReferenceCountedOpenSslContext referenceCountedOpenSslContext0, long v, OpenSslEngineMap openSslEngineMap0, X509Certificate[] arr_x509Certificate, TrustManagerFactory trustManagerFactory0, X509Certificate[] arr_x509Certificate1, PrivateKey privateKey0, String s, KeyManagerFactory keyManagerFactory0, String s1, long v1, long v2) {
        TrustManagerFactory trustManagerFactory1;
        if(privateKey0 == null && arr_x509Certificate1 != null || privateKey0 != null && arr_x509Certificate1 == null) {
            throw new IllegalArgumentException("Either both keyCertChain and key needs to be null or none of them");
        }
        try {
            if(keyManagerFactory0 != null) {
                throw new IllegalArgumentException("KeyManagerFactory not supported");
            }
        }
        catch(Exception exception0) {
            throw new SSLException("failed to set certificate and key", exception0);
        }
        catch(Throwable throwable0) {
            throw throwable0;
        }
        if(arr_x509Certificate1 != null) {
            try {
                try {
                    ReferenceCountedOpenSslContext.setKeyMaterial(v, arr_x509Certificate1, privateKey0, s);
                    goto label_12;
                }
                catch(Exception exception0) {
                }
                throw new SSLException("failed to set certificate and key", exception0);
            }
            catch(Throwable throwable0) {
            }
            throw throwable0;
        }
    label_12:
        SSLContext.setVerify(v, 1, 10);
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
            ReferenceCountedOpenSslClientContext.setVerifyCallback(v, openSslEngineMap0, ReferenceCountedOpenSslContext.chooseTrustManager(trustManagerFactory1.getTrustManagers()));
        }
        catch(Exception exception1) {
            throw new SSLException("unable to setup trustmanager", exception1);
        }
        OpenSslSessionContext openSslSessionContext0 = new OpenSslClientSessionContext(referenceCountedOpenSslContext0, null);
        openSslSessionContext0.setSessionCacheEnabled(ReferenceCountedOpenSslContext.CLIENT_ENABLE_SESSION_CACHE);
        if(Long.compare(v1, 0L) > 0) {
            openSslSessionContext0.setSessionCacheSize(((int)Math.min(v1, 0x7FFFFFFFL)));
        }
        if(v2 > 0L) {
            openSslSessionContext0.setSessionTimeout(((int)Math.min(v2, 0x7FFFFFFFL)));
        }
        if(ReferenceCountedOpenSslContext.CLIENT_ENABLE_SESSION_TICKET) {
            openSslSessionContext0.setTicketKeys(new OpenSslSessionTicketKey[0]);
        }
        return openSslSessionContext0;
    }

    @Override  // io.netty.handler.ssl.ReferenceCountedOpenSslContext
    public OpenSslSessionContext sessionContext() {
        return this.sessionContext;
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

