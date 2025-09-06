package io.netty.channel.socket.nio;

import io.netty.channel.ChannelConfig;
import io.netty.channel.ChannelException;
import io.netty.channel.ChannelMetadata;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelOutboundBuffer;
import io.netty.channel.nio.AbstractNioMessageChannel;
import io.netty.channel.socket.DefaultServerSocketChannelConfig;
import io.netty.channel.socket.InternetProtocolFamily;
import io.netty.channel.socket.ServerSocketChannel;
import io.netty.channel.socket.ServerSocketChannelConfig;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.SocketUtils;
import io.netty.util.internal.SuppressJava6Requirement;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.SocketAddress;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SocketChannel;
import java.nio.channels.spi.SelectorProvider;
import java.util.List;
import java.util.Map;

public class NioServerSocketChannel extends AbstractNioMessageChannel implements ServerSocketChannel {
    final class NioServerSocketChannelConfig extends DefaultServerSocketChannelConfig {
        private NioServerSocketChannelConfig(NioServerSocketChannel nioServerSocketChannel1, ServerSocket serverSocket0) {
            super(nioServerSocketChannel1, serverSocket0);
        }

        public NioServerSocketChannelConfig(NioServerSocketChannel nioServerSocketChannel1, ServerSocket serverSocket0, io.netty.channel.socket.nio.NioServerSocketChannel.1 nioServerSocketChannel$10) {
            this(nioServerSocketChannel1, serverSocket0);
        }

        @Override  // io.netty.channel.DefaultChannelConfig
        public void autoReadCleared() {
            NioServerSocketChannel.this.clearReadPending();
        }

        // 去混淆评级： 低(30)
        @Override  // io.netty.channel.socket.DefaultServerSocketChannelConfig
        public Object getOption(ChannelOption channelOption0) {
            return super.getOption(channelOption0);
        }

        // 去混淆评级： 低(20)
        @Override  // io.netty.channel.socket.DefaultServerSocketChannelConfig
        public Map getOptions() {
            return super.getOptions();
        }

        private java.nio.channels.ServerSocketChannel jdkChannel() {
            return ((NioServerSocketChannel)this.channel).javaChannel();
        }

        // 去混淆评级： 低(30)
        @Override  // io.netty.channel.socket.DefaultServerSocketChannelConfig
        public boolean setOption(ChannelOption channelOption0, Object object0) {
            return super.setOption(channelOption0, object0);
        }
    }

    private static final SelectorProvider DEFAULT_SELECTOR_PROVIDER;
    private static final ChannelMetadata METADATA;
    private static final Method OPEN_SERVER_SOCKET_CHANNEL_WITH_FAMILY;
    private final ServerSocketChannelConfig config;
    private static final InternalLogger logger;

    static {
        NioServerSocketChannel.METADATA = new ChannelMetadata(false, 16);
        NioServerSocketChannel.DEFAULT_SELECTOR_PROVIDER = SelectorProvider.provider();
        NioServerSocketChannel.logger = InternalLoggerFactory.getInstance(NioServerSocketChannel.class);
        NioServerSocketChannel.OPEN_SERVER_SOCKET_CHANNEL_WITH_FAMILY = SelectorProviderUtil.findOpenMethod("openServerSocketChannel");
    }

    public NioServerSocketChannel() {
        this(NioServerSocketChannel.DEFAULT_SELECTOR_PROVIDER);
    }

    public NioServerSocketChannel(java.nio.channels.ServerSocketChannel serverSocketChannel0) {
        super(null, serverSocketChannel0, 16);
        this.config = new NioServerSocketChannelConfig(this, this, this.javaChannel().socket(), null);
    }

    public NioServerSocketChannel(SelectorProvider selectorProvider0) {
        this(selectorProvider0, null);
    }

    public NioServerSocketChannel(SelectorProvider selectorProvider0, InternetProtocolFamily internetProtocolFamily0) {
        this(NioServerSocketChannel.newChannel(selectorProvider0, internetProtocolFamily0));
    }

    @Override  // io.netty.channel.nio.AbstractNioMessageChannel
    public boolean closeOnReadError(Throwable throwable0) {
        return super.closeOnReadError(throwable0);
    }

    @Override  // io.netty.channel.Channel
    public ChannelConfig config() {
        return this.config();
    }

    @Override  // io.netty.channel.socket.ServerSocketChannel
    public ServerSocketChannelConfig config() {
        return this.config;
    }

