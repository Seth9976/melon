package io.netty.util.concurrent;

public interface GenericProgressiveFutureListener extends GenericFutureListener {
    void operationProgressed(ProgressiveFuture arg1, long arg2, long arg3);
}

