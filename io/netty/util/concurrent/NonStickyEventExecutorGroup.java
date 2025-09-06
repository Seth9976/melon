package io.netty.util.concurrent;

import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.Callable;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class NonStickyEventExecutorGroup implements EventExecutorGroup {
    static final class NonStickyOrderedEventExecutor extends AbstractEventExecutor implements OrderedEventExecutor, Runnable {
        private static final int NONE = 0;
        private static final int RUNNING = 2;
        private static final int SUBMITTED = 1;
        private final AtomicReference executingThread;
        private final EventExecutor executor;
        private final int maxTaskExecutePerRun;
        private final AtomicInteger state;
        private final Queue tasks;

        public NonStickyOrderedEventExecutor(EventExecutor eventExecutor0, int v) {
            super(eventExecutor0);
            this.tasks = PlatformDependent.newMpscQueue();
            this.state = new AtomicInteger();
            this.executingThread = new AtomicReference();
            this.executor = eventExecutor0;
            this.maxTaskExecutePerRun = v;
        }

        @Override
        public boolean awaitTermination(long v, TimeUnit timeUnit0) {
            return this.executor.awaitTermination(v, timeUnit0);
        }

        @Override
        public void execute(Runnable runnable0) {
            if(!this.tasks.offer(runnable0)) {
                throw new RejectedExecutionException();
            }
            if(this.state.compareAndSet(0, 1)) {
                this.executor.execute(this);
            }
        }

        @Override  // io.netty.util.concurrent.EventExecutor
        public boolean inEventLoop(Thread thread0) {
            return this.executingThread.get() == thread0;
        }

        @Override
        public boolean isShutdown() {
            return this.executor.isShutdown();
        }

        @Override  // io.netty.util.concurrent.EventExecutorGroup
        public boolean isShuttingDown() {
            return this.executor.isShutdown();
        }

        @Override
        public boolean isTerminated() {
            return this.executor.isTerminated();
        }

        @Override
        public void run() {
            if(this.state.compareAndSet(1, 2)) {
                Thread thread0 = Thread.currentThread();
                this.executingThread.set(thread0);
                while(true) {
                    int v = 0;
                    try {
                        while(v < this.maxTaskExecutePerRun) {
                            Runnable runnable0 = (Runnable)this.tasks.poll();
                            if(runnable0 == null) {
                                break;
                            }
                            AbstractEventExecutor.safeExecute(runnable0);
                            ++v;
                        }
                    }
                    catch(Throwable throwable0) {
                        if(v == this.maxTaskExecutePerRun) {
                            try {
                                this.state.set(1);
                                AtomicReference atomicReference0 = this.executingThread;
                                while(true) {
                                    if(atomicReference0.compareAndSet(thread0, null) || atomicReference0.get() != thread0) {
                                        this.executor.execute(this);
                                        return;
                                    }
                                }
                            }
                            catch(Throwable unused_ex) {
                                this.state.set(2);
                                throw throwable0;
                            }
                        }
                        this.state.set(0);
                        if(!this.tasks.isEmpty() && this.state.compareAndSet(0, 2)) {
                            throw throwable0;
                        }
                        AtomicReference atomicReference1 = this.executingThread;
                        while(!atomicReference1.compareAndSet(thread0, null) && atomicReference1.get() == thread0) {
                        }
                        return;
                    }
                    if(v == this.maxTaskExecutePerRun) {
                        try {
                            this.state.set(1);
                            AtomicReference atomicReference2 = this.executingThread;
                            while(true) {
                                if(atomicReference2.compareAndSet(thread0, null) || atomicReference2.get() != thread0) {
                                    this.executor.execute(this);
                                    return;
                                }
                            }
                        }
                        catch(Throwable unused_ex) {
                            this.state.set(2);
                            continue;
                        }
                    }
                    this.state.set(0);
                    if(this.tasks.isEmpty() || !this.state.compareAndSet(0, 2)) {
                        AtomicReference atomicReference3 = this.executingThread;
                        while(!atomicReference3.compareAndSet(thread0, null) && atomicReference3.get() == thread0) {
                        }
                        return;
                    }
                }
            }
        }

        @Override  // io.netty.util.concurrent.AbstractEventExecutor, io.netty.util.concurrent.EventExecutorGroup
        public void shutdown() {
            this.executor.shutdown();
        }

        @Override  // io.netty.util.concurrent.EventExecutorGroup
        public Future shutdownGracefully(long v, long v1, TimeUnit timeUnit0) {
            return this.executor.shutdownGracefully(v, v1, timeUnit0);
        }

        @Override  // io.netty.util.concurrent.EventExecutorGroup
        public Future terminationFuture() {
            return this.executor.terminationFuture();
        }
    }

    private final EventExecutorGroup group;
    private final int maxTaskExecutePerRun;

    public NonStickyEventExecutorGroup(EventExecutorGroup eventExecutorGroup0) {
        this(eventExecutorGroup0, 0x400);
    }

    public NonStickyEventExecutorGroup(EventExecutorGroup eventExecutorGroup0, int v) {
        this.group = NonStickyEventExecutorGroup.verify(eventExecutorGroup0);
        this.maxTaskExecutePerRun = ObjectUtil.checkPositive(v, "maxTaskExecutePerRun");
    }

    @Override
    public boolean awaitTermination(long v, TimeUnit timeUnit0) {
        return this.group.awaitTermination(v, timeUnit0);
    }

    @Override
    public void execute(Runnable runnable0) {
        this.group.execute(runnable0);
    }

    @Override
    public List invokeAll(Collection collection0) {
        return this.group.invokeAll(collection0);
    }

    @Override
    public List invokeAll(Collection collection0, long v, TimeUnit timeUnit0) {
        return this.group.invokeAll(collection0, v, timeUnit0);
    }

    @Override
    public Object invokeAny(Collection collection0) {
        return this.group.invokeAny(collection0);
    }

    @Override
    public Object invokeAny(Collection collection0, long v, TimeUnit timeUnit0) {
        return this.group.invokeAny(collection0, v, timeUnit0);
    }

    @Override
    public boolean isShutdown() {
        return this.group.isShutdown();
    }

    @Override  // io.netty.util.concurrent.EventExecutorGroup
    public boolean isShuttingDown() {
        return this.group.isShuttingDown();
    }

    @Override
    public boolean isTerminated() {
        return this.group.isTerminated();
    }

    @Override  // io.netty.util.concurrent.EventExecutorGroup
    public Iterator iterator() {
        return new Iterator() {
            @Override
            public boolean hasNext() {
                return this.group.iterator().hasNext();
            }

            public EventExecutor next() {
                Object object0 = this.group.iterator().next();
                return NonStickyEventExecutorGroup.this.newExecutor(((EventExecutor)object0));
            }

            @Override
            public Object next() {
                return this.next();
            }

            @Override
            public void remove() {
                this.group.iterator().remove();
            }
        };
    }

    private NonStickyOrderedEventExecutor newExecutor(EventExecutor eventExecutor0) {
        return new NonStickyOrderedEventExecutor(eventExecutor0, this.maxTaskExecutePerRun);
    }

    @Override  // io.netty.util.concurrent.EventExecutorGroup
    public EventExecutor next() {
        return this.newExecutor(this.group.next());
    }

    @Override  // io.netty.util.concurrent.EventExecutorGroup
    public ScheduledFuture schedule(Runnable runnable0, long v, TimeUnit timeUnit0) {
        return this.group.schedule(runnable0, v, timeUnit0);
    }

    @Override  // io.netty.util.concurrent.EventExecutorGroup
    public ScheduledFuture schedule(Callable callable0, long v, TimeUnit timeUnit0) {
        return this.group.schedule(callable0, v, timeUnit0);
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
        return this.group.scheduleAtFixedRate(runnable0, v, v1, timeUnit0);
    }

    @Override
    public java.util.concurrent.ScheduledFuture scheduleAtFixedRate(Runnable runnable0, long v, long v1, TimeUnit timeUnit0) {
        return this.scheduleAtFixedRate(runnable0, v, v1, timeUnit0);
    }

    @Override  // io.netty.util.concurrent.EventExecutorGroup
    public ScheduledFuture scheduleWithFixedDelay(Runnable runnable0, long v, long v1, TimeUnit timeUnit0) {
        return this.group.scheduleWithFixedDelay(runnable0, v, v1, timeUnit0);
    }

    @Override
    public java.util.concurrent.ScheduledFuture scheduleWithFixedDelay(Runnable runnable0, long v, long v1, TimeUnit timeUnit0) {
        return this.scheduleWithFixedDelay(runnable0, v, v1, timeUnit0);
    }

    @Override  // io.netty.util.concurrent.EventExecutorGroup
    public void shutdown() {
        this.group.shutdown();
    }

    @Override  // io.netty.util.concurrent.EventExecutorGroup
    public Future shutdownGracefully() {
        return this.group.shutdownGracefully();
    }

    @Override  // io.netty.util.concurrent.EventExecutorGroup
    public Future shutdownGracefully(long v, long v1, TimeUnit timeUnit0) {
        return this.group.shutdownGracefully(v, v1, timeUnit0);
    }

    @Override  // io.netty.util.concurrent.EventExecutorGroup
    public List shutdownNow() {
        return this.group.shutdownNow();
    }

    @Override  // io.netty.util.concurrent.EventExecutorGroup
    public Future submit(Runnable runnable0) {
        return this.group.submit(runnable0);
    }

    @Override  // io.netty.util.concurrent.EventExecutorGroup
    public Future submit(Runnable runnable0, Object object0) {
        return this.group.submit(runnable0, object0);
    }

    @Override  // io.netty.util.concurrent.EventExecutorGroup
    public Future submit(Callable callable0) {
        return this.group.submit(callable0);
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

    @Override  // io.netty.util.concurrent.EventExecutorGroup
    public Future terminationFuture() {
        return this.group.terminationFuture();
    }

    private static EventExecutorGroup verify(EventExecutorGroup eventExecutorGroup0) {
        for(Object object0: ((EventExecutorGroup)ObjectUtil.checkNotNull(eventExecutorGroup0, "group"))) {
            EventExecutor eventExecutor0 = (EventExecutor)object0;
            if(eventExecutor0 instanceof OrderedEventExecutor) {
                throw new IllegalArgumentException("EventExecutorGroup " + eventExecutorGroup0 + " contains OrderedEventExecutors: " + eventExecutor0);
            }
            if(false) {
                break;
            }
        }
        return eventExecutorGroup0;
    }
}

