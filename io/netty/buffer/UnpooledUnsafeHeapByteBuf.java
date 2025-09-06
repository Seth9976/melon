package io.netty.buffer;

import io.netty.util.internal.PlatformDependent;

public class UnpooledUnsafeHeapByteBuf extends UnpooledHeapByteBuf {
    public UnpooledUnsafeHeapByteBuf(ByteBufAllocator byteBufAllocator0, int v, int v1) {
        super(byteBufAllocator0, v, v1);
    }

    @Override  // io.netty.buffer.UnpooledHeapByteBuf
    public byte _getByte(int v) {
        return UnsafeByteBufUtil.getByte(this.array, v);
    }

    @Override  // io.netty.buffer.UnpooledHeapByteBuf
    public int _getInt(int v) {
        return UnsafeByteBufUtil.getInt(this.array, v);
    }

    @Override  // io.netty.buffer.UnpooledHeapByteBuf
    public int _getIntLE(int v) {
        return UnsafeByteBufUtil.getIntLE(this.array, v);
    }

    @Override  // io.netty.buffer.UnpooledHeapByteBuf
    public long _getLong(int v) {
        return UnsafeByteBufUtil.getLong(this.array, v);
    }

    @Override  // io.netty.buffer.UnpooledHeapByteBuf
    public long _getLongLE(int v) {
        return UnsafeByteBufUtil.getLongLE(this.array, v);
    }

    @Override  // io.netty.buffer.UnpooledHeapByteBuf
    public short _getShort(int v) {
        return UnsafeByteBufUtil.getShort(this.array, v);
    }

    @Override  // io.netty.buffer.UnpooledHeapByteBuf
    public short _getShortLE(int v) {
        return UnsafeByteBufUtil.getShortLE(this.array, v);
    }

    @Override  // io.netty.buffer.UnpooledHeapByteBuf
    public int _getUnsignedMedium(int v) {
        return UnsafeByteBufUtil.getUnsignedMedium(this.array, v);
    }

    @Override  // io.netty.buffer.UnpooledHeapByteBuf
    public int _getUnsignedMediumLE(int v) {
        return UnsafeByteBufUtil.getUnsignedMediumLE(this.array, v);
    }

    @Override  // io.netty.buffer.UnpooledHeapByteBuf
    public void _setByte(int v, int v1) {
        UnsafeByteBufUtil.setByte(this.array, v, v1);
    }

    @Override  // io.netty.buffer.UnpooledHeapByteBuf
    public void _setInt(int v, int v1) {
        UnsafeByteBufUtil.setInt(this.array, v, v1);
    }

    @Override  // io.netty.buffer.UnpooledHeapByteBuf
    public void _setIntLE(int v, int v1) {
        UnsafeByteBufUtil.setIntLE(this.array, v, v1);
    }

    @Override  // io.netty.buffer.UnpooledHeapByteBuf
    public void _setLong(int v, long v1) {
        UnsafeByteBufUtil.setLong(this.array, v, v1);
    }

    @Override  // io.netty.buffer.UnpooledHeapByteBuf
    public void _setLongLE(int v, long v1) {
        UnsafeByteBufUtil.setLongLE(this.array, v, v1);
    }

    @Override  // io.netty.buffer.UnpooledHeapByteBuf
    public void _setMedium(int v, int v1) {
        UnsafeByteBufUtil.setMedium(this.array, v, v1);
    }

    @Override  // io.netty.buffer.UnpooledHeapByteBuf
    public void _setMediumLE(int v, int v1) {
        UnsafeByteBufUtil.setMediumLE(this.array, v, v1);
    }

    @Override  // io.netty.buffer.UnpooledHeapByteBuf
    public void _setShort(int v, int v1) {
        UnsafeByteBufUtil.setShort(this.array, v, v1);
    }

    @Override  // io.netty.buffer.UnpooledHeapByteBuf
    public void _setShortLE(int v, int v1) {
        UnsafeByteBufUtil.setShortLE(this.array, v, v1);
    }

    @Override  // io.netty.buffer.UnpooledHeapByteBuf
    public byte[] allocateArray(int v) {
        return PlatformDependent.allocateUninitializedArray(v);
    }

    @Override  // io.netty.buffer.UnpooledHeapByteBuf
    public byte getByte(int v) {
        this.checkIndex(v);
        return this._getByte(v);
    }

