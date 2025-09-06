package io.netty.buffer;

import androidx.appcompat.app.o;
import io.netty.util.internal.LongCounter;
import io.netty.util.internal.PlatformDependent;
import java.nio.ByteBuffer;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.locks.ReentrantLock;

final class PoolChunk implements PoolChunkMetric {
    static final boolean $assertionsDisabled = false;
    private static final int BITMAP_IDX_BIT_LENGTH = 0x20;
    private static final int INUSED_BIT_LENGTH = 1;
    static final int IS_SUBPAGE_SHIFT = 0x20;
    static final int IS_USED_SHIFT = 33;
    static final int RUN_OFFSET_SHIFT = 49;
    private static final int SIZE_BIT_LENGTH = 15;
    static final int SIZE_SHIFT = 34;
    private static final int SUBPAGE_BIT_LENGTH = 1;
    final PoolArena arena;
    final Object base;
    private final Deque cachedNioBuffers;
    private final int chunkSize;
    int freeBytes;
    final Object memory;
    PoolChunk next;
    private final int pageShifts;
    private final int pageSize;
    PoolChunkList parent;
    private final LongCounter pinnedBytes;
    PoolChunk prev;
    private final IntPriorityQueue[] runsAvail;
    private final ReentrantLock runsAvailLock;
    private final LongLongHashMap runsAvailMap;
    private final PoolSubpage[] subpages;
    final boolean unpooled;

    public PoolChunk(PoolArena poolArena0, Object object0, Object object1, int v) {
        this.pinnedBytes = PlatformDependent.newLongCounter();
        this.unpooled = true;
        this.arena = poolArena0;
        this.base = object0;
        this.memory = object1;
        this.pageSize = 0;
        this.pageShifts = 0;
        this.runsAvailMap = null;
        this.runsAvail = null;
        this.runsAvailLock = null;
        this.subpages = null;
        this.chunkSize = v;
        this.cachedNioBuffers = null;
    }

    public PoolChunk(PoolArena poolArena0, Object object0, Object object1, int v, int v1, int v2, int v3) {
        this.pinnedBytes = PlatformDependent.newLongCounter();
        this.unpooled = false;
        this.arena = poolArena0;
        this.base = object0;
        this.memory = object1;
        this.pageSize = v;
        this.pageShifts = v1;
        this.chunkSize = v2;
        this.freeBytes = v2;
        this.runsAvail = PoolChunk.newRunsAvailqueueArray(v3);
        this.runsAvailLock = new ReentrantLock();
        this.runsAvailMap = new LongLongHashMap(-1L);
        int v4 = v2 >> v1;
        this.subpages = new PoolSubpage[v4];
        this.insertAvailRun(0, v4, ((long)v4) << 34);
        this.cachedNioBuffers = new ArrayDeque(8);
    }

    public boolean allocate(PooledByteBuf pooledByteBuf0, int v, int v1, PoolThreadCache poolThreadCache0) {
        long v4;
        PoolArena poolArena0 = this.arena;
        SizeClasses sizeClasses0 = poolArena0.sizeClass;
        if(v1 <= sizeClasses0.smallMaxSizeIdx) {
            PoolSubpage poolSubpage0 = poolArena0.smallSubpagePools[v1];
            poolSubpage0.lock();
            try {
                PoolSubpage poolSubpage1 = poolSubpage0.next;
                if(poolSubpage1 != poolSubpage0) {
                    long v3 = poolSubpage1.allocate();
                    poolSubpage1.chunk.initBufWithSubpage(pooledByteBuf0, null, v3, v, poolThreadCache0);
                    return true;
                }
                v4 = this.allocateSubpage(v1, poolSubpage0);
                if(v4 < 0L) {
                    return false;
                }
            }
            finally {
                poolSubpage0.unlock();
            }
        }
        else {
            v4 = this.allocateRun(sizeClasses0.sizeIdx2size(v1));
            if(v4 < 0L) {
                return false;
            }
        }
        this.initBuf(pooledByteBuf0, (this.cachedNioBuffers == null ? null : ((ByteBuffer)this.cachedNioBuffers.pollLast())), v4, v, poolThreadCache0);
        return true;
    }

    private long allocateRun(int v) {
        int v1 = v >> this.pageShifts;
        int v2 = this.arena.sizeClass.pages2pageIdx(v1);
        this.runsAvailLock.lock();
        try {
            int v4 = this.runFirstBestFit(v2);
            if(v4 == -1) {
                return -1L;
            }
            long v5 = ((long)this.runsAvail[v4].poll()) << 0x20;
            this.removeAvailRun0(v5);
            long v6 = this.splitLargeRun(v5, v1);
            this.freeBytes -= PoolChunk.runSize(this.pageShifts, v6);
            return v6;
        }
        finally {
            this.runsAvailLock.unlock();
        }
    }

