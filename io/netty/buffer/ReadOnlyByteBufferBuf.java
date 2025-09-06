package io.netty.buffer;

import io.netty.util.internal.StringUtil;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ReadOnlyBufferException;
import java.nio.channels.FileChannel;
import java.nio.channels.GatheringByteChannel;
import java.nio.channels.ScatteringByteChannel;

class ReadOnlyByteBufferBuf extends AbstractReferenceCountedByteBuf {
    private final ByteBufAllocator allocator;
    protected final ByteBuffer buffer;
    private ByteBuffer tmpNioBuf;

    public ReadOnlyByteBufferBuf(ByteBufAllocator byteBufAllocator0, ByteBuffer byteBuffer0) {
        super(byteBuffer0.remaining());
        if(!byteBuffer0.isReadOnly()) {
            throw new IllegalArgumentException("must be a readonly buffer: " + StringUtil.simpleClassName(byteBuffer0));
        }
        this.allocator = byteBufAllocator0;
        ByteBuffer byteBuffer1 = byteBuffer0.slice().order(ByteOrder.BIG_ENDIAN);
        this.buffer = byteBuffer1;
        this.writerIndex(byteBuffer1.limit());
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public byte _getByte(int v) {
        return this.buffer.get(v);
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public int _getInt(int v) {
        return this.buffer.getInt(v);
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public int _getIntLE(int v) {
        return ByteBufUtil.swapInt(this.buffer.getInt(v));
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public long _getLong(int v) {
        return this.buffer.getLong(v);
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public long _getLongLE(int v) {
        return ByteBufUtil.swapLong(this.buffer.getLong(v));
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public short _getShort(int v) {
        return this.buffer.getShort(v);
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public short _getShortLE(int v) {
        return ByteBufUtil.swapShort(this.buffer.getShort(v));
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public int _getUnsignedMedium(int v) {
        int v1 = this.getByte(v);
        int v2 = this.getByte(v + 1);
        return this.getByte(v + 2) & 0xFF | ((v1 & 0xFF) << 16 | (v2 & 0xFF) << 8);
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public int _getUnsignedMediumLE(int v) {
        int v1 = this.getByte(v);
        int v2 = this.getByte(v + 1);
        return (this.getByte(v + 2) & 0xFF) << 16 | (v1 & 0xFF | (v2 & 0xFF) << 8);
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public void _setByte(int v, int v1) {
        throw new ReadOnlyBufferException();
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public void _setInt(int v, int v1) {
        throw new ReadOnlyBufferException();
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public void _setIntLE(int v, int v1) {
        throw new ReadOnlyBufferException();
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public void _setLong(int v, long v1) {
        throw new ReadOnlyBufferException();
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public void _setLongLE(int v, long v1) {
        throw new ReadOnlyBufferException();
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public void _setMedium(int v, int v1) {
        throw new ReadOnlyBufferException();
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public void _setMediumLE(int v, int v1) {
        throw new ReadOnlyBufferException();
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public void _setShort(int v, int v1) {
        throw new ReadOnlyBufferException();
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public void _setShortLE(int v, int v1) {
        throw new ReadOnlyBufferException();
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBufAllocator alloc() {
        return this.allocator;
    }

    @Override  // io.netty.buffer.ByteBuf
    public byte[] array() {
        return this.buffer.array();
    }

    @Override  // io.netty.buffer.ByteBuf
    public int arrayOffset() {
        return this.buffer.arrayOffset();
    }

    @Override  // io.netty.buffer.ByteBuf
    public int capacity() {
        return this.maxCapacity();
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf capacity(int v) {
        throw new ReadOnlyBufferException();
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf copy(int v, int v1) {
        ByteBuffer byteBuffer0;
        this.ensureAccessible();
        try {
            byteBuffer0 = (ByteBuffer)this.internalNioBuffer().clear().position(v).limit(v + v1);
        }
        catch(IllegalArgumentException unused_ex) {
            throw new IndexOutOfBoundsException("Too many bytes to read - Need " + (v + v1));
        }
        ByteBuf byteBuf0 = byteBuffer0.isDirect() ? this.alloc().directBuffer(v1) : this.alloc().heapBuffer(v1);
        byteBuf0.writeBytes(byteBuffer0);
        return byteBuf0;
    }

    @Override  // io.netty.buffer.AbstractReferenceCountedByteBuf
    public void deallocate() {
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public int ensureWritable(int v, boolean z) {
        return 1;
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public ByteBuf ensureWritable(int v) {
        throw new ReadOnlyBufferException();
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public byte getByte(int v) {
        this.ensureAccessible();
        return this._getByte(v);
    }

    @Override  // io.netty.buffer.ByteBuf
    public int getBytes(int v, FileChannel fileChannel0, long v1, int v2) {
        this.ensureAccessible();
        if(v2 == 0) {
            return 0;
        }
        ByteBuffer byteBuffer0 = this.internalNioBuffer();
        byteBuffer0.clear().position(v).limit(v + v2);
        return fileChannel0.write(byteBuffer0, v1);
    }

    @Override  // io.netty.buffer.ByteBuf
    public int getBytes(int v, GatheringByteChannel gatheringByteChannel0, int v1) {
        this.ensureAccessible();
        if(v1 == 0) {
            return 0;
        }
        ByteBuffer byteBuffer0 = this.internalNioBuffer();
        byteBuffer0.clear().position(v).limit(v + v1);
        return gatheringByteChannel0.write(byteBuffer0);
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
        this.ensureAccessible();
        if(v1 == 0) {
            return this;
        }
        if(this.buffer.hasArray()) {
            outputStream0.write(this.buffer.array(), this.buffer.arrayOffset() + v, v1);
            return this;
        }
        byte[] arr_b = ByteBufUtil.threadLocalTempArray(v1);
        ByteBuffer byteBuffer0 = this.internalNioBuffer();
        byteBuffer0.clear().position(v);
        byteBuffer0.get(arr_b, 0, v1);
        outputStream0.write(arr_b, 0, v1);
        return this;
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int v, ByteBuffer byteBuffer0) {
        this.checkIndex(v, byteBuffer0.remaining());
        ByteBuffer byteBuffer1 = this.internalNioBuffer();
        byteBuffer1.clear().position(v).limit(byteBuffer0.remaining() + v);
        byteBuffer0.put(byteBuffer1);
        return this;
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int v, byte[] arr_b, int v1, int v2) {
        this.checkDstIndex(v, v2, v1, arr_b.length);
        ByteBuffer byteBuffer0 = this.internalNioBuffer();
        byteBuffer0.clear().position(v).limit(v + v2);
        byteBuffer0.get(arr_b, v1, v2);
        return this;
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public int getInt(int v) {
        this.ensureAccessible();
        return this._getInt(v);
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public int getIntLE(int v) {
        this.ensureAccessible();
        return this._getIntLE(v);
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public long getLong(int v) {
        this.ensureAccessible();
        return this._getLong(v);
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public long getLongLE(int v) {
        this.ensureAccessible();
        return this._getLongLE(v);
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public short getShort(int v) {
        this.ensureAccessible();
        return this._getShort(v);
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public short getShortLE(int v) {
        this.ensureAccessible();
        return this._getShortLE(v);
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public int getUnsignedMedium(int v) {
        this.ensureAccessible();
        return this._getUnsignedMedium(v);
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public int getUnsignedMediumLE(int v) {
        this.ensureAccessible();
        return this._getUnsignedMediumLE(v);
    }

    @Override  // io.netty.buffer.ByteBuf
    public boolean hasArray() {
        return this.buffer.hasArray();
    }

    @Override  // io.netty.buffer.ByteBuf
    public boolean hasMemoryAddress() {
        return false;
    }

    public final ByteBuffer internalNioBuffer() {
        ByteBuffer byteBuffer0 = this.tmpNioBuf;
        if(byteBuffer0 == null) {
            byteBuffer0 = this.buffer.duplicate();
            this.tmpNioBuf = byteBuffer0;
        }
        return byteBuffer0;
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuffer internalNioBuffer(int v, int v1) {
        this.ensureAccessible();
        return (ByteBuffer)this.internalNioBuffer().clear().position(v).limit(v + v1);
    }

    @Override  // io.netty.buffer.ByteBuf
    public final boolean isContiguous() {
        return true;
    }

    @Override  // io.netty.buffer.ByteBuf
    public boolean isDirect() {
        return this.buffer.isDirect();
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public boolean isReadOnly() {
        return this.buffer.isReadOnly();
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public boolean isWritable() {
        return false;
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public boolean isWritable(int v) {
        return false;
    }

    @Override  // io.netty.buffer.ByteBuf
    public long memoryAddress() {
        throw new UnsupportedOperationException();
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuffer nioBuffer(int v, int v1) {
        this.checkIndex(v, v1);
        return (ByteBuffer)this.buffer.duplicate().position(v).limit(v + v1);
    }

    @Override  // io.netty.buffer.ByteBuf
    public int nioBufferCount() {
        return 1;
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuffer[] nioBuffers(int v, int v1) {
        return new ByteBuffer[]{this.nioBuffer(v, v1)};
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteOrder order() {
        return ByteOrder.BIG_ENDIAN;
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public ByteBuf setByte(int v, int v1) {
        throw new ReadOnlyBufferException();
    }

    @Override  // io.netty.buffer.ByteBuf
    public int setBytes(int v, InputStream inputStream0, int v1) {
        throw new ReadOnlyBufferException();
    }

    @Override  // io.netty.buffer.ByteBuf
    public int setBytes(int v, FileChannel fileChannel0, long v1, int v2) {
        throw new ReadOnlyBufferException();
    }

    @Override  // io.netty.buffer.ByteBuf
    public int setBytes(int v, ScatteringByteChannel scatteringByteChannel0, int v1) {
        throw new ReadOnlyBufferException();
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf setBytes(int v, ByteBuf byteBuf0, int v1, int v2) {
        throw new ReadOnlyBufferException();
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf setBytes(int v, ByteBuffer byteBuffer0) {
        throw new ReadOnlyBufferException();
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf setBytes(int v, byte[] arr_b, int v1, int v2) {
        throw new ReadOnlyBufferException();
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public ByteBuf setInt(int v, int v1) {
        throw new ReadOnlyBufferException();
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public ByteBuf setIntLE(int v, int v1) {
        throw new ReadOnlyBufferException();
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public ByteBuf setLong(int v, long v1) {
        throw new ReadOnlyBufferException();
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public ByteBuf setLongLE(int v, long v1) {
        throw new ReadOnlyBufferException();
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public ByteBuf setMedium(int v, int v1) {
        throw new ReadOnlyBufferException();
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public ByteBuf setMediumLE(int v, int v1) {
        throw new ReadOnlyBufferException();
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public ByteBuf setShort(int v, int v1) {
        throw new ReadOnlyBufferException();
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public ByteBuf setShortLE(int v, int v1) {
        throw new ReadOnlyBufferException();
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf unwrap() {
        return null;
    }
}

