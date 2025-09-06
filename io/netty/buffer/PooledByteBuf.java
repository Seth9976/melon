package io.netty.buffer;

import io.netty.util.Recycler.EnhancedHandle;
import io.netty.util.internal.ObjectPool.Handle;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.FileChannel;
import java.nio.channels.GatheringByteChannel;
import java.nio.channels.ScatteringByteChannel;

abstract class PooledByteBuf extends AbstractReferenceCountedByteBuf {
    static final boolean $assertionsDisabled;
    private ByteBufAllocator allocator;
    PoolThreadCache cache;
    protected PoolChunk chunk;
    protected long handle;
    protected int length;
    int maxLength;
    protected Object memory;
    protected int offset;
    private final EnhancedHandle recyclerHandle;
    ByteBuffer tmpNioBuf;

    public PooledByteBuf(Handle objectPool$Handle0, int v) {
        super(v);
        this.recyclerHandle = (EnhancedHandle)objectPool$Handle0;
    }

    public final ByteBuffer _internalNioBuffer(int v, int v1, boolean z) {
        int v2 = this.idx(v);
        ByteBuffer byteBuffer0 = z ? this.newInternalNioBuffer(this.memory) : this.internalNioBuffer();
        byteBuffer0.limit(v1 + v2).position(v2);
        return byteBuffer0;
    }

    @Override  // io.netty.buffer.ByteBuf
    public final ByteBufAllocator alloc() {
        return this.allocator;
    }

    @Override  // io.netty.buffer.ByteBuf
    public final int capacity() {
        return this.length;
    }

    @Override  // io.netty.buffer.ByteBuf
    public final ByteBuf capacity(int v) {
        if(v == this.length) {
            this.ensureAccessible();
            return this;
        }
        this.checkNewCapacity(v);
        PoolChunk poolChunk0 = this.chunk;
        if(!poolChunk0.unpooled) {
            if(v > this.length) {
                if(v <= this.maxLength) {
                    this.length = v;
                    return this;
                }
            }
            else if(v > this.maxLength >>> 1 && (this.maxLength > 0x200 || v > this.maxLength - 16)) {
                this.length = v;
                this.trimIndicesToCapacity(v);
                return this;
            }
        }
        poolChunk0.arena.reallocate(this, v);
        return this;
    }

    @Override  // io.netty.buffer.AbstractReferenceCountedByteBuf
    public final void deallocate() {
        long v = this.handle;
        if(v >= 0L) {
            this.handle = -1L;
            this.memory = null;
            this.chunk.arena.free(this.chunk, this.tmpNioBuf, v, this.maxLength, this.cache);
            this.tmpNioBuf = null;
            this.chunk = null;
            this.cache = null;
            this.recyclerHandle.unguardedRecycle(this);
        }
    }

    public ByteBuffer duplicateInternalNioBuffer(int v, int v1) {
        this.checkIndex(v, v1);
        return this._internalNioBuffer(v, v1, true);
    }

    @Override  // io.netty.buffer.ByteBuf
    public final int getBytes(int v, FileChannel fileChannel0, long v1, int v2) {
        return fileChannel0.write(this.duplicateInternalNioBuffer(v, v2), v1);
    }

    @Override  // io.netty.buffer.ByteBuf
    public final int getBytes(int v, GatheringByteChannel gatheringByteChannel0, int v1) {
        return gatheringByteChannel0.write(this.duplicateInternalNioBuffer(v, v1));
    }

    public final int idx(int v) {
        return this.offset + v;
    }

    public void init(PoolChunk poolChunk0, ByteBuffer byteBuffer0, long v, int v1, int v2, int v3, PoolThreadCache poolThreadCache0) {
        this.init0(poolChunk0, byteBuffer0, v, v1, v2, v3, poolThreadCache0);
    }

