package io.netty.channel;

import U4.x;
import io.netty.buffer.ByteBufAllocator;
import io.netty.util.Attribute;
import io.netty.util.AttributeKey;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.ResourceLeakHint;
import io.netty.util.concurrent.AbstractEventExecutor;
import io.netty.util.concurrent.EventExecutor;
import io.netty.util.concurrent.OrderedEventExecutor;
import io.netty.util.internal.ObjectPool.Handle;
import io.netty.util.internal.ObjectPool.ObjectCreator;
import io.netty.util.internal.ObjectPool;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PromiseNotificationUtil;
import io.netty.util.internal.SystemPropertyUtil;
import io.netty.util.internal.ThrowableUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.net.SocketAddress;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

abstract class AbstractChannelHandlerContext implements ChannelHandlerContext, ResourceLeakHint {
    static final class Tasks {
        private final Runnable invokeChannelReadCompleteTask;
        private final Runnable invokeChannelWritableStateChangedTask;
        private final Runnable invokeFlushTask;
        private final Runnable invokeReadTask;
        private final AbstractChannelHandlerContext next;

        public Tasks(AbstractChannelHandlerContext abstractChannelHandlerContext0) {
            this.invokeChannelReadCompleteTask = new Runnable() {
                @Override
                public void run() {
                    Tasks.this.next.invokeChannelReadComplete();
                }
            };
            this.invokeReadTask = new Runnable() {
                @Override
                public void run() {
                    Tasks.this.next.invokeRead();
                }
            };
            this.invokeChannelWritableStateChangedTask = new Runnable() {
                @Override
                public void run() {
                    Tasks.this.next.invokeChannelWritabilityChanged();
                }
            };
            this.invokeFlushTask = new Runnable() {
                @Override
                public void run() {
                    Tasks.this.next.invokeFlush();
                }
            };
            this.next = abstractChannelHandlerContext0;
        }

        public static Runnable access$1400(Tasks abstractChannelHandlerContext$Tasks0) {
            return abstractChannelHandlerContext$Tasks0.invokeReadTask;
        }

        public static Runnable access$1500(Tasks abstractChannelHandlerContext$Tasks0) {
            return abstractChannelHandlerContext$Tasks0.invokeFlushTask;
        }

        public static Runnable access$700(Tasks abstractChannelHandlerContext$Tasks0) {
            return abstractChannelHandlerContext$Tasks0.invokeChannelReadCompleteTask;
        }

        public static Runnable access$800(Tasks abstractChannelHandlerContext$Tasks0) {
            return abstractChannelHandlerContext$Tasks0.invokeChannelWritableStateChangedTask;
        }
    }

    static final class WriteTask implements Runnable {
        private static final boolean ESTIMATE_TASK_SIZE_ON_SUBMIT;
        private static final ObjectPool RECYCLER;
        private static final int WRITE_TASK_OVERHEAD;
        private AbstractChannelHandlerContext ctx;
        private final Handle handle;
        private Object msg;
        private ChannelPromise promise;
        private int size;

        static {
            WriteTask.RECYCLER = ObjectPool.newPool(new ObjectCreator() {
                public WriteTask newObject(Handle objectPool$Handle0) {
                    return new WriteTask(objectPool$Handle0, null);
                }

                @Override  // io.netty.util.internal.ObjectPool$ObjectCreator
                public Object newObject(Handle objectPool$Handle0) {
                    return this.newObject(objectPool$Handle0);
                }
            });
            WriteTask.ESTIMATE_TASK_SIZE_ON_SUBMIT = SystemPropertyUtil.getBoolean("io.netty.transport.estimateSizeOnSubmit", true);
            WriteTask.WRITE_TASK_OVERHEAD = SystemPropertyUtil.getInt("io.netty.transport.writeTaskSizeOverhead", 0x20);
        }

        private WriteTask(Handle objectPool$Handle0) {
            this.handle = objectPool$Handle0;
        }

        public WriteTask(Handle objectPool$Handle0, io.netty.channel.AbstractChannelHandlerContext.1 abstractChannelHandlerContext$10) {
            this(objectPool$Handle0);
        }

        public void cancel() {
            try {
                this.decrementPendingOutboundBytes();
            }
            finally {
                this.recycle();
            }
        }

        private void decrementPendingOutboundBytes() {
            if(WriteTask.ESTIMATE_TASK_SIZE_ON_SUBMIT) {
                this.ctx.pipeline.decrementPendingOutboundBytes(((long)(this.size & 0x7FFFFFFF)));
            }
        }

        public static void init(WriteTask abstractChannelHandlerContext$WriteTask0, AbstractChannelHandlerContext abstractChannelHandlerContext0, Object object0, ChannelPromise channelPromise0, boolean z) {
            abstractChannelHandlerContext$WriteTask0.ctx = abstractChannelHandlerContext0;
            abstractChannelHandlerContext$WriteTask0.msg = object0;
            abstractChannelHandlerContext$WriteTask0.promise = channelPromise0;
            if(WriteTask.ESTIMATE_TASK_SIZE_ON_SUBMIT) {
                abstractChannelHandlerContext$WriteTask0.size = abstractChannelHandlerContext0.pipeline.estimatorHandle().size(object0) + WriteTask.WRITE_TASK_OVERHEAD;
                abstractChannelHandlerContext0.pipeline.incrementPendingOutboundBytes(((long)abstractChannelHandlerContext$WriteTask0.size));
            }
            else {
                abstractChannelHandlerContext$WriteTask0.size = 0;
            }
            if(z) {
                abstractChannelHandlerContext$WriteTask0.size |= 0x80000000;
            }
        }

        public static WriteTask newInstance(AbstractChannelHandlerContext abstractChannelHandlerContext0, Object object0, ChannelPromise channelPromise0, boolean z) {
            WriteTask abstractChannelHandlerContext$WriteTask0 = (WriteTask)WriteTask.RECYCLER.get();
            WriteTask.init(abstractChannelHandlerContext$WriteTask0, abstractChannelHandlerContext0, object0, channelPromise0, z);
            return abstractChannelHandlerContext$WriteTask0;
        }

        private void recycle() {
            this.ctx = null;
            this.msg = null;
            this.promise = null;
            this.handle.recycle(this);
        }

        @Override
        public void run() {
            try {
                this.decrementPendingOutboundBytes();
                if(this.size >= 0) {
                    this.ctx.invokeWrite(this.msg, this.promise);
                }
                else {
                    this.ctx.invokeWriteAndFlush(this.msg, this.promise);
                }
            }
            finally {
                this.recycle();
            }
        }
    }

    static final boolean $assertionsDisabled = false;
    private static final int ADD_COMPLETE = 2;
    private static final int ADD_PENDING = 1;
    private static final AtomicIntegerFieldUpdater HANDLER_STATE_UPDATER = null;
    private static final int INIT = 0;
    private static final int REMOVE_COMPLETE = 3;
    private final int executionMask;
    final EventExecutor executor;
    private volatile int handlerState;
    private Tasks invokeTasks;
    private static final InternalLogger logger;
    private final String name;
    volatile AbstractChannelHandlerContext next;
    private final boolean ordered;
    private final DefaultChannelPipeline pipeline;
    volatile AbstractChannelHandlerContext prev;
    private ChannelFuture succeededFuture;

