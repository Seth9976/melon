package io.netty.bootstrap;

import io.netty.channel.AbstractChannel.AbstractUnsafe;
import io.netty.channel.AbstractChannel;
import io.netty.channel.ChannelConfig;
import io.netty.channel.ChannelMetadata;
import io.netty.channel.ChannelOutboundBuffer;
import io.netty.channel.ChannelPromise;
import io.netty.channel.DefaultChannelConfig;
import io.netty.channel.EventLoop;
import java.net.SocketAddress;

final class FailedChannel extends AbstractChannel {
    final class FailedChannelUnsafe extends AbstractUnsafe {
        private FailedChannelUnsafe() {
        }

        public FailedChannelUnsafe(io.netty.bootstrap.FailedChannel.1 failedChannel$10) {
        }

        @Override  // io.netty.channel.Channel$Unsafe
        public void connect(SocketAddress socketAddress0, SocketAddress socketAddress1, ChannelPromise channelPromise0) {
            channelPromise0.setFailure(new UnsupportedOperationException());
        }
    }

    private static final ChannelMetadata METADATA;
    private final ChannelConfig config;

    static {
        FailedChannel.METADATA = new ChannelMetadata(false);
    }

    public FailedChannel() {
        super(null);
        this.config = new DefaultChannelConfig(this);
    }

    @Override  // io.netty.channel.Channel
    public ChannelConfig config() {
        return this.config;
    }

    @Override  // io.netty.channel.AbstractChannel
    public void doBeginRead() {
        throw new UnsupportedOperationException();
    }

    @Override  // io.netty.channel.AbstractChannel
    public void doBind(SocketAddress socketAddress0) {
        throw new UnsupportedOperationException();
    }

    @Override  // io.netty.channel.AbstractChannel
    public void doClose() {
        throw new UnsupportedOperationException();
    }

    @Override  // io.netty.channel.AbstractChannel
    public void doDisconnect() {
        throw new UnsupportedOperationException();
    }

    @Override  // io.netty.channel.AbstractChannel
    public void doWrite(ChannelOutboundBuffer channelOutboundBuffer0) {
        throw new UnsupportedOperationException();
    }

    @Override  // io.netty.channel.Channel
    public boolean isActive() {
        return false;
    }

    @Override  // io.netty.channel.AbstractChannel
    public boolean isCompatible(EventLoop eventLoop0) {
        return false;
    }

    @Override  // io.netty.channel.Channel
    public boolean isOpen() {
        return false;
    }

    @Override  // io.netty.channel.AbstractChannel
    public SocketAddress localAddress0() {
        return null;
    }

    @Override  // io.netty.channel.Channel
    public ChannelMetadata metadata() {
        return FailedChannel.METADATA;
    }

    @Override  // io.netty.channel.AbstractChannel
    public AbstractUnsafe newUnsafe() {
        return new FailedChannelUnsafe(this, null);
    }

    @Override  // io.netty.channel.AbstractChannel
    public SocketAddress remoteAddress0() {
        return null;
    }

    class io.netty.bootstrap.FailedChannel.1 {
    }

}

