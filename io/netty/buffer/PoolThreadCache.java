package io.netty.buffer;

import io.netty.util.Recycler.EnhancedHandle;
import io.netty.util.internal.MathUtil;
import io.netty.util.internal.ObjectPool.Handle;
import io.netty.util.internal.ObjectPool.ObjectCreator;
import io.netty.util.internal.ObjectPool;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicBoolean;

final class PoolThreadCache {
    static final class FreeOnFinalize {
        private final PoolThreadCache cache;

        private FreeOnFinalize(PoolThreadCache poolThreadCache0) {
            this.cache = poolThreadCache0;
        }

        public FreeOnFinalize(PoolThreadCache poolThreadCache0, io.netty.buffer.PoolThreadCache.1 poolThreadCache$10) {
            this(poolThreadCache0);
        }

        @Override
        public void finalize() {
            try {
                super.finalize();
            }
            finally {
                this.cache.free(true);
            }
        }
    }

    static abstract class MemoryRegionCache {
        static final class Entry {
            PoolChunk chunk;
            long handle;
            ByteBuffer nioBuffer;
            int normCapacity;
            final EnhancedHandle recyclerHandle;

            public Entry(Handle objectPool$Handle0) {
                this.handle = -1L;
                this.recyclerHandle = (EnhancedHandle)objectPool$Handle0;
            }

            public void recycle() {
                this.chunk = null;
                this.nioBuffer = null;
                this.handle = -1L;
                this.recyclerHandle.recycle(this);
            }

            public void unguardedRecycle() {
                this.chunk = null;
                this.nioBuffer = null;
                this.handle = -1L;
                this.recyclerHandle.unguardedRecycle(this);
            }
        }

        private static final ObjectPool RECYCLER;
        private int allocations;
        private final Queue queue;
        private final int size;
        private final SizeClass sizeClass;

        static {
            MemoryRegionCache.RECYCLER = ObjectPool.newPool(new ObjectCreator() {
                public Entry newObject(Handle objectPool$Handle0) {
                    return new Entry(objectPool$Handle0);
                }

                @Override  // io.netty.util.internal.ObjectPool$ObjectCreator
                public Object newObject(Handle objectPool$Handle0) {
                    return this.newObject(objectPool$Handle0);
                }
            });
        }

        public MemoryRegionCache(int v, SizeClass poolArena$SizeClass0) {
            int v1 = MathUtil.safeFindNextPositivePowerOfTwo(v);
            this.size = v1;
            this.queue = PlatformDependent.newFixedMpscQueue(v1);
            this.sizeClass = poolArena$SizeClass0;
        }

        public static Queue access$100(MemoryRegionCache poolThreadCache$MemoryRegionCache0) {
            return poolThreadCache$MemoryRegionCache0.queue;
        }

        public final boolean add(PoolChunk poolChunk0, ByteBuffer byteBuffer0, long v, int v1) {
            Entry poolThreadCache$MemoryRegionCache$Entry0 = MemoryRegionCache.newEntry(poolChunk0, byteBuffer0, v, v1);
            boolean z = this.queue.offer(poolThreadCache$MemoryRegionCache$Entry0);
            if(!z) {
                poolThreadCache$MemoryRegionCache$Entry0.unguardedRecycle();
            }
            return z;
        }

        public final boolean allocate(PooledByteBuf pooledByteBuf0, int v, PoolThreadCache poolThreadCache0) {
            Entry poolThreadCache$MemoryRegionCache$Entry0 = (Entry)this.queue.poll();
            if(poolThreadCache$MemoryRegionCache$Entry0 == null) {
                return false;
            }
            this.initBuf(poolThreadCache$MemoryRegionCache$Entry0.chunk, poolThreadCache$MemoryRegionCache$Entry0.nioBuffer, poolThreadCache$MemoryRegionCache$Entry0.handle, pooledByteBuf0, v, poolThreadCache0);
            poolThreadCache$MemoryRegionCache$Entry0.unguardedRecycle();
            ++this.allocations;
            return true;
        }

        private int free(int v, boolean z) {
            int v1;
            for(v1 = 0; v1 < v; ++v1) {
                Entry poolThreadCache$MemoryRegionCache$Entry0 = (Entry)this.queue.poll();
                if(poolThreadCache$MemoryRegionCache$Entry0 == null) {
                    break;
                }
                this.freeEntry(poolThreadCache$MemoryRegionCache$Entry0, z);
            }
            return v1;
        }

        public final int free(boolean z) {
            return this.free(0x7FFFFFFF, z);
        }

