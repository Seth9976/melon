package io.netty.channel.pool;

import io.netty.channel.Channel;
import io.netty.channel.EventLoop;
import io.netty.util.concurrent.Future;

public interface ChannelHealthChecker {
    public static final ChannelHealthChecker ACTIVE;

    static {
        ChannelHealthChecker.ACTIVE = new ChannelHealthChecker() {
            @Override  // io.netty.channel.pool.ChannelHealthChecker
            public Future isHealthy(Channel channel0) {
                EventLoop eventLoop0 = channel0.eventLoop();
                return channel0.isActive() ? eventLoop0.newSucceededFuture(Boolean.TRUE) : eventLoop0.newSucceededFuture(Boolean.FALSE);
            }
        };
    }

    Future isHealthy(Channel arg1);
}

