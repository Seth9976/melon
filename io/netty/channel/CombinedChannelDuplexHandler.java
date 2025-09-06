package io.netty.channel;

import io.netty.buffer.ByteBufAllocator;
import io.netty.util.Attribute;
import io.netty.util.AttributeKey;
import io.netty.util.concurrent.EventExecutor;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.ThrowableUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.net.SocketAddress;

public class CombinedChannelDuplexHandler extends ChannelDuplexHandler {
    static class DelegatingChannelHandlerContext implements ChannelHandlerContext {
        private final ChannelHandlerContext ctx;
        private final ChannelHandler handler;
        boolean removed;

        public DelegatingChannelHandlerContext(ChannelHandlerContext channelHandlerContext0, ChannelHandler channelHandler0) {
            this.ctx = channelHandlerContext0;
            this.handler = channelHandler0;
        }

        public static ChannelHandlerContext access$300(DelegatingChannelHandlerContext combinedChannelDuplexHandler$DelegatingChannelHandlerContext0) {
            return combinedChannelDuplexHandler$DelegatingChannelHandlerContext0.ctx;
        }

        @Override  // io.netty.channel.ChannelHandlerContext
        public ByteBufAllocator alloc() {
            return this.ctx.alloc();
        }

        @Override  // io.netty.channel.ChannelHandlerContext
        public Attribute attr(AttributeKey attributeKey0) {
            return this.ctx.channel().attr(attributeKey0);
        }

        @Override  // io.netty.channel.ChannelOutboundInvoker
        public ChannelFuture bind(SocketAddress socketAddress0) {
            return this.ctx.bind(socketAddress0);
        }

        @Override  // io.netty.channel.ChannelOutboundInvoker
        public ChannelFuture bind(SocketAddress socketAddress0, ChannelPromise channelPromise0) {
            return this.ctx.bind(socketAddress0, channelPromise0);
        }

        @Override  // io.netty.channel.ChannelHandlerContext
        public Channel channel() {
            return this.ctx.channel();
        }

        @Override  // io.netty.channel.ChannelOutboundInvoker
        public ChannelFuture close() {
            return this.ctx.close();
        }

        @Override  // io.netty.channel.ChannelOutboundInvoker
        public ChannelFuture close(ChannelPromise channelPromise0) {
            return this.ctx.close(channelPromise0);
        }

        @Override  // io.netty.channel.ChannelOutboundInvoker
        public ChannelFuture connect(SocketAddress socketAddress0) {
            return this.ctx.connect(socketAddress0);
        }

        @Override  // io.netty.channel.ChannelOutboundInvoker
        public ChannelFuture connect(SocketAddress socketAddress0, ChannelPromise channelPromise0) {
            return this.ctx.connect(socketAddress0, channelPromise0);
        }

        @Override  // io.netty.channel.ChannelOutboundInvoker
        public ChannelFuture connect(SocketAddress socketAddress0, SocketAddress socketAddress1) {
            return this.ctx.connect(socketAddress0, socketAddress1);
        }

        @Override  // io.netty.channel.ChannelOutboundInvoker
        public ChannelFuture connect(SocketAddress socketAddress0, SocketAddress socketAddress1, ChannelPromise channelPromise0) {
            return this.ctx.connect(socketAddress0, socketAddress1, channelPromise0);
        }

        @Override  // io.netty.channel.ChannelOutboundInvoker
        public ChannelFuture deregister() {
            return this.ctx.deregister();
        }

        @Override  // io.netty.channel.ChannelOutboundInvoker
        public ChannelFuture deregister(ChannelPromise channelPromise0) {
            return this.ctx.deregister(channelPromise0);
        }

        @Override  // io.netty.channel.ChannelOutboundInvoker
        public ChannelFuture disconnect() {
            return this.ctx.disconnect();
        }

        @Override  // io.netty.channel.ChannelOutboundInvoker
        public ChannelFuture disconnect(ChannelPromise channelPromise0) {
            return this.ctx.disconnect(channelPromise0);
        }

