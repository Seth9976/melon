package io.netty.channel.local;

import io.netty.buffer.ByteBuf;
import io.netty.channel.AbstractChannel.AbstractUnsafe;
import io.netty.channel.AbstractChannel;
import io.netty.channel.Channel;
import io.netty.channel.ChannelConfig;
import io.netty.channel.ChannelMetadata;
import io.netty.channel.ChannelOutboundBuffer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.ChannelPromise;
import io.netty.channel.DefaultChannelConfig;
import io.netty.channel.EventLoop;
import io.netty.channel.PreferHeapByteBufAllocator;
import io.netty.channel.RecvByteBufAllocator.Handle;
import io.netty.channel.SingleThreadEventLoop;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.SingleThreadEventExecutor;
import io.netty.util.internal.InternalThreadLocalMap;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.net.ConnectException;
import java.net.SocketAddress;
import java.nio.channels.AlreadyConnectedException;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.ConnectionPendingException;
import java.nio.channels.NotYetConnectedException;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

public class LocalChannel extends AbstractChannel {
    class LocalUnsafe extends AbstractUnsafe {
        private LocalUnsafe() {
        }

        public LocalUnsafe(io.netty.channel.local.LocalChannel.1 localChannel$10) {
        }

        @Override  // io.netty.channel.Channel$Unsafe
        public void connect(SocketAddress socketAddress0, SocketAddress socketAddress1, ChannelPromise channelPromise0) {
            if(channelPromise0.setUncancellable() && this.ensureOpen(channelPromise0)) {
                if(LocalChannel.this.state == State.CONNECTED) {
                    AlreadyConnectedException alreadyConnectedException0 = new AlreadyConnectedException();
                    this.safeSetFailure(channelPromise0, alreadyConnectedException0);
                    LocalChannel.this.pipeline().fireExceptionCaught(alreadyConnectedException0);
                    return;
                }
                if(LocalChannel.this.connectPromise != null) {
                    throw new ConnectionPendingException();
                }
                LocalChannel.this.connectPromise = channelPromise0;
                if(LocalChannel.this.state != State.BOUND && socketAddress1 == null) {
                    socketAddress1 = new LocalAddress(LocalChannel.this);
                }
                if(socketAddress1 != null) {
                    try {
                        LocalChannel.this.doBind(socketAddress1);
                    }
                    catch(Throwable throwable0) {
                        this.safeSetFailure(channelPromise0, throwable0);
                        this.close(this.voidPromise());
                        return;
                    }
                }
                Channel channel0 = LocalChannelRegistry.get(socketAddress0);
                if(!(channel0 instanceof LocalServerChannel)) {
                    this.safeSetFailure(channelPromise0, new ConnectException("connection refused: " + socketAddress0));
                    this.close(this.voidPromise());
                    return;
                }
                LocalChannel localChannel0 = ((LocalServerChannel)channel0).serve(LocalChannel.this);
                LocalChannel.this.peer = localChannel0;
            }
        }
    }

    static enum State {
        OPEN,
        BOUND,
        CONNECTED,
        CLOSED;

    }

    static final boolean $assertionsDisabled = false;
    private static final AtomicReferenceFieldUpdater FINISH_READ_FUTURE_UPDATER = null;
    private static final int MAX_READER_STACK_DEPTH = 8;
    private static final ChannelMetadata METADATA;
    private final ChannelConfig config;
    private volatile ChannelPromise connectPromise;
    private volatile Future finishReadFuture;
    final Queue inboundBuffer;
    private volatile LocalAddress localAddress;
    private static final InternalLogger logger;
    private volatile LocalChannel peer;
    private volatile boolean readInProgress;
    private final Runnable readTask;
    private volatile LocalAddress remoteAddress;
    private final Runnable shutdownHook;
    private volatile State state;
    private volatile boolean writeInProgress;

    static {
        LocalChannel.logger = InternalLoggerFactory.getInstance(LocalChannel.class);
        LocalChannel.FINISH_READ_FUTURE_UPDATER = AtomicReferenceFieldUpdater.newUpdater(LocalChannel.class, Future.class, "finishReadFuture");
        LocalChannel.METADATA = new ChannelMetadata(false);
    }

    public LocalChannel() {
        super(null);
        DefaultChannelConfig defaultChannelConfig0 = new DefaultChannelConfig(this);
        this.config = defaultChannelConfig0;
        this.inboundBuffer = PlatformDependent.newSpscQueue();
        this.readTask = new Runnable() {
            @Override
            public void run() {
                if(!LocalChannel.this.inboundBuffer.isEmpty()) {
                    LocalChannel.this.readInbound();
                }
            }
        };
        this.shutdownHook = new Runnable() {
            @Override
            public void run() {
                LocalChannel.this.unsafe().close(LocalChannel.this.unsafe().voidPromise());
            }
        };
        this.config().setAllocator(new PreferHeapByteBufAllocator(defaultChannelConfig0.getAllocator()));
    }

