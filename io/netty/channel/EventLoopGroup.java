package io.netty.channel;

import io.netty.util.concurrent.EventExecutorGroup;

public interface EventLoopGroup extends EventExecutorGroup {
    EventLoop next();

    ChannelFuture register(Channel arg1);

    @Deprecated
    ChannelFuture register(Channel arg1, ChannelPromise arg2);

    ChannelFuture register(ChannelPromise arg1);
}