        @Override  // io.netty.channel.ChannelHandlerContext
        public EventExecutor executor() {
            return this.ctx.executor();
        }

        @Override  // io.netty.channel.ChannelHandlerContext
        public ChannelHandlerContext fireChannelActive() {
            this.ctx.fireChannelActive();
            return this;
        }

        @Override  // io.netty.channel.ChannelInboundInvoker
        public ChannelInboundInvoker fireChannelActive() {
            return this.fireChannelActive();
        }

        @Override  // io.netty.channel.ChannelHandlerContext
        public ChannelHandlerContext fireChannelInactive() {
            this.ctx.fireChannelInactive();
            return this;
        }

        @Override  // io.netty.channel.ChannelInboundInvoker
        public ChannelInboundInvoker fireChannelInactive() {
            return this.fireChannelInactive();
        }

        @Override  // io.netty.channel.ChannelHandlerContext
        public ChannelHandlerContext fireChannelRead(Object object0) {
            this.ctx.fireChannelRead(object0);
            return this;
        }

        @Override  // io.netty.channel.ChannelInboundInvoker
        public ChannelInboundInvoker fireChannelRead(Object object0) {
            return this.fireChannelRead(object0);
        }

        @Override  // io.netty.channel.ChannelHandlerContext
        public ChannelHandlerContext fireChannelReadComplete() {
            this.ctx.fireChannelReadComplete();
            return this;
        }

        @Override  // io.netty.channel.ChannelInboundInvoker
        public ChannelInboundInvoker fireChannelReadComplete() {
            return this.fireChannelReadComplete();
        }

        @Override  // io.netty.channel.ChannelHandlerContext
        public ChannelHandlerContext fireChannelRegistered() {
            this.ctx.fireChannelRegistered();
            return this;
        }

        @Override  // io.netty.channel.ChannelInboundInvoker
        public ChannelInboundInvoker fireChannelRegistered() {
            return this.fireChannelRegistered();
        }

        @Override  // io.netty.channel.ChannelHandlerContext
        public ChannelHandlerContext fireChannelUnregistered() {
            this.ctx.fireChannelUnregistered();
            return this;
        }

        @Override  // io.netty.channel.ChannelInboundInvoker
        public ChannelInboundInvoker fireChannelUnregistered() {
            return this.fireChannelUnregistered();
        }

        @Override  // io.netty.channel.ChannelHandlerContext
        public ChannelHandlerContext fireChannelWritabilityChanged() {
            this.ctx.fireChannelWritabilityChanged();
            return this;
        }

        @Override  // io.netty.channel.ChannelInboundInvoker
        public ChannelInboundInvoker fireChannelWritabilityChanged() {
            return this.fireChannelWritabilityChanged();
        }

        @Override  // io.netty.channel.ChannelHandlerContext
        public ChannelHandlerContext fireExceptionCaught(Throwable throwable0) {
            this.ctx.fireExceptionCaught(throwable0);
            return this;
        }

        @Override  // io.netty.channel.ChannelInboundInvoker
        public ChannelInboundInvoker fireExceptionCaught(Throwable throwable0) {
            return this.fireExceptionCaught(throwable0);
        }

        @Override  // io.netty.channel.ChannelHandlerContext
        public ChannelHandlerContext fireUserEventTriggered(Object object0) {
            this.ctx.fireUserEventTriggered(object0);
            return this;
        }

        @Override  // io.netty.channel.ChannelInboundInvoker
        public ChannelInboundInvoker fireUserEventTriggered(Object object0) {
            return this.fireUserEventTriggered(object0);
        }

        @Override  // io.netty.channel.ChannelHandlerContext
        public ChannelHandlerContext flush() {
            this.ctx.flush();
            return this;
        }

        @Override  // io.netty.channel.ChannelOutboundInvoker
        public ChannelOutboundInvoker flush() {
            return this.flush();
        }

        @Override  // io.netty.channel.ChannelHandlerContext
        public ChannelHandler handler() {
            return this.ctx.handler();
        }

