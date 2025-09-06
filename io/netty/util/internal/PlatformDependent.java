package io.netty.util.internal;

import U4.x;
import io.netty.util.CharsetUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import io.netty.util.internal.shaded.org.jctools.queues.MpscArrayQueue;
import io.netty.util.internal.shaded.org.jctools.queues.MpscChunkedArrayQueue;
import io.netty.util.internal.shaded.org.jctools.queues.MpscUnboundedArrayQueue;
import io.netty.util.internal.shaded.org.jctools.queues.SpscLinkedQueue;
import io.netty.util.internal.shaded.org.jctools.queues.atomic.MpscAtomicArrayQueue;
import io.netty.util.internal.shaded.org.jctools.queues.atomic.MpscChunkedAtomicArrayQueue;
import io.netty.util.internal.shaded.org.jctools.queues.atomic.MpscUnboundedAtomicArrayQueue;
import io.netty.util.internal.shaded.org.jctools.queues.atomic.SpscLinkedAtomicQueue;
import io.netty.util.internal.shaded.org.jctools.util.Pow2;
import io.netty.util.internal.shaded.org.jctools.util.UnsafeAccess;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Queue;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicLong;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class PlatformDependent {
    static final class AtomicLongCounter extends AtomicLong implements LongCounter {
        private static final long serialVersionUID = 0x388C80422F257DC9L;

        private AtomicLongCounter() {
        }

        public AtomicLongCounter(io.netty.util.internal.PlatformDependent.1 platformDependent$10) {
        }

        @Override  // io.netty.util.internal.LongCounter
        public void add(long v) {
            this.addAndGet(v);
        }

        @Override  // io.netty.util.internal.LongCounter
        public void decrement() {
            this.decrementAndGet();
        }

        @Override  // io.netty.util.internal.LongCounter
        public void increment() {
            this.incrementAndGet();
        }

        @Override  // io.netty.util.internal.LongCounter
        public long value() {
            return this.get();
        }
    }

    static final class Mpsc {
        private static final boolean USE_MPSC_CHUNKED_ARRAY_QUEUE;

        static {
            if(AccessController.doPrivileged(new PrivilegedAction() {
                @Override
                public Object run() {
                    return UnsafeAccess.UNSAFE;
                }
            }) == null) {
                PlatformDependent.logger.debug("org.jctools-core.MpscChunkedArrayQueue: unavailable");
                Mpsc.USE_MPSC_CHUNKED_ARRAY_QUEUE = false;
                return;
            }
            PlatformDependent.logger.debug("org.jctools-core.MpscChunkedArrayQueue: available");
            Mpsc.USE_MPSC_CHUNKED_ARRAY_QUEUE = true;
        }

        public static Queue newChunkedMpscQueue(int v, int v1) {
            return Mpsc.USE_MPSC_CHUNKED_ARRAY_QUEUE ? new MpscChunkedArrayQueue(v, v1) : new MpscChunkedAtomicArrayQueue(v, v1);
        }

        public static Queue newMpscQueue() {
            return Mpsc.USE_MPSC_CHUNKED_ARRAY_QUEUE ? new MpscUnboundedArrayQueue(0x400) : new MpscUnboundedAtomicArrayQueue(0x400);
        }

        public static Queue newMpscQueue(int v) {
            return Mpsc.newChunkedMpscQueue(0x400, Math.max(Math.min(v, 0x40000000), 0x800));
        }
    }

    interface ThreadLocalRandomProvider {
        Random current();
    }

    static final boolean $assertionsDisabled = false;
    private static final int ADDRESS_SIZE = 0;
    private static final String[] ALLOWED_LINUX_OS_CLASSIFIERS = null;
    public static final boolean BIG_ENDIAN_NATIVE_ORDER = false;
    private static final int BIT_MODE = 0;
    private static final long BYTE_ARRAY_BASE_OFFSET = 0L;
    private static final boolean CAN_ENABLE_TCP_NODELAY_BY_DEFAULT = false;
    private static final Cleaner CLEANER = null;
    private static final boolean DIRECT_BUFFER_PREFERRED = false;
    private static final AtomicLong DIRECT_MEMORY_COUNTER = null;
    private static final long DIRECT_MEMORY_LIMIT = 0L;
    private static final boolean IS_IVKVM_DOT_NET = false;
    private static final boolean IS_J9_JVM = false;
    private static final boolean IS_OSX = false;
    private static final boolean IS_WINDOWS = false;
    private static final String LINUX_ID_LIKE_PREFIX = "ID_LIKE=";
    private static final String LINUX_ID_PREFIX = "ID=";
    private static final Set LINUX_OS_CLASSIFIERS = null;
    private static final int MAX_ALLOWED_MPSC_CAPACITY = 0x40000000;
    private static final long MAX_DIRECT_MEMORY = 0L;
    private static Pattern MAX_DIRECT_MEMORY_SIZE_ARG_PATTERN = null;
    private static final boolean MAYBE_SUPER_USER = false;
    private static final int MIN_MAX_MPSC_CAPACITY = 0x800;
    private static final int MPSC_CHUNK_SIZE = 0x400;
    private static final Cleaner NOOP;
    private static final String NORMALIZED_ARCH;
    private static final String NORMALIZED_OS;
    private static final String[] OS_RELEASE_FILES;
    private static final ThreadLocalRandomProvider RANDOM_PROVIDER;
    private static final File TMPDIR;
    private static final int UNINITIALIZED_ARRAY_ALLOCATION_THRESHOLD;
    private static final Throwable UNSAFE_UNAVAILABILITY_CAUSE;
    private static final boolean USE_DIRECT_BUFFER_NO_CLEANER;
    private static final InternalLogger logger;

    static {
        InternalLogger internalLogger0 = InternalLoggerFactory.getInstance(PlatformDependent.class);
        PlatformDependent.logger = internalLogger0;
        PlatformDependent.CAN_ENABLE_TCP_NODELAY_BY_DEFAULT = true;
        PlatformDependent.UNSAFE_UNAVAILABILITY_CAUSE = PlatformDependent.unsafeUnavailabilityCause0();
        long v = PlatformDependent.estimateMaxDirectMemory();
        PlatformDependent.MAX_DIRECT_MEMORY = v;
        PlatformDependent.BYTE_ARRAY_BASE_OFFSET = 0L;
        PlatformDependent.TMPDIR = PlatformDependent.tmpdir0();
        PlatformDependent.BIT_MODE = PlatformDependent.bitMode0();
        PlatformDependent.NORMALIZED_ARCH = "aarch_64";
        PlatformDependent.NORMALIZED_OS = "linux";
        String[] arr_s = {"fedora", "suse", "arch"};
        PlatformDependent.ALLOWED_LINUX_OS_CLASSIFIERS = arr_s;
        PlatformDependent.IS_WINDOWS = PlatformDependent.isWindows0();
        PlatformDependent.IS_OSX = PlatformDependent.isOsx0();
        PlatformDependent.IS_J9_JVM = PlatformDependent.isJ9Jvm0();
        PlatformDependent.IS_IVKVM_DOT_NET = PlatformDependent.isIkvmDotNet0();
        PlatformDependent.ADDRESS_SIZE = PlatformDependent.addressSize0();
        PlatformDependent.OS_RELEASE_FILES = new String[]{"/etc/os-release", "/usr/lib/os-release"};
        boolean z = false;
        PlatformDependent.BIG_ENDIAN_NATIVE_ORDER = ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN;
        io.netty.util.internal.PlatformDependent.1 platformDependent$10 = new Cleaner() {
            @Override  // io.netty.util.internal.Cleaner
            public void freeDirectBuffer(ByteBuffer byteBuffer0) {
            }
        };
        PlatformDependent.NOOP = platformDependent$10;
        PlatformDependent.RANDOM_PROVIDER = new ThreadLocalRandomProvider() {
            @Override  // io.netty.util.internal.PlatformDependent$ThreadLocalRandomProvider
            public Random current() {
                return ThreadLocalRandom.current();
            }
        };
        long v1 = SystemPropertyUtil.getLong("io.netty.maxDirectMemory", -1L);
        PlatformDependent.USE_DIRECT_BUFFER_NO_CLEANER = false;
        PlatformDependent.DIRECT_MEMORY_COUNTER = null;
        internalLogger0.debug("-Dio.netty.maxDirectMemory: {} bytes", v1);
        if(v1 >= 1L) {
            v = v1;
        }
        PlatformDependent.DIRECT_MEMORY_LIMIT = v;
        SystemPropertyUtil.getInt("io.netty.uninitializedArrayAllocationThreshold", 0x400);
        PlatformDependent.UNINITIALIZED_ARRAY_ALLOCATION_THRESHOLD = -1;
        internalLogger0.debug("-Dio.netty.uninitializedArrayAllocationThreshold: {}", -1);
        PlatformDependent.MAYBE_SUPER_USER = PlatformDependent.maybeSuperUser0();
        PlatformDependent.CLEANER = new CleanerJava6();
        Cleaner cleaner0 = PlatformDependent.CLEANER;
        if(cleaner0 != platformDependent$10 && !SystemPropertyUtil.getBoolean("io.netty.noPreferDirect", false)) {
            z = true;
        }
        PlatformDependent.DIRECT_BUFFER_PREFERRED = z;
        if(internalLogger0.isDebugEnabled()) {
            internalLogger0.debug("-Dio.netty.noPreferDirect: {}", Boolean.valueOf(((boolean)(true ^ z))));
        }
        if(cleaner0 == platformDependent$10) {
            internalLogger0.info("Your platform does not provide complete low-level API for accessing direct buffers reliably. Unless explicitly requested, heap buffer will always be preferred to avoid potential system instability.");
        }
        Set set0 = Collections.unmodifiableSet(new HashSet(Arrays.asList(arr_s)));
        LinkedHashSet linkedHashSet0 = new LinkedHashSet();
        if(!PlatformDependent.addPropertyOsClassifiers(set0, linkedHashSet0)) {
            PlatformDependent.addFilesystemOsClassifiers(set0, linkedHashSet0);
        }
        PlatformDependent.LINUX_OS_CLASSIFIERS = Collections.unmodifiableSet(linkedHashSet0);
    }

    private static void addClassifier(Set set0, Set set1, String[] arr_s) {
        for(int v = 0; v < arr_s.length; ++v) {
            String s = arr_s[v];
            if(set0.contains(s)) {
                set1.add(s);
            }
        }
    }

    public static void addFilesystemOsClassifiers(Set set0, Set set1) {
        String[] arr_s = PlatformDependent.OS_RELEASE_FILES;
        for(int v = 0; v < arr_s.length; ++v) {
            String s = arr_s[v];
            if(((Boolean)AccessController.doPrivileged(new PrivilegedAction() {
                public Boolean run() {
                    Throwable throwable1;
                    IOException iOException1;
                    SecurityException securityException2;
                    BufferedReader bufferedReader0;
                    try {
                        if(new File(s).exists()) {
                            goto label_1;
                        }
                    }
                    catch(SecurityException securityException0) {
                        PlatformDependent.logger.debug("Unable to check if {} exists", s, securityException0);
                    }
                    return false;
                    try {
                    label_1:
                        bufferedReader0 = null;
                        bufferedReader0 = new BufferedReader(new InputStreamReader(new FileInputStream(new File(s)), CharsetUtil.UTF_8));
                    }
                    catch(SecurityException securityException1) {
                        securityException2 = securityException1;
                        goto label_29;
                    }
                    catch(IOException iOException0) {
                        iOException1 = iOException0;
                        goto label_32;
                    }
                    catch(Throwable throwable0) {
                        throwable1 = throwable0;
                        goto label_35;
                    }
                    try {
                        String s;
                        while((s = bufferedReader0.readLine()) != null) {
                            if(s.startsWith("ID=")) {
                                PlatformDependent.addClassifier(set0, set1, new String[]{PlatformDependent.normalizeOsReleaseVariableValue(s.substring(3))});
                            }
                            else if(s.startsWith("ID_LIKE=")) {
                                PlatformDependent.addClassifier(set0, set1, PlatformDependent.normalizeOsReleaseVariableValue(s.substring(8)).split("[ ]+"));
                            }
                        }
                    }
                    catch(SecurityException securityException2) {
                        goto label_29;
                    }
                    catch(IOException iOException1) {
                        goto label_32;
                    }
                    catch(Throwable throwable1) {
                        break alab1;
                    }
                alab1:
                    while(true) {
                        try {
                            bufferedReader0.close();
                            return true;
                        }
                        catch(IOException unused_ex) {
                        }
                        catch(SecurityException securityException0) {
                            PlatformDependent.logger.debug("Unable to check if {} exists", s, securityException0);
                            return false;
                        }
                        try {
                            while(true) {
                                return true;
                                try {
                                    break alab1;
                                }
                                catch(SecurityException securityException2) {
                                }
                                catch(IOException iOException1) {
                                    goto label_32;
                                }
                            label_29:
                                PlatformDependent.logger.debug("Unable to read {}", s, securityException2);
                                if(bufferedReader0 != null) {
                                    break;
                                }
                                return true;
                            label_32:
                                PlatformDependent.logger.debug("Error while reading content of {}", s, iOException1);
                                if(bufferedReader0 == null) {
                                    return true;
                                }
                                break;
                            }
                        }
                        catch(Throwable throwable1) {
                            break alab1;
                        }
                    }
                label_35:
                    if(bufferedReader0 == null) {
                        throw throwable1;
                    }
                    else {
                        try {
                            try {
                                bufferedReader0.close();
                            }
                            catch(IOException unused_ex) {
                            }
                            throw throwable1;
                        }
                        catch(SecurityException securityException0) {
                        }
                    }
                    PlatformDependent.logger.debug("Unable to check if {} exists", s, securityException0);
                    return false;
                }

                @Override
                public Object run() {
                    return this.run();
                }
            })).booleanValue()) {
                break;
            }
        }
    }

    public static boolean addPropertyOsClassifiers(Set set0, Set set1) {
        String s = SystemPropertyUtil.get("io.netty.osClassifiers");
        if(s == null) {
            return false;
        }
        if(s.isEmpty()) {
            return true;
        }
        String[] arr_s = s.split(",");
        if(arr_s.length == 0) {
            throw new IllegalArgumentException("io.netty.osClassifiers property is not empty, but contains no classifiers: " + s);
        }
        if(arr_s.length > 2) {
            throw new IllegalArgumentException("io.netty.osClassifiers property contains more than 2 classifiers: " + s);
        }
        for(int v = 0; v < arr_s.length; ++v) {
            PlatformDependent.addClassifier(set0, set1, new String[]{arr_s[v]});
        }
        return true;
    }

    public static int addressSize() {
        return PlatformDependent.ADDRESS_SIZE;
    }

    // 去混淆评级： 低(30)
    private static int addressSize0() {
        return PlatformDependent0.addressSize();
    }

    public static long align(long v, int v1) {
        return Pow2.align(v, v1);
    }

    public static ByteBuffer alignDirectBuffer(ByteBuffer byteBuffer0, int v) {
        if(!byteBuffer0.isDirect()) {
            throw new IllegalArgumentException("Cannot get aligned slice of non-direct byte buffer.");
        }
        long v1 = PlatformDependent.directBufferAddress(byteBuffer0);
        byteBuffer0.position(((int)(PlatformDependent.align(v1, v) - v1)));
        return byteBuffer0.slice();
    }

    public static ByteBuffer allocateDirectNoCleaner(int v) {
        PlatformDependent.incrementMemoryCounter(v);
        try {
            return PlatformDependent0.allocateDirectNoCleaner(v);
        }
        catch(Throwable throwable0) {
            PlatformDependent.decrementMemoryCounter(v);
            PlatformDependent.throwException(throwable0);
            return null;
        }
    }

    public static long allocateMemory(long v) {
        return PlatformDependent0.allocateMemory(v);
    }

    public static byte[] allocateUninitializedArray(int v) {
        return PlatformDependent.UNINITIALIZED_ARRAY_ALLOCATION_THRESHOLD < 0 || PlatformDependent.UNINITIALIZED_ARRAY_ALLOCATION_THRESHOLD > v ? new byte[v] : PlatformDependent0.allocateUninitializedArray(v);
    }

    public static int bitMode() {
        return PlatformDependent.BIT_MODE;
    }

    // 去混淆评级： 低(22)
    private static int bitMode0() {
        int v = SystemPropertyUtil.getInt("io.netty.bitMode", 0);
        if(v > 0) {
            PlatformDependent.logger.debug("-Dio.netty.bitMode: {}", v);
            return v;
        }
        int v1 = SystemPropertyUtil.getInt("sun.arch.data.model", 0);
        if(v1 > 0) {
            PlatformDependent.logger.debug("-Dio.netty.bitMode: {} (sun.arch.data.model)", v1);
            return v1;
        }
        int v2 = SystemPropertyUtil.getInt("com.ibm.vm.bitmode", 0);
        if(v2 > 0) {
            PlatformDependent.logger.debug("-Dio.netty.bitMode: {} (com.ibm.vm.bitmode)", v2);
            return v2;
        }
        Matcher matcher0 = Pattern.compile("([1-9][0-9]+)-?bit").matcher("dalvik");
        return matcher0.find() ? Integer.parseInt(matcher0.group(1)) : 0x40;
    }

    public static long byteArrayBaseOffset() [...] // 潜在的解密器

    // 去混淆评级： 中等(50)
    private static long byteArrayBaseOffset0() [...] // 潜在的解密器

    public static boolean canEnableTcpNoDelayByDefault() [...] // 潜在的解密器

    public static void copyMemory(long v, long v1, long v2) {
        PlatformDependent0.copyMemory(v, v1, v2);
    }

    public static void copyMemory(long v, byte[] arr_b, int v1, long v2) {
        PlatformDependent0.copyMemory(null, v, arr_b, ((long)v1), v2);
    }

    public static void copyMemory(byte[] arr_b, int v, long v1, long v2) {
        PlatformDependent0.copyMemory(arr_b, ((long)v), null, v1, v2);
    }

    public static void copyMemory(byte[] arr_b, int v, byte[] arr_b1, int v1, long v2) {
        PlatformDependent0.copyMemory(arr_b, ((long)v), arr_b1, ((long)v1), v2);
    }

    @SuppressJava6Requirement(reason = "Guarded by version check")
    public static File createTempFile(String s, String s1, File file0) {
        File file1 = file0 == null ? File.createTempFile(s, s1) : File.createTempFile(s, s1, file0);
        if(!file1.setReadable(false, false) || !file1.setReadable(true, true)) {
            throw new IOException("Failed to set permissions on temporary file " + file1);
        }
        return file1;
    }

    private static void decrementMemoryCounter(int v) {
        AtomicLong atomicLong0 = PlatformDependent.DIRECT_MEMORY_COUNTER;
        if(atomicLong0 != null) {
            atomicLong0.addAndGet(((long)(-v)));
        }
    }

    // 去混淆评级： 低(30)
    public static ByteBuffer directBuffer(long v, int v1) {
        throw new UnsupportedOperationException("sun.misc.Unsafe or java.nio.DirectByteBuffer.<init>(long, int) not available");
    }

    public static long directBufferAddress(ByteBuffer byteBuffer0) {
        return PlatformDependent0.directBufferAddress(byteBuffer0);
    }

    public static boolean directBufferPreferred() [...] // 潜在的解密器

    // 去混淆评级： 中等(60)
    public static boolean equals(byte[] arr_b, int v, byte[] arr_b1, int v1, int v2) {
        return PlatformDependent.equalsSafe(arr_b, v, arr_b1, v1, v2);
    }

    // 去混淆评级： 中等(60)
    public static int equalsConstantTime(byte[] arr_b, int v, byte[] arr_b1, int v1, int v2) {
        return ConstantTimeUtils.equalsConstantTime(arr_b, v, arr_b1, v1, v2);
    }

    private static boolean equalsSafe(byte[] arr_b, int v, byte[] arr_b1, int v1, int v2) {
        int v3 = v2 + v;
        while(v < v3) {
            if(arr_b[v] != arr_b1[v1]) {
                return false;
            }
            ++v;
            ++v1;
        }
        return true;
    }

    public static long estimateMaxDirectMemory() {
        long v2;
        ClassLoader classLoader0;
        long v = 0L;
        try {
            classLoader0 = null;
            classLoader0 = PlatformDependent.getSystemClassLoader();
            v = ((Number)Class.forName("sun.misc.VM", true, classLoader0).getDeclaredMethod("maxDirectMemory", null).invoke(null, null)).longValue();
        }
        catch(Throwable unused_ex) {
        }
        if(v > 0L) {
            return v;
        }
        try {
            List list0 = (List)Class.forName("java.lang.management.RuntimeMXBean", true, classLoader0).getDeclaredMethod("getInputArguments", null).invoke(Class.forName("java.lang.management.ManagementFactory", true, classLoader0).getDeclaredMethod("getRuntimeMXBean", null).invoke(null, null), null);
            Pattern pattern0 = PlatformDependent.getMaxDirectMemorySizeArgPattern();
            int v1 = list0.size() - 1;
        label_9:
            while(v1 >= 0) {
                Matcher matcher0 = pattern0.matcher(((CharSequence)list0.get(v1)));
                if(matcher0.matches()) {
                    v = Long.parseLong(matcher0.group(1));
                    switch(matcher0.group(2).charAt(0)) {
                        case 71: 
                        case 103: {
                            v2 = 0x40000000L;
                            break;
                        }
                        case 75: 
                        case 107: {
                            v2 = 0x400L;
                            break;
                        }
                        case 77: 
                        case 109: {
                            v2 = 0x100000L;
                            break;
                        }
                        default: {
                            break label_9;
                        }
                    }
                    v *= v2;
                    if(true) {
                        break;
                    }
                }
                else {
                    --v1;
                }
            }
        }
        catch(Throwable unused_ex) {
        }
        if(v <= 0L) {
            v = Runtime.getRuntime().maxMemory();
            PlatformDependent.logger.debug("maxDirectMemory: {} bytes (maybe)", v);
            return v;
        }
        PlatformDependent.logger.debug("maxDirectMemory: {} bytes", v);
        return v;
    }

    public static void freeDirectBuffer(ByteBuffer byteBuffer0) {
        PlatformDependent.CLEANER.freeDirectBuffer(byteBuffer0);
    }

    public static void freeDirectNoCleaner(ByteBuffer byteBuffer0) {
        PlatformDependent0.freeMemory(PlatformDependent0.directBufferAddress(byteBuffer0));
        PlatformDependent.decrementMemoryCounter(byteBuffer0.capacity());
    }

    public static void freeMemory(long v) {
        PlatformDependent0.freeMemory(v);
    }

    public static byte getByte(long v) {
        return PlatformDependent0.getByte(v);
    }

    public static byte getByte(byte[] arr_b, int v) {
        return PlatformDependent0.getByte(arr_b, v);
    }

    public static byte getByte(byte[] arr_b, long v) {
        return PlatformDependent0.getByte(arr_b, v);
    }

    public static ClassLoader getClassLoader(Class class0) {
        return PlatformDependent0.getClassLoader(class0);
    }

    public static ClassLoader getContextClassLoader() {
        return PlatformDependent0.getContextClassLoader();
    }

    public static int getInt(long v) {
        return PlatformDependent0.getInt(v);
    }

    public static int getInt(Object object0, long v) {
        return PlatformDependent0.getInt(object0, v);
    }

    public static int getInt(byte[] arr_b, int v) {
        return PlatformDependent0.getInt(arr_b, v);
    }

    public static int getInt(int[] arr_v, long v) {
        return PlatformDependent0.getInt(arr_v, v);
    }

    // 去混淆评级： 低(20)
    private static int getIntSafe(byte[] arr_b, int v) {
        return PlatformDependent.BIG_ENDIAN_NATIVE_ORDER ? arr_b[v + 3] & 0xFF | (arr_b[v] << 24 | (arr_b[v + 1] & 0xFF) << 16 | (arr_b[v + 2] & 0xFF) << 8) : arr_b[v + 3] << 24 | (arr_b[v] & 0xFF | (arr_b[v + 1] & 0xFF) << 8 | (arr_b[v + 2] & 0xFF) << 16);
    }

    public static int getIntVolatile(long v) {
        return PlatformDependent0.getIntVolatile(v);
    }

    public static long getLong(long v) {
        return PlatformDependent0.getLong(v);
    }

    public static long getLong(byte[] arr_b, int v) {
        return PlatformDependent0.getLong(arr_b, v);
    }

    public static long getLong(long[] arr_v, long v) {
        return PlatformDependent0.getLong(arr_v, v);
    }

    // 去混淆评级： 低(20)
    private static long getLongSafe(byte[] arr_b, int v) {
        return PlatformDependent.BIG_ENDIAN_NATIVE_ORDER ? ((long)arr_b[v + 7]) & 0xFFL | ((((long)arr_b[v + 6]) & 0xFFL) << 8 | ((((long)arr_b[v + 1]) & 0xFFL) << 0x30 | ((long)arr_b[v]) << 56 | (((long)arr_b[v + 2]) & 0xFFL) << 40 | (((long)arr_b[v + 3]) & 0xFFL) << 0x20 | (((long)arr_b[v + 4]) & 0xFFL) << 24 | (((long)arr_b[v + 5]) & 0xFFL) << 16)) : ((long)arr_b[v + 7]) << 56 | ((((long)arr_b[v + 1]) & 0xFFL) << 8 | ((long)arr_b[v]) & 0xFFL | (((long)arr_b[v + 2]) & 0xFFL) << 16 | (((long)arr_b[v + 3]) & 0xFFL) << 24 | (((long)arr_b[v + 4]) & 0xFFL) << 0x20 | (((long)arr_b[v + 5]) & 0xFFL) << 40 | (((long)arr_b[v + 6]) & 0xFFL) << 0x30);
    }

    private static Pattern getMaxDirectMemorySizeArgPattern() {
        Pattern pattern0 = PlatformDependent.MAX_DIRECT_MEMORY_SIZE_ARG_PATTERN;
        if(pattern0 == null) {
            pattern0 = Pattern.compile("\\s*-XX:MaxDirectMemorySize\\s*=\\s*([0-9]+)\\s*([kKmMgG]?)\\s*$");
            PlatformDependent.MAX_DIRECT_MEMORY_SIZE_ARG_PATTERN = pattern0;
        }
        return pattern0;
    }

    public static Object getObject(Object object0, long v) {
        return PlatformDependent0.getObject(object0, v);
    }

    public static short getShort(long v) {
        return PlatformDependent0.getShort(v);
    }

    public static short getShort(byte[] arr_b, int v) {
        return PlatformDependent0.getShort(arr_b, v);
    }

    // 去混淆评级： 低(20)
    private static short getShortSafe(byte[] arr_b, int v) {
        return PlatformDependent.BIG_ENDIAN_NATIVE_ORDER ? ((short)(arr_b[v + 1] & 0xFF | arr_b[v] << 8)) : ((short)(arr_b[v + 1] << 8 | arr_b[v] & 0xFF));
    }

    public static ClassLoader getSystemClassLoader() {
        return PlatformDependent0.getSystemClassLoader();
    }

    public static Throwable getUnsafeUnavailabilityCause() {
        return PlatformDependent.UNSAFE_UNAVAILABILITY_CAUSE;
    }

    // 去混淆评级： 中等(60)
    public static boolean hasAlignDirectByteBuffer() [...] // 潜在的解密器

    public static boolean hasDirectBufferNoCleanerConstructor() [...] // 潜在的解密器

    public static boolean hasUnsafe() [...] // 潜在的解密器

    public static int hashCodeAscii(CharSequence charSequence0) {
        int v5;
        int v = charSequence0.length();
        int v1 = -1028477387;
        if(v >= 0x20) {
            for(int v2 = v - 8; v2 >= (v & 7); v2 -= 8) {
                v1 = PlatformDependent.hashCodeAsciiCompute(charSequence0, v2, v1);
            }
        }
        else if(v >= 8) {
            v1 = PlatformDependent.hashCodeAsciiCompute(charSequence0, v - 8, -1028477387);
            if(v >= 16) {
                v1 = PlatformDependent.hashCodeAsciiCompute(charSequence0, v - 16, v1);
                if(v >= 24) {
                    v1 = PlatformDependent.hashCodeAsciiCompute(charSequence0, v - 24, v1);
                }
            }
        }
        int v3 = 0xCC9E2D51;
        int v4 = 1;
        if((v & 7) == 0) {
            return v1;
        }
        if((((v & 7) == 2 ? 0 : 1) & ((v & 7) == 4 ? 0 : 1) & ((v & 7) == 6 ? 0 : 1)) == 0) {
            v5 = 0;
        }
        else {
            v1 = v1 * 0xCC9E2D51 + PlatformDependent.hashCodeAsciiSanitizeByte(charSequence0.charAt(0));
            v5 = 1;
        }
        if((((v & 7) == 1 ? 0 : 1) & ((v & 7) == 4 ? 0 : 1) & ((v & 7) == 5 ? 0 : 1)) != 0) {
            v1 = v1 * (v5 == 0 ? 0xCC9E2D51 : 461845907) + PlatformDependent0.hashCodeAsciiSanitize(PlatformDependent.hashCodeAsciiSanitizeShort(charSequence0, v5));
            v5 += 2;
        }
        if((v & 7) >= 4) {
            if(v5 != 3) {
                v4 = 0;
            }
            if(((v5 == 0 ? 1 : 0) | v4) == 0) {
                v3 = 461845907;
            }
            return v1 * v3 + PlatformDependent.hashCodeAsciiSanitizeInt(charSequence0, v5);
        }
        return v1;
    }

    // 去混淆评级： 中等(60)
    public static int hashCodeAscii(byte[] arr_b, int v, int v1) {
        return PlatformDependent.hashCodeAsciiSafe(arr_b, v, v1);
    }

    // 去混淆评级： 低(20)
    private static int hashCodeAsciiCompute(CharSequence charSequence0, int v, int v1) {
        return PlatformDependent.BIG_ENDIAN_NATIVE_ORDER ? PlatformDependent.hashCodeAsciiSanitizeInt(charSequence0, v + 4) * 461845907 + v1 * 0xCC9E2D51 + PlatformDependent.hashCodeAsciiSanitizeInt(charSequence0, v) : PlatformDependent.hashCodeAsciiSanitizeInt(charSequence0, v) * 461845907 + v1 * 0xCC9E2D51 + PlatformDependent.hashCodeAsciiSanitizeInt(charSequence0, v + 4);
    }

    public static int hashCodeAsciiSafe(byte[] arr_b, int v, int v1) {
        int v2 = v - 8 + v1;
        int v3 = -1028477387;
        while(v2 >= v + (v1 & 7)) {
            v3 = PlatformDependent0.hashCodeAsciiCompute(PlatformDependent.getLongSafe(arr_b, v2), v3);
            v2 -= 8;
        }
        switch(v1 & 7) {
            case 1: {
                return v3 * 0xCC9E2D51 + PlatformDependent0.hashCodeAsciiSanitize(arr_b[v]);
            }
            case 2: {
                return v3 * 0xCC9E2D51 + PlatformDependent0.hashCodeAsciiSanitize(PlatformDependent.getShortSafe(arr_b, v));
            }
            case 3: {
                return (v3 * 0xCC9E2D51 + PlatformDependent0.hashCodeAsciiSanitize(arr_b[v])) * 461845907 + PlatformDependent0.hashCodeAsciiSanitize(PlatformDependent.getShortSafe(arr_b, v + 1));
            }
            case 4: {
                return v3 * 0xCC9E2D51 + PlatformDependent0.hashCodeAsciiSanitize(PlatformDependent.getIntSafe(arr_b, v));
            }
            case 5: {
                return (v3 * 0xCC9E2D51 + PlatformDependent0.hashCodeAsciiSanitize(arr_b[v])) * 461845907 + PlatformDependent0.hashCodeAsciiSanitize(PlatformDependent.getIntSafe(arr_b, v + 1));
            }
            case 6: {
                return (v3 * 0xCC9E2D51 + PlatformDependent0.hashCodeAsciiSanitize(PlatformDependent.getShortSafe(arr_b, v))) * 461845907 + PlatformDependent0.hashCodeAsciiSanitize(PlatformDependent.getIntSafe(arr_b, v + 2));
            }
            case 7: {
                return ((v3 * 0xCC9E2D51 + PlatformDependent0.hashCodeAsciiSanitize(arr_b[v])) * 461845907 + PlatformDependent0.hashCodeAsciiSanitize(PlatformDependent.getShortSafe(arr_b, v + 1))) * 0xCC9E2D51 + PlatformDependent0.hashCodeAsciiSanitize(PlatformDependent.getIntSafe(arr_b, v + 3));
            }
            default: {
                return v3;
            }
        }
    }

    private static int hashCodeAsciiSanitizeByte(char c) {
        return c & 0x1F;
    }

    private static int hashCodeAsciiSanitizeInt(CharSequence charSequence0, int v) {
        int v1;
        if(PlatformDependent.BIG_ENDIAN_NATIVE_ORDER) {
            v1 = charSequence0.charAt(v + 3) & 0x1F | (charSequence0.charAt(v + 2) & 0x1F) << 8 | (charSequence0.charAt(v + 1) & 0x1F) << 16;
            return (charSequence0.charAt(v) & 0x1F) << 24 | v1;
        }
        v1 = (charSequence0.charAt(v + 3) & 0x1F) << 24 | (charSequence0.charAt(v + 2) & 0x1F) << 16 | (charSequence0.charAt(v + 1) & 0x1F) << 8;
        return charSequence0.charAt(v) & 0x1F | v1;
    }

    private static int hashCodeAsciiSanitizeShort(CharSequence charSequence0, int v) {
        int v1;
        if(PlatformDependent.BIG_ENDIAN_NATIVE_ORDER) {
            v1 = charSequence0.charAt(v + 1) & 0x1F;
            return (charSequence0.charAt(v) & 0x1F) << 8 | v1;
        }
        v1 = (charSequence0.charAt(v + 1) & 0x1F) << 8;
        return charSequence0.charAt(v) & 0x1F | v1;
    }

    private static void incrementMemoryCounter(int v) {
        AtomicLong atomicLong0 = PlatformDependent.DIRECT_MEMORY_COUNTER;
        if(atomicLong0 != null) {
            long v1 = atomicLong0.addAndGet(((long)v));
            if(v1 > 0L) {
                atomicLong0.addAndGet(((long)(-v)));
                StringBuilder stringBuilder0 = x.n(v, "failed to allocate ", " byte(s) of direct memory (used: ");
                stringBuilder0.append(v1 - ((long)v));
                stringBuilder0.append(", max: ");
                stringBuilder0.append(0L);
                stringBuilder0.append(')');
                throw new OutOfDirectMemoryError(stringBuilder0.toString());
            }
        }
    }

    // 去混淆评级： 低(20)
    public static boolean isAndroid() [...] // 潜在的解密器

    public static boolean isIkvmDotNet() [...] // 潜在的解密器

    // 去混淆评级： 中等(50)
    private static boolean isIkvmDotNet0() {
        return false;
    }

    public static boolean isJ9Jvm() [...] // 潜在的解密器

    // 去混淆评级： 中等(120)
    private static boolean isJ9Jvm0() {
        return false;
    }

    public static boolean isOsx() [...] // 潜在的解密器

    private static boolean isOsx0() {
        boolean z = "osx".equals(PlatformDependent.NORMALIZED_OS);
        if(z) {
            PlatformDependent.logger.debug("Platform: MacOS");
        }
        return z;
    }

    // 去混淆评级： 低(20)
    public static boolean isUnaligned() [...] // 潜在的解密器

    public static boolean isWindows() [...] // 潜在的解密器

    private static boolean isWindows0() {
        boolean z = "windows".equals(PlatformDependent.NORMALIZED_OS);
        if(z) {
            PlatformDependent.logger.debug("Platform: Windows");
        }
        return z;
    }

    // 去混淆评级： 中等(60)
    public static boolean isZero(byte[] arr_b, int v, int v1) {
        return PlatformDependent.isZeroSafe(arr_b, v, v1);
    }

    private static boolean isZeroSafe(byte[] arr_b, int v, int v1) {
        int v2 = v1 + v;
        while(v < v2) {
            if(arr_b[v] != 0) {
                return false;
            }
            ++v;
        }
        return true;
    }

    // 去混淆评级： 低(20)
    public static int javaVersion() [...] // 潜在的解密器

    public static long maxDirectMemory() [...] // 潜在的解密器

    public static boolean maybeSuperUser() [...] // 潜在的解密器

    // 去混淆评级： 中等(130)
    private static boolean maybeSuperUser0() {
        return true;
    }

    // 去混淆评级： 低(20)
    @SuppressJava6Requirement(reason = "Usage guarded by java version check")
    public static Deque newConcurrentDeque() {
        return new LinkedBlockingDeque();
    }

    public static ConcurrentMap newConcurrentHashMap() {
        return new ConcurrentHashMap();
    }

    public static ConcurrentMap newConcurrentHashMap(int v) {
        return new ConcurrentHashMap(v);
    }

    public static ConcurrentMap newConcurrentHashMap(int v, float f) {
        return new ConcurrentHashMap(v, f);
    }

    public static ConcurrentMap newConcurrentHashMap(int v, float f, int v1) {
        return new ConcurrentHashMap(v, f, v1);
    }

    public static ConcurrentMap newConcurrentHashMap(Map map0) {
        return new ConcurrentHashMap(map0);
    }

    public static Queue newFixedMpscQueue(int v) {
        return PlatformDependent.hasUnsafe() ? new MpscArrayQueue(v) : new MpscAtomicArrayQueue(v);
    }

    // 去混淆评级： 低(20)
    public static LongCounter newLongCounter() {
        return new AtomicLongCounter(null);
    }

    public static Queue newMpscQueue() {
        return Mpsc.newMpscQueue();
    }

    public static Queue newMpscQueue(int v) {
        return Mpsc.newMpscQueue(v);
    }

    public static Queue newMpscQueue(int v, int v1) {
        return Mpsc.newChunkedMpscQueue(v, v1);
    }

    public static Queue newSpscQueue() {
        return PlatformDependent.hasUnsafe() ? new SpscLinkedQueue() : new SpscLinkedAtomicQueue();
    }

    private static String normalize(String s) {
        return s.toLowerCase(Locale.US).replaceAll("[^a-z0-9]+", "");
    }

    private static String normalizeArch(String s) [...] // 潜在的解密器

    private static String normalizeOs(String s) [...] // 潜在的解密器

    private static String normalizeOsReleaseVariableValue(String s) {
        return s.trim().replaceAll("[\"\']", "");
    }

    public static String normalizedArch() {
        return PlatformDependent.NORMALIZED_ARCH;
    }

    public static Set normalizedLinuxClassifiers() {
        return PlatformDependent.LINUX_OS_CLASSIFIERS;
    }

    public static String normalizedOs() {
        return PlatformDependent.NORMALIZED_OS;
    }

    public static long objectFieldOffset(Field field0) {
        return PlatformDependent0.objectFieldOffset(field0);
    }

    public static void putByte(long v, byte b) {
        PlatformDependent0.putByte(v, b);
    }

    public static void putByte(Object object0, long v, byte b) {
        PlatformDependent0.putByte(object0, v, b);
    }

    public static void putByte(byte[] arr_b, int v, byte b) {
        PlatformDependent0.putByte(arr_b, v, b);
    }

    public static void putInt(long v, int v1) {
        PlatformDependent0.putInt(v, v1);
    }

    public static void putInt(byte[] arr_b, int v, int v1) {
        PlatformDependent0.putInt(arr_b, v, v1);
    }

    public static void putIntOrdered(long v, int v1) {
        PlatformDependent0.putIntOrdered(v, v1);
    }

    public static void putLong(long v, long v1) {
        PlatformDependent0.putLong(v, v1);
    }

    public static void putLong(byte[] arr_b, int v, long v1) {
        PlatformDependent0.putLong(arr_b, v, v1);
    }

    public static void putObject(Object object0, long v, Object object1) {
        PlatformDependent0.putObject(object0, v, object1);
    }

    public static void putShort(long v, short v1) {
        PlatformDependent0.putShort(v, v1);
    }

    public static void putShort(byte[] arr_b, int v, short v1) {
        PlatformDependent0.putShort(arr_b, v, v1);
    }

    public static ByteBuffer reallocateDirectNoCleaner(ByteBuffer byteBuffer0, int v) {
        int v1 = v - byteBuffer0.capacity();
        PlatformDependent.incrementMemoryCounter(v1);
        try {
            return PlatformDependent0.reallocateDirectNoCleaner(byteBuffer0, v);
        }
        catch(Throwable throwable0) {
            PlatformDependent.decrementMemoryCounter(v1);
            PlatformDependent.throwException(throwable0);
            return null;
        }
    }

    public static long reallocateMemory(long v, long v1) {
        return PlatformDependent0.reallocateMemory(v, v1);
    }

    public static void safeConstructPutInt(Object object0, long v, int v1) {
        PlatformDependent0.safeConstructPutInt(object0, v, v1);
    }

    public static void setMemory(long v, long v1, byte b) {
        PlatformDependent0.setMemory(v, v1, b);
    }

    public static void setMemory(byte[] arr_b, int v, long v1, byte b) {
        PlatformDependent0.setMemory(arr_b, ((long)v), v1, b);
    }

    public static Random threadLocalRandom() {
        return PlatformDependent.RANDOM_PROVIDER.current();
    }

    public static void throwException(Throwable throwable0) {
        PlatformDependent0.throwException(throwable0);
    }

    private static void throwException0(Throwable throwable0) {
        throw throwable0;
    }

    public static File tmpdir() {
        return PlatformDependent.TMPDIR;
    }

    private static File tmpdir0() {
        try {
            File file0 = PlatformDependent.toDirectory(SystemPropertyUtil.get("io.netty.tmpdir"));
            if(file0 != null) {
                PlatformDependent.logger.debug("-Dio.netty.tmpdir: {}", file0);
                return file0;
            }
            File file1 = PlatformDependent.toDirectory("/data/user/0/com.iloen.melon/cache");
            if(file1 != null) {
                PlatformDependent.logger.debug("-Dio.netty.tmpdir: {} (java.io.tmpdir)", file1);
                return file1;
            }
            File file2 = PlatformDependent.toDirectory(System.getenv("TMPDIR"));
            if(file2 != null) {
                PlatformDependent.logger.debug("-Dio.netty.tmpdir: {} ($TMPDIR)", file2);
                return file2;
            }
        }
        catch(Throwable unused_ex) {
        }
        File file3 = new File("/tmp");
        PlatformDependent.logger.warn("Failed to get the temporary directory; falling back to: {}", file3);
        return file3;
    }

    private static File toDirectory(String s) {
        if(s == null) {
            return null;
        }
        File file0 = new File(s);
        file0.mkdirs();
        if(!file0.isDirectory()) {
            return null;
        }
        try {
            return file0.getAbsoluteFile();
        }
        catch(Exception unused_ex) {
            return file0;
        }
    }

    private static Throwable unsafeUnavailabilityCause0() {
        Throwable throwable0 = PlatformDependent0.getUnsafeUnavailabilityCause();
        if(throwable0 != null) {
            return throwable0;
        }
        try {
            PlatformDependent.logger.debug("sun.misc.Unsafe: {}", "unavailable");
            return PlatformDependent0.getUnsafeUnavailabilityCause();
        }
        catch(Throwable throwable1) {
            PlatformDependent.logger.trace("Could not determine if Unsafe is available", throwable1);
            return new UnsupportedOperationException("Could not determine if Unsafe is available", throwable1);
        }
    }

    public static boolean useDirectBufferNoCleaner() [...] // 潜在的解密器

    public static long usedDirectMemory() {
        return PlatformDependent.DIRECT_MEMORY_COUNTER == null ? -1L : PlatformDependent.DIRECT_MEMORY_COUNTER.get();
    }

    final class io.netty.util.internal.PlatformDependent.2 implements ThreadLocalRandomProvider {
        @Override  // io.netty.util.internal.PlatformDependent$ThreadLocalRandomProvider
        @SuppressJava6Requirement(reason = "Usage guarded by java version check")
        public Random current() {
            return java.util.concurrent.ThreadLocalRandom.current();
        }
    }

}

