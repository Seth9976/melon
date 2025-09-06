package io.netty.util.internal;

import io.netty.util.concurrent.Promise;
import io.netty.util.internal.logging.InternalLogger;

public final class PromiseNotificationUtil {
    public static void tryCancel(Promise promise0, InternalLogger internalLogger0) {
        if(!promise0.cancel(false) && internalLogger0 != null) {
            Throwable throwable0 = promise0.cause();
            if(throwable0 == null) {
                internalLogger0.warn("Failed to cancel promise because it has succeeded already: {}", promise0);
                return;
            }
            internalLogger0.warn("Failed to cancel promise because it has failed already: {}, unnotified cause:", promise0, throwable0);
        }
    }

    public static void tryFailure(Promise promise0, Throwable throwable0, InternalLogger internalLogger0) {
        if(!promise0.tryFailure(throwable0) && internalLogger0 != null) {
            Throwable throwable1 = promise0.cause();
            if(throwable1 == null) {
                internalLogger0.warn("Failed to mark a promise as failure because it has succeeded already: {}", promise0, throwable0);
                return;
            }
            if(internalLogger0.isWarnEnabled()) {
                internalLogger0.warn("Failed to mark a promise as failure because it has failed already: {}, unnotified cause: {}", new Object[]{promise0, ThrowableUtil.stackTraceToString(throwable1), throwable0});
            }
        }
    }

    public static void trySuccess(Promise promise0, Object object0, InternalLogger internalLogger0) {
        if(!promise0.trySuccess(object0) && internalLogger0 != null) {
            Throwable throwable0 = promise0.cause();
            if(throwable0 == null) {
                internalLogger0.warn("Failed to mark a promise as success because it has succeeded already: {}", promise0);
                return;
            }
            internalLogger0.warn("Failed to mark a promise as success because it has failed already: {}, unnotified cause:", promise0, throwable0);
        }
    }
}

