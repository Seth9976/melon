package io.netty.util.concurrent;

import java.util.concurrent.TimeUnit;

public interface Future extends java.util.concurrent.Future {
    Future addListener(GenericFutureListener arg1);

    Future addListeners(GenericFutureListener[] arg1);

    Future await();

    boolean await(long arg1);

    boolean await(long arg1, TimeUnit arg2);

    Future awaitUninterruptibly();

    boolean awaitUninterruptibly(long arg1);

    boolean awaitUninterruptibly(long arg1, TimeUnit arg2);

    @Override
    boolean cancel(boolean arg1);

    Throwable cause();

    Object getNow();

    boolean isCancellable();

    boolean isSuccess();

    Future removeListener(GenericFutureListener arg1);

    Future removeListeners(GenericFutureListener[] arg1);

    Future sync();

    Future syncUninterruptibly();
}