        private void freeEntry(Entry poolThreadCache$MemoryRegionCache$Entry0, boolean z) {
            PoolChunk poolChunk0 = poolThreadCache$MemoryRegionCache$Entry0.chunk;
            long v = poolThreadCache$MemoryRegionCache$Entry0.handle;
            ByteBuffer byteBuffer0 = poolThreadCache$MemoryRegionCache$Entry0.nioBuffer;
            int v1 = poolThreadCache$MemoryRegionCache$Entry0.normCapacity;
            if(!z) {
                poolThreadCache$MemoryRegionCache$Entry0.recycle();
            }
            poolChunk0.arena.freeChunk(poolChunk0, v, v1, this.sizeClass, byteBuffer0, z);
        }

        public abstract void initBuf(PoolChunk arg1, ByteBuffer arg2, long arg3, PooledByteBuf arg4, int arg5, PoolThreadCache arg6);

        private static Entry newEntry(PoolChunk poolChunk0, ByteBuffer byteBuffer0, long v, int v1) {
            Entry poolThreadCache$MemoryRegionCache$Entry0 = (Entry)MemoryRegionCache.RECYCLER.get();
            poolThreadCache$MemoryRegionCache$Entry0.chunk = poolChunk0;
            poolThreadCache$MemoryRegionCache$Entry0.nioBuffer = byteBuffer0;
            poolThreadCache$MemoryRegionCache$Entry0.handle = v;
            poolThreadCache$MemoryRegionCache$Entry0.normCapacity = v1;
            return poolThreadCache$MemoryRegionCache$Entry0;
        }

        public final void trim() {
            int v = this.size - this.allocations;
            this.allocations = 0;
            if(v > 0) {
                this.free(v, false);
            }
        }
    }

    static final class NormalMemoryRegionCache extends MemoryRegionCache {
        public NormalMemoryRegionCache(int v) {
            super(v, SizeClass.Normal);
        }

        @Override  // io.netty.buffer.PoolThreadCache$MemoryRegionCache
        public void initBuf(PoolChunk poolChunk0, ByteBuffer byteBuffer0, long v, PooledByteBuf pooledByteBuf0, int v1, PoolThreadCache poolThreadCache0) {
            poolChunk0.initBuf(pooledByteBuf0, byteBuffer0, v, v1, poolThreadCache0);
        }
    }

    static final class SubPageMemoryRegionCache extends MemoryRegionCache {
        public SubPageMemoryRegionCache(int v) {
            super(v, SizeClass.Small);
        }

        @Override  // io.netty.buffer.PoolThreadCache$MemoryRegionCache
        public void initBuf(PoolChunk poolChunk0, ByteBuffer byteBuffer0, long v, PooledByteBuf pooledByteBuf0, int v1, PoolThreadCache poolThreadCache0) {
            poolChunk0.initBufWithSubpage(pooledByteBuf0, byteBuffer0, v, v1, poolThreadCache0);
        }
    }

    private static final int INTEGER_SIZE_MINUS_ONE = 0x1F;
    private int allocations;
    final PoolArena directArena;
    private final FreeOnFinalize freeOnFinalize;
    private final int freeSweepAllocationThreshold;
    private final AtomicBoolean freed;
    final PoolArena heapArena;
    private static final InternalLogger logger;
    private final MemoryRegionCache[] normalDirectCaches;
    private final MemoryRegionCache[] normalHeapCaches;
    private final MemoryRegionCache[] smallSubPageDirectCaches;
    private final MemoryRegionCache[] smallSubPageHeapCaches;

    static {
        PoolThreadCache.logger = InternalLoggerFactory.getInstance(PoolThreadCache.class);
    }

