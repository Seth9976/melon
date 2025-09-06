package io.netty.buffer;

import io.netty.util.internal.LongCounter;
import io.netty.util.internal.PlatformDependent;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

abstract class PoolArena implements PoolArenaMetric {
    static final class DirectArena extends PoolArena {
        public DirectArena(PooledByteBufAllocator pooledByteBufAllocator0, SizeClasses sizeClasses0) {
            super(pooledByteBufAllocator0, sizeClasses0);
        }

        // 去混淆评级： 低(40)
        private static ByteBuffer allocateDirect(int v) {
            return ByteBuffer.allocateDirect(v);
        }

        @Override  // io.netty.buffer.PoolArena
        public void destroyChunk(PoolChunk poolChunk0) {
            if(PlatformDependent.useDirectBufferNoCleaner()) {
                PlatformDependent.freeDirectNoCleaner(((ByteBuffer)poolChunk0.base));
                return;
            }
            PlatformDependent.freeDirectBuffer(((ByteBuffer)poolChunk0.base));
        }

        @Override  // io.netty.buffer.PoolArena
        public boolean isDirect() {
            return true;
        }

        @Override  // io.netty.buffer.PoolArena
        public void memoryCopy(Object object0, int v, PooledByteBuf pooledByteBuf0, int v1) {
            this.memoryCopy(((ByteBuffer)object0), v, pooledByteBuf0, v1);
        }

        public void memoryCopy(ByteBuffer byteBuffer0, int v, PooledByteBuf pooledByteBuf0, int v1) {
            if(v1 == 0) {
                return;
            }
            if(PoolArena.HAS_UNSAFE) {
                PlatformDependent.copyMemory(PlatformDependent.directBufferAddress(byteBuffer0) + ((long)v), PlatformDependent.directBufferAddress(((ByteBuffer)pooledByteBuf0.memory)) + ((long)pooledByteBuf0.offset), v1);
                return;
            }
            ByteBuffer byteBuffer1 = byteBuffer0.duplicate();
            ByteBuffer byteBuffer2 = pooledByteBuf0.internalNioBuffer();
            byteBuffer1.position(v).limit(v + v1);
            byteBuffer2.position(pooledByteBuf0.offset);
            byteBuffer2.put(byteBuffer1);
        }

        @Override  // io.netty.buffer.PoolArena
        public PooledByteBuf newByteBuf(int v) {
            return PoolArena.HAS_UNSAFE ? PooledUnsafeDirectByteBuf.newInstance(v) : PooledDirectByteBuf.newInstance(v);
        }

        @Override  // io.netty.buffer.PoolArena
        public PoolChunk newChunk(int v, int v1, int v2, int v3) {
            int v4 = this.sizeClass.directMemoryCacheAlignment;
            if(v4 == 0) {
                ByteBuffer byteBuffer0 = DirectArena.allocateDirect(v3);
                return new PoolChunk(this, byteBuffer0, byteBuffer0, v, v2, v3, v1);
            }
            ByteBuffer byteBuffer1 = DirectArena.allocateDirect(v4 + v3);
            return new PoolChunk(this, byteBuffer1, PlatformDependent.alignDirectBuffer(byteBuffer1, this.sizeClass.directMemoryCacheAlignment), v, v2, v3, v1);
        }

        @Override  // io.netty.buffer.PoolArena
        public PoolChunk newUnpooledChunk(int v) {
            int v1 = this.sizeClass.directMemoryCacheAlignment;
            if(v1 == 0) {
                ByteBuffer byteBuffer0 = DirectArena.allocateDirect(v);
                return new PoolChunk(this, byteBuffer0, byteBuffer0, v);
            }
            ByteBuffer byteBuffer1 = DirectArena.allocateDirect(v1 + v);
            return new PoolChunk(this, byteBuffer1, PlatformDependent.alignDirectBuffer(byteBuffer1, this.sizeClass.directMemoryCacheAlignment), v);
        }
    }

    static final class HeapArena extends PoolArena {
        public HeapArena(PooledByteBufAllocator pooledByteBufAllocator0, SizeClasses sizeClasses0) {
            super(pooledByteBufAllocator0, sizeClasses0);
        }

