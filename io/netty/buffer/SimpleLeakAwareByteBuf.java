package io.netty.buffer;

import io.netty.util.ReferenceCounted;
import io.netty.util.ResourceLeakTracker;
import io.netty.util.internal.ObjectUtil;
import java.nio.ByteOrder;

class SimpleLeakAwareByteBuf extends WrappedByteBuf {
    static final boolean $assertionsDisabled;
    final ResourceLeakTracker leak;
    private final ByteBuf trackedByteBuf;

    public SimpleLeakAwareByteBuf(ByteBuf byteBuf0, ByteBuf byteBuf1, ResourceLeakTracker resourceLeakTracker0) {
        super(byteBuf0);
        this.trackedByteBuf = (ByteBuf)ObjectUtil.checkNotNull(byteBuf1, "trackedByteBuf");
        this.leak = (ResourceLeakTracker)ObjectUtil.checkNotNull(resourceLeakTracker0, "leak");
    }

    public SimpleLeakAwareByteBuf(ByteBuf byteBuf0, ResourceLeakTracker resourceLeakTracker0) {
        this(byteBuf0, byteBuf0, resourceLeakTracker0);
    }

    @Override  // io.netty.buffer.WrappedByteBuf
    public ByteBuf asReadOnly() {
        return this.newSharedLeakAwareByteBuf(super.asReadOnly());
    }

    private void closeLeak() {
        this.leak.close(this.trackedByteBuf);
    }

    @Override  // io.netty.buffer.WrappedByteBuf
    public ByteBuf duplicate() {
        return this.newSharedLeakAwareByteBuf(super.duplicate());
    }

    private SimpleLeakAwareByteBuf newLeakAwareByteBuf(ByteBuf byteBuf0, ResourceLeakTracker resourceLeakTracker0) {
        return this.newLeakAwareByteBuf(byteBuf0, byteBuf0, resourceLeakTracker0);
    }

    public SimpleLeakAwareByteBuf newLeakAwareByteBuf(ByteBuf byteBuf0, ByteBuf byteBuf1, ResourceLeakTracker resourceLeakTracker0) {
        return new SimpleLeakAwareByteBuf(byteBuf0, byteBuf1, resourceLeakTracker0);
    }

    private SimpleLeakAwareByteBuf newSharedLeakAwareByteBuf(ByteBuf byteBuf0) {
        return this.newLeakAwareByteBuf(byteBuf0, this.trackedByteBuf, this.leak);
    }

    @Override  // io.netty.buffer.WrappedByteBuf
    public ByteBuf order(ByteOrder byteOrder0) {
        return this.order() == byteOrder0 ? this : this.newSharedLeakAwareByteBuf(super.order(byteOrder0));
    }

    @Override  // io.netty.buffer.WrappedByteBuf
    public ByteBuf readRetainedSlice(int v) {
        return this.unwrappedDerived(super.readRetainedSlice(v));
    }

    @Override  // io.netty.buffer.WrappedByteBuf
    public ByteBuf readSlice(int v) {
        return this.newSharedLeakAwareByteBuf(super.readSlice(v));
    }

    @Override  // io.netty.buffer.WrappedByteBuf
    public boolean release() {
        if(super.release()) {
            this.closeLeak();
            return true;
        }
        return false;
    }

    @Override  // io.netty.buffer.WrappedByteBuf
    public boolean release(int v) {
        if(super.release(v)) {
            this.closeLeak();
            return true;
        }
        return false;
    }

    @Override  // io.netty.buffer.WrappedByteBuf
    public ByteBuf retainedDuplicate() {
        return this.unwrappedDerived(super.retainedDuplicate());
    }

    @Override  // io.netty.buffer.WrappedByteBuf
    public ByteBuf retainedSlice() {
        return this.unwrappedDerived(super.retainedSlice());
    }

    @Override  // io.netty.buffer.WrappedByteBuf
    public ByteBuf retainedSlice(int v, int v1) {
        return this.unwrappedDerived(super.retainedSlice(v, v1));
    }

    @Override  // io.netty.buffer.WrappedByteBuf
    public ByteBuf slice() {
        return this.newSharedLeakAwareByteBuf(super.slice());
    }

    @Override  // io.netty.buffer.WrappedByteBuf
    public ByteBuf slice(int v, int v1) {
        return this.newSharedLeakAwareByteBuf(super.slice(v, v1));
    }

    @Override  // io.netty.buffer.WrappedByteBuf
    public ByteBuf touch() {
        return this;
    }

    @Override  // io.netty.buffer.WrappedByteBuf
    public ByteBuf touch(Object object0) {
        return this;
    }

    @Override  // io.netty.buffer.WrappedByteBuf
    public ReferenceCounted touch() {
        return this.touch();
    }

    @Override  // io.netty.buffer.WrappedByteBuf
    public ReferenceCounted touch(Object object0) {
        return this.touch(object0);
    }

    private static ByteBuf unwrapSwapped(ByteBuf byteBuf0) {
        if(byteBuf0 instanceof SwappedByteBuf) {
            while(true) {
                byteBuf0 = byteBuf0.unwrap();
                if(!(byteBuf0 instanceof SwappedByteBuf)) {
                    break;
                }
            }
        }
        return byteBuf0;
    }

    private ByteBuf unwrappedDerived(ByteBuf byteBuf0) {
        ByteBuf byteBuf1 = SimpleLeakAwareByteBuf.unwrapSwapped(byteBuf0);
        if(byteBuf1 instanceof AbstractPooledDerivedByteBuf) {
            ((AbstractPooledDerivedByteBuf)byteBuf1).parent(this);
            return this.newLeakAwareByteBuf(byteBuf0, AbstractByteBuf.leakDetector.trackForcibly(byteBuf0));
        }
        return this.newSharedLeakAwareByteBuf(byteBuf0);
    }
}

