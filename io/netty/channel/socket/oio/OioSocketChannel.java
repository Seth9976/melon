package io.netty.channel.socket.oio;

import io.netty.buffer.ByteBuf;
import io.netty.channel.Channel;
import io.netty.channel.ChannelConfig;
import io.netty.channel.ChannelException;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelPromise;
import io.netty.channel.ConnectTimeoutException;
import io.netty.channel.EventLoop;
import io.netty.channel.oio.OioByteStreamChannel;
import io.netty.channel.socket.ServerSocketChannel;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.SocketChannelConfig;
import io.netty.util.concurrent.Future;
import io.netty.util.internal.SocketUtils;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketTimeoutException;

@Deprecated
public class OioSocketChannel extends OioByteStreamChannel implements SocketChannel {
    private final OioSocketChannelConfig config;
    private static final InternalLogger logger;
    private final Socket socket;

    static {
        OioSocketChannel.logger = InternalLoggerFactory.getInstance(OioSocketChannel.class);
    }

    public OioSocketChannel() {
        this(new Socket());
    }

    public OioSocketChannel(Channel channel0, Socket socket0) {
        super(channel0);
        this.socket = socket0;
        this.config = new DefaultOioSocketChannelConfig(this, socket0);
        try {
            try {
                if(socket0.isConnected()) {
                    this.activate(socket0.getInputStream(), socket0.getOutputStream());
                }
                socket0.setSoTimeout(1000);
                return;
            }
            catch(Exception exception0) {
            }
            throw new ChannelException("failed to initialize a socket", exception0);
        }
        catch(Throwable throwable0) {
        }
        try {
            socket0.close();
        }
        catch(IOException iOException0) {
            OioSocketChannel.logger.warn("Failed to close a socket.", iOException0);
        }
        throw throwable0;
    }

    public OioSocketChannel(Socket socket0) {
        this(null, socket0);
    }

    public boolean checkInputShutdown() {
        if(this.isInputShutdown()) {
            try {
                Thread.sleep(this.config().getSoTimeout());
            }
            catch(Throwable unused_ex) {
            }
            return true;
        }
        return false;
    }

    public final void clearReadPending0() {
        this.clearReadPending();
    }

    @Override  // io.netty.channel.Channel
    public ChannelConfig config() {
        return this.config();
    }

    @Override  // io.netty.channel.socket.SocketChannel
    public SocketChannelConfig config() {
        return this.config();
    }

    public OioSocketChannelConfig config() {
        return this.config;
    }

    @Override  // io.netty.channel.AbstractChannel
    public void doBind(SocketAddress socketAddress0) {
        SocketUtils.bind(this.socket, socketAddress0);
    }

    @Override  // io.netty.channel.oio.OioByteStreamChannel
    public void doClose() {
        this.socket.close();
    }

    @Override  // io.netty.channel.oio.AbstractOioChannel
    public void doConnect(SocketAddress socketAddress0, SocketAddress socketAddress1) {
        if(socketAddress1 != null) {
            SocketUtils.bind(this.socket, socketAddress1);
        }
        int v = this.config().getConnectTimeoutMillis();
        try {
            try {
                SocketUtils.connect(this.socket, socketAddress0, v);
                this.activate(this.socket.getInputStream(), this.socket.getOutputStream());
            }
            catch(SocketTimeoutException socketTimeoutException0) {
                ConnectTimeoutException connectTimeoutException0 = new ConnectTimeoutException("connection timed out after " + v + " ms: " + socketAddress0);
                connectTimeoutException0.setStackTrace(socketTimeoutException0.getStackTrace());
                throw connectTimeoutException0;
            }
        }
        catch(Throwable throwable0) {
            this.doClose();
            throw throwable0;
        }
    }

    @Override  // io.netty.channel.AbstractChannel
    public void doDisconnect() {
        this.doClose();
    }

