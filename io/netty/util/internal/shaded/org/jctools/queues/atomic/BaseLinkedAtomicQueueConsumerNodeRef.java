package io.netty.util.internal.shaded.org.jctools.queues.atomic;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

abstract class BaseLinkedAtomicQueueConsumerNodeRef extends BaseLinkedAtomicQueuePad1 {
    private static final AtomicReferenceFieldUpdater C_NODE_UPDATER;
    private volatile LinkedQueueAtomicNode consumerNode;

    static {
        BaseLinkedAtomicQueueConsumerNodeRef.C_NODE_UPDATER = AtomicReferenceFieldUpdater.newUpdater(BaseLinkedAtomicQueueConsumerNodeRef.class, LinkedQueueAtomicNode.class, "consumerNode");
    }

    public final LinkedQueueAtomicNode lpConsumerNode() {
        return this.consumerNode;
    }

    public final LinkedQueueAtomicNode lvConsumerNode() {
        return this.consumerNode;
    }

    public final void spConsumerNode(LinkedQueueAtomicNode linkedQueueAtomicNode0) {
        BaseLinkedAtomicQueueConsumerNodeRef.C_NODE_UPDATER.lazySet(this, linkedQueueAtomicNode0);
    }
}

