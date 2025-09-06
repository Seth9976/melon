package io.netty.channel;

import io.netty.util.concurrent.EventExecutorGroup;
import java.util.List;
import java.util.Map;

public interface ChannelPipeline extends ChannelInboundInvoker, ChannelOutboundInvoker, Iterable {
    ChannelPipeline addAfter(EventExecutorGroup arg1, String arg2, String arg3, ChannelHandler arg4);

    ChannelPipeline addAfter(String arg1, String arg2, ChannelHandler arg3);

    ChannelPipeline addBefore(EventExecutorGroup arg1, String arg2, String arg3, ChannelHandler arg4);

    ChannelPipeline addBefore(String arg1, String arg2, ChannelHandler arg3);

    ChannelPipeline addFirst(EventExecutorGroup arg1, String arg2, ChannelHandler arg3);

    ChannelPipeline addFirst(EventExecutorGroup arg1, ChannelHandler[] arg2);

    ChannelPipeline addFirst(String arg1, ChannelHandler arg2);

    ChannelPipeline addFirst(ChannelHandler[] arg1);

    ChannelPipeline addLast(EventExecutorGroup arg1, String arg2, ChannelHandler arg3);

    ChannelPipeline addLast(EventExecutorGroup arg1, ChannelHandler[] arg2);

    ChannelPipeline addLast(String arg1, ChannelHandler arg2);

    ChannelPipeline addLast(ChannelHandler[] arg1);

    Channel channel();

    ChannelHandlerContext context(ChannelHandler arg1);

    ChannelHandlerContext context(Class arg1);

    ChannelHandlerContext context(String arg1);

    ChannelPipeline fireChannelActive();

    ChannelPipeline fireChannelInactive();

    ChannelPipeline fireChannelRead(Object arg1);

    ChannelPipeline fireChannelReadComplete();

    ChannelPipeline fireChannelRegistered();

    ChannelPipeline fireChannelUnregistered();

    ChannelPipeline fireChannelWritabilityChanged();

    ChannelPipeline fireExceptionCaught(Throwable arg1);

    ChannelPipeline fireUserEventTriggered(Object arg1);

    ChannelHandler first();

    ChannelHandlerContext firstContext();

    ChannelPipeline flush();

    ChannelHandler get(Class arg1);

    ChannelHandler get(String arg1);

    ChannelHandler last();

    ChannelHandlerContext lastContext();

    List names();

    ChannelHandler remove(Class arg1);

    ChannelHandler remove(String arg1);

    ChannelPipeline remove(ChannelHandler arg1);

    ChannelHandler removeFirst();

    ChannelHandler removeLast();

    ChannelHandler replace(Class arg1, String arg2, ChannelHandler arg3);

    ChannelHandler replace(String arg1, String arg2, ChannelHandler arg3);

    ChannelPipeline replace(ChannelHandler arg1, String arg2, ChannelHandler arg3);

    Map toMap();
}

