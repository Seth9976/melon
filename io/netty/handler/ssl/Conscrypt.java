package io.netty.handler.ssl;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import javax.net.ssl.SSLEngine;

final class Conscrypt {
    private static final Method IS_CONSCRYPT_SSLENGINE;

    // 去混淆评级： 低(45)
    static {
        Conscrypt.IS_CONSCRYPT_SSLENGINE = null;
    }

    public static boolean isAvailable() [...] // 潜在的解密器

    public static boolean isEngineSupported(SSLEngine sSLEngine0) {
        try {
            return Conscrypt.IS_CONSCRYPT_SSLENGINE != null && ((Boolean)Conscrypt.IS_CONSCRYPT_SSLENGINE.invoke(null, sSLEngine0)).booleanValue();
        }
        catch(IllegalAccessException unused_ex) {
            return false;
        }
        catch(InvocationTargetException invocationTargetException0) {
            throw new RuntimeException(invocationTargetException0);
        }
    }
}

