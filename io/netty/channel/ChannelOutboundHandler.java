package io.netty.channel;

import java.net.SocketAddress;

public interface ChannelOutboundHandler extends ChannelHandler {
    void bind(ChannelHandlerContext arg1, SocketAddress arg2, ChannelPromise arg3);

    void close(ChannelHandlerContext arg1, ChannelPromise arg2);

    void connect(ChannelHandlerContext arg1, SocketAddress arg2, SocketAddress arg3, ChannelPromise arg4);

    void deregister(ChannelHandlerContext arg1, ChannelPromise arg2);

    void disconnect(ChannelHandlerContext arg1, ChannelPromise arg2);

    void flush(ChannelHandlerContext arg1);

    void read(ChannelHandlerContext arg1);

    void write(ChannelHandlerContext arg1, Object arg2, ChannelPromise arg3);
}

