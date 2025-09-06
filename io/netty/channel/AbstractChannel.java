package io.netty.channel;

import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.socket.ChannelOutputShutdownEvent;
import io.netty.channel.socket.ChannelOutputShutdownException;
import io.netty.util.DefaultAttributeMap;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.Promise;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.io.IOException;
import java.net.ConnectException;
import java.net.InetSocketAddress;
import java.net.NoRouteToHostException;
import java.net.SocketAddress;
import java.net.SocketException;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.NotYetConnectedException;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

public abstract class AbstractChannel extends DefaultAttributeMap implements Channel {
    public abstract class AbstractUnsafe implements Unsafe {
        static final boolean $assertionsDisabled;
        private boolean inFlush0;
        private boolean neverRegistered;
        private volatile ChannelOutboundBuffer outboundBuffer;
        private Handle recvHandle;

        public AbstractUnsafe() {
            this.outboundBuffer = new ChannelOutboundBuffer(abstractChannel0);
            this.neverRegistered = true;
        }

        public final Throwable annotateConnectException(Throwable throwable0, SocketAddress socketAddress0) {
            if(throwable0 instanceof ConnectException) {
                return new AnnotatedConnectException(((ConnectException)throwable0), socketAddress0);
            }
            if(throwable0 instanceof NoRouteToHostException) {
                return new AnnotatedNoRouteToHostException(((NoRouteToHostException)throwable0), socketAddress0);
            }
            return throwable0 instanceof SocketException ? new AnnotatedSocketException(((SocketException)throwable0), socketAddress0) : throwable0;
        }

        private void assertEventLoop() {
        }

