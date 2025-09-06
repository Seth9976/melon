package io.netty.handler.ssl;

import U4.x;
import io.netty.util.internal.EmptyArrays;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.SuppressJava6Requirement;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.security.AccessController;
import java.security.PrivilegedExceptionAction;
import java.util.List;
import java.util.function.BiFunction;
import javax.net.ssl.SSLEngine;

@SuppressJava6Requirement(reason = "Usage guarded by java version check")
final class BouncyCastleAlpnSslUtils {
    private static final Class BC_APPLICATION_PROTOCOL_SELECTOR;
    private static final Method BC_APPLICATION_PROTOCOL_SELECTOR_SELECT;
    private static final Method GET_APPLICATION_PROTOCOL;
    private static final Method GET_HANDSHAKE_APPLICATION_PROTOCOL;
    private static final Method GET_HANDSHAKE_APPLICATION_PROTOCOL_SELECTOR;
    private static final Method GET_PARAMETERS;
    private static final Method SET_APPLICATION_PROTOCOLS;
    private static final Method SET_HANDSHAKE_APPLICATION_PROTOCOL_SELECTOR;
    private static final Method SET_PARAMETERS;
    private static final InternalLogger logger;

    static {
        Method method8;
        Method method7;
        Method method6;
        Method method5;
        Method method4;
        Method method2;
        Method method1;
        Class class1;
        BouncyCastleAlpnSslUtils.logger = InternalLoggerFactory.getInstance(BouncyCastleAlpnSslUtils.class);
        Method method0 = null;
        try {
            Class class0 = Class.forName("org.bouncycastle.jsse.BCSSLEngine");
            class1 = Class.forName("org.bouncycastle.jsse.BCApplicationProtocolSelector");
            method1 = (Method)AccessController.doPrivileged(new PrivilegedExceptionAction() {
                @Override
                public Object run() {
                    return this.run();
                }

                public Method run() {
                    return class1.getMethod("select", Object.class, List.class);
                }
            });
            SSLEngine sSLEngine0 = SslUtils.getSSLContext("BCJSSE").createSSLEngine();
            method2 = (Method)AccessController.doPrivileged(new PrivilegedExceptionAction() {
                @Override
                public Object run() {
                    return this.run();
                }

                public Method run() {
                    return class0.getMethod("getParameters", null);
                }
            });
            Object object0 = method2.invoke(sSLEngine0, null);
            Class class2 = object0.getClass();
            Method method3 = (Method)AccessController.doPrivileged(new PrivilegedExceptionAction() {
                @Override
                public Object run() {
                    return this.run();
                }

                public Method run() {
                    return class0.getMethod("setParameters", class2);
                }
            });
            method3.invoke(sSLEngine0, object0);
            method4 = (Method)AccessController.doPrivileged(new PrivilegedExceptionAction() {
                @Override
                public Object run() {
                    return this.run();
                }

                public Method run() {
                    return class2.getMethod("setApplicationProtocols", String[].class);
                }
            });
            method4.invoke(object0, EmptyArrays.EMPTY_STRINGS);
            method5 = (Method)AccessController.doPrivileged(new PrivilegedExceptionAction() {
                @Override
                public Object run() {
                    return this.run();
                }

                public Method run() {
                    return class0.getMethod("getApplicationProtocol", null);
                }
            });
            method5.invoke(sSLEngine0, null);
            method6 = (Method)AccessController.doPrivileged(new PrivilegedExceptionAction() {
                @Override
                public Object run() {
                    return this.run();
                }

                public Method run() {
                    return class0.getMethod("getHandshakeApplicationProtocol", null);
                }
            });
            method6.invoke(sSLEngine0, null);
            method7 = (Method)AccessController.doPrivileged(new PrivilegedExceptionAction() {
                @Override
                public Object run() {
                    return this.run();
                }

                public Method run() {
                    return class0.getMethod("setBCHandshakeApplicationProtocolSelector", class1);
                }
            });
            method8 = (Method)AccessController.doPrivileged(new PrivilegedExceptionAction() {
                @Override
                public Object run() {
                    return this.run();
                }

                public Method run() {
                    return class0.getMethod("getBCHandshakeApplicationProtocolSelector", null);
                }
            });
            method8.invoke(sSLEngine0, null);
            method0 = method3;
        }
        catch(Throwable throwable0) {
            BouncyCastleAlpnSslUtils.logger.error("Unable to initialize BouncyCastleAlpnSslUtils.", throwable0);
            method8 = null;
            class1 = null;
            method1 = null;
            method2 = null;
            method5 = null;
            method4 = null;
            method6 = null;
            method7 = null;
        }
        BouncyCastleAlpnSslUtils.SET_PARAMETERS = method0;
        BouncyCastleAlpnSslUtils.GET_PARAMETERS = method2;
        BouncyCastleAlpnSslUtils.SET_APPLICATION_PROTOCOLS = method4;
        BouncyCastleAlpnSslUtils.GET_APPLICATION_PROTOCOL = method5;
        BouncyCastleAlpnSslUtils.GET_HANDSHAKE_APPLICATION_PROTOCOL = method6;
        BouncyCastleAlpnSslUtils.SET_HANDSHAKE_APPLICATION_PROTOCOL_SELECTOR = method7;
        BouncyCastleAlpnSslUtils.GET_HANDSHAKE_APPLICATION_PROTOCOL_SELECTOR = method8;
        BouncyCastleAlpnSslUtils.BC_APPLICATION_PROTOCOL_SELECTOR_SELECT = method1;
        BouncyCastleAlpnSslUtils.BC_APPLICATION_PROTOCOL_SELECTOR = class1;
    }

