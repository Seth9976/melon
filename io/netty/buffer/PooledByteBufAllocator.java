package io.netty.buffer;

import io.netty.util.NettyRuntime;
import io.netty.util.concurrent.EventExecutor;
import io.netty.util.concurrent.FastThreadLocal;
import io.netty.util.concurrent.FastThreadLocalThread;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.SystemPropertyUtil;
import io.netty.util.internal.ThreadExecutorMap;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PooledByteBufAllocator extends AbstractByteBufAllocator implements ByteBufAllocatorMetricProvider {
    final class PoolThreadLocalCache extends FastThreadLocal {
        private final boolean useCacheForAllThreads;

        public PoolThreadLocalCache(boolean z) {
            this.useCacheForAllThreads = z;
        }

        public PoolThreadCache initialValue() {
            synchronized(this) {
                PoolArena poolArena0 = this.leastUsedArena(PooledByteBufAllocator.this.heapArenas);
                PoolArena poolArena1 = this.leastUsedArena(PooledByteBufAllocator.this.directArenas);
                EventExecutor eventExecutor0 = ThreadExecutorMap.currentExecutor();
                return !this.useCacheForAllThreads && !(Thread.currentThread() instanceof FastThreadLocalThread) && eventExecutor0 == null ? new PoolThreadCache(poolArena0, poolArena1, 0, 0, 0, 0, false) : new PoolThreadCache(poolArena0, poolArena1, PooledByteBufAllocator.this.smallCacheSize, PooledByteBufAllocator.this.normalCacheSize, PooledByteBufAllocator.DEFAULT_MAX_CACHED_BUFFER_CAPACITY, 0, true);
            }
        }

        @Override  // io.netty.util.concurrent.FastThreadLocal
        public Object initialValue() {
            return this.initialValue();
        }

        private PoolArena leastUsedArena(PoolArena[] arr_poolArena) {
            if(arr_poolArena != null && arr_poolArena.length != 0) {
                PoolArena poolArena0 = arr_poolArena[0];
                if(poolArena0.numThreadCaches.get() == 0) {
                    return poolArena0;
                }
                for(int v = 1; v < arr_poolArena.length; ++v) {
                    PoolArena poolArena1 = arr_poolArena[v];
                    if(poolArena1.numThreadCaches.get() < poolArena0.numThreadCaches.get()) {
                        poolArena0 = poolArena1;
                    }
                }
                return poolArena0;
            }
            return null;
        }

        public void onRemoval(PoolThreadCache poolThreadCache0) {
            poolThreadCache0.free(false);
        }

        @Override  // io.netty.util.concurrent.FastThreadLocal
        public void onRemoval(Object object0) {
            this.onRemoval(((PoolThreadCache)object0));
        }
    }

    static final boolean $assertionsDisabled = false;
    private static final int CACHE_NOT_USED = 0;
    public static final PooledByteBufAllocator DEFAULT = null;
    private static final int DEFAULT_CACHE_TRIM_INTERVAL = 0;
    private static final long DEFAULT_CACHE_TRIM_INTERVAL_MILLIS = 0L;
    private static final int DEFAULT_DIRECT_MEMORY_CACHE_ALIGNMENT = 0;
    static final int DEFAULT_MAX_CACHED_BUFFER_CAPACITY = 0;
    static final int DEFAULT_MAX_CACHED_BYTEBUFFERS_PER_CHUNK = 0;
    private static final int DEFAULT_MAX_ORDER = 0;
    private static final int DEFAULT_NORMAL_CACHE_SIZE = 0;
    private static final int DEFAULT_NUM_DIRECT_ARENA = 0;
    private static final int DEFAULT_NUM_HEAP_ARENA = 0;
    private static final int DEFAULT_PAGE_SIZE = 0;
    private static final int DEFAULT_SMALL_CACHE_SIZE = 0;
    private static final boolean DEFAULT_USE_CACHE_FOR_ALL_THREADS = false;
    private static final int MAX_CHUNK_SIZE = 0x40000000;
    private static final int MIN_PAGE_SIZE = 0x1000;
    private final int chunkSize;
    private final List directArenaMetrics;
    private final PoolArena[] directArenas;
    private final List heapArenaMetrics;
    private final PoolArena[] heapArenas;
    private static final InternalLogger logger;
    private final PooledByteBufAllocatorMetric metric;
    private final int normalCacheSize;
    private final int smallCacheSize;
    private final PoolThreadLocalCache threadCache;
    private final Runnable trimTask;

    static {
        int v2;
        Throwable throwable1;
        PooledByteBufAllocator.logger = InternalLoggerFactory.getInstance(PooledByteBufAllocator.class);
        int v = SystemPropertyUtil.getInt("io.netty.allocator.directMemoryCacheAlignment", 0);
        int v1 = SystemPropertyUtil.getInt("io.netty.allocator.pageSize", 0x2000);
        Throwable throwable0 = null;
        try {
            throwable1 = throwable2;
            PooledByteBufAllocator.validateAndCalculatePageShifts(v1, v);
            v2 = v1;
            throwable1 = null;
        }
        catch(Throwable unused_ex) {
            v = 0;
            v2 = 0x2000;
        }
        PooledByteBufAllocator.DEFAULT_PAGE_SIZE = v2;
        PooledByteBufAllocator.DEFAULT_DIRECT_MEMORY_CACHE_ALIGNMENT = v;
        int v3 = 9;
        int v4 = SystemPropertyUtil.getInt("io.netty.allocator.maxOrder", 9);
        try {
            PooledByteBufAllocator.validateAndCalculateChunkSize(v2, v4);
            v3 = v4;
        }
        catch(Throwable throwable3) {
            throwable0 = throwable3;
        }
        PooledByteBufAllocator.DEFAULT_MAX_ORDER = v3;
        int v5 = NettyRuntime.availableProcessors();
        int v6 = PooledByteBufAllocator.DEFAULT_PAGE_SIZE;
        int v7 = Math.max(0, SystemPropertyUtil.getInt("io.netty.allocator.numHeapArenas", ((int)Math.min(v5 * 2, Runtime.getRuntime().maxMemory() / ((long)(v6 << v3)) / 2L / 3L))));
        PooledByteBufAllocator.DEFAULT_NUM_HEAP_ARENA = v7;
        int v8 = Math.max(0, SystemPropertyUtil.getInt("io.netty.allocator.numDirectArenas", ((int)Math.min(v5 * 2, 0L))));
        PooledByteBufAllocator.DEFAULT_NUM_DIRECT_ARENA = v8;
        int v9 = SystemPropertyUtil.getInt("io.netty.allocator.smallCacheSize", 0x100);
        PooledByteBufAllocator.DEFAULT_SMALL_CACHE_SIZE = v9;
        int v10 = SystemPropertyUtil.getInt("io.netty.allocator.normalCacheSize", 0x40);
        PooledByteBufAllocator.DEFAULT_NORMAL_CACHE_SIZE = v10;
        int v11 = SystemPropertyUtil.getInt("io.netty.allocator.maxCachedBufferCapacity", 0x8000);
        PooledByteBufAllocator.DEFAULT_MAX_CACHED_BUFFER_CAPACITY = v11;
        int v12 = SystemPropertyUtil.getInt("io.netty.allocator.cacheTrimInterval", 0x2000);
        PooledByteBufAllocator.DEFAULT_CACHE_TRIM_INTERVAL = v12;
        if(SystemPropertyUtil.contains("io.netty.allocation.cacheTrimIntervalMillis")) {
            PooledByteBufAllocator.logger.warn("-Dio.netty.allocation.cacheTrimIntervalMillis is deprecated, use -Dio.netty.allocator.cacheTrimIntervalMillis");
            PooledByteBufAllocator.DEFAULT_CACHE_TRIM_INTERVAL_MILLIS = SystemPropertyUtil.contains("io.netty.allocator.cacheTrimIntervalMillis") ? SystemPropertyUtil.getLong("io.netty.allocator.cacheTrimIntervalMillis", 0L) : SystemPropertyUtil.getLong("io.netty.allocation.cacheTrimIntervalMillis", 0L);
        }
        else {
            PooledByteBufAllocator.DEFAULT_CACHE_TRIM_INTERVAL_MILLIS = SystemPropertyUtil.getLong("io.netty.allocator.cacheTrimIntervalMillis", 0L);
        }
        boolean z = SystemPropertyUtil.getBoolean("io.netty.allocator.useCacheForAllThreads", false);
        PooledByteBufAllocator.DEFAULT_USE_CACHE_FOR_ALL_THREADS = z;
        int v13 = SystemPropertyUtil.getInt("io.netty.allocator.maxCachedByteBuffersPerChunk", 0x3FF);
        PooledByteBufAllocator.DEFAULT_MAX_CACHED_BYTEBUFFERS_PER_CHUNK = v13;
        InternalLogger internalLogger0 = PooledByteBufAllocator.logger;
        if(internalLogger0.isDebugEnabled()) {
            internalLogger0.debug("-Dio.netty.allocator.numHeapArenas: {}", v7);
            internalLogger0.debug("-Dio.netty.allocator.numDirectArenas: {}", v8);
            if(throwable1 == null) {
                internalLogger0.debug("-Dio.netty.allocator.pageSize: {}", v6);
            }
            else {
                internalLogger0.debug("-Dio.netty.allocator.pageSize: {}", v6, throwable1);
            }
            if(throwable0 == null) {
                internalLogger0.debug("-Dio.netty.allocator.maxOrder: {}", v3);
            }
            else {
                internalLogger0.debug("-Dio.netty.allocator.maxOrder: {}", v3, throwable0);
            }
            internalLogger0.debug("-Dio.netty.allocator.chunkSize: {}", ((int)(v6 << v3)));
            internalLogger0.debug("-Dio.netty.allocator.smallCacheSize: {}", v9);
            internalLogger0.debug("-Dio.netty.allocator.normalCacheSize: {}", v10);
            internalLogger0.debug("-Dio.netty.allocator.maxCachedBufferCapacity: {}", v11);
            internalLogger0.debug("-Dio.netty.allocator.cacheTrimInterval: {}", v12);
            internalLogger0.debug("-Dio.netty.allocator.cacheTrimIntervalMillis: {}", 0L);
            internalLogger0.debug("-Dio.netty.allocator.useCacheForAllThreads: {}", Boolean.valueOf(z));
            internalLogger0.debug("-Dio.netty.allocator.maxCachedByteBuffersPerChunk: {}", v13);
        }
        PooledByteBufAllocator.DEFAULT = new PooledByteBufAllocator(false);
    }

    public PooledByteBufAllocator() {
        this(false);
    }

    public PooledByteBufAllocator(int v, int v1, int v2, int v3) {
        this(false, v, v1, v2, v3);
    }

    public PooledByteBufAllocator(boolean z) {
        this(z, PooledByteBufAllocator.DEFAULT_NUM_HEAP_ARENA, PooledByteBufAllocator.DEFAULT_NUM_DIRECT_ARENA, PooledByteBufAllocator.DEFAULT_PAGE_SIZE, PooledByteBufAllocator.DEFAULT_MAX_ORDER);
    }

    @Deprecated
    public PooledByteBufAllocator(boolean z, int v, int v1, int v2, int v3) {
        this(z, v, v1, v2, v3, 0, PooledByteBufAllocator.DEFAULT_SMALL_CACHE_SIZE, PooledByteBufAllocator.DEFAULT_NORMAL_CACHE_SIZE);
    }

    @Deprecated
    public PooledByteBufAllocator(boolean z, int v, int v1, int v2, int v3, int v4, int v5, int v6) {
        this(z, v, v1, v2, v3, v5, v6, PooledByteBufAllocator.DEFAULT_USE_CACHE_FOR_ALL_THREADS, PooledByteBufAllocator.DEFAULT_DIRECT_MEMORY_CACHE_ALIGNMENT);
    }

    @Deprecated
    public PooledByteBufAllocator(boolean z, int v, int v1, int v2, int v3, int v4, int v5, int v6, boolean z1) {
        this(z, v, v1, v2, v3, v5, v6, z1);
    }

    @Deprecated
    public PooledByteBufAllocator(boolean z, int v, int v1, int v2, int v3, int v4, int v5, int v6, boolean z1, int v7) {
        this(z, v, v1, v2, v3, v5, v6, z1, v7);
    }

    public PooledByteBufAllocator(boolean z, int v, int v1, int v2, int v3, int v4, int v5, boolean z1) {
        this(z, v, v1, v2, v3, v4, v5, z1, PooledByteBufAllocator.DEFAULT_DIRECT_MEMORY_CACHE_ALIGNMENT);
    }

    public PooledByteBufAllocator(boolean z, int v, int v1, int v2, int v3, int v4, int v5, boolean z1, int v6) {
        super(z);
        this.trimTask = () -> {
            PoolThreadCache poolThreadCache0 = (PoolThreadCache)PooledByteBufAllocator.this.threadCache.getIfExists();
            if(poolThreadCache0 != null) {
                poolThreadCache0.trim();
                return true;
            }
            return false;
        };
        this.threadCache = new PoolThreadLocalCache(this, z1);
        this.smallCacheSize = v4;
        this.normalCacheSize = v5;
        if(v6 != 0) {
            v2 = (int)PlatformDependent.align(v2, v6);
        }
        int v7 = PooledByteBufAllocator.validateAndCalculateChunkSize(v2, v3);
        this.chunkSize = v7;
        ObjectUtil.checkPositiveOrZero(v, "nHeapArena");
        ObjectUtil.checkPositiveOrZero(v1, "nDirectArena");
        ObjectUtil.checkPositiveOrZero(v6, "directMemoryCacheAlignment");
        if((-v6 & v6) != v6) {
            throw new IllegalArgumentException("directMemoryCacheAlignment: " + v6 + " (expected: power of two)");
        }
        int v8 = PooledByteBufAllocator.validateAndCalculatePageShifts(v2, v6);
        if(v > 0) {
            PoolArena[] arr_poolArena = PooledByteBufAllocator.newArenaArray(v);
            this.heapArenas = arr_poolArena;
            ArrayList arrayList0 = new ArrayList(arr_poolArena.length);
            SizeClasses sizeClasses0 = new SizeClasses(v2, v8, v7, 0);
            for(int v10 = 0; v10 < this.heapArenas.length; ++v10) {
                HeapArena poolArena$HeapArena0 = new HeapArena(this, sizeClasses0);
                this.heapArenas[v10] = poolArena$HeapArena0;
                arrayList0.add(poolArena$HeapArena0);
            }
            this.heapArenaMetrics = Collections.unmodifiableList(arrayList0);
        }
        else {
            this.heapArenas = null;
            this.heapArenaMetrics = Collections.EMPTY_LIST;
        }
        if(v1 > 0) {
            PoolArena[] arr_poolArena1 = PooledByteBufAllocator.newArenaArray(v1);
            this.directArenas = arr_poolArena1;
            ArrayList arrayList1 = new ArrayList(arr_poolArena1.length);
            SizeClasses sizeClasses1 = new SizeClasses(v2, v8, this.chunkSize, v6);
            for(int v9 = 0; v9 < this.directArenas.length; ++v9) {
                DirectArena poolArena$DirectArena0 = new DirectArena(this, sizeClasses1);
                this.directArenas[v9] = poolArena$DirectArena0;
                arrayList1.add(poolArena$DirectArena0);
            }
            this.directArenaMetrics = Collections.unmodifiableList(arrayList1);
        }
        else {
            this.directArenas = null;
            this.directArenaMetrics = Collections.EMPTY_LIST;
        }
        this.metric = new PooledByteBufAllocatorMetric(this);
    }

    public static int access$400() [...] // 潜在的解密器

    public static long access$500() [...] // 潜在的解密器

    public static Runnable access$600(PooledByteBufAllocator pooledByteBufAllocator0) {
        return pooledByteBufAllocator0.trimTask;
    }

    @Deprecated
    public final int chunkSize() {
        return this.chunkSize;
    }

    public static int defaultMaxOrder() {
        return PooledByteBufAllocator.DEFAULT_MAX_ORDER;
    }

    public static int defaultNormalCacheSize() {
        return PooledByteBufAllocator.DEFAULT_NORMAL_CACHE_SIZE;
    }

    public static int defaultNumDirectArena() {
        return PooledByteBufAllocator.DEFAULT_NUM_DIRECT_ARENA;
    }

    public static int defaultNumHeapArena() {
        return PooledByteBufAllocator.DEFAULT_NUM_HEAP_ARENA;
    }

    public static int defaultPageSize() {
        return PooledByteBufAllocator.DEFAULT_PAGE_SIZE;
    }

    public static boolean defaultPreferDirect() {
        return PlatformDependent.directBufferPreferred();
    }

    public static int defaultSmallCacheSize() {
        return PooledByteBufAllocator.DEFAULT_SMALL_CACHE_SIZE;
    }

    @Deprecated
    public static int defaultTinyCacheSize() {
        return 0;
    }

    public static boolean defaultUseCacheForAllThreads() {
        return PooledByteBufAllocator.DEFAULT_USE_CACHE_FOR_ALL_THREADS;
    }

    @Deprecated
    public List directArenas() {
        return this.directArenaMetrics;
    }

    public String dumpStats() {
        int v1 = this.heapArenas == null ? 0 : this.heapArenas.length;
        StringBuilder stringBuilder0 = new StringBuilder(0x200);
        stringBuilder0.append(v1);
        stringBuilder0.append(" heap arena(s):");
        stringBuilder0.append("\n");
        if(v1 > 0) {
            PoolArena[] arr_poolArena = this.heapArenas;
            for(int v2 = 0; v2 < arr_poolArena.length; ++v2) {
                stringBuilder0.append(arr_poolArena[v2]);
            }
        }
        int v3 = this.directArenas == null ? 0 : this.directArenas.length;
        stringBuilder0.append(v3);
        stringBuilder0.append(" direct arena(s):");
        stringBuilder0.append("\n");
        if(v3 > 0) {
            PoolArena[] arr_poolArena1 = this.directArenas;
            for(int v = 0; v < arr_poolArena1.length; ++v) {
                stringBuilder0.append(arr_poolArena1[v]);
            }
        }
        return stringBuilder0.toString();
    }

    @Deprecated
    public void freeThreadLocalCache() {
        this.threadCache.remove();
    }

    @Deprecated
    public boolean hasThreadLocalCache() {
        return this.threadCache.isSet();
    }

    @Deprecated
    public List heapArenas() {
        return this.heapArenaMetrics;
    }

    @Override  // io.netty.buffer.ByteBufAllocator
    public boolean isDirectBufferPooled() {
        return this.directArenas != null;
    }

    public static boolean isDirectMemoryCacheAlignmentSupported() [...] // 潜在的解密器

    @Override  // io.netty.buffer.ByteBufAllocatorMetricProvider
    public ByteBufAllocatorMetric metric() {
        return this.metric();
    }

    public PooledByteBufAllocatorMetric metric() {
        return this.metric;
    }

    private static PoolArena[] newArenaArray(int v) {
        return new PoolArena[v];
    }

    @Override  // io.netty.buffer.AbstractByteBufAllocator
    public ByteBuf newDirectBuffer(int v, int v1) {
        PoolThreadCache poolThreadCache0 = (PoolThreadCache)this.threadCache.get();
        return poolThreadCache0.directArena == null ? AbstractByteBufAllocator.toLeakAwareBuffer(UnsafeByteBufUtil.newUnsafeDirectByteBuf(this, v, v1)) : AbstractByteBufAllocator.toLeakAwareBuffer(poolThreadCache0.directArena.allocate(poolThreadCache0, v, v1));
    }

    // 去混淆评级： 低(20)
    @Override  // io.netty.buffer.AbstractByteBufAllocator
    public ByteBuf newHeapBuffer(int v, int v1) {
        PoolThreadCache poolThreadCache0 = (PoolThreadCache)this.threadCache.get();
        return poolThreadCache0.heapArena == null ? AbstractByteBufAllocator.toLeakAwareBuffer(new UnpooledUnsafeHeapByteBuf(this, v, v1)) : AbstractByteBufAllocator.toLeakAwareBuffer(poolThreadCache0.heapArena.allocate(poolThreadCache0, v, v1));
    }

    @Deprecated
    public int normalCacheSize() {
        return this.normalCacheSize;
    }

    @Deprecated
    public int numDirectArenas() {
        return this.directArenaMetrics.size();
    }

    @Deprecated
    public int numHeapArenas() {
        return this.heapArenaMetrics.size();
    }

    @Deprecated
    public int numThreadLocalCaches() {
        PoolArena[] arr_poolArena = this.heapArenas == null ? this.directArenas : this.heapArenas;
        if(arr_poolArena == null) {
            return 0;
        }
        int v1 = 0;
        for(int v = 0; v < arr_poolArena.length; ++v) {
            v1 += arr_poolArena[v].numThreadCaches.get();
        }
        return v1;
    }

    public final long pinnedDirectMemory() {
        return PooledByteBufAllocator.pinnedMemory(this.directArenas);
    }

    public final long pinnedHeapMemory() {
        return PooledByteBufAllocator.pinnedMemory(this.heapArenas);
    }

    private static long pinnedMemory(PoolArena[] arr_poolArena) {
        if(arr_poolArena == null) {
            return -1L;
        }
        long v1 = 0L;
        for(int v = 0; v < arr_poolArena.length; ++v) {
            v1 += arr_poolArena[v].numPinnedBytes();
            if(v1 < 0L) {
                return 0x7FFFFFFFFFFFFFFFL;
            }
        }
        return v1;
    }

    @Deprecated
    public int smallCacheSize() {
        return this.smallCacheSize;
    }

    public final PoolThreadCache threadCache() {
        return (PoolThreadCache)this.threadCache.get();
    }

    @Deprecated
    public int tinyCacheSize() [...] // Inlined contents

    // 检测为 Lambda 实现
    public boolean trimCurrentThreadCache() [...]

    public final long usedDirectMemory() {
        return PooledByteBufAllocator.usedMemory(this.directArenas);
    }

    public final long usedHeapMemory() {
        return PooledByteBufAllocator.usedMemory(this.heapArenas);
    }

    private static long usedMemory(PoolArena[] arr_poolArena) {
        if(arr_poolArena == null) {
            return -1L;
        }
        long v1 = 0L;
        for(int v = 0; v < arr_poolArena.length; ++v) {
            v1 += arr_poolArena[v].numActiveBytes();
            if(v1 < 0L) {
                return 0x7FFFFFFFFFFFFFFFL;
            }
        }
        return v1;
    }

    private static int validateAndCalculateChunkSize(int v, int v1) {
        if(v1 > 14) {
            throw new IllegalArgumentException("maxOrder: " + v1 + " (expected: 0-14)");
        }
        int v2 = v;
        for(int v3 = v1; v3 > 0; --v3) {
            if(v2 > 0x20000000) {
                throw new IllegalArgumentException(String.format("pageSize (%d) << maxOrder (%d) must not exceed %d", v, v1, 0x40000000));
            }
            v2 <<= 1;
        }
        return v2;
    }

    private static int validateAndCalculatePageShifts(int v, int v1) {
        if(v < 0x1000) {
            throw new IllegalArgumentException("pageSize: " + v + " (expected: 4096)");
        }
        if((v - 1 & v) != 0) {
            throw new IllegalArgumentException("pageSize: " + v + " (expected: power of 2)");
        }
        if(v < v1) {
            throw new IllegalArgumentException("Alignment cannot be greater than page size. Alignment: " + v1 + ", page size: " + v + '.');
        }
        return 0x1F - Integer.numberOfLeadingZeros(v);
    }

    class io.netty.buffer.PooledByteBufAllocator.1 implements Runnable {
        @Override
        public void run() {
            PooledByteBufAllocator.this.trimCurrentThreadCache();
        }
    }

}

