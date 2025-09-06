package io.netty.channel.pool;

import io.netty.channel.Channel;

public abstract class AbstractChannelPoolHandler implements ChannelPoolHandler {
    @Override  // io.netty.channel.pool.ChannelPoolHandler
    public void channelAcquired(Channel channel0) {
    }

    @Override  // io.netty.channel.pool.ChannelPoolHandler
    public void channelReleased(Channel channel0) {
    }
}

