package io.netty.handler.ssl.util;

import io.netty.util.concurrent.FastThreadLocal;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.SuppressJava6Requirement;
import java.security.InvalidAlgorithmParameterException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.Provider;
import javax.net.ssl.ManagerFactoryParameters;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.TrustManagerFactorySpi;
import javax.net.ssl.X509ExtendedTrustManager;
import javax.net.ssl.X509TrustManager;

public abstract class SimpleTrustManagerFactory extends TrustManagerFactory {
    static final class SimpleTrustManagerFactorySpi extends TrustManagerFactorySpi {
        private SimpleTrustManagerFactory parent;
        private volatile TrustManager[] trustManagers;

        @Override  // javax.net.ssl.TrustManagerFactorySpi
        public TrustManager[] engineGetTrustManagers() {
            TrustManager[] arr_trustManager = this.trustManagers;
            if(arr_trustManager == null) {
                arr_trustManager = this.parent.engineGetTrustManagers();
                if(PlatformDependent.javaVersion() >= 7) {
                    SimpleTrustManagerFactorySpi.wrapIfNeeded(arr_trustManager);
                }
                this.trustManagers = arr_trustManager;
            }
            return (TrustManager[])arr_trustManager.clone();
        }

        @Override  // javax.net.ssl.TrustManagerFactorySpi
        public void engineInit(KeyStore keyStore0) {
            try {
                this.parent.engineInit(keyStore0);
            }
            catch(KeyStoreException keyStoreException0) {
                throw keyStoreException0;
            }
            catch(Exception exception0) {
                throw new KeyStoreException(exception0);
            }
        }

        @Override  // javax.net.ssl.TrustManagerFactorySpi
        public void engineInit(ManagerFactoryParameters managerFactoryParameters0) {
            try {
                this.parent.engineInit(managerFactoryParameters0);
            }
            catch(InvalidAlgorithmParameterException invalidAlgorithmParameterException0) {
                throw invalidAlgorithmParameterException0;
            }
            catch(Exception exception0) {
                throw new InvalidAlgorithmParameterException(exception0);
            }
        }

        public void init(SimpleTrustManagerFactory simpleTrustManagerFactory0) {
            this.parent = simpleTrustManagerFactory0;
        }

        @SuppressJava6Requirement(reason = "Usage guarded by java version check")
        private static void wrapIfNeeded(TrustManager[] arr_trustManager) {
            for(int v = 0; v < arr_trustManager.length; ++v) {
                TrustManager trustManager0 = arr_trustManager[v];
                if(trustManager0 instanceof X509TrustManager && !(trustManager0 instanceof X509ExtendedTrustManager)) {
                    arr_trustManager[v] = new X509TrustManagerWrapper(((X509TrustManager)trustManager0));
                }
            }
        }
    }

    private static final FastThreadLocal CURRENT_SPI;
    private static final Provider PROVIDER;

    static {
        SimpleTrustManagerFactory.PROVIDER = new Provider("", 0.0, "") {
            private static final long serialVersionUID = -2680540247105807895L;

        };
        SimpleTrustManagerFactory.CURRENT_SPI = new FastThreadLocal() {
            public SimpleTrustManagerFactorySpi initialValue() {
                return new SimpleTrustManagerFactorySpi();
            }

            @Override  // io.netty.util.concurrent.FastThreadLocal
            public Object initialValue() {
                return this.initialValue();
            }
        };
    }

    public SimpleTrustManagerFactory() {
        this("");
    }

    public SimpleTrustManagerFactory(String s) {
        super(((TrustManagerFactorySpi)SimpleTrustManagerFactory.CURRENT_SPI.get()), SimpleTrustManagerFactory.PROVIDER, s);
        ((SimpleTrustManagerFactorySpi)SimpleTrustManagerFactory.CURRENT_SPI.get()).init(this);
        SimpleTrustManagerFactory.CURRENT_SPI.remove();
        ObjectUtil.checkNotNull(s, "name");
    }

    public abstract TrustManager[] engineGetTrustManagers();

    public abstract void engineInit(KeyStore arg1);

    public abstract void engineInit(ManagerFactoryParameters arg1);
}

