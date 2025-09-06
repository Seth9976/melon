package io.netty.util.internal;

import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.security.AccessController;
import java.security.PrivilegedAction;

final class CleanerJava9 implements Cleaner {
    private static final Method INVOKE_CLEANER;
    private static final InternalLogger logger;

    static {
        Method method0;
        InternalLogger internalLogger0 = InternalLoggerFactory.getInstance(CleanerJava9.class);
        CleanerJava9.logger = internalLogger0;
        Throwable throwable0 = null;
        if(PlatformDependent0.hasUnsafe()) {
            Object object0 = AccessController.doPrivileged(new PrivilegedAction() {
                @Override
                public Object run() {
                    try {
                        Method method0 = PlatformDependent0.UNSAFE.getClass().getDeclaredMethod("invokeCleaner", ByteBuffer.class);
                        method0.invoke(PlatformDependent0.UNSAFE, ByteBuffer.allocateDirect(1));
                        return method0;
                    }
                    catch(NoSuchMethodException object0) {
                        return object0;
                    }
                    catch(InvocationTargetException object0) {
                        return object0;
                    }
                    catch(IllegalAccessException object0) {
                        return object0;
                    }
                }
            });
            if(object0 instanceof Throwable) {
                throwable0 = (Throwable)object0;
                method0 = null;
            }
            else {
                method0 = (Method)object0;
            }
        }
        else {
            throwable0 = new UnsupportedOperationException("sun.misc.Unsafe unavailable");
            method0 = null;
        }
        if(throwable0 == null) {
            internalLogger0.debug("java.nio.ByteBuffer.cleaner(): available");
        }
        else {
            internalLogger0.debug("java.nio.ByteBuffer.cleaner(): unavailable", throwable0);
        }
        CleanerJava9.INVOKE_CLEANER = method0;
    }

    @Override  // io.netty.util.internal.Cleaner
    public void freeDirectBuffer(ByteBuffer byteBuffer0) {
        if(System.getSecurityManager() == null) {
            try {
                CleanerJava9.INVOKE_CLEANER.invoke(PlatformDependent0.UNSAFE, byteBuffer0);
            }
            catch(Throwable throwable0) {
                PlatformDependent0.throwException(throwable0);
            }
            return;
        }
        CleanerJava9.freeDirectBufferPrivileged(byteBuffer0);
    }

    private static void freeDirectBufferPrivileged(ByteBuffer byteBuffer0) {
        Exception exception0 = (Exception)AccessController.doPrivileged(new PrivilegedAction() {
            public Exception run() {
                try {
                    CleanerJava9.INVOKE_CLEANER.invoke(PlatformDependent0.UNSAFE, byteBuffer0);
                    return null;
                }
                catch(InvocationTargetException exception0) {
                    return exception0;
                }
                catch(IllegalAccessException exception0) {
                    return exception0;
                }
            }

            @Override
            public Object run() {
                return this.run();
            }
        });
        if(exception0 != null) {
            PlatformDependent0.throwException(exception0);
        }
    }

    public static boolean isSupported() {
        return CleanerJava9.INVOKE_CLEANER != null;
    }
}

