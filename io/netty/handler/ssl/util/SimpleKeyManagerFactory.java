package io.netty.handler.ssl.util;

import io.netty.util.concurrent.FastThreadLocal;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.SuppressJava6Requirement;
import java.security.InvalidAlgorithmParameterException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.Provider;
import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.KeyManagerFactorySpi;
import javax.net.ssl.ManagerFactoryParameters;
import javax.net.ssl.X509ExtendedKeyManager;
import javax.net.ssl.X509KeyManager;

public abstract class SimpleKeyManagerFactory extends KeyManagerFactory {
    static final class SimpleKeyManagerFactorySpi extends KeyManagerFactorySpi {
        private volatile KeyManager[] keyManagers;
        private SimpleKeyManagerFactory parent;

        private SimpleKeyManagerFactorySpi() {
        }

        public SimpleKeyManagerFactorySpi(io.netty.handler.ssl.util.SimpleKeyManagerFactory.1 simpleKeyManagerFactory$10) {
        }

        @Override  // javax.net.ssl.KeyManagerFactorySpi
        public KeyManager[] engineGetKeyManagers() {
            KeyManager[] arr_keyManager = this.keyManagers;
            if(arr_keyManager == null) {
                arr_keyManager = this.parent.engineGetKeyManagers();
                if(PlatformDependent.javaVersion() >= 7) {
                    SimpleKeyManagerFactorySpi.wrapIfNeeded(arr_keyManager);
                }
                this.keyManagers = arr_keyManager;
            }
            return (KeyManager[])arr_keyManager.clone();
        }

        @Override  // javax.net.ssl.KeyManagerFactorySpi
        public void engineInit(KeyStore keyStore0, char[] arr_c) {
            try {
                this.parent.engineInit(keyStore0, arr_c);
            }
            catch(KeyStoreException keyStoreException0) {
                throw keyStoreException0;
            }
            catch(Exception exception0) {
                throw new KeyStoreException(exception0);
            }
        }

        @Override  // javax.net.ssl.KeyManagerFactorySpi
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

        public void init(SimpleKeyManagerFactory simpleKeyManagerFactory0) {
            this.parent = simpleKeyManagerFactory0;
        }

        @SuppressJava6Requirement(reason = "Usage guarded by java version check")
        private static void wrapIfNeeded(KeyManager[] arr_keyManager) {
            for(int v = 0; v < arr_keyManager.length; ++v) {
                KeyManager keyManager0 = arr_keyManager[v];
                if(keyManager0 instanceof X509KeyManager && !(keyManager0 instanceof X509ExtendedKeyManager)) {
                    arr_keyManager[v] = new X509KeyManagerWrapper(((X509KeyManager)keyManager0));
                }
            }
        }
    }

    private static final FastThreadLocal CURRENT_SPI;
    private static final Provider PROVIDER;

    static {
        SimpleKeyManagerFactory.PROVIDER = new Provider("", 0.0, "") {
            private static final long serialVersionUID = -2680540247105807895L;

        };
        SimpleKeyManagerFactory.CURRENT_SPI = new FastThreadLocal() {
            public SimpleKeyManagerFactorySpi initialValue() {
                return new SimpleKeyManagerFactorySpi(null);
            }

            @Override  // io.netty.util.concurrent.FastThreadLocal
            public Object initialValue() {
                return this.initialValue();
            }
        };
    }

    public SimpleKeyManagerFactory() {
        this("");
    }

    public SimpleKeyManagerFactory(String s) {
        KeyManagerFactorySpi keyManagerFactorySpi0 = (KeyManagerFactorySpi)SimpleKeyManagerFactory.CURRENT_SPI.get();
        String s1 = (String)ObjectUtil.checkNotNull(s, "name");
        super(keyManagerFactorySpi0, SimpleKeyManagerFactory.PROVIDER, s1);
        ((SimpleKeyManagerFactorySpi)SimpleKeyManagerFactory.CURRENT_SPI.get()).init(this);
        SimpleKeyManagerFactory.CURRENT_SPI.remove();
    }

    public abstract KeyManager[] engineGetKeyManagers();

    public abstract void engineInit(KeyStore arg1, char[] arg2);

    public abstract void engineInit(ManagerFactoryParameters arg1);
}

