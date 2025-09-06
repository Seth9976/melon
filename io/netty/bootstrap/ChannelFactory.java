package io.netty.bootstrap;

import io.netty.channel.Channel;

@Deprecated
public interface ChannelFactory {
    Channel newChannel();
}