        @Override  // io.netty.channel.Channel$Unsafe
        public final void beginRead() {
            try {
                AbstractChannel.this.doBeginRead();
            }
            catch(Exception exception0) {
                this.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        AbstractChannel.this.pipeline.fireExceptionCaught(exception0);
                    }
                });
                this.close(this.voidPromise());
            }
        }

        @Override  // io.netty.channel.Channel$Unsafe
        public final void bind(SocketAddress socketAddress0, ChannelPromise channelPromise0) {
            if(channelPromise0.setUncancellable() && this.ensureOpen(channelPromise0)) {
                Object object0 = AbstractChannel.this.config().getOption(ChannelOption.SO_BROADCAST);
                if(Boolean.TRUE.equals(object0) && socketAddress0 instanceof InetSocketAddress && !((InetSocketAddress)socketAddress0).getAddress().isAnyLocalAddress()) {
                    AbstractChannel.logger.warn("A non-root user can\'t receive a broadcast packet if the socket is not bound to a wildcard address; binding to a non-wildcard address (" + socketAddress0 + ") anyway as requested.");
                }
                boolean z = AbstractChannel.this.isActive();
                try {
                    AbstractChannel.this.doBind(socketAddress0);
                }
                catch(Throwable throwable0) {
                    this.safeSetFailure(channelPromise0, throwable0);
                    this.closeIfClosed();
                    return;
                }
                if(!z && AbstractChannel.this.isActive()) {
                    this.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            AbstractChannel.this.pipeline.fireChannelActive();
                        }
                    });
                }
                this.safeSetSuccess(channelPromise0);
            }
        }

        private void close(ChannelPromise channelPromise0, Throwable throwable0, ClosedChannelException closedChannelException0, boolean z) {
            if(!channelPromise0.setUncancellable()) {
                return;
            }
            if(AbstractChannel.this.closeInitiated) {
                if(AbstractChannel.this.closeFuture.isDone()) {
                    this.safeSetSuccess(channelPromise0);
                    return;
                }
                if(!(channelPromise0 instanceof VoidChannelPromise)) {
                    io.netty.channel.AbstractChannel.AbstractUnsafe.4 abstractChannel$AbstractUnsafe$40 = new ChannelFutureListener() {
                        public void operationComplete(ChannelFuture channelFuture0) {
                            channelPromise0.setSuccess();
                        }

                        @Override  // io.netty.util.concurrent.GenericFutureListener
                        public void operationComplete(Future future0) {
                            this.operationComplete(((ChannelFuture)future0));
                        }
                    };
                    AbstractChannel.this.closeFuture.addListener(abstractChannel$AbstractUnsafe$40);
                }
                return;
            }
            AbstractChannel.this.closeInitiated = true;
            boolean z1 = AbstractChannel.this.isActive();
            ChannelOutboundBuffer channelOutboundBuffer0 = this.outboundBuffer;
            this.outboundBuffer = null;
            Executor executor0 = this.prepareToClose();
            if(executor0 != null) {
                executor0.execute(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            AbstractUnsafe.this.doClose0(channelPromise0);
                        }
                        finally {
                            io.netty.channel.AbstractChannel.AbstractUnsafe.5.1 abstractChannel$AbstractUnsafe$5$10 = new Runnable() {
                                @Override
                                public void run() {
                                    io.netty.channel.AbstractChannel.AbstractUnsafe.5 abstractChannel$AbstractUnsafe$50 = io.netty.channel.AbstractChannel.AbstractUnsafe.5.this;
                                    ChannelOutboundBuffer channelOutboundBuffer0 = abstractChannel$AbstractUnsafe$50.val$outboundBuffer;
                                    if(channelOutboundBuffer0 != null) {
                                        channelOutboundBuffer0.failFlushed(abstractChannel$AbstractUnsafe$50.val$cause, abstractChannel$AbstractUnsafe$50.val$notify);
                                        io.netty.channel.AbstractChannel.AbstractUnsafe.5.this.val$outboundBuffer.close(io.netty.channel.AbstractChannel.AbstractUnsafe.5.this.val$closeCause);
                                    }
                                    AbstractUnsafe.this.fireChannelInactiveAndDeregister(io.netty.channel.AbstractChannel.AbstractUnsafe.5.this.val$wasActive);
                                }
                            };
                            AbstractUnsafe.this.invokeLater(abstractChannel$AbstractUnsafe$5$10);
                        }
                    }
                });
                return;
            }
            try {
                this.doClose0(channelPromise0);
            }
            catch(Throwable throwable1) {
                if(channelOutboundBuffer0 != null) {
                    channelOutboundBuffer0.failFlushed(throwable0, z);
                    channelOutboundBuffer0.close(closedChannelException0);
                }
                throw throwable1;
            }
            if(channelOutboundBuffer0 != null) {
                channelOutboundBuffer0.failFlushed(throwable0, z);
                channelOutboundBuffer0.close(closedChannelException0);
            }
            if(this.inFlush0) {
                this.invokeLater(() -> AbstractUnsafe.this.deregister(AbstractUnsafe.this.voidPromise(), this.val$wasActive && !AbstractChannel.this.isActive()));
                return;
            }
            this.fireChannelInactiveAndDeregister(z1);

            class io.netty.channel.AbstractChannel.AbstractUnsafe.6 implements Runnable {
                public io.netty.channel.AbstractChannel.AbstractUnsafe.6(boolean z) {
                }

                @Override
                public void run() {
                    AbstractUnsafe.this.fireChannelInactiveAndDeregister(this.val$wasActive);
                }
            }

        }

        @Override  // io.netty.channel.Channel$Unsafe
        public void close(ChannelPromise channelPromise0) {
            StacklessClosedChannelException stacklessClosedChannelException0 = StacklessClosedChannelException.newInstance(AbstractChannel.class, "close(ChannelPromise)");
            this.close(channelPromise0, stacklessClosedChannelException0, stacklessClosedChannelException0, false);
        }

        @Override  // io.netty.channel.Channel$Unsafe
        public final void closeForcibly() {
            try {
                AbstractChannel.this.doClose();
            }
            catch(Exception exception0) {
                AbstractChannel.logger.warn("Failed to close a channel.", exception0);
            }
        }

        public final void closeIfClosed() {
            if(AbstractChannel.this.isOpen()) {
                return;
            }
            this.close(this.voidPromise());
        }

        private void closeOutboundBufferForShutdown(ChannelPipeline channelPipeline0, ChannelOutboundBuffer channelOutboundBuffer0, Throwable throwable0) {
            channelOutboundBuffer0.failFlushed(throwable0, false);
            channelOutboundBuffer0.close(throwable0, true);
            channelPipeline0.fireUserEventTriggered(ChannelOutputShutdownEvent.INSTANCE);
        }

        private void deregister(ChannelPromise channelPromise0, boolean z) {
            if(!channelPromise0.setUncancellable()) {
                return;
            }
            if(!AbstractChannel.this.registered) {
                this.safeSetSuccess(channelPromise0);
                return;
            }
            this.invokeLater(new Runnable() {
                @Override
                public void run() {
                    try {
                        AbstractChannel.this.doDeregister();
                    }
                    catch(Throwable throwable0) {
                        try {
                            AbstractChannel.logger.warn("Unexpected exception occurred while deregistering a channel.", throwable0);
                        }
                        catch(Throwable throwable1) {
                            if(z) {
                                AbstractChannel.this.pipeline.fireChannelInactive();
                            }
                            if(AbstractChannel.this.registered) {
                                AbstractChannel.this.registered = false;
                                AbstractChannel.this.pipeline.fireChannelUnregistered();
                            }
                            AbstractUnsafe.this.safeSetSuccess(channelPromise0);
                            throw throwable1;
                        }
                        if(z) {
                            AbstractChannel.this.pipeline.fireChannelInactive();
                        }
                        if(AbstractChannel.this.registered) {
                            AbstractChannel.this.registered = false;
                            AbstractChannel.this.pipeline.fireChannelUnregistered();
                        }
                        AbstractUnsafe.this.safeSetSuccess(channelPromise0);
                        return;
                    }
                    if(z) {
                        AbstractChannel.this.pipeline.fireChannelInactive();
                    }
                    if(AbstractChannel.this.registered) {
                        AbstractChannel.this.registered = false;
                        AbstractChannel.this.pipeline.fireChannelUnregistered();
                    }
                    AbstractUnsafe.this.safeSetSuccess(channelPromise0);
                }
            });
        }

        @Override  // io.netty.channel.Channel$Unsafe
        public final void deregister(ChannelPromise channelPromise0) {
            this.deregister(channelPromise0, false);
        }

        @Override  // io.netty.channel.Channel$Unsafe
        public final void disconnect(ChannelPromise channelPromise0) {
            if(!channelPromise0.setUncancellable()) {
                return;
            }
            boolean z = AbstractChannel.this.isActive();
            try {
                AbstractChannel.this.doDisconnect();
                AbstractChannel.this.remoteAddress = null;
                AbstractChannel.this.localAddress = null;
            }
            catch(Throwable throwable0) {
                this.safeSetFailure(channelPromise0, throwable0);
                this.closeIfClosed();
                return;
            }
            if(z && !AbstractChannel.this.isActive()) {
                this.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        AbstractChannel.this.pipeline.fireChannelInactive();
                    }
                });
            }
            this.safeSetSuccess(channelPromise0);
            this.closeIfClosed();
        }

        private void doClose0(ChannelPromise channelPromise0) {
            try {
                AbstractChannel.this.doClose();
                AbstractChannel.this.closeFuture.setClosed();
                this.safeSetSuccess(channelPromise0);
            }
            catch(Throwable throwable0) {
                AbstractChannel.this.closeFuture.setClosed();
                this.safeSetFailure(channelPromise0, throwable0);
            }
        }

        public final boolean ensureOpen(ChannelPromise channelPromise0) {
            if(AbstractChannel.this.isOpen()) {
                return true;
            }
            this.safeSetFailure(channelPromise0, this.newClosedChannelException(AbstractChannel.this.initialCloseCause, "ensureOpen(ChannelPromise)"));
            return false;
        }

        // 检测为 Lambda 实现
        private void fireChannelInactiveAndDeregister(boolean z) [...]

        @Override  // io.netty.channel.Channel$Unsafe
        public final void flush() {
            ChannelOutboundBuffer channelOutboundBuffer0 = this.outboundBuffer;
            if(channelOutboundBuffer0 == null) {
                return;
            }
            channelOutboundBuffer0.addFlush();
            this.flush0();
        }

        public void flush0() {
            if(!this.inFlush0) {
                ChannelOutboundBuffer channelOutboundBuffer0 = this.outboundBuffer;
                if(channelOutboundBuffer0 != null && !channelOutboundBuffer0.isEmpty()) {
                    this.inFlush0 = true;
                    if(!AbstractChannel.this.isActive()) {
                        try {
                            if(!channelOutboundBuffer0.isEmpty()) {
                                if(AbstractChannel.this.isOpen()) {
                                    channelOutboundBuffer0.failFlushed(new NotYetConnectedException(), true);
                                }
                                else {
                                    channelOutboundBuffer0.failFlushed(this.newClosedChannelException(AbstractChannel.this.initialCloseCause, "flush0()"), false);
                                }
                            }
                        }
                        finally {
                            this.inFlush0 = false;
                        }
                        return;
                    }
                    try {
                        AbstractChannel.this.doWrite(channelOutboundBuffer0);
                        this.inFlush0 = false;
                    }
                    catch(Throwable throwable0) {
                        try {
                            this.handleWriteError(throwable0);
                            this.inFlush0 = false;
                        }
                        catch(Throwable throwable1) {
                            this.inFlush0 = false;
                            throw throwable1;
                        }
                    }
                }
            }
        }

        public final void handleWriteError(Throwable throwable0) {
            if(throwable0 instanceof IOException && AbstractChannel.this.config().isAutoClose()) {
                AbstractChannel.this.initialCloseCause = throwable0;
                this.close(this.voidPromise(), throwable0, this.newClosedChannelException(throwable0, "flush0()"), false);
                return;
            }
            try {
                this.shutdownOutput(this.voidPromise(), throwable0);
            }
            catch(Throwable throwable1) {
                AbstractChannel.this.initialCloseCause = throwable0;
                this.close(this.voidPromise(), throwable1, this.newClosedChannelException(throwable0, "flush0()"), false);
            }
        }

        private void invokeLater(Runnable runnable0) {
            try {
                AbstractChannel.this.eventLoop().execute(runnable0);
            }
            catch(RejectedExecutionException rejectedExecutionException0) {
                AbstractChannel.logger.warn("Can\'t invoke task later as EventLoop rejected it", rejectedExecutionException0);
            }
        }

        @Override  // io.netty.channel.Channel$Unsafe
        public final SocketAddress localAddress() {
            return AbstractChannel.this.localAddress0();
        }

        private ClosedChannelException newClosedChannelException(Throwable throwable0, String s) {
            ClosedChannelException closedChannelException0 = StacklessClosedChannelException.newInstance(AbstractUnsafe.class, s);
            if(throwable0 != null) {
                closedChannelException0.initCause(throwable0);
            }
            return closedChannelException0;
        }

        @Override  // io.netty.channel.Channel$Unsafe
        public final ChannelOutboundBuffer outboundBuffer() {
            return this.outboundBuffer;
        }

        public Executor prepareToClose() {
            return null;
        }

        @Override  // io.netty.channel.Channel$Unsafe
        public Handle recvBufAllocHandle() {
            if(this.recvHandle == null) {
                this.recvHandle = AbstractChannel.this.config().getRecvByteBufAllocator().newHandle();
            }
            return this.recvHandle;
        }

        @Override  // io.netty.channel.Channel$Unsafe
        public final void register(EventLoop eventLoop0, ChannelPromise channelPromise0) {
            ObjectUtil.checkNotNull(eventLoop0, "eventLoop");
            if(AbstractChannel.this.isRegistered()) {
                channelPromise0.setFailure(new IllegalStateException("registered to an event loop already"));
                return;
            }
            if(!AbstractChannel.this.isCompatible(eventLoop0)) {
                channelPromise0.setFailure(new IllegalStateException("incompatible event loop type: " + eventLoop0.getClass().getName()));
                return;
            }
            AbstractChannel.this.eventLoop = eventLoop0;
            if(eventLoop0.inEventLoop()) {
                this.register0(channelPromise0);
                return;
            }
            try {
                eventLoop0.execute(() -> {
                    try {
                        if(this.val$promise.setUncancellable() && AbstractUnsafe.this.ensureOpen(this.val$promise)) {
                            boolean z = AbstractUnsafe.this.neverRegistered;
                            AbstractChannel.this.doRegister();
                            AbstractUnsafe.this.neverRegistered = false;
                            AbstractChannel.this.registered = true;
                            AbstractChannel.this.pipeline.invokeHandlerAddedIfNeeded();
                            AbstractUnsafe.this.safeSetSuccess(this.val$promise);
                            AbstractChannel.this.pipeline.fireChannelRegistered();
                            if(AbstractChannel.this.isActive()) {
                                if(z) {
                                    AbstractChannel.this.pipeline.fireChannelActive();
                                    return;
                                }
                                if(AbstractChannel.this.config().isAutoRead()) {
                                    AbstractUnsafe.this.beginRead();
                                }
                            }
                        }
                        return;
                    }
                    catch(Throwable throwable0) {
                    }
                    AbstractUnsafe.this.closeForcibly();
                    AbstractChannel.this.closeFuture.setClosed();
                    AbstractUnsafe.this.safeSetFailure(this.val$promise, throwable0);
                });
            }
            catch(Throwable throwable0) {
                AbstractChannel.logger.warn("Force-closing a channel whose registration task was not accepted by an event loop: {}", AbstractChannel.this, throwable0);
                this.closeForcibly();
                AbstractChannel.this.closeFuture.setClosed();
                this.safeSetFailure(channelPromise0, throwable0);
            }

            class io.netty.channel.AbstractChannel.AbstractUnsafe.1 implements Runnable {
                public io.netty.channel.AbstractChannel.AbstractUnsafe.1(ChannelPromise channelPromise0) {
                }

                @Override
                public void run() {
                    AbstractUnsafe.this.register0(this.val$promise);
                }
            }

        }

        // 检测为 Lambda 实现
        private void register0(ChannelPromise channelPromise0) [...]

        @Override  // io.netty.channel.Channel$Unsafe
        public final SocketAddress remoteAddress() {
            return AbstractChannel.this.remoteAddress0();
        }

        public final void safeSetFailure(ChannelPromise channelPromise0, Throwable throwable0) {
            if(!(channelPromise0 instanceof VoidChannelPromise) && !channelPromise0.tryFailure(throwable0)) {
                AbstractChannel.logger.warn("Failed to mark a promise as failure because it\'s done already: {}", channelPromise0, throwable0);
            }
        }

        public final void safeSetSuccess(ChannelPromise channelPromise0) {
            if(!(channelPromise0 instanceof VoidChannelPromise) && !channelPromise0.trySuccess()) {
                AbstractChannel.logger.warn("Failed to mark a promise as success because it is done already: {}", channelPromise0);
            }
        }

        private void shutdownOutput(ChannelPromise channelPromise0, Throwable throwable0) {
            if(!channelPromise0.setUncancellable()) {
                return;
            }
            ChannelOutboundBuffer channelOutboundBuffer0 = this.outboundBuffer;
            if(channelOutboundBuffer0 == null) {
                channelPromise0.setFailure(new ClosedChannelException());
                return;
            }
            this.outboundBuffer = null;
            ChannelOutputShutdownException channelOutputShutdownException0 = throwable0 == null ? new ChannelOutputShutdownException("Channel output shutdown") : new ChannelOutputShutdownException("Channel output shutdown", throwable0);
            try {
                AbstractChannel.this.doShutdownOutput();
                channelPromise0.setSuccess();
            }
            catch(Throwable throwable1) {
                channelPromise0.setFailure(throwable1);
            }
            finally {
                this.closeOutboundBufferForShutdown(AbstractChannel.this.pipeline, channelOutboundBuffer0, channelOutputShutdownException0);
            }
        }

        public final void shutdownOutput(ChannelPromise channelPromise0) {
            this.shutdownOutput(channelPromise0, null);
        }

        @Override  // io.netty.channel.Channel$Unsafe
        public final ChannelPromise voidPromise() {
            return AbstractChannel.this.unsafeVoidPromise;
        }

        @Override  // io.netty.channel.Channel$Unsafe
        public final void write(Object object0, ChannelPromise channelPromise0) {
            int v1;
            ChannelOutboundBuffer channelOutboundBuffer0 = this.outboundBuffer;
            if(channelOutboundBuffer0 == null) {
                try {
                    ReferenceCountUtil.release(object0);
                }
                finally {
                    this.safeSetFailure(channelPromise0, this.newClosedChannelException(AbstractChannel.this.initialCloseCause, "write(Object, ChannelPromise)"));
                }
                return;
            }
            try {
                object0 = AbstractChannel.this.filterOutboundMessage(object0);
                v1 = AbstractChannel.this.pipeline.estimatorHandle().size(object0);
            }
            catch(Throwable unused_ex) {
                try {
                    ReferenceCountUtil.release(object0);
                }
                finally {
                    this.safeSetFailure(channelPromise0, throwable0);
                }
                return;
            }
            if(v1 < 0) {
                v1 = 0;
            }
            channelOutboundBuffer0.addMessage(object0, v1, channelPromise0);
        }
    }

    static final class AnnotatedConnectException extends ConnectException {
        private static final long serialVersionUID = 0x36268A3AE3B97B94L;

        public AnnotatedConnectException(ConnectException connectException0, SocketAddress socketAddress0) {
            super(connectException0.getMessage() + ": " + socketAddress0);
            this.initCause(connectException0);
        }

        @Override
        public Throwable fillInStackTrace() {
            return this;
        }
    }

    static final class AnnotatedNoRouteToHostException extends NoRouteToHostException {
        private static final long serialVersionUID = -6801433937592080623L;

        public AnnotatedNoRouteToHostException(NoRouteToHostException noRouteToHostException0, SocketAddress socketAddress0) {
            super(noRouteToHostException0.getMessage() + ": " + socketAddress0);
            this.initCause(noRouteToHostException0);
        }

        @Override
        public Throwable fillInStackTrace() {
            return this;
        }
    }

    static final class AnnotatedSocketException extends SocketException {
        private static final long serialVersionUID = 0x3614035CDFE3F217L;

        public AnnotatedSocketException(SocketException socketException0, SocketAddress socketAddress0) {
            super(socketException0.getMessage() + ": " + socketAddress0);
            this.initCause(socketException0);
        }

        @Override
        public Throwable fillInStackTrace() {
            return this;
        }
    }

    static final class CloseFuture extends DefaultChannelPromise {
        public CloseFuture(AbstractChannel abstractChannel0) {
            super(abstractChannel0);
        }

        public boolean setClosed() {
            return super.trySuccess();
        }

        @Override  // io.netty.channel.DefaultChannelPromise
        public ChannelPromise setFailure(Throwable throwable0) {
            throw new IllegalStateException();
        }

        @Override  // io.netty.channel.DefaultChannelPromise
        public Promise setFailure(Throwable throwable0) {
            return this.setFailure(throwable0);
        }

        @Override  // io.netty.channel.DefaultChannelPromise
        public ChannelPromise setSuccess() {
            throw new IllegalStateException();
        }

        @Override  // io.netty.util.concurrent.DefaultPromise, io.netty.util.concurrent.Promise
        public boolean tryFailure(Throwable throwable0) {
            throw new IllegalStateException();
        }

        @Override  // io.netty.channel.DefaultChannelPromise
        public boolean trySuccess() {
            throw new IllegalStateException();
        }
    }

    private final CloseFuture closeFuture;
    private boolean closeInitiated;
    private volatile EventLoop eventLoop;
    private final ChannelId id;
    private Throwable initialCloseCause;
    private volatile SocketAddress localAddress;
    private static final InternalLogger logger;
    private final Channel parent;
    private final DefaultChannelPipeline pipeline;
    private volatile boolean registered;
    private volatile SocketAddress remoteAddress;
    private String strVal;
    private boolean strValActive;
    private final Unsafe unsafe;
    private final VoidChannelPromise unsafeVoidPromise;

    static {
        AbstractChannel.logger = InternalLoggerFactory.getInstance(AbstractChannel.class);
    }

    public AbstractChannel(Channel channel0) {
        this.unsafeVoidPromise = new VoidChannelPromise(this, false);
        this.closeFuture = new CloseFuture(this);
        this.parent = channel0;
        this.id = this.newId();
        this.unsafe = this.newUnsafe();
        this.pipeline = this.newChannelPipeline();
    }

    public AbstractChannel(Channel channel0, ChannelId channelId0) {
        this.unsafeVoidPromise = new VoidChannelPromise(this, false);
        this.closeFuture = new CloseFuture(this);
        this.parent = channel0;
        this.id = channelId0;
        this.unsafe = this.newUnsafe();
        this.pipeline = this.newChannelPipeline();
    }

    public static EventLoop access$100(AbstractChannel abstractChannel0) {
        return abstractChannel0.eventLoop;
    }

    @Override  // io.netty.channel.Channel
    public ByteBufAllocator alloc() {
        return this.config().getAllocator();
    }

    @Override  // io.netty.channel.ChannelOutboundInvoker
    public ChannelFuture bind(SocketAddress socketAddress0) {
        return this.pipeline.bind(socketAddress0);
    }

    @Override  // io.netty.channel.ChannelOutboundInvoker
    public ChannelFuture bind(SocketAddress socketAddress0, ChannelPromise channelPromise0) {
        return this.pipeline.bind(socketAddress0, channelPromise0);
    }

    @Override  // io.netty.channel.Channel
    public long bytesBeforeUnwritable() {
        ChannelOutboundBuffer channelOutboundBuffer0 = this.unsafe.outboundBuffer();
        return channelOutboundBuffer0 == null ? 0L : channelOutboundBuffer0.bytesBeforeUnwritable();
    }

    @Override  // io.netty.channel.Channel
    public long bytesBeforeWritable() {
        ChannelOutboundBuffer channelOutboundBuffer0 = this.unsafe.outboundBuffer();
        return channelOutboundBuffer0 == null ? 0x7FFFFFFFFFFFFFFFL : channelOutboundBuffer0.bytesBeforeWritable();
    }

    @Override  // io.netty.channel.ChannelOutboundInvoker
    public ChannelFuture close() {
        return this.pipeline.close();
    }

    @Override  // io.netty.channel.ChannelOutboundInvoker
    public ChannelFuture close(ChannelPromise channelPromise0) {
        return this.pipeline.close(channelPromise0);
    }

    @Override  // io.netty.channel.Channel
    public ChannelFuture closeFuture() {
        return this.closeFuture;
    }

    public final int compareTo(Channel channel0) {
        return this == channel0 ? 0 : this.id().compareTo(channel0.id());
    }

    @Override
    public int compareTo(Object object0) {
        return this.compareTo(((Channel)object0));
    }

    @Override  // io.netty.channel.ChannelOutboundInvoker
    public ChannelFuture connect(SocketAddress socketAddress0) {
        return this.pipeline.connect(socketAddress0);
    }

    @Override  // io.netty.channel.ChannelOutboundInvoker
    public ChannelFuture connect(SocketAddress socketAddress0, ChannelPromise channelPromise0) {
        return this.pipeline.connect(socketAddress0, channelPromise0);
    }

    @Override  // io.netty.channel.ChannelOutboundInvoker
    public ChannelFuture connect(SocketAddress socketAddress0, SocketAddress socketAddress1) {
        return this.pipeline.connect(socketAddress0, socketAddress1);
    }

    @Override  // io.netty.channel.ChannelOutboundInvoker
    public ChannelFuture connect(SocketAddress socketAddress0, SocketAddress socketAddress1, ChannelPromise channelPromise0) {
        return this.pipeline.connect(socketAddress0, socketAddress1, channelPromise0);
    }

    @Override  // io.netty.channel.ChannelOutboundInvoker
    public ChannelFuture deregister() {
        return this.pipeline.deregister();
    }

    @Override  // io.netty.channel.ChannelOutboundInvoker
    public ChannelFuture deregister(ChannelPromise channelPromise0) {
        return this.pipeline.deregister(channelPromise0);
    }

    @Override  // io.netty.channel.ChannelOutboundInvoker
    public ChannelFuture disconnect() {
        return this.pipeline.disconnect();
    }

    @Override  // io.netty.channel.ChannelOutboundInvoker
    public ChannelFuture disconnect(ChannelPromise channelPromise0) {
        return this.pipeline.disconnect(channelPromise0);
    }

    public abstract void doBeginRead();

    public abstract void doBind(SocketAddress arg1);

    public abstract void doClose();

    public void doDeregister() {
    }

    public abstract void doDisconnect();

    public void doRegister() {
    }

    public void doShutdownOutput() {
        this.doClose();
    }

    public abstract void doWrite(ChannelOutboundBuffer arg1);

    @Override
    public final boolean equals(Object object0) {
        return this == object0;
    }

    @Override  // io.netty.channel.Channel
    public EventLoop eventLoop() {
        EventLoop eventLoop0 = this.eventLoop;
        if(eventLoop0 == null) {
            throw new IllegalStateException("channel not registered to an event loop");
        }
        return eventLoop0;
    }

    public Object filterOutboundMessage(Object object0) {
        return object0;
    }

    @Override  // io.netty.channel.Channel
    public Channel flush() {
        this.pipeline.flush();
        return this;
    }

    @Override  // io.netty.channel.ChannelOutboundInvoker
    public ChannelOutboundInvoker flush() {
        return this.flush();
    }

    @Override
    public final int hashCode() {
        return this.id.hashCode();
    }

    @Override  // io.netty.channel.Channel
    public final ChannelId id() {
        return this.id;
    }

    @Deprecated
    public void invalidateLocalAddress() {
        this.localAddress = null;
    }

    @Deprecated
    public void invalidateRemoteAddress() {
        this.remoteAddress = null;
    }

    public abstract boolean isCompatible(EventLoop arg1);

    @Override  // io.netty.channel.Channel
    public boolean isRegistered() {
        return this.registered;
    }

    @Override  // io.netty.channel.Channel
    public boolean isWritable() {
        ChannelOutboundBuffer channelOutboundBuffer0 = this.unsafe.outboundBuffer();
        return channelOutboundBuffer0 != null && channelOutboundBuffer0.isWritable();
    }

    @Override  // io.netty.channel.Channel
    public SocketAddress localAddress() {
        SocketAddress socketAddress0 = this.localAddress;
        if(socketAddress0 == null) {
            try {
                SocketAddress socketAddress1 = this.unsafe().localAddress();
                this.localAddress = socketAddress1;
                return socketAddress1;
            }
            catch(Error error0) {
                throw error0;
            }
            catch(Throwable unused_ex) {
                return null;
            }
        }
        return socketAddress0;
    }

    public abstract SocketAddress localAddress0();

    public final int maxMessagesPerWrite() {
        ChannelConfig channelConfig0 = this.config();
        if(channelConfig0 instanceof DefaultChannelConfig) {
            return ((DefaultChannelConfig)channelConfig0).getMaxMessagesPerWrite();
        }
        Integer integer0 = (Integer)channelConfig0.getOption(ChannelOption.MAX_MESSAGES_PER_WRITE);
        return integer0 == null ? 0x7FFFFFFF : ((int)integer0);
    }

    public DefaultChannelPipeline newChannelPipeline() {
        return new DefaultChannelPipeline(this);
    }

    @Override  // io.netty.channel.ChannelOutboundInvoker
    public ChannelFuture newFailedFuture(Throwable throwable0) {
        return this.pipeline.newFailedFuture(throwable0);
    }

    public ChannelId newId() {
        return DefaultChannelId.newInstance();
    }

    @Override  // io.netty.channel.ChannelOutboundInvoker
    public ChannelProgressivePromise newProgressivePromise() {
        return this.pipeline.newProgressivePromise();
    }

    @Override  // io.netty.channel.ChannelOutboundInvoker
    public ChannelPromise newPromise() {
        return this.pipeline.newPromise();
    }

    @Override  // io.netty.channel.ChannelOutboundInvoker
    public ChannelFuture newSucceededFuture() {
        return this.pipeline.newSucceededFuture();
    }

    public abstract AbstractUnsafe newUnsafe();

    @Override  // io.netty.channel.Channel
    public Channel parent() {
        return this.parent;
    }

    @Override  // io.netty.channel.Channel
    public ChannelPipeline pipeline() {
        return this.pipeline;
    }

    @Override  // io.netty.channel.Channel
    public Channel read() {
        this.pipeline.read();
        return this;
    }

    @Override  // io.netty.channel.ChannelOutboundInvoker
    public ChannelOutboundInvoker read() {
        return this.read();
    }

    @Override  // io.netty.channel.Channel
    public SocketAddress remoteAddress() {
        SocketAddress socketAddress0 = this.remoteAddress;
        if(socketAddress0 == null) {
            try {
                SocketAddress socketAddress1 = this.unsafe().remoteAddress();
                this.remoteAddress = socketAddress1;
                return socketAddress1;
            }
            catch(Error error0) {
                throw error0;
            }
            catch(Throwable unused_ex) {
                return null;
            }
        }
        return socketAddress0;
    }

    public abstract SocketAddress remoteAddress0();

    @Override
    public String toString() {
        boolean z = this.isActive();
        if(this.strValActive == z) {
            String s = this.strVal;
            if(s != null) {
                return s;
            }
        }
        SocketAddress socketAddress0 = this.remoteAddress();
        SocketAddress socketAddress1 = this.localAddress();
        if(socketAddress0 != null) {
            this.strVal = "[id: 0x" + this.id.asShortText() + ", L:" + socketAddress1 + (z ? " - " : " ! ") + "R:" + socketAddress0 + ']';
        }
        else if(socketAddress1 == null) {
            this.strVal = "[id: 0x" + this.id.asShortText() + ']';
        }
        else {
            this.strVal = "[id: 0x" + this.id.asShortText() + ", L:" + socketAddress1 + ']';
        }
        this.strValActive = z;
        return this.strVal;
    }

    @Override  // io.netty.channel.Channel
    public Unsafe unsafe() {
        return this.unsafe;
    }

    public void validateFileRegion(DefaultFileRegion defaultFileRegion0, long v) {
        DefaultFileRegion.validate(defaultFileRegion0, v);
    }

    @Override  // io.netty.channel.ChannelOutboundInvoker
    public final ChannelPromise voidPromise() {
        return this.pipeline.voidPromise();
    }

    @Override  // io.netty.channel.ChannelOutboundInvoker
    public ChannelFuture write(Object object0) {
        return this.pipeline.write(object0);
    }

    @Override  // io.netty.channel.ChannelOutboundInvoker
    public ChannelFuture write(Object object0, ChannelPromise channelPromise0) {
        return this.pipeline.write(object0, channelPromise0);
    }

    @Override  // io.netty.channel.ChannelOutboundInvoker
    public ChannelFuture writeAndFlush(Object object0) {
        return this.pipeline.writeAndFlush(object0);
    }

    @Override  // io.netty.channel.ChannelOutboundInvoker
    public ChannelFuture writeAndFlush(Object object0, ChannelPromise channelPromise0) {
        return this.pipeline.writeAndFlush(object0, channelPromise0);
    }
}