    static {
        AbstractChannelHandlerContext.logger = InternalLoggerFactory.getInstance(AbstractChannelHandlerContext.class);
        AbstractChannelHandlerContext.HANDLER_STATE_UPDATER = AtomicIntegerFieldUpdater.newUpdater(AbstractChannelHandlerContext.class, "handlerState");
    }

    public AbstractChannelHandlerContext(DefaultChannelPipeline defaultChannelPipeline0, EventExecutor eventExecutor0, String s, Class class0) {
        boolean z = false;
        this.handlerState = 0;
        this.name = (String)ObjectUtil.checkNotNull(s, "name");
        this.pipeline = defaultChannelPipeline0;
        this.executor = eventExecutor0;
        this.executionMask = ChannelHandlerMask.mask(class0);
        if(eventExecutor0 == null || eventExecutor0 instanceof OrderedEventExecutor) {
            z = true;
        }
        this.ordered = z;
    }

    @Override  // io.netty.channel.ChannelHandlerContext
    public ByteBufAllocator alloc() {
        return this.channel().config().getAllocator();
    }

    @Override  // io.netty.channel.ChannelHandlerContext
    public Attribute attr(AttributeKey attributeKey0) {
        return this.channel().attr(attributeKey0);
    }

    @Override  // io.netty.channel.ChannelOutboundInvoker
    public ChannelFuture bind(SocketAddress socketAddress0) {
        return this.bind(socketAddress0, this.newPromise());
    }

    @Override  // io.netty.channel.ChannelOutboundInvoker
    public ChannelFuture bind(SocketAddress socketAddress0, ChannelPromise channelPromise0) {
        ObjectUtil.checkNotNull(socketAddress0, "localAddress");
        if(this.isNotValidPromise(channelPromise0, false)) {
            return channelPromise0;
        }
        AbstractChannelHandlerContext abstractChannelHandlerContext0 = this.findContextOutbound(0x200);
        EventExecutor eventExecutor0 = abstractChannelHandlerContext0.executor();
        if(eventExecutor0.inEventLoop()) {
            abstractChannelHandlerContext0.invokeBind(socketAddress0, channelPromise0);
            return channelPromise0;
        }
        AbstractChannelHandlerContext.safeExecute(eventExecutor0, () -> {
            if(this.val$next.invokeHandler()) {
                try {
                    ChannelHandler channelHandler0 = this.val$next.handler();
                    HeadContext defaultChannelPipeline$HeadContext0 = this.val$next.pipeline.head;
                    if(channelHandler0 == defaultChannelPipeline$HeadContext0) {
                        defaultChannelPipeline$HeadContext0.bind(this.val$next, this.val$localAddress, this.val$promise);
                        return;
                    }
                    if(channelHandler0 instanceof ChannelDuplexHandler) {
                        ((ChannelDuplexHandler)channelHandler0).bind(this.val$next, this.val$localAddress, this.val$promise);
                        return;
                    }
                    ((ChannelOutboundHandler)channelHandler0).bind(this.val$next, this.val$localAddress, this.val$promise);
                    return;
                }
                catch(Throwable throwable0) {
                }
                AbstractChannelHandlerContext.notifyOutboundHandlerException(throwable0, this.val$promise);
                return;
            }
            this.val$next.bind(this.val$localAddress, this.val$promise);
        }, channelPromise0, null, false);
        return channelPromise0;

        class io.netty.channel.AbstractChannelHandlerContext.8 implements Runnable {
            public io.netty.channel.AbstractChannelHandlerContext.8(AbstractChannelHandlerContext abstractChannelHandlerContext1, SocketAddress socketAddress0, ChannelPromise channelPromise0) {
            }

            @Override
            public void run() {
                this.val$next.invokeBind(this.val$localAddress, this.val$promise);
            }
        }

    }

    public final void callHandlerAdded() {
        if(this.setAddComplete()) {
            this.handler().handlerAdded(this);
        }
    }

    public final void callHandlerRemoved() {
        try {
            if(this.handlerState == 2) {
                this.handler().handlerRemoved(this);
            }
        }
        finally {
            this.setRemoved();
        }
    }

    @Override  // io.netty.channel.ChannelHandlerContext
    public Channel channel() {
        return this.pipeline.channel();
    }

    @Override  // io.netty.channel.ChannelOutboundInvoker
    public ChannelFuture close() {
        return this.close(this.newPromise());
    }

    @Override  // io.netty.channel.ChannelOutboundInvoker
    public ChannelFuture close(ChannelPromise channelPromise0) {
        if(this.isNotValidPromise(channelPromise0, false)) {
            return channelPromise0;
        }
        AbstractChannelHandlerContext abstractChannelHandlerContext0 = this.findContextOutbound(0x1000);
        EventExecutor eventExecutor0 = abstractChannelHandlerContext0.executor();
        if(eventExecutor0.inEventLoop()) {
            abstractChannelHandlerContext0.invokeClose(channelPromise0);
            return channelPromise0;
        }
        AbstractChannelHandlerContext.safeExecute(eventExecutor0, () -> {
            if(this.val$next.invokeHandler()) {
                try {
                    ChannelHandler channelHandler0 = this.val$next.handler();
                    HeadContext defaultChannelPipeline$HeadContext0 = this.val$next.pipeline.head;
                    if(channelHandler0 == defaultChannelPipeline$HeadContext0) {
                        defaultChannelPipeline$HeadContext0.close(this.val$next, this.val$promise);
                        return;
                    }
                    if(channelHandler0 instanceof ChannelDuplexHandler) {
                        ((ChannelDuplexHandler)channelHandler0).close(this.val$next, this.val$promise);
                        return;
                    }
                    ((ChannelOutboundHandler)channelHandler0).close(this.val$next, this.val$promise);
                    return;
                }
                catch(Throwable throwable0) {
                }
                AbstractChannelHandlerContext.notifyOutboundHandlerException(throwable0, this.val$promise);
                return;
            }
            this.val$next.close(this.val$promise);
        }, channelPromise0, null, false);
        return channelPromise0;

        class io.netty.channel.AbstractChannelHandlerContext.11 implements Runnable {
            public io.netty.channel.AbstractChannelHandlerContext.11(AbstractChannelHandlerContext abstractChannelHandlerContext1, ChannelPromise channelPromise0) {
            }

            @Override
            public void run() {
                this.val$next.invokeClose(this.val$promise);
            }
        }

    }

    @Override  // io.netty.channel.ChannelOutboundInvoker
    public ChannelFuture connect(SocketAddress socketAddress0) {
        return this.connect(socketAddress0, this.newPromise());
    }

