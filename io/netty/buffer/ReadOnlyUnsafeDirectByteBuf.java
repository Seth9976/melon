package io.netty.buffer;

import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import java.nio.ByteBuffer;

final class ReadOnlyUnsafeDirectByteBuf extends ReadOnlyByteBufferBuf {
    private final long memoryAddress;

    public ReadOnlyUnsafeDirectByteBuf(ByteBufAllocator byteBufAllocator0, ByteBuffer byteBuffer0) {
        super(byteBufAllocator0, byteBuffer0);
        this.memoryAddress = PlatformDependent.directBufferAddress(this.buffer);
    }

    @Override  // io.netty.buffer.ReadOnlyByteBufferBuf
    public byte _getByte(int v) {
        return UnsafeByteBufUtil.getByte(this.addr(v));
    }

    @Override  // io.netty.buffer.ReadOnlyByteBufferBuf
    public int _getInt(int v) {
        return UnsafeByteBufUtil.getInt(this.addr(v));
    }

    @Override  // io.netty.buffer.ReadOnlyByteBufferBuf
    public long _getLong(int v) {
        return UnsafeByteBufUtil.getLong(this.addr(v));
    }

    @Override  // io.netty.buffer.ReadOnlyByteBufferBuf
    public short _getShort(int v) {
        return UnsafeByteBufUtil.getShort(this.addr(v));
    }

    @Override  // io.netty.buffer.ReadOnlyByteBufferBuf
    public int _getUnsignedMedium(int v) {
        return UnsafeByteBufUtil.getUnsignedMedium(this.addr(v));
    }

    private long addr(int v) {
        return this.memoryAddress + ((long)v);
    }

    @Override  // io.netty.buffer.ReadOnlyByteBufferBuf
    public ByteBuf copy(int v, int v1) {
        this.checkIndex(v, v1);
        ByteBuf byteBuf0 = this.alloc().directBuffer(v1, this.maxCapacity());
        if(v1 != 0) {
            if(byteBuf0.hasMemoryAddress()) {
                PlatformDependent.copyMemory(this.addr(v), byteBuf0.memoryAddress(), v1);
                byteBuf0.setIndex(0, v1);
                return byteBuf0;
            }
            byteBuf0.writeBytes(this, v, v1);
        }
        return byteBuf0;
    }

    @Override  // io.netty.buffer.ReadOnlyByteBufferBuf
    public ByteBuf getBytes(int v, ByteBuf byteBuf0, int v1, int v2) {
        this.checkIndex(v, v2);
        ObjectUtil.checkNotNull(byteBuf0, "dst");
        if(v1 < 0 || v1 > byteBuf0.capacity() - v2) {
            throw new IndexOutOfBoundsException("dstIndex: " + v1);
        }
        if(byteBuf0.hasMemoryAddress()) {
            PlatformDependent.copyMemory(this.addr(v), ((long)v1) + byteBuf0.memoryAddress(), v2);
            return this;
        }
        if(byteBuf0.hasArray()) {
            PlatformDependent.copyMemory(this.addr(v), byteBuf0.array(), byteBuf0.arrayOffset() + v1, v2);
            return this;
        }
        byteBuf0.setBytes(v1, this, v, v2);
        return this;
    }

    @Override  // io.netty.buffer.ReadOnlyByteBufferBuf
    public ByteBuf getBytes(int v, byte[] arr_b, int v1, int v2) {
        this.checkIndex(v, v2);
        ObjectUtil.checkNotNull(arr_b, "dst");
        if(v1 < 0 || v1 > arr_b.length - v2) {
            throw new IndexOutOfBoundsException(String.format("dstIndex: %d, length: %d (expected: range(0, %d))", v1, v2, ((int)arr_b.length)));
        }
        if(v2 != 0) {
            PlatformDependent.copyMemory(this.addr(v), arr_b, v1, v2);
        }
        return this;
    }

    @Override  // io.netty.buffer.ReadOnlyByteBufferBuf
    public boolean hasMemoryAddress() {
        return true;
    }

    @Override  // io.netty.buffer.ReadOnlyByteBufferBuf
    public long memoryAddress() {
        return this.memoryAddress;
    }
}

