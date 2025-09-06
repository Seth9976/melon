package io.netty.buffer;

import io.netty.util.internal.PlatformDependent;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;

public class UnpooledUnsafeDirectByteBuf extends UnpooledDirectByteBuf {
    long memoryAddress;

    public UnpooledUnsafeDirectByteBuf(ByteBufAllocator byteBufAllocator0, int v, int v1) {
        super(byteBufAllocator0, v, v1);
    }

    public UnpooledUnsafeDirectByteBuf(ByteBufAllocator byteBufAllocator0, ByteBuffer byteBuffer0, int v) {
        super(byteBufAllocator0, byteBuffer0, v, false, true);
    }

    public UnpooledUnsafeDirectByteBuf(ByteBufAllocator byteBufAllocator0, ByteBuffer byteBuffer0, int v, boolean z) {
        super(byteBufAllocator0, byteBuffer0, v, z, false);
    }

    @Override  // io.netty.buffer.UnpooledDirectByteBuf
    public byte _getByte(int v) {
        return UnsafeByteBufUtil.getByte(this.addr(v));
    }

    @Override  // io.netty.buffer.UnpooledDirectByteBuf
    public int _getInt(int v) {
        return UnsafeByteBufUtil.getInt(this.addr(v));
    }

    @Override  // io.netty.buffer.UnpooledDirectByteBuf
    public int _getIntLE(int v) {
        return UnsafeByteBufUtil.getIntLE(this.addr(v));
    }

    @Override  // io.netty.buffer.UnpooledDirectByteBuf
    public long _getLong(int v) {
        return UnsafeByteBufUtil.getLong(this.addr(v));
    }

    @Override  // io.netty.buffer.UnpooledDirectByteBuf
    public long _getLongLE(int v) {
        return UnsafeByteBufUtil.getLongLE(this.addr(v));
    }

    @Override  // io.netty.buffer.UnpooledDirectByteBuf
    public short _getShort(int v) {
        return UnsafeByteBufUtil.getShort(this.addr(v));
    }

    @Override  // io.netty.buffer.UnpooledDirectByteBuf
    public short _getShortLE(int v) {
        return UnsafeByteBufUtil.getShortLE(this.addr(v));
    }

    @Override  // io.netty.buffer.UnpooledDirectByteBuf
    public int _getUnsignedMedium(int v) {
        return UnsafeByteBufUtil.getUnsignedMedium(this.addr(v));
    }

    @Override  // io.netty.buffer.UnpooledDirectByteBuf
    public int _getUnsignedMediumLE(int v) {
        return UnsafeByteBufUtil.getUnsignedMediumLE(this.addr(v));
    }

    @Override  // io.netty.buffer.UnpooledDirectByteBuf
    public void _setByte(int v, int v1) {
        UnsafeByteBufUtil.setByte(this.addr(v), v1);
    }

    @Override  // io.netty.buffer.UnpooledDirectByteBuf
    public void _setInt(int v, int v1) {
        UnsafeByteBufUtil.setInt(this.addr(v), v1);
    }

    @Override  // io.netty.buffer.UnpooledDirectByteBuf
    public void _setIntLE(int v, int v1) {
        UnsafeByteBufUtil.setIntLE(this.addr(v), v1);
    }

    @Override  // io.netty.buffer.UnpooledDirectByteBuf
    public void _setLong(int v, long v1) {
        UnsafeByteBufUtil.setLong(this.addr(v), v1);
    }

    @Override  // io.netty.buffer.UnpooledDirectByteBuf
    public void _setLongLE(int v, long v1) {
        UnsafeByteBufUtil.setLongLE(this.addr(v), v1);
    }

    @Override  // io.netty.buffer.UnpooledDirectByteBuf
    public void _setMedium(int v, int v1) {
        UnsafeByteBufUtil.setMedium(this.addr(v), v1);
    }

    @Override  // io.netty.buffer.UnpooledDirectByteBuf
    public void _setMediumLE(int v, int v1) {
        UnsafeByteBufUtil.setMediumLE(this.addr(v), v1);
    }

    @Override  // io.netty.buffer.UnpooledDirectByteBuf
    public void _setShort(int v, int v1) {
        UnsafeByteBufUtil.setShort(this.addr(v), v1);
    }

    @Override  // io.netty.buffer.UnpooledDirectByteBuf
    public void _setShortLE(int v, int v1) {
        UnsafeByteBufUtil.setShortLE(this.addr(v), v1);
    }

    public final long addr(int v) {
        return this.memoryAddress + ((long)v);
    }

    @Override  // io.netty.buffer.UnpooledDirectByteBuf
    public ByteBuf copy(int v, int v1) {
        return UnsafeByteBufUtil.copy(this, this.addr(v), v, v1);
    }

    @Override  // io.netty.buffer.UnpooledDirectByteBuf
    public byte getByte(int v) {
        this.checkIndex(v);
        return this._getByte(v);
    }

