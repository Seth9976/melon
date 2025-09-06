package io.netty.util.concurrent;

import io.netty.util.internal.DefaultPriorityQueue;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PriorityQueue;
import java.util.Comparator;
import java.util.Queue;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public abstract class AbstractScheduledEventExecutor extends AbstractEventExecutor {
    static final boolean $assertionsDisabled;
    private static final Comparator SCHEDULED_FUTURE_TASK_COMPARATOR;
    private static final long START_TIME;
    static final Runnable WAKEUP_TASK;
    long nextTaskId;
    PriorityQueue scheduledTaskQueue;

    static {
        AbstractScheduledEventExecutor.SCHEDULED_FUTURE_TASK_COMPARATOR = new Comparator() {
            public int compare(ScheduledFutureTask scheduledFutureTask0, ScheduledFutureTask scheduledFutureTask1) {
                return scheduledFutureTask0.compareTo(scheduledFutureTask1);
            }

            @Override
            public int compare(Object object0, Object object1) {
                return this.compare(((ScheduledFutureTask)object0), ((ScheduledFutureTask)object1));
            }
        };
        AbstractScheduledEventExecutor.START_TIME = System.nanoTime();
        AbstractScheduledEventExecutor.WAKEUP_TASK = new Runnable() {
            @Override
            public void run() {
            }
        };
    }

    public AbstractScheduledEventExecutor() {
    }

    public AbstractScheduledEventExecutor(EventExecutorGroup eventExecutorGroup0) {
        super(eventExecutorGroup0);
    }

    public boolean afterScheduledTaskSubmitted(long v) {
        return true;
    }

    public boolean beforeScheduledTaskSubmitted(long v) {
        return true;
    }

    public void cancelScheduledTasks() {
        PriorityQueue priorityQueue0 = this.scheduledTaskQueue;
        if(AbstractScheduledEventExecutor.isNullOrEmpty(priorityQueue0)) {
            return;
        }
        ScheduledFutureTask[] arr_scheduledFutureTask = (ScheduledFutureTask[])priorityQueue0.toArray(new ScheduledFutureTask[0]);
        for(int v = 0; v < arr_scheduledFutureTask.length; ++v) {
            arr_scheduledFutureTask[v].cancelWithoutRemove(false);
        }
        priorityQueue0.clearIgnoringIndexes();
    }

    public static long deadlineNanos(long v, long v1) {
        long v2 = v + v1;
        return v2 >= 0L ? v2 : 0x7FFFFFFFFFFFFFFFL;
    }

    public static long deadlineToDelayNanos(long v) {
        return ScheduledFutureTask.deadlineToDelayNanos(AbstractScheduledEventExecutor.defaultCurrentTimeNanos(), v);
    }

    public static long defaultCurrentTimeNanos() {
        return System.nanoTime() - AbstractScheduledEventExecutor.START_TIME;
    }

    public long getCurrentTimeNanos() {
        return AbstractScheduledEventExecutor.defaultCurrentTimeNanos();
    }

    public final boolean hasScheduledTasks() {
        ScheduledFutureTask scheduledFutureTask0 = this.peekScheduledTask();
        return scheduledFutureTask0 != null && scheduledFutureTask0.deadlineNanos() <= this.getCurrentTimeNanos();
    }

    public static long initialNanoTime() [...] // 潜在的解密器

    private static boolean isNullOrEmpty(Queue queue0) {
        return queue0 == null || queue0.isEmpty();
    }

    @Deprecated
    public static long nanoTime() {
        return AbstractScheduledEventExecutor.defaultCurrentTimeNanos();
    }

    public final long nextScheduledTaskDeadlineNanos() {
        ScheduledFutureTask scheduledFutureTask0 = this.peekScheduledTask();
        return scheduledFutureTask0 == null ? -1L : scheduledFutureTask0.deadlineNanos();
    }

    public final long nextScheduledTaskNano() {
        ScheduledFutureTask scheduledFutureTask0 = this.peekScheduledTask();
        return scheduledFutureTask0 == null ? -1L : scheduledFutureTask0.delayNanos();
    }

    public final ScheduledFutureTask peekScheduledTask() {
        return this.scheduledTaskQueue == null ? null : ((ScheduledFutureTask)this.scheduledTaskQueue.peek());
    }

    public final Runnable pollScheduledTask() {
        return this.pollScheduledTask(this.getCurrentTimeNanos());
    }

    public final Runnable pollScheduledTask(long v) {
        Runnable runnable0 = this.peekScheduledTask();
        if(runnable0 != null && ((ScheduledFutureTask)runnable0).deadlineNanos() - v <= 0L) {
            this.scheduledTaskQueue.remove();
            ((ScheduledFutureTask)runnable0).setConsumed();
            return runnable0;
        }
        return null;
    }

    public final void removeScheduled(ScheduledFutureTask scheduledFutureTask0) {
        if(this.inEventLoop()) {
            this.scheduledTaskQueue().removeTyped(scheduledFutureTask0);
            return;
        }
        this.lazyExecute(scheduledFutureTask0);
    }

    private ScheduledFuture schedule(ScheduledFutureTask scheduledFutureTask0) {
        if(this.inEventLoop()) {
            this.scheduleFromEventLoop(scheduledFutureTask0);
            return scheduledFutureTask0;
        }
        long v = scheduledFutureTask0.deadlineNanos();
        if(this.beforeScheduledTaskSubmitted(v)) {
            this.execute(scheduledFutureTask0);
            return scheduledFutureTask0;
        }
        this.lazyExecute(scheduledFutureTask0);
        if(this.afterScheduledTaskSubmitted(v)) {
            this.execute(AbstractScheduledEventExecutor.WAKEUP_TASK);
        }
        return scheduledFutureTask0;
    }

    @Override  // io.netty.util.concurrent.AbstractEventExecutor
    public ScheduledFuture schedule(Runnable runnable0, long v, TimeUnit timeUnit0) {
        ObjectUtil.checkNotNull(runnable0, "command");
        ObjectUtil.checkNotNull(timeUnit0, "unit");
        if(v < 0L) {
            v = 0L;
        }
        return this.schedule(new ScheduledFutureTask(this, runnable0, AbstractScheduledEventExecutor.deadlineNanos(this.getCurrentTimeNanos(), timeUnit0.toNanos(v))));
    }

    @Override  // io.netty.util.concurrent.AbstractEventExecutor
    public ScheduledFuture schedule(Callable callable0, long v, TimeUnit timeUnit0) {
        ObjectUtil.checkNotNull(callable0, "callable");
        ObjectUtil.checkNotNull(timeUnit0, "unit");
        if(v < 0L) {
            v = 0L;
        }
        return this.schedule(new ScheduledFutureTask(this, callable0, AbstractScheduledEventExecutor.deadlineNanos(this.getCurrentTimeNanos(), timeUnit0.toNanos(v))));
    }

    @Override  // io.netty.util.concurrent.AbstractEventExecutor
    public java.util.concurrent.ScheduledFuture schedule(Runnable runnable0, long v, TimeUnit timeUnit0) {
        return this.schedule(runnable0, v, timeUnit0);
    }

    @Override  // io.netty.util.concurrent.AbstractEventExecutor
    public java.util.concurrent.ScheduledFuture schedule(Callable callable0, long v, TimeUnit timeUnit0) {
        return this.schedule(callable0, v, timeUnit0);
    }

    @Override  // io.netty.util.concurrent.AbstractEventExecutor
    public ScheduledFuture scheduleAtFixedRate(Runnable runnable0, long v, long v1, TimeUnit timeUnit0) {
        ObjectUtil.checkNotNull(runnable0, "command");
        ObjectUtil.checkNotNull(timeUnit0, "unit");
        if(v < 0L) {
            throw new IllegalArgumentException(String.format("initialDelay: %d (expected: >= 0)", v));
        }
        if(v1 <= 0L) {
            throw new IllegalArgumentException(String.format("period: %d (expected: > 0)", v1));
        }
        return this.schedule(new ScheduledFutureTask(this, runnable0, AbstractScheduledEventExecutor.deadlineNanos(this.getCurrentTimeNanos(), timeUnit0.toNanos(v)), timeUnit0.toNanos(v1)));
    }

    @Override  // io.netty.util.concurrent.AbstractEventExecutor
    public java.util.concurrent.ScheduledFuture scheduleAtFixedRate(Runnable runnable0, long v, long v1, TimeUnit timeUnit0) {
        return this.scheduleAtFixedRate(runnable0, v, v1, timeUnit0);
    }

    public final void scheduleFromEventLoop(ScheduledFutureTask scheduledFutureTask0) {
        PriorityQueue priorityQueue0 = this.scheduledTaskQueue();
        long v = this.nextTaskId + 1L;
        this.nextTaskId = v;
        priorityQueue0.add(scheduledFutureTask0.setId(v));
    }

    @Override  // io.netty.util.concurrent.AbstractEventExecutor
    public ScheduledFuture scheduleWithFixedDelay(Runnable runnable0, long v, long v1, TimeUnit timeUnit0) {
        ObjectUtil.checkNotNull(runnable0, "command");
        ObjectUtil.checkNotNull(timeUnit0, "unit");
        if(v < 0L) {
            throw new IllegalArgumentException(String.format("initialDelay: %d (expected: >= 0)", v));
        }
        if(v1 <= 0L) {
            throw new IllegalArgumentException(String.format("delay: %d (expected: > 0)", v1));
        }
        return this.schedule(new ScheduledFutureTask(this, runnable0, AbstractScheduledEventExecutor.deadlineNanos(this.getCurrentTimeNanos(), timeUnit0.toNanos(v)), -timeUnit0.toNanos(v1)));
    }

    @Override  // io.netty.util.concurrent.AbstractEventExecutor
    public java.util.concurrent.ScheduledFuture scheduleWithFixedDelay(Runnable runnable0, long v, long v1, TimeUnit timeUnit0) {
        return this.scheduleWithFixedDelay(runnable0, v, v1, timeUnit0);
    }

    public PriorityQueue scheduledTaskQueue() {
        if(this.scheduledTaskQueue == null) {
            this.scheduledTaskQueue = new DefaultPriorityQueue(AbstractScheduledEventExecutor.SCHEDULED_FUTURE_TASK_COMPARATOR, 11);
        }
        return this.scheduledTaskQueue;
    }

    @Deprecated
    public void validateScheduled(long v, TimeUnit timeUnit0) {
    }

    private void validateScheduled0(long v, TimeUnit timeUnit0) {
    }
}

