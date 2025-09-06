package io.netty.channel.pool;

import io.netty.channel.Channel;

public interface ChannelPoolHandler {
    void channelAcquired(Channel arg1);

    void channelCreated(Channel arg1);

    void channelReleased(Channel arg1);
}

