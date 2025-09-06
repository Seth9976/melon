package io.netty.util.internal;

import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.concurrent.atomic.AtomicLong;
import sun.misc.Unsafe;

@SuppressJava6Requirement(reason = "Unsafe access is guarded")
final class PlatformDependent0 {
    static final boolean $assertionsDisabled = false;
    private static final long ADDRESS_FIELD_OFFSET = 0L;
    private static final Method ALIGN_SLICE = null;
    private static final Method ALLOCATE_ARRAY_METHOD = null;
    private static final long BITS_MAX_DIRECT_MEMORY = 0L;
    private static final long BYTE_ARRAY_BASE_OFFSET = 0L;
    private static final Constructor DIRECT_BUFFER_CONSTRUCTOR = null;
    private static final Throwable EXPLICIT_NO_UNSAFE_CAUSE = null;
    static final int HASH_CODE_ASCII_SEED = -1028477387;
    static final int HASH_CODE_C1 = 0xCC9E2D51;
    static final int HASH_CODE_C2 = 461845907;
    private static final Object INTERNAL_UNSAFE = null;
    private static final long INT_ARRAY_BASE_OFFSET = 0L;
    private static final long INT_ARRAY_INDEX_SCALE = 0L;
    private static final boolean IS_ANDROID = false;
    private static final boolean IS_EXPLICIT_TRY_REFLECTION_SET_ACCESSIBLE = false;
    private static final int JAVA_VERSION = 0;
    private static final long LONG_ARRAY_BASE_OFFSET = 0L;
    private static final long LONG_ARRAY_INDEX_SCALE = 0L;
    private static final boolean RUNNING_IN_NATIVE_IMAGE = false;
    private static final boolean STORE_FENCE_AVAILABLE = false;
    private static final boolean UNALIGNED = false;
    static final Unsafe UNSAFE = null;
    private static final long UNSAFE_COPY_THRESHOLD = 0x100000L;
    private static final Throwable UNSAFE_UNAVAILABILITY_CAUSE;
    private static final InternalLogger logger;

