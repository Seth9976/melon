package io.netty.channel.socket;

import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.ChannelConfig;
import io.netty.channel.MessageSizeEstimator;
import io.netty.channel.RecvByteBufAllocator;
import io.netty.channel.WriteBufferWaterMark;
import java.net.InetAddress;
import java.net.NetworkInterface;

public interface DatagramChannelConfig extends ChannelConfig {
    InetAddress getInterface();

    NetworkInterface getNetworkInterface();

    int getReceiveBufferSize();

    int getSendBufferSize();

    int getTimeToLive();

    int getTrafficClass();

    boolean isBroadcast();

    boolean isLoopbackModeDisabled();

    boolean isReuseAddress();

    DatagramChannelConfig setAllocator(ByteBufAllocator arg1);

    DatagramChannelConfig setAutoClose(boolean arg1);

    DatagramChannelConfig setAutoRead(boolean arg1);

    DatagramChannelConfig setBroadcast(boolean arg1);

    DatagramChannelConfig setConnectTimeoutMillis(int arg1);

    DatagramChannelConfig setInterface(InetAddress arg1);

    DatagramChannelConfig setLoopbackModeDisabled(boolean arg1);

    @Deprecated
    DatagramChannelConfig setMaxMessagesPerRead(int arg1);

    DatagramChannelConfig setMessageSizeEstimator(MessageSizeEstimator arg1);

    DatagramChannelConfig setNetworkInterface(NetworkInterface arg1);

    DatagramChannelConfig setReceiveBufferSize(int arg1);

    DatagramChannelConfig setRecvByteBufAllocator(RecvByteBufAllocator arg1);

    DatagramChannelConfig setReuseAddress(boolean arg1);

    DatagramChannelConfig setSendBufferSize(int arg1);

    DatagramChannelConfig setTimeToLive(int arg1);

    DatagramChannelConfig setTrafficClass(int arg1);

    DatagramChannelConfig setWriteBufferWaterMark(WriteBufferWaterMark arg1);

    DatagramChannelConfig setWriteSpinCount(int arg1);
}

