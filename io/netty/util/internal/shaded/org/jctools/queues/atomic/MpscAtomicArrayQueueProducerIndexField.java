package io.netty.util.internal.shaded.org.jctools.queues.atomic;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;

abstract class MpscAtomicArrayQueueProducerIndexField extends MpscAtomicArrayQueueL1Pad {
    private static final AtomicLongFieldUpdater P_INDEX_UPDATER;
    private volatile long producerIndex;

    static {
        MpscAtomicArrayQueueProducerIndexField.P_INDEX_UPDATER = AtomicLongFieldUpdater.newUpdater(MpscAtomicArrayQueueProducerIndexField.class, "producerIndex");
    }

    public MpscAtomicArrayQueueProducerIndexField(int v) {
        super(v);
    }

    public final boolean casProducerIndex(long v, long v1) {
        return MpscAtomicArrayQueueProducerIndexField.P_INDEX_UPDATER.compareAndSet(this, v, v1);
    }

    @Override  // io.netty.util.internal.shaded.org.jctools.queues.IndexedQueueSizeUtil$IndexedQueue
    public final long lvProducerIndex() {
        return this.producerIndex;
    }
}

