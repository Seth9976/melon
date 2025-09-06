package io.netty.channel;

import java.net.SocketAddress;

public abstract class AbstractServerChannel extends AbstractChannel implements ServerChannel {
    final class DefaultServerUnsafe extends AbstractUnsafe {
        private DefaultServerUnsafe() {
        }

        public DefaultServerUnsafe(io.netty.channel.AbstractServerChannel.1 abstractServerChannel$10) {
        }

        @Override  // io.netty.channel.Channel$Unsafe
        public void connect(SocketAddress socketAddress0, SocketAddress socketAddress1, ChannelPromise channelPromise0) {
            this.safeSetFailure(channelPromise0, new UnsupportedOperationException());
        }
    }

    private static final ChannelMetadata METADATA;

    static {
        AbstractServerChannel.METADATA = new ChannelMetadata(false, 16);
    }

    public AbstractServerChannel() {
        super(null);
    }

    @Override  // io.netty.channel.AbstractChannel
    public void doDisconnect() {
        throw new UnsupportedOperationException();
    }

    @Override  // io.netty.channel.AbstractChannel
    public void doWrite(ChannelOutboundBuffer channelOutboundBuffer0) {
        throw new UnsupportedOperationException();
    }

    @Override  // io.netty.channel.AbstractChannel
    public final Object filterOutboundMessage(Object object0) {
        throw new UnsupportedOperationException();
    }

    @Override  // io.netty.channel.Channel
    public ChannelMetadata metadata() {
        return AbstractServerChannel.METADATA;
    }

    @Override  // io.netty.channel.AbstractChannel
    public AbstractUnsafe newUnsafe() {
        return new DefaultServerUnsafe(this, null);
    }

    @Override  // io.netty.channel.AbstractChannel, io.netty.channel.Channel
    public SocketAddress remoteAddress() {
        return null;
    }

    @Override  // io.netty.channel.AbstractChannel
    public SocketAddress remoteAddress0() {
        return null;
    }

    class io.netty.channel.AbstractServerChannel.1 {
    }

}

