package io.netty.util;

import io.netty.util.internal.ReferenceCountUpdater;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

public abstract class AbstractReferenceCounted implements ReferenceCounted {
    private static final AtomicIntegerFieldUpdater AIF_UPDATER;
    private static final long REFCNT_FIELD_OFFSET;
    private volatile int refCnt;
    private static final ReferenceCountUpdater updater;

    static {
        AbstractReferenceCounted.REFCNT_FIELD_OFFSET = ReferenceCountUpdater.getUnsafeOffset(AbstractReferenceCounted.class, "refCnt");
        AbstractReferenceCounted.AIF_UPDATER = AtomicIntegerFieldUpdater.newUpdater(AbstractReferenceCounted.class, "refCnt");
        AbstractReferenceCounted.updater = new ReferenceCountUpdater() {
            @Override  // io.netty.util.internal.ReferenceCountUpdater
            public long unsafeOffset() {
                return AbstractReferenceCounted.REFCNT_FIELD_OFFSET;
            }

            @Override  // io.netty.util.internal.ReferenceCountUpdater
            public AtomicIntegerFieldUpdater updater() {
                return AbstractReferenceCounted.AIF_UPDATER;
            }
        };
    }

    public AbstractReferenceCounted() {
        this.refCnt = 2;
    }

    public abstract void deallocate();

    private boolean handleRelease(boolean z) {
        if(z) {
            this.deallocate();
        }
        return z;
    }

    @Override  // io.netty.util.ReferenceCounted
    public int refCnt() {
        return AbstractReferenceCounted.updater.refCnt(this);
    }

    @Override  // io.netty.util.ReferenceCounted
    public boolean release() {
        return this.handleRelease(AbstractReferenceCounted.updater.release(this));
    }

    @Override  // io.netty.util.ReferenceCounted
    public boolean release(int v) {
        return this.handleRelease(AbstractReferenceCounted.updater.release(this, v));
    }

    @Override  // io.netty.util.ReferenceCounted
    public ReferenceCounted retain() {
        return AbstractReferenceCounted.updater.retain(this);
    }

    @Override  // io.netty.util.ReferenceCounted
    public ReferenceCounted retain(int v) {
        return AbstractReferenceCounted.updater.retain(this, v);
    }

    public final void setRefCnt(int v) {
        AbstractReferenceCounted.updater.setRefCnt(this, v);
    }

    @Override  // io.netty.util.ReferenceCounted
    public ReferenceCounted touch() {
        return this.touch(null);
    }
}

