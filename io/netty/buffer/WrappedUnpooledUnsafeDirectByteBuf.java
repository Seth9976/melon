package io.netty.buffer;

import io.netty.util.internal.PlatformDependent;
import java.nio.ByteBuffer;

final class WrappedUnpooledUnsafeDirectByteBuf extends UnpooledUnsafeDirectByteBuf {
    public WrappedUnpooledUnsafeDirectByteBuf(ByteBufAllocator byteBufAllocator0, long v, int v1, boolean z) {
        super(byteBufAllocator0, PlatformDependent.directBuffer(v, v1), v1, z);
    }

    @Override  // io.netty.buffer.UnpooledDirectByteBuf
    public void freeDirect(ByteBuffer byteBuffer0) {
        PlatformDependent.freeMemory(this.memoryAddress);
    }
}

