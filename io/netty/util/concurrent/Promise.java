package io.netty.util.concurrent;

public interface Promise extends Future {
    Promise addListener(GenericFutureListener arg1);

    Promise addListeners(GenericFutureListener[] arg1);

    Promise await();

    Promise awaitUninterruptibly();

    Promise removeListener(GenericFutureListener arg1);

    Promise removeListeners(GenericFutureListener[] arg1);

    Promise setFailure(Throwable arg1);

    Promise setSuccess(Object arg1);

    boolean setUncancellable();

    Promise sync();

    Promise syncUninterruptibly();

    boolean tryFailure(Throwable arg1);

    boolean trySuccess(Object arg1);
}

