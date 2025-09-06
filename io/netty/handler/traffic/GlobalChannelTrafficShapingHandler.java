package io.netty.handler.traffic;

import io.netty.buffer.ByteBuf;
import io.netty.channel.Channel;
import io.netty.channel.ChannelConfig;
import io.netty.channel.ChannelHandler.Sharable;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPromise;
import io.netty.util.Attribute;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.util.AbstractCollection;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

@Sharable
public class GlobalChannelTrafficShapingHandler extends AbstractTrafficShapingHandler {
    static final class PerChannel {
        TrafficCounter channelTrafficCounter;
        long lastReadTimestamp;
        long lastWriteTimestamp;
        ArrayDeque messagesQueue;
        long queueSize;

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

        public ToSend(long v, Object object0, long v1, ChannelPromise channelPromise0, io.netty.handler.traffic.GlobalChannelTrafficShapingHandler.1 globalChannelTrafficShapingHandler$10) {
            this(v, object0, v1, channelPromise0);
        }
    }

    private static final float DEFAULT_ACCELERATION = -0.1f;
    private static final float DEFAULT_DEVIATION = 0.1f;
    private static final float DEFAULT_SLOWDOWN = 0.4f;
    private static final float MAX_DEVIATION = 0.4f;
    private volatile float accelerationFactor;
    final ConcurrentMap channelQueues;
    private final AtomicLong cumulativeReadBytes;
    private final AtomicLong cumulativeWrittenBytes;
    private static final InternalLogger logger;
    private volatile float maxDeviation;
    volatile long maxGlobalWriteSize;
    private final AtomicLong queuesSize;
    private volatile long readChannelLimit;
    private volatile boolean readDeviationActive;
    private volatile float slowDownFactor;
    private volatile long writeChannelLimit;
    private volatile boolean writeDeviationActive;

    static {
        GlobalChannelTrafficShapingHandler.logger = InternalLoggerFactory.getInstance(GlobalChannelTrafficShapingHandler.class);
    }

    public GlobalChannelTrafficShapingHandler(ScheduledExecutorService scheduledExecutorService0) {
        this.channelQueues = PlatformDependent.newConcurrentHashMap();
        this.queuesSize = new AtomicLong();
        this.cumulativeWrittenBytes = new AtomicLong();
        this.cumulativeReadBytes = new AtomicLong();
        this.maxGlobalWriteSize = 0x19000000L;
        this.createGlobalTrafficCounter(scheduledExecutorService0);
    }

    public GlobalChannelTrafficShapingHandler(ScheduledExecutorService scheduledExecutorService0, long v) {
        super(v);
        this.channelQueues = PlatformDependent.newConcurrentHashMap();
        this.queuesSize = new AtomicLong();
        this.cumulativeWrittenBytes = new AtomicLong();
        this.cumulativeReadBytes = new AtomicLong();
        this.maxGlobalWriteSize = 0x19000000L;
        this.createGlobalTrafficCounter(scheduledExecutorService0);
    }

    public GlobalChannelTrafficShapingHandler(ScheduledExecutorService scheduledExecutorService0, long v, long v1, long v2, long v3) {
        super(v, v1);
        this.channelQueues = PlatformDependent.newConcurrentHashMap();
        this.queuesSize = new AtomicLong();
        this.cumulativeWrittenBytes = new AtomicLong();
        this.cumulativeReadBytes = new AtomicLong();
        this.maxGlobalWriteSize = 0x19000000L;
        this.writeChannelLimit = v2;
        this.readChannelLimit = v3;
        this.createGlobalTrafficCounter(scheduledExecutorService0);
    }

    public GlobalChannelTrafficShapingHandler(ScheduledExecutorService scheduledExecutorService0, long v, long v1, long v2, long v3, long v4) {
        super(v, v1, v4);
        this.channelQueues = PlatformDependent.newConcurrentHashMap();
        this.queuesSize = new AtomicLong();
        this.cumulativeWrittenBytes = new AtomicLong();
        this.cumulativeReadBytes = new AtomicLong();
        this.maxGlobalWriteSize = 0x19000000L;
        this.writeChannelLimit = v2;
        this.readChannelLimit = v3;
        this.createGlobalTrafficCounter(scheduledExecutorService0);
    }