    public PoolThreadCache(PoolArena poolArena0, PoolArena poolArena1, int v, int v1, int v2, int v3, boolean z) {
        this.freed = new AtomicBoolean();
        ObjectUtil.checkPositiveOrZero(v2, "maxCachedBufferCapacity");
        this.freeSweepAllocationThreshold = v3;
        this.heapArena = poolArena0;
        this.directArena = poolArena1;
        FreeOnFinalize poolThreadCache$FreeOnFinalize0 = null;
        if(poolArena1 == null) {
            this.smallSubPageDirectCaches = null;
            this.normalDirectCaches = null;
        }
        else {
            this.smallSubPageDirectCaches = PoolThreadCache.createSubPageCaches(v, poolArena1.sizeClass.nSubpages);
            this.normalDirectCaches = PoolThreadCache.createNormalCaches(v1, v2, poolArena1);
            poolArena1.numThreadCaches.getAndIncrement();
        }
        if(poolArena0 == null) {
            this.smallSubPageHeapCaches = null;
            this.normalHeapCaches = null;
        }
        else {
            this.smallSubPageHeapCaches = PoolThreadCache.createSubPageCaches(v, poolArena0.sizeClass.nSubpages);
            this.normalHeapCaches = PoolThreadCache.createNormalCaches(v1, v2, poolArena0);
            poolArena0.numThreadCaches.getAndIncrement();
        }
        if((this.smallSubPageDirectCaches != null || this.normalDirectCaches != null || this.smallSubPageHeapCaches != null || this.normalHeapCaches != null) && v3 < 1) {
            throw new IllegalArgumentException("freeSweepAllocationThreshold: " + v3 + " (expected: > 0)");
        }
        if(z) {
            poolThreadCache$FreeOnFinalize0 = new FreeOnFinalize(this, null);
        }
        this.freeOnFinalize = poolThreadCache$FreeOnFinalize0;
    }

    public boolean add(PoolArena poolArena0, PoolChunk poolChunk0, ByteBuffer byteBuffer0, long v, int v1, SizeClass poolArena$SizeClass0) {
        MemoryRegionCache poolThreadCache$MemoryRegionCache0 = this.cache(poolArena0, poolArena0.sizeClass.size2SizeIdx(v1), poolArena$SizeClass0);
        if(poolThreadCache$MemoryRegionCache0 == null) {
            return false;
        }
        return this.freed.get() ? false : poolThreadCache$MemoryRegionCache0.add(poolChunk0, byteBuffer0, v, v1);
    }

    private boolean allocate(MemoryRegionCache poolThreadCache$MemoryRegionCache0, PooledByteBuf pooledByteBuf0, int v) {
        if(poolThreadCache$MemoryRegionCache0 == null) {
            return false;
        }
        boolean z = poolThreadCache$MemoryRegionCache0.allocate(pooledByteBuf0, v, this);
        int v1 = this.allocations + 1;
        this.allocations = v1;
        if(v1 >= this.freeSweepAllocationThreshold) {
            this.allocations = 0;
            this.trim();
        }
        return z;
    }

    public boolean allocateNormal(PoolArena poolArena0, PooledByteBuf pooledByteBuf0, int v, int v1) {
        return this.allocate(this.cacheForNormal(poolArena0, v1), pooledByteBuf0, v);
    }

    public boolean allocateSmall(PoolArena poolArena0, PooledByteBuf pooledByteBuf0, int v, int v1) {
        return this.allocate(this.cacheForSmall(poolArena0, v1), pooledByteBuf0, v);
    }

    private MemoryRegionCache cache(PoolArena poolArena0, int v, SizeClass poolArena$SizeClass0) {
        switch(io.netty.buffer.PoolThreadCache.1.$SwitchMap$io$netty$buffer$PoolArena$SizeClass[poolArena$SizeClass0.ordinal()]) {
            case 1: {
                return this.cacheForNormal(poolArena0, v);
            }
            case 2: {
                return this.cacheForSmall(poolArena0, v);
            }
            default: {
                throw new Error();
            }
        }
    }

    private static MemoryRegionCache cache(MemoryRegionCache[] arr_poolThreadCache$MemoryRegionCache, int v) {
        return arr_poolThreadCache$MemoryRegionCache == null || v > arr_poolThreadCache$MemoryRegionCache.length - 1 ? null : arr_poolThreadCache$MemoryRegionCache[v];
    }

    private MemoryRegionCache cacheForNormal(PoolArena poolArena0, int v) {
        int v1 = v - poolArena0.sizeClass.nSubpages;
        return poolArena0.isDirect() ? PoolThreadCache.cache(this.normalDirectCaches, v1) : PoolThreadCache.cache(this.normalHeapCaches, v1);
    }

    // 去混淆评级： 低(20)
    private MemoryRegionCache cacheForSmall(PoolArena poolArena0, int v) {
        return poolArena0.isDirect() ? PoolThreadCache.cache(this.smallSubPageDirectCaches, v) : PoolThreadCache.cache(this.smallSubPageHeapCaches, v);
    }

    private static void checkCacheMayLeak(MemoryRegionCache[] arr_poolThreadCache$MemoryRegionCache, String s) {
        for(int v = 0; v < arr_poolThreadCache$MemoryRegionCache.length; ++v) {
            if(!MemoryRegionCache.access$100(arr_poolThreadCache$MemoryRegionCache[v]).isEmpty()) {
                PoolThreadCache.logger.debug("{} memory may leak.", s);
                return;
            }
        }
    }

