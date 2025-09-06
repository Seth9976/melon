package io.netty.util.internal.shaded.org.jctools.queues.atomic;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

abstract class BaseLinkedAtomicQueueProducerNodeRef extends BaseLinkedAtomicQueuePad0 {
    private static final AtomicReferenceFieldUpdater P_NODE_UPDATER;
    private volatile LinkedQueueAtomicNode producerNode;

    static {
        BaseLinkedAtomicQueueProducerNodeRef.P_NODE_UPDATER = AtomicReferenceFieldUpdater.newUpdater(BaseLinkedAtomicQueueProducerNodeRef.class, LinkedQueueAtomicNode.class, "producerNode");
    }

    public final boolean casProducerNode(LinkedQueueAtomicNode linkedQueueAtomicNode0, LinkedQueueAtomicNode linkedQueueAtomicNode1) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater0 = BaseLinkedAtomicQueueProducerNodeRef.P_NODE_UPDATER;
        do {
            if(atomicReferenceFieldUpdater0.compareAndSet(this, linkedQueueAtomicNode0, linkedQueueAtomicNode1)) {
                return true;
            }
        }
        while(atomicReferenceFieldUpdater0.get(this) == linkedQueueAtomicNode0);
        return false;
    }

    public final LinkedQueueAtomicNode lpProducerNode() {
        return this.producerNode;
    }

    public final LinkedQueueAtomicNode lvProducerNode() {
        return this.producerNode;
    }

    public final void soProducerNode(LinkedQueueAtomicNode linkedQueueAtomicNode0) {
        BaseLinkedAtomicQueueProducerNodeRef.P_NODE_UPDATER.lazySet(this, linkedQueueAtomicNode0);
    }

    public final void spProducerNode(LinkedQueueAtomicNode linkedQueueAtomicNode0) {
        BaseLinkedAtomicQueueProducerNodeRef.P_NODE_UPDATER.lazySet(this, linkedQueueAtomicNode0);
    }

    public final LinkedQueueAtomicNode xchgProducerNode(LinkedQueueAtomicNode linkedQueueAtomicNode0) {
        return (LinkedQueueAtomicNode)BaseLinkedAtomicQueueProducerNodeRef.P_NODE_UPDATER.getAndSet(this, linkedQueueAtomicNode0);
    }
}