        @Override  // io.netty.channel.ChannelHandlerContext
        public boolean hasAttr(AttributeKey attributeKey0) {
            return this.ctx.channel().hasAttr(attributeKey0);
        }

        // 去混淆评级： 低(20)
        @Override  // io.netty.channel.ChannelHandlerContext
        public boolean isRemoved() {
            return this.removed || this.ctx.isRemoved();
        }

        @Override  // io.netty.channel.ChannelHandlerContext
        public String name() {
            return this.ctx.name();
        }

        @Override  // io.netty.channel.ChannelOutboundInvoker
        public ChannelFuture newFailedFuture(Throwable throwable0) {
            return this.ctx.newFailedFuture(throwable0);
        }

        @Override  // io.netty.channel.ChannelOutboundInvoker
        public ChannelProgressivePromise newProgressivePromise() {
            return this.ctx.newProgressivePromise();
        }

        @Override  // io.netty.channel.ChannelOutboundInvoker
        public ChannelPromise newPromise() {
            return this.ctx.newPromise();
        }

        @Override  // io.netty.channel.ChannelOutboundInvoker
        public ChannelFuture newSucceededFuture() {
            return this.ctx.newSucceededFuture();
        }

        @Override  // io.netty.channel.ChannelHandlerContext
        public ChannelPipeline pipeline() {
            return this.ctx.pipeline();
        }

        @Override  // io.netty.channel.ChannelHandlerContext
        public ChannelHandlerContext read() {
            this.ctx.read();
            return this;
        }

        @Override  // io.netty.channel.ChannelOutboundInvoker
        public ChannelOutboundInvoker read() {
            return this.read();
        }

        public final void remove() {
            EventExecutor eventExecutor0 = this.executor();
            if(eventExecutor0.inEventLoop()) {
                this.remove0();
                return;
            }
            eventExecutor0.execute(() -> if(!DelegatingChannelHandlerContext.this.removed) {
                try {
                    DelegatingChannelHandlerContext.this.removed = true;
                    DelegatingChannelHandlerContext.this.handler.handlerRemoved(DelegatingChannelHandlerContext.this);
                }
                catch(Throwable throwable0) {
                    DelegatingChannelHandlerContext.this.fireExceptionCaught(new ChannelPipelineException(DelegatingChannelHandlerContext.this.handler.getClass().getName() + ".handlerRemoved() has thrown an exception.", throwable0));
                }
            });

            class io.netty.channel.CombinedChannelDuplexHandler.DelegatingChannelHandlerContext.1 implements Runnable {
                @Override
                public void run() {
                    DelegatingChannelHandlerContext.this.remove0();
                }
            }

        }

        // 检测为 Lambda 实现
        private void remove0() [...]

        @Override  // io.netty.channel.ChannelOutboundInvoker
        public ChannelPromise voidPromise() {
            return this.ctx.voidPromise();
        }

        @Override  // io.netty.channel.ChannelOutboundInvoker
        public ChannelFuture write(Object object0) {
            return this.ctx.write(object0);
        }

        @Override  // io.netty.channel.ChannelOutboundInvoker
        public ChannelFuture write(Object object0, ChannelPromise channelPromise0) {
            return this.ctx.write(object0, channelPromise0);
        }

        @Override  // io.netty.channel.ChannelOutboundInvoker
        public ChannelFuture writeAndFlush(Object object0) {
            return this.ctx.writeAndFlush(object0);
        }

        @Override  // io.netty.channel.ChannelOutboundInvoker
        public ChannelFuture writeAndFlush(Object object0, ChannelPromise channelPromise0) {
            return this.ctx.writeAndFlush(object0, channelPromise0);
        }
    }

    static final boolean $assertionsDisabled;
    private volatile boolean handlerAdded;
    private DelegatingChannelHandlerContext inboundCtx;
    private ChannelInboundHandler inboundHandler;
    private static final InternalLogger logger;
    private DelegatingChannelHandlerContext outboundCtx;
    private ChannelOutboundHandler outboundHandler;

