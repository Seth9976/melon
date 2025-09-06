package io.netty.handler.ipfilter;

import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import java.net.SocketAddress;

public abstract class AbstractRemoteAddressFilter extends ChannelInboundHandlerAdapter {
    public abstract boolean accept(ChannelHandlerContext arg1, SocketAddress arg2);

    public void channelAccepted(ChannelHandlerContext channelHandlerContext0, SocketAddress socketAddress0) {
    }

    @Override  // io.netty.channel.ChannelInboundHandlerAdapter
    public void channelActive(ChannelHandlerContext channelHandlerContext0) {
        if(!this.handleNewChannel(channelHandlerContext0)) {
            throw new IllegalStateException("cannot determine to accept or reject a channel: " + channelHandlerContext0.channel());
        }
        channelHandlerContext0.fireChannelActive();
    }

    @Override  // io.netty.channel.ChannelInboundHandlerAdapter
    public void channelRegistered(ChannelHandlerContext channelHandlerContext0) {
        this.handleNewChannel(channelHandlerContext0);
        channelHandlerContext0.fireChannelRegistered();
    }

    public ChannelFuture channelRejected(ChannelHandlerContext channelHandlerContext0, SocketAddress socketAddress0) [...] // Inlined contents

    private boolean handleNewChannel(ChannelHandlerContext channelHandlerContext0) {
        SocketAddress socketAddress0 = channelHandlerContext0.channel().remoteAddress();
        if(socketAddress0 == null) {
            return false;
        }
        channelHandlerContext0.pipeline().remove(this);
        if(!this.accept(channelHandlerContext0, socketAddress0)) {
            channelHandlerContext0.close();
        }
        return true;
    }
}

