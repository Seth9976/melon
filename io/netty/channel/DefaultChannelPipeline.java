package io.netty.channel;

import H0.b;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.ResourceLeakDetector;
import io.netty.util.concurrent.EventExecutor;
import io.netty.util.concurrent.EventExecutorGroup;
import io.netty.util.concurrent.FastThreadLocal;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.StringUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.net.SocketAddress;
import java.util.ArrayList;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.WeakHashMap;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

public class DefaultChannelPipeline implements ChannelPipeline {
    final class HeadContext extends AbstractChannelHandlerContext implements ChannelInboundHandler, ChannelOutboundHandler {
        private final Unsafe unsafe;

        public HeadContext(DefaultChannelPipeline defaultChannelPipeline1) {
            super(defaultChannelPipeline1, null, DefaultChannelPipeline.HEAD_NAME, HeadContext.class);
            this.unsafe = defaultChannelPipeline1.channel().unsafe();
            this.setAddComplete();
        }

        @Override  // io.netty.channel.ChannelOutboundHandler
        public void bind(ChannelHandlerContext channelHandlerContext0, SocketAddress socketAddress0, ChannelPromise channelPromise0) {
            this.unsafe.bind(socketAddress0, channelPromise0);
        }

        @Override  // io.netty.channel.ChannelInboundHandler
        public void channelActive(ChannelHandlerContext channelHandlerContext0) {
            channelHandlerContext0.fireChannelActive();
            this.readIfIsAutoRead();
        }

        @Override  // io.netty.channel.ChannelInboundHandler
        public void channelInactive(ChannelHandlerContext channelHandlerContext0) {
            channelHandlerContext0.fireChannelInactive();
        }

        @Override  // io.netty.channel.ChannelInboundHandler
        public void channelRead(ChannelHandlerContext channelHandlerContext0, Object object0) {
            channelHandlerContext0.fireChannelRead(object0);
        }

        @Override  // io.netty.channel.ChannelInboundHandler
        public void channelReadComplete(ChannelHandlerContext channelHandlerContext0) {
            channelHandlerContext0.fireChannelReadComplete();
            this.readIfIsAutoRead();
        }

        @Override  // io.netty.channel.ChannelInboundHandler
        public void channelRegistered(ChannelHandlerContext channelHandlerContext0) {
            DefaultChannelPipeline.this.invokeHandlerAddedIfNeeded();
            channelHandlerContext0.fireChannelRegistered();
        }

        @Override  // io.netty.channel.ChannelInboundHandler
        public void channelUnregistered(ChannelHandlerContext channelHandlerContext0) {
            channelHandlerContext0.fireChannelUnregistered();
            if(!DefaultChannelPipeline.this.channel.isOpen()) {
                DefaultChannelPipeline.this.destroy();
            }
        }

        @Override  // io.netty.channel.ChannelInboundHandler
        public void channelWritabilityChanged(ChannelHandlerContext channelHandlerContext0) {
            channelHandlerContext0.fireChannelWritabilityChanged();
        }

        @Override  // io.netty.channel.ChannelOutboundHandler
        public void close(ChannelHandlerContext channelHandlerContext0, ChannelPromise channelPromise0) {
            this.unsafe.close(channelPromise0);
        }

        @Override  // io.netty.channel.ChannelOutboundHandler
        public void connect(ChannelHandlerContext channelHandlerContext0, SocketAddress socketAddress0, SocketAddress socketAddress1, ChannelPromise channelPromise0) {
            this.unsafe.connect(socketAddress0, socketAddress1, channelPromise0);
        }

        @Override  // io.netty.channel.ChannelOutboundHandler
        public void deregister(ChannelHandlerContext channelHandlerContext0, ChannelPromise channelPromise0) {
            this.unsafe.deregister(channelPromise0);
        }

        @Override  // io.netty.channel.ChannelOutboundHandler
        public void disconnect(ChannelHandlerContext channelHandlerContext0, ChannelPromise channelPromise0) {
            this.unsafe.disconnect(channelPromise0);
        }

        @Override  // io.netty.channel.ChannelInboundHandler, io.netty.channel.ChannelHandler
        public void exceptionCaught(ChannelHandlerContext channelHandlerContext0, Throwable throwable0) {
            channelHandlerContext0.fireExceptionCaught(throwable0);
        }

        @Override  // io.netty.channel.ChannelOutboundHandler
        public void flush(ChannelHandlerContext channelHandlerContext0) {
            this.unsafe.flush();
        }

        @Override  // io.netty.channel.ChannelHandlerContext
        public ChannelHandler handler() {
            return this;
        }

        @Override  // io.netty.channel.ChannelHandler
        public void handlerAdded(ChannelHandlerContext channelHandlerContext0) {
        }

        @Override  // io.netty.channel.ChannelHandler
        public void handlerRemoved(ChannelHandlerContext channelHandlerContext0) {
        }

        @Override  // io.netty.channel.ChannelOutboundHandler
        public void read(ChannelHandlerContext channelHandlerContext0) {
            this.unsafe.beginRead();
        }

        private void readIfIsAutoRead() {
            if(DefaultChannelPipeline.this.channel.config().isAutoRead()) {
                DefaultChannelPipeline.this.channel.read();
            }
        }

        @Override  // io.netty.channel.ChannelInboundHandler
        public void userEventTriggered(ChannelHandlerContext channelHandlerContext0, Object object0) {
            channelHandlerContext0.fireUserEventTriggered(object0);
        }

        @Override  // io.netty.channel.ChannelOutboundHandler
        public void write(ChannelHandlerContext channelHandlerContext0, Object object0, ChannelPromise channelPromise0) {
            this.unsafe.write(object0, channelPromise0);
        }
    }

    final class PendingHandlerAddedTask extends PendingHandlerCallback {
        public PendingHandlerAddedTask(AbstractChannelHandlerContext abstractChannelHandlerContext0) {
            super(abstractChannelHandlerContext0);
        }

        @Override  // io.netty.channel.DefaultChannelPipeline$PendingHandlerCallback
        public void execute() {
            EventExecutor eventExecutor0 = this.ctx.executor();
            if(eventExecutor0.inEventLoop()) {
                DefaultChannelPipeline.this.callHandlerAdded0(this.ctx);
                return;
            }
            try {
                eventExecutor0.execute(this);
            }
            catch(RejectedExecutionException rejectedExecutionException0) {
                if(DefaultChannelPipeline.logger.isWarnEnabled()) {
                    DefaultChannelPipeline.logger.warn("Can\'t invoke handlerAdded() as the EventExecutor {} rejected it, removing handler {}.", new Object[]{eventExecutor0, this.ctx.name(), rejectedExecutionException0});
                }
                DefaultChannelPipeline.this.atomicRemoveFromHandlerList(this.ctx);
                this.ctx.setRemoved();
            }
        }

