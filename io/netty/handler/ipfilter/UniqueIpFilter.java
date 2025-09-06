package io.netty.handler.ipfilter;

import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandler.Sharable;
import io.netty.channel.ChannelHandlerContext;
import io.netty.util.concurrent.Future;
import io.netty.util.internal.ConcurrentSet;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.util.Set;

@Sharable
public class UniqueIpFilter extends AbstractRemoteAddressFilter {
    private final Set connected;

    public UniqueIpFilter() {
        this.connected = new ConcurrentSet();
    }

    public boolean accept(ChannelHandlerContext channelHandlerContext0, InetSocketAddress inetSocketAddress0) {
        InetAddress inetAddress0 = inetSocketAddress0.getAddress();
        if(!this.connected.add(inetAddress0)) {
            return false;
        }
        channelHandlerContext0.channel().closeFuture().addListener(new ChannelFutureListener() {
            public void operationComplete(ChannelFuture channelFuture0) {
                UniqueIpFilter.this.connected.remove(inetAddress0);
            }

            @Override  // io.netty.util.concurrent.GenericFutureListener
            public void operationComplete(Future future0) {
                this.operationComplete(((ChannelFuture)future0));
            }
        });
        return true;
    }

    @Override  // io.netty.handler.ipfilter.AbstractRemoteAddressFilter
    public boolean accept(ChannelHandlerContext channelHandlerContext0, SocketAddress socketAddress0) {
        return this.accept(channelHandlerContext0, ((InetSocketAddress)socketAddress0));
    }
}

