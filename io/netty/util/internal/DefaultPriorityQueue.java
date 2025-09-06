package io.netty.util.internal;

import java.util.AbstractQueue;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

public final class DefaultPriorityQueue extends AbstractQueue implements PriorityQueue {
    final class PriorityQueueIterator implements Iterator {
        private int index;

        private PriorityQueueIterator() {
        }

        public PriorityQueueIterator(io.netty.util.internal.DefaultPriorityQueue.1 defaultPriorityQueue$10) {
        }

        @Override
        public boolean hasNext() {
            return this.index < DefaultPriorityQueue.this.size;
        }

        public PriorityQueueNode next() {
            if(this.index >= DefaultPriorityQueue.this.size) {
                throw new NoSuchElementException();
            }
            int v = this.index;
            this.index = v + 1;
            return DefaultPriorityQueue.this.queue[v];
        }

        @Override
        public Object next() {
            return this.next();
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("remove");
        }
    }

    private static final PriorityQueueNode[] EMPTY_ARRAY;
    private final Comparator comparator;
    private PriorityQueueNode[] queue;
    private int size;

    static {
        DefaultPriorityQueue.EMPTY_ARRAY = new PriorityQueueNode[0];
    }

    public DefaultPriorityQueue(Comparator comparator0, int v) {
        this.comparator = (Comparator)ObjectUtil.checkNotNull(comparator0, "comparator");
        this.queue = v == 0 ? DefaultPriorityQueue.EMPTY_ARRAY : new PriorityQueueNode[v];
    }

    private void bubbleDown(int v, PriorityQueueNode priorityQueueNode0) {
        int v1 = this.size >>> 1;
        while(v < v1) {
            int v2 = (v << 1) + 1;
            PriorityQueueNode[] arr_priorityQueueNode = this.queue;
            PriorityQueueNode priorityQueueNode1 = arr_priorityQueueNode[v2];
            int v3 = (v << 1) + 2;
            if(v3 >= this.size || this.comparator.compare(priorityQueueNode1, arr_priorityQueueNode[v3]) <= 0) {
                v3 = v2;
            }
            else {
                priorityQueueNode1 = this.queue[v3];
            }
            if(this.comparator.compare(priorityQueueNode0, priorityQueueNode1) <= 0) {
                break;
            }
            this.queue[v] = priorityQueueNode1;
            priorityQueueNode1.priorityQueueIndex(this, v);
            v = v3;
        }
        this.queue[v] = priorityQueueNode0;
        priorityQueueNode0.priorityQueueIndex(this, v);
    }

    private void bubbleUp(int v, PriorityQueueNode priorityQueueNode0) {
        while(v > 0) {
            int v1 = v - 1 >>> 1;
            PriorityQueueNode priorityQueueNode1 = this.queue[v1];
            if(this.comparator.compare(priorityQueueNode0, priorityQueueNode1) >= 0) {
                break;
            }
            this.queue[v] = priorityQueueNode1;
            priorityQueueNode1.priorityQueueIndex(this, v);
            v = v1;
        }
        this.queue[v] = priorityQueueNode0;
        priorityQueueNode0.priorityQueueIndex(this, v);
    }

    @Override
    public void clear() {
        for(int v = 0; v < this.size; ++v) {
            PriorityQueueNode priorityQueueNode0 = this.queue[v];
            if(priorityQueueNode0 != null) {
                priorityQueueNode0.priorityQueueIndex(this, -1);
                this.queue[v] = null;
            }
        }
        this.size = 0;
    }

    @Override  // io.netty.util.internal.PriorityQueue
    public void clearIgnoringIndexes() {
        this.size = 0;
    }

    private boolean contains(PriorityQueueNode priorityQueueNode0, int v) {
        return v >= 0 && v < this.size && priorityQueueNode0.equals(this.queue[v]);
    }

    @Override
    public boolean contains(Object object0) {
        return object0 instanceof PriorityQueueNode ? this.contains(((PriorityQueueNode)object0), ((PriorityQueueNode)object0).priorityQueueIndex(this)) : false;
    }

    public boolean containsTyped(PriorityQueueNode priorityQueueNode0) {
        return this.contains(priorityQueueNode0, priorityQueueNode0.priorityQueueIndex(this));
    }

