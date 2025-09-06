package io.netty.util.internal.shaded.org.jctools.queues.atomic;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;

abstract class BaseMpscLinkedAtomicArrayQueueProducerFields extends BaseMpscLinkedAtomicArrayQueuePad1 {
    private static final AtomicLongFieldUpdater P_INDEX_UPDATER;
    private volatile long producerIndex;

    static {
        BaseMpscLinkedAtomicArrayQueueProducerFields.P_INDEX_UPDATER = AtomicLongFieldUpdater.newUpdater(BaseMpscLinkedAtomicArrayQueueProducerFields.class, "producerIndex");
    }

    public final boolean casProducerIndex(long v, long v1) {
        return BaseMpscLinkedAtomicArrayQueueProducerFields.P_INDEX_UPDATER.compareAndSet(this, v, v1);
    }

    @Override  // io.netty.util.internal.shaded.org.jctools.queues.IndexedQueueSizeUtil$IndexedQueue
    public final long lvProducerIndex() {
        return this.producerIndex;
    }

    public final void soProducerIndex(long v) {
        BaseMpscLinkedAtomicArrayQueueProducerFields.P_INDEX_UPDATER.lazySet(this, v);
    }
}

