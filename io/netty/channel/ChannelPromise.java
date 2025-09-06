package io.netty.channel;

import io.netty.util.concurrent.GenericFutureListener;
import io.netty.util.concurrent.Promise;

public interface ChannelPromise extends ChannelFuture, Promise {
    ChannelPromise addListener(GenericFutureListener arg1);

    ChannelPromise addListeners(GenericFutureListener[] arg1);

    ChannelPromise await();

    ChannelPromise awaitUninterruptibly();

    @Override  // io.netty.channel.ChannelFuture
    Channel channel();

    ChannelPromise removeListener(GenericFutureListener arg1);

    ChannelPromise removeListeners(GenericFutureListener[] arg1);

    ChannelPromise setFailure(Throwable arg1);

    ChannelPromise setSuccess();

    ChannelPromise setSuccess(Void arg1);

    ChannelPromise sync();

    ChannelPromise syncUninterruptibly();

    boolean trySuccess();

    ChannelPromise unvoid();
}

