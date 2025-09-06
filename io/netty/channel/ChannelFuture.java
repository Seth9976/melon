package io.netty.channel;

import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;

public interface ChannelFuture extends Future {
    ChannelFuture addListener(GenericFutureListener arg1);

    ChannelFuture addListeners(GenericFutureListener[] arg1);

    ChannelFuture await();

    ChannelFuture awaitUninterruptibly();

    Channel channel();

    boolean isVoid();

    ChannelFuture removeListener(GenericFutureListener arg1);

    ChannelFuture removeListeners(GenericFutureListener[] arg1);

    ChannelFuture sync();

    ChannelFuture syncUninterruptibly();
}