    private long allocateSubpage(int v, PoolSubpage poolSubpage0) {
        long v1 = this.allocateRun(this.calculateRunSize(v));
        if(v1 < 0L) {
            return -1L;
        }
        int v2 = PoolChunk.runOffset(v1);
        int v3 = this.arena.sizeClass.sizeIdx2size(v);
        PoolSubpage poolSubpage1 = new PoolSubpage(poolSubpage0, this, this.pageShifts, v2, PoolChunk.runSize(this.pageShifts, v1), v3);
        this.subpages[v2] = poolSubpage1;
        return poolSubpage1.allocate();
    }

    public static int bitmapIdx(long v) {
        return (int)v;
    }

    private int calculateRunSize(int v) {
        int v4;
        int v1 = 1 << this.pageShifts - 4;
        int v2 = this.arena.sizeClass.sizeIdx2size(v);
        int v3 = 0;
        do {
            v3 += this.pageSize;
            v4 = v3 / v2;
        }
        while(v4 < v1 && v3 != v4 * v2);
        while(v4 > v1) {
            v3 -= this.pageSize;
            v4 = v3 / v2;
        }
        return v3;
    }

    @Override  // io.netty.buffer.PoolChunkMetric
    public int chunkSize() {
        return this.chunkSize;
    }

    private long collapseNext(long v) {
        while(true) {
            int v1 = PoolChunk.runOffset(v);
            int v2 = PoolChunk.runPages(v);
            int v3 = v1 + v2;
            long v4 = this.getAvailRunByOffset(v3);
            if(v4 == -1L) {
                break;
            }
            int v5 = PoolChunk.runPages(v4);
            if(v4 == v || v3 != PoolChunk.runOffset(v4)) {
                break;
            }
            this.removeAvailRun(v4);
            v = ((long)(v2 + v5)) << 34 | ((long)v1) << 49;
        }
        return v;
    }

    private long collapsePast(long v) {
        while(true) {
            int v1 = PoolChunk.runOffset(v);
            int v2 = PoolChunk.runPages(v);
            long v3 = this.getAvailRunByOffset(v1 - 1);
            if(v3 == -1L) {
                break;
            }
            int v4 = PoolChunk.runOffset(v3);
            int v5 = PoolChunk.runPages(v3);
            if(v3 == v || v4 + v5 != v1) {
                break;
            }
            this.removeAvailRun(v3);
            v = ((long)(v5 + v2)) << 34 | ((long)v4) << 49;
        }
        return v;
    }

    private long collapseRuns(long v) {
        return this.collapseNext(this.collapsePast(v));
    }

    public void decrementPinnedMemory(int v) {
        this.pinnedBytes.add(((long)(-v)));
    }

    public void destroy() {
        this.arena.destroyChunk(this);
    }

    public void free(long v, int v1, ByteBuffer byteBuffer0) {
        if(PoolChunk.isSubpage(v)) {
            int v2 = PoolChunk.runOffset(v);
            PoolSubpage poolSubpage0 = this.subpages[v2];
            PoolSubpage poolSubpage1 = poolSubpage0.chunk.arena.smallSubpagePools[poolSubpage0.headIndex];
            poolSubpage1.lock();
            try {
                if(poolSubpage0.free(poolSubpage1, PoolChunk.bitmapIdx(v))) {
                    return;
                }
                this.subpages[v2] = null;
            }
            finally {
                poolSubpage1.unlock();
            }
        }
        this.runsAvailLock.lock();
        try {
            long v5 = this.collapseRuns(v);
            this.insertAvailRun(PoolChunk.runOffset(v5 & 0xFFFFFFFCFFFFFFFFL), PoolChunk.runPages(v5 & 0xFFFFFFFCFFFFFFFFL), v5 & 0xFFFFFFFCFFFFFFFFL);
            this.freeBytes += PoolChunk.runSize(this.pageShifts, v);
        }
        finally {
            this.runsAvailLock.unlock();
        }
        if(byteBuffer0 != null && (this.cachedNioBuffers != null && this.cachedNioBuffers.size() < PooledByteBufAllocator.DEFAULT_MAX_CACHED_BYTEBUFFERS_PER_CHUNK)) {
            this.cachedNioBuffers.offer(byteBuffer0);
        }
    }

    @Override  // io.netty.buffer.PoolChunkMetric
    public int freeBytes() {
        if(this.unpooled) {
            return this.freeBytes;
        }
        this.runsAvailLock.lock();
        int v = this.freeBytes;
        this.runsAvailLock.unlock();
        return v;
    }

    private long getAvailRunByOffset(int v) {
        return this.runsAvailMap.get(((long)v));
    }

    public void incrementPinnedMemory(int v) {
        this.pinnedBytes.add(((long)v));
    }

    public void initBuf(PooledByteBuf pooledByteBuf0, ByteBuffer byteBuffer0, long v, int v1, PoolThreadCache poolThreadCache0) {
        if(PoolChunk.isSubpage(v)) {
            this.initBufWithSubpage(pooledByteBuf0, byteBuffer0, v, v1, poolThreadCache0);
            return;
        }
        PoolThreadCache poolThreadCache1 = this.arena.parent.threadCache();
        pooledByteBuf0.init(this, byteBuffer0, v, PoolChunk.runOffset(v) << this.pageShifts, v1, PoolChunk.runSize(this.pageShifts, v), poolThreadCache1);
    }

