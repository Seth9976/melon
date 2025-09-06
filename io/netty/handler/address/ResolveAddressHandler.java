package io.netty.handler.address;

import io.netty.channel.ChannelHandler.Sharable;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundHandlerAdapter;
import io.netty.channel.ChannelPromise;
import io.netty.resolver.AddressResolver;
import io.netty.resolver.AddressResolverGroup;
import io.netty.util.concurrent.EventExecutor;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.FutureListener;
import io.netty.util.internal.ObjectUtil;
import java.net.SocketAddress;

@Sharable
public class ResolveAddressHandler extends ChannelOutboundHandlerAdapter {
    private final AddressResolverGroup resolverGroup;

    public ResolveAddressHandler(AddressResolverGroup addressResolverGroup0) {
        this.resolverGroup = (AddressResolverGroup)ObjectUtil.checkNotNull(addressResolverGroup0, "resolverGroup");
    }

    @Override  // io.netty.channel.ChannelOutboundHandlerAdapter
    public void connect(ChannelHandlerContext channelHandlerContext0, SocketAddress socketAddress0, SocketAddress socketAddress1, ChannelPromise channelPromise0) {
        EventExecutor eventExecutor0 = channelHandlerContext0.executor();
        AddressResolver addressResolver0 = this.resolverGroup.getResolver(eventExecutor0);
        if(addressResolver0.isSupported(socketAddress0) && !addressResolver0.isResolved(socketAddress0)) {
            addressResolver0.resolve(socketAddress0).addListener(new FutureListener() {
                @Override  // io.netty.util.concurrent.GenericFutureListener
                public void operationComplete(Future future0) {
                    Throwable throwable0 = future0.cause();
                    if(throwable0 == null) {
                        SocketAddress socketAddress0 = (SocketAddress)future0.getNow();
                        channelHandlerContext0.connect(socketAddress0, socketAddress1, channelPromise0);
                    }
                    else {
                        channelPromise0.setFailure(throwable0);
                    }
                    channelHandlerContext0.pipeline().remove(ResolveAddressHandler.this);
                }
            });
            return;
        }
        channelHandlerContext0.connect(socketAddress0, socketAddress1, channelPromise0);
        channelHandlerContext0.pipeline().remove(this);
    }
}

