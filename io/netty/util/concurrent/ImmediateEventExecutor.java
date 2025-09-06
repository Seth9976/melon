package io.netty.util.concurrent;

import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.TimeUnit;

public final class ImmediateEventExecutor extends AbstractEventExecutor {
    static class ImmediateProgressivePromise extends DefaultProgressivePromise {
        public ImmediateProgressivePromise(EventExecutor eventExecutor0) {
            super(eventExecutor0);
        }

        @Override  // io.netty.util.concurrent.DefaultPromise
        public void checkDeadLock() {
        }
    }

    static class ImmediatePromise extends DefaultPromise {
        public ImmediatePromise(EventExecutor eventExecutor0) {
            super(eventExecutor0);
        }

        @Override  // io.netty.util.concurrent.DefaultPromise
        public void checkDeadLock() {
        }
    }

    private static final FastThreadLocal DELAYED_RUNNABLES;
    public static final ImmediateEventExecutor INSTANCE;
    private static final FastThreadLocal RUNNING;
    private static final InternalLogger logger;
    private final Future terminationFuture;

    static {
        ImmediateEventExecutor.logger = InternalLoggerFactory.getInstance(ImmediateEventExecutor.class);
        ImmediateEventExecutor.INSTANCE = new ImmediateEventExecutor();
        ImmediateEventExecutor.DELAYED_RUNNABLES = new FastThreadLocal() {
            @Override  // io.netty.util.concurrent.FastThreadLocal
            public Object initialValue() {
                return this.initialValue();
            }

            public Queue initialValue() {
                return new ArrayDeque();
            }
        };
        ImmediateEventExecutor.RUNNING = new FastThreadLocal() {
            public Boolean initialValue() {
                return false;
            }

            @Override  // io.netty.util.concurrent.FastThreadLocal
            public Object initialValue() {
                return this.initialValue();
            }
        };
    }

    private ImmediateEventExecutor() {
        UnsupportedOperationException unsupportedOperationException0 = new UnsupportedOperationException();
        this.terminationFuture = new FailedFuture(GlobalEventExecutor.INSTANCE, unsupportedOperationException0);
    }

    @Override
    public boolean awaitTermination(long v, TimeUnit timeUnit0) {
        return false;
    }

    @Override
    public void execute(Runnable runnable0) {
        ObjectUtil.checkNotNull(runnable0, "command");
        FastThreadLocal fastThreadLocal0 = ImmediateEventExecutor.RUNNING;
        if(!((Boolean)fastThreadLocal0.get()).booleanValue()) {
            fastThreadLocal0.set(Boolean.TRUE);
            try {
                runnable0.run();
            }
            catch(Throwable throwable0) {
                try {
                    ImmediateEventExecutor.logger.info("Throwable caught while executing Runnable {}", runnable0, throwable0);
                }
                catch(Throwable throwable1) {
                    Queue queue0 = (Queue)ImmediateEventExecutor.DELAYED_RUNNABLES.get();
                    Runnable runnable1;
                    while((runnable1 = (Runnable)queue0.poll()) != null) {
                        try {
                            runnable1.run();
                        }
                        catch(Throwable throwable2) {
                            ImmediateEventExecutor.logger.info("Throwable caught while executing Runnable {}", runnable1, throwable2);
                        }
                    }
                    ImmediateEventExecutor.RUNNING.set(Boolean.FALSE);
                    throw throwable1;
                }
                Queue queue1 = (Queue)ImmediateEventExecutor.DELAYED_RUNNABLES.get();
                while(true) {
                    Runnable runnable2 = (Runnable)queue1.poll();
                    if(runnable2 == null) {
                        ImmediateEventExecutor.RUNNING.set(Boolean.FALSE);
                        return;
                    }
                    try {
                        runnable2.run();
                    }
                    catch(Throwable throwable3) {
                        ImmediateEventExecutor.logger.info("Throwable caught while executing Runnable {}", runnable2, throwable3);
                    }
                }
            }
            Queue queue2 = (Queue)ImmediateEventExecutor.DELAYED_RUNNABLES.get();
            Runnable runnable3;
            while((runnable3 = (Runnable)queue2.poll()) != null) {
                try {
                    runnable3.run();
                }
                catch(Throwable throwable4) {
                    ImmediateEventExecutor.logger.info("Throwable caught while executing Runnable {}", runnable3, throwable4);
                }
            }
            ImmediateEventExecutor.RUNNING.set(Boolean.FALSE);
            return;
        }
        ((Queue)ImmediateEventExecutor.DELAYED_RUNNABLES.get()).add(runnable0);
    }

    @Override  // io.netty.util.concurrent.AbstractEventExecutor
    public boolean inEventLoop() {
        return true;
    }

    @Override  // io.netty.util.concurrent.EventExecutor
    public boolean inEventLoop(Thread thread0) {
        return true;
    }

    @Override
    public boolean isShutdown() {
        return false;
    }

    @Override  // io.netty.util.concurrent.EventExecutorGroup
    public boolean isShuttingDown() {
        return false;
    }

    @Override
    public boolean isTerminated() {
        return false;
    }

    @Override  // io.netty.util.concurrent.AbstractEventExecutor
    public ProgressivePromise newProgressivePromise() {
        return new ImmediateProgressivePromise(this);
    }

    @Override  // io.netty.util.concurrent.AbstractEventExecutor
    public Promise newPromise() {
        return new ImmediatePromise(this);
    }

    @Override  // io.netty.util.concurrent.AbstractEventExecutor
    @Deprecated
    public void shutdown() {
    }

    @Override  // io.netty.util.concurrent.EventExecutorGroup
    public Future shutdownGracefully(long v, long v1, TimeUnit timeUnit0) {
        return this.terminationFuture();
    }

    @Override  // io.netty.util.concurrent.EventExecutorGroup
    public Future terminationFuture() {
        return this.terminationFuture;
    }
}

