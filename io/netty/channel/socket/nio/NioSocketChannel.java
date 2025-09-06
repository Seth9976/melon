package io.netty.channel.socket.nio;

import io.netty.buffer.ByteBuf;
import io.netty.channel.AbstractChannel.AbstractUnsafe;
import io.netty.channel.Channel;
import io.netty.channel.ChannelConfig;
import io.netty.channel.ChannelException;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelOutboundBuffer;
import io.netty.channel.ChannelPromise;
import io.netty.channel.FileRegion;
import io.netty.channel.RecvByteBufAllocator.Handle;
import io.netty.channel.nio.AbstractNioByteChannel.NioByteUnsafe;
import io.netty.channel.nio.AbstractNioByteChannel;
import io.netty.channel.nio.AbstractNioChannel.AbstractNioUnsafe;
import io.netty.channel.nio.NioEventLoop;
import io.netty.channel.socket.DefaultSocketChannelConfig;
import io.netty.channel.socket.InternetProtocolFamily;
import io.netty.channel.socket.ServerSocketChannel;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.SocketChannelConfig;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GlobalEventExecutor;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.SocketUtils;
import io.netty.util.internal.SuppressJava6Requirement;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectableChannel;
import java.nio.channels.spi.SelectorProvider;
import java.util.Map;
import java.util.concurrent.Executor;

public class NioSocketChannel extends AbstractNioByteChannel implements SocketChannel {
    final class NioSocketChannelConfig extends DefaultSocketChannelConfig {
        private volatile int maxBytesPerGatheringWrite;

        private NioSocketChannelConfig(NioSocketChannel nioSocketChannel1, Socket socket0) {
            super(nioSocketChannel1, socket0);
            this.maxBytesPerGatheringWrite = 0x7FFFFFFF;
            this.calculateMaxBytesPerGatheringWrite();
        }

        public NioSocketChannelConfig(NioSocketChannel nioSocketChannel1, Socket socket0, io.netty.channel.socket.nio.NioSocketChannel.1 nioSocketChannel$10) {
            this(nioSocketChannel1, socket0);
        }

        @Override  // io.netty.channel.DefaultChannelConfig
        public void autoReadCleared() {
            NioSocketChannel.this.clearReadPending();
        }

        private void calculateMaxBytesPerGatheringWrite() {
            int v = this.getSendBufferSize();
            if(v << 1 > 0) {
                this.setMaxBytesPerGatheringWrite(v << 1);
            }
        }

        public int getMaxBytesPerGatheringWrite() {
            return this.maxBytesPerGatheringWrite;
        }

        // 去混淆评级： 低(30)
        @Override  // io.netty.channel.socket.DefaultSocketChannelConfig
        public Object getOption(ChannelOption channelOption0) {
            return super.getOption(channelOption0);
        }

        // 去混淆评级： 低(20)
        @Override  // io.netty.channel.socket.DefaultSocketChannelConfig
        public Map getOptions() {
            return super.getOptions();
        }

        private java.nio.channels.SocketChannel jdkChannel() {
            return ((NioSocketChannel)this.channel).javaChannel();
        }

        public void setMaxBytesPerGatheringWrite(int v) {
            this.maxBytesPerGatheringWrite = v;
        }

        // 去混淆评级： 低(30)
        @Override  // io.netty.channel.socket.DefaultSocketChannelConfig
        public boolean setOption(ChannelOption channelOption0, Object object0) {
            return super.setOption(channelOption0, object0);
        }

        @Override  // io.netty.channel.socket.DefaultSocketChannelConfig
        public SocketChannelConfig setSendBufferSize(int v) {
            return this.setSendBufferSize(v);
        }

        public NioSocketChannelConfig setSendBufferSize(int v) {
            super.setSendBufferSize(v);
            this.calculateMaxBytesPerGatheringWrite();
            return this;
        }
    }

    final class NioSocketChannelUnsafe extends NioByteUnsafe {
        private NioSocketChannelUnsafe() {
        }

        public NioSocketChannelUnsafe(io.netty.channel.socket.nio.NioSocketChannel.1 nioSocketChannel$10) {
        }

        @Override  // io.netty.channel.AbstractChannel$AbstractUnsafe
        public Executor prepareToClose() {
            try {
                if(NioSocketChannel.this.javaChannel().isOpen() && NioSocketChannel.this.config().getSoLinger() > 0) {
                    NioSocketChannel.this.doDeregister();
                    return GlobalEventExecutor.INSTANCE;
                }
            }
            catch(Throwable unused_ex) {
            }
            return null;
        }
    }

