package io.netty.buffer;

import io.netty.util.internal.ObjectPool.Handle;
import io.netty.util.internal.ObjectPool.ObjectCreator;
import io.netty.util.internal.ObjectPool;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;

final class PooledDirectByteBuf extends PooledByteBuf {
    private static final ObjectPool RECYCLER;

    static {
        PooledDirectByteBuf.RECYCLER = ObjectPool.newPool(new ObjectCreator() {
            public PooledDirectByteBuf newObject(Handle objectPool$Handle0) {
                return new PooledDirectByteBuf(objectPool$Handle0, 0, null);
            }

            @Override  // io.netty.util.internal.ObjectPool$ObjectCreator
            public Object newObject(Handle objectPool$Handle0) {
                return this.newObject(objectPool$Handle0);
            }
        });
    }

    private PooledDirectByteBuf(Handle objectPool$Handle0, int v) {
        super(objectPool$Handle0, v);
    }

    public PooledDirectByteBuf(Handle objectPool$Handle0, int v, io.netty.buffer.PooledDirectByteBuf.1 pooledDirectByteBuf$10) {
        this(objectPool$Handle0, v);
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public byte _getByte(int v) {
        return ((ByteBuffer)this.memory).get(this.idx(v));
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public int _getInt(int v) {
        return ((ByteBuffer)this.memory).getInt(this.idx(v));
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public int _getIntLE(int v) {
        return ByteBufUtil.swapInt(this._getInt(v));
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public long _getLong(int v) {
        return ((ByteBuffer)this.memory).getLong(this.idx(v));
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public long _getLongLE(int v) {
        return ByteBufUtil.swapLong(this._getLong(v));
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public short _getShort(int v) {
        return ((ByteBuffer)this.memory).getShort(this.idx(v));
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public short _getShortLE(int v) {
        return ByteBufUtil.swapShort(this._getShort(v));
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public int _getUnsignedMedium(int v) {
        int v1 = this.idx(v);
        int v2 = ((ByteBuffer)this.memory).get(v1);
        int v3 = ((ByteBuffer)this.memory).get(v1 + 1);
        return ((ByteBuffer)this.memory).get(v1 + 2) & 0xFF | ((v2 & 0xFF) << 16 | (v3 & 0xFF) << 8);
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public int _getUnsignedMediumLE(int v) {
        int v1 = this.idx(v);
        int v2 = ((ByteBuffer)this.memory).get(v1);
        int v3 = ((ByteBuffer)this.memory).get(v1 + 1);
        return (((ByteBuffer)this.memory).get(v1 + 2) & 0xFF) << 16 | (v2 & 0xFF | (v3 & 0xFF) << 8);
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public void _setByte(int v, int v1) {
        ((ByteBuffer)this.memory).put(this.idx(v), ((byte)v1));
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public void _setInt(int v, int v1) {
        ((ByteBuffer)this.memory).putInt(this.idx(v), v1);
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public void _setIntLE(int v, int v1) {
        this._setInt(v, ByteBufUtil.swapInt(v1));
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public void _setLong(int v, long v1) {
        ((ByteBuffer)this.memory).putLong(this.idx(v), v1);
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public void _setLongLE(int v, long v1) {
        this._setLong(v, ByteBufUtil.swapLong(v1));
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public void _setMedium(int v, int v1) {
        int v2 = this.idx(v);
        ((ByteBuffer)this.memory).put(v2, ((byte)(v1 >>> 16)));
        ((ByteBuffer)this.memory).put(v2 + 1, ((byte)(v1 >>> 8)));
        ((ByteBuffer)this.memory).put(v2 + 2, ((byte)v1));
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public void _setMediumLE(int v, int v1) {
        int v2 = this.idx(v);
        ((ByteBuffer)this.memory).put(v2, ((byte)v1));
        ((ByteBuffer)this.memory).put(v2 + 1, ((byte)(v1 >>> 8)));
        ((ByteBuffer)this.memory).put(v2 + 2, ((byte)(v1 >>> 16)));
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public void _setShort(int v, int v1) {
        ((ByteBuffer)this.memory).putShort(this.idx(v), ((short)v1));
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public void _setShortLE(int v, int v1) {
        this._setShort(v, ByteBufUtil.swapShort(((short)v1)));
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
        this.checkIndex(v, v1);
        return this.alloc().directBuffer(v1, this.maxCapacity()).writeBytes(this, v, v1);
    }

    private void getBytes(int v, OutputStream outputStream0, int v1, boolean z) {
        this.checkIndex(v, v1);
        if(v1 == 0) {
            return;
        }
        ByteBufUtil.readBytes(this.alloc(), (z ? this.internalNioBuffer() : ((ByteBuffer)this.memory).duplicate()), this.idx(v), v1, outputStream0);
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int v, ByteBuf byteBuf0, int v1, int v2) {
        this.checkDstIndex(v, v2, v1, byteBuf0.capacity());
        if(byteBuf0.hasArray()) {
            this.getBytes(v, byteBuf0.array(), byteBuf0.arrayOffset() + v1, v2);
            return this;
        }
        if(byteBuf0.nioBufferCount() > 0) {
            ByteBuffer[] arr_byteBuffer = byteBuf0.nioBuffers(v1, v2);
            for(int v3 = 0; v3 < arr_byteBuffer.length; ++v3) {
                ByteBuffer byteBuffer0 = arr_byteBuffer[v3];
                this.getBytes(v, byteBuffer0);
                v += byteBuffer0.remaining();
            }
            return this;
        }
        byteBuf0.setBytes(v1, this, v, v2);
        return this;
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int v, OutputStream outputStream0, int v1) {
        this.getBytes(v, outputStream0, v1, false);
        return this;
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int v, ByteBuffer byteBuffer0) {
        byteBuffer0.put(this.duplicateInternalNioBuffer(v, byteBuffer0.remaining()));
        return this;
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int v, byte[] arr_b, int v1, int v2) {
        this.checkDstIndex(v, v2, v1, arr_b.length);
        this._internalNioBuffer(v, v2, true).get(arr_b, v1, v2);
        return this;
    }

    @Override  // io.netty.buffer.ByteBuf
    public boolean hasArray() {
        return false;
    }

    @Override  // io.netty.buffer.ByteBuf
    public boolean hasMemoryAddress() {
        return false;
    }

    @Override  // io.netty.buffer.ByteBuf
    public boolean isDirect() {
        return true;
    }

    @Override  // io.netty.buffer.ByteBuf
    public long memoryAddress() {
        throw new UnsupportedOperationException();
    }

    public static PooledDirectByteBuf newInstance(int v) {
        PooledDirectByteBuf pooledDirectByteBuf0 = (PooledDirectByteBuf)PooledDirectByteBuf.RECYCLER.get();
        pooledDirectByteBuf0.reuse(v);
        return pooledDirectByteBuf0;
    }

    @Override  // io.netty.buffer.PooledByteBuf
    public ByteBuffer newInternalNioBuffer(Object object0) {
        return this.newInternalNioBuffer(((ByteBuffer)object0));
    }

    public ByteBuffer newInternalNioBuffer(ByteBuffer byteBuffer0) {
        return byteBuffer0.duplicate();
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public ByteBuf readBytes(OutputStream outputStream0, int v) {
        this.checkReadableBytes(v);
        this.getBytes(this.readerIndex, outputStream0, v, true);
        this.readerIndex += v;
        return this;
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public ByteBuf readBytes(ByteBuffer byteBuffer0) {
        int v = byteBuffer0.remaining();
        this.checkReadableBytes(v);
        byteBuffer0.put(this._internalNioBuffer(this.readerIndex, v, false));
        this.readerIndex += v;
        return this;
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public ByteBuf readBytes(byte[] arr_b, int v, int v1) {
        this.checkDstIndex(v1, v, arr_b.length);
        this._internalNioBuffer(this.readerIndex, v1, false).get(arr_b, v, v1);
        this.readerIndex += v1;
        return this;
    }

    @Override  // io.netty.buffer.ByteBuf
    public int setBytes(int v, InputStream inputStream0, int v1) {
        this.checkIndex(v, v1);
        byte[] arr_b = ByteBufUtil.threadLocalTempArray(v1);
        int v2 = inputStream0.read(arr_b, 0, v1);
        if(v2 <= 0) {
            return v2;
        }
        ByteBuffer byteBuffer0 = this.internalNioBuffer();
        byteBuffer0.position(this.idx(v));
        byteBuffer0.put(arr_b, 0, v2);
        return v2;
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf setBytes(int v, ByteBuf byteBuf0, int v1, int v2) {
        this.checkSrcIndex(v, v2, v1, byteBuf0.capacity());
        if(byteBuf0.hasArray()) {
            this.setBytes(v, byteBuf0.array(), byteBuf0.arrayOffset() + v1, v2);
            return this;
        }
        if(byteBuf0.nioBufferCount() > 0) {
            ByteBuffer[] arr_byteBuffer = byteBuf0.nioBuffers(v1, v2);
            for(int v3 = 0; v3 < arr_byteBuffer.length; ++v3) {
                ByteBuffer byteBuffer0 = arr_byteBuffer[v3];
                this.setBytes(v, byteBuffer0);
                v += byteBuffer0.remaining();
            }
            return this;
        }
        byteBuf0.getBytes(v1, this, v, v2);
        return this;
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf setBytes(int v, ByteBuffer byteBuffer0) {
        int v1 = byteBuffer0.remaining();
        this.checkIndex(v, v1);
        ByteBuffer byteBuffer1 = this.internalNioBuffer();
        if(byteBuffer0 == byteBuffer1) {
            byteBuffer0 = byteBuffer0.duplicate();
        }
        int v2 = this.idx(v);
        byteBuffer1.limit(v1 + v2).position(v2);
        byteBuffer1.put(byteBuffer0);
        return this;
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf setBytes(int v, byte[] arr_b, int v1, int v2) {
        this.checkSrcIndex(v, v2, v1, arr_b.length);
        this._internalNioBuffer(v, v2, false).put(arr_b, v1, v2);
        return this;
    }
}