        @Override
        public void run() {
            DefaultChannelPipeline.this.callHandlerAdded0(this.ctx);
        }
    }

    static abstract class PendingHandlerCallback implements Runnable {
        final AbstractChannelHandlerContext ctx;
        PendingHandlerCallback next;

        public PendingHandlerCallback(AbstractChannelHandlerContext abstractChannelHandlerContext0) {
            this.ctx = abstractChannelHandlerContext0;
        }

        public abstract void execute();
    }

    final class PendingHandlerRemovedTask extends PendingHandlerCallback {
        public PendingHandlerRemovedTask(AbstractChannelHandlerContext abstractChannelHandlerContext0) {
            super(abstractChannelHandlerContext0);
        }

        @Override  // io.netty.channel.DefaultChannelPipeline$PendingHandlerCallback
        public void execute() {
            EventExecutor eventExecutor0 = this.ctx.executor();
            if(eventExecutor0.inEventLoop()) {
                DefaultChannelPipeline.this.callHandlerRemoved0(this.ctx);
                return;
            }
            try {
                eventExecutor0.execute(this);
            }
            catch(RejectedExecutionException rejectedExecutionException0) {
                if(DefaultChannelPipeline.logger.isWarnEnabled()) {
                    DefaultChannelPipeline.logger.warn("Can\'t invoke handlerRemoved() as the EventExecutor {} rejected it, removing handler {}.", new Object[]{eventExecutor0, this.ctx.name(), rejectedExecutionException0});
                }
                this.ctx.setRemoved();
            }
        }

        @Override
        public void run() {
            DefaultChannelPipeline.this.callHandlerRemoved0(this.ctx);
        }
    }

    final class TailContext extends AbstractChannelHandlerContext implements ChannelInboundHandler {
        public TailContext(DefaultChannelPipeline defaultChannelPipeline1) {
            super(defaultChannelPipeline1, null, DefaultChannelPipeline.TAIL_NAME, TailContext.class);
            this.setAddComplete();
        }

        @Override  // io.netty.channel.ChannelInboundHandler
        public void channelActive(ChannelHandlerContext channelHandlerContext0) {
        }

        @Override  // io.netty.channel.ChannelInboundHandler
        public void channelInactive(ChannelHandlerContext channelHandlerContext0) {
        }

        @Override  // io.netty.channel.ChannelInboundHandler
        public void channelRead(ChannelHandlerContext channelHandlerContext0, Object object0) {
            DefaultChannelPipeline.this.onUnhandledInboundMessage(channelHandlerContext0, object0);
        }

        @Override  // io.netty.channel.ChannelInboundHandler
        public void channelReadComplete(ChannelHandlerContext channelHandlerContext0) {
        }

        @Override  // io.netty.channel.ChannelInboundHandler
        public void channelRegistered(ChannelHandlerContext channelHandlerContext0) {
        }

        @Override  // io.netty.channel.ChannelInboundHandler
        public void channelUnregistered(ChannelHandlerContext channelHandlerContext0) {
        }

        @Override  // io.netty.channel.ChannelInboundHandler
        public void channelWritabilityChanged(ChannelHandlerContext channelHandlerContext0) {
        }

        @Override  // io.netty.channel.ChannelInboundHandler
        public void exceptionCaught(ChannelHandlerContext channelHandlerContext0, Throwable throwable0) {
            DefaultChannelPipeline.this.onUnhandledInboundException(throwable0);
        }

        @Override  // io.netty.channel.ChannelHandlerContext
        public ChannelHandler handler() {
            return this;
        }

        @Override  // io.netty.channel.ChannelHandler
        public void handlerAdded(ChannelHandlerContext channelHandlerContext0) {
        }

        @Override  // io.netty.channel.ChannelHandler
        public void handlerRemoved(ChannelHandlerContext channelHandlerContext0) {
        }

        @Override  // io.netty.channel.ChannelInboundHandler
        public void userEventTriggered(ChannelHandlerContext channelHandlerContext0, Object object0) {
            DefaultChannelPipeline.this.onUnhandledInboundUserEventTriggered(object0);
        }
    }

    static final boolean $assertionsDisabled;
    private static final AtomicReferenceFieldUpdater ESTIMATOR;
    private static final String HEAD_NAME;
    private static final String TAIL_NAME;
    private final Channel channel;
    private Map childExecutors;
    private volatile Handle estimatorHandle;
    private boolean firstRegistration;
    final HeadContext head;
    static final InternalLogger logger;
    private static final FastThreadLocal nameCaches;
    private PendingHandlerCallback pendingHandlerCallbackHead;
    private boolean registered;
    private final ChannelFuture succeededFuture;
    final TailContext tail;
    private final boolean touch;
    private final VoidChannelPromise voidPromise;

    static {
        DefaultChannelPipeline.logger = InternalLoggerFactory.getInstance(DefaultChannelPipeline.class);
        DefaultChannelPipeline.HEAD_NAME = "DefaultChannelPipeline$HeadContext#0";
        DefaultChannelPipeline.TAIL_NAME = "DefaultChannelPipeline$TailContext#0";
        DefaultChannelPipeline.nameCaches = new FastThreadLocal() {
            @Override  // io.netty.util.concurrent.FastThreadLocal
            public Object initialValue() {
                return this.initialValue();
            }

            public Map initialValue() {
                return new WeakHashMap();
            }
        };
        DefaultChannelPipeline.ESTIMATOR = AtomicReferenceFieldUpdater.newUpdater(DefaultChannelPipeline.class, Handle.class, "estimatorHandle");
    }

    public DefaultChannelPipeline(Channel channel0) {
        this.touch = ResourceLeakDetector.isEnabled();
        this.firstRegistration = true;
        this.channel = (Channel)ObjectUtil.checkNotNull(channel0, "channel");
        this.succeededFuture = new SucceededChannelFuture(channel0, null);
        this.voidPromise = new VoidChannelPromise(channel0, true);
        TailContext defaultChannelPipeline$TailContext0 = new TailContext(this, this);
        this.tail = defaultChannelPipeline$TailContext0;
        HeadContext defaultChannelPipeline$HeadContext0 = new HeadContext(this, this);
        this.head = defaultChannelPipeline$HeadContext0;
        defaultChannelPipeline$HeadContext0.next = defaultChannelPipeline$TailContext0;
        defaultChannelPipeline$TailContext0.prev = defaultChannelPipeline$HeadContext0;
    }

