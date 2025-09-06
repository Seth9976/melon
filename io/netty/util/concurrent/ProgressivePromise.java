package io.netty.util.concurrent;

public interface ProgressivePromise extends ProgressiveFuture, Promise {
    ProgressivePromise addListener(GenericFutureListener arg1);

    ProgressivePromise addListeners(GenericFutureListener[] arg1);

    ProgressivePromise await();

    ProgressivePromise awaitUninterruptibly();

    ProgressivePromise removeListener(GenericFutureListener arg1);

    ProgressivePromise removeListeners(GenericFutureListener[] arg1);

    ProgressivePromise setFailure(Throwable arg1);

    ProgressivePromise setProgress(long arg1, long arg2);

    ProgressivePromise setSuccess(Object arg1);

    ProgressivePromise sync();

    ProgressivePromise syncUninterruptibly();

    boolean tryProgress(long arg1, long arg2);
}

