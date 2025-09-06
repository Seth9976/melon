package io.netty.util.concurrent;

import io.netty.util.internal.ObjectUtil;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadFactory;

public final class ThreadPerTaskExecutor implements Executor {
    private final ThreadFactory threadFactory;

    public ThreadPerTaskExecutor(ThreadFactory threadFactory0) {
        this.threadFactory = (ThreadFactory)ObjectUtil.checkNotNull(threadFactory0, "threadFactory");
    }

    @Override
    public void execute(Runnable runnable0) {
        this.threadFactory.newThread(runnable0).start();
    }
}

