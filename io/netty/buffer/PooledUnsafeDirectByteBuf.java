package io.netty.buffer;

import io.netty.util.internal.ObjectPool.Handle;
import io.netty.util.internal.ObjectPool.ObjectCreator;
import io.netty.util.internal.ObjectPool;
import io.netty.util.internal.PlatformDependent;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;

final class PooledUnsafeDirectByteBuf extends PooledByteBuf {
    private static final ObjectPool RECYCLER;
    private long memoryAddress;

    static {
        PooledUnsafeDirectByteBuf.RECYCLER = ObjectPool.newPool(new ObjectCreator() {
            public PooledUnsafeDirectByteBuf newObject(Handle objectPool$Handle0) {
                return new PooledUnsafeDirectByteBuf(objectPool$Handle0, 0, null);
            }

            @Override  // io.netty.util.internal.ObjectPool$ObjectCreator
            public Object newObject(Handle objectPool$Handle0) {
                return this.newObject(objectPool$Handle0);
            }
        });
    }

    private PooledUnsafeDirectByteBuf(Handle objectPool$Handle0, int v) {
        super(objectPool$Handle0, v);
    }

    public PooledUnsafeDirectByteBuf(Handle objectPool$Handle0, int v, io.netty.buffer.PooledUnsafeDirectByteBuf.1 pooledUnsafeDirectByteBuf$10) {
        this(objectPool$Handle0, v);
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public byte _getByte(int v) {
        return UnsafeByteBufUtil.getByte(this.addr(v));
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public int _getInt(int v) {
        return UnsafeByteBufUtil.getInt(this.addr(v));
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public int _getIntLE(int v) {
        return UnsafeByteBufUtil.getIntLE(this.addr(v));
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public long _getLong(int v) {
        return UnsafeByteBufUtil.getLong(this.addr(v));
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public long _getLongLE(int v) {
        return UnsafeByteBufUtil.getLongLE(this.addr(v));
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public short _getShort(int v) {
        return UnsafeByteBufUtil.getShort(this.addr(v));
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public short _getShortLE(int v) {
        return UnsafeByteBufUtil.getShortLE(this.addr(v));
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public int _getUnsignedMedium(int v) {
        return UnsafeByteBufUtil.getUnsignedMedium(this.addr(v));
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public int _getUnsignedMediumLE(int v) {
        return UnsafeByteBufUtil.getUnsignedMediumLE(this.addr(v));
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public void _setByte(int v, int v1) {
        UnsafeByteBufUtil.setByte(this.addr(v), ((int)(((byte)v1))));
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public void _setInt(int v, int v1) {
        UnsafeByteBufUtil.setInt(this.addr(v), v1);
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public void _setIntLE(int v, int v1) {
        UnsafeByteBufUtil.setIntLE(this.addr(v), v1);
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public void _setLong(int v, long v1) {
        UnsafeByteBufUtil.setLong(this.addr(v), v1);
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public void _setLongLE(int v, long v1) {
        UnsafeByteBufUtil.setLongLE(this.addr(v), v1);
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public void _setMedium(int v, int v1) {
        UnsafeByteBufUtil.setMedium(this.addr(v), v1);
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public void _setMediumLE(int v, int v1) {
        UnsafeByteBufUtil.setMediumLE(this.addr(v), v1);
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public void _setShort(int v, int v1) {
        UnsafeByteBufUtil.setShort(this.addr(v), v1);
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public void _setShortLE(int v, int v1) {
        UnsafeByteBufUtil.setShortLE(this.addr(v), v1);
    }

    private long addr(int v) {
        return this.memoryAddress + ((long)v);
    }

    @Override  // io.netty.buffer.ByteBuf
    public byte[] array() {
        throw new UnsupportedOperationException("direct buffer");
    }

    @Override  // io.netty.buffer.ByteBuf
    public int arrayOffset() {
        throw new UnsupportedOperationException("direct buffer");
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf copy(int v, int v1) {
        return UnsafeByteBufUtil.copy(this, this.addr(v), v, v1);
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int v, ByteBuf byteBuf0, int v1, int v2) {
        UnsafeByteBufUtil.getBytes(this, this.addr(v), v, byteBuf0, v1, v2);
        return this;
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int v, OutputStream outputStream0, int v1) {
        UnsafeByteBufUtil.getBytes(this, this.addr(v), v, outputStream0, v1);
        return this;
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int v, ByteBuffer byteBuffer0) {
        UnsafeByteBufUtil.getBytes(this, this.addr(v), v, byteBuffer0);
        return this;
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int v, byte[] arr_b, int v1, int v2) {
        UnsafeByteBufUtil.getBytes(this, this.addr(v), v, arr_b, v1, v2);
        return this;
    }

    @Override  // io.netty.buffer.ByteBuf
    public boolean hasArray() {
        return false;
    }

    @Override  // io.netty.buffer.ByteBuf
    public boolean hasMemoryAddress() {
        return true;
    }

    @Override  // io.netty.buffer.PooledByteBuf
    public void init(PoolChunk poolChunk0, ByteBuffer byteBuffer0, long v, int v1, int v2, int v3, PoolThreadCache poolThreadCache0) {
        super.init(poolChunk0, byteBuffer0, v, v1, v2, v3, poolThreadCache0);
        this.initMemoryAddress();
    }

    private void initMemoryAddress() {
        this.memoryAddress = PlatformDependent.directBufferAddress(((ByteBuffer)this.memory)) + ((long)this.offset);
    }

    @Override  // io.netty.buffer.PooledByteBuf
    public void initUnpooled(PoolChunk poolChunk0, int v) {
        super.initUnpooled(poolChunk0, v);
        this.initMemoryAddress();
    }

    @Override  // io.netty.buffer.ByteBuf
    public boolean isDirect() {
        return true;
    }

    @Override  // io.netty.buffer.ByteBuf
    public long memoryAddress() {
        this.ensureAccessible();
        return this.memoryAddress;
    }

    public static PooledUnsafeDirectByteBuf newInstance(int v) {
        PooledUnsafeDirectByteBuf pooledUnsafeDirectByteBuf0 = (PooledUnsafeDirectByteBuf)PooledUnsafeDirectByteBuf.RECYCLER.get();
        pooledUnsafeDirectByteBuf0.reuse(v);
        return pooledUnsafeDirectByteBuf0;
    }

    @Override  // io.netty.buffer.PooledByteBuf
    public ByteBuffer newInternalNioBuffer(Object object0) {
        return this.newInternalNioBuffer(((ByteBuffer)object0));
    }

    public ByteBuffer newInternalNioBuffer(ByteBuffer byteBuffer0) {
        return byteBuffer0.duplicate();
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public SwappedByteBuf newSwappedByteBuf() {
        return PlatformDependent.isUnaligned() ? new UnsafeDirectSwappedByteBuf(this) : super.newSwappedByteBuf();
    }

    @Override  // io.netty.buffer.ByteBuf
    public int setBytes(int v, InputStream inputStream0, int v1) {
        return UnsafeByteBufUtil.setBytes(this, this.addr(v), v, inputStream0, v1);
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf setBytes(int v, ByteBuf byteBuf0, int v1, int v2) {
        UnsafeByteBufUtil.setBytes(this, this.addr(v), v, byteBuf0, v1, v2);
        return this;
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf setBytes(int v, ByteBuffer byteBuffer0) {
        UnsafeByteBufUtil.setBytes(this, this.addr(v), v, byteBuffer0);
        return this;
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf setBytes(int v, byte[] arr_b, int v1, int v2) {
        UnsafeByteBufUtil.setBytes(this, this.addr(v), v, arr_b, v1, v2);
        return this;
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public ByteBuf setZero(int v, int v1) {
        this.checkIndex(v, v1);
        UnsafeByteBufUtil.setZero(this.addr(v), v1);
        return this;
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public ByteBuf writeZero(int v) {
        this.ensureWritable(v);
        int v1 = this.writerIndex;
        UnsafeByteBufUtil.setZero(this.addr(v1), v);
        this.writerIndex = v1 + v;
        return this;
    }
}

