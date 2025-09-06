package io.netty.buffer;

import U4.x;
import androidx.appcompat.app.o;
import java.util.concurrent.locks.ReentrantLock;

final class PoolSubpage implements PoolSubpageMetric {
    static final boolean $assertionsDisabled;
    private final long[] bitmap;
    private final int bitmapLength;
    final PoolChunk chunk;
    boolean doNotDestroy;
    final int elemSize;
    final int headIndex;
    final ReentrantLock lock;
    private final int maxNumElems;
    PoolSubpage next;
    private int nextAvail;
    private int numAvail;
    private final int pageShifts;
    PoolSubpage prev;
    private final int runOffset;
    private final int runSize;

    public PoolSubpage(int v) {
        this.chunk = null;
        this.lock = new ReentrantLock();
        this.pageShifts = -1;
        this.runOffset = -1;
        this.elemSize = -1;
        this.runSize = -1;
        this.bitmap = null;
        this.bitmapLength = -1;
        this.maxNumElems = 0;
        this.headIndex = v;
    }

    public PoolSubpage(PoolSubpage poolSubpage0, PoolChunk poolChunk0, int v, int v1, int v2, int v3) {
        this.headIndex = poolSubpage0.headIndex;
        this.chunk = poolChunk0;
        this.pageShifts = v;
        this.runOffset = v1;
        this.runSize = v2;
        this.elemSize = v3;
        this.doNotDestroy = true;
        int v4 = v2 / v3;
        this.numAvail = v4;
        this.maxNumElems = v4;
        int v5 = (v4 & 0x3F) == 0 ? v4 >>> 6 : (v4 >>> 6) + 1;
        this.bitmapLength = v5;
        this.bitmap = new long[v5];
        this.nextAvail = 0;
        this.lock = null;
        this.addToPool(poolSubpage0);
    }

    private void addToPool(PoolSubpage poolSubpage0) {
        this.prev = poolSubpage0;
        PoolSubpage poolSubpage1 = poolSubpage0.next;
        this.next = poolSubpage1;
        poolSubpage1.prev = this;
        poolSubpage0.next = this;
    }

    public long allocate() {
        if(this.numAvail != 0 && this.doNotDestroy) {
            int v = this.getNextAvail();
            if(v >= 0) {
                this.bitmap[v >>> 6] |= 1L << (v & 0x3F);
                int v1 = this.numAvail - 1;
                this.numAvail = v1;
                if(v1 == 0) {
                    this.removeFromPool();
                }
                return this.toHandle(v);
            }
            this.removeFromPool();
            StringBuilder stringBuilder0 = x.n(v, "No next available bitmap index found (bitmapIdx = ", "), even though there are supposed to be (numAvail = ");
            stringBuilder0.append(this.numAvail);
            stringBuilder0.append(") out of (maxNumElems = ");
            throw new AssertionError(x.g(this.maxNumElems, ") available indexes.", stringBuilder0));
        }
        return -1L;
    }

    public void destroy() {
        PoolChunk poolChunk0 = this.chunk;
        if(poolChunk0 != null) {
            poolChunk0.destroy();
        }
    }

    @Override  // io.netty.buffer.PoolSubpageMetric
    public int elementSize() {
        return this.elemSize;
    }

    private int findNextAvail() {
        for(int v = 0; v < this.bitmapLength; ++v) {
            long v1 = this.bitmap[v];
            if(~v1 != 0L) {
                return this.findNextAvail0(v, v1);
            }
        }
        return -1;
    }

    private int findNextAvail0(int v, long v1) {
        for(int v2 = 0; v2 < 0x40; ++v2) {
            if((1L & v1) == 0L) {
                int v3 = v << 6 | v2;
                return v3 >= this.maxNumElems ? -1 : v3;
            }
            v1 >>>= 1;
        }
        return -1;
    }

    public boolean free(PoolSubpage poolSubpage0, int v) {
        this.bitmap[v >>> 6] ^= 1L << (v & 0x3F);
        this.setNextAvail(v);
        int v1 = this.numAvail;
        this.numAvail = v1 + 1;
        if(v1 == 0) {
            this.addToPool(poolSubpage0);
            if(this.maxNumElems > 1) {
                return true;
            }
        }
        if(this.numAvail != this.maxNumElems) {
            return true;
        }
        if(this.prev == this.next) {
            return true;
        }
        this.doNotDestroy = false;
        this.removeFromPool();
        return false;
    }

    private int getNextAvail() {
        int v = this.nextAvail;
        if(v >= 0) {
            this.nextAvail = -1;
            return v;
        }
        return this.findNextAvail();
    }

    public boolean isDoNotDestroy() {
        PoolChunk poolChunk0 = this.chunk;
        if(poolChunk0 == null) {
            return true;
        }
        PoolSubpage poolSubpage0 = poolChunk0.arena.smallSubpagePools[this.headIndex];
        poolSubpage0.lock();
        boolean z = this.doNotDestroy;
        poolSubpage0.unlock();
        return z;
    }

    public void lock() {
        this.lock.lock();
    }

    @Override  // io.netty.buffer.PoolSubpageMetric
    public int maxNumElements() {
        return this.maxNumElems;
    }

    @Override  // io.netty.buffer.PoolSubpageMetric
    public int numAvailable() {
        PoolChunk poolChunk0 = this.chunk;
        if(poolChunk0 == null) {
            return 0;
        }
        PoolSubpage poolSubpage0 = poolChunk0.arena.smallSubpagePools[this.headIndex];
        poolSubpage0.lock();
        int v = this.numAvail;
        poolSubpage0.unlock();
        return v;
    }

    @Override  // io.netty.buffer.PoolSubpageMetric
    public int pageSize() {
        return 1 << this.pageShifts;
    }

    private void removeFromPool() {
        this.prev.next = this.next;
        this.next.prev = this.prev;
        this.next = null;
        this.prev = null;
    }

    private void setNextAvail(int v) {
        this.nextAvail = v;
    }

    private long toHandle(int v) {
        return ((long)this.runOffset) << 49 | ((long)(this.runSize >> this.pageShifts)) << 34 | 0x300000000L | ((long)v);
    }

    @Override
    public String toString() {
        int v;
        PoolChunk poolChunk0 = this.chunk;
        if(poolChunk0 == null) {
            v = 0;
        }
        else {
            PoolSubpage poolSubpage0 = poolChunk0.arena.smallSubpagePools[this.headIndex];
            poolSubpage0.lock();
            boolean z = this.doNotDestroy;
            int v1 = this.numAvail;
            poolSubpage0.unlock();
            if(!z) {
                StringBuilder stringBuilder0 = new StringBuilder("(");
                return x.g(this.runOffset, ": not in use)", stringBuilder0);
            }
            v = v1;
        }
        StringBuilder stringBuilder1 = new StringBuilder("(");
        stringBuilder1.append(this.runOffset);
        stringBuilder1.append(": ");
        stringBuilder1.append(this.maxNumElems - v);
        stringBuilder1.append('/');
        stringBuilder1.append(this.maxNumElems);
        stringBuilder1.append(", offset: ");
        stringBuilder1.append(this.runOffset);
        stringBuilder1.append(", length: ");
        stringBuilder1.append(this.runSize);
        stringBuilder1.append(", elemSize: ");
        return o.q(stringBuilder1, this.elemSize, ')');
    }

    public void unlock() {
        this.lock.unlock();
    }
}