        @Override  // io.netty.buffer.PoolArena
        public void destroyChunk(PoolChunk poolChunk0) {
        }

        @Override  // io.netty.buffer.PoolArena
        public boolean isDirect() {
            return false;
        }

        @Override  // io.netty.buffer.PoolArena
        public void memoryCopy(Object object0, int v, PooledByteBuf pooledByteBuf0, int v1) {
            this.memoryCopy(((byte[])object0), v, pooledByteBuf0, v1);
        }

        public void memoryCopy(byte[] arr_b, int v, PooledByteBuf pooledByteBuf0, int v1) {
            if(v1 == 0) {
                return;
            }
            System.arraycopy(arr_b, v, pooledByteBuf0.memory, pooledByteBuf0.offset, v1);
        }

        private static byte[] newByteArray(int v) {
            return PlatformDependent.allocateUninitializedArray(v);
        }

        // 去混淆评级： 低(30)
        @Override  // io.netty.buffer.PoolArena
        public PooledByteBuf newByteBuf(int v) {
            return PooledUnsafeHeapByteBuf.newUnsafeInstance(v);
        }

        @Override  // io.netty.buffer.PoolArena
        public PoolChunk newChunk(int v, int v1, int v2, int v3) {
            return new PoolChunk(this, null, HeapArena.newByteArray(v3), v, v2, v3, v1);
        }

        @Override  // io.netty.buffer.PoolArena
        public PoolChunk newUnpooledChunk(int v) {
            return new PoolChunk(this, null, HeapArena.newByteArray(v), v);
        }
    }

    static enum SizeClass {
        Small,
        Normal;

    }

    static final boolean $assertionsDisabled;
    private static final boolean HAS_UNSAFE;
    private final LongCounter activeBytesHuge;
    private final LongCounter allocationsHuge;
    private long allocationsNormal;
    private final LongCounter allocationsSmall;
    private final List chunkListMetrics;
    private final LongCounter deallocationsHuge;
    private long deallocationsNormal;
    private long deallocationsSmall;
    private final ReentrantLock lock;
    final AtomicInteger numThreadCaches;
    final PooledByteBufAllocator parent;
    private final PoolChunkList q000;
    private final PoolChunkList q025;
    private final PoolChunkList q050;
    private final PoolChunkList q075;
    private final PoolChunkList q100;
    private final PoolChunkList qInit;
    final SizeClasses sizeClass;
    final PoolSubpage[] smallSubpagePools;

    static {
        PoolArena.HAS_UNSAFE = PlatformDependent.hasUnsafe();
    }

