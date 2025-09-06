package io.netty.channel;

import io.netty.util.concurrent.EventExecutor;

final class SucceededChannelFuture extends CompleteChannelFuture {
    public SucceededChannelFuture(Channel channel0, EventExecutor eventExecutor0) {
        super(channel0, eventExecutor0);
    }

    @Override  // io.netty.util.concurrent.Future
    public Throwable cause() {
        return null;
    }

    @Override  // io.netty.util.concurrent.Future
    public boolean isSuccess() {
        return true;
    }
}