    private void init0(PoolChunk poolChunk0, ByteBuffer byteBuffer0, long v, int v1, int v2, int v3, PoolThreadCache poolThreadCache0) {
        poolChunk0.incrementPinnedMemory(v3);
        this.chunk = poolChunk0;
        this.memory = poolChunk0.memory;
        this.tmpNioBuf = byteBuffer0;
        this.allocator = poolChunk0.arena.parent;
        this.cache = poolThreadCache0;
        this.handle = v;
        this.offset = v1;
        this.length = v2;
        this.maxLength = v3;
    }

    public void initUnpooled(PoolChunk poolChunk0, int v) {
        this.init0(poolChunk0, null, 0L, 0, v, v, null);
    }

    public final ByteBuffer internalNioBuffer() {
        ByteBuffer byteBuffer0 = this.tmpNioBuf;
        if(byteBuffer0 == null) {
            ByteBuffer byteBuffer1 = this.newInternalNioBuffer(this.memory);
            this.tmpNioBuf = byteBuffer1;
            return byteBuffer1;
        }
        byteBuffer0.clear();
        return byteBuffer0;
    }

    @Override  // io.netty.buffer.ByteBuf
    public final ByteBuffer internalNioBuffer(int v, int v1) {
        this.checkIndex(v, v1);
        return this._internalNioBuffer(v, v1, false);
    }

    @Override  // io.netty.buffer.ByteBuf
    public final boolean isContiguous() {
        return true;
    }

    @Override  // io.netty.buffer.ByteBuf
    public int maxFastWritableBytes() {
        return Math.min(this.maxLength, this.maxCapacity()) - this.writerIndex;
    }

    public abstract ByteBuffer newInternalNioBuffer(Object arg1);

    @Override  // io.netty.buffer.ByteBuf
    public final ByteBuffer nioBuffer(int v, int v1) {
        return this.duplicateInternalNioBuffer(v, v1).slice();
    }

    @Override  // io.netty.buffer.ByteBuf
    public final int nioBufferCount() {
        return 1;
    }

    @Override  // io.netty.buffer.ByteBuf
    public final ByteBuffer[] nioBuffers(int v, int v1) {
        return new ByteBuffer[]{this.nioBuffer(v, v1)};
    }

    @Override  // io.netty.buffer.ByteBuf
    public final ByteOrder order() {
        return ByteOrder.BIG_ENDIAN;
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public final int readBytes(FileChannel fileChannel0, long v, int v1) {
        this.checkReadableBytes(v1);
        int v2 = fileChannel0.write(this._internalNioBuffer(this.readerIndex, v1, false), v);
        this.readerIndex += v2;
        return v2;
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public final int readBytes(GatheringByteChannel gatheringByteChannel0, int v) {
        this.checkReadableBytes(v);
        int v1 = gatheringByteChannel0.write(this._internalNioBuffer(this.readerIndex, v, false));
        this.readerIndex += v1;
        return v1;
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public final ByteBuf retainedDuplicate() {
        return PooledDuplicatedByteBuf.newInstance(this, this, this.readerIndex(), this.writerIndex());
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public final ByteBuf retainedSlice() {
        int v = this.readerIndex();
        return this.retainedSlice(v, this.writerIndex() - v);
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public final ByteBuf retainedSlice(int v, int v1) {
        return PooledSlicedByteBuf.newInstance(this, this, v, v1);
    }

    public final void reuse(int v) {
        this.maxCapacity(v);
        this.resetRefCnt();
        this.setIndex0(0, 0);
        this.discardMarks();
    }

    @Override  // io.netty.buffer.ByteBuf
    public final int setBytes(int v, FileChannel fileChannel0, long v1, int v2) {
        try {
            return fileChannel0.read(this.internalNioBuffer(v, v2), v1);
        }
        catch(ClosedChannelException unused_ex) {
            return -1;
        }
    }

    @Override  // io.netty.buffer.ByteBuf
    public final int setBytes(int v, ScatteringByteChannel scatteringByteChannel0, int v1) {
        try {
            return scatteringByteChannel0.read(this.internalNioBuffer(v, v1));
        }
        catch(ClosedChannelException unused_ex) {
            return -1;
        }
    }

    @Override  // io.netty.buffer.ByteBuf
    public final ByteBuf unwrap() {
        return null;
    }
}

