package io.netty.channel;

import io.netty.util.concurrent.Future;

@Deprecated
public class ThreadPerChannelEventLoop extends SingleThreadEventLoop {
    private Channel ch;
    private final ThreadPerChannelEventLoopGroup parent;

    public ThreadPerChannelEventLoop(ThreadPerChannelEventLoopGroup threadPerChannelEventLoopGroup0) {
        super(threadPerChannelEventLoopGroup0, threadPerChannelEventLoopGroup0.executor, true);
        this.parent = threadPerChannelEventLoopGroup0;
    }

    public void deregister() {
        this.ch = null;
        this.parent.activeChildren.remove(this);
        this.parent.idleChildren.add(this);
    }

    @Override  // io.netty.channel.SingleThreadEventLoop
    @Deprecated
    public ChannelFuture register(Channel channel0, ChannelPromise channelPromise0) {
        return super.register(channel0, channelPromise0).addListener(new ChannelFutureListener() {
            public void operationComplete(ChannelFuture channelFuture0) {
                if(channelFuture0.isSuccess()) {
                    Channel channel0 = channelFuture0.channel();
                    ThreadPerChannelEventLoop.this.ch = channel0;
                    return;
                }
                ThreadPerChannelEventLoop.this.deregister();
            }

            @Override  // io.netty.util.concurrent.GenericFutureListener
            public void operationComplete(Future future0) {
                this.operationComplete(((ChannelFuture)future0));
            }
        });
    }

    @Override  // io.netty.channel.SingleThreadEventLoop
    public ChannelFuture register(ChannelPromise channelPromise0) {
        return super.register(channelPromise0).addListener(new ChannelFutureListener() {
            public void operationComplete(ChannelFuture channelFuture0) {
                if(channelFuture0.isSuccess()) {
                    Channel channel0 = channelFuture0.channel();
                    ThreadPerChannelEventLoop.this.ch = channel0;
                    return;
                }
                ThreadPerChannelEventLoop.this.deregister();
            }

            @Override  // io.netty.util.concurrent.GenericFutureListener
            public void operationComplete(Future future0) {
                this.operationComplete(((ChannelFuture)future0));
            }
        });
    }

    @Override  // io.netty.channel.SingleThreadEventLoop
    public int registeredChannels() {
        return 1;
    }

    @Override  // io.netty.util.concurrent.SingleThreadEventExecutor
    public void run() {
        Channel channel0;
        while(true) {
            while(true) {
            label_0:
                Runnable runnable0 = this.takeTask();
                if(runnable0 != null) {
                    runnable0.run();
                    this.updateLastExecutionTime();
                }
                channel0 = this.ch;
                if(this.isShuttingDown()) {
                    break;
                }
                if(channel0 != null && !channel0.isRegistered()) {
                    this.runAllTasks();
                    this.deregister();
                }
            }
            if(channel0 != null) {
                channel0.unsafe().close(channel0.unsafe().voidPromise());
            }
            if(!this.confirmShutdown()) {
                goto label_0;
            }
            break;
        }
    }
}

