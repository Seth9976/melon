package io.netty.util.internal.shaded.org.jctools.queues.atomic;

import io.netty.util.internal.shaded.org.jctools.queues.IndexedQueueSizeUtil.IndexedQueue;
import io.netty.util.internal.shaded.org.jctools.queues.IndexedQueueSizeUtil;
import io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue;
import io.netty.util.internal.shaded.org.jctools.queues.QueueProgressIndicators;
import io.netty.util.internal.shaded.org.jctools.queues.SupportsIterator;
import io.netty.util.internal.shaded.org.jctools.util.Pow2;
import java.util.AbstractQueue;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicReferenceArray;

abstract class AtomicReferenceArrayQueue extends AbstractQueue implements IndexedQueue, MessagePassingQueue, QueueProgressIndicators, SupportsIterator {
    static class WeakIterator implements Iterator {
        private final AtomicReferenceArray buffer;
        private final int mask;
        private Object nextElement;
        private long nextIndex;
        private final long pIndex;

        public WeakIterator(long v, long v1, int v2, AtomicReferenceArray atomicReferenceArray0) {
            this.nextIndex = v;
            this.pIndex = v1;
            this.mask = v2;
            this.buffer = atomicReferenceArray0;
            this.nextElement = this.getNext();
        }

        private Object getNext() {
            int v = this.mask;
            AtomicReferenceArray atomicReferenceArray0 = this.buffer;
            long v1;
            while((v1 = this.nextIndex) < this.pIndex) {
                this.nextIndex = v1 + 1L;
                Object object0 = AtomicQueueUtil.lvRefElement(atomicReferenceArray0, AtomicQueueUtil.calcCircularRefElementOffset(v1, v));
                if(object0 != null) {
                    return object0;
                }
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
    }

    protected final AtomicReferenceArray buffer;
    protected final int mask;

    public AtomicReferenceArrayQueue(int v) {
        int v1 = Pow2.roundToPowerOfTwo(v);
        this.mask = v1 - 1;
        this.buffer = new AtomicReferenceArray(v1);
    }

    @Override  // io.netty.util.internal.shaded.org.jctools.queues.IndexedQueueSizeUtil$IndexedQueue, io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public final int capacity() {
        return this.mask + 1;
    }

    @Override  // io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public void clear() {
        while(this.poll() != null) {
        }
    }

    @Override  // io.netty.util.internal.shaded.org.jctools.queues.QueueProgressIndicators
    public final long currentConsumerIndex() {
        return this.lvConsumerIndex();
    }

    @Override  // io.netty.util.internal.shaded.org.jctools.queues.QueueProgressIndicators
    public final long currentProducerIndex() {
        return this.lvProducerIndex();
    }

    @Override  // io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public final boolean isEmpty() {
        return IndexedQueueSizeUtil.isEmpty(this);
    }

    @Override
    public final Iterator iterator() {
        return new WeakIterator(this.lvConsumerIndex(), this.lvProducerIndex(), this.mask, this.buffer);
    }

    @Override  // io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public final int size() {
        return IndexedQueueSizeUtil.size(this);
    }

    @Override
    public String toString() {
        return this.getClass().getName();
    }
}

