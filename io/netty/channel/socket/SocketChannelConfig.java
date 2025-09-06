package io.netty.channel.socket;

import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.MessageSizeEstimator;
import io.netty.channel.RecvByteBufAllocator;
import io.netty.channel.WriteBufferWaterMark;

public interface SocketChannelConfig extends DuplexChannelConfig {
    int getReceiveBufferSize();

    int getSendBufferSize();

    int getSoLinger();

    int getTrafficClass();

    boolean isKeepAlive();

    boolean isReuseAddress();

    boolean isTcpNoDelay();

    SocketChannelConfig setAllocator(ByteBufAllocator arg1);

    SocketChannelConfig setAllowHalfClosure(boolean arg1);

    SocketChannelConfig setAutoClose(boolean arg1);

    SocketChannelConfig setAutoRead(boolean arg1);

    SocketChannelConfig setConnectTimeoutMillis(int arg1);

    SocketChannelConfig setKeepAlive(boolean arg1);

    @Deprecated
    SocketChannelConfig setMaxMessagesPerRead(int arg1);

    SocketChannelConfig setMessageSizeEstimator(MessageSizeEstimator arg1);

    SocketChannelConfig setPerformancePreferences(int arg1, int arg2, int arg3);

    SocketChannelConfig setReceiveBufferSize(int arg1);

    SocketChannelConfig setRecvByteBufAllocator(RecvByteBufAllocator arg1);

    SocketChannelConfig setReuseAddress(boolean arg1);

    SocketChannelConfig setSendBufferSize(int arg1);

    SocketChannelConfig setSoLinger(int arg1);

    SocketChannelConfig setTcpNoDelay(boolean arg1);

    SocketChannelConfig setTrafficClass(int arg1);

    SocketChannelConfig setWriteBufferWaterMark(WriteBufferWaterMark arg1);

    SocketChannelConfig setWriteSpinCount(int arg1);
}