    @Override  // io.netty.channel.oio.OioByteStreamChannel
    public int doReadBytes(ByteBuf byteBuf0) {
        if(this.socket.isClosed()) {
            return -1;
        }
        try {
            return super.doReadBytes(byteBuf0);
        }
        catch(SocketTimeoutException unused_ex) {
            return 0;
        }
    }

    @Override  // io.netty.channel.AbstractChannel
    public final void doShutdownOutput() {
        this.shutdownOutput0();
    }

    // 去混淆评级： 低(20)
    @Override  // io.netty.channel.oio.OioByteStreamChannel, io.netty.channel.Channel
    public boolean isActive() {
        return !this.socket.isClosed() && this.socket.isConnected();
    }

    // 去混淆评级： 低(20)
    @Override  // io.netty.channel.oio.AbstractOioByteChannel, io.netty.channel.socket.DuplexChannel
    public boolean isInputShutdown() {
        return this.socket.isInputShutdown() || !this.isActive();
    }

    @Override  // io.netty.channel.Channel
    public boolean isOpen() {
        return !this.socket.isClosed();
    }

    // 去混淆评级： 低(20)
    @Override  // io.netty.channel.socket.DuplexChannel
    public boolean isOutputShutdown() {
        return this.socket.isOutputShutdown() || !this.isActive();
    }

    // 去混淆评级： 低(30)
    @Override  // io.netty.channel.socket.DuplexChannel
    public boolean isShutdown() {
        return this.socket.isInputShutdown() && this.socket.isOutputShutdown() || !this.isActive();
    }

    @Override  // io.netty.channel.socket.SocketChannel
    public InetSocketAddress localAddress() {
        return (InetSocketAddress)super.localAddress();
    }

    @Override  // io.netty.channel.Channel, io.netty.channel.AbstractChannel
    public SocketAddress localAddress() {
        return this.localAddress();
    }

    @Override  // io.netty.channel.AbstractChannel
    public SocketAddress localAddress0() {
        return this.socket.getLocalSocketAddress();
    }

    @Override  // io.netty.channel.Channel, io.netty.channel.AbstractChannel
    public Channel parent() {
        return this.parent();
    }

    @Override  // io.netty.channel.socket.SocketChannel
    public ServerSocketChannel parent() {
        return (ServerSocketChannel)super.parent();
    }

    @Override  // io.netty.channel.socket.SocketChannel
    public InetSocketAddress remoteAddress() {
        return (InetSocketAddress)super.remoteAddress();
    }

    @Override  // io.netty.channel.Channel, io.netty.channel.AbstractChannel
    public SocketAddress remoteAddress() {
        return this.remoteAddress();
    }

    @Override  // io.netty.channel.AbstractChannel
    public SocketAddress remoteAddress0() {
        return this.socket.getRemoteSocketAddress();
    }

    @Override  // io.netty.channel.oio.AbstractOioChannel
    @Deprecated
    public void setReadPending(boolean z) {
        super.setReadPending(z);
    }

    @Override  // io.netty.channel.socket.DuplexChannel
    public ChannelFuture shutdown() {
        return this.shutdown(this.newPromise());
    }

    @Override  // io.netty.channel.socket.DuplexChannel
    public ChannelFuture shutdown(ChannelPromise channelPromise0) {
        ChannelFuture channelFuture0 = this.shutdownOutput();
        if(channelFuture0.isDone()) {
            this.shutdownOutputDone(channelFuture0, channelPromise0);
            return channelPromise0;
        }
        channelFuture0.addListener(new ChannelFutureListener() {
            public void operationComplete(ChannelFuture channelFuture0) {
                OioSocketChannel.this.shutdownOutputDone(channelFuture0, channelPromise0);
            }

            @Override  // io.netty.util.concurrent.GenericFutureListener
            public void operationComplete(Future future0) {
                this.operationComplete(((ChannelFuture)future0));
            }
        });
        return channelPromise0;
    }

