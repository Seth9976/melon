package io.netty.handler.ssl;

import io.netty.util.internal.EmptyArrays;
import io.netty.util.internal.SuppressJava6Requirement;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.lang.reflect.Method;
import java.security.AccessController;
import java.security.PrivilegedExceptionAction;
import java.util.List;
import java.util.function.BiFunction;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLParameters;

@SuppressJava6Requirement(reason = "Usage guarded by java version check")
final class JdkAlpnSslUtils {
    private static final Method GET_APPLICATION_PROTOCOL;
    private static final Method GET_HANDSHAKE_APPLICATION_PROTOCOL;
    private static final Method GET_HANDSHAKE_APPLICATION_PROTOCOL_SELECTOR;
    private static final Method SET_APPLICATION_PROTOCOLS;
    private static final Method SET_HANDSHAKE_APPLICATION_PROTOCOL_SELECTOR;
    private static final InternalLogger logger;

    static {
        Method method5;
        Method method4;
        Method method3;
        Method method2;
        JdkAlpnSslUtils.logger = InternalLoggerFactory.getInstance(JdkAlpnSslUtils.class);
        Method method0 = null;
        try {
            SSLContext sSLContext0 = SSLContext.getInstance("TLS");
            sSLContext0.init(null, null, null);
            SSLEngine sSLEngine0 = sSLContext0.createSSLEngine();
            Method method1 = (Method)AccessController.doPrivileged(new PrivilegedExceptionAction() {
                @Override
                public Object run() {
                    return this.run();
                }

                public Method run() {
                    return SSLEngine.class.getMethod("getHandshakeApplicationProtocol", null);
                }
            });
            method1.invoke(sSLEngine0, null);
            method2 = (Method)AccessController.doPrivileged(new PrivilegedExceptionAction() {
                @Override
                public Object run() {
                    return this.run();
                }

                public Method run() {
                    return SSLEngine.class.getMethod("getApplicationProtocol", null);
                }
            });
            method2.invoke(sSLEngine0, null);
            method3 = (Method)AccessController.doPrivileged(new PrivilegedExceptionAction() {
                @Override
                public Object run() {
                    return this.run();
                }

                public Method run() {
                    return SSLParameters.class.getMethod("setApplicationProtocols", String[].class);
                }
            });
            method3.invoke(sSLEngine0.getSSLParameters(), EmptyArrays.EMPTY_STRINGS);
            method4 = (Method)AccessController.doPrivileged(new PrivilegedExceptionAction() {
                @Override
                public Object run() {
                    return this.run();
                }

                public Method run() {
                    return SSLEngine.class.getMethod("setHandshakeApplicationProtocolSelector", BiFunction.class);
                }
            });
            method4.invoke(sSLEngine0, new BiFunction() {
                @Override
                public Object apply(Object object0, Object object1) {
                    return this.apply(((SSLEngine)object0), ((List)object1));
                }

                public String apply(SSLEngine sSLEngine0, List list0) {
                    return null;
                }
            });
            method5 = (Method)AccessController.doPrivileged(new PrivilegedExceptionAction() {
                @Override
                public Object run() {
                    return this.run();
                }

                public Method run() {
                    return SSLEngine.class.getMethod("getHandshakeApplicationProtocolSelector", null);
                }
            });
            method5.invoke(sSLEngine0, null);
            method0 = method1;
        }
        catch(Throwable unused_ex) {
            method2 = null;
            method3 = null;
            method4 = null;
            method5 = null;
        }
        JdkAlpnSslUtils.GET_HANDSHAKE_APPLICATION_PROTOCOL = method0;
        JdkAlpnSslUtils.GET_APPLICATION_PROTOCOL = method2;
        JdkAlpnSslUtils.SET_APPLICATION_PROTOCOLS = method3;
        JdkAlpnSslUtils.SET_HANDSHAKE_APPLICATION_PROTOCOL_SELECTOR = method4;
        JdkAlpnSslUtils.GET_HANDSHAKE_APPLICATION_PROTOCOL_SELECTOR = method5;
    }

    public static String getApplicationProtocol(SSLEngine sSLEngine0) {
        try {
            return (String)JdkAlpnSslUtils.GET_APPLICATION_PROTOCOL.invoke(sSLEngine0, null);
        }
        catch(UnsupportedOperationException unsupportedOperationException0) {
            throw unsupportedOperationException0;
        }
        catch(Exception exception0) {
            throw new IllegalStateException(exception0);
        }
    }

    public static String getHandshakeApplicationProtocol(SSLEngine sSLEngine0) {
        try {
            return (String)JdkAlpnSslUtils.GET_HANDSHAKE_APPLICATION_PROTOCOL.invoke(sSLEngine0, null);
        }
        catch(UnsupportedOperationException unsupportedOperationException0) {
            throw unsupportedOperationException0;
        }
        catch(Exception exception0) {
            throw new IllegalStateException(exception0);
        }
    }

    public static BiFunction getHandshakeApplicationProtocolSelector(SSLEngine sSLEngine0) {
        try {
            return (BiFunction)JdkAlpnSslUtils.GET_HANDSHAKE_APPLICATION_PROTOCOL_SELECTOR.invoke(sSLEngine0, null);
        }
        catch(UnsupportedOperationException unsupportedOperationException0) {
            throw unsupportedOperationException0;
        }
        catch(Exception exception0) {
            throw new IllegalStateException(exception0);
        }
    }

    public static void setApplicationProtocols(SSLEngine sSLEngine0, List list0) {
        SSLParameters sSLParameters0 = sSLEngine0.getSSLParameters();
        String[] arr_s = (String[])list0.toArray(EmptyArrays.EMPTY_STRINGS);
        try {
            JdkAlpnSslUtils.SET_APPLICATION_PROTOCOLS.invoke(sSLParameters0, arr_s);
        }
        catch(UnsupportedOperationException unsupportedOperationException0) {
            throw unsupportedOperationException0;
        }
        catch(Exception exception0) {
            throw new IllegalStateException(exception0);
        }
        sSLEngine0.setSSLParameters(sSLParameters0);
    }

    public static void setHandshakeApplicationProtocolSelector(SSLEngine sSLEngine0, BiFunction biFunction0) {
        try {
            JdkAlpnSslUtils.SET_HANDSHAKE_APPLICATION_PROTOCOL_SELECTOR.invoke(sSLEngine0, biFunction0);
        }
        catch(UnsupportedOperationException unsupportedOperationException0) {
            throw unsupportedOperationException0;
        }
        catch(Exception exception0) {
            throw new IllegalStateException(exception0);
        }
    }

    public static boolean supportsAlpn() [...] // 潜在的解密器
}