    @Override  // io.netty.channel.ChannelOutboundInvoker
    public ChannelFuture connect(SocketAddress socketAddress0, ChannelPromise channelPromise0) {
        return this.connect(socketAddress0, null, channelPromise0);
    }

    @Override  // io.netty.channel.ChannelOutboundInvoker
    public ChannelFuture connect(SocketAddress socketAddress0, SocketAddress socketAddress1) {
        return this.connect(socketAddress0, socketAddress1, this.newPromise());
    }

    @Override  // io.netty.channel.ChannelOutboundInvoker
    public ChannelFuture connect(SocketAddress socketAddress0, SocketAddress socketAddress1, ChannelPromise channelPromise0) {
        ObjectUtil.checkNotNull(socketAddress0, "remoteAddress");
        if(this.isNotValidPromise(channelPromise0, false)) {
            return channelPromise0;
        }
        AbstractChannelHandlerContext abstractChannelHandlerContext0 = this.findContextOutbound(0x400);
        EventExecutor eventExecutor0 = abstractChannelHandlerContext0.executor();
        if(eventExecutor0.inEventLoop()) {
            abstractChannelHandlerContext0.invokeConnect(socketAddress0, socketAddress1, channelPromise0);
            return channelPromise0;
        }
        AbstractChannelHandlerContext.safeExecute(eventExecutor0, () -> {
            if(this.val$next.invokeHandler()) {
                try {
                    ChannelHandler channelHandler0 = this.val$next.handler();
                    HeadContext defaultChannelPipeline$HeadContext0 = this.val$next.pipeline.head;
                    if(channelHandler0 == defaultChannelPipeline$HeadContext0) {
                        defaultChannelPipeline$HeadContext0.connect(this.val$next, this.val$remoteAddress, this.val$localAddress, this.val$promise);
                        return;
                    }
                    if(channelHandler0 instanceof ChannelDuplexHandler) {
                        ((ChannelDuplexHandler)channelHandler0).connect(this.val$next, this.val$remoteAddress, this.val$localAddress, this.val$promise);
                        return;
                    }
                    ((ChannelOutboundHandler)channelHandler0).connect(this.val$next, this.val$remoteAddress, this.val$localAddress, this.val$promise);
                    return;
                }
                catch(Throwable throwable0) {
                }
                AbstractChannelHandlerContext.notifyOutboundHandlerException(throwable0, this.val$promise);
                return;
            }
            this.val$next.connect(this.val$remoteAddress, this.val$localAddress, this.val$promise);
        }, channelPromise0, null, false);
        return channelPromise0;

        class io.netty.channel.AbstractChannelHandlerContext.9 implements Runnable {
            public io.netty.channel.AbstractChannelHandlerContext.9(AbstractChannelHandlerContext abstractChannelHandlerContext1, SocketAddress socketAddress0, SocketAddress socketAddress1, ChannelPromise channelPromise0) {
            }

            @Override
            public void run() {
                this.val$next.invokeConnect(this.val$remoteAddress, this.val$localAddress, this.val$promise);
            }
        }

    }

    @Override  // io.netty.channel.ChannelOutboundInvoker
    public ChannelFuture deregister() {
        return this.deregister(this.newPromise());
    }

    @Override  // io.netty.channel.ChannelOutboundInvoker
    public ChannelFuture deregister(ChannelPromise channelPromise0) {
        if(this.isNotValidPromise(channelPromise0, false)) {
            return channelPromise0;
        }
        AbstractChannelHandlerContext abstractChannelHandlerContext0 = this.findContextOutbound(0x2000);
        EventExecutor eventExecutor0 = abstractChannelHandlerContext0.executor();
        if(eventExecutor0.inEventLoop()) {
            abstractChannelHandlerContext0.invokeDeregister(channelPromise0);
            return channelPromise0;
        }
        AbstractChannelHandlerContext.safeExecute(eventExecutor0, () -> {
            if(this.val$next.invokeHandler()) {
                try {
                    ChannelHandler channelHandler0 = this.val$next.handler();
                    HeadContext defaultChannelPipeline$HeadContext0 = this.val$next.pipeline.head;
                    if(channelHandler0 == defaultChannelPipeline$HeadContext0) {
                        defaultChannelPipeline$HeadContext0.deregister(this.val$next, this.val$promise);
                        return;
                    }
                    if(channelHandler0 instanceof ChannelDuplexHandler) {
                        ((ChannelDuplexHandler)channelHandler0).deregister(this.val$next, this.val$promise);
                        return;
                    }
                    ((ChannelOutboundHandler)channelHandler0).deregister(this.val$next, this.val$promise);
                    return;
                }
                catch(Throwable throwable0) {
                }
                AbstractChannelHandlerContext.notifyOutboundHandlerException(throwable0, this.val$promise);
                return;
            }
            this.val$next.deregister(this.val$promise);
        }, channelPromise0, null, false);
        return channelPromise0;

        class io.netty.channel.AbstractChannelHandlerContext.12 implements Runnable {
            public io.netty.channel.AbstractChannelHandlerContext.12(AbstractChannelHandlerContext abstractChannelHandlerContext1, ChannelPromise channelPromise0) {
            }

            @Override
            public void run() {
                this.val$next.invokeDeregister(this.val$promise);
            }
        }

    }

    @Override  // io.netty.channel.ChannelOutboundInvoker
    public ChannelFuture disconnect() {
        return this.disconnect(this.newPromise());
    }

    @Override  // io.netty.channel.ChannelOutboundInvoker
    public ChannelFuture disconnect(ChannelPromise channelPromise0) {
        if(!this.channel().metadata().hasDisconnect()) {
            return this.close(channelPromise0);
        }
        if(this.isNotValidPromise(channelPromise0, false)) {
            return channelPromise0;
        }
        AbstractChannelHandlerContext abstractChannelHandlerContext0 = this.findContextOutbound(0x800);
        EventExecutor eventExecutor0 = abstractChannelHandlerContext0.executor();
        if(eventExecutor0.inEventLoop()) {
            abstractChannelHandlerContext0.invokeDisconnect(channelPromise0);
            return channelPromise0;
        }
        AbstractChannelHandlerContext.safeExecute(eventExecutor0, () -> {
            if(this.val$next.invokeHandler()) {
                try {
                    ChannelHandler channelHandler0 = this.val$next.handler();
                    HeadContext defaultChannelPipeline$HeadContext0 = this.val$next.pipeline.head;
                    if(channelHandler0 == defaultChannelPipeline$HeadContext0) {
                        defaultChannelPipeline$HeadContext0.disconnect(this.val$next, this.val$promise);
                        return;
                    }
                    if(channelHandler0 instanceof ChannelDuplexHandler) {
                        ((ChannelDuplexHandler)channelHandler0).disconnect(this.val$next, this.val$promise);
                        return;
                    }
                    ((ChannelOutboundHandler)channelHandler0).disconnect(this.val$next, this.val$promise);
                    return;
                }
                catch(Throwable throwable0) {
                }
                AbstractChannelHandlerContext.notifyOutboundHandlerException(throwable0, this.val$promise);
                return;
            }
            this.val$next.disconnect(this.val$promise);
        }, channelPromise0, null, false);
        return channelPromise0;

        class io.netty.channel.AbstractChannelHandlerContext.10 implements Runnable {
            public io.netty.channel.AbstractChannelHandlerContext.10(AbstractChannelHandlerContext abstractChannelHandlerContext1, ChannelPromise channelPromise0) {
            }

            @Override
            public void run() {
                this.val$next.invokeDisconnect(this.val$promise);
            }
        }

    }

