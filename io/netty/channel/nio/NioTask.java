package io.netty.channel.nio;

import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;

public interface NioTask {
    void channelReady(SelectableChannel arg1, SelectionKey arg2);

    void channelUnregistered(SelectableChannel arg1, Throwable arg2);
}