    public PoolArena(PooledByteBufAllocator pooledByteBufAllocator0, SizeClasses sizeClasses0) {
        this.allocationsSmall = PlatformDependent.newLongCounter();
        this.allocationsHuge = PlatformDependent.newLongCounter();
        this.activeBytesHuge = PlatformDependent.newLongCounter();
        this.deallocationsHuge = PlatformDependent.newLongCounter();
        this.numThreadCaches = new AtomicInteger();
        this.lock = new ReentrantLock();
        this.parent = pooledByteBufAllocator0;
        this.sizeClass = sizeClasses0;
        this.smallSubpagePools = this.newSubpagePoolArray(sizeClasses0.nSubpages);
        for(int v = 0; true; ++v) {
            PoolSubpage[] arr_poolSubpage = this.smallSubpagePools;
            if(v >= arr_poolSubpage.length) {
                break;
            }
            arr_poolSubpage[v] = this.newSubpagePoolHead(v);
        }
        PoolChunkList poolChunkList0 = new PoolChunkList(this, null, 100, 0x7FFFFFFF, sizeClasses0.chunkSize);
        this.q100 = poolChunkList0;
        PoolChunkList poolChunkList1 = new PoolChunkList(this, poolChunkList0, 75, 100, sizeClasses0.chunkSize);
        this.q075 = poolChunkList1;
        PoolChunkList poolChunkList2 = new PoolChunkList(this, poolChunkList1, 50, 100, sizeClasses0.chunkSize);
        this.q050 = poolChunkList2;
        PoolChunkList poolChunkList3 = new PoolChunkList(this, poolChunkList2, 25, 75, sizeClasses0.chunkSize);
        this.q025 = poolChunkList3;
        PoolChunkList poolChunkList4 = new PoolChunkList(this, poolChunkList3, 1, 50, sizeClasses0.chunkSize);
        this.q000 = poolChunkList4;
        PoolChunkList poolChunkList5 = new PoolChunkList(this, poolChunkList4, 0x80000000, 25, sizeClasses0.chunkSize);
        this.qInit = poolChunkList5;
        poolChunkList0.prevList(poolChunkList1);
        poolChunkList1.prevList(poolChunkList2);
        poolChunkList2.prevList(poolChunkList3);
        poolChunkList3.prevList(poolChunkList4);
        poolChunkList4.prevList(null);
        poolChunkList5.prevList(poolChunkList5);
        ArrayList arrayList0 = new ArrayList(6);
        arrayList0.add(poolChunkList5);
        arrayList0.add(poolChunkList4);
        arrayList0.add(poolChunkList3);
        arrayList0.add(poolChunkList2);
        arrayList0.add(poolChunkList1);
        arrayList0.add(poolChunkList0);
        this.chunkListMetrics = Collections.unmodifiableList(arrayList0);
    }

    private void allocate(PoolThreadCache poolThreadCache0, PooledByteBuf pooledByteBuf0, int v) {
        int v1 = this.sizeClass.size2SizeIdx(v);
        SizeClasses sizeClasses0 = this.sizeClass;
        if(v1 <= sizeClasses0.smallMaxSizeIdx) {
            this.tcacheAllocateSmall(poolThreadCache0, pooledByteBuf0, v, v1);
            return;
        }
        if(v1 < sizeClasses0.nSizes) {
            this.tcacheAllocateNormal(poolThreadCache0, pooledByteBuf0, v, v1);
            return;
        }
        if(sizeClasses0.directMemoryCacheAlignment > 0) {
            v = sizeClasses0.normalizeSize(v);
        }
        this.allocateHuge(pooledByteBuf0, v);
    }

    public PooledByteBuf allocate(PoolThreadCache poolThreadCache0, int v, int v1) {
        PooledByteBuf pooledByteBuf0 = this.newByteBuf(v1);
        this.allocate(poolThreadCache0, pooledByteBuf0, v);
        return pooledByteBuf0;
    }

    private void allocateHuge(PooledByteBuf pooledByteBuf0, int v) {
        PoolChunk poolChunk0 = this.newUnpooledChunk(v);
        this.activeBytesHuge.add(((long)poolChunk0.chunkSize()));
        pooledByteBuf0.initUnpooled(poolChunk0, v);
        this.allocationsHuge.increment();
    }

    private void allocateNormal(PooledByteBuf pooledByteBuf0, int v, int v1, PoolThreadCache poolThreadCache0) {
        if(!this.q050.allocate(pooledByteBuf0, v, v1, poolThreadCache0) && !this.q025.allocate(pooledByteBuf0, v, v1, poolThreadCache0) && !this.q000.allocate(pooledByteBuf0, v, v1, poolThreadCache0) && !this.qInit.allocate(pooledByteBuf0, v, v1, poolThreadCache0) && !this.q075.allocate(pooledByteBuf0, v, v1, poolThreadCache0)) {
            PoolChunk poolChunk0 = this.newChunk(this.sizeClass.pageSize, this.sizeClass.nPSizes, this.sizeClass.pageShifts, this.sizeClass.chunkSize);
            poolChunk0.allocate(pooledByteBuf0, v, v1, poolThreadCache0);
            this.qInit.add(poolChunk0);
        }
    }