    @Override  // io.netty.channel.ChannelPipeline
    public final ChannelPipeline addAfter(EventExecutorGroup eventExecutorGroup0, String s, String s1, ChannelHandler channelHandler0) {
        AbstractChannelHandlerContext abstractChannelHandlerContext1;
        synchronized(this) {
            DefaultChannelPipeline.checkMultiplicity(channelHandler0);
            String s2 = this.filterName(s1, channelHandler0);
            AbstractChannelHandlerContext abstractChannelHandlerContext0 = this.getContextOrDie(s);
            abstractChannelHandlerContext1 = this.newContext(eventExecutorGroup0, s2, channelHandler0);
            DefaultChannelPipeline.addAfter0(abstractChannelHandlerContext0, abstractChannelHandlerContext1);
            if(!this.registered) {
                abstractChannelHandlerContext1.setAddPending();
                this.callHandlerCallbackLater(abstractChannelHandlerContext1, true);
                return this;
            }
            EventExecutor eventExecutor0 = abstractChannelHandlerContext1.executor();
            if(!eventExecutor0.inEventLoop()) {
                this.callHandlerAddedInEventLoop(abstractChannelHandlerContext1, eventExecutor0);
                return this;
            }
        }
        this.callHandlerAdded0(abstractChannelHandlerContext1);
        return this;
    }

    @Override  // io.netty.channel.ChannelPipeline
    public final ChannelPipeline addAfter(String s, String s1, ChannelHandler channelHandler0) {
        return this.addAfter(null, s, s1, channelHandler0);
    }

    private static void addAfter0(AbstractChannelHandlerContext abstractChannelHandlerContext0, AbstractChannelHandlerContext abstractChannelHandlerContext1) {
        abstractChannelHandlerContext1.prev = abstractChannelHandlerContext0;
        abstractChannelHandlerContext1.next = abstractChannelHandlerContext0.next;
        abstractChannelHandlerContext0.next.prev = abstractChannelHandlerContext1;
        abstractChannelHandlerContext0.next = abstractChannelHandlerContext1;
    }

    @Override  // io.netty.channel.ChannelPipeline
    public final ChannelPipeline addBefore(EventExecutorGroup eventExecutorGroup0, String s, String s1, ChannelHandler channelHandler0) {
        AbstractChannelHandlerContext abstractChannelHandlerContext1;
        synchronized(this) {
            DefaultChannelPipeline.checkMultiplicity(channelHandler0);
            String s2 = this.filterName(s1, channelHandler0);
            AbstractChannelHandlerContext abstractChannelHandlerContext0 = this.getContextOrDie(s);
            abstractChannelHandlerContext1 = this.newContext(eventExecutorGroup0, s2, channelHandler0);
            DefaultChannelPipeline.addBefore0(abstractChannelHandlerContext0, abstractChannelHandlerContext1);
            if(!this.registered) {
                abstractChannelHandlerContext1.setAddPending();
                this.callHandlerCallbackLater(abstractChannelHandlerContext1, true);
                return this;
            }
            EventExecutor eventExecutor0 = abstractChannelHandlerContext1.executor();
            if(!eventExecutor0.inEventLoop()) {
                this.callHandlerAddedInEventLoop(abstractChannelHandlerContext1, eventExecutor0);
                return this;
            }
        }
        this.callHandlerAdded0(abstractChannelHandlerContext1);
        return this;
    }

    @Override  // io.netty.channel.ChannelPipeline
    public final ChannelPipeline addBefore(String s, String s1, ChannelHandler channelHandler0) {
        return this.addBefore(null, s, s1, channelHandler0);
    }

    private static void addBefore0(AbstractChannelHandlerContext abstractChannelHandlerContext0, AbstractChannelHandlerContext abstractChannelHandlerContext1) {
        abstractChannelHandlerContext1.prev = abstractChannelHandlerContext0.prev;
        abstractChannelHandlerContext1.next = abstractChannelHandlerContext0;
        abstractChannelHandlerContext0.prev.next = abstractChannelHandlerContext1;
        abstractChannelHandlerContext0.prev = abstractChannelHandlerContext1;
    }

    public final ChannelPipeline addFirst(ChannelHandler channelHandler0) {
        return this.addFirst(null, channelHandler0);
    }

    @Override  // io.netty.channel.ChannelPipeline
    public final ChannelPipeline addFirst(EventExecutorGroup eventExecutorGroup0, String s, ChannelHandler channelHandler0) {
        AbstractChannelHandlerContext abstractChannelHandlerContext0;
        synchronized(this) {
            DefaultChannelPipeline.checkMultiplicity(channelHandler0);
            abstractChannelHandlerContext0 = this.newContext(eventExecutorGroup0, this.filterName(s, channelHandler0), channelHandler0);
            this.addFirst0(abstractChannelHandlerContext0);
            if(!this.registered) {
                abstractChannelHandlerContext0.setAddPending();
                this.callHandlerCallbackLater(abstractChannelHandlerContext0, true);
                return this;
            }
            EventExecutor eventExecutor0 = abstractChannelHandlerContext0.executor();
            if(!eventExecutor0.inEventLoop()) {
                this.callHandlerAddedInEventLoop(abstractChannelHandlerContext0, eventExecutor0);
                return this;
            }
        }
        this.callHandlerAdded0(abstractChannelHandlerContext0);
        return this;
    }

    @Override  // io.netty.channel.ChannelPipeline
    public final ChannelPipeline addFirst(EventExecutorGroup eventExecutorGroup0, ChannelHandler[] arr_channelHandler) {
        ObjectUtil.checkNotNull(arr_channelHandler, "handlers");
        if(arr_channelHandler.length != 0 && arr_channelHandler[0] != null) {
            int v;
            for(v = 1; v < arr_channelHandler.length && arr_channelHandler[v] != null; ++v) {
            }
            for(int v1 = v - 1; v1 >= 0; --v1) {
                this.addFirst(eventExecutorGroup0, null, arr_channelHandler[v1]);
            }
        }
        return this;
    }

    @Override  // io.netty.channel.ChannelPipeline
    public final ChannelPipeline addFirst(String s, ChannelHandler channelHandler0) {
        return this.addFirst(null, s, channelHandler0);
    }

    @Override  // io.netty.channel.ChannelPipeline
    public final ChannelPipeline addFirst(ChannelHandler[] arr_channelHandler) {
        return this.addFirst(null, arr_channelHandler);
    }

    private void addFirst0(AbstractChannelHandlerContext abstractChannelHandlerContext0) {
        AbstractChannelHandlerContext abstractChannelHandlerContext1 = this.head.next;
        abstractChannelHandlerContext0.prev = this.head;
        abstractChannelHandlerContext0.next = abstractChannelHandlerContext1;
        this.head.next = abstractChannelHandlerContext0;
        abstractChannelHandlerContext1.prev = abstractChannelHandlerContext0;
    }

    public final ChannelPipeline addLast(ChannelHandler channelHandler0) {
        return this.addLast(null, channelHandler0);
    }

