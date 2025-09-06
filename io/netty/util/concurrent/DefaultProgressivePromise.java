package io.netty.util.concurrent;

import U4.x;
import io.netty.util.internal.ObjectUtil;
import k8.Y;

public class DefaultProgressivePromise extends DefaultPromise implements ProgressivePromise {
    public DefaultProgressivePromise() {
    }

    public DefaultProgressivePromise(EventExecutor eventExecutor0) {
        super(eventExecutor0);
    }

    @Override  // io.netty.util.concurrent.DefaultPromise, io.netty.util.concurrent.Future
    public Future addListener(GenericFutureListener genericFutureListener0) {
        return this.addListener(genericFutureListener0);
    }

    @Override  // io.netty.util.concurrent.ProgressiveFuture
    public ProgressiveFuture addListener(GenericFutureListener genericFutureListener0) {
        return this.addListener(genericFutureListener0);
    }

    @Override  // io.netty.util.concurrent.ProgressivePromise
    public ProgressivePromise addListener(GenericFutureListener genericFutureListener0) {
        super.addListener(genericFutureListener0);
        return this;
    }

    @Override  // io.netty.util.concurrent.DefaultPromise, io.netty.util.concurrent.Promise
    public Promise addListener(GenericFutureListener genericFutureListener0) {
        return this.addListener(genericFutureListener0);
    }

    @Override  // io.netty.util.concurrent.DefaultPromise, io.netty.util.concurrent.Future
    public Future addListeners(GenericFutureListener[] arr_genericFutureListener) {
        return this.addListeners(arr_genericFutureListener);
    }

    @Override  // io.netty.util.concurrent.ProgressiveFuture
    public ProgressiveFuture addListeners(GenericFutureListener[] arr_genericFutureListener) {
        return this.addListeners(arr_genericFutureListener);
    }

    @Override  // io.netty.util.concurrent.ProgressivePromise
    public ProgressivePromise addListeners(GenericFutureListener[] arr_genericFutureListener) {
        super.addListeners(arr_genericFutureListener);
        return this;
    }

    @Override  // io.netty.util.concurrent.DefaultPromise, io.netty.util.concurrent.Promise
    public Promise addListeners(GenericFutureListener[] arr_genericFutureListener) {
        return this.addListeners(arr_genericFutureListener);
    }

    @Override  // io.netty.util.concurrent.DefaultPromise, io.netty.util.concurrent.Future
    public Future await() {
        return this.await();
    }

    @Override  // io.netty.util.concurrent.ProgressiveFuture
    public ProgressiveFuture await() {
        return this.await();
    }

    @Override  // io.netty.util.concurrent.ProgressivePromise
    public ProgressivePromise await() {
        super.await();
        return this;
    }

    @Override  // io.netty.util.concurrent.DefaultPromise, io.netty.util.concurrent.Promise
    public Promise await() {
        return this.await();
    }

    @Override  // io.netty.util.concurrent.DefaultPromise, io.netty.util.concurrent.Future
    public Future awaitUninterruptibly() {
        return this.awaitUninterruptibly();
    }

    @Override  // io.netty.util.concurrent.ProgressiveFuture
    public ProgressiveFuture awaitUninterruptibly() {
        return this.awaitUninterruptibly();
    }

    @Override  // io.netty.util.concurrent.ProgressivePromise
    public ProgressivePromise awaitUninterruptibly() {
        super.awaitUninterruptibly();
        return this;
    }

    @Override  // io.netty.util.concurrent.DefaultPromise, io.netty.util.concurrent.Promise
    public Promise awaitUninterruptibly() {
        return this.awaitUninterruptibly();
    }

    @Override  // io.netty.util.concurrent.DefaultPromise, io.netty.util.concurrent.Future
    public Future removeListener(GenericFutureListener genericFutureListener0) {
        return this.removeListener(genericFutureListener0);
    }

    @Override  // io.netty.util.concurrent.ProgressiveFuture
    public ProgressiveFuture removeListener(GenericFutureListener genericFutureListener0) {
        return this.removeListener(genericFutureListener0);
    }

    @Override  // io.netty.util.concurrent.ProgressivePromise
    public ProgressivePromise removeListener(GenericFutureListener genericFutureListener0) {
        super.removeListener(genericFutureListener0);
        return this;
    }