    @Override  // io.netty.channel.ChannelHandlerContext
    public EventExecutor executor() {
        EventExecutor eventExecutor0 = this.executor;
        return eventExecutor0 == null ? this.channel().eventLoop() : eventExecutor0;
    }

    private AbstractChannelHandlerContext findContextInbound(int v) {
        EventExecutor eventExecutor0 = this.executor();
        AbstractChannelHandlerContext abstractChannelHandlerContext0 = this;
        do {
            abstractChannelHandlerContext0 = abstractChannelHandlerContext0.next;
        }
        while(AbstractChannelHandlerContext.skipContext(abstractChannelHandlerContext0, eventExecutor0, v, 510));
        return abstractChannelHandlerContext0;
    }

    private AbstractChannelHandlerContext findContextOutbound(int v) {
        EventExecutor eventExecutor0 = this.executor();
        AbstractChannelHandlerContext abstractChannelHandlerContext0 = this;
        do {
            abstractChannelHandlerContext0 = abstractChannelHandlerContext0.prev;
        }
        while(AbstractChannelHandlerContext.skipContext(abstractChannelHandlerContext0, eventExecutor0, v, 0x1FE00));
        return abstractChannelHandlerContext0;
    }

    @Override  // io.netty.channel.ChannelHandlerContext
    public ChannelHandlerContext fireChannelActive() {
        AbstractChannelHandlerContext.invokeChannelActive(this.findContextInbound(8));
        return this;
    }

    @Override  // io.netty.channel.ChannelInboundInvoker
    public ChannelInboundInvoker fireChannelActive() {
        return this.fireChannelActive();
    }

    @Override  // io.netty.channel.ChannelHandlerContext
    public ChannelHandlerContext fireChannelInactive() {
        AbstractChannelHandlerContext.invokeChannelInactive(this.findContextInbound(16));
        return this;
    }

    @Override  // io.netty.channel.ChannelInboundInvoker
    public ChannelInboundInvoker fireChannelInactive() {
        return this.fireChannelInactive();
    }

    @Override  // io.netty.channel.ChannelHandlerContext
    public ChannelHandlerContext fireChannelRead(Object object0) {
        AbstractChannelHandlerContext.invokeChannelRead(this.findContextInbound(0x20), object0);
        return this;
    }

    @Override  // io.netty.channel.ChannelInboundInvoker
    public ChannelInboundInvoker fireChannelRead(Object object0) {
        return this.fireChannelRead(object0);
    }

    @Override  // io.netty.channel.ChannelHandlerContext
    public ChannelHandlerContext fireChannelReadComplete() {
        AbstractChannelHandlerContext.invokeChannelReadComplete(this.findContextInbound(0x40));
        return this;
    }

    @Override  // io.netty.channel.ChannelInboundInvoker
    public ChannelInboundInvoker fireChannelReadComplete() {
        return this.fireChannelReadComplete();
    }

    @Override  // io.netty.channel.ChannelHandlerContext
    public ChannelHandlerContext fireChannelRegistered() {
        AbstractChannelHandlerContext.invokeChannelRegistered(this.findContextInbound(2));
        return this;
    }

    @Override  // io.netty.channel.ChannelInboundInvoker
    public ChannelInboundInvoker fireChannelRegistered() {
        return this.fireChannelRegistered();
    }

    @Override  // io.netty.channel.ChannelHandlerContext
    public ChannelHandlerContext fireChannelUnregistered() {
        AbstractChannelHandlerContext.invokeChannelUnregistered(this.findContextInbound(4));
        return this;
    }

    @Override  // io.netty.channel.ChannelInboundInvoker
    public ChannelInboundInvoker fireChannelUnregistered() {
        return this.fireChannelUnregistered();
    }

    @Override  // io.netty.channel.ChannelHandlerContext
    public ChannelHandlerContext fireChannelWritabilityChanged() {
        AbstractChannelHandlerContext.invokeChannelWritabilityChanged(this.findContextInbound(0x100));
        return this;
    }

    @Override  // io.netty.channel.ChannelInboundInvoker
    public ChannelInboundInvoker fireChannelWritabilityChanged() {
        return this.fireChannelWritabilityChanged();
    }

    @Override  // io.netty.channel.ChannelHandlerContext
    public ChannelHandlerContext fireExceptionCaught(Throwable throwable0) {
        AbstractChannelHandlerContext.invokeExceptionCaught(this.findContextInbound(1), throwable0);
        return this;
    }

    @Override  // io.netty.channel.ChannelInboundInvoker
    public ChannelInboundInvoker fireExceptionCaught(Throwable throwable0) {
        return this.fireExceptionCaught(throwable0);
    }

    @Override  // io.netty.channel.ChannelHandlerContext
    public ChannelHandlerContext fireUserEventTriggered(Object object0) {
        AbstractChannelHandlerContext.invokeUserEventTriggered(this.findContextInbound(0x80), object0);
        return this;
    }

    @Override  // io.netty.channel.ChannelInboundInvoker
    public ChannelInboundInvoker fireUserEventTriggered(Object object0) {
        return this.fireUserEventTriggered(object0);
    }

    @Override  // io.netty.channel.ChannelHandlerContext
    public ChannelHandlerContext flush() {
        AbstractChannelHandlerContext abstractChannelHandlerContext0 = this.findContextOutbound(0x10000);
        EventExecutor eventExecutor0 = abstractChannelHandlerContext0.executor();
        if(eventExecutor0.inEventLoop()) {
            abstractChannelHandlerContext0.invokeFlush();
            return this;
        }
        Tasks abstractChannelHandlerContext$Tasks0 = abstractChannelHandlerContext0.invokeTasks;
        if(abstractChannelHandlerContext$Tasks0 == null) {
            abstractChannelHandlerContext$Tasks0 = new Tasks(abstractChannelHandlerContext0);
            abstractChannelHandlerContext0.invokeTasks = abstractChannelHandlerContext$Tasks0;
        }
        AbstractChannelHandlerContext.safeExecute(eventExecutor0, Tasks.access$1500(abstractChannelHandlerContext$Tasks0), this.channel().voidPromise(), null, false);
        return this;
    }

    @Override  // io.netty.channel.ChannelOutboundInvoker
    public ChannelOutboundInvoker flush() {
        return this.flush();
    }

    @Override  // io.netty.channel.ChannelHandlerContext
    public boolean hasAttr(AttributeKey attributeKey0) {
        return this.channel().hasAttr(attributeKey0);
    }

