package io.netty.util.concurrent;

import io.netty.util.internal.ObjectUtil;
import java.util.concurrent.TimeUnit;

public abstract class CompleteFuture extends AbstractFuture {
    private final EventExecutor executor;

    public CompleteFuture(EventExecutor eventExecutor0) {
        this.executor = eventExecutor0;
    }

    @Override  // io.netty.util.concurrent.Future
    public Future addListener(GenericFutureListener genericFutureListener0) {
        DefaultPromise.notifyListener(this.executor(), this, ((GenericFutureListener)ObjectUtil.checkNotNull(genericFutureListener0, "listener")));
        return this;
    }

    @Override  // io.netty.util.concurrent.Future
    public Future addListeners(GenericFutureListener[] arr_genericFutureListener) {
        GenericFutureListener[] arr_genericFutureListener1 = (GenericFutureListener[])ObjectUtil.checkNotNull(arr_genericFutureListener, "listeners");
        for(int v = 0; v < arr_genericFutureListener1.length; ++v) {
            GenericFutureListener genericFutureListener0 = arr_genericFutureListener1[v];
            if(genericFutureListener0 == null) {
                break;
            }
            DefaultPromise.notifyListener(this.executor(), this, genericFutureListener0);
        }
        return this;
    }

    @Override  // io.netty.util.concurrent.Future
    public Future await() {
        if(Thread.interrupted()) {
            throw new InterruptedException();
        }
        return this;
    }

    @Override  // io.netty.util.concurrent.Future
    public boolean await(long v) {
        if(Thread.interrupted()) {
            throw new InterruptedException();
        }
        return true;
    }

    @Override  // io.netty.util.concurrent.Future
    public boolean await(long v, TimeUnit timeUnit0) {
        if(Thread.interrupted()) {
            throw new InterruptedException();
        }
        return true;
    }

    @Override  // io.netty.util.concurrent.Future
    public Future awaitUninterruptibly() {
        return this;
    }

    @Override  // io.netty.util.concurrent.Future
    public boolean awaitUninterruptibly(long v) {
        return true;
    }

    @Override  // io.netty.util.concurrent.Future
    public boolean awaitUninterruptibly(long v, TimeUnit timeUnit0) {
        return true;
    }

    @Override  // io.netty.util.concurrent.Future
    public boolean cancel(boolean z) {
        return false;
    }

    public EventExecutor executor() {
        return this.executor;
    }

    @Override  // io.netty.util.concurrent.Future
    public boolean isCancellable() {
        return false;
    }

    @Override
    public boolean isCancelled() {
        return false;
    }

    @Override
    public boolean isDone() {
        return true;
    }

    @Override  // io.netty.util.concurrent.Future
    public Future removeListener(GenericFutureListener genericFutureListener0) {
        return this;
    }

    @Override  // io.netty.util.concurrent.Future
    public Future removeListeners(GenericFutureListener[] arr_genericFutureListener) {
        return this;
    }

    @Override  // io.netty.util.concurrent.Future
    public Future sync() {
        return this;
    }

    @Override  // io.netty.util.concurrent.Future
    public Future syncUninterruptibly() {
        return this;
    }
}

