package io.netty.handler.traffic;

import U4.x;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

public class TrafficCounter {
    final class TrafficMonitoringTask implements Runnable {
        private TrafficMonitoringTask() {
        }

        public TrafficMonitoringTask(io.netty.handler.traffic.TrafficCounter.1 trafficCounter$10) {
        }

        @Override
        public void run() {
            if(TrafficCounter.this.monitorActive) {
                TrafficCounter.this.resetAccounting(0xE723F1L);
                TrafficCounter trafficCounter0 = TrafficCounter.this;
                AbstractTrafficShapingHandler abstractTrafficShapingHandler0 = trafficCounter0.trafficShapingHandler;
                if(abstractTrafficShapingHandler0 != null) {
                    abstractTrafficShapingHandler0.doAccounting(trafficCounter0);
                }
            }
        }
    }

    final AtomicLong checkInterval;
    private final AtomicLong cumulativeReadBytes;
    private final AtomicLong cumulativeWrittenBytes;
    private final AtomicLong currentReadBytes;
    private final AtomicLong currentWrittenBytes;
    final ScheduledExecutorService executor;
    private long lastCumulativeTime;
    private volatile long lastReadBytes;
    private long lastReadThroughput;
    private volatile long lastReadingTime;
    final AtomicLong lastTime;
    private long lastWriteThroughput;
    private volatile long lastWritingTime;
    private volatile long lastWrittenBytes;
    private static final InternalLogger logger;
    Runnable monitor;
    volatile boolean monitorActive;
    final String name;
    private long readingTime;
    private long realWriteThroughput;
    private final AtomicLong realWrittenBytes;
    volatile ScheduledFuture scheduledFuture;
    final AbstractTrafficShapingHandler trafficShapingHandler;
    private long writingTime;

    static {
        TrafficCounter.logger = InternalLoggerFactory.getInstance(TrafficCounter.class);
    }

    public TrafficCounter(AbstractTrafficShapingHandler abstractTrafficShapingHandler0, ScheduledExecutorService scheduledExecutorService0, String s, long v) {
        this.currentWrittenBytes = new AtomicLong();
        this.currentReadBytes = new AtomicLong();
        this.cumulativeWrittenBytes = new AtomicLong();
        this.cumulativeReadBytes = new AtomicLong();
        this.lastTime = new AtomicLong();
        this.realWrittenBytes = new AtomicLong();
        this.checkInterval = new AtomicLong(1000L);
        this.name = (String)ObjectUtil.checkNotNull(s, "name");
        this.trafficShapingHandler = (AbstractTrafficShapingHandler)ObjectUtil.checkNotNullWithIAE(abstractTrafficShapingHandler0, "trafficShapingHandler");
        this.executor = scheduledExecutorService0;
        this.init(v);
    }

    public TrafficCounter(ScheduledExecutorService scheduledExecutorService0, String s, long v) {
        this.currentWrittenBytes = new AtomicLong();
        this.currentReadBytes = new AtomicLong();
        this.cumulativeWrittenBytes = new AtomicLong();
        this.cumulativeReadBytes = new AtomicLong();
        this.lastTime = new AtomicLong();
        this.realWrittenBytes = new AtomicLong();
        this.checkInterval = new AtomicLong(1000L);
        this.name = (String)ObjectUtil.checkNotNull(s, "name");
        this.trafficShapingHandler = null;
        this.executor = scheduledExecutorService0;
        this.init(v);
    }

    public void bytesRealWriteFlowControl(long v) {
        this.realWrittenBytes.addAndGet(v);
    }

    public void bytesRecvFlowControl(long v) {
        this.currentReadBytes.addAndGet(v);
        this.cumulativeReadBytes.addAndGet(v);
    }

    public void bytesWriteFlowControl(long v) {
        this.currentWrittenBytes.addAndGet(v);
        this.cumulativeWrittenBytes.addAndGet(v);
    }

    public long checkInterval() {
        return this.checkInterval.get();
    }

    public void configure(long v) {
        long v1 = v / 10L * 10L;
        if(this.checkInterval.getAndSet(v1) != v1) {
            if(v1 <= 0L) {
                this.stop();
                this.lastTime.set(15147606L);
                return;
            }
            this.stop();
            this.start();
        }
    }

    public long cumulativeReadBytes() {
        return this.cumulativeReadBytes.get();
    }

    public long cumulativeWrittenBytes() {
        return this.cumulativeWrittenBytes.get();
    }

