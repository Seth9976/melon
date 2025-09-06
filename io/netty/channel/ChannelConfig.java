package io.netty.channel;

import io.netty.buffer.ByteBufAllocator;
import java.util.Map;

public interface ChannelConfig {
    ByteBufAllocator getAllocator();

    int getConnectTimeoutMillis();

    @Deprecated
    int getMaxMessagesPerRead();

    MessageSizeEstimator getMessageSizeEstimator();

    Object getOption(ChannelOption arg1);

    Map getOptions();

    RecvByteBufAllocator getRecvByteBufAllocator();

    int getWriteBufferHighWaterMark();

    int getWriteBufferLowWaterMark();

    WriteBufferWaterMark getWriteBufferWaterMark();

    int getWriteSpinCount();

    boolean isAutoClose();

    boolean isAutoRead();

    ChannelConfig setAllocator(ByteBufAllocator arg1);

    ChannelConfig setAutoClose(boolean arg1);

    ChannelConfig setAutoRead(boolean arg1);

    ChannelConfig setConnectTimeoutMillis(int arg1);

    @Deprecated
    ChannelConfig setMaxMessagesPerRead(int arg1);

    ChannelConfig setMessageSizeEstimator(MessageSizeEstimator arg1);

    boolean setOption(ChannelOption arg1, Object arg2);

    boolean setOptions(Map arg1);

    ChannelConfig setRecvByteBufAllocator(RecvByteBufAllocator arg1);

    ChannelConfig setWriteBufferHighWaterMark(int arg1);

    ChannelConfig setWriteBufferLowWaterMark(int arg1);

    ChannelConfig setWriteBufferWaterMark(WriteBufferWaterMark arg1);

    ChannelConfig setWriteSpinCount(int arg1);
}

