package io.netty.channel.socket;

import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.ChannelConfig;
import io.netty.channel.MessageSizeEstimator;
import io.netty.channel.RecvByteBufAllocator;
import io.netty.channel.WriteBufferWaterMark;

public interface ServerSocketChannelConfig extends ChannelConfig {
    int getBacklog();

    int getReceiveBufferSize();

    boolean isReuseAddress();

    ServerSocketChannelConfig setAllocator(ByteBufAllocator arg1);

    ServerSocketChannelConfig setAutoRead(boolean arg1);

    ServerSocketChannelConfig setBacklog(int arg1);

    ServerSocketChannelConfig setConnectTimeoutMillis(int arg1);

    @Deprecated
    ServerSocketChannelConfig setMaxMessagesPerRead(int arg1);

    ServerSocketChannelConfig setMessageSizeEstimator(MessageSizeEstimator arg1);

    ServerSocketChannelConfig setPerformancePreferences(int arg1, int arg2, int arg3);

    ServerSocketChannelConfig setReceiveBufferSize(int arg1);

    ServerSocketChannelConfig setRecvByteBufAllocator(RecvByteBufAllocator arg1);

    ServerSocketChannelConfig setReuseAddress(boolean arg1);

    ServerSocketChannelConfig setWriteBufferHighWaterMark(int arg1);

    ServerSocketChannelConfig setWriteBufferLowWaterMark(int arg1);

    ServerSocketChannelConfig setWriteBufferWaterMark(WriteBufferWaterMark arg1);

    ServerSocketChannelConfig setWriteSpinCount(int arg1);
}

