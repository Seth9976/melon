package io.netty.util.internal.shaded.org.jctools.queues;

import io.netty.util.internal.shaded.org.jctools.util.Pow2;
import io.netty.util.internal.shaded.org.jctools.util.UnsafeRefArrayAccess;
import java.util.Iterator;
import java.util.NoSuchElementException;

abstract class ConcurrentCircularArrayQueue extends ConcurrentCircularArrayQueueL0Pad implements IndexedQueue, MessagePassingQueue, QueueProgressIndicators, SupportsIterator {
    static class WeakIterator implements Iterator {
        private final Object[] buffer;
        private final long mask;
        private Object nextElement;
        private long nextIndex;
        private final long pIndex;

        public WeakIterator(long v, long v1, long v2, Object[] arr_object) {
            this.nextIndex = v;
            this.pIndex = v1;
            this.mask = v2;
            this.buffer = arr_object;
            this.nextElement = this.getNext();
        }

        private Object getNext() {
            long v;
            while((v = this.nextIndex) < this.pIndex) {
                this.nextIndex = v + 1L;
                Object object0 = UnsafeRefArrayAccess.lvRefElement(this.buffer, UnsafeRefArrayAccess.calcCircularRefElementOffset(v, this.mask));
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

    protected final Object[] buffer;
    protected final long mask;

    public ConcurrentCircularArrayQueue(int v) {
        int v1 = Pow2.roundToPowerOfTwo(v);
        this.mask = (long)(v1 - 1);
        this.buffer = UnsafeRefArrayAccess.allocateRefArray(v1);
    }

    @Override  // io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue, io.netty.util.internal.shaded.org.jctools.queues.IndexedQueueSizeUtil$IndexedQueue
    public int capacity() {
        return (int)(this.mask + 1L);
    }

    @Override  // io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public void clear() {
        while(this.poll() != null) {
        }
    }

    @Override  // io.netty.util.internal.shaded.org.jctools.queues.QueueProgressIndicators
    public long currentConsumerIndex() {
        return this.lvConsumerIndex();
    }

    @Override  // io.netty.util.internal.shaded.org.jctools.queues.QueueProgressIndicators
    public long currentProducerIndex() {
        return this.lvProducerIndex();
    }

    @Override  // io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public boolean isEmpty() {
        return IndexedQueueSizeUtil.isEmpty(this);
    }

    @Override
    public Iterator iterator() {
        return new WeakIterator(this.lvConsumerIndex(), this.lvProducerIndex(), this.mask, this.buffer);
    }

    @Override  // io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public int size() {
        return IndexedQueueSizeUtil.size(this);
    }

    @Override
    public String toString() {
        return this.getClass().getName();
    }
}

