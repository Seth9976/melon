package io.netty.util.internal.shaded.org.jctools.queues;

import io.netty.util.internal.shaded.org.jctools.util.UnsafeAccess;

final class LinkedQueueNode {
    private static final long NEXT_OFFSET;
    private volatile LinkedQueueNode next;
    private Object value;

    static {
        LinkedQueueNode.NEXT_OFFSET = UnsafeAccess.fieldOffset(LinkedQueueNode.class, "next");
    }

    public LinkedQueueNode() {
        this(null);
    }

    public LinkedQueueNode(Object object0) {
        this.spValue(object0);
    }

    public Object getAndNullValue() {
        this.spValue(null);
        return this.lpValue();
    }

    public Object lpValue() {
        return this.value;
    }

    public LinkedQueueNode lvNext() {
        return this.next;
    }

    public void soNext(LinkedQueueNode linkedQueueNode0) {
        UnsafeAccess.UNSAFE.putOrderedObject(this, LinkedQueueNode.NEXT_OFFSET, linkedQueueNode0);
    }

    public void spNext(LinkedQueueNode linkedQueueNode0) {
        UnsafeAccess.UNSAFE.putObject(this, LinkedQueueNode.NEXT_OFFSET, linkedQueueNode0);
    }

    public void spValue(Object object0) {
        this.value = object0;
    }
}

