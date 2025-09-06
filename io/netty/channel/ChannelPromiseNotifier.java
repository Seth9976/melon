package io.netty.channel;

import io.netty.util.concurrent.PromiseNotifier;

@Deprecated
public final class ChannelPromiseNotifier extends PromiseNotifier implements ChannelFutureListener {
    public ChannelPromiseNotifier(boolean z, ChannelPromise[] arr_channelPromise) {
        super(z, arr_channelPromise);
    }

    public ChannelPromiseNotifier(ChannelPromise[] arr_channelPromise) {
        super(arr_channelPromise);
    }
}