    @Override  // io.netty.channel.ChannelPipeline
    public final ChannelPipeline addLast(EventExecutorGroup eventExecutorGroup0, String s, ChannelHandler channelHandler0) {
        AbstractChannelHandlerContext abstractChannelHandlerContext0;
        synchronized(this) {
            DefaultChannelPipeline.checkMultiplicity(channelHandler0);
            abstractChannelHandlerContext0 = this.newContext(eventExecutorGroup0, this.filterName(s, channelHandler0), channelHandler0);
            this.addLast0(abstractChannelHandlerContext0);
            if(!this.registered) {
                abstractChannelHandlerContext0.setAddPending();
                this.callHandlerCallbackLater(abstractChannelHandlerContext0, true);
                return this;
            }
            EventExecutor eventExecutor0 = abstractChannelHandlerContext0.executor();
            if(!eventExecutor0.inEventLoop()) {
                this.callHandlerAddedInEventLoop(abstractChannelHandlerContext0, eventExecutor0);
                return this;
            }
        }
        this.callHandlerAdded0(abstractChannelHandlerContext0);
        return this;
    }

    @Override  // io.netty.channel.ChannelPipeline
    public final ChannelPipeline addLast(EventExecutorGroup eventExecutorGroup0, ChannelHandler[] arr_channelHandler) {
        ObjectUtil.checkNotNull(arr_channelHandler, "handlers");
        for(int v = 0; v < arr_channelHandler.length; ++v) {
            ChannelHandler channelHandler0 = arr_channelHandler[v];
            if(channelHandler0 == null) {
                break;
            }
            this.addLast(eventExecutorGroup0, null, channelHandler0);
        }
        return this;
    }

    @Override  // io.netty.channel.ChannelPipeline
    public final ChannelPipeline addLast(String s, ChannelHandler channelHandler0) {
        return this.addLast(null, s, channelHandler0);
    }

    @Override  // io.netty.channel.ChannelPipeline
    public final ChannelPipeline addLast(ChannelHandler[] arr_channelHandler) {
        return this.addLast(null, arr_channelHandler);
    }

    private void addLast0(AbstractChannelHandlerContext abstractChannelHandlerContext0) {
        AbstractChannelHandlerContext abstractChannelHandlerContext1 = this.tail.prev;
        abstractChannelHandlerContext0.prev = abstractChannelHandlerContext1;
        abstractChannelHandlerContext0.next = this.tail;
        abstractChannelHandlerContext1.next = abstractChannelHandlerContext0;
        this.tail.prev = abstractChannelHandlerContext0;
    }

    private void atomicRemoveFromHandlerList(AbstractChannelHandlerContext abstractChannelHandlerContext0) {
        synchronized(this) {
            AbstractChannelHandlerContext abstractChannelHandlerContext1 = abstractChannelHandlerContext0.next;
            abstractChannelHandlerContext0.prev.next = abstractChannelHandlerContext1;
            abstractChannelHandlerContext1.prev = abstractChannelHandlerContext0.prev;
        }
    }

    @Override  // io.netty.channel.ChannelOutboundInvoker
    public final ChannelFuture bind(SocketAddress socketAddress0) {
        return this.tail.bind(socketAddress0);
    }

    @Override  // io.netty.channel.ChannelOutboundInvoker
    public final ChannelFuture bind(SocketAddress socketAddress0, ChannelPromise channelPromise0) {
        return this.tail.bind(socketAddress0, channelPromise0);
    }

    // 检测为 Lambda 实现
    private void callHandlerAdded0(AbstractChannelHandlerContext abstractChannelHandlerContext0) [...]

    private void callHandlerAddedForAllHandlers() {
        PendingHandlerCallback defaultChannelPipeline$PendingHandlerCallback0;
        synchronized(this) {
            this.registered = true;
            defaultChannelPipeline$PendingHandlerCallback0 = this.pendingHandlerCallbackHead;
            this.pendingHandlerCallbackHead = null;
        }
        while(defaultChannelPipeline$PendingHandlerCallback0 != null) {
            defaultChannelPipeline$PendingHandlerCallback0.execute();
            defaultChannelPipeline$PendingHandlerCallback0 = defaultChannelPipeline$PendingHandlerCallback0.next;
        }
    }

    private void callHandlerAddedInEventLoop(AbstractChannelHandlerContext abstractChannelHandlerContext0, EventExecutor eventExecutor0) {
        abstractChannelHandlerContext0.setAddPending();
        eventExecutor0.execute(() -> try {
            this.val$newCtx.callHandlerAdded();
        }
        catch(Throwable throwable0) {
            try {
                DefaultChannelPipeline.this.atomicRemoveFromHandlerList(this.val$newCtx);
                this.val$newCtx.callHandlerRemoved();
            }
            catch(Throwable throwable1) {
                InternalLogger internalLogger0 = DefaultChannelPipeline.logger;
                if(internalLogger0.isWarnEnabled()) {
                    internalLogger0.warn("Failed to remove a handler: " + this.val$newCtx.name(), throwable1);
                }
                DefaultChannelPipeline.this.fireExceptionCaught(new ChannelPipelineException(this.val$newCtx.handler().getClass().getName() + ".handlerAdded() has thrown an exception; also failed to remove.", throwable0));
                return;
            }
            DefaultChannelPipeline.this.fireExceptionCaught(new ChannelPipelineException(this.val$newCtx.handler().getClass().getName() + ".handlerAdded() has thrown an exception; removed.", throwable0));
        });

        class io.netty.channel.DefaultChannelPipeline.6 implements Runnable {
            public io.netty.channel.DefaultChannelPipeline.6(AbstractChannelHandlerContext abstractChannelHandlerContext0) {
            }

            @Override
            public void run() {
                DefaultChannelPipeline.this.callHandlerAdded0(this.val$newCtx);
            }
        }

    }

    private void callHandlerCallbackLater(AbstractChannelHandlerContext abstractChannelHandlerContext0, boolean z) {
        PendingHandlerAddedTask defaultChannelPipeline$PendingHandlerAddedTask0 = z ? new PendingHandlerAddedTask(this, abstractChannelHandlerContext0) : new PendingHandlerRemovedTask(this, abstractChannelHandlerContext0);
        PendingHandlerCallback defaultChannelPipeline$PendingHandlerCallback0 = this.pendingHandlerCallbackHead;
        if(defaultChannelPipeline$PendingHandlerCallback0 == null) {
            this.pendingHandlerCallbackHead = defaultChannelPipeline$PendingHandlerAddedTask0;
            return;
        }
        PendingHandlerCallback defaultChannelPipeline$PendingHandlerCallback1;
        while((defaultChannelPipeline$PendingHandlerCallback1 = defaultChannelPipeline$PendingHandlerCallback0.next) != null) {
            defaultChannelPipeline$PendingHandlerCallback0 = defaultChannelPipeline$PendingHandlerCallback1;
        }
        defaultChannelPipeline$PendingHandlerCallback0.next = defaultChannelPipeline$PendingHandlerAddedTask0;
    }

