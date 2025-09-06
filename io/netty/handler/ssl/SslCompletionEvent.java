package io.netty.handler.ssl;

import io.netty.util.internal.ObjectUtil;

public abstract class SslCompletionEvent {
    private final Throwable cause;

    public SslCompletionEvent() {
        this.cause = null;
    }

    public SslCompletionEvent(Throwable throwable0) {
        this.cause = (Throwable)ObjectUtil.checkNotNull(throwable0, "cause");
    }

    public final Throwable cause() {
        return this.cause;
    }

    public final boolean isSuccess() {
        return this.cause == null;
    }

    @Override
    public String toString() {
        Throwable throwable0 = this.cause();
        return throwable0 == null ? this.getClass().getSimpleName() + "(SUCCESS)" : this.getClass().getSimpleName() + '(' + throwable0 + ')';
    }
}