    public GlobalChannelTrafficShapingHandler(ScheduledExecutorService scheduledExecutorService0, long v, long v1, long v2, long v3, long v4, long v5) {
        super(v, v1, v4, v5);
        this.channelQueues = PlatformDependent.newConcurrentHashMap();
        this.queuesSize = new AtomicLong();
        this.cumulativeWrittenBytes = new AtomicLong();
        this.cumulativeReadBytes = new AtomicLong();
        this.maxGlobalWriteSize = 0x19000000L;
        this.createGlobalTrafficCounter(scheduledExecutorService0);
        this.writeChannelLimit = v2;
        this.readChannelLimit = v3;
    }

    public float accelerationFactor() {
        return this.accelerationFactor;
    }

    @Override  // io.netty.handler.traffic.AbstractTrafficShapingHandler
    public void channelRead(ChannelHandlerContext channelHandlerContext0, Object object0) {
        long v = this.calculateSize(object0);
        long v1 = 0L;
        if(v > 0L) {
            long v2 = this.trafficCounter.readTimeToWait(v, this.getReadLimit(), this.maxTime, 0xE7230DL);
            Integer integer0 = channelHandlerContext0.channel().hashCode();
            PerChannel globalChannelTrafficShapingHandler$PerChannel0 = (PerChannel)this.channelQueues.get(integer0);
            if(globalChannelTrafficShapingHandler$PerChannel0 != null) {
                long v3 = globalChannelTrafficShapingHandler$PerChannel0.channelTrafficCounter.readTimeToWait(v, this.readChannelLimit, this.maxTime, 0xE7230DL);
                if(this.readDeviationActive) {
                    long v4 = globalChannelTrafficShapingHandler$PerChannel0.channelTrafficCounter.cumulativeReadBytes();
                    long v5 = this.cumulativeReadBytes.get();
                    if(v4 > 0L) {
                        v1 = v4;
                    }
                    if(v5 < v1) {
                        v5 = v1;
                    }
                    v1 = this.computeBalancedWait(((float)v1), ((float)v5), v3);
                }
                else {
                    v1 = v3;
                }
            }
            long v6 = this.checkWaitReadTime(channelHandlerContext0, (v1 >= v2 ? v1 : v2), 0xE7230DL);
            if(v6 >= 10L) {
                Channel channel0 = channelHandlerContext0.channel();
                ChannelConfig channelConfig0 = channel0.config();
                InternalLogger internalLogger0 = GlobalChannelTrafficShapingHandler.logger;
                if(internalLogger0.isDebugEnabled()) {
                    internalLogger0.debug("Read Suspend: " + v6 + ':' + channelConfig0.isAutoRead() + ':' + AbstractTrafficShapingHandler.isHandlerActive(channelHandlerContext0));
                }
                if(channelConfig0.isAutoRead() && AbstractTrafficShapingHandler.isHandlerActive(channelHandlerContext0)) {
                    channelConfig0.setAutoRead(false);
                    channel0.attr(AbstractTrafficShapingHandler.READ_SUSPENDED).set(Boolean.TRUE);
                    Attribute attribute0 = channel0.attr(AbstractTrafficShapingHandler.REOPEN_TASK);
                    Runnable runnable0 = (Runnable)attribute0.get();
                    if(runnable0 == null) {
                        runnable0 = new ReopenReadTimerTask(channelHandlerContext0);
                        attribute0.set(runnable0);
                    }
                    channelHandlerContext0.executor().schedule(runnable0, v6, TimeUnit.MILLISECONDS);
                    if(internalLogger0.isDebugEnabled()) {
                        internalLogger0.debug("Suspend final status => " + channelConfig0.isAutoRead() + ':' + AbstractTrafficShapingHandler.isHandlerActive(channelHandlerContext0) + " will reopened at: " + v6);
                    }
                }
            }
        }
        this.informReadOperation(channelHandlerContext0, 0xE7230DL);
        channelHandlerContext0.fireChannelRead(object0);
    }

    public Collection channelTrafficCounters() {
        return new AbstractCollection() {
            @Override
            public Iterator iterator() {
                return new Iterator() {
                    final Iterator iter;

                    {
                        this.iter = GlobalChannelTrafficShapingHandler.this.channelQueues.values().iterator();
                    }

                    @Override
                    public boolean hasNext() {
                        return this.iter.hasNext();
                    }

                    public TrafficCounter next() {
                        Object object0 = this.iter.next();
                        return ((PerChannel)object0).channelTrafficCounter;
                    }

                    @Override
                    public Object next() {
                        return this.next();
                    }

                    @Override
                    public void remove() {
                        throw new UnsupportedOperationException();
                    }
                };
            }

            @Override
            public int size() {
                return GlobalChannelTrafficShapingHandler.this.channelQueues.size();
            }
        };
    }