    @Override  // io.netty.util.internal.PriorityQueue
    public boolean containsTyped(Object object0) {
        return this.containsTyped(((PriorityQueueNode)object0));
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public Iterator iterator() {
        return new PriorityQueueIterator(this, null);
    }

    public boolean offer(PriorityQueueNode priorityQueueNode0) {
        if(priorityQueueNode0.priorityQueueIndex(this) != -1) {
            throw new IllegalArgumentException("e.priorityQueueIndex(): " + priorityQueueNode0.priorityQueueIndex(this) + " (expected: -1) + e: " + priorityQueueNode0);
        }
        PriorityQueueNode[] arr_priorityQueueNode = this.queue;
        if(this.size >= arr_priorityQueueNode.length) {
            this.queue = (PriorityQueueNode[])Arrays.copyOf(arr_priorityQueueNode, arr_priorityQueueNode.length + (arr_priorityQueueNode.length >= 0x40 ? arr_priorityQueueNode.length >>> 1 : arr_priorityQueueNode.length + 2));
        }
        int v = this.size;
        this.size = v + 1;
        this.bubbleUp(v, priorityQueueNode0);
        return true;
    }

    @Override
    public boolean offer(Object object0) {
        return this.offer(((PriorityQueueNode)object0));
    }

    public PriorityQueueNode peek() {
        return this.size == 0 ? null : this.queue[0];
    }

    @Override
    public Object peek() {
        return this.peek();
    }

    public PriorityQueueNode poll() {
        if(this.size == 0) {
            return null;
        }
        PriorityQueueNode priorityQueueNode0 = this.queue[0];
        priorityQueueNode0.priorityQueueIndex(this, -1);
        PriorityQueueNode[] arr_priorityQueueNode = this.queue;
        int v = this.size - 1;
        this.size = v;
        PriorityQueueNode priorityQueueNode1 = arr_priorityQueueNode[v];
        arr_priorityQueueNode[v] = null;
        if(v != 0) {
            this.bubbleDown(0, priorityQueueNode1);
        }
        return priorityQueueNode0;
    }

    @Override
    public Object poll() {
        return this.poll();
    }

    public void priorityChanged(PriorityQueueNode priorityQueueNode0) {
        int v = priorityQueueNode0.priorityQueueIndex(this);
        if(!this.contains(priorityQueueNode0, v)) {
            return;
        }
        if(v == 0) {
            this.bubbleDown(0, priorityQueueNode0);
            return;
        }
        if(this.comparator.compare(priorityQueueNode0, this.queue[v - 1 >>> 1]) < 0) {
            this.bubbleUp(v, priorityQueueNode0);
            return;
        }
        this.bubbleDown(v, priorityQueueNode0);
    }

    @Override  // io.netty.util.internal.PriorityQueue
    public void priorityChanged(Object object0) {
        this.priorityChanged(((PriorityQueueNode)object0));
    }

    @Override
    public boolean remove(Object object0) {
        try {
            return this.removeTyped(((PriorityQueueNode)object0));
        }
        catch(ClassCastException unused_ex) {
            return false;
        }
    }

    public boolean removeTyped(PriorityQueueNode priorityQueueNode0) {
        int v = priorityQueueNode0.priorityQueueIndex(this);
        if(!this.contains(priorityQueueNode0, v)) {
            return false;
        }
        priorityQueueNode0.priorityQueueIndex(this, -1);
        int v1 = this.size - 1;
        this.size = v1;
        if(v1 != 0 && v1 != v) {
            PriorityQueueNode[] arr_priorityQueueNode = this.queue;
            PriorityQueueNode priorityQueueNode1 = arr_priorityQueueNode[v1];
            arr_priorityQueueNode[v] = priorityQueueNode1;
            arr_priorityQueueNode[v1] = null;
            if(this.comparator.compare(priorityQueueNode0, priorityQueueNode1) < 0) {
                this.bubbleDown(v, priorityQueueNode1);
                return true;
            }
            this.bubbleUp(v, priorityQueueNode1);
            return true;
        }
        this.queue[v] = null;
        return true;
    }

    @Override  // io.netty.util.internal.PriorityQueue
    public boolean removeTyped(Object object0) {
        return this.removeTyped(((PriorityQueueNode)object0));
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(this.queue, this.size);
    }

    @Override
    public Object[] toArray(Object[] arr_object) {
        int v = this.size;
        if(arr_object.length < v) {
            return Arrays.copyOf(this.queue, v, arr_object.getClass());
        }
        System.arraycopy(this.queue, 0, arr_object, 0, v);
        int v1 = this.size;
        if(arr_object.length > v1) {
            arr_object[v1] = null;
        }
        return arr_object;
    }

    class io.netty.util.internal.DefaultPriorityQueue.1 {
    }

}

