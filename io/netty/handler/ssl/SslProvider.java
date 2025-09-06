package io.netty.handler.ssl;

import java.security.Provider;

public enum SslProvider {
    JDK,
    OPENSSL,
    OPENSSL_REFCNT;

    public static boolean isAlpnSupported(SslProvider sslProvider0) {
        switch(io.netty.handler.ssl.SslProvider.1.$SwitchMap$io$netty$handler$ssl$SslProvider[sslProvider0.ordinal()]) {
            case 1: {
                return JdkAlpnApplicationProtocolNegotiator.isAlpnSupported();
            }
            case 2: 
            case 3: {
                return OpenSsl.isAlpnSupported();
            }
            default: {
                throw new Error("Unknown SslProvider: " + sslProvider0);
            }
        }
    }

    public static boolean isOptionSupported(SslProvider sslProvider0, SslContextOption sslContextOption0) {
        switch(io.netty.handler.ssl.SslProvider.1.$SwitchMap$io$netty$handler$ssl$SslProvider[sslProvider0.ordinal()]) {
            case 1: {
                return false;
            }
            case 2: 
            case 3: {
                return OpenSsl.isOptionSupported(sslContextOption0);
            }
            default: {
                throw new Error("Unknown SslProvider: " + sslProvider0);
            }
        }
    }

    public static boolean isTlsv13EnabledByDefault(SslProvider sslProvider0, Provider provider0) {
        switch(io.netty.handler.ssl.SslProvider.1.$SwitchMap$io$netty$handler$ssl$SslProvider[sslProvider0.ordinal()]) {
            case 1: {
                return SslUtils.isTLSv13EnabledByJDK(provider0);
            }
            case 2: 
            case 3: {
                return OpenSsl.isTlsv13Supported();
            }
            default: {
                throw new Error("Unknown SslProvider: " + sslProvider0);
            }
        }
    }

    public static boolean isTlsv13Supported(SslProvider sslProvider0) {
        return SslProvider.isTlsv13Supported(sslProvider0, null);
    }

    public static boolean isTlsv13Supported(SslProvider sslProvider0, Provider provider0) {
        switch(io.netty.handler.ssl.SslProvider.1.$SwitchMap$io$netty$handler$ssl$SslProvider[sslProvider0.ordinal()]) {
            case 1: {
                return SslUtils.isTLSv13SupportedByJDK(provider0);
            }
            case 2: 
            case 3: {
                return OpenSsl.isTlsv13Supported();
            }
            default: {
                throw new Error("Unknown SslProvider: " + sslProvider0);
            }
        }
    }

    class io.netty.handler.ssl.SslProvider.1 {
        static final int[] $SwitchMap$io$netty$handler$ssl$SslProvider;

        static {
            int[] arr_v = new int[SslProvider.values().length];
            io.netty.handler.ssl.SslProvider.1.$SwitchMap$io$netty$handler$ssl$SslProvider = arr_v;
            try {
                arr_v[SslProvider.JDK.ordinal()] = 1;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                io.netty.handler.ssl.SslProvider.1.$SwitchMap$io$netty$handler$ssl$SslProvider[SslProvider.OPENSSL.ordinal()] = 2;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                io.netty.handler.ssl.SslProvider.1.$SwitchMap$io$netty$handler$ssl$SslProvider[SslProvider.OPENSSL_REFCNT.ordinal()] = 3;
            }
            catch(NoSuchFieldError unused_ex) {
            }
        }
    }

}

