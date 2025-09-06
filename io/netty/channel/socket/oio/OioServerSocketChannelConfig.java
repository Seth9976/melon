package io.netty.channel.socket.oio;

import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.MessageSizeEstimator;
import io.netty.channel.RecvByteBufAllocator;
import io.netty.channel.WriteBufferWaterMark;
import io.netty.channel.socket.ServerSocketChannelConfig;

@Deprecated
public interface OioServerSocketChannelConfig extends ServerSocketChannelConfig {
    int getSoTimeout();

    OioServerSocketChannelConfig setAllocator(ByteBufAllocator arg1);

    OioServerSocketChannelConfig setAutoClose(boolean arg1);

    OioServerSocketChannelConfig setAutoRead(boolean arg1);

    OioServerSocketChannelConfig setBacklog(int arg1);

    OioServerSocketChannelConfig setConnectTimeoutMillis(int arg1);

    @Deprecated
    OioServerSocketChannelConfig setMaxMessagesPerRead(int arg1);

    OioServerSocketChannelConfig setMessageSizeEstimator(MessageSizeEstimator arg1);

    OioServerSocketChannelConfig setPerformancePreferences(int arg1, int arg2, int arg3);

    OioServerSocketChannelConfig setReceiveBufferSize(int arg1);

    OioServerSocketChannelConfig setRecvByteBufAllocator(RecvByteBufAllocator arg1);

    OioServerSocketChannelConfig setReuseAddress(boolean arg1);

    OioServerSocketChannelConfig setSoTimeout(int arg1);

    OioServerSocketChannelConfig setWriteBufferHighWaterMark(int arg1);

    OioServerSocketChannelConfig setWriteBufferLowWaterMark(int arg1);

    OioServerSocketChannelConfig setWriteBufferWaterMark(WriteBufferWaterMark arg1);

    OioServerSocketChannelConfig setWriteSpinCount(int arg1);
}

