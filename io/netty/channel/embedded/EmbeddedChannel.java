package io.netty.channel.embedded;

import io.netty.channel.AbstractChannel.AbstractUnsafe;
import io.netty.channel.AbstractChannel;
import io.netty.channel.Channel.Unsafe;
import io.netty.channel.Channel;
import io.netty.channel.ChannelConfig;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelId;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelMetadata;
import io.netty.channel.ChannelOutboundBuffer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.ChannelPromise;
import io.netty.channel.DefaultChannelConfig;
import io.netty.channel.DefaultChannelPipeline;
import io.netty.channel.EventLoop;
import io.netty.channel.RecvByteBufAllocator.Handle;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.concurrent.Future;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.RecyclableArrayList;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.net.SocketAddress;
import java.nio.channels.ClosedChannelException;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.TimeUnit;

public class EmbeddedChannel extends AbstractChannel {
    final class EmbeddedChannelPipeline extends DefaultChannelPipeline {
        public EmbeddedChannelPipeline(EmbeddedChannel embeddedChannel1) {
            super(embeddedChannel1);
        }

        @Override  // io.netty.channel.DefaultChannelPipeline
        public void onUnhandledInboundException(Throwable throwable0) {
            EmbeddedChannel.this.recordException(throwable0);
        }

        @Override  // io.netty.channel.DefaultChannelPipeline
        public void onUnhandledInboundMessage(ChannelHandlerContext channelHandlerContext0, Object object0) {
            EmbeddedChannel.this.handleInboundMessage(object0);
        }
    }

    final class EmbeddedUnsafe extends AbstractUnsafe {
        final Unsafe wrapped;

        private EmbeddedUnsafe() {
            this.wrapped = new Unsafe() {
                @Override  // io.netty.channel.Channel$Unsafe
                public void beginRead() {
                    EmbeddedUnsafe.this.beginRead();
                    EmbeddedChannel.this.runPendingTasks();
                }

                @Override  // io.netty.channel.Channel$Unsafe
                public void bind(SocketAddress socketAddress0, ChannelPromise channelPromise0) {
                    EmbeddedUnsafe.this.bind(socketAddress0, channelPromise0);
                    EmbeddedChannel.this.runPendingTasks();
                }

                @Override  // io.netty.channel.Channel$Unsafe
                public void close(ChannelPromise channelPromise0) {
                    EmbeddedUnsafe.this.close(channelPromise0);
                    EmbeddedChannel.this.runPendingTasks();
                }

                @Override  // io.netty.channel.Channel$Unsafe
                public void closeForcibly() {
                    EmbeddedUnsafe.this.closeForcibly();
                    EmbeddedChannel.this.runPendingTasks();
                }

                @Override  // io.netty.channel.Channel$Unsafe
                public void connect(SocketAddress socketAddress0, SocketAddress socketAddress1, ChannelPromise channelPromise0) {
                    EmbeddedUnsafe.this.connect(socketAddress0, socketAddress1, channelPromise0);
                    EmbeddedChannel.this.runPendingTasks();
                }

                @Override  // io.netty.channel.Channel$Unsafe
                public void deregister(ChannelPromise channelPromise0) {
                    EmbeddedUnsafe.this.deregister(channelPromise0);
                    EmbeddedChannel.this.runPendingTasks();
                }

                @Override  // io.netty.channel.Channel$Unsafe
                public void disconnect(ChannelPromise channelPromise0) {
                    EmbeddedUnsafe.this.disconnect(channelPromise0);
                    EmbeddedChannel.this.runPendingTasks();
                }

                @Override  // io.netty.channel.Channel$Unsafe
                public void flush() {
                    EmbeddedUnsafe.this.flush();
                    EmbeddedChannel.this.runPendingTasks();
                }

                @Override  // io.netty.channel.Channel$Unsafe
                public SocketAddress localAddress() {
                    return EmbeddedUnsafe.this.localAddress();
                }

                @Override  // io.netty.channel.Channel$Unsafe
                public ChannelOutboundBuffer outboundBuffer() {
                    return EmbeddedUnsafe.this.outboundBuffer();
                }

                @Override  // io.netty.channel.Channel$Unsafe
                public Handle recvBufAllocHandle() {
                    return EmbeddedUnsafe.this.recvBufAllocHandle();
                }

                @Override  // io.netty.channel.Channel$Unsafe
                public void register(EventLoop eventLoop0, ChannelPromise channelPromise0) {
                    EmbeddedUnsafe.this.register(eventLoop0, channelPromise0);
                    EmbeddedChannel.this.runPendingTasks();
                }

                @Override  // io.netty.channel.Channel$Unsafe
                public SocketAddress remoteAddress() {
                    return EmbeddedUnsafe.this.remoteAddress();
                }

                @Override  // io.netty.channel.Channel$Unsafe
                public ChannelPromise voidPromise() {
                    return EmbeddedUnsafe.this.voidPromise();
                }

                @Override  // io.netty.channel.Channel$Unsafe
                public void write(Object object0, ChannelPromise channelPromise0) {
                    EmbeddedUnsafe.this.write(object0, channelPromise0);
                    EmbeddedChannel.this.runPendingTasks();
                }
            };
        }

