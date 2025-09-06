package io.netty.util.internal.shaded.org.jctools.queues.atomic;

import io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue.Consumer;
import io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue.ExitCondition;
import io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue.WaitStrategy;
import io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueueUtil;
import java.util.Iterator;

abstract class BaseLinkedAtomicQueue extends BaseLinkedAtomicQueuePad2 {
    @Override  // io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public int capacity() {
        return -1;
    }

    @Override  // io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public int drain(Consumer messagePassingQueue$Consumer0) {
        return MessagePassingQueueUtil.drain(this, messagePassingQueue$Consumer0);
    }

    @Override  // io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public int drain(Consumer messagePassingQueue$Consumer0, int v) {
        int v1 = 0;
        if(messagePassingQueue$Consumer0 == null) {
            throw new IllegalArgumentException("c is null");
        }
        if(v < 0) {
            throw new IllegalArgumentException("limit is negative: " + v);
        }
        if(v == 0) {
            return 0;
        }
        for(LinkedQueueAtomicNode linkedQueueAtomicNode0 = this.lpConsumerNode(); v1 < v; linkedQueueAtomicNode0 = linkedQueueAtomicNode1) {
            LinkedQueueAtomicNode linkedQueueAtomicNode1 = linkedQueueAtomicNode0.lvNext();
            if(linkedQueueAtomicNode1 == null) {
                return v1;
            }
            messagePassingQueue$Consumer0.accept(this.getSingleConsumerNodeValue(linkedQueueAtomicNode0, linkedQueueAtomicNode1));
            ++v1;
        }
        return v;
    }

    @Override  // io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public void drain(Consumer messagePassingQueue$Consumer0, WaitStrategy messagePassingQueue$WaitStrategy0, ExitCondition messagePassingQueue$ExitCondition0) {
        MessagePassingQueueUtil.drain(this, messagePassingQueue$Consumer0, messagePassingQueue$WaitStrategy0, messagePassingQueue$ExitCondition0);
    }

    public Object getSingleConsumerNodeValue(LinkedQueueAtomicNode linkedQueueAtomicNode0, LinkedQueueAtomicNode linkedQueueAtomicNode1) {
        Object object0 = linkedQueueAtomicNode1.getAndNullValue();
        linkedQueueAtomicNode0.soNext(linkedQueueAtomicNode0);
        this.spConsumerNode(linkedQueueAtomicNode1);
        return object0;
    }

    @Override  // io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public boolean isEmpty() {
        return this.lvConsumerNode() == this.lvProducerNode();
    }

    @Override
    public final Iterator iterator() {
        throw new UnsupportedOperationException();
    }

    public final LinkedQueueAtomicNode newNode() {
        return new LinkedQueueAtomicNode();
    }

    public final LinkedQueueAtomicNode newNode(Object object0) {
        return new LinkedQueueAtomicNode(object0);
    }

    @Override  // io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public Object peek() {
        LinkedQueueAtomicNode linkedQueueAtomicNode0 = this.lpConsumerNode();
        LinkedQueueAtomicNode linkedQueueAtomicNode1 = linkedQueueAtomicNode0.lvNext();
        if(linkedQueueAtomicNode1 != null) {
            return linkedQueueAtomicNode1.lpValue();
        }
        return linkedQueueAtomicNode0 == this.lvProducerNode() ? null : this.spinWaitForNextNode(linkedQueueAtomicNode0).lpValue();
    }

    @Override  // io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public Object poll() {
        LinkedQueueAtomicNode linkedQueueAtomicNode0 = this.lpConsumerNode();
        LinkedQueueAtomicNode linkedQueueAtomicNode1 = linkedQueueAtomicNode0.lvNext();
        if(linkedQueueAtomicNode1 != null) {
            return this.getSingleConsumerNodeValue(linkedQueueAtomicNode0, linkedQueueAtomicNode1);
        }
        return linkedQueueAtomicNode0 == this.lvProducerNode() ? null : this.getSingleConsumerNodeValue(linkedQueueAtomicNode0, this.spinWaitForNextNode(linkedQueueAtomicNode0));
    }

    @Override  // io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public boolean relaxedOffer(Object object0) {
        return this.offer(object0);
    }

    @Override  // io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public Object relaxedPeek() {
        LinkedQueueAtomicNode linkedQueueAtomicNode0 = this.lpConsumerNode().lvNext();
        return linkedQueueAtomicNode0 == null ? null : linkedQueueAtomicNode0.lpValue();
    }

    @Override  // io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public Object relaxedPoll() {
        LinkedQueueAtomicNode linkedQueueAtomicNode0 = this.lpConsumerNode();
        LinkedQueueAtomicNode linkedQueueAtomicNode1 = linkedQueueAtomicNode0.lvNext();
        return linkedQueueAtomicNode1 == null ? null : this.getSingleConsumerNodeValue(linkedQueueAtomicNode0, linkedQueueAtomicNode1);
    }

    @Override  // io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public final int size() {
        LinkedQueueAtomicNode linkedQueueAtomicNode0 = this.lvConsumerNode();
        LinkedQueueAtomicNode linkedQueueAtomicNode1 = this.lvProducerNode();
        int v = 0;
        while(linkedQueueAtomicNode0 != linkedQueueAtomicNode1 && linkedQueueAtomicNode0 != null && v < 0x7FFFFFFF) {
            LinkedQueueAtomicNode linkedQueueAtomicNode2 = linkedQueueAtomicNode0.lvNext();
            if(linkedQueueAtomicNode2 == linkedQueueAtomicNode0) {
                break;
            }
            ++v;
            linkedQueueAtomicNode0 = linkedQueueAtomicNode2;
        }
        return v;
    }

    public LinkedQueueAtomicNode spinWaitForNextNode(LinkedQueueAtomicNode linkedQueueAtomicNode0) {
        LinkedQueueAtomicNode linkedQueueAtomicNode1;
        do {
            linkedQueueAtomicNode1 = linkedQueueAtomicNode0.lvNext();
        }
        while(linkedQueueAtomicNode1 == null);
        return linkedQueueAtomicNode1;
    }

    @Override
    public String toString() {
        return this.getClass().getName();
    }
}

