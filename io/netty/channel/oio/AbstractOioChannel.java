package io.netty.channel.oio;

import io.netty.channel.AbstractChannel.AbstractUnsafe;
import io.netty.channel.AbstractChannel;
import io.netty.channel.Channel;
import io.netty.channel.ChannelPromise;
import io.netty.channel.EventLoop;
import io.netty.channel.ThreadPerChannelEventLoop;
import java.net.SocketAddress;

@Deprecated
public abstract class AbstractOioChannel extends AbstractChannel {
    final class DefaultOioUnsafe extends AbstractUnsafe {
        private DefaultOioUnsafe() {
        }

        public DefaultOioUnsafe(io.netty.channel.oio.AbstractOioChannel.1 abstractOioChannel$10) {
        }

        @Override  // io.netty.channel.Channel$Unsafe
        public void connect(SocketAddress socketAddress0, SocketAddress socketAddress1, ChannelPromise channelPromise0) {
            if(channelPromise0.setUncancellable() && this.ensureOpen(channelPromise0)) {
                try {
                    boolean z = AbstractOioChannel.this.isActive();
                    AbstractOioChannel.this.doConnect(socketAddress0, socketAddress1);
                    boolean z1 = AbstractOioChannel.this.isActive();
                    this.safeSetSuccess(channelPromise0);
                    if(!z && z1) {
                        AbstractOioChannel.this.pipeline().fireChannelActive();
                    }
                }
                catch(Throwable throwable0) {
                    this.safeSetFailure(channelPromise0, this.annotateConnectException(throwable0, socketAddress0));
                    this.closeIfClosed();
                }
            }
        }
    }

    protected static final int SO_TIMEOUT = 1000;
    private final Runnable clearReadPendingRunnable;
    boolean readPending;
    final Runnable readTask;
    boolean readWhenInactive;

    public AbstractOioChannel(Channel channel0) {
        super(channel0);
        this.readTask = () -> ;;
        this.clearReadPendingRunnable = new Runnable() {
            @Override
            public void run() {
                AbstractOioChannel.this.readPending = false;
            }
        };
    }

    public final void clearReadPending() {
        if(this.isRegistered()) {
            EventLoop eventLoop0 = this.eventLoop();
            if(eventLoop0.inEventLoop()) {
                this.readPending = false;
                return;
            }
            eventLoop0.execute(this.clearReadPendingRunnable);
            return;
        }
        this.readPending = false;
    }

    @Override  // io.netty.channel.AbstractChannel
    public void doBeginRead() {
        if(this.readPending) {
            return;
        }
        if(!this.isActive()) {
            this.readWhenInactive = true;
            return;
        }
        this.readPending = true;
        this.eventLoop().execute(this.readTask);
    }

    public abstract void doConnect(SocketAddress arg1, SocketAddress arg2);

    // 检测为 Lambda 实现
    public abstract void doRead();

    @Override  // io.netty.channel.AbstractChannel
    public boolean isCompatible(EventLoop eventLoop0) {
        return eventLoop0 instanceof ThreadPerChannelEventLoop;
    }

    @Deprecated
    public boolean isReadPending() {
        return this.readPending;
    }

    @Override  // io.netty.channel.AbstractChannel
    public AbstractUnsafe newUnsafe() {
        return new DefaultOioUnsafe(this, null);
    }

    @Deprecated
    public void setReadPending(boolean z) {
        if(this.isRegistered()) {
            EventLoop eventLoop0 = this.eventLoop();
            if(eventLoop0.inEventLoop()) {
                this.readPending = z;
                return;
            }
            eventLoop0.execute(new Runnable() {
                @Override
                public void run() {
                    AbstractOioChannel.this.readPending = z;
                }
            });
            return;
        }
        this.readPending = z;
    }

    class io.netty.channel.oio.AbstractOioChannel.1 implements Runnable {
        @Override
        public void run() {
            AbstractOioChannel.this.doRead();
        }
    }

}

