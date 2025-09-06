package io.netty.channel.local;

import io.netty.channel.AbstractServerChannel;
import io.netty.channel.ChannelConfig;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.DefaultChannelConfig;
import io.netty.channel.EventLoop;
import io.netty.channel.PreferHeapByteBufAllocator;
import io.netty.channel.RecvByteBufAllocator.Handle;
import io.netty.channel.ServerChannelRecvByteBufAllocator;
import io.netty.channel.SingleThreadEventLoop;
import io.netty.util.concurrent.SingleThreadEventExecutor;
import java.net.SocketAddress;
import java.util.ArrayDeque;
import java.util.Queue;

public class LocalServerChannel extends AbstractServerChannel {
    private volatile boolean acceptInProgress;
    private final ChannelConfig config;
    private final Queue inboundBuffer;
    private volatile LocalAddress localAddress;
    private final Runnable shutdownHook;
    private volatile int state;

    public LocalServerChannel() {
        io.netty.channel.local.LocalServerChannel.1 localServerChannel$10 = new DefaultChannelConfig(this, new ServerChannelRecvByteBufAllocator()) {
        };
        this.config = localServerChannel$10;
        this.inboundBuffer = new ArrayDeque();
        this.shutdownHook = new Runnable() {
            @Override
            public void run() {
                LocalServerChannel.this.unsafe().close(LocalServerChannel.this.unsafe().voidPromise());
            }
        };
        this.config().setAllocator(new PreferHeapByteBufAllocator(localServerChannel$10.getAllocator()));
    }

    @Override  // io.netty.channel.Channel
    public ChannelConfig config() {
        return this.config;
    }

    @Override  // io.netty.channel.AbstractChannel
    public void doBeginRead() {
        if(this.acceptInProgress) {
            return;
        }
        if(this.inboundBuffer.isEmpty()) {
            this.acceptInProgress = true;
            return;
        }
        this.readInbound();
    }

    @Override  // io.netty.channel.AbstractChannel
    public void doBind(SocketAddress socketAddress0) {
        this.localAddress = LocalChannelRegistry.register(this, this.localAddress, socketAddress0);
        this.state = 1;
    }

    @Override  // io.netty.channel.AbstractChannel
    public void doClose() {
        if(this.state <= 1) {
            if(this.localAddress != null) {
                LocalChannelRegistry.unregister(this.localAddress);
                this.localAddress = null;
            }
            this.state = 2;
        }
    }

    @Override  // io.netty.channel.AbstractChannel
    public void doDeregister() {
        ((SingleThreadEventExecutor)this.eventLoop()).removeShutdownHook(this.shutdownHook);
    }

    @Override  // io.netty.channel.AbstractChannel
    public void doRegister() {
        ((SingleThreadEventExecutor)this.eventLoop()).addShutdownHook(this.shutdownHook);
    }

    @Override  // io.netty.channel.Channel
    public boolean isActive() {
        return this.state == 1;
    }

    @Override  // io.netty.channel.AbstractChannel
    public boolean isCompatible(EventLoop eventLoop0) {
        return eventLoop0 instanceof SingleThreadEventLoop;
    }

    @Override  // io.netty.channel.Channel
    public boolean isOpen() {
        return this.state < 2;
    }

    public LocalAddress localAddress() {
        return (LocalAddress)super.localAddress();
    }

    @Override  // io.netty.channel.AbstractChannel, io.netty.channel.Channel
    public SocketAddress localAddress() {
        return this.localAddress();
    }

    @Override  // io.netty.channel.AbstractChannel
    public SocketAddress localAddress0() {
        return this.localAddress;
    }

    public LocalChannel newLocalChannel(LocalChannel localChannel0) {
        return new LocalChannel(this, localChannel0);
    }

    private void readInbound() {
        Handle recvByteBufAllocator$Handle0 = this.unsafe().recvBufAllocHandle();
        recvByteBufAllocator$Handle0.reset(this.config());
        ChannelPipeline channelPipeline0 = this.pipeline();
        do {
            Object object0 = this.inboundBuffer.poll();
            if(object0 == null) {
                break;
            }
            channelPipeline0.fireChannelRead(object0);
        }
        while(recvByteBufAllocator$Handle0.continueReading());
        recvByteBufAllocator$Handle0.readComplete();
        channelPipeline0.fireChannelReadComplete();
    }

    public LocalAddress remoteAddress() {
        return (LocalAddress)super.remoteAddress();
    }

    @Override  // io.netty.channel.AbstractServerChannel
    public SocketAddress remoteAddress() {
        return this.remoteAddress();
    }

    public LocalChannel serve(LocalChannel localChannel0) {
        LocalChannel localChannel1 = this.newLocalChannel(localChannel0);
        if(this.eventLoop().inEventLoop()) {
            this.serve0(localChannel1);
            return localChannel1;
        }
        this.eventLoop().execute(() -> {
            LocalServerChannel.this.inboundBuffer.add(this.val$child);
            if(LocalServerChannel.this.acceptInProgress) {
                LocalServerChannel.this.acceptInProgress = false;
                LocalServerChannel.this.readInbound();
            }
        });
        return localChannel1;

        class io.netty.channel.local.LocalServerChannel.3 implements Runnable {
            public io.netty.channel.local.LocalServerChannel.3(LocalChannel localChannel0) {
            }

            @Override
            public void run() {
                LocalServerChannel.this.serve0(this.val$child);
            }
        }

    }

    // 检测为 Lambda 实现
    private void serve0(LocalChannel localChannel0) [...]
}