    static {
        CombinedChannelDuplexHandler.logger = InternalLoggerFactory.getInstance(CombinedChannelDuplexHandler.class);
    }

    public CombinedChannelDuplexHandler() {
        this.ensureNotSharable();
    }

    public CombinedChannelDuplexHandler(ChannelInboundHandler channelInboundHandler0, ChannelOutboundHandler channelOutboundHandler0) {
        this.ensureNotSharable();
        this.init(channelInboundHandler0, channelOutboundHandler0);
    }

    @Override  // io.netty.channel.ChannelDuplexHandler
    public void bind(ChannelHandlerContext channelHandlerContext0, SocketAddress socketAddress0, ChannelPromise channelPromise0) {
        DelegatingChannelHandlerContext combinedChannelDuplexHandler$DelegatingChannelHandlerContext0 = this.outboundCtx;
        if(!combinedChannelDuplexHandler$DelegatingChannelHandlerContext0.removed) {
            this.outboundHandler.bind(combinedChannelDuplexHandler$DelegatingChannelHandlerContext0, socketAddress0, channelPromise0);
            return;
        }
        combinedChannelDuplexHandler$DelegatingChannelHandlerContext0.bind(socketAddress0, channelPromise0);
    }

    @Override  // io.netty.channel.ChannelInboundHandlerAdapter
    public void channelActive(ChannelHandlerContext channelHandlerContext0) {
        DelegatingChannelHandlerContext combinedChannelDuplexHandler$DelegatingChannelHandlerContext0 = this.inboundCtx;
        if(!combinedChannelDuplexHandler$DelegatingChannelHandlerContext0.removed) {
            this.inboundHandler.channelActive(combinedChannelDuplexHandler$DelegatingChannelHandlerContext0);
            return;
        }
        combinedChannelDuplexHandler$DelegatingChannelHandlerContext0.fireChannelActive();
    }

    @Override  // io.netty.channel.ChannelInboundHandlerAdapter
    public void channelInactive(ChannelHandlerContext channelHandlerContext0) {
        DelegatingChannelHandlerContext combinedChannelDuplexHandler$DelegatingChannelHandlerContext0 = this.inboundCtx;
        if(!combinedChannelDuplexHandler$DelegatingChannelHandlerContext0.removed) {
            this.inboundHandler.channelInactive(combinedChannelDuplexHandler$DelegatingChannelHandlerContext0);
            return;
        }
        combinedChannelDuplexHandler$DelegatingChannelHandlerContext0.fireChannelInactive();
    }

    @Override  // io.netty.channel.ChannelInboundHandlerAdapter
    public void channelRead(ChannelHandlerContext channelHandlerContext0, Object object0) {
        DelegatingChannelHandlerContext combinedChannelDuplexHandler$DelegatingChannelHandlerContext0 = this.inboundCtx;
        if(!combinedChannelDuplexHandler$DelegatingChannelHandlerContext0.removed) {
            this.inboundHandler.channelRead(combinedChannelDuplexHandler$DelegatingChannelHandlerContext0, object0);
            return;
        }
        combinedChannelDuplexHandler$DelegatingChannelHandlerContext0.fireChannelRead(object0);
    }

    @Override  // io.netty.channel.ChannelInboundHandlerAdapter
    public void channelReadComplete(ChannelHandlerContext channelHandlerContext0) {
        DelegatingChannelHandlerContext combinedChannelDuplexHandler$DelegatingChannelHandlerContext0 = this.inboundCtx;
        if(!combinedChannelDuplexHandler$DelegatingChannelHandlerContext0.removed) {
            this.inboundHandler.channelReadComplete(combinedChannelDuplexHandler$DelegatingChannelHandlerContext0);
            return;
        }
        combinedChannelDuplexHandler$DelegatingChannelHandlerContext0.fireChannelReadComplete();
    }