    public static String getApplicationProtocol(SSLEngine sSLEngine0) {
        try {
            return (String)BouncyCastleAlpnSslUtils.GET_APPLICATION_PROTOCOL.invoke(sSLEngine0, null);
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
            return (String)BouncyCastleAlpnSslUtils.GET_HANDSHAKE_APPLICATION_PROTOCOL.invoke(sSLEngine0, null);
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
            return new BiFunction() {
                @Override
                public Object apply(Object object0, Object object1) {
                    return this.apply(((SSLEngine)object0), ((List)object1));
                }

                public String apply(SSLEngine sSLEngine0, List list0) {
                    try {
                        return (String)BouncyCastleAlpnSslUtils.BC_APPLICATION_PROTOCOL_SELECTOR_SELECT.invoke(BouncyCastleAlpnSslUtils.GET_HANDSHAKE_APPLICATION_PROTOCOL_SELECTOR.invoke(sSLEngine0, null), sSLEngine0, list0);
                    }
                    catch(Exception exception0) {
                        throw new RuntimeException("Could not call getHandshakeApplicationProtocolSelector", exception0);
                    }
                }
            };
        }
        catch(UnsupportedOperationException unsupportedOperationException0) {
            throw unsupportedOperationException0;
        }
        catch(Exception exception0) {
            throw new IllegalStateException(exception0);
        }
    }

    public static void setApplicationProtocols(SSLEngine sSLEngine0, List list0) {
        String[] arr_s = (String[])list0.toArray(EmptyArrays.EMPTY_STRINGS);
        try {
            Object object0 = BouncyCastleAlpnSslUtils.GET_PARAMETERS.invoke(sSLEngine0, null);
            BouncyCastleAlpnSslUtils.SET_APPLICATION_PROTOCOLS.invoke(object0, arr_s);
            BouncyCastleAlpnSslUtils.SET_PARAMETERS.invoke(sSLEngine0, object0);
        }
        catch(UnsupportedOperationException unsupportedOperationException0) {
            throw unsupportedOperationException0;
        }
        catch(Exception exception0) {
            throw new IllegalStateException(exception0);
        }
        if(PlatformDependent.javaVersion() >= 9) {
            JdkAlpnSslUtils.setApplicationProtocols(sSLEngine0, list0);
        }
    }

    public static void setHandshakeApplicationProtocolSelector(SSLEngine sSLEngine0, BiFunction biFunction0) {
        try {
            io.netty.handler.ssl.BouncyCastleAlpnSslUtils.9 bouncyCastleAlpnSslUtils$90 = new InvocationHandler() {
                @Override
                public Object invoke(Object object0, Method method0, Object[] arr_object) {
                    if(method0.getName().equals("select")) {
                        try {
                            return biFunction0.apply(((SSLEngine)arr_object[0]), ((List)arr_object[1]));
                        }
                        catch(ClassCastException classCastException0) {
                            throw new RuntimeException("BCApplicationProtocolSelector select method parameter of invalid type.", classCastException0);
                        }
                    }
                    throw new UnsupportedOperationException(x.k("Method \'", method0.getName(), "\' not supported."));
                }
            };
            Object[] arr_object = {Proxy.newProxyInstance(BouncyCastleAlpnSslUtils.class.getClassLoader(), new Class[]{BouncyCastleAlpnSslUtils.BC_APPLICATION_PROTOCOL_SELECTOR}, bouncyCastleAlpnSslUtils$90)};
            BouncyCastleAlpnSslUtils.SET_HANDSHAKE_APPLICATION_PROTOCOL_SELECTOR.invoke(sSLEngine0, arr_object);
        }
        catch(UnsupportedOperationException unsupportedOperationException0) {
            throw unsupportedOperationException0;
        }
        catch(Exception exception0) {
            throw new IllegalStateException(exception0);
        }
    }
}

