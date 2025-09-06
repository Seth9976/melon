package io.netty.handler.ssl;

import javax.net.ssl.SSLEngine;

final class BouncyCastle {
    private static final boolean BOUNCY_CASTLE_ON_CLASSPATH;

    static {
        boolean z = false;
        try {
            Class.forName("org.bouncycastle.jsse.provider.BouncyCastleJsseProvider");
            z = true;
        }
        catch(Throwable unused_ex) {
        }
        BouncyCastle.BOUNCY_CASTLE_ON_CLASSPATH = z;
    }

    public static boolean isAvailable() [...] // 潜在的解密器

    public static boolean isInUse(SSLEngine sSLEngine0) {
        return sSLEngine0.getClass().getPackage().getName().startsWith("org.bouncycastle.jsse.provider");
    }
}

