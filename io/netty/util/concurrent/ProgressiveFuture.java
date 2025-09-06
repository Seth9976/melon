package io.netty.util.concurrent;

public interface ProgressiveFuture extends Future {
    ProgressiveFuture addListener(GenericFutureListener arg1);

    ProgressiveFuture addListeners(GenericFutureListener[] arg1);

    ProgressiveFuture await();

    ProgressiveFuture awaitUninterruptibly();

    ProgressiveFuture removeListener(GenericFutureListener arg1);

    ProgressiveFuture removeListeners(GenericFutureListener[] arg1);

    ProgressiveFuture sync();

    ProgressiveFuture syncUninterruptibly();
}