    public void initBufWithSubpage(PooledByteBuf pooledByteBuf0, ByteBuffer byteBuffer0, long v, int v1, PoolThreadCache poolThreadCache0) {
        int v2 = PoolChunk.runOffset(v);
        int v3 = this.subpages[v2].elemSize;
        pooledByteBuf0.init(this, byteBuffer0, v, PoolChunk.bitmapIdx(v) * v3 + (v2 << this.pageShifts), v1, v3, poolThreadCache0);
    }

    private void insertAvailRun(int v, int v1, long v2) {
        this.runsAvail[this.arena.sizeClass.pages2pageIdxFloor(v1)].offer(((int)(v2 >> 0x20)));
        this.insertAvailRun0(v, v2);
        if(v1 > 1) {
            this.insertAvailRun0(v + v1 - 1, v2);
        }
    }

    private void insertAvailRun0(int v, long v1) {
        this.runsAvailMap.put(((long)v), v1);
    }

    public static boolean isRun(long v) {
        return !PoolChunk.isSubpage(v);
    }

    public static boolean isSubpage(long v) {
        return (v >> 0x20 & 1L) == 1L;
    }

    public static boolean isUsed(long v) {
        return (v >> 33 & 1L) == 1L;
    }

    private static int lastPage(int v, int v1) [...] // Inlined contents

    private static IntPriorityQueue[] newRunsAvailqueueArray(int v) {
        IntPriorityQueue[] arr_intPriorityQueue = new IntPriorityQueue[v];
        for(int v1 = 0; v1 < v; ++v1) {
            arr_intPriorityQueue[v1] = new IntPriorityQueue();
        }
        return arr_intPriorityQueue;
    }

    public int pinnedBytes() {
        return (int)this.pinnedBytes.value();
    }

    private void removeAvailRun(long v) {
        this.runsAvail[this.arena.sizeClass.pages2pageIdxFloor(PoolChunk.runPages(v))].remove(((int)(v >> 0x20)));
        this.removeAvailRun0(v);
    }

    private void removeAvailRun0(long v) {
        int v1 = PoolChunk.runOffset(v);
        int v2 = PoolChunk.runPages(v);
        this.runsAvailMap.remove(((long)v1));
        if(v2 > 1) {
            this.runsAvailMap.remove(((long)(v1 + v2 - 1)));
        }
    }

    private int runFirstBestFit(int v) {
        if(this.freeBytes == this.chunkSize) {
            return this.arena.sizeClass.nPSizes - 1;
        }
        while(v < this.arena.sizeClass.nPSizes) {
            IntPriorityQueue intPriorityQueue0 = this.runsAvail[v];
            if(intPriorityQueue0 != null && !intPriorityQueue0.isEmpty()) {
                return v;
            }
            ++v;
        }
        return -1;
    }

    public static int runOffset(long v) {
        return (int)(v >> 49);
    }

    public static int runPages(long v) {
        return (int)(v >> 34 & 0x7FFFL);
    }

    public static int runSize(int v, long v1) {
        return PoolChunk.runPages(v1) << v;
    }

    private long splitLargeRun(long v, int v1) {
        int v2 = PoolChunk.runPages(v) - v1;
        if(v2 > 0) {
            int v3 = PoolChunk.runOffset(v);
            this.insertAvailRun(v3 + v1, v2, ((long)v2) << 34 | ((long)(v3 + v1)) << 49);
            return ((long)v1) << 34 | ((long)v3) << 49 | 0x200000000L;
        }
        return v | 0x200000000L;
    }

    private static long toRunHandle(int v, int v1, int v2) [...] // Inlined contents

    @Override
    public String toString() {
        int v;
        if(this.unpooled) {
            v = this.freeBytes;
        }
        else {
            this.runsAvailLock.lock();
            v = this.freeBytes;
            this.runsAvailLock.unlock();
        }
        StringBuilder stringBuilder0 = new StringBuilder("Chunk(");
        stringBuilder0.append(Integer.toHexString(System.identityHashCode(this)));
        stringBuilder0.append(": ");
        stringBuilder0.append(this.usage(v));
        stringBuilder0.append("%, ");
        stringBuilder0.append(this.chunkSize - v);
        stringBuilder0.append('/');
        return o.q(stringBuilder0, this.chunkSize, ')');
    }

    private int usage(int v) {
        if(v == 0) {
            return 100;
        }
        int v1 = (int)(((long)v) * 100L / ((long)this.chunkSize));
        return v1 == 0 ? 99 : 100 - v1;
    }

    @Override  // io.netty.buffer.PoolChunkMetric
    public int usage() {
        if(this.unpooled) {
            return this.usage(this.freeBytes);
        }
        this.runsAvailLock.lock();
        int v = this.freeBytes;
        this.runsAvailLock.unlock();
        return this.usage(v);
    }
}

