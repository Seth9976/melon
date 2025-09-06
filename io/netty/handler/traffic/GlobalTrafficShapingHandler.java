package io.netty.handler.traffic;

import io.netty.buffer.ByteBuf;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler.Sharable;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPromise;
import io.netty.util.concurrent.EventExecutor;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import java.util.ArrayDeque;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

@Sharable
public class GlobalTrafficShapingHandler extends AbstractTrafficShapingHandler {
    static final class PerChannel {
        long lastReadTimestamp;
        long lastWriteTimestamp;
        ArrayDeque messagesQueue;
        long queueSize;

        private PerChannel() {
        }

        public PerChannel(io.netty.handler.traffic.GlobalTrafficShapingHandler.1 globalTrafficShapingHandler$10) {
        }
    }

    static final class ToSend {
        final ChannelPromise promise;
        final long relativeTimeAction;
        final long size;
        final Object toSend;

        private ToSend(long v, Object object0, long v1, ChannelPromise channelPromise0) {
            this.relativeTimeAction = v;
            this.toSend = object0;
            this.size = v1;
            this.promise = channelPromise0;
        }

        public ToSend(long v, Object object0, long v1, ChannelPromise channelPromise0, io.netty.handler.traffic.GlobalTrafficShapingHandler.1 globalTrafficShapingHandler$10) {
            this(v, object0, v1, channelPromise0);
        }
    }

    private final ConcurrentMap channelQueues;
    long maxGlobalWriteSize;
    private final AtomicLong queuesSize;

    public GlobalTrafficShapingHandler(EventExecutor eventExecutor0) {
        this.channelQueues = PlatformDependent.newConcurrentHashMap();
        this.queuesSize = new AtomicLong();
        this.maxGlobalWriteSize = 0x19000000L;
        this.createGlobalTrafficCounter(eventExecutor0);
    }

    public GlobalTrafficShapingHandler(ScheduledExecutorService scheduledExecutorService0, long v) {
        super(v);
        this.channelQueues = PlatformDependent.newConcurrentHashMap();
        this.queuesSize = new AtomicLong();
        this.maxGlobalWriteSize = 0x19000000L;
        this.createGlobalTrafficCounter(scheduledExecutorService0);
    }

    public GlobalTrafficShapingHandler(ScheduledExecutorService scheduledExecutorService0, long v, long v1) {
        super(v, v1);
        this.channelQueues = PlatformDependent.newConcurrentHashMap();
        this.queuesSize = new AtomicLong();
        this.maxGlobalWriteSize = 0x19000000L;
        this.createGlobalTrafficCounter(scheduledExecutorService0);
    }

    public GlobalTrafficShapingHandler(ScheduledExecutorService scheduledExecutorService0, long v, long v1, long v2) {
        super(v, v1, v2);
        this.channelQueues = PlatformDependent.newConcurrentHashMap();
        this.queuesSize = new AtomicLong();
        this.maxGlobalWriteSize = 0x19000000L;
        this.createGlobalTrafficCounter(scheduledExecutorService0);
    }

    public GlobalTrafficShapingHandler(ScheduledExecutorService scheduledExecutorService0, long v, long v1, long v2, long v3) {
        super(v, v1, v2, v3);
        this.channelQueues = PlatformDependent.newConcurrentHashMap();
        this.queuesSize = new AtomicLong();
        this.maxGlobalWriteSize = 0x19000000L;
        this.createGlobalTrafficCounter(scheduledExecutorService0);
    }

    @Override  // io.netty.handler.traffic.AbstractTrafficShapingHandler
    public long checkWaitReadTime(ChannelHandlerContext channelHandlerContext0, long v, long v1) {
        Integer integer0 = channelHandlerContext0.channel().hashCode();
        PerChannel globalTrafficShapingHandler$PerChannel0 = (PerChannel)this.channelQueues.get(integer0);
        return globalTrafficShapingHandler$PerChannel0 == null || v <= this.maxTime || v1 + v - globalTrafficShapingHandler$PerChannel0.lastReadTimestamp <= this.maxTime ? v : this.maxTime;
    }

