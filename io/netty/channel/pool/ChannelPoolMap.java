package io.netty.channel.pool;

public interface ChannelPoolMap {
    boolean contains(Object arg1);

    ChannelPool get(Object arg1);
}

