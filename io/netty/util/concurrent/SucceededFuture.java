package io.netty.util.concurrent;

public final class SucceededFuture extends CompleteFuture {
    private final Object result;

    public SucceededFuture(EventExecutor eventExecutor0, Object object0) {
        super(eventExecutor0);
        this.result = object0;
    }

    @Override  // io.netty.util.concurrent.Future
    public Throwable cause() {
        return null;
    }

    @Override  // io.netty.util.concurrent.Future
    public Object getNow() {
        return this.result;
    }

    @Override  // io.netty.util.concurrent.Future
    public boolean isSuccess() {
        return true;
    }
}

