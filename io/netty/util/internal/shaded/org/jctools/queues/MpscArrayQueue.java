package io.netty.util.internal.shaded.org.jctools.queues;

import io.netty.util.internal.shaded.org.jctools.util.UnsafeRefArrayAccess;
import java.util.Iterator;

public class MpscArrayQueue extends MpscArrayQueueL3Pad {
    public MpscArrayQueue(int v) {
        super(v);
    }

    @Override  // io.netty.util.internal.shaded.org.jctools.queues.ConcurrentCircularArrayQueue
    public int capacity() {
        return super.capacity();
    }

    @Override  // io.netty.util.internal.shaded.org.jctools.queues.ConcurrentCircularArrayQueue
    public void clear() {
        super.clear();
    }

    @Override  // io.netty.util.internal.shaded.org.jctools.queues.ConcurrentCircularArrayQueue
    public long currentConsumerIndex() {
        return super.currentConsumerIndex();
    }

    @Override  // io.netty.util.internal.shaded.org.jctools.queues.ConcurrentCircularArrayQueue
    public long currentProducerIndex() {
        return super.currentProducerIndex();
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
        Object[] arr_object = this.buffer;
        long v2 = this.mask;
        long v3 = this.lpConsumerIndex();
        for(int v1 = 0; v1 < v; ++v1) {
            long v4 = ((long)v1) + v3;
            long v5 = UnsafeRefArrayAccess.calcCircularRefElementOffset(v4, v2);
            Object object0 = UnsafeRefArrayAccess.lvRefElement(arr_object, v5);
            if(object0 == null) {
                return v1;
            }
            UnsafeRefArrayAccess.spRefElement(arr_object, v5, null);
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
        long v = this.mask;
        long v1 = this.lvProducerIndex();
        if(v1 >= this.lvProducerLimit()) {
            long v2 = this.lvConsumerIndex() + (v + 1L);
            if(v1 >= v2) {
                return 1;
            }
            this.soProducerLimit(v2);
        }
        if(!this.casProducerIndex(v1, v1 + 1L)) {
            return -1;
        }
        UnsafeRefArrayAccess.soRefElement(this.buffer, UnsafeRefArrayAccess.calcCircularRefElementOffset(v1, v), object0);
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
        long v2 = this.mask;
        long v3 = this.lvProducerLimit();
        do {
            v4 = this.lvProducerIndex();
            long v5 = v3 - v4;
            if(v5 <= 0L) {
                v3 = this.lvConsumerIndex() + (v2 + 1L);
                v5 = v3 - v4;
                if(v5 <= 0L) {
                    return 0;
                }
                this.soProducerLimit(v3);
            }
            v6 = Math.min(((int)v5), v);
        }
        while(!this.casProducerIndex(v4, ((long)v6) + v4));
        Object[] arr_object = this.buffer;
        for(int v1 = 0; v1 < v6; ++v1) {
            UnsafeRefArrayAccess.soRefElement(arr_object, UnsafeRefArrayAccess.calcCircularRefElementOffset(((long)v1) + v4, v2), messagePassingQueue$Supplier0.get());
        }
        return v6;
    }

    @Override  // io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public void fill(Supplier messagePassingQueue$Supplier0, WaitStrategy messagePassingQueue$WaitStrategy0, ExitCondition messagePassingQueue$ExitCondition0) {
        MessagePassingQueueUtil.fill(this, messagePassingQueue$Supplier0, messagePassingQueue$WaitStrategy0, messagePassingQueue$ExitCondition0);
    }

    @Override  // io.netty.util.internal.shaded.org.jctools.queues.ConcurrentCircularArrayQueue
    public boolean isEmpty() {
        return super.isEmpty();
    }

    @Override  // io.netty.util.internal.shaded.org.jctools.queues.ConcurrentCircularArrayQueue
    public Iterator iterator() {
        return super.iterator();
    }