    @Override  // io.netty.buffer.UnpooledHeapByteBuf
    public int getInt(int v) {
        this.checkIndex(v, 4);
        return this._getInt(v);
    }

    @Override  // io.netty.buffer.UnpooledHeapByteBuf
    public int getIntLE(int v) {
        this.checkIndex(v, 4);
        return this._getIntLE(v);
    }

    @Override  // io.netty.buffer.UnpooledHeapByteBuf
    public long getLong(int v) {
        this.checkIndex(v, 8);
        return this._getLong(v);
    }

    @Override  // io.netty.buffer.UnpooledHeapByteBuf
    public long getLongLE(int v) {
        this.checkIndex(v, 8);
        return this._getLongLE(v);
    }

    @Override  // io.netty.buffer.UnpooledHeapByteBuf
    public short getShort(int v) {
        this.checkIndex(v, 2);
        return this._getShort(v);
    }

    @Override  // io.netty.buffer.UnpooledHeapByteBuf
    public short getShortLE(int v) {
        this.checkIndex(v, 2);
        return this._getShortLE(v);
    }

    @Override  // io.netty.buffer.UnpooledHeapByteBuf
    public int getUnsignedMedium(int v) {
        this.checkIndex(v, 3);
        return this._getUnsignedMedium(v);
    }

    @Override  // io.netty.buffer.UnpooledHeapByteBuf
    public int getUnsignedMediumLE(int v) {
        this.checkIndex(v, 3);
        return this._getUnsignedMediumLE(v);
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    @Deprecated
    public SwappedByteBuf newSwappedByteBuf() {
        return PlatformDependent.isUnaligned() ? new UnsafeHeapSwappedByteBuf(this) : super.newSwappedByteBuf();
    }

    @Override  // io.netty.buffer.UnpooledHeapByteBuf
    public ByteBuf setByte(int v, int v1) {
        this.checkIndex(v);
        this._setByte(v, v1);
        return this;
    }

    @Override  // io.netty.buffer.UnpooledHeapByteBuf
    public ByteBuf setInt(int v, int v1) {
        this.checkIndex(v, 4);
        this._setInt(v, v1);
        return this;
    }

    @Override  // io.netty.buffer.UnpooledHeapByteBuf
    public ByteBuf setIntLE(int v, int v1) {
        this.checkIndex(v, 4);
        this._setIntLE(v, v1);
        return this;
    }

    @Override  // io.netty.buffer.UnpooledHeapByteBuf
    public ByteBuf setLong(int v, long v1) {
        this.checkIndex(v, 8);
        this._setLong(v, v1);
        return this;
    }

    @Override  // io.netty.buffer.UnpooledHeapByteBuf
    public ByteBuf setLongLE(int v, long v1) {
        this.checkIndex(v, 8);
        this._setLongLE(v, v1);
        return this;
    }

    @Override  // io.netty.buffer.UnpooledHeapByteBuf
    public ByteBuf setMedium(int v, int v1) {
        this.checkIndex(v, 3);
        this._setMedium(v, v1);
        return this;
    }

    @Override  // io.netty.buffer.UnpooledHeapByteBuf
    public ByteBuf setMediumLE(int v, int v1) {
        this.checkIndex(v, 3);
        this._setMediumLE(v, v1);
        return this;
    }

    @Override  // io.netty.buffer.UnpooledHeapByteBuf
    public ByteBuf setShort(int v, int v1) {
        this.checkIndex(v, 2);
        this._setShort(v, v1);
        return this;
    }

    @Override  // io.netty.buffer.UnpooledHeapByteBuf
    public ByteBuf setShortLE(int v, int v1) {
        this.checkIndex(v, 2);
        this._setShortLE(v, v1);
        return this;
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public ByteBuf setZero(int v, int v1) {
        if(PlatformDependent.javaVersion() >= 7) {
            this.checkIndex(v, v1);
            UnsafeByteBufUtil.setZero(this.array, v, v1);
            return this;
        }
        return super.setZero(v, v1);
    }

    // 去混淆评级： 低(20)
    @Override  // io.netty.buffer.AbstractByteBuf
    public ByteBuf writeZero(int v) {
        return super.writeZero(v);
    }
}

