package io.netty.channel;

import io.netty.util.concurrent.AbstractEventExecutorGroup;
import io.netty.util.concurrent.DefaultPromise;
import io.netty.util.concurrent.DefaultThreadFactory;
import io.netty.util.concurrent.EventExecutor;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.FutureListener;
import io.netty.util.concurrent.GlobalEventExecutor;
import io.netty.util.concurrent.Promise;
import io.netty.util.concurrent.ThreadPerTaskExecutor;
import io.netty.util.internal.EmptyArrays;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.ReadOnlyIterator;
import java.util.Collections;
import java.util.Iterator;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

@Deprecated
public class ThreadPerChannelEventLoopGroup extends AbstractEventExecutorGroup implements EventLoopGroup {
    final Set activeChildren;
    private final Object[] childArgs;
    private final FutureListener childTerminationListener;
    final Executor executor;
    final Queue idleChildren;
    private final int maxChannels;
    private volatile boolean shuttingDown;
    private final Promise terminationFuture;
    private final ChannelException tooManyChannels;

    public ThreadPerChannelEventLoopGroup() {
        this(0);
    }

    public ThreadPerChannelEventLoopGroup(int v) {
        this(v, null, new Object[0]);
    }

    public ThreadPerChannelEventLoopGroup(int v, Executor executor0, Object[] arr_object) {
        this.activeChildren = Collections.newSetFromMap(PlatformDependent.newConcurrentHashMap());
        this.idleChildren = new ConcurrentLinkedQueue();
        this.terminationFuture = new DefaultPromise(GlobalEventExecutor.INSTANCE);
        this.childTerminationListener = new FutureListener() {
            @Override  // io.netty.util.concurrent.GenericFutureListener
            public void operationComplete(Future future0) {
                if(ThreadPerChannelEventLoopGroup.this.isTerminated()) {
                    ThreadPerChannelEventLoopGroup.this.terminationFuture.trySuccess(null);
                }
            }
        };
        ObjectUtil.checkPositiveOrZero(v, "maxChannels");
        if(executor0 == null) {
            executor0 = new ThreadPerTaskExecutor(new DefaultThreadFactory(this.getClass()));
        }
        this.childArgs = arr_object == null ? EmptyArrays.EMPTY_OBJECTS : ((Object[])arr_object.clone());
        this.maxChannels = v;
        this.executor = executor0;
        this.tooManyChannels = ChannelException.newStatic(("too many channels (max: " + v + ')'), ThreadPerChannelEventLoopGroup.class, "nextChild()");
    }

    public ThreadPerChannelEventLoopGroup(int v, ThreadFactory threadFactory0, Object[] arr_object) {
        this(v, (threadFactory0 == null ? null : new ThreadPerTaskExecutor(threadFactory0)), arr_object);
    }

    @Override
    public boolean awaitTermination(long v, TimeUnit timeUnit0) {
        long v1 = timeUnit0.toNanos(v) + System.nanoTime();
        for(Object object0: this.activeChildren) {
            do {
                long v2 = v1 - System.nanoTime();
                if(v2 <= 0L) {
                    return this.isTerminated();
                }
            }
            while(!((EventLoop)object0).awaitTermination(v2, TimeUnit.NANOSECONDS));
        }
        for(Object object1: this.idleChildren) {
            do {
                long v3 = v1 - System.nanoTime();
                if(v3 <= 0L) {
                    return this.isTerminated();
                }
            }
            while(!((EventLoop)object1).awaitTermination(v3, TimeUnit.NANOSECONDS));
        }
        return this.isTerminated();
    }

    @Override
    public boolean isShutdown() {
        for(Object object0: this.activeChildren) {
            if(!((EventLoop)object0).isShutdown()) {
                return false;
            }
            if(false) {
                break;
            }
        }
        for(Object object1: this.idleChildren) {
            if(!((EventLoop)object1).isShutdown()) {
                return false;
            }
            if(false) {
                break;
            }
        }
        return true;
    }

    @Override  // io.netty.util.concurrent.EventExecutorGroup
    public boolean isShuttingDown() {
        for(Object object0: this.activeChildren) {
            if(!((EventLoop)object0).isShuttingDown()) {
                return false;
            }
            if(false) {
                break;
            }
        }
        for(Object object1: this.idleChildren) {
            if(!((EventLoop)object1).isShuttingDown()) {
                return false;
            }
            if(false) {
                break;
            }
        }
        return true;
    }

