package org.apache.http.impl.client;

import U4.x;
import java.util.concurrent.atomic.AtomicLong;

public final class FutureRequestExecutionMetrics {
    static class DurationCounter {
        private final AtomicLong count;
        private final AtomicLong cumulativeDuration;

        public DurationCounter() {
            this.count = new AtomicLong(0L);
            this.cumulativeDuration = new AtomicLong(0L);
        }

        public long averageDuration() {
            long v = this.count.get();
            return v <= 0L ? 0L : this.cumulativeDuration.get() / v;
        }

        public long count() {
            return this.count.get();
        }

        public void increment(long v) {
            this.count.incrementAndGet();
            this.cumulativeDuration.addAndGet(System.currentTimeMillis() - v);
        }

        @Override
        public String toString() {
            StringBuilder stringBuilder0 = new StringBuilder("[count=");
            stringBuilder0.append(this.count());
            stringBuilder0.append(", averageDuration=");
            return x.h(this.averageDuration(), "]", stringBuilder0);
        }
    }

    private final AtomicLong activeConnections;
    private final DurationCounter failedConnections;
    private final DurationCounter requests;
    private final AtomicLong scheduledConnections;
    private final DurationCounter successfulConnections;
    private final DurationCounter tasks;

    public FutureRequestExecutionMetrics() {
        this.activeConnections = new AtomicLong();
        this.scheduledConnections = new AtomicLong();
        this.successfulConnections = new DurationCounter();
        this.failedConnections = new DurationCounter();
        this.requests = new DurationCounter();
        this.tasks = new DurationCounter();
    }

    public long getActiveConnectionCount() {
        return this.activeConnections.get();
    }

    public AtomicLong getActiveConnections() {
        return this.activeConnections;
    }

    public long getFailedConnectionAverageDuration() {
        return this.failedConnections.averageDuration();
    }

    public long getFailedConnectionCount() {
        return this.failedConnections.count();
    }

    public DurationCounter getFailedConnections() {
        return this.failedConnections;
    }

    public long getRequestAverageDuration() {
        return this.requests.averageDuration();
    }

    public long getRequestCount() {
        return this.requests.count();
    }

    public DurationCounter getRequests() {
        return this.requests;
    }

    public long getScheduledConnectionCount() {
        return this.scheduledConnections.get();
    }

    public AtomicLong getScheduledConnections() {
        return this.scheduledConnections;
    }

    public long getSuccessfulConnectionAverageDuration() {
        return this.successfulConnections.averageDuration();
    }

    public long getSuccessfulConnectionCount() {
        return this.successfulConnections.count();
    }

    public DurationCounter getSuccessfulConnections() {
        return this.successfulConnections;
    }

    public long getTaskAverageDuration() {
        return this.tasks.averageDuration();
    }

    public long getTaskCount() {
        return this.tasks.count();
    }

    public DurationCounter getTasks() {
        return this.tasks;
    }

    @Override
    public String toString() {
        return "[activeConnections=" + this.activeConnections + ", scheduledConnections=" + this.scheduledConnections + ", successfulConnections=" + this.successfulConnections + ", failedConnections=" + this.failedConnections + ", requests=" + this.requests + ", tasks=" + this.tasks + "]";
    }
}