    private static void appendPoolSubPages(StringBuilder stringBuilder0, PoolSubpage[] arr_poolSubpage) {
        for(int v = 0; v < arr_poolSubpage.length; ++v) {
            PoolSubpage poolSubpage0 = arr_poolSubpage[v];
            if(poolSubpage0.next != poolSubpage0 && poolSubpage0.next != null) {
                stringBuilder0.append("\n");
                stringBuilder0.append(v);
                stringBuilder0.append(": ");
                for(PoolSubpage poolSubpage1 = poolSubpage0.next; poolSubpage1 != null; poolSubpage1 = poolSubpage2) {
                    stringBuilder0.append(poolSubpage1);
                    PoolSubpage poolSubpage2 = poolSubpage1.next;
                    if(poolSubpage2 == poolSubpage0) {
                        break;
                    }
                }
            }
        }
    }

    @Override  // io.netty.buffer.PoolArenaMetric
    public List chunkLists() {
        return this.chunkListMetrics;
    }

    public abstract void destroyChunk(PoolChunk arg1);

    private void destroyPoolChunkLists(PoolChunkList[] arr_poolChunkList) {
        for(int v = 0; v < arr_poolChunkList.length; ++v) {
            arr_poolChunkList[v].destroy(this);
        }
    }

    private static void destroyPoolSubPages(PoolSubpage[] arr_poolSubpage) {
        for(int v = 0; v < arr_poolSubpage.length; ++v) {
            arr_poolSubpage[v].destroy();
        }
    }

    @Override
    public final void finalize() {
        try {
            super.finalize();
        }
        finally {
            PoolArena.destroyPoolSubPages(this.smallSubpagePools);
            this.destroyPoolChunkLists(new PoolChunkList[]{this.qInit, this.q000, this.q025, this.q050, this.q075, this.q100});
        }
    }

    public void free(PoolChunk poolChunk0, ByteBuffer byteBuffer0, long v, int v1, PoolThreadCache poolThreadCache0) {
        poolChunk0.decrementPinnedMemory(v1);
        if(poolChunk0.unpooled) {
            this.destroyChunk(poolChunk0);
            this.activeBytesHuge.add(((long)(-poolChunk0.chunkSize())));
            this.deallocationsHuge.increment();
            return;
        }
        SizeClass poolArena$SizeClass0 = PoolArena.sizeClass(v);
        if(poolThreadCache0 != null && poolThreadCache0.add(this, poolChunk0, byteBuffer0, v, v1, poolArena$SizeClass0)) {
            return;
        }
        this.freeChunk(poolChunk0, v, v1, poolArena$SizeClass0, byteBuffer0, false);
    }

    public void freeChunk(PoolChunk poolChunk0, long v, int v1, SizeClass poolArena$SizeClass0, ByteBuffer byteBuffer0, boolean z) {
        this.lock();
        try {
            if(!z) {
                switch(io.netty.buffer.PoolArena.1.$SwitchMap$io$netty$buffer$PoolArena$SizeClass[poolArena$SizeClass0.ordinal()]) {
                    case 1: {
                        ++this.deallocationsNormal;
                        break;
                    }
                    case 2: {
                        ++this.deallocationsSmall;
                        break;
                    }
                    default: {
                        throw new Error();
                    }
                }
            }
            boolean z1 = poolChunk0.parent.free(poolChunk0, v, v1, byteBuffer0);
        }
        finally {
            this.unlock();
        }
        if(!z1) {
            this.destroyChunk(poolChunk0);
        }
    }

    private void incSmallAllocation() {
        this.allocationsSmall.increment();
    }

    public abstract boolean isDirect();

    public void lock() {
        this.lock.lock();
    }

    public abstract void memoryCopy(Object arg1, int arg2, PooledByteBuf arg3, int arg4);

    public abstract PooledByteBuf newByteBuf(int arg1);

    public abstract PoolChunk newChunk(int arg1, int arg2, int arg3, int arg4);

    private PoolSubpage[] newSubpagePoolArray(int v) {
        return new PoolSubpage[v];
    }

    private PoolSubpage newSubpagePoolHead(int v) {
        PoolSubpage poolSubpage0 = new PoolSubpage(v);
        poolSubpage0.prev = poolSubpage0;
        poolSubpage0.next = poolSubpage0;
        return poolSubpage0;
    }