    public LocalChannel(LocalServerChannel localServerChannel0, LocalChannel localChannel0) {
        super(localServerChannel0);
        DefaultChannelConfig defaultChannelConfig0 = new DefaultChannelConfig(this);
        this.config = defaultChannelConfig0;
        this.inboundBuffer = PlatformDependent.newSpscQueue();
        this.readTask = new Runnable() {
            @Override
            public void run() {
                if(!LocalChannel.this.inboundBuffer.isEmpty()) {
                    LocalChannel.this.readInbound();
                }
            }
        };
        this.shutdownHook = new Runnable() {
            @Override
            public void run() {
                LocalChannel.this.unsafe().close(LocalChannel.this.unsafe().voidPromise());
            }
        };
        this.config().setAllocator(new PreferHeapByteBufAllocator(defaultChannelConfig0.getAllocator()));
        this.peer = localChannel0;
        this.localAddress = localServerChannel0.localAddress();
        this.remoteAddress = localChannel0.localAddress();
    }

    @Override  // io.netty.channel.Channel
    public ChannelConfig config() {
        return this.config;
    }

    @Override  // io.netty.channel.AbstractChannel
    public void doBeginRead() {
        if(this.readInProgress) {
            return;
        }
        if(this.inboundBuffer.isEmpty()) {
            this.readInProgress = true;
            return;
        }
        InternalThreadLocalMap internalThreadLocalMap0 = InternalThreadLocalMap.get();
        int v = internalThreadLocalMap0.localChannelReaderStackDepth();
        if(v < 8) {
            internalThreadLocalMap0.setLocalChannelReaderStackDepth(v + 1);
            try {
                this.readInbound();
            }
            finally {
                internalThreadLocalMap0.setLocalChannelReaderStackDepth(v);
            }
            return;
        }
        try {
            this.eventLoop().execute(this.readTask);
        }
        catch(Throwable throwable0) {
            LocalChannel.logger.warn("Closing Local channels {}-{} because exception occurred!", new Object[]{this, this.peer, throwable0});
            this.close();
            this.peer.close();
            PlatformDependent.throwException(throwable0);
        }
    }

    @Override  // io.netty.channel.AbstractChannel
    public void doBind(SocketAddress socketAddress0) {
        this.localAddress = LocalChannelRegistry.register(this, this.localAddress, socketAddress0);
        this.state = State.BOUND;
    }

    @Override  // io.netty.channel.AbstractChannel
    public void doClose() {
        try {
            LocalChannel localChannel0 = this.peer;
            State localChannel$State0 = this.state;
            State localChannel$State1 = State.CLOSED;
            if(localChannel$State0 != localChannel$State1) {
                if(this.localAddress != null) {
                    if(this.parent() == null) {
                        LocalChannelRegistry.unregister(this.localAddress);
                    }
                    this.localAddress = null;
                }
                this.state = localChannel$State1;
                if(this.writeInProgress && localChannel0 != null) {
                    this.finishPeerRead(localChannel0);
                }
                ChannelPromise channelPromise0 = this.connectPromise;
                if(channelPromise0 != null) {
                    channelPromise0.tryFailure(new ClosedChannelException());
                    this.connectPromise = null;
                }
            }
            if(localChannel0 != null) {
                this.peer = null;
                EventLoop eventLoop0 = localChannel0.eventLoop();
                boolean z = localChannel0.isActive();
                try {
                    eventLoop0.execute(() -> {
                        if(this.val$peerIsActive) {
                            this.val$peer.unsafe().close(this.val$peer.unsafe().voidPromise());
                            return;
                        }
                        this.val$peer.releaseInboundBuffers();
                    });
                }
                catch(Throwable throwable0) {
                    LocalChannel.logger.warn("Releasing Inbound Queues for channels {}-{} because exception occurred!", new Object[]{this, localChannel0, throwable0});
                    if(eventLoop0.inEventLoop()) {
                        localChannel0.releaseInboundBuffers();
                    }
                    else {
                        localChannel0.close();
                    }
                    PlatformDependent.throwException(throwable0);
                }
            }
        }
        finally {
            if(localChannel$State0 != null && localChannel$State0 != State.CLOSED) {
                this.releaseInboundBuffers();
            }
        }

        class io.netty.channel.local.LocalChannel.4 implements Runnable {
            public io.netty.channel.local.LocalChannel.4(LocalChannel localChannel1, boolean z) {
            }

            @Override
            public void run() {
                this.val$peer.tryClose(this.val$peerIsActive);
            }
        }

    }

