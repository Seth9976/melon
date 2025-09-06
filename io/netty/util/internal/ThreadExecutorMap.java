package io.netty.util.internal;

import io.netty.util.concurrent.EventExecutor;
import io.netty.util.concurrent.FastThreadLocal;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadFactory;

public final class ThreadExecutorMap {
    private static final FastThreadLocal mappings;

    static {
        ThreadExecutorMap.mappings = new FastThreadLocal();
    }

    public static Runnable apply(Runnable runnable0, EventExecutor eventExecutor0) {
        ObjectUtil.checkNotNull(runnable0, "command");
        ObjectUtil.checkNotNull(eventExecutor0, "eventExecutor");
        return new Runnable() {
            @Override
            public void run() {
                ThreadExecutorMap.setCurrentEventExecutor(eventExecutor0);
                try {
                    runnable0.run();
                }
                finally {
                    ThreadExecutorMap.setCurrentEventExecutor(null);
                }
            }
        };
    }

    public static Executor apply(Executor executor0, EventExecutor eventExecutor0) {
        ObjectUtil.checkNotNull(executor0, "executor");
        ObjectUtil.checkNotNull(eventExecutor0, "eventExecutor");
        return new Executor() {
            @Override
            public void execute(Runnable runnable0) {
                Runnable runnable1 = ThreadExecutorMap.apply(runnable0, eventExecutor0);
                executor0.execute(runnable1);
            }
        };
    }

    public static ThreadFactory apply(ThreadFactory threadFactory0, EventExecutor eventExecutor0) {
        ObjectUtil.checkNotNull(threadFactory0, "threadFactory");
        ObjectUtil.checkNotNull(eventExecutor0, "eventExecutor");
        return new ThreadFactory() {
            @Override
            public Thread newThread(Runnable runnable0) {
                Runnable runnable1 = ThreadExecutorMap.apply(runnable0, eventExecutor0);
                return threadFactory0.newThread(runnable1);
            }
        };
    }

    public static EventExecutor currentExecutor() {
        return (EventExecutor)ThreadExecutorMap.mappings.get();
    }

    private static void setCurrentEventExecutor(EventExecutor eventExecutor0) {
        ThreadExecutorMap.mappings.set(eventExecutor0);
    }
}

