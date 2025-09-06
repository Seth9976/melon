package io.netty.util.internal.shaded.org.jctools.queues;

import com.google.android.gms.internal.cast.a;
import io.netty.util.internal.shaded.org.jctools.util.UnsafeAccess;

abstract class BaseLinkedQueueProducerNodeRef extends BaseLinkedQueuePad0 {
    static final long P_NODE_OFFSET;
    private volatile LinkedQueueNode producerNode;

    static {
        BaseLinkedQueueProducerNodeRef.P_NODE_OFFSET = UnsafeAccess.fieldOffset(BaseLinkedQueueProducerNodeRef.class, "producerNode");
    }

    public final boolean casProducerNode(LinkedQueueNode linkedQueueNode0, LinkedQueueNode linkedQueueNode1) {
        return a.a(UnsafeAccess.UNSAFE, this, BaseLinkedQueueProducerNodeRef.P_NODE_OFFSET, linkedQueueNode0, linkedQueueNode1);
    }

    public final LinkedQueueNode lpProducerNode() {
        return this.producerNode;
    }

    public final LinkedQueueNode lvProducerNode() {
        return this.producerNode;
    }

    public final void soProducerNode(LinkedQueueNode linkedQueueNode0) {
        UnsafeAccess.UNSAFE.putOrderedObject(this, BaseLinkedQueueProducerNodeRef.P_NODE_OFFSET, linkedQueueNode0);
    }

    public final void spProducerNode(LinkedQueueNode linkedQueueNode0) {
        UnsafeAccess.UNSAFE.putObject(this, BaseLinkedQueueProducerNodeRef.P_NODE_OFFSET, linkedQueueNode0);
    }
}

