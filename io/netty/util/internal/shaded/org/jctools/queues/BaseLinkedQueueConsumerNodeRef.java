package io.netty.util.internal.shaded.org.jctools.queues;

import io.netty.util.internal.shaded.org.jctools.util.UnsafeAccess;

abstract class BaseLinkedQueueConsumerNodeRef extends BaseLinkedQueuePad1 {
    private static final long C_NODE_OFFSET;
    private LinkedQueueNode consumerNode;

    static {
        BaseLinkedQueueConsumerNodeRef.C_NODE_OFFSET = UnsafeAccess.fieldOffset(BaseLinkedQueueConsumerNodeRef.class, "consumerNode");
    }

    public final LinkedQueueNode lpConsumerNode() {
        return this.consumerNode;
    }

    public final LinkedQueueNode lvConsumerNode() {
        return (LinkedQueueNode)UnsafeAccess.UNSAFE.getObjectVolatile(this, BaseLinkedQueueConsumerNodeRef.C_NODE_OFFSET);
    }

    public final void spConsumerNode(LinkedQueueNode linkedQueueNode0) {
        this.consumerNode = linkedQueueNode0;
    }
}

