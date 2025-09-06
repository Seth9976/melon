package io.netty.handler.traffic;

import io.netty.util.internal.ObjectUtil;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class GlobalChannelTrafficCounter extends TrafficCounter {
    static class MixedTrafficMonitoringTask implements Runnable {
        private final TrafficCounter counter;
        private final GlobalChannelTrafficShapingHandler trafficShapingHandler1;

        public MixedTrafficMonitoringTask(GlobalChannelTrafficShapingHandler globalChannelTrafficShapingHandler0, TrafficCounter trafficCounter0) {
            this.trafficShapingHandler1 = globalChannelTrafficShapingHandler0;
            this.counter = trafficCounter0;
        }

        @Override
        public void run() {
            if(!this.counter.monitorActive) {
                return;
            }
            this.counter.resetAccounting(0xE722A3L);
            for(Object object0: this.trafficShapingHandler1.channelQueues.values()) {
                ((PerChannel)object0).channelTrafficCounter.resetAccounting(0xE722A3L);
            }
            this.trafficShapingHandler1.doAccounting(this.counter);
        }
    }

    public GlobalChannelTrafficCounter(GlobalChannelTrafficShapingHandler globalChannelTrafficShapingHandler0, ScheduledExecutorService scheduledExecutorService0, String s, long v) {
        super(globalChannelTrafficShapingHandler0, scheduledExecutorService0, s, v);
        ObjectUtil.checkNotNullWithIAE(scheduledExecutorService0, "executor");
    }

    @Override  // io.netty.handler.traffic.TrafficCounter
    public void resetCumulativeTime() {
        for(Object object0: ((GlobalChannelTrafficShapingHandler)this.trafficShapingHandler).channelQueues.values()) {
            ((PerChannel)object0).channelTrafficCounter.resetCumulativeTime();
        }
        super.resetCumulativeTime();
    }

    @Override  // io.netty.handler.traffic.TrafficCounter
    public void start() {
        synchronized(this) {
            if(this.monitorActive) {
                return;
            }
            this.lastTime.set(15147660L);
            long v1 = this.checkInterval.get();
            if(v1 > 0L) {
                this.monitorActive = true;
                MixedTrafficMonitoringTask globalChannelTrafficCounter$MixedTrafficMonitoringTask0 = new MixedTrafficMonitoringTask(((GlobalChannelTrafficShapingHandler)this.trafficShapingHandler), this);
                this.monitor = globalChannelTrafficCounter$MixedTrafficMonitoringTask0;
                this.scheduledFuture = this.executor.scheduleAtFixedRate(globalChannelTrafficCounter$MixedTrafficMonitoringTask0, 0L, v1, TimeUnit.MILLISECONDS);
            }
        }
    }

    @Override  // io.netty.handler.traffic.TrafficCounter
    public void stop() {
        synchronized(this) {
            if(!this.monitorActive) {
                return;
            }
            this.monitorActive = false;
            this.resetAccounting(0xE722A2L);
            this.trafficShapingHandler.doAccounting(this);
            if(this.scheduledFuture != null) {
                this.scheduledFuture.cancel(true);
            }
        }
    }
}

