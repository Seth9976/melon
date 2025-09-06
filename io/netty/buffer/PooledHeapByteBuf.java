package io.netty.buffer;

import io.netty.util.internal.ObjectPool.Handle;
import io.netty.util.internal.ObjectPool.ObjectCreator;
import io.netty.util.internal.ObjectPool;
import io.netty.util.internal.PlatformDependent;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;

class PooledHeapByteBuf extends PooledByteBuf {
    private static final ObjectPool RECYCLER;

    static {
        PooledHeapByteBuf.RECYCLER = ObjectPool.newPool(new ObjectCreator() {
            public PooledHeapByteBuf newObject(Handle objectPool$Handle0) {
                return new PooledHeapByteBuf(objectPool$Handle0, 0);
            }

            @Override  // io.netty.util.internal.ObjectPool$ObjectCreator
            public Object newObject(Handle objectPool$Handle0) {
                return this.newObject(objectPool$Handle0);
            }
        });
    }

    public PooledHeapByteBuf(Handle objectPool$Handle0, int v) {
        super(objectPool$Handle0, v);
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public byte _getByte(int v) {
        return HeapByteBufUtil.getByte(((byte[])this.memory), this.idx(v));
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public int _getInt(int v) {
        return HeapByteBufUtil.getInt(((byte[])this.memory), this.idx(v));
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public int _getIntLE(int v) {
        return HeapByteBufUtil.getIntLE(((byte[])this.memory), this.idx(v));
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public long _getLong(int v) {
        return HeapByteBufUtil.getLong(((byte[])this.memory), this.idx(v));
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public long _getLongLE(int v) {
        return HeapByteBufUtil.getLongLE(((byte[])this.memory), this.idx(v));
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public short _getShort(int v) {
        return HeapByteBufUtil.getShort(((byte[])this.memory), this.idx(v));
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public short _getShortLE(int v) {
        return HeapByteBufUtil.getShortLE(((byte[])this.memory), this.idx(v));
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public int _getUnsignedMedium(int v) {
        return HeapByteBufUtil.getUnsignedMedium(((byte[])this.memory), this.idx(v));
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public int _getUnsignedMediumLE(int v) {
        return HeapByteBufUtil.getUnsignedMediumLE(((byte[])this.memory), this.idx(v));
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public void _setByte(int v, int v1) {
        HeapByteBufUtil.setByte(((byte[])this.memory), this.idx(v), v1);
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public void _setInt(int v, int v1) {
        HeapByteBufUtil.setInt(((byte[])this.memory), this.idx(v), v1);
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public void _setIntLE(int v, int v1) {
        HeapByteBufUtil.setIntLE(((byte[])this.memory), this.idx(v), v1);
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public void _setLong(int v, long v1) {
        HeapByteBufUtil.setLong(((byte[])this.memory), this.idx(v), v1);
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public void _setLongLE(int v, long v1) {
        HeapByteBufUtil.setLongLE(((byte[])this.memory), this.idx(v), v1);
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public void _setMedium(int v, int v1) {
        HeapByteBufUtil.setMedium(((byte[])this.memory), this.idx(v), v1);
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public void _setMediumLE(int v, int v1) {
        HeapByteBufUtil.setMediumLE(((byte[])this.memory), this.idx(v), v1);
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public void _setShort(int v, int v1) {
        HeapByteBufUtil.setShort(((byte[])this.memory), this.idx(v), v1);
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public void _setShortLE(int v, int v1) {
        HeapByteBufUtil.setShortLE(((byte[])this.memory), this.idx(v), v1);
    }

    @Override  // io.netty.buffer.ByteBuf
    public final byte[] array() {
        this.ensureAccessible();
        return (byte[])this.memory;
    }

    @Override  // io.netty.buffer.ByteBuf
    public final int arrayOffset() {
        return this.offset;
    }

    @Override  // io.netty.buffer.ByteBuf
    public final ByteBuf copy(int v, int v1) {
        this.checkIndex(v, v1);
        return this.alloc().heapBuffer(v1, this.maxCapacity()).writeBytes(((byte[])this.memory), this.idx(v), v1);
    }

    @Override  // io.netty.buffer.PooledByteBuf
    public final ByteBuffer duplicateInternalNioBuffer(int v, int v1) {
        this.checkIndex(v, v1);
        return ByteBuffer.wrap(((byte[])this.memory), this.idx(v), v1).slice();
    }

    @Override  // io.netty.buffer.ByteBuf
    public final ByteBuf getBytes(int v, ByteBuf byteBuf0, int v1, int v2) {
        this.checkDstIndex(v, v2, v1, byteBuf0.capacity());
        if(byteBuf0.hasMemoryAddress()) {
            PlatformDependent.copyMemory(((byte[])this.memory), this.idx(v), ((long)v1) + byteBuf0.memoryAddress(), ((long)v2));
            return this;
        }
        if(byteBuf0.hasArray()) {
            this.getBytes(v, byteBuf0.array(), byteBuf0.arrayOffset() + v1, v2);
            return this;
        }
        byteBuf0.setBytes(v1, ((byte[])this.memory), this.idx(v), v2);
        return this;
    }

    @Override  // io.netty.buffer.ByteBuf
    public final ByteBuf getBytes(int v, OutputStream outputStream0, int v1) {
        this.checkIndex(v, v1);
        outputStream0.write(((byte[])this.memory), this.idx(v), v1);
        return this;
    }

    @Override  // io.netty.buffer.ByteBuf
    public final ByteBuf getBytes(int v, ByteBuffer byteBuffer0) {
        int v1 = byteBuffer0.remaining();
        this.checkIndex(v, v1);
        byteBuffer0.put(((byte[])this.memory), this.idx(v), v1);
        return this;
    }

    @Override  // io.netty.buffer.ByteBuf
    public final ByteBuf getBytes(int v, byte[] arr_b, int v1, int v2) {
        this.checkDstIndex(v, v2, v1, arr_b.length);
        System.arraycopy(this.memory, this.idx(v), arr_b, v1, v2);
        return this;
    }

    @Override  // io.netty.buffer.ByteBuf
    public final boolean hasArray() {
        return true;
    }

    @Override  // io.netty.buffer.ByteBuf
    public final boolean hasMemoryAddress() {
        return false;
    }

    @Override  // io.netty.buffer.ByteBuf
    public final boolean isDirect() {
        return false;
    }

    @Override  // io.netty.buffer.ByteBuf
    public final long memoryAddress() {
        throw new UnsupportedOperationException();
    }

    public static PooledHeapByteBuf newInstance(int v) {
        PooledHeapByteBuf pooledHeapByteBuf0 = (PooledHeapByteBuf)PooledHeapByteBuf.RECYCLER.get();
        pooledHeapByteBuf0.reuse(v);
        return pooledHeapByteBuf0;
    }

    @Override  // io.netty.buffer.PooledByteBuf
    public ByteBuffer newInternalNioBuffer(Object object0) {
        return this.newInternalNioBuffer(((byte[])object0));
    }

    public final ByteBuffer newInternalNioBuffer(byte[] arr_b) {
        return ByteBuffer.wrap(arr_b);
    }

    @Override  // io.netty.buffer.ByteBuf
    public final int setBytes(int v, InputStream inputStream0, int v1) {
        this.checkIndex(v, v1);
        return inputStream0.read(((byte[])this.memory), this.idx(v), v1);
    }

    @Override  // io.netty.buffer.ByteBuf
    public final ByteBuf setBytes(int v, ByteBuf byteBuf0, int v1, int v2) {
        this.checkSrcIndex(v, v2, v1, byteBuf0.capacity());
        if(byteBuf0.hasMemoryAddress()) {
            PlatformDependent.copyMemory(byteBuf0.memoryAddress() + ((long)v1), ((byte[])this.memory), this.idx(v), v2);
            return this;
        }
        if(byteBuf0.hasArray()) {
            this.setBytes(v, byteBuf0.array(), byteBuf0.arrayOffset() + v1, v2);
            return this;
        }
        byteBuf0.getBytes(v1, ((byte[])this.memory), this.idx(v), v2);
        return this;
    }

    @Override  // io.netty.buffer.ByteBuf
    public final ByteBuf setBytes(int v, ByteBuffer byteBuffer0) {
        int v1 = byteBuffer0.remaining();
        this.checkIndex(v, v1);
        byteBuffer0.get(((byte[])this.memory), this.idx(v), v1);
        return this;
    }

    @Override  // io.netty.buffer.ByteBuf
    public final ByteBuf setBytes(int v, byte[] arr_b, int v1, int v2) {
        this.checkSrcIndex(v, v2, v1, arr_b.length);
        System.arraycopy(arr_b, v1, this.memory, this.idx(v), v2);
        return this;
    }
}

