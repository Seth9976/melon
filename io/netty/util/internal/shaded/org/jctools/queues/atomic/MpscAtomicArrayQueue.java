package io.netty.util.internal.shaded.org.jctools.queues.atomic;

import io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue.Consumer;
import io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue.ExitCondition;
import io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue.Supplier;
import io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue.WaitStrategy;
import io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueueUtil;
import java.util.concurrent.atomic.AtomicReferenceArray;

public class MpscAtomicArrayQueue extends MpscAtomicArrayQueueL3Pad {
    public MpscAtomicArrayQueue(int v) {
        super(v);
    }

    @Override  // io.netty.util.internal.shaded.org.jctools.queues.atomic.AtomicReferenceArrayQueue
    public void clear() {
        super.clear();
    }

    @Override  // io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public int drain(Consumer messagePassingQueue$Consumer0) {
        return this.drain(messagePassingQueue$Consumer0, this.capacity());
    }

    @Override  // io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public int drain(Consumer messagePassingQueue$Consumer0, int v) {
        if(messagePassingQueue$Consumer0 == null) {
            throw new IllegalArgumentException("c is null");
        }
        if(v < 0) {
            throw new IllegalArgumentException("limit is negative: " + v);
        }
        if(v == 0) {
            return 0;
        }
        AtomicReferenceArray atomicReferenceArray0 = this.buffer;
        int v2 = this.mask;
        long v3 = this.lpConsumerIndex();
        for(int v1 = 0; v1 < v; ++v1) {
            long v4 = ((long)v1) + v3;
            int v5 = AtomicQueueUtil.calcCircularRefElementOffset(v4, v2);
            Object object0 = AtomicQueueUtil.lvRefElement(atomicReferenceArray0, v5);
            if(object0 == null) {
                return v1;
            }
            AtomicQueueUtil.spRefElement(atomicReferenceArray0, v5, null);
            this.soConsumerIndex(v4 + 1L);
            messagePassingQueue$Consumer0.accept(object0);
        }
        return v;
    }

    @Override  // io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public void drain(Consumer messagePassingQueue$Consumer0, WaitStrategy messagePassingQueue$WaitStrategy0, ExitCondition messagePassingQueue$ExitCondition0) {
        MessagePassingQueueUtil.drain(this, messagePassingQueue$Consumer0, messagePassingQueue$WaitStrategy0, messagePassingQueue$ExitCondition0);
    }

    public final int failFastOffer(Object object0) {
        if(object0 == null) {
            throw null;
        }
        int v = this.mask;
        long v1 = this.lvProducerIndex();
        if(v1 >= this.lvProducerLimit()) {
            long v2 = this.lvConsumerIndex() + ((long)(v + 1));
            if(v1 >= v2) {
                return 1;
            }
            this.soProducerLimit(v2);
        }
        if(!this.casProducerIndex(v1, v1 + 1L)) {
            return -1;
        }
        AtomicQueueUtil.soRefElement(this.buffer, AtomicQueueUtil.calcCircularRefElementOffset(v1, v), object0);
        return 0;
    }

    @Override  // io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public int fill(Supplier messagePassingQueue$Supplier0) {
        return MessagePassingQueueUtil.fillBounded(this, messagePassingQueue$Supplier0);
    }

    @Override  // io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public int fill(Supplier messagePassingQueue$Supplier0, int v) {
        int v6;
        long v4;
        if(messagePassingQueue$Supplier0 == null) {
            throw new IllegalArgumentException("supplier is null");
        }
        if(v < 0) {
            throw new IllegalArgumentException("limit is negative:" + v);
        }
        if(v == 0) {
            return 0;
        }
        int v2 = this.mask;
        long v3 = this.lvProducerLimit();
        do {
            v4 = this.lvProducerIndex();
            long v5 = v3 - v4;
            if(v5 <= 0L) {
                v3 = this.lvConsumerIndex() + ((long)(v2 + 1));
                v5 = v3 - v4;
                if(v5 <= 0L) {
                    return 0;
                }
                this.soProducerLimit(v3);
            }
            v6 = Math.min(((int)v5), v);
        }
        while(!this.casProducerIndex(v4, ((long)v6) + v4));
        AtomicReferenceArray atomicReferenceArray0 = this.buffer;
        for(int v1 = 0; v1 < v6; ++v1) {
            AtomicQueueUtil.soRefElement(atomicReferenceArray0, AtomicQueueUtil.calcCircularRefElementOffset(((long)v1) + v4, v2), messagePassingQueue$Supplier0.get());
        }
        return v6;
    }

    @Override  // io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public void fill(Supplier messagePassingQueue$Supplier0, WaitStrategy messagePassingQueue$WaitStrategy0, ExitCondition messagePassingQueue$ExitCondition0) {
        MessagePassingQueueUtil.fill(this, messagePassingQueue$Supplier0, messagePassingQueue$WaitStrategy0, messagePassingQueue$ExitCondition0);
    }

    @Override  // io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public boolean offer(Object object0) {
        long v2;
        if(object0 == null) {
            throw null;
        }
        int v = this.mask;
        long v1 = this.lvProducerLimit();
        do {
            v2 = this.lvProducerIndex();
            if(Long.compare(v2, v1) >= 0) {
                v1 = this.lvConsumerIndex() + ((long)v) + 1L;
                if(v2 >= v1) {
                    return false;
                }
                this.soProducerLimit(v1);
            }
        }
        while(!this.casProducerIndex(v2, v2 + 1L));
        AtomicQueueUtil.soRefElement(this.buffer, AtomicQueueUtil.calcCircularRefElementOffset(v2, v), object0);
        return true;
    }

    public boolean offerIfBelowThreshold(Object object0, int v) {
        long v3;
        if(object0 == null) {
            throw null;
        }
        int v1 = this.mask;
        long v2 = this.lvProducerLimit();
        do {
            v3 = this.lvProducerIndex();
            if(((long)(v1 + 1)) - (v2 - v3) >= ((long)v)) {
                long v4 = this.lvConsumerIndex();
                if(v3 - v4 >= ((long)v)) {
                    return false;
                }
                v2 = v4 + ((long)(v1 + 1));
                this.soProducerLimit(v2);
            }
        }
        while(!this.casProducerIndex(v3, v3 + 1L));
        AtomicQueueUtil.soRefElement(this.buffer, AtomicQueueUtil.calcCircularRefElementOffset(v3, v1), object0);
        return true;
    }

    @Override  // io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public Object peek() {
        Object object1;
        AtomicReferenceArray atomicReferenceArray0 = this.buffer;
        long v = this.lpConsumerIndex();
        int v1 = AtomicQueueUtil.calcCircularRefElementOffset(v, this.mask);
        Object object0 = AtomicQueueUtil.lvRefElement(atomicReferenceArray0, v1);
        if(object0 == null) {
            if(v != this.lvProducerIndex()) {
                do {
                    object1 = AtomicQueueUtil.lvRefElement(atomicReferenceArray0, v1);
                }
                while(object1 == null);
                return object1;
            }
            return null;
        }
        return object0;
    }

    @Override  // io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public Object poll() {
        Object object1;
        long v = this.lpConsumerIndex();
        int v1 = AtomicQueueUtil.calcCircularRefElementOffset(v, this.mask);
        AtomicReferenceArray atomicReferenceArray0 = this.buffer;
        Object object0 = AtomicQueueUtil.lvRefElement(atomicReferenceArray0, v1);
        if(object0 == null) {
            if(v != this.lvProducerIndex()) {
                do {
                    object1 = AtomicQueueUtil.lvRefElement(atomicReferenceArray0, v1);
                }
                while(object1 == null);
                AtomicQueueUtil.spRefElement(atomicReferenceArray0, v1, null);
                this.soConsumerIndex(v + 1L);
                return object1;
            }
            return null;
        }
        AtomicQueueUtil.spRefElement(atomicReferenceArray0, v1, null);
        this.soConsumerIndex(v + 1L);
        return object0;
    }

    @Override  // io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public boolean relaxedOffer(Object object0) {
        return this.offer(object0);
    }

    @Override  // io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public Object relaxedPeek() {
        return AtomicQueueUtil.lvRefElement(this.buffer, AtomicQueueUtil.calcCircularRefElementOffset(this.lpConsumerIndex(), this.mask));
    }

    @Override  // io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public Object relaxedPoll() {
        AtomicReferenceArray atomicReferenceArray0 = this.buffer;
        long v = this.lpConsumerIndex();
        int v1 = AtomicQueueUtil.calcCircularRefElementOffset(v, this.mask);
        Object object0 = AtomicQueueUtil.lvRefElement(atomicReferenceArray0, v1);
        if(object0 == null) {
            return null;
        }
        AtomicQueueUtil.spRefElement(atomicReferenceArray0, v1, null);
        this.soConsumerIndex(v + 1L);
        return object0;
    }

    @Override  // io.netty.util.internal.shaded.org.jctools.queues.atomic.AtomicReferenceArrayQueue
    public String toString() {
        return super.toString();
    }

    @Deprecated
    public int weakOffer(Object object0) {
        return this.failFastOffer(object0);
    }
}