    public abstract PoolChunk newUnpooledChunk(int arg1);

    @Override  // io.netty.buffer.SizeClassesMetric
    public int normalizeSize(int v) {
        return this.sizeClass.normalizeSize(v);
    }

    @Override  // io.netty.buffer.PoolArenaMetric
    public long numActiveAllocations() {
        long v = this.allocationsSmall.value();
        long v1 = this.allocationsHuge.value();
        long v2 = this.deallocationsHuge.value();
        this.lock();
        long v3 = this.allocationsNormal - (this.deallocationsSmall + this.deallocationsNormal) + (v1 + v - v2);
        this.unlock();
        return Math.max(v3, 0L);
    }

    @Override  // io.netty.buffer.PoolArenaMetric
    public long numActiveBytes() {
        long v = this.activeBytesHuge.value();
        this.lock();
        try {
            for(int v1 = 0; v1 < this.chunkListMetrics.size(); ++v1) {
                for(Object object0: ((PoolChunkListMetric)this.chunkListMetrics.get(v1))) {
                    v += (long)((PoolChunkMetric)object0).chunkSize();
                }
            }
        }
        finally {
            this.unlock();
        }
        return Math.max(0L, v);
    }

    @Override  // io.netty.buffer.PoolArenaMetric
    public long numActiveHugeAllocations() {
        return Math.max(this.numHugeAllocations() - this.numHugeDeallocations(), 0L);
    }

    @Override  // io.netty.buffer.PoolArenaMetric
    public long numActiveNormalAllocations() {
        this.lock();
        long v = this.allocationsNormal - this.deallocationsNormal;
        this.unlock();
        return Math.max(v, 0L);
    }

    @Override  // io.netty.buffer.PoolArenaMetric
    public long numActiveSmallAllocations() {
        return Math.max(this.numSmallAllocations() - this.numSmallDeallocations(), 0L);
    }

    @Override  // io.netty.buffer.PoolArenaMetric
    public long numActiveTinyAllocations() {
        return 0L;
    }

    @Override  // io.netty.buffer.PoolArenaMetric
    public long numAllocations() {
        this.lock();
        long v = this.allocationsNormal;
        this.unlock();
        long v1 = this.allocationsSmall.value();
        return this.allocationsHuge.value() + (v1 + v);
    }

    @Override  // io.netty.buffer.PoolArenaMetric
    public int numChunkLists() {
        return this.chunkListMetrics.size();
    }

    @Override  // io.netty.buffer.PoolArenaMetric
    public long numDeallocations() {
        this.lock();
        long v = this.deallocationsSmall + this.deallocationsNormal;
        this.unlock();
        return this.deallocationsHuge.value() + v;
    }

    @Override  // io.netty.buffer.PoolArenaMetric
    public long numHugeAllocations() {
        return this.allocationsHuge.value();
    }

    @Override  // io.netty.buffer.PoolArenaMetric
    public long numHugeDeallocations() {
        return this.deallocationsHuge.value();
    }

    @Override  // io.netty.buffer.PoolArenaMetric
    public long numNormalAllocations() {
        this.lock();
        long v = this.allocationsNormal;
        this.unlock();
        return v;
    }

    @Override  // io.netty.buffer.PoolArenaMetric
    public long numNormalDeallocations() {
        this.lock();
        long v = this.deallocationsNormal;
        this.unlock();
        return v;
    }

    public long numPinnedBytes() {
        long v = this.activeBytesHuge.value();
        this.lock();
        try {
            for(int v1 = 0; v1 < this.chunkListMetrics.size(); ++v1) {
                for(Object object0: ((PoolChunkListMetric)this.chunkListMetrics.get(v1))) {
                    v += (long)((PoolChunk)(((PoolChunkMetric)object0))).pinnedBytes();
                }
            }
        }
        finally {
            this.unlock();
        }
        return Math.max(0L, v);
    }

    @Override  // io.netty.buffer.PoolArenaMetric
    public long numSmallAllocations() {
        return this.allocationsSmall.value();
    }

