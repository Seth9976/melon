package io.netty.util.internal.shaded.org.jctools.queues;

import java.util.Iterator;

abstract class BaseLinkedQueue extends BaseLinkedQueuePad2 {
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
        for(LinkedQueueNode linkedQueueNode0 = this.lpConsumerNode(); v1 < v; linkedQueueNode0 = linkedQueueNode1) {
            LinkedQueueNode linkedQueueNode1 = linkedQueueNode0.lvNext();
            if(linkedQueueNode1 == null) {
                return v1;
            }
            messagePassingQueue$Consumer0.accept(this.getSingleConsumerNodeValue(linkedQueueNode0, linkedQueueNode1));
            ++v1;
        }
        return v;
    }

    @Override  // io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public void drain(Consumer messagePassingQueue$Consumer0, WaitStrategy messagePassingQueue$WaitStrategy0, ExitCondition messagePassingQueue$ExitCondition0) {
        MessagePassingQueueUtil.drain(this, messagePassingQueue$Consumer0, messagePassingQueue$WaitStrategy0, messagePassingQueue$ExitCondition0);
    }

    public Object getSingleConsumerNodeValue(LinkedQueueNode linkedQueueNode0, LinkedQueueNode linkedQueueNode1) {
        Object object0 = linkedQueueNode1.getAndNullValue();
        linkedQueueNode0.soNext(linkedQueueNode0);
        this.spConsumerNode(linkedQueueNode1);
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

    public final LinkedQueueNode newNode() {
        return new LinkedQueueNode();
    }

    public final LinkedQueueNode newNode(Object object0) {
        return new LinkedQueueNode(object0);
    }

    @Override  // io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public Object peek() {
        LinkedQueueNode linkedQueueNode0 = this.lpConsumerNode();
        LinkedQueueNode linkedQueueNode1 = linkedQueueNode0.lvNext();
        if(linkedQueueNode1 != null) {
            return linkedQueueNode1.lpValue();
        }
        return linkedQueueNode0 == this.lvProducerNode() ? null : this.spinWaitForNextNode(linkedQueueNode0).lpValue();
    }

    @Override  // io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public Object poll() {
        LinkedQueueNode linkedQueueNode0 = this.lpConsumerNode();
        LinkedQueueNode linkedQueueNode1 = linkedQueueNode0.lvNext();
        if(linkedQueueNode1 != null) {
            return this.getSingleConsumerNodeValue(linkedQueueNode0, linkedQueueNode1);
        }
        return linkedQueueNode0 == this.lvProducerNode() ? null : this.getSingleConsumerNodeValue(linkedQueueNode0, this.spinWaitForNextNode(linkedQueueNode0));
    }

    @Override  // io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public boolean relaxedOffer(Object object0) {
        return this.offer(object0);
    }

    @Override  // io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public Object relaxedPeek() {
        LinkedQueueNode linkedQueueNode0 = this.lpConsumerNode().lvNext();
        return linkedQueueNode0 == null ? null : linkedQueueNode0.lpValue();
    }

    @Override  // io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public Object relaxedPoll() {
        LinkedQueueNode linkedQueueNode0 = this.lpConsumerNode();
        LinkedQueueNode linkedQueueNode1 = linkedQueueNode0.lvNext();
        return linkedQueueNode1 == null ? null : this.getSingleConsumerNodeValue(linkedQueueNode0, linkedQueueNode1);
    }

    @Override  // io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public final int size() {
        LinkedQueueNode linkedQueueNode0 = this.lvConsumerNode();
        LinkedQueueNode linkedQueueNode1 = this.lvProducerNode();
        int v = 0;
        while(linkedQueueNode0 != linkedQueueNode1 && linkedQueueNode0 != null && v < 0x7FFFFFFF) {
            LinkedQueueNode linkedQueueNode2 = linkedQueueNode0.lvNext();
            if(linkedQueueNode2 == linkedQueueNode0) {
                break;
            }
            ++v;
            linkedQueueNode0 = linkedQueueNode2;
        }
        return v;
    }

    public LinkedQueueNode spinWaitForNextNode(LinkedQueueNode linkedQueueNode0) {
        LinkedQueueNode linkedQueueNode1;
        do {
            linkedQueueNode1 = linkedQueueNode0.lvNext();
        }
        while(linkedQueueNode1 == null);
        return linkedQueueNode1;
    }

    @Override
    public String toString() {
        return this.getClass().getName();
    }
}

