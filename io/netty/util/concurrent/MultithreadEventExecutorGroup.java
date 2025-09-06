package io.netty.util.concurrent;

import io.netty.util.internal.ObjectUtil;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class MultithreadEventExecutorGroup extends AbstractEventExecutorGroup {
    private final EventExecutor[] children;
    private final EventExecutorChooser chooser;
    private final Set readonlyChildren;
    private final AtomicInteger terminatedChildren;
    private final Promise terminationFuture;

    public MultithreadEventExecutorGroup(int v, Executor executor0, EventExecutorChooserFactory eventExecutorChooserFactory0, Object[] arr_object) {
        this.terminatedChildren = new AtomicInteger();
        this.terminationFuture = new DefaultPromise(GlobalEventExecutor.INSTANCE);
        ObjectUtil.checkPositive(v, "nThreads");
        if(executor0 == null) {
            executor0 = new ThreadPerTaskExecutor(this.newDefaultThreadFactory());
        }
        this.children = new EventExecutor[v];
        int v1 = 0;
        int v2 = 0;
        while(v2 < v) {
            try {
                try {
                    this.children[v2] = this.newChild(executor0, arr_object);
                    ++v2;
                }
                catch(Exception exception0) {
                    throw new IllegalStateException("failed to create a child event loop", exception0);
                }
            }
            catch(Throwable throwable0) {
                for(int v3 = 0; v3 < v2; ++v3) {
                    this.children[v3].shutdownGracefully();
                }
                while(v1 < v2) {
                    EventExecutor eventExecutor0 = this.children[v1];
                    try {
                        while(!eventExecutor0.isTerminated()) {
                            eventExecutor0.awaitTermination(0x7FFFFFFFL, TimeUnit.SECONDS);
                        }
                        ++v1;
                    }
                    catch(InterruptedException unused_ex) {
                        Thread.currentThread().interrupt();
                        if(true) {
                            break;
                        }
                    }
                }
                throw throwable0;
            }
        }
        this.chooser = eventExecutorChooserFactory0.newChooser(this.children);
        io.netty.util.concurrent.MultithreadEventExecutorGroup.1 multithreadEventExecutorGroup$10 = new FutureListener() {
            @Override  // io.netty.util.concurrent.GenericFutureListener
            public void operationComplete(Future future0) {
                if(MultithreadEventExecutorGroup.this.terminatedChildren.incrementAndGet() == MultithreadEventExecutorGroup.access$100(MultithreadEventExecutorGroup.this).length) {
                    MultithreadEventExecutorGroup.this.terminationFuture.setSuccess(null);
                }
            }
        };
        EventExecutor[] arr_eventExecutor = this.children;
        while(v1 < arr_eventExecutor.length) {
            arr_eventExecutor[v1].terminationFuture().addListener(multithreadEventExecutorGroup$10);
            ++v1;
        }
        LinkedHashSet linkedHashSet0 = new LinkedHashSet(this.children.length);
        Collections.addAll(linkedHashSet0, this.children);
        this.readonlyChildren = Collections.unmodifiableSet(linkedHashSet0);
    }

    public MultithreadEventExecutorGroup(int v, Executor executor0, Object[] arr_object) {
        this(v, executor0, DefaultEventExecutorChooserFactory.INSTANCE, arr_object);
    }

    public MultithreadEventExecutorGroup(int v, ThreadFactory threadFactory0, Object[] arr_object) {
        this(v, (threadFactory0 == null ? null : new ThreadPerTaskExecutor(threadFactory0)), arr_object);
    }

    public static EventExecutor[] access$100(MultithreadEventExecutorGroup multithreadEventExecutorGroup0) {
        return multithreadEventExecutorGroup0.children;
    }

    @Override
    public boolean awaitTermination(long v, TimeUnit timeUnit0) {
        long v1 = System.nanoTime();
        long v2 = timeUnit0.toNanos(v);
        EventExecutor[] arr_eventExecutor = this.children;
        int v3 = 0;
        while(v3 < arr_eventExecutor.length) {
            EventExecutor eventExecutor0 = arr_eventExecutor[v3];
        label_6:
            long v4 = v2 + v1 - System.nanoTime();
            if(v4 <= 0L) {
                break;
            }
            if(eventExecutor0.awaitTermination(v4, TimeUnit.NANOSECONDS)) {
                ++v3;
                continue;
            }
            if(false) {
                break;
            }
            goto label_6;
        }
        return this.isTerminated();
    }

    public final int executorCount() {
        return this.children.length;
    }

    @Override
    public boolean isShutdown() {
        EventExecutor[] arr_eventExecutor = this.children;
        for(int v = 0; v < arr_eventExecutor.length; ++v) {
            if(!arr_eventExecutor[v].isShutdown()) {
                return false;
            }
        }
        return true;
    }

    @Override  // io.netty.util.concurrent.EventExecutorGroup
    public boolean isShuttingDown() {
        EventExecutor[] arr_eventExecutor = this.children;
        for(int v = 0; v < arr_eventExecutor.length; ++v) {
            if(!arr_eventExecutor[v].isShuttingDown()) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean isTerminated() {
        EventExecutor[] arr_eventExecutor = this.children;
        for(int v = 0; v < arr_eventExecutor.length; ++v) {
            if(!arr_eventExecutor[v].isTerminated()) {
                return false;
            }
        }
        return true;
    }

    @Override  // io.netty.util.concurrent.EventExecutorGroup
    public Iterator iterator() {
        return this.readonlyChildren.iterator();
    }

    public abstract EventExecutor newChild(Executor arg1, Object[] arg2);

    public ThreadFactory newDefaultThreadFactory() {
        return new DefaultThreadFactory(this.getClass());
    }

    @Override  // io.netty.util.concurrent.EventExecutorGroup
    public EventExecutor next() {
        return this.chooser.next();
    }

    @Override  // io.netty.util.concurrent.AbstractEventExecutorGroup
    @Deprecated
    public void shutdown() {
        EventExecutor[] arr_eventExecutor = this.children;
        for(int v = 0; v < arr_eventExecutor.length; ++v) {
            arr_eventExecutor[v].shutdown();
        }
    }

    @Override  // io.netty.util.concurrent.EventExecutorGroup
    public Future shutdownGracefully(long v, long v1, TimeUnit timeUnit0) {
        EventExecutor[] arr_eventExecutor = this.children;
        for(int v2 = 0; v2 < arr_eventExecutor.length; ++v2) {
            arr_eventExecutor[v2].shutdownGracefully(v, v1, timeUnit0);
        }
        return this.terminationFuture();
    }

    @Override  // io.netty.util.concurrent.EventExecutorGroup
    public Future terminationFuture() {
        return this.terminationFuture;
    }
}

