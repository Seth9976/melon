package io.netty.channel;

import io.netty.util.concurrent.EventExecutor;

final class DefaultChannelHandlerContext extends AbstractChannelHandlerContext {
    private final ChannelHandler handler;

    public DefaultChannelHandlerContext(DefaultChannelPipeline defaultChannelPipeline0, EventExecutor eventExecutor0, String s, ChannelHandler channelHandler0) {
        super(defaultChannelPipeline0, eventExecutor0, s, channelHandler0.getClass());
        this.handler = channelHandler0;
    }

    @Override  // io.netty.channel.ChannelHandlerContext
    public ChannelHandler handler() {
        return this.handler;
    }
}

