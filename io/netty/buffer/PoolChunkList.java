package io.netty.buffer;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

final class PoolChunkList implements PoolChunkListMetric {
    static final boolean $assertionsDisabled;
    private static final Iterator EMPTY_METRICS;
    private final PoolArena arena;
    private final int freeMaxThreshold;
    private final int freeMinThreshold;
    private PoolChunk head;
    private final int maxCapacity;
    private final int maxUsage;
    private final int minUsage;
    private final PoolChunkList nextList;
    private PoolChunkList prevList;

    static {
        PoolChunkList.EMPTY_METRICS = Collections.EMPTY_LIST.iterator();
    }

    public PoolChunkList(PoolArena poolArena0, PoolChunkList poolChunkList0, int v, int v1, int v2) {
        this.arena = poolArena0;
        this.nextList = poolChunkList0;
        this.minUsage = v;
        this.maxUsage = v1;
        this.maxCapacity = PoolChunkList.calculateMaxCapacity(v, v2);
        int v3 = 0;
        this.freeMinThreshold = v1 == 100 ? 0 : ((int)((100.0 - ((double)v1) + 1.0) * ((double)v2) / 100.0));
        if(v != 100) {
            v3 = (int)((100.0 - ((double)v) + 1.0) * ((double)v2) / 100.0);
        }
        this.freeMaxThreshold = v3;
    }

    public void add(PoolChunk poolChunk0) {
        if(poolChunk0.freeBytes <= this.freeMinThreshold) {
            this.nextList.add(poolChunk0);
            return;
        }
        this.add0(poolChunk0);
    }

    public void add0(PoolChunk poolChunk0) {
        poolChunk0.parent = this;
        PoolChunk poolChunk1 = this.head;
        if(poolChunk1 == null) {
            this.head = poolChunk0;
            poolChunk0.prev = null;
            poolChunk0.next = null;
            return;
        }
        poolChunk0.prev = null;
        poolChunk0.next = poolChunk1;
        poolChunk1.prev = poolChunk0;
        this.head = poolChunk0;
    }

    public boolean allocate(PooledByteBuf pooledByteBuf0, int v, int v1, PoolThreadCache poolThreadCache0) {
        if(this.arena.sizeClass.sizeIdx2size(v1) > this.maxCapacity) {
            return false;
        }
        for(PoolChunk poolChunk0 = this.head; poolChunk0 != null; poolChunk0 = poolChunk0.next) {
            if(poolChunk0.allocate(pooledByteBuf0, v, v1, poolThreadCache0)) {
                if(poolChunk0.freeBytes <= this.freeMinThreshold) {
                    this.remove(poolChunk0);
                    this.nextList.add(poolChunk0);
                }
                return true;
            }
        }
        return false;
    }

    private static int calculateMaxCapacity(int v, int v1) {
        int v2 = PoolChunkList.minUsage0(v);
        return v2 == 100 ? 0 : ((int)((100L - ((long)v2)) * ((long)v1) / 100L));
    }

    public void destroy(PoolArena poolArena0) {
        for(PoolChunk poolChunk0 = this.head; poolChunk0 != null; poolChunk0 = poolChunk0.next) {
            poolArena0.destroyChunk(poolChunk0);
        }
        this.head = null;
    }

    public boolean free(PoolChunk poolChunk0, long v, int v1, ByteBuffer byteBuffer0) {
        poolChunk0.free(v, v1, byteBuffer0);
        if(poolChunk0.freeBytes > this.freeMaxThreshold) {
            this.remove(poolChunk0);
            return this.move0(poolChunk0);
        }
        return true;
    }

    @Override
    public Iterator iterator() {
        Iterator iterator0;
        this.arena.lock();
        try {
            if(this.head == null) {
                iterator0 = PoolChunkList.EMPTY_METRICS;
            }
            else {
                ArrayList arrayList0 = new ArrayList();
                PoolChunk poolChunk0 = this.head;
                do {
                    arrayList0.add(poolChunk0);
                    poolChunk0 = poolChunk0.next;
                }
                while(poolChunk0 != null);
                iterator0 = arrayList0.iterator();
            }
            return iterator0;
        }
        finally {
            this.arena.unlock();
        }
    }

    @Override  // io.netty.buffer.PoolChunkListMetric
    public int maxUsage() {
        return Math.min(this.maxUsage, 100);
    }

    @Override  // io.netty.buffer.PoolChunkListMetric
    public int minUsage() {
        return PoolChunkList.minUsage0(this.minUsage);
    }

    private static int minUsage0(int v) {
        return Math.max(1, v);
    }

    private boolean move(PoolChunk poolChunk0) {
        if(poolChunk0.freeBytes > this.freeMaxThreshold) {
            return this.move0(poolChunk0);
        }
        this.add0(poolChunk0);
        return true;
    }

    private boolean move0(PoolChunk poolChunk0) {
        return this.prevList == null ? false : this.prevList.move(poolChunk0);
    }

    public void prevList(PoolChunkList poolChunkList0) {
        this.prevList = poolChunkList0;
    }

    private void remove(PoolChunk poolChunk0) {
        if(poolChunk0 == this.head) {
            PoolChunk poolChunk1 = poolChunk0.next;
            this.head = poolChunk1;
            if(poolChunk1 != null) {
                poolChunk1.prev = null;
            }
        }
        else {
            PoolChunk poolChunk2 = poolChunk0.next;
            PoolChunk poolChunk3 = poolChunk0.prev;
            poolChunk3.next = poolChunk2;
            if(poolChunk2 != null) {
                poolChunk2.prev = poolChunk3;
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder0 = new StringBuilder();
        this.arena.lock();
        try {
            PoolChunk poolChunk0 = this.head;
            if(poolChunk0 == null) {
                return "none";
            }
            while(true) {
                stringBuilder0.append(poolChunk0);
                poolChunk0 = poolChunk0.next;
                if(poolChunk0 == null) {
                    break;
                }
                stringBuilder0.append("\n");
            }
        }
        finally {
            this.arena.unlock();
        }
        return stringBuilder0.toString();
    }
}

