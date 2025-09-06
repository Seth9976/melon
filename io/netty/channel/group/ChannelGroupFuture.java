package io.netty.channel.group;

import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import java.util.Iterator;

public interface ChannelGroupFuture extends Future, Iterable {
    ChannelGroupFuture addListener(GenericFutureListener arg1);

    ChannelGroupFuture addListeners(GenericFutureListener[] arg1);

    ChannelGroupFuture await();

    ChannelGroupFuture awaitUninterruptibly();

    ChannelGroupException cause();

    ChannelFuture find(Channel arg1);

    ChannelGroup group();

    boolean isPartialFailure();

    boolean isPartialSuccess();

    @Override  // io.netty.util.concurrent.Future
    boolean isSuccess();

    @Override
    Iterator iterator();

    ChannelGroupFuture removeListener(GenericFutureListener arg1);

    ChannelGroupFuture removeListeners(GenericFutureListener[] arg1);

    ChannelGroupFuture sync();

    ChannelGroupFuture syncUninterruptibly();
}

