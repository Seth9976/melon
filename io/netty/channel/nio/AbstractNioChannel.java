package io.netty.channel.nio;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.ByteBufUtil;
import io.netty.buffer.Unpooled;
import io.netty.channel.AbstractChannel.AbstractUnsafe;
import io.netty.channel.AbstractChannel;
import io.netty.channel.Channel.Unsafe;
import io.netty.channel.Channel;
import io.netty.channel.ChannelException;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelPromise;
import io.netty.channel.ConnectTimeoutException;
import io.netty.channel.EventLoop;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.ReferenceCounted;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.ScheduledFuture;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.io.IOException;
import java.net.SocketAddress;
import java.nio.channels.CancelledKeyException;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.ConnectionPendingException;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.util.concurrent.TimeUnit;

public abstract class AbstractNioChannel extends AbstractChannel {
    public abstract class AbstractNioUnsafe extends AbstractUnsafe implements NioUnsafe {
        static final boolean $assertionsDisabled;

        @Override  // io.netty.channel.nio.AbstractNioChannel$NioUnsafe
        public final SelectableChannel ch() {
            return AbstractNioChannel.this.javaChannel();
        }

        @Override  // io.netty.channel.Channel$Unsafe
        public final void connect(SocketAddress socketAddress0, SocketAddress socketAddress1, ChannelPromise channelPromise0) {
            if(channelPromise0.setUncancellable() && this.ensureOpen(channelPromise0)) {
                try {
                    if(AbstractNioChannel.this.connectPromise != null) {
                        throw new ConnectionPendingException();
                    }
                    boolean z = AbstractNioChannel.this.isActive();
                    if(AbstractNioChannel.this.doConnect(socketAddress0, socketAddress1)) {
                        this.fulfillConnectPromise(channelPromise0, z);
                        return;
                    }
                    AbstractNioChannel.this.connectPromise = channelPromise0;
                    AbstractNioChannel.this.requestedRemoteAddress = socketAddress0;
                    int v = AbstractNioChannel.this.config().getConnectTimeoutMillis();
                    if(v > 0) {
                        ScheduledFuture scheduledFuture0 = AbstractNioChannel.this.eventLoop().schedule(new Runnable() {
                            @Override
                            public void run() {
                                ChannelPromise channelPromise0 = AbstractNioChannel.this.connectPromise;
                                if(channelPromise0 != null && !channelPromise0.isDone() && channelPromise0.tryFailure(new ConnectTimeoutException("connection timed out after " + v + " ms: " + socketAddress0))) {
                                    ChannelPromise channelPromise1 = AbstractNioUnsafe.this.voidPromise();
                                    AbstractNioUnsafe.this.close(channelPromise1);
                                }
                            }
                        }, ((long)v), TimeUnit.MILLISECONDS);
                        AbstractNioChannel.this.connectTimeoutFuture = scheduledFuture0;
                    }
                    channelPromise0.addListener(new ChannelFutureListener() {
                        public void operationComplete(ChannelFuture channelFuture0) {
                            if(channelFuture0.isCancelled()) {
                                if(AbstractNioChannel.this.connectTimeoutFuture != null) {
                                    AbstractNioChannel.this.connectTimeoutFuture.cancel(false);
                                }
                                AbstractNioChannel.this.connectPromise = null;
                                ChannelPromise channelPromise0 = AbstractNioUnsafe.this.voidPromise();
                                AbstractNioUnsafe.this.close(channelPromise0);
                            }
                        }

                        @Override  // io.netty.util.concurrent.GenericFutureListener
                        public void operationComplete(Future future0) {
                            this.operationComplete(((ChannelFuture)future0));
                        }
                    });
                    return;
                }
                catch(Throwable throwable0) {
                }
                channelPromise0.tryFailure(this.annotateConnectException(throwable0, socketAddress0));
                this.closeIfClosed();
            }
        }

        @Override  // io.netty.channel.nio.AbstractNioChannel$NioUnsafe
        public final void finishConnect() {
            try {
                boolean z = AbstractNioChannel.this.isActive();
                AbstractNioChannel.this.doFinishConnect();
                this.fulfillConnectPromise(AbstractNioChannel.this.connectPromise, z);
            }
            catch(Throwable throwable0) {
                try {
                    Throwable throwable2 = this.annotateConnectException(throwable0, AbstractNioChannel.this.requestedRemoteAddress);
                    this.fulfillConnectPromise(AbstractNioChannel.this.connectPromise, throwable2);
                }
                catch(Throwable throwable1) {
                    if(AbstractNioChannel.this.connectTimeoutFuture != null) {
                        AbstractNioChannel.this.connectTimeoutFuture.cancel(false);
                    }
                    AbstractNioChannel.this.connectPromise = null;
                    throw throwable1;
                }
                if(AbstractNioChannel.this.connectTimeoutFuture != null) {
                    AbstractNioChannel.this.connectTimeoutFuture.cancel(false);
                }
                AbstractNioChannel.this.connectPromise = null;
                return;
            }
            if(AbstractNioChannel.this.connectTimeoutFuture != null) {
                AbstractNioChannel.this.connectTimeoutFuture.cancel(false);
            }
            AbstractNioChannel.this.connectPromise = null;
        }

