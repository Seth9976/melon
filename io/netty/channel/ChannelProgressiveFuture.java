package io.netty.channel;

import io.netty.util.concurrent.GenericFutureListener;
import io.netty.util.concurrent.ProgressiveFuture;

public interface ChannelProgressiveFuture extends ChannelFuture, ProgressiveFuture {
    ChannelProgressiveFuture addListener(GenericFutureListener arg1);

    ChannelProgressiveFuture addListeners(GenericFutureListener[] arg1);

    ChannelProgressiveFuture await();

    ChannelProgressiveFuture awaitUninterruptibly();

    ChannelProgressiveFuture removeListener(GenericFutureListener arg1);

    ChannelProgressiveFuture removeListeners(GenericFutureListener[] arg1);

    ChannelProgressiveFuture sync();

    ChannelProgressiveFuture syncUninterruptibly();
}

