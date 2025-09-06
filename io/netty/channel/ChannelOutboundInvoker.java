package io.netty.channel;

import java.net.SocketAddress;

public interface ChannelOutboundInvoker {
    ChannelFuture bind(SocketAddress arg1);

    ChannelFuture bind(SocketAddress arg1, ChannelPromise arg2);

    ChannelFuture close();

    ChannelFuture close(ChannelPromise arg1);

    ChannelFuture connect(SocketAddress arg1);

    ChannelFuture connect(SocketAddress arg1, ChannelPromise arg2);

    ChannelFuture connect(SocketAddress arg1, SocketAddress arg2);

    ChannelFuture connect(SocketAddress arg1, SocketAddress arg2, ChannelPromise arg3);

    ChannelFuture deregister();

    ChannelFuture deregister(ChannelPromise arg1);

    ChannelFuture disconnect();

    ChannelFuture disconnect(ChannelPromise arg1);

    ChannelOutboundInvoker flush();

    ChannelFuture newFailedFuture(Throwable arg1);

    ChannelProgressivePromise newProgressivePromise();

    ChannelPromise newPromise();

    ChannelFuture newSucceededFuture();

    ChannelOutboundInvoker read();

    ChannelPromise voidPromise();

    ChannelFuture write(Object arg1);

    ChannelFuture write(Object arg1, ChannelPromise arg2);

    ChannelFuture writeAndFlush(Object arg1);

    ChannelFuture writeAndFlush(Object arg1, ChannelPromise arg2);
}