    // 检测为 Lambda 实现
    private void callHandlerRemoved0(AbstractChannelHandlerContext abstractChannelHandlerContext0) [...]

    @Override  // io.netty.channel.ChannelPipeline
    public final Channel channel() {
        return this.channel;
    }

    private void checkDuplicateName(String s) {
        if(this.context0(s) != null) {
            throw new IllegalArgumentException("Duplicate handler name: " + s);
        }
    }

    private static void checkMultiplicity(ChannelHandler channelHandler0) {
        if(channelHandler0 instanceof ChannelHandlerAdapter) {
            if(!((ChannelHandlerAdapter)channelHandler0).isSharable() && ((ChannelHandlerAdapter)channelHandler0).added) {
                throw new ChannelPipelineException(((ChannelHandlerAdapter)channelHandler0).getClass().getName() + " is not a @Sharable handler, so can\'t be added or removed multiple times.");
            }
            ((ChannelHandlerAdapter)channelHandler0).added = true;
        }
    }

    private EventExecutor childExecutor(EventExecutorGroup eventExecutorGroup0) {
        if(eventExecutorGroup0 == null) {
            return null;
        }
        Boolean boolean0 = (Boolean)this.channel.config().getOption(ChannelOption.SINGLE_EVENTEXECUTOR_PER_GROUP);
        if(boolean0 != null && !boolean0.booleanValue()) {
            return eventExecutorGroup0.next();
        }
        Map map0 = this.childExecutors;
        if(map0 == null) {
            map0 = new IdentityHashMap(4);
            this.childExecutors = map0;
        }
        EventExecutor eventExecutor0 = (EventExecutor)map0.get(eventExecutorGroup0);
        if(eventExecutor0 == null) {
            eventExecutor0 = eventExecutorGroup0.next();
            map0.put(eventExecutorGroup0, eventExecutor0);
        }
        return eventExecutor0;
    }

    @Override  // io.netty.channel.ChannelOutboundInvoker
    public final ChannelFuture close() {
        return this.tail.close();
    }

    @Override  // io.netty.channel.ChannelOutboundInvoker
    public final ChannelFuture close(ChannelPromise channelPromise0) {
        return this.tail.close(channelPromise0);
    }

    @Override  // io.netty.channel.ChannelOutboundInvoker
    public final ChannelFuture connect(SocketAddress socketAddress0) {
        return this.tail.connect(socketAddress0);
    }

    @Override  // io.netty.channel.ChannelOutboundInvoker
    public final ChannelFuture connect(SocketAddress socketAddress0, ChannelPromise channelPromise0) {
        return this.tail.connect(socketAddress0, channelPromise0);
    }

    @Override  // io.netty.channel.ChannelOutboundInvoker
    public final ChannelFuture connect(SocketAddress socketAddress0, SocketAddress socketAddress1) {
        return this.tail.connect(socketAddress0, socketAddress1);
    }

    @Override  // io.netty.channel.ChannelOutboundInvoker
    public final ChannelFuture connect(SocketAddress socketAddress0, SocketAddress socketAddress1, ChannelPromise channelPromise0) {
        return this.tail.connect(socketAddress0, socketAddress1, channelPromise0);
    }

    @Override  // io.netty.channel.ChannelPipeline
    public final ChannelHandlerContext context(ChannelHandler channelHandler0) {
        ObjectUtil.checkNotNull(channelHandler0, "handler");
        for(ChannelHandlerContext channelHandlerContext0 = this.head.next; true; channelHandlerContext0 = channelHandlerContext0.next) {
            if(channelHandlerContext0 == null) {
                return null;
            }
            if(channelHandlerContext0.handler() == channelHandler0) {
                return channelHandlerContext0;
            }
        }
    }

    @Override  // io.netty.channel.ChannelPipeline
    public final ChannelHandlerContext context(Class class0) {
        ObjectUtil.checkNotNull(class0, "handlerType");
        for(ChannelHandlerContext channelHandlerContext0 = this.head.next; true; channelHandlerContext0 = channelHandlerContext0.next) {
            if(channelHandlerContext0 == null) {
                return null;
            }
            if(class0.isAssignableFrom(channelHandlerContext0.handler().getClass())) {
                return channelHandlerContext0;
            }
        }
    }

    @Override  // io.netty.channel.ChannelPipeline
    public final ChannelHandlerContext context(String s) {
        return this.context0(((String)ObjectUtil.checkNotNull(s, "name")));
    }

    private AbstractChannelHandlerContext context0(String s) {
        for(AbstractChannelHandlerContext abstractChannelHandlerContext0 = this.head.next; abstractChannelHandlerContext0 != this.tail; abstractChannelHandlerContext0 = abstractChannelHandlerContext0.next) {
            if(abstractChannelHandlerContext0.name().equals(s)) {
                return abstractChannelHandlerContext0;
            }
        }
        return null;
    }

    public void decrementPendingOutboundBytes(long v) {
        ChannelOutboundBuffer channelOutboundBuffer0 = this.channel.unsafe().outboundBuffer();
        if(channelOutboundBuffer0 != null) {
            channelOutboundBuffer0.decrementPendingOutboundBytes(v);
        }
    }

    @Override  // io.netty.channel.ChannelOutboundInvoker
    public final ChannelFuture deregister() {
        return this.tail.deregister();
    }

    @Override  // io.netty.channel.ChannelOutboundInvoker
    public final ChannelFuture deregister(ChannelPromise channelPromise0) {
        return this.tail.deregister(channelPromise0);
    }

    private void destroy() {
        synchronized(this) {
            this.destroyUp(this.head.next, false);
        }
    }

    // 检测为 Lambda 实现
    private void destroyDown(Thread thread0, AbstractChannelHandlerContext abstractChannelHandlerContext0, boolean z) [...]

    // 检测为 Lambda 实现
    private void destroyUp(AbstractChannelHandlerContext abstractChannelHandlerContext0, boolean z) [...]

    @Override  // io.netty.channel.ChannelOutboundInvoker
    public final ChannelFuture disconnect() {
        return this.tail.disconnect();
    }

    @Override  // io.netty.channel.ChannelOutboundInvoker
    public final ChannelFuture disconnect(ChannelPromise channelPromise0) {
        return this.tail.disconnect(channelPromise0);
    }

    public final Handle estimatorHandle() {
        Handle messageSizeEstimator$Handle0 = this.estimatorHandle;
        if(messageSizeEstimator$Handle0 == null) {
            Handle messageSizeEstimator$Handle1 = this.channel.config().getMessageSizeEstimator().newHandle();
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater0 = DefaultChannelPipeline.ESTIMATOR;
            do {
                if(atomicReferenceFieldUpdater0.compareAndSet(this, null, messageSizeEstimator$Handle1)) {
                    return messageSizeEstimator$Handle1;
                }
            }
            while(atomicReferenceFieldUpdater0.get(this) == null);
            return this.estimatorHandle;
        }
        return messageSizeEstimator$Handle0;
    }