    static {
        boolean z1;
        long v2;
        Constructor constructor0;
        Object object4;
        boolean z;
        Field field0;
        Unsafe unsafe0;
        ByteBuffer byteBuffer0;
        InternalLogger internalLogger0 = InternalLoggerFactory.getInstance(PlatformDependent0.class);
        PlatformDependent0.logger = internalLogger0;
        Throwable throwable0 = PlatformDependent0.explicitNoUnsafeCause0();
        PlatformDependent0.EXPLICIT_NO_UNSAFE_CAUSE = throwable0;
        PlatformDependent0.JAVA_VERSION = PlatformDependent0.javaVersion0();
        PlatformDependent0.IS_ANDROID = PlatformDependent0.isAndroid0();
        PlatformDependent0.RUNNING_IN_NATIVE_IMAGE = SystemPropertyUtil.contains("org.graalvm.nativeimage.imagecode");
        PlatformDependent0.IS_EXPLICIT_TRY_REFLECTION_SET_ACCESSIBLE = PlatformDependent0.explicitTryReflectionSetAccessible0();
        Class class0 = byte[].class;
        if(throwable0 == null) {
            byteBuffer0 = ByteBuffer.allocateDirect(1);
            Object object0 = AccessController.doPrivileged(new PrivilegedAction() {
                @Override
                public Object run() {
                    try {
                        Field field0 = Unsafe.class.getDeclaredField("theUnsafe");
                        Throwable throwable0 = ReflectionUtil.trySetAccessible(field0, false);
                        return throwable0 != null ? throwable0 : field0.get(null);
                    }
                    catch(NoSuchFieldException object0) {
                        return object0;
                    }
                    catch(SecurityException object0) {
                        return object0;
                    }
                    catch(IllegalAccessException object0) {
                        return object0;
                    }
                    catch(NoClassDefFoundError object0) {
                        return object0;
                    }
                }
            });
            if(object0 instanceof Throwable) {
                throwable0 = (Throwable)object0;
                if(internalLogger0.isTraceEnabled()) {
                    internalLogger0.debug("sun.misc.Unsafe.theUnsafe: unavailable", throwable0);
                }
                else {
                    internalLogger0.debug("sun.misc.Unsafe.theUnsafe: unavailable: {}", throwable0.getMessage());
                }
                unsafe0 = null;
            }
            else {
                unsafe0 = (Unsafe)object0;
                internalLogger0.debug("sun.misc.Unsafe.theUnsafe: available");
            }
            if(unsafe0 != null) {
                Object object1 = AccessController.doPrivileged(new PrivilegedAction() {
                    @Override
                    public Object run() {
                        try {
                            unsafe0.getClass().getDeclaredMethod("copyMemory", Object.class, Long.TYPE, Object.class, Long.TYPE, Long.TYPE);
                            return null;
                        }
                        catch(NoSuchMethodException object0) {
                            return object0;
                        }
                        catch(SecurityException object0) {
                            return object0;
                        }
                    }
                });
                if(object1 == null) {
                    internalLogger0.debug("sun.misc.Unsafe.copyMemory: available");
                }
                else {
                    throwable0 = (Throwable)object1;
                    if(internalLogger0.isTraceEnabled()) {
                        internalLogger0.debug("sun.misc.Unsafe.copyMemory: unavailable", throwable0);
                    }
                    else {
                        internalLogger0.debug("sun.misc.Unsafe.copyMemory: unavailable: {}", throwable0.getMessage());
                    }
                    unsafe0 = null;
                }
            }
            if(unsafe0 == null) {
                z = false;
            }
            else {
                Object object2 = AccessController.doPrivileged(new PrivilegedAction() {
                    @Override
                    public Object run() {
                        try {
                            unsafe0.getClass().getDeclaredMethod("storeFence", null);
                            return null;
                        }
                        catch(NoSuchMethodException object0) {
                            return object0;
                        }
                        catch(SecurityException object0) {
                            return object0;
                        }
                    }
                });
                if(object2 == null) {
                    internalLogger0.debug("sun.misc.Unsafe.storeFence: available");
                    z = true;
                }
                else {
                    if(internalLogger0.isTraceEnabled()) {
                        internalLogger0.debug("sun.misc.Unsafe.storeFence: unavailable", ((Throwable)object2));
                    }
                    else {
                        internalLogger0.debug("sun.misc.Unsafe.storeFence: unavailable: {}", ((Throwable)object2).getMessage());
                    }
                    z = false;
                }
            }
            if(unsafe0 == null) {
                field0 = null;
            }
            else {
                Object object3 = AccessController.doPrivileged(new PrivilegedAction() {
                    @Override
                    public Object run() {
                        try {
                            Field field0 = Buffer.class.getDeclaredField("address");
                            long v = unsafe0.objectFieldOffset(field0);
                            return unsafe0.getLong(byteBuffer0, v) == 0L ? null : field0;
                        }
                        catch(NoSuchFieldException object0) {
                            return object0;
                        }
                        catch(SecurityException object0) {
                            return object0;
                        }
                    }
                });
                if(object3 instanceof Field) {
                    field0 = (Field)object3;
                    internalLogger0.debug("java.nio.Buffer.address: available");
                }
                else {
                    if(internalLogger0.isTraceEnabled()) {
                        internalLogger0.debug("java.nio.Buffer.address: unavailable", ((Throwable)object3));
                    }
                    else {
                        internalLogger0.debug("java.nio.Buffer.address: unavailable: {}", ((Throwable)object3).getMessage());
                    }
                    unsafe0 = null;
                    throwable0 = (Throwable)object3;
                    field0 = null;
                }
            }
            if(unsafe0 != null) {
                long v = (long)unsafe0.arrayIndexScale(class0);
                if(v != 1L) {
                    internalLogger0.debug("unsafe.arrayIndexScale is {} (expected: 1). Not using unsafe.", v);
                    throwable0 = new UnsupportedOperationException("Unexpected unsafe.arrayIndexScale");
                    unsafe0 = null;
                }
            }
        }
        else {
            byteBuffer0 = null;
            unsafe0 = null;
            field0 = null;
            z = false;
        }
        PlatformDependent0.UNSAFE_UNAVAILABILITY_CAUSE = throwable0;
        PlatformDependent0.UNSAFE = unsafe0;
        long v1 = -1L;
        if(unsafe0 == null) {
            PlatformDependent0.ADDRESS_FIELD_OFFSET = -1L;
            PlatformDependent0.BYTE_ARRAY_BASE_OFFSET = -1L;
            PlatformDependent0.LONG_ARRAY_BASE_OFFSET = -1L;
            PlatformDependent0.LONG_ARRAY_INDEX_SCALE = -1L;
            PlatformDependent0.INT_ARRAY_BASE_OFFSET = -1L;
            PlatformDependent0.INT_ARRAY_INDEX_SCALE = -1L;
            PlatformDependent0.UNALIGNED = false;
            PlatformDependent0.BITS_MAX_DIRECT_MEMORY = -1L;
            PlatformDependent0.DIRECT_BUFFER_CONSTRUCTOR = null;
            PlatformDependent0.ALLOCATE_ARRAY_METHOD = null;
            PlatformDependent0.STORE_FENCE_AVAILABLE = false;
        }
        else {
            try {
                object4 = AccessController.doPrivileged(new PrivilegedAction() {
                    @Override
                    public Object run() {
                        Throwable throwable0;
                        try {
                            Class class0 = Long.TYPE;
                            constructor0 = byteBuffer0.getClass().getDeclaredConstructor(class0, Integer.TYPE);
                            throwable0 = ReflectionUtil.trySetAccessible(constructor0, true);
                            return throwable0 != null ? throwable0 : constructor0;
                        }
                        catch(NoSuchMethodException constructor0) {
                        }
                        catch(SecurityException constructor0) {
                        }
                        return constructor0;
                    }
                });
                if(object4 instanceof Constructor) {
                    v2 = unsafe0.allocateMemory(1L);
                    goto label_100;
                }
                else {
                    if(internalLogger0.isTraceEnabled()) {
                        internalLogger0.debug("direct buffer constructor: unavailable", ((Throwable)object4));
                    }
                    else {
                        internalLogger0.debug("direct buffer constructor: unavailable: {}", ((Throwable)object4).getMessage());
                    }
                    constructor0 = null;
                    v2 = -1L;
                }
                goto label_110;
            }
            catch(Throwable throwable1) {
                v2 = -1L;
                goto label_107;
            }
            try {
            label_100:
                ((Constructor)object4).newInstance(v2, 1);
                constructor0 = (Constructor)object4;
                internalLogger0.debug("direct buffer constructor: available");
                goto label_110;
            }
            catch(InstantiationException | IllegalAccessException | InvocationTargetException unused_ex) {
                constructor0 = null;
                goto label_110;
            }
            catch(Throwable throwable1) {
            }
        label_107:
            if(v2 != -1L) {
                PlatformDependent0.UNSAFE.freeMemory(v2);
            }
            throw throwable1;
        label_110:
            if(v2 != -1L) {
                PlatformDependent0.UNSAFE.freeMemory(v2);
            }
            PlatformDependent0.DIRECT_BUFFER_CONSTRUCTOR = constructor0;
            PlatformDependent0.ADDRESS_FIELD_OFFSET = PlatformDependent0.objectFieldOffset(field0);
            PlatformDependent0.BYTE_ARRAY_BASE_OFFSET = (long)PlatformDependent0.UNSAFE.arrayBaseOffset(class0);
            PlatformDependent0.INT_ARRAY_BASE_OFFSET = (long)PlatformDependent0.UNSAFE.arrayBaseOffset(int[].class);
            PlatformDependent0.INT_ARRAY_INDEX_SCALE = (long)PlatformDependent0.UNSAFE.arrayIndexScale(int[].class);
            PlatformDependent0.LONG_ARRAY_BASE_OFFSET = (long)PlatformDependent0.UNSAFE.arrayBaseOffset(long[].class);
            PlatformDependent0.LONG_ARRAY_INDEX_SCALE = (long)PlatformDependent0.UNSAFE.arrayIndexScale(long[].class);
            AtomicLong atomicLong0 = new AtomicLong(-1L);
            Object object5 = AccessController.doPrivileged(new PrivilegedAction() {
                @Override
                public Object run() {
                    try {
                        Method method0 = Class.forName("java.nio.Bits", false, PlatformDependent0.getSystemClassLoader()).getDeclaredMethod("unaligned", null);
                        Throwable throwable0 = ReflectionUtil.trySetAccessible(method0, true);
                        return throwable0 != null ? throwable0 : method0.invoke(null, null);
                    }
                    catch(NoSuchMethodException object0) {
                    }
                    catch(SecurityException object0) {
                    }
                    catch(IllegalAccessException object0) {
                    }
                    catch(ClassNotFoundException object0) {
                    }
                    catch(InvocationTargetException object0) {
                    }
                    return object0;
                }
            });
            if(object5 instanceof Boolean) {
                z1 = ((Boolean)object5).booleanValue();
                PlatformDependent0.logger.debug("java.nio.Bits.unaligned: available, {}", ((Boolean)object5));
            }
            else {
                z1 = false;
                InternalLogger internalLogger1 = PlatformDependent0.logger;
                if(internalLogger1.isTraceEnabled()) {
                    internalLogger1.debug("java.nio.Bits.unaligned: unavailable, {}", Boolean.FALSE, ((Throwable)object5));
                }
                else {
                    internalLogger1.debug("java.nio.Bits.unaligned: unavailable, {}, {}", Boolean.FALSE, ((Throwable)object5).getMessage());
                }
            }
            PlatformDependent0.UNALIGNED = z1;
            if(atomicLong0.get() >= 0L) {
                v1 = atomicLong0.get();
            }
            PlatformDependent0.BITS_MAX_DIRECT_MEMORY = v1;
            PlatformDependent0.logger.debug("jdk.internal.misc.Unsafe.allocateUninitializedArray(int): unavailable prior to Java9");
            PlatformDependent0.ALLOCATE_ARRAY_METHOD = null;
            PlatformDependent0.STORE_FENCE_AVAILABLE = z;
        }
        PlatformDependent0.ALIGN_SLICE = null;
        PlatformDependent0.INTERNAL_UNSAFE = null;
        PlatformDependent0.logger.debug("java.nio.DirectByteBuffer.<init>(long, {int,long}): {}", "unavailable");
    }

