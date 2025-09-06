package io.netty.util.concurrent;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public abstract class AbstractEventExecutorGroup implements EventExecutorGroup {
    @Override
    public void execute(Runnable runnable0) {
        this.next().execute(runnable0);
    }

    @Override
    public List invokeAll(Collection collection0) {
        return this.next().invokeAll(collection0);
    }

    @Override
    public List invokeAll(Collection collection0, long v, TimeUnit timeUnit0) {
        return this.next().invokeAll(collection0, v, timeUnit0);
    }

    @Override
    public Object invokeAny(Collection collection0) {
        return this.next().invokeAny(collection0);
    }

    @Override
    public Object invokeAny(Collection collection0, long v, TimeUnit timeUnit0) {
        return this.next().invokeAny(collection0, v, timeUnit0);
    }

    @Override  // io.netty.util.concurrent.EventExecutorGroup
    public ScheduledFuture schedule(Runnable runnable0, long v, TimeUnit timeUnit0) {
        return this.next().schedule(runnable0, v, timeUnit0);
    }

    @Override  // io.netty.util.concurrent.EventExecutorGroup
    public ScheduledFuture schedule(Callable callable0, long v, TimeUnit timeUnit0) {
        return this.next().schedule(callable0, v, timeUnit0);
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
        return this.next().scheduleAtFixedRate(runnable0, v, v1, timeUnit0);
    }

    @Override
    public java.util.concurrent.ScheduledFuture scheduleAtFixedRate(Runnable runnable0, long v, long v1, TimeUnit timeUnit0) {
        return this.scheduleAtFixedRate(runnable0, v, v1, timeUnit0);
    }

    @Override  // io.netty.util.concurrent.EventExecutorGroup
    public ScheduledFuture scheduleWithFixedDelay(Runnable runnable0, long v, long v1, TimeUnit timeUnit0) {
        return this.next().scheduleWithFixedDelay(runnable0, v, v1, timeUnit0);
    }

    @Override
    public java.util.concurrent.ScheduledFuture scheduleWithFixedDelay(Runnable runnable0, long v, long v1, TimeUnit timeUnit0) {
        return this.scheduleWithFixedDelay(runnable0, v, v1, timeUnit0);
    }

    @Override  // io.netty.util.concurrent.EventExecutorGroup
    @Deprecated
    public abstract void shutdown();

    @Override  // io.netty.util.concurrent.EventExecutorGroup
    public Future shutdownGracefully() {
        return this.shutdownGracefully(2L, 15L, TimeUnit.SECONDS);
    }

    @Override  // io.netty.util.concurrent.EventExecutorGroup
    @Deprecated
    public List shutdownNow() {
        this.shutdown();
        return Collections.EMPTY_LIST;
    }

    @Override  // io.netty.util.concurrent.EventExecutorGroup
    public Future submit(Runnable runnable0) {
        return this.next().submit(runnable0);
    }

    @Override  // io.netty.util.concurrent.EventExecutorGroup
    public Future submit(Runnable runnable0, Object object0) {
        return this.next().submit(runnable0, object0);
    }

    @Override  // io.netty.util.concurrent.EventExecutorGroup
    public Future submit(Callable callable0) {
        return this.next().submit(callable0);
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
}

