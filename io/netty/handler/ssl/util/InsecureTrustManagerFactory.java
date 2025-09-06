package io.netty.handler.ssl.util;

import io.netty.util.internal.EmptyArrays;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.security.KeyStore;
import java.security.cert.X509Certificate;
import javax.net.ssl.ManagerFactoryParameters;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

public final class InsecureTrustManagerFactory extends SimpleTrustManagerFactory {
    public static final TrustManagerFactory INSTANCE;
    private static final InternalLogger logger;
    private static final TrustManager tm;

    static {
        InsecureTrustManagerFactory.logger = InternalLoggerFactory.getInstance(InsecureTrustManagerFactory.class);
        InsecureTrustManagerFactory.INSTANCE = new InsecureTrustManagerFactory();
        InsecureTrustManagerFactory.tm = new X509TrustManager() {
            @Override  // javax.net.ssl.X509TrustManager
            public void checkClientTrusted(X509Certificate[] arr_x509Certificate, String s) {
                if(InsecureTrustManagerFactory.logger.isDebugEnabled()) {
                    InsecureTrustManagerFactory.logger.debug("Accepting a client certificate: " + arr_x509Certificate[0].getSubjectDN());
                }
            }

            @Override  // javax.net.ssl.X509TrustManager
            public void checkServerTrusted(X509Certificate[] arr_x509Certificate, String s) {
                if(InsecureTrustManagerFactory.logger.isDebugEnabled()) {
                    InsecureTrustManagerFactory.logger.debug("Accepting a server certificate: " + arr_x509Certificate[0].getSubjectDN());
                }
            }

            @Override  // javax.net.ssl.X509TrustManager
            public X509Certificate[] getAcceptedIssuers() {
                return EmptyArrays.EMPTY_X509_CERTIFICATES;
            }
        };
    }

    @Override  // io.netty.handler.ssl.util.SimpleTrustManagerFactory
    public TrustManager[] engineGetTrustManagers() {
        return new TrustManager[]{InsecureTrustManagerFactory.tm};
    }

    @Override  // io.netty.handler.ssl.util.SimpleTrustManagerFactory
    public void engineInit(KeyStore keyStore0) {
    }

    @Override  // io.netty.handler.ssl.util.SimpleTrustManagerFactory
    public void engineInit(ManagerFactoryParameters managerFactoryParameters0) {
    }
}

