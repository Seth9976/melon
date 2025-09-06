package io.netty.handler.ssl;

import io.netty.util.internal.EmptyArrays;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.SuppressJava6Requirement;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.security.AccessController;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivilegedAction;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509ExtendedTrustManager;
import javax.net.ssl.X509TrustManager;

@SuppressJava6Requirement(reason = "Usage guarded by java version check")
final class OpenSslX509TrustManagerWrapper {
    interface TrustManagerWrapper {
        X509TrustManager wrapIfNeeded(X509TrustManager arg1);
    }

    static final class UnsafeTrustManagerWrapper implements TrustManagerWrapper {
        private final long spiOffset;
        private final long tmOffset;

        public UnsafeTrustManagerWrapper(long v, long v1) {
            this.spiOffset = v;
            this.tmOffset = v1;
        }

        @Override  // io.netty.handler.ssl.OpenSslX509TrustManagerWrapper$TrustManagerWrapper
        @SuppressJava6Requirement(reason = "Usage guarded by java version check")
        public X509TrustManager wrapIfNeeded(X509TrustManager x509TrustManager0) {
            if(!(x509TrustManager0 instanceof X509ExtendedTrustManager)) {
                try {
                    SSLContext sSLContext0 = OpenSslX509TrustManagerWrapper.newSSLContext();
                    sSLContext0.init(null, new TrustManager[]{x509TrustManager0}, null);
                    Object object0 = PlatformDependent.getObject(sSLContext0, this.spiOffset);
                    if(object0 != null) {
                        Object object1 = PlatformDependent.getObject(object0, this.tmOffset);
                        if(object1 instanceof X509ExtendedTrustManager) {
                            return (X509TrustManager)object1;
                        }
                    }
                }
                catch(NoSuchAlgorithmException noSuchAlgorithmException0) {
                    PlatformDependent.throwException(noSuchAlgorithmException0);
                    return x509TrustManager0;
                }
                catch(KeyManagementException keyManagementException0) {
                    PlatformDependent.throwException(keyManagementException0);
                    return x509TrustManager0;
                }
                catch(NoSuchProviderException noSuchProviderException0) {
                    PlatformDependent.throwException(noSuchProviderException0);
                    return x509TrustManager0;
                }
            }
            return x509TrustManager0;
        }
    }

    private static final InternalLogger LOGGER;
    private static final TrustManagerWrapper WRAPPER;

    static {
        SSLContext sSLContext0;
        InternalLogger internalLogger0 = InternalLoggerFactory.getInstance(OpenSslX509TrustManagerWrapper.class);
        OpenSslX509TrustManagerWrapper.LOGGER = internalLogger0;
        TrustManagerWrapper openSslX509TrustManagerWrapper$TrustManagerWrapper0 = new TrustManagerWrapper() {
            @Override  // io.netty.handler.ssl.OpenSslX509TrustManagerWrapper$TrustManagerWrapper
            public X509TrustManager wrapIfNeeded(X509TrustManager x509TrustManager0) {
                return x509TrustManager0;
            }
        };
        Throwable throwable0 = null;
        if(PlatformDependent.getUnsafeUnavailabilityCause() == null) {
            try {
                sSLContext0 = OpenSslX509TrustManagerWrapper.newSSLContext();
                sSLContext0.init(null, new TrustManager[]{new X509TrustManager() {
                    @Override  // javax.net.ssl.X509TrustManager
                    public void checkClientTrusted(X509Certificate[] arr_x509Certificate, String s) {
                        throw new CertificateException();
                    }

                    @Override  // javax.net.ssl.X509TrustManager
                    public void checkServerTrusted(X509Certificate[] arr_x509Certificate, String s) {
                        throw new CertificateException();
                    }

                    @Override  // javax.net.ssl.X509TrustManager
                    public X509Certificate[] getAcceptedIssuers() {
                        return EmptyArrays.EMPTY_X509_CERTIFICATES;
                    }
                }}, null);
            }
            catch(Throwable throwable1) {
                throwable0 = throwable1;
                sSLContext0 = null;
            }
            if(throwable0 == null) {
                Object object0 = AccessController.doPrivileged(new PrivilegedAction() {
                    @Override
                    public Object run() {
                        Class class0;
                        long v;
                        try {
                            try {
                                v = PlatformDependent.objectFieldOffset(SSLContext.class.getDeclaredField("contextSpi"));
                                Object object1 = PlatformDependent.getObject(sSLContext0, v);
                                if(object1 == null) {
                                    throw new NoSuchFieldException();
                                }
                                class0 = object1.getClass();
                            }
                            catch(NoSuchFieldException object0) {
                                return object0;
                            }
                            while(true) {
                                try {
                                label_4:
                                    long v1 = PlatformDependent.objectFieldOffset(class0.getDeclaredField("trustManager"));
                                    if(PlatformDependent.getObject(object1, v1) instanceof X509ExtendedTrustManager) {
                                        return new UnsafeTrustManagerWrapper(v, v1);
                                    }
                                    goto label_7;
                                }
                                catch(NoSuchFieldException unused_ex) {
                                    try {
                                    label_7:
                                        class0 = class0.getSuperclass();
                                        if(class0 == null) {
                                            throw new NoSuchFieldException();
                                        }
                                        goto label_4;
                                    }
                                    catch(NoSuchFieldException object0) {
                                    }
                                    return object0;
                                }
                            }
                        }
                        catch(SecurityException object0) {
                            return object0;
                        }
                    }
                });
                if(object0 instanceof Throwable) {
                    OpenSslX509TrustManagerWrapper.LOGGER.debug("Unable to access wrapped TrustManager", ((Throwable)object0));
                }
                else {
                    openSslX509TrustManagerWrapper$TrustManagerWrapper0 = (TrustManagerWrapper)object0;
                }
            }
            else {
                OpenSslX509TrustManagerWrapper.LOGGER.debug("Unable to access wrapped TrustManager", throwable0);
            }
        }
        else {
            internalLogger0.debug("Unable to access wrapped TrustManager", null);
        }
        OpenSslX509TrustManagerWrapper.WRAPPER = openSslX509TrustManagerWrapper$TrustManagerWrapper0;
    }

    private static SSLContext newSSLContext() {
        return SSLContext.getInstance("TLS", "SunJSSE");
    }

    public static X509TrustManager wrapIfNeeded(X509TrustManager x509TrustManager0) {
        return OpenSslX509TrustManagerWrapper.WRAPPER.wrapIfNeeded(x509TrustManager0);
    }
}