        public EmbeddedUnsafe(io.netty.channel.embedded.EmbeddedChannel.1 embeddedChannel$10) {
        }

        @Override  // io.netty.channel.Channel$Unsafe
        public void connect(SocketAddress socketAddress0, SocketAddress socketAddress1, ChannelPromise channelPromise0) {
            this.safeSetSuccess(channelPromise0);
        }
    }

    static enum State {
        OPEN,
        ACTIVE,
        CLOSED;

    }

    static final boolean $assertionsDisabled;
    private static final ChannelHandler[] EMPTY_HANDLERS;
    private static final SocketAddress LOCAL_ADDRESS;
    private static final ChannelMetadata METADATA_DISCONNECT;
    private static final ChannelMetadata METADATA_NO_DISCONNECT;
    private static final SocketAddress REMOTE_ADDRESS;
    private final ChannelConfig config;
    private Queue inboundMessages;
    private Throwable lastException;
    private static final InternalLogger logger;
    private final EmbeddedEventLoop loop;
    private final ChannelMetadata metadata;
    private Queue outboundMessages;
    private final ChannelFutureListener recordExceptionListener;
    private State state;

    static {
        EmbeddedChannel.LOCAL_ADDRESS = new EmbeddedSocketAddress();
        EmbeddedChannel.REMOTE_ADDRESS = new EmbeddedSocketAddress();
        EmbeddedChannel.EMPTY_HANDLERS = new ChannelHandler[0];
        EmbeddedChannel.logger = InternalLoggerFactory.getInstance(EmbeddedChannel.class);
        EmbeddedChannel.METADATA_NO_DISCONNECT = new ChannelMetadata(false);
        EmbeddedChannel.METADATA_DISCONNECT = new ChannelMetadata(true);
    }

    public EmbeddedChannel() {
        this(EmbeddedChannel.EMPTY_HANDLERS);
    }

    public EmbeddedChannel(Channel channel0, ChannelId channelId0, boolean z, boolean z1, ChannelHandler[] arr_channelHandler) {
        super(channel0, channelId0);
        this.loop = new EmbeddedEventLoop();
        this.recordExceptionListener = new ChannelFutureListener() {
            public void operationComplete(ChannelFuture channelFuture0) {
                EmbeddedChannel.this.recordException(channelFuture0);
            }

            @Override  // io.netty.util.concurrent.GenericFutureListener
            public void operationComplete(Future future0) {
                this.operationComplete(((ChannelFuture)future0));
            }
        };
        this.metadata = EmbeddedChannel.metadata(z1);
        this.config = new DefaultChannelConfig(this);
        this.setup(z, arr_channelHandler);
    }

    public EmbeddedChannel(ChannelId channelId0) {
        this(channelId0, EmbeddedChannel.EMPTY_HANDLERS);
    }

    public EmbeddedChannel(ChannelId channelId0, boolean z, ChannelConfig channelConfig0, ChannelHandler[] arr_channelHandler) {
        super(null, channelId0);
        this.loop = new EmbeddedEventLoop();
        this.recordExceptionListener = new ChannelFutureListener() {
            public void operationComplete(ChannelFuture channelFuture0) {
                EmbeddedChannel.this.recordException(channelFuture0);
            }

            @Override  // io.netty.util.concurrent.GenericFutureListener
            public void operationComplete(Future future0) {
                this.operationComplete(((ChannelFuture)future0));
            }
        };
        this.metadata = EmbeddedChannel.metadata(z);
        this.config = (ChannelConfig)ObjectUtil.checkNotNull(channelConfig0, "config");
        this.setup(true, arr_channelHandler);
    }

    public EmbeddedChannel(ChannelId channelId0, boolean z, boolean z1, ChannelHandler[] arr_channelHandler) {
        this(null, channelId0, z, z1, arr_channelHandler);
    }

    public EmbeddedChannel(ChannelId channelId0, boolean z, ChannelHandler[] arr_channelHandler) {
        this(channelId0, true, z, arr_channelHandler);
    }

