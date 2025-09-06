package io.netty.handler.ssl;

import io.netty.util.internal.ObjectUtil;
import java.security.KeyStore;
import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.KeyManagerFactorySpi;
import javax.net.ssl.ManagerFactoryParameters;
import javax.net.ssl.X509KeyManager;

public final class OpenSslCachingX509KeyManagerFactory extends KeyManagerFactory {
    private final int maxCachedEntries;

    public OpenSslCachingX509KeyManagerFactory(KeyManagerFactory keyManagerFactory0) {
        this(keyManagerFactory0, 0x400);
    }

    public OpenSslCachingX509KeyManagerFactory(KeyManagerFactory keyManagerFactory0, int v) {
        super(new KeyManagerFactorySpi() {
            @Override  // javax.net.ssl.KeyManagerFactorySpi
            public KeyManager[] engineGetKeyManagers() {
                return this.val$factory.getKeyManagers();
            }

            @Override  // javax.net.ssl.KeyManagerFactorySpi
            public void engineInit(KeyStore keyStore0, char[] arr_c) {
                this.val$factory.init(keyStore0, arr_c);
            }

            @Override  // javax.net.ssl.KeyManagerFactorySpi
            public void engineInit(ManagerFactoryParameters managerFactoryParameters0) {
                this.val$factory.init(managerFactoryParameters0);
            }
        }, keyManagerFactory0.getProvider(), keyManagerFactory0.getAlgorithm());
        this.maxCachedEntries = ObjectUtil.checkPositive(v, "maxCachedEntries");
    }

    public OpenSslKeyMaterialProvider newProvider(String s) {
        X509KeyManager x509KeyManager0 = ReferenceCountedOpenSslContext.chooseX509KeyManager(this.getKeyManagers());
        return "sun.security.ssl.X509KeyManagerImpl".equals(x509KeyManager0.getClass().getName()) ? new OpenSslKeyMaterialProvider(x509KeyManager0, s) : new OpenSslCachingKeyMaterialProvider(ReferenceCountedOpenSslContext.chooseX509KeyManager(this.getKeyManagers()), s, this.maxCachedEntries);
    }
}

