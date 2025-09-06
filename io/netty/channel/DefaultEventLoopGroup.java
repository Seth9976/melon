package io.netty.channel;

import io.netty.util.concurrent.EventExecutor;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadFactory;

public class DefaultEventLoopGroup extends MultithreadEventLoopGroup {
    public DefaultEventLoopGroup() {
        this(0);
    }

    public DefaultEventLoopGroup(int v) {
        this(v, null);
    }

    public DefaultEventLoopGroup(int v, Executor executor0) {
        super(v, executor0, new Object[0]);
    }

    public DefaultEventLoopGroup(int v, ThreadFactory threadFactory0) {
        super(v, threadFactory0, new Object[0]);
    }

    public DefaultEventLoopGroup(ThreadFactory threadFactory0) {
        this(0, threadFactory0);
    }

    @Override  // io.netty.channel.MultithreadEventLoopGroup
    public EventLoop newChild(Executor executor0, Object[] arr_object) {
        return new DefaultEventLoop(this, executor0);
    }

    @Override  // io.netty.channel.MultithreadEventLoopGroup
    public EventExecutor newChild(Executor executor0, Object[] arr_object) {
        return this.newChild(executor0, arr_object);
    }
}

