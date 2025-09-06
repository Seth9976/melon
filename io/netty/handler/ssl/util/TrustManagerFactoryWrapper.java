package io.netty.handler.ssl.util;

import io.netty.util.internal.ObjectUtil;
import java.security.KeyStore;
import javax.net.ssl.ManagerFactoryParameters;
import javax.net.ssl.TrustManager;

public final class TrustManagerFactoryWrapper extends SimpleTrustManagerFactory {
    private final TrustManager tm;

    public TrustManagerFactoryWrapper(TrustManager trustManager0) {
        this.tm = (TrustManager)ObjectUtil.checkNotNull(trustManager0, "tm");
    }

    @Override  // io.netty.handler.ssl.util.SimpleTrustManagerFactory
    public TrustManager[] engineGetTrustManagers() {
        return new TrustManager[]{this.tm};
    }

    @Override  // io.netty.handler.ssl.util.SimpleTrustManagerFactory
    public void engineInit(KeyStore keyStore0) {
    }

    @Override  // io.netty.handler.ssl.util.SimpleTrustManagerFactory
    public void engineInit(ManagerFactoryParameters managerFactoryParameters0) {
    }
}

