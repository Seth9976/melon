package io.netty.channel.socket.oio;

import io.netty.channel.ChannelConfig;
import io.netty.channel.ChannelException;
import io.netty.channel.ChannelMetadata;
import io.netty.channel.ChannelOutboundBuffer;
import io.netty.channel.oio.AbstractOioMessageChannel;
import io.netty.channel.socket.ServerSocketChannel;
import io.netty.channel.socket.ServerSocketChannelConfig;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.SocketUtils;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketTimeoutException;
import java.util.List;

@Deprecated
public class OioServerSocketChannel extends AbstractOioMessageChannel implements ServerSocketChannel {
    private static final ChannelMetadata METADATA;
    private final OioServerSocketChannelConfig config;
    private static final InternalLogger logger;
    final ServerSocket socket;

    static {
        OioServerSocketChannel.logger = InternalLoggerFactory.getInstance(OioServerSocketChannel.class);
        OioServerSocketChannel.METADATA = new ChannelMetadata(false, 1);
    }

    public OioServerSocketChannel() {
        this(OioServerSocketChannel.newServerSocket());
    }

    public OioServerSocketChannel(ServerSocket serverSocket0) {
        super(null);
        ObjectUtil.checkNotNull(serverSocket0, "socket");
        try {
            try {
                serverSocket0.setSoTimeout(1000);
                this.socket = serverSocket0;
                this.config = new DefaultOioServerSocketChannelConfig(this, serverSocket0);
                return;
            }
            catch(IOException iOException0) {
            }
            throw new ChannelException("Failed to set the server socket timeout.", iOException0);
        }
        catch(Throwable throwable0) {
            try {
                serverSocket0.close();
            }
            catch(IOException iOException1) {
                if(OioServerSocketChannel.logger.isWarnEnabled()) {
                    OioServerSocketChannel.logger.warn("Failed to close a partially initialized socket.", iOException1);
                }
            }
            throw throwable0;
        }
        this.socket = serverSocket0;
        this.config = new DefaultOioServerSocketChannelConfig(this, serverSocket0);
    }

    public final void clearReadPending0() {
        this.clearReadPending();
    }

    @Override  // io.netty.channel.Channel
    public ChannelConfig config() {
        return this.config();
    }

    @Override  // io.netty.channel.socket.ServerSocketChannel
    public ServerSocketChannelConfig config() {
        return this.config();
    }

    public OioServerSocketChannelConfig config() {
        return this.config;
    }

    @Override  // io.netty.channel.AbstractChannel
    public void doBind(SocketAddress socketAddress0) {
        int v = this.config.getBacklog();
        this.socket.bind(socketAddress0, v);
    }

    @Override  // io.netty.channel.AbstractChannel
    public void doClose() {
        this.socket.close();
    }

    @Override  // io.netty.channel.oio.AbstractOioChannel
    public void doConnect(SocketAddress socketAddress0, SocketAddress socketAddress1) {
        throw new UnsupportedOperationException();
    }

    @Override  // io.netty.channel.AbstractChannel
    public void doDisconnect() {
        throw new UnsupportedOperationException();
    }

    @Override  // io.netty.channel.oio.AbstractOioMessageChannel
    public int doReadMessages(List list0) {
        if(this.socket.isClosed()) {
            return -1;
        }
        try {
            Socket socket0 = this.socket.accept();
            try {
                list0.add(new OioSocketChannel(this, socket0));
                return 1;
            }
            catch(Throwable throwable0) {
                OioServerSocketChannel.logger.warn("Failed to create a new channel from an accepted socket.", throwable0);
                try {
                    socket0.close();
                    return 0;
                }
                catch(Throwable throwable1) {
                    OioServerSocketChannel.logger.warn("Failed to close a socket.", throwable1);
                }
            }
        }
        catch(SocketTimeoutException unused_ex) {
        }
        return 0;
    }

    @Override  // io.netty.channel.AbstractChannel
    public void doWrite(ChannelOutboundBuffer channelOutboundBuffer0) {
        throw new UnsupportedOperationException();
    }

    @Override  // io.netty.channel.AbstractChannel
    public Object filterOutboundMessage(Object object0) {
        throw new UnsupportedOperationException();
    }

    // 去混淆评级： 低(20)
    @Override  // io.netty.channel.Channel
    public boolean isActive() {
        return this.isOpen() && this.socket.isBound();
    }

    @Override  // io.netty.channel.Channel
    public boolean isOpen() {
        return !this.socket.isClosed();
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
        return SocketUtils.localSocketAddress(this.socket);
    }

    @Override  // io.netty.channel.Channel
    public ChannelMetadata metadata() {
        return OioServerSocketChannel.METADATA;
    }

    private static ServerSocket newServerSocket() {
        try {
            return new ServerSocket();
        }
        catch(IOException iOException0) {
            throw new ChannelException("failed to create a server socket", iOException0);
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

    @Override  // io.netty.channel.oio.AbstractOioChannel
    @Deprecated
    public void setReadPending(boolean z) {
        super.setReadPending(z);
    }
}