    @Override  // io.netty.buffer.PoolArenaMetric
    public long numSmallDeallocations() {
        this.lock();
        long v = this.deallocationsSmall;
        this.unlock();
        return v;
    }

    @Override  // io.netty.buffer.PoolArenaMetric
    public int numSmallSubpages() {
        return this.smallSubpagePools.length;
    }

    @Override  // io.netty.buffer.PoolArenaMetric
    public int numThreadCaches() {
        return this.numThreadCaches.get();
    }

    @Override  // io.netty.buffer.PoolArenaMetric
    public long numTinyAllocations() {
        return 0L;
    }

    @Override  // io.netty.buffer.PoolArenaMetric
    public long numTinyDeallocations() {
        return 0L;
    }

    @Override  // io.netty.buffer.PoolArenaMetric
    public int numTinySubpages() {
        return 0;
    }

    @Override  // io.netty.buffer.SizeClassesMetric
    public long pageIdx2size(int v) {
        return this.sizeClass.pageIdx2size(v);
    }

    @Override  // io.netty.buffer.SizeClassesMetric
    public long pageIdx2sizeCompute(int v) {
        return this.sizeClass.pageIdx2sizeCompute(v);
    }

    @Override  // io.netty.buffer.SizeClassesMetric
    public int pages2pageIdx(int v) {
        return this.sizeClass.pages2pageIdx(v);
    }

    @Override  // io.netty.buffer.SizeClassesMetric
    public int pages2pageIdxFloor(int v) {
        return this.sizeClass.pages2pageIdxFloor(v);
    }

    public void reallocate(PooledByteBuf pooledByteBuf0, int v) {
        PoolThreadCache poolThreadCache0;
        int v4;
        int v3;
        Object object0;
        long v2;
        ByteBuffer byteBuffer0;
        PoolChunk poolChunk0;
        int v1;
        synchronized(pooledByteBuf0) {
            v1 = pooledByteBuf0.length;
            if(v1 != v) {
                poolChunk0 = pooledByteBuf0.chunk;
                byteBuffer0 = pooledByteBuf0.tmpNioBuf;
                v2 = pooledByteBuf0.handle;
                object0 = pooledByteBuf0.memory;
                v3 = pooledByteBuf0.maxLength;
                v4 = pooledByteBuf0.offset;
                poolThreadCache0 = pooledByteBuf0.cache;
                this.allocate(this.parent.threadCache(), pooledByteBuf0, v);
                goto label_15;
            }
            return;
        }
    label_15:
        if(v > v1) {
            v = v1;
        }
        else {
            pooledByteBuf0.trimIndicesToCapacity(v);
        }
        this.memoryCopy(object0, v4, pooledByteBuf0, v);
        this.free(poolChunk0, byteBuffer0, v2, v3, poolThreadCache0);
    }

    @Override  // io.netty.buffer.SizeClassesMetric
    public int size2SizeIdx(int v) {
        return this.sizeClass.size2SizeIdx(v);
    }

    // 去混淆评级： 低(20)
    private static SizeClass sizeClass(long v) {
        return PoolChunk.isSubpage(v) ? SizeClass.Small : SizeClass.Normal;
    }

    @Override  // io.netty.buffer.SizeClassesMetric
    public int sizeIdx2size(int v) {
        return this.sizeClass.sizeIdx2size(v);
    }

    @Override  // io.netty.buffer.SizeClassesMetric
    public int sizeIdx2sizeCompute(int v) {
        return this.sizeClass.sizeIdx2sizeCompute(v);
    }

    @Override  // io.netty.buffer.PoolArenaMetric
    public List smallSubpages() {
        return PoolArena.subPageMetricList(this.smallSubpagePools);
    }

    private static List subPageMetricList(PoolSubpage[] arr_poolSubpage) {
        List list0 = new ArrayList();
        for(int v = 0; v < arr_poolSubpage.length; ++v) {
            PoolSubpage poolSubpage0 = arr_poolSubpage[v];
            PoolSubpage poolSubpage1 = poolSubpage0.next;
            if(poolSubpage1 != poolSubpage0) {
                while(true) {
                    ((ArrayList)list0).add(poolSubpage1);
                    poolSubpage1 = poolSubpage1.next;
                    if(poolSubpage1 == poolSubpage0) {
                        break;
                    }
                }
            }
        }
        return list0;
    }

