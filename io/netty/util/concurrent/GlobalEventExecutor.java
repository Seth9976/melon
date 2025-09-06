package io.netty.util.concurrent;

import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PriorityQueue;
import io.netty.util.internal.SystemPropertyUtil;
import io.netty.util.internal.ThreadExecutorMap;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.jetbrains.annotations.Async.Schedule;

public final class GlobalEventExecutor extends AbstractScheduledEventExecutor implements OrderedEventExecutor {
    final class TaskRunner implements Runnable {
        static final boolean $assertionsDisabled;

        @Override
        public void run() {
            do {
                do {
                    do {
                        Runnable runnable0 = GlobalEventExecutor.this.takeTask();
                        if(runnable0 == null) {
                            break;
                        }
                        try {
                            AbstractEventExecutor.runTask(runnable0);
                        }
                        catch(Throwable throwable0) {
                            GlobalEventExecutor.logger.warn("Unexpected exception from the global event executor: ", throwable0);
                        }
                    }
                    while(runnable0 != GlobalEventExecutor.this.quietPeriodTask);
                    PriorityQueue priorityQueue0 = GlobalEventExecutor.this.scheduledTaskQueue;
                }
                while(!GlobalEventExecutor.this.taskQueue.isEmpty() || priorityQueue0 != null && priorityQueue0.size() != 1);
                GlobalEventExecutor.this.started.compareAndSet(true, false);
            }
            while(!GlobalEventExecutor.this.taskQueue.isEmpty() && GlobalEventExecutor.this.started.compareAndSet(false, true));
        }
    }

    public static final GlobalEventExecutor INSTANCE;
    private static final long SCHEDULE_QUIET_PERIOD_INTERVAL;
    private static final InternalLogger logger;
    final ScheduledFutureTask quietPeriodTask;
    private final AtomicBoolean started;
    final BlockingQueue taskQueue;
    private final TaskRunner taskRunner;
    private final Future terminationFuture;
    volatile Thread thread;
    final ThreadFactory threadFactory;

    static {
        InternalLogger internalLogger0 = InternalLoggerFactory.getInstance(GlobalEventExecutor.class);
        GlobalEventExecutor.logger = internalLogger0;
        int v = 1;
        int v1 = SystemPropertyUtil.getInt("io.netty.globalEventExecutor.quietPeriodSeconds", 1);
        if(v1 > 0) {
            v = v1;
        }
        internalLogger0.debug("-Dio.netty.globalEventExecutor.quietPeriodSeconds: {}", v);
        GlobalEventExecutor.SCHEDULE_QUIET_PERIOD_INTERVAL = TimeUnit.SECONDS.toNanos(((long)v));
        GlobalEventExecutor.INSTANCE = new GlobalEventExecutor();
    }

    private GlobalEventExecutor() {
        this.taskQueue = new LinkedBlockingQueue();
        ScheduledFutureTask scheduledFutureTask0 = new ScheduledFutureTask(this, Executors.callable(new Runnable() {
            @Override
            public void run() {
            }
        }, null), AbstractScheduledEventExecutor.deadlineNanos(this.getCurrentTimeNanos(), GlobalEventExecutor.SCHEDULE_QUIET_PERIOD_INTERVAL), -GlobalEventExecutor.SCHEDULE_QUIET_PERIOD_INTERVAL);
        this.quietPeriodTask = scheduledFutureTask0;
        this.taskRunner = new TaskRunner(this);
        this.started = new AtomicBoolean();
        this.terminationFuture = new FailedFuture(this, new UnsupportedOperationException());
        this.scheduledTaskQueue().add(scheduledFutureTask0);
        this.threadFactory = ThreadExecutorMap.apply(new DefaultThreadFactory("globalEventExecutor", false, 5, null), this);
    }

    private void addTask(Runnable runnable0) {
        Object object0 = ObjectUtil.checkNotNull(runnable0, "task");
        this.taskQueue.add(object0);
    }

    public boolean awaitInactivity(long v, TimeUnit timeUnit0) {
        ObjectUtil.checkNotNull(timeUnit0, "unit");
        Thread thread0 = this.thread;
        if(thread0 == null) {
            throw new IllegalStateException("thread was not started");
        }
        thread0.join(timeUnit0.toMillis(v));
        return !thread0.isAlive();
    }

    @Override
    public boolean awaitTermination(long v, TimeUnit timeUnit0) {
        return false;
    }

    @Override
    public void execute(Runnable runnable0) {
        this.execute0(runnable0);
    }

    private void execute0(@Schedule Runnable runnable0) {
        this.addTask(((Runnable)ObjectUtil.checkNotNull(runnable0, "task")));
        if(!this.inEventLoop()) {
            this.startThread();
        }
    }

    private void fetchFromScheduledTaskQueue() {
        long v = this.getCurrentTimeNanos();
        for(Runnable runnable0 = this.pollScheduledTask(v); runnable0 != null; runnable0 = this.pollScheduledTask(v)) {
            this.taskQueue.add(runnable0);
        }
    }

    @Override  // io.netty.util.concurrent.EventExecutor
    public boolean inEventLoop(Thread thread0) {
        return thread0 == this.thread;
    }

    @Override
    public boolean isShutdown() {
        return false;
    }

    @Override  // io.netty.util.concurrent.EventExecutorGroup
    public boolean isShuttingDown() {
        return false;
    }

    @Override
    public boolean isTerminated() {
        return false;
    }

    public int pendingTasks() {
        return this.taskQueue.size();
    }

    @Override  // io.netty.util.concurrent.AbstractEventExecutor, io.netty.util.concurrent.EventExecutorGroup
    @Deprecated
    public void shutdown() {
        throw new UnsupportedOperationException();
    }

    @Override  // io.netty.util.concurrent.EventExecutorGroup
    public Future shutdownGracefully(long v, long v1, TimeUnit timeUnit0) {
        return this.terminationFuture();
    }

    private void startThread() {
        if(this.started.compareAndSet(false, true)) {
            Thread thread0 = this.threadFactory.newThread(this.taskRunner);
            AccessController.doPrivileged(new PrivilegedAction() {
                @Override
                public Object run() {
                    return this.run();
                }

                public Void run() {
                    thread0.setContextClassLoader(null);
                    return null;
                }
            });
            this.thread = thread0;
            thread0.start();
        }
    }

    public Runnable takeTask() {
        Runnable runnable0;
        BlockingQueue blockingQueue0 = this.taskQueue;
        do {
            ScheduledFutureTask scheduledFutureTask0 = this.peekScheduledTask();
            runnable0 = null;
            if(scheduledFutureTask0 == null) {
                try {
                    return (Runnable)blockingQueue0.take();
                }
                catch(InterruptedException unused_ex) {
                    return null;
                }
            }
            long v = scheduledFutureTask0.delayNanos();
            if(v > 0L) {
                try {
                    runnable0 = (Runnable)blockingQueue0.poll(v, TimeUnit.NANOSECONDS);
                }
                catch(InterruptedException unused_ex) {
                    return null;
                }
            }
            if(runnable0 == null) {
                this.fetchFromScheduledTaskQueue();
                runnable0 = (Runnable)blockingQueue0.poll();
            }
        }
        while(runnable0 == null);
        return runnable0;
    }

    @Override  // io.netty.util.concurrent.EventExecutorGroup
    public Future terminationFuture() {
        return this.terminationFuture;
    }
}