    public EmbeddedChannel(ChannelId channelId0, ChannelHandler[] arr_channelHandler) {
        this(channelId0, false, arr_channelHandler);
    }

    public EmbeddedChannel(boolean z, boolean z1, ChannelHandler[] arr_channelHandler) {
        this(EmbeddedChannelId.INSTANCE, z, z1, arr_channelHandler);
    }

    public EmbeddedChannel(boolean z, ChannelHandler[] arr_channelHandler) {
        this(EmbeddedChannelId.INSTANCE, z, arr_channelHandler);
    }

    public EmbeddedChannel(ChannelHandler[] arr_channelHandler) {
        this(EmbeddedChannelId.INSTANCE, arr_channelHandler);
    }

    public void advanceTimeBy(long v, TimeUnit timeUnit0) {
        this.embeddedEventLoop().advanceTimeBy(timeUnit0.toNanos(v));
    }

    private ChannelFuture checkException(ChannelPromise channelPromise0) {
        Throwable throwable0 = this.lastException;
        if(throwable0 != null) {
            this.lastException = null;
            if(channelPromise0.isVoid()) {
                PlatformDependent.throwException(throwable0);
            }
            return channelPromise0.setFailure(throwable0);
        }
        return channelPromise0.setSuccess();
    }

    public void checkException() {
        this.checkException(this.voidPromise());
    }

    private boolean checkOpen(boolean z) {
        if(!this.isOpen()) {
            if(z) {
                this.recordException(new ClosedChannelException());
            }
            return false;
        }
        return true;
    }

    @Override  // io.netty.channel.AbstractChannel
    public final ChannelFuture close() {
        return this.close(this.newPromise());
    }

    @Override  // io.netty.channel.AbstractChannel
    public final ChannelFuture close(ChannelPromise channelPromise0) {
        this.runPendingTasks();
        ChannelFuture channelFuture0 = super.close(channelPromise0);
        this.finishPendingTasks(true);
        return channelFuture0;
    }

    @Override  // io.netty.channel.Channel
    public ChannelConfig config() {
        return this.config;
    }

    @Override  // io.netty.channel.AbstractChannel
    public final ChannelFuture disconnect() {
        return this.disconnect(this.newPromise());
    }

    @Override  // io.netty.channel.AbstractChannel
    public final ChannelFuture disconnect(ChannelPromise channelPromise0) {
        ChannelFuture channelFuture0 = super.disconnect(channelPromise0);
        this.finishPendingTasks(!this.metadata.hasDisconnect());
        return channelFuture0;
    }

    @Override  // io.netty.channel.AbstractChannel
    public void doBeginRead() {
    }

    @Override  // io.netty.channel.AbstractChannel
    public void doBind(SocketAddress socketAddress0) {
    }

    @Override  // io.netty.channel.AbstractChannel
    public void doClose() {
        this.state = State.CLOSED;
    }

    @Override  // io.netty.channel.AbstractChannel
    public void doDisconnect() {
        if(!this.metadata.hasDisconnect()) {
            this.doClose();
        }
    }

    @Override  // io.netty.channel.AbstractChannel
    public void doRegister() {
        this.state = State.ACTIVE;
    }

    @Override  // io.netty.channel.AbstractChannel
    public void doWrite(ChannelOutboundBuffer channelOutboundBuffer0) {
        Object object0;
        while((object0 = channelOutboundBuffer0.current()) != null) {
            ReferenceCountUtil.retain(object0);
            this.handleOutboundMessage(object0);
            channelOutboundBuffer0.remove();
        }
    }

    // 去混淆评级： 低(20)
    private EmbeddedEventLoop embeddedEventLoop() {
        return this.isRegistered() ? ((EmbeddedEventLoop)super.eventLoop()) : this.loop;
    }

    public final void ensureOpen() {
        if(!this.checkOpen(true)) {
            this.checkException();
        }
    }

    private boolean finish(boolean z) {
        this.close();
        try {
            this.checkException();
            return EmbeddedChannel.isNotEmpty(this.inboundMessages) || EmbeddedChannel.isNotEmpty(this.outboundMessages);
        }
        finally {
            if(z) {
                EmbeddedChannel.releaseAll(this.inboundMessages);
                EmbeddedChannel.releaseAll(this.outboundMessages);
            }
        }
    }

    public boolean finish() {
        return this.finish(false);
    }

    public boolean finishAndReleaseAll() {
        return this.finish(true);
    }

    private void finishPendingTasks(boolean z) {
        this.runPendingTasks();
        if(z) {
            this.embeddedEventLoop().cancelScheduledTasks();
        }
    }

