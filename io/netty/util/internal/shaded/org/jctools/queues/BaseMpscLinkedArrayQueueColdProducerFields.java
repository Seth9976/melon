package io.netty.util.internal.shaded.org.jctools.queues;

import io.netty.util.internal.shaded.org.jctools.util.UnsafeAccess;

abstract class BaseMpscLinkedArrayQueueColdProducerFields extends BaseMpscLinkedArrayQueuePad3 {
    private static final long P_LIMIT_OFFSET;
    protected Object[] producerBuffer;
    private volatile long producerLimit;
    protected long producerMask;

    static {
        BaseMpscLinkedArrayQueueColdProducerFields.P_LIMIT_OFFSET = UnsafeAccess.fieldOffset(BaseMpscLinkedArrayQueueColdProducerFields.class, "producerLimit");
    }

    public final boolean casProducerLimit(long v, long v1) {
        return UnsafeAccess.UNSAFE.compareAndSwapLong(this, BaseMpscLinkedArrayQueueColdProducerFields.P_LIMIT_OFFSET, v, v1);
    }

    public final long lvProducerLimit() {
        return this.producerLimit;
    }

    public final void soProducerLimit(long v) {
        UnsafeAccess.UNSAFE.putOrderedLong(this, BaseMpscLinkedArrayQueueColdProducerFields.P_LIMIT_OFFSET, v);
    }
}

