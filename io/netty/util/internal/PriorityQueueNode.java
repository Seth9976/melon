package io.netty.util.internal;

public interface PriorityQueueNode {
    public static final int INDEX_NOT_IN_QUEUE = -1;

    int priorityQueueIndex(DefaultPriorityQueue arg1);

    void priorityQueueIndex(DefaultPriorityQueue arg1, int arg2);
}

