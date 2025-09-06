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

final class PooledDuplicatedByteBuf extends AbstractPooledDerivedByteBuf {
    private static final ObjectPool RECYCLER;

    static {
        PooledDuplicatedByteBuf.RECYCLER = ObjectPool.newPool(new ObjectCreator() {
            public PooledDuplicatedByteBuf newObject(Handle objectPool$Handle0) {
                return new PooledDuplicatedByteBuf(objectPool$Handle0, null);
            }

            @Override  // io.netty.util.internal.ObjectPool$ObjectCreator
            public Object newObject(Handle objectPool$Handle0) {
                return this.newObject(objectPool$Handle0);
            }
        });
    }

    private PooledDuplicatedByteBuf(Handle objectPool$Handle0) {
        super(objectPool$Handle0);
    }

    public PooledDuplicatedByteBuf(Handle objectPool$Handle0, io.netty.buffer.PooledDuplicatedByteBuf.1 pooledDuplicatedByteBuf$10) {
        this(objectPool$Handle0);
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public byte _getByte(int v) {
        return this.unwrap()._getByte(v);
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public int _getInt(int v) {
        return this.unwrap()._getInt(v);
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public int _getIntLE(int v) {
        return this.unwrap()._getIntLE(v);
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public long _getLong(int v) {
        return this.unwrap()._getLong(v);
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public long _getLongLE(int v) {
        return this.unwrap()._getLongLE(v);
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public short _getShort(int v) {
        return this.unwrap()._getShort(v);
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public short _getShortLE(int v) {
        return this.unwrap()._getShortLE(v);
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public int _getUnsignedMedium(int v) {
        return this.unwrap()._getUnsignedMedium(v);
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public int _getUnsignedMediumLE(int v) {
        return this.unwrap()._getUnsignedMediumLE(v);
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public void _setByte(int v, int v1) {
        this.unwrap()._setByte(v, v1);
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public void _setInt(int v, int v1) {
        this.unwrap()._setInt(v, v1);
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public void _setIntLE(int v, int v1) {
        this.unwrap()._setIntLE(v, v1);
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public void _setLong(int v, long v1) {
        this.unwrap()._setLong(v, v1);
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public void _setLongLE(int v, long v1) {
        this.unwrap().setLongLE(v, v1);
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public void _setMedium(int v, int v1) {
        this.unwrap()._setMedium(v, v1);
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public void _setMediumLE(int v, int v1) {
        this.unwrap()._setMediumLE(v, v1);
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public void _setShort(int v, int v1) {
        this.unwrap()._setShort(v, v1);
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public void _setShortLE(int v, int v1) {
        this.unwrap()._setShortLE(v, v1);
    }

    @Override  // io.netty.buffer.ByteBuf
    public int arrayOffset() {
        return this.unwrap().arrayOffset();
    }

    @Override  // io.netty.buffer.ByteBuf
    public int capacity() {
        return this.unwrap().capacity();
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf capacity(int v) {
        this.unwrap().capacity(v);
        return this;
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf copy(int v, int v1) {
        return this.unwrap().copy(v, v1);
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public ByteBuf duplicate() {
        return this.duplicate0().setIndex(this.readerIndex(), this.writerIndex());
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public int forEachByte(int v, int v1, ByteProcessor byteProcessor0) {
        return this.unwrap().forEachByte(v, v1, byteProcessor0);
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public int forEachByteDesc(int v, int v1, ByteProcessor byteProcessor0) {
        return this.unwrap().forEachByteDesc(v, v1, byteProcessor0);
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public byte getByte(int v) {
        return this.unwrap().getByte(v);
    }

    @Override  // io.netty.buffer.ByteBuf
    public int getBytes(int v, FileChannel fileChannel0, long v1, int v2) {
        return this.unwrap().getBytes(v, fileChannel0, v1, v2);
    }

    @Override  // io.netty.buffer.ByteBuf
    public int getBytes(int v, GatheringByteChannel gatheringByteChannel0, int v1) {
        return this.unwrap().getBytes(v, gatheringByteChannel0, v1);
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int v, ByteBuf byteBuf0, int v1, int v2) {
        this.unwrap().getBytes(v, byteBuf0, v1, v2);
        return this;
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int v, OutputStream outputStream0, int v1) {
        this.unwrap().getBytes(v, outputStream0, v1);
        return this;
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int v, ByteBuffer byteBuffer0) {
        this.unwrap().getBytes(v, byteBuffer0);
        return this;
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int v, byte[] arr_b, int v1, int v2) {
        this.unwrap().getBytes(v, arr_b, v1, v2);
        return this;
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public int getInt(int v) {
        return this.unwrap().getInt(v);
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public int getIntLE(int v) {
        return this.unwrap().getIntLE(v);
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public long getLong(int v) {
        return this.unwrap().getLong(v);
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public long getLongLE(int v) {
        return this.unwrap().getLongLE(v);
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public short getShort(int v) {
        return this.unwrap().getShort(v);
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public short getShortLE(int v) {
        return this.unwrap().getShortLE(v);
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public int getUnsignedMedium(int v) {
        return this.unwrap().getUnsignedMedium(v);
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public int getUnsignedMediumLE(int v) {
        return this.unwrap().getUnsignedMediumLE(v);
    }

    @Override  // io.netty.buffer.ByteBuf
    public long memoryAddress() {
        return this.unwrap().memoryAddress();
    }

    public static PooledDuplicatedByteBuf newInstance(AbstractByteBuf abstractByteBuf0, ByteBuf byteBuf0, int v, int v1) {
        Object object0 = PooledDuplicatedByteBuf.RECYCLER.get();
        ((PooledDuplicatedByteBuf)object0).init(abstractByteBuf0, byteBuf0, v, v1, abstractByteBuf0.maxCapacity());
        ((PooledDuplicatedByteBuf)object0).markReaderIndex();
        ((PooledDuplicatedByteBuf)object0).markWriterIndex();
        return (PooledDuplicatedByteBuf)object0;
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuffer nioBuffer(int v, int v1) {
        return this.unwrap().nioBuffer(v, v1);
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuffer[] nioBuffers(int v, int v1) {
        return this.unwrap().nioBuffers(v, v1);
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public ByteBuf retainedDuplicate() {
        return PooledDuplicatedByteBuf.newInstance(this.unwrap(), this, this.readerIndex(), this.writerIndex());
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public ByteBuf retainedSlice(int v, int v1) {
        return PooledSlicedByteBuf.newInstance(this.unwrap(), this, v, v1);
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public ByteBuf setByte(int v, int v1) {
        this.unwrap().setByte(v, v1);
        return this;
    }

    @Override  // io.netty.buffer.ByteBuf
    public int setBytes(int v, InputStream inputStream0, int v1) {
        return this.unwrap().setBytes(v, inputStream0, v1);
    }

    @Override  // io.netty.buffer.ByteBuf
    public int setBytes(int v, FileChannel fileChannel0, long v1, int v2) {
        return this.unwrap().setBytes(v, fileChannel0, v1, v2);
    }

    @Override  // io.netty.buffer.ByteBuf
    public int setBytes(int v, ScatteringByteChannel scatteringByteChannel0, int v1) {
        return this.unwrap().setBytes(v, scatteringByteChannel0, v1);
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf setBytes(int v, ByteBuf byteBuf0, int v1, int v2) {
        this.unwrap().setBytes(v, byteBuf0, v1, v2);
        return this;
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf setBytes(int v, ByteBuffer byteBuffer0) {
        this.unwrap().setBytes(v, byteBuffer0);
        return this;
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf setBytes(int v, byte[] arr_b, int v1, int v2) {
        this.unwrap().setBytes(v, arr_b, v1, v2);
        return this;
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public ByteBuf setInt(int v, int v1) {
        this.unwrap().setInt(v, v1);
        return this;
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public ByteBuf setIntLE(int v, int v1) {
        this.unwrap().setIntLE(v, v1);
        return this;
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public ByteBuf setLong(int v, long v1) {
        this.unwrap().setLong(v, v1);
        return this;
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public ByteBuf setLongLE(int v, long v1) {
        this.unwrap().setLongLE(v, v1);
        return this;
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public ByteBuf setMedium(int v, int v1) {
        this.unwrap().setMedium(v, v1);
        return this;
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public ByteBuf setMediumLE(int v, int v1) {
        this.unwrap().setMediumLE(v, v1);
        return this;
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public ByteBuf setShort(int v, int v1) {
        this.unwrap().setShort(v, v1);
        return this;
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public ByteBuf setShortLE(int v, int v1) {
        this.unwrap().setShortLE(v, v1);
        return this;
    }
}