    private String filterName(String s, ChannelHandler channelHandler0) {
        if(s == null) {
            return this.generateName(channelHandler0);
        }
        this.checkDuplicateName(s);
        return s;
    }

    @Override  // io.netty.channel.ChannelInboundInvoker
    public ChannelInboundInvoker fireChannelActive() {
        return this.fireChannelActive();
    }

    @Override  // io.netty.channel.ChannelPipeline
    public final ChannelPipeline fireChannelActive() {
        AbstractChannelHandlerContext.invokeChannelActive(this.head);
        return this;
    }

    @Override  // io.netty.channel.ChannelInboundInvoker
    public ChannelInboundInvoker fireChannelInactive() {
        return this.fireChannelInactive();
    }

    @Override  // io.netty.channel.ChannelPipeline
    public final ChannelPipeline fireChannelInactive() {
        AbstractChannelHandlerContext.invokeChannelInactive(this.head);
        return this;
    }

    @Override  // io.netty.channel.ChannelInboundInvoker
    public ChannelInboundInvoker fireChannelRead(Object object0) {
        return this.fireChannelRead(object0);
    }

    @Override  // io.netty.channel.ChannelPipeline
    public final ChannelPipeline fireChannelRead(Object object0) {
        AbstractChannelHandlerContext.invokeChannelRead(this.head, object0);
        return this;
    }

    @Override  // io.netty.channel.ChannelInboundInvoker
    public ChannelInboundInvoker fireChannelReadComplete() {
        return this.fireChannelReadComplete();
    }

    @Override  // io.netty.channel.ChannelPipeline
    public final ChannelPipeline fireChannelReadComplete() {
        AbstractChannelHandlerContext.invokeChannelReadComplete(this.head);
        return this;
    }

    @Override  // io.netty.channel.ChannelInboundInvoker
    public ChannelInboundInvoker fireChannelRegistered() {
        return this.fireChannelRegistered();
    }

    @Override  // io.netty.channel.ChannelPipeline
    public final ChannelPipeline fireChannelRegistered() {
        AbstractChannelHandlerContext.invokeChannelRegistered(this.head);
        return this;
    }

    @Override  // io.netty.channel.ChannelInboundInvoker
    public ChannelInboundInvoker fireChannelUnregistered() {
        return this.fireChannelUnregistered();
    }

    @Override  // io.netty.channel.ChannelPipeline
    public final ChannelPipeline fireChannelUnregistered() {
        AbstractChannelHandlerContext.invokeChannelUnregistered(this.head);
        return this;
    }

    @Override  // io.netty.channel.ChannelInboundInvoker
    public ChannelInboundInvoker fireChannelWritabilityChanged() {
        return this.fireChannelWritabilityChanged();
    }

    @Override  // io.netty.channel.ChannelPipeline
    public final ChannelPipeline fireChannelWritabilityChanged() {
        AbstractChannelHandlerContext.invokeChannelWritabilityChanged(this.head);
        return this;
    }

    @Override  // io.netty.channel.ChannelInboundInvoker
    public ChannelInboundInvoker fireExceptionCaught(Throwable throwable0) {
        return this.fireExceptionCaught(throwable0);
    }

    @Override  // io.netty.channel.ChannelPipeline
    public final ChannelPipeline fireExceptionCaught(Throwable throwable0) {
        AbstractChannelHandlerContext.invokeExceptionCaught(this.head, throwable0);
        return this;
    }

    @Override  // io.netty.channel.ChannelInboundInvoker
    public ChannelInboundInvoker fireUserEventTriggered(Object object0) {
        return this.fireUserEventTriggered(object0);
    }

    @Override  // io.netty.channel.ChannelPipeline
    public final ChannelPipeline fireUserEventTriggered(Object object0) {
        AbstractChannelHandlerContext.invokeUserEventTriggered(this.head, object0);
        return this;
    }

    @Override  // io.netty.channel.ChannelPipeline
    public final ChannelHandler first() {
        ChannelHandlerContext channelHandlerContext0 = this.firstContext();
        return channelHandlerContext0 == null ? null : channelHandlerContext0.handler();
    }

    @Override  // io.netty.channel.ChannelPipeline
    public final ChannelHandlerContext firstContext() {
        return this.head.next == this.tail ? null : this.head.next;
    }

    @Override  // io.netty.channel.ChannelOutboundInvoker
    public ChannelOutboundInvoker flush() {
        return this.flush();
    }

    @Override  // io.netty.channel.ChannelPipeline
    public final ChannelPipeline flush() {
        this.tail.flush();
        return this;
    }

    private String generateName(ChannelHandler channelHandler0) {
        String s2;
        Map map0 = (Map)DefaultChannelPipeline.nameCaches.get();
        Class class0 = channelHandler0.getClass();
        String s = (String)map0.get(class0);
        if(s == null) {
            s = DefaultChannelPipeline.generateName0(class0);
            map0.put(class0, s);
        }
        if(this.context0(s) != null) {
            String s1 = b.d(1, 0, s);
            for(int v = 1; true; ++v) {
                s2 = s1 + v;
                if(this.context0(s2) == null) {
                    break;
                }
            }
            return s2;
        }
        return s;
    }

    private static String generateName0(Class class0) [...] // 潜在的解密器

    @Override  // io.netty.channel.ChannelPipeline
    public final ChannelHandler get(Class class0) {
        ChannelHandlerContext channelHandlerContext0 = this.context(class0);
        return channelHandlerContext0 == null ? null : channelHandlerContext0.handler();
    }

    @Override  // io.netty.channel.ChannelPipeline
    public final ChannelHandler get(String s) {
        ChannelHandlerContext channelHandlerContext0 = this.context(s);
        return channelHandlerContext0 == null ? null : channelHandlerContext0.handler();
    }

    private AbstractChannelHandlerContext getContextOrDie(ChannelHandler channelHandler0) {
        AbstractChannelHandlerContext abstractChannelHandlerContext0 = (AbstractChannelHandlerContext)this.context(channelHandler0);
        if(abstractChannelHandlerContext0 == null) {
            throw new NoSuchElementException(channelHandler0.getClass().getName());
        }
        return abstractChannelHandlerContext0;
    }

    private AbstractChannelHandlerContext getContextOrDie(Class class0) {
        AbstractChannelHandlerContext abstractChannelHandlerContext0 = (AbstractChannelHandlerContext)this.context(class0);
        if(abstractChannelHandlerContext0 == null) {
            throw new NoSuchElementException(class0.getName());
        }
        return abstractChannelHandlerContext0;
    }

