package io.netty.util.internal.shaded.org.jctools.queues.atomic;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;

abstract class MpscAtomicArrayQueueConsumerIndexField extends MpscAtomicArrayQueueL2Pad {
    private static final AtomicLongFieldUpdater C_INDEX_UPDATER;
    private volatile long consumerIndex;

    static {
        MpscAtomicArrayQueueConsumerIndexField.C_INDEX_UPDATER = AtomicLongFieldUpdater.newUpdater(MpscAtomicArrayQueueConsumerIndexField.class, "consumerIndex");
    }

    public MpscAtomicArrayQueueConsumerIndexField(int v) {
        super(v);
    }

    public final long lpConsumerIndex() {
        return this.consumerIndex;
    }

    @Override  // io.netty.util.internal.shaded.org.jctools.queues.IndexedQueueSizeUtil$IndexedQueue
    public final long lvConsumerIndex() {
        return this.consumerIndex;
    }

    public final void soConsumerIndex(long v) {
        MpscAtomicArrayQueueConsumerIndexField.C_INDEX_UPDATER.lazySet(this, v);
    }
}