    // 检测为 Lambda 实现
    private void invokeBind(SocketAddress socketAddress0, ChannelPromise channelPromise0) [...]

    // 检测为 Lambda 实现
    private void invokeChannelActive() [...]

    public static void invokeChannelActive(AbstractChannelHandlerContext abstractChannelHandlerContext0) {
        EventExecutor eventExecutor0 = abstractChannelHandlerContext0.executor();
        if(eventExecutor0.inEventLoop()) {
            abstractChannelHandlerContext0.invokeChannelActive();
            return;
        }
        eventExecutor0.execute(() -> {
            if(this.val$next.invokeHandler()) {
                try {
                    ChannelHandler channelHandler0 = this.val$next.handler();
                    HeadContext defaultChannelPipeline$HeadContext0 = this.val$next.pipeline.head;
                    if(channelHandler0 == defaultChannelPipeline$HeadContext0) {
                        defaultChannelPipeline$HeadContext0.channelActive(this.val$next);
                        return;
                    }
                    if(channelHandler0 instanceof ChannelDuplexHandler) {
                        ((ChannelDuplexHandler)channelHandler0).channelActive(this.val$next);
                        return;
                    }
                    ((ChannelInboundHandler)channelHandler0).channelActive(this.val$next);
                    return;
                }
                catch(Throwable throwable0) {
                }
                this.val$next.invokeExceptionCaught(throwable0);
                return;
            }
            this.val$next.fireChannelActive();
        });

        final class io.netty.channel.AbstractChannelHandlerContext.3 implements Runnable {
            public io.netty.channel.AbstractChannelHandlerContext.3(AbstractChannelHandlerContext abstractChannelHandlerContext0) {
            }

            @Override
            public void run() {
                this.val$next.invokeChannelActive();
            }
        }

    }

    // 检测为 Lambda 实现
    private void invokeChannelInactive() [...]

    public static void invokeChannelInactive(AbstractChannelHandlerContext abstractChannelHandlerContext0) {
        EventExecutor eventExecutor0 = abstractChannelHandlerContext0.executor();
        if(eventExecutor0.inEventLoop()) {
            abstractChannelHandlerContext0.invokeChannelInactive();
            return;
        }
        eventExecutor0.execute(() -> {
            if(this.val$next.invokeHandler()) {
                try {
                    ChannelHandler channelHandler0 = this.val$next.handler();
                    HeadContext defaultChannelPipeline$HeadContext0 = this.val$next.pipeline.head;
                    if(channelHandler0 == defaultChannelPipeline$HeadContext0) {
                        defaultChannelPipeline$HeadContext0.channelInactive(this.val$next);
                        return;
                    }
                    if(channelHandler0 instanceof ChannelDuplexHandler) {
                        ((ChannelDuplexHandler)channelHandler0).channelInactive(this.val$next);
                        return;
                    }
                    ((ChannelInboundHandler)channelHandler0).channelInactive(this.val$next);
                    return;
                }
                catch(Throwable throwable0) {
                }
                this.val$next.invokeExceptionCaught(throwable0);
                return;
            }
            this.val$next.fireChannelInactive();
        });

        final class io.netty.channel.AbstractChannelHandlerContext.4 implements Runnable {
            public io.netty.channel.AbstractChannelHandlerContext.4(AbstractChannelHandlerContext abstractChannelHandlerContext0) {
            }

            @Override
            public void run() {
                this.val$next.invokeChannelInactive();
            }
        }

    }

    public static void invokeChannelRead(AbstractChannelHandlerContext abstractChannelHandlerContext0, Object object0) {
        Object object1 = ObjectUtil.checkNotNull(object0, "msg");
        Object object2 = abstractChannelHandlerContext0.pipeline.touch(object1, abstractChannelHandlerContext0);
        EventExecutor eventExecutor0 = abstractChannelHandlerContext0.executor();
        if(eventExecutor0.inEventLoop()) {
            abstractChannelHandlerContext0.invokeChannelRead(object2);
            return;
        }
        eventExecutor0.execute(() -> {
            if(this.val$next.invokeHandler()) {
                try {
                    ChannelHandler channelHandler0 = this.val$next.handler();
                    HeadContext defaultChannelPipeline$HeadContext0 = this.val$next.pipeline.head;
                    if(channelHandler0 == defaultChannelPipeline$HeadContext0) {
                        defaultChannelPipeline$HeadContext0.channelRead(this.val$next, this.val$m);
                        return;
                    }
                    if(channelHandler0 instanceof ChannelDuplexHandler) {
                        ((ChannelDuplexHandler)channelHandler0).channelRead(this.val$next, this.val$m);
                        return;
                    }
                    ((ChannelInboundHandler)channelHandler0).channelRead(this.val$next, this.val$m);
                    return;
                }
                catch(Throwable throwable0) {
                }
                this.val$next.invokeExceptionCaught(throwable0);
                return;
            }
            this.val$next.fireChannelRead(this.val$m);
        });

        final class io.netty.channel.AbstractChannelHandlerContext.7 implements Runnable {
            public io.netty.channel.AbstractChannelHandlerContext.7(AbstractChannelHandlerContext abstractChannelHandlerContext0, Object object0) {
            }

            @Override
            public void run() {
                this.val$next.invokeChannelRead(this.val$m);
            }
        }

    }

    // 检测为 Lambda 实现
    private void invokeChannelRead(Object object0) [...]

    private void invokeChannelReadComplete() {
        if(this.invokeHandler()) {
            try {
                ChannelHandler channelHandler0 = this.handler();
                HeadContext defaultChannelPipeline$HeadContext0 = this.pipeline.head;
                if(channelHandler0 == defaultChannelPipeline$HeadContext0) {
                    defaultChannelPipeline$HeadContext0.channelReadComplete(this);
                    return;
                }
                if(channelHandler0 instanceof ChannelDuplexHandler) {
                    ((ChannelDuplexHandler)channelHandler0).channelReadComplete(this);
                    return;
                }
                ((ChannelInboundHandler)channelHandler0).channelReadComplete(this);
                return;
            }
            catch(Throwable throwable0) {
            }
            this.invokeExceptionCaught(throwable0);
            return;
        }
        this.fireChannelReadComplete();
    }

    public static void invokeChannelReadComplete(AbstractChannelHandlerContext abstractChannelHandlerContext0) {
        EventExecutor eventExecutor0 = abstractChannelHandlerContext0.executor();
        if(eventExecutor0.inEventLoop()) {
            abstractChannelHandlerContext0.invokeChannelReadComplete();
            return;
        }
        Tasks abstractChannelHandlerContext$Tasks0 = abstractChannelHandlerContext0.invokeTasks;
        if(abstractChannelHandlerContext$Tasks0 == null) {
            abstractChannelHandlerContext$Tasks0 = new Tasks(abstractChannelHandlerContext0);
            abstractChannelHandlerContext0.invokeTasks = abstractChannelHandlerContext$Tasks0;
        }
        eventExecutor0.execute(Tasks.access$700(abstractChannelHandlerContext$Tasks0));
    }

