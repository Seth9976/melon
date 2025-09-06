package io.netty.util.internal.shaded.org.jctools.queues;

import io.netty.util.internal.shaded.org.jctools.util.UnsafeAccess;

abstract class MpscArrayQueueConsumerIndexField extends MpscArrayQueueL2Pad {
    private static final long C_INDEX_OFFSET;
    private volatile long consumerIndex;

    static {
        MpscArrayQueueConsumerIndexField.C_INDEX_OFFSET = UnsafeAccess.fieldOffset(MpscArrayQueueConsumerIndexField.class, "consumerIndex");
    }

    public MpscArrayQueueConsumerIndexField(int v) {
        super(v);
    }

    public final long lpConsumerIndex() {
        return UnsafeAccess.UNSAFE.getLong(this, MpscArrayQueueConsumerIndexField.C_INDEX_OFFSET);
    }

    @Override  // io.netty.util.internal.shaded.org.jctools.queues.IndexedQueueSizeUtil$IndexedQueue
    public final long lvConsumerIndex() {
        return this.consumerIndex;
    }

    public final void soConsumerIndex(long v) {
        UnsafeAccess.UNSAFE.putOrderedLong(this, MpscArrayQueueConsumerIndexField.C_INDEX_OFFSET, v);
    }
}

