package io.netty.handler.stream;

import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.ChannelHandlerContext;

public interface ChunkedInput {
    void close();

    boolean isEndOfInput();

    long length();

    long progress();

    Object readChunk(ByteBufAllocator arg1);

    @Deprecated
    Object readChunk(ChannelHandlerContext arg1);
}