    private ChannelFuture flushInbound(boolean z, ChannelPromise channelPromise0) {
        if(this.checkOpen(z)) {
            this.pipeline().fireChannelReadComplete();
            this.runPendingTasks();
        }
        return this.checkException(channelPromise0);
    }

    public EmbeddedChannel flushInbound() {
        this.flushInbound(true, this.voidPromise());
        return this;
    }

    public EmbeddedChannel flushOutbound() {
        if(this.checkOpen(true)) {
            this.flushOutbound0();
        }
        this.checkException(this.voidPromise());
        return this;
    }

    private void flushOutbound0() {
        this.runPendingTasks();
        this.flush();
    }

    public void freezeTime() {
        this.embeddedEventLoop().freezeTime();
    }

    public void handleInboundMessage(Object object0) {
        this.inboundMessages().add(object0);
    }

    public void handleOutboundMessage(Object object0) {
        this.outboundMessages().add(object0);
    }

    public boolean hasPendingTasks() {
        return this.embeddedEventLoop().hasPendingNormalTasks() || this.embeddedEventLoop().nextScheduledTask() == 0L;
    }

    public Queue inboundMessages() {
        if(this.inboundMessages == null) {
            this.inboundMessages = new ArrayDeque();
        }
        return this.inboundMessages;
    }

    @Override  // io.netty.channel.Channel
    public boolean isActive() {
        return this.state == State.ACTIVE;
    }

    @Override  // io.netty.channel.AbstractChannel
    public boolean isCompatible(EventLoop eventLoop0) {
        return eventLoop0 instanceof EmbeddedEventLoop;
    }

    private static boolean isNotEmpty(Queue queue0) {
        return queue0 != null && !queue0.isEmpty();
    }

    @Override  // io.netty.channel.Channel
    public boolean isOpen() {
        return this.state != State.CLOSED;
    }

    @Deprecated
    public Queue lastInboundBuffer() {
        return this.inboundMessages();
    }

    @Deprecated
    public Queue lastOutboundBuffer() {
        return this.outboundMessages();
    }

    // 去混淆评级： 低(20)
    @Override  // io.netty.channel.AbstractChannel
    public SocketAddress localAddress0() {
        return this.isActive() ? EmbeddedChannel.LOCAL_ADDRESS : null;
    }

    // 去混淆评级： 低(20)
    private static ChannelMetadata metadata(boolean z) {
        return z ? EmbeddedChannel.METADATA_DISCONNECT : EmbeddedChannel.METADATA_NO_DISCONNECT;
    }

    @Override  // io.netty.channel.Channel
    public ChannelMetadata metadata() {
        return this.metadata;
    }

    @Override  // io.netty.channel.AbstractChannel
    public final DefaultChannelPipeline newChannelPipeline() {
        return new EmbeddedChannelPipeline(this, this);
    }

    @Override  // io.netty.channel.AbstractChannel
    public AbstractUnsafe newUnsafe() {
        return new EmbeddedUnsafe(this, null);
    }

    public Queue outboundMessages() {
        if(this.outboundMessages == null) {
            this.outboundMessages = new ArrayDeque();
        }
        return this.outboundMessages;
    }

    private static Object poll(Queue queue0) {
        return queue0 == null ? null : queue0.poll();
    }

    public Object readInbound() {
        Object object0 = EmbeddedChannel.poll(this.inboundMessages);
        if(object0 != null) {
            ReferenceCountUtil.touch(object0, "Caller of readInbound() will handle the message from this point");
        }
        return object0;
    }

    public Object readOutbound() {
        Object object0 = EmbeddedChannel.poll(this.outboundMessages);
        if(object0 != null) {
            ReferenceCountUtil.touch(object0, "Caller of readOutbound() will handle the message from this point.");
        }
        return object0;
    }

    private void recordException(ChannelFuture channelFuture0) {
        if(!channelFuture0.isSuccess()) {
            this.recordException(channelFuture0.cause());
        }
    }

    private void recordException(Throwable throwable0) {
        if(this.lastException == null) {
            this.lastException = throwable0;
            return;
        }
        EmbeddedChannel.logger.warn("More than one exception was raised. Will report only the first one and log others.", throwable0);
    }

    public void register() {
        Throwable throwable0 = this.loop.register(this).cause();
        if(throwable0 != null) {
            PlatformDependent.throwException(throwable0);
        }
    }

    private static boolean releaseAll(Queue queue0) {
        if(EmbeddedChannel.isNotEmpty(queue0)) {
            Object object0;
            while((object0 = queue0.poll()) != null) {
                ReferenceCountUtil.release(object0);
            }
            return true;
        }
        return false;
    }

