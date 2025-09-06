package io.netty.channel;

import io.netty.util.concurrent.EventExecutor;
import io.netty.util.concurrent.Future;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;

final class FailedChannelFuture extends CompleteChannelFuture {
    private final Throwable cause;

    public FailedChannelFuture(Channel channel0, EventExecutor eventExecutor0, Throwable throwable0) {
        super(channel0, eventExecutor0);
        this.cause = (Throwable)ObjectUtil.checkNotNull(throwable0, "cause");
    }

    @Override  // io.netty.util.concurrent.Future
    public Throwable cause() {
        return this.cause;
    }

    @Override  // io.netty.util.concurrent.Future
    public boolean isSuccess() {
        return false;
    }

    @Override  // io.netty.channel.CompleteChannelFuture
    public ChannelFuture sync() {
        PlatformDependent.throwException(this.cause);
        return this;
    }

    @Override  // io.netty.channel.CompleteChannelFuture
    public Future sync() {
        return this.sync();
    }

    @Override  // io.netty.channel.CompleteChannelFuture
    public ChannelFuture syncUninterruptibly() {
        PlatformDependent.throwException(this.cause);
        return this;
    }

    @Override  // io.netty.channel.CompleteChannelFuture
    public Future syncUninterruptibly() {
        return this.syncUninterruptibly();
    }
}

