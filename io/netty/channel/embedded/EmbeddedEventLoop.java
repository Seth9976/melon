package io.netty.channel.embedded;

import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelPromise;
import io.netty.channel.DefaultChannelPromise;
import io.netty.channel.EventLoop;
import io.netty.channel.EventLoopGroup;
import io.netty.util.concurrent.AbstractScheduledEventExecutor;
import io.netty.util.concurrent.EventExecutor;
import io.netty.util.concurrent.EventExecutorGroup;
import io.netty.util.concurrent.Future;
import io.netty.util.internal.ObjectUtil;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.TimeUnit;

final class EmbeddedEventLoop extends AbstractScheduledEventExecutor implements EventLoop {
    private long frozenTimestamp;
    private long startTime;
    private final Queue tasks;
    private boolean timeFrozen;

    public EmbeddedEventLoop() {
        this.startTime = AbstractScheduledEventExecutor.initialNanoTime();
        this.tasks = new ArrayDeque(2);
    }

    public void advanceTimeBy(long v) {
        if(this.timeFrozen) {
            this.frozenTimestamp += v;
            return;
        }
        this.startTime -= v;
    }

    @Override
    public boolean awaitTermination(long v, TimeUnit timeUnit0) {
        return false;
    }

    @Override  // io.netty.util.concurrent.AbstractScheduledEventExecutor
    public void cancelScheduledTasks() {
        super.cancelScheduledTasks();
    }

    @Override
    public void execute(Runnable runnable0) {
        Object object0 = ObjectUtil.checkNotNull(runnable0, "command");
        this.tasks.add(object0);
    }

    public void freezeTime() {
        if(!this.timeFrozen) {
            this.frozenTimestamp = this.getCurrentTimeNanos();
            this.timeFrozen = true;
        }
    }

    // 去混淆评级： 低(20)
    @Override  // io.netty.util.concurrent.AbstractScheduledEventExecutor
    public long getCurrentTimeNanos() {
        return this.timeFrozen ? this.frozenTimestamp : System.nanoTime() - this.startTime;
    }

    public boolean hasPendingNormalTasks() {
        return !this.tasks.isEmpty();
    }

    @Override  // io.netty.util.concurrent.AbstractEventExecutor, io.netty.util.concurrent.EventExecutor
    public boolean inEventLoop() {
        return true;
    }

    @Override  // io.netty.util.concurrent.EventExecutor
    public boolean inEventLoop(Thread thread0) {
        return true;
    }

    @Override
    public boolean isShutdown() {
        return false;
    }

    @Override  // io.netty.util.concurrent.EventExecutorGroup
    public boolean isShuttingDown() {
        return false;
    }

    @Override
    public boolean isTerminated() {
        return false;
    }

    @Override  // io.netty.channel.EventLoopGroup
    public EventLoop next() {
        return (EventLoop)super.next();
    }

    @Override  // io.netty.util.concurrent.AbstractEventExecutor, io.netty.util.concurrent.EventExecutor, io.netty.util.concurrent.EventExecutorGroup
    public EventExecutor next() {
        return this.next();
    }

    public long nextScheduledTask() {
        return this.nextScheduledTaskNano();
    }

    @Override  // io.netty.channel.EventLoop
    public EventLoopGroup parent() {
        return (EventLoopGroup)super.parent();
    }

    @Override  // io.netty.util.concurrent.AbstractEventExecutor, io.netty.util.concurrent.EventExecutor
    public EventExecutorGroup parent() {
        return this.parent();
    }

    @Override  // io.netty.channel.EventLoopGroup
    public ChannelFuture register(Channel channel0) {
        return this.register(new DefaultChannelPromise(channel0, this));
    }

    @Override  // io.netty.channel.EventLoopGroup
    @Deprecated
    public ChannelFuture register(Channel channel0, ChannelPromise channelPromise0) {
        channel0.unsafe().register(this, channelPromise0);
        return channelPromise0;
    }

    @Override  // io.netty.channel.EventLoopGroup
    public ChannelFuture register(ChannelPromise channelPromise0) {
        ObjectUtil.checkNotNull(channelPromise0, "promise");
        channelPromise0.channel().unsafe().register(this, channelPromise0);
        return channelPromise0;
    }

    public long runScheduledTasks() {
        long v = this.getCurrentTimeNanos();
        Runnable runnable0;
        while((runnable0 = this.pollScheduledTask(v)) != null) {
            runnable0.run();
        }
        return this.nextScheduledTaskNano();
    }

    public void runTasks() {
        Runnable runnable0;
        while((runnable0 = (Runnable)this.tasks.poll()) != null) {
            runnable0.run();
        }
    }

    @Override  // io.netty.util.concurrent.AbstractEventExecutor, io.netty.util.concurrent.EventExecutorGroup
    @Deprecated
    public void shutdown() {
        throw new UnsupportedOperationException();
    }

    @Override  // io.netty.util.concurrent.EventExecutorGroup
    public Future shutdownGracefully(long v, long v1, TimeUnit timeUnit0) {
        throw new UnsupportedOperationException();
    }

    @Override  // io.netty.util.concurrent.EventExecutorGroup
    public Future terminationFuture() {
        throw new UnsupportedOperationException();
    }

    public void unfreezeTime() {
        if(this.timeFrozen) {
            this.startTime = System.nanoTime() - this.frozenTimestamp;
            this.timeFrozen = false;
        }
    }
}