    @Override  // io.netty.channel.ChannelInboundHandlerAdapter
    public void channelRegistered(ChannelHandlerContext channelHandlerContext0) {
        DelegatingChannelHandlerContext combinedChannelDuplexHandler$DelegatingChannelHandlerContext0 = this.inboundCtx;
        if(!combinedChannelDuplexHandler$DelegatingChannelHandlerContext0.removed) {
            this.inboundHandler.channelRegistered(combinedChannelDuplexHandler$DelegatingChannelHandlerContext0);
            return;
        }
        combinedChannelDuplexHandler$DelegatingChannelHandlerContext0.fireChannelRegistered();
    }

    @Override  // io.netty.channel.ChannelInboundHandlerAdapter
    public void channelUnregistered(ChannelHandlerContext channelHandlerContext0) {
        DelegatingChannelHandlerContext combinedChannelDuplexHandler$DelegatingChannelHandlerContext0 = this.inboundCtx;
        if(!combinedChannelDuplexHandler$DelegatingChannelHandlerContext0.removed) {
            this.inboundHandler.channelUnregistered(combinedChannelDuplexHandler$DelegatingChannelHandlerContext0);
            return;
        }
        combinedChannelDuplexHandler$DelegatingChannelHandlerContext0.fireChannelUnregistered();
    }

    @Override  // io.netty.channel.ChannelInboundHandlerAdapter
    public void channelWritabilityChanged(ChannelHandlerContext channelHandlerContext0) {
        DelegatingChannelHandlerContext combinedChannelDuplexHandler$DelegatingChannelHandlerContext0 = this.inboundCtx;
        if(!combinedChannelDuplexHandler$DelegatingChannelHandlerContext0.removed) {
            this.inboundHandler.channelWritabilityChanged(combinedChannelDuplexHandler$DelegatingChannelHandlerContext0);
            return;
        }
        combinedChannelDuplexHandler$DelegatingChannelHandlerContext0.fireChannelWritabilityChanged();
    }

    private void checkAdded() {
        if(!this.handlerAdded) {
            throw new IllegalStateException("handler not added to pipeline yet");
        }
    }

    @Override  // io.netty.channel.ChannelDuplexHandler
    public void close(ChannelHandlerContext channelHandlerContext0, ChannelPromise channelPromise0) {
        DelegatingChannelHandlerContext combinedChannelDuplexHandler$DelegatingChannelHandlerContext0 = this.outboundCtx;
        if(!combinedChannelDuplexHandler$DelegatingChannelHandlerContext0.removed) {
            this.outboundHandler.close(combinedChannelDuplexHandler$DelegatingChannelHandlerContext0, channelPromise0);
            return;
        }
        combinedChannelDuplexHandler$DelegatingChannelHandlerContext0.close(channelPromise0);
    }

    @Override  // io.netty.channel.ChannelDuplexHandler
    public void connect(ChannelHandlerContext channelHandlerContext0, SocketAddress socketAddress0, SocketAddress socketAddress1, ChannelPromise channelPromise0) {
        DelegatingChannelHandlerContext combinedChannelDuplexHandler$DelegatingChannelHandlerContext0 = this.outboundCtx;
        if(!combinedChannelDuplexHandler$DelegatingChannelHandlerContext0.removed) {
            this.outboundHandler.connect(combinedChannelDuplexHandler$DelegatingChannelHandlerContext0, socketAddress0, socketAddress1, channelPromise0);
            return;
        }
        combinedChannelDuplexHandler$DelegatingChannelHandlerContext0.connect(socketAddress0, socketAddress1, channelPromise0);
    }

    @Override  // io.netty.channel.ChannelDuplexHandler
    public void deregister(ChannelHandlerContext channelHandlerContext0, ChannelPromise channelPromise0) {
        DelegatingChannelHandlerContext combinedChannelDuplexHandler$DelegatingChannelHandlerContext0 = this.outboundCtx;
        if(!combinedChannelDuplexHandler$DelegatingChannelHandlerContext0.removed) {
            this.outboundHandler.deregister(combinedChannelDuplexHandler$DelegatingChannelHandlerContext0, channelPromise0);
            return;
        }
        combinedChannelDuplexHandler$DelegatingChannelHandlerContext0.deregister(channelPromise0);
    }

