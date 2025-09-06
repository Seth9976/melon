package io.netty.buffer;

import io.netty.util.internal.EmptyArrays;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.FileChannel;
import java.nio.channels.GatheringByteChannel;
import java.nio.channels.ScatteringByteChannel;

public class UnpooledHeapByteBuf extends AbstractReferenceCountedByteBuf {
    private final ByteBufAllocator alloc;
    byte[] array;
    private ByteBuffer tmpNioBuf;

    public UnpooledHeapByteBuf(ByteBufAllocator byteBufAllocator0, int v, int v1) {
        super(v1);
        if(v > v1) {
            throw new IllegalArgumentException(String.format("initialCapacity(%d) > maxCapacity(%d)", v, v1));
        }
        this.alloc = (ByteBufAllocator)ObjectUtil.checkNotNull(byteBufAllocator0, "alloc");
        this.setArray(this.allocateArray(v));
        this.setIndex(0, 0);
    }

    public UnpooledHeapByteBuf(ByteBufAllocator byteBufAllocator0, byte[] arr_b, int v) {
        super(v);
        ObjectUtil.checkNotNull(byteBufAllocator0, "alloc");
        ObjectUtil.checkNotNull(arr_b, "initialArray");
        if(arr_b.length > v) {
            throw new IllegalArgumentException(String.format("initialCapacity(%d) > maxCapacity(%d)", ((int)arr_b.length), v));
        }
        this.alloc = byteBufAllocator0;
        this.setArray(arr_b);
        this.setIndex(0, arr_b.length);
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public byte _getByte(int v) {
        return HeapByteBufUtil.getByte(this.array, v);
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public int _getInt(int v) {
        return HeapByteBufUtil.getInt(this.array, v);
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public int _getIntLE(int v) {
        return HeapByteBufUtil.getIntLE(this.array, v);
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public long _getLong(int v) {
        return HeapByteBufUtil.getLong(this.array, v);
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public long _getLongLE(int v) {
        return HeapByteBufUtil.getLongLE(this.array, v);
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public short _getShort(int v) {
        return HeapByteBufUtil.getShort(this.array, v);
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public short _getShortLE(int v) {
        return HeapByteBufUtil.getShortLE(this.array, v);
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public int _getUnsignedMedium(int v) {
        return HeapByteBufUtil.getUnsignedMedium(this.array, v);
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public int _getUnsignedMediumLE(int v) {
        return HeapByteBufUtil.getUnsignedMediumLE(this.array, v);
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public void _setByte(int v, int v1) {
        HeapByteBufUtil.setByte(this.array, v, v1);
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public void _setInt(int v, int v1) {
        HeapByteBufUtil.setInt(this.array, v, v1);
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public void _setIntLE(int v, int v1) {
        HeapByteBufUtil.setIntLE(this.array, v, v1);
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public void _setLong(int v, long v1) {
        HeapByteBufUtil.setLong(this.array, v, v1);
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public void _setLongLE(int v, long v1) {
        HeapByteBufUtil.setLongLE(this.array, v, v1);
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public void _setMedium(int v, int v1) {
        HeapByteBufUtil.setMedium(this.array, v, v1);
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public void _setMediumLE(int v, int v1) {
        HeapByteBufUtil.setMediumLE(this.array, v, v1);
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public void _setShort(int v, int v1) {
        HeapByteBufUtil.setShort(this.array, v, v1);
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public void _setShortLE(int v, int v1) {
        HeapByteBufUtil.setShortLE(this.array, v, v1);
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBufAllocator alloc() {
        return this.alloc;
    }

    public byte[] allocateArray(int v) {
        return new byte[v];
    }

    @Override  // io.netty.buffer.ByteBuf
    public byte[] array() {
        this.ensureAccessible();
        return this.array;
    }

    @Override  // io.netty.buffer.ByteBuf
    public int arrayOffset() {
        return 0;
    }

    @Override  // io.netty.buffer.ByteBuf
    public int capacity() {
        return this.array.length;
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf capacity(int v) {
        this.checkNewCapacity(v);
        byte[] arr_b = this.array;
        int v1 = arr_b.length;
        if(v == v1) {
            return this;
        }
        if(v <= v1) {
            this.trimIndicesToCapacity(v);
            v1 = v;
        }
        byte[] arr_b1 = this.allocateArray(v);
        System.arraycopy(arr_b, 0, arr_b1, 0, v1);
        this.setArray(arr_b1);
        this.freeArray(arr_b);
        return this;
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf copy(int v, int v1) {
        this.checkIndex(v, v1);
        return this.alloc().heapBuffer(v1, this.maxCapacity()).writeBytes(this.array, v, v1);
    }

    @Override  // io.netty.buffer.AbstractReferenceCountedByteBuf
    public void deallocate() {
        this.freeArray(this.array);
        this.array = EmptyArrays.EMPTY_BYTES;
    }

    public void freeArray(byte[] arr_b) {
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public byte getByte(int v) {
        this.ensureAccessible();
        return this._getByte(v);
    }

    private int getBytes(int v, FileChannel fileChannel0, long v1, int v2, boolean z) {
        this.ensureAccessible();
        return z ? fileChannel0.write(((ByteBuffer)this.internalNioBuffer().clear().position(v).limit(v + v2)), v1) : fileChannel0.write(((ByteBuffer)ByteBuffer.wrap(this.array).clear().position(v).limit(v + v2)), v1);
    }

    private int getBytes(int v, GatheringByteChannel gatheringByteChannel0, int v1, boolean z) {
        this.ensureAccessible();
        return z ? gatheringByteChannel0.write(((ByteBuffer)this.internalNioBuffer().clear().position(v).limit(v + v1))) : gatheringByteChannel0.write(((ByteBuffer)ByteBuffer.wrap(this.array).clear().position(v).limit(v + v1)));
    }

    @Override  // io.netty.buffer.ByteBuf
    public int getBytes(int v, FileChannel fileChannel0, long v1, int v2) {
        this.ensureAccessible();
        return this.getBytes(v, fileChannel0, v1, v2, false);
    }

    @Override  // io.netty.buffer.ByteBuf
    public int getBytes(int v, GatheringByteChannel gatheringByteChannel0, int v1) {
        this.ensureAccessible();
        return this.getBytes(v, gatheringByteChannel0, v1, false);
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int v, ByteBuf byteBuf0, int v1, int v2) {
        this.checkDstIndex(v, v2, v1, byteBuf0.capacity());
        if(byteBuf0.hasMemoryAddress()) {
            PlatformDependent.copyMemory(this.array, v, byteBuf0.memoryAddress() + ((long)v1), ((long)v2));
            return this;
        }
        if(byteBuf0.hasArray()) {
            this.getBytes(v, byteBuf0.array(), byteBuf0.arrayOffset() + v1, v2);
            return this;
        }
        byteBuf0.setBytes(v1, this.array, v, v2);
        return this;
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int v, OutputStream outputStream0, int v1) {
        this.ensureAccessible();
        outputStream0.write(this.array, v, v1);
        return this;
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int v, ByteBuffer byteBuffer0) {
        this.ensureAccessible();
        byteBuffer0.put(this.array, v, byteBuffer0.remaining());
        return this;
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int v, byte[] arr_b, int v1, int v2) {
        this.checkDstIndex(v, v2, v1, arr_b.length);
        System.arraycopy(this.array, v, arr_b, v1, v2);
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
        return true;
    }

    @Override  // io.netty.buffer.ByteBuf
    public boolean hasMemoryAddress() {
        return false;
    }

    private ByteBuffer internalNioBuffer() {
        ByteBuffer byteBuffer0 = this.tmpNioBuf;
        if(byteBuffer0 == null) {
            byteBuffer0 = ByteBuffer.wrap(this.array);
            this.tmpNioBuf = byteBuffer0;
        }
        return byteBuffer0;
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuffer internalNioBuffer(int v, int v1) {
        this.checkIndex(v, v1);
        return (ByteBuffer)this.internalNioBuffer().clear().position(v).limit(v + v1);
    }

    @Override  // io.netty.buffer.ByteBuf
    public final boolean isContiguous() {
        return true;
    }

    @Override  // io.netty.buffer.ByteBuf
    public boolean isDirect() {
        return false;
    }

    @Override  // io.netty.buffer.ByteBuf
    public long memoryAddress() {
        throw new UnsupportedOperationException();
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuffer nioBuffer(int v, int v1) {
        this.ensureAccessible();
        return ByteBuffer.wrap(this.array, v, v1).slice();
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
    public int readBytes(FileChannel fileChannel0, long v, int v1) {
        this.checkReadableBytes(v1);
        int v2 = this.getBytes(this.readerIndex, fileChannel0, v, v1, true);
        this.readerIndex += v2;
        return v2;
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public int readBytes(GatheringByteChannel gatheringByteChannel0, int v) {
        this.checkReadableBytes(v);
        int v1 = this.getBytes(this.readerIndex, gatheringByteChannel0, v, true);
        this.readerIndex += v1;
        return v1;
    }

    private void setArray(byte[] arr_b) {
        this.array = arr_b;
        this.tmpNioBuf = null;
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public ByteBuf setByte(int v, int v1) {
        this.ensureAccessible();
        this._setByte(v, v1);
        return this;
    }

    @Override  // io.netty.buffer.ByteBuf
    public int setBytes(int v, InputStream inputStream0, int v1) {
        this.ensureAccessible();
        return inputStream0.read(this.array, v, v1);
    }

    @Override  // io.netty.buffer.ByteBuf
    public int setBytes(int v, FileChannel fileChannel0, long v1, int v2) {
        this.ensureAccessible();
        try {
            return fileChannel0.read(((ByteBuffer)this.internalNioBuffer().clear().position(v).limit(v + v2)), v1);
        }
        catch(ClosedChannelException unused_ex) {
            return -1;
        }
    }

    @Override  // io.netty.buffer.ByteBuf
    public int setBytes(int v, ScatteringByteChannel scatteringByteChannel0, int v1) {
        this.ensureAccessible();
        try {
            return scatteringByteChannel0.read(((ByteBuffer)this.internalNioBuffer().clear().position(v).limit(v + v1)));
        }
        catch(ClosedChannelException unused_ex) {
            return -1;
        }
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf setBytes(int v, ByteBuf byteBuf0, int v1, int v2) {
        this.checkSrcIndex(v, v2, v1, byteBuf0.capacity());
        if(byteBuf0.hasMemoryAddress()) {
            PlatformDependent.copyMemory(byteBuf0.memoryAddress() + ((long)v1), this.array, v, v2);
            return this;
        }
        if(byteBuf0.hasArray()) {
            this.setBytes(v, byteBuf0.array(), byteBuf0.arrayOffset() + v1, v2);
            return this;
        }
        byteBuf0.getBytes(v1, this.array, v, v2);
        return this;
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf setBytes(int v, ByteBuffer byteBuffer0) {
        this.ensureAccessible();
        byteBuffer0.get(this.array, v, byteBuffer0.remaining());
        return this;
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf setBytes(int v, byte[] arr_b, int v1, int v2) {
        this.checkSrcIndex(v, v2, v1, arr_b.length);
        System.arraycopy(arr_b, v1, this.array, v, v2);
        return this;
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public ByteBuf setInt(int v, int v1) {
        this.ensureAccessible();
        this._setInt(v, v1);
        return this;
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public ByteBuf setIntLE(int v, int v1) {
        this.ensureAccessible();
        this._setIntLE(v, v1);
        return this;
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public ByteBuf setLong(int v, long v1) {
        this.ensureAccessible();
        this._setLong(v, v1);
        return this;
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public ByteBuf setLongLE(int v, long v1) {
        this.ensureAccessible();
        this._setLongLE(v, v1);
        return this;
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public ByteBuf setMedium(int v, int v1) {
        this.ensureAccessible();
        this._setMedium(v, v1);
        return this;
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public ByteBuf setMediumLE(int v, int v1) {
        this.ensureAccessible();
        this._setMediumLE(v, v1);
        return this;
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public ByteBuf setShort(int v, int v1) {
        this.ensureAccessible();
        this._setShort(v, v1);
        return this;
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public ByteBuf setShortLE(int v, int v1) {
        this.ensureAccessible();
        this._setShortLE(v, v1);
        return this;
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf unwrap() {
        return null;
    }
}

