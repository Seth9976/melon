package io.netty.buffer;

import io.netty.util.ReferenceCounted;
import io.netty.util.internal.ReferenceCountUpdater;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

public abstract class AbstractReferenceCountedByteBuf extends AbstractByteBuf {
    private static final AtomicIntegerFieldUpdater AIF_UPDATER;
    private static final long REFCNT_FIELD_OFFSET;
    private volatile int refCnt;
    private static final ReferenceCountUpdater updater;

    static {
        AbstractReferenceCountedByteBuf.REFCNT_FIELD_OFFSET = ReferenceCountUpdater.getUnsafeOffset(AbstractReferenceCountedByteBuf.class, "refCnt");
        AbstractReferenceCountedByteBuf.AIF_UPDATER = AtomicIntegerFieldUpdater.newUpdater(AbstractReferenceCountedByteBuf.class, "refCnt");
        AbstractReferenceCountedByteBuf.updater = new ReferenceCountUpdater() {
            @Override  // io.netty.util.internal.ReferenceCountUpdater
            public long unsafeOffset() {
                return AbstractReferenceCountedByteBuf.REFCNT_FIELD_OFFSET;
            }

            @Override  // io.netty.util.internal.ReferenceCountUpdater
            public AtomicIntegerFieldUpdater updater() {
                return AbstractReferenceCountedByteBuf.AIF_UPDATER;
            }
        };
    }

    public AbstractReferenceCountedByteBuf(int v) {
        super(v);
        AbstractReferenceCountedByteBuf.updater.setInitialValue(this);
    }

    public abstract void deallocate();

    private boolean handleRelease(boolean z) {
        if(z) {
            this.deallocate();
        }
        return z;
    }

    @Override  // io.netty.buffer.ByteBuf
    public boolean isAccessible() {
        return AbstractReferenceCountedByteBuf.updater.isLiveNonVolatile(this);
    }

    @Override  // io.netty.util.ReferenceCounted
    public int refCnt() {
        return AbstractReferenceCountedByteBuf.updater.refCnt(this);
    }

    @Override  // io.netty.util.ReferenceCounted
    public boolean release() {
        return this.handleRelease(AbstractReferenceCountedByteBuf.updater.release(this));
    }

    @Override  // io.netty.util.ReferenceCounted
    public boolean release(int v) {
        return this.handleRelease(AbstractReferenceCountedByteBuf.updater.release(this, v));
    }

    public final void resetRefCnt() {
        AbstractReferenceCountedByteBuf.updater.resetRefCnt(this);
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf retain() {
        return (ByteBuf)AbstractReferenceCountedByteBuf.updater.retain(this);
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf retain(int v) {
        return (ByteBuf)AbstractReferenceCountedByteBuf.updater.retain(this, v);
    }

    @Override  // io.netty.buffer.ByteBuf
    public ReferenceCounted retain() {
        return this.retain();
    }

    @Override  // io.netty.buffer.ByteBuf
    public ReferenceCounted retain(int v) {
        return this.retain(v);
    }

    public final void setRefCnt(int v) {
        AbstractReferenceCountedByteBuf.updater.setRefCnt(this, v);
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf touch() {
        return this;
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf touch(Object object0) {
        return this;
    }

    @Override  // io.netty.buffer.ByteBuf
    public ReferenceCounted touch() {
        return this.touch();
    }

    @Override  // io.netty.buffer.ByteBuf
    public ReferenceCounted touch(Object object0) {
        return this.touch(object0);
    }
}

