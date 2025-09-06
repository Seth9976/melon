package io.netty.util.internal.shaded.org.jctools.queues.atomic;

import io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue.Consumer;
import io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue.ExitCondition;
import io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue.Supplier;
import io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue.WaitStrategy;
import io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue;
import io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueueUtil;
import io.netty.util.internal.shaded.org.jctools.queues.QueueProgressIndicators;
import io.netty.util.internal.shaded.org.jctools.util.PortableJvmInfo;
import io.netty.util.internal.shaded.org.jctools.util.Pow2;
import io.netty.util.internal.shaded.org.jctools.util.RangeUtil;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicReferenceArray;

abstract class BaseMpscLinkedAtomicArrayQueue extends BaseMpscLinkedAtomicArrayQueueColdProducerFields implements MessagePassingQueue, QueueProgressIndicators {
    static class WeakIterator implements Iterator {
        private AtomicReferenceArray currentBuffer;
        private int mask;
        private Object nextElement;
        private long nextIndex;
        private final long pIndex;

        public WeakIterator(AtomicReferenceArray atomicReferenceArray0, long v, long v1) {
            this.pIndex = v1 >> 1;
            this.nextIndex = v >> 1;
            this.setBuffer(atomicReferenceArray0);
            this.nextElement = this.getNext();
        }

        private Object getNext() {
            Object object2;
        alab1:
            while(true) {
                do {
                    long v = this.nextIndex;
                    if(Long.compare(v, this.pIndex) >= 0) {
                        break alab1;
                    }
                    this.nextIndex = v + 1L;
                    Object object0 = AtomicQueueUtil.lvRefElement(this.currentBuffer, AtomicQueueUtil.calcCircularRefElementOffset(v, this.mask));
                    if(object0 == null) {
                        continue alab1;
                    }
                    if(object0 != BaseMpscLinkedAtomicArrayQueue.JUMP) {
                        return object0;
                    }
                    Object object1 = AtomicQueueUtil.lvRefElement(this.currentBuffer, AtomicQueueUtil.calcRefElementOffset(this.mask + 1));
                    if(object1 == BaseMpscLinkedAtomicArrayQueue.BUFFER_CONSUMED || object1 == null) {
                        break alab1;
                    }
                    this.setBuffer(((AtomicReferenceArray)object1));
                    object2 = AtomicQueueUtil.lvRefElement(this.currentBuffer, AtomicQueueUtil.calcCircularRefElementOffset(v, this.mask));
                }
                while(object2 == null);
                return object2;
            }
            return null;
        }

        @Override
        public boolean hasNext() {
            return this.nextElement != null;
        }

        @Override
        public Object next() {
            Object object0 = this.nextElement;
            if(object0 == null) {
                throw new NoSuchElementException();
            }
            this.nextElement = this.getNext();
            return object0;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("remove");
        }

        private void setBuffer(AtomicReferenceArray atomicReferenceArray0) {
            this.currentBuffer = atomicReferenceArray0;
            this.mask = AtomicQueueUtil.length(atomicReferenceArray0) - 2;
        }
    }

    static final boolean $assertionsDisabled = false;
    private static final Object BUFFER_CONSUMED = null;
    private static final int CONTINUE_TO_P_INDEX_CAS = 0;
    private static final Object JUMP = null;
    private static final int QUEUE_FULL = 2;
    private static final int QUEUE_RESIZE = 3;
    private static final int RETRY = 1;

    static {
        BaseMpscLinkedAtomicArrayQueue.JUMP = new Object();
        BaseMpscLinkedAtomicArrayQueue.BUFFER_CONSUMED = new Object();
    }

    public BaseMpscLinkedAtomicArrayQueue(int v) {
        RangeUtil.checkGreaterThanOrEqual(v, 2, "initialCapacity");
        int v1 = Pow2.roundToPowerOfTwo(v);
        long v2 = (long)(v1 - 1 << 1);
        AtomicReferenceArray atomicReferenceArray0 = AtomicQueueUtil.allocateRefArray(v1 + 1);
        this.producerBuffer = atomicReferenceArray0;
        this.producerMask = v2;
        this.consumerBuffer = atomicReferenceArray0;
        this.consumerMask = v2;
        this.soProducerLimit(v2);
    }

    public abstract long availableInQueue(long arg1, long arg2);

    @Override  // io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue, io.netty.util.internal.shaded.org.jctools.queues.IndexedQueueSizeUtil$IndexedQueue
    public abstract int capacity();

