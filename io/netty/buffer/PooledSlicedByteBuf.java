package io.netty.buffer;

import io.netty.util.ByteProcessor;
import io.netty.util.internal.ObjectPool.Handle;
import io.netty.util.internal.ObjectPool.ObjectCreator;
import io.netty.util.internal.ObjectPool;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.GatheringByteChannel;
import java.nio.channels.ScatteringByteChannel;

final class PooledSlicedByteBuf extends AbstractPooledDerivedByteBuf {
    private static final ObjectPool RECYCLER;
    int adjustment;

    static {
        PooledSlicedByteBuf.RECYCLER = ObjectPool.newPool(new ObjectCreator() {
            public PooledSlicedByteBuf newObject(Handle objectPool$Handle0) {
                return new PooledSlicedByteBuf(objectPool$Handle0, null);
            }

            @Override  // io.netty.util.internal.ObjectPool$ObjectCreator
            public Object newObject(Handle objectPool$Handle0) {
                return this.newObject(objectPool$Handle0);
            }
        });
    }

    private PooledSlicedByteBuf(Handle objectPool$Handle0) {
        super(objectPool$Handle0);
    }

    public PooledSlicedByteBuf(Handle objectPool$Handle0, io.netty.buffer.PooledSlicedByteBuf.1 pooledSlicedByteBuf$10) {
        this(objectPool$Handle0);
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public byte _getByte(int v) {
        return this.unwrap()._getByte(this.idx(v));
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public int _getInt(int v) {
        return this.unwrap()._getInt(this.idx(v));
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public int _getIntLE(int v) {
        return this.unwrap()._getIntLE(this.idx(v));
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public long _getLong(int v) {
        return this.unwrap()._getLong(this.idx(v));
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public long _getLongLE(int v) {
        return this.unwrap()._getLongLE(this.idx(v));
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public short _getShort(int v) {
        return this.unwrap()._getShort(this.idx(v));
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public short _getShortLE(int v) {
        return this.unwrap()._getShortLE(this.idx(v));
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public int _getUnsignedMedium(int v) {
        return this.unwrap()._getUnsignedMedium(this.idx(v));
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public int _getUnsignedMediumLE(int v) {
        return this.unwrap()._getUnsignedMediumLE(this.idx(v));
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public void _setByte(int v, int v1) {
        this.unwrap()._setByte(this.idx(v), v1);
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public void _setInt(int v, int v1) {
        this.unwrap()._setInt(this.idx(v), v1);
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public void _setIntLE(int v, int v1) {
        this.unwrap()._setIntLE(this.idx(v), v1);
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public void _setLong(int v, long v1) {
        this.unwrap()._setLong(this.idx(v), v1);
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public void _setLongLE(int v, long v1) {
        this.unwrap().setLongLE(this.idx(v), v1);
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public void _setMedium(int v, int v1) {
        this.unwrap()._setMedium(this.idx(v), v1);
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public void _setMediumLE(int v, int v1) {
        this.unwrap()._setMediumLE(this.idx(v), v1);
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public void _setShort(int v, int v1) {
        this.unwrap()._setShort(this.idx(v), v1);
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public void _setShortLE(int v, int v1) {
        this.unwrap()._setShortLE(this.idx(v), v1);
    }

    @Override  // io.netty.buffer.ByteBuf
    public int arrayOffset() {
        return this.idx(this.unwrap().arrayOffset());
    }

    @Override  // io.netty.buffer.ByteBuf
    public int capacity() {
        return this.maxCapacity();
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf capacity(int v) {
        throw new UnsupportedOperationException("sliced buffer");
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf copy(int v, int v1) {
        this.checkIndex0(v, v1);
        return this.unwrap().copy(this.idx(v), v1);
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public ByteBuf duplicate() {
        return this.duplicate0().setIndex(this.idx(this.readerIndex()), this.idx(this.writerIndex()));
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public int forEachByte(int v, int v1, ByteProcessor byteProcessor0) {
        this.checkIndex0(v, v1);
        int v2 = this.unwrap().forEachByte(this.idx(v), v1, byteProcessor0);
        return v2 >= this.adjustment ? v2 - this.adjustment : -1;
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public int forEachByteDesc(int v, int v1, ByteProcessor byteProcessor0) {
        this.checkIndex0(v, v1);
        int v2 = this.unwrap().forEachByteDesc(this.idx(v), v1, byteProcessor0);
        return v2 >= this.adjustment ? v2 - this.adjustment : -1;
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public byte getByte(int v) {
        this.checkIndex0(v, 1);
        return this.unwrap().getByte(this.idx(v));
    }

    @Override  // io.netty.buffer.ByteBuf
    public int getBytes(int v, FileChannel fileChannel0, long v1, int v2) {
        this.checkIndex0(v, v2);
        return this.unwrap().getBytes(this.idx(v), fileChannel0, v1, v2);
    }

    @Override  // io.netty.buffer.ByteBuf
    public int getBytes(int v, GatheringByteChannel gatheringByteChannel0, int v1) {
        this.checkIndex0(v, v1);
        return this.unwrap().getBytes(this.idx(v), gatheringByteChannel0, v1);
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int v, ByteBuf byteBuf0, int v1, int v2) {
        this.checkIndex0(v, v2);
        this.unwrap().getBytes(this.idx(v), byteBuf0, v1, v2);
        return this;
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int v, OutputStream outputStream0, int v1) {
        this.checkIndex0(v, v1);
        this.unwrap().getBytes(this.idx(v), outputStream0, v1);
        return this;
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int v, ByteBuffer byteBuffer0) {
        this.checkIndex0(v, byteBuffer0.remaining());
        this.unwrap().getBytes(this.idx(v), byteBuffer0);
        return this;
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int v, byte[] arr_b, int v1, int v2) {
        this.checkIndex0(v, v2);
        this.unwrap().getBytes(this.idx(v), arr_b, v1, v2);
        return this;
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public int getInt(int v) {
        this.checkIndex0(v, 4);
        return this.unwrap().getInt(this.idx(v));
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public int getIntLE(int v) {
        this.checkIndex0(v, 4);
        return this.unwrap().getIntLE(this.idx(v));
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public long getLong(int v) {
        this.checkIndex0(v, 8);
        return this.unwrap().getLong(this.idx(v));
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public long getLongLE(int v) {
        this.checkIndex0(v, 8);
        return this.unwrap().getLongLE(this.idx(v));
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public short getShort(int v) {
        this.checkIndex0(v, 2);
        return this.unwrap().getShort(this.idx(v));
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public short getShortLE(int v) {
        this.checkIndex0(v, 2);
        return this.unwrap().getShortLE(this.idx(v));
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public int getUnsignedMedium(int v) {
        this.checkIndex0(v, 3);
        return this.unwrap().getUnsignedMedium(this.idx(v));
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public int getUnsignedMediumLE(int v) {
        this.checkIndex0(v, 3);
        return this.unwrap().getUnsignedMediumLE(this.idx(v));
    }

    private int idx(int v) {
        return v + this.adjustment;
    }

    @Override  // io.netty.buffer.ByteBuf
    public long memoryAddress() {
        return this.unwrap().memoryAddress() + ((long)this.adjustment);
    }

    public static PooledSlicedByteBuf newInstance(AbstractByteBuf abstractByteBuf0, ByteBuf byteBuf0, int v, int v1) {
        AbstractUnpooledSlicedByteBuf.checkSliceOutOfBounds(v, v1, abstractByteBuf0);
        return PooledSlicedByteBuf.newInstance0(abstractByteBuf0, byteBuf0, v, v1);
    }

    private static PooledSlicedByteBuf newInstance0(AbstractByteBuf abstractByteBuf0, ByteBuf byteBuf0, int v, int v1) {
        Object object0 = PooledSlicedByteBuf.RECYCLER.get();
        ((PooledSlicedByteBuf)object0).init(abstractByteBuf0, byteBuf0, 0, v1, v1);
        ((PooledSlicedByteBuf)object0).discardMarks();
        ((PooledSlicedByteBuf)object0).adjustment = v;
        return (PooledSlicedByteBuf)object0;
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuffer nioBuffer(int v, int v1) {
        this.checkIndex0(v, v1);
        return this.unwrap().nioBuffer(this.idx(v), v1);
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuffer[] nioBuffers(int v, int v1) {
        this.checkIndex0(v, v1);
        return this.unwrap().nioBuffers(this.idx(v), v1);
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public ByteBuf retainedDuplicate() {
        return PooledDuplicatedByteBuf.newInstance(this.unwrap(), this, this.idx(this.readerIndex()), this.idx(this.writerIndex()));
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public ByteBuf retainedSlice(int v, int v1) {
        this.checkIndex0(v, v1);
        return PooledSlicedByteBuf.newInstance0(this.unwrap(), this, this.idx(v), v1);
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public ByteBuf setByte(int v, int v1) {
        this.checkIndex0(v, 1);
        this.unwrap().setByte(this.idx(v), v1);
        return this;
    }

    @Override  // io.netty.buffer.ByteBuf
    public int setBytes(int v, InputStream inputStream0, int v1) {
        this.checkIndex0(v, v1);
        return this.unwrap().setBytes(this.idx(v), inputStream0, v1);
    }

    @Override  // io.netty.buffer.ByteBuf
    public int setBytes(int v, FileChannel fileChannel0, long v1, int v2) {
        this.checkIndex0(v, v2);
        return this.unwrap().setBytes(this.idx(v), fileChannel0, v1, v2);
    }

    @Override  // io.netty.buffer.ByteBuf
    public int setBytes(int v, ScatteringByteChannel scatteringByteChannel0, int v1) {
        this.checkIndex0(v, v1);
        return this.unwrap().setBytes(this.idx(v), scatteringByteChannel0, v1);
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf setBytes(int v, ByteBuf byteBuf0, int v1, int v2) {
        this.checkIndex0(v, v2);
        this.unwrap().setBytes(this.idx(v), byteBuf0, v1, v2);
        return this;
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf setBytes(int v, ByteBuffer byteBuffer0) {
        this.checkIndex0(v, byteBuffer0.remaining());
        this.unwrap().setBytes(this.idx(v), byteBuffer0);
        return this;
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf setBytes(int v, byte[] arr_b, int v1, int v2) {
        this.checkIndex0(v, v2);
        this.unwrap().setBytes(this.idx(v), arr_b, v1, v2);
        return this;
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public ByteBuf setInt(int v, int v1) {
        this.checkIndex0(v, 4);
        this.unwrap().setInt(this.idx(v), v1);
        return this;
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public ByteBuf setIntLE(int v, int v1) {
        this.checkIndex0(v, 4);
        this.unwrap().setIntLE(this.idx(v), v1);
        return this;
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public ByteBuf setLong(int v, long v1) {
        this.checkIndex0(v, 8);
        this.unwrap().setLong(this.idx(v), v1);
        return this;
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public ByteBuf setLongLE(int v, long v1) {
        this.checkIndex0(v, 8);
        this.unwrap().setLongLE(this.idx(v), v1);
        return this;
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public ByteBuf setMedium(int v, int v1) {
        this.checkIndex0(v, 3);
        this.unwrap().setMedium(this.idx(v), v1);
        return this;
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public ByteBuf setMediumLE(int v, int v1) {
        this.checkIndex0(v, 3);
        this.unwrap().setMediumLE(this.idx(v), v1);
        return this;
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public ByteBuf setShort(int v, int v1) {
        this.checkIndex0(v, 2);
        this.unwrap().setShort(this.idx(v), v1);
        return this;
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public ByteBuf setShortLE(int v, int v1) {
        this.checkIndex0(v, 2);
        this.unwrap().setShortLE(this.idx(v), v1);
        return this;
    }

    @Override  // io.netty.buffer.AbstractPooledDerivedByteBuf
    public ByteBuf slice(int v, int v1) {
        this.checkIndex0(v, v1);
        return super.slice(this.idx(v), v1);
    }
}

