package io.netty.buffer;

class UnpooledDuplicatedByteBuf extends DuplicatedByteBuf {
    public UnpooledDuplicatedByteBuf(AbstractByteBuf abstractByteBuf0) {
        super(abstractByteBuf0);
    }

    @Override  // io.netty.buffer.DuplicatedByteBuf
    public byte _getByte(int v) {
        return this.unwrap()._getByte(v);
    }

    @Override  // io.netty.buffer.DuplicatedByteBuf
    public int _getInt(int v) {
        return this.unwrap()._getInt(v);
    }

    @Override  // io.netty.buffer.DuplicatedByteBuf
    public int _getIntLE(int v) {
        return this.unwrap()._getIntLE(v);
    }

    @Override  // io.netty.buffer.DuplicatedByteBuf
    public long _getLong(int v) {
        return this.unwrap()._getLong(v);
    }

    @Override  // io.netty.buffer.DuplicatedByteBuf
    public long _getLongLE(int v) {
        return this.unwrap()._getLongLE(v);
    }

    @Override  // io.netty.buffer.DuplicatedByteBuf
    public short _getShort(int v) {
        return this.unwrap()._getShort(v);
    }

    @Override  // io.netty.buffer.DuplicatedByteBuf
    public short _getShortLE(int v) {
        return this.unwrap()._getShortLE(v);
    }

    @Override  // io.netty.buffer.DuplicatedByteBuf
    public int _getUnsignedMedium(int v) {
        return this.unwrap()._getUnsignedMedium(v);
    }

    @Override  // io.netty.buffer.DuplicatedByteBuf
    public int _getUnsignedMediumLE(int v) {
        return this.unwrap()._getUnsignedMediumLE(v);
    }

    @Override  // io.netty.buffer.DuplicatedByteBuf
    public void _setByte(int v, int v1) {
        this.unwrap()._setByte(v, v1);
    }

    @Override  // io.netty.buffer.DuplicatedByteBuf
    public void _setInt(int v, int v1) {
        this.unwrap()._setInt(v, v1);
    }

    @Override  // io.netty.buffer.DuplicatedByteBuf
    public void _setIntLE(int v, int v1) {
        this.unwrap()._setIntLE(v, v1);
    }

    @Override  // io.netty.buffer.DuplicatedByteBuf
    public void _setLong(int v, long v1) {
        this.unwrap()._setLong(v, v1);
    }

    @Override  // io.netty.buffer.DuplicatedByteBuf
    public void _setLongLE(int v, long v1) {
        this.unwrap()._setLongLE(v, v1);
    }

    @Override  // io.netty.buffer.DuplicatedByteBuf
    public void _setMedium(int v, int v1) {
        this.unwrap()._setMedium(v, v1);
    }

    @Override  // io.netty.buffer.DuplicatedByteBuf
    public void _setMediumLE(int v, int v1) {
        this.unwrap()._setMediumLE(v, v1);
    }

    @Override  // io.netty.buffer.DuplicatedByteBuf
    public void _setShort(int v, int v1) {
        this.unwrap()._setShort(v, v1);
    }

    @Override  // io.netty.buffer.DuplicatedByteBuf
    public void _setShortLE(int v, int v1) {
        this.unwrap()._setShortLE(v, v1);
    }

    public AbstractByteBuf unwrap() {
        return (AbstractByteBuf)super.unwrap();
    }

    @Override  // io.netty.buffer.DuplicatedByteBuf
    public ByteBuf unwrap() {
        return this.unwrap();
    }
}

