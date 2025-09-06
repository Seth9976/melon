package io.netty.channel;

import io.netty.util.concurrent.GenericFutureListener;
import io.netty.util.concurrent.ProgressivePromise;

public interface ChannelProgressivePromise extends ChannelProgressiveFuture, ChannelPromise, ProgressivePromise {
    ChannelProgressivePromise addListener(GenericFutureListener arg1);

    ChannelProgressivePromise addListeners(GenericFutureListener[] arg1);

    ChannelProgressivePromise await();

    ChannelProgressivePromise awaitUninterruptibly();

    ChannelProgressivePromise removeListener(GenericFutureListener arg1);

    ChannelProgressivePromise removeListeners(GenericFutureListener[] arg1);

    ChannelProgressivePromise setFailure(Throwable arg1);

    ChannelProgressivePromise setProgress(long arg1, long arg2);

    ChannelProgressivePromise setSuccess();

    ChannelProgressivePromise setSuccess(Void arg1);

    ChannelProgressivePromise sync();

    ChannelProgressivePromise syncUninterruptibly();

    ChannelProgressivePromise unvoid();
}