    public static boolean access$000() [...] // 潜在的解密器

    public static int addressSize() {
        return PlatformDependent0.UNSAFE.addressSize();
    }

    public static ByteBuffer alignSlice(ByteBuffer byteBuffer0, int v) {
        try {
            return (ByteBuffer)PlatformDependent0.ALIGN_SLICE.invoke(byteBuffer0, v);
        }
        catch(IllegalAccessException illegalAccessException0) {
            throw new Error(illegalAccessException0);
        }
        catch(InvocationTargetException invocationTargetException0) {
            throw new Error(invocationTargetException0);
        }
    }

    public static ByteBuffer allocateDirectNoCleaner(int v) {
        return PlatformDependent0.newDirectBuffer(PlatformDependent0.UNSAFE.allocateMemory(((long)Math.max(1, v))), v);
    }

    public static long allocateMemory(long v) {
        return PlatformDependent0.UNSAFE.allocateMemory(v);
    }

    public static byte[] allocateUninitializedArray(int v) {
        try {
            return (byte[])PlatformDependent0.ALLOCATE_ARRAY_METHOD.invoke(PlatformDependent0.INTERNAL_UNSAFE, Byte.TYPE, v);
        }
        catch(IllegalAccessException illegalAccessException0) {
            throw new Error(illegalAccessException0);
        }
        catch(InvocationTargetException invocationTargetException0) {
            throw new Error(invocationTargetException0);
        }
    }