    // 检测为 Lambda 实现
    private void invokeChannelRegistered() [...]

    public static void invokeChannelRegistered(AbstractChannelHandlerContext abstractChannelHandlerContext0) {
        EventExecutor eventExecutor0 = abstractChannelHandlerContext0.executor();
        if(eventExecutor0.inEventLoop()) {
            abstractChannelHandlerContext0.invokeChannelRegistered();
            return;
        }
        eventExecutor0.execute(() -> {
            if(this.val$next.invokeHandler()) {
                try {
                    ChannelHandler channelHandler0 = this.val$next.handler();
                    HeadContext defaultChannelPipeline$HeadContext0 = this.val$next.pipeline.head;
                    if(channelHandler0 == defaultChannelPipeline$HeadContext0) {
                        defaultChannelPipeline$HeadContext0.channelRegistered(this.val$next);
                        return;
                    }
                    if(channelHandler0 instanceof ChannelDuplexHandler) {
                        ((ChannelDuplexHandler)channelHandler0).channelRegistered(this.val$next);
                        return;
                    }
                    ((ChannelInboundHandler)channelHandler0).channelRegistered(this.val$next);
                    return;
                }
                catch(Throwable throwable0) {
                }
                this.val$next.invokeExceptionCaught(throwable0);
                return;
            }
            this.val$next.fireChannelRegistered();
        });

        final class io.netty.channel.AbstractChannelHandlerContext.1 implements Runnable {
            public io.netty.channel.AbstractChannelHandlerContext.1(AbstractChannelHandlerContext abstractChannelHandlerContext0) {
            }

            @Override
            public void run() {
                this.val$next.invokeChannelRegistered();
            }
        }

    }

    // 检测为 Lambda 实现
    private void invokeChannelUnregistered() [...]

    public static void invokeChannelUnregistered(AbstractChannelHandlerContext abstractChannelHandlerContext0) {
        EventExecutor eventExecutor0 = abstractChannelHandlerContext0.executor();
        if(eventExecutor0.inEventLoop()) {
            abstractChannelHandlerContext0.invokeChannelUnregistered();
            return;
        }
        eventExecutor0.execute(() -> {
            if(this.val$next.invokeHandler()) {
                try {
                    ChannelHandler channelHandler0 = this.val$next.handler();
                    HeadContext defaultChannelPipeline$HeadContext0 = this.val$next.pipeline.head;
                    if(channelHandler0 == defaultChannelPipeline$HeadContext0) {
                        defaultChannelPipeline$HeadContext0.channelUnregistered(this.val$next);
                        return;
                    }
                    if(channelHandler0 instanceof ChannelDuplexHandler) {
                        ((ChannelDuplexHandler)channelHandler0).channelUnregistered(this.val$next);
                        return;
                    }
                    ((ChannelInboundHandler)channelHandler0).channelUnregistered(this.val$next);
                    return;
                }
                catch(Throwable throwable0) {
                }
                this.val$next.invokeExceptionCaught(throwable0);
                return;
            }
            this.val$next.fireChannelUnregistered();
        });

        final class io.netty.channel.AbstractChannelHandlerContext.2 implements Runnable {
            public io.netty.channel.AbstractChannelHandlerContext.2(AbstractChannelHandlerContext abstractChannelHandlerContext0) {
            }

            @Override
            public void run() {
                this.val$next.invokeChannelUnregistered();
            }
        }

    }

    private void invokeChannelWritabilityChanged() {
        if(this.invokeHandler()) {
            try {
                ChannelHandler channelHandler0 = this.handler();
                HeadContext defaultChannelPipeline$HeadContext0 = this.pipeline.head;
                if(channelHandler0 == defaultChannelPipeline$HeadContext0) {
                    defaultChannelPipeline$HeadContext0.channelWritabilityChanged(this);
                    return;
                }
                if(channelHandler0 instanceof ChannelDuplexHandler) {
                    ((ChannelDuplexHandler)channelHandler0).channelWritabilityChanged(this);
                    return;
                }
                ((ChannelInboundHandler)channelHandler0).channelWritabilityChanged(this);
                return;
            }
            catch(Throwable throwable0) {
            }
            this.invokeExceptionCaught(throwable0);
            return;
        }
        this.fireChannelWritabilityChanged();
    }

    public static void invokeChannelWritabilityChanged(AbstractChannelHandlerContext abstractChannelHandlerContext0) {
        EventExecutor eventExecutor0 = abstractChannelHandlerContext0.executor();
        if(eventExecutor0.inEventLoop()) {
            abstractChannelHandlerContext0.invokeChannelWritabilityChanged();
            return;
        }
        Tasks abstractChannelHandlerContext$Tasks0 = abstractChannelHandlerContext0.invokeTasks;
        if(abstractChannelHandlerContext$Tasks0 == null) {
            abstractChannelHandlerContext$Tasks0 = new Tasks(abstractChannelHandlerContext0);
            abstractChannelHandlerContext0.invokeTasks = abstractChannelHandlerContext$Tasks0;
        }
        eventExecutor0.execute(Tasks.access$800(abstractChannelHandlerContext$Tasks0));
    }

    // 检测为 Lambda 实现
    private void invokeClose(ChannelPromise channelPromise0) [...]

    // 检测为 Lambda 实现
    private void invokeConnect(SocketAddress socketAddress0, SocketAddress socketAddress1, ChannelPromise channelPromise0) [...]

    // 检测为 Lambda 实现
    private void invokeDeregister(ChannelPromise channelPromise0) [...]

    // 检测为 Lambda 实现
    private void invokeDisconnect(ChannelPromise channelPromise0) [...]

    public static void invokeExceptionCaught(AbstractChannelHandlerContext abstractChannelHandlerContext0, Throwable throwable0) {
        ObjectUtil.checkNotNull(throwable0, "cause");
        EventExecutor eventExecutor0 = abstractChannelHandlerContext0.executor();
        if(eventExecutor0.inEventLoop()) {
            abstractChannelHandlerContext0.invokeExceptionCaught(throwable0);
            return;
        }
        try {
            eventExecutor0.execute(() -> {
                if(this.val$next.invokeHandler()) {
                    try {
                        this.val$next.handler().exceptionCaught(this.val$next, this.val$cause);
                    }
                    catch(Throwable throwable1) {
                        InternalLogger internalLogger0 = AbstractChannelHandlerContext.logger;
                        if(internalLogger0.isDebugEnabled()) {
                            internalLogger0.debug("An exception {}was thrown by a user handler\'s exceptionCaught() method while handling the following exception:", ThrowableUtil.stackTraceToString(throwable1), this.val$cause);
                            return;
                        }
                        if(internalLogger0.isWarnEnabled()) {
                            internalLogger0.warn("An exception \'{}\' [enable DEBUG level for full stacktrace] was thrown by a user handler\'s exceptionCaught() method while handling the following exception:", throwable1, this.val$cause);
                        }
                    }
                    return;
                }
                this.val$next.fireExceptionCaught(this.val$cause);
            });
        }
        catch(Throwable throwable1) {
            InternalLogger internalLogger0 = AbstractChannelHandlerContext.logger;
            if(internalLogger0.isWarnEnabled()) {
                internalLogger0.warn("Failed to submit an exceptionCaught() event.", throwable1);
                internalLogger0.warn("The exceptionCaught() event that was failed to submit was:", throwable0);
            }
        }

        final class io.netty.channel.AbstractChannelHandlerContext.5 implements Runnable {
            public io.netty.channel.AbstractChannelHandlerContext.5(AbstractChannelHandlerContext abstractChannelHandlerContext0, Throwable throwable0) {
            }

            @Override
            public void run() {
                this.val$next.invokeExceptionCaught(this.val$cause);
            }
        }

    }