    @Override  // io.netty.channel.AbstractChannel
    public void doDeregister() {
        ((SingleThreadEventExecutor)this.eventLoop()).removeShutdownHook(this.shutdownHook);
    }

    @Override  // io.netty.channel.AbstractChannel
    public void doDisconnect() {
        this.doClose();
    }

    @Override  // io.netty.channel.AbstractChannel
    public void doRegister() {
        if(this.peer != null && this.parent() != null) {
            LocalChannel localChannel0 = this.peer;
            this.state = State.CONNECTED;
            localChannel0.remoteAddress = this.parent() == null ? null : this.parent().localAddress();
            localChannel0.state = State.CONNECTED;
            localChannel0.eventLoop().execute(new Runnable() {
                @Override
                public void run() {
                    ChannelPromise channelPromise0 = localChannel0.connectPromise;
                    if(channelPromise0 != null && channelPromise0.trySuccess()) {
                        localChannel0.pipeline().fireChannelActive();
                    }
                }
            });
        }
        ((SingleThreadEventExecutor)this.eventLoop()).addShutdownHook(this.shutdownHook);
    }

    @Override  // io.netty.channel.AbstractChannel
    public void doWrite(ChannelOutboundBuffer channelOutboundBuffer0) {
        switch(io.netty.channel.local.LocalChannel.6.$SwitchMap$io$netty$channel$local$LocalChannel$State[this.state.ordinal()]) {
            case 1: 
            case 2: {
                throw new NotYetConnectedException();
            }
            case 3: {
                throw new ClosedChannelException();
            }
            default: {
                LocalChannel localChannel0 = this.peer;
                this.writeInProgress = true;
                ClosedChannelException closedChannelException0 = null;
                try {
                    Object object0;
                    while((object0 = channelOutboundBuffer0.current()) != null) {
                        try {
                            if(localChannel0.state != State.CONNECTED) {
                                if(closedChannelException0 == null) {
                                    closedChannelException0 = new ClosedChannelException();
                                }
                                channelOutboundBuffer0.remove(closedChannelException0);
                                continue;
                            }
                            Object object1 = ReferenceCountUtil.retain(object0);
                            localChannel0.inboundBuffer.add(object1);
                            channelOutboundBuffer0.remove();
                            continue;
                        }
                        catch(Throwable throwable0) {
                        }
                        channelOutboundBuffer0.remove(throwable0);
                    }
                }
                finally {
                    this.writeInProgress = false;
                }
                this.finishPeerRead(localChannel0);
            }
        }
    }

    private void finishPeerRead(LocalChannel localChannel0) {
        if(localChannel0.eventLoop() == this.eventLoop() && !localChannel0.writeInProgress) {
            this.finishPeerRead0(localChannel0);
            return;
        }
        this.runFinishPeerReadTask(localChannel0);
    }

    // 检测为 Lambda 实现
    private void finishPeerRead0(LocalChannel localChannel0) [...]

    @Override  // io.netty.channel.Channel
    public boolean isActive() {
        return this.state == State.CONNECTED;
    }

    @Override  // io.netty.channel.AbstractChannel
    public boolean isCompatible(EventLoop eventLoop0) {
        return eventLoop0 instanceof SingleThreadEventLoop;
    }

    @Override  // io.netty.channel.Channel
    public boolean isOpen() {
        return this.state != State.CLOSED;
    }

    public LocalAddress localAddress() {
        return (LocalAddress)super.localAddress();
    }

    @Override  // io.netty.channel.AbstractChannel
    public SocketAddress localAddress() {
        return this.localAddress();
    }

    @Override  // io.netty.channel.AbstractChannel
    public SocketAddress localAddress0() {
        return this.localAddress;
    }

    @Override  // io.netty.channel.Channel
    public ChannelMetadata metadata() {
        return LocalChannel.METADATA;
    }

    @Override  // io.netty.channel.AbstractChannel
    public AbstractUnsafe newUnsafe() {
        return new LocalUnsafe(this, null);
    }

    @Override  // io.netty.channel.AbstractChannel
    public Channel parent() {
        return this.parent();
    }

    public LocalServerChannel parent() {
        return (LocalServerChannel)super.parent();
    }

