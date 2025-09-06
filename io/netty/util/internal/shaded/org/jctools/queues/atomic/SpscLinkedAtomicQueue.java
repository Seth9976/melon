package io.netty.util.internal.shaded.org.jctools.queues.atomic;

import io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue.Consumer;
import io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue.ExitCondition;
import io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue.Supplier;
import io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue.WaitStrategy;
import io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueueUtil;

public class SpscLinkedAtomicQueue extends BaseLinkedAtomicQueue {
    public SpscLinkedAtomicQueue() {
        LinkedQueueAtomicNode linkedQueueAtomicNode0 = this.newNode();
        this.spProducerNode(linkedQueueAtomicNode0);
        this.spConsumerNode(linkedQueueAtomicNode0);
        linkedQueueAtomicNode0.soNext(null);
    }

    @Override  // io.netty.util.internal.shaded.org.jctools.queues.atomic.BaseLinkedAtomicQueue
    public int capacity() {
        return super.capacity();
    }

    @Override  // io.netty.util.internal.shaded.org.jctools.queues.atomic.BaseLinkedAtomicQueue
    public int drain(Consumer messagePassingQueue$Consumer0) {
        return super.drain(messagePassingQueue$Consumer0);
    }

    @Override  // io.netty.util.internal.shaded.org.jctools.queues.atomic.BaseLinkedAtomicQueue
    public int drain(Consumer messagePassingQueue$Consumer0, int v) {
        return super.drain(messagePassingQueue$Consumer0, v);
    }

    @Override  // io.netty.util.internal.shaded.org.jctools.queues.atomic.BaseLinkedAtomicQueue
    public void drain(Consumer messagePassingQueue$Consumer0, WaitStrategy messagePassingQueue$WaitStrategy0, ExitCondition messagePassingQueue$ExitCondition0) {
        super.drain(messagePassingQueue$Consumer0, messagePassingQueue$WaitStrategy0, messagePassingQueue$ExitCondition0);
    }

    @Override  // io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public int fill(Supplier messagePassingQueue$Supplier0) {
        return MessagePassingQueueUtil.fillUnbounded(this, messagePassingQueue$Supplier0);
    }

    @Override  // io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public int fill(Supplier messagePassingQueue$Supplier0, int v) {
        if(messagePassingQueue$Supplier0 == null) {
            throw new IllegalArgumentException("supplier is null");
        }
        if(v < 0) {
            throw new IllegalArgumentException("limit is negative:" + v);
        }
        if(v == 0) {
            return 0;
        }
        LinkedQueueAtomicNode linkedQueueAtomicNode0 = this.newNode(messagePassingQueue$Supplier0.get());
        int v1 = 1;
        LinkedQueueAtomicNode linkedQueueAtomicNode1;
        for(linkedQueueAtomicNode1 = linkedQueueAtomicNode0; v1 < v; linkedQueueAtomicNode1 = linkedQueueAtomicNode2) {
            LinkedQueueAtomicNode linkedQueueAtomicNode2 = this.newNode(messagePassingQueue$Supplier0.get());
            linkedQueueAtomicNode1.spNext(linkedQueueAtomicNode2);
            ++v1;
        }
        this.soProducerNode(linkedQueueAtomicNode1);
        this.lpProducerNode().soNext(linkedQueueAtomicNode0);
        return v;
    }

    @Override  // io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public void fill(Supplier messagePassingQueue$Supplier0, WaitStrategy messagePassingQueue$WaitStrategy0, ExitCondition messagePassingQueue$ExitCondition0) {
        MessagePassingQueueUtil.fill(this, messagePassingQueue$Supplier0, messagePassingQueue$WaitStrategy0, messagePassingQueue$ExitCondition0);
    }

    @Override  // io.netty.util.internal.shaded.org.jctools.queues.atomic.BaseLinkedAtomicQueue
    public boolean isEmpty() {
        return super.isEmpty();
    }

    @Override  // io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public boolean offer(Object object0) {
        if(object0 == null) {
            throw null;
        }
        LinkedQueueAtomicNode linkedQueueAtomicNode0 = this.newNode(object0);
        this.soProducerNode(linkedQueueAtomicNode0);
        this.lpProducerNode().soNext(linkedQueueAtomicNode0);
        return true;
    }

    @Override  // io.netty.util.internal.shaded.org.jctools.queues.atomic.BaseLinkedAtomicQueue
    public Object peek() {
        return super.peek();
    }

    @Override  // io.netty.util.internal.shaded.org.jctools.queues.atomic.BaseLinkedAtomicQueue
    public Object poll() {
        return super.poll();
    }

    @Override  // io.netty.util.internal.shaded.org.jctools.queues.atomic.BaseLinkedAtomicQueue
    public boolean relaxedOffer(Object object0) {
        return super.relaxedOffer(object0);
    }

    @Override  // io.netty.util.internal.shaded.org.jctools.queues.atomic.BaseLinkedAtomicQueue
    public Object relaxedPeek() {
        return super.relaxedPeek();
    }

    @Override  // io.netty.util.internal.shaded.org.jctools.queues.atomic.BaseLinkedAtomicQueue
    public Object relaxedPoll() {
        return super.relaxedPoll();
    }

    @Override  // io.netty.util.internal.shaded.org.jctools.queues.atomic.BaseLinkedAtomicQueue
    public String toString() {
        return super.toString();
    }
}