    // 检测为 Lambda 实现
    private void invokeExceptionCaught(Throwable throwable0) [...]

    private void invokeFlush() {
        if(this.invokeHandler()) {
            this.invokeFlush0();
            return;
        }
        this.flush();
    }

    private void invokeFlush0() {
        try {
            ChannelHandler channelHandler0 = this.handler();
            HeadContext defaultChannelPipeline$HeadContext0 = this.pipeline.head;
            if(channelHandler0 == defaultChannelPipeline$HeadContext0) {
                defaultChannelPipeline$HeadContext0.flush(this);
                return;
            }
            if(channelHandler0 instanceof ChannelDuplexHandler) {
                ((ChannelDuplexHandler)channelHandler0).flush(this);
                return;
            }
            ((ChannelOutboundHandler)channelHandler0).flush(this);
            return;
        }
        catch(Throwable throwable0) {
        }
        this.invokeExceptionCaught(throwable0);
    }

    private boolean invokeHandler() {
        return this.handlerState == 2 || !this.ordered && this.handlerState == 1;
    }

    private void invokeRead() {
        if(this.invokeHandler()) {
            try {
                ChannelHandler channelHandler0 = this.handler();
                HeadContext defaultChannelPipeline$HeadContext0 = this.pipeline.head;
                if(channelHandler0 == defaultChannelPipeline$HeadContext0) {
                    defaultChannelPipeline$HeadContext0.read(this);
                    return;
                }
                if(channelHandler0 instanceof ChannelDuplexHandler) {
                    ((ChannelDuplexHandler)channelHandler0).read(this);
                    return;
                }
                ((ChannelOutboundHandler)channelHandler0).read(this);
                return;
            }
            catch(Throwable throwable0) {
            }
            this.invokeExceptionCaught(throwable0);
            return;
        }
        this.read();
    }

    public static void invokeUserEventTriggered(AbstractChannelHandlerContext abstractChannelHandlerContext0, Object object0) {
        ObjectUtil.checkNotNull(object0, "event");
        EventExecutor eventExecutor0 = abstractChannelHandlerContext0.executor();
        if(eventExecutor0.inEventLoop()) {
            abstractChannelHandlerContext0.invokeUserEventTriggered(object0);
            return;
        }
        eventExecutor0.execute(() -> {
            if(this.val$next.invokeHandler()) {
                try {
                    ChannelHandler channelHandler0 = this.val$next.handler();
                    HeadContext defaultChannelPipeline$HeadContext0 = this.val$next.pipeline.head;
                    if(channelHandler0 == defaultChannelPipeline$HeadContext0) {
                        defaultChannelPipeline$HeadContext0.userEventTriggered(this.val$next, this.val$event);
                        return;
                    }
                    if(channelHandler0 instanceof ChannelDuplexHandler) {
                        ((ChannelDuplexHandler)channelHandler0).userEventTriggered(this.val$next, this.val$event);
                        return;
                    }
                    ((ChannelInboundHandler)channelHandler0).userEventTriggered(this.val$next, this.val$event);
                    return;
                }
                catch(Throwable throwable0) {
                }
                this.val$next.invokeExceptionCaught(throwable0);
                return;
            }
            this.val$next.fireUserEventTriggered(this.val$event);
        });

        final class io.netty.channel.AbstractChannelHandlerContext.6 implements Runnable {
            public io.netty.channel.AbstractChannelHandlerContext.6(AbstractChannelHandlerContext abstractChannelHandlerContext0, Object object0) {
            }

            @Override
            public void run() {
                this.val$next.invokeUserEventTriggered(this.val$event);
            }
        }

    }

    // 检测为 Lambda 实现
    private void invokeUserEventTriggered(Object object0) [...]

    public void invokeWrite(Object object0, ChannelPromise channelPromise0) {
        if(this.invokeHandler()) {
            this.invokeWrite0(object0, channelPromise0);
            return;
        }
        this.write(object0, channelPromise0);
    }

    private void invokeWrite0(Object object0, ChannelPromise channelPromise0) {
        try {
            ChannelHandler channelHandler0 = this.handler();
            HeadContext defaultChannelPipeline$HeadContext0 = this.pipeline.head;
            if(channelHandler0 == defaultChannelPipeline$HeadContext0) {
                defaultChannelPipeline$HeadContext0.write(this, object0, channelPromise0);
                return;
            }
            if(channelHandler0 instanceof ChannelDuplexHandler) {
                ((ChannelDuplexHandler)channelHandler0).write(this, object0, channelPromise0);
                return;
            }
            ((ChannelOutboundHandler)channelHandler0).write(this, object0, channelPromise0);
            return;
        }
        catch(Throwable throwable0) {
        }
        AbstractChannelHandlerContext.notifyOutboundHandlerException(throwable0, channelPromise0);
    }

    public void invokeWriteAndFlush(Object object0, ChannelPromise channelPromise0) {
        if(this.invokeHandler()) {
            this.invokeWrite0(object0, channelPromise0);
            this.invokeFlush0();
            return;
        }
        this.writeAndFlush(object0, channelPromise0);
    }

    private boolean isNotValidPromise(ChannelPromise channelPromise0, boolean z) {
        ObjectUtil.checkNotNull(channelPromise0, "promise");
        if(channelPromise0.isDone()) {
            if(!channelPromise0.isCancelled()) {
                throw new IllegalArgumentException("promise already done: " + channelPromise0);
            }
            return true;
        }
        if(channelPromise0.channel() != this.channel()) {
            throw new IllegalArgumentException(String.format("promise.channel does not match: %s (expected: %s)", channelPromise0.channel(), this.channel()));
        }
        if(channelPromise0.getClass() == DefaultChannelPromise.class) {
            return false;
        }
        if(!z && channelPromise0 instanceof VoidChannelPromise) {
            throw new IllegalArgumentException("VoidChannelPromise not allowed for this operation");
        }
        if(channelPromise0 instanceof CloseFuture) {
            throw new IllegalArgumentException("AbstractChannel$CloseFuture not allowed in a pipeline");
        }
        return false;
    }

