package io.netty.util.internal;

import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.security.AccessController;
import java.security.PrivilegedAction;

final class CleanerJava6 implements Cleaner {
    private static final Field CLEANER_FIELD;
    private static final long CLEANER_FIELD_OFFSET;
    private static final Method CLEAN_METHOD;
    private static final InternalLogger logger;

    static {
        Method method0;
        Field field0;
        CleanerJava6.logger = InternalLoggerFactory.getInstance(CleanerJava6.class);
        ByteBuffer byteBuffer0 = ByteBuffer.allocateDirect(1);
        long v = -1L;
        Throwable throwable0 = null;
        try {
            Object object0 = AccessController.doPrivileged(new PrivilegedAction() {
                @Override
                public Object run() {
                    try {
                        return byteBuffer0.getClass().getDeclaredField("cleaner");
                    }
                    catch(Throwable field0) {
                        return field0;
                    }
                }
            });
            if(object0 instanceof Throwable) {
                throw (Throwable)object0;
            }
            field0 = (Field)object0;
            long v1 = PlatformDependent0.objectFieldOffset(field0);
            Object object1 = PlatformDependent0.getObject(byteBuffer0, v1);
            method0 = object1.getClass().getDeclaredMethod("clean", null);
            method0.invoke(object1, null);
            v = v1;
        }
        catch(Throwable throwable1) {
            field0 = null;
            method0 = null;
            throwable0 = throwable1;
        }
        if(throwable0 == null) {
            CleanerJava6.logger.debug("java.nio.ByteBuffer.cleaner(): available");
        }
        else {
            CleanerJava6.logger.debug("java.nio.ByteBuffer.cleaner(): unavailable", throwable0);
        }
        CleanerJava6.CLEANER_FIELD = field0;
        CleanerJava6.CLEANER_FIELD_OFFSET = v;
        CleanerJava6.CLEAN_METHOD = method0;
    }

    @Override  // io.netty.util.internal.Cleaner
    public void freeDirectBuffer(ByteBuffer byteBuffer0) {
        if(!byteBuffer0.isDirect()) {
            return;
        }
        if(System.getSecurityManager() == null) {
            try {
                CleanerJava6.freeDirectBuffer0(byteBuffer0);
            }
            catch(Throwable throwable0) {
                PlatformDependent0.throwException(throwable0);
            }
            return;
        }
        CleanerJava6.freeDirectBufferPrivileged(byteBuffer0);
    }

    private static void freeDirectBuffer0(ByteBuffer byteBuffer0) {
        Object object0 = CleanerJava6.CLEANER_FIELD_OFFSET == -1L ? CleanerJava6.CLEANER_FIELD.get(byteBuffer0) : PlatformDependent0.getObject(byteBuffer0, CleanerJava6.CLEANER_FIELD_OFFSET);
        if(object0 != null) {
            CleanerJava6.CLEAN_METHOD.invoke(object0, null);
        }
    }

    private static void freeDirectBufferPrivileged(ByteBuffer byteBuffer0) {
        Throwable throwable0 = (Throwable)AccessController.doPrivileged(new PrivilegedAction() {
            @Override
            public Object run() {
                return this.run();
            }

            public Throwable run() {
                try {
                    CleanerJava6.freeDirectBuffer0(byteBuffer0);
                    return null;
                }
                catch(Throwable throwable0) {
                    return throwable0;
                }
            }
        });
        if(throwable0 != null) {
            PlatformDependent0.throwException(throwable0);
        }
    }

    public static boolean isSupported() [...] // 潜在的解密器
}

