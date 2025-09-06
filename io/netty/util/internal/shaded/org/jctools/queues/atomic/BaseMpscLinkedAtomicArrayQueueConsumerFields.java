package io.netty.util.internal.shaded.org.jctools.queues.atomic;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;

abstract class BaseMpscLinkedAtomicArrayQueueConsumerFields extends BaseMpscLinkedAtomicArrayQueuePad2 {
    private static final AtomicLongFieldUpdater C_INDEX_UPDATER;
    protected AtomicReferenceArray consumerBuffer;
    private volatile long consumerIndex;
    protected long consumerMask;

    static {
        BaseMpscLinkedAtomicArrayQueueConsumerFields.C_INDEX_UPDATER = AtomicLongFieldUpdater.newUpdater(BaseMpscLinkedAtomicArrayQueueConsumerFields.class, "consumerIndex");
    }

    public final long lpConsumerIndex() {
        return this.consumerIndex;
    }

    @Override  // io.netty.util.internal.shaded.org.jctools.queues.IndexedQueueSizeUtil$IndexedQueue
    public final long lvConsumerIndex() {
        return this.consumerIndex;
    }

    public final void soConsumerIndex(long v) {
        BaseMpscLinkedAtomicArrayQueueConsumerFields.C_INDEX_UPDATER.lazySet(this, v);
    }
}

