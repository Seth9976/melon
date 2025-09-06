package io.netty.buffer;

import io.netty.util.ResourceLeakTracker;
import io.netty.util.internal.ObjectUtil;
import java.nio.ByteOrder;

class SimpleLeakAwareCompositeByteBuf extends WrappedCompositeByteBuf {
    static final boolean $assertionsDisabled;
    final ResourceLeakTracker leak;

    public SimpleLeakAwareCompositeByteBuf(CompositeByteBuf compositeByteBuf0, ResourceLeakTracker resourceLeakTracker0) {
        super(compositeByteBuf0);
        this.leak = (ResourceLeakTracker)ObjectUtil.checkNotNull(resourceLeakTracker0, "leak");
    }

    @Override  // io.netty.buffer.WrappedCompositeByteBuf
    public ByteBuf asReadOnly() {
        return this.newLeakAwareByteBuf(super.asReadOnly());
    }

    private void closeLeak(ByteBuf byteBuf0) {
        this.leak.close(byteBuf0);
    }

    @Override  // io.netty.buffer.WrappedCompositeByteBuf
    public ByteBuf duplicate() {
        return this.newLeakAwareByteBuf(super.duplicate());
    }

    private SimpleLeakAwareByteBuf newLeakAwareByteBuf(ByteBuf byteBuf0) {
        return this.newLeakAwareByteBuf(byteBuf0, this.unwrap(), this.leak);
    }

    public SimpleLeakAwareByteBuf newLeakAwareByteBuf(ByteBuf byteBuf0, ByteBuf byteBuf1, ResourceLeakTracker resourceLeakTracker0) {
        return new SimpleLeakAwareByteBuf(byteBuf0, byteBuf1, resourceLeakTracker0);
    }

    @Override  // io.netty.buffer.WrappedCompositeByteBuf
    public ByteBuf order(ByteOrder byteOrder0) {
        return this.order() == byteOrder0 ? this : this.newLeakAwareByteBuf(super.order(byteOrder0));
    }

    @Override  // io.netty.buffer.WrappedCompositeByteBuf
    public ByteBuf readRetainedSlice(int v) {
        return this.newLeakAwareByteBuf(super.readRetainedSlice(v));
    }

    @Override  // io.netty.buffer.WrappedCompositeByteBuf
    public ByteBuf readSlice(int v) {
        return this.newLeakAwareByteBuf(super.readSlice(v));
    }

    @Override  // io.netty.buffer.WrappedCompositeByteBuf
    public boolean release() {
        ByteBuf byteBuf0 = this.unwrap();
        if(super.release()) {
            this.closeLeak(byteBuf0);
            return true;
        }
        return false;
    }

    @Override  // io.netty.buffer.WrappedCompositeByteBuf
    public boolean release(int v) {
        ByteBuf byteBuf0 = this.unwrap();
        if(super.release(v)) {
            this.closeLeak(byteBuf0);
            return true;
        }
        return false;
    }

    @Override  // io.netty.buffer.WrappedCompositeByteBuf
    public ByteBuf retainedDuplicate() {
        return this.newLeakAwareByteBuf(super.retainedDuplicate());
    }

    @Override  // io.netty.buffer.WrappedCompositeByteBuf
    public ByteBuf retainedSlice() {
        return this.newLeakAwareByteBuf(super.retainedSlice());
    }

    @Override  // io.netty.buffer.WrappedCompositeByteBuf
    public ByteBuf retainedSlice(int v, int v1) {
        return this.newLeakAwareByteBuf(super.retainedSlice(v, v1));
    }

    @Override  // io.netty.buffer.WrappedCompositeByteBuf
    public ByteBuf slice() {
        return this.newLeakAwareByteBuf(super.slice());
    }

    @Override  // io.netty.buffer.WrappedCompositeByteBuf
    public ByteBuf slice(int v, int v1) {
        return this.newLeakAwareByteBuf(super.slice(v, v1));
    }
}

