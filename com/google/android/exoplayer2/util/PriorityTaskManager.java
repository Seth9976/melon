package com.google.android.exoplayer2.util;

import java.io.IOException;
import java.util.Collections;
import java.util.PriorityQueue;

public final class PriorityTaskManager {
    public static class PriorityTooLowException extends IOException {
        public PriorityTooLowException(int v, int v1) {
            super("Priority too low [priority=" + v + ", highest=" + v1 + "]");
        }
    }

    private int highestPriority;
    private final Object lock;
    private final PriorityQueue queue;

    public PriorityTaskManager() {
        this.lock = new Object();
        this.queue = new PriorityQueue(10, Collections.reverseOrder());
        this.highestPriority = 0x80000000;
    }

    public void add(int v) {
        synchronized(this.lock) {
            this.queue.add(v);
            this.highestPriority = Math.max(this.highestPriority, v);
        }
    }

    public void proceed(int v) {
        synchronized(this.lock) {
            while(this.highestPriority != v) {
                this.lock.wait();
            }
        }
    }

    public boolean proceedNonBlocking(int v) {
        synchronized(this.lock) {
        }
        return this.highestPriority == v;
    }

    public void proceedOrThrow(int v) {
        synchronized(this.lock) {
            if(this.highestPriority == v) {
                return;
            }
        }
        throw new PriorityTooLowException(v, this.highestPriority);
    }

    public void remove(int v) {
        synchronized(this.lock) {
            this.queue.remove(v);
            this.highestPriority = this.queue.isEmpty() ? 0x80000000 : ((int)(((Integer)Util.castNonNull(((Integer)this.queue.peek())))));
            this.lock.notifyAll();
        }
    }
}

