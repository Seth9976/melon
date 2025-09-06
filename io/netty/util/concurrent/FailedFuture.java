package io.netty.util.concurrent;

import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;

public final class FailedFuture extends CompleteFuture {
    private final Throwable cause;

    public FailedFuture(EventExecutor eventExecutor0, Throwable throwable0) {
        super(eventExecutor0);
        this.cause = (Throwable)ObjectUtil.checkNotNull(throwable0, "cause");
    }

    @Override  // io.netty.util.concurrent.Future
    public Throwable cause() {
        return this.cause;
    }

    @Override  // io.netty.util.concurrent.Future
    public Object getNow() {
        return null;
    }

    @Override  // io.netty.util.concurrent.Future
    public boolean isSuccess() {
        return false;
    }

    @Override  // io.netty.util.concurrent.CompleteFuture
    public Future sync() {
        PlatformDependent.throwException(this.cause);
        return this;
    }

    @Override  // io.netty.util.concurrent.CompleteFuture
    public Future syncUninterruptibly() {
        PlatformDependent.throwException(this.cause);
        return this;
    }
}