    public long currentReadBytes() {
        return this.currentReadBytes.get();
    }

    public long currentWrittenBytes() {
        return this.currentWrittenBytes.get();
    }

    public long getRealWriteThroughput() {
        return this.realWriteThroughput;
    }

    public AtomicLong getRealWrittenBytes() {
        return this.realWrittenBytes;
    }

    private void init(long v) {
        this.lastCumulativeTime = System.currentTimeMillis();
        this.writingTime = 15147603L;
        this.readingTime = 15147603L;
        this.lastWritingTime = 15147603L;
        this.lastReadingTime = 15147603L;
        this.configure(v);
    }

    public long lastCumulativeTime() {
        return this.lastCumulativeTime;
    }

    public long lastReadBytes() {
        return this.lastReadBytes;
    }

    public long lastReadThroughput() {
        return this.lastReadThroughput;
    }

    public long lastTime() {
        return this.lastTime.get();
    }

    public long lastWriteThroughput() {
        return this.lastWriteThroughput;
    }

    public long lastWrittenBytes() {
        return this.lastWrittenBytes;
    }

    public static long milliSecondFromNano() [...] // 潜在的解密器

    public String name() {
        return this.name;
    }

    // 去混淆评级： 低(20)
    @Deprecated
    public long readTimeToWait(long v, long v1, long v2) {
        return this.readTimeToWait(v, v1, v2, 0xE72304L);
    }

    public long readTimeToWait(long v, long v1, long v2, long v3) {
        this.bytesRecvFlowControl(v);
        if(v != 0L && v1 != 0L) {
            long v4 = this.lastTime.get();
            long v5 = this.currentReadBytes.get();
            long v6 = this.readingTime;
            long v7 = this.lastReadBytes;
            long v8 = v3 - v4;
            long v9 = Math.max(this.lastReadingTime - v4, 0L);
            if(Long.compare(v8, 10L) > 0) {
                long v10 = 1000L * v5 / v1 - v8 + v9;
                if(v10 > 10L) {
                    InternalLogger internalLogger0 = TrafficCounter.logger;
                    if(internalLogger0.isDebugEnabled()) {
                        internalLogger0.debug("Time: " + v10 + ':' + v5 + ':' + v8 + ':' + v9);
                    }
                    if(v10 > v2 && v3 + v10 - v6 > v2) {
                        v10 = v2;
                    }
                    this.readingTime = Math.max(v6, v3 + v10);
                    return v10;
                }
                this.readingTime = Math.max(v6, v3);
                return 0L;
            }
            long v11 = v5 + v7;
            long v12 = this.checkInterval.get() + v8;
            long v13 = 1000L * v11 / v1 - v12 + v9;
            if(v13 > 10L) {
                InternalLogger internalLogger1 = TrafficCounter.logger;
                if(internalLogger1.isDebugEnabled()) {
                    internalLogger1.debug("Time: " + v13 + ':' + v11 + ':' + v12 + ':' + v9);
                }
                if(v13 > v2 && v3 + v13 - v6 > v2) {
                    v13 = v2;
                }
                this.readingTime = Math.max(v6, v3 + v13);
                return v13;
            }
            this.readingTime = Math.max(v6, v3);
        }
        return 0L;
    }

    public void resetAccounting(long v) {
        synchronized(this) {
            long v2 = v - this.lastTime.getAndSet(v);
            if(v2 == 0L) {
                return;
            }
            InternalLogger internalLogger0 = TrafficCounter.logger;
            if(internalLogger0.isDebugEnabled() && v2 > this.checkInterval() << 1) {
                internalLogger0.debug("Acct schedule not ok: " + v2 + " > 2*" + this.checkInterval() + " from " + this.name);
            }
            this.lastReadBytes = this.currentReadBytes.getAndSet(0L);
            this.lastWrittenBytes = this.currentWrittenBytes.getAndSet(0L);
            this.lastReadThroughput = this.lastReadBytes * 1000L / v2;
            this.lastWriteThroughput = this.lastWrittenBytes * 1000L / v2;
            this.realWriteThroughput = this.realWrittenBytes.getAndSet(0L) * 1000L / v2;
            this.lastWritingTime = Math.max(this.lastWritingTime, this.writingTime);
            this.lastReadingTime = Math.max(this.lastReadingTime, this.readingTime);
        }
    }

