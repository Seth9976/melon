package io.netty.channel.socket.oio;

import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.MessageSizeEstimator;
import io.netty.channel.RecvByteBufAllocator;
import io.netty.channel.WriteBufferWaterMark;
import io.netty.channel.socket.DatagramChannelConfig;
import java.net.InetAddress;
import java.net.NetworkInterface;

@Deprecated
public interface OioDatagramChannelConfig extends DatagramChannelConfig {
    int getSoTimeout();

    OioDatagramChannelConfig setAllocator(ByteBufAllocator arg1);

    OioDatagramChannelConfig setAutoClose(boolean arg1);

    OioDatagramChannelConfig setAutoRead(boolean arg1);

    OioDatagramChannelConfig setBroadcast(boolean arg1);

    OioDatagramChannelConfig setConnectTimeoutMillis(int arg1);

    OioDatagramChannelConfig setInterface(InetAddress arg1);

    OioDatagramChannelConfig setLoopbackModeDisabled(boolean arg1);

    OioDatagramChannelConfig setMaxMessagesPerRead(int arg1);

    OioDatagramChannelConfig setMessageSizeEstimator(MessageSizeEstimator arg1);

    OioDatagramChannelConfig setNetworkInterface(NetworkInterface arg1);

    OioDatagramChannelConfig setReceiveBufferSize(int arg1);

    OioDatagramChannelConfig setRecvByteBufAllocator(RecvByteBufAllocator arg1);

    OioDatagramChannelConfig setReuseAddress(boolean arg1);

    OioDatagramChannelConfig setSendBufferSize(int arg1);

    OioDatagramChannelConfig setSoTimeout(int arg1);

    OioDatagramChannelConfig setTimeToLive(int arg1);

    OioDatagramChannelConfig setTrafficClass(int arg1);

    OioDatagramChannelConfig setWriteBufferHighWaterMark(int arg1);

    OioDatagramChannelConfig setWriteBufferLowWaterMark(int arg1);

    OioDatagramChannelConfig setWriteBufferWaterMark(WriteBufferWaterMark arg1);

    OioDatagramChannelConfig setWriteSpinCount(int arg1);
}

