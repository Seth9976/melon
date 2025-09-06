package io.netty.channel;

import io.netty.buffer.ByteBufAllocator;
import io.netty.util.AttributeMap;
import java.net.SocketAddress;

public interface Channel extends ChannelOutboundInvoker, AttributeMap, Comparable {
    public interface Unsafe {
        void beginRead();

        void bind(SocketAddress arg1, ChannelPromise arg2);

        void close(ChannelPromise arg1);

        void closeForcibly();

        void connect(SocketAddress arg1, SocketAddress arg2, ChannelPromise arg3);

        void deregister(ChannelPromise arg1);

        void disconnect(ChannelPromise arg1);

        void flush();

        SocketAddress localAddress();

        ChannelOutboundBuffer outboundBuffer();

        Handle recvBufAllocHandle();

        void register(EventLoop arg1, ChannelPromise arg2);

        SocketAddress remoteAddress();

        ChannelPromise voidPromise();

        void write(Object arg1, ChannelPromise arg2);
    }

    ByteBufAllocator alloc();

    long bytesBeforeUnwritable();

    long bytesBeforeWritable();

    ChannelFuture closeFuture();

    ChannelConfig config();

    EventLoop eventLoop();

    Channel flush();

    ChannelId id();

    boolean isActive();

    boolean isOpen();

    boolean isRegistered();

    boolean isWritable();

    SocketAddress localAddress();

    ChannelMetadata metadata();

    Channel parent();

    ChannelPipeline pipeline();

    Channel read();

    SocketAddress remoteAddress();

    Unsafe unsafe();
}