    public void createGlobalTrafficCounter(ScheduledExecutorService scheduledExecutorService0) {
        TrafficCounter trafficCounter0 = new TrafficCounter(this, ((ScheduledExecutorService)ObjectUtil.checkNotNull(scheduledExecutorService0, "executor")), "GlobalTC", this.checkInterval);
        this.setTrafficCounter(trafficCounter0);
        trafficCounter0.start();
    }

    public long getMaxGlobalWriteSize() {
        return this.maxGlobalWriteSize;
    }

    private PerChannel getOrSetPerChannel(ChannelHandlerContext channelHandlerContext0) {
        Integer integer0 = channelHandlerContext0.channel().hashCode();
        PerChannel globalTrafficShapingHandler$PerChannel0 = (PerChannel)this.channelQueues.get(integer0);
        if(globalTrafficShapingHandler$PerChannel0 == null) {
            globalTrafficShapingHandler$PerChannel0 = new PerChannel(null);
            globalTrafficShapingHandler$PerChannel0.messagesQueue = new ArrayDeque();
            globalTrafficShapingHandler$PerChannel0.queueSize = 0L;
            globalTrafficShapingHandler$PerChannel0.lastReadTimestamp = 0xE7239DL;
            globalTrafficShapingHandler$PerChannel0.lastWriteTimestamp = 0xE7239DL;
            this.channelQueues.put(integer0, globalTrafficShapingHandler$PerChannel0);
        }
        return globalTrafficShapingHandler$PerChannel0;
    }

    @Override  // io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler
    public void handlerAdded(ChannelHandlerContext channelHandlerContext0) {
        this.getOrSetPerChannel(channelHandlerContext0);
        super.handlerAdded(channelHandlerContext0);
    }

    @Override  // io.netty.handler.traffic.AbstractTrafficShapingHandler
    public void handlerRemoved(ChannelHandlerContext channelHandlerContext0) {
        Channel channel0 = channelHandlerContext0.channel();
        PerChannel globalTrafficShapingHandler$PerChannel0 = (PerChannel)this.channelQueues.remove(channel0.hashCode());
        if(globalTrafficShapingHandler$PerChannel0 != null) {
            synchronized(globalTrafficShapingHandler$PerChannel0) {
                if(channel0.isActive()) {
                    for(Object object0: globalTrafficShapingHandler$PerChannel0.messagesQueue) {
                        long v1 = this.calculateSize(((ToSend)object0).toSend);
                        this.trafficCounter.bytesRealWriteFlowControl(v1);
                        globalTrafficShapingHandler$PerChannel0.queueSize -= v1;
                        this.queuesSize.addAndGet(-v1);
                        channelHandlerContext0.write(((ToSend)object0).toSend, ((ToSend)object0).promise);
                    }
                }
                else {
                    this.queuesSize.addAndGet(-globalTrafficShapingHandler$PerChannel0.queueSize);
                    for(Object object1: globalTrafficShapingHandler$PerChannel0.messagesQueue) {
                        Object object2 = ((ToSend)object1).toSend;
                        if(object2 instanceof ByteBuf) {
                            ((ByteBuf)object2).release();
                        }
                    }
                }
                globalTrafficShapingHandler$PerChannel0.messagesQueue.clear();
            }
        }
        this.releaseWriteSuspended(channelHandlerContext0);
        this.releaseReadSuspended(channelHandlerContext0);
        super.handlerRemoved(channelHandlerContext0);
    }

    @Override  // io.netty.handler.traffic.AbstractTrafficShapingHandler
    public void informReadOperation(ChannelHandlerContext channelHandlerContext0, long v) {
        Integer integer0 = channelHandlerContext0.channel().hashCode();
        PerChannel globalTrafficShapingHandler$PerChannel0 = (PerChannel)this.channelQueues.get(integer0);
        if(globalTrafficShapingHandler$PerChannel0 != null) {
            globalTrafficShapingHandler$PerChannel0.lastReadTimestamp = v;
        }
    }

    public long queuesSize() {
        return this.queuesSize.get();
    }

    public final void release() {
        this.trafficCounter.stop();
    }

    // 检测为 Lambda 实现
    private void sendAllValid(ChannelHandlerContext channelHandlerContext0, PerChannel globalTrafficShapingHandler$PerChannel0, long v) [...]

    public void setMaxGlobalWriteSize(long v) {
        this.maxGlobalWriteSize = v;
    }