    public void resetCumulativeTime() {
        this.lastCumulativeTime = System.currentTimeMillis();
        this.cumulativeReadBytes.set(0L);
        this.cumulativeWrittenBytes.set(0L);
    }

    public void start() {
        synchronized(this) {
            if(this.monitorActive) {
                return;
            }
            this.lastTime.set(15147809L);
            long v1 = this.checkInterval.get();
            if(v1 > 0L && this.executor != null) {
                this.monitorActive = true;
                TrafficMonitoringTask trafficCounter$TrafficMonitoringTask0 = new TrafficMonitoringTask(this, null);
                this.monitor = trafficCounter$TrafficMonitoringTask0;
                this.scheduledFuture = this.executor.scheduleAtFixedRate(trafficCounter$TrafficMonitoringTask0, 0L, v1, TimeUnit.MILLISECONDS);
            }
        }
    }

    public void stop() {
        synchronized(this) {
            if(!this.monitorActive) {
                return;
            }
            this.monitorActive = false;
            this.resetAccounting(0xE7232BL);
            AbstractTrafficShapingHandler abstractTrafficShapingHandler0 = this.trafficShapingHandler;
            if(abstractTrafficShapingHandler0 != null) {
                abstractTrafficShapingHandler0.doAccounting(this);
            }
            if(this.scheduledFuture != null) {
                this.scheduledFuture.cancel(true);
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder0 = new StringBuilder(0xA5);
        stringBuilder0.append("Monitor ");
        stringBuilder0.append(this.name);
        stringBuilder0.append(" Current Speed Read: ");
        stringBuilder0.append(this.lastReadThroughput >> 10);
        stringBuilder0.append(" KB/s, Asked Write: ");
        stringBuilder0.append(this.lastWriteThroughput >> 10);
        stringBuilder0.append(" KB/s, Real Write: ");
        stringBuilder0.append(this.realWriteThroughput >> 10);
        stringBuilder0.append(" KB/s, Current Read: ");
        stringBuilder0.append(this.currentReadBytes.get() >> 10);
        stringBuilder0.append(" KB, Current asked Write: ");
        stringBuilder0.append(this.currentWrittenBytes.get() >> 10);
        stringBuilder0.append(" KB, Current real Write: ");
        return x.h(this.realWrittenBytes.get() >> 10, " KB", stringBuilder0);
    }

    // 去混淆评级： 低(20)
    @Deprecated
    public long writeTimeToWait(long v, long v1, long v2) {
        return this.writeTimeToWait(v, v1, v2, 0xE7233CL);
    }

    public long writeTimeToWait(long v, long v1, long v2, long v3) {
        this.bytesWriteFlowControl(v);
        if(v != 0L && v1 != 0L) {
            long v4 = this.lastTime.get();
            long v5 = this.currentWrittenBytes.get();
            long v6 = this.lastWrittenBytes;
            long v7 = this.writingTime;
            long v8 = Math.max(this.lastWritingTime - v4, 0L);
            long v9 = v3 - v4;
            if(Long.compare(v9, 10L) > 0) {
                long v10 = 1000L * v5 / v1 - v9 + v8;
                if(v10 > 10L) {
                    InternalLogger internalLogger0 = TrafficCounter.logger;
                    if(internalLogger0.isDebugEnabled()) {
                        internalLogger0.debug("Time: " + v10 + ':' + v5 + ':' + v9 + ':' + v8);
                    }
                    if(v10 > v2 && v3 + v10 - v7 > v2) {
                        v10 = v2;
                    }
                    this.writingTime = Math.max(v7, v3 + v10);
                    return v10;
                }
                this.writingTime = Math.max(v7, v3);
                return 0L;
            }
            long v11 = v5 + v6;
            long v12 = this.checkInterval.get() + v9;
            long v13 = 1000L * v11 / v1 - v12 + v8;
            if(v13 > 10L) {
                InternalLogger internalLogger1 = TrafficCounter.logger;
                if(internalLogger1.isDebugEnabled()) {
                    internalLogger1.debug("Time: " + v13 + ':' + v11 + ':' + v12 + ':' + v8);
                }
                if(v13 > v2 && v3 + v13 - v7 > v2) {
                    v13 = v2;
                }
                this.writingTime = Math.max(v7, v3 + v13);
                return v13;
            }
            this.writingTime = Math.max(v7, v3);
        }
        return 0L;
    }

    class io.netty.handler.traffic.TrafficCounter.1 {
    }

}