    @Override  // io.netty.channel.AbstractChannel
    @SuppressJava6Requirement(reason = "Usage guarded by java version check")
    public void doBind(SocketAddress socketAddress0) {
        if(PlatformDependent.javaVersion() >= 7) {
            this.javaChannel().bind(socketAddress0, this.config.getBacklog());
            return;
        }
        this.javaChannel().socket().bind(socketAddress0, this.config.getBacklog());
    }

    @Override  // io.netty.channel.nio.AbstractNioChannel
    public void doClose() {
        this.javaChannel().close();
    }

    @Override  // io.netty.channel.nio.AbstractNioChannel
    public boolean doConnect(SocketAddress socketAddress0, SocketAddress socketAddress1) {
        throw new UnsupportedOperationException();
    }

    @Override  // io.netty.channel.AbstractChannel
    public void doDisconnect() {
        throw new UnsupportedOperationException();
    }

    @Override  // io.netty.channel.nio.AbstractNioChannel
    public void doFinishConnect() {
        throw new UnsupportedOperationException();
    }

    @Override  // io.netty.channel.nio.AbstractNioMessageChannel
    public int doReadMessages(List list0) {
        SocketChannel socketChannel0 = SocketUtils.accept(this.javaChannel());
        if(socketChannel0 != null) {
            try {
                list0.add(new NioSocketChannel(this, socketChannel0));
                return 1;
            }
            catch(Throwable throwable0) {
                NioServerSocketChannel.logger.warn("Failed to create a new channel from an accepted socket.", throwable0);
                try {
                    socketChannel0.close();
                    return 0;
                }
                catch(Throwable throwable1) {
                    NioServerSocketChannel.logger.warn("Failed to close a socket.", throwable1);
                }
            }
        }
        return 0;
    }

    @Override  // io.netty.channel.nio.AbstractNioMessageChannel
    public boolean doWriteMessage(Object object0, ChannelOutboundBuffer channelOutboundBuffer0) {
        throw new UnsupportedOperationException();
    }

    @Override  // io.netty.channel.AbstractChannel
    public final Object filterOutboundMessage(Object object0) {
        throw new UnsupportedOperationException();
    }

    // 去混淆评级： 低(20)
    @Override  // io.netty.channel.Channel
    public boolean isActive() {
        return this.isOpen() && this.javaChannel().socket().isBound();
    }

    @Override  // io.netty.channel.nio.AbstractNioChannel
    public SelectableChannel javaChannel() {
        return this.javaChannel();
    }

    public java.nio.channels.ServerSocketChannel javaChannel() {
        return (java.nio.channels.ServerSocketChannel)super.javaChannel();
    }

    @Override  // io.netty.channel.socket.ServerSocketChannel
    public InetSocketAddress localAddress() {
        return (InetSocketAddress)super.localAddress();
    }

    @Override  // io.netty.channel.AbstractChannel, io.netty.channel.Channel
    public SocketAddress localAddress() {
        return this.localAddress();
    }

    @Override  // io.netty.channel.AbstractChannel
    public SocketAddress localAddress0() {
        return SocketUtils.localSocketAddress(this.javaChannel().socket());
    }

    @Override  // io.netty.channel.Channel
    public ChannelMetadata metadata() {
        return NioServerSocketChannel.METADATA;
    }

    private static java.nio.channels.ServerSocketChannel newChannel(SelectorProvider selectorProvider0, InternetProtocolFamily internetProtocolFamily0) {
        try {
            java.nio.channels.ServerSocketChannel serverSocketChannel0 = (java.nio.channels.ServerSocketChannel)SelectorProviderUtil.newChannel(NioServerSocketChannel.OPEN_SERVER_SOCKET_CHANNEL_WITH_FAMILY, selectorProvider0, internetProtocolFamily0);
            return serverSocketChannel0 == null ? selectorProvider0.openServerSocketChannel() : serverSocketChannel0;
        }
        catch(IOException iOException0) {
            throw new ChannelException("Failed to open a socket.", iOException0);
        }
    }

    @Override  // io.netty.channel.socket.ServerSocketChannel
    public InetSocketAddress remoteAddress() [...] // Inlined contents

    @Override  // io.netty.channel.AbstractChannel, io.netty.channel.Channel
    public SocketAddress remoteAddress() {
        return null;
    }

    @Override  // io.netty.channel.AbstractChannel
    public SocketAddress remoteAddress0() {
        return null;
    }

    class io.netty.channel.socket.nio.NioServerSocketChannel.1 {
    }

}

