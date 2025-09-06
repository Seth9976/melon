package io.netty.util.internal;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.NoSuchElementException;

public final class EmptyPriorityQueue implements PriorityQueue {
    private static final PriorityQueue INSTANCE;

    static {
        EmptyPriorityQueue.INSTANCE = new EmptyPriorityQueue();
    }

    @Override
    public boolean add(Object object0) {
        return false;
    }

    @Override
    public boolean addAll(Collection collection0) {
        return false;
    }

    @Override
    public void clear() {
    }

    @Override  // io.netty.util.internal.PriorityQueue
    public void clearIgnoringIndexes() {
    }

    @Override
    public boolean contains(Object object0) {
        return false;
    }

    @Override
    public boolean containsAll(Collection collection0) {
        return false;
    }

    @Override  // io.netty.util.internal.PriorityQueue
    public boolean containsTyped(Object object0) {
        return false;
    }

    @Override
    public Object element() {
        throw new NoSuchElementException();
    }

    // 去混淆评级： 低(20)
    @Override
    public boolean equals(Object object0) {
        return object0 instanceof PriorityQueue && ((PriorityQueue)object0).isEmpty();
    }

    @Override
    public int hashCode() {
        return 0;
    }

    public static EmptyPriorityQueue instance() {
        return (EmptyPriorityQueue)EmptyPriorityQueue.INSTANCE;
    }

    @Override
    public boolean isEmpty() {
        return true;
    }

    @Override
    public Iterator iterator() {
        return Collections.EMPTY_LIST.iterator();
    }

    @Override
    public boolean offer(Object object0) {
        return false;
    }

    @Override
    public Object peek() {
        return null;
    }

    @Override
    public Object poll() {
        return null;
    }

    @Override  // io.netty.util.internal.PriorityQueue
    public void priorityChanged(Object object0) {
    }

    @Override
    public Object remove() {
        throw new NoSuchElementException();
    }

    @Override
    public boolean remove(Object object0) {
        return false;
    }

    @Override
    public boolean removeAll(Collection collection0) {
        return false;
    }

    @Override  // io.netty.util.internal.PriorityQueue
    public boolean removeTyped(Object object0) {
        return false;
    }

    @Override
    public boolean retainAll(Collection collection0) {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public Object[] toArray() {
        return EmptyArrays.EMPTY_OBJECTS;
    }

    @Override
    public Object[] toArray(Object[] arr_object) {
        if(arr_object.length > 0) {
            arr_object[0] = null;
        }
        return arr_object;
    }

    @Override
    public String toString() {
        return "EmptyPriorityQueue";
    }
}

