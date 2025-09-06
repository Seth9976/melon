package io.netty.channel;

import io.netty.buffer.ByteBufAllocator;
import io.netty.util.Attribute;
import io.netty.util.AttributeKey;
import io.netty.util.AttributeMap;
import io.netty.util.concurrent.EventExecutor;

public interface ChannelHandlerContext extends ChannelInboundInvoker, ChannelOutboundInvoker, AttributeMap {
    ByteBufAllocator alloc();

    @Override  // io.netty.util.AttributeMap
    @Deprecated
    Attribute attr(AttributeKey arg1);

    Channel channel();

    EventExecutor executor();

    ChannelHandlerContext fireChannelActive();

    ChannelHandlerContext fireChannelInactive();

    ChannelHandlerContext fireChannelRead(Object arg1);

    ChannelHandlerContext fireChannelReadComplete();

    ChannelHandlerContext fireChannelRegistered();

    ChannelHandlerContext fireChannelUnregistered();

    ChannelHandlerContext fireChannelWritabilityChanged();

    ChannelHandlerContext fireExceptionCaught(Throwable arg1);

    ChannelHandlerContext fireUserEventTriggered(Object arg1);

    ChannelHandlerContext flush();

    ChannelHandler handler();

    @Override  // io.netty.util.AttributeMap
    @Deprecated
    boolean hasAttr(AttributeKey arg1);

    boolean isRemoved();

    String name();

    ChannelPipeline pipeline();

    ChannelHandlerContext read();
}

