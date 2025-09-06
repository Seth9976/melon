package io.netty.util.internal.shaded.org.jctools.queues.atomic;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;

abstract class MpscAtomicArrayQueueProducerLimitField extends MpscAtomicArrayQueueMidPad {
    private static final AtomicLongFieldUpdater P_LIMIT_UPDATER;
    private volatile long producerLimit;

    static {
        MpscAtomicArrayQueueProducerLimitField.P_LIMIT_UPDATER = AtomicLongFieldUpdater.newUpdater(MpscAtomicArrayQueueProducerLimitField.class, "producerLimit");
    }

    public MpscAtomicArrayQueueProducerLimitField(int v) {
        super(v);
        this.producerLimit = (long)v;
    }

    public final long lvProducerLimit() {
        return this.producerLimit;
    }

    public final void soProducerLimit(long v) {
        MpscAtomicArrayQueueProducerLimitField.P_LIMIT_UPDATER.lazySet(this, v);
    }
}

