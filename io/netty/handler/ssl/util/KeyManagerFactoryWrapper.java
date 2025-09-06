package io.netty.handler.ssl.util;

import io.netty.util.internal.ObjectUtil;
import java.security.KeyStore;
import javax.net.ssl.KeyManager;
import javax.net.ssl.ManagerFactoryParameters;

public final class KeyManagerFactoryWrapper extends SimpleKeyManagerFactory {
    private final KeyManager km;

    public KeyManagerFactoryWrapper(KeyManager keyManager0) {
        this.km = (KeyManager)ObjectUtil.checkNotNull(keyManager0, "km");
    }

    @Override  // io.netty.handler.ssl.util.SimpleKeyManagerFactory
    public KeyManager[] engineGetKeyManagers() {
        return new KeyManager[]{this.km};
    }

    @Override  // io.netty.handler.ssl.util.SimpleKeyManagerFactory
    public void engineInit(KeyStore keyStore0, char[] arr_c) {
    }

    @Override  // io.netty.handler.ssl.util.SimpleKeyManagerFactory
    public void engineInit(ManagerFactoryParameters managerFactoryParameters0) {
    }
}