        @Override  // io.netty.channel.AbstractChannel$AbstractUnsafe
        public final void flush0() {
            if(!this.isFlushPending()) {
                super.flush0();
            }
        }

        @Override  // io.netty.channel.nio.AbstractNioChannel$NioUnsafe
        public final void forceFlush() {
            super.flush0();
        }

        private void fulfillConnectPromise(ChannelPromise channelPromise0, Throwable throwable0) {
            if(channelPromise0 == null) {
                return;
            }
            channelPromise0.tryFailure(throwable0);
            this.closeIfClosed();
        }

        private void fulfillConnectPromise(ChannelPromise channelPromise0, boolean z) {
            if(channelPromise0 != null) {
                boolean z1 = AbstractNioChannel.this.isActive();
                boolean z2 = channelPromise0.trySuccess();
                if(!z && z1) {
                    AbstractNioChannel.this.pipeline().fireChannelActive();
                }
                if(!z2) {
                    this.close(this.voidPromise());
                }
            }
        }

        private boolean isFlushPending() {
            SelectionKey selectionKey0 = AbstractNioChannel.this.selectionKey();
            return selectionKey0.isValid() && (selectionKey0.interestOps() & 4) != 0;
        }

        public final void removeReadOp() {
            SelectionKey selectionKey0 = AbstractNioChannel.this.selectionKey();
            if(selectionKey0.isValid()) {
                int v = selectionKey0.interestOps();
                int v1 = AbstractNioChannel.this.readInterestOp;
                if((v & v1) != 0) {
                    selectionKey0.interestOps(v & ~v1);
                }
            }
        }
    }

    public interface NioUnsafe extends Unsafe {
        SelectableChannel ch();

        void finishConnect();

        void forceFlush();

        void read();
    }

    static final boolean $assertionsDisabled;
    private final SelectableChannel ch;
    private final Runnable clearReadPendingRunnable;
    private ChannelPromise connectPromise;
    private Future connectTimeoutFuture;
    private static final InternalLogger logger;
    protected final int readInterestOp;
    boolean readPending;
    private SocketAddress requestedRemoteAddress;
    volatile SelectionKey selectionKey;

    static {
        AbstractNioChannel.logger = InternalLoggerFactory.getInstance(AbstractNioChannel.class);
    }

    public AbstractNioChannel(Channel channel0, SelectableChannel selectableChannel0, int v) {
        super(channel0);
        this.clearReadPendingRunnable = () -> {
            AbstractNioChannel.this.readPending = false;
            ((AbstractNioUnsafe)AbstractNioChannel.this.unsafe()).removeReadOp();
        };
        this.ch = selectableChannel0;
        this.readInterestOp = v;
        try {
            selectableChannel0.configureBlocking(false);
        }
        catch(IOException iOException0) {
            try {
                selectableChannel0.close();
            }
            catch(IOException iOException1) {
                AbstractNioChannel.logger.warn("Failed to close a partially initialized socket.", iOException1);
            }
            throw new ChannelException("Failed to enter non-blocking mode.", iOException0);
        }
    }

    public final void clearReadPending() {
        if(this.isRegistered()) {
            NioEventLoop nioEventLoop0 = this.eventLoop();
            if(nioEventLoop0.inEventLoop()) {
                this.clearReadPending0();
                return;
            }
            nioEventLoop0.execute(this.clearReadPendingRunnable);
            return;
        }
        this.readPending = false;
    }

    // 检测为 Lambda 实现
    private void clearReadPending0() [...]

    @Override  // io.netty.channel.AbstractChannel
    public void doBeginRead() {
        SelectionKey selectionKey0 = this.selectionKey;
        if(selectionKey0.isValid()) {
            this.readPending = true;
            int v = selectionKey0.interestOps();
            int v1 = this.readInterestOp;
            if((v & v1) == 0) {
                selectionKey0.interestOps(v | v1);
            }
        }
    }

    @Override  // io.netty.channel.AbstractChannel
    public void doClose() {
        ChannelPromise channelPromise0 = this.connectPromise;
        if(channelPromise0 != null) {
            channelPromise0.tryFailure(new ClosedChannelException());
            this.connectPromise = null;
        }
        Future future0 = this.connectTimeoutFuture;
        if(future0 != null) {
            future0.cancel(false);
            this.connectTimeoutFuture = null;
        }
    }

    public abstract boolean doConnect(SocketAddress arg1, SocketAddress arg2);

    @Override  // io.netty.channel.AbstractChannel
    public void doDeregister() {
        this.eventLoop().cancel(this.selectionKey());
    }

    public abstract void doFinishConnect();