    @Override  // io.netty.handler.traffic.AbstractTrafficShapingHandler
    public void submitWrite(ChannelHandlerContext channelHandlerContext0, Object object0, long v, long v1, long v2, ChannelPromise channelPromise0) {
        ToSend globalTrafficShapingHandler$ToSend0;
        long v4;
        Integer integer0 = channelHandlerContext0.channel().hashCode();
        PerChannel globalTrafficShapingHandler$PerChannel0 = (PerChannel)this.channelQueues.get(integer0);
        if(globalTrafficShapingHandler$PerChannel0 == null) {
            globalTrafficShapingHandler$PerChannel0 = this.getOrSetPerChannel(channelHandlerContext0);
        }
        synchronized(globalTrafficShapingHandler$PerChannel0) {
            if(v1 == 0L && globalTrafficShapingHandler$PerChannel0.messagesQueue.isEmpty()) {
                this.trafficCounter.bytesRealWriteFlowControl(v);
                channelHandlerContext0.write(object0, channelPromise0);
                globalTrafficShapingHandler$PerChannel0.lastWriteTimestamp = v2;
                return;
            }
            v4 = v1 <= this.maxTime || v2 + v1 - globalTrafficShapingHandler$PerChannel0.lastWriteTimestamp <= this.maxTime ? v1 : this.maxTime;
            globalTrafficShapingHandler$ToSend0 = new ToSend(v4 + v2, object0, v, channelPromise0, null);
            globalTrafficShapingHandler$PerChannel0.messagesQueue.addLast(globalTrafficShapingHandler$ToSend0);
            globalTrafficShapingHandler$PerChannel0.queueSize += v;
            this.queuesSize.addAndGet(v);
            this.checkWriteSuspend(channelHandlerContext0, v4, globalTrafficShapingHandler$PerChannel0.queueSize);
            boolean z = Long.compare(this.queuesSize.get(), this.maxGlobalWriteSize) > 0;
        }
        if(z) {
            this.setUserDefinedWritability(channelHandlerContext0, false);
        }
        channelHandlerContext0.executor().schedule(() -> {
            synchronized(this.val$forSchedule) {
                ToSend globalTrafficShapingHandler$ToSend0 = (ToSend)this.val$forSchedule.messagesQueue.pollFirst();
                while(globalTrafficShapingHandler$ToSend0 != null) {
                    if(globalTrafficShapingHandler$ToSend0.relativeTimeAction <= this.val$futureNow) {
                        GlobalTrafficShapingHandler.this.trafficCounter.bytesRealWriteFlowControl(globalTrafficShapingHandler$ToSend0.size);
                        this.val$forSchedule.queueSize -= globalTrafficShapingHandler$ToSend0.size;
                        GlobalTrafficShapingHandler.this.queuesSize.addAndGet(-globalTrafficShapingHandler$ToSend0.size);
                        this.val$ctx.write(globalTrafficShapingHandler$ToSend0.toSend, globalTrafficShapingHandler$ToSend0.promise);
                        this.val$forSchedule.lastWriteTimestamp = this.val$futureNow;
                        globalTrafficShapingHandler$ToSend0 = (ToSend)this.val$forSchedule.messagesQueue.pollFirst();
                    }
                    else {
                        this.val$forSchedule.messagesQueue.addFirst(globalTrafficShapingHandler$ToSend0);
                        if(true) {
                            break;
                        }
                    }
                }
                if(this.val$forSchedule.messagesQueue.isEmpty()) {
                    GlobalTrafficShapingHandler.this.releaseWriteSuspended(this.val$ctx);
                }
            }
            this.val$ctx.flush();
        }, v4, TimeUnit.MILLISECONDS);

        class io.netty.handler.traffic.GlobalTrafficShapingHandler.1 implements Runnable {
            public io.netty.handler.traffic.GlobalTrafficShapingHandler.1(ChannelHandlerContext channelHandlerContext0, PerChannel globalTrafficShapingHandler$PerChannel0, long v) {
            }

            @Override
            public void run() {
                GlobalTrafficShapingHandler.this.sendAllValid(this.val$ctx, this.val$forSchedule, this.val$futureNow);
            }
        }

    }

    @Override  // io.netty.handler.traffic.AbstractTrafficShapingHandler
    public int userDefinedWritabilityIndex() {
        return 2;
    }
}

