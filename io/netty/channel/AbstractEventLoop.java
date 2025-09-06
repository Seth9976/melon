package io.netty.channel;

import io.netty.util.concurrent.AbstractEventExecutor;
import io.netty.util.concurrent.EventExecutor;
import io.netty.util.concurrent.EventExecutorGroup;

public abstract class AbstractEventLoop extends AbstractEventExecutor implements EventLoop {
    public AbstractEventLoop() {
    }

    public AbstractEventLoop(EventLoopGroup eventLoopGroup0) {
        super(eventLoopGroup0);
    }

    @Override  // io.netty.channel.EventLoopGroup
    public EventLoop next() {
        return (EventLoop)super.next();
    }

    @Override  // io.netty.util.concurrent.AbstractEventExecutor, io.netty.util.concurrent.EventExecutor, io.netty.util.concurrent.EventExecutorGroup
    public EventExecutor next() {
        return this.next();
    }

    @Override  // io.netty.channel.EventLoop
    public EventLoopGroup parent() {
        return (EventLoopGroup)super.parent();
    }

    @Override  // io.netty.util.concurrent.AbstractEventExecutor, io.netty.util.concurrent.EventExecutor
    public EventExecutorGroup parent() {
        return this.parent();
    }
}