    private void tcacheAllocateNormal(PoolThreadCache poolThreadCache0, PooledByteBuf pooledByteBuf0, int v, int v1) {
        if(poolThreadCache0.allocateNormal(this, pooledByteBuf0, v, v1)) {
            return;
        }
        this.lock();
        try {
            this.allocateNormal(pooledByteBuf0, v, v1, poolThreadCache0);
            ++this.allocationsNormal;
        }
        finally {
            this.unlock();
        }
    }

    private void tcacheAllocateSmall(PoolThreadCache poolThreadCache0, PooledByteBuf pooledByteBuf0, int v, int v1) {
        if(poolThreadCache0.allocateSmall(this, pooledByteBuf0, v, v1)) {
            return;
        }
        PoolSubpage poolSubpage0 = this.smallSubpagePools[v1];
        poolSubpage0.lock();
        try {
            PoolSubpage poolSubpage1 = poolSubpage0.next;
            boolean z = poolSubpage1 == poolSubpage0;
            if(!z) {
                long v3 = poolSubpage1.allocate();
                poolSubpage1.chunk.initBufWithSubpage(pooledByteBuf0, null, v3, v, poolThreadCache0);
            }
        }
        finally {
            poolSubpage0.unlock();
        }
        if(z) {
            this.lock();
            try {
                this.allocateNormal(pooledByteBuf0, v, v1, poolThreadCache0);
            }
            finally {
                this.unlock();
            }
        }
        this.incSmallAllocation();
    }

    @Override  // io.netty.buffer.PoolArenaMetric
    public List tinySubpages() {
        return Collections.EMPTY_LIST;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder0;
        this.lock();
        try {
            stringBuilder0 = new StringBuilder();
            stringBuilder0.append("Chunk(s) at 0~25%:");
            stringBuilder0.append("\n");
            stringBuilder0.append(this.qInit);
            stringBuilder0.append("\n");
            stringBuilder0.append("Chunk(s) at 0~50%:");
            stringBuilder0.append("\n");
            stringBuilder0.append(this.q000);
            stringBuilder0.append("\n");
            stringBuilder0.append("Chunk(s) at 25~75%:");
            stringBuilder0.append("\n");
            stringBuilder0.append(this.q025);
            stringBuilder0.append("\n");
            stringBuilder0.append("Chunk(s) at 50~100%:");
            stringBuilder0.append("\n");
            stringBuilder0.append(this.q050);
            stringBuilder0.append("\n");
            stringBuilder0.append("Chunk(s) at 75~100%:");
            stringBuilder0.append("\n");
            stringBuilder0.append(this.q075);
            stringBuilder0.append("\n");
            stringBuilder0.append("Chunk(s) at 100%:");
            stringBuilder0.append("\n");
            stringBuilder0.append(this.q100);
            stringBuilder0.append("\n");
            stringBuilder0.append("small subpages:");
            PoolArena.appendPoolSubPages(stringBuilder0, this.smallSubpagePools);
            stringBuilder0.append("\n");
        }
        finally {
            this.unlock();
        }
        return stringBuilder0.toString();
    }

    public void unlock() {
        this.lock.unlock();
    }

    class io.netty.buffer.PoolArena.1 {
        static final int[] $SwitchMap$io$netty$buffer$PoolArena$SizeClass;

        static {
            int[] arr_v = new int[SizeClass.values().length];
            io.netty.buffer.PoolArena.1.$SwitchMap$io$netty$buffer$PoolArena$SizeClass = arr_v;
            try {
                arr_v[SizeClass.Normal.ordinal()] = 1;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                io.netty.buffer.PoolArena.1.$SwitchMap$io$netty$buffer$PoolArena$SizeClass[SizeClass.Small.ordinal()] = 2;
            }
            catch(NoSuchFieldError unused_ex) {
            }
        }
    }

}

