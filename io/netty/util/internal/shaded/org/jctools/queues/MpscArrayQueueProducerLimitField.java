package io.netty.util.internal.shaded.org.jctools.queues;

import io.netty.util.internal.shaded.org.jctools.util.UnsafeAccess;

abstract class MpscArrayQueueProducerLimitField extends MpscArrayQueueMidPad {
    private static final long P_LIMIT_OFFSET;
    private volatile long producerLimit;

    static {
        MpscArrayQueueProducerLimitField.P_LIMIT_OFFSET = UnsafeAccess.fieldOffset(MpscArrayQueueProducerLimitField.class, "producerLimit");
    }

    public MpscArrayQueueProducerLimitField(int v) {
        super(v);
        this.producerLimit = (long)v;
    }

    public final long lvProducerLimit() {
        return this.producerLimit;
    }

    public final void soProducerLimit(long v) {
        UnsafeAccess.UNSAFE.putOrderedLong(this, MpscArrayQueueProducerLimitField.P_LIMIT_OFFSET, v);
    }
}