    @Override
    public boolean isTerminated() {
        for(Object object0: this.activeChildren) {
            if(!((EventLoop)object0).isTerminated()) {
                return false;
            }
            if(false) {
                break;
            }
        }
        for(Object object1: this.idleChildren) {
            if(!((EventLoop)object1).isTerminated()) {
                return false;
            }
            if(false) {
                break;
            }
        }
        return true;
    }

    @Override  // io.netty.util.concurrent.EventExecutorGroup
    public Iterator iterator() {
        return new ReadOnlyIterator(this.activeChildren.iterator());
    }

    public EventLoop newChild(Object[] arr_object) {
        return new ThreadPerChannelEventLoop(this);
    }

    @Override  // io.netty.channel.EventLoopGroup
    public EventLoop next() {
        throw new UnsupportedOperationException();
    }

    @Override  // io.netty.util.concurrent.EventExecutorGroup
    public EventExecutor next() {
        return this.next();
    }

    private EventLoop nextChild() {
        if(this.shuttingDown) {
            throw new RejectedExecutionException("shutting down");
        }
        EventLoop eventLoop0 = (EventLoop)this.idleChildren.poll();
        if(eventLoop0 == null) {
            if(this.maxChannels > 0 && this.activeChildren.size() >= this.maxChannels) {
                throw this.tooManyChannels;
            }
            eventLoop0 = this.newChild(this.childArgs);
            eventLoop0.terminationFuture().addListener(this.childTerminationListener);
        }
        this.activeChildren.add(eventLoop0);
        return eventLoop0;
    }

    @Override  // io.netty.channel.EventLoopGroup
    public ChannelFuture register(Channel channel0) {
        ObjectUtil.checkNotNull(channel0, "channel");
        try {
            EventLoop eventLoop0 = this.nextChild();
            return eventLoop0.register(new DefaultChannelPromise(channel0, eventLoop0));
        }
        catch(Throwable throwable0) {
            return new FailedChannelFuture(channel0, GlobalEventExecutor.INSTANCE, throwable0);
        }
    }

    @Override  // io.netty.channel.EventLoopGroup
    @Deprecated
    public ChannelFuture register(Channel channel0, ChannelPromise channelPromise0) {
        ObjectUtil.checkNotNull(channel0, "channel");
        try {
            return this.nextChild().register(channel0, channelPromise0);
        }
        catch(Throwable throwable0) {
            channelPromise0.setFailure(throwable0);
            return channelPromise0;
        }
    }

    @Override  // io.netty.channel.EventLoopGroup
    public ChannelFuture register(ChannelPromise channelPromise0) {
        try {
            return this.nextChild().register(channelPromise0);
        }
        catch(Throwable throwable0) {
            channelPromise0.setFailure(throwable0);
            return channelPromise0;
        }
    }

    @Override  // io.netty.util.concurrent.AbstractEventExecutorGroup, io.netty.util.concurrent.EventExecutorGroup
    @Deprecated
    public void shutdown() {
        this.shuttingDown = true;
        for(Object object0: this.activeChildren) {
            ((EventLoop)object0).shutdown();
        }
        for(Object object1: this.idleChildren) {
            ((EventLoop)object1).shutdown();
        }
        if(this.isTerminated()) {
            this.terminationFuture.trySuccess(null);
        }
    }

    @Override  // io.netty.util.concurrent.EventExecutorGroup
    public Future shutdownGracefully(long v, long v1, TimeUnit timeUnit0) {
        this.shuttingDown = true;
        for(Object object0: this.activeChildren) {
            ((EventLoop)object0).shutdownGracefully(v, v1, timeUnit0);
        }
        for(Object object1: this.idleChildren) {
            ((EventLoop)object1).shutdownGracefully(v, v1, timeUnit0);
        }
        if(this.isTerminated()) {
            this.terminationFuture.trySuccess(null);
        }
        return this.terminationFuture();
    }

    @Override  // io.netty.util.concurrent.EventExecutorGroup
    public Future terminationFuture() {
        return this.terminationFuture;
    }
}