    private void readInbound() {
        Handle recvByteBufAllocator$Handle0 = this.unsafe().recvBufAllocHandle();
        recvByteBufAllocator$Handle0.reset(this.config());
        ChannelPipeline channelPipeline0 = this.pipeline();
        do {
            ByteBuf byteBuf0 = this.inboundBuffer.poll();
            if(byteBuf0 == null) {
                break;
            }
            if(byteBuf0 instanceof ByteBuf && this.inboundBuffer.peek() instanceof ByteBuf) {
                ByteBuf byteBuf1 = recvByteBufAllocator$Handle0.allocate(this.alloc());
                if(byteBuf0.readableBytes() < byteBuf1.writableBytes()) {
                    byteBuf1.writeBytes(byteBuf0, byteBuf0.readerIndex(), byteBuf0.readableBytes());
                    byteBuf0.release();
                    while(true) {
                        Object object0 = this.inboundBuffer.peek();
                        if(!(object0 instanceof ByteBuf) || ((ByteBuf)object0).readableBytes() >= byteBuf1.writableBytes()) {
                            break;
                        }
                        this.inboundBuffer.poll();
                        byteBuf1.writeBytes(((ByteBuf)object0), ((ByteBuf)object0).readerIndex(), ((ByteBuf)object0).readableBytes());
                        ((ByteBuf)object0).release();
                    }
                    recvByteBufAllocator$Handle0.lastBytesRead(byteBuf1.readableBytes());
                    byteBuf0 = byteBuf1;
                }
                else {
                    recvByteBufAllocator$Handle0.lastBytesRead(byteBuf1.capacity());
                    byteBuf1.release();
                }
            }
            recvByteBufAllocator$Handle0.incMessagesRead(1);
            channelPipeline0.fireChannelRead(byteBuf0);
        }
        while(recvByteBufAllocator$Handle0.continueReading());
        recvByteBufAllocator$Handle0.readComplete();
        channelPipeline0.fireChannelReadComplete();
    }

    private void releaseInboundBuffers() {
        this.readInProgress = false;
        Queue queue0 = this.inboundBuffer;
        Object object0;
        while((object0 = queue0.poll()) != null) {
            ReferenceCountUtil.release(object0);
        }
    }

    public LocalAddress remoteAddress() {
        return (LocalAddress)super.remoteAddress();
    }

    @Override  // io.netty.channel.AbstractChannel
    public SocketAddress remoteAddress() {
        return this.remoteAddress();
    }

    @Override  // io.netty.channel.AbstractChannel
    public SocketAddress remoteAddress0() {
        return this.remoteAddress;
    }

    private void runFinishPeerReadTask(LocalChannel localChannel0) {
        io.netty.channel.local.LocalChannel.5 localChannel$50 = () -> {
            Future future0 = this.val$peer.finishReadFuture;
            if(future0 != null) {
                if(!future0.isDone()) {
                    LocalChannel.this.runFinishPeerReadTask(this.val$peer);
                    return;
                }
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater0 = LocalChannel.FINISH_READ_FUTURE_UPDATER;
                while(!atomicReferenceFieldUpdater0.compareAndSet(this.val$peer, future0, null) && atomicReferenceFieldUpdater0.get(this.val$peer) == future0) {
                }
            }
            if(this.val$peer.readInProgress && !this.val$peer.inboundBuffer.isEmpty()) {
                this.val$peer.readInProgress = false;
                this.val$peer.readInbound();
            }
        };
        try {
            if(localChannel0.writeInProgress) {
                localChannel0.finishReadFuture = localChannel0.eventLoop().submit(localChannel$50);
                return;
            }
            localChannel0.eventLoop().execute(localChannel$50);
            return;
        }
        catch(Throwable throwable0) {
        }
        LocalChannel.logger.warn("Closing Local channels {}-{} because exception occurred!", new Object[]{this, localChannel0, throwable0});
        this.close();
        localChannel0.close();
        PlatformDependent.throwException(throwable0);

        class io.netty.channel.local.LocalChannel.5 implements Runnable {
            public io.netty.channel.local.LocalChannel.5(LocalChannel localChannel1) {
            }

            @Override
            public void run() {
                LocalChannel.this.finishPeerRead0(this.val$peer);
            }
        }

    }

    // 检测为 Lambda 实现
    private void tryClose(boolean z) [...]

    class io.netty.channel.local.LocalChannel.6 {
        static final int[] $SwitchMap$io$netty$channel$local$LocalChannel$State;

        static {
            int[] arr_v = new int[State.values().length];
            io.netty.channel.local.LocalChannel.6.$SwitchMap$io$netty$channel$local$LocalChannel$State = arr_v;
            try {
                arr_v[State.OPEN.ordinal()] = 1;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                io.netty.channel.local.LocalChannel.6.$SwitchMap$io$netty$channel$local$LocalChannel$State[State.BOUND.ordinal()] = 2;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                io.netty.channel.local.LocalChannel.6.$SwitchMap$io$netty$channel$local$LocalChannel$State[State.CLOSED.ordinal()] = 3;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                io.netty.channel.local.LocalChannel.6.$SwitchMap$io$netty$channel$local$LocalChannel$State[State.CONNECTED.ordinal()] = 4;
            }
            catch(NoSuchFieldError unused_ex) {
            }
        }
    }

}

