package io.netty.channel;

import io.netty.util.concurrent.EventExecutor;
import io.netty.util.concurrent.EventExecutorGroup;
import io.netty.util.concurrent.RejectedExecutionHandler;
import io.netty.util.concurrent.RejectedExecutionHandlers;
import io.netty.util.concurrent.SingleThreadEventExecutor;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.SystemPropertyUtil;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadFactory;

public abstract class SingleThreadEventLoop extends SingleThreadEventExecutor implements EventLoop {
    public static final class ChannelsReadOnlyIterator implements Iterator {
        private static final Iterator EMPTY;
        private final Iterator channelIterator;

        static {
            ChannelsReadOnlyIterator.EMPTY = new Iterator() {
                @Override
                public boolean hasNext() {
                    return false;
                }

                @Override
                public Object next() {
                    throw new NoSuchElementException();
                }

                @Override
                public void remove() {
                    throw new UnsupportedOperationException("remove");
                }
            };
        }

        public ChannelsReadOnlyIterator(Iterable iterable0) {
            this.channelIterator = ((Iterable)ObjectUtil.checkNotNull(iterable0, "channelIterable")).iterator();
        }

        public static Iterator empty() {
            return ChannelsReadOnlyIterator.EMPTY;
        }

        @Override
        public boolean hasNext() {
            return this.channelIterator.hasNext();
        }

        public Channel next() {
            return this.channelIterator.next();
        }

        @Override
        public Object next() {
            return this.next();
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("remove");
        }
    }

    protected static final int DEFAULT_MAX_PENDING_TASKS;
    private final Queue tailTasks;

    static {
        SingleThreadEventLoop.DEFAULT_MAX_PENDING_TASKS = Math.max(16, SystemPropertyUtil.getInt("io.netty.eventLoop.maxPendingTasks", 0x7FFFFFFF));
    }

    public SingleThreadEventLoop(EventLoopGroup eventLoopGroup0, Executor executor0, boolean z) {
        this(eventLoopGroup0, executor0, z, SingleThreadEventLoop.DEFAULT_MAX_PENDING_TASKS, RejectedExecutionHandlers.reject());
    }

    public SingleThreadEventLoop(EventLoopGroup eventLoopGroup0, Executor executor0, boolean z, int v, RejectedExecutionHandler rejectedExecutionHandler0) {
        super(eventLoopGroup0, executor0, z, v, rejectedExecutionHandler0);
        this.tailTasks = this.newTaskQueue(v);
    }

    public SingleThreadEventLoop(EventLoopGroup eventLoopGroup0, Executor executor0, boolean z, Queue queue0, Queue queue1, RejectedExecutionHandler rejectedExecutionHandler0) {
        super(eventLoopGroup0, executor0, z, queue0, rejectedExecutionHandler0);
        this.tailTasks = (Queue)ObjectUtil.checkNotNull(queue1, "tailTaskQueue");
    }

    public SingleThreadEventLoop(EventLoopGroup eventLoopGroup0, ThreadFactory threadFactory0, boolean z) {
        this(eventLoopGroup0, threadFactory0, z, SingleThreadEventLoop.DEFAULT_MAX_PENDING_TASKS, RejectedExecutionHandlers.reject());
    }

    public SingleThreadEventLoop(EventLoopGroup eventLoopGroup0, ThreadFactory threadFactory0, boolean z, int v, RejectedExecutionHandler rejectedExecutionHandler0) {
        super(eventLoopGroup0, threadFactory0, z, v, rejectedExecutionHandler0);
        this.tailTasks = this.newTaskQueue(v);
    }

    @Override  // io.netty.util.concurrent.SingleThreadEventExecutor
    public void afterRunningAllTasks() {
        this.runAllTasksFrom(this.tailTasks);
    }

    public final void executeAfterEventLoopIteration(Runnable runnable0) {
        ObjectUtil.checkNotNull(runnable0, "task");
        if(this.isShutdown()) {
            SingleThreadEventExecutor.reject();
        }
        if(!this.tailTasks.offer(runnable0)) {
            this.reject(runnable0);
        }
        this.wakeup(this.inEventLoop());
    }

    // 去混淆评级： 低(20)
    @Override  // io.netty.util.concurrent.SingleThreadEventExecutor
    public boolean hasTasks() {
        return super.hasTasks() || !this.tailTasks.isEmpty();
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

    @Override  // io.netty.util.concurrent.SingleThreadEventExecutor
    public int pendingTasks() {
        int v = super.pendingTasks();
        return this.tailTasks.size() + v;
    }

    @Override  // io.netty.channel.EventLoopGroup
    public ChannelFuture register(Channel channel0) {
        return this.register(new DefaultChannelPromise(channel0, this));
    }

    @Override  // io.netty.channel.EventLoopGroup
    @Deprecated
    public ChannelFuture register(Channel channel0, ChannelPromise channelPromise0) {
        ObjectUtil.checkNotNull(channelPromise0, "promise");
        ObjectUtil.checkNotNull(channel0, "channel");
        channel0.unsafe().register(this, channelPromise0);
        return channelPromise0;
    }

    @Override  // io.netty.channel.EventLoopGroup
    public ChannelFuture register(ChannelPromise channelPromise0) {
        ObjectUtil.checkNotNull(channelPromise0, "promise");
        channelPromise0.channel().unsafe().register(this, channelPromise0);
        return channelPromise0;
    }

    public int registeredChannels() {
        return -1;
    }

    public Iterator registeredChannelsIterator() {
        throw new UnsupportedOperationException("registeredChannelsIterator");
    }

    public final boolean removeAfterEventLoopIterationTask(Runnable runnable0) {
        Object object0 = ObjectUtil.checkNotNull(runnable0, "task");
        return this.tailTasks.remove(object0);
    }
}

