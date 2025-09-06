package io.netty.channel;

public interface ChannelInboundHandler extends ChannelHandler {
    void channelActive(ChannelHandlerContext arg1);

    void channelInactive(ChannelHandlerContext arg1);

    void channelRead(ChannelHandlerContext arg1, Object arg2);

    void channelReadComplete(ChannelHandlerContext arg1);

    void channelRegistered(ChannelHandlerContext arg1);

    void channelUnregistered(ChannelHandlerContext arg1);

    void channelWritabilityChanged(ChannelHandlerContext arg1);

    @Override  // io.netty.channel.ChannelHandler
    void exceptionCaught(ChannelHandlerContext arg1, Throwable arg2);

    void userEventTriggered(ChannelHandlerContext arg1, Object arg2);
}