    public static long bitsMaxDirectMemory() [...] // 潜在的解密器

    public static long byteArrayBaseOffset() [...] // 潜在的解密器

    public static void copyMemory(long v, long v1, long v2) {
        if(PlatformDependent0.javaVersion() <= 8) {
            PlatformDependent0.copyMemoryWithSafePointPolling(v, v1, v2);
            return;
        }
        PlatformDependent0.UNSAFE.copyMemory(v, v1, v2);
    }

    public static void copyMemory(Object object0, long v, Object object1, long v1, long v2) {
        PlatformDependent0.copyMemoryWithSafePointPolling(object0, v, object1, v1, v2);
    }

    private static void copyMemoryWithSafePointPolling(long v, long v1, long v2) {
        while(v2 > 0L) {
            long v3 = Math.min(v2, 0x100000L);
            PlatformDependent0.UNSAFE.copyMemory(v, v1, v3);
            v2 -= v3;
            v += v3;
            v1 += v3;
        }
    }

    private static void copyMemoryWithSafePointPolling(Object object0, long v, Object object1, long v1, long v2) {
        while(v2 > 0L) {
            long v3 = Math.min(v2, 0x100000L);
            PlatformDependent0.UNSAFE.copyMemory(object0, v, object1, v1, v3);
            v2 -= v3;
            v += v3;
            v1 += v3;
        }
    }

    public static long directBufferAddress(ByteBuffer byteBuffer0) {
        return PlatformDependent0.getLong(byteBuffer0, PlatformDependent0.ADDRESS_FIELD_OFFSET);
    }

