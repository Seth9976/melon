package io.netty.channel;

import io.netty.util.concurrent.PromiseAggregator;

@Deprecated
public final class ChannelPromiseAggregator extends PromiseAggregator implements ChannelFutureListener {
    public ChannelPromiseAggregator(ChannelPromise channelPromise0) {
        super(channelPromise0);
    }
}