    @Override  // io.netty.channel.ChannelHandlerContext
    public boolean isRemoved() {
        return this.handlerState == 3;
    }

    @Override  // io.netty.channel.ChannelHandlerContext
    public String name() {
        return this.name;
    }

    @Override  // io.netty.channel.ChannelOutboundInvoker
    public ChannelFuture newFailedFuture(Throwable throwable0) {
        return new FailedChannelFuture(this.channel(), this.executor(), throwable0);
    }

    @Override  // io.netty.channel.ChannelOutboundInvoker
    public ChannelProgressivePromise newProgressivePromise() {
        return new DefaultChannelProgressivePromise(this.channel(), this.executor());
    }

    @Override  // io.netty.channel.ChannelOutboundInvoker
    public ChannelPromise newPromise() {
        return new DefaultChannelPromise(this.channel(), this.executor());
    }

    @Override  // io.netty.channel.ChannelOutboundInvoker
    public ChannelFuture newSucceededFuture() {
        ChannelFuture channelFuture0 = this.succeededFuture;
        if(channelFuture0 == null) {
            channelFuture0 = new SucceededChannelFuture(this.channel(), this.executor());
            this.succeededFuture = channelFuture0;
        }
        return channelFuture0;
    }

    private static void notifyOutboundHandlerException(Throwable throwable0, ChannelPromise channelPromise0) {
        PromiseNotificationUtil.tryFailure(channelPromise0, throwable0, (channelPromise0 instanceof VoidChannelPromise ? null : AbstractChannelHandlerContext.logger));
    }

    @Override  // io.netty.channel.ChannelHandlerContext
    public ChannelPipeline pipeline() {
        return this.pipeline;
    }

    @Override  // io.netty.channel.ChannelHandlerContext
    public ChannelHandlerContext read() {
        AbstractChannelHandlerContext abstractChannelHandlerContext0 = this.findContextOutbound(0x4000);
        EventExecutor eventExecutor0 = abstractChannelHandlerContext0.executor();
        if(eventExecutor0.inEventLoop()) {
            abstractChannelHandlerContext0.invokeRead();
            return this;
        }
        Tasks abstractChannelHandlerContext$Tasks0 = abstractChannelHandlerContext0.invokeTasks;
        if(abstractChannelHandlerContext$Tasks0 == null) {
            abstractChannelHandlerContext$Tasks0 = new Tasks(abstractChannelHandlerContext0);
            abstractChannelHandlerContext0.invokeTasks = abstractChannelHandlerContext$Tasks0;
        }
        eventExecutor0.execute(Tasks.access$1400(abstractChannelHandlerContext$Tasks0));
        return this;
    }

    @Override  // io.netty.channel.ChannelOutboundInvoker
    public ChannelOutboundInvoker read() {
        return this.read();
    }

    private static boolean safeExecute(EventExecutor eventExecutor0, Runnable runnable0, ChannelPromise channelPromise0, Object object0, boolean z) {
        try {
            if(z && eventExecutor0 instanceof AbstractEventExecutor) {
                ((AbstractEventExecutor)eventExecutor0).lazyExecute(runnable0);
                return true;
            }
            eventExecutor0.execute(runnable0);
            return true;
        }
        catch(Throwable throwable0) {
            try {
                if(object0 != null) {
                    ReferenceCountUtil.release(object0);
                }
                return false;
            }
            finally {
                channelPromise0.setFailure(throwable0);
            }
        }
    }

    public final boolean setAddComplete() {
        do {
            int v = this.handlerState;
            if(v == 3) {
                return false;
            }
        }
        while(!AbstractChannelHandlerContext.HANDLER_STATE_UPDATER.compareAndSet(this, v, 2));
        return true;
    }

    public final void setAddPending() {
        AbstractChannelHandlerContext.HANDLER_STATE_UPDATER.compareAndSet(this, 0, 1);
    }

    public final void setRemoved() {
        this.handlerState = 3;
    }

    private static boolean skipContext(AbstractChannelHandlerContext abstractChannelHandlerContext0, EventExecutor eventExecutor0, int v, int v1) {
        return ((v1 | v) & abstractChannelHandlerContext0.executionMask) == 0 || abstractChannelHandlerContext0.executor() == eventExecutor0 && (abstractChannelHandlerContext0.executionMask & v) == 0;
    }

    @Override  // io.netty.util.ResourceLeakHint
    public String toHintString() {
        return x.m(new StringBuilder("\'"), this.name, "\' will handle the message from this point.");
    }

    // 去混淆评级： 低(20)
    @Override
    public String toString() {
        return "ChannelHandlerContext" + '(' + this.name + ", " + this.channel() + ')';
    }

    @Override  // io.netty.channel.ChannelOutboundInvoker
    public ChannelPromise voidPromise() {
        return this.channel().voidPromise();
    }

    private void write(Object object0, boolean z, ChannelPromise channelPromise0) {
        ObjectUtil.checkNotNull(object0, "msg");
        try {
            if(this.isNotValidPromise(channelPromise0, true)) {
                ReferenceCountUtil.release(object0);
                return;
            }
        }
        catch(RuntimeException runtimeException0) {
            ReferenceCountUtil.release(object0);
            throw runtimeException0;
        }
        AbstractChannelHandlerContext abstractChannelHandlerContext0 = this.findContextOutbound((z ? 0x18000 : 0x8000));
        Object object1 = this.pipeline.touch(object0, abstractChannelHandlerContext0);
        EventExecutor eventExecutor0 = abstractChannelHandlerContext0.executor();
        if(eventExecutor0.inEventLoop()) {
            if(z) {
                abstractChannelHandlerContext0.invokeWriteAndFlush(object1, channelPromise0);
                return;
            }
            abstractChannelHandlerContext0.invokeWrite(object1, channelPromise0);
            return;
        }
        WriteTask abstractChannelHandlerContext$WriteTask0 = WriteTask.newInstance(abstractChannelHandlerContext0, object1, channelPromise0, z);
        if(!AbstractChannelHandlerContext.safeExecute(eventExecutor0, abstractChannelHandlerContext$WriteTask0, channelPromise0, object1, !z)) {
            abstractChannelHandlerContext$WriteTask0.cancel();
        }
    }

    @Override  // io.netty.channel.ChannelOutboundInvoker
    public ChannelFuture write(Object object0) {
        return this.write(object0, this.newPromise());
    }

    @Override  // io.netty.channel.ChannelOutboundInvoker
    public ChannelFuture write(Object object0, ChannelPromise channelPromise0) {
        this.write(object0, false, channelPromise0);
        return channelPromise0;
    }

    @Override  // io.netty.channel.ChannelOutboundInvoker
    public ChannelFuture writeAndFlush(Object object0) {
        return this.writeAndFlush(object0, this.newPromise());
    }

    @Override  // io.netty.channel.ChannelOutboundInvoker
    public ChannelFuture writeAndFlush(Object object0, ChannelPromise channelPromise0) {
        this.write(object0, true, channelPromise0);
        return channelPromise0;
    }
}

