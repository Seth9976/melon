package io.netty.channel;

import io.netty.util.concurrent.AbstractEventExecutorGroup;
import io.netty.util.concurrent.EventExecutor;

public abstract class AbstractEventLoopGroup extends AbstractEventExecutorGroup implements EventLoopGroup {
    @Override  // io.netty.channel.EventLoopGroup
    public abstract EventLoop next();

    @Override  // io.netty.util.concurrent.EventExecutorGroup
    public EventExecutor next() {
        return this.next();
    }
}

