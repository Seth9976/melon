package io.netty.channel;

public class ChannelInboundHandlerAdapter extends ChannelHandlerAdapter implements ChannelInboundHandler {
    @Override  // io.netty.channel.ChannelInboundHandler
    @Skip
    public void channelActive(ChannelHandlerContext channelHandlerContext0) {
        channelHandlerContext0.fireChannelActive();
    }

    @Override  // io.netty.channel.ChannelInboundHandler
    @Skip
    public void channelInactive(ChannelHandlerContext channelHandlerContext0) {
        channelHandlerContext0.fireChannelInactive();
    }

    @Override  // io.netty.channel.ChannelInboundHandler
    @Skip
    public void channelRead(ChannelHandlerContext channelHandlerContext0, Object object0) {
        channelHandlerContext0.fireChannelRead(object0);
    }

    @Override  // io.netty.channel.ChannelInboundHandler
    @Skip
    public void channelReadComplete(ChannelHandlerContext channelHandlerContext0) {
        channelHandlerContext0.fireChannelReadComplete();
    }

    @Override  // io.netty.channel.ChannelInboundHandler
    @Skip
    public void channelRegistered(ChannelHandlerContext channelHandlerContext0) {
        channelHandlerContext0.fireChannelRegistered();
    }

    @Override  // io.netty.channel.ChannelInboundHandler
    @Skip
    public void channelUnregistered(ChannelHandlerContext channelHandlerContext0) {
        channelHandlerContext0.fireChannelUnregistered();
    }

    @Override  // io.netty.channel.ChannelInboundHandler
    @Skip
    public void channelWritabilityChanged(ChannelHandlerContext channelHandlerContext0) {
        channelHandlerContext0.fireChannelWritabilityChanged();
    }

    @Override  // io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelInboundHandler
    @Skip
    public void exceptionCaught(ChannelHandlerContext channelHandlerContext0, Throwable throwable0) {
        channelHandlerContext0.fireExceptionCaught(throwable0);
    }

    @Override  // io.netty.channel.ChannelInboundHandler
    @Skip
    public void userEventTriggered(ChannelHandlerContext channelHandlerContext0, Object object0) {
        channelHandlerContext0.fireUserEventTriggered(object0);
    }
}

