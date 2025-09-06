package io.netty.util.internal.shaded.org.jctools.queues.atomic;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;

abstract class BaseMpscLinkedAtomicArrayQueueColdProducerFields extends BaseMpscLinkedAtomicArrayQueuePad3 {
    private static final AtomicLongFieldUpdater P_LIMIT_UPDATER;
    protected AtomicReferenceArray producerBuffer;
    private volatile long producerLimit;
    protected long producerMask;

    static {
        BaseMpscLinkedAtomicArrayQueueColdProducerFields.P_LIMIT_UPDATER = AtomicLongFieldUpdater.newUpdater(BaseMpscLinkedAtomicArrayQueueColdProducerFields.class, "producerLimit");
    }

    public final boolean casProducerLimit(long v, long v1) {
        return BaseMpscLinkedAtomicArrayQueueColdProducerFields.P_LIMIT_UPDATER.compareAndSet(this, v, v1);
    }

    public final long lvProducerLimit() {
        return this.producerLimit;
    }

    public final void soProducerLimit(long v) {
        BaseMpscLinkedAtomicArrayQueueColdProducerFields.P_LIMIT_UPDATER.lazySet(this, v);
    }
}

