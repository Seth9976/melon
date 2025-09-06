package io.netty.util.concurrent;

import io.netty.util.internal.ObjectUtil;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

public final class RejectedExecutionHandlers {
    private static final RejectedExecutionHandler REJECT;

    static {
        RejectedExecutionHandlers.REJECT = new RejectedExecutionHandler() {
            @Override  // io.netty.util.concurrent.RejectedExecutionHandler
            public void rejected(Runnable runnable0, SingleThreadEventExecutor singleThreadEventExecutor0) {
                throw new RejectedExecutionException();
            }
        };
    }

    public static RejectedExecutionHandler backoff(int v, long v1, TimeUnit timeUnit0) {
        ObjectUtil.checkPositive(v, "retries");
        return new RejectedExecutionHandler() {
            @Override  // io.netty.util.concurrent.RejectedExecutionHandler
            public void rejected(Runnable runnable0, SingleThreadEventExecutor singleThreadEventExecutor0) {
                if(!singleThreadEventExecutor0.inEventLoop()) {
                    for(int v = 0; v < v; ++v) {
                        singleThreadEventExecutor0.wakeup(false);
                        LockSupport.parkNanos(timeUnit0.toNanos(v1));
                        if(singleThreadEventExecutor0.offerTask(runnable0)) {
                            return;
                        }
                    }
                }
                throw new RejectedExecutionException();
            }
        };
    }

    public static RejectedExecutionHandler reject() {
        return RejectedExecutionHandlers.REJECT;
    }
}

