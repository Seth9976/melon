package io.netty.util.concurrent;

import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.Delayed;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.RunnableScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

public final class UnorderedThreadPoolEventExecutor extends ScheduledThreadPoolExecutor implements EventExecutor {
    static final class NonNotifyRunnable implements Runnable {
        private final Runnable task;

        public NonNotifyRunnable(Runnable runnable0) {
            this.task = runnable0;
        }

        @Override
        public void run() {
            this.task.run();
        }
    }

    static final class RunnableScheduledFutureTask extends PromiseTask implements ScheduledFuture, RunnableScheduledFuture {
        static final boolean $assertionsDisabled;
        private final RunnableScheduledFuture future;
        private final boolean wasCallable;

        public RunnableScheduledFutureTask(EventExecutor eventExecutor0, RunnableScheduledFuture runnableScheduledFuture0, boolean z) {
            super(eventExecutor0, runnableScheduledFuture0);
            this.future = runnableScheduledFuture0;
            this.wasCallable = z;
        }

        @Override
        public int compareTo(Object object0) {
            return this.compareTo(((Delayed)object0));
        }

        public int compareTo(Delayed delayed0) {
            return this.future.compareTo(delayed0);
        }

        @Override
        public long getDelay(TimeUnit timeUnit0) {
            return this.future.getDelay(timeUnit0);
        }

        @Override
        public boolean isPeriodic() {
            return this.future.isPeriodic();
        }

        @Override  // io.netty.util.concurrent.PromiseTask
        public void run() {
            if(!this.isPeriodic()) {
                super.run();
                return;
            }
            if(!this.isDone()) {
                try {
                    this.runTask();
                }
                catch(Throwable throwable0) {
                    if(!this.tryFailureInternal(throwable0)) {
                        UnorderedThreadPoolEventExecutor.logger.warn("Failure during execution of task", throwable0);
                    }
                }
            }
        }

        @Override  // io.netty.util.concurrent.PromiseTask
        public Object runTask() {
            Object object0 = super.runTask();
            if(object0 == null && this.wasCallable) {
                try {
                    return this.future.get();
                }
                catch(ExecutionException executionException0) {
                    throw executionException0.getCause();
                }
            }
            return object0;
        }
    }

    private final Set executorSet;
    private static final InternalLogger logger;
    private final Promise terminationFuture;

    static {
        UnorderedThreadPoolEventExecutor.logger = InternalLoggerFactory.getInstance(UnorderedThreadPoolEventExecutor.class);
    }

    public UnorderedThreadPoolEventExecutor(int v) {
        this(v, new DefaultThreadFactory(UnorderedThreadPoolEventExecutor.class));
    }

    public UnorderedThreadPoolEventExecutor(int v, RejectedExecutionHandler rejectedExecutionHandler0) {
        this(v, new DefaultThreadFactory(UnorderedThreadPoolEventExecutor.class), rejectedExecutionHandler0);
    }

    public UnorderedThreadPoolEventExecutor(int v, ThreadFactory threadFactory0) {
        super(v, threadFactory0);
        this.terminationFuture = GlobalEventExecutor.INSTANCE.newPromise();
        this.executorSet = Collections.singleton(this);
    }

    public UnorderedThreadPoolEventExecutor(int v, ThreadFactory threadFactory0, RejectedExecutionHandler rejectedExecutionHandler0) {
        super(v, threadFactory0, rejectedExecutionHandler0);
        this.terminationFuture = GlobalEventExecutor.INSTANCE.newPromise();
        this.executorSet = Collections.singleton(this);
    }

    @Override
    public RunnableScheduledFuture decorateTask(Runnable runnable0, RunnableScheduledFuture runnableScheduledFuture0) {
        return runnable0 instanceof NonNotifyRunnable ? runnableScheduledFuture0 : new RunnableScheduledFutureTask(this, runnableScheduledFuture0, false);
    }

    @Override
    public RunnableScheduledFuture decorateTask(Callable callable0, RunnableScheduledFuture runnableScheduledFuture0) {
        return new RunnableScheduledFutureTask(this, runnableScheduledFuture0, true);
    }

    @Override
    public void execute(Runnable runnable0) {
        super.schedule(new NonNotifyRunnable(runnable0), 0L, TimeUnit.NANOSECONDS);
    }

    @Override  // io.netty.util.concurrent.EventExecutor
    public boolean inEventLoop() {
        return false;
    }

    @Override  // io.netty.util.concurrent.EventExecutor
    public boolean inEventLoop(Thread thread0) {
        return false;
    }

    @Override  // io.netty.util.concurrent.EventExecutorGroup
    public boolean isShuttingDown() {
        return this.isShutdown();
    }

    @Override  // io.netty.util.concurrent.EventExecutorGroup
    public Iterator iterator() {
        return this.executorSet.iterator();
    }

