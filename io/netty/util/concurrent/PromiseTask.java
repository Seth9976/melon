package io.netty.util.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.RunnableFuture;

class PromiseTask extends DefaultPromise implements RunnableFuture {
    static final class RunnableAdapter implements Callable {
        final Object result;
        final Runnable task;

        public RunnableAdapter(Runnable runnable0, Object object0) {
            this.task = runnable0;
            this.result = object0;
        }

        @Override
        public Object call() {
            this.task.run();
            return this.result;
        }

        @Override
        public String toString() {
            return "Callable(task: " + this.task + ", result: " + this.result + ')';
        }
    }

    static class SentinelRunnable implements Runnable {
        private final String name;

        public SentinelRunnable(String s) {
            this.name = s;
        }

        @Override
        public void run() {
        }

        @Override
        public String toString() {
            return this.name;
        }
    }

    private static final Runnable CANCELLED;
    private static final Runnable COMPLETED;
    private static final Runnable FAILED;
    private Object task;

    static {
        PromiseTask.COMPLETED = new SentinelRunnable("COMPLETED");
        PromiseTask.CANCELLED = new SentinelRunnable("CANCELLED");
        PromiseTask.FAILED = new SentinelRunnable("FAILED");
    }

    public PromiseTask(EventExecutor eventExecutor0, Runnable runnable0) {
        super(eventExecutor0);
        this.task = runnable0;
    }

    public PromiseTask(EventExecutor eventExecutor0, Runnable runnable0, Object object0) {
        super(eventExecutor0);
        if(object0 != null) {
            runnable0 = new RunnableAdapter(runnable0, object0);
        }
        this.task = runnable0;
    }

    public PromiseTask(EventExecutor eventExecutor0, Callable callable0) {
        super(eventExecutor0);
        this.task = callable0;
    }

    @Override  // io.netty.util.concurrent.DefaultPromise
    public boolean cancel(boolean z) {
        return this.clearTaskAfterCompletion(super.cancel(z), PromiseTask.CANCELLED);
    }

    private boolean clearTaskAfterCompletion(boolean z, Runnable runnable0) {
        if(z) {
            this.task = runnable0;
        }
        return z;
    }

    @Override
    public final boolean equals(Object object0) {
        return this == object0;
    }

    @Override
    public final int hashCode() {
        return System.identityHashCode(this);
    }

    @Override
    public void run() {
        try {
            if(this.setUncancellableInternal()) {
                this.setSuccessInternal(this.runTask());
            }
        }
        catch(Throwable throwable0) {
            this.setFailureInternal(throwable0);
        }
    }

    public Object runTask() {
        Object object0 = this.task;
        if(object0 instanceof Callable) {
            return ((Callable)object0).call();
        }
        ((Runnable)object0).run();
        return null;
    }

    @Override  // io.netty.util.concurrent.DefaultPromise
    public final Promise setFailure(Throwable throwable0) {
        throw new IllegalStateException();
    }

    public final Promise setFailureInternal(Throwable throwable0) {
        super.setFailure(throwable0);
        this.clearTaskAfterCompletion(true, PromiseTask.FAILED);
        return this;
    }

    @Override  // io.netty.util.concurrent.DefaultPromise
    public final Promise setSuccess(Object object0) {
        throw new IllegalStateException();
    }

    public final Promise setSuccessInternal(Object object0) {
        super.setSuccess(object0);
        this.clearTaskAfterCompletion(true, PromiseTask.COMPLETED);
        return this;
    }

    @Override  // io.netty.util.concurrent.DefaultPromise
    public final boolean setUncancellable() {
        throw new IllegalStateException();
    }

    public final boolean setUncancellableInternal() {
        return super.setUncancellable();
    }

    @Override  // io.netty.util.concurrent.DefaultPromise
    public StringBuilder toStringBuilder() {
        StringBuilder stringBuilder0 = super.toStringBuilder();
        stringBuilder0.setCharAt(stringBuilder0.length() - 1, ',');
        stringBuilder0.append(" task: ");
        stringBuilder0.append(this.task);
        stringBuilder0.append(')');
        return stringBuilder0;
    }

    @Override  // io.netty.util.concurrent.DefaultPromise
    public final boolean tryFailure(Throwable throwable0) {
        return false;
    }

    public final boolean tryFailureInternal(Throwable throwable0) {
        return this.clearTaskAfterCompletion(super.tryFailure(throwable0), PromiseTask.FAILED);
    }

    @Override  // io.netty.util.concurrent.DefaultPromise
    public final boolean trySuccess(Object object0) {
        return false;
    }

    public final boolean trySuccessInternal(Object object0) {
        return this.clearTaskAfterCompletion(super.trySuccess(object0), PromiseTask.COMPLETED);
    }
}

