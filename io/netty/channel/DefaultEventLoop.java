package io.netty.channel;

import io.netty.util.concurrent.AbstractEventExecutor;
import io.netty.util.concurrent.DefaultThreadFactory;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadFactory;

public class DefaultEventLoop extends SingleThreadEventLoop {
    public DefaultEventLoop() {
        this(null);
    }

    public DefaultEventLoop(EventLoopGroup eventLoopGroup0) {
        this(eventLoopGroup0, new DefaultThreadFactory(DefaultEventLoop.class));
    }

    public DefaultEventLoop(EventLoopGroup eventLoopGroup0, Executor executor0) {
        super(eventLoopGroup0, executor0, true);
    }

    public DefaultEventLoop(EventLoopGroup eventLoopGroup0, ThreadFactory threadFactory0) {
        super(eventLoopGroup0, threadFactory0, true);
    }

    public DefaultEventLoop(Executor executor0) {
        this(null, executor0);
    }

    public DefaultEventLoop(ThreadFactory threadFactory0) {
        this(null, threadFactory0);
    }

    @Override  // io.netty.util.concurrent.SingleThreadEventExecutor
    public void run() {
        do {
            Runnable runnable0 = this.takeTask();
            if(runnable0 != null) {
                AbstractEventExecutor.runTask(runnable0);
                this.updateLastExecutionTime();
            }
        }
        while(!this.confirmShutdown());
    }
}

