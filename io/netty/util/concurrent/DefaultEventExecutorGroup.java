package io.netty.util.concurrent;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadFactory;

public class DefaultEventExecutorGroup extends MultithreadEventExecutorGroup {
    public DefaultEventExecutorGroup(int v) {
        this(v, null);
    }

    public DefaultEventExecutorGroup(int v, ThreadFactory threadFactory0) {
        this(v, threadFactory0, SingleThreadEventExecutor.DEFAULT_MAX_PENDING_EXECUTOR_TASKS, RejectedExecutionHandlers.reject());
    }

    public DefaultEventExecutorGroup(int v, ThreadFactory threadFactory0, int v1, RejectedExecutionHandler rejectedExecutionHandler0) {
        super(v, threadFactory0, new Object[]{v1, rejectedExecutionHandler0});
    }

    @Override  // io.netty.util.concurrent.MultithreadEventExecutorGroup
    public EventExecutor newChild(Executor executor0, Object[] arr_object) {
        return new DefaultEventExecutor(this, executor0, ((int)(((Integer)arr_object[0]))), ((RejectedExecutionHandler)arr_object[1]));
    }
}

