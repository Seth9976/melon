package io.netty.channel;

import java.net.SocketAddress;

public class ChannelDuplexHandler extends ChannelInboundHandlerAdapter implements ChannelOutboundHandler {
    @Override  // io.netty.channel.ChannelOutboundHandler
    @Skip
    public void bind(ChannelHandlerContext channelHandlerContext0, SocketAddress socketAddress0, ChannelPromise channelPromise0) {
        channelHandlerContext0.bind(socketAddress0, channelPromise0);
    }

    @Override  // io.netty.channel.ChannelOutboundHandler
    @Skip
    public void close(ChannelHandlerContext channelHandlerContext0, ChannelPromise channelPromise0) {
        channelHandlerContext0.close(channelPromise0);
    }

    @Override  // io.netty.channel.ChannelOutboundHandler
    @Skip
    public void connect(ChannelHandlerContext channelHandlerContext0, SocketAddress socketAddress0, SocketAddress socketAddress1, ChannelPromise channelPromise0) {
        channelHandlerContext0.connect(socketAddress0, socketAddress1, channelPromise0);
    }

    @Override  // io.netty.channel.ChannelOutboundHandler
    @Skip
    public void deregister(ChannelHandlerContext channelHandlerContext0, ChannelPromise channelPromise0) {
        channelHandlerContext0.deregister(channelPromise0);
    }

    @Override  // io.netty.channel.ChannelOutboundHandler
    @Skip
    public void disconnect(ChannelHandlerContext channelHandlerContext0, ChannelPromise channelPromise0) {
        channelHandlerContext0.disconnect(channelPromise0);
    }

    @Override  // io.netty.channel.ChannelOutboundHandler
    @Skip
    public void flush(ChannelHandlerContext channelHandlerContext0) {
        channelHandlerContext0.flush();
    }

    @Override  // io.netty.channel.ChannelOutboundHandler
    @Skip
    public void read(ChannelHandlerContext channelHandlerContext0) {
        channelHandlerContext0.read();
    }

    @Override  // io.netty.channel.ChannelOutboundHandler
    @Skip
    public void write(ChannelHandlerContext channelHandlerContext0, Object object0, ChannelPromise channelPromise0) {
        channelHandlerContext0.write(object0, channelPromise0);
    }
}

