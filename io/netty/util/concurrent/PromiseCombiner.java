package io.netty.util.concurrent;

import io.netty.util.internal.ObjectUtil;

public final class PromiseCombiner {
    private Promise aggregatePromise;
    private Throwable cause;
    private int doneCount;
    private final EventExecutor executor;
    private int expectedCount;
    private final GenericFutureListener listener;

    @Deprecated
    public PromiseCombiner() {
        this(ImmediateEventExecutor.INSTANCE);
    }

    public PromiseCombiner(EventExecutor eventExecutor0) {
        this.listener = new GenericFutureListener() {
            static final boolean $assertionsDisabled;

            @Override  // io.netty.util.concurrent.GenericFutureListener
            public void operationComplete(Future future0) {
                if(PromiseCombiner.this.executor.inEventLoop()) {
                    this.operationComplete0(future0);
                    return;
                }
                io.netty.util.concurrent.PromiseCombiner.1.1 promiseCombiner$1$10 = () -> {
                    PromiseCombiner.access$204(PromiseCombiner.this);
                    if(!this.val$future.isSuccess() && PromiseCombiner.this.cause == null) {
                        Throwable throwable0 = this.val$future.cause();
                        PromiseCombiner.this.cause = throwable0;
                    }
                    if(PromiseCombiner.this.doneCount == PromiseCombiner.this.expectedCount && PromiseCombiner.this.aggregatePromise != null) {
                        PromiseCombiner.this.tryPromise();
                    }
                };
                PromiseCombiner.this.executor.execute(promiseCombiner$1$10);

                class io.netty.util.concurrent.PromiseCombiner.1.1 implements Runnable {
                    public io.netty.util.concurrent.PromiseCombiner.1.1(Future future0) {
                    }

                    @Override
                    public void run() {
                        io.netty.util.concurrent.PromiseCombiner.1.this.operationComplete0(this.val$future);
                    }
                }

            }

            // 检测为 Lambda 实现
            private void operationComplete0(Future future0) [...]
        };
        this.executor = (EventExecutor)ObjectUtil.checkNotNull(eventExecutor0, "executor");
    }

    public static int access$204(PromiseCombiner promiseCombiner0) {
        int v = promiseCombiner0.doneCount + 1;
        promiseCombiner0.doneCount = v;
        return v;
    }

    public void add(Future future0) {
        this.checkAddAllowed();
        this.checkInEventLoop();
        ++this.expectedCount;
        future0.addListener(this.listener);
    }

    @Deprecated
    public void add(Promise promise0) {
        this.add(promise0);
    }

    public void addAll(Future[] arr_future) {
        for(int v = 0; v < arr_future.length; ++v) {
            this.add(arr_future[v]);
        }
    }

    @Deprecated
    public void addAll(Promise[] arr_promise) {
        this.addAll(arr_promise);
    }

    private void checkAddAllowed() {
        if(this.aggregatePromise != null) {
            throw new IllegalStateException("Adding promises is not allowed after finished adding");
        }
    }

    private void checkInEventLoop() {
        if(!this.executor.inEventLoop()) {
            throw new IllegalStateException("Must be called from EventExecutor thread");
        }
    }

    public void finish(Promise promise0) {
        ObjectUtil.checkNotNull(promise0, "aggregatePromise");
        this.checkInEventLoop();
        if(this.aggregatePromise != null) {
            throw new IllegalStateException("Already finished");
        }
        this.aggregatePromise = promise0;
        if(this.doneCount == this.expectedCount) {
            this.tryPromise();
        }
    }

    private boolean tryPromise() {
        return this.cause == null ? this.aggregatePromise.trySuccess(null) : this.aggregatePromise.tryFailure(this.cause);
    }
}

