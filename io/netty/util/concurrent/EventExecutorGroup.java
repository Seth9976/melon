package io.netty.util.concurrent;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public interface EventExecutorGroup extends Iterable, ScheduledExecutorService {
    boolean isShuttingDown();

    @Override
    Iterator iterator();

    EventExecutor next();

    ScheduledFuture schedule(Runnable arg1, long arg2, TimeUnit arg3);

    ScheduledFuture schedule(Callable arg1, long arg2, TimeUnit arg3);

    ScheduledFuture scheduleAtFixedRate(Runnable arg1, long arg2, long arg3, TimeUnit arg4);

    ScheduledFuture scheduleWithFixedDelay(Runnable arg1, long arg2, long arg3, TimeUnit arg4);

    @Override
    @Deprecated
    void shutdown();

    Future shutdownGracefully();

    Future shutdownGracefully(long arg1, long arg2, TimeUnit arg3);

    @Override
    @Deprecated
    List shutdownNow();

    Future submit(Runnable arg1);

    Future submit(Runnable arg1, Object arg2);

    Future submit(Callable arg1);

    Future terminationFuture();
}

