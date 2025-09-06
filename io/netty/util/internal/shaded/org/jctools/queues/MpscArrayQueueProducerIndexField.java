package io.netty.util.internal.shaded.org.jctools.queues;

import io.netty.util.internal.shaded.org.jctools.util.UnsafeAccess;

abstract class MpscArrayQueueProducerIndexField extends MpscArrayQueueL1Pad {
    private static final long P_INDEX_OFFSET;
    private volatile long producerIndex;

    static {
        MpscArrayQueueProducerIndexField.P_INDEX_OFFSET = UnsafeAccess.fieldOffset(MpscArrayQueueProducerIndexField.class, "producerIndex");
    }

    public MpscArrayQueueProducerIndexField(int v) {
        super(v);
    }

    public final boolean casProducerIndex(long v, long v1) {
        return UnsafeAccess.UNSAFE.compareAndSwapLong(this, MpscArrayQueueProducerIndexField.P_INDEX_OFFSET, v, v1);
    }

    @Override  // io.netty.util.internal.shaded.org.jctools.queues.IndexedQueueSizeUtil$IndexedQueue
    public final long lvProducerIndex() {
        return this.producerIndex;
    }
}