    private static final SelectorProvider DEFAULT_SELECTOR_PROVIDER;
    private static final Method OPEN_SOCKET_CHANNEL_WITH_FAMILY;
    private final SocketChannelConfig config;
    private static final InternalLogger logger;

    static {
        NioSocketChannel.logger = InternalLoggerFactory.getInstance(NioSocketChannel.class);
        NioSocketChannel.DEFAULT_SELECTOR_PROVIDER = SelectorProvider.provider();
        NioSocketChannel.OPEN_SOCKET_CHANNEL_WITH_FAMILY = SelectorProviderUtil.findOpenMethod("openSocketChannel");
    }

    public NioSocketChannel() {
        this(NioSocketChannel.DEFAULT_SELECTOR_PROVIDER);
    }

    public NioSocketChannel(Channel channel0, java.nio.channels.SocketChannel socketChannel0) {
        super(channel0, socketChannel0);
        this.config = new NioSocketChannelConfig(this, this, socketChannel0.socket(), null);
    }

    public NioSocketChannel(java.nio.channels.SocketChannel socketChannel0) {
        this(null, socketChannel0);
    }

    public NioSocketChannel(SelectorProvider selectorProvider0) {
        this(selectorProvider0, null);
    }

    public NioSocketChannel(SelectorProvider selectorProvider0, InternetProtocolFamily internetProtocolFamily0) {
        this(NioSocketChannel.newChannel(selectorProvider0, internetProtocolFamily0));
    }

    private void adjustMaxBytesPerGatheringWrite(int v, int v1, int v2) {
        if(v == v1) {
            if(v << 1 > v2) {
                ((NioSocketChannelConfig)this.config).setMaxBytesPerGatheringWrite(v << 1);
            }
        }
        else if(v > 0x1000 && v1 < v >>> 1) {
            ((NioSocketChannelConfig)this.config).setMaxBytesPerGatheringWrite(v >>> 1);
        }
    }

    @Override  // io.netty.channel.Channel
    public ChannelConfig config() {
        return this.config();
    }

    @Override  // io.netty.channel.socket.SocketChannel
    public SocketChannelConfig config() {
        return this.config;
    }

    @Override  // io.netty.channel.AbstractChannel
    public void doBind(SocketAddress socketAddress0) {
        this.doBind0(socketAddress0);
    }

    private void doBind0(SocketAddress socketAddress0) {
        SocketUtils.bind(this.javaChannel().socket(), socketAddress0);
    }

    @Override  // io.netty.channel.nio.AbstractNioChannel
    public void doClose() {
        super.doClose();
        this.javaChannel().close();
    }

