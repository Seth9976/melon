package io.netty.channel.socket.oio;

import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.MessageSizeEstimator;
import io.netty.channel.RecvByteBufAllocator;
import io.netty.channel.WriteBufferWaterMark;
import io.netty.channel.socket.SocketChannelConfig;

@Deprecated
public interface OioSocketChannelConfig extends SocketChannelConfig {
    int getSoTimeout();

    OioSocketChannelConfig setAllocator(ByteBufAllocator arg1);

    OioSocketChannelConfig setAllowHalfClosure(boolean arg1);

    OioSocketChannelConfig setAutoClose(boolean arg1);

    OioSocketChannelConfig setAutoRead(boolean arg1);

    OioSocketChannelConfig setConnectTimeoutMillis(int arg1);

    OioSocketChannelConfig setKeepAlive(boolean arg1);

    @Deprecated
    OioSocketChannelConfig setMaxMessagesPerRead(int arg1);

    OioSocketChannelConfig setMessageSizeEstimator(MessageSizeEstimator arg1);

    OioSocketChannelConfig setPerformancePreferences(int arg1, int arg2, int arg3);

    OioSocketChannelConfig setReceiveBufferSize(int arg1);

    OioSocketChannelConfig setRecvByteBufAllocator(RecvByteBufAllocator arg1);

    OioSocketChannelConfig setReuseAddress(boolean arg1);

    OioSocketChannelConfig setSendBufferSize(int arg1);

    OioSocketChannelConfig setSoLinger(int arg1);

    OioSocketChannelConfig setSoTimeout(int arg1);

    OioSocketChannelConfig setTcpNoDelay(boolean arg1);

    OioSocketChannelConfig setTrafficClass(int arg1);

    OioSocketChannelConfig setWriteBufferHighWaterMark(int arg1);

    OioSocketChannelConfig setWriteBufferLowWaterMark(int arg1);

    OioSocketChannelConfig setWriteBufferWaterMark(WriteBufferWaterMark arg1);

    OioSocketChannelConfig setWriteSpinCount(int arg1);
}