    public static boolean equals(byte[] arr_b, int v, byte[] arr_b1, int v1, int v2) {
        int v3 = v2 & 7;
        long v4 = (long)(v1 - v);
        if(v2 >= 8) {
            long v5 = ((long)v3) + ((long)v);
            for(long v6 = ((long)v) - 8L + ((long)v2); v6 >= v5; v6 -= 8L) {
                if(PlatformDependent0.UNSAFE.getLong(arr_b, v6) != PlatformDependent0.UNSAFE.getLong(arr_b1, v6 + v4)) {
                    return false;
                }
            }
        }
        if(v3 >= 4) {
            v3 -= 4;
            long v7 = ((long)v3) + ((long)v);
            if(PlatformDependent0.UNSAFE.getInt(arr_b, v7) != PlatformDependent0.UNSAFE.getInt(arr_b1, v7 + v4)) {
                return false;
            }
        }
        long v8 = v4 + ((long)v);
        return v3 < 2 ? v3 == 0 || PlatformDependent0.UNSAFE.getByte(arr_b, ((long)v)) == PlatformDependent0.UNSAFE.getByte(arr_b1, v8) : PlatformDependent0.UNSAFE.getChar(arr_b, ((long)v)) == PlatformDependent0.UNSAFE.getChar(arr_b1, v8) && (v3 == 2 || PlatformDependent0.UNSAFE.getByte(arr_b, 2L + ((long)v)) == PlatformDependent0.UNSAFE.getByte(arr_b1, v8 + 2L));
    }

    public static int equalsConstantTime(byte[] arr_b, int v, byte[] arr_b1, int v1, int v2) {
        long v3 = (long)(v2 & 7);
        long v4 = ((long)v) + v3;
        long v5 = (long)(v1 - v);
        long v6 = ((long)v) - 8L + ((long)v2);
        long v7 = 0L;
        while(v6 >= v4) {
            v7 |= PlatformDependent0.UNSAFE.getLong(arr_b, v6) ^ PlatformDependent0.UNSAFE.getLong(arr_b1, v6 + v5);
            v6 -= 8L;
        }
        if(v3 >= 4L) {
            int v8 = PlatformDependent0.UNSAFE.getInt(arr_b, ((long)v));
            v7 |= (long)(PlatformDependent0.UNSAFE.getInt(arr_b1, ((long)v) + v5) ^ v8);
            v3 -= 4L;
        }
        if(v3 >= 2L) {
            long v9 = v4 - v3;
            int v10 = PlatformDependent0.UNSAFE.getChar(arr_b, v9);
            v7 |= (long)(PlatformDependent0.UNSAFE.getChar(arr_b1, v9 + v5) ^ v10);
            v3 -= 2L;
        }
        if(v3 == 1L) {
            v7 |= (long)(PlatformDependent0.UNSAFE.getByte(arr_b, v4 - 1L) ^ PlatformDependent0.UNSAFE.getByte(arr_b1, v4 - 1L + v5));
        }
        return 0;
    }

    private static Throwable explicitNoUnsafeCause0() {
        String s = "io.netty.tryUnsafe";
        boolean z = SystemPropertyUtil.getBoolean("io.netty.noUnsafe", false);
        InternalLogger internalLogger0 = PlatformDependent0.logger;
        internalLogger0.debug("-Dio.netty.noUnsafe: {}", Boolean.valueOf(z));
        if(z) {
            internalLogger0.debug("sun.misc.Unsafe: unavailable (io.netty.noUnsafe)");
            return new UnsupportedOperationException("sun.misc.Unsafe: unavailable (io.netty.noUnsafe)");
        }
        if(!SystemPropertyUtil.contains("io.netty.tryUnsafe")) {
            s = "org.jboss.netty.tryUnsafe";
        }
        if(!SystemPropertyUtil.getBoolean(s, true)) {
            String s1 = "sun.misc.Unsafe: unavailable (" + s + ")";
            internalLogger0.debug(s1);
            return new UnsupportedOperationException(s1);
        }
        return null;
    }

    // 去混淆评级： 低(20)
    private static boolean explicitTryReflectionSetAccessible0() {
        return SystemPropertyUtil.getBoolean("io.netty.tryReflectionSetAccessible", true);
    }

    public static void freeMemory(long v) {
        PlatformDependent0.UNSAFE.freeMemory(v);
    }

