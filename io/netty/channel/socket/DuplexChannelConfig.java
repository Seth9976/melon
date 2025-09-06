package io.netty.channel.socket;

import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.ChannelConfig;
import io.netty.channel.MessageSizeEstimator;
import io.netty.channel.RecvByteBufAllocator;
import io.netty.channel.WriteBufferWaterMark;

public interface DuplexChannelConfig extends ChannelConfig {
    boolean isAllowHalfClosure();

    DuplexChannelConfig setAllocator(ByteBufAllocator arg1);

    DuplexChannelConfig setAllowHalfClosure(boolean arg1);

    DuplexChannelConfig setAutoClose(boolean arg1);

    DuplexChannelConfig setAutoRead(boolean arg1);

    @Deprecated
    DuplexChannelConfig setMaxMessagesPerRead(int arg1);

    DuplexChannelConfig setMessageSizeEstimator(MessageSizeEstimator arg1);

    DuplexChannelConfig setRecvByteBufAllocator(RecvByteBufAllocator arg1);

    DuplexChannelConfig setWriteBufferWaterMark(WriteBufferWaterMark arg1);

    DuplexChannelConfig setWriteSpinCount(int arg1);
}

