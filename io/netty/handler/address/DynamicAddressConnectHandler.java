package io.netty.handler.address;

import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundHandlerAdapter;
import io.netty.channel.ChannelPromise;
import io.netty.util.concurrent.Future;
import java.net.SocketAddress;

public abstract class DynamicAddressConnectHandler extends ChannelOutboundHandlerAdapter {
    @Override  // io.netty.channel.ChannelOutboundHandlerAdapter
    public final void connect(ChannelHandlerContext channelHandlerContext0, SocketAddress socketAddress0, SocketAddress socketAddress1, ChannelPromise channelPromise0) {
        channelHandlerContext0.connect(socketAddress0, socketAddress1, channelPromise0).addListener(new ChannelFutureListener() {
            public void operationComplete(ChannelFuture channelFuture0) {
                if(channelFuture0.isSuccess()) {
                    channelFuture0.channel().pipeline().remove(DynamicAddressConnectHandler.this);
                }
            }

            @Override  // io.netty.util.concurrent.GenericFutureListener
            public void operationComplete(Future future0) {
                this.operationComplete(((ChannelFuture)future0));
            }
        });
    }

    public SocketAddress localAddress(SocketAddress socketAddress0, SocketAddress socketAddress1) [...] // Inlined contents

    public SocketAddress remoteAddress(SocketAddress socketAddress0, SocketAddress socketAddress1) [...] // Inlined contents
}

