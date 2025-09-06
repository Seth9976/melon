package io.netty.handler.traffic;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPromise;
import java.util.ArrayDeque;
import java.util.concurrent.TimeUnit;

public class ChannelTrafficShapingHandler extends AbstractTrafficShapingHandler {
    static final class ToSend {
        final ChannelPromise promise;
        final long relativeTimeAction;
        final Object toSend;

        private ToSend(long v, Object object0, ChannelPromise channelPromise0) {
            this.relativeTimeAction = v;
            this.toSend = object0;
            this.promise = channelPromise0;
        }

        public ToSend(long v, Object object0, ChannelPromise channelPromise0, io.netty.handler.traffic.ChannelTrafficShapingHandler.1 channelTrafficShapingHandler$10) {
            this(v, object0, channelPromise0);
        }
    }

    private final ArrayDeque messagesQueue;
    private long queueSize;

    public ChannelTrafficShapingHandler(long v) {
        super(v);
        this.messagesQueue = new ArrayDeque();
    }

    public ChannelTrafficShapingHandler(long v, long v1) {
        super(v, v1);
        this.messagesQueue = new ArrayDeque();
    }

    public ChannelTrafficShapingHandler(long v, long v1, long v2) {
        super(v, v1, v2);
        this.messagesQueue = new ArrayDeque();
    }

    public ChannelTrafficShapingHandler(long v, long v1, long v2, long v3) {
        super(v, v1, v2, v3);
        this.messagesQueue = new ArrayDeque();
    }

    @Override  // io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler
    public void handlerAdded(ChannelHandlerContext channelHandlerContext0) {
        TrafficCounter trafficCounter0 = new TrafficCounter(this, channelHandlerContext0.executor(), "ChannelTC" + channelHandlerContext0.channel().hashCode(), this.checkInterval);
        this.setTrafficCounter(trafficCounter0);
        trafficCounter0.start();
        super.handlerAdded(channelHandlerContext0);
    }

    @Override  // io.netty.handler.traffic.AbstractTrafficShapingHandler
    public void handlerRemoved(ChannelHandlerContext channelHandlerContext0) {
        this.trafficCounter.stop();
        synchronized(this) {
            if(channelHandlerContext0.channel().isActive()) {
                for(Object object0: this.messagesQueue) {
                    long v1 = this.calculateSize(((ToSend)object0).toSend);
                    this.trafficCounter.bytesRealWriteFlowControl(v1);
                    this.queueSize -= v1;
                    channelHandlerContext0.write(((ToSend)object0).toSend, ((ToSend)object0).promise);
                }
            }
            else {
                for(Object object1: this.messagesQueue) {
                    Object object2 = ((ToSend)object1).toSend;
                    if(object2 instanceof ByteBuf) {
                        ((ByteBuf)object2).release();
                    }
                }
            }
            this.messagesQueue.clear();
        }
        this.releaseWriteSuspended(channelHandlerContext0);
        this.releaseReadSuspended(channelHandlerContext0);
        super.handlerRemoved(channelHandlerContext0);
    }

    public long queueSize() {
        return this.queueSize;
    }

    // 检测为 Lambda 实现
    private void sendAllValid(ChannelHandlerContext channelHandlerContext0, long v) [...]

    @Override  // io.netty.handler.traffic.AbstractTrafficShapingHandler
    public void submitWrite(ChannelHandlerContext channelHandlerContext0, Object object0, long v, long v1, long v2, ChannelPromise channelPromise0) {
        ToSend channelTrafficShapingHandler$ToSend0;
        Throwable throwable1;
        __monitor_enter(this);
        try {
            if(v1 == 0L && this.messagesQueue.isEmpty()) {
                this.trafficCounter.bytesRealWriteFlowControl(v);
                channelHandlerContext0.write(object0, channelPromise0);
                __monitor_exit(this);
                return;
            }
        }
        catch(Throwable throwable0) {
            throwable1 = throwable0;
            goto label_18;
        }
        try {
            channelTrafficShapingHandler$ToSend0 = new ToSend(v1 + v2, object0, channelPromise0, null);
            this.messagesQueue.addLast(channelTrafficShapingHandler$ToSend0);
            long v3 = this.queueSize + v;
            this.queueSize = v3;
            this.checkWriteSuspend(channelHandlerContext0, v1, v3);
            __monitor_exit(this);
            goto label_20;
        label_17:
            throwable1 = throwable2;
        label_18:
            __monitor_exit(this);
        }
        catch(Throwable throwable2) {
            goto label_17;
        }
        throw throwable1;
    label_20:
        channelHandlerContext0.executor().schedule(() -> {
            synchronized(ChannelTrafficShapingHandler.this) {
                ToSend channelTrafficShapingHandler$ToSend0 = (ToSend)ChannelTrafficShapingHandler.this.messagesQueue.pollFirst();
                while(channelTrafficShapingHandler$ToSend0 != null) {
                    if(channelTrafficShapingHandler$ToSend0.relativeTimeAction <= this.val$futureNow) {
                        long v2 = ChannelTrafficShapingHandler.this.calculateSize(channelTrafficShapingHandler$ToSend0.toSend);
                        ChannelTrafficShapingHandler.this.trafficCounter.bytesRealWriteFlowControl(v2);
                        ChannelTrafficShapingHandler.this.queueSize -= v2;
                        this.val$ctx.write(channelTrafficShapingHandler$ToSend0.toSend, channelTrafficShapingHandler$ToSend0.promise);
                        channelTrafficShapingHandler$ToSend0 = (ToSend)ChannelTrafficShapingHandler.this.messagesQueue.pollFirst();
                    }
                    else {
                        ChannelTrafficShapingHandler.this.messagesQueue.addFirst(channelTrafficShapingHandler$ToSend0);
                        if(true) {
                            break;
                        }
                    }
                }
                if(ChannelTrafficShapingHandler.this.messagesQueue.isEmpty()) {
                    ChannelTrafficShapingHandler.this.releaseWriteSuspended(this.val$ctx);
                }
            }
            this.val$ctx.flush();
        }, v1, TimeUnit.MILLISECONDS);

        class io.netty.handler.traffic.ChannelTrafficShapingHandler.1 implements Runnable {
            public io.netty.handler.traffic.ChannelTrafficShapingHandler.1(ChannelHandlerContext channelHandlerContext0, long v) {
            }

            @Override
            public void run() {
                ChannelTrafficShapingHandler.this.sendAllValid(this.val$ctx, this.val$futureNow);
            }
        }

    }
}