    private static MemoryRegionCache[] createNormalCaches(int v, int v1, PoolArena poolArena0) {
        if(v > 0 && v1 > 0) {
            int v2 = Math.min(poolArena0.sizeClass.chunkSize, v1);
            ArrayList arrayList0 = new ArrayList();
            for(int v3 = poolArena0.sizeClass.nSubpages; v3 < poolArena0.sizeClass.nSizes && poolArena0.sizeClass.sizeIdx2size(v3) <= v2; ++v3) {
                arrayList0.add(new NormalMemoryRegionCache(v));
            }
            return (MemoryRegionCache[])arrayList0.toArray(new MemoryRegionCache[0]);
        }
        return null;
    }

    private static MemoryRegionCache[] createSubPageCaches(int v, int v1) {
        if(v > 0 && v1 > 0) {
            MemoryRegionCache[] arr_poolThreadCache$MemoryRegionCache = new MemoryRegionCache[v1];
            for(int v2 = 0; v2 < v1; ++v2) {
                arr_poolThreadCache$MemoryRegionCache[v2] = new SubPageMemoryRegionCache(v);
            }
            return arr_poolThreadCache$MemoryRegionCache;
        }
        return null;
    }

    private static int free(MemoryRegionCache poolThreadCache$MemoryRegionCache0, boolean z) {
        return poolThreadCache$MemoryRegionCache0 == null ? 0 : poolThreadCache$MemoryRegionCache0.free(z);
    }

    private static int free(MemoryRegionCache[] arr_poolThreadCache$MemoryRegionCache, boolean z) {
        if(arr_poolThreadCache$MemoryRegionCache == null) {
            return 0;
        }
        int v1 = 0;
        for(int v = 0; v < arr_poolThreadCache$MemoryRegionCache.length; ++v) {
            v1 += PoolThreadCache.free(arr_poolThreadCache$MemoryRegionCache[v], z);
        }
        return v1;
    }

    public void free(boolean z) {
        if(this.freed.compareAndSet(false, true)) {
            int v = PoolThreadCache.free(this.smallSubPageDirectCaches, z) + PoolThreadCache.free(this.normalDirectCaches, z) + PoolThreadCache.free(this.smallSubPageHeapCaches, z) + PoolThreadCache.free(this.normalHeapCaches, z);
            if(v > 0) {
                InternalLogger internalLogger0 = PoolThreadCache.logger;
                if(internalLogger0.isDebugEnabled()) {
                    internalLogger0.debug("Freed {} thread-local buffer(s) from thread: {}", v, "jeb-dexdec-sb-st-2355");
                }
            }
            PoolArena poolArena0 = this.directArena;
            if(poolArena0 != null) {
                poolArena0.numThreadCaches.getAndDecrement();
            }
            PoolArena poolArena1 = this.heapArena;
            if(poolArena1 != null) {
                poolArena1.numThreadCaches.getAndDecrement();
            }
            return;
        }
        PoolThreadCache.checkCacheMayLeak(this.smallSubPageDirectCaches, "SmallSubPageDirectCaches");
        PoolThreadCache.checkCacheMayLeak(this.normalDirectCaches, "NormalDirectCaches");
        PoolThreadCache.checkCacheMayLeak(this.smallSubPageHeapCaches, "SmallSubPageHeapCaches");
        PoolThreadCache.checkCacheMayLeak(this.normalHeapCaches, "NormalHeapCaches");
    }

    public static int log2(int v) {
        return 0x1F - Integer.numberOfLeadingZeros(v);
    }

    private static void trim(MemoryRegionCache poolThreadCache$MemoryRegionCache0) {
        if(poolThreadCache$MemoryRegionCache0 == null) {
            return;
        }
        poolThreadCache$MemoryRegionCache0.trim();
    }

    private static void trim(MemoryRegionCache[] arr_poolThreadCache$MemoryRegionCache) {
        if(arr_poolThreadCache$MemoryRegionCache != null) {
            for(int v = 0; v < arr_poolThreadCache$MemoryRegionCache.length; ++v) {
                PoolThreadCache.trim(arr_poolThreadCache$MemoryRegionCache[v]);
            }
        }
    }

    public void trim() {
        PoolThreadCache.trim(this.smallSubPageDirectCaches);
        PoolThreadCache.trim(this.normalDirectCaches);
        PoolThreadCache.trim(this.smallSubPageHeapCaches);
        PoolThreadCache.trim(this.normalHeapCaches);
    }
}