    @Override  // io.netty.buffer.UnpooledDirectByteBuf
    public ByteBuf getBytes(int v, ByteBuf byteBuf0, int v1, int v2) {
        UnsafeByteBufUtil.getBytes(this, this.addr(v), v, byteBuf0, v1, v2);
        return this;
    }

    @Override  // io.netty.buffer.UnpooledDirectByteBuf
    public void getBytes(int v, OutputStream outputStream0, int v1, boolean z) {
        UnsafeByteBufUtil.getBytes(this, this.addr(v), v, outputStream0, v1);
    }

    @Override  // io.netty.buffer.UnpooledDirectByteBuf
    public void getBytes(int v, ByteBuffer byteBuffer0, boolean z) {
        UnsafeByteBufUtil.getBytes(this, this.addr(v), v, byteBuffer0);
    }

    @Override  // io.netty.buffer.UnpooledDirectByteBuf
    public void getBytes(int v, byte[] arr_b, int v1, int v2, boolean z) {
        UnsafeByteBufUtil.getBytes(this, this.addr(v), v, arr_b, v1, v2);
    }

    @Override  // io.netty.buffer.UnpooledDirectByteBuf
    public int getInt(int v) {
        this.checkIndex(v, 4);
        return this._getInt(v);
    }

    @Override  // io.netty.buffer.UnpooledDirectByteBuf
    public long getLong(int v) {
        this.checkIndex(v, 8);
        return this._getLong(v);
    }

    @Override  // io.netty.buffer.UnpooledDirectByteBuf
    public short getShort(int v) {
        this.checkIndex(v, 2);
        return this._getShort(v);
    }

    @Override  // io.netty.buffer.UnpooledDirectByteBuf
    public int getUnsignedMedium(int v) {
        this.checkIndex(v, 3);
        return this._getUnsignedMedium(v);
    }

    @Override  // io.netty.buffer.UnpooledDirectByteBuf
    public boolean hasMemoryAddress() {
        return true;
    }

    @Override  // io.netty.buffer.UnpooledDirectByteBuf
    public long memoryAddress() {
        this.ensureAccessible();
        return this.memoryAddress;
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public SwappedByteBuf newSwappedByteBuf() {
        return PlatformDependent.isUnaligned() ? new UnsafeDirectSwappedByteBuf(this) : super.newSwappedByteBuf();
    }

    @Override  // io.netty.buffer.UnpooledDirectByteBuf
    public ByteBuf setByte(int v, int v1) {
        this.checkIndex(v);
        this._setByte(v, v1);
        return this;
    }

    @Override  // io.netty.buffer.UnpooledDirectByteBuf
    public final void setByteBuffer(ByteBuffer byteBuffer0, boolean z) {
        super.setByteBuffer(byteBuffer0, z);
        this.memoryAddress = PlatformDependent.directBufferAddress(byteBuffer0);
    }

    @Override  // io.netty.buffer.UnpooledDirectByteBuf
    public int setBytes(int v, InputStream inputStream0, int v1) {
        return UnsafeByteBufUtil.setBytes(this, this.addr(v), v, inputStream0, v1);
    }

    @Override  // io.netty.buffer.UnpooledDirectByteBuf
    public ByteBuf setBytes(int v, ByteBuf byteBuf0, int v1, int v2) {
        UnsafeByteBufUtil.setBytes(this, this.addr(v), v, byteBuf0, v1, v2);
        return this;
    }

    @Override  // io.netty.buffer.UnpooledDirectByteBuf
    public ByteBuf setBytes(int v, ByteBuffer byteBuffer0) {
        UnsafeByteBufUtil.setBytes(this, this.addr(v), v, byteBuffer0);
        return this;
    }

    @Override  // io.netty.buffer.UnpooledDirectByteBuf
    public ByteBuf setBytes(int v, byte[] arr_b, int v1, int v2) {
        UnsafeByteBufUtil.setBytes(this, this.addr(v), v, arr_b, v1, v2);
        return this;
    }

    @Override  // io.netty.buffer.UnpooledDirectByteBuf
    public ByteBuf setInt(int v, int v1) {
        this.checkIndex(v, 4);
        this._setInt(v, v1);
        return this;
    }

    @Override  // io.netty.buffer.UnpooledDirectByteBuf
    public ByteBuf setLong(int v, long v1) {
        this.checkIndex(v, 8);
        this._setLong(v, v1);
        return this;
    }

    @Override  // io.netty.buffer.UnpooledDirectByteBuf
    public ByteBuf setMedium(int v, int v1) {
        this.checkIndex(v, 3);
        this._setMedium(v, v1);
        return this;
    }

    @Override  // io.netty.buffer.UnpooledDirectByteBuf
    public ByteBuf setShort(int v, int v1) {
        this.checkIndex(v, 2);
        this._setShort(v, v1);
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

