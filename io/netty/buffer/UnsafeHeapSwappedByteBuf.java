package io.netty.buffer;

import io.netty.util.internal.PlatformDependent;

final class UnsafeHeapSwappedByteBuf extends AbstractUnsafeSwappedByteBuf {
    public UnsafeHeapSwappedByteBuf(AbstractByteBuf abstractByteBuf0) {
        super(abstractByteBuf0);
    }

    @Override  // io.netty.buffer.AbstractUnsafeSwappedByteBuf
    public int _getInt(AbstractByteBuf abstractByteBuf0, int v) {
        return PlatformDependent.getInt(abstractByteBuf0.array(), UnsafeHeapSwappedByteBuf.idx(abstractByteBuf0, v));
    }

    @Override  // io.netty.buffer.AbstractUnsafeSwappedByteBuf
    public long _getLong(AbstractByteBuf abstractByteBuf0, int v) {
        return PlatformDependent.getLong(abstractByteBuf0.array(), UnsafeHeapSwappedByteBuf.idx(abstractByteBuf0, v));
    }

    @Override  // io.netty.buffer.AbstractUnsafeSwappedByteBuf
    public short _getShort(AbstractByteBuf abstractByteBuf0, int v) {
        return PlatformDependent.getShort(abstractByteBuf0.array(), UnsafeHeapSwappedByteBuf.idx(abstractByteBuf0, v));
    }

    @Override  // io.netty.buffer.AbstractUnsafeSwappedByteBuf
    public void _setInt(AbstractByteBuf abstractByteBuf0, int v, int v1) {
        PlatformDependent.putInt(abstractByteBuf0.array(), UnsafeHeapSwappedByteBuf.idx(abstractByteBuf0, v), v1);
    }

    @Override  // io.netty.buffer.AbstractUnsafeSwappedByteBuf
    public void _setLong(AbstractByteBuf abstractByteBuf0, int v, long v1) {
        PlatformDependent.putLong(abstractByteBuf0.array(), UnsafeHeapSwappedByteBuf.idx(abstractByteBuf0, v), v1);
    }

    @Override  // io.netty.buffer.AbstractUnsafeSwappedByteBuf
    public void _setShort(AbstractByteBuf abstractByteBuf0, int v, short v1) {
        PlatformDependent.putShort(abstractByteBuf0.array(), UnsafeHeapSwappedByteBuf.idx(abstractByteBuf0, v), v1);
    }

    private static int idx(ByteBuf byteBuf0, int v) {
        return byteBuf0.arrayOffset() + v;
    }
}

