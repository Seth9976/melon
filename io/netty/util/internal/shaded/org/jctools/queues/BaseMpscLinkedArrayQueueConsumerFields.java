package io.netty.util.internal.shaded.org.jctools.queues;

import io.netty.util.internal.shaded.org.jctools.util.UnsafeAccess;

abstract class BaseMpscLinkedArrayQueueConsumerFields extends BaseMpscLinkedArrayQueuePad2 {
    private static final long C_INDEX_OFFSET;
    protected Object[] consumerBuffer;
    private volatile long consumerIndex;
    protected long consumerMask;

    static {
        BaseMpscLinkedArrayQueueConsumerFields.C_INDEX_OFFSET = UnsafeAccess.fieldOffset(BaseMpscLinkedArrayQueueConsumerFields.class, "consumerIndex");
    }

    public final long lpConsumerIndex() {
        return UnsafeAccess.UNSAFE.getLong(this, BaseMpscLinkedArrayQueueConsumerFields.C_INDEX_OFFSET);
    }

    @Override  // io.netty.util.internal.shaded.org.jctools.queues.IndexedQueueSizeUtil$IndexedQueue
    public final long lvConsumerIndex() {
        return this.consumerIndex;
    }

    public final void soConsumerIndex(long v) {
        UnsafeAccess.UNSAFE.putOrderedLong(this, BaseMpscLinkedArrayQueueConsumerFields.C_INDEX_OFFSET, v);
    }
}

