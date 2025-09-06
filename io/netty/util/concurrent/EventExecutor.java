package io.netty.util.concurrent;

public interface EventExecutor extends EventExecutorGroup {
    boolean inEventLoop();

    boolean inEventLoop(Thread arg1);

    Future newFailedFuture(Throwable arg1);

    ProgressivePromise newProgressivePromise();

    Promise newPromise();

    Future newSucceededFuture(Object arg1);

    @Override  // io.netty.util.concurrent.EventExecutorGroup
    EventExecutor next();

    EventExecutorGroup parent();
}

