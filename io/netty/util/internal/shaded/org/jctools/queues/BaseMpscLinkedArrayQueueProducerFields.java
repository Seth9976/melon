package io.netty.util.internal.shaded.org.jctools.queues;

import io.netty.util.internal.shaded.org.jctools.util.UnsafeAccess;

abstract class BaseMpscLinkedArrayQueueProducerFields extends BaseMpscLinkedArrayQueuePad1 {
    private static final long P_INDEX_OFFSET;
    private volatile long producerIndex;

    static {
        BaseMpscLinkedArrayQueueProducerFields.P_INDEX_OFFSET = UnsafeAccess.fieldOffset(BaseMpscLinkedArrayQueueProducerFields.class, "producerIndex");
    }

    public final boolean casProducerIndex(long v, long v1) {
        return UnsafeAccess.UNSAFE.compareAndSwapLong(this, BaseMpscLinkedArrayQueueProducerFields.P_INDEX_OFFSET, v, v1);
    }

    @Override  // io.netty.util.internal.shaded.org.jctools.queues.IndexedQueueSizeUtil$IndexedQueue
    public final long lvProducerIndex() {
        return this.producerIndex;
    }

    public final void soProducerIndex(long v) {
        UnsafeAccess.UNSAFE.putOrderedLong(this, BaseMpscLinkedArrayQueueProducerFields.P_INDEX_OFFSET, v);
    }
}

