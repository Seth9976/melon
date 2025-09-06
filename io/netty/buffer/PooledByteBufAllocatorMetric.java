package io.netty.buffer;

import io.netty.util.internal.StringUtil;
import java.util.List;

public final class PooledByteBufAllocatorMetric implements ByteBufAllocatorMetric {
    private final PooledByteBufAllocator allocator;

    public PooledByteBufAllocatorMetric(PooledByteBufAllocator pooledByteBufAllocator0) {
        this.allocator = pooledByteBufAllocator0;
    }

    public int chunkSize() {
        return this.allocator.chunkSize();
    }

    public List directArenas() {
        return this.allocator.directArenas();
    }

    public List heapArenas() {
        return this.allocator.heapArenas();
    }

    public int normalCacheSize() {
        return this.allocator.normalCacheSize();
    }

    public int numDirectArenas() {
        return this.allocator.numDirectArenas();
    }

    public int numHeapArenas() {
        return this.allocator.numHeapArenas();
    }

    public int numThreadLocalCaches() {
        return this.allocator.numThreadLocalCaches();
    }

    public int smallCacheSize() {
        return this.allocator.smallCacheSize();
    }

    @Deprecated
    public int tinyCacheSize() {
        return 0;
    }

    @Override
    public String toString() {
        return StringUtil.simpleClassName(this) + "(usedHeapMemory: " + this.usedHeapMemory() + "; usedDirectMemory: " + this.usedDirectMemory() + "; numHeapArenas: " + this.numHeapArenas() + "; numDirectArenas: " + this.numDirectArenas() + "; smallCacheSize: " + this.smallCacheSize() + "; normalCacheSize: " + this.normalCacheSize() + "; numThreadLocalCaches: " + this.numThreadLocalCaches() + "; chunkSize: " + this.chunkSize() + ')';
    }

    @Override  // io.netty.buffer.ByteBufAllocatorMetric
    public long usedDirectMemory() {
        return this.allocator.usedDirectMemory();
    }

    @Override  // io.netty.buffer.ByteBufAllocatorMetric
    public long usedHeapMemory() {
        return this.allocator.usedHeapMemory();
    }
}

