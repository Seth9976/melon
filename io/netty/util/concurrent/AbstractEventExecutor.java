package io.netty.util.concurrent;

import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.Callable;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.TimeUnit;
import org.jetbrains.annotations.Async.Execute;

public abstract class AbstractEventExecutor extends AbstractExecutorService implements EventExecutor {
    @Deprecated
    public interface LazyRunnable extends Runnable {
    }

    static final long DEFAULT_SHUTDOWN_QUIET_PERIOD = 2L;
    static final long DEFAULT_SHUTDOWN_TIMEOUT = 15L;
    private static final InternalLogger logger;
    private final EventExecutorGroup parent;
    private final Collection selfCollection;

    static {
        AbstractEventExecutor.logger = InternalLoggerFactory.getInstance(AbstractEventExecutor.class);
    }

    public AbstractEventExecutor() {
        this(null);
    }

    public AbstractEventExecutor(EventExecutorGroup eventExecutorGroup0) {
        this.selfCollection = Collections.singleton(this);
        this.parent = eventExecutorGroup0;
    }

    @Override  // io.netty.util.concurrent.EventExecutor
    public boolean inEventLoop() {
        return this.inEventLoop(Thread.currentThread());
    }

    @Override  // io.netty.util.concurrent.EventExecutorGroup
    public Iterator iterator() {
        return this.selfCollection.iterator();
    }

    public void lazyExecute(Runnable runnable0) {
        this.execute(runnable0);
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

    @Override
    public final RunnableFuture newTaskFor(Runnable runnable0, Object object0) {
        return new PromiseTask(this, runnable0, object0);
    }

    @Override
    public final RunnableFuture newTaskFor(Callable callable0) {
        return new PromiseTask(this, callable0);
    }

    @Override  // io.netty.util.concurrent.EventExecutor
    public EventExecutor next() {
        return this;
    }

    @Override  // io.netty.util.concurrent.EventExecutor
    public EventExecutorGroup parent() {
        return this.parent;
    }

    public static void runTask(@Execute Runnable runnable0) {
        runnable0.run();
    }

    public static void safeExecute(Runnable runnable0) {
        try {
            AbstractEventExecutor.runTask(runnable0);
        }
        catch(Throwable throwable0) {
            AbstractEventExecutor.logger.warn("A task raised an exception. Task: {}", runnable0, throwable0);
        }
    }

    @Override  // io.netty.util.concurrent.EventExecutorGroup
    public ScheduledFuture schedule(Runnable runnable0, long v, TimeUnit timeUnit0) {
        throw new UnsupportedOperationException();
    }

    @Override  // io.netty.util.concurrent.EventExecutorGroup
    public ScheduledFuture schedule(Callable callable0, long v, TimeUnit timeUnit0) {
        throw new UnsupportedOperationException();
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
        throw new UnsupportedOperationException();
    }

    @Override
    public java.util.concurrent.ScheduledFuture scheduleAtFixedRate(Runnable runnable0, long v, long v1, TimeUnit timeUnit0) {
        return this.scheduleAtFixedRate(runnable0, v, v1, timeUnit0);
    }

    @Override  // io.netty.util.concurrent.EventExecutorGroup
    public ScheduledFuture scheduleWithFixedDelay(Runnable runnable0, long v, long v1, TimeUnit timeUnit0) {
        throw new UnsupportedOperationException();
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
}

