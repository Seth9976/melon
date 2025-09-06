package io.netty.util.internal.shaded.org.jctools.queues;

public class SpscLinkedQueue extends BaseLinkedQueue {
    public SpscLinkedQueue() {
        LinkedQueueNode linkedQueueNode0 = this.newNode();
        this.spProducerNode(linkedQueueNode0);
        this.spConsumerNode(linkedQueueNode0);
        linkedQueueNode0.soNext(null);
    }

    @Override  // io.netty.util.internal.shaded.org.jctools.queues.BaseLinkedQueue
    public int capacity() {
        return super.capacity();
    }

    @Override  // io.netty.util.internal.shaded.org.jctools.queues.BaseLinkedQueue
    public int drain(Consumer messagePassingQueue$Consumer0) {
        return super.drain(messagePassingQueue$Consumer0);
    }

    @Override  // io.netty.util.internal.shaded.org.jctools.queues.BaseLinkedQueue
    public int drain(Consumer messagePassingQueue$Consumer0, int v) {
        return super.drain(messagePassingQueue$Consumer0, v);
    }

    @Override  // io.netty.util.internal.shaded.org.jctools.queues.BaseLinkedQueue
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
        LinkedQueueNode linkedQueueNode0 = this.newNode(messagePassingQueue$Supplier0.get());
        int v1 = 1;
        LinkedQueueNode linkedQueueNode1;
        for(linkedQueueNode1 = linkedQueueNode0; v1 < v; linkedQueueNode1 = linkedQueueNode2) {
            LinkedQueueNode linkedQueueNode2 = this.newNode(messagePassingQueue$Supplier0.get());
            linkedQueueNode1.spNext(linkedQueueNode2);
            ++v1;
        }
        this.soProducerNode(linkedQueueNode1);
        this.lpProducerNode().soNext(linkedQueueNode0);
        return v;
    }

    @Override  // io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public void fill(Supplier messagePassingQueue$Supplier0, WaitStrategy messagePassingQueue$WaitStrategy0, ExitCondition messagePassingQueue$ExitCondition0) {
        MessagePassingQueueUtil.fill(this, messagePassingQueue$Supplier0, messagePassingQueue$WaitStrategy0, messagePassingQueue$ExitCondition0);
    }

    @Override  // io.netty.util.internal.shaded.org.jctools.queues.BaseLinkedQueue
    public boolean isEmpty() {
        return super.isEmpty();
    }

    @Override  // io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public boolean offer(Object object0) {
        if(object0 == null) {
            throw null;
        }
        LinkedQueueNode linkedQueueNode0 = this.newNode(object0);
        this.soProducerNode(linkedQueueNode0);
        this.lpProducerNode().soNext(linkedQueueNode0);
        return true;
    }

    @Override  // io.netty.util.internal.shaded.org.jctools.queues.BaseLinkedQueue
    public Object peek() {
        return super.peek();
    }

    @Override  // io.netty.util.internal.shaded.org.jctools.queues.BaseLinkedQueue
    public Object poll() {
        return super.poll();
    }

    @Override  // io.netty.util.internal.shaded.org.jctools.queues.BaseLinkedQueue
    public boolean relaxedOffer(Object object0) {
        return super.relaxedOffer(object0);
    }

    @Override  // io.netty.util.internal.shaded.org.jctools.queues.BaseLinkedQueue
    public Object relaxedPeek() {
        return super.relaxedPeek();
    }

    @Override  // io.netty.util.internal.shaded.org.jctools.queues.BaseLinkedQueue
    public Object relaxedPoll() {
        return super.relaxedPoll();
    }

    @Override  // io.netty.util.internal.shaded.org.jctools.queues.BaseLinkedQueue
    public String toString() {
        return super.toString();
    }
}