    @Override  // io.netty.handler.traffic.AbstractTrafficShapingHandler
    public long checkWaitReadTime(ChannelHandlerContext channelHandlerContext0, long v, long v1) {
        Integer integer0 = channelHandlerContext0.channel().hashCode();
        PerChannel globalChannelTrafficShapingHandler$PerChannel0 = (PerChannel)this.channelQueues.get(integer0);
        return globalChannelTrafficShapingHandler$PerChannel0 == null || v <= this.maxTime || v1 + v - globalChannelTrafficShapingHandler$PerChannel0.lastReadTimestamp <= this.maxTime ? v : this.maxTime;
    }

    private long computeBalancedWait(float f, float f1, long v) {
        if(f1 != 0.0f) {
            float f2 = f / f1;
            if(f2 <= this.maxDeviation) {
                return (long)(((float)v) * this.accelerationFactor);
            }
            else if(f2 >= 1.0f - this.maxDeviation) {
                return v >= 10L ? ((long)(((float)v) * this.slowDownFactor)) : ((long)(10.0f * this.slowDownFactor));
            }
        }
        return v;
    }

    private void computeDeviationCumulativeBytes() {
        boolean z;
        Iterator iterator0 = this.channelQueues.values().iterator();
        long v = 0L;
        long v1 = 0x7FFFFFFFFFFFFFFFL;
        long v2 = 0x7FFFFFFFFFFFFFFFL;
        long v3 = 0L;
        while(true) {
            z = false;
            if(!iterator0.hasNext()) {
                break;
            }
            Object object0 = iterator0.next();
            long v4 = ((PerChannel)object0).channelTrafficCounter.cumulativeWrittenBytes();
            if(v < v4) {
                v = v4;
            }
            if(v1 > v4) {
                v1 = v4;
            }
            long v5 = ((PerChannel)object0).channelTrafficCounter.cumulativeReadBytes();
            if(v3 < v5) {
                v3 = v5;
            }
            if(v2 > v5) {
                v2 = v5;
            }
        }
        boolean z1 = this.channelQueues.size() > 1;
        this.readDeviationActive = z1 && v2 < v3 / 2L;
        if(z1 && v1 < v / 2L) {
            z = true;
        }
        this.writeDeviationActive = z;
        this.cumulativeWrittenBytes.set(v);
        this.cumulativeReadBytes.set(v3);
    }

    public void configureChannel(long v, long v1) {
        this.writeChannelLimit = v;
        this.readChannelLimit = v1;
        for(Object object0: this.channelQueues.values()) {
            ((PerChannel)object0).channelTrafficCounter.resetAccounting(0xE723C4L);
        }
    }

    public void createGlobalTrafficCounter(ScheduledExecutorService scheduledExecutorService0) {
        this.setMaxDeviation(0.1f, 0.4f, -0.1f);
        ObjectUtil.checkNotNullWithIAE(scheduledExecutorService0, "executor");
        GlobalChannelTrafficCounter globalChannelTrafficCounter0 = new GlobalChannelTrafficCounter(this, scheduledExecutorService0, "GlobalChannelTC", this.checkInterval);
        this.setTrafficCounter(globalChannelTrafficCounter0);
        globalChannelTrafficCounter0.start();
    }

    @Override  // io.netty.handler.traffic.AbstractTrafficShapingHandler
    public void doAccounting(TrafficCounter trafficCounter0) {
        this.computeDeviationCumulativeBytes();
        super.doAccounting(trafficCounter0);
    }

    public long getMaxGlobalWriteSize() {
        return this.maxGlobalWriteSize;
    }

