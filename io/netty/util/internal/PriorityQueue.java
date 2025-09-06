package io.netty.util.internal;

import java.util.Queue;

public interface PriorityQueue extends Queue {
    void clearIgnoringIndexes();

    boolean containsTyped(Object arg1);

    void priorityChanged(Object arg1);

    boolean removeTyped(Object arg1);
}