    public static byte getByte(long v) {
        return PlatformDependent0.UNSAFE.getByte(v);
    }

    public static byte getByte(byte[] arr_b, int v) {
        return PlatformDependent0.UNSAFE.getByte(arr_b, ((long)v));
    }

    public static byte getByte(byte[] arr_b, long v) {
        return PlatformDependent0.UNSAFE.getByte(arr_b, v);
    }

    public static ClassLoader getClassLoader(Class class0) {
        return System.getSecurityManager() == null ? class0.getClassLoader() : ((ClassLoader)AccessController.doPrivileged(new PrivilegedAction() {
            public ClassLoader run() {
                return class0.getClassLoader();
            }

            @Override
            public Object run() {
                return this.run();
            }
        }));
    }

    public static ClassLoader getContextClassLoader() {
        return System.getSecurityManager() == null ? Thread.currentThread().getContextClassLoader() : ((ClassLoader)AccessController.doPrivileged(new PrivilegedAction() {
            public ClassLoader run() {
                return Thread.currentThread().getContextClassLoader();
            }

            @Override
            public Object run() {
                return this.run();
            }
        }));
    }

    public static int getInt(long v) {
        return PlatformDependent0.UNSAFE.getInt(v);
    }

    public static int getInt(Object object0, long v) {
        return PlatformDependent0.UNSAFE.getInt(object0, v);
    }

    public static int getInt(byte[] arr_b, int v) {
        return PlatformDependent0.UNSAFE.getInt(arr_b, ((long)v));
    }

    public static int getInt(int[] arr_v, long v) {
        return PlatformDependent0.UNSAFE.getInt(arr_v, PlatformDependent0.INT_ARRAY_INDEX_SCALE * v + PlatformDependent0.INT_ARRAY_BASE_OFFSET);
    }

    public static int getIntVolatile(long v) {
        return PlatformDependent0.UNSAFE.getIntVolatile(null, v);
    }

    public static long getLong(long v) {
        return PlatformDependent0.UNSAFE.getLong(v);
    }

    private static long getLong(Object object0, long v) {
        return PlatformDependent0.UNSAFE.getLong(object0, v);
    }

    public static long getLong(byte[] arr_b, int v) {
        return PlatformDependent0.UNSAFE.getLong(arr_b, ((long)v));
    }

    public static long getLong(long[] arr_v, long v) {
        return PlatformDependent0.UNSAFE.getLong(arr_v, PlatformDependent0.LONG_ARRAY_INDEX_SCALE * v + PlatformDependent0.LONG_ARRAY_BASE_OFFSET);
    }

    public static Object getObject(Object object0, long v) {
        return PlatformDependent0.UNSAFE.getObject(object0, v);
    }

    public static short getShort(long v) {
        return PlatformDependent0.UNSAFE.getShort(v);
    }

    public static short getShort(byte[] arr_b, int v) {
        return PlatformDependent0.UNSAFE.getShort(arr_b, ((long)v));
    }

    public static ClassLoader getSystemClassLoader() {
        return System.getSecurityManager() == null ? ClassLoader.getSystemClassLoader() : ((ClassLoader)AccessController.doPrivileged(new PrivilegedAction() {
            public ClassLoader run() {
                return ClassLoader.getSystemClassLoader();
            }

            @Override
            public Object run() {
                return this.run();
            }
        }));
    }

    public static Throwable getUnsafeUnavailabilityCause() {
        return PlatformDependent0.UNSAFE_UNAVAILABILITY_CAUSE;
    }

    public static boolean hasAlignSliceMethod() [...] // 潜在的解密器

    public static boolean hasAllocateArrayMethod() [...] // 潜在的解密器

    public static boolean hasDirectBufferNoCleanerConstructor() [...] // 潜在的解密器

    public static boolean hasUnsafe() [...] // 潜在的解密器

