package io.netty.util.concurrent;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadFactory;

public final class DefaultEventExecutor extends SingleThreadEventExecutor {
    public DefaultEventExecutor() {
        this(null);
    }

    public DefaultEventExecutor(EventExecutorGroup eventExecutorGroup0) {
        this(eventExecutorGroup0, new DefaultThreadFactory(DefaultEventExecutor.class));
    }

    public DefaultEventExecutor(EventExecutorGroup eventExecutorGroup0, Executor executor0) {
        super(eventExecutorGroup0, executor0, true);
    }

    public DefaultEventExecutor(EventExecutorGroup eventExecutorGroup0, Executor executor0, int v, RejectedExecutionHandler rejectedExecutionHandler0) {
        super(eventExecutorGroup0, executor0, true, v, rejectedExecutionHandler0);
    }

    public DefaultEventExecutor(EventExecutorGroup eventExecutorGroup0, ThreadFactory threadFactory0) {
        super(eventExecutorGroup0, threadFactory0, true);
    }

    public DefaultEventExecutor(EventExecutorGroup eventExecutorGroup0, ThreadFactory threadFactory0, int v, RejectedExecutionHandler rejectedExecutionHandler0) {
        super(eventExecutorGroup0, threadFactory0, true, v, rejectedExecutionHandler0);
    }

    public DefaultEventExecutor(Executor executor0) {
        this(null, executor0);
    }

    public DefaultEventExecutor(ThreadFactory threadFactory0) {
        this(null, threadFactory0);
    }

    @Override  // io.netty.util.concurrent.SingleThreadEventExecutor
    public void run() {
        do {
            Runnable runnable0 = this.takeTask();
            if(runnable0 != null) {
                AbstractEventExecutor.runTask(runnable0);
                this.updateLastExecutionTime();
            }
        }
        while(!this.confirmShutdown());
    }
}

