package io.netty.handler.traffic;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufHolder;
import io.netty.channel.Channel;
import io.netty.channel.ChannelConfig;
import io.netty.channel.ChannelDuplexHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundBuffer;
import io.netty.channel.ChannelPromise;
import io.netty.channel.FileRegion;
import io.netty.util.Attribute;
import io.netty.util.AttributeKey;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.util.concurrent.TimeUnit;

public abstract class AbstractTrafficShapingHandler extends ChannelDuplexHandler {
    static final class ReopenReadTimerTask implements Runnable {
        final ChannelHandlerContext ctx;

        public ReopenReadTimerTask(ChannelHandlerContext channelHandlerContext0) {
            this.ctx = channelHandlerContext0;
        }

        @Override
        public void run() {
            Channel channel0 = this.ctx.channel();
            ChannelConfig channelConfig0 = channel0.config();
            if(channelConfig0.isAutoRead() || !AbstractTrafficShapingHandler.isHandlerActive(this.ctx)) {
                if(AbstractTrafficShapingHandler.logger.isDebugEnabled()) {
                    if(!channelConfig0.isAutoRead() || AbstractTrafficShapingHandler.isHandlerActive(this.ctx)) {
                        if(AbstractTrafficShapingHandler.logger.isDebugEnabled()) {
                            AbstractTrafficShapingHandler.logger.debug("Normal unsuspend: " + channelConfig0.isAutoRead() + ':' + AbstractTrafficShapingHandler.isHandlerActive(this.ctx));
                        }
                    }
                    else if(AbstractTrafficShapingHandler.logger.isDebugEnabled()) {
                        AbstractTrafficShapingHandler.logger.debug("Unsuspend: " + channelConfig0.isAutoRead() + ':' + AbstractTrafficShapingHandler.isHandlerActive(this.ctx));
                    }
                }
                channel0.attr(AbstractTrafficShapingHandler.READ_SUSPENDED).set(Boolean.FALSE);
                channelConfig0.setAutoRead(true);
                channel0.read();
            }
            else {
                if(AbstractTrafficShapingHandler.logger.isDebugEnabled()) {
                    AbstractTrafficShapingHandler.logger.debug("Not unsuspend: " + channelConfig0.isAutoRead() + ':' + AbstractTrafficShapingHandler.isHandlerActive(this.ctx));
                }
                channel0.attr(AbstractTrafficShapingHandler.READ_SUSPENDED).set(Boolean.FALSE);
            }
            if(AbstractTrafficShapingHandler.logger.isDebugEnabled()) {
                AbstractTrafficShapingHandler.logger.debug("Unsuspend final status => " + channelConfig0.isAutoRead() + ':' + AbstractTrafficShapingHandler.isHandlerActive(this.ctx));
            }
        }
    }

    static final int CHANNEL_DEFAULT_USER_DEFINED_WRITABILITY_INDEX = 1;
    public static final long DEFAULT_CHECK_INTERVAL = 1000L;
    static final long DEFAULT_MAX_SIZE = 0x400000L;
    public static final long DEFAULT_MAX_TIME = 15000L;
    static final int GLOBALCHANNEL_DEFAULT_USER_DEFINED_WRITABILITY_INDEX = 3;
    static final int GLOBAL_DEFAULT_USER_DEFINED_WRITABILITY_INDEX = 2;
    static final long MINIMAL_WAIT = 10L;
    static final AttributeKey READ_SUSPENDED;
    static final AttributeKey REOPEN_TASK;
    protected volatile long checkInterval;
    private static final InternalLogger logger;
    protected volatile long maxTime;
    volatile long maxWriteDelay;
    volatile long maxWriteSize;
    private volatile long readLimit;
    protected TrafficCounter trafficCounter;
    final int userDefinedWritabilityIndex;
    private volatile long writeLimit;

    // 去混淆评级： 低(20)
    static {
        AbstractTrafficShapingHandler.logger = InternalLoggerFactory.getInstance(AbstractTrafficShapingHandler.class);
        AbstractTrafficShapingHandler.READ_SUSPENDED = AttributeKey.valueOf("io.netty.handler.traffic.AbstractTrafficShapingHandler.READ_SUSPENDED");
        AbstractTrafficShapingHandler.REOPEN_TASK = AttributeKey.valueOf("io.netty.handler.traffic.AbstractTrafficShapingHandler.REOPEN_TASK");
    }

    public AbstractTrafficShapingHandler() {
        this(0L, 0L, 1000L, 15000L);
    }

    public AbstractTrafficShapingHandler(long v) {
        this(0L, 0L, v, 15000L);
    }

    public AbstractTrafficShapingHandler(long v, long v1) {
        this(v, v1, 1000L, 15000L);
    }

    public AbstractTrafficShapingHandler(long v, long v1, long v2) {
        this(v, v1, v2, 15000L);
    }