    public static int hashCodeAscii(byte[] arr_b, int v, int v1) {
        int v9;
        int v7;
        int v6;
        long v2 = (long)v;
        long v3 = ((long)(v1 & 7)) + v2;
        long v4 = v2 - 8L + ((long)v1);
        int v5 = -1028477387;
        while(true) {
            v6 = 0;
            if(v4 < v3) {
                break;
            }
            v5 = PlatformDependent0.hashCodeAsciiCompute(PlatformDependent0.UNSAFE.getLong(arr_b, v4), v5);
            v4 -= 8L;
        }
        switch(v1 & 7) {
            case 0: {
                return v5;
            }
            case 2: {
                v7 = 0;
                break;
            }
            default: {
                v7 = 1;
                break;
            }
        }
        int v8 = 461845907;
        if((v7 & ((v1 & 7) == 4 ? 0 : 1) & ((v1 & 7) == 6 ? 0 : 1)) == 0) {
            v9 = 0xCC9E2D51;
        }
        else {
            v5 = v5 * 0xCC9E2D51 + PlatformDependent0.hashCodeAsciiSanitize(PlatformDependent0.UNSAFE.getByte(arr_b, v2));
            ++v2;
            v9 = 461845907;
        }
        if((v1 & 7) != 5) {
            v6 = 1;
        }
        if((v6 & (((v1 & 7) == 1 ? 0 : 1) & ((v1 & 7) == 4 ? 0 : 1))) != 0) {
            v5 = v5 * v9 + PlatformDependent0.hashCodeAsciiSanitize(PlatformDependent0.UNSAFE.getShort(arr_b, v2));
            if(v9 != 0xCC9E2D51) {
                v8 = 0xCC9E2D51;
            }
            v2 += 2L;
            v9 = v8;
        }
        return (v1 & 7) < 4 ? v5 : v5 * v9 + PlatformDependent0.hashCodeAsciiSanitize(PlatformDependent0.UNSAFE.getInt(arr_b, v2));
    }

    public static int hashCodeAsciiCompute(long v, int v1) {
        return (((int)v) & 0x1F1F1F1F) * 461845907 + v1 * 0xCC9E2D51 + ((int)((v & 0x1F1F1F1F00000000L) >>> 0x20));
    }

    public static int hashCodeAsciiSanitize(byte b) {
        return b & 0x1F;
    }

    public static int hashCodeAsciiSanitize(int v) [...] // Inlined contents

    public static int hashCodeAsciiSanitize(short v) {
        return v & 0x1F1F;
    }

    public static boolean isAndroid() [...] // 潜在的解密器

    // 去混淆评级： 低(20)
    private static boolean isAndroid0() {
        PlatformDependent0.logger.debug("Platform: Android");
        return true;
    }

    public static boolean isExplicitNoUnsafe() [...] // 潜在的解密器

    public static boolean isExplicitTryReflectionSetAccessible() [...] // 潜在的解密器

    public static boolean isUnaligned() [...] // 潜在的解密器

    public static boolean isZero(byte[] arr_b, int v, int v1) {
        if(v1 <= 0) {
            return true;
        }
        int v2 = v1 & 7;
        long v3 = ((long)v2) + ((long)v);
        for(long v4 = ((long)v) - 8L + ((long)v1); Long.compare(v4, v3) >= 0; v4 -= 8L) {
            if(PlatformDependent0.UNSAFE.getLong(arr_b, v4) != 0L) {
                return false;
            }
        }
        if(v2 >= 4) {
            v2 -= 4;
            if(PlatformDependent0.UNSAFE.getInt(arr_b, ((long)v2) + ((long)v)) != 0) {
                return false;
            }
        }
        return v2 < 2 ? arr_b[v] == 0 : PlatformDependent0.UNSAFE.getChar(arr_b, ((long)v)) == 0 && (v2 == 2 || arr_b[v + 2] == 0);
    }

    public static int javaVersion() [...] // 潜在的解密器

    private static int javaVersion0() {
        int v = PlatformDependent0.isAndroid0() ? 6 : PlatformDependent0.majorVersionFromJavaSpecificationVersion();
        PlatformDependent0.logger.debug("Java version: {}", v);
        return v;
    }

    public static int majorVersion(String s) [...] // Inlined contents

    // 去混淆评级： 低(20)
    public static int majorVersionFromJavaSpecificationVersion() {
        return 0;
    }

    public static ByteBuffer newDirectBuffer(long v, int v1) {
        ObjectUtil.checkPositiveOrZero(v1, "capacity");
        try {
            return (ByteBuffer)PlatformDependent0.DIRECT_BUFFER_CONSTRUCTOR.newInstance(v, v1);
        }
        catch(Throwable throwable0) {
            throw throwable0 instanceof Error ? ((Error)throwable0) : new Error(throwable0);
        }
    }

    public static long objectFieldOffset(Field field0) {
        return PlatformDependent0.UNSAFE.objectFieldOffset(field0);
    }