    @Override  // io.netty.util.concurrent.DefaultPromise, io.netty.util.concurrent.Promise
    public Promise removeListener(GenericFutureListener genericFutureListener0) {
        return this.removeListener(genericFutureListener0);
    }

    @Override  // io.netty.util.concurrent.DefaultPromise, io.netty.util.concurrent.Future
    public Future removeListeners(GenericFutureListener[] arr_genericFutureListener) {
        return this.removeListeners(arr_genericFutureListener);
    }

    @Override  // io.netty.util.concurrent.ProgressiveFuture
    public ProgressiveFuture removeListeners(GenericFutureListener[] arr_genericFutureListener) {
        return this.removeListeners(arr_genericFutureListener);
    }

    @Override  // io.netty.util.concurrent.ProgressivePromise
    public ProgressivePromise removeListeners(GenericFutureListener[] arr_genericFutureListener) {
        super.removeListeners(arr_genericFutureListener);
        return this;
    }

    @Override  // io.netty.util.concurrent.DefaultPromise, io.netty.util.concurrent.Promise
    public Promise removeListeners(GenericFutureListener[] arr_genericFutureListener) {
        return this.removeListeners(arr_genericFutureListener);
    }

    @Override  // io.netty.util.concurrent.ProgressivePromise
    public ProgressivePromise setFailure(Throwable throwable0) {
        super.setFailure(throwable0);
        return this;
    }

    @Override  // io.netty.util.concurrent.DefaultPromise, io.netty.util.concurrent.Promise
    public Promise setFailure(Throwable throwable0) {
        return this.setFailure(throwable0);
    }

    @Override  // io.netty.util.concurrent.ProgressivePromise
    public ProgressivePromise setProgress(long v, long v1) {
        if(v1 < 0L) {
            ObjectUtil.checkPositiveOrZero(v, "progress");
            v1 = -1L;
        }
        else if(v >= 0L && v <= v1) {
        }
        else {
            throw new IllegalArgumentException(x.h(v1, "))", Y.o(v, "progress: ", " (expected: 0 <= progress <= total (")));
        }
        if(this.isDone()) {
            throw new IllegalStateException("complete already");
        }
        this.notifyProgressiveListeners(v, v1);
        return this;
    }

    @Override  // io.netty.util.concurrent.ProgressivePromise
    public ProgressivePromise setSuccess(Object object0) {
        super.setSuccess(object0);
        return this;
    }

    @Override  // io.netty.util.concurrent.DefaultPromise, io.netty.util.concurrent.Promise
    public Promise setSuccess(Object object0) {
        return this.setSuccess(object0);
    }

    @Override  // io.netty.util.concurrent.DefaultPromise, io.netty.util.concurrent.Future
    public Future sync() {
        return this.sync();
    }

    @Override  // io.netty.util.concurrent.ProgressiveFuture
    public ProgressiveFuture sync() {
        return this.sync();
    }

    @Override  // io.netty.util.concurrent.ProgressivePromise
    public ProgressivePromise sync() {
        super.sync();
        return this;
    }

    @Override  // io.netty.util.concurrent.DefaultPromise, io.netty.util.concurrent.Promise
    public Promise sync() {
        return this.sync();
    }

    @Override  // io.netty.util.concurrent.DefaultPromise, io.netty.util.concurrent.Future
    public Future syncUninterruptibly() {
        return this.syncUninterruptibly();
    }

    @Override  // io.netty.util.concurrent.ProgressiveFuture
    public ProgressiveFuture syncUninterruptibly() {
        return this.syncUninterruptibly();
    }

    @Override  // io.netty.util.concurrent.ProgressivePromise
    public ProgressivePromise syncUninterruptibly() {
        super.syncUninterruptibly();
        return this;
    }

    @Override  // io.netty.util.concurrent.DefaultPromise, io.netty.util.concurrent.Promise
    public Promise syncUninterruptibly() {
        return this.syncUninterruptibly();
    }

    @Override  // io.netty.util.concurrent.ProgressivePromise
    public boolean tryProgress(long v, long v1) {
        if(Long.compare(v1, 0L) < 0) {
            if(v >= 0L && !this.isDone()) {
                v1 = -1L;
                this.notifyProgressiveListeners(v, v1);
                return true;
            }
            return false;
        }
        if(v >= 0L && v <= v1 && !this.isDone()) {
            this.notifyProgressiveListeners(v, v1);
            return true;
        }
        return false;
    }
}