    @Override  // io.netty.channel.ChannelDuplexHandler
    public void disconnect(ChannelHandlerContext channelHandlerContext0, ChannelPromise channelPromise0) {
        DelegatingChannelHandlerContext combinedChannelDuplexHandler$DelegatingChannelHandlerContext0 = this.outboundCtx;
        if(!combinedChannelDuplexHandler$DelegatingChannelHandlerContext0.removed) {
            this.outboundHandler.disconnect(combinedChannelDuplexHandler$DelegatingChannelHandlerContext0, channelPromise0);
            return;
        }
        combinedChannelDuplexHandler$DelegatingChannelHandlerContext0.disconnect(channelPromise0);
    }

    @Override  // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelHandler
    public void exceptionCaught(ChannelHandlerContext channelHandlerContext0, Throwable throwable0) {
        DelegatingChannelHandlerContext combinedChannelDuplexHandler$DelegatingChannelHandlerContext0 = this.inboundCtx;
        if(!combinedChannelDuplexHandler$DelegatingChannelHandlerContext0.removed) {
            this.inboundHandler.exceptionCaught(combinedChannelDuplexHandler$DelegatingChannelHandlerContext0, throwable0);
            return;
        }
        combinedChannelDuplexHandler$DelegatingChannelHandlerContext0.fireExceptionCaught(throwable0);
    }

    @Override  // io.netty.channel.ChannelDuplexHandler
    public void flush(ChannelHandlerContext channelHandlerContext0) {
        DelegatingChannelHandlerContext combinedChannelDuplexHandler$DelegatingChannelHandlerContext0 = this.outboundCtx;
        if(!combinedChannelDuplexHandler$DelegatingChannelHandlerContext0.removed) {
            this.outboundHandler.flush(combinedChannelDuplexHandler$DelegatingChannelHandlerContext0);
            return;
        }
        combinedChannelDuplexHandler$DelegatingChannelHandlerContext0.flush();
    }

    @Override  // io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler
    public void handlerAdded(ChannelHandlerContext channelHandlerContext0) {
        if(this.inboundHandler == null) {
            throw new IllegalStateException("init() must be invoked before being added to a ChannelPipeline if CombinedChannelDuplexHandler was constructed with the default constructor.");
        }
        this.outboundCtx = new DelegatingChannelHandlerContext(channelHandlerContext0, this.outboundHandler);
        this.inboundCtx = new DelegatingChannelHandlerContext(channelHandlerContext0, this.inboundHandler) {
            @Override  // io.netty.channel.CombinedChannelDuplexHandler$DelegatingChannelHandlerContext
            public ChannelHandlerContext fireExceptionCaught(Throwable throwable0) {
                if(!CombinedChannelDuplexHandler.this.outboundCtx.removed) {
                    try {
                        CombinedChannelDuplexHandler.this.outboundHandler.exceptionCaught(CombinedChannelDuplexHandler.this.outboundCtx, throwable0);
                    }
                    catch(Throwable throwable1) {
                        if(CombinedChannelDuplexHandler.logger.isDebugEnabled()) {
                            CombinedChannelDuplexHandler.logger.debug("An exception {}was thrown by a user handler\'s exceptionCaught() method while handling the following exception:", ThrowableUtil.stackTraceToString(throwable1), throwable0);
                            return this;
                        }
                        if(CombinedChannelDuplexHandler.logger.isWarnEnabled()) {
                            CombinedChannelDuplexHandler.logger.warn("An exception \'{}\' [enable DEBUG level for full stacktrace] was thrown by a user handler\'s exceptionCaught() method while handling the following exception:", throwable1, throwable0);
                        }
                    }
                    return this;
                }
                super.fireExceptionCaught(throwable0);
                return this;
            }

            @Override  // io.netty.channel.CombinedChannelDuplexHandler$DelegatingChannelHandlerContext
            public ChannelInboundInvoker fireExceptionCaught(Throwable throwable0) {
                return this.fireExceptionCaught(throwable0);
            }
        };
        this.handlerAdded = true;
        try {
            this.inboundHandler.handlerAdded(this.inboundCtx);
        }
        finally {
            this.outboundHandler.handlerAdded(this.outboundCtx);
        }
    }