    public static void putByte(long v, byte b) {
        PlatformDependent0.UNSAFE.putByte(v, b);
    }

    public static void putByte(Object object0, long v, byte b) {
        PlatformDependent0.UNSAFE.putByte(object0, v, b);
    }

    public static void putByte(byte[] arr_b, int v, byte b) {
        PlatformDependent0.UNSAFE.putByte(arr_b, ((long)v), b);
    }

    public static void putInt(long v, int v1) {
        PlatformDependent0.UNSAFE.putInt(v, v1);
    }

    public static void putInt(byte[] arr_b, int v, int v1) {
        PlatformDependent0.UNSAFE.putInt(arr_b, ((long)v), v1);
    }

    public static void putIntOrdered(long v, int v1) {
        PlatformDependent0.UNSAFE.putOrderedInt(null, v, v1);
    }

    public static void putLong(long v, long v1) {
        PlatformDependent0.UNSAFE.putLong(v, v1);
    }

    public static void putLong(byte[] arr_b, int v, long v1) {
        PlatformDependent0.UNSAFE.putLong(arr_b, ((long)v), v1);
    }

    public static void putObject(Object object0, long v, Object object1) {
        PlatformDependent0.UNSAFE.putObject(object0, v, object1);
    }

    public static void putShort(long v, short v1) {
        PlatformDependent0.UNSAFE.putShort(v, v1);
    }

    public static void putShort(byte[] arr_b, int v, short v1) {
        PlatformDependent0.UNSAFE.putShort(arr_b, ((long)v), v1);
    }

    public static ByteBuffer reallocateDirectNoCleaner(ByteBuffer byteBuffer0, int v) {
        long v1 = PlatformDependent0.directBufferAddress(byteBuffer0);
        return PlatformDependent0.newDirectBuffer(PlatformDependent0.UNSAFE.reallocateMemory(v1, ((long)v)), v);
    }

    public static long reallocateMemory(long v, long v1) {
        return PlatformDependent0.UNSAFE.reallocateMemory(v, v1);
    }

    public static void safeConstructPutInt(Object object0, long v, int v1) {
        if(PlatformDependent0.STORE_FENCE_AVAILABLE) {
            PlatformDependent0.UNSAFE.putInt(object0, v, v1);
            PlatformDependent0.UNSAFE.storeFence();
            return;
        }
        PlatformDependent0.UNSAFE.putIntVolatile(object0, v, v1);
    }

    public static void setMemory(long v, long v1, byte b) {
        PlatformDependent0.UNSAFE.setMemory(v, v1, b);
    }

    public static void setMemory(Object object0, long v, long v1, byte b) {
        PlatformDependent0.UNSAFE.setMemory(object0, v, v1, b);
    }

    public static void throwException(Throwable throwable0) {
        Throwable throwable1 = (Throwable)ObjectUtil.checkNotNull(throwable0, "cause");
        PlatformDependent0.UNSAFE.throwException(throwable1);
    }

    public static boolean unalignedAccess() [...] // 潜在的解密器

    private static boolean unsafeStaticFieldOffsetSupported() [...] // 潜在的解密器

    final class io.netty.util.internal.PlatformDependent0.7 implements PrivilegedAction {
        @Override
        public Object run() {
            try {
                return PlatformDependent0.getClassLoader(PlatformDependent0.class).loadClass("jdk.internal.misc.Unsafe").getDeclaredMethod("getUnsafe", null).invoke(null, null);
            }
            catch(Throwable object0) {
                return object0;
            }
        }
    }


    final class io.netty.util.internal.PlatformDependent0.8 implements PrivilegedAction {
        public io.netty.util.internal.PlatformDependent0.8(Object object0) {
        }

        @Override
        public Object run() {
            try {
                return this.val$finalInternalUnsafe.getClass().getDeclaredMethod("allocateUninitializedArray", Class.class, Integer.TYPE);
            }
            catch(NoSuchMethodException object0) {
                return object0;
            }
            catch(SecurityException object0) {
                return object0;
            }
        }
    }


    final class io.netty.util.internal.PlatformDependent0.9 implements PrivilegedAction {
        @Override
        public Object run() {
            try {
                return ByteBuffer.class.getDeclaredMethod("alignedSlice", Integer.TYPE);
            }
            catch(Exception unused_ex) {
                return null;
            }
        }
    }

}

