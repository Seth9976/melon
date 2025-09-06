package io.netty.util.concurrent;

import io.netty.util.internal.DefaultPriorityQueue;
import io.netty.util.internal.PriorityQueueNode;
import java.util.concurrent.Callable;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

final class ScheduledFutureTask extends PromiseTask implements ScheduledFuture, PriorityQueueNode {
    static final boolean $assertionsDisabled;
    private long deadlineNanos;
    private long id;
    private final long periodNanos;
    private int queueIndex;

    public ScheduledFutureTask(AbstractScheduledEventExecutor abstractScheduledEventExecutor0, Runnable runnable0, long v) {
        super(abstractScheduledEventExecutor0, runnable0);
        this.queueIndex = -1;
        this.deadlineNanos = v;
        this.periodNanos = 0L;
    }

    public ScheduledFutureTask(AbstractScheduledEventExecutor abstractScheduledEventExecutor0, Runnable runnable0, long v, long v1) {
        super(abstractScheduledEventExecutor0, runnable0);
        this.queueIndex = -1;
        this.deadlineNanos = v;
        this.periodNanos = ScheduledFutureTask.validatePeriod(v1);
    }

    public ScheduledFutureTask(AbstractScheduledEventExecutor abstractScheduledEventExecutor0, Callable callable0, long v) {
        super(abstractScheduledEventExecutor0, callable0);
        this.queueIndex = -1;
        this.deadlineNanos = v;
        this.periodNanos = 0L;
    }

    public ScheduledFutureTask(AbstractScheduledEventExecutor abstractScheduledEventExecutor0, Callable callable0, long v, long v1) {
        super(abstractScheduledEventExecutor0, callable0);
        this.queueIndex = -1;
        this.deadlineNanos = v;
        this.periodNanos = ScheduledFutureTask.validatePeriod(v1);
    }

    @Override  // io.netty.util.concurrent.PromiseTask, io.netty.util.concurrent.Future
    public boolean cancel(boolean z) {
        boolean z1 = super.cancel(z);
        if(z1) {
            this.scheduledExecutor().removeScheduled(this);
        }
        return z1;
    }

    public boolean cancelWithoutRemove(boolean z) {
        return super.cancel(z);
    }

    @Override
    public int compareTo(Object object0) {
        return this.compareTo(((Delayed)object0));
    }

    public int compareTo(Delayed delayed0) {
        if(this == delayed0) {
            return 0;
        }
        int v = Long.compare(this.deadlineNanos() - ((ScheduledFutureTask)delayed0).deadlineNanos(), 0L);
        if(v < 0) {
            return -1;
        }
        if(v > 0) {
            return 1;
        }
        return this.id >= ((ScheduledFutureTask)delayed0).id ? 1 : -1;
    }

    public long deadlineNanos() {
        return this.deadlineNanos;
    }

    public static long deadlineToDelayNanos(long v, long v1) {
        return v1 == 0L ? 0L : Math.max(0L, v1 - v);
    }

    public long delayNanos() {
        return this.delayNanos(this.scheduledExecutor().getCurrentTimeNanos());
    }

    public long delayNanos(long v) {
        return ScheduledFutureTask.deadlineToDelayNanos(v, this.deadlineNanos);
    }

    @Override  // io.netty.util.concurrent.DefaultPromise
    public EventExecutor executor() {
        return super.executor();
    }

    @Override
    public long getDelay(TimeUnit timeUnit0) {
        return timeUnit0.convert(this.delayNanos(), TimeUnit.NANOSECONDS);
    }

    @Override  // io.netty.util.internal.PriorityQueueNode
    public int priorityQueueIndex(DefaultPriorityQueue defaultPriorityQueue0) {
        return this.queueIndex;
    }

    @Override  // io.netty.util.internal.PriorityQueueNode
    public void priorityQueueIndex(DefaultPriorityQueue defaultPriorityQueue0, int v) {
        this.queueIndex = v;
    }

    @Override  // io.netty.util.concurrent.PromiseTask
    public void run() {
        try {
            if(this.delayNanos() > 0L) {
                if(this.isCancelled()) {
                    this.scheduledExecutor().scheduledTaskQueue().removeTyped(this);
                    return;
                }
                this.scheduledExecutor().scheduleFromEventLoop(this);
                return;
            }
            if(this.periodNanos == 0L) {
                if(this.setUncancellableInternal()) {
                    this.setSuccessInternal(this.runTask());
                    return;
                }
            }
            else if(!this.isCancelled()) {
                this.runTask();
                if(!this.executor().isShutdown()) {
                    long v = this.periodNanos;
                    if(v > 0L) {
                        this.deadlineNanos += v;
                    }
                    else {
                        this.deadlineNanos = this.scheduledExecutor().getCurrentTimeNanos() - this.periodNanos;
                    }
                    if(!this.isCancelled()) {
                        this.scheduledExecutor().scheduledTaskQueue().add(this);
                    }
                }
            }
            return;
        }
        catch(Throwable throwable0) {
        }
        this.setFailureInternal(throwable0);
    }

    private AbstractScheduledEventExecutor scheduledExecutor() {
        return (AbstractScheduledEventExecutor)this.executor();
    }

    public void setConsumed() {
        if(this.periodNanos == 0L) {
            this.deadlineNanos = 0L;
        }
    }

    public ScheduledFutureTask setId(long v) {
        if(this.id == 0L) {
            this.id = v;
        }
        return this;
    }

    @Override  // io.netty.util.concurrent.PromiseTask
    public StringBuilder toStringBuilder() {
        StringBuilder stringBuilder0 = super.toStringBuilder();
        stringBuilder0.setCharAt(stringBuilder0.length() - 1, ',');
        stringBuilder0.append(" deadline: ");
        stringBuilder0.append(this.deadlineNanos);
        stringBuilder0.append(", period: ");
        stringBuilder0.append(this.periodNanos);
        stringBuilder0.append(')');
        return stringBuilder0;
    }

    private static long validatePeriod(long v) {
        if(v == 0L) {
            throw new IllegalArgumentException("period: 0 (expected: != 0)");
        }
        return v;
    }
}