    private PerChannel getOrSetPerChannel(ChannelHandlerContext channelHandlerContext0) {
        Integer integer0 = channelHandlerContext0.channel().hashCode();
        PerChannel globalChannelTrafficShapingHandler$PerChannel0 = (PerChannel)this.channelQueues.get(integer0);
        if(globalChannelTrafficShapingHandler$PerChannel0 == null) {
            PerChannel globalChannelTrafficShapingHandler$PerChannel1 = new PerChannel();
            globalChannelTrafficShapingHandler$PerChannel1.messagesQueue = new ArrayDeque();
            globalChannelTrafficShapingHandler$PerChannel1.channelTrafficCounter = new TrafficCounter(this, null, "ChannelTC" + channelHandlerContext0.channel().hashCode(), this.checkInterval);
            globalChannelTrafficShapingHandler$PerChannel1.queueSize = 0L;
            globalChannelTrafficShapingHandler$PerChannel1.lastReadTimestamp = 0xE722E7L;
            globalChannelTrafficShapingHandler$PerChannel1.lastWriteTimestamp = 0xE722E7L;
            this.channelQueues.put(integer0, globalChannelTrafficShapingHandler$PerChannel1);
            return globalChannelTrafficShapingHandler$PerChannel1;
        }
        return globalChannelTrafficShapingHandler$PerChannel0;
    }

    public long getReadChannelLimit() {
        return this.readChannelLimit;
    }

    public long getWriteChannelLimit() {
        return this.writeChannelLimit;
    }

    @Override  // io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler
    public void handlerAdded(ChannelHandlerContext channelHandlerContext0) {
        this.getOrSetPerChannel(channelHandlerContext0);
        this.trafficCounter.resetCumulativeTime();
        super.handlerAdded(channelHandlerContext0);
    }

    @Override  // io.netty.handler.traffic.AbstractTrafficShapingHandler
    public void handlerRemoved(ChannelHandlerContext channelHandlerContext0) {
        this.trafficCounter.resetCumulativeTime();
        Channel channel0 = channelHandlerContext0.channel();
        PerChannel globalChannelTrafficShapingHandler$PerChannel0 = (PerChannel)this.channelQueues.remove(channel0.hashCode());
        if(globalChannelTrafficShapingHandler$PerChannel0 != null) {
            synchronized(globalChannelTrafficShapingHandler$PerChannel0) {
                if(channel0.isActive()) {
                    for(Object object0: globalChannelTrafficShapingHandler$PerChannel0.messagesQueue) {
                        long v1 = this.calculateSize(((ToSend)object0).toSend);
                        this.trafficCounter.bytesRealWriteFlowControl(v1);
                        globalChannelTrafficShapingHandler$PerChannel0.channelTrafficCounter.bytesRealWriteFlowControl(v1);
                        globalChannelTrafficShapingHandler$PerChannel0.queueSize -= v1;
                        this.queuesSize.addAndGet(-v1);
                        channelHandlerContext0.write(((ToSend)object0).toSend, ((ToSend)object0).promise);
                    }
                }
                else {
                    this.queuesSize.addAndGet(-globalChannelTrafficShapingHandler$PerChannel0.queueSize);
                    for(Object object1: globalChannelTrafficShapingHandler$PerChannel0.messagesQueue) {
                        Object object2 = ((ToSend)object1).toSend;
                        if(object2 instanceof ByteBuf) {
                            ((ByteBuf)object2).release();
                        }
                    }
                }
                globalChannelTrafficShapingHandler$PerChannel0.messagesQueue.clear();
            }
        }
        this.releaseWriteSuspended(channelHandlerContext0);
        this.releaseReadSuspended(channelHandlerContext0);
        super.handlerRemoved(channelHandlerContext0);
    }

    @Override  // io.netty.handler.traffic.AbstractTrafficShapingHandler
    public void informReadOperation(ChannelHandlerContext channelHandlerContext0, long v) {
        Integer integer0 = channelHandlerContext0.channel().hashCode();
        PerChannel globalChannelTrafficShapingHandler$PerChannel0 = (PerChannel)this.channelQueues.get(integer0);
        if(globalChannelTrafficShapingHandler$PerChannel0 != null) {
            globalChannelTrafficShapingHandler$PerChannel0.lastReadTimestamp = v;
        }
    }

    public float maxDeviation() {
        return this.maxDeviation;
    }

    public long maximumCumulativeReadBytes() {
        return this.cumulativeReadBytes.get();
    }

    public long maximumCumulativeWrittenBytes() {
        return this.cumulativeWrittenBytes.get();
    }

    public long queuesSize() {
        return this.queuesSize.get();
    }

    public final void release() {
        this.trafficCounter.stop();
    }

