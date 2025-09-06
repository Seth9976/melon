package io.netty.channel.group;

import io.netty.channel.Channel;
import io.netty.channel.ChannelId;
import java.util.Set;

public interface ChannelGroup extends Comparable, Set {
    ChannelGroupFuture close();

    ChannelGroupFuture close(ChannelMatcher arg1);

    @Deprecated
    ChannelGroupFuture deregister();

    @Deprecated
    ChannelGroupFuture deregister(ChannelMatcher arg1);

    ChannelGroupFuture disconnect();

    ChannelGroupFuture disconnect(ChannelMatcher arg1);

    Channel find(ChannelId arg1);

    ChannelGroup flush();

    ChannelGroup flush(ChannelMatcher arg1);

    @Deprecated
    ChannelGroupFuture flushAndWrite(Object arg1);

    @Deprecated
    ChannelGroupFuture flushAndWrite(Object arg1, ChannelMatcher arg2);

    String name();

    ChannelGroupFuture newCloseFuture();

    ChannelGroupFuture newCloseFuture(ChannelMatcher arg1);

    ChannelGroupFuture write(Object arg1);

    ChannelGroupFuture write(Object arg1, ChannelMatcher arg2);

    ChannelGroupFuture write(Object arg1, ChannelMatcher arg2, boolean arg3);

    ChannelGroupFuture writeAndFlush(Object arg1);

    ChannelGroupFuture writeAndFlush(Object arg1, ChannelMatcher arg2);

    ChannelGroupFuture writeAndFlush(Object arg1, ChannelMatcher arg2, boolean arg3);
}

