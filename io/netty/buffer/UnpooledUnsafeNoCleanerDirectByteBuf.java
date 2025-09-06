package io.netty.buffer;

import io.netty.util.internal.PlatformDependent;
import java.nio.ByteBuffer;

class UnpooledUnsafeNoCleanerDirectByteBuf extends UnpooledUnsafeDirectByteBuf {
    public UnpooledUnsafeNoCleanerDirectByteBuf(ByteBufAllocator byteBufAllocator0, int v, int v1) {
        super(byteBufAllocator0, v, v1);
    }

    @Override  // io.netty.buffer.UnpooledDirectByteBuf
    public ByteBuffer allocateDirect(int v) {
        return PlatformDependent.allocateDirectNoCleaner(v);
    }

    @Override  // io.netty.buffer.UnpooledDirectByteBuf
    public ByteBuf capacity(int v) {
        this.checkNewCapacity(v);
        if(v == this.capacity()) {
            return this;
        }
        this.trimIndicesToCapacity(v);
        this.setByteBuffer(this.reallocateDirect(this.buffer, v), false);
        return this;
    }

    @Override  // io.netty.buffer.UnpooledDirectByteBuf
    public void freeDirect(ByteBuffer byteBuffer0) {
        PlatformDependent.freeDirectNoCleaner(byteBuffer0);
    }

    public ByteBuffer reallocateDirect(ByteBuffer byteBuffer0, int v) {
        return PlatformDependent.reallocateDirectNoCleaner(byteBuffer0, v);
    }
}

