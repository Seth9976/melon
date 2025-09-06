package io.netty.channel.nio;

import io.netty.channel.DefaultSelectStrategyFactory;
import io.netty.channel.EventLoop;
import io.netty.channel.EventLoopTaskQueueFactory;
import io.netty.channel.MultithreadEventLoopGroup;
import io.netty.channel.SelectStrategyFactory;
import io.netty.util.concurrent.EventExecutor;
import io.netty.util.concurrent.EventExecutorChooserFactory;
import io.netty.util.concurrent.RejectedExecutionHandler;
import io.netty.util.concurrent.RejectedExecutionHandlers;
import java.nio.channels.spi.SelectorProvider;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadFactory;

public class NioEventLoopGroup extends MultithreadEventLoopGroup {
    public NioEventLoopGroup() {
        this(0);
    }

    public NioEventLoopGroup(int v) {
        this(v, null);
    }

    public NioEventLoopGroup(int v, Executor executor0) {
        this(v, executor0, SelectorProvider.provider());
    }

    public NioEventLoopGroup(int v, Executor executor0, EventExecutorChooserFactory eventExecutorChooserFactory0, SelectorProvider selectorProvider0, SelectStrategyFactory selectStrategyFactory0) {
        super(v, executor0, eventExecutorChooserFactory0, new Object[]{selectorProvider0, selectStrategyFactory0, RejectedExecutionHandlers.reject()});
    }

    public NioEventLoopGroup(int v, Executor executor0, EventExecutorChooserFactory eventExecutorChooserFactory0, SelectorProvider selectorProvider0, SelectStrategyFactory selectStrategyFactory0, RejectedExecutionHandler rejectedExecutionHandler0) {
        super(v, executor0, eventExecutorChooserFactory0, new Object[]{selectorProvider0, selectStrategyFactory0, rejectedExecutionHandler0});
    }

    public NioEventLoopGroup(int v, Executor executor0, EventExecutorChooserFactory eventExecutorChooserFactory0, SelectorProvider selectorProvider0, SelectStrategyFactory selectStrategyFactory0, RejectedExecutionHandler rejectedExecutionHandler0, EventLoopTaskQueueFactory eventLoopTaskQueueFactory0) {
        super(v, executor0, eventExecutorChooserFactory0, new Object[]{selectorProvider0, selectStrategyFactory0, rejectedExecutionHandler0, eventLoopTaskQueueFactory0});
    }

    public NioEventLoopGroup(int v, Executor executor0, EventExecutorChooserFactory eventExecutorChooserFactory0, SelectorProvider selectorProvider0, SelectStrategyFactory selectStrategyFactory0, RejectedExecutionHandler rejectedExecutionHandler0, EventLoopTaskQueueFactory eventLoopTaskQueueFactory0, EventLoopTaskQueueFactory eventLoopTaskQueueFactory1) {
        super(v, executor0, eventExecutorChooserFactory0, new Object[]{selectorProvider0, selectStrategyFactory0, rejectedExecutionHandler0, eventLoopTaskQueueFactory0, eventLoopTaskQueueFactory1});
    }

    public NioEventLoopGroup(int v, Executor executor0, SelectorProvider selectorProvider0) {
        this(v, executor0, selectorProvider0, DefaultSelectStrategyFactory.INSTANCE);
    }

    public NioEventLoopGroup(int v, Executor executor0, SelectorProvider selectorProvider0, SelectStrategyFactory selectStrategyFactory0) {
        super(v, executor0, new Object[]{selectorProvider0, selectStrategyFactory0, RejectedExecutionHandlers.reject()});
    }

    public NioEventLoopGroup(int v, ThreadFactory threadFactory0) {
        this(v, threadFactory0, SelectorProvider.provider());
    }

    public NioEventLoopGroup(int v, ThreadFactory threadFactory0, SelectorProvider selectorProvider0) {
        this(v, threadFactory0, selectorProvider0, DefaultSelectStrategyFactory.INSTANCE);
    }

    public NioEventLoopGroup(int v, ThreadFactory threadFactory0, SelectorProvider selectorProvider0, SelectStrategyFactory selectStrategyFactory0) {
        super(v, threadFactory0, new Object[]{selectorProvider0, selectStrategyFactory0, RejectedExecutionHandlers.reject()});
    }

    public NioEventLoopGroup(ThreadFactory threadFactory0) {
        this(0, threadFactory0, SelectorProvider.provider());
    }

    @Override  // io.netty.channel.MultithreadEventLoopGroup
    public EventLoop newChild(Executor executor0, Object[] arr_object) {
        SelectorProvider selectorProvider0 = (SelectorProvider)arr_object[0];
        SelectStrategyFactory selectStrategyFactory0 = (SelectStrategyFactory)arr_object[1];
        RejectedExecutionHandler rejectedExecutionHandler0 = (RejectedExecutionHandler)arr_object[2];
        EventLoopTaskQueueFactory eventLoopTaskQueueFactory0 = null;
        EventLoopTaskQueueFactory eventLoopTaskQueueFactory1 = arr_object.length <= 3 ? null : ((EventLoopTaskQueueFactory)arr_object[3]);
        if(arr_object.length > 4) {
            eventLoopTaskQueueFactory0 = (EventLoopTaskQueueFactory)arr_object[4];
        }
        return new NioEventLoop(this, executor0, selectorProvider0, selectStrategyFactory0.newSelectStrategy(), rejectedExecutionHandler0, eventLoopTaskQueueFactory1, eventLoopTaskQueueFactory0);
    }

    @Override  // io.netty.channel.MultithreadEventLoopGroup
    public EventExecutor newChild(Executor executor0, Object[] arr_object) {
        return this.newChild(executor0, arr_object);
    }

    public void rebuildSelectors() {
        for(Object object0: this) {
            ((NioEventLoop)(((EventExecutor)object0))).rebuildSelector();
        }
    }

    public void setIoRatio(int v) {
        for(Object object0: this) {
            ((NioEventLoop)(((EventExecutor)object0))).setIoRatio(v);
        }
    }
}

