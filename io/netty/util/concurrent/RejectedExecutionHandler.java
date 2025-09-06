package io.netty.util.concurrent;

public interface RejectedExecutionHandler {
    void rejected(Runnable arg1, SingleThreadEventExecutor arg2);
}

