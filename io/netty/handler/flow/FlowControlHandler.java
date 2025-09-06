package io.netty.handler.flow;

import io.netty.channel.ChannelConfig;
import io.netty.channel.ChannelDuplexHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.internal.ObjectPool.Handle;
import io.netty.util.internal.ObjectPool.ObjectCreator;
import io.netty.util.internal.ObjectPool;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.util.ArrayDeque;

public class FlowControlHandler extends ChannelDuplexHandler {
    static final class RecyclableArrayDeque extends ArrayDeque {
        private static final int DEFAULT_NUM_ELEMENTS = 2;
        private static final ObjectPool RECYCLER;
        private final Handle handle;
        private static final long serialVersionUID;

        static {
            RecyclableArrayDeque.RECYCLER = ObjectPool.newPool(new ObjectCreator() {
                public RecyclableArrayDeque newObject(Handle objectPool$Handle0) {
                    return new RecyclableArrayDeque(2, objectPool$Handle0, null);
                }

                @Override  // io.netty.util.internal.ObjectPool$ObjectCreator
                public Object newObject(Handle objectPool$Handle0) {
                    return this.newObject(objectPool$Handle0);
                }
            });
        }

        private RecyclableArrayDeque(int v, Handle objectPool$Handle0) {
            super(v);
            this.handle = objectPool$Handle0;
        }

        public RecyclableArrayDeque(int v, Handle objectPool$Handle0, io.netty.handler.flow.FlowControlHandler.1 flowControlHandler$10) {
            this(v, objectPool$Handle0);
        }

        public static RecyclableArrayDeque newInstance() {
            return (RecyclableArrayDeque)RecyclableArrayDeque.RECYCLER.get();
        }

        public void recycle() {
            this.clear();
            this.handle.recycle(this);
        }
    }

    private ChannelConfig config;
    private static final InternalLogger logger;
    private RecyclableArrayDeque queue;
    private final boolean releaseMessages;
    private boolean shouldConsume;

    static {
        FlowControlHandler.logger = InternalLoggerFactory.getInstance(FlowControlHandler.class);
    }

    public FlowControlHandler() {
        this(true);
    }

    public FlowControlHandler(boolean z) {
        this.releaseMessages = z;
    }

    @Override  // io.netty.channel.ChannelInboundHandlerAdapter
    public void channelInactive(ChannelHandlerContext channelHandlerContext0) {
        this.destroy();
        channelHandlerContext0.fireChannelInactive();
    }

    @Override  // io.netty.channel.ChannelInboundHandlerAdapter
    public void channelRead(ChannelHandlerContext channelHandlerContext0, Object object0) {
        if(this.queue == null) {
            this.queue = RecyclableArrayDeque.newInstance();
        }
        this.queue.offer(object0);
        boolean z = this.shouldConsume;
        this.shouldConsume = false;
        this.dequeue(channelHandlerContext0, ((int)z));
    }

    @Override  // io.netty.channel.ChannelInboundHandlerAdapter
    public void channelReadComplete(ChannelHandlerContext channelHandlerContext0) {
        if(this.isQueueEmpty()) {
            channelHandlerContext0.fireChannelReadComplete();
        }
    }

    private int dequeue(ChannelHandlerContext channelHandlerContext0, int v) {
        int v1 = 0;
        while(this.queue != null && (v1 < v || this.config.isAutoRead())) {
            Object object0 = this.queue.poll();
            if(object0 == null) {
                break;
            }
            ++v1;
            channelHandlerContext0.fireChannelRead(object0);
        }
        if(this.queue != null && this.queue.isEmpty()) {
            this.queue.recycle();
            this.queue = null;
            if(v1 > 0) {
                channelHandlerContext0.fireChannelReadComplete();
            }
        }
        return v1;
    }

    private void destroy() {
        RecyclableArrayDeque flowControlHandler$RecyclableArrayDeque0 = this.queue;
        if(flowControlHandler$RecyclableArrayDeque0 != null) {
            if(!flowControlHandler$RecyclableArrayDeque0.isEmpty()) {
                FlowControlHandler.logger.trace("Non-empty queue: {}", this.queue);
                if(this.releaseMessages) {
                    Object object0;
                    while((object0 = this.queue.poll()) != null) {
                        ReferenceCountUtil.safeRelease(object0);
                    }
                }
            }
            this.queue.recycle();
            this.queue = null;
        }
    }

    @Override  // io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler
    public void handlerAdded(ChannelHandlerContext channelHandlerContext0) {
        this.config = channelHandlerContext0.channel().config();
    }

    @Override  // io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler
    public void handlerRemoved(ChannelHandlerContext channelHandlerContext0) {
        super.handlerRemoved(channelHandlerContext0);
        if(!this.isQueueEmpty()) {
            this.dequeue(channelHandlerContext0, this.queue.size());
        }
        this.destroy();
    }

    public boolean isQueueEmpty() {
        return this.queue == null || this.queue.isEmpty();
    }

    @Override  // io.netty.channel.ChannelDuplexHandler
    public void read(ChannelHandlerContext channelHandlerContext0) {
        if(this.dequeue(channelHandlerContext0, 1) == 0) {
            this.shouldConsume = true;
            channelHandlerContext0.read();
            return;
        }
        if(this.config.isAutoRead()) {
            channelHandlerContext0.read();
        }
    }

    class io.netty.handler.flow.FlowControlHandler.1 {
    }

}