    @Override  // io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler
    public void handlerRemoved(ChannelHandlerContext channelHandlerContext0) {
        try {
            this.inboundCtx.remove();
        }
        finally {
            this.outboundCtx.remove();
        }
    }

    public final ChannelInboundHandler inboundHandler() {
        return this.inboundHandler;
    }

    public final void init(ChannelInboundHandler channelInboundHandler0, ChannelOutboundHandler channelOutboundHandler0) {
        this.validate(channelInboundHandler0, channelOutboundHandler0);
        this.inboundHandler = channelInboundHandler0;
        this.outboundHandler = channelOutboundHandler0;
    }

    public final ChannelOutboundHandler outboundHandler() {
        return this.outboundHandler;
    }

    @Override  // io.netty.channel.ChannelDuplexHandler
    public void read(ChannelHandlerContext channelHandlerContext0) {
        DelegatingChannelHandlerContext combinedChannelDuplexHandler$DelegatingChannelHandlerContext0 = this.outboundCtx;
        if(!combinedChannelDuplexHandler$DelegatingChannelHandlerContext0.removed) {
            this.outboundHandler.read(combinedChannelDuplexHandler$DelegatingChannelHandlerContext0);
            return;
        }
        combinedChannelDuplexHandler$DelegatingChannelHandlerContext0.read();
    }

    public final void removeInboundHandler() {
        this.checkAdded();
        this.inboundCtx.remove();
    }

    public final void removeOutboundHandler() {
        this.checkAdded();
        this.outboundCtx.remove();
    }

    @Override  // io.netty.channel.ChannelInboundHandlerAdapter
    public void userEventTriggered(ChannelHandlerContext channelHandlerContext0, Object object0) {
        DelegatingChannelHandlerContext combinedChannelDuplexHandler$DelegatingChannelHandlerContext0 = this.inboundCtx;
        if(!combinedChannelDuplexHandler$DelegatingChannelHandlerContext0.removed) {
            this.inboundHandler.userEventTriggered(combinedChannelDuplexHandler$DelegatingChannelHandlerContext0, object0);
            return;
        }
        combinedChannelDuplexHandler$DelegatingChannelHandlerContext0.fireUserEventTriggered(object0);
    }

    private void validate(ChannelInboundHandler channelInboundHandler0, ChannelOutboundHandler channelOutboundHandler0) {
        if(this.inboundHandler != null) {
            throw new IllegalStateException("init() can not be invoked if CombinedChannelDuplexHandler was constructed with non-default constructor.");
        }
        ObjectUtil.checkNotNull(channelInboundHandler0, "inboundHandler");
        ObjectUtil.checkNotNull(channelOutboundHandler0, "outboundHandler");
        if(channelInboundHandler0 instanceof ChannelOutboundHandler) {
            throw new IllegalArgumentException("inboundHandler must not implement ChannelOutboundHandler to get combined.");
        }
        if(channelOutboundHandler0 instanceof ChannelInboundHandler) {
            throw new IllegalArgumentException("outboundHandler must not implement ChannelInboundHandler to get combined.");
        }
    }

    @Override  // io.netty.channel.ChannelDuplexHandler
    public void write(ChannelHandlerContext channelHandlerContext0, Object object0, ChannelPromise channelPromise0) {
        DelegatingChannelHandlerContext combinedChannelDuplexHandler$DelegatingChannelHandlerContext0 = this.outboundCtx;
        if(!combinedChannelDuplexHandler$DelegatingChannelHandlerContext0.removed) {
            this.outboundHandler.write(combinedChannelDuplexHandler$DelegatingChannelHandlerContext0, object0, channelPromise0);
            return;
        }
        combinedChannelDuplexHandler$DelegatingChannelHandlerContext0.write(object0, channelPromise0);
    }
}