    @Override  // io.netty.channel.nio.AbstractNioChannel
    public boolean doConnect(SocketAddress socketAddress0, SocketAddress socketAddress1) {
        if(socketAddress1 != null) {
            this.doBind0(socketAddress1);
        }
        try {
            if(!SocketUtils.connect(this.javaChannel(), socketAddress0)) {
                this.selectionKey().interestOps(8);
                return false;
            }
            return true;
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

    @Override  // io.netty.channel.nio.AbstractNioChannel
    public void doFinishConnect() {
        if(!this.javaChannel().finishConnect()) {
            throw new Error();
        }
    }

    @Override  // io.netty.channel.nio.AbstractNioByteChannel
    public int doReadBytes(ByteBuf byteBuf0) {
        Handle recvByteBufAllocator$Handle0 = this.unsafe().recvBufAllocHandle();
        recvByteBufAllocator$Handle0.attemptedBytesRead(byteBuf0.writableBytes());
        return byteBuf0.writeBytes(this.javaChannel(), recvByteBufAllocator$Handle0.attemptedBytesRead());
    }

    @Override  // io.netty.channel.AbstractChannel
    @SuppressJava6Requirement(reason = "Usage guarded by java version check")
    public final void doShutdownOutput() {
        if(PlatformDependent.javaVersion() >= 7) {
            this.javaChannel().shutdownOutput();
            return;
        }
        this.javaChannel().socket().shutdownOutput();
    }

    @Override  // io.netty.channel.nio.AbstractNioByteChannel
    public void doWrite(ChannelOutboundBuffer channelOutboundBuffer0) {
        boolean z;
        java.nio.channels.SocketChannel socketChannel0 = this.javaChannel();
        int v = this.config().getWriteSpinCount();
        do {
            if(channelOutboundBuffer0.isEmpty()) {
                this.clearOpWrite();
                return;
            }
            int v1 = ((NioSocketChannelConfig)this.config).getMaxBytesPerGatheringWrite();
            ByteBuffer[] arr_byteBuffer = channelOutboundBuffer0.nioBuffers(0x400, ((long)v1));
            int v2 = channelOutboundBuffer0.nioBufferCount();
            z = false;
            switch(v2) {
                case 0: {
                    v -= this.doWrite0(channelOutboundBuffer0);
                    break;
                }
                case 1: {
                    ByteBuffer byteBuffer0 = arr_byteBuffer[0];
                    int v5 = byteBuffer0.remaining();
                    int v6 = socketChannel0.write(byteBuffer0);
                    if(v6 <= 0) {
                        this.incompleteWrite(true);
                        return;
                    }
                    this.adjustMaxBytesPerGatheringWrite(v5, v6, v1);
                    channelOutboundBuffer0.removeBytes(((long)v6));
                    --v;
                    break;
                }
                default: {
                    long v3 = channelOutboundBuffer0.nioBufferSize();
                    long v4 = socketChannel0.write(arr_byteBuffer, 0, v2);
                    if(v4 <= 0L) {
                        this.incompleteWrite(true);
                        return;
                    }
                    this.adjustMaxBytesPerGatheringWrite(((int)v3), ((int)v4), v1);
                    channelOutboundBuffer0.removeBytes(v4);
                    --v;
                }
            }
        }
        while(v > 0);
        if(v < 0) {
            z = true;
        }
        this.incompleteWrite(z);
    }

    @Override  // io.netty.channel.nio.AbstractNioByteChannel
    public int doWriteBytes(ByteBuf byteBuf0) {
        int v = byteBuf0.readableBytes();
        return byteBuf0.readBytes(this.javaChannel(), v);
    }

    @Override  // io.netty.channel.nio.AbstractNioByteChannel
    public long doWriteFileRegion(FileRegion fileRegion0) {
        long v = fileRegion0.transferred();
        return fileRegion0.transferTo(this.javaChannel(), v);
    }

    @Override  // io.netty.channel.Channel
    public boolean isActive() {
        java.nio.channels.SocketChannel socketChannel0 = this.javaChannel();
        return socketChannel0.isOpen() && socketChannel0.isConnected();
    }

    // 去混淆评级： 低(20)
    @Override  // io.netty.channel.socket.DuplexChannel
    public boolean isInputShutdown() {
        return this.javaChannel().socket().isInputShutdown() || !this.isActive();
    }

    @Override  // io.netty.channel.nio.AbstractNioByteChannel
    public boolean isInputShutdown0() {
        return this.isInputShutdown();
    }

    // 去混淆评级： 低(20)
    @Override  // io.netty.channel.socket.DuplexChannel
    public boolean isOutputShutdown() {
        return this.javaChannel().socket().isOutputShutdown() || !this.isActive();
    }

    @Override  // io.netty.channel.socket.DuplexChannel
    public boolean isShutdown() {
        Socket socket0 = this.javaChannel().socket();
        return socket0.isInputShutdown() && socket0.isOutputShutdown() || !this.isActive();
    }

    @Override  // io.netty.channel.nio.AbstractNioChannel
    public SelectableChannel javaChannel() {
        return this.javaChannel();
    }

    public java.nio.channels.SocketChannel javaChannel() {
        return (java.nio.channels.SocketChannel)super.javaChannel();
    }

    @Override  // io.netty.channel.socket.SocketChannel
    public InetSocketAddress localAddress() {
        return (InetSocketAddress)super.localAddress();
    }

    @Override  // io.netty.channel.AbstractChannel, io.netty.channel.Channel
    public SocketAddress localAddress() {
        return this.localAddress();
    }

    @Override  // io.netty.channel.AbstractChannel
    public SocketAddress localAddress0() {
        return this.javaChannel().socket().getLocalSocketAddress();
    }

    private static java.nio.channels.SocketChannel newChannel(SelectorProvider selectorProvider0, InternetProtocolFamily internetProtocolFamily0) {
        try {
            java.nio.channels.SocketChannel socketChannel0 = (java.nio.channels.SocketChannel)SelectorProviderUtil.newChannel(NioSocketChannel.OPEN_SOCKET_CHANNEL_WITH_FAMILY, selectorProvider0, internetProtocolFamily0);
            return socketChannel0 == null ? selectorProvider0.openSocketChannel() : socketChannel0;
        }
        catch(IOException iOException0) {
            throw new ChannelException("Failed to open a socket.", iOException0);
        }
    }

    @Override  // io.netty.channel.nio.AbstractNioByteChannel
    public AbstractUnsafe newUnsafe() {
        return this.newUnsafe();
    }

    @Override  // io.netty.channel.nio.AbstractNioByteChannel
    public AbstractNioUnsafe newUnsafe() {
        return new NioSocketChannelUnsafe(this, null);
    }

    @Override  // io.netty.channel.AbstractChannel, io.netty.channel.Channel
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

    @Override  // io.netty.channel.AbstractChannel, io.netty.channel.Channel
    public SocketAddress remoteAddress() {
        return this.remoteAddress();
    }

    @Override  // io.netty.channel.AbstractChannel
    public SocketAddress remoteAddress0() {
        return this.javaChannel().socket().getRemoteSocketAddress();
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
                NioSocketChannel.this.shutdownOutputDone(channelFuture0, channelPromise0);
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
                NioSocketChannel.logger.debug("Exception suppressed because a previous exception occurred.", throwable1);
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

    @Override  // io.netty.channel.nio.AbstractNioByteChannel, io.netty.channel.socket.DuplexChannel
    public ChannelFuture shutdownInput() {
        return this.shutdownInput(this.newPromise());
    }

    @Override  // io.netty.channel.socket.DuplexChannel
    public ChannelFuture shutdownInput(ChannelPromise channelPromise0) {
        NioEventLoop nioEventLoop0 = this.eventLoop();
        if(nioEventLoop0.inEventLoop()) {
            this.shutdownInput0(channelPromise0);
            return channelPromise0;
        }
        nioEventLoop0.execute(() -> try {
            NioSocketChannel.this.shutdownInput0();
            this.val$promise.setSuccess();
        }
        catch(Throwable throwable0) {
            this.val$promise.setFailure(throwable0);
        });
        return channelPromise0;

        class io.netty.channel.socket.nio.NioSocketChannel.2 implements Runnable {
            public io.netty.channel.socket.nio.NioSocketChannel.2(ChannelPromise channelPromise0) {
            }

            @Override
            public void run() {
                NioSocketChannel.this.shutdownInput0(this.val$promise);
            }
        }

    }

    @SuppressJava6Requirement(reason = "Usage guarded by java version check")
    private void shutdownInput0() {
        if(PlatformDependent.javaVersion() >= 7) {
            this.javaChannel().shutdownInput();
            return;
        }
        this.javaChannel().socket().shutdownInput();
    }

    // 检测为 Lambda 实现
    private void shutdownInput0(ChannelPromise channelPromise0) [...]

    @Override  // io.netty.channel.socket.DuplexChannel
    public ChannelFuture shutdownOutput() {
        return this.shutdownOutput(this.newPromise());
    }

    @Override  // io.netty.channel.socket.DuplexChannel
    public ChannelFuture shutdownOutput(ChannelPromise channelPromise0) {
        NioEventLoop nioEventLoop0 = this.eventLoop();
        if(nioEventLoop0.inEventLoop()) {
            ((AbstractUnsafe)this.unsafe()).shutdownOutput(channelPromise0);
            return channelPromise0;
        }
        nioEventLoop0.execute(new Runnable() {
            @Override
            public void run() {
                ((AbstractUnsafe)NioSocketChannel.this.unsafe()).shutdownOutput(channelPromise0);
            }
        });
        return channelPromise0;
    }

    private void shutdownOutputDone(ChannelFuture channelFuture0, ChannelPromise channelPromise0) {
        ChannelFuture channelFuture1 = this.shutdownInput();
        if(channelFuture1.isDone()) {
            NioSocketChannel.shutdownDone(channelFuture0, channelFuture1, channelPromise0);
            return;
        }
        channelFuture1.addListener(new ChannelFutureListener() {
            public void operationComplete(ChannelFuture channelFuture0) {
                NioSocketChannel.shutdownDone(channelFuture0, channelFuture0, channelPromise0);
            }

            @Override  // io.netty.util.concurrent.GenericFutureListener
            public void operationComplete(Future future0) {
                this.operationComplete(((ChannelFuture)future0));
            }
        });
    }
}