    private static void shutdownDone(ChannelFuture channelFuture0, ChannelFuture channelFuture1, ChannelPromise channelPromise0) {
        Throwable throwable0 = channelFuture0.cause();
        Throwable throwable1 = channelFuture1.cause();
        if(throwable0 != null) {
            if(throwable1 != null) {
                OioSocketChannel.logger.debug("Exception suppressed because a previous exception occurred.", throwable1);
            }
            channelPromise0.setFailure(throwable0);
            return;
        }
        if(throwable1 != null) {
            channelPromise0.setFailure(throwable1);
            return;
        }
        channelPromise0.setSuccess();
    }

    @Override  // io.netty.channel.oio.AbstractOioByteChannel, io.netty.channel.socket.DuplexChannel
    public ChannelFuture shutdownInput() {
        return this.shutdownInput(this.newPromise());
    }

    @Override  // io.netty.channel.socket.DuplexChannel
    public ChannelFuture shutdownInput(ChannelPromise channelPromise0) {
        EventLoop eventLoop0 = this.eventLoop();
        if(eventLoop0.inEventLoop()) {
            this.shutdownInput0(channelPromise0);
            return channelPromise0;
        }
        eventLoop0.execute(() -> try {
            OioSocketChannel.this.socket.shutdownInput();
            this.val$promise.setSuccess();
        }
        catch(Throwable throwable0) {
            this.val$promise.setFailure(throwable0);
        });
        return channelPromise0;

        class io.netty.channel.socket.oio.OioSocketChannel.2 implements Runnable {
            public io.netty.channel.socket.oio.OioSocketChannel.2(ChannelPromise channelPromise0) {
            }

            @Override
            public void run() {
                OioSocketChannel.this.shutdownInput0(this.val$promise);
            }
        }

    }

    // 检测为 Lambda 实现
    private void shutdownInput0(ChannelPromise channelPromise0) [...]

    @Override  // io.netty.channel.socket.DuplexChannel
    public ChannelFuture shutdownOutput() {
        return this.shutdownOutput(this.newPromise());
    }

    @Override  // io.netty.channel.socket.DuplexChannel
    public ChannelFuture shutdownOutput(ChannelPromise channelPromise0) {
        EventLoop eventLoop0 = this.eventLoop();
        if(eventLoop0.inEventLoop()) {
            this.shutdownOutput0(channelPromise0);
            return channelPromise0;
        }
        eventLoop0.execute(() -> try {
            OioSocketChannel.this.shutdownOutput0();
            this.val$promise.setSuccess();
        }
        catch(Throwable throwable0) {
            this.val$promise.setFailure(throwable0);
        });
        return channelPromise0;

        class io.netty.channel.socket.oio.OioSocketChannel.1 implements Runnable {
            public io.netty.channel.socket.oio.OioSocketChannel.1(ChannelPromise channelPromise0) {
            }

            @Override
            public void run() {
                OioSocketChannel.this.shutdownOutput0(this.val$promise);
            }
        }

    }

    private void shutdownOutput0() {
        this.socket.shutdownOutput();
    }

    // 检测为 Lambda 实现
    private void shutdownOutput0(ChannelPromise channelPromise0) [...]

    private void shutdownOutputDone(ChannelFuture channelFuture0, ChannelPromise channelPromise0) {
        ChannelFuture channelFuture1 = this.shutdownInput();
        if(channelFuture1.isDone()) {
            OioSocketChannel.shutdownDone(channelFuture0, channelFuture1, channelPromise0);
            return;
        }
        channelFuture1.addListener(new ChannelFutureListener() {
            public void operationComplete(ChannelFuture channelFuture0) {
                OioSocketChannel.shutdownDone(channelFuture0, channelFuture0, channelPromise0);
            }

            @Override  // io.netty.util.concurrent.GenericFutureListener
            public void operationComplete(Future future0) {
                this.operationComplete(((ChannelFuture)future0));
            }
        });
    }
}