    public boolean releaseInbound() {
        return EmbeddedChannel.releaseAll(this.inboundMessages);
    }

    public boolean releaseOutbound() {
        return EmbeddedChannel.releaseAll(this.outboundMessages);
    }

    // 去混淆评级： 低(20)
    @Override  // io.netty.channel.AbstractChannel
    public SocketAddress remoteAddress0() {
        return this.isActive() ? EmbeddedChannel.REMOTE_ADDRESS : null;
    }

    public void runPendingTasks() {
        try {
            this.embeddedEventLoop().runTasks();
        }
        catch(Exception exception0) {
            this.recordException(exception0);
        }
        try {
            this.embeddedEventLoop().runScheduledTasks();
        }
        catch(Exception exception1) {
            this.recordException(exception1);
        }
    }

    public long runScheduledPendingTasks() {
        try {
            return this.embeddedEventLoop().runScheduledTasks();
        }
        catch(Exception exception0) {
            this.recordException(exception0);
            return this.embeddedEventLoop().nextScheduledTask();
        }
    }

    private void setup(boolean z, ChannelHandler[] arr_channelHandler) {
        ObjectUtil.checkNotNull(arr_channelHandler, "handlers");
        this.pipeline().addLast(new ChannelHandler[]{new ChannelInitializer() {
            @Override  // io.netty.channel.ChannelInitializer
            public void initChannel(Channel channel0) {
                ChannelPipeline channelPipeline0 = channel0.pipeline();
                ChannelHandler[] arr_channelHandler = arr_channelHandler;
                for(int v = 0; v < arr_channelHandler.length; ++v) {
                    ChannelHandler channelHandler0 = arr_channelHandler[v];
                    if(channelHandler0 == null) {
                        break;
                    }
                    channelPipeline0.addLast(new ChannelHandler[]{channelHandler0});
                }
            }
        }});
        if(z) {
            this.loop.register(this);
        }
    }

    public void unfreezeTime() {
        this.embeddedEventLoop().unfreezeTime();
    }

    @Override  // io.netty.channel.AbstractChannel
    public Unsafe unsafe() {
        return ((EmbeddedUnsafe)super.unsafe()).wrapped;
    }

    public boolean writeInbound(Object[] arr_object) {
        this.ensureOpen();
        if(arr_object.length == 0) {
            return EmbeddedChannel.isNotEmpty(this.inboundMessages);
        }
        ChannelPipeline channelPipeline0 = this.pipeline();
        for(int v = 0; v < arr_object.length; ++v) {
            channelPipeline0.fireChannelRead(arr_object[v]);
        }
        this.flushInbound(false, this.voidPromise());
        return EmbeddedChannel.isNotEmpty(this.inboundMessages);
    }

    public ChannelFuture writeOneInbound(Object object0) {
        return this.writeOneInbound(object0, this.newPromise());
    }

    public ChannelFuture writeOneInbound(Object object0, ChannelPromise channelPromise0) {
        if(this.checkOpen(true)) {
            this.pipeline().fireChannelRead(object0);
        }
        return this.checkException(channelPromise0);
    }

    public ChannelFuture writeOneOutbound(Object object0) {
        return this.writeOneOutbound(object0, this.newPromise());
    }

    // 去混淆评级： 低(20)
    public ChannelFuture writeOneOutbound(Object object0, ChannelPromise channelPromise0) {
        return this.checkOpen(true) ? this.write(object0, channelPromise0) : this.checkException(channelPromise0);
    }

    public boolean writeOutbound(Object[] arr_object) {
        this.ensureOpen();
        if(arr_object.length == 0) {
            return EmbeddedChannel.isNotEmpty(this.outboundMessages);
        }
        RecyclableArrayList recyclableArrayList0 = RecyclableArrayList.newInstance(arr_object.length);
        try {
            for(int v2 = 0; v2 < arr_object.length; ++v2) {
                Object object0 = arr_object[v2];
                if(object0 == null) {
                    break;
                }
                recyclableArrayList0.add(this.write(object0));
            }
            this.flushOutbound0();
            int v3 = recyclableArrayList0.size();
            for(int v1 = 0; v1 < v3; ++v1) {
                ChannelFuture channelFuture0 = (ChannelFuture)recyclableArrayList0.get(v1);
                if(channelFuture0.isDone()) {
                    this.recordException(channelFuture0);
                }
                else {
                    channelFuture0.addListener(this.recordExceptionListener);
                }
            }
            this.checkException();
            return EmbeddedChannel.isNotEmpty(this.outboundMessages);
        }
        finally {
            recyclableArrayList0.recycle();
        }
    }
}