    @Override  // io.netty.util.concurrent.EventExecutor
    public Future newFailedFuture(Throwable throwable0) {
        return new FailedFuture(this, throwable0);
    }

    @Override  // io.netty.util.concurrent.EventExecutor
    public ProgressivePromise newProgressivePromise() {
        return new DefaultProgressivePromise(this);
    }

    @Override  // io.netty.util.concurrent.EventExecutor
    public Promise newPromise() {
        return new DefaultPromise(this);
    }

    @Override  // io.netty.util.concurrent.EventExecutor
    public Future newSucceededFuture(Object object0) {
        return new SucceededFuture(this, object0);
    }

    @Override  // io.netty.util.concurrent.EventExecutor
    public EventExecutor next() {
        return this;
    }

    @Override  // io.netty.util.concurrent.EventExecutor
    public EventExecutorGroup parent() {
        return this;
    }

    @Override  // io.netty.util.concurrent.EventExecutorGroup
    public ScheduledFuture schedule(Runnable runnable0, long v, TimeUnit timeUnit0) {
        return (ScheduledFuture)super.schedule(runnable0, v, timeUnit0);
    }

    @Override  // io.netty.util.concurrent.EventExecutorGroup
    public ScheduledFuture schedule(Callable callable0, long v, TimeUnit timeUnit0) {
        return (ScheduledFuture)super.schedule(callable0, v, timeUnit0);
    }

    @Override
    public java.util.concurrent.ScheduledFuture schedule(Runnable runnable0, long v, TimeUnit timeUnit0) {
        return this.schedule(runnable0, v, timeUnit0);
    }

    @Override
    public java.util.concurrent.ScheduledFuture schedule(Callable callable0, long v, TimeUnit timeUnit0) {
        return this.schedule(callable0, v, timeUnit0);
    }

    @Override  // io.netty.util.concurrent.EventExecutorGroup
    public ScheduledFuture scheduleAtFixedRate(Runnable runnable0, long v, long v1, TimeUnit timeUnit0) {
        return (ScheduledFuture)super.scheduleAtFixedRate(runnable0, v, v1, timeUnit0);
    }

    @Override
    public java.util.concurrent.ScheduledFuture scheduleAtFixedRate(Runnable runnable0, long v, long v1, TimeUnit timeUnit0) {
        return this.scheduleAtFixedRate(runnable0, v, v1, timeUnit0);
    }

    @Override  // io.netty.util.concurrent.EventExecutorGroup
    public ScheduledFuture scheduleWithFixedDelay(Runnable runnable0, long v, long v1, TimeUnit timeUnit0) {
        return (ScheduledFuture)super.scheduleWithFixedDelay(runnable0, v, v1, timeUnit0);
    }

    @Override
    public java.util.concurrent.ScheduledFuture scheduleWithFixedDelay(Runnable runnable0, long v, long v1, TimeUnit timeUnit0) {
        return this.scheduleWithFixedDelay(runnable0, v, v1, timeUnit0);
    }

    @Override  // io.netty.util.concurrent.EventExecutorGroup
    public void shutdown() {
        super.shutdown();
        this.terminationFuture.trySuccess(null);
    }

    @Override  // io.netty.util.concurrent.EventExecutorGroup
    public Future shutdownGracefully() {
        return this.shutdownGracefully(2L, 15L, TimeUnit.SECONDS);
    }

    @Override  // io.netty.util.concurrent.EventExecutorGroup
    public Future shutdownGracefully(long v, long v1, TimeUnit timeUnit0) {
        this.shutdown();
        return this.terminationFuture();
    }

    @Override  // io.netty.util.concurrent.EventExecutorGroup
    public List shutdownNow() {
        List list0 = super.shutdownNow();
        this.terminationFuture.trySuccess(null);
        return list0;
    }

    @Override  // io.netty.util.concurrent.EventExecutorGroup
    public Future submit(Runnable runnable0) {
        return (Future)super.submit(runnable0);
    }

    @Override  // io.netty.util.concurrent.EventExecutorGroup
    public Future submit(Runnable runnable0, Object object0) {
        return (Future)super.submit(runnable0, object0);
    }

    @Override  // io.netty.util.concurrent.EventExecutorGroup
    public Future submit(Callable callable0) {
        return (Future)super.submit(callable0);
    }

    @Override
    public java.util.concurrent.Future submit(Runnable runnable0) {
        return this.submit(runnable0);
    }

    @Override
    public java.util.concurrent.Future submit(Runnable runnable0, Object object0) {
        return this.submit(runnable0, object0);
    }

    @Override
    public java.util.concurrent.Future submit(Callable callable0) {
        return this.submit(callable0);
    }

    @Override  // io.netty.util.concurrent.EventExecutorGroup
    public Future terminationFuture() {
        return this.terminationFuture;
    }
}