    // 检测为 Lambda 实现
    private void sendAllValid(ChannelHandlerContext channelHandlerContext0, PerChannel globalChannelTrafficShapingHandler$PerChannel0, long v) [...]

    public void setMaxDeviation(float f, float f1, float f2) {
        if(f > 0.4f) {
            throw new IllegalArgumentException("maxDeviation must be <= 0.4");
        }
        ObjectUtil.checkPositiveOrZero(f1, "slowDownFactor");
        if(f2 > 0.0f) {
            throw new IllegalArgumentException("accelerationFactor must be <= 0");
        }
        this.maxDeviation = f;
        this.accelerationFactor = f2 + 1.0f;
        this.slowDownFactor = f1 + 1.0f;
    }

    public void setMaxGlobalWriteSize(long v) {
        this.maxGlobalWriteSize = ObjectUtil.checkPositive(v, "maxGlobalWriteSize");
    }

    public void setReadChannelLimit(long v) {
        this.readChannelLimit = v;
        for(Object object0: this.channelQueues.values()) {
            ((PerChannel)object0).channelTrafficCounter.resetAccounting(0xE72456L);
        }
    }

    public void setWriteChannelLimit(long v) {
        this.writeChannelLimit = v;
        for(Object object0: this.channelQueues.values()) {
            ((PerChannel)object0).channelTrafficCounter.resetAccounting(0xE72456L);
        }
    }

    public float slowDownFactor() {
        return this.slowDownFactor;
    }

    @Override  // io.netty.handler.traffic.AbstractTrafficShapingHandler
    public void submitWrite(ChannelHandlerContext channelHandlerContext0, Object object0, long v, long v1, long v2, ChannelPromise channelPromise0) {
        ToSend globalChannelTrafficShapingHandler$ToSend0;
        long v4;
        Integer integer0 = channelHandlerContext0.channel().hashCode();
        PerChannel globalChannelTrafficShapingHandler$PerChannel0 = (PerChannel)this.channelQueues.get(integer0);
        if(globalChannelTrafficShapingHandler$PerChannel0 == null) {
            globalChannelTrafficShapingHandler$PerChannel0 = this.getOrSetPerChannel(channelHandlerContext0);
        }
        synchronized(globalChannelTrafficShapingHandler$PerChannel0) {
            if(v1 == 0L && globalChannelTrafficShapingHandler$PerChannel0.messagesQueue.isEmpty()) {
                this.trafficCounter.bytesRealWriteFlowControl(v);
                globalChannelTrafficShapingHandler$PerChannel0.channelTrafficCounter.bytesRealWriteFlowControl(v);
                channelHandlerContext0.write(object0, channelPromise0);
                globalChannelTrafficShapingHandler$PerChannel0.lastWriteTimestamp = v2;
                return;
            }
            v4 = v1 <= this.maxTime || v2 + v1 - globalChannelTrafficShapingHandler$PerChannel0.lastWriteTimestamp <= this.maxTime ? v1 : this.maxTime;
            globalChannelTrafficShapingHandler$ToSend0 = new ToSend(v4 + v2, object0, v, channelPromise0, null);
            globalChannelTrafficShapingHandler$PerChannel0.messagesQueue.addLast(globalChannelTrafficShapingHandler$ToSend0);
            globalChannelTrafficShapingHandler$PerChannel0.queueSize += v;
            this.queuesSize.addAndGet(v);
            this.checkWriteSuspend(channelHandlerContext0, v4, globalChannelTrafficShapingHandler$PerChannel0.queueSize);
            boolean z = Long.compare(this.queuesSize.get(), this.maxGlobalWriteSize) > 0;
        }
        if(z) {
            this.setUserDefinedWritability(channelHandlerContext0, false);
        }
        channelHandlerContext0.executor().schedule(() -> {
            synchronized(this.val$forSchedule) {
                ToSend globalChannelTrafficShapingHandler$ToSend0 = (ToSend)this.val$forSchedule.messagesQueue.pollFirst();
                while(globalChannelTrafficShapingHandler$ToSend0 != null) {
                    if(globalChannelTrafficShapingHandler$ToSend0.relativeTimeAction <= this.val$futureNow) {
                        GlobalChannelTrafficShapingHandler.this.trafficCounter.bytesRealWriteFlowControl(globalChannelTrafficShapingHandler$ToSend0.size);
                        this.val$forSchedule.channelTrafficCounter.bytesRealWriteFlowControl(globalChannelTrafficShapingHandler$ToSend0.size);
                        this.val$forSchedule.queueSize -= globalChannelTrafficShapingHandler$ToSend0.size;
                        GlobalChannelTrafficShapingHandler.this.queuesSize.addAndGet(-globalChannelTrafficShapingHandler$ToSend0.size);
                        this.val$ctx.write(globalChannelTrafficShapingHandler$ToSend0.toSend, globalChannelTrafficShapingHandler$ToSend0.promise);
                        this.val$forSchedule.lastWriteTimestamp = this.val$futureNow;
                        globalChannelTrafficShapingHandler$ToSend0 = (ToSend)this.val$forSchedule.messagesQueue.pollFirst();
                    }
                    else {
                        this.val$forSchedule.messagesQueue.addFirst(globalChannelTrafficShapingHandler$ToSend0);
                        if(true) {
                            break;
                        }
                    }
                }
                if(this.val$forSchedule.messagesQueue.isEmpty()) {
                    GlobalChannelTrafficShapingHandler.this.releaseWriteSuspended(this.val$ctx);
                }
            }
            this.val$ctx.flush();
        }, v4, TimeUnit.MILLISECONDS);

        class io.netty.handler.traffic.GlobalChannelTrafficShapingHandler.2 implements Runnable {
            public io.netty.handler.traffic.GlobalChannelTrafficShapingHandler.2(ChannelHandlerContext channelHandlerContext0, PerChannel globalChannelTrafficShapingHandler$PerChannel0, long v) {
            }

            @Override
            public void run() {
                GlobalChannelTrafficShapingHandler.this.sendAllValid(this.val$ctx, this.val$forSchedule, this.val$futureNow);
            }
        }

    }