    private AbstractChannelHandlerContext getContextOrDie(String s) {
        AbstractChannelHandlerContext abstractChannelHandlerContext0 = (AbstractChannelHandlerContext)this.context(s);
        if(abstractChannelHandlerContext0 == null) {
            throw new NoSuchElementException(s);
        }
        return abstractChannelHandlerContext0;
    }

    public void incrementPendingOutboundBytes(long v) {
        ChannelOutboundBuffer channelOutboundBuffer0 = this.channel.unsafe().outboundBuffer();
        if(channelOutboundBuffer0 != null) {
            channelOutboundBuffer0.incrementPendingOutboundBytes(v);
        }
    }

    public final void invokeHandlerAddedIfNeeded() {
        if(this.firstRegistration) {
            this.firstRegistration = false;
            this.callHandlerAddedForAllHandlers();
        }
    }

    @Override
    public final Iterator iterator() {
        return this.toMap().entrySet().iterator();
    }

    @Override  // io.netty.channel.ChannelPipeline
    public final ChannelHandler last() {
        AbstractChannelHandlerContext abstractChannelHandlerContext0 = this.tail.prev;
        return abstractChannelHandlerContext0 == this.head ? null : abstractChannelHandlerContext0.handler();
    }

    @Override  // io.netty.channel.ChannelPipeline
    public final ChannelHandlerContext lastContext() {
        ChannelHandlerContext channelHandlerContext0 = this.tail.prev;
        return channelHandlerContext0 == this.head ? null : channelHandlerContext0;
    }

    @Override  // io.netty.channel.ChannelPipeline
    public final List names() {
        List list0 = new ArrayList();
        for(AbstractChannelHandlerContext abstractChannelHandlerContext0 = this.head.next; abstractChannelHandlerContext0 != null; abstractChannelHandlerContext0 = abstractChannelHandlerContext0.next) {
            ((ArrayList)list0).add(abstractChannelHandlerContext0.name());
        }
        return list0;
    }

    private AbstractChannelHandlerContext newContext(EventExecutorGroup eventExecutorGroup0, String s, ChannelHandler channelHandler0) {
        return new DefaultChannelHandlerContext(this, this.childExecutor(eventExecutorGroup0), s, channelHandler0);
    }

    @Override  // io.netty.channel.ChannelOutboundInvoker
    public final ChannelFuture newFailedFuture(Throwable throwable0) {
        return new FailedChannelFuture(this.channel, null, throwable0);
    }

    @Override  // io.netty.channel.ChannelOutboundInvoker
    public final ChannelProgressivePromise newProgressivePromise() {
        return new DefaultChannelProgressivePromise(this.channel);
    }

    @Override  // io.netty.channel.ChannelOutboundInvoker
    public final ChannelPromise newPromise() {
        return new DefaultChannelPromise(this.channel);
    }

    @Override  // io.netty.channel.ChannelOutboundInvoker
    public final ChannelFuture newSucceededFuture() {
        return this.succeededFuture;
    }

    public void onUnhandledChannelWritabilityChanged() {
    }

    public void onUnhandledInboundChannelActive() {
    }

    public void onUnhandledInboundChannelInactive() {
    }

    public void onUnhandledInboundChannelReadComplete() {
    }

    public void onUnhandledInboundException(Throwable throwable0) {
        try {
            DefaultChannelPipeline.logger.warn("An exceptionCaught() event was fired, and it reached at the tail of the pipeline. It usually means the last handler in the pipeline did not handle the exception.", throwable0);
        }
        finally {
            ReferenceCountUtil.release(throwable0);
        }
    }

    public void onUnhandledInboundMessage(ChannelHandlerContext channelHandlerContext0, Object object0) {
        this.onUnhandledInboundMessage(object0);
        InternalLogger internalLogger0 = DefaultChannelPipeline.logger;
        if(internalLogger0.isDebugEnabled()) {
            internalLogger0.debug("Discarded message pipeline : {}. Channel : {}.", channelHandlerContext0.pipeline().names(), channelHandlerContext0.channel());
        }
    }

    public void onUnhandledInboundMessage(Object object0) {
        try {
            DefaultChannelPipeline.logger.debug("Discarded inbound message {} that reached at the tail of the pipeline. Please check your pipeline configuration.", object0);
        }
        finally {
            ReferenceCountUtil.release(object0);
        }
    }

    public void onUnhandledInboundUserEventTriggered(Object object0) {
        ReferenceCountUtil.release(object0);
    }

    @Override  // io.netty.channel.ChannelOutboundInvoker
    public ChannelOutboundInvoker read() {
        return this.read();
    }

    public final ChannelPipeline read() {
        this.tail.read();
        return this;
    }

    private AbstractChannelHandlerContext remove(AbstractChannelHandlerContext abstractChannelHandlerContext0) {
        synchronized(this) {
            this.atomicRemoveFromHandlerList(abstractChannelHandlerContext0);
            if(!this.registered) {
                this.callHandlerCallbackLater(abstractChannelHandlerContext0, false);
                return abstractChannelHandlerContext0;
            }
            EventExecutor eventExecutor0 = abstractChannelHandlerContext0.executor();
            if(!eventExecutor0.inEventLoop()) {
                eventExecutor0.execute(() -> try {
                    this.val$ctx.callHandlerRemoved();
                }
                catch(Throwable throwable0) {
                    DefaultChannelPipeline.this.fireExceptionCaught(new ChannelPipelineException(this.val$ctx.handler().getClass().getName() + ".handlerRemoved() has thrown an exception.", throwable0));
                });
                return abstractChannelHandlerContext0;
            }
        }
        this.callHandlerRemoved0(abstractChannelHandlerContext0);
        return abstractChannelHandlerContext0;

        class io.netty.channel.DefaultChannelPipeline.2 implements Runnable {
            public io.netty.channel.DefaultChannelPipeline.2(AbstractChannelHandlerContext abstractChannelHandlerContext0) {
            }

            @Override
            public void run() {
                DefaultChannelPipeline.this.callHandlerRemoved0(this.val$ctx);
            }
        }

    }

    @Override  // io.netty.channel.ChannelPipeline
    public final ChannelHandler remove(Class class0) {
        return this.remove(this.getContextOrDie(class0)).handler();
    }

    @Override  // io.netty.channel.ChannelPipeline
    public final ChannelHandler remove(String s) {
        return this.remove(this.getContextOrDie(s)).handler();
    }

    @Override  // io.netty.channel.ChannelPipeline
    public final ChannelPipeline remove(ChannelHandler channelHandler0) {
        this.remove(this.getContextOrDie(channelHandler0));
        return this;
    }

    @Override  // io.netty.channel.ChannelPipeline
    public final ChannelHandler removeFirst() {
        if(this.head.next == this.tail) {
            throw new NoSuchElementException();
        }
        return this.remove(this.head.next).handler();
    }

