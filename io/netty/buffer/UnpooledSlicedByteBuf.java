package io.netty.buffer;

class UnpooledSlicedByteBuf extends AbstractUnpooledSlicedByteBuf {
    public UnpooledSlicedByteBuf(AbstractByteBuf abstractByteBuf0, int v, int v1) {
        super(abstractByteBuf0, v, v1);
    }

    @Override  // io.netty.buffer.AbstractUnpooledSlicedByteBuf
    public byte _getByte(int v) {
        return this.unwrap()._getByte(this.idx(v));
    }

    @Override  // io.netty.buffer.AbstractUnpooledSlicedByteBuf
    public int _getInt(int v) {
        return this.unwrap()._getInt(this.idx(v));
    }

    @Override  // io.netty.buffer.AbstractUnpooledSlicedByteBuf
    public int _getIntLE(int v) {
        return this.unwrap()._getIntLE(this.idx(v));
    }

    @Override  // io.netty.buffer.AbstractUnpooledSlicedByteBuf
    public long _getLong(int v) {
        return this.unwrap()._getLong(this.idx(v));
    }

    @Override  // io.netty.buffer.AbstractUnpooledSlicedByteBuf
    public long _getLongLE(int v) {
        return this.unwrap()._getLongLE(this.idx(v));
    }

    @Override  // io.netty.buffer.AbstractUnpooledSlicedByteBuf
    public short _getShort(int v) {
        return this.unwrap()._getShort(this.idx(v));
    }

    @Override  // io.netty.buffer.AbstractUnpooledSlicedByteBuf
    public short _getShortLE(int v) {
        return this.unwrap()._getShortLE(this.idx(v));
    }

    @Override  // io.netty.buffer.AbstractUnpooledSlicedByteBuf
    public int _getUnsignedMedium(int v) {
        return this.unwrap()._getUnsignedMedium(this.idx(v));
    }

    @Override  // io.netty.buffer.AbstractUnpooledSlicedByteBuf
    public int _getUnsignedMediumLE(int v) {
        return this.unwrap()._getUnsignedMediumLE(this.idx(v));
    }

    @Override  // io.netty.buffer.AbstractUnpooledSlicedByteBuf
    public void _setByte(int v, int v1) {
        this.unwrap()._setByte(this.idx(v), v1);
    }

    @Override  // io.netty.buffer.AbstractUnpooledSlicedByteBuf
    public void _setInt(int v, int v1) {
        this.unwrap()._setInt(this.idx(v), v1);
    }

    @Override  // io.netty.buffer.AbstractUnpooledSlicedByteBuf
    public void _setIntLE(int v, int v1) {
        this.unwrap()._setIntLE(this.idx(v), v1);
    }

    @Override  // io.netty.buffer.AbstractUnpooledSlicedByteBuf
    public void _setLong(int v, long v1) {
        this.unwrap()._setLong(this.idx(v), v1);
    }

    @Override  // io.netty.buffer.AbstractUnpooledSlicedByteBuf
    public void _setLongLE(int v, long v1) {
        this.unwrap()._setLongLE(this.idx(v), v1);
    }

    @Override  // io.netty.buffer.AbstractUnpooledSlicedByteBuf
    public void _setMedium(int v, int v1) {
        this.unwrap()._setMedium(this.idx(v), v1);
    }

    @Override  // io.netty.buffer.AbstractUnpooledSlicedByteBuf
    public void _setMediumLE(int v, int v1) {
        this.unwrap()._setMediumLE(this.idx(v), v1);
    }

    @Override  // io.netty.buffer.AbstractUnpooledSlicedByteBuf
    public void _setShort(int v, int v1) {
        this.unwrap()._setShort(this.idx(v), v1);
    }

    @Override  // io.netty.buffer.AbstractUnpooledSlicedByteBuf
    public void _setShortLE(int v, int v1) {
        this.unwrap()._setShortLE(this.idx(v), v1);
    }

    @Override  // io.netty.buffer.ByteBuf
    public int capacity() {
        return this.maxCapacity();
    }

    public AbstractByteBuf unwrap() {
        return (AbstractByteBuf)super.unwrap();
    }

    @Override  // io.netty.buffer.AbstractUnpooledSlicedByteBuf
    public ByteBuf unwrap() {
        return this.unwrap();
    }
}

