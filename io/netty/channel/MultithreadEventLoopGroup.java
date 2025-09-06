package io.netty.channel;

import io.netty.util.NettyRuntime;
import io.netty.util.concurrent.DefaultThreadFactory;
import io.netty.util.concurrent.EventExecutor;
import io.netty.util.concurrent.EventExecutorChooserFactory;
import io.netty.util.concurrent.MultithreadEventExecutorGroup;
import io.netty.util.internal.SystemPropertyUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadFactory;

public abstract class MultithreadEventLoopGroup extends MultithreadEventExecutorGroup implements EventLoopGroup {
    private static final int DEFAULT_EVENT_LOOP_THREADS;
    private static final InternalLogger logger;

    static {
        InternalLogger internalLogger0 = InternalLoggerFactory.getInstance(MultithreadEventLoopGroup.class);
        MultithreadEventLoopGroup.logger = internalLogger0;
        int v = Math.max(1, SystemPropertyUtil.getInt("io.netty.eventLoopThreads", NettyRuntime.availableProcessors() * 2));
        MultithreadEventLoopGroup.DEFAULT_EVENT_LOOP_THREADS = v;
        if(internalLogger0.isDebugEnabled()) {
            internalLogger0.debug("-Dio.netty.eventLoopThreads: {}", v);
        }
    }

    public MultithreadEventLoopGroup(int v, Executor executor0, EventExecutorChooserFactory eventExecutorChooserFactory0, Object[] arr_object) {
        if(v == 0) {
            v = MultithreadEventLoopGroup.DEFAULT_EVENT_LOOP_THREADS;
        }
        super(v, executor0, eventExecutorChooserFactory0, arr_object);
    }

    public MultithreadEventLoopGroup(int v, Executor executor0, Object[] arr_object) {
        if(v == 0) {
            v = MultithreadEventLoopGroup.DEFAULT_EVENT_LOOP_THREADS;
        }
        super(v, executor0, arr_object);
    }

    public MultithreadEventLoopGroup(int v, ThreadFactory threadFactory0, Object[] arr_object) {
        if(v == 0) {
            v = MultithreadEventLoopGroup.DEFAULT_EVENT_LOOP_THREADS;
        }
        super(v, threadFactory0, arr_object);
    }

    public abstract EventLoop newChild(Executor arg1, Object[] arg2);

    @Override  // io.netty.util.concurrent.MultithreadEventExecutorGroup
    public EventExecutor newChild(Executor executor0, Object[] arr_object) {
        return this.newChild(executor0, arr_object);
    }

    @Override  // io.netty.util.concurrent.MultithreadEventExecutorGroup
    public ThreadFactory newDefaultThreadFactory() {
        return new DefaultThreadFactory(this.getClass(), 10);
    }

    @Override  // io.netty.channel.EventLoopGroup
    public EventLoop next() {
        return (EventLoop)super.next();
    }

    @Override  // io.netty.util.concurrent.MultithreadEventExecutorGroup, io.netty.util.concurrent.EventExecutorGroup
    public EventExecutor next() {
        return this.next();
    }

    @Override  // io.netty.channel.EventLoopGroup
    public ChannelFuture register(Channel channel0) {
        return this.next().register(channel0);
    }

    @Override  // io.netty.channel.EventLoopGroup
    @Deprecated
    public ChannelFuture register(Channel channel0, ChannelPromise channelPromise0) {
        return this.next().register(channel0, channelPromise0);
    }

    @Override  // io.netty.channel.EventLoopGroup
    public ChannelFuture register(ChannelPromise channelPromise0) {
        return this.next().register(channelPromise0);
    }
}

