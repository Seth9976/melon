package io.netty.channel;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.CompositeByteBuf;
import io.netty.util.internal.ObjectUtil;

public final class PreferHeapByteBufAllocator implements ByteBufAllocator {
    private final ByteBufAllocator allocator;

    public PreferHeapByteBufAllocator(ByteBufAllocator byteBufAllocator0) {
        this.allocator = (ByteBufAllocator)ObjectUtil.checkNotNull(byteBufAllocator0, "allocator");
    }

    @Override  // io.netty.buffer.ByteBufAllocator
    public ByteBuf buffer() {
        return this.allocator.heapBuffer();
    }

    @Override  // io.netty.buffer.ByteBufAllocator
    public ByteBuf buffer(int v) {
        return this.allocator.heapBuffer(v);
    }

    @Override  // io.netty.buffer.ByteBufAllocator
    public ByteBuf buffer(int v, int v1) {
        return this.allocator.heapBuffer(v, v1);
    }

    @Override  // io.netty.buffer.ByteBufAllocator
    public int calculateNewCapacity(int v, int v1) {
        return this.allocator.calculateNewCapacity(v, v1);
    }

    @Override  // io.netty.buffer.ByteBufAllocator
    public CompositeByteBuf compositeBuffer() {
        return this.allocator.compositeHeapBuffer();
    }

    @Override  // io.netty.buffer.ByteBufAllocator
    public CompositeByteBuf compositeBuffer(int v) {
        return this.allocator.compositeHeapBuffer(v);
    }

    @Override  // io.netty.buffer.ByteBufAllocator
    public CompositeByteBuf compositeDirectBuffer() {
        return this.allocator.compositeDirectBuffer();
    }

    @Override  // io.netty.buffer.ByteBufAllocator
    public CompositeByteBuf compositeDirectBuffer(int v) {
        return this.allocator.compositeDirectBuffer(v);
    }

    @Override  // io.netty.buffer.ByteBufAllocator
    public CompositeByteBuf compositeHeapBuffer() {
        return this.allocator.compositeHeapBuffer();
    }

    @Override  // io.netty.buffer.ByteBufAllocator
    public CompositeByteBuf compositeHeapBuffer(int v) {
        return this.allocator.compositeHeapBuffer(v);
    }

    @Override  // io.netty.buffer.ByteBufAllocator
    public ByteBuf directBuffer() {
        return this.allocator.directBuffer();
    }

    @Override  // io.netty.buffer.ByteBufAllocator
    public ByteBuf directBuffer(int v) {
        return this.allocator.directBuffer(v);
    }

    @Override  // io.netty.buffer.ByteBufAllocator
    public ByteBuf directBuffer(int v, int v1) {
        return this.allocator.directBuffer(v, v1);
    }

    @Override  // io.netty.buffer.ByteBufAllocator
    public ByteBuf heapBuffer() {
        return this.allocator.heapBuffer();
    }

    @Override  // io.netty.buffer.ByteBufAllocator
    public ByteBuf heapBuffer(int v) {
        return this.allocator.heapBuffer(v);
    }

    @Override  // io.netty.buffer.ByteBufAllocator
    public ByteBuf heapBuffer(int v, int v1) {
        return this.allocator.heapBuffer(v, v1);
    }

    @Override  // io.netty.buffer.ByteBufAllocator
    public ByteBuf ioBuffer() {
        return this.allocator.heapBuffer();
    }

    @Override  // io.netty.buffer.ByteBufAllocator
    public ByteBuf ioBuffer(int v) {
        return this.allocator.heapBuffer(v);
    }

    @Override  // io.netty.buffer.ByteBufAllocator
    public ByteBuf ioBuffer(int v, int v1) {
        return this.allocator.heapBuffer(v, v1);
    }

    @Override  // io.netty.buffer.ByteBufAllocator
    public boolean isDirectBufferPooled() {
        return this.allocator.isDirectBufferPooled();
    }
}