    private ChannelHandler removeIfExists(ChannelHandlerContext channelHandlerContext0) {
        return channelHandlerContext0 == null ? null : this.remove(((AbstractChannelHandlerContext)channelHandlerContext0)).handler();
    }

    public final ChannelHandler removeIfExists(ChannelHandler channelHandler0) {
        return this.removeIfExists(this.context(channelHandler0));
    }

    public final ChannelHandler removeIfExists(Class class0) {
        return this.removeIfExists(this.context(class0));
    }

    public final ChannelHandler removeIfExists(String s) {
        return this.removeIfExists(this.context(s));
    }

    @Override  // io.netty.channel.ChannelPipeline
    public final ChannelHandler removeLast() {
        TailContext defaultChannelPipeline$TailContext0 = this.tail;
        if(this.head.next == defaultChannelPipeline$TailContext0) {
            throw new NoSuchElementException();
        }
        return this.remove(defaultChannelPipeline$TailContext0.prev).handler();
    }

    private ChannelHandler replace(AbstractChannelHandlerContext abstractChannelHandlerContext0, String s, ChannelHandler channelHandler0) {
        AbstractChannelHandlerContext abstractChannelHandlerContext1;
        synchronized(this) {
            DefaultChannelPipeline.checkMultiplicity(channelHandler0);
            if(s == null) {
                s = this.generateName(channelHandler0);
            }
            else if(!abstractChannelHandlerContext0.name().equals(s)) {
                this.checkDuplicateName(s);
            }
            abstractChannelHandlerContext1 = this.newContext(abstractChannelHandlerContext0.executor, s, channelHandler0);
            DefaultChannelPipeline.replace0(abstractChannelHandlerContext0, abstractChannelHandlerContext1);
            if(!this.registered) {
                this.callHandlerCallbackLater(abstractChannelHandlerContext1, true);
                this.callHandlerCallbackLater(abstractChannelHandlerContext0, false);
                return abstractChannelHandlerContext0.handler();
            }
            EventExecutor eventExecutor0 = abstractChannelHandlerContext0.executor();
            if(!eventExecutor0.inEventLoop()) {
                eventExecutor0.execute(new Runnable() {
                    @Override
                    public void run() {
                        DefaultChannelPipeline.this.callHandlerAdded0(abstractChannelHandlerContext1);
                        DefaultChannelPipeline.this.callHandlerRemoved0(abstractChannelHandlerContext0);
                    }
                });
                return abstractChannelHandlerContext0.handler();
            }
        }
        this.callHandlerAdded0(abstractChannelHandlerContext1);
        this.callHandlerRemoved0(abstractChannelHandlerContext0);
        return abstractChannelHandlerContext0.handler();
    }

    @Override  // io.netty.channel.ChannelPipeline
    public final ChannelHandler replace(Class class0, String s, ChannelHandler channelHandler0) {
        return this.replace(this.getContextOrDie(class0), s, channelHandler0);
    }

    @Override  // io.netty.channel.ChannelPipeline
    public final ChannelHandler replace(String s, String s1, ChannelHandler channelHandler0) {
        return this.replace(this.getContextOrDie(s), s1, channelHandler0);
    }

    @Override  // io.netty.channel.ChannelPipeline
    public final ChannelPipeline replace(ChannelHandler channelHandler0, String s, ChannelHandler channelHandler1) {
        this.replace(this.getContextOrDie(channelHandler0), s, channelHandler1);
        return this;
    }

    private static void replace0(AbstractChannelHandlerContext abstractChannelHandlerContext0, AbstractChannelHandlerContext abstractChannelHandlerContext1) {
        AbstractChannelHandlerContext abstractChannelHandlerContext2 = abstractChannelHandlerContext0.prev;
        AbstractChannelHandlerContext abstractChannelHandlerContext3 = abstractChannelHandlerContext0.next;
        abstractChannelHandlerContext1.prev = abstractChannelHandlerContext2;
        abstractChannelHandlerContext1.next = abstractChannelHandlerContext3;
        abstractChannelHandlerContext2.next = abstractChannelHandlerContext1;
        abstractChannelHandlerContext3.prev = abstractChannelHandlerContext1;
        abstractChannelHandlerContext0.prev = abstractChannelHandlerContext1;
        abstractChannelHandlerContext0.next = abstractChannelHandlerContext1;
    }

    @Override  // io.netty.channel.ChannelPipeline
    public final Map toMap() {
        Map map0 = new LinkedHashMap();
        for(AbstractChannelHandlerContext abstractChannelHandlerContext0 = this.head.next; abstractChannelHandlerContext0 != this.tail; abstractChannelHandlerContext0 = abstractChannelHandlerContext0.next) {
            map0.put(abstractChannelHandlerContext0.name(), abstractChannelHandlerContext0.handler());
        }
        return map0;
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = new StringBuilder();
        stringBuilder0.append(StringUtil.simpleClassName(this));
        stringBuilder0.append('{');
        AbstractChannelHandlerContext abstractChannelHandlerContext0 = this.head.next;
        while(abstractChannelHandlerContext0 != this.tail) {
            stringBuilder0.append('(');
            stringBuilder0.append(abstractChannelHandlerContext0.name());
            stringBuilder0.append(" = ");
            stringBuilder0.append(abstractChannelHandlerContext0.handler().getClass().getName());
            stringBuilder0.append(')');
            abstractChannelHandlerContext0 = abstractChannelHandlerContext0.next;
            if(abstractChannelHandlerContext0 == this.tail) {
                break;
            }
            stringBuilder0.append(", ");
        }
        stringBuilder0.append('}');
        return stringBuilder0.toString();
    }

    // 去混淆评级： 低(20)
    public final Object touch(Object object0, AbstractChannelHandlerContext abstractChannelHandlerContext0) {
        return this.touch ? ReferenceCountUtil.touch(object0, abstractChannelHandlerContext0) : object0;
    }

    @Override  // io.netty.channel.ChannelOutboundInvoker
    public final ChannelPromise voidPromise() {
        return this.voidPromise;
    }

    @Override  // io.netty.channel.ChannelOutboundInvoker
    public final ChannelFuture write(Object object0) {
        return this.tail.write(object0);
    }

    @Override  // io.netty.channel.ChannelOutboundInvoker
    public final ChannelFuture write(Object object0, ChannelPromise channelPromise0) {
        return this.tail.write(object0, channelPromise0);
    }

    @Override  // io.netty.channel.ChannelOutboundInvoker
    public final ChannelFuture writeAndFlush(Object object0) {
        return this.tail.writeAndFlush(object0);
    }

    @Override  // io.netty.channel.ChannelOutboundInvoker
    public final ChannelFuture writeAndFlush(Object object0, ChannelPromise channelPromise0) {
        return this.tail.writeAndFlush(object0, channelPromise0);
    }
}

