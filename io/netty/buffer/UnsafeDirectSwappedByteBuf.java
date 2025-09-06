package io.netty.buffer;

import io.netty.util.internal.PlatformDependent;

final class UnsafeDirectSwappedByteBuf extends AbstractUnsafeSwappedByteBuf {
    public UnsafeDirectSwappedByteBuf(AbstractByteBuf abstractByteBuf0) {
        super(abstractByteBuf0);
    }

    @Override  // io.netty.buffer.AbstractUnsafeSwappedByteBuf
    public int _getInt(AbstractByteBuf abstractByteBuf0, int v) {
        return PlatformDependent.getInt(UnsafeDirectSwappedByteBuf.addr(abstractByteBuf0, v));
    }

    @Override  // io.netty.buffer.AbstractUnsafeSwappedByteBuf
    public long _getLong(AbstractByteBuf abstractByteBuf0, int v) {
        return PlatformDependent.getLong(UnsafeDirectSwappedByteBuf.addr(abstractByteBuf0, v));
    }

    @Override  // io.netty.buffer.AbstractUnsafeSwappedByteBuf
    public short _getShort(AbstractByteBuf abstractByteBuf0, int v) {
        return PlatformDependent.getShort(UnsafeDirectSwappedByteBuf.addr(abstractByteBuf0, v));
    }

    @Override  // io.netty.buffer.AbstractUnsafeSwappedByteBuf
    public void _setInt(AbstractByteBuf abstractByteBuf0, int v, int v1) {
        PlatformDependent.putInt(UnsafeDirectSwappedByteBuf.addr(abstractByteBuf0, v), v1);
    }

    @Override  // io.netty.buffer.AbstractUnsafeSwappedByteBuf
    public void _setLong(AbstractByteBuf abstractByteBuf0, int v, long v1) {
        PlatformDependent.putLong(UnsafeDirectSwappedByteBuf.addr(abstractByteBuf0, v), v1);
    }

    @Override  // io.netty.buffer.AbstractUnsafeSwappedByteBuf
    public void _setShort(AbstractByteBuf abstractByteBuf0, int v, short v1) {
        PlatformDependent.putShort(UnsafeDirectSwappedByteBuf.addr(abstractByteBuf0, v), v1);
    }

    private static long addr(AbstractByteBuf abstractByteBuf0, int v) {
        return abstractByteBuf0.memoryAddress() + ((long)v);
    }
}