    @Override  // io.netty.handler.traffic.AbstractTrafficShapingHandler
    public String toString() {
        return super.toString() + " Write Channel Limit: " + this.writeChannelLimit + " Read Channel Limit: " + this.readChannelLimit;
    }

    @Override  // io.netty.handler.traffic.AbstractTrafficShapingHandler
    public int userDefinedWritabilityIndex() {
        return 3;
    }

    @Override  // io.netty.handler.traffic.AbstractTrafficShapingHandler
    public void write(ChannelHandlerContext channelHandlerContext0, Object object0, ChannelPromise channelPromise0) {
        long v = this.calculateSize(object0);
        long v1 = 0L;
        if(Long.compare(v, 0L) > 0) {
            long v2 = this.trafficCounter.writeTimeToWait(v, this.getWriteLimit(), this.maxTime, 0xE72479L);
            Integer integer0 = channelHandlerContext0.channel().hashCode();
            PerChannel globalChannelTrafficShapingHandler$PerChannel0 = (PerChannel)this.channelQueues.get(integer0);
            if(globalChannelTrafficShapingHandler$PerChannel0 != null) {
                long v3 = globalChannelTrafficShapingHandler$PerChannel0.channelTrafficCounter.writeTimeToWait(v, this.writeChannelLimit, this.maxTime, 0xE72479L);
                if(this.writeDeviationActive) {
                    long v4 = globalChannelTrafficShapingHandler$PerChannel0.channelTrafficCounter.cumulativeWrittenBytes();
                    long v5 = this.cumulativeWrittenBytes.get();
                    if(v4 > 0L) {
                        v1 = v4;
                    }
                    v1 = this.computeBalancedWait(((float)v1), ((float)(v5 >= v1 ? v5 : v1)), v3);
                }
                else {
                    v1 = v3;
                }
            }
            if(v1 >= v2) {
                v2 = v1;
            }
            if(v2 >= 10L) {
                InternalLogger internalLogger0 = GlobalChannelTrafficShapingHandler.logger;
                if(internalLogger0.isDebugEnabled()) {
                    internalLogger0.debug("Write suspend: " + v2 + ':' + channelHandlerContext0.channel().config().isAutoRead() + ':' + AbstractTrafficShapingHandler.isHandlerActive(channelHandlerContext0));
                }
                this.submitWrite(channelHandlerContext0, object0, v, v2, 0xE72479L, channelPromise0);
                return;
            }
        }
        this.submitWrite(channelHandlerContext0, object0, v, 0L, 0xE72479L, channelPromise0);
    }
}

