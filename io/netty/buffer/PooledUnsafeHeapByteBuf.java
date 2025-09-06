package io.netty.buffer;

import io.netty.util.internal.ObjectPool.Handle;
import io.netty.util.internal.ObjectPool.ObjectCreator;
import io.netty.util.internal.ObjectPool;
import io.netty.util.internal.PlatformDependent;

final class PooledUnsafeHeapByteBuf extends PooledHeapByteBuf {
    private static final ObjectPool RECYCLER;

    static {
        PooledUnsafeHeapByteBuf.RECYCLER = ObjectPool.newPool(new ObjectCreator() {
            public PooledUnsafeHeapByteBuf newObject(Handle objectPool$Handle0) {
                return new PooledUnsafeHeapByteBuf(objectPool$Handle0, 0, null);
            }

            @Override  // io.netty.util.internal.ObjectPool$ObjectCreator
            public Object newObject(Handle objectPool$Handle0) {
                return this.newObject(objectPool$Handle0);
            }
        });
    }

    private PooledUnsafeHeapByteBuf(Handle objectPool$Handle0, int v) {
        super(objectPool$Handle0, v);
    }

    public PooledUnsafeHeapByteBuf(Handle objectPool$Handle0, int v, io.netty.buffer.PooledUnsafeHeapByteBuf.1 pooledUnsafeHeapByteBuf$10) {
        this(objectPool$Handle0, v);
    }

    @Override  // io.netty.buffer.PooledHeapByteBuf
    public byte _getByte(int v) {
        return UnsafeByteBufUtil.getByte(((byte[])this.memory), this.idx(v));
    }

    @Override  // io.netty.buffer.PooledHeapByteBuf
    public int _getInt(int v) {
        return UnsafeByteBufUtil.getInt(((byte[])this.memory), this.idx(v));
    }

    @Override  // io.netty.buffer.PooledHeapByteBuf
    public int _getIntLE(int v) {
        return UnsafeByteBufUtil.getIntLE(((byte[])this.memory), this.idx(v));
    }

    @Override  // io.netty.buffer.PooledHeapByteBuf
    public long _getLong(int v) {
        return UnsafeByteBufUtil.getLong(((byte[])this.memory), this.idx(v));
    }

    @Override  // io.netty.buffer.PooledHeapByteBuf
    public long _getLongLE(int v) {
        return UnsafeByteBufUtil.getLongLE(((byte[])this.memory), this.idx(v));
    }

    @Override  // io.netty.buffer.PooledHeapByteBuf
    public short _getShort(int v) {
        return UnsafeByteBufUtil.getShort(((byte[])this.memory), this.idx(v));
    }

    @Override  // io.netty.buffer.PooledHeapByteBuf
    public short _getShortLE(int v) {
        return UnsafeByteBufUtil.getShortLE(((byte[])this.memory), this.idx(v));
    }

    @Override  // io.netty.buffer.PooledHeapByteBuf
    public int _getUnsignedMedium(int v) {
        return UnsafeByteBufUtil.getUnsignedMedium(((byte[])this.memory), this.idx(v));
    }

    @Override  // io.netty.buffer.PooledHeapByteBuf
    public int _getUnsignedMediumLE(int v) {
        return UnsafeByteBufUtil.getUnsignedMediumLE(((byte[])this.memory), this.idx(v));
    }

    @Override  // io.netty.buffer.PooledHeapByteBuf
    public void _setByte(int v, int v1) {
        UnsafeByteBufUtil.setByte(((byte[])this.memory), this.idx(v), v1);
    }

    @Override  // io.netty.buffer.PooledHeapByteBuf
    public void _setInt(int v, int v1) {
        UnsafeByteBufUtil.setInt(((byte[])this.memory), this.idx(v), v1);
    }

    @Override  // io.netty.buffer.PooledHeapByteBuf
    public void _setIntLE(int v, int v1) {
        UnsafeByteBufUtil.setIntLE(((byte[])this.memory), this.idx(v), v1);
    }

    @Override  // io.netty.buffer.PooledHeapByteBuf
    public void _setLong(int v, long v1) {
        UnsafeByteBufUtil.setLong(((byte[])this.memory), this.idx(v), v1);
    }

    @Override  // io.netty.buffer.PooledHeapByteBuf
    public void _setLongLE(int v, long v1) {
        UnsafeByteBufUtil.setLongLE(((byte[])this.memory), this.idx(v), v1);
    }

    @Override  // io.netty.buffer.PooledHeapByteBuf
    public void _setMedium(int v, int v1) {
        UnsafeByteBufUtil.setMedium(((byte[])this.memory), this.idx(v), v1);
    }

    @Override  // io.netty.buffer.PooledHeapByteBuf
    public void _setMediumLE(int v, int v1) {
        UnsafeByteBufUtil.setMediumLE(((byte[])this.memory), this.idx(v), v1);
    }

    @Override  // io.netty.buffer.PooledHeapByteBuf
    public void _setShort(int v, int v1) {
        UnsafeByteBufUtil.setShort(((byte[])this.memory), this.idx(v), v1);
    }

    @Override  // io.netty.buffer.PooledHeapByteBuf
    public void _setShortLE(int v, int v1) {
        UnsafeByteBufUtil.setShortLE(((byte[])this.memory), this.idx(v), v1);
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    @Deprecated
    public SwappedByteBuf newSwappedByteBuf() {
        return PlatformDependent.isUnaligned() ? new UnsafeHeapSwappedByteBuf(this) : super.newSwappedByteBuf();
    }

    public static PooledUnsafeHeapByteBuf newUnsafeInstance(int v) {
        PooledUnsafeHeapByteBuf pooledUnsafeHeapByteBuf0 = (PooledUnsafeHeapByteBuf)PooledUnsafeHeapByteBuf.RECYCLER.get();
        pooledUnsafeHeapByteBuf0.reuse(v);
        return pooledUnsafeHeapByteBuf0;
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public ByteBuf setZero(int v, int v1) {
        if(PlatformDependent.javaVersion() >= 7) {
            this.checkIndex(v, v1);
            UnsafeByteBufUtil.setZero(((byte[])this.memory), this.idx(v), v1);
            return this;
        }
        return super.setZero(v, v1);
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public ByteBuf writeZero(int v) {
        if(PlatformDependent.javaVersion() >= 7) {
            this.ensureWritable(v);
            int v1 = this.writerIndex;
            UnsafeByteBufUtil.setZero(((byte[])this.memory), this.idx(v1), v);
            this.writerIndex = v1 + v;
            return this;
        }
        return super.writeZero(v);
    }
}