    public AbstractTrafficShapingHandler(long v, long v1, long v2, long v3) {
        this.checkInterval = 1000L;
        this.maxWriteDelay = 4000L;
        this.maxWriteSize = 0x400000L;
        this.maxTime = ObjectUtil.checkPositive(v3, "maxTime");
        this.userDefinedWritabilityIndex = this.userDefinedWritabilityIndex();
        this.writeLimit = v;
        this.readLimit = v1;
        this.checkInterval = v2;
    }

    public long calculateSize(Object object0) {
        if(object0 instanceof ByteBuf) {
            return (long)((ByteBuf)object0).readableBytes();
        }
        if(object0 instanceof ByteBufHolder) {
            return (long)((ByteBufHolder)object0).content().readableBytes();
        }
        return object0 instanceof FileRegion ? ((FileRegion)object0).count() : -1L;
    }

    @Override  // io.netty.channel.ChannelInboundHandlerAdapter
    public void channelRead(ChannelHandlerContext channelHandlerContext0, Object object0) {
        long v = this.calculateSize(object0);
        if(v > 0L) {
            long v1 = this.checkWaitReadTime(channelHandlerContext0, this.trafficCounter.readTimeToWait(v, this.readLimit, this.maxTime, 0xE721C1L), 0xE721C1L);
            if(v1 >= 10L) {
                Channel channel0 = channelHandlerContext0.channel();
                ChannelConfig channelConfig0 = channel0.config();
                InternalLogger internalLogger0 = AbstractTrafficShapingHandler.logger;
                if(internalLogger0.isDebugEnabled()) {
                    internalLogger0.debug("Read suspend: " + v1 + ':' + channelConfig0.isAutoRead() + ':' + AbstractTrafficShapingHandler.isHandlerActive(channelHandlerContext0));
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
                    channelHandlerContext0.executor().schedule(runnable0, v1, TimeUnit.MILLISECONDS);
                    if(internalLogger0.isDebugEnabled()) {
                        internalLogger0.debug("Suspend final status => " + channelConfig0.isAutoRead() + ':' + AbstractTrafficShapingHandler.isHandlerActive(channelHandlerContext0) + " will reopened at: " + v1);
                    }
                }
            }
        }
        this.informReadOperation(channelHandlerContext0, 0xE721C1L);
        channelHandlerContext0.fireChannelRead(object0);
    }

    @Override  // io.netty.channel.ChannelInboundHandlerAdapter
    public void channelRegistered(ChannelHandlerContext channelHandlerContext0) {
        this.setUserDefinedWritability(channelHandlerContext0, true);
        super.channelRegistered(channelHandlerContext0);
    }

    public long checkWaitReadTime(ChannelHandlerContext channelHandlerContext0, long v, long v1) {
        return v;
    }

    public void checkWriteSuspend(ChannelHandlerContext channelHandlerContext0, long v, long v1) {
        if(v1 <= this.maxWriteSize && v <= this.maxWriteDelay) {
            return;
        }
        this.setUserDefinedWritability(channelHandlerContext0, false);
    }

    public void configure(long v) {
        this.checkInterval = v;
        TrafficCounter trafficCounter0 = this.trafficCounter;
        if(trafficCounter0 != null) {
            trafficCounter0.configure(this.checkInterval);
        }
    }

    public void configure(long v, long v1) {
        this.writeLimit = v;
        this.readLimit = v1;
        TrafficCounter trafficCounter0 = this.trafficCounter;
        if(trafficCounter0 != null) {
            trafficCounter0.resetAccounting(0xE721E1L);
        }
    }

    public void configure(long v, long v1, long v2) {
        this.configure(v, v1);
        this.configure(v2);
    }

    public void doAccounting(TrafficCounter trafficCounter0) {
    }

    public long getCheckInterval() {
        return this.checkInterval;
    }

    public long getMaxTimeWait() {
        return this.maxTime;
    }

    public long getMaxWriteDelay() {
        return this.maxWriteDelay;
    }

    public long getMaxWriteSize() {
        return this.maxWriteSize;
    }

    public long getReadLimit() {
        return this.readLimit;
    }

    public long getWriteLimit() {
        return this.writeLimit;
    }

    @Override  // io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler
    public void handlerRemoved(ChannelHandlerContext channelHandlerContext0) {
        Channel channel0 = channelHandlerContext0.channel();
        AttributeKey attributeKey0 = AbstractTrafficShapingHandler.REOPEN_TASK;
        if(channel0.hasAttr(attributeKey0)) {
            channel0.attr(attributeKey0).set(null);
        }
        super.handlerRemoved(channelHandlerContext0);
    }

    public void informReadOperation(ChannelHandlerContext channelHandlerContext0, long v) {
    }

    public static boolean isHandlerActive(ChannelHandlerContext channelHandlerContext0) {
        Boolean boolean0 = (Boolean)channelHandlerContext0.channel().attr(AbstractTrafficShapingHandler.READ_SUSPENDED).get();
        return boolean0 == null || Boolean.FALSE.equals(boolean0);
    }

