package io.netty.util.concurrent;

import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;

@Deprecated
public final class UnaryPromiseNotifier implements FutureListener {
    private static final InternalLogger logger;
    private final Promise promise;

    static {
        UnaryPromiseNotifier.logger = InternalLoggerFactory.getInstance(UnaryPromiseNotifier.class);
    }

    public UnaryPromiseNotifier(Promise promise0) {
        this.promise = (Promise)ObjectUtil.checkNotNull(promise0, "promise");
    }

    public static void cascadeTo(Future future0, Promise promise0) {
        if(future0.isSuccess()) {
            if(!promise0.trySuccess(future0.getNow())) {
                UnaryPromiseNotifier.logger.warn("Failed to mark a promise as success because it is done already: {}", promise0);
            }
        }
        else if(future0.isCancelled()) {
            if(!promise0.cancel(false)) {
                UnaryPromiseNotifier.logger.warn("Failed to cancel a promise because it is done already: {}", promise0);
            }
        }
        else if(!promise0.tryFailure(future0.cause())) {
            Throwable throwable0 = future0.cause();
            UnaryPromiseNotifier.logger.warn("Failed to mark a promise as failure because it\'s done already: {}", promise0, throwable0);
        }
    }

    @Override  // io.netty.util.concurrent.GenericFutureListener
    public void operationComplete(Future future0) {
        UnaryPromiseNotifier.cascadeTo(future0, this.promise);
    }
}