    @Override  // io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public boolean offer(Object object0) {
        long v2;
        if(object0 == null) {
            throw null;
        }
        long v = this.mask;
        long v1 = this.lvProducerLimit();
        do {
            v2 = this.lvProducerIndex();
            if(Long.compare(v2, v1) >= 0) {
                v1 = this.lvConsumerIndex() + v + 1L;
                if(v2 >= v1) {
                    return false;
                }
                this.soProducerLimit(v1);
            }
        }
        while(!this.casProducerIndex(v2, v2 + 1L));
        UnsafeRefArrayAccess.soRefElement(this.buffer, UnsafeRefArrayAccess.calcCircularRefElementOffset(v2, v), object0);
        return true;
    }

    public boolean offerIfBelowThreshold(Object object0, int v) {
        long v3;
        if(object0 == null) {
            throw null;
        }
        long v1 = this.mask;
        long v2 = this.lvProducerLimit();
        do {
            v3 = this.lvProducerIndex();
            if(v1 + 1L - (v2 - v3) >= ((long)v)) {
                long v4 = this.lvConsumerIndex();
                if(v3 - v4 >= ((long)v)) {
                    return false;
                }
                v2 = v4 + (v1 + 1L);
                this.soProducerLimit(v2);
            }
        }
        while(!this.casProducerIndex(v3, v3 + 1L));
        UnsafeRefArrayAccess.soRefElement(this.buffer, UnsafeRefArrayAccess.calcCircularRefElementOffset(v3, v1), object0);
        return true;
    }

    @Override  // io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public Object peek() {
        Object object1;
        Object[] arr_object = this.buffer;
        long v = this.lpConsumerIndex();
        long v1 = UnsafeRefArrayAccess.calcCircularRefElementOffset(v, this.mask);
        Object object0 = UnsafeRefArrayAccess.lvRefElement(arr_object, v1);
        if(object0 == null) {
            if(v != this.lvProducerIndex()) {
                do {
                    object1 = UnsafeRefArrayAccess.lvRefElement(arr_object, v1);
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
        long v1 = UnsafeRefArrayAccess.calcCircularRefElementOffset(v, this.mask);
        Object[] arr_object = this.buffer;
        Object object0 = UnsafeRefArrayAccess.lvRefElement(arr_object, v1);
        if(object0 == null) {
            if(v != this.lvProducerIndex()) {
                do {
                    object1 = UnsafeRefArrayAccess.lvRefElement(arr_object, v1);
                }
                while(object1 == null);
                UnsafeRefArrayAccess.spRefElement(arr_object, v1, null);
                this.soConsumerIndex(v + 1L);
                return object1;
            }
            return null;
        }
        UnsafeRefArrayAccess.spRefElement(arr_object, v1, null);
        this.soConsumerIndex(v + 1L);
        return object0;
    }

    @Override  // io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public boolean relaxedOffer(Object object0) {
        return this.offer(object0);
    }

    @Override  // io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public Object relaxedPeek() {
        long v = UnsafeRefArrayAccess.calcCircularRefElementOffset(this.lpConsumerIndex(), this.mask);
        return UnsafeRefArrayAccess.lvRefElement(this.buffer, v);
    }

    @Override  // io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public Object relaxedPoll() {
        Object[] arr_object = this.buffer;
        long v = this.lpConsumerIndex();
        long v1 = UnsafeRefArrayAccess.calcCircularRefElementOffset(v, this.mask);
        Object object0 = UnsafeRefArrayAccess.lvRefElement(arr_object, v1);
        if(object0 == null) {
            return null;
        }
        UnsafeRefArrayAccess.spRefElement(arr_object, v1, null);
        this.soConsumerIndex(v + 1L);
        return object0;
    }

    @Override  // io.netty.util.internal.shaded.org.jctools.queues.ConcurrentCircularArrayQueue
    public int size() {
        return super.size();
    }

    @Override  // io.netty.util.internal.shaded.org.jctools.queues.ConcurrentCircularArrayQueue
    public String toString() {
        return super.toString();
    }
}