    @Override  // io.netty.channel.AbstractChannel
    public void doRegister() {
        for(boolean z = false; true; z = true) {
            try {
                this.selectionKey = this.javaChannel().register(this.eventLoop().unwrappedSelector(), 0, this);
                return;
            }
            catch(CancelledKeyException cancelledKeyException0) {
            }
            if(z) {
                break;
            }
            this.eventLoop().selectNow();
        }
        throw cancelledKeyException0;
    }

    @Override  // io.netty.channel.AbstractChannel
    public EventLoop eventLoop() {
        return this.eventLoop();
    }

    public NioEventLoop eventLoop() {
        return (NioEventLoop)super.eventLoop();
    }

    @Override  // io.netty.channel.AbstractChannel
    public boolean isCompatible(EventLoop eventLoop0) {
        return eventLoop0 instanceof NioEventLoop;
    }

    @Override  // io.netty.channel.Channel
    public boolean isOpen() {
        return this.ch.isOpen();
    }

    @Deprecated
    public boolean isReadPending() {
        return this.readPending;
    }

    public SelectableChannel javaChannel() {
        return this.ch;
    }

    public final ByteBuf newDirectBuffer(ByteBuf byteBuf0) {
        int v = byteBuf0.readableBytes();
        if(v == 0) {
            ReferenceCountUtil.safeRelease(byteBuf0);
            return Unpooled.EMPTY_BUFFER;
        }
        ByteBufAllocator byteBufAllocator0 = this.alloc();
        if(byteBufAllocator0.isDirectBufferPooled()) {
            ByteBuf byteBuf1 = byteBufAllocator0.directBuffer(v);
            byteBuf1.writeBytes(byteBuf0, byteBuf0.readerIndex(), v);
            ReferenceCountUtil.safeRelease(byteBuf0);
            return byteBuf1;
        }
        ByteBuf byteBuf2 = ByteBufUtil.threadLocalDirectBuffer();
        if(byteBuf2 != null) {
            byteBuf2.writeBytes(byteBuf0, byteBuf0.readerIndex(), v);
            ReferenceCountUtil.safeRelease(byteBuf0);
            return byteBuf2;
        }
        return byteBuf0;
    }

    public final ByteBuf newDirectBuffer(ReferenceCounted referenceCounted0, ByteBuf byteBuf0) {
        int v = byteBuf0.readableBytes();
        if(v == 0) {
            ReferenceCountUtil.safeRelease(referenceCounted0);
            return Unpooled.EMPTY_BUFFER;
        }
        ByteBufAllocator byteBufAllocator0 = this.alloc();
        if(byteBufAllocator0.isDirectBufferPooled()) {
            ByteBuf byteBuf1 = byteBufAllocator0.directBuffer(v);
            byteBuf1.writeBytes(byteBuf0, byteBuf0.readerIndex(), v);
            ReferenceCountUtil.safeRelease(referenceCounted0);
            return byteBuf1;
        }
        ByteBuf byteBuf2 = ByteBufUtil.threadLocalDirectBuffer();
        if(byteBuf2 != null) {
            byteBuf2.writeBytes(byteBuf0, byteBuf0.readerIndex(), v);
            ReferenceCountUtil.safeRelease(referenceCounted0);
            return byteBuf2;
        }
        if(referenceCounted0 != byteBuf0) {
            byteBuf0.retain();
            ReferenceCountUtil.safeRelease(referenceCounted0);
        }
        return byteBuf0;
    }

    public SelectionKey selectionKey() {
        return this.selectionKey;
    }

    @Deprecated
    public void setReadPending(boolean z) {
        if(this.isRegistered()) {
            NioEventLoop nioEventLoop0 = this.eventLoop();
            if(nioEventLoop0.inEventLoop()) {
                this.setReadPending0(z);
                return;
            }
            nioEventLoop0.execute(() -> {
                AbstractNioChannel.this.readPending = this.val$readPending;
                if(!this.val$readPending) {
                    ((AbstractNioUnsafe)AbstractNioChannel.this.unsafe()).removeReadOp();
                }
            });
            return;
        }
        this.readPending = z;

        class io.netty.channel.nio.AbstractNioChannel.2 implements Runnable {
            public io.netty.channel.nio.AbstractNioChannel.2(boolean z) {
            }

            @Override
            public void run() {
                AbstractNioChannel.this.setReadPending0(this.val$readPending);
            }
        }

    }

    // 检测为 Lambda 实现
    private void setReadPending0(boolean z) [...]

    @Override  // io.netty.channel.AbstractChannel
    public Unsafe unsafe() {
        return this.unsafe();
    }

    public NioUnsafe unsafe() {
        return (NioUnsafe)super.unsafe();
    }

    class io.netty.channel.nio.AbstractNioChannel.1 implements Runnable {
        @Override
        public void run() {
            AbstractNioChannel.this.clearReadPending0();
        }
    }

}