    @Override  // io.netty.util.internal.shaded.org.jctools.queues.QueueProgressIndicators
    public long currentConsumerIndex() {
        return this.lvConsumerIndex() / 2L;
    }

    @Override  // io.netty.util.internal.shaded.org.jctools.queues.QueueProgressIndicators
    public long currentProducerIndex() {
        return this.lvProducerIndex() / 2L;
    }

    @Override  // io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public int drain(Consumer messagePassingQueue$Consumer0) {
        return this.drain(messagePassingQueue$Consumer0, this.capacity());
    }

    @Override  // io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public int drain(Consumer messagePassingQueue$Consumer0, int v) {
        return MessagePassingQueueUtil.drain(this, messagePassingQueue$Consumer0, v);
    }

    @Override  // io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public void drain(Consumer messagePassingQueue$Consumer0, WaitStrategy messagePassingQueue$WaitStrategy0, ExitCondition messagePassingQueue$ExitCondition0) {
        MessagePassingQueueUtil.drain(this, messagePassingQueue$Consumer0, messagePassingQueue$WaitStrategy0, messagePassingQueue$ExitCondition0);
    }

    @Override  // io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public int fill(Supplier messagePassingQueue$Supplier0) {
        int v = this.capacity();
        long v1 = 0L;
        do {
            int v2 = this.fill(messagePassingQueue$Supplier0, PortableJvmInfo.RECOMENDED_OFFER_BATCH);
            if(v2 == 0) {
                return (int)v1;
            }
            v1 += (long)v2;
        }
        while(v1 <= ((long)v));
        return (int)v1;
    }

    @Override  // io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public int fill(Supplier messagePassingQueue$Supplier0, int v) {
        long v5;
        AtomicReferenceArray atomicReferenceArray0;
        long v4;
        long v3;
        long v2;
        if(messagePassingQueue$Supplier0 == null) {
            throw new IllegalArgumentException("supplier is null");
        }
        if(v < 0) {
            throw new IllegalArgumentException("limit is negative:" + v);
        }
        if(v == 0) {
            return 0;
        }
        while(true) {
            do {
            label_5:
                v2 = this.lvProducerLimit();
                v3 = this.lvProducerIndex();
            }
            while((v3 & 1L) == 1L);
            v4 = this.producerMask;
            atomicReferenceArray0 = this.producerBuffer;
            v5 = Math.min(v2, ((long)v) * 2L + v3);
            if(v3 >= v2) {
                switch(this.offerSlowPath(v4, v3, v2)) {
                    case 0: 
                    case 1: {
                        goto label_5;
                    }
                    case 2: {
                        return 0;
                    }
                    case 3: {
                        this.resize(v4, atomicReferenceArray0, v3, null, messagePassingQueue$Supplier0);
                        return 1;
                    }
                }
            }
            if(!this.casProducerIndex(v3, v5)) {
                goto label_5;
            }
            break;
        }
        int v6 = (int)((v5 - v3) / 2L);
        for(int v1 = 0; v1 < v6; ++v1) {
            AtomicQueueUtil.soRefElement(atomicReferenceArray0, AtomicQueueUtil.modifiedCalcCircularRefElementOffset(((long)v1) * 2L + v3, v4), messagePassingQueue$Supplier0.get());
        }
        return v6;
    }

    @Override  // io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public void fill(Supplier messagePassingQueue$Supplier0, WaitStrategy messagePassingQueue$WaitStrategy0, ExitCondition messagePassingQueue$ExitCondition0) {
        MessagePassingQueueUtil.fill(this, messagePassingQueue$Supplier0, messagePassingQueue$WaitStrategy0, messagePassingQueue$ExitCondition0);
    }

    public abstract long getCurrentBufferCapacity(long arg1);

    public abstract int getNextBufferSize(AtomicReferenceArray arg1);

    @Override  // io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public boolean isEmpty() {
        return this.lvConsumerIndex() == this.lvProducerIndex();
    }

    @Override
    public Iterator iterator() {
        return new WeakIterator(this.consumerBuffer, this.lvConsumerIndex(), this.lvProducerIndex());
    }

    private Object newBufferPeek(AtomicReferenceArray atomicReferenceArray0, long v) {
        Object object0 = AtomicQueueUtil.lvRefElement(atomicReferenceArray0, AtomicQueueUtil.modifiedCalcCircularRefElementOffset(v, this.consumerMask));
        if(object0 == null) {
            throw new IllegalStateException("new buffer must have at least one element");
        }
        return object0;
    }

    private Object newBufferPoll(AtomicReferenceArray atomicReferenceArray0, long v) {
        int v1 = AtomicQueueUtil.modifiedCalcCircularRefElementOffset(v, this.consumerMask);
        Object object0 = AtomicQueueUtil.lvRefElement(atomicReferenceArray0, v1);
        if(object0 == null) {
            throw new IllegalStateException("new buffer must have at least one element");
        }
        AtomicQueueUtil.soRefElement(atomicReferenceArray0, v1, null);
        this.soConsumerIndex(v + 2L);
        return object0;
    }

    private static int nextArrayOffset(long v) {
        return AtomicQueueUtil.modifiedCalcCircularRefElementOffset(v + 2L, 0x7FFFFFFFFFFFFFFFL);
    }

    private AtomicReferenceArray nextBuffer(AtomicReferenceArray atomicReferenceArray0, long v) {
        int v1 = BaseMpscLinkedAtomicArrayQueue.nextArrayOffset(v);
        AtomicReferenceArray atomicReferenceArray1 = (AtomicReferenceArray)AtomicQueueUtil.lvRefElement(atomicReferenceArray0, v1);
        this.consumerBuffer = atomicReferenceArray1;
        this.consumerMask = (long)(AtomicQueueUtil.length(atomicReferenceArray1) - 2 << 1);
        AtomicQueueUtil.soRefElement(atomicReferenceArray0, v1, BaseMpscLinkedAtomicArrayQueue.BUFFER_CONSUMED);
        return atomicReferenceArray1;
    }

    @Override  // io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public boolean offer(Object object0) {
        AtomicReferenceArray atomicReferenceArray0;
        long v2;
        long v1;
        if(object0 == null) {
            throw null;
        }
        while(true) {
            do {
            label_1:
                long v = this.lvProducerLimit();
                v1 = this.lvProducerIndex();
            }
            while((v1 & 1L) == 1L);
            v2 = this.producerMask;
            atomicReferenceArray0 = this.producerBuffer;
            if(Long.compare(v, v1) <= 0) {
                switch(this.offerSlowPath(v2, v1, v)) {
                    case 1: {
                        goto label_1;
                    }
                    case 2: {
                        return false;
                    }
                    case 3: {
                        this.resize(v2, atomicReferenceArray0, v1, object0, null);
                        return true;
                    }
                }
            }
            if(!this.casProducerIndex(v1, v1 + 2L)) {
                goto label_1;
            }
            break;
        }
        AtomicQueueUtil.soRefElement(atomicReferenceArray0, AtomicQueueUtil.modifiedCalcCircularRefElementOffset(v1, v2), object0);
        return true;
    }

    private int offerSlowPath(long v, long v1, long v2) {
        long v3 = this.lvConsumerIndex();
        long v4 = this.getCurrentBufferCapacity(v) + v3;
        if(Long.compare(v4, v1) > 0) {
            return this.casProducerLimit(v2, v4) ? 0 : 1;
        }
        if(this.availableInQueue(v1, v3) <= 0L) {
            return 2;
        }
        return this.casProducerIndex(v1, v1 + 1L) ? 3 : 1;
    }

    @Override  // io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public Object peek() {
        AtomicReferenceArray atomicReferenceArray0 = this.consumerBuffer;
        long v = this.lpConsumerIndex();
        long v1 = this.consumerMask;
        int v2 = AtomicQueueUtil.modifiedCalcCircularRefElementOffset(v, v1);
        Object object0 = AtomicQueueUtil.lvRefElement(atomicReferenceArray0, v2);
        if(object0 == null && v != this.lvProducerIndex()) {
            while(true) {
                object0 = AtomicQueueUtil.lvRefElement(atomicReferenceArray0, v2);
                if(object0 != null) {
                    break;
                }
            }
        }
        return object0 == BaseMpscLinkedAtomicArrayQueue.JUMP ? this.newBufferPeek(this.nextBuffer(atomicReferenceArray0, v1), v) : object0;
    }

    @Override  // io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public Object poll() {
        Object object1;
        AtomicReferenceArray atomicReferenceArray0 = this.consumerBuffer;
        long v = this.lpConsumerIndex();
        long v1 = this.consumerMask;
        int v2 = AtomicQueueUtil.modifiedCalcCircularRefElementOffset(v, v1);
        Object object0 = AtomicQueueUtil.lvRefElement(atomicReferenceArray0, v2);
        if(object0 == null) {
            if(v != this.lvProducerIndex()) {
                do {
                    object1 = AtomicQueueUtil.lvRefElement(atomicReferenceArray0, v2);
                }
                while(object1 == null);
                object0 = object1;
                goto label_12;
            }
            return null;
        }
    label_12:
        if(object0 == BaseMpscLinkedAtomicArrayQueue.JUMP) {
            return this.newBufferPoll(this.nextBuffer(atomicReferenceArray0, v1), v);
        }
        AtomicQueueUtil.soRefElement(atomicReferenceArray0, v2, null);
        this.soConsumerIndex(v + 2L);
        return object0;
    }

    @Override  // io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public boolean relaxedOffer(Object object0) {
        return this.offer(object0);
    }

    @Override  // io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public Object relaxedPeek() {
        AtomicReferenceArray atomicReferenceArray0 = this.consumerBuffer;
        long v = this.lpConsumerIndex();
        long v1 = this.consumerMask;
        Object object0 = AtomicQueueUtil.lvRefElement(atomicReferenceArray0, AtomicQueueUtil.modifiedCalcCircularRefElementOffset(v, v1));
        return object0 == BaseMpscLinkedAtomicArrayQueue.JUMP ? this.newBufferPeek(this.nextBuffer(atomicReferenceArray0, v1), v) : object0;
    }

    @Override  // io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public Object relaxedPoll() {
        AtomicReferenceArray atomicReferenceArray0 = this.consumerBuffer;
        long v = this.lpConsumerIndex();
        long v1 = this.consumerMask;
        int v2 = AtomicQueueUtil.modifiedCalcCircularRefElementOffset(v, v1);
        Object object0 = AtomicQueueUtil.lvRefElement(atomicReferenceArray0, v2);
        if(object0 == null) {
            return null;
        }
        if(object0 == BaseMpscLinkedAtomicArrayQueue.JUMP) {
            return this.newBufferPoll(this.nextBuffer(atomicReferenceArray0, v1), v);
        }
        AtomicQueueUtil.soRefElement(atomicReferenceArray0, v2, null);
        this.soConsumerIndex(v + 2L);
        return object0;
    }

    private void resize(long v, AtomicReferenceArray atomicReferenceArray0, long v1, Object object0, Supplier messagePassingQueue$Supplier0) {
        int v5;
        int v4;
        long v3;
        AtomicReferenceArray atomicReferenceArray1;
        int v2 = this.getNextBufferSize(atomicReferenceArray0);
        try {
            atomicReferenceArray1 = AtomicQueueUtil.allocateRefArray(v2);
            this.producerBuffer = atomicReferenceArray1;
            v3 = (long)(v2 - 2 << 1);
            this.producerMask = v3;
            v4 = AtomicQueueUtil.modifiedCalcCircularRefElementOffset(v1, v);
            v5 = AtomicQueueUtil.modifiedCalcCircularRefElementOffset(v1, v3);
        }
        catch(OutOfMemoryError outOfMemoryError0) {
            this.soProducerIndex(v1);
            throw outOfMemoryError0;
        }
        if(object0 == null) {
            object0 = messagePassingQueue$Supplier0.get();
        }
        AtomicQueueUtil.soRefElement(atomicReferenceArray1, v5, object0);
        AtomicQueueUtil.soRefElement(atomicReferenceArray0, BaseMpscLinkedAtomicArrayQueue.nextArrayOffset(v), atomicReferenceArray1);
        long v6 = this.availableInQueue(v1, this.lvConsumerIndex());
        RangeUtil.checkPositive(v6, "availableInQueue");
        this.soProducerLimit(Math.min(v3, v6) + v1);
        this.soProducerIndex(v1 + 2L);
        AtomicQueueUtil.soRefElement(atomicReferenceArray0, v4, BaseMpscLinkedAtomicArrayQueue.JUMP);
    }

    @Override  // io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public int size() {
        long v2;
        long v1;
        for(long v = this.lvConsumerIndex(); true; v = v2) {
            v1 = this.lvProducerIndex();
            v2 = this.lvConsumerIndex();
            if(v == v2) {
                break;
            }
        }
        long v3 = v1 - v2 >> 1;
        return v3 <= 0x7FFFFFFFL ? ((int)v3) : 0x7FFFFFFF;
    }

    @Override
    public String toString() {
        return this.getClass().getName();
    }
}