    @Override  // io.netty.channel.ChannelDuplexHandler
    public void read(ChannelHandlerContext channelHandlerContext0) {
        if(AbstractTrafficShapingHandler.isHandlerActive(channelHandlerContext0)) {
            channelHandlerContext0.read();
        }
    }

    public void releaseReadSuspended(ChannelHandlerContext channelHandlerContext0) {
        Channel channel0 = channelHandlerContext0.channel();
        channel0.attr(AbstractTrafficShapingHandler.READ_SUSPENDED).set(Boolean.FALSE);
        channel0.config().setAutoRead(true);
    }

    public void releaseWriteSuspended(ChannelHandlerContext channelHandlerContext0) {
        this.setUserDefinedWritability(channelHandlerContext0, true);
    }

    public void setCheckInterval(long v) {
        this.checkInterval = v;
        TrafficCounter trafficCounter0 = this.trafficCounter;
        if(trafficCounter0 != null) {
            trafficCounter0.configure(v);
        }
    }

    public void setMaxTimeWait(long v) {
        this.maxTime = ObjectUtil.checkPositive(v, "maxTime");
    }

    public void setMaxWriteDelay(long v) {
        this.maxWriteDelay = ObjectUtil.checkPositive(v, "maxWriteDelay");
    }

    public void setMaxWriteSize(long v) {
        this.maxWriteSize = v;
    }

    public void setReadLimit(long v) {
        this.readLimit = v;
        TrafficCounter trafficCounter0 = this.trafficCounter;
        if(trafficCounter0 != null) {
            trafficCounter0.resetAccounting(0xE7233DL);
        }
    }

    public void setTrafficCounter(TrafficCounter trafficCounter0) {
        this.trafficCounter = trafficCounter0;
    }

    public void setUserDefinedWritability(ChannelHandlerContext channelHandlerContext0, boolean z) {
        ChannelOutboundBuffer channelOutboundBuffer0 = channelHandlerContext0.channel().unsafe().outboundBuffer();
        if(channelOutboundBuffer0 != null) {
            channelOutboundBuffer0.setUserDefinedWritability(this.userDefinedWritabilityIndex, z);
        }
    }

    public void setWriteLimit(long v) {
        this.writeLimit = v;
        TrafficCounter trafficCounter0 = this.trafficCounter;
        if(trafficCounter0 != null) {
            trafficCounter0.resetAccounting(0xE7233FL);
        }
    }

    public abstract void submitWrite(ChannelHandlerContext arg1, Object arg2, long arg3, long arg4, long arg5, ChannelPromise arg6);

    @Deprecated
    public void submitWrite(ChannelHandlerContext channelHandlerContext0, Object object0, long v, ChannelPromise channelPromise0) {
        this.submitWrite(channelHandlerContext0, object0, this.calculateSize(object0), v, 0xE7235BL, channelPromise0);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder0 = new StringBuilder(290);
        stringBuilder0.append("TrafficShaping with Write Limit: ");
        stringBuilder0.append(this.writeLimit);
        stringBuilder0.append(" Read Limit: ");
        stringBuilder0.append(this.readLimit);
        stringBuilder0.append(" CheckInterval: ");
        stringBuilder0.append(this.checkInterval);
        stringBuilder0.append(" maxDelay: ");
        stringBuilder0.append(this.maxWriteDelay);
        stringBuilder0.append(" maxSize: ");
        stringBuilder0.append(this.maxWriteSize);
        stringBuilder0.append(" and Counter: ");
        TrafficCounter trafficCounter0 = this.trafficCounter;
        if(trafficCounter0 != null) {
            stringBuilder0.append(trafficCounter0);
            return stringBuilder0.toString();
        }
        stringBuilder0.append("none");
        return stringBuilder0.toString();
    }

    public TrafficCounter trafficCounter() {
        return this.trafficCounter;
    }

    public int userDefinedWritabilityIndex() {
        return 1;
    }

    @Override  // io.netty.channel.ChannelDuplexHandler
    public void write(ChannelHandlerContext channelHandlerContext0, Object object0, ChannelPromise channelPromise0) {
        long v = this.calculateSize(object0);
        if(v > 0L) {
            long v1 = this.trafficCounter.writeTimeToWait(v, this.writeLimit, this.maxTime, 0xE7236AL);
            if(v1 >= 10L) {
                InternalLogger internalLogger0 = AbstractTrafficShapingHandler.logger;
                if(internalLogger0.isDebugEnabled()) {
                    internalLogger0.debug("Write suspend: " + v1 + ':' + channelHandlerContext0.channel().config().isAutoRead() + ':' + AbstractTrafficShapingHandler.isHandlerActive(channelHandlerContext0));
                }
                this.submitWrite(channelHandlerContext0, object0, v, v1, 0xE7236AL, channelPromise0);
                return;
            }
        }
        this.submitWrite(channelHandlerContext0, object0, v, 0L, 0xE7236AL, channelPromise0);
    }
}

